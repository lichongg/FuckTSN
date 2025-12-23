package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.g.j.xt;
import com.ss.android.socialbase.downloader.g.qv;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Handler f37746a;

    /* renamed from: b, reason: collision with root package name */
    private o.i f37747b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f37748c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f37749d = new AtomicBoolean(false);

    class a implements l.InterfaceC0749l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37750a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37751b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37752c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f37753d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ l.k f37754e;

        a(int i6, String str, com.ss.android.xt.j.xt.b bVar, long j6, l.k kVar) {
            this.f37750a = i6;
            this.f37751b = str;
            this.f37752c = bVar;
            this.f37753d = j6;
            this.f37754e = kVar;
        }

        @Override // com.ss.android.downloadlib.addownload.l.InterfaceC0749l
        public void j(long j6) {
            j.this.h(this.f37750a, this.f37751b, j6, this.f37752c, this.f37753d, this.f37754e);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.k f37756a;

        b(l.k kVar) {
            this.f37756a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f37748c.get()) {
                return;
            }
            j.this.f37748c.set(true);
            this.f37756a.j();
        }
    }

    class c implements qv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.InterfaceC0749l f37769a;

        c(l.InterfaceC0749l interfaceC0749l) {
            this.f37769a = interfaceC0749l;
        }

        @Override // com.ss.android.socialbase.downloader.g.qv
        public void j(Map<String, String> map) {
            if (j.this.f37748c.get()) {
                return;
            }
            j.this.f37748c.set(true);
            long c6 = j.this.c(map);
            if (c6 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(c6));
                    jSONObject.putOpt("available_space", Long.valueOf(j.r()));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
            this.f37769a.j(c6);
        }
    }

    class d implements c.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37771a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l.k f37772b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f37773c;

        d(com.ss.android.xt.j.xt.b bVar, l.k kVar, String str) {
            this.f37771a = bVar;
            this.f37772b = kVar;
            this.f37773c = str;
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.k f37795a;

        e(l.k kVar) {
            this.f37795a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37795a.j();
        }
    }

    static class f implements c.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cw f37797a;

        f(cw cwVar) {
            this.f37797a = cwVar;
        }
    }

    public interface g {
        boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar, com.ss.android.downloadlib.addownload.j.a aVar);
    }

    public class h implements g {

        /* renamed from: a, reason: collision with root package name */
        private static com.ss.android.downloadlib.addownload.j.c f37798a;

        /* renamed from: b, reason: collision with root package name */
        private static com.ss.android.downloadlib.addownload.j.a f37799b;

        class a implements com.ss.android.downloadlib.addownload.j.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f37800a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f37801b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f37802c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f37803d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ o f37804e;

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void j() {
                com.ss.android.downloadlib.addownload.j.c unused = h.f37798a = null;
                h.this.e(this.f37800a, this.f37801b, this.f37802c, this.f37803d, "download_percent_cancel", "confirm");
            }

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void xt() {
                com.ss.android.downloadlib.addownload.j.c unused = h.f37798a = null;
                h.this.e(this.f37800a, this.f37801b, this.f37802c, this.f37803d, "download_percent_cancel", CommonNetImpl.CANCEL);
                this.f37804e.a(this.f37803d);
            }

            a(int i6, int i7, int i8, com.ss.android.xt.j.xt.b bVar, o oVar) {
                this.f37800a = i6;
                this.f37801b = i7;
                this.f37802c = i8;
                this.f37803d = bVar;
                this.f37804e = oVar;
            }
        }

        class b implements com.ss.android.downloadlib.addownload.j.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f37806a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f37807b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f37808c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f37809d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.ss.android.downloadlib.addownload.j.a f37810e;

            @Override // com.ss.android.downloadlib.addownload.j.a
            public void delete() {
                com.ss.android.downloadlib.addownload.j.c unused = h.f37798a = null;
                h.this.e(this.f37806a, this.f37807b, this.f37808c, this.f37809d, "download_percent_cancel", "delete");
                this.f37810e.delete();
            }

            b(int i6, int i7, int i8, com.ss.android.xt.j.xt.b bVar, com.ss.android.downloadlib.addownload.j.a aVar) {
                this.f37806a = i6;
                this.f37807b = i7;
                this.f37808c = i8;
                this.f37809d = bVar;
                this.f37810e = aVar;
            }
        }

        @Override // com.ss.android.downloadlib.addownload.j.g
        public boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar, com.ss.android.downloadlib.addownload.j.a aVar) {
            if (bVar == null || !h(bVar)) {
                return false;
            }
            cw e6 = !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).u(bVar.j());
            if (e6 == null) {
                return false;
            }
            long uq = e6.uq();
            long ka = e6.ka();
            if (uq < 0 || ka <= 0) {
                return false;
            }
            int a6 = com.ss.android.downloadlib.addownload.h.a(e6.ae(), (int) ((100 * uq) / ka));
            int i7 = (int) (uq / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            boolean z5 = a6 > b(bVar.mi());
            f37798a = new a(a6, i7, i7, bVar, oVar);
            String o5 = a.h.o(com.ss.android.downloadlib.addownload.h.b(bVar.mi(), uq, ka));
            String format = z5 ? String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", o5, a.h.o(ka - uq)) : String.format("该任务已下载%s，即将下载完成，是否继续下载？", o5);
            if (aVar != null) {
                f(new b(a6, i7, i7, bVar, aVar));
            }
            TTDelegateActivity.x(bVar, format, "继续", "暂停", "删除");
            return true;
        }

        public static com.ss.android.downloadlib.addownload.j.c c() {
            return f37798a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i6, int i7, int i8, com.ss.android.xt.j.xt.b bVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", str);
                jSONObject.putOpt("pause_optimise_action", str2);
                jSONObject.putOpt("download_percent", Integer.valueOf(i6));
                jSONObject.putOpt("download_current_bytes", Integer.valueOf(i7));
                jSONObject.putOpt("download_total_bytes", Integer.valueOf(i8));
            } catch (JSONException e6) {
                vl.j(e6);
            }
            com.ss.android.downloadlib.r.b.a().r("pause_cancel_optimise", jSONObject, bVar);
        }

        public static void f(com.ss.android.downloadlib.addownload.j.a aVar) {
            f37799b = aVar;
        }

        public static com.ss.android.downloadlib.addownload.j.a i() {
            return f37799b;
        }

        private int b(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("cancel_pause_optimise_download_percent_value", 50);
        }

        private boolean h(com.ss.android.xt.j.xt.a aVar) {
            if (a.n.k(aVar).j("cancel_pause_optimise_download_percent_retain_switch", 0) != 1 || !aVar.i()) {
                return false;
            }
            return true;
        }
    }

    public interface i {
        boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar);
    }

    /* renamed from: com.ss.android.downloadlib.addownload.j$j, reason: collision with other inner class name */
    public class C0748j implements i {

        /* renamed from: a, reason: collision with root package name */
        private static com.ss.android.downloadlib.addownload.j.c f37812a;

        /* renamed from: com.ss.android.downloadlib.addownload.j$j$a */
        class a implements com.ss.android.downloadlib.addownload.j.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f37813a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ o f37814b;

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void j() {
                com.ss.android.downloadlib.addownload.j.c unused = C0748j.f37812a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                com.ss.android.downloadlib.r.b.a().r("pause_optimise", jSONObject, this.f37813a);
            }

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void xt() {
                com.ss.android.downloadlib.addownload.j.c unused = C0748j.f37812a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", CommonNetImpl.CANCEL);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                com.ss.android.downloadlib.r.b.a().r("pause_optimise", jSONObject, this.f37813a);
                this.f37814b.a(this.f37813a);
            }

            a(com.ss.android.xt.j.xt.b bVar, o oVar) {
                this.f37813a = bVar;
                this.f37814b = oVar;
            }
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar) {
            if (bVar == null || bVar.w0() || !e(bVar)) {
                return false;
            }
            cw e6 = !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).u(bVar.j());
            if (e6 == null) {
                return false;
            }
            long b6 = com.ss.android.downloadlib.addownload.h.b(e6.ae(), e6.uq(), e6.ka());
            long ka = e6.ka();
            if (b6 <= 0 || ka <= 0 || ka > b(bVar.mi())) {
                return false;
            }
            f37812a = new a(bVar, oVar);
            TTDelegateActivity.l(bVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", a.h.o(ka - b6)), "继续", "暂停");
            bVar.S0(true);
            return true;
        }

        public static com.ss.android.downloadlib.addownload.j.c c() {
            return f37812a;
        }

        private int b(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("pause_optimise_apk_size", 100) * 1048576;
        }

        private boolean e(com.ss.android.xt.j.xt.a aVar) {
            if (a.n.k(aVar).j("pause_optimise_apk_size_switch", 0) != 1 || !aVar.i()) {
                return false;
            }
            return true;
        }
    }

    public class k implements i {

        /* renamed from: a, reason: collision with root package name */
        private static com.ss.android.downloadlib.addownload.j.c f37816a;

        class a implements com.ss.android.downloadlib.addownload.j.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f37817a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ o f37818b;

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void j() {
                com.ss.android.downloadlib.addownload.j.c unused = k.f37816a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "download_percent");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                com.ss.android.downloadlib.r.b.a().r("pause_optimise", jSONObject, this.f37817a);
            }

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void xt() {
                com.ss.android.downloadlib.addownload.j.c unused = k.f37816a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "download_percent");
                    jSONObject.putOpt("pause_optimise_action", CommonNetImpl.CANCEL);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                com.ss.android.downloadlib.r.b.a().r("pause_optimise", jSONObject, this.f37817a);
                this.f37818b.a(this.f37817a);
            }

            a(com.ss.android.xt.j.xt.b bVar, o oVar) {
                this.f37817a = bVar;
                this.f37818b = oVar;
            }
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar) {
            int a6;
            if (bVar == null || bVar.c1() || !e(bVar)) {
                return false;
            }
            cw e6 = !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).u(bVar.j());
            if (e6 == null) {
                return false;
            }
            long uq = e6.uq();
            long ka = e6.ka();
            if (uq <= 0 || ka <= 0 || (a6 = com.ss.android.downloadlib.addownload.h.a(e6.ae(), (int) ((uq * 100) / ka))) <= b(bVar.mi())) {
                return false;
            }
            f37816a = new a(bVar, oVar);
            TTDelegateActivity.w(bVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(a6)), "继续", "暂停");
            bVar.j(true);
            return true;
        }

        public static com.ss.android.downloadlib.addownload.j.c c() {
            return f37816a;
        }

        private int b(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("pause_optimise_download_percent", 50);
        }

        private boolean e(com.ss.android.xt.j.xt.a aVar) {
            if (a.n.k(aVar).j("pause_optimise_download_percent_switch", 0) != 1 || !aVar.i()) {
                return false;
            }
            return true;
        }
    }

    public class m {

        /* renamed from: b, reason: collision with root package name */
        private static m f37820b;

        /* renamed from: a, reason: collision with root package name */
        private List<i> f37821a;

        public static m a() {
            if (f37820b == null) {
                synchronized (m.class) {
                    try {
                        if (f37820b == null) {
                            f37820b = new m();
                        }
                    } finally {
                    }
                }
            }
            return f37820b;
        }

        public void b(com.ss.android.xt.j.xt.b bVar, int i6, o oVar) {
            List<i> list = this.f37821a;
            if (list == null || list.size() == 0 || bVar == null) {
                oVar.a(bVar);
                return;
            }
            cw e6 = !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(null).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(null).u(bVar.j());
            if (e6 == null || !"application/vnd.android.package-archive".equals(e6.xw())) {
                oVar.a(bVar);
                return;
            }
            boolean z5 = com.ss.android.socialbase.downloader.jy.j.j(bVar.mi()).j("pause_optimise_switch", 0) == 1;
            for (i iVar : this.f37821a) {
                if (z5 || (iVar instanceof q)) {
                    if (iVar.a(bVar, i6, oVar)) {
                        return;
                    }
                }
            }
            oVar.a(bVar);
        }

        private m() {
            ArrayList arrayList = new ArrayList();
            this.f37821a = arrayList;
            arrayList.add(new l());
            this.f37821a.add(new q());
            this.f37821a.add(new k());
            this.f37821a.add(new C0748j());
        }
    }

    public class n {

        /* renamed from: b, reason: collision with root package name */
        private static n f37822b;

        /* renamed from: a, reason: collision with root package name */
        private List<g> f37823a;

        public static n a() {
            if (f37822b == null) {
                synchronized (m.class) {
                    try {
                        if (f37822b == null) {
                            f37822b = new n();
                        }
                    } finally {
                    }
                }
            }
            return f37822b;
        }

        public void b(com.ss.android.xt.j.xt.b bVar, int i6, o oVar, com.ss.android.downloadlib.addownload.j.a aVar) {
            List<g> list = this.f37823a;
            if (list == null || list.size() == 0 || bVar == null) {
                oVar.a(bVar);
            }
            cw e6 = !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).u(bVar.j());
            if (e6 == null) {
                e6 = ae.xt(com.ss.android.downloadlib.addownload.m.getContext()).tl(bVar.mi());
            }
            if (e6 == null || !"application/vnd.android.package-archive".equals(e6.xw())) {
                oVar.a(bVar);
                return;
            }
            if (new l().a(bVar, i6, oVar)) {
                return;
            }
            Iterator<g> it = this.f37823a.iterator();
            while (it.hasNext()) {
                if (it.next().a(bVar, i6, oVar, aVar)) {
                    return;
                }
            }
            oVar.a(bVar);
        }

        private n() {
            ArrayList arrayList = new ArrayList();
            this.f37823a = arrayList;
            arrayList.add(new p());
            this.f37823a.add(new r());
            this.f37823a.add(new h());
        }
    }

    public interface o {
        void a(com.ss.android.xt.j.xt.b bVar);
    }

    public class p implements g {
        @Override // com.ss.android.downloadlib.addownload.j.g
        public boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar, com.ss.android.downloadlib.addownload.j.a aVar) {
            if (bVar == null) {
                return false;
            }
            return com.ss.android.downloadlib.addownload.b.e(bVar, !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).u(bVar.j()), i6, oVar, true, aVar);
        }
    }

    public class q implements i {
        @Override // com.ss.android.downloadlib.addownload.j.i
        public boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar) {
            if (bVar == null) {
                return false;
            }
            return com.ss.android.downloadlib.addownload.b.e(bVar, !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(null).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(null).u(bVar.j()), i6, oVar, false, null);
        }
    }

    public class r implements g {

        /* renamed from: a, reason: collision with root package name */
        private static com.ss.android.downloadlib.addownload.j.c f37824a;

        /* renamed from: b, reason: collision with root package name */
        private static com.ss.android.downloadlib.addownload.j.a f37825b;

        class a implements com.ss.android.downloadlib.addownload.j.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f37826a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f37827b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f37828c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ o f37829d;

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void j() {
                com.ss.android.downloadlib.addownload.j.c unused = r.f37824a = null;
                r.this.e(this.f37826a, this.f37827b, this.f37828c, "apk_size_cancel", "confirm");
            }

            @Override // com.ss.android.downloadlib.addownload.j.c
            public void xt() {
                com.ss.android.downloadlib.addownload.j.c unused = r.f37824a = null;
                r.this.e(this.f37826a, this.f37827b, this.f37828c, "apk_size_cancel", CommonNetImpl.CANCEL);
                this.f37829d.a(this.f37828c);
            }

            a(int i6, int i7, com.ss.android.xt.j.xt.b bVar, o oVar) {
                this.f37826a = i6;
                this.f37827b = i7;
                this.f37828c = bVar;
                this.f37829d = oVar;
            }
        }

        class b implements com.ss.android.downloadlib.addownload.j.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f37831a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f37832b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f37833c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.ss.android.downloadlib.addownload.j.a f37834d;

            @Override // com.ss.android.downloadlib.addownload.j.a
            public void delete() {
                com.ss.android.downloadlib.addownload.j.c unused = r.f37824a = null;
                r.this.e(this.f37831a, this.f37832b, this.f37833c, "apk_size_cancel", "delete");
                this.f37834d.delete();
            }

            b(int i6, int i7, com.ss.android.xt.j.xt.b bVar, com.ss.android.downloadlib.addownload.j.a aVar) {
                this.f37831a = i6;
                this.f37832b = i7;
                this.f37833c = bVar;
                this.f37834d = aVar;
            }
        }

        @Override // com.ss.android.downloadlib.addownload.j.g
        public boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar, com.ss.android.downloadlib.addownload.j.a aVar) {
            if (bVar == null || !h(bVar)) {
                return false;
            }
            cw e6 = !TextUtils.isEmpty(bVar.h()) ? com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).e(bVar.h(), null, true) : com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext()).u(bVar.j());
            if (e6 == null) {
                return false;
            }
            long b6 = com.ss.android.downloadlib.addownload.h.b(e6.ae(), e6.uq(), e6.ka());
            long ka = e6.ka();
            if (b6 < 0 || ka <= 0 || ka > b(bVar.mi())) {
                return false;
            }
            int i7 = (int) (b6 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            f37824a = new a(i7, i7, bVar, oVar);
            String format = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", a.h.o(ka - b6));
            if (aVar != null) {
                f(new b(i7, i7, bVar, aVar));
            }
            TTDelegateActivity.m(bVar, format, "继续", "暂停", "删除");
            return true;
        }

        public static com.ss.android.downloadlib.addownload.j.c c() {
            return f37824a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i6, int i7, com.ss.android.xt.j.xt.b bVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", str);
                jSONObject.putOpt("pause_optimise_action", str2);
                jSONObject.putOpt("download_current_bytes", Integer.valueOf(i6));
                jSONObject.putOpt("download_total_bytes", Integer.valueOf(i7));
            } catch (JSONException e6) {
                vl.j(e6);
            }
            com.ss.android.downloadlib.r.b.a().r("pause_cancel_optimise", jSONObject, bVar);
        }

        public static void f(com.ss.android.downloadlib.addownload.j.a aVar) {
            f37825b = aVar;
        }

        public static com.ss.android.downloadlib.addownload.j.a i() {
            return f37825b;
        }

        private int b(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("cancel_pause_optimise_apk_size", 100) * 1048576;
        }

        private boolean h(com.ss.android.xt.j.xt.a aVar) {
            if (a.n.k(aVar).j("cancel_pause_optimise_apk_retain_switch", 0) != 1 || !aVar.i()) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(int r13, java.lang.String r14, long r15, com.ss.android.xt.j.xt.b r17, long r18, com.ss.android.downloadlib.addownload.l.k r20) {
        /*
            r12 = this;
            r1 = r15
            r8 = r20
            java.util.concurrent.atomic.AtomicBoolean r0 = r12.f37748c
            r9 = 1
            r0.set(r9)
            r3 = 0
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7d
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r0 = "apk_size"
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch: org.json.JSONException -> L1e
            r3.putOpt(r0, r4)     // Catch: org.json.JSONException -> L1e
            goto L22
        L1e:
            r0 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r0)
        L22:
            double r4 = com.ss.android.downloadlib.a.n.h(r13)
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 + r6
            double r0 = (double) r1
            double r4 = r4 * r0
            java.lang.Double r0 = java.lang.Double.valueOf(r4)
            long r0 = r0.longValue()
            long r4 = com.ss.android.downloadlib.a.n.w(r13)
            long r0 = r0 + r4
            long r4 = r0 - r18
            long r6 = r()
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L7d
            r1 = r12
            r2 = r17
            r1.l(r2, r3, r4, r6)
            k(r2)
            r10 = r4
            r4 = r6
            long r6 = r()
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 >= 0) goto L79
            r2.s0(r9)
            java.lang.String r0 = r2.j()
            com.ss.android.downloadlib.addownload.c$d r3 = com.ss.android.downloadlib.addownload.c.d.b()
            com.ss.android.downloadlib.addownload.j$d r4 = new com.ss.android.downloadlib.addownload.j$d
            r4.<init>(r2, r8, r0)
            r3.f(r0, r4)
            r1 = r12
            r4 = r14
            r3 = r2
            r5 = r10
            r2 = r13
            boolean r13 = r1.p(r2, r3, r4, r5)
            r2 = r3
            if (r13 == 0) goto L7e
            r2.J0(r9)
            goto L7e
        L79:
            r1 = r12
            r1.t(r2, r3, r4, r6)
        L7d:
            r13 = 0
        L7e:
            if (r13 != 0) goto L8a
            android.os.Handler r13 = r12.f37746a
            com.ss.android.downloadlib.addownload.j$e r0 = new com.ss.android.downloadlib.addownload.j$e
            r0.<init>(r8)
            r13.post(r0)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.j.h(int, java.lang.String, long, com.ss.android.xt.j.xt.b, long, com.ss.android.downloadlib.addownload.l$k):void");
    }

    public class l implements i {
        @Override // com.ss.android.downloadlib.addownload.j.i
        public boolean a(com.ss.android.xt.j.xt.b bVar, int i6, o oVar) {
            if (bVar == null || !c(bVar.mi())) {
                return false;
            }
            if (System.currentTimeMillis() - bVar.k() > b(bVar.mi())) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "mistake_click");
            } catch (JSONException e6) {
                vl.j(e6);
            }
            com.ss.android.downloadlib.r.b.a().r("pause_optimise", jSONObject, bVar);
            return true;
        }

        private long b(int i6) {
            return com.ss.android.socialbase.downloader.jy.j.j(i6).j("pause_optimise_mistake_click_interval", 300);
        }

        private boolean c(int i6) {
            if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("pause_optimise_mistake_click_interval_switch", 0) != 1) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return 0L;
    }

    public static JSONObject e(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    private void l(com.ss.android.xt.j.xt.b bVar, JSONObject jSONObject, long j6, long j7) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j7));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j6));
        } catch (JSONException e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().r("clean_space_no_enough_for_download", jSONObject, bVar);
    }

    private void m(String str, com.ss.android.xt.j.xt.b bVar, l.InterfaceC0749l interfaceC0749l) {
        if (interfaceC0749l == null) {
            return;
        }
        xt.j(str, new c(interfaceC0749l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long r() {
        return a.h.I(0L);
    }

    private void t(com.ss.android.xt.j.xt.b bVar, JSONObject jSONObject, long j6, long j7) {
        bVar.M0("1");
        o.d.c().d(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j7 - j6));
        } catch (JSONException e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().r("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }

    void g(int i6, long j6, long j7, l.k kVar) {
        l.k kVar2;
        this.f37749d.set(false);
        if (kVar == null) {
            return;
        }
        if (!a.n.o(i6) || !a.n.t(i6)) {
            kVar.j();
            return;
        }
        long d6 = a.n.d(i6);
        this.f37748c.set(false);
        String j8 = this.f37747b.f37961b.j();
        com.ss.android.xt.j.xt.b t5 = o.f.c().t(j8);
        if (t5 == null) {
            o.i iVar = this.f37747b;
            t5 = new com.ss.android.xt.j.xt.b(iVar.f37961b, iVar.f37962c, iVar.f37963d, 0);
            o.f.c().l(t5);
        }
        com.ss.android.xt.j.xt.b bVar = t5;
        bVar.J0(false);
        if (com.ss.android.downloadlib.addownload.m.v() != null) {
            com.ss.android.downloadlib.addownload.m.v();
        }
        c.d.b().e(bVar.j());
        boolean q5 = a.n.q(i6);
        if (j7 > 0) {
            h(i6, j8, j7, bVar, j6, kVar);
            kVar2 = kVar;
        } else if (q5) {
            kVar2 = kVar;
            m(j8, bVar, new a(i6, j8, bVar, j6, kVar2));
        } else {
            kVar2 = kVar;
            d6 = 0;
        }
        this.f37746a.postDelayed(new b(kVar2), d6);
    }

    public void j(o.i iVar) {
        this.f37747b = iVar;
    }

    public void n(boolean z5) {
        this.f37749d.set(z5);
    }

    public boolean o() {
        return this.f37749d.get();
    }

    j(Handler handler) {
        this.f37746a = handler;
    }

    public static void f(int i6) {
        if (a.n.o(i6) && com.ss.android.downloadlib.addownload.m.v() != null && com.ss.android.downloadlib.addownload.m.v().xt()) {
            com.ss.android.downloadlib.addownload.m.v();
        }
    }

    private static void k(com.ss.android.xt.j.xt.b bVar) {
        long r5 = r();
        if (com.ss.android.downloadlib.addownload.m.v() != null) {
            com.ss.android.downloadlib.addownload.m.v();
        }
        c.b.a();
        c.b.e();
        if (a.n.b(bVar.mi())) {
            c.b.b(com.ss.android.downloadlib.addownload.m.getContext());
        }
        long r6 = r();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(r6 - r5));
        } catch (JSONException e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().r("clean_quite_finish", jSONObject, bVar);
    }

    private boolean p(int i6, @NonNull com.ss.android.xt.j.xt.b bVar, String str, long j6) {
        if (!a.n.o(i6)) {
            return false;
        }
        if (com.ss.android.downloadlib.addownload.m.v() != null) {
            return com.ss.android.downloadlib.addownload.m.v().a(i6, str, true, j6);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().r("cleanspace_window_show", jSONObject, bVar);
        return false;
    }

    public static boolean q(cw cwVar, long j6) {
        int ae = cwVar.ae();
        if (!a.n.o(ae) || com.ss.android.downloadlib.addownload.m.v() == null) {
            return false;
        }
        boolean a6 = com.ss.android.downloadlib.addownload.m.v().a(ae, cwVar.oq(), false, j6);
        if (a6) {
            c.d.b().f(cwVar.oq(), new f(cwVar));
        }
        return a6;
    }

    public static long s() {
        if (com.ss.android.downloadlib.addownload.m.v() != null) {
            return com.ss.android.downloadlib.addownload.m.v().j();
        }
        return 0L;
    }
}
