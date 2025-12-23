package com.beizi.ad.internal.f;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.h.f;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.r;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.a;
import com.beizi.ad.model.c;
import com.beizi.ad.model.e;
import com.beizi.ad.model.f;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends AsyncTask<Void, Integer, c> {

    /* renamed from: b, reason: collision with root package name */
    private static final c f11884b = new c(true);

    /* renamed from: c, reason: collision with root package name */
    public static final String f11885c = f.a("emulator");

    /* renamed from: a, reason: collision with root package name */
    private SoftReference<com.beizi.ad.internal.f> f11886a;

    /* renamed from: d, reason: collision with root package name */
    private final Set<String> f11887d;

    /* renamed from: e, reason: collision with root package name */
    private final Bundle f11888e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<String> f11889f;

    /* renamed from: g, reason: collision with root package name */
    private Date f11890g;

    /* renamed from: h, reason: collision with root package name */
    private String f11891h;

    /* renamed from: i, reason: collision with root package name */
    private int f11892i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11893j;

    /* renamed from: k, reason: collision with root package name */
    private String f11894k;

    /* renamed from: l, reason: collision with root package name */
    private int f11895l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11896m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.f.a$a, reason: collision with other inner class name */
    public static final class C0107a {

        /* renamed from: d, reason: collision with root package name */
        private Date f11900d;

        /* renamed from: e, reason: collision with root package name */
        private String f11901e;

        /* renamed from: h, reason: collision with root package name */
        private String f11904h;

        /* renamed from: j, reason: collision with root package name */
        private boolean f11906j;

        /* renamed from: a, reason: collision with root package name */
        private final HashSet<String> f11897a = new HashSet<>();

        /* renamed from: b, reason: collision with root package name */
        private final Bundle f11898b = new Bundle();

        /* renamed from: c, reason: collision with root package name */
        private final HashSet<String> f11899c = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        private int f11902f = -1;

        /* renamed from: g, reason: collision with root package name */
        private boolean f11903g = false;

        /* renamed from: i, reason: collision with root package name */
        private int f11905i = -1;

        public void a(String str) {
            this.f11899c.add(str);
        }

        public com.beizi.ad.b.a a() {
            return new com.beizi.ad.b.a(this.f11900d, this.f11902f, this.f11897a, false);
        }
    }

    protected a() {
        this.f11887d = new HashSet();
        this.f11888e = null;
        this.f11889f = new HashSet();
    }

    private boolean b(int i6) {
        return i6 == 200;
    }

    public void a(com.beizi.ad.internal.f fVar) {
        this.f11886a = new SoftReference<>(fVar);
        e c6 = fVar.c();
        if (c6 == null || c6.b() == null) {
            a(0);
            cancel(true);
        } else {
            if (d.a(StubApp.getOrigApplicationContext(c6.b().getApplicationContext())).b(c6.b())) {
                return;
            }
            a(2);
            cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @TargetApi(11)
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onCancelled(c cVar) {
        super.onCancelled(cVar);
    }

    public a(C0107a c0107a) {
        this.f11890g = c0107a.f11900d;
        this.f11891h = c0107a.f11901e;
        this.f11892i = c0107a.f11902f;
        this.f11887d = Collections.unmodifiableSet(c0107a.f11897a);
        this.f11888e = c0107a.f11898b;
        this.f11889f = Collections.unmodifiableSet(c0107a.f11899c);
        this.f11893j = c0107a.f11903g;
        this.f11894k = c0107a.f11904h;
        this.f11895l = c0107a.f11905i;
        this.f11896m = c0107a.f11906j;
    }

    private void a(int i6) {
        com.beizi.ad.internal.f fVar = this.f11886a.get();
        if (fVar != null) {
            fVar.a(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c doInBackground(Void... voidArr) {
        e c6;
        com.beizi.ad.internal.f fVar = this.f11886a.get();
        if (fVar == null || (c6 = fVar.c()) == null) {
            return null;
        }
        try {
            boolean z5 = c6.i() == k.PREFETCH;
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
            a.b.C0122a c7 = new a.b.C0122a().a(a7.z()).a(f.i.SRC_APP).c(a7.y()).a(z5 ? f.g.REQ_WIFI_PRELOAD : f.g.REQ_AD).a(q.c()).b(a6.d()).a(a8).a(aVar.a()).d(a7.C()).b(a7.A()).c(a7.B());
            if (z5) {
                for (String str : h.a().k()) {
                    if (!o.a(str)) {
                        c7.a(new a.C0120a.C0121a().a(str).c(c6.a()).a());
                    }
                }
            } else {
                c7.a(new a.C0120a.C0121a().a(c6.c()).c(c6.a()).b(c6.k()).a());
            }
            a.b a10 = c7.a();
            byte[] bytes = com.beizi.ad.lance.a.a.a(l.a(), a10.toString()).getBytes();
            m.d("lance", "sdkRequest:" + a10.toString());
            String l6 = h.a().l();
            m.d("lance", "getRequestBaseUrl:" + l6);
            HttpURLConnection a11 = a(new URL(l6));
            a(a11, bytes);
            a11.connect();
            if (!b(a11.getResponseCode())) {
                return f11884b;
            }
            a11.getContentLength();
            InputStream inputStream = a11.getInputStream();
            String a12 = c.l.a(inputStream);
            inputStream.close();
            return new c(a12, a11.getHeaderFields(), c6.i());
        } catch (IOException unused) {
            return f11884b;
        } catch (IllegalArgumentException unused2) {
            return f11884b;
        } catch (SecurityException unused3) {
            return f11884b;
        } catch (MalformedURLException unused4) {
            return f11884b;
        } catch (Exception e6) {
            e6.printStackTrace();
            return f11884b;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(c cVar) {
        if (cVar == null) {
            a(2);
            return;
        }
        if (cVar.i()) {
            a(2);
            return;
        }
        com.beizi.ad.internal.f fVar = this.f11886a.get();
        if (fVar != null) {
            fVar.a(cVar);
        }
    }
}
