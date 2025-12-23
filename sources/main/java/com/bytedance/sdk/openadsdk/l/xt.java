package com.bytedance.sdk.openadsdk.l;

import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static byte[] j(byte[] bArr, int i6) {
        if (bArr != null && i6 > 0) {
            try {
                if (bArr.length == i6) {
                    return TTEncryptUtils.a(bArr, i6);
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return null;
    }
}
