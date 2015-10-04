

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.mod.Mod;

public class GuiScreenInstallModFromURL extends GuiScreen implements Runnable {

	private axu parent;
	private avw textField;
	private Thread thread;
	private String url;
	private File installedFile;
	private ave mc = ave.A();
	
	public GuiScreenInstallModFromURL(GuiScreenInstallMod guiScreenInstallMod) {
		this.parent = guiScreenInstallMod;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.textField.g(); // draw text field
		this.a(RenderUtil.getFontRenderer(), "Enter an URL", this.getWidth() / 2,
				50, 0x88888888);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void a(avs button) {
		super.a(button);
		if (button.k == 2) {
			mc.a(this.parent);
		}else if(button.k == 1) {
			if(!textField.b().isEmpty()) {
				button.l = false;
				this.textField.c(false); // setEnabled
				button.j = "§eInstalling...";
				this.url = this.textField.b();
				this.thread = new Thread(this);
				this.thread.start();
			}
		}
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) {
		super.keyTyped(typedChar, keyCode);
		this.textField.a(typedChar, keyCode);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.textField.a(mouseX, mouseY, mouseButton);
	}

	@Override
	public void initGui() {
		this.getButtonList().clear();
		this.textField = new avw(0, this.getFontRenderer(), this.getWidth() / 2 - 75,
				70, 150, 20);
		this.getButtonList().add(new GuiButton(1, this.getWidth() / 2 - 75, 97, 150, 20,
				"Install"));
		this.getButtonList().add(new GuiButton(2, this.getWidth() / 2 - 75, 119, 150, 20,
				"Back"));
		this.textField.f(500); // setMaxStringLength

	}

	@Override
	public void run() {
		try {
			installAsync(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void installAsync(String url) throws MalformedURLException,
			IOException, FileNotFoundException {
		URL website = new URL(url);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		BedrockClient client = (BedrockClient) BedrockMC.getClient();
		File file = new File(client.modFile, "mod-"
				+ System.currentTimeMillis() + ".jar");
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		this.installedFile = file;
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		if(installedFile != null) {
			Mod mod = BedrockMC.getClient().getModManager().loadMod(this.installedFile); // install
			mc.a(new GuiScreenModInfo(mod, this.parent));
			BedrockMC.getClient().getModManager().enableMod(mod);
		}
	}

}
