package cn.jiguang.bg;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashSet<g> f2078a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashSet<g> f2079b = new LinkedHashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private List<Boolean> f2080c = new ArrayList();

    public g a(int i6) {
        List<Boolean> list;
        Boolean bool;
        cn.jiguang.bb.f.c("IpPool", "current ipv4List=" + this.f2078a + " ipv6List=" + this.f2079b);
        g a6 = i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? null : a(true, false) : a(true, true) : a(false, true) : a(false, false);
        cn.jiguang.bb.f.c("IpPool", "get ipPort=" + a6);
        if (a6 != null) {
            InetAddress inetAddress = a6.f2083c;
            if (inetAddress instanceof Inet4Address) {
                list = this.f2080c;
                bool = Boolean.FALSE;
            } else if (inetAddress instanceof Inet6Address) {
                list = this.f2080c;
                bool = Boolean.TRUE;
            }
            list.add(bool);
            return a6;
        }
        return a6;
    }

    private g a(boolean z5, boolean z6) {
        LinkedHashSet<g> linkedHashSet = z5 ? this.f2079b : this.f2078a;
        LinkedHashSet<g> linkedHashSet2 = z6 ? null : z5 ? this.f2078a : this.f2079b;
        return (g) ((linkedHashSet2 == null || linkedHashSet2.isEmpty() || !(linkedHashSet == null || linkedHashSet.isEmpty() || a(z5))) ? a(linkedHashSet) : a(linkedHashSet2));
    }

    private static <T> T a(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> it = collection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public void a() {
        try {
            this.f2078a.clear();
            this.f2079b.clear();
        } catch (Throwable unused) {
        }
    }

    public boolean a(g gVar) {
        LinkedHashSet<g> linkedHashSet;
        if (gVar == null || !gVar.a()) {
            return false;
        }
        InetAddress inetAddress = gVar.f2083c;
        if (inetAddress instanceof Inet4Address) {
            linkedHashSet = this.f2078a;
        } else {
            if (!(inetAddress instanceof Inet6Address)) {
                return false;
            }
            linkedHashSet = this.f2079b;
        }
        return linkedHashSet.add(gVar);
    }

    private boolean a(boolean z5) {
        if (this.f2080c.size() < 2) {
            return false;
        }
        for (int size = this.f2080c.size() - 1; size >= this.f2080c.size() - 2; size--) {
            if (this.f2080c.get(size).booleanValue() != z5) {
                return false;
            }
        }
        return true;
    }
}
