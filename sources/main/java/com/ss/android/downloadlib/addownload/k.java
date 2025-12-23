package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.j;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.ae.up;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.notification.xt;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w2.t;

/* loaded from: D:\Downloads\app\classes6.dex */
public class k implements a.p.InterfaceC0739a {

    /* renamed from: a, reason: collision with root package name */
    private long f37836a;

    /* renamed from: b, reason: collision with root package name */
    public o.i f37837b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f37838c = false;

    /* renamed from: d, reason: collision with root package name */
    private l f37839d;

    /* renamed from: e, reason: collision with root package name */
    private e f37840e;

    class a implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f37841a;

        @Override // w2.t
        public void j() {
            this.f37841a.j();
        }

        a(t tVar) {
            this.f37841a = tVar;
        }

        @Override // w2.t
        public void j(String str) {
            m.d().j(1, m.getContext(), k.this.f37837b.f37961b, "您已禁止使用存储权限，请授权后再下载", null, 1);
            com.ss.android.downloadlib.r.b.a().t(k.this.f37836a, 1);
            this.f37841a.j(str);
        }
    }

    class b implements a.j.InterfaceC0734a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f37843a;

        @Override // com.ss.android.downloadlib.a.j.InterfaceC0734a
        public void j() {
            t tVar = this.f37843a;
            if (tVar != null) {
                tVar.j();
            }
        }

        b(t tVar) {
            this.f37843a = tVar;
        }

        @Override // com.ss.android.downloadlib.a.j.InterfaceC0734a
        public void j(String str) {
            t tVar = this.f37843a;
            if (tVar != null) {
                tVar.j(str);
            }
        }
    }

    class c implements e {
        c() {
        }

        @Override // com.ss.android.downloadlib.addownload.k.e
        public void j(cw cwVar) {
            com.ss.android.downloadlib.r.b.a().d(k.this.f37836a, 2, cwVar);
        }
    }

    static class d extends com.ss.android.socialbase.downloader.r.j {

        /* renamed from: a, reason: collision with root package name */
        private a.p f37846a;

        @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
        public void cw(cw cwVar) {
            a(cwVar, 4);
        }

        @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
        public void j(cw cwVar) {
            a(cwVar, 1);
        }

        @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
        public void m(cw cwVar) {
            a(cwVar, -4);
        }

        @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
        public void r(cw cwVar) {
            a(cwVar, -2);
        }

        @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
        public void up(cw cwVar) {
            a(cwVar, -3);
        }

        @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
        public void xt(cw cwVar) {
            a(cwVar, 2);
        }

        @Override // com.ss.android.socialbase.downloader.r.j, com.ss.android.socialbase.downloader.r.kt
        public void ae(cw cwVar) {
            a(cwVar, 11);
        }

        @Override // com.ss.android.socialbase.downloader.r.cw, com.ss.android.socialbase.downloader.r.a
        public void j(cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
            a(cwVar, -1);
        }

        d(a.p pVar) {
            this.f37846a = pVar;
        }

        private void a(cw cwVar, int i6) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = cwVar;
            obtain.arg1 = i6;
            this.f37846a.sendMessage(obtain);
        }
    }

    public interface e {
        void j(cw cwVar);
    }

    int c(Context context, com.ss.android.socialbase.downloader.r.a aVar) {
        c.C0742c c0742c;
        up e6;
        if (context == null) {
            return 0;
        }
        Map<String, String> oq = this.f37837b.f37961b.oq();
        ArrayList arrayList = new ArrayList();
        if (m.f().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.f37837b.f37961b.ch()) && (e6 = e(this.f37837b.f37961b.ch())) != null) {
            arrayList.add(e6);
        }
        if (oq != null) {
            for (Map.Entry<String, String> entry : oq.entrySet()) {
                if (entry != null) {
                    arrayList.add(new up(entry.getKey(), entry.getValue()));
                }
            }
        }
        String a6 = a.l.a(String.valueOf(this.f37837b.f37961b.r()), this.f37837b.f37961b.cw(), this.f37837b.f37961b.qv(), String.valueOf(this.f37837b.f37961b.la()));
        com.ss.android.socialbase.downloader.jy.j x5 = a.n.x(this.f37837b.f37961b);
        JSONObject m6 = a.n.m(this.f37837b.f37961b);
        if (!this.f37837b.f37963d.az()) {
            m6 = a.h.r(m6);
            a.h.u(m6, "ah_plans", new JSONArray());
        }
        int ed = this.f37837b.f37961b.ed();
        if (this.f37837b.f37961b.x() || com.ss.android.downloadlib.addownload.d.l(this.f37837b.f37961b)) {
            ed = 4;
        }
        String f6 = f(x5);
        cw tl = ae.xt(m.getContext()).tl(com.ss.android.socialbase.downloader.downloader.cw.j(this.f37837b.f37961b.j(), f6));
        if (tl != null && 3 == this.f37837b.f37961b.la()) {
            tl.g(true);
        }
        com.ss.android.socialbase.appdownloader.e g6 = new com.ss.android.socialbase.appdownloader.e(context, this.f37837b.f37961b.j()).P0(this.f37837b.f37961b.xt()).I(this.f37837b.f37961b.tl()).B0(a6).J(arrayList).L(this.f37837b.f37961b.vl()).n(this.f37837b.f37961b.jy()).O0(this.f37837b.f37961b.av()).m(f6).j0(this.f37837b.f37961b.a()).w0(this.f37837b.f37961b.up()).d0(this.f37837b.f37961b.n()).C(this.f37837b.f37961b.m()).D(aVar).F0(this.f37837b.f37961b.tj() || x5.j("need_independent_process", 0) == 1).F(this.f37837b.f37961b.wq()).Q0(this.f37837b.f37961b.rn()).b(this.f37837b.f37961b.s()).m0(1000).A0(100).K(m6).u(true).e0(true).N0(x5.j("retry_count", 5)).l(x5.j("backup_url_retry_count", 0)).e0(true).O(x5.j("need_head_connection", 0) == 1).o0(x5.j("need_https_to_http_retry", 0) == 1).x0(x5.j("need_chunk_downgrade_retry", 1) == 1).c(x5.j("need_retry_delay", 0) == 1).t(x5.cw("retry_delay_time_array")).k0(x5.j("need_reuse_runnable", 0) == 1).V(ed).e(this.f37837b.f37961b.nd()).g(this.f37837b.f37961b.rh());
        if (TextUtils.isEmpty(this.f37837b.f37961b.g())) {
            g6.W("application/vnd.android.package-archive");
        } else {
            g6.W(this.f37837b.f37961b.g());
        }
        if (x5.j("notification_opt_2", 0) == 1) {
            g6.L(false);
            g6.Q0(true);
        }
        if (x5.j("clear_space_use_disk_handler", 0) == 1) {
            c0742c = new c.C0742c();
            g6.E(c0742c);
        } else {
            c0742c = null;
        }
        com.ss.android.j.j.cw.b bVar = this.f37837b.f37961b;
        if ((bVar instanceof com.ss.android.xt.j.j.a) && !TextUtils.isEmpty(((com.ss.android.xt.j.j.a) bVar).k())) {
            g6.n0(((com.ss.android.xt.j.j.a) this.f37837b.f37961b).k());
        }
        int b6 = com.ss.android.downloadlib.addownload.d.b(this.f37837b, b(), g6);
        if (c0742c != null) {
            c0742c.b(b6);
        }
        return b6;
    }

    public void l(cw cwVar) {
        this.f37838c = false;
        B(cwVar);
    }

    @NonNull
    public static List<com.ss.android.j.j.cw.f> A(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.j.j.cw.f) {
                    arrayList.add((com.ss.android.j.j.cw.f) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.j.j.cw.f) {
                            arrayList.add((com.ss.android.j.j.cw.f) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.j.j.cw.f) {
                            arrayList.add((com.ss.android.j.j.cw.f) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void C(t tVar) {
        String str;
        if (a.j.f(com.kuaishou.weapon.p0.g.f36050j)) {
            if (tVar != null) {
                tVar.j();
                return;
            }
            return;
        }
        if (a.h.v()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (a.j.f("android.permission.READ_MEDIA_IMAGES") || a.j.f("android.permission.READ_MEDIA_AUDIO") || a.j.f("android.permission.READ_MEDIA_VIDEO")) {
                if (tVar != null) {
                    tVar.j();
                    return;
                }
                return;
            }
        } else {
            str = com.kuaishou.weapon.p0.g.f36049i;
        }
        a.j.e(new String[]{str}, new b(tVar));
    }

    private up e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new up("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e6) {
            m.w().j(e6, "parseLogExtra Error");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r4.startsWith(r3) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String f(com.ss.android.socialbase.downloader.jy.j r9) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.k.f(com.ss.android.socialbase.downloader.jy.j):java.lang.String");
    }

    @NonNull
    public static List<com.ss.android.j.j.cw.e> g(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.j.j.cw.e) {
                    arrayList.add((com.ss.android.j.j.cw.e) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.j.j.cw.e) {
                            arrayList.add((com.ss.android.j.j.cw.e) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.j.j.cw.e) {
                            arrayList.add((com.ss.android.j.j.cw.e) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean t() {
        return a.h.z(this.f37837b.f37961b) && com.ss.android.downloadlib.addownload.d.f(this.f37837b.f37963d.j());
    }

    private boolean u(cw cwVar) {
        return cwVar != null && cwVar.i() == -3 && com.ss.android.socialbase.downloader.az.m.r(cwVar.qv(), cwVar.tl());
    }

    private boolean v() {
        com.ss.android.j.j.cw.b bVar = this.f37837b.f37961b;
        return (bVar == null || TextUtils.isEmpty(bVar.s()) || TextUtils.isEmpty(this.f37837b.f37961b.j())) ? false : true;
    }

    private boolean x() {
        return this.f37837b.f37963d.r();
    }

    private boolean y(cw cwVar) {
        return !a.h.z(this.f37837b.f37961b) && u(cwVar);
    }

    public void B(@Nullable cw cwVar) {
        e eVar = this.f37840e;
        if (eVar != null) {
            eVar.j(cwVar);
            this.f37840e = null;
        }
    }

    void a(cw cwVar) {
        if (!com.ss.android.downloadlib.addownload.d.g(this.f37837b.f37961b) || this.f37838c) {
            return;
        }
        com.ss.android.downloadlib.r.b.a().j("file_status", (cwVar == null || !a.h.N(cwVar.ws())) ? 2 : 1, this.f37837b);
        this.f37838c = true;
    }

    void h() {
        if (this.f37840e == null) {
            this.f37840e = new c();
        }
    }

    public void i(long j6) {
        this.f37836a = j6;
        o.i r5 = o.f.c().r(j6);
        this.f37837b = r5;
        if (r5.b()) {
            com.ss.android.downloadlib.up.a.a().c("setAdId ModelBox notValid");
        }
    }

    void k(Message message, com.ss.android.j.j.up.e eVar, Map<Integer, Object> map) {
        e eVar2;
        if (message == null || message.what != 3) {
            return;
        }
        cw cwVar = (cw) message.obj;
        int i6 = message.arg1;
        if (i6 != 1 && i6 != 6 && i6 == 2) {
            if (cwVar.fp()) {
                com.ss.android.downloadlib.c d6 = com.ss.android.downloadlib.c.d();
                o.i iVar = this.f37837b;
                d6.h(iVar.f37961b, iVar.f37963d, iVar.f37962c);
                cwVar.g(false);
            }
            com.ss.android.downloadlib.r.b.a().h(cwVar);
        }
        eVar.a(cwVar);
        h.c(eVar);
        int f6 = com.ss.android.socialbase.appdownloader.b.f(cwVar.i());
        long ka = cwVar.ka();
        int uq = ka > 0 ? (int) ((cwVar.uq() * 100) / ka) : 0;
        if ((ka > 0 || com.ss.android.socialbase.downloader.jy.j.cw().j("fix_click_start")) && (eVar2 = this.f37840e) != null) {
            eVar2.j(cwVar);
            this.f37840e = null;
        }
        for (com.ss.android.j.j.cw.e eVar3 : g(map)) {
            if (f6 != 1) {
                if (f6 == 2) {
                    eVar3.onDownloadPaused(eVar, h.a(cwVar.ae(), uq));
                } else if (f6 == 3) {
                    if (cwVar.i() == -4) {
                        eVar3.j();
                    } else if (cwVar.i() == -1) {
                        eVar3.onDownloadFailed(eVar);
                    } else if (cwVar.i() == -3) {
                        if (a.h.z(this.f37837b.f37961b)) {
                            eVar3.onInstalled(eVar);
                        } else {
                            eVar3.onDownloadFinished(eVar);
                        }
                    }
                }
            } else if (cwVar.i() != 11) {
                eVar3.onDownloadActive(eVar, h.a(cwVar.ae(), uq));
            } else {
                Iterator<com.ss.android.j.j.cw.f> it = A(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    void n(cw cwVar, boolean z5) {
        if (this.f37837b.f37961b == null || cwVar == null || cwVar.ae() == 0) {
            return;
        }
        int i6 = cwVar.i();
        if (i6 == -1 || i6 == -4) {
            com.ss.android.downloadlib.r.b.a().c(this.f37836a, 2);
        } else if (com.ss.android.downloadlib.addownload.d.g(this.f37837b.f37961b) || (z5 && com.ss.android.downloadlib.r.a.c().b() && (i6 == -2 || i6 == -3))) {
            com.ss.android.downloadlib.r.b.a().c(this.f37836a, 2);
        }
        switch (i6) {
            case -4:
            case -1:
                h();
                o.f c6 = o.f.c();
                o.i iVar = this.f37837b;
                c6.l(new com.ss.android.xt.j.xt.b(iVar.f37961b, iVar.f37962c, iVar.f37963d, cwVar.ae()));
                break;
            case -3:
                if (!a.h.z(this.f37837b.f37961b)) {
                    com.ss.android.downloadlib.r.b.a().d(this.f37836a, 5, cwVar);
                    if (z5 && com.ss.android.downloadlib.r.a.c().e() && !com.ss.android.downloadlib.r.a.c().f(this.f37836a, this.f37837b.f37961b.ch())) {
                        com.ss.android.downloadlib.r.b.a().c(this.f37836a, 2);
                        break;
                    }
                } else {
                    com.ss.android.downloadlib.up.a.a().f("SUCCESSED isInstalledApp");
                    break;
                }
                break;
            case -2:
                com.ss.android.downloadlib.r.b.a().d(this.f37836a, 4, cwVar);
                if (z5 && com.ss.android.downloadlib.r.a.c().e() && !com.ss.android.downloadlib.r.a.c().f(this.f37836a, this.f37837b.f37961b.ch())) {
                    com.ss.android.downloadlib.r.b.a().c(this.f37836a, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.r.b.a().d(this.f37836a, 3, cwVar);
                break;
        }
    }

    void o(@NonNull t tVar) {
        if (!TextUtils.isEmpty(this.f37837b.f37961b.az())) {
            String az = this.f37837b.f37961b.az();
            if (az.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                tVar.j();
                return;
            }
            try {
                String parent = m.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (az.startsWith(parent)) {
                    tVar.j();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        C(new a(tVar));
    }

    public boolean p(int i6) {
        if (this.f37837b.f37963d.xt() == 2 && i6 == 2) {
            return true;
        }
        return this.f37837b.f37963d.xt() == 2 && i6 == 1 && m.f().optInt("disable_lp_if_market", 0) == 1;
    }

    boolean r(Context context, int i6, boolean z5) {
        if (a.h.z(this.f37837b.f37961b)) {
            com.ss.android.xt.j.xt.b q5 = o.f.c().q(this.f37837b.f37960a);
            if (q5 != null) {
                xt.j().m(q5.mi());
            }
            return j.g.g(this.f37837b);
        }
        if (p(i6) && !TextUtils.isEmpty(this.f37837b.f37961b.s()) && m.f().optInt("disable_market") != 1) {
            if (j.g.h(this.f37837b, i6)) {
                return true;
            }
            return this.f37839d.q() && this.f37839d.N(true);
        }
        if (!z5 || this.f37837b.f37963d.xt() != 4 || this.f37839d.S()) {
            return false;
        }
        this.f37839d.n(true);
        return true;
    }

    boolean s(boolean z5) {
        return !z5 && this.f37837b.f37963d.xt() == 1;
    }

    public k(l lVar) {
        this.f37839d = lVar;
    }

    private boolean b() {
        if (v() && x()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m(com.ss.android.socialbase.downloader.ae.cw r7, com.ss.android.j.j.up.e r8, java.util.List<com.ss.android.j.j.cw.e> r9, boolean r10) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L8
            goto Lae
        L8:
            if (r7 == 0) goto L9a
            if (r8 != 0) goto Le
            goto L9a
        Le:
            r0 = 0
            long r1 = r7.ka()     // Catch: java.lang.Exception -> L28
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L2c
            long r1 = r7.uq()     // Catch: java.lang.Exception -> L28
            r3 = 100
            long r1 = r1 * r3
            long r3 = r7.ka()     // Catch: java.lang.Exception -> L28
            long r1 = r1 / r3
            int r2 = (int) r1
            goto L2d
        L28:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)
        L2c:
            r2 = 0
        L2d:
            if (r2 >= 0) goto L30
            goto L31
        L30:
            r0 = r2
        L31:
            r8.a(r7)
            com.ss.android.downloadlib.addownload.h.c(r8)
            java.util.Iterator r9 = r9.iterator()
        L3b:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto Lae
            java.lang.Object r1 = r9.next()
            com.ss.android.j.j.cw.e r1 = (com.ss.android.j.j.cw.e) r1
            int r2 = r7.i()
            switch(r2) {
                case -4: goto L85;
                case -3: goto L7b;
                case -2: goto L6f;
                case -1: goto L6b;
                case 0: goto L85;
                case 1: goto L5f;
                case 2: goto L5f;
                case 3: goto L5f;
                case 4: goto L5f;
                case 5: goto L5f;
                case 6: goto L4e;
                case 7: goto L5f;
                case 8: goto L5f;
                case 9: goto L4e;
                case 10: goto L4e;
                case 11: goto L4f;
                default: goto L4e;
            }
        L4e:
            goto L3b
        L4f:
            boolean r2 = r1 instanceof com.ss.android.j.j.cw.f
            if (r2 != 0) goto L3b
            int r2 = r7.ae()
            int r2 = com.ss.android.downloadlib.addownload.h.a(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3b
        L5f:
            int r2 = r7.ae()
            int r2 = com.ss.android.downloadlib.addownload.h.a(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3b
        L6b:
            r1.onDownloadFailed(r8)
            goto L3b
        L6f:
            int r2 = r7.ae()
            int r2 = com.ss.android.downloadlib.addownload.h.a(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3b
        L7b:
            if (r10 == 0) goto L81
            r1.onInstalled(r8)
            goto L3b
        L81:
            r1.onDownloadFinished(r8)
            goto L3b
        L85:
            com.ss.android.downloadlib.addownload.o$i r2 = r6.f37837b
            com.ss.android.j.j.cw.b r2 = r2.f37961b
            boolean r2 = com.ss.android.downloadlib.a.h.z(r2)
            if (r2 == 0) goto L96
            r2 = -3
            r8.f38315b = r2
            r1.onInstalled(r8)
            goto L3b
        L96:
            r1.j()
            goto L3b
        L9a:
            java.util.Iterator r7 = r9.iterator()
        L9e:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lae
            java.lang.Object r8 = r7.next()
            com.ss.android.j.j.cw.e r8 = (com.ss.android.j.j.cw.e) r8
            r8.j()
            goto L9e
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.k.m(com.ss.android.socialbase.downloader.ae.cw, com.ss.android.j.j.up.e, java.util.List, boolean):void");
    }

    public boolean q(int i6, com.ss.android.j.j.cw.b bVar) {
        if (com.ss.android.socialbase.appdownloader.m.e.e() && p(i6) && !a.h.z(bVar)) {
            return true;
        }
        return false;
    }

    boolean w(cw cwVar) {
        if (!t() && !y(cwVar)) {
            return false;
        }
        return true;
    }

    @Nullable
    public String z() {
        File externalFilesDir = m.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            if (externalFilesDir.exists()) {
                return externalFilesDir.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.downloadlib.a.p.InterfaceC0739a
    public void j(Message message) {
    }
}
