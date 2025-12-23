package cn.jiguang.bg;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.bg.c;
import cn.jiguang.bz.y;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private k f2094b;

    /* renamed from: c, reason: collision with root package name */
    private h f2095c;

    /* renamed from: f, reason: collision with root package name */
    private o f2098f;

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashSet<g> f2093a = new LinkedHashSet<>();

    /* renamed from: d, reason: collision with root package name */
    private p f2096d = new p(5, 2000, null, "ssn");

    /* renamed from: e, reason: collision with root package name */
    private f f2097e = new f();

    private LinkedHashSet<g> c() {
        String a6;
        LinkedList a7;
        try {
            a6 = cn.jiguang.bf.a.a(this.f2094b.f2099a);
            cn.jiguang.bb.f.c("SisConn", "load Default Conn, from host=" + a6);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        cn.jiguang.bj.b a8 = cn.jiguang.bj.b.a();
        k kVar = this.f2094b;
        InetAddress[] b6 = a8.b(kVar.f2099a, a6, 3000L, kVar.a());
        if (b6 != null && b6.length != 0 && (a7 = y.a((Collection) Arrays.asList(b6))) != null && !a7.isEmpty()) {
            String hostAddress = ((InetAddress) a7.get(0)).getHostAddress();
            LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
            linkedHashSet.add(new g(hostAddress, 7000));
            linkedHashSet.add(new g(hostAddress, 7002));
            linkedHashSet.add(new g(hostAddress, 7003));
            linkedHashSet.add(new g(hostAddress, 7004));
            linkedHashSet.add(new g(hostAddress, 7005));
            linkedHashSet.add(new g(hostAddress, 7006));
            linkedHashSet.add(new g(hostAddress, 7007));
            linkedHashSet.add(new g(hostAddress, 7008));
            linkedHashSet.add(new g(hostAddress, 7009));
            return linkedHashSet;
        }
        return null;
    }

    public cn.jiguang.bl.a a(h hVar) {
        this.f2095c = hVar;
        cn.jiguang.bb.f.e("SisConn", "start sisAndConnect...");
        this.f2097e = new f();
        long uptimeMillis = SystemClock.uptimeMillis() + 12000;
        boolean d6 = c.d(this.f2094b.f2099a);
        LinkedHashSet<g> c6 = g.c((String) cn.jiguang.e.b.a(this.f2094b.f2099a, d6 ? cn.jiguang.e.a.ar() : cn.jiguang.e.a.aq()));
        boolean z5 = (c6 == null || c6.isEmpty()) ? false : true;
        boolean a6 = a();
        if (z5 && a6) {
            a(c6);
        }
        l a7 = this.f2094b.a(12000L);
        LinkedHashSet<g> linkedHashSet = a7 != null ? d6 ? a7.f2107b : a7.f2106a : null;
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            this.f2094b.a(a7.f2112g);
            a(linkedHashSet, uptimeMillis);
        } else if (z5 && !a6) {
            a(c6);
        }
        b();
        cn.jiguang.bb.f.c("SisConn", "wait final result...");
        Object a8 = this.f2096d.a(60000L);
        this.f2096d.a(false);
        if (a8 instanceof cn.jiguang.bl.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("connect succeed connResult hostName=");
            cn.jiguang.bl.a aVar = (cn.jiguang.bl.a) a8;
            sb.append(aVar.f2343h);
            sb.append(" port=");
            sb.append(aVar.f2344i);
            cn.jiguang.bb.f.e("SisConn", sb.toString());
            return aVar;
        }
        if (a8 instanceof Exception) {
            cn.jiguang.bb.f.e("SisConn", "all sis and connect failed, e:" + a8);
            c.a.a(this.f2094b.f2099a, 1402, "Exception: " + a8);
            throw ((Exception) a8);
        }
        cn.jiguang.bb.f.k("SisConn", "all sis and connect failed:" + a8);
        c.a.a(this.f2094b.f2099a, 1403, "ERR_UNKNOWN: " + a8);
        throw new cn.jiguang.bi.e(1, null);
    }

    private void a(LinkedHashSet<g> linkedHashSet) {
        linkedHashSet.removeAll(this.f2093a);
        if (linkedHashSet.isEmpty()) {
            c.a.a(this.f2094b.f2099a, 1405, "没有可用的 IP 地址进行连接-旧");
            return;
        }
        LinkedHashSet<g> a6 = e.a(this.f2094b.f2099a, linkedHashSet, 0L);
        cn.jiguang.bb.f.c("SisConn", "connect: last good sis info" + a6);
        Iterator<g> it = a6.iterator();
        while (it.hasNext() && !a(it.next())) {
        }
    }

    private void b() {
        boolean e6 = cn.jiguang.bz.b.e(this.f2094b.f2099a);
        g a6 = g.a((String) cn.jiguang.e.b.a(this.f2094b.f2099a, cn.jiguang.e.a.c(!e6)));
        StringBuilder sb = new StringBuilder();
        sb.append("connect: use last good");
        sb.append(e6 ? "v6" : "v4");
        sb.append(" address=");
        sb.append(a6);
        cn.jiguang.bb.f.c("SisConn", sb.toString());
        if (a(a6)) {
            return;
        }
        g a7 = g.a((String) cn.jiguang.e.b.a(this.f2094b.f2099a, cn.jiguang.e.a.c(e6)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connect: use last good");
        sb2.append(e6 ? "v4" : "v6");
        sb2.append(" address=");
        sb2.append(a7);
        cn.jiguang.bb.f.c("SisConn", sb2.toString());
        if (a(a7)) {
            return;
        }
        LinkedHashSet<g> c6 = c();
        if (c6 != null) {
            c6.removeAll(this.f2093a);
        }
        LinkedList a8 = y.a(c6);
        cn.jiguang.bb.f.c("SisConn", "connect: use defaultConn=" + a8);
        Iterator it = a8.iterator();
        while (it.hasNext()) {
            if (a((g) it.next())) {
                return;
            }
        }
        LinkedHashSet<g> a9 = cn.jiguang.bh.l.a().a(cn.jiguang.bf.a.b(this.f2094b.f2099a), 10000L);
        a8.clear();
        if (a9 != null) {
            a9.removeAll(this.f2093a);
            a8 = y.a(a9);
        }
        cn.jiguang.bb.f.c("SisConn", "connect: use srv address" + a8);
        Iterator it2 = a8.iterator();
        while (it2.hasNext() && !a((g) it2.next())) {
        }
    }

    public j(k kVar) {
        this.f2094b = kVar;
    }

    private void a(LinkedHashSet<g> linkedHashSet, long j6) {
        InetAddress[] b6;
        this.f2097e.a();
        this.f2096d.b();
        linkedHashSet.removeAll(this.f2093a);
        LinkedHashSet<g> a6 = e.a(this.f2094b.f2099a, linkedHashSet, System.currentTimeMillis());
        cn.jiguang.bb.f.c("SisConn", "connect: new sis info=" + a6);
        if (a6.isEmpty()) {
            c.a.a(this.f2094b.f2099a, 1406, "没有可用的 IP 地址进行连接-新");
            return;
        }
        Iterator<g> it = a6.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (SystemClock.uptimeMillis() >= j6 || a(next)) {
                return;
            }
        }
        cn.jiguang.bb.f.c("SisConn", "after connect use new sis, wait connect Result");
        long uptimeMillis = j6 - SystemClock.uptimeMillis();
        if (uptimeMillis > 0 && this.f2096d.a(uptimeMillis) == null && this.f2098f == null) {
            HashSet hashSet = new HashSet();
            Iterator<g> it2 = a6.iterator();
            while (it2.hasNext()) {
                g next2 = it2.next();
                if (this.f2093a.contains(next2)) {
                    hashSet.add(next2.f2081a);
                }
            }
            int b7 = this.f2094b.b();
            boolean z5 = true;
            if (b7 != 1 && b7 != 0) {
                z5 = false;
            }
            g a7 = g.a((String) cn.jiguang.e.b.a(this.f2094b.f2099a, cn.jiguang.e.a.b(z5)));
            if (a7 == null || (b6 = cn.jiguang.bj.b.a().b(this.f2094b.f2099a, a7.f2081a, 3000L, false)) == null || b6.length <= 0) {
                return;
            }
            a7.f2083c = b6[0];
            long uptimeMillis2 = j6 - SystemClock.uptimeMillis();
            if (uptimeMillis2 < 10) {
                return;
            }
            this.f2098f = new o(this.f2094b, a7, hashSet);
            cn.jiguang.bb.f.c("SisConn", "second sis, addr=" + a7 + ", failIps=" + hashSet);
            FutureTask futureTask = new FutureTask(this.f2098f);
            try {
                cn.jiguang.be.b.e(futureTask);
                l lVar = (l) futureTask.get(uptimeMillis2, TimeUnit.MILLISECONDS);
                LinkedHashSet<g> linkedHashSet2 = lVar != null ? c.d(this.f2094b.f2099a) ? lVar.f2107b : lVar.f2106a : null;
                if (linkedHashSet2 == null || linkedHashSet2.isEmpty()) {
                    return;
                }
                this.f2094b.a(lVar.f2112g);
                a(linkedHashSet2, j6);
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("SisConn", "second sis e:" + th);
            }
        }
    }

    private boolean a() {
        return (a(this.f2094b.f2099a, cn.jiguang.bz.o.a(this.f2094b.f2099a)) || y.b(((Long) cn.jiguang.e.b.a(this.f2094b.f2099a, cn.jiguang.e.a.at())).longValue(), 180000L)) ? false : true;
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        cn.jiguang.bb.f.c("SisConn", "newType=" + str + " last=" + ((String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.al())));
        return !str.equalsIgnoreCase(r3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
    
        r11.f2093a.add(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(cn.jiguang.bg.g r12) {
        /*
            r11 = this;
            cn.jiguang.bg.h r0 = r11.f2095c
            boolean r0 = r0.f2085a
            r1 = 0
            r2 = -991(0xfffffffffffffc21, float:NaN)
            r3 = 1
            if (r0 == 0) goto L15
            cn.jiguang.bi.e r12 = new cn.jiguang.bi.e
            r12.<init>(r2, r1)
        Lf:
            cn.jiguang.bg.p r0 = r11.f2096d
            r0.a(r12)
            return r3
        L15:
            cn.jiguang.bg.p r0 = r11.f2096d
            boolean r0 = r0.a()
            if (r0 == 0) goto L1e
            return r3
        L1e:
            r0 = 0
            if (r12 == 0) goto Lce
            boolean r4 = r12.a()
            if (r4 == 0) goto Lce
            java.util.LinkedHashSet<cn.jiguang.bg.g> r4 = r11.f2093a
            boolean r4 = r4.contains(r12)
            if (r4 == 0) goto L31
            goto Lce
        L31:
            cn.jiguang.bj.b r5 = cn.jiguang.bj.b.a()
            cn.jiguang.bg.k r4 = r11.f2094b
            android.content.Context r6 = r4.f2099a
            java.lang.String r7 = r12.f2081a
            r8 = 3000(0xbb8, double:1.482E-320)
            boolean r10 = r4.a()
            java.net.InetAddress[] r4 = r5.b(r6, r7, r8, r10)
            if (r4 == 0) goto Lb2
            int r5 = r4.length
            if (r5 != 0) goto L4b
            goto Lb2
        L4b:
            java.util.List r4 = java.util.Arrays.asList(r4)
            java.util.LinkedList r4 = cn.jiguang.bz.y.a(r4)
            cn.jiguang.bg.k r5 = r11.f2094b
            android.content.Context r5 = r5.f2099a
            java.util.LinkedList r4 = cn.jiguang.bz.y.a(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L5f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lac
            java.lang.Object r5 = r4.next()
            java.net.InetAddress r5 = (java.net.InetAddress) r5
            cn.jiguang.bg.h r6 = r11.f2095c
            boolean r6 = r6.f2085a
            if (r6 == 0) goto L77
            cn.jiguang.bi.e r12 = new cn.jiguang.bi.e
            r12.<init>(r2, r1)
            goto Lf
        L77:
            cn.jiguang.bg.p r6 = r11.f2096d
            boolean r6 = r6.a()
            if (r6 == 0) goto L80
            return r3
        L80:
            cn.jiguang.bg.g r6 = new cn.jiguang.bg.g
            int r7 = r12.f2082b
            r6.<init>(r5, r7)
            java.util.LinkedHashSet<cn.jiguang.bg.g> r5 = r11.f2093a
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L5f
            cn.jiguang.bg.f r5 = r11.f2097e
            boolean r5 = r5.a(r6)
            if (r5 == 0) goto L5f
            java.util.LinkedHashSet<cn.jiguang.bg.g> r1 = r11.f2093a
            r1.add(r6)
            cn.jiguang.bg.p r1 = r11.f2096d
            cn.jiguang.bg.b r2 = new cn.jiguang.bg.b
            cn.jiguang.bg.k r3 = r11.f2094b
            cn.jiguang.bg.f r4 = r11.f2097e
            cn.jiguang.bg.h r5 = r11.f2095c
            r2.<init>(r3, r1, r4, r5)
            r1.a(r2)
        Lac:
            java.util.LinkedHashSet<cn.jiguang.bg.g> r1 = r11.f2093a
            r1.add(r12)
            return r0
        Lb2:
            cn.jiguang.bg.k r1 = r11.f2094b
            android.content.Context r1 = r1.f2099a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "DNS解析失败: "
            r2.append(r3)
            java.lang.String r12 = r12.f2081a
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r2 = 1404(0x57c, float:1.967E-42)
            cn.jiguang.bg.c.a.a(r1, r2, r12)
        Lce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bg.j.a(cn.jiguang.bg.g):boolean");
    }
}
