package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35134a = "SSFSecureX509SingleInstance";

    /* renamed from: b, reason: collision with root package name */
    private static volatile k f35135b;

    @SuppressLint({"NewApi"})
    public static k a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (f35135b == null) {
            synchronized (e.class) {
                try {
                    if (f35135b == null) {
                        InputStream o5 = com.huawei.secure.android.common.ssl.util.a.o(context);
                        if (o5 == null) {
                            com.huawei.secure.android.common.ssl.util.h.e(f35134a, "get assets bks");
                            o5 = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            com.huawei.secure.android.common.ssl.util.h.e(f35134a, "get files bks");
                        }
                        f35135b = new k(o5, "", true);
                    }
                } finally {
                }
            }
        }
        return f35135b;
    }

    @Deprecated
    public static void b(InputStream inputStream) {
        String str = f35134a;
        com.huawei.secure.android.common.ssl.util.h.e(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f35135b != null) {
            f35135b = new k(inputStream, "", true);
            com.huawei.secure.android.common.ssl.util.h.b(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            d.b(f35135b);
            c.b(f35135b);
        }
        com.huawei.secure.android.common.ssl.util.h.b(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void c(InputStream inputStream, SecureRandom secureRandom) {
        String str = f35134a;
        com.huawei.secure.android.common.ssl.util.h.e(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f35135b != null) {
            f35135b = new k(inputStream, "", true);
            com.huawei.secure.android.common.ssl.util.h.b(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            d.c(f35135b, secureRandom);
            c.c(f35135b, secureRandom);
        }
        com.huawei.secure.android.common.ssl.util.h.b(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    private e() {
    }
}
