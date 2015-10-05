import org.bedrockmc.api.gui.Label;

public class GuiLabel implements Label {

	private int x;
	private int y;
	private String text;

	public GuiLabel(int x, int y, String text) {
		super();
		this.x = x;
		this.y = y;
		this.text = text;
	}

	@Override
	public void drawElement() {
		Minecraft.getMinecraft().k.a(text, x, y, 0xFFFFFF);
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}
}
