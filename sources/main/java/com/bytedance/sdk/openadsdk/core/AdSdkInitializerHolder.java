package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class AdSdkInitializerHolder {
    private static String MEDIATION_CLASS_NAME = "com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder";
    private static String PACKAGE_NAME = "com.byted.pangle";
    private static volatile Object mDispatchAdSdkInitializer;
    private static volatile cw mInitializer;

    private static Object getDispatchAdSdkInitializer(Bundle bundle, cw cwVar) {
        try {
            return Class.forName(MEDIATION_CLASS_NAME).getDeclaredMethod("getInstance", Bundle.class, cw.class).invoke(null, bundle, cwVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Object getNewInstance(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        if (mInitializer == null) {
            synchronized (AdSdkInitializerHolder.class) {
                try {
                    if (mInitializer == null) {
                        mInitializer = new cw(bundle);
                        mDispatchAdSdkInitializer = getDispatchAdSdkInitializer(bundle, mInitializer);
                    }
                } finally {
                }
            }
        }
        int i6 = bundle.getInt("api_sdk_version", 0);
        if (i6 == 0) {
            i6 = getSdkVersion();
            com.bytedance.sdk.component.utils.vl.j("wzj,通过反射取apiSdkVersion值=".concat(String.valueOf(i6)));
            if (i6 == 0) {
                return null;
            }
        }
        r0.a.a().b(i6);
        return i6 < 6803 ? mDispatchAdSdkInitializer != null ? new com.bytedance.sdk.openadsdk.i.xt.xt.xt(a1.b.a(mDispatchAdSdkInitializer)) : new com.bytedance.sdk.openadsdk.i.xt.xt.j(mInitializer) : mDispatchAdSdkInitializer != null ? mDispatchAdSdkInitializer : mInitializer;
    }

    private static int getSdkVersion() {
        try {
            return Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk").getField("SDK_VERSION_CODE").getInt(null);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return 0;
        }
    }

    public static boolean hasDispatchAdSdkInitializer() {
        return mDispatchAdSdkInitializer != null;
    }

    public static boolean isSdkInitSuccess() {
        if (mInitializer != null) {
            return mInitializer.j();
        }
        return false;
    }
}
