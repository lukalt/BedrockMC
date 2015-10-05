import java.util.ArrayList;
import java.util.List;

import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.mod.Mod;

public class GuiModSelectionList extends awd {


	private List<GuiModListEntry> entries = new ArrayList<GuiModListEntry>();
	private GuiScreenModList parent;
	protected int selection = -1;
	private ave mc = ave.A();
	
	@Override
	protected boolean a(int slotIndex) {
		return slotIndex == selection;
	}

	public GuiModSelectionList(GuiScreenModList list, ave mcIn,
			int width, int height, int x, int y, int slotHeight) {
		super(mcIn, width, height, x, y, slotHeight);
		this.parent = list;
		for(Mod mod : BedrockMC.getClient().getModManager().getLoadedMods()) {
			entries.add(new GuiModListEntry(parent, mod));
		}
	}

	@Override
	protected int b() {
		return entries.size();
	}

	@Override
	public awd.a b(int i) {
		return entries.get(i);
	}
	
	public void setSelection(int slotIndex) {
		this.selection = slotIndex;
	}
	
	@Override
	protected void a(int slotIndex, boolean isDoubleClick,
			int mouseX, int mouseY) {
		try {
			GuiModListEntry entry = (GuiModListEntry) b(slotIndex);
			mc.a(new GuiScreenModInfo(entry.mod, this.parent));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		super.a(slotIndex, isDoubleClick, mouseX, mouseY);
	}
	
}
