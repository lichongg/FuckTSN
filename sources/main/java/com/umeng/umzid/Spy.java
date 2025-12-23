package com.umeng.umzid;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Spy {
    public static boolean initSuccess;

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z5, boolean z6);

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static synchronized String getTag(Context context) {
        boolean j6;
        String nativeTag;
        synchronized (Spy.class) {
            if (context != null) {
                try {
                    j6 = d.j(context);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                j6 = false;
            }
            nativeTag = getNativeTag(j6, context != null ? d.i(context) : false);
        }
        return nativeTag;
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
