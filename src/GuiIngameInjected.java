
import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.BindedKey;
import org.bedrockmc.api.mod.Mod;
import org.lwjgl.input.Keyboard;

public class GuiIngameInjected extends avo {

	public avr scaledResolution;
	private ave mc;
	public GuiIngameInjected(ave mc) {
		super(mc);
		this.mc = mc;
	}
	
	@Override
	public void c() {
		this.scaledResolution = new avr(ave.A()); // update resolution, may need rework
		super.c(); // render everything else
		this.mc.A.a("keyBindings"); // debugProfiling
		if (Keyboard.isKeyDown(Keyboard.KEY_F9)) {
			Minecraft.getMinecraft().a(
							new GuiScreenModList(
									Minecraft.getMinecraft().m));
		}
		this.mc.A.b(); // debugProfilingEnd
		this.mc.A.a("modOverlay"); // debugProfiling
		BedrockClient client = (BedrockClient) BedrockMC.getClient();
		for (Mod mod : client.getKeyBindings().keySet()) {
			for (BindedKey key : client.getKeyBindings().get(mod)) {
				if (Keyboard.isKeyDown(key.getKeyCode())) {
					key.onKeyDown();
				}
			}

		}
		this.mc.A.b(); // debugProfilingEnd
	}
	
	public avr getScaledResoltion() {
		return this.scaledResolution;
	}

}
