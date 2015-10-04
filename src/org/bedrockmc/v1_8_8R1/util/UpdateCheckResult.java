package org.bedrockmc.v1_8_8R1.util;

public class UpdateCheckResult {

	private UpdateCheckResultType updateCheckResultType;
	
	public boolean isUpdateAvailable() {
		return this.updateCheckResultType == UpdateCheckResultType.UPDATE_AVAILABLE;
	}
	
	
}
