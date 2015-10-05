
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.ModManager;
import org.bedrockmc.api.mod.Mod;

import com.google.common.io.Files;

public class GuiScreenInstallMod extends InternalModScreen {

	private axu parent;
	
	public GuiScreenInstallMod(axu parent) {
		this.parent = parent;
	}
	
	@Override
	public void a(int mouseX, int mouseY, float partialTicks) {
		super.c();
		super.a(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void a(avs button) {
		super.a(button);
		switch(button.k) {
		case 0:
			FileDialog dialog = new FileDialog((Frame) null, "Choose Mod", FileDialog.LOAD);
			dialog.setFilenameFilter(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".jar");
				}
			});
			dialog.setDirectory(new File("bedrock-mods").getAbsolutePath());
			dialog.setVisible(true);
			if(dialog.getFile() != null) {
				File file = new File(dialog.getDirectory(), dialog.getFile());
				if(file.exists()) {
					File to = new File("bedrock-mods", file.getName());
					if(to.exists()) {
						int i = JOptionPane.showConfirmDialog(null, "This mod is already installed. Do you want to override it?","BedrockMC",JOptionPane.YES_NO_OPTION);
						if(i == JOptionPane.NO_OPTION) {
							return;
						}
					}
					try {
						Files.copy(file, to);
					} catch (IOException e) {
						e.printStackTrace();
					}
					ModManager modManager = BedrockMC.getInstance().getModManager();
					Mod mod = modManager.loadMod(to);
					modManager.enableMod(mod);
				}
			}
		break;
		case 1:
			this.j.a(parent);
			break;
		case 2:
			this.j.a((axu)new GuiScreenInstallModFromURL(this));
			break;
		}
	}

	@Override
	public void b() {
		super.b();
		this.n.clear();
		this.n.add(new avs(0, this.getWidth() / 2 - 100, 120, 200,20, "Install from File System"));
		this.n.add(new avs(2, this.getWidth() / 2 - 100, 98, 200,20, "Install from URL"));
		avs e = new avs(3, this.getWidth() / 2 - 100, 76, 200,20, "Install from Marketplace");
		e.l = false;
		this.n.add(e);
		this.n.add(new avs(1, this.getWidth() / 2 - 100, this.getHeight() -100,200,20,"Back"));
	}

}
