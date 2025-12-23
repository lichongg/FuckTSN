package com.bytedance.pangle.tl;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    public static boolean j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            az j6 = com.bytedance.pangle.util.g.j() ? r.j(str, 1) : j.j(str, true);
            Signature[] signatureArr = j6 != null ? j6.xt : null;
            byte[] decode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (decode == null || decode.length == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
                return false;
            }
            int i6 = 0;
            for (Signature signature : signatureArr) {
                i6 += signature.toByteArray().length;
            }
            byte[] bArr = new byte[i6];
            int i7 = 0;
            for (Signature signature2 : signatureArr) {
                System.arraycopy(signature2.toByteArray(), 0, bArr, i7, signature2.toByteArray().length);
                i7 += signature2.toByteArray().length;
            }
            boolean j7 = az.j(bArr, decode);
            if (!j7) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            }
            return j7;
        } catch (i e6) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e6);
            return false;
        }
    }
}
