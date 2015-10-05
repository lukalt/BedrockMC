import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.bedrockmc.api.gui.Button;
import org.bedrockmc.api.gui.Element;
import org.bedrockmc.api.gui.GuiListener;
import org.bedrockmc.api.gui.GuiScreenType;
import org.bedrockmc.api.gui.ModGuiScreen;
import org.bedrockmc.api.gui.TextField;

public class SimpleModGuiScreen extends GuiScreen implements ModGuiScreen {

	private GuiListener listener;
	private GuiScreenType type = GuiScreenType.GUI_SCREEN;
	private List<Element> elements = new ArrayList<Element>();

	@Override
	public List<Button> getButtons() {
		List<Button> buttons = new ArrayList<>();
		synchronized (this.elements) {
			for (Element el : elements) {
				if (el instanceof Button) {
					buttons.add((Button) el);
				}
			}
		}
		return buttons;
	}

	@Override
	public void addButton(Button button) {
		Validate.notNull(button);
		synchronized (this.elements) {
			this.elements.add(button);
		}
	}

	@Override
	public void removeButton(Button button) {
		Validate.notNull(button);
		synchronized (this.elements) {
			this.elements.remove(button);
		}

	}

	@Override
	public GuiListener getGuiListener() {
		return this.listener;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		for (Element el : elements) {
			el.drawElement();
		}
	}

	@Override
	protected void a(avs button) {
		super.a(button);
		if (button instanceof Button) {
			listener.buttonClicked((Button) button);
		}
	}

	@Override
	public void setGuiListener(GuiListener listener) {
		this.listener = listener;
	}

	@Override
	public void closeGui() {

	}

	@Override
	public Button createButton(int id, String label, int x, int y) {
		return new CustomGuiButton(id, x, y, 200, 20, label);
	}

	@Override
	public Button createButton(int id, String label, int x, int y, int width,
			int height, boolean enabled) {
		CustomGuiButton customGuiButton = new CustomGuiButton(id, x, y, width,
				height, label);
		customGuiButton.setEnabled(enabled);
		return customGuiButton;
	}

	@Override
	public TextField createTextField(int x, int y, int width, int height) {
		return new GuiTextField(ave.A(), x, y, width, height);
	}

	@Override
	public void addLabel(String string, int x, int y) {
		synchronized (this.elements) {
			this.elements.add(new GuiLabel(x, y, string));
		}
	}

	@Override
	public void addElement(Element element) {
		synchronized (this.elements) {
			this.elements.add(element);
		}
	}

	@Override
	public Collection<Element> getElements() {
		synchronized (this.elements) {
			return this.elements;
		}
	}

	@Override
	public void removeElement(Element element) {
		synchronized (this.elements) {
			this.elements.remove(element);
		}
	}

	@Override
	public GuiScreenType getType() {
		return this.type;
	}

	@Override
	public void openGui() {
		ave.A().a(this);
	}

	@Override
	public void drawString(int x, int y, String text) {
		this.a(RenderUtil.getFontRenderer(), text, x, y, Integer.MAX_VALUE);
	}

	@Override
	public void drawString(int x, int y, String text, int color) {
		Validate.notNull(text);
		this.a(RenderUtil.getFontRenderer(), text, x, y, color);
	}

	@Override
	public void drawRectangle(int left, int top, int right, int bottom,
			int color) {
		axu.a(left, top, right, bottom, color);
	}

	@Override
	public void drawHorizontalLine(int left, int right, int y, int color) {
		this.a(left, right, y, color);
	}

	@Override
	public void drawVerticalLine(int top, int bottom, int x, int color) {
		this.b(top, bottom, x, color);
	}

}
