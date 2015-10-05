import java.lang.reflect.Field;

import org.bedrockmc.api.gui.TextField;

public class GuiTextField extends avw implements TextField {

	public GuiTextField(ave mc, int x, int y, int width, int height) {
		super(0, RenderUtil.getFontRenderer(), x, y, width, height);
	}

	@Override
	public void drawElement() {
		super.g();
	}

	@Override
	public int getX() {
		return this.a;
	}

	@Override
	public int getY() {
		return this.f;
	}

	@Override
	public void setX(int x) {
		this.a = x;
	}

	@Override
	public void setY(int y) {
		this.f = y;
	}

	@Override
	public int getCursor() {
		return this.i(); // getCursorPosition
	}

	@Override
	public int getMaxLength() {
		return this.h(); // getMaxStringLength
	}

	@Override
	public void setMaxLength(int i) {
		super.f(i);
	}

	@Override
	public void setCursor(int pos) {
		super.e(pos);
	}

	@Override
	public void setText(String text) {
		this.a(text);
	}

	@Override
	public String getText() {
		return this.b();
	}

	@Override
	public void setFocused(boolean flag) {

	}

	@Override
	public boolean isFocused() {
		return false;
	}

	@Override
	public int getWidth() {
		try {
			Class<?> clazz = super.getClass();
			Field i = clazz.getField("i");
			i.setAccessible(true);
			return i.getInt(this);
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getHeight() {
		try {
			Class<?> clazz = super.getClass();
			Field i = clazz.getField("j");
			i.setAccessible(true);
			return i.getInt(this);
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
}
