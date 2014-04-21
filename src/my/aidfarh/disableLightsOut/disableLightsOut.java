package my.aidfarh.disableLightsOut;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;

public class disableLightsOut implements IXposedHookLoadPackage{
	public void handleLoadPackage (final LoadPackageParam lpparam) throws Throwable {
		if (!lpparam.packageName.equals("com.android.systemui"))
            return;

        XposedHelpers.findAndHookMethod("com.android.systemui.statusbar.phone.NavigationBarTransitions", lpparam.classLoader,
				"applyLightsOut", boolean.class, boolean.class, boolean.class, XC_MethodReplacement.DO_NOTHING);
    }
}