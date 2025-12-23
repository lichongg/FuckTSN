package com.tencent.open.web.security;

import android.content.Context;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JniInterface {
    public static boolean isJniOk;

    public static native boolean BackSpaceChar(boolean z5, int i6);

    public static native boolean clearAllPWD();

    public static native String d1(String str);

    public static native String d2(String str);

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i6, String str, int i7);

    public static void loadSo() {
        if (isJniOk) {
            return;
        }
        try {
            Context a6 = g.a();
            if (a6 == null) {
                SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
                return;
            }
            if (!new File(a6.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                return;
            }
            System.load(a6.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
            isJniOk = true;
            SLog.i("openSDK_LOG.JniInterface", "-->load lib success:" + AuthAgent.SECURE_LIB_NAME);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th);
        }
    }
}
