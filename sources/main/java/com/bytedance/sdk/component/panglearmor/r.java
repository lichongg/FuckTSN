package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.vl;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f26705j;

    @DungeonFlag
    private static PublicKey j() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    @DungeonFlag
    public static boolean j(String str, String str2) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(j().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(generatePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    @DungeonFlag
    public static boolean j(final String str) {
        try {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.r.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    try {
                        str2 = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception unused) {
                        str2 = "";
                    }
                    if (str2.equals("127.0.0.1") || str2.equals("::1")) {
                        boolean unused2 = r.f26705j = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError e6) {
            vl.j(e6);
        }
        return f26705j;
    }
}
