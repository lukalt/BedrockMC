import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.BindedKey;
import org.bedrockmc.api.Client;
import org.bedrockmc.api.MinecraftVersion;
import org.bedrockmc.api.ModManager;
import org.bedrockmc.api.Texture;
import org.bedrockmc.api.chat.ChatMessage;
import org.bedrockmc.api.entity.Player;
import org.bedrockmc.api.event.EventManager;
import org.bedrockmc.api.gui.GuiListener;
import org.bedrockmc.api.gui.GuiScreenType;
import org.bedrockmc.api.gui.ModGuiScreen;
import org.bedrockmc.api.mod.Mod;
import org.bedrockmc.api.mod.ModIcon;
import org.bedrockmc.api.mod.java.JavaModManager;
import org.bedrockmc.api.overlay.RenderManager;
import org.bedrockmc.api.world.World;
import org.bedrockmc.v1_8_8R1.util.Exceptions;

public class BedrockClient implements Client {

	private EventManager eventManager;
	private ModManager modManager;
	public File modFile;
	private RenderManager rederManager;
	private Map<Mod, Set<BindedKey>> keys = new HashMap<Mod, Set<BindedKey>>();
	private ave mc;
	private Class<?> minecraftClass;
	private Map<wn, BedrockPlayer> playerHandles = new ConcurrentHashMap<>();
	
	public BedrockClient(ave mc) {
		BedrockMC.setClient(this);
		System.out.println("Starting BedrockMC...");
		this.mc = mc;
		this.modManager = new JavaModManager();
		this.eventManager = new EventManager();
		Injector.inject(mc);
		this.rederManager = new IngameRenderManager(Injector.INGAME_GUI);
		System.out.println("Loading mods...");
		this.modFile = new File("bedrock-mods");
		if (!this.modFile.exists()) {
			this.modFile.mkdir();
		}
		loadMods();
		this.minecraftClass = ave.class;
	}
	
	public BedrockPlayer getBedrockPlayerForHandle(wn entityPlayer) {
		BedrockPlayer bedrockPlayer = this.playerHandles.get(entityPlayer);
		if(bedrockPlayer == null) {
			this.playerHandles.put(entityPlayer, bedrockPlayer = new BedrockPlayer(entityPlayer));
		}
		return bedrockPlayer;
	}

	public ave getMinecraft() {
		return this.mc;
	}
	
	public void loadMods() {
		FileFilter filter = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".jar");
			}
		};

		for (File file : this.modFile.listFiles(filter)) {
			this.modManager.loadMod(file);
		}
		for (Mod mod : this.modManager.getLoadedMods()) {
			modManager.enableMod(mod);
		}
	}
	
	@Override
	public void addChatMessage(String message) {

	}

	@Override
	public void sendChatMessage(String message) {

	}

	@Override
	public Player getPlayer() {
		wn ep = ave.A().h;
		if(ep == null) {
			return null;
		}
		return this.getBedrockPlayerForHandle(ep);
	}

	@Override
	public boolean isIngame() {
		wn ep = ave.A().h;
		return ep != null;
	}

	@Override
	public void connectToServer(String address) {
		this.mc.a(new awz(this.mc.m,this.mc,new bde("Minecraft Server", address, true)));
	}
	
	public void connectToServer(String host, int port) {
		this.mc.a(new awz(this.mc.m,this.mc,host,port));
	}

	@Override
	public ModManager getModManager() {
		return this.modManager;
	}

	@Override
	public EventManager getEventManager() {
		return this.eventManager;
	}

	@Override
	public void shutdown() {
		ave.A().m();
	}

	@Override
	public String getServerName() {
		try {
			return (String) getInternalMinecraftField("aq");
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getServerPort() {
		try {
			return ((Integer) getInternalMinecraftField("ar")).intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public World getWorld() {
		Exceptions.unimplemented();
		return null;
	}

	@Override
	public void openGuiScreen(ModGuiScreen gui) {
		gui.openGui();
	}

	@Override
	public ModGuiScreen createGuiScreen(GuiListener listener, GuiScreenType type) {
		SimpleModGuiScreen simpleModGuiScreen = new SimpleModGuiScreen();
		simpleModGuiScreen.setGuiListener(listener);
		return simpleModGuiScreen;
		
	}

	@Override
	public ModGuiScreen createGuiScreen(GuiListener listener) {
		SimpleModGuiScreen simpleModGuiScreen = new SimpleModGuiScreen();
		simpleModGuiScreen.setGuiListener(listener);
		return simpleModGuiScreen;
	}

	@Override
	public long getSystemTime() {
		return ave.J();
	}

	@Override
	public boolean isUnicode() {
		return ave.A().d();
	}

	@Override
	public RenderManager getRenderManager() {
		return this.rederManager;
	}

	@Override
	public ModIcon createModIcon(BufferedImage image) {
		Exceptions.unimplemented();
		return null;
	}

	@Override
	public int getMinecraftVersionCode() {
		return 47;
	}

	@Override
	public String getMinecraftVersion() {
		return "1.8.8";
	}

	@Override
	public MinecraftVersion getCurrentVersion() {
		return MinecraftVersion.MINECRAFT_1_8_8;
	}

	@Override
	public int getBedrockVersionCode() {
		return 1;
	}

	@Override
	public String getBedrockVersion() {
		return "1.0.1";
	}

	@Override
	public Texture bindTexture(BufferedImage image) {
		Exceptions.unimplemented();
		return null;
	}

	@Override
	public Texture bindTexture(Mod mod, String name) {
		Exceptions.unimplemented();
		return null;
	}

	@Override
	public void sendChatMessage(ChatMessage message) {
		Exceptions.unimplemented();
	}

	@Override
	public void registerKeyBinding(Mod mod, BindedKey key) {
		Set<BindedKey> set = this.keys.get(mod);
		if(set == null) {
			this.keys.put(mod, set = new HashSet<>());
		}
		set.add(key);
	}

	public Map<Mod, Set<BindedKey>> getKeyBindings() {
		return this.keys;
	}

	private Object getInternalMinecraftField(String field) throws Exception {
		Field f = this.minecraftClass.getField(field);
		if(!f.isAccessible()) {
			f.setAccessible(true);
		}
		return f.get(this.mc);
	}
}
