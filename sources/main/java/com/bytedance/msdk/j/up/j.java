package com.bytedance.msdk.j.up;

import android.content.Context;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static Object j(Context context) {
        if (context != null) {
            try {
                Object obj = context.getClass() == PluginActivityWrapper.class ? ((PluginActivityWrapper) context).mOriginActivity : context.getClass() == PluginApplicationWrapper.class ? ((PluginApplicationWrapper) context).mOriginApplication : null;
                if (obj != null) {
                    return obj;
                }
            } catch (Throwable unused) {
            }
        }
        return context;
    }
}
