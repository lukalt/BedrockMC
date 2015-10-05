import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.ModManager;

public class GuiScreenModList extends GuiScreen {

	private GuiModSelectionList modSelectionList;
	private axu parent;
	private ave mc = ave.A();
	
	public GuiScreenModList(axu m) {
		super();
		this.parent = m;
	}

	public GuiModSelectionList getModSelectionList() {
		return modSelectionList;
	}

	public void setModSelectionList(GuiModSelectionList modSelectionList) {
		this.modSelectionList = modSelectionList;
	}

	public axu getParent() {
		return parent;
	}

	public void setParent(GuiScreen parent) {
		this.parent = parent;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.modSelectionList.a(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void actionPerformed(avs button) {
		super.actionPerformed(button);
		switch (button.k) {
		case 0:
			mc.a(this.parent);
			break;
		case 2:
			button.j = "§c" + modSelectionList.selection;
			break;
		case 3:
			mc.a(new GuiScreenInstallMod(this));
			break;
		case 8:
			mc.a(new GuiScreenModList(this.parent));
			break;
		case 1:
			System.out.println("Reloading...");
			reloadMods();
			break;
		}
	}

	private void reloadMods() {
		ModManager modManager = BedrockMC.getInstance().getModManager();
		modManager.unloadMods();
		((BedrockClient)BedrockMC.getClient()).loadMods();
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		modSelectionList.b(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
		this.modSelectionList.c(mouseX, mouseY, state);
	}

	@Override
	public void initGui() {
		this.modSelectionList = new GuiModSelectionList(this, mc, this.getWidth(),
				this.getHeight(), 32, this.getHeight() - 64, 36);
		this.n.add(new avs(1,
				this.getWidth() / 2 + 2, this.getHeight() - 52, 98, 20, "Reload"));
		this.n.add(new avs(3, this.getWidth() / 2 - 100,
				this.getHeight() - 52, 98, 20, "Install Mod"));
		this.n.add(new avs(0, this.getWidth() / 2 - 100,
				this.getHeight() - 28, "Cancel"));
	}

	public void selectEntry(int slot) {
		modSelectionList.selection = slot;
		try {
			GuiModListEntry entry = (GuiModListEntry) modSelectionList.b(slot);
			mc.a(new GuiScreenModInfo(entry.mod, this.parent));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
