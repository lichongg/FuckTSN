package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.m;
import java.security.cert.X509Certificate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35188a = "WebViewSSLCheck";

    public static void a(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        b(sslErrorHandler, sslError, null, context, null);
    }

    public static void b(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, m.a aVar) {
        String str2 = f35188a;
        com.huawei.secure.android.common.ssl.util.h.e(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate a6 = com.huawei.secure.android.common.ssl.util.e.a(sslError.getCertificate());
        X509Certificate a7 = new com.huawei.secure.android.common.ssl.util.k(context).a();
        com.huawei.secure.android.common.ssl.util.h.b(str2, "checkServerCertificateNew: error certificate is : " + a6);
        if (com.huawei.secure.android.common.ssl.util.e.e(a7, a6)) {
            com.huawei.secure.android.common.ssl.util.h.e(str2, "checkServerCertificateNew: proceed");
            if (aVar != null) {
                aVar.b(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        com.huawei.secure.android.common.ssl.util.h.d(str2, "checkServerCertificateNew: cancel");
        if (aVar != null) {
            aVar.a(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean c(String str, SslError sslError) {
        return d(com.huawei.secure.android.common.ssl.util.e.b(str), sslError);
    }

    public static boolean d(X509Certificate x509Certificate, SslError sslError) {
        return com.huawei.secure.android.common.ssl.util.e.e(x509Certificate, com.huawei.secure.android.common.ssl.util.e.a(sslError.getCertificate()));
    }
}
