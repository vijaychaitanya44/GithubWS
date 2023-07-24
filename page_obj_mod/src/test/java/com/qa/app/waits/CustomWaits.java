package com.qa.app.waits;

public class CustomWaits {
	
	
	public static void  waitForSeconds(int time) {
		
		try {
			Thread.sleep(time*1000);
		}
		catch(InterruptedException t) {
		}
		
	}

}
