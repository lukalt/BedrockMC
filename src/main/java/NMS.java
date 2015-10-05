
import org.bedrockmc.api.Location;
import org.bedrockmc.api.chat.ChatColor;
import org.bedrockmc.api.chat.ChatMessage;

public class NMS {
	
	// Obfuscation:
	// fa <=> ChatComponentText
	// es <=> ChatComponentStyle
	// eu <=> IChatComponent
	// ez <=> ChatStyle
	
	public static fa asNMSChat(ChatMessage message) {
		if(message == null) {
			return null;
		}
		fa comp = new fa(message.getText());
		ez s = comp.b();
		s.a(message.isBold());
		s.b(message.isItalic());
		s.e(message.isObfuscated());
		s.c(message.isStrikethrough());
		s.d(message.isUnderlined());
		comp.a(s);
		for(ChatMessage msg : message.getExtras()) {
			comp.a(asNMSChat(msg));
		}
		return comp;
	}
	
	public static ChatMessage toBedrockChat(eu c) {
		if(c == null) {
			return null;
		}
		ChatMessage msg = new ChatMessage(c.e()); // getUnformattedText
		ez s = c.b();
		msg.setBold(s.b()); // isBold
		msg.setItalic(s.c());
		msg.setObfuscated(s.f());
		msg.setUnderlined(s.e());
		msg.setColor(ChatColor.valueOf(s.a().e().toUpperCase()));
		c.a(s);
		return msg;
	}

	public static Location toBedrockLoc(cj pos) {
		return new Location(pos.n(),pos.o(),pos.p());
	}
	
	public static cj toNMSPos(Location loc) {
		return new cj(loc.getX(), loc.getY(), loc.getZ());
	}
	
}
