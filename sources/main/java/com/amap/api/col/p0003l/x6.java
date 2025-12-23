package com.amap.api.col.p0003l;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.p0003l.g4;
import com.stub.StubApp;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x6 extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f7669a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7670b;

    /* renamed from: c, reason: collision with root package name */
    private SSLContext f7671c;

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z5;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket());
            d(a6);
            return a6;
        } finally {
            if (!z5) {
            }
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (!g4.g.f6342b || !(socket instanceof SSLSocket)) {
                return socket;
            }
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            return socket;
        } catch (Throwable th) {
            v5.p(th, "myssl", "stlv2");
            return socket;
        }
    }

    private void c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f7671c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(q4.u("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String u5 = q4.u("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(u5)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            v5.p(th, "myssl", "isc2");
        }
    }

    private static void d(Socket socket) {
        int i6 = Build.VERSION.SDK_INT;
        if (g4.g.f6343c && g4.g.f6345e && (socket instanceof SSLSocket)) {
            int i7 = g4.g.f6346f;
            int i8 = g4.g.f6344d;
            if (i7 <= i8) {
                i8 = g4.g.f6346f;
            }
            if (i8 <= 17 || i6 <= i8) {
                try {
                    socket.getClass().getMethod(q4.u("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    v5.p(th, "myssl", "sust");
                }
            }
        }
    }

    public final void b() {
        int i6 = Build.VERSION.SDK_INT;
        if (!g4.g.f6343c || this.f7670b == null || this.f7671c == null) {
            return;
        }
        int i7 = g4.g.f6344d;
        if (i7 <= 17 || i6 <= i7) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f7670b);
            if (i6 >= 28) {
                c(sSLSessionCache);
                return;
            }
            try {
                sSLSessionCache.getClass().getMethod(q4.u("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f7671c);
            } catch (Throwable th) {
                v5.p(th, "myssl", "isc1");
                c(sSLSessionCache);
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            v5.p(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            v5.p(th, "myssl", "gscs");
        }
        return new String[0];
    }

    public x6(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.f7670b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } catch (Throwable th) {
                try {
                    v5.p(th, "myssl", "<init>");
                    try {
                        if (this.f7671c == null) {
                            this.f7671c = SSLContext.getDefault();
                        }
                    } catch (Throwable th2) {
                        v5.p(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.f7669a == null) {
                            this.f7669a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        v5.p(th3, "myssl", "<init3>");
                        return;
                    }
                } finally {
                }
            }
        }
        this.f7671c = sSLContext;
        if (sSLContext != null) {
            this.f7669a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f7671c == null) {
                this.f7671c = SSLContext.getDefault();
            }
        } catch (Throwable th4) {
            v5.p(th4, "myssl", "<init2>");
        }
        try {
            if (this.f7669a == null) {
                this.f7669a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th5) {
            v5.p(th5, "myssl", "<init3>");
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        boolean z6;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket(socket, str, i6, z5));
            d(a6);
            return a6;
        } finally {
            if (!z6) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i6) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket(str, i6));
            d(a6);
            return a6;
        } catch (Throwable th) {
            v5.p(th, "myssl", "cs3");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i6, InetAddress inetAddress, int i7) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket(str, i6, inetAddress, i7));
            d(a6);
            return a6;
        } catch (Throwable th) {
            v5.p(th, "myssl", "cs4");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i6) throws IOException {
        boolean z5;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket(inetAddress, i6));
            d(a6);
            return a6;
        } finally {
            if (!z5) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws IOException {
        boolean z5;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f7669a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket(inetAddress, i6, inetAddress2, i7));
            d(a6);
            return a6;
        } finally {
            if (!z5) {
            }
        }
    }
}
