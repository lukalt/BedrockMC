package org.bedrockmc.v1_8_8R1.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bedrockmc.api.Client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VersionManager implements Runnable {
	
	private Client client;
	private static String URL = "https://bedrockmc.org/api/latest-version.json";
	private static Gson gson = new GsonBuilder().create();
	private Callback<UpdateCheckResult> callback;
	
	public VersionManager(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void checkForUpdates(Callback<UpdateCheckResult> callback) {
		this.callback = callback;
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		URL url;
		try {
			url = new URL(VersionManager.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			callback.callBack(new UpdateCheckResult(UpdateCheckResultType.ERROR, null, null, null));
			return;
		}
		try {
			URLConnection c = url.openConnection();
			String content = org.apache.commons.io.IOUtils.toString(c.getInputStream());
			VersionData version = gson.fromJson(content, VersionData.class);
			if(version.getVersionCode() > client.getBedrockVersionCode()) {
				callback.callBack(new UpdateCheckResult(UpdateCheckResultType.UPDATE_AVAILABLE, version.getDirectDownloadUrl(), "", version.getBedrockVersion()));
			} else {
				callback.callBack(new UpdateCheckResult(UpdateCheckResultType.UP_TO_DATE, null, null, null));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
