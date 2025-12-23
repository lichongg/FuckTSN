package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.col.p0003l.y5;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MsgProcessor {
    private static y5 mDelegate = new y5();

    public static native int nativeInit(Context context);

    public static void nativeInitInfo(Context context, boolean z5, String str, String str2, String str3, String[] strArr) {
        mDelegate.a(context, z5, str, str2, str3, strArr);
        nativeInit(context);
    }

    public static void nativeMsgProcessor(String str, String str2) {
        mDelegate.b(str, str2);
    }
}
