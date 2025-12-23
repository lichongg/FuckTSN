package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.j;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.r.mi;
import com.ss.android.socialbase.downloader.r.w;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static String f37610b = "c";

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f37611c;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Long, Runnable> f37612a;

    class a implements j.InterfaceC0759j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f37613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.b f37615c;

        a(l lVar, int i6, com.ss.android.j.j.cw.b bVar) {
            this.f37613a = lVar;
            this.f37614b = i6;
            this.f37615c = bVar;
        }

        @Override // com.ss.android.downloadlib.j.InterfaceC0759j
        public void j(boolean z5) {
            c.this.d(this.f37613a, z5, this.f37614b, this.f37615c);
        }
    }

    public class b {
        /* JADX WARN: Removed duplicated region for block: B:24:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void c(java.io.File r3) {
            /*
                r0 = 0
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
                r1.<init>(r3)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
                java.lang.String r0 = "1"
                byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
                r1.write(r0)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
                r1.close()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
                goto L2b
            L13:
                r3 = move-exception
                r0 = r1
                goto L2f
            L16:
                r0 = move-exception
                goto L1e
            L18:
                r3 = move-exception
                goto L2f
            L1a:
                r1 = move-exception
                r2 = r1
                r1 = r0
                r0 = r2
            L1e:
                com.bytedance.sdk.component.utils.vl.j(r0)     // Catch: java.lang.Throwable -> L13
                if (r1 == 0) goto L2b
                r1.close()     // Catch: java.lang.Exception -> L27
                goto L2b
            L27:
                r0 = move-exception
                com.bytedance.sdk.component.utils.vl.j(r0)
            L2b:
                r3.delete()
                return
            L2f:
                if (r0 == 0) goto L39
                r0.close()     // Catch: java.lang.Exception -> L35
                goto L39
            L35:
                r0 = move-exception
                com.bytedance.sdk.component.utils.vl.j(r0)
            L39:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.c.b.c(java.io.File):void");
        }

        public static void b(Context context) {
            File externalCacheDir;
            if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
                return;
            }
            try {
                d(externalCacheDir.getPath());
            } catch (Exception e6) {
                vl.j(e6);
            }
        }

        private static void d(String str) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                    return;
                }
                String[] list = file.list();
                if (list == null) {
                    return;
                }
                for (String str2 : list) {
                    if (str2 != null) {
                        String str3 = File.separator;
                        String str4 = str.endsWith(str3) ? str + str2 : str + str3 + str2;
                        File file2 = new File(str4);
                        if (file2.isFile()) {
                            file2.delete();
                        }
                        if (file2.isDirectory()) {
                            d(str4);
                        }
                    }
                }
                file.delete();
            }
        }

        public static void a() {
            List<cw> n6 = com.ss.android.socialbase.appdownloader.f.L().n(m.getContext());
            if (n6 != null && n6.size() > 0) {
                for (int i6 = 0; i6 < n6.size(); i6++) {
                    cw cwVar = n6.get(i6);
                    File file = new File(cwVar.vl(), cwVar.jy());
                    long lastModified = file.lastModified();
                    long j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("download_file_expire_hours", 0) * 3600000;
                    if (j6 <= 0) {
                        j6 = bn.f10748d;
                    }
                    if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= j6) {
                        c(file);
                        ae.xt(m.getContext()).oq(cwVar.ae());
                    }
                }
            }
        }

        public static void e() {
            List xt = ae.xt(m.getContext()).xt("application/vnd.android.package-archive");
            if (xt != null && !xt.isEmpty()) {
                for (int i6 = 0; i6 < xt.size(); i6++) {
                    cw cwVar = (cw) xt.get(i6);
                    if (cwVar != null) {
                        String str = cwVar.qv() + File.separator + cwVar.tl();
                        File file = new File(str);
                        if (file.exists()) {
                            long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                            long j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("download_complete_file_expire_hours", 0) * 3600000;
                            if (j6 <= 0) {
                                j6 = bn.f10748d;
                            }
                            if (currentTimeMillis >= j6 || a.h.C(m.getContext(), str)) {
                                c(file);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.c$c, reason: collision with other inner class name */
    public class C0742c implements mi {

        /* renamed from: a, reason: collision with root package name */
        private int f37617a;

        private boolean d(com.ss.android.socialbase.downloader.jy.j jVar) {
            if (jVar.j("clear_space_use_disk_handler", 0) != 1) {
                return false;
            }
            return System.currentTimeMillis() - d.b().h() >= jVar.j("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
        }

        private long e(com.ss.android.socialbase.downloader.jy.j jVar) {
            long j6 = jVar.j("clear_space_sleep_time", 0L);
            if (j6 <= 0) {
                return 0L;
            }
            if (j6 > 5000) {
                j6 = 5000;
            }
            a.k.e("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(j6)), null);
            try {
                Thread.sleep(j6);
            } catch (InterruptedException e6) {
                vl.j(e6);
            }
            a.k.e("AppDownloadDiskSpaceHandler", "waiting end!", null);
            return j6;
        }

        public void b(int i6) {
            this.f37617a = i6;
        }

        @Override // com.ss.android.socialbase.downloader.r.mi
        public boolean j(long j6, long j7, w wVar) {
            com.ss.android.socialbase.downloader.jy.j j8 = com.ss.android.socialbase.downloader.jy.j.j(this.f37617a);
            if (!d(j8)) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.b().a();
            long j9 = 0;
            long I = a.h.I(0L);
            a();
            long I2 = a.h.I(0L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (I2 < j7) {
                long e6 = e(j8);
                if (e6 > 0) {
                    I2 = a.h.I(0L);
                }
                j9 = e6;
            }
            long j10 = I2;
            a.k.e("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j7 + ", byteAvailableAfter = " + j10 + ", cleaned = " + (j10 - I), null);
            c(I, j10, j7, currentTimeMillis2, j9);
            if (j10 < j7) {
                return false;
            }
            if (wVar == null) {
                return true;
            }
            wVar.j();
            return true;
        }

        private void a() {
            m.b();
            b.a();
            b.e();
        }

        private void c(long j6, long j7, long j8, long j9, long j10) {
            boolean z5;
            cw tl = ae.xt(m.getContext()).tl(this.f37617a);
            if (tl == null) {
                return;
            }
            if (j7 > j8) {
                z5 = true;
            } else {
                z5 = false;
            }
            try {
                com.ss.android.downloadlib.d.d().l(tl, j6, j7, j8, j9, j10, z5);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public class d {

        /* renamed from: e, reason: collision with root package name */
        private static volatile d f37618e;

        /* renamed from: a, reason: collision with root package name */
        private long f37619a = 0;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<String, e> f37620b = new ConcurrentHashMap<>();

        /* renamed from: c, reason: collision with root package name */
        private HashMap<String, Integer> f37621c = new HashMap<>();

        /* renamed from: d, reason: collision with root package name */
        private List<String> f37622d = new CopyOnWriteArrayList();

        public static d b() {
            if (f37618e == null) {
                synchronized (d.class) {
                    try {
                        if (f37618e == null) {
                            f37618e = new d();
                        }
                    } finally {
                    }
                }
            }
            return f37618e;
        }

        @WorkerThread
        public static void c(cw cwVar) {
            if (cwVar == null || com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("delete_file_after_install", 0) == 0) {
                return;
            }
            try {
                String str = cwVar.qv() + File.separator + cwVar.tl();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File file = new File(str);
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }

        @WorkerThread
        public static void d(com.ss.android.xt.j.xt.b bVar) {
            cw tl;
            if (bVar == null || bVar.xt() <= 0 || (tl = ae.xt(m.getContext()).tl(bVar.mi())) == null) {
                return;
            }
            c(tl);
        }

        long h() {
            return this.f37619a;
        }

        void a() {
            this.f37619a = System.currentTimeMillis();
        }

        public void e(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f37620b.remove(str);
            }
        }

        public void f(String str, e eVar) {
            if (!TextUtils.isEmpty(str)) {
                this.f37620b.put(str, eVar);
            }
        }

        public int g(String str) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (this.f37621c == null) {
                this.f37621c = new HashMap<>();
            }
            if (!this.f37621c.containsKey(str)) {
                return 0;
            }
            return this.f37621c.get(str).intValue();
        }
    }

    public interface e {
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private cw f37623a;

        class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f37624a;

            a(com.ss.android.xt.j.xt.b bVar) {
                this.f37624a = bVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.xt.j.xt.b f6;
            if (this.f37623a == null || (f6 = o.f.c().f(this.f37623a)) == null) {
                return;
            }
            com.ss.android.downloadlib.r.b.a().m("cleanspace_task", f6);
            long longValue = Double.valueOf((a.n.h(this.f37623a.ae()) + 1.0d) * this.f37623a.ka()).longValue() - this.f37623a.uq();
            long I = a.h.I(0L);
            if (m.v() != null) {
                m.v();
            }
            b.a();
            b.e();
            if (a.n.b(f6.mi())) {
                b.b(m.getContext());
            }
            long I2 = a.h.I(0L);
            if (I2 >= longValue) {
                f6.M0("1");
                o.d.c().d(f6);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("quite_clean_size", Long.valueOf(I2 - I));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                com.ss.android.downloadlib.r.b.a().r("cleanspace_download_after_quite_clean", jSONObject, f6);
                ae.xt(m.getContext()).up(this.f37623a.ae());
                return;
            }
            if (m.v() != null) {
                f6.s0(false);
                d.b().f(f6.j(), new a(f6));
                if (m.v().a(this.f37623a.ae(), this.f37623a.oq(), true, longValue)) {
                    f6.J0(true);
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e7) {
                vl.j(e7);
            }
            com.ss.android.downloadlib.r.b.a().r("cleanspace_window_show", jSONObject2, f6);
        }

        public f(cw cwVar) {
            this.f37623a = cwVar;
        }
    }

    public static c a() {
        if (f37611c == null) {
            synchronized (c.class) {
                try {
                    if (f37611c == null) {
                        f37611c = new c();
                    }
                } finally {
                }
            }
        }
        return f37611c;
    }

    public static boolean e(cw cwVar) {
        return cwVar == null || cwVar.i() == 0 || cwVar.i() == -4;
    }

    public void d(l lVar, boolean z5, int i6, com.ss.android.j.j.cw.b bVar) {
        if (bVar instanceof com.ss.android.xt.j.j.a) {
            ((com.ss.android.xt.j.j.a) bVar).e(3);
        }
        long r5 = bVar.r();
        if (i6 == 4) {
            if (z5) {
                b(r5, true, 2);
                return;
            } else {
                b(r5, false, 2);
                lVar.X(false);
                return;
            }
        }
        if (i6 == 5) {
            if (z5) {
                b(r5, true, 1);
                return;
            } else {
                b(r5, false, 1);
                lVar.n(false);
                return;
            }
        }
        if (i6 != 7) {
            return;
        }
        Runnable remove = this.f37612a.remove(Long.valueOf(r5));
        if (z5) {
            com.ss.android.downloadlib.r.b.a().c(r5, 1);
            b(r5, true, 1);
        } else {
            if (remove != null) {
                com.ss.android.downloadlib.c.d().s().post(remove);
            }
            b(r5, false, 1);
        }
    }

    public c() {
        this.f37612a = null;
        this.f37612a = new ConcurrentHashMap<>();
    }

    private void b(long j6, boolean z5, int i6) {
        com.ss.android.downloadlib.r.b.a().f(j6, z5, i6);
        if (z5) {
            m.C();
        }
    }

    public void c(l lVar, int i6, com.ss.android.j.j.cw.b bVar) {
        j.l.b().d(new a(lVar, i6, bVar), f());
    }

    public long f() {
        return m.f().optLong("quick_app_check_internal", 1200L);
    }
}
