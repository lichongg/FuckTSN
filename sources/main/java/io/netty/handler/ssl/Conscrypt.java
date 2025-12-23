package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE = loadIsConscryptEngine();

    private static boolean isConscryptEngine(SSLEngine sSLEngine) {
        try {
            return ((Boolean) IS_CONSCRYPT_SSLENGINE.invoke(null, sSLEngine)).booleanValue();
        } catch (IllegalAccessException unused) {
            return false;
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    static boolean isAvailable() {
        return IS_CONSCRYPT_SSLENGINE != null && PlatformDependent.javaVersion() >= 8;
    }

    private static Method loadIsConscryptEngine() {
        try {
            return Class.forName("org.conscrypt.Conscrypt", true, ConscryptAlpnSslEngine.class.getClassLoader()).getMethod("isConscrypt", SSLEngine.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    private Conscrypt() {
    }

    static boolean isEngineSupported(SSLEngine sSLEngine) {
        if (isAvailable() && isConscryptEngine(sSLEngine)) {
            return true;
        }
        return false;
    }
}
