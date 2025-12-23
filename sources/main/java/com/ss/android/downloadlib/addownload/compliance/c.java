package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.umeng.analytics.pro.bi;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import w2.q;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f37664a;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o.i f37665a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.downloadlib.addownload.compliance.d f37666b;

        a(o.i iVar, com.ss.android.downloadlib.addownload.compliance.d dVar) {
            this.f37665a = iVar;
            this.f37666b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.o(this.f37665a, cVar.m(), c.this.l(this.f37665a, true, 4), this.f37666b);
        }
    }

    class b implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o.i f37668a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.downloadlib.addownload.compliance.d f37669b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f37670c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f37671d;

        @Override // w2.q
        public void j(String str) {
            c.this.h(this.f37668a, str, this.f37669b);
        }

        b(o.i iVar, com.ss.android.downloadlib.addownload.compliance.d dVar, String str, byte[] bArr) {
            this.f37668a = iVar;
            this.f37669b = dVar;
            this.f37670c = str;
            this.f37671d = bArr;
        }

        @Override // w2.q
        public void j(Throwable th) {
            c.this.i(this.f37668a, this.f37670c, this.f37671d, this.f37669b);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.c$c, reason: collision with other inner class name */
    class RunnableC0744c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37673a;

        RunnableC0744c(String str) {
            this.f37673a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.d().j(6, m.getContext(), null, this.f37673a, null, 0);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private static c f37675a = new c(null);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    private c() {
        this.f37664a = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(o.i iVar, String str, byte[] bArr, com.ss.android.downloadlib.addownload.compliance.d dVar) {
        if (this.f37664a.get() < 6) {
            this.f37664a.incrementAndGet();
            o(iVar, str, bArr, dVar);
        } else {
            j("当前网络不佳，请稍后再试");
            this.f37664a.set(0);
            c(402, iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] l(o.i iVar, boolean z5, int i6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", iVar.j());
            jSONObject.put(bi.f40972o, iVar.up());
            jSONObject.put("call_scene", 50);
            if (z5) {
                jSONObject.put("sender_package_name", m.getContext().getPackageName());
                jSONObject.put("sender_version", m.z().f38271e);
                if (i6 > 0) {
                    jSONObject.put("store", i6);
                }
            } else {
                jSONObject.put("id", String.valueOf(iVar.xt()));
                if (iVar.tj().l() != null) {
                    if (TextUtils.isEmpty(iVar.tj().l().b())) {
                        com.ss.android.downloadlib.up.a.a().c("web_url is null");
                    }
                    jSONObject.put("web_url", iVar.tj().l().b());
                } else {
                    com.ss.android.downloadlib.up.a.a().c("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.up.a.a().c("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37664a.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb.append("/customer/api/app/deep_link");
        return sb.toString();
    }

    public void c(int i6, o.i iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i6));
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().r("get_miui_market_compliance_error", jSONObject, iVar);
    }

    public void d(int i6, o.i iVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i6));
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().r("get_miui_market_compliance_success", jSONObject, iVar);
    }

    public static c a() {
        return d.f37675a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(@NonNull o.i iVar, String str, com.ss.android.downloadlib.addownload.compliance.d dVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.up.a.a().c("response content is null");
                c(404, iVar);
                dVar.j();
                return;
            }
            this.f37664a.set(0);
            e a6 = e.a(str);
            if (a6.e() != 0) {
                c(403, iVar);
                dVar.j();
            } else if (TextUtils.isEmpty(a6.u())) {
                c(405, iVar);
                dVar.j();
            } else {
                dVar.j(a6.u());
            }
        } catch (Exception e6) {
            com.ss.android.downloadlib.up.a.a().j(e6, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    private void j(String str) {
        com.ss.android.downloadlib.c.d().s().post(new RunnableC0744c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(@NonNull o.i iVar, String str, byte[] bArr, com.ss.android.downloadlib.addownload.compliance.d dVar) {
        m.B().j(str, bArr, "application/json; charset=utf-8", 0, new b(iVar, dVar, str, bArr));
    }

    public void g(o.i iVar, com.ss.android.downloadlib.addownload.compliance.d dVar) {
        if (m.B() == null) {
            com.ss.android.downloadlib.up.a.a().c("getDownloadNetworkFactory == NULL");
            c(401, iVar);
        } else {
            com.ss.android.downloadlib.e.c().d(new a(iVar, dVar));
        }
    }
}
