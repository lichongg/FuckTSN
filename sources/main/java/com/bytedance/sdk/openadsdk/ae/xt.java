package com.bytedance.sdk.openadsdk.ae;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static String cw = "OutProcessEncryptUtils";

    /* renamed from: j, reason: collision with root package name */
    static String f27523j = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALo9WqslO45/EjPWz6YMAu8PBgzV9Ujk3TSQSgebYdNPLJ2u0Y69eSj5DRk7uVplC+WkdEJGznST4OXTRZyKI9ECAwEAAQ==";
    private static volatile xt xt;

    /* renamed from: r, reason: collision with root package name */
    private PublicKey f27524r = null;
    private r up;

    public static xt j() {
        if (xt == null) {
            synchronized (xt.class) {
                try {
                    if (xt == null) {
                        xt = new xt();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    private PublicKey cw(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(f27523j, 2)));
    }

    private r r(Context context) {
        r rVar = new r();
        rVar.f27522j = cw.j();
        rVar.xt = cw.j();
        String str = rVar.f27522j + "#" + rVar.xt;
        for (int i6 = 2; i6 >= 0; i6--) {
            byte[] j6 = j(context, str);
            if (j6 != null && j6.length > 0) {
                rVar.cw = Base64.encodeToString(j6, 2);
            }
            if (!TextUtils.isEmpty(rVar.cw)) {
                break;
            }
        }
        return rVar;
    }

    private PublicKey xt(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (this.f27524r == null) {
            this.f27524r = cw(context);
        }
        return this.f27524r;
    }

    private xt() {
    }

    private byte[] j(PublicKey publicKey, byte[] bArr) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public r j(Context context) {
        r r5;
        r rVar = this.up;
        if (rVar != null) {
            return rVar;
        }
        synchronized (this) {
            r5 = r(context);
            this.up = r5;
        }
        return r5;
    }

    private byte[] j(Context context, String str) {
        try {
            return j(xt(context), str.getBytes());
        } catch (Exception unused) {
            return null;
        }
    }
}
