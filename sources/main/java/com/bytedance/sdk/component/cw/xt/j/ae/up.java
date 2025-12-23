package com.bytedance.sdk.component.cw.xt.j.ae;

import com.bytedance.sdk.component.cw.xt.j.g.m;
import com.bytedance.sdk.component.cw.xt.v;
import com.bytedance.sdk.component.cw.xt.x;
import com.bytedance.sdk.component.utils.vl;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static final up f26159j = j();
    private static final Logger xt = Logger.getLogger(v.class.getName());

    public String j(SSLSocket sSLSocket) {
        return null;
    }

    public void xt(SSLSocket sSLSocket) {
    }

    public String cw() {
        return "OkHttp";
    }

    public void j(SSLSocket sSLSocket, String str, List<x> list) {
    }

    public boolean xt(String str) {
        return true;
    }

    public static up xt() {
        return f26159j;
    }

    public void j(Socket socket, InetSocketAddress inetSocketAddress, int i6) throws IOException {
        socket.connect(inetSocketAddress, i6);
    }

    static byte[] xt(List<x> list) {
        com.bytedance.sdk.component.cw.j.cw cwVar = new com.bytedance.sdk.component.cw.j.cw();
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            x xVar = list.get(i6);
            if (xVar != x.HTTP_1_0) {
                cwVar.g(xVar.toString().length());
                cwVar.xt(xVar.toString());
            }
        }
        try {
            return cwVar.i();
        } catch (IOException e6) {
            vl.j(e6);
            return null;
        }
    }

    public void j(int i6, String str, Throwable th) {
        xt.log(i6 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object j(String str) {
        if (xt.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void j(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        j(5, str, (Throwable) obj);
    }

    public static List<String> j(List<x> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            x xVar = list.get(i6);
            if (xVar != x.HTTP_1_0) {
                arrayList.add(xVar.toString());
            }
        }
        return arrayList;
    }

    public m xt(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.cw.xt.j.g.xt(x509TrustManager.getAcceptedIssuers());
    }

    public com.bytedance.sdk.component.cw.xt.j.g.cw j(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.cw.xt.j.g.j(xt(x509TrustManager));
    }

    private static up j() {
        up j6 = j.j();
        if (j6 != null) {
            return j6;
        }
        xt j7 = xt.j();
        if (j7 != null) {
            return j7;
        }
        up j8 = cw.j();
        return j8 != null ? j8 : new up();
    }
}
