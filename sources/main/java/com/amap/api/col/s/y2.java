package com.amap.api.col.s;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.s.y0;
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
public final class y2 extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f8771a;

    /* renamed from: b, reason: collision with root package name */
    private Context f8772b;

    /* renamed from: c, reason: collision with root package name */
    private SSLContext f8773c;

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z5;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f8771a;
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
            if (!y0.g.f8762b || !(socket instanceof SSLSocket)) {
                return socket;
            }
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            return socket;
        } catch (Throwable th) {
            g2.o(th, "myssl", "stlv2");
            return socket;
        }
    }

    private void c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f8773c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(j1.t("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String t5 = j1.t("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(t5)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            g2.o(th, "myssl", "isc2");
        }
    }

    private static void d(Socket socket) {
        int i6 = Build.VERSION.SDK_INT;
        if (y0.g.f8763c && y0.g.f8765e && (socket instanceof SSLSocket)) {
            int i7 = y0.g.f8766f;
            int i8 = y0.g.f8764d;
            if (i7 <= i8) {
                i8 = y0.g.f8766f;
            }
            if (i8 <= 17 || i6 <= i8) {
                try {
                    socket.getClass().getMethod(j1.t("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    g2.o(th, "myssl", "sust");
                }
            }
        }
    }

    public final void b() {
        int i6 = Build.VERSION.SDK_INT;
        if (!y0.g.f8763c || this.f8772b == null || this.f8773c == null) {
            return;
        }
        int i7 = y0.g.f8764d;
        if (i7 <= 17 || i6 <= i7) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f8772b);
            if (i6 >= 28) {
                c(sSLSessionCache);
                return;
            }
            try {
                sSLSessionCache.getClass().getMethod(j1.t("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f8773c);
            } catch (Throwable th) {
                g2.o(th, "myssl", "isc1");
                c(sSLSessionCache);
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f8771a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            g2.o(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f8771a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            g2.o(th, "myssl", "gscs");
        }
        return new String[0];
    }

    public y2(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.f8772b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } catch (Throwable th) {
                try {
                    g2.o(th, "myssl", "<init>");
                    try {
                        if (this.f8773c == null) {
                            this.f8773c = SSLContext.getDefault();
                        }
                    } catch (Throwable th2) {
                        g2.o(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.f8771a == null) {
                            this.f8771a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        g2.o(th3, "myssl", "<init3>");
                        return;
                    }
                } finally {
                }
            }
        }
        this.f8773c = sSLContext;
        if (sSLContext != null) {
            this.f8771a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f8773c == null) {
                this.f8773c = SSLContext.getDefault();
            }
        } catch (Throwable th4) {
            g2.o(th4, "myssl", "<init2>");
        }
        try {
            if (this.f8771a == null) {
                this.f8771a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th5) {
            g2.o(th5, "myssl", "<init3>");
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i6, boolean z5) throws IOException {
        boolean z6;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f8771a;
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
            SSLSocketFactory sSLSocketFactory = this.f8771a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket(str, i6));
            d(a6);
            return a6;
        } catch (Throwable th) {
            g2.o(th, "myssl", "cs3");
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
            SSLSocketFactory sSLSocketFactory = this.f8771a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a6 = a(sSLSocketFactory.createSocket(str, i6, inetAddress, i7));
            d(a6);
            return a6;
        } catch (Throwable th) {
            g2.o(th, "myssl", "cs4");
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
            SSLSocketFactory sSLSocketFactory = this.f8771a;
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
            SSLSocketFactory sSLSocketFactory = this.f8771a;
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
