
public class RenderUtil {

	public static int getStringWidth(String s) {
		return getMinecraftInstance().k.a(s);
	}

	public static ave getMinecraftInstance() {
		return ave.A();
	}
	
	public static int getCharWidth(char c) {
		return getMinecraftInstance().k.a(c);
	}
	
	public static avn getFontRenderer() {
		return getMinecraftInstance().k;
	}
}
