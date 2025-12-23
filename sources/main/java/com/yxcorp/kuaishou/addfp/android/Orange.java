package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import android.text.TextUtils;
import com.yxcorp.kuaishou.addfp.c.a.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Orange {
    private static final int JNI_CONTROL_COMMAND_DIR_DETECT = 1114128;
    private static final int JNI_CONTROL_COMMAND_EGID = 1114139;
    private static final int JNI_CONTROL_COMMAND_GK_DETECT = 1114132;
    private static final int JNI_CONTROL_COMMAND_MANU_DETECT = 1114140;
    private static final int JNI_CONTROL_COMMAND_PROPS_DETECT = 1114131;
    private static final int JNI_CONTROL_COMMAND_RES_SOC_DETECT = 1245186;
    private static final int JNI_CONTROL_COMMAND_SERIAL_DETECT = 1179649;
    private static boolean sLibLoadFail = true;
    private static final String sdkVersion = "1.4.4.137.dea39c19";
    private static volatile Orange singleton;
    private String mEgidJson = "";

    private static native String getClock(Context context, byte[] bArr, int i6);

    private static native byte[] getMagic(Context context, byte[] bArr, int i6);

    private static native Object jniCommand(int i6, Object obj, Object obj2, Object obj3);

    public byte[] dcc(byte[] bArr, byte[] bArr2) {
        try {
            isReject();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized String getClockWrapper(Context context, byte[] bArr, int i6) {
        if (isReject()) {
            return "";
        }
        return getClock(context, bArr, i6);
    }

    public synchronized byte[] getMagicWrapper(Context context, byte[] bArr, int i6) {
        if (isReject()) {
            return null;
        }
        return getMagic(context, bArr, i6);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String getResSoc(String str) {
        try {
            if (isReject()) {
                return "";
            }
            return (String) jniCommand(JNI_CONTROL_COMMAND_RES_SOC_DETECT, str, null, null);
        } catch (Throwable unused) {
            return "";
        }
    }

    public synchronized String sted(String str, boolean z5) {
        try {
            if (isReject()) {
                return "";
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mEgidJson)) {
                return this.mEgidJson;
            }
            if (!TextUtils.isEmpty(str)) {
                return (String) jniCommand(JNI_CONTROL_COMMAND_EGID, "", str, null);
            }
            String str2 = (String) jniCommand(JNI_CONTROL_COMMAND_EGID, "", str, null);
            this.mEgidJson = str2;
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static Orange getInstance() {
        if (singleton == null) {
            synchronized (Orange.class) {
                try {
                    if (singleton == null) {
                        singleton = new Orange();
                    }
                } finally {
                }
            }
        }
        return singleton;
    }

    public static String getVersion() {
        return sdkVersion;
    }

    private boolean isReject() {
        return sLibLoadFail;
    }

    private void loadSoLib() {
        try {
            System.loadLibrary("sgcore");
            sLibLoadFail = false;
        } catch (Throwable th) {
            sLibLoadFail = true;
            th.printStackTrace();
        }
    }

    public String gKpsd() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_GK_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gManu(Context context, String str) {
        try {
            return (isReject() || context == null) ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_MANU_DETECT, str, context.getPackageName(), null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gProps() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_PROPS_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gRdi() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_DIR_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gSer() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_SERIAL_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private Orange() {
        loadSoLib();
    }

    public static String gLs(int i6, String str) {
        try {
            return a.a(i6, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
