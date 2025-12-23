package cn.jiguang.bg;

import android.content.Context;
import cn.jiguang.bz.y;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i implements Callable<l> {

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashSet<g> f2091a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private k f2092b;

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l call() {
        f fVar = new f();
        p pVar = new p(5, 2000, null, "ss");
        a(pVar, fVar);
        cn.jiguang.bb.f.c("Sis", "main sis: after host and last good, wait Result");
        Object a6 = pVar.a(60000L);
        if (a6 instanceof l) {
            return (l) a6;
        }
        b(pVar, fVar);
        cn.jiguang.bb.f.c("Sis", "main sis: after default and srv, wait Result");
        Object a7 = pVar.a(60000L);
        pVar.a(false);
        if (a7 instanceof l) {
            return (l) a7;
        }
        return null;
    }

    private LinkedHashSet<g> a(Context context) {
        LinkedHashSet<g> c6 = g.c((String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.av()));
        return (c6 == null || c6.isEmpty()) ? g.a(cn.jiguang.bf.a.b()) : c6;
    }

    private void b(p pVar, f fVar) {
        LinkedHashSet<g> a6 = a(this.f2092b.f2099a);
        a6.removeAll(this.f2091a);
        LinkedList a7 = y.a(a6);
        cn.jiguang.bb.f.c("Sis", "main sis: default sis" + a7);
        Iterator it = a7.iterator();
        while (it.hasNext()) {
            if (a((g) it.next(), pVar, fVar)) {
                return;
            }
        }
        LinkedHashSet<g> a8 = cn.jiguang.bh.l.a().a(cn.jiguang.bf.a.c(), 10000L);
        a7.clear();
        if (a8 != null) {
            a8.removeAll(this.f2091a);
            a7 = y.a(a8);
        }
        cn.jiguang.bb.f.c("Sis", "main sis: sis srv" + a7);
        Iterator it2 = a7.iterator();
        while (it2.hasNext() && !a((g) it2.next(), pVar, fVar)) {
        }
    }

    public i(k kVar) {
        this.f2092b = kVar;
    }

    private void a(p pVar, f fVar) {
        LinkedHashSet<g> a6 = g.a(cn.jiguang.bf.a.a());
        a6.removeAll(this.f2091a);
        boolean e6 = cn.jiguang.bz.b.e(this.f2092b.f2099a);
        List a7 = y.a(a6);
        if (e6) {
            a7 = y.a((List<g>) a7);
        }
        Iterator it = a7.iterator();
        while (it.hasNext()) {
            if (a((g) it.next(), pVar, fVar)) {
                return;
            }
        }
        g a8 = g.a((String) cn.jiguang.e.b.a(this.f2092b.f2099a, cn.jiguang.e.a.b(!e6)));
        StringBuilder sb = new StringBuilder();
        sb.append("main sis: last good sis ");
        sb.append(e6 ? "v6" : "v4");
        sb.append(" address=");
        sb.append(a8);
        cn.jiguang.bb.f.c("Sis", sb.toString());
        if (a(a8, pVar, fVar)) {
            return;
        }
        g a9 = g.a((String) cn.jiguang.e.b.a(this.f2092b.f2099a, cn.jiguang.e.a.b(e6)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("main sis: last good sis ");
        sb2.append(e6 ? "v4" : "v6");
        sb2.append(" address=");
        sb2.append(a9);
        cn.jiguang.bb.f.c("Sis", sb2.toString());
        a(a9, pVar, fVar);
    }

    private boolean a(g gVar, p pVar, f fVar) {
        if (pVar.a()) {
            return true;
        }
        if (gVar != null && gVar.a() && !this.f2091a.contains(gVar)) {
            cn.jiguang.bj.b a6 = cn.jiguang.bj.b.a();
            k kVar = this.f2092b;
            InetAddress[] b6 = a6.b(kVar.f2099a, gVar.f2081a, 3000L, kVar.a());
            if (b6 != null && b6.length != 0) {
                Iterator<InetAddress> it = y.a(this.f2092b.f2099a, (LinkedList<InetAddress>) y.a((Collection) Arrays.asList(b6))).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InetAddress next = it.next();
                    if (!pVar.a()) {
                        g gVar2 = new g(next, gVar.f2082b);
                        if (!this.f2091a.contains(gVar2) && fVar.a(gVar2)) {
                            this.f2091a.add(gVar2);
                            pVar.a((Callable<?>) new o(this.f2092b, pVar, fVar));
                            break;
                        }
                    } else {
                        return true;
                    }
                }
                this.f2091a.add(gVar);
            }
        }
        return false;
    }
}
