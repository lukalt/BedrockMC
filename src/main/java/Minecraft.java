
public class Minecraft {

	public static ave getMinecraft()  {
		return ave.A();
	}
	
	public static void displayGuiScreen(axu guiScreen) {
		getMinecraft().a(guiScreen);
	}
	
	public static bdb getWorldClient() {
		return getMinecraft().f;
	}
	
	public static bfr getRenderGlobal() {
		return getMinecraft().g;
	}
	
	public static biu getRenderManager() {
		return getMinecraft().af();
	}
	
	public static long getSystemTime() {
		return ave.J();
	}
	
	public static boolean isFullScreen() {
		return ave.A().K();
	}
}
