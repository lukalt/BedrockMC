
import java.awt.image.BufferedImage;

import org.bedrockmc.api.mod.ModIcon;

public class SimpleModIcon extends ModIcon {
	
	blz dynamicTexture;
	private int texture;
	
	public SimpleModIcon(BufferedImage img) {
		if(img == null) {
			this.texture = -1;
			return;
		}
		dynamicTexture = new blz(img);
		this.texture = dynamicTexture.b(); // getGlTextureId
	}
	
	@Override
	public int getIcon() {
		return texture;
	}

	@Override
	public boolean hasIcon() {
		return texture != -1;
	}
	
	public blz getTexture() {
		return this.dynamicTexture;
	}

	
}
