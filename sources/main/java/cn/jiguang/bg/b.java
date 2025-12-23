package cn.jiguang.bg;

import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.bg.c;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.Callable;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements Callable<cn.jiguang.bl.a> {

    /* renamed from: a, reason: collision with root package name */
    private final k f2066a;

    /* renamed from: b, reason: collision with root package name */
    private final p f2067b;

    /* renamed from: c, reason: collision with root package name */
    private final f f2068c;

    /* renamed from: d, reason: collision with root package name */
    private final h f2069d;

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public cn.jiguang.bl.a call() {
        try {
            if (this.f2068c == null) {
                return null;
            }
            return a(this.f2068c.a(this.f2066a.b()));
        } catch (Throwable th) {
            String str = "run e:" + th;
            cn.jiguang.bb.f.i("ConnTask", str);
            c.a.a(this.f2066a.f2099a, 1408, "连接某个ip 未知异常: " + str);
            return null;
        }
    }

    public cn.jiguang.bl.a a(g gVar) {
        cn.jiguang.bl.a cVar;
        if (this.f2067b.a()) {
            return null;
        }
        h hVar = this.f2069d;
        if (hVar == null || hVar.f2085a) {
            this.f2067b.a(new cn.jiguang.bi.e(-991, null));
            return null;
        }
        if (gVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(cn.jiguang.bf.a.f2056n)) {
            String str = cn.jiguang.bf.a.f2056n;
            gVar.f2081a = str;
            gVar.f2083c = InetAddress.getByName(str);
        }
        int i6 = cn.jiguang.bf.a.f2057o;
        if (i6 > 0) {
            gVar.f2082b = i6;
        }
        cn.jiguang.bb.f.d("ConnTask", "Open connection with ip=" + gVar.f2083c + ", port:" + gVar.f2082b);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c.d(this.f2066a.f2099a)) {
            cn.jiguang.bb.f.d("ConnTask", "start connect ssl socket");
            cVar = new cn.jiguang.bl.b(8128, 20);
        } else {
            cVar = new cn.jiguang.bl.c(8128, 20);
        }
        String a6 = cn.jiguang.bq.c.a().a(gVar.f2081a, gVar.f2082b, cVar.f2342g);
        int a7 = cVar.a(gVar.f2081a, gVar.f2082b);
        if (this.f2067b.a()) {
            y.a(cVar);
            cn.jiguang.bq.c.a().d(a6, -991);
            return null;
        }
        if (this.f2069d.f2085a) {
            this.f2067b.a(new cn.jiguang.bi.e(-991, null));
            y.a(cVar);
            cn.jiguang.bq.c.a().d(a6, -991);
            return null;
        }
        cn.jiguang.bq.c.a().d(a6, a7);
        if (a7 == 0) {
            cn.jiguang.e.b.a(this.f2066a.f2099a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.c((gVar.f2083c instanceof Inet4Address) || w.f(gVar.f2081a)).a((cn.jiguang.e.a<String>) gVar.toString())});
            cn.jiguang.bb.f.g("ConnTask", "Succeed to open connection - ip:" + gVar.f2083c + ", port:" + gVar.f2082b);
            this.f2067b.a(cVar);
            e.a(this.f2066a.f2099a, gVar, 1, 0L);
            return cVar;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        this.f2066a.a(2, gVar.f2081a, gVar.f2082b, cn.jiguang.d.b.b(this.f2066a.f2099a), uptimeMillis2, a7);
        String str2 = "Failed(" + a7 + ") to open connection - ip:" + gVar.f2083c + ", port:" + gVar.f2082b + ", cost:" + uptimeMillis2;
        cn.jiguang.bb.f.f("ConnTask", str2);
        e.a(this.f2066a.f2099a, gVar, -1, uptimeMillis2);
        y.a(cVar);
        c.a.a(this.f2066a.f2099a, 1407, "连接某个ip失败: " + str2);
        return null;
    }

    public b(k kVar, p pVar, f fVar, h hVar) {
        this.f2067b = pVar;
        this.f2066a = kVar;
        this.f2068c = fVar;
        this.f2069d = hVar;
    }
}
