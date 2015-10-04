

import java.util.UUID;

import org.bedrockmc.api.Location;
import org.bedrockmc.api.entity.EntityType;
import org.bedrockmc.api.entity.Player;
import org.bedrockmc.v1_8_8R1.util.Exceptions;

public class BedrockPlayer implements Player {

	/*
	 * TODO: Implement the missing method. 
	 */
	
	private wn handle;
	
	public BedrockPlayer(wn handle) {
		this.handle = handle;
	}
	
	public wn getHandle() {
		return this.handle;
	}
	
	@Override
	public Location getLocation() {
		return new Location(handle.s, handle.t, handle.u);
	}

	@Override
	public String getName() {
		return handle.e_();
	}

	@Override
	public UUID getUniqueId() {
		return handle.aK();
	}

	@Override
	public float getCameraPitch() {
		Exceptions.unimplemented();
		//return handle.cameraPitch;
		return 0f;
	}

	@Override
	public float getCameraYaw() {
		return handle.bo;
	}

	@Override
	public int getDimension() {
		Exceptions.unimplemented();
		//return handle.dimension;
		return 0;
	}

	@Override
	public float getExp() {
		return handle.bD;
	}

	@Override
	public Location getEyeLocation() {
		Location l = getLocation();
		l.setPitch(this.getCameraPitch());
		l.setYaw(this.getCameraYaw());
		return l;
	}

	@Override
	public double getHealth() {
		return handle.bn(); // getHealth
	}

	@Override
	public int getLevel() {
		return handle.bB; // experienceLevel
	}

	@Override
	public double getMaxHealth() {
		return handle.bu();
	}

	@Override
	public float getTotalExperience() {
		return handle.bC; //experienceTotal
	}

	@Override
	public boolean isAlive() {
		Exceptions.unimplemented();
		//return !handle.isDead;
		return false;
	}

	@Override
	public boolean isBlocking() {
		Exceptions.unimplemented();
		//return handle.isBlocking();
		return false;
	}

	@Override
	public boolean isBurning() {
		Exceptions.unimplemented();
		return false;
	}

	@Override
	public boolean isDead() {
		return handle.I; // isDead
	}

	@Override
	public boolean isSneaking() {
		return handle.av(); // isSneaking
	}

	@Override
	public void setBlocking(boolean arg0) {
		Exceptions.unimplemented();
	}

	@Override
	public void setPostion(Location loc) {
		handle.b(loc.getX(), loc.getY(), loc.getZ()); // setPosition
	}

	@Override
	public void setSneaking(boolean sneaking) {
		handle.c(sneaking); // setSneaking
	}

	@Override
	public void setHealth(double health) {
		handle.i((float) health); // setHealth
	}

	@Override
	public void setMaxHealth(double maxHealth) {
		Exceptions.unimplemented();
		//handle.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(maxHealth);
	}

	@Override
	public int getEntityId() {
		return handle.F(); // getEntitiyId
	}

	@Override
	public void remove() {
		this.handle.J(); // setDead
	}

	@Override
	public void setFireTicks(int ticks) {
		Exceptions.unimplemented();
		//this.handle.setFire(ticks / 20); // TODO improve
	}

	@Override
	public EntityType getType() {
		return EntityType.PLAYER;
	}

}
