package com.amanoteam.kanni;

import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.view.WindowManager.LayoutParams;

import de.robv.android.xposed.XposedBridge;


public class Kanni implements IXposedHookLoadPackage {
	
	public void handleLoadPackage(final LoadPackageParam loadPackageParam) throws Throwable {
		
		findAndHookMethod(LayoutParams.class, "copyFrom", LayoutParams.class, new XC_MethodHook() {
				
				@Override
				protected void beforeHookedMethod(final MethodHookParam param) throws Throwable {
					final LayoutParams params = (LayoutParams) param.args[0];
					params.screenBrightness = LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
					params.buttonBrightness = LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
				}
				
			}
			
		);
		
	}
	
}
