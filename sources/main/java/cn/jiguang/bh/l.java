package cn.jiguang.bh;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private long f2204a;

    /* renamed from: b, reason: collision with root package name */
    private long f2205b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Pair<LinkedHashSet<cn.jiguang.bg.g>, Long>> f2206c;

    /* renamed from: cn.jiguang.bh.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class a implements Callable<LinkedHashSet<cn.jiguang.bg.g>> {

        /* renamed from: a, reason: collision with root package name */
        private String f2207a;

        /* renamed from: b, reason: collision with root package name */
        private l f2208b;

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LinkedHashSet<cn.jiguang.bg.g> call() {
            LinkedHashSet<cn.jiguang.bg.g> a6 = l.a(this.f2207a);
            if (a6 != null && a6.size() > 0) {
                this.f2208b.a(this.f2207a, (Pair<LinkedHashSet<cn.jiguang.bg.g>, Long>) new Pair(a6, Long.valueOf(System.currentTimeMillis())));
            }
            return a6;
        }

        a(String str, l lVar) {
            this.f2207a = str;
            this.f2208b = lVar;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final l f2209a = new l(null);
    }

    private l() {
        this.f2204a = 86400000L;
        this.f2205b = 1800000L;
        this.f2206c = new HashMap();
    }

    private Pair<LinkedHashSet<cn.jiguang.bg.g>, Boolean> a(String str, long j6, long j7) {
        Object obj;
        Pair<LinkedHashSet<cn.jiguang.bg.g>, Long> pair = this.f2206c.get(str);
        boolean z5 = pair == null || (obj = pair.first) == null || ((LinkedHashSet) obj).size() == 0;
        long longValue = ((Long) (z5 ? cn.jiguang.e.b.a((Context) null, cn.jiguang.e.a.e(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j6) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z5) {
            String str2 = (String) cn.jiguang.e.b.a((Context) null, cn.jiguang.e.a.d(str));
            if (!TextUtils.isEmpty(str2)) {
                for (String str3 : str2.split(",")) {
                    cn.jiguang.bg.g a6 = cn.jiguang.bg.g.a(str3);
                    if (a6 != null && a6.a()) {
                        linkedHashSet.add(a6);
                    }
                }
                this.f2206c.put(str, new Pair<>(linkedHashSet, Long.valueOf(System.currentTimeMillis())));
            }
        } else {
            linkedHashSet = (LinkedHashSet) pair.first;
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return new Pair<>(linkedHashSet, Boolean.valueOf(currentTimeMillis > longValue + j7));
    }

    /* synthetic */ l(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static l a() {
        return b.f2209a;
    }

    public static LinkedHashSet<cn.jiguang.bg.g> a(String str) {
        e eVar;
        i a6;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] b6 = b(str);
            cn.jiguang.bb.f.c("SRVLoader", "srv host:" + str);
            String a7 = cn.jiguang.bq.c.a().a(str);
            LinkedHashSet<cn.jiguang.bg.g> linkedHashSet = new LinkedHashSet<>();
            try {
                String[] a8 = k.b().a();
                if (a8 != null && a8.length != 0) {
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    cn.jiguang.bj.b a9 = cn.jiguang.bj.b.a();
                    for (String str2 : a8) {
                        InetAddress a10 = a9.a((Context) null, str2, 3000L, false);
                        if (a10 != null) {
                            linkedHashSet2.add(a10);
                        }
                    }
                    Iterator it = linkedHashSet2.iterator();
                    while (it.hasNext()) {
                        try {
                            eVar = new e(o.a(null, new InetSocketAddress((InetAddress) it.next(), 53), b6, System.currentTimeMillis() + 1000));
                            a6 = eVar.a();
                        } catch (IOException e6) {
                            cn.jiguang.bb.f.i("SRVLoader", "tcp send to  err:" + e6);
                        }
                        if (a6 == null) {
                            break;
                        }
                        for (h hVar : eVar.b(1)) {
                            if (hVar.d() == a6.g() && hVar.c() == a6.e() && hVar.b().equals(a6.d())) {
                                Iterator a11 = hVar.a();
                                while (a11.hasNext()) {
                                    m mVar = (m) a11.next();
                                    if (mVar.j() > 0) {
                                        String gVar = mVar.k().toString();
                                        if (!TextUtils.isEmpty(gVar)) {
                                            if (gVar.endsWith(".")) {
                                                gVar = gVar.substring(0, gVar.length() - 1);
                                            }
                                            cn.jiguang.bg.g gVar2 = new cn.jiguang.bg.g(gVar, mVar.j());
                                            if (gVar2.a()) {
                                                linkedHashSet.add(gVar2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    cn.jiguang.bq.c.a().a(a7, 0);
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.j("SRVLoader", "Get default ports error with Exception:" + th);
                cn.jiguang.bq.c.a().a(a7, 2);
            }
            return linkedHashSet;
        } catch (IOException e7) {
            cn.jiguang.bb.f.i("SRVLoader", "can't srv, create query:" + e7);
            return null;
        }
    }

    private static byte[] b(String str) {
        return e.a(i.a(g.a(g.a(str), g.f2182a), 33, 1)).c(65535);
    }

    public LinkedHashSet<cn.jiguang.bg.g> a(String str, long j6) {
        LinkedHashSet<cn.jiguang.bg.g> linkedHashSet;
        StringBuilder sb;
        LinkedHashSet<cn.jiguang.bg.g> linkedHashSet2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Pair<LinkedHashSet<cn.jiguang.bg.g>, Boolean> a6 = a(str, this.f2204a, this.f2205b);
        if (a6 != null) {
            Object obj = a6.first;
            LinkedHashSet<cn.jiguang.bg.g> linkedHashSet3 = (obj == null || ((LinkedHashSet) obj).size() <= 0) ? null : (LinkedHashSet) a6.first;
            if (!((Boolean) a6.second).booleanValue()) {
                return linkedHashSet3;
            }
            linkedHashSet = linkedHashSet3;
        } else {
            linkedHashSet = null;
        }
        FutureTask futureTask = new FutureTask(new a(str, this));
        cn.jiguang.be.b.e(futureTask);
        if (j6 == 0) {
            sb = new StringBuilder();
        } else {
            try {
                linkedHashSet2 = (LinkedHashSet) futureTask.get(j6, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("SRVLoader", "run futureTask e:" + th);
            }
            if (linkedHashSet2 != null && linkedHashSet2.size() > 0) {
                cn.jiguang.bb.f.c("SRVLoader", "use resolved result=" + linkedHashSet2);
                return linkedHashSet2;
            }
            sb = new StringBuilder();
        }
        sb.append("use cache=");
        sb.append(linkedHashSet);
        cn.jiguang.bb.f.c("SRVLoader", sb.toString());
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Pair<LinkedHashSet<cn.jiguang.bg.g>, Long> pair) {
        Object obj = pair.first;
        if (obj == null || ((LinkedHashSet) obj).size() <= 0 || pair.second == null) {
            return;
        }
        this.f2206c.put(str, pair);
        StringBuilder sb = new StringBuilder();
        Iterator it = ((LinkedHashSet) pair.first).iterator();
        while (it.hasNext()) {
            sb.append(((cn.jiguang.bg.g) it.next()).toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        cn.jiguang.e.b.a((Context) null, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.d(str).a((cn.jiguang.e.a<String>) sb.toString()), cn.jiguang.e.a.e(str).a((cn.jiguang.e.a<Long>) pair.second)});
    }
}
