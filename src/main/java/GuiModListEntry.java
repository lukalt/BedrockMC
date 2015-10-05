
import java.util.ArrayList;
import java.util.List;

import org.bedrockmc.api.mod.Mod;

public class GuiModListEntry implements awd.a {

	private final GuiScreenModList parent;
	private final ave mc;
	private avn fontRenderer;
	final Mod mod;
	
	public GuiModListEntry(GuiScreenModList list, Mod mod) {
		this.parent = list;
		this.mod = mod;
		this.mc = Minecraft.getMinecraft();
		this.fontRenderer = this.mc.k;
	}

	@Override // drawSlot
	public void a(int slotIndex, int x, int y, int listWidth,
			int slotHeight, int mouseX, int mouseY, boolean isSelected) {
		int mv = 0;
		this.fontRenderer.a(this.mod.getName(), x + mv + 3,
				y + 1, 16777215);
		List<String> list = new ArrayList<String>();
		list.add("by " + this.mod.getDescription().getAuthor());
		if (!this.mod.getDescription().getWebsite().isEmpty()) {
			list.add("Website: " + this.mod.getDescription().getWebsite());
		}

		for (int var13 = 0; var13 < Math.min(list.size(), 2); ++var13) {
			this.fontRenderer.a((String) list.get(var13), x + mv
					+ 3, y + 12 + this.fontRenderer.a * var13,
					8421504);
		}

		String version = mod.getDescription().getVersion();
		int stringWidth = this.fontRenderer.a(version);
		this.fontRenderer.a(version, x + listWidth - stringWidth
				- 4, y + 1, 8421504);
		String str = mod.isEnabled() ? "§aEnabled" : "§cDisabled";
		int stWidth =this.fontRenderer.a(str);
		this.fontRenderer.a(str, x + listWidth - stWidth - 4,
				y + 1 + 12, 8421504);
		if (isSelected) {
			axu.a(x, y, x + 32, y + 32, -1601138544);
			axu.a(x, y - 1, x + listWidth, y, 0x88888888);
			axu.a(x, y + slotHeight, x + listWidth, y + slotHeight + 1,
					0x88888888);
			axu.a(x, y - 1, x + 1, y + slotHeight, 0x88888888);
			axu.a(x + listWidth, y - 1, x + listWidth + 1, y
					+ slotHeight, 0x88888888);
		}
	}


	@Override
	public boolean a(int slotId, int arg1, int arg2, int arg3, int arg4, int arg5) {
		parent.selectEntry(slotId);
		return false;
	}

	@Override
	public void b(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
	}

	@Override
	public void a(int par1, int par2, int par3) {
	}
}
