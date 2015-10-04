
public class Injector {

	public static GuiIngameInjected INGAME_GUI;

	public static void inject(ave mc) {

		mc.q = (INGAME_GUI = new GuiIngameInjected(mc)); // replace the ingame gui with the modified one!
	}
}
