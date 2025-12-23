package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.baidu.mobads.sdk.internal.by;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35136a = "SSLUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35137b = "TLSv1.3";

    /* renamed from: c, reason: collision with root package name */
    private static final String f35138c = "TLSv1.2";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35139d = "TLS";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35140e = "TLSv1";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f35141f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f35142g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f35143h = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", by.f10823a, "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static boolean e(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = strArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    arrayList.add(str);
                    break;
                }
                if (upperCase.contains(strArr[i6].toUpperCase(Locale.ENGLISH))) {
                    break;
                }
                i6++;
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean h(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e6) {
                com.huawei.secure.android.common.ssl.util.h.d(f35136a, "setEnabledProtocols: exception : " + e6.getMessage());
            }
        }
        return false;
    }

    public static boolean l(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean d(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return e(sSLSocket, f35143h);
    }

    public static void f(SSLSocket sSLSocket) {
        if (sSLSocket == null || k(sSLSocket)) {
            return;
        }
        d(sSLSocket);
    }

    public static void g(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{f35137b, f35138c});
        }
        if (i6 < 29) {
            sSLSocket.setEnabledProtocols(new String[]{f35138c});
        }
    }

    public static SSLContext i() throws NoSuchAlgorithmException {
        return Build.VERSION.SDK_INT >= 29 ? SSLContext.getInstance(f35137b) : SSLContext.getInstance(f35138c);
    }

    public static void j(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        g(sSLSocket);
        f(sSLSocket);
    }

    public static boolean k(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return l(sSLSocket, f35142g);
    }

    public static String[] a(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] b(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void c(SSLSocket sSLSocket) {
        for (String str : sSLSocket.getEnabledProtocols()) {
            com.huawei.secure.android.common.ssl.util.h.e(f35136a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            com.huawei.secure.android.common.ssl.util.h.e(f35136a, "new cipher suites is : " + str2);
        }
    }
}
