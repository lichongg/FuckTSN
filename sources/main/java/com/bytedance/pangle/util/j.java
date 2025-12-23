package com.bytedance.pangle.util;

import android.app.Activity;
import android.content.res.Resources;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static void j(com.bytedance.pangle.wrapper.j jVar, Activity activity) {
        try {
            FieldUtils.writeField(jVar, "mTheme", (Object) null);
            FieldUtils.writeField((Object) jVar, "mThemeResource", (Object) 0);
            int[] j6 = j(activity);
            if (j6 == null) {
                return;
            }
            for (int i6 : j6) {
                if (i6 != 0) {
                    jVar.setWrapperActivityTheme(i6);
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.openadsdk.api.m.j(e6);
        }
    }

    private static int[] j(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (g.qv()) {
                Object readField = FieldUtils.readField(theme, "mThemeImpl");
                if (readField == null) {
                    return null;
                }
                try {
                    Object invokeMethod = MethodUtils.invokeMethod(readField, "getKey", new Object[0]);
                    if (invokeMethod != null) {
                        return (int[]) FieldUtils.readField(invokeMethod, "mResId");
                    }
                } catch (Exception unused) {
                }
                Object invoke = com.bytedance.pangle.xt.xt.j.j(readField.getClass(), "getKey", new Class[0]).invoke(readField, null);
                if (invoke == null) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) com.bytedance.pangle.xt.xt.j.j(invoke.getClass(), "mResId").get(invoke);
            }
            if (g.xt()) {
                Object invokeMethod2 = MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                if (invokeMethod2 == null) {
                    return null;
                }
                return (int[]) FieldUtils.readField(invokeMethod2, "mResId");
            }
            String str = (String) MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
            if (str == null) {
                return null;
            }
            String[] split = str.trim().replace("!", "").split(" ");
            int[] iArr = new int[split.length];
            for (int i6 = 0; i6 < split.length; i6++) {
                iArr[i6] = Integer.parseInt(split[i6], 16);
            }
            return iArr;
        } catch (Throwable th) {
            ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
            return null;
        }
    }

    public static void j(IPluginActivity iPluginActivity, Activity activity) {
        try {
            FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
            FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
            int[] j6 = j(activity);
            if (j6 == null) {
                return;
            }
            for (int i6 : j6) {
                if (i6 != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i6);
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.openadsdk.api.m.j(e6);
        }
    }
}
