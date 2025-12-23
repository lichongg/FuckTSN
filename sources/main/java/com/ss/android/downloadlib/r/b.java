package com.ss.android.downloadlib.r;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.j.j.cw.g;
import com.ss.android.j.j.up.d;
import com.ss.android.socialbase.appdownloader.m.e;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.up.j;
import com.umeng.analytics.pro.bi;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    static /* synthetic */ class a {
    }

    /* renamed from: com.ss.android.downloadlib.r.b$b, reason: collision with other inner class name */
    private static class C0762b {

        /* renamed from: a, reason: collision with root package name */
        private static b f38205a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public void j(String str, int i6, o.i iVar) {
        o(null, str, null, i6, 0, iVar);
    }

    public void k(String str, long j6) {
        q(str, null, j6);
    }

    public void m(String str, com.ss.android.xt.j.xt.a aVar) {
        r(str, null, aVar);
    }

    public void n(String str, String str2, com.ss.android.xt.j.xt.a aVar) {
        p(str, str2, null, aVar);
    }

    public void t(long j6, int i6) {
        d(j6, i6, null);
    }

    public void w(String str, com.ss.android.xt.j.xt.a aVar) {
        n(null, str, aVar);
    }

    public void x(String str, JSONObject jSONObject, com.ss.android.xt.j.xt.a aVar) {
        p(null, str, jSONObject, aVar);
    }

    private b() {
    }

    private JSONObject b(com.ss.android.xt.j.xt.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            a.h.s(aVar.ae(), jSONObject);
            a.h.s(aVar.av(), jSONObject);
            jSONObject.putOpt("download_url", aVar.j());
            jSONObject.putOpt(bi.f40972o, aVar.up());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", e.q());
            jSONObject.putOpt("rom_version", e.f());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.tl()));
            if (aVar.tl() == 2) {
                a.i.g(jSONObject, aVar);
            }
            if (e.b()) {
                a.i.e(jSONObject);
            }
            return jSONObject;
        } catch (Exception e6) {
            m.w().j(e6, "getBaseJson");
            return jSONObject;
        }
    }

    private void o(String str, String str2, JSONObject jSONObject, long j6, int i6, com.ss.android.xt.j.xt.a aVar) {
        if (aVar == null) {
            com.ss.android.downloadlib.up.a.a().c("onEvent data null");
            return;
        }
        if ((aVar instanceof o.i) && ((o.i) aVar).b()) {
            com.ss.android.downloadlib.up.a.a().c("onEvent ModelBox notValid");
            return;
        }
        try {
            d.a d6 = new d.a().j(a.h.q(str, aVar.oq(), "embeded_ad")).A(str2).C(aVar.cw()).h(aVar.xt()).d(aVar.r());
            if (j6 <= 0) {
                j6 = aVar.vl();
            }
            d.a i7 = d6.z(j6).t(aVar.g()).k(aVar.ws()).l(a.h.t(b(aVar), jSONObject)).B(aVar.qv()).i(aVar.az());
            if (i6 <= 0) {
                i6 = 2;
            }
            g(i7.g(i6).m(aVar.jy()).n());
        } catch (Exception e6) {
            com.ss.android.downloadlib.up.a.a().j(e6, "onEvent");
        }
    }

    public void i(cw cwVar, j jVar) {
        com.ss.android.xt.j.xt.b f6;
        if (cwVar == null || (f6 = o.f.c().f(cwVar)) == null || f6.N.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.d.g(jSONObject, cwVar);
            jSONObject.putOpt("fail_status", Integer.valueOf(f6.T()));
            jSONObject.putOpt("fail_msg", f6.C());
            jSONObject.put("download_failed_times", f6.T0());
            if (cwVar.ka() > 0) {
                jSONObject.put("download_percent", cwVar.uq() / cwVar.ka());
            }
            jSONObject.put("download_status", cwVar.v());
            long currentTimeMillis = System.currentTimeMillis();
            if (f6.Q0() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - f6.Q0());
            }
            if (f6.S() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - f6.S());
            }
            jSONObject.put("is_update_download", f6.i0() ? 1 : 2);
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.up.c.e() ? 1 : 2);
            jSONObject.put("has_send_download_failed_finally", f6.O.get() ? 1 : 2);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        p(f6.oq(), "download_cancel", jSONObject, f6);
    }

    public void l(String str, @NonNull com.ss.android.j.j.cw.b bVar, @NonNull g gVar, @NonNull com.ss.android.j.j.cw.c cVar) {
        w(str, new o.i(bVar.r(), bVar, gVar, cVar));
    }

    public void p(String str, String str2, JSONObject jSONObject, com.ss.android.xt.j.xt.a aVar) {
        o(str, str2, jSONObject, 0L, 0, aVar);
    }

    public void r(String str, JSONObject jSONObject, com.ss.android.xt.j.xt.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        a.h.u(jSONObject2, "unity_label", str);
        p("embeded_ad", "ttdownloader_unity", a.h.s(jSONObject, jSONObject2), aVar);
    }

    public void u(cw cwVar, j jVar) {
        if (cwVar == null) {
            return;
        }
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
        if (f6 == null) {
            com.ss.android.downloadlib.up.a.a().c("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (f6.N.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            a.i.a(cwVar, jSONObject);
            com.ss.android.downloadlib.d.g(jSONObject, cwVar);
            if (jVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(jVar.j()));
                jSONObject.putOpt("fail_msg", jVar.xt());
                f6.p0(jVar.j());
                f6.K(jVar.xt());
            }
            f6.n();
            jSONObject.put("download_failed_times", f6.T0());
            if (cwVar.ka() > 0) {
                jSONObject.put("download_percent", cwVar.uq() / cwVar.ka());
            }
            jSONObject.put("has_send_download_failed_finally", f6.O.get() ? 1 : 2);
            a.i.d(f6, jSONObject);
            jSONObject.put("is_update_download", f6.i0() ? 1 : 2);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        p(f6.oq(), "download_failed", jSONObject, f6);
        o.d.c().d(f6);
    }

    public static b a() {
        return C0762b.f38205a;
    }

    private void g(d dVar) {
        if (m.h() == null) {
            return;
        }
        if (dVar.f()) {
            m.h().j(dVar);
        } else {
            m.h().xt(dVar);
        }
    }

    public void c(long j6, int i6) {
        String xt;
        int i7;
        o.i r5 = o.f.c().r(j6);
        if (r5.b()) {
            com.ss.android.downloadlib.up.a.a().c("sendClickEvent ModelBox notValid");
            return;
        }
        if (r5.f37962c.vl()) {
            int i8 = 1;
            g gVar = r5.f37962c;
            if (i6 == 1) {
                xt = gVar.cw();
            } else {
                xt = gVar.xt();
            }
            String q5 = a.h.q(r5.f37962c.r(), AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i6));
                if (com.ss.android.socialbase.appdownloader.up.c.e()) {
                    i7 = 1;
                } else {
                    i7 = 2;
                }
                jSONObject.putOpt("permission_notification", Integer.valueOf(i7));
                if (!com.ss.android.socialbase.downloader.az.m.cw(m.getContext())) {
                    i8 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i8));
            } catch (JSONException e6) {
                vl.j(e6);
            }
            p(xt, q5, jSONObject, r5);
            if (AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(q5) && r5.f37961b != null) {
                com.ss.android.downloadlib.r.a.c().d(j6, r5.f37961b.ch());
            }
        }
    }

    public void d(long j6, int i6, cw cwVar) {
        String q5;
        o.i r5 = o.f.c().r(j6);
        if (r5.b()) {
            com.ss.android.downloadlib.up.a.a().c("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        a.h.u(jSONObject, "download_scene", Integer.valueOf(r5.kt()));
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            q5 = null;
                        } else {
                            if (cwVar != null) {
                                try {
                                    a.i.f(jSONObject, cwVar.ae());
                                    com.ss.android.downloadlib.d.w(jSONObject, cwVar);
                                } catch (Throwable unused) {
                                }
                            }
                            q5 = a.h.q(r5.f37962c.tl(), "click_install");
                        }
                    } else {
                        q5 = a.h.q(r5.f37962c.ae(), "click_continue");
                        a.i.a(cwVar, jSONObject);
                    }
                } else {
                    q5 = a.h.q(r5.f37962c.m(), "click_pause");
                    a.i.h(cwVar, jSONObject);
                }
            } else {
                q5 = a.h.q(r5.f37962c.up(), "click_start");
                a.i.c(cwVar, jSONObject);
            }
        } else {
            q5 = a.h.q(r5.f37962c.g(), "storage_deny");
        }
        o(null, q5, jSONObject, 0L, 1, r5);
    }

    public void e(long j6, j jVar) {
        o.i r5 = o.f.c().r(j6);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (jVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(jVar.j()));
                jSONObject.putOpt("fail_msg", jVar.xt());
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        x("download_failed", jSONObject, r5);
    }

    public void f(long j6, boolean z5, int i6) {
        String str;
        o.i r5 = o.f.c().r(j6);
        if (r5.b()) {
            com.ss.android.downloadlib.up.a.a().c("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (r5.f37961b.gq() == null) {
            return;
        }
        com.ss.android.j.j.cw.b bVar = r5.f37961b;
        if (bVar instanceof com.ss.android.xt.j.j.a) {
            ((com.ss.android.xt.j.j.a) bVar).e(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i6));
        } catch (JSONException e6) {
            vl.j(e6);
        }
        if (z5) {
            str = "deeplink_quickapp_success";
        } else {
            str = "deeplink_quickapp_failed";
        }
        x(str, jSONObject, r5);
    }

    public void h(cw cwVar) {
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
        if (f6 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            a.i.a(cwVar, jSONObject);
            f6.J(System.currentTimeMillis());
            p(f6.oq(), "download_resume", jSONObject, f6);
            o.d.c().d(f6);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public void q(String str, JSONObject jSONObject, long j6) {
        com.ss.android.xt.j.xt.a q5 = o.f.c().q(j6);
        if (q5 != null) {
            r(str, jSONObject, q5);
            return;
        }
        o.i r5 = o.f.c().r(j6);
        if (r5.b()) {
            com.ss.android.downloadlib.up.a.a().c("sendUnityEvent ModelBox notValid");
        } else {
            r(str, jSONObject, r5);
        }
    }

    public void s(JSONObject jSONObject, @NonNull com.ss.android.xt.j.xt.b bVar) {
        p(bVar.oq(), "install_finish", jSONObject, bVar);
    }

    public void v(String str, long j6) {
        com.ss.android.xt.j.xt.b q5 = o.f.c().q(j6);
        if (q5 != null) {
            w(str, q5);
        } else {
            w(str, o.f.c().r(j6));
        }
    }
}
