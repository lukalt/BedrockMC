import java.util.Collection;

import org.bedrockmc.api.Difficulty;
import org.bedrockmc.api.GameMode;
import org.bedrockmc.api.Location;
import org.bedrockmc.api.world.Chunk;
import org.bedrockmc.api.world.World;


public class BedrockWorld implements World {

	@Override
	public String getName() {
		
		return null;
	}

	@Override
	public int getDimension() {
		
		return 0;
	}

	@Override
	public boolean isRaining() {
		
		return false;
	}

	@Override
	public boolean isThundering() {
		
		return false;
	}

	@Override
	public GameMode getDefaultGameMode() {
		
		return null;
	}

	@Override
	public void setDefaultGameMode(GameMode gameMode) {
		
		
	}

	@Override
	public long getWorldTime() {
		
		return 0;
	}

	@Override
	public Location getSpawn() {
		
		return null;
	}

	@Override
	public void setSpawn(Location location) {
		
		
	}

	@Override
	public long getSeed() {
		
		return 0;
	}

	@Override
	public Difficulty getDifficulty() {
		
		return null;
	}

	@Override
	public boolean isDifficultyLocked() {
		
		return false;
	}

	@Override
	public Collection<Chunk> getChunks() {
		
		return null;
	}

	@Override
	public Chunk getChunkAt(int x, int y) {
		
		return null;
	}

	@Override
	public Chunk getChunkAt(Location location) {
		
		return null;
	}

}
