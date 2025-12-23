package com.sun.mail.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocketFetcher {
    /* JADX WARN: Can't wrap try/catch for region: R(24:0|(1:2)(1:80)|(1:4)(1:79)|5|(19:74|75|76|8|(1:10)(1:73)|11|(3:68|69|70)|13|14|(1:67)(1:18)|19|20|21|(7:23|(6:47|48|(1:27)(1:46)|28|29|30)|25|(0)(0)|28|29|30)|(1:52)|(2:58|59)|(1:55)|56|57)|7|8|(0)(0)|11|(0)|13|14|(1:16)|67|19|20|21|(0)|(0)|(0)|(0)|56|57|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ce, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4 A[Catch: Exception -> 0x00cd, SocketTimeoutException -> 0x0149, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cd, blocks: (B:21:0x00ae, B:23:0x00b4, B:48:0x00c8), top: B:20:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.Socket getSocket(java.lang.String r15, int r16, java.util.Properties r17, java.lang.String r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.getSocket(java.lang.String, int, java.util.Properties, java.lang.String, boolean):java.net.Socket");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static javax.net.SocketFactory getSocketFactory(java.lang.String r2) throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r0 = 0
            if (r2 == 0) goto L2f
            int r1 = r2.length()
            if (r1 != 0) goto La
            goto L2f
        La:
            java.lang.ClassLoader r1 = getContextClassLoader()
            if (r1 == 0) goto L16
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.ClassNotFoundException -> L15
            goto L17
        L15:
        L16:
            r1 = r0
        L17:
            if (r1 != 0) goto L1d
            java.lang.Class r1 = java.lang.Class.forName(r2)
        L1d:
            java.lang.String r2 = "getDefault"
            java.lang.reflect.Method r2 = r1.getMethod(r2, r0)
            java.lang.Object r1 = new java.lang.Object
            r1.<init>()
            java.lang.Object r2 = r2.invoke(r1, r0)
            javax.net.SocketFactory r2 = (javax.net.SocketFactory) r2
            return r2
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.getSocketFactory(java.lang.String):javax.net.SocketFactory");
    }

    public static Socket startTLS(Socket socket) throws IOException {
        return startTLS(socket, new Properties(), "socket");
    }

    private static void configureSSLSocket(Socket socket, Properties properties, String str) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String property = properties.getProperty(String.valueOf(str) + ".ssl.protocols", null);
            if (property != null) {
                sSLSocket.setEnabledProtocols(stringArray(property));
            } else {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
            String property2 = properties.getProperty(String.valueOf(str) + ".ssl.ciphersuites", null);
            if (property2 != null) {
                sSLSocket.setEnabledCipherSuites(stringArray(property2));
            }
        }
    }

    private static Socket createSocket(InetAddress inetAddress, int i6, String str, int i7, int i8, SocketFactory socketFactory, boolean z5) throws IOException {
        Socket createSocket = socketFactory != null ? socketFactory.createSocket() : z5 ? SSLSocketFactory.getDefault().createSocket() : new Socket();
        if (inetAddress != null) {
            createSocket.bind(new InetSocketAddress(inetAddress, i6));
        }
        if (i8 >= 0) {
            createSocket.connect(new InetSocketAddress(str, i7), i8);
            return createSocket;
        }
        createSocket.connect(new InetSocketAddress(str, i7));
        return createSocket;
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: com.sun.mail.util.SocketFetcher.1
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

    public static Socket startTLS(Socket socket, Properties properties, String str) throws IOException {
        String hostName = socket.getInetAddress().getHostName();
        int port = socket.getPort();
        try {
            SocketFactory socketFactory = getSocketFactory(properties.getProperty(String.valueOf(str) + ".socketFactory.class", null));
            Socket createSocket = ((socketFactory == null || !(socketFactory instanceof SSLSocketFactory)) ? (SSLSocketFactory) SSLSocketFactory.getDefault() : (SSLSocketFactory) socketFactory).createSocket(socket, hostName, port, true);
            configureSSLSocket(createSocket, properties, str);
            return createSocket;
        } catch (Exception e6) {
            e = e6;
            if (e instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e).getTargetException();
                if (targetException instanceof Exception) {
                    e = (Exception) targetException;
                }
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            IOException iOException = new IOException("Exception in startTLS: host " + hostName + ", port " + port + "; Exception: " + e);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private static String[] stringArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private SocketFetcher() {
    }

    public static Socket getSocket(String str, int i6, Properties properties, String str2) throws IOException {
        return getSocket(str, i6, properties, str2, false);
    }
}
