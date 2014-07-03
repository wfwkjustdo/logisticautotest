package com.incito.appium.util;


import java.io.IOException;

public class SetIME {
	Runtime rt = Runtime.getRuntime();
   public void setIMEByCMD(String cmd){

	   try {
		rt.exec(cmd);
	} catch (IOException e) {
		e.printStackTrace();
	}

   }


}
