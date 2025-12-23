package com.beizi.ad.v2.e;

import android.text.TextUtils;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.h.r;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.a;
import com.beizi.ad.model.c;
import com.beizi.ad.model.e;
import com.beizi.ad.model.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    private boolean a(int i6) {
        return i6 == 200;
    }

    public void a(com.beizi.ad.model.b bVar, a aVar) {
        if (bVar == null || aVar == null) {
            return;
        }
        try {
            String l6 = h.a().l();
            m.d("lance", "getRequestBaseUrl:" + l6);
            HttpURLConnection a6 = a(new URL(l6));
            byte[] b6 = b(bVar);
            if (b6 == null) {
                aVar.a(4);
                return;
            }
            a(a6, b6);
            a6.connect();
            if (!a(a6.getResponseCode())) {
                aVar.a(2);
                return;
            }
            InputStream inputStream = a6.getInputStream();
            String a7 = c.l.a(inputStream);
            inputStream.close();
            if (TextUtils.isEmpty(a7)) {
                aVar.a(3);
            } else {
                aVar.a(a7);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private byte[] b(com.beizi.ad.model.b bVar) {
        String a6 = a(bVar);
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        return a6.getBytes();
    }

    public String a(com.beizi.ad.model.b bVar) {
        h a6 = h.a();
        com.beizi.ad.internal.h.a a7 = com.beizi.ad.internal.h.a.a();
        e.a a8 = new e.a.C0126a().a(a7.d()).j(a7.e()).l(a7.w()).m(a7.x()).n(a7.b()).b("").c(a7.r()).a(f.e.PLATFORM_ANDROID).a(a7.n()).d(a7.s()).e(a7.t()).f(a7.u()).g(a7.g()).h(a7.h()).i(a7.v()).k(a7.f()).o(a7.k()).a(a7.m()).p(a7.p()).q(a7.q()).r(a7.o()).s(a7.i()).t(a7.j()).u(a7.l()).v(a7.c()).a(h.a().o()).w(a7.D()).x(a7.E()).a();
        r a9 = r.a();
        a9.d();
        e.c.a aVar = new e.c.a();
        aVar.a(a9.b());
        aVar.a(a9.c());
        if (!TextUtils.isEmpty(a9.f12144b) && !TextUtils.isEmpty(a9.f12145c)) {
            aVar.a(new e.b.a().b(a9.f12145c).a(a9.f12144b).c(a9.f12146d).a(a9.f12147e).a());
        }
        a.b.C0122a c6 = new a.b.C0122a().a(a7.z()).a(f.i.SRC_APP).a(f.g.REQ_AD).a(q.c()).b(a6.d()).a(a8).a(aVar.a()).c(a7.y()).d(a7.C()).b(a7.A()).c(a7.B());
        a.C0120a.C0121a c0121a = new a.C0120a.C0121a();
        if (bVar != null) {
            c0121a.a(bVar.a());
            c0121a.c(bVar.c());
            if (bVar.b()) {
                c0121a.a(1);
            } else {
                c0121a.a(0);
            }
            c0121a.a(bVar.d());
        }
        c6.a(c0121a.a());
        a.b a10 = c6.a();
        String a11 = com.beizi.ad.lance.a.a.a(l.a(), a10.toString());
        m.d("lance", "sdkRequest:" + a10.toString());
        return a11;
    }

    private HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("User-Agent", h.a().f12000e);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        String a6 = x.a();
        if (!TextUtils.isEmpty(a6)) {
            httpURLConnection.setRequestProperty("Cookie", a6);
        }
        httpURLConnection.setRequestProperty("Connect-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public String a(String str, boolean z5) {
        com.beizi.ad.internal.h.a a6 = com.beizi.ad.internal.h.a.a();
        e.a a7 = new e.a.C0126a().a(a6.d()).j(a6.e()).l(a6.w()).m(a6.x()).n(a6.b()).b("").c(a6.r()).a(f.e.PLATFORM_ANDROID).a(a6.n()).d(a6.s()).e(a6.t()).f(a6.u()).g(a6.g()).h(a6.h()).i(a6.v()).k(a6.f()).o(a6.k()).a(a6.m()).p(a6.p()).q(a6.q()).r(a6.o()).s(a6.i()).t(a6.j()).u(a6.l()).v(a6.c()).a(h.a().o()).w(a6.D()).x(a6.E()).a();
        r a8 = r.a();
        a8.d();
        e.c.a aVar = new e.c.a();
        aVar.a(a8.b());
        aVar.a(a8.c());
        if (!TextUtils.isEmpty(a8.f12144b) && !TextUtils.isEmpty(a8.f12145c)) {
            aVar.a(new e.b.a().b(a8.f12145c).a(a8.f12144b).c(a8.f12146d).a(a8.f12147e).a());
        }
        a.b.C0122a c6 = new a.b.C0122a().a(a6.z()).a(f.i.SRC_APP).a(f.g.REQ_AD).a(q.c()).a(a7).a(aVar.a()).c(a6.y()).d(a6.C()).b(a6.A()).c(a6.B());
        c6.a(new a.C0120a.C0121a().c(str).a(z5 ? 1 : 0).a());
        a.b a9 = c6.a();
        String a10 = com.beizi.ad.lance.a.a.a(l.a(), a9.toString());
        m.d("lance", "sdkRequest:" + a9.toString());
        return a10;
    }
}
