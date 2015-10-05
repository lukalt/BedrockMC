import java.util.List;

public class GuiScreen extends axu {

	public int getWidth() {
		return this.l;
	}

	public int getHeight() {
		return this.m;
	}

	public void drawScreen(int mouseX, int mouseY, float f) {
		// Invoked when the screen is beeing rendered
	}

	protected void keyTyped(char c, int i) {
		// Invoked when a key is typed
	}

	public void initGui() {
		// invoked when the gui is initalized
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
	}
	
	protected void mouseReleased(int mouseX, int mouseY, int state){
    }

	protected void actionPerformed(avs button) {
	}
	
	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {	
	}
	
	public void handleMouseInput() {
	}
	
	public void handleKeyboardInput() {
	}
	
	public void drawDefaultBackground() {
		super.c();
	}
	
	public void updateScreen() {
	}
	
	public void onGuiClose() {
	}
	
	@Override
	public void a(int mouseX, int mouseY, float f) {
		if(this.hasBackground()) {
			this.drawDefaultBackground();
		}
		super.a(mouseX, mouseY, f);
		this.drawScreen(mouseX, mouseY, f);
	}

	@Override
	protected void a(char c, int i) {
		super.a(c,i);
		this.keyTyped(c, i);
	}

	@Override
	public void b() {
		super.b();
		this.initGui();
	}

	@Override
	protected void a(avs a) {
		super.a(a);
		this.actionPerformed(a);
	}

	@Override
	public void a(int a, int b, int c) {
		super.a(a,b,c);
		this.mouseClicked(a, b, c);
	}
	
	@Override
	public void b(int a, int b, int c) {
		super.b(a, b, c);
		this.mouseReleased(a,b,c);
	}
	
	@Override
	protected void a(int a, int b, int c, long d) {
		super.a(a,b,c,d);
		this.mouseClickMove(a, b, c, d);
	}
	
	@Override
	public void k() {
		super.k();
		this.handleMouseInput();
	}
	
	@Override
	public void l() {
		super.l();
		this.handleKeyboardInput();
	}
	
	@Override
	public void e() {
		super.e();
		this.updateScreen();
	}
	
	@Override
	public void m() {
		super.m();
		this.onGuiClose();
	}
	
	public static boolean isCtrlKeyDown() {
		return GuiScreen.q();
	}
	
	public static boolean isShiftKeyDown() {
		return GuiScreen.r();
	}
	
	public List<avs> getButtonList() {
		return this.n;
	}
	
	public avn getFontRenderer() {
		return this.q;
	}
	
	public int getStringWidth(String i) {
		return this.getFontRenderer().a(i);
	}
	
	public boolean hasBackground() {
		return true;
	}
	
}

