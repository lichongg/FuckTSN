package com.tencent.open.web.security;

import com.tencent.open.b;
import com.tencent.open.log.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SecureJsInterface extends b.C0813b {
    public static boolean isPWDEdit;

    /* renamed from: a, reason: collision with root package name */
    private String f40685a;

    @Override // com.tencent.open.b.C0813b
    public boolean customCallback() {
        return true;
    }

    public void clearAllEdit() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e6.getMessage());
            throw new RuntimeException(e6);
        }
    }

    public void curPosFromJS(String str) {
        int i6;
        SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i6 = Integer.parseInt(str);
        } catch (NumberFormatException e6) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e6);
            i6 = -1;
        }
        if (i6 < 0) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z5 = a.f40688c;
        boolean z6 = a.f40687b;
        if (z6) {
            if (JniInterface.BackSpaceChar(z6, i6)) {
                a.f40687b = false;
                return;
            }
            return;
        }
        String str2 = a.f40686a;
        this.f40685a = str2;
        JniInterface.insetTextToArray(i6, str2, str2.length());
        SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f40685a);
    }

    public String getMD5FromNative() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e6.getMessage());
            throw new RuntimeException(e6);
        }
    }

    public void isPasswordEdit(String str) {
        int i6;
        SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i6 = Integer.parseInt(str);
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e6.getMessage());
            i6 = -1;
        }
        if (i6 != 0 && i6 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i6 == 0) {
            isPWDEdit = false;
        } else if (i6 == 1) {
            isPWDEdit = true;
        }
    }
}
