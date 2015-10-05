
import org.bedrockmc.api.Texture;

public class SimpleDynamicTexture implements Texture {

	private int textureId;
	
	public SimpleDynamicTexture(int textureId) {
		this.textureId = textureId;
	}
	
	@Override
	public int getTextureId() {
		return this.textureId;
	}

}
