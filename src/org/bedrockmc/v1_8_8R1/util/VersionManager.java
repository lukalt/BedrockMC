package org.bedrockmc.v1_8_8R1.util;

import java.util.concurrent.Callable;

import org.bedrockmc.api.Client;

public class VersionManager {
	
	private Client client;
	private long lastCheck = -1l;
	
	public VersionManager(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void checkForUpdates(Callable<UpdateCheckResult> callable) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		t.start();
	}
	
}
