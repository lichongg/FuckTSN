package com.bytedance.sdk.component.cw.xt.j.ae;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.acse.ottn.l3;
import com.bytedance.sdk.component.cw.xt.j.g.m;
import com.bytedance.sdk.component.cw.xt.x;
import com.bytedance.sdk.component.utils.vl;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\Downloads\app\classes4.dex */
class j extends up {
    private final r<Socket> cw;

    /* renamed from: j, reason: collision with root package name */
    private final Class<?> f26152j;

    /* renamed from: m, reason: collision with root package name */
    private final cw f26153m = cw.j();

    /* renamed from: r, reason: collision with root package name */
    private final r<Socket> f26154r;
    private final r<Socket> up;
    private final r<Socket> xt;

    /* renamed from: com.bytedance.sdk.component.cw.xt.j.ae.j$j, reason: collision with other inner class name */
    static final class C0406j extends com.bytedance.sdk.component.cw.xt.j.g.cw {

        /* renamed from: j, reason: collision with root package name */
        private final Object f26156j;
        private final Method xt;

        public int hashCode() {
            return 0;
        }

        public boolean equals(Object obj) {
            return obj instanceof C0406j;
        }

        C0406j(Object obj, Method method) {
            this.f26156j = obj;
            this.xt = method;
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.g.cw
        public List<Certificate> j(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.xt.invoke(this.f26156j, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (InvocationTargetException e7) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e7.getMessage());
                sSLPeerUnverifiedException.initCause(e7);
                throw sSLPeerUnverifiedException;
            }
        }
    }

    static final class xt implements m {

        /* renamed from: j, reason: collision with root package name */
        private final X509TrustManager f26157j;
        private final Method xt;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof xt)) {
                return false;
            }
            xt xtVar = (xt) obj;
            return this.f26157j.equals(xtVar.f26157j) && this.xt.equals(xtVar.xt);
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.g.m
        public X509Certificate j(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.xt.invoke(this.f26157j, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e6) {
                throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to get issues and signature", (Exception) e6);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public int hashCode() {
            return this.f26157j.hashCode() + (this.xt.hashCode() * 31);
        }

        xt(X509TrustManager x509TrustManager, Method method) {
            this.xt = method;
            this.f26157j = x509TrustManager;
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public void j(Socket socket, InetSocketAddress inetSocketAddress, int i6) throws IOException {
        try {
            socket.connect(inetSocketAddress, i6);
        } catch (AssertionError e6) {
            if (!com.bytedance.sdk.component.cw.xt.j.cw.j(e6)) {
                throw e6;
            }
            throw new IOException(e6);
        } catch (ClassCastException e7) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e7;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e7);
            throw iOException;
        } catch (SecurityException e8) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e8);
            throw iOException2;
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public boolean xt(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return j(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.xt(str);
        } catch (IllegalAccessException e6) {
            e = e6;
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e7) {
            e = e7;
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            if (Build.VERSION.SDK_INT < 23) {
                return super.xt(str);
            }
            return false;
        } catch (InvocationTargetException e8) {
            e = e8;
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to determine cleartext support", e);
        }
    }

    static final class cw {
        private final Method cw;

        /* renamed from: j, reason: collision with root package name */
        private final Method f26155j;
        private final Method xt;

        Object j(String str) {
            Method method = this.f26155j;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, null);
                    this.xt.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        cw(Method method, Method method2, Method method3) {
            this.f26155j = method;
            this.xt = method2;
            this.cw = method3;
        }

        boolean j(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.cw.invoke(obj, null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static cw j() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod(l3.f4736f, null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new cw(method3, method2, method);
        }
    }

    private static boolean r() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    j(Class<?> cls, r<Socket> rVar, r<Socket> rVar2, r<Socket> rVar3, r<Socket> rVar4) {
        this.f26152j = cls;
        this.xt = rVar;
        this.cw = rVar2;
        this.f26154r = rVar3;
        this.up = rVar4;
    }

    private boolean xt(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.xt(str);
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public void j(SSLSocket sSLSocket, String str, List<x> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    d.a();
                    SNIHostName a6 = c.a(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(a6));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable unused) {
                }
            } else {
                this.xt.xt(sSLSocket, Boolean.TRUE);
                this.cw.xt(sSLSocket, str);
            }
        }
        r<Socket> rVar = this.up;
        if (rVar == null || !rVar.j((r<Socket>) sSLSocket)) {
            return;
        }
        this.up.r(sSLSocket, up.xt(list));
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public m xt(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new xt(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.xt(x509TrustManager);
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public String j(SSLSocket sSLSocket) {
        byte[] bArr;
        r<Socket> rVar = this.f26154r;
        if (rVar == null || !rVar.j((r<Socket>) sSLSocket) || (bArr = (byte[]) this.f26154r.r(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.component.cw.xt.j.cw.up);
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public void j(int i6, String str, Throwable th) {
        int min;
        int i7 = i6 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i8 = 0;
        while (i8 < length) {
            int indexOf = str.indexOf(10, i8);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i8 + 4000);
                vl.j(i7, "OkHttp", str.substring(i8, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i8 = min;
                }
            }
            i8 = min + 1;
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public Object j(String str) {
        return this.f26153m.j(str);
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public void j(String str, Object obj) {
        if (this.f26153m.j(obj)) {
            return;
        }
        j(5, str, (Throwable) null);
    }

    private boolean j(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return xt(str, cls, obj);
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public com.bytedance.sdk.component.cw.xt.j.g.cw j(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0406j(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.j(x509TrustManager);
        }
    }

    public static up j() {
        Class<?> cls;
        r rVar;
        r rVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            r rVar3 = new r(null, "setUseSessionTickets", Boolean.TYPE);
            r rVar4 = new r(null, "setHostname", String.class);
            if (r()) {
                r rVar5 = new r(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                rVar2 = new r(null, "setAlpnProtocols", byte[].class);
                rVar = rVar5;
            } else {
                rVar = null;
                rVar2 = null;
            }
            return new j(cls2, rVar3, rVar4, rVar, rVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
