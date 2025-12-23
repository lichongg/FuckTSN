package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.cw;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.library.solder.lib.ext.PluginError;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.b;
import com.ss.android.downloadlib.j;
import com.ss.android.socialbase.appdownloader.j;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.j.j;
import com.ss.android.socialbase.downloader.notification.xt;
import com.ss.android.socialbase.downloader.r.uf;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d implements j.c, j.InterfaceC0786j, uf, z2.a {

    /* renamed from: c, reason: collision with root package name */
    private static String f38031c = "d";

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f38032d;

    /* renamed from: a, reason: collision with root package name */
    private long f38033a;

    /* renamed from: b, reason: collision with root package name */
    private f f38034b;

    class a implements j.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f38035a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38036b;

        a(com.ss.android.xt.j.xt.b bVar, String str) {
            this.f38035a = bVar;
            this.f38036b = str;
        }

        @Override // com.ss.android.downloadlib.j.d
        public void j(boolean z5) {
            boolean z6;
            com.ss.android.socialbase.downloader.m.j.xt(d.f38031c, "appBackForeground->".concat(String.valueOf(z5)));
            if (z5) {
                if (j.h.b(this.f38035a)) {
                    z6 = j.g.i(this.f38036b, this.f38035a);
                } else {
                    z6 = false;
                }
                if (!z6 && j.h.i(this.f38035a) && this.f38035a.l() == 4) {
                    com.ss.android.downloadlib.addownload.j.b.a().f(this.f38035a);
                    return;
                }
                return;
            }
            if (!j.g.i(this.f38036b, this.f38035a) && this.f38035a.l() == 4) {
                com.ss.android.downloadlib.addownload.j.b.a().f(this.f38035a);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f38038a;

        b(long j6) {
            this.f38038a = j6;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.d().h(this.f38038a);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38040a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f38041b;

        c(String str, com.ss.android.xt.j.xt.b bVar) {
            this.f38040a = str;
            this.f38041b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String c6 = a.g.c(this.f38040a);
            if (TextUtils.isEmpty(c6)) {
                return;
            }
            cw.j(m.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(this.f38041b.xt()), c6).apply();
        }
    }

    /* renamed from: com.ss.android.downloadlib.d$d, reason: collision with other inner class name */
    class C0755d implements j.InterfaceC0759j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.ae.cw f38043a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f38044b;

        C0755d(com.ss.android.socialbase.downloader.ae.cw cwVar, JSONObject jSONObject) {
            this.f38043a = cwVar;
            this.f38044b = jSONObject;
        }

        @Override // com.ss.android.downloadlib.j.InterfaceC0759j
        public void j(boolean z5) {
            if (!z5) {
                Intent intent = (Intent) this.f38043a.vm().get("intent");
                if (intent != null) {
                    this.f38043a.vm().remove("intent");
                    com.ss.android.socialbase.appdownloader.b.j(m.getContext(), intent);
                    a.h.u(this.f38044b, LiveConfigKey.BACKUP, 1);
                } else {
                    a.h.u(this.f38044b, LiveConfigKey.BACKUP, 2);
                }
            }
            com.ss.android.xt.j.xt.b f6 = o.f.c().f(this.f38043a);
            if (f6 != null) {
                com.ss.android.downloadlib.r.b.a().r(z5 ? "installer_delay_success" : "installer_delay_failed", this.f38044b, f6);
            } else {
                com.ss.android.downloadlib.up.a.a().f("ah nativeModel=null");
            }
            if (z5) {
                m.C();
                m.getContext();
            }
        }
    }

    @WorkerThread
    private class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final int f38046a;

        public e(int i6) {
            this.f38046a = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o.f.c().v();
                ConcurrentHashMap<Long, com.ss.android.xt.j.xt.b> b6 = o.f.c().b();
                if (b6 != null && !b6.isEmpty()) {
                    d.this.r(b6, this.f38046a);
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    private static class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private long f38048a;

        /* renamed from: b, reason: collision with root package name */
        private int f38049b;

        /* renamed from: c, reason: collision with root package name */
        private long f38050c;

        /* renamed from: d, reason: collision with root package name */
        private int f38051d;

        /* renamed from: e, reason: collision with root package name */
        private long f38052e;

        /* synthetic */ f(long j6, int i6, long j7, int i7, a aVar) {
            this(j6, i6, j7, i7);
        }

        private f(long j6, int i6, long j7, int i7) {
            this.f38048a = j6;
            this.f38049b = i6;
            this.f38050c = j7;
            this.f38051d = i7;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
        
            if (r7 < r5) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean c() {
            /*
                Method dump skipped, instructions count: 247
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.d.f.c():boolean");
        }

        private int a(boolean z5, com.ss.android.xt.j.xt.b bVar, com.ss.android.socialbase.downloader.ae.cw cwVar, boolean z6, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
            int i6 = 1;
            if (j6.j("install_failed_check_ttmd5", 1) == 1) {
                int lo = cwVar.lo();
                try {
                    jSONObject.put("ttmd5_status", lo);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.az.m.j(lo)) {
                    return PluginError.ERROR_UPD_CAPACITY;
                }
            }
            int i7 = this.f38051d;
            if (i7 != 2000) {
                return i7;
            }
            if (j6.j("install_failed_check_signature", 1) == 1 && a.h.G(m.getContext(), bVar.up())) {
                if (!a.h.B(a.h.e(m.getContext(), cwVar.ws()), a.h.F(m.getContext(), bVar.up()))) {
                    return PluginError.ERROR_UPD_REQUEST;
                }
            }
            if (!z5) {
                return 2002;
            }
            long j7 = this.f38052e;
            long j8 = this.f38050c;
            if (j7 <= j8) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j7 - j8);
                if (bVar.g0() <= this.f38050c) {
                    i6 = 0;
                }
                jSONObject.put("install_again", i6);
            } catch (Throwable unused2) {
            }
            if (!z6) {
                return 2003;
            }
            return PluginError.ERROR_UPD_EXTRACT;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            this.f38052e = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c()) {
                    d.d().i(this.f38048a, this.f38049b);
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    private static com.ss.android.socialbase.downloader.ae.cw e(List<com.ss.android.socialbase.downloader.ae.cw> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.ss.android.socialbase.downloader.ae.cw cwVar : list) {
                if (cwVar != null) {
                    if (!str.equals(cwVar.la())) {
                        if (a.h.y(m.getContext(), cwVar.ws(), str)) {
                        }
                    }
                    return cwVar;
                }
            }
        }
        return null;
    }

    @Override // z2.a
    public void j(int i6) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f38033a < 120000) {
            return;
        }
        com.ss.android.downloadlib.e.c().e(new e(i6), this.f38033a > 0 ? 2000L : 8000L);
        this.f38033a = currentTimeMillis;
    }

    @WorkerThread
    public synchronized void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a.h.K()) {
            throw new RuntimeException("handleAppInstalled in main thread.");
        }
        com.ss.android.xt.j.xt.b g6 = o.f.c().g(str);
        if (g6 == null) {
            o.g.c().d(str);
            return;
        }
        l c6 = com.ss.android.downloadlib.c.d().c(g6.j());
        if (c6 != null) {
            c6.H();
        }
        if (g6.N.get()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.jy.j.j(g6.mi()).xt("notification_opt_2") == 1) {
            xt.j().m(g6.mi());
        }
        new j.m().a(g6, new a(g6, str), a.n.k(g6).j("try_applink_delay_after_installed", 0));
        b.i.c().i(g6);
        q(str, g6);
        com.ss.android.downloadlib.addownload.j.b.a().j(str);
        com.ss.android.socialbase.downloader.ae.cw e6 = e(ae.xt(m.getContext()).xt("application/vnd.android.package-archive"), str);
        if (e6 == null) {
            com.ss.android.downloadlib.c.d().v(null, str);
            return;
        }
        if (com.ss.android.socialbase.downloader.jy.j.j(e6.ae()).xt("no_hide_notification") != 1) {
            xt.j().j(e6.ae());
        }
        com.ss.android.downloadlib.c.d().v(e6, str);
        c.d.c(e6);
    }

    synchronized void s() {
        f fVar = this.f38034b;
        if (fVar != null) {
            fVar.d();
            this.f38034b = null;
        }
    }

    public static String b(@NonNull com.ss.android.socialbase.downloader.ae.cw cwVar, @NonNull com.ss.android.xt.j.xt.b bVar) {
        File file = new File(cwVar.qv(), cwVar.tl());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = m.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.b.e());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(cwVar.la())) {
            return cwVar.la();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", cwVar.la());
        } catch (JSONException e7) {
            vl.j(e7);
        }
        com.ss.android.downloadlib.r.b.a().p("embeded_ad", "package_name_error", jSONObject, bVar);
        return str;
    }

    public static d d() {
        if (f38032d == null) {
            synchronized (d.class) {
                try {
                    if (f38032d == null) {
                        f38032d = new d();
                    }
                } finally {
                }
            }
        }
        return f38032d;
    }

    private JSONObject f(com.ss.android.xt.j.xt.b bVar, String str, int i6) {
        com.ss.android.socialbase.appdownloader.d a6;
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.socialbase.downloader.ae.cw tl = ae.xt(m.getContext()).tl(bVar.mi());
            jSONObject.putOpt("scene", Integer.valueOf(i6));
            a.i.f(jSONObject, bVar.mi());
            a.i.d(bVar, jSONObject);
            jSONObject.put("is_update_download", bVar.i0() ? 1 : 2);
            jSONObject.put("install_after_back_app", bVar.x() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", bVar.b1() ? "1" : "2");
            if (tl != null) {
                g(jSONObject, tl);
                try {
                    jSONObject.put("uninstall_resume_count", tl.lc());
                    if (bVar.g0() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - bVar.g0();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > com.ss.android.socialbase.downloader.jy.j.j(tl.ae()).j("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String j6 = com.ss.android.socialbase.downloader.az.m.j(tl.vm().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(j6) && (a6 = com.ss.android.socialbase.appdownloader.d.a(j6)) != null) {
                    a6.c(jSONObject);
                }
            }
            int c6 = c(bVar, tl, str, jSONObject);
            jSONObject.put("fail_status", c6);
            if (c6 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (c6 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return jSONObject;
    }

    public static JSONObject g(JSONObject jSONObject, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (jSONObject != null && cwVar != null) {
            int i6 = 1;
            if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("download_event_opt", 1) != 0) {
                try {
                    jSONObject.put("download_id", cwVar.ae());
                    jSONObject.put(CommonNetImpl.NAME, cwVar.tl());
                    jSONObject.put("cur_bytes", cwVar.uq());
                    jSONObject.put("total_bytes", cwVar.ka());
                    jSONObject.put("network_quality", cwVar.wo());
                    jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.g.vl.j().xt().name());
                    jSONObject.put("only_wifi", cwVar.x() ? 1 : 0);
                    jSONObject.put("need_https_degrade", cwVar.d() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", cwVar.kt() ? 1 : 0);
                    jSONObject.put("chunk_count", cwVar.kj());
                    jSONObject.put("retry_count", cwVar.c());
                    jSONObject.put("cur_retry_time", cwVar.fx());
                    jSONObject.put("need_retry_delay", cwVar.wi() ? 1 : 0);
                    jSONObject.put("backup_url_used", cwVar.hh() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", cwVar.cw() != null ? cwVar.cw() : "");
                    jSONObject.put("need_independent_process", cwVar.xp() ? 1 : 0);
                    jSONObject.put("total_retry_count", cwVar.n());
                    jSONObject.put("cur_retry_time_in_total", cwVar.nd());
                    jSONObject.put("real_download_time", cwVar.lx());
                    jSONObject.put("first_speed_time", cwVar.ch());
                    jSONObject.put("all_connect_time", cwVar.l());
                    jSONObject.put("download_prepare_time", cwVar.p());
                    jSONObject.put("download_time", cwVar.lx() + cwVar.l() + cwVar.p());
                    jSONObject.put("chunk_downgrade_retry_used", cwVar.qg() ? 1 : 0);
                    jSONObject.put("need_chunk_downgrade_retry", cwVar.zs() ? 1 : 0);
                    jSONObject.put("failed_resume_count", cwVar.pm());
                    jSONObject.put("preconnect_level", cwVar.qf());
                    jSONObject.put(TKDownloadReason.KSAD_TK_MD5, cwVar.rn());
                    jSONObject.put("expect_file_length", cwVar.wq());
                    jSONObject.put("retry_schedule_count", cwVar.b());
                    jSONObject.put("rw_concurrent", cwVar.kc() ? 1 : 0);
                    double uq = cwVar.uq() / 1048576.0d;
                    double lx = cwVar.lx() / 1000.0d;
                    if (uq > 0.0d && lx > 0.0d) {
                        double d6 = uq / lx;
                        try {
                            jSONObject.put("download_speed", d6);
                        } catch (Exception unused) {
                        }
                        com.ss.android.socialbase.downloader.m.j.xt(f38031c, "download speed : " + d6 + "MB/s");
                    }
                    try {
                        jSONObject.put("is_download_service_foreground", ae.xt(m.getContext()).jy(cwVar.ae()) ? 1 : 0);
                    } catch (Exception e6) {
                        vl.j(e6);
                    }
                    if (cwVar.ja() != null) {
                        jSONObject.put("backup_url_count", cwVar.ja().size());
                        jSONObject.put("cur_backup_url_index", cwVar.mi());
                    }
                    jSONObject.put("clear_space_restart_times", c.d.b().g(cwVar.oq()));
                    jSONObject.put("mime_type", cwVar.xw());
                    if (!com.ss.android.socialbase.downloader.az.m.cw(m.getContext())) {
                        i6 = 2;
                    }
                    jSONObject.put("network_available", i6);
                    jSONObject.put("status_code", cwVar.ll());
                    w(jSONObject, cwVar);
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }
        return jSONObject;
    }

    @WorkerThread
    public static synchronized void m(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.xt.j.xt.b bVar) {
        synchronized (d.class) {
            if (cwVar == null) {
                com.ss.android.downloadlib.up.a.a().c("onDownloadFinish info null");
                return;
            }
            if (bVar == null) {
                com.ss.android.downloadlib.up.a.a().c("onDownloadFinish nativeModel null");
                return;
            }
            if (bVar.u0() != 1) {
                return;
            }
            b.i.c().j(bVar);
            String b6 = b(cwVar, bVar);
            o.f.c().w(cwVar.oq(), b6);
            Map<Long, com.ss.android.xt.j.xt.b> h6 = o.f.c().h(cwVar.oq(), b6);
            bVar.V(System.currentTimeMillis());
            bVar.G0(2);
            bVar.Y0(b6);
            h6.put(Long.valueOf(bVar.xt()), bVar);
            o.d.c().e(h6.values());
            o(bVar);
            com.ss.android.downloadlib.addownload.i.b().h(bVar.tj(), cwVar);
            bVar.L0(System.currentTimeMillis());
            com.ss.android.downloadlib.c.d().k(cwVar, b6);
            if ("application/vnd.android.package-archive".equals(cwVar.xw())) {
                if (a.n.k(bVar).j("enable_app_install_receiver", 1) != 1 && m.f().optInt("enable_app_install_receiver", 1) != 1) {
                    com.ss.android.downloadlib.addownload.f.a().c(bVar);
                }
                d().x(cwVar, bVar);
                if (bVar.D()) {
                    com.ss.android.downloadlib.addownload.j.b.a().c(cwVar.ae(), bVar.xt(), bVar.vl(), b6, cwVar.g(), bVar.r(), cwVar.ws());
                }
            }
        }
    }

    private static void o(com.ss.android.xt.j.xt.b bVar) {
        if (bVar == null) {
            return;
        }
        String b02 = TextUtils.isEmpty(bVar.b0()) ? "" : bVar.b0();
        com.ss.android.socialbase.downloader.ae.cw tl = ae.xt(m.getContext()).tl(bVar.mi());
        bVar.M0("");
        o.d.c().d(bVar);
        JSONObject g6 = g(new JSONObject(), tl);
        try {
            g6.putOpt("finish_reason", b02);
            g6.putOpt("finish_from_reserve_wifi", Integer.valueOf(tl.e() ? 1 : 0));
        } catch (JSONException e6) {
            vl.j(e6);
        }
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(tl);
        a.i.f(g6, tl.ae());
        try {
            g6.put("download_failed_times", f6.T0());
            g6.put("can_show_notification", com.ss.android.socialbase.appdownloader.up.c.e() ? 1 : 2);
            if (tl.wq() > 0 && tl.ka() > 0) {
                g6.put("file_length_gap", tl.wq() - tl.ka());
            }
            g6.put("ttmd5_status", tl.a());
            g6.put("has_send_download_failed_finally", f6.O.get() ? 1 : 2);
            g6.put("is_update_download", f6.i0() ? 1 : 2);
            a.i.d(f6, g6);
        } catch (Throwable th) {
            vl.j(th);
        }
        com.ss.android.downloadlib.r.b.a().x("download_finish", g6, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void r(@NonNull ConcurrentHashMap<Long, com.ss.android.xt.j.xt.b> concurrentHashMap, int i6) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.xt.j.xt.b bVar : concurrentHashMap.values()) {
            if (bVar.N.get()) {
                if (currentTimeMillis - bVar.Q0() >= com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("start_event_expire_hours", 168) * 3600000) {
                    arrayList.add(Long.valueOf(bVar.xt()));
                }
            } else if (bVar.u0() == 1) {
                if (u(bVar) <= 0 && currentTimeMillis - bVar.Q0() >= com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("start_event_expire_hours", 168) * 3600000) {
                    arrayList.add(Long.valueOf(bVar.xt()));
                }
            } else if (bVar.u0() != 2) {
                arrayList.add(Long.valueOf(bVar.xt()));
            } else if (!bVar.y0()) {
                if (a.h.M(bVar)) {
                    if (bVar.l() == 4) {
                        i6 = bVar.l();
                        w2.o e6 = m.e();
                        if (e6 != null) {
                            e6.j(bVar.tj());
                        }
                    }
                    bVar.f0(false);
                    com.ss.android.downloadlib.r.b.a().s(f(bVar, bVar.up(), i6), bVar);
                    arrayList.add(Long.valueOf(bVar.xt()));
                    c.d.d(bVar);
                } else if (bVar.y0() && bVar.l() == 4 && i6 == 1 && !a.h.M(bVar)) {
                    a.o.a().b(f38031c, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                    com.ss.android.downloadlib.f.a().d(bVar);
                } else if (currentTimeMillis - bVar.Q0() >= com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("finish_event_expire_hours", 168) * 3600000) {
                    arrayList.add(Long.valueOf(bVar.xt()));
                } else if (TextUtils.isEmpty(bVar.up())) {
                    arrayList.add(Long.valueOf(bVar.xt()));
                }
            }
        }
        o.f.c().m(arrayList);
    }

    public static JSONObject w(JSONObject jSONObject, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (jSONObject != null && cwVar != null) {
            if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("download_event_opt", 1) != 0) {
                try {
                    long I = a.h.I(0L);
                    double d6 = I;
                    jSONObject.put("available_space", d6 / 1048576.0d);
                    long ka = cwVar.ka();
                    double d7 = ka;
                    jSONObject.put("apk_size", d7 / 1048576.0d);
                    if (I > 0 && ka > 0) {
                        jSONObject.put("available_space_ratio", d6 / d7);
                        return jSONObject;
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
            return jSONObject;
        }
        return jSONObject;
    }

    @Override // com.ss.android.socialbase.appdownloader.j.c
    public void a(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.appdownloader.d dVar) {
        JSONObject v5;
        if (cwVar == null || dVar == null) {
            return;
        }
        JSONArray up = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).up("ah_report_config");
        if (dVar.f38360b != 0) {
            cwVar.vm().remove("intent");
        }
        if (up == null || (v5 = v(cwVar, dVar)) == null) {
            return;
        }
        cwVar.vm().put("ah_ext_json", v5);
    }

    @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
    public void cw() {
        com.ss.android.socialbase.downloader.m.j.xt(f38031c, "onAppBackground()");
        j(6);
    }

    void n(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.xt.j.xt.b bVar, int i6) {
        long max;
        if (cwVar == null || bVar == null) {
            return;
        }
        s();
        long currentTimeMillis = System.currentTimeMillis();
        bVar.X0(currentTimeMillis);
        bVar.c(a.h.i(Environment.getDataDirectory(), -1L));
        if (i6 != 2000) {
            max = 2000;
        } else {
            long j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("check_install_failed_delay_time", 120000L);
            if (j6 < 0) {
                return;
            } else {
                max = Math.max(j6, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            }
        }
        long j7 = max;
        f fVar = new f(bVar.xt(), cwVar.ae(), currentTimeMillis, i6, null);
        com.ss.android.downloadlib.e.c().e(fVar, j7);
        this.f38034b = fVar;
        o.d.c().d(bVar);
    }

    public void q(String str, com.ss.android.xt.j.xt.b bVar) {
        if (bVar != null && a.h.M(bVar) && bVar.N.compareAndSet(false, true)) {
            int i6 = 4;
            if (bVar.l() == 4) {
                w2.o e6 = m.e();
                if (e6 != null) {
                    e6.j(bVar.tj());
                }
            } else {
                i6 = 3;
            }
            com.ss.android.downloadlib.r.b.a().p(bVar.oq(), "install_finish", f(bVar, str, i6), bVar);
            o.d.c().d(bVar);
        }
    }

    public void x(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.xt.j.xt.b bVar) {
        if (cwVar == null || bVar == null || com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        String ws = cwVar.ws();
        if (TextUtils.isEmpty(ws)) {
            return;
        }
        com.ss.android.downloadlib.e.c().k(new c(ws, bVar));
    }

    @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
    public void xt() {
        com.ss.android.socialbase.downloader.m.j.xt(f38031c, "onAppForeground()");
        s();
        j(5);
    }

    private d() {
        com.ss.android.socialbase.appdownloader.j.l(this);
        com.ss.android.socialbase.downloader.j.j.j().j(this);
    }

    private int c(com.ss.android.xt.j.xt.b bVar, com.ss.android.socialbase.downloader.ae.cw cwVar, String str, JSONObject jSONObject) {
        int K = com.ss.android.socialbase.appdownloader.b.K(m.getContext(), cwVar);
        int H = a.h.H(m.getContext(), str);
        if (K > 0 && H > 0 && K != H) {
            if (H > K) {
                return 3011;
            }
            return 3010;
        }
        if (com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("install_finish_check_ttmd5", 1) == 1) {
            String string = cw.j(m.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.xt()), null);
            if (TextUtils.isEmpty(string) && cwVar != null) {
                string = a.g.c(cwVar.ws());
            }
            int b6 = a.g.b(string, a.g.f(str));
            try {
                jSONObject.put("ttmd5_status", b6);
            } catch (Throwable unused) {
            }
            if (b6 == 0) {
                return 3000;
            }
            if (b6 == 1) {
                return 3002;
            }
            return 3001;
        }
        return 3001;
    }

    private int u(com.ss.android.xt.j.xt.b bVar) {
        int v5;
        int i6;
        double j6 = com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("download_failed_finally_hours", 48.0d);
        if (j6 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - bVar.Q0() < j6 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (bVar.O.get()) {
            return 0;
        }
        com.ss.android.socialbase.downloader.ae.cw tl = ae.xt(m.getContext()).tl(bVar.mi());
        if (tl == null || (v5 = tl.v()) == -3 || v5 == -4) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.xt.m.xt(v5) && bVar.O.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                g(jSONObject, tl);
                jSONObject.putOpt("download_status", Integer.valueOf(v5));
                jSONObject.putOpt("fail_status", Integer.valueOf(bVar.T()));
                jSONObject.putOpt("fail_msg", bVar.C());
                jSONObject.put("download_failed_times", bVar.T0());
                if (tl.ka() > 0) {
                    jSONObject.put("download_percent", tl.uq() / tl.ka());
                }
                if (bVar.i0()) {
                    i6 = 1;
                } else {
                    i6 = 2;
                }
                jSONObject.put("is_update_download", i6);
                com.ss.android.downloadlib.r.b.a().p(bVar.oq(), "download_failed_finally", jSONObject, bVar);
                o.d.c().d(bVar);
                return 0;
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return 1;
    }

    private JSONObject v(@NonNull com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.appdownloader.d dVar) {
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
        if (f6 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        dVar.c(jSONObject);
        try {
            jSONObject.put("download_id", cwVar.ae());
            jSONObject.put(CommonNetImpl.NAME, cwVar.tl());
        } catch (Throwable th) {
            vl.j(th);
        }
        a.i.f(jSONObject, cwVar.ae());
        com.ss.android.downloadlib.r.b.a().p("embeded_ad", "ah_result", jSONObject, f6);
        return jSONObject;
    }

    public void h(long j6) {
        o.g.b b6;
        int i6;
        try {
            com.ss.android.xt.j.xt.b q5 = o.f.c().q(j6);
            if (q5 != null && !a.h.M(q5) && !q5.N.get()) {
                Pair<o.g.b, Integer> f6 = o.g.c().f(q5);
                if (f6 != null) {
                    b6 = (o.g.b) f6.first;
                    i6 = ((Integer) f6.second).intValue();
                } else {
                    b6 = o.g.c().b(q5);
                    i6 = -1;
                }
                if (b6 != null) {
                    o.g.c().h(b6.f37954a);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("installed_app_name", b6.f37957d);
                    jSONObject.put("installed_pkg_name", b6.f37954a);
                    if (i6 != -1) {
                        jSONObject.put("error_code", i6);
                        a.i.f(jSONObject, q5.mi());
                        com.ss.android.downloadlib.r.b.a().x("install_finish_hijack", jSONObject, q5);
                        return;
                    }
                    com.ss.android.downloadlib.r.b.a().x("install_finish_may_hijack", jSONObject, q5);
                }
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.up.a.a().j(th, "trySendInstallFinishHijack");
        }
    }

    public void i(long j6, int i6) {
        long j7 = com.ss.android.socialbase.downloader.jy.j.j(i6).j("check_install_finish_hijack_delay_time", PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        if (j7 < 0) {
            return;
        }
        com.ss.android.downloadlib.e.c().e(new b(j6), Math.max(j7, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS));
    }

    public void l(com.ss.android.socialbase.downloader.ae.cw cwVar, long j6, long j7, long j8, long j9, long j10, boolean z5) {
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
        if (f6 == null) {
            com.ss.android.downloadlib.up.a.a().c("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j6 / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j7 - j6) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j9));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z5 ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j8));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j8 - j7) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j10));
            a.i.a(cwVar, jSONObject);
            com.ss.android.downloadlib.r.b.a().r("cleanup", jSONObject, f6);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.r.uf
    public void j(@Nullable com.ss.android.socialbase.downloader.ae.cw cwVar, @Nullable String str) {
        if (cwVar == null) {
            com.ss.android.downloadlib.up.a.a().c("info is null");
        } else if ((com.ss.android.socialbase.downloader.jy.j.j(cwVar).xt("check_applink_mode") & 2) != 0) {
            j.l.b().e(new C0755d(cwVar, (JSONObject) cwVar.vm().get("ah_ext_json")));
        }
    }
}
