
import java.awt.Desktop;
import java.net.URI;

import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.mod.Mod;

public class GuiScreenModInfo extends GuiScreen {

	private Mod mod;
	private axu parent;
	private jy resLoc;
	private ave mc = ave.A();

	public GuiScreenModInfo(Mod mod, axu parent) {
		this.mod = mod;
		this.parent = parent;
		this.resLoc = new jy("/mods/" + mod.getName() + "/icons");
	}
	
	public jy getResourceLocation() {
		return this.resLoc;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		String s = mod.getName() + " §7v. " + mod.getDescription().getVersion();
		String author = "§7by " + mod.getDescription().getAuthor();
		this.drawString(s, this.getWidth() / 2 - this.getStringWidth(s) / 2,
				100);
		this.drawString(author,this.getWidth() / 2 - RenderUtil.getStringWidth(author) / 2,
				100 + 13);
//		if (mod.getIcon() != null && mod.getIcon().hasIcon()) {
//			SimpleModIcon mIcon = (SimpleModIcon) mod.getIcon();
//			int icon = mIcon.getIcon();
//			DynamicTexture texture = mIcon.getTexture();
//			mc.getTextureManager().loadTexture(resLoc, texture);
//			mc.getTextureManager().bindTexture(resLoc);
//			// drawRect(width / 2 - 33, height / 2- 33, width / 2 + 33, height /
//			// 2 + 33, 0xEEEEEEEE);
//			drawScaledCustomSizeModalRect(width / 2 - 32, 16, 1f, 1f, 64, 64,
//					64, 64, 64f, 64f);
//		}
	}

	public void drawString(String s, int x, int y) {
		this.a(getFontRenderer(), s, x, y, 0xFFFFFF);
	}

	public void drawCString(String s, int x, int y) {
		this.a(getFontRenderer(), s, x, y, 0xFFFFFF);
	}

	@Override
	protected void a(avs button) {
		if (button.k == 0) {
			mc.a(parent);
		} else if (button.k == 1) {
			if (mod.isEnabled()) {
				BedrockMC.getClient().getModManager().disableMod(mod);
				button.j = "§aEnable";
			} else {
				BedrockMC.getClient().getModManager().enableMod(mod);
				button.j = "§cDisable";
			}
		} else if (button.k == 3) {
			try {
				Desktop.getDesktop().browse(
						new URI(mod.getDescription().getWebsite()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (button.k == 2) {
			BedrockMC.getClient().getModManager().reloadMod(mod);
			mc.a(parent);
		}
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {
		super.initGui();
		GuiButton e2 = new GuiButton(3, this.getWidth() / 2 - 100,
				this.getHeight() - 88, 100, 20, "Open Website");
		e2.l = !mod.getDescription().getWebsite().isEmpty();
		this.getButtonList().add(e2);
		GuiButton e3 = new GuiButton(3, this.getWidth() / 2 + 2,
				this.getHeight() - 88, 98, 20, "Settings");
		e3.l = false; // implement
		this.getButtonList().add(e3);
		GuiButton e = new GuiButton(2, this.getWidth() / 2 + 2,
				this.getHeight() - 110, 98, 20, "Reload");
		e.l = mod.isEnabled();
		this.getButtonList().add(e);
		this.getButtonList().add(
				new GuiButton(1, this.getWidth() / 2 - 100,
						this.getHeight() - 110, 100, 20,
						mod.isEnabled() ? "§cDisable" : "§aEnable"));
		this.getButtonList().add(
				new GuiButton(0, this.getWidth() / 2 - 100,
						this.getHeight() - 66, 200, 20, "Back"));
	}

}
