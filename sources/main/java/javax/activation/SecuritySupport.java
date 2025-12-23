package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Enumeration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class SecuritySupport {
    public static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.activation.SecuritySupport.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    public static InputStream getResourceAsStream(final Class cls, final String str) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: javax.activation.SecuritySupport.2
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws IOException {
                    return cls.getResourceAsStream(str);
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getException());
        }
    }

    public static URL[] getResources(final ClassLoader classLoader, final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.activation.SecuritySupport.3
            @Override // java.security.PrivilegedAction
            public Object run() {
                URL[] urlArr = null;
                try {
                    ArrayList arrayList = new ArrayList();
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (resources != null && resources.hasMoreElements()) {
                        URL nextElement = resources.nextElement();
                        if (nextElement != null) {
                            arrayList.add(nextElement);
                        }
                    }
                    if (arrayList.size() > 0) {
                        urlArr = new URL[arrayList.size()];
                        return (URL[]) arrayList.toArray(urlArr);
                    }
                } catch (IOException | SecurityException unused) {
                }
                return urlArr;
            }
        });
    }

    public static URL[] getSystemResources(final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.activation.SecuritySupport.4
            @Override // java.security.PrivilegedAction
            public Object run() {
                URL[] urlArr = null;
                try {
                    ArrayList arrayList = new ArrayList();
                    Enumeration<URL> systemResources = ClassLoader.getSystemResources(str);
                    while (systemResources != null && systemResources.hasMoreElements()) {
                        URL nextElement = systemResources.nextElement();
                        if (nextElement != null) {
                            arrayList.add(nextElement);
                        }
                    }
                    if (arrayList.size() > 0) {
                        urlArr = new URL[arrayList.size()];
                        return (URL[]) arrayList.toArray(urlArr);
                    }
                } catch (IOException | SecurityException unused) {
                }
                return urlArr;
            }
        });
    }

    public static InputStream openStream(final URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: javax.activation.SecuritySupport.5
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws IOException {
                    return url.openStream();
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getException());
        }
    }

    private SecuritySupport() {
    }
}
