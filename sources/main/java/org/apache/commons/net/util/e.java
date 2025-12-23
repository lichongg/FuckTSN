package org.apache.commons.net.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {
    public static boolean a(SSLSocket sSLSocket) {
        Object invoke;
        try {
            Class<?> cls = Class.forName("javax.net.ssl.SSLParameters");
            Method declaredMethod = cls.getDeclaredMethod("setEndpointIdentificationAlgorithm", String.class);
            Method declaredMethod2 = SSLSocket.class.getDeclaredMethod("getSSLParameters", null);
            Method declaredMethod3 = SSLSocket.class.getDeclaredMethod("setSSLParameters", cls);
            if (declaredMethod != null && declaredMethod2 != null && declaredMethod3 != null && (invoke = declaredMethod2.invoke(sSLSocket, null)) != null) {
                declaredMethod.invoke(invoke, "HTTPS");
                declaredMethod3.invoke(sSLSocket, invoke);
                return true;
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
        }
        return false;
    }

    private e() {
    }
}
