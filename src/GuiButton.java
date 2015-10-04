
public class GuiButton extends avs {

	public GuiButton(int id, int x, int y, String label) {
		super(id, x, y, label);
	}

	public GuiButton(int id, int x, int y, int width, int height,String label) {
		super(id, x, y, width, height, label);
	}
	
	public int getWidth() {
		return this.f;
	}
	
	public int getHeight() {
		return this.g;
	}
	
	public String getLabel() {
		return this.j;
	}
	
	public boolean isEnabled() {
		return this.l;
	}
	
	public boolean isVisible() {
		return this.m;
	}
	
	public boolean isHovered() {
		return this.n;
	}
	
	public int getID() {
		return this.k;
	}
	
	public int getX() {
		return this.h;
	}
	
	public int getY() {
		return this.i;
	}
	
	public void setWidth(int w) {
		this.f = w;
	}
	
	public void setHeight(int h) {
		this.g = h;
	}
	
	public void setLabel(String s) {
		this.j = s;
	}
	
	public void setEnabled(boolean e) {
		this.l = e;
	}
	
	public void setVisible(boolean v) {
		this.m = v;
	}
	
	public void setHovered(boolean h) {
		this.n = h;
	}
	
	public void setId(int id) {
		this.k = id;
	}
	
	public void setX(int x) {
		this.h = x;
	}
	
	public void setY(int y) {
		this.i = y;
	}

}
