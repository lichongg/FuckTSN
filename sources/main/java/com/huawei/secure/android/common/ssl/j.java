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
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35178a = "SecureX509SingleInstance";

    /* renamed from: b, reason: collision with root package name */
    private static volatile k f35179b;

    @Deprecated
    public static void b(InputStream inputStream) {
        String str = f35178a;
        com.huawei.secure.android.common.ssl.util.h.e(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f35179b != null) {
            f35179b = new k(inputStream, "");
            h.b(f35179b);
            g.b(f35179b);
        }
        com.huawei.secure.android.common.ssl.util.h.e(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void c(InputStream inputStream, SecureRandom secureRandom) {
        String str = f35178a;
        com.huawei.secure.android.common.ssl.util.h.e(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f35179b != null) {
            f35179b = new k(inputStream, "");
            h.c(f35179b, secureRandom);
            g.c(f35179b, secureRandom);
        }
        com.huawei.secure.android.common.ssl.util.h.e(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    private j() {
    }

    @SuppressLint({"NewApi"})
    public static k a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.b(context);
            if (f35179b == null) {
                synchronized (j.class) {
                    if (f35179b == null) {
                        try {
                            inputStream = com.huawei.secure.android.common.ssl.util.a.o(context);
                        } catch (RuntimeException unused) {
                            com.huawei.secure.android.common.ssl.util.h.d(f35178a, "get files bks error");
                            inputStream = null;
                        }
                        if (inputStream == null) {
                            com.huawei.secure.android.common.ssl.util.h.e(f35178a, "get assets bks");
                            inputStream = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            com.huawei.secure.android.common.ssl.util.h.e(f35178a, "get files bks");
                        }
                        f35179b = new k(inputStream, "");
                    }
                }
            }
            com.huawei.secure.android.common.ssl.util.h.b(f35178a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return f35179b;
        }
        throw new NullPointerException("context is null");
    }
}
