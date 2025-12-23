package com.huawei.hms.feature;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class DynamicModuleInitializer {
    private static WeakReference<Context> sContext;

    public static Context getContext() {
        WeakReference<Context> weakReference = sContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void initializeModule(Context context) {
        sContext = new WeakReference<>(context);
    }
}
