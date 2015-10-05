import org.bedrockmc.api.overlay.RenderManager;

public class IngameRenderManager implements RenderManager {

	private GuiIngameInjected gui;
	private ave mc;
	
	public IngameRenderManager(GuiIngameInjected gui) {
		this.gui = gui;
		this.mc = Minecraft.getMinecraft();
	}

	@Override
	public void drawHorizontalLine(int arg0, int arg1, int arg2, int color) {
		gui.a(arg0, arg1, arg2, color);
	}

	@Override
	public void drawRect(int left, int top, int right, int bottom, int color) {
		axu.a(left, top, right, bottom, color);
	}

	@Override
	public void drawString(int x, int y, String text) {
		mc.k.a(text, x, y, 0xFFFFFF);
	}

	@Override
	public void drawString(int x, int y, String text, int color) {
		mc.k.a(text, x, y, color);
	}

	@Override
	public void drawVerticalLine(int arg0, int arg1, int arg2, int color) {
		gui.b(arg0, arg1, arg2, color);
	}

	@Override
	public int getHeight() {
		return gui.scaledResolution.b();
	}

	@Override
	public int getWidth() {
		return gui.scaledResolution.a();
	}

	public avo getGui() {
		return this.gui;
	}

	public ave getMc() {
		return this.mc;
	}

}
