package com.ss.android.downloadlib.addownload;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.downloadlib.a;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import java.util.Calendar;

/* loaded from: D:\Downloads\app\classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private volatile cw f37737a;

    /* renamed from: b, reason: collision with root package name */
    private volatile cw f37738b;

    /* renamed from: c, reason: collision with root package name */
    private volatile cw f37739c;

    /* renamed from: d, reason: collision with root package name */
    private volatile cw f37740d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f37741e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f37742f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f37743g;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                i.this.a();
            } catch (Exception e6) {
                com.ss.android.downloadlib.up.a.a().e(false, e6, "读取sp出错");
            }
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static i f37745a = new i(null);
    }

    /* synthetic */ i(a aVar) {
        this();
    }

    private boolean e(cw cwVar) {
        return cwVar != null && cwVar.i() == -2;
    }

    private boolean f(cw cwVar, com.ss.android.j.j.cw.b bVar) {
        return (cwVar == null || bVar == null || a.h.z(bVar)) ? false : true;
    }

    private i() {
        this.f37737a = null;
        this.f37738b = null;
        this.f37739c = null;
        this.f37740d = null;
        this.f37741e = false;
        this.f37742f = false;
        this.f37743g = false;
        com.ss.android.downloadlib.e.c().k(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f37741e) {
            return;
        }
        String valueOf = String.valueOf(g());
        if (TextUtils.isEmpty(valueOf)) {
            return;
        }
        SharedPreferences j6 = com.bytedance.sdk.openadsdk.ats.cw.j(m.getContext(), "sp_download_retain", 0);
        if (valueOf.equals(j6.getString("unfinished_pushed_update_time", "0"))) {
            String string = j6.getString("unfinished_pushed_id", "0");
            if (string == null) {
                string = "0";
            }
            this.f37737a = ae.xt(m.getContext()).tl(Integer.parseInt(string));
        }
        if (valueOf.equals(j6.getString("uninstalled_pushed_update_time", "0"))) {
            String string2 = j6.getString("uninstalled_pushed_id", "0");
            if (string2 == null) {
                string2 = "0";
            }
            this.f37738b = ae.xt(m.getContext()).tl(Integer.parseInt(string2));
        }
        if (valueOf.equals(j6.getString("unfinished_pop_up_update_time", "0"))) {
            String string3 = j6.getString("unfinished_pop_up_id", "0");
            if (string3 == null) {
                string3 = "0";
            }
            this.f37739c = ae.xt(m.getContext()).tl(Integer.parseInt(string3));
        }
        if (valueOf.equals(j6.getString("uninstalled_pop_up_update_time", "0"))) {
            String string4 = j6.getString("uninstalled_pop_up_id", "0");
            this.f37740d = ae.xt(m.getContext()).tl(Integer.parseInt(string4 != null ? string4 : "0"));
        }
        this.f37741e = true;
    }

    public static i b() {
        return b.f37745a;
    }

    public void d(com.ss.android.j.j.cw.b bVar, cw cwVar) {
        if (e(cwVar) && m.e() != null && m.e().j(bVar, cwVar)) {
            com.ss.android.downloadlib.r.b.a().k("download_unfinished_push_retain", bVar.r());
        }
    }

    public long g() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public void h(com.ss.android.j.j.cw.b bVar, cw cwVar) {
        if (f(cwVar, bVar) && m.e() != null && m.e().xt(bVar, cwVar)) {
            com.ss.android.downloadlib.r.b.a().k("download_uninstalled_push_retain", bVar.r());
        }
    }
}
