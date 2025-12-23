package com.ss.android.downloadlib.addownload;

import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.impls.w;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.j.c f37602a;

    /* renamed from: b, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.j.a f37603b;

    static class a implements com.ss.android.downloadlib.addownload.j.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37604a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f37605b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37606c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j.o f37607d;

        @Override // com.ss.android.downloadlib.addownload.j.c
        public void j() {
            b.c(null);
            cw tl = ae.xt(m.getContext()).tl(this.f37604a);
            if (tl != null) {
                tl.xq();
                w.j().j(tl);
                if (this.f37605b) {
                    com.ss.android.downloadlib.r.b.a().m("cancel_pause_reserve_wifi_confirm", this.f37606c);
                } else {
                    com.ss.android.downloadlib.r.b.a().w("pause_reserve_wifi_confirm", this.f37606c);
                }
            }
            this.f37607d.a(this.f37606c);
        }

        @Override // com.ss.android.downloadlib.addownload.j.c
        public void xt() {
            b.c(null);
            cw tl = ae.xt(m.getContext()).tl(this.f37604a);
            if (tl != null) {
                tl.k();
            }
            if (this.f37605b) {
                com.ss.android.downloadlib.r.b.a().m("cancel_pause_reserve_wifi_cancel", this.f37606c);
            } else {
                com.ss.android.downloadlib.r.b.a().w("pause_reserve_wifi_cancel", this.f37606c);
            }
            this.f37607d.a(this.f37606c);
        }

        a(int i6, boolean z5, com.ss.android.xt.j.xt.b bVar, j.o oVar) {
            this.f37604a = i6;
            this.f37605b = z5;
            this.f37606c = bVar;
            this.f37607d = oVar;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.b$b, reason: collision with other inner class name */
    static class C0741b implements com.ss.android.downloadlib.addownload.j.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37608a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.downloadlib.addownload.j.a f37609b;

        C0741b(com.ss.android.xt.j.xt.b bVar, com.ss.android.downloadlib.addownload.j.a aVar) {
            this.f37608a = bVar;
            this.f37609b = aVar;
        }

        @Override // com.ss.android.downloadlib.addownload.j.a
        public void delete() {
            com.ss.android.downloadlib.r.b.a().m("cancel_pause_reserve_wifi_delete", this.f37608a);
            this.f37609b.delete();
        }
    }

    public static boolean d(int i6) {
        return i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5 || i6 == 7 || i6 == 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static boolean e(com.ss.android.xt.j.xt.b bVar, cw cwVar, int i6, j.o oVar, boolean z5, com.ss.android.downloadlib.addownload.j.a aVar) {
        if (bVar == null) {
            com.ss.android.downloadlib.up.a.a().c("tryReverseWifi nativeModel null");
            return false;
        }
        if (cwVar == null) {
            com.ss.android.downloadlib.up.a.a().c("tryReverseWifi info null");
            return false;
        }
        int ae = cwVar.ae();
        ?? f6 = z5 ? a.n.f(bVar) : a.n.A(bVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf((int) f6));
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (z5) {
            com.ss.android.downloadlib.r.b.a().r("cancel_pause_reserve_wifi_switch_status", jSONObject, bVar);
        } else {
            com.ss.android.downloadlib.r.b.a().r("pause_reserve_wifi_switch_status", jSONObject, bVar);
        }
        if (f6 == 0 || !d(i6) || com.ss.android.socialbase.downloader.az.m.xt(m.getContext())) {
            return false;
        }
        if (!z5 && cwVar.ya()) {
            return false;
        }
        c(new a(ae, z5, bVar, oVar));
        if (z5 && aVar != null) {
            b(new C0741b(bVar, aVar));
        }
        if (z5) {
            TTDelegateActivity.k(bVar, "删除");
            return true;
        }
        TTDelegateActivity.v(bVar);
        return true;
    }

    public static com.ss.android.downloadlib.addownload.j.c a() {
        return f37602a;
    }

    public static void b(com.ss.android.downloadlib.addownload.j.a aVar) {
        f37603b = aVar;
    }

    public static void c(com.ss.android.downloadlib.addownload.j.c cVar) {
        f37602a = cVar;
    }

    public static com.ss.android.downloadlib.addownload.j.a f() {
        return f37603b;
    }
}
