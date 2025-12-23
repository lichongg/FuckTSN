package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.j.j.up.a;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.j.j;
import com.ss.android.socialbase.downloader.notification.xt;
import com.ss.android.socialbase.downloader.r.ws;
import com.stub.StubApp;
import com.umeng.analytics.pro.bm;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import org.json.JSONObject;
import x2.l;
import x2.n;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements x2.e {

    /* renamed from: b, reason: collision with root package name */
    private static String f37974b = "b";

    /* renamed from: a, reason: collision with root package name */
    private Handler f37975a = new Handler(Looper.getMainLooper());

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.d().j(5, m.getContext(), null, "无网络，请检查网络设置", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.b$b, reason: collision with other inner class name */
    class RunnableC0750b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.jy.j f37977a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.b f37978b;

        RunnableC0750b(com.ss.android.socialbase.downloader.jy.j jVar, com.ss.android.j.j.cw.b bVar) {
            this.f37977a = jVar;
            this.f37978b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.d().j(2, m.getContext(), this.f37978b, this.f37977a.j("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
        }
    }

    class c implements j.InterfaceC0786j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37980a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f37981b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f37982c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ double f37983d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ cw f37984e;

        c(com.ss.android.xt.j.xt.b bVar, long j6, long j7, double d6, cw cwVar) {
            this.f37980a = bVar;
            this.f37981b = j6;
            this.f37982c = j7;
            this.f37983d = d6;
            this.f37984e = cwVar;
        }

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void xt() {
            if (a.h.M(this.f37980a)) {
                com.ss.android.socialbase.downloader.j.j.j().xt(this);
                return;
            }
            long j6 = this.f37981b;
            if (j6 <= -1 || this.f37982c <= -1 || j6 >= this.f37983d) {
                return;
            }
            com.ss.android.downloadlib.r.b.a().r("clean_space_install", com.ss.android.downloadlib.addownload.j.e("install_no_enough_space"), this.f37980a);
            if (com.ss.android.downloadlib.addownload.j.q(this.f37984e, ((long) this.f37983d) - this.f37981b)) {
                com.ss.android.socialbase.downloader.j.j.j().xt(this);
                this.f37980a.e(true);
            }
        }

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void cw() {
        }
    }

    public class d extends x2.f {

        /* renamed from: a, reason: collision with root package name */
        private static String f37986a = "b$d";

        class a implements x2.g {

            /* renamed from: a, reason: collision with root package name */
            private a.b f37987a;

            /* renamed from: b, reason: collision with root package name */
            private DialogInterface.OnClickListener f37988b;

            /* renamed from: c, reason: collision with root package name */
            private DialogInterface.OnClickListener f37989c;

            /* renamed from: d, reason: collision with root package name */
            private DialogInterface.OnCancelListener f37990d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f37991e;

            /* renamed from: com.ss.android.downloadlib.b$d$a$a, reason: collision with other inner class name */
            class C0751a implements a.c {
                C0751a() {
                }

                @Override // com.ss.android.j.j.up.a.c
                public void cw(DialogInterface dialogInterface) {
                    if (a.this.f37990d == null || dialogInterface == null) {
                        return;
                    }
                    a.this.f37990d.onCancel(dialogInterface);
                }

                @Override // com.ss.android.j.j.up.a.c
                public void j(DialogInterface dialogInterface) {
                    if (a.this.f37988b != null) {
                        a.this.f37988b.onClick(dialogInterface, -1);
                    }
                }

                @Override // com.ss.android.j.j.up.a.c
                public void xt(DialogInterface dialogInterface) {
                    if (a.this.f37989c != null) {
                        a.this.f37989c.onClick(dialogInterface, -2);
                    }
                }
            }

            @Override // x2.g
            public x2.g j(int i6) {
                this.f37987a.h(this.f37991e.getResources().getString(i6));
                return this;
            }

            a(Context context) {
                this.f37991e = context;
                this.f37987a = new a.b(context);
            }

            @Override // x2.g
            public x2.g a(int i6, DialogInterface.OnClickListener onClickListener) {
                this.f37987a.l(this.f37991e.getResources().getString(i6));
                this.f37989c = onClickListener;
                return this;
            }

            @Override // x2.g
            public x2.g b(int i6, DialogInterface.OnClickListener onClickListener) {
                this.f37987a.b(this.f37991e.getResources().getString(i6));
                this.f37988b = onClickListener;
                return this;
            }

            @Override // x2.g
            public x2.g c(DialogInterface.OnCancelListener onCancelListener) {
                this.f37990d = onCancelListener;
                return this;
            }

            @Override // x2.g
            public x2.g j(String str) {
                this.f37987a.p(str);
                return this;
            }

            @Override // x2.g
            public x2.g j(boolean z5) {
                this.f37987a.i(z5);
                return this;
            }

            @Override // x2.g
            public n j() {
                this.f37987a.g(new C0751a());
                a.k.d(d.f37986a, "getThemedAlertDlgBuilder", null);
                this.f37987a.e(3);
                return new C0752b(m.d().xt(this.f37987a.j()));
            }
        }

        /* renamed from: com.ss.android.downloadlib.b$d$b, reason: collision with other inner class name */
        private static class C0752b implements n {

            /* renamed from: a, reason: collision with root package name */
            private Dialog f37994a;

            @Override // x2.n
            public void j() {
                Dialog dialog = this.f37994a;
                if (dialog != null) {
                    dialog.show();
                }
            }

            @Override // x2.n
            public boolean xt() {
                Dialog dialog = this.f37994a;
                if (dialog != null) {
                    return dialog.isShowing();
                }
                return false;
            }

            public C0752b(Dialog dialog) {
                if (dialog != null) {
                    this.f37994a = dialog;
                    j();
                }
            }
        }

        @Override // x2.f, x2.k
        public x2.g j(Context context) {
            return new a(context);
        }
    }

    public class e implements ws {
        private File a(String str, String str2) {
            File file = new File(str2);
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                str = name.substring(0, lastIndexOf);
            }
            return new File(file.getParent(), str + ".apk");
        }

        @Override // com.ss.android.socialbase.downloader.r.ws
        public boolean xt(cw cwVar) {
            if (cwVar != null) {
                return u2.b.f(com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()), cwVar.xw());
            }
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.r.ws
        public void j(cw cwVar) throws com.ss.android.socialbase.downloader.up.j {
            w2.c A = m.A();
            if (cwVar != null && A != null) {
                File a6 = a(cwVar.la(), cwVar.ws());
                com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
                if (f6 != null) {
                    a.h.r(f6.ae());
                }
                cwVar.oq("application/vnd.android.package-archive");
                cwVar.m(a6.getName());
                cwVar.qv((String) null);
            }
        }
    }

    public class f implements ws {

        class a implements MediaScannerConnection.OnScanCompletedListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ cw f37995a;

            a(cw cwVar) {
                this.f37995a = cwVar;
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                if (uri != null) {
                    this.f37995a.j("file_content_uri", (Object) uri.toString());
                    com.ss.android.socialbase.downloader.downloader.cw.x().j(this.f37995a);
                }
            }
        }

        private boolean a(cw cwVar) {
            StringBuilder sb = new StringBuilder();
            sb.append(cwVar.qv());
            String str = File.separator;
            sb.append(str);
            sb.append(cwVar.tl());
            String sb2 = sb.toString();
            File file = new File(sb2);
            String d6 = com.ss.android.socialbase.appdownloader.m.j.f.d(m.getContext(), com.ss.android.socialbase.appdownloader.b.m(cwVar, file), sb2);
            boolean z5 = false;
            if (!TextUtils.isEmpty(d6)) {
                String str2 = d6 + ".apk";
                if (str2.equals(cwVar.tl())) {
                    return true;
                }
                try {
                    z5 = file.renameTo(new File(cwVar.qv() + str + str2));
                    if (!z5) {
                        return z5;
                    }
                    cwVar.m(str2);
                    return z5;
                } catch (Exception e6) {
                    vl.j(e6);
                }
            }
            return z5;
        }

        private void b(Context context, cw cwVar) {
            String str = cwVar.qv() + File.separator + cwVar.tl();
            Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{bm.f41039d}, "_data=? ", new String[]{str}, null);
            if (query == null || !query.moveToFirst()) {
                MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new a(cwVar));
            } else {
                cwVar.j("file_content_uri", (Object) ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex(bm.f41039d))).toString());
            }
            com.ss.android.socialbase.downloader.az.m.j(query);
        }

        @Override // com.ss.android.socialbase.downloader.r.ws
        public void j(cw cwVar) throws com.ss.android.socialbase.downloader.up.j {
            if (cwVar == null || !a(cwVar)) {
                return;
            }
            b(m.getContext(), cwVar);
        }

        @Override // com.ss.android.socialbase.downloader.r.ws
        public boolean xt(cw cwVar) {
            if (cwVar != null) {
                return a.n.z(com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()));
            }
            return false;
        }
    }

    public class g implements x2.m {

        /* renamed from: a, reason: collision with root package name */
        private Context f37997a;

        @Override // x2.m
        public void j(Context context, String str) {
            com.ss.android.downloadlib.d.d().p(str);
        }

        @Override // x2.m
        public void a(int i6, int i7, String str, String str2, String str3) {
            cw tl;
            Context context = this.f37997a;
            if (context == null || (tl = ae.xt(context).tl(i6)) == null || tl.i() != -3) {
                return;
            }
            tl.ae(str2);
            o.a().b(this.f37997a, tl);
        }

        @Override // x2.m
        public void b(int i6, int i7, String str, int i8, long j6) {
            cw tl;
            com.ss.android.xt.j.xt.b f6;
            Context context = this.f37997a;
            if (context == null || (tl = ae.xt(context).tl(i6)) == null || tl.i() == 0 || (f6 = o.f.c().f(tl)) == null) {
                return;
            }
            if (i7 == 1) {
                com.ss.android.downloadlib.d.m(tl, f6);
                if ("application/vnd.android.package-archive".equals(tl.xw())) {
                    com.ss.android.downloadlib.addownload.e.a().c(tl, f6.xt(), f6.vl(), f6.up(), tl.g(), f6.r(), tl.ws());
                    return;
                }
                return;
            }
            if (i7 == 3) {
                com.ss.android.downloadlib.r.b.a().p("download_notification", "download_notification_install", com.ss.android.downloadlib.d.w(new JSONObject(), tl), f6);
                return;
            }
            if (i7 == 5) {
                com.ss.android.downloadlib.r.b.a().n("download_notification", "download_notification_pause", f6);
            } else if (i7 == 6) {
                com.ss.android.downloadlib.r.b.a().n("download_notification", "download_notification_continue", f6);
            } else {
                if (i7 != 7) {
                    return;
                }
                com.ss.android.downloadlib.r.b.a().n("download_notification", "download_notification_click", f6);
            }
        }

        @Override // x2.m
        public boolean j(int i6, boolean z5) {
            if (m.c() != null) {
                return m.c().j(z5);
            }
            return false;
        }

        public g(Context context) {
            this.f37997a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }

        @Override // x2.m
        public void j(cw cwVar) {
            if (cwVar == null) {
                return;
            }
            com.ss.android.downloadlib.c.d().i(cwVar);
            if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("report_download_cancel", 1) == 1) {
                com.ss.android.downloadlib.r.b.a().i(cwVar, new com.ss.android.socialbase.downloader.up.j(1012, ""));
            } else {
                com.ss.android.downloadlib.r.b.a().u(cwVar, new com.ss.android.socialbase.downloader.up.j(1012, ""));
            }
        }

        @Override // x2.m
        public boolean j() {
            return o.a().c();
        }
    }

    public class h implements l, com.ss.android.socialbase.downloader.r.vl {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                cw tl;
                int jy;
                o.f.c().v();
                for (com.ss.android.xt.j.xt.b bVar : o.f.c().b().values()) {
                    int mi = bVar.mi();
                    if (mi != 0) {
                        com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(mi);
                        if (j6.xt("notification_opt_2") == 1 && (tl = ae.xt(m.getContext()).tl(mi)) != null) {
                            if (a.h.M(bVar) && !a.h.d(bVar.up())) {
                                int jy2 = tl.jy("restart_notify_open_app_count");
                                if (jy2 < j6.j("noti_open_restart_times", 1)) {
                                    i.c().k(bVar);
                                    tl.j("restart_notify_open_app_count", String.valueOf(jy2 + 1));
                                }
                            } else if (tl.v() == -2) {
                                int jy3 = tl.jy("restart_notify_continue_count");
                                if (jy3 < j6.j("noti_continue_restart_times", 1)) {
                                    i.c().g(bVar);
                                    tl.j("restart_notify_continue_count", String.valueOf(jy3 + 1));
                                }
                            } else if (tl.v() == -3 && com.ss.android.socialbase.downloader.az.m.cw(tl) && !a.h.M(bVar) && (jy = tl.jy("restart_notify_install_count")) < j6.j("noti_install_restart_times", 1)) {
                                i.c().a(bVar);
                                tl.j("restart_notify_install_count", String.valueOf(jy + 1));
                            }
                        }
                    }
                }
            }
        }

        @Override // x2.l
        public void a(cw cwVar, boolean z5) {
            if (cwVar == null) {
                return;
            }
            b(cwVar, cwVar.v(), z5);
        }

        @WorkerThread
        public void b(cw cwVar, int i6, boolean z5) {
            int i7;
            o.f.c().v();
            com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
            if (f6 != null) {
                try {
                    if (z5) {
                        f6.o(cwVar.pm());
                    } else if (f6.E() == -1) {
                        return;
                    } else {
                        f6.o(-1);
                    }
                    o.d.c().d(f6);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("download_id", cwVar.ae());
                    jSONObject.put(CommonNetImpl.NAME, cwVar.tl());
                    jSONObject.put("url", cwVar.oq());
                    jSONObject.put("download_time", cwVar.hu());
                    jSONObject.put("download_status", i6);
                    jSONObject.put("cur_bytes", cwVar.uq());
                    jSONObject.put("total_bytes", cwVar.ka());
                    jSONObject.put("only_wifi", cwVar.x() ? 1 : 0);
                    jSONObject.put("chunk_count", cwVar.kj());
                    if (z5) {
                        i7 = 1;
                    } else {
                        i7 = 2;
                    }
                    jSONObject.put("launch_resumed", i7);
                    jSONObject.put("failed_resume_count", cwVar.pm());
                    com.ss.android.downloadlib.r.b.a().p("embeded_ad", "download_uncompleted", jSONObject, f6);
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }

        @Override // com.ss.android.socialbase.downloader.r.vl
        public void j() {
            com.ss.android.downloadlib.e.c().e(new a(), 5000L);
        }
    }

    public class i {

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f37999a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f38000b;

            a(int i6, com.ss.android.xt.j.xt.b bVar) {
                this.f37999a = i6;
                this.f38000b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                cw tl = ae.xt(m.getContext()).tl(this.f37999a);
                JSONObject jSONObject = new JSONObject();
                a.h.u(jSONObject, "ttdownloader_type", 1);
                a.i.a(tl, jSONObject);
                if (tl != null && -2 == tl.v() && !tl.qb()) {
                    i.this.e(this.f37999a, this.f38000b, jSONObject);
                } else {
                    a.h.u(jSONObject, "error_code", 1001);
                }
                com.ss.android.downloadlib.r.b.a().x("download_notification_try_show", jSONObject, this.f38000b);
            }
        }

        /* renamed from: com.ss.android.downloadlib.b$i$b, reason: collision with other inner class name */
        class RunnableC0753b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f38002a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f38003b;

            RunnableC0753b(int i6, com.ss.android.xt.j.xt.b bVar) {
                this.f38002a = i6;
                this.f38003b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                cw tl = ae.xt(m.getContext()).tl(this.f38002a);
                JSONObject jSONObject = new JSONObject();
                a.h.u(jSONObject, "ttdownloader_type", 2);
                a.i.a(tl, jSONObject);
                if (!a.h.M(this.f38003b)) {
                    i.this.e(this.f38002a, this.f38003b, jSONObject);
                } else {
                    a.h.u(jSONObject, "error_code", 1002);
                }
                com.ss.android.downloadlib.r.b.a().x("download_notification_try_show", jSONObject, this.f38003b);
            }
        }

        class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f38005a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f38006b;

            c(int i6, com.ss.android.xt.j.xt.b bVar) {
                this.f38005a = i6;
                this.f38006b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                cw tl = ae.xt(m.getContext()).tl(this.f38005a);
                JSONObject jSONObject = new JSONObject();
                a.h.u(jSONObject, "ttdownloader_type", 3);
                a.i.a(tl, jSONObject);
                if (!a.h.d(this.f38006b.up())) {
                    i.this.e(this.f38005a, this.f38006b, jSONObject);
                } else {
                    a.h.u(jSONObject, "error_code", 1003);
                }
                com.ss.android.downloadlib.r.b.a().x("download_notification_try_show", jSONObject, this.f38006b);
            }
        }

        private static class d {

            /* renamed from: a, reason: collision with root package name */
            private static i f38008a = new i(null);
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        private i() {
        }

        public void a(@NonNull com.ss.android.xt.j.xt.b bVar) {
            b(bVar, 5L);
        }

        public void g(com.ss.android.xt.j.xt.b bVar) {
            m(bVar, 5L);
        }

        public void k(@NonNull com.ss.android.xt.j.xt.b bVar) {
            h(bVar, 5L);
        }

        public void l(com.ss.android.xt.j.xt.b bVar) {
            if (bVar == null) {
                return;
            }
            m(bVar, com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("noti_continue_delay_secs", 5));
        }

        private void b(@NonNull com.ss.android.xt.j.xt.b bVar, long j6) {
            int mi = bVar.mi();
            if (com.ss.android.socialbase.downloader.jy.j.j(mi).xt("notification_opt_2") != 1) {
                return;
            }
            d(mi);
            com.ss.android.downloadlib.e.c().e(new RunnableC0753b(mi, bVar), j6 * 1000);
        }

        public static i c() {
            return d.f38008a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i6, com.ss.android.xt.j.xt.b bVar, JSONObject jSONObject) {
            if (!com.ss.android.socialbase.appdownloader.up.c.e()) {
                a.h.u(jSONObject, "error_code", 1004);
                return;
            }
            cw tl = ae.xt(m.getContext()).tl(i6);
            if (tl == null) {
                a.h.u(jSONObject, "error_code", 1005);
                return;
            }
            if (xt.j().up(i6) != null) {
                xt.j().m(i6);
            }
            com.ss.android.socialbase.appdownloader.up.b bVar2 = new com.ss.android.socialbase.appdownloader.up.b(m.getContext(), i6, tl.g(), tl.qv(), tl.tl(), tl.h());
            bVar2.j(tl.uq());
            bVar2.xt(tl.ka());
            bVar2.j(tl.i(), null, false, false);
            xt.j().j(bVar2);
            bVar2.j((com.ss.android.socialbase.downloader.up.j) null, false);
            com.ss.android.downloadlib.r.b.a().x("download_notification_show", jSONObject, bVar);
        }

        private void m(@NonNull com.ss.android.xt.j.xt.b bVar, long j6) {
            int mi = bVar.mi();
            if (com.ss.android.socialbase.downloader.jy.j.j(mi).xt("notification_opt_2") != 1) {
                return;
            }
            d(mi);
            com.ss.android.downloadlib.e.c().e(new a(mi, bVar), j6 * 1000);
        }

        public void d(int i6) {
            cw tl;
            if (com.ss.android.socialbase.appdownloader.up.a.d().b(i6) == null && (tl = ae.xt(m.getContext()).tl(i6)) != null) {
                com.ss.android.socialbase.appdownloader.up.a.d().f(i6, tl.et());
            }
        }

        public void h(@NonNull com.ss.android.xt.j.xt.b bVar, long j6) {
            int mi = bVar.mi();
            if (com.ss.android.socialbase.downloader.jy.j.j(mi).xt("notification_opt_2") != 1) {
                return;
            }
            d(mi);
            com.ss.android.downloadlib.e.c().e(new c(mi, bVar), j6 * 1000);
        }

        public void i(@NonNull com.ss.android.xt.j.xt.b bVar) {
            h(bVar, com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("noti_open_delay_secs", 5));
        }

        public void j(@NonNull com.ss.android.xt.j.xt.b bVar) {
            b(bVar, com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("noti_install_delay_secs", 5));
        }
    }

    public class k implements ws {
        @Override // com.ss.android.socialbase.downloader.r.ws
        public boolean xt(cw cwVar) {
            return cwVar != null && a.n.y() && cwVar.ij() == null;
        }

        @Override // com.ss.android.socialbase.downloader.r.ws
        public void j(cw cwVar) throws com.ss.android.socialbase.downloader.up.j {
            PackageInfo l6 = com.ss.android.socialbase.appdownloader.b.l(m.getContext(), cwVar, cwVar.qv(), cwVar.tl());
            if (l6 != null) {
                cwVar.tl(l6.versionCode);
            }
        }
    }

    public class j implements com.ss.android.socialbase.downloader.tl.cw {
        @Override // com.ss.android.socialbase.downloader.tl.cw
        public void j(int i6, String str, JSONObject jSONObject) {
            com.ss.android.xt.j.xt.b f6;
            cw tl = ae.xt(m.getContext()).tl(i6);
            if (tl == null || (f6 = o.f.c().f(tl)) == null) {
                return;
            }
            if ("install_view_result".equals(str)) {
                jSONObject = a.h.r(jSONObject);
                com.ss.android.downloadlib.d.g(jSONObject, tl);
                a.h.u(jSONObject, "model_id", Long.valueOf(f6.xt()));
            }
            com.ss.android.downloadlib.r.b.a().x(str, jSONObject, f6);
        }

        @Override // com.ss.android.socialbase.downloader.tl.cw
        public void xt(int i6, String str, JSONObject jSONObject) {
            com.ss.android.xt.j.xt.b f6;
            cw tl = ae.xt(m.getContext()).tl(i6);
            if (tl == null || (f6 = o.f.c().f(tl)) == null) {
                return;
            }
            com.ss.android.downloadlib.r.b.a().r(str, jSONObject, f6);
        }
    }

    @Override // x2.e
    public void j(cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
        com.ss.android.socialbase.downloader.up.j jVar2;
        com.ss.android.j.j.cw.b d6;
        if (cwVar == null) {
            return;
        }
        if (i6 == -1 && jVar != null) {
            JSONObject jSONObject = new JSONObject();
            a.i.a(cwVar, jSONObject);
            com.ss.android.downloadlib.d.g(jSONObject, cwVar);
            a.k.c("download_failed", jSONObject.toString());
        }
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
        if (f6 == null) {
            return;
        }
        try {
            if (i6 != -1) {
                if (i6 == -3) {
                    com.ss.android.downloadlib.d.m(cwVar, f6);
                    return;
                }
                if (i6 == 2001) {
                    com.ss.android.downloadlib.d.d().n(cwVar, f6, 2001);
                    return;
                } else {
                    if (i6 == 11) {
                        com.ss.android.downloadlib.d.d().n(cwVar, f6, 2000);
                        if (f6.G()) {
                            return;
                        }
                        b(cwVar, f6);
                        return;
                    }
                    return;
                }
            }
            if (jVar != null) {
                if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("toast_without_network", 0) == 1 && jVar.j() == 1049) {
                    this.f37975a.post(new a());
                }
                if (com.ss.android.socialbase.downloader.az.m.tl(jVar)) {
                    if (m.v() != null) {
                        m.v();
                    }
                    com.ss.android.downloadlib.r.b.a().m("download_failed_for_space", f6);
                    if (!f6.F()) {
                        com.ss.android.downloadlib.r.b.a().m("download_can_restart", f6);
                        a(cwVar);
                    }
                    if ((m.v() == null || !m.v().cw()) && (d6 = o.f.c().d(f6.xt())) != null && d6.qv()) {
                        com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
                        if (j6.j("show_no_enough_space_toast", 0) == 1) {
                            this.f37975a.post(new RunnableC0750b(j6, d6));
                        }
                    }
                }
                jVar2 = new com.ss.android.socialbase.downloader.up.j(jVar.j(), a.h.p(jVar.getMessage(), m.f().optInt("exception_msg_length", 500)));
            } else {
                jVar2 = null;
            }
            com.ss.android.downloadlib.r.b.a().u(cwVar, jVar2);
            com.ss.android.downloadlib.c.d().j(cwVar, jVar, "");
        } catch (Exception e6) {
            m.w().j(e6, "onAppDownloadMonitorSend");
        }
    }

    private void a(@NonNull cw cwVar) {
        if (!a.n.o(cwVar.ae())) {
            return;
        }
        com.ss.android.downloadlib.e.c().k(new c.f(cwVar));
    }

    private void b(cw cwVar, com.ss.android.xt.j.xt.b bVar) {
        long i6 = a.h.i(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, a.h.h(Environment.getDataDirectory()) / 10);
        long ka = cwVar.ka();
        double d6 = (ka * 2.5d) + min;
        if (i6 > -1 && ka > -1) {
            double d7 = i6;
            if (d7 < d6 && d6 - d7 > com.ss.android.downloadlib.addownload.j.s()) {
                com.ss.android.downloadlib.addownload.j.f(cwVar.ae());
            }
        }
        com.ss.android.socialbase.downloader.j.j.j().j(new c(bVar, i6, ka, d6, cwVar));
    }
}
