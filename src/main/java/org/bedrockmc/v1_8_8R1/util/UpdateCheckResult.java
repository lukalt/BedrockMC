package org.bedrockmc.v1_8_8R1.util;

public class UpdateCheckResult {

	private UpdateCheckResultType updateCheckResultType;
	private String downloadUrl;
	private String changelog;
	private String version;
	
	public boolean isUpdateAvailable() {
		return this.updateCheckResultType == UpdateCheckResultType.UPDATE_AVAILABLE;
	}

	public UpdateCheckResult(UpdateCheckResultType updateCheckResultType,
			String downloadUrl, String changelog, String version) {
		super();
		this.updateCheckResultType = updateCheckResultType;
		this.downloadUrl = downloadUrl;
		this.changelog = changelog;
		this.version = version;
	}

	public UpdateCheckResultType getUpdateCheckResultType() {
		return updateCheckResultType;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public String getChangelog() {
		return changelog;
	}

	public String getVersion() {
		return version;
	}

}
