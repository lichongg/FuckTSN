package com.bytedance.sdk.openadsdk.core.la;

import com.baidu.mobads.sdk.internal.by;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static String j(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(bArr);
            return qv.j(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
