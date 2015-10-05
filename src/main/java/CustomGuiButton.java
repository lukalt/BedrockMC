

import org.bedrockmc.api.gui.Button;
import org.lwjgl.input.Mouse;

public class CustomGuiButton extends GuiButton implements Button {

	public CustomGuiButton(int buttonId, int x, int y, int widthIn,
			int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn > 20 ? 20 : heightIn, buttonText);
	}

	@Override
	public void drawButton() {
		this.a(Minecraft.getMinecraft(), Mouse.getX(),Mouse.getY());
	}

	@Override
	public void drawElement() {
		this.drawButton();
	}

	@Override
	public int getId() {
		return this.k;
	}

}
