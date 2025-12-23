package cn.jiguang.bi;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bz.o;
import com.tencent.bugly.BuglyStrategy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    private static long f2288c = 1;

    /* renamed from: a, reason: collision with root package name */
    private Map<Long, d> f2289a;

    /* renamed from: b, reason: collision with root package name */
    private cn.jiguang.bm.a f2290b;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final i f2292a = new i();
    }

    private i() {
        this.f2290b = new cn.jiguang.bm.a() { // from class: cn.jiguang.bi.i.1
            @Override // cn.jiguang.bm.a
            public void a(Message message) {
                long j6 = message.what - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                Bundle bundle = new Bundle();
                bundle.putLong("rid", j6);
                g.a().a(JCoreManager.getAppContext(null), "tcp_a6", bundle);
            }
        };
        this.f2289a = new HashMap();
    }

    public static long b() {
        long j6 = f2288c + 1;
        f2288c = j6;
        if (j6 >= 2147483647L) {
            f2288c = 1L;
        }
        return f2288c;
    }

    public d a(long j6) {
        return this.f2289a.get(Long.valueOf(j6));
    }

    public static i a() {
        return a.f2292a;
    }

    public void b(Context context, long j6) {
        d remove = this.f2289a.remove(Long.valueOf(j6));
        if (remove == null) {
            cn.jiguang.bb.f.i("TcpRequestManager", "not found requst by rid:" + j6);
            return;
        }
        cn.jiguang.bb.f.c("TcpRequestManager", "request time out:" + remove);
        b.a().a(context, remove.f2223c, remove.f2222b, remove.f2224d);
    }

    public void a(Context context) {
        if (this.f2289a.isEmpty()) {
            cn.jiguang.bb.f.c("TcpRequestManager", "no cache request");
            return;
        }
        for (Map.Entry<Long, d> entry : this.f2289a.entrySet()) {
            if (entry.getValue().f2230j) {
                long nanoTime = System.nanoTime() - entry.getValue().f2228h;
                if (entry.getValue().f2229i - nanoTime >= 10000) {
                    entry.getValue().a();
                    cn.jiguang.bb.f.c("TcpRequestManager", "send again:" + entry.getValue());
                    g.a().c().e().a(a(context, entry.getValue()));
                } else {
                    cn.jiguang.bb.f.c("TcpRequestManager", "shoud not send again by 10000ms,hasRequestTime:" + nanoTime + ",timeout:" + entry.getValue().f2229i);
                }
            }
        }
    }

    public void a(Context context, long j6) {
        d remove = this.f2289a.remove(Long.valueOf(j6));
        if (remove != null) {
            if (remove.f2230j) {
                cn.jiguang.bm.b.a().b((int) (j6 + 100000));
            }
            cn.jiguang.bb.f.c("TcpRequestManager", "handle reponse :" + remove);
        }
    }

    public void a(Context context, long j6, int i6, int i7, byte[] bArr, String str) {
        long c6 = cn.jiguang.bg.c.c(context);
        if (this.f2289a.containsKey(Long.valueOf(c6))) {
            cn.jiguang.bb.f.j("TcpRequestManager", "Generator same rid,not do this msg");
            return;
        }
        d dVar = new d(j6, str, i6, i7, c6, 0L, bArr);
        if (g.a().d()) {
            g.a().c().e().a(a(context, dVar));
        } else {
            cn.jiguang.bb.f.k("TcpRequestManager", !o.c() ? "send error -tcp connect was invalid" : "current use not login success,wait a moment");
        }
        this.f2289a.put(Long.valueOf(c6), dVar);
    }

    public void a(Context context, long j6, int i6, int i7, byte[] bArr, String str, long j7) {
        long j8;
        if (i6 == 10) {
            j8 = j6;
        } else {
            long c6 = cn.jiguang.bg.c.c(context);
            cn.jiguang.bb.f.c("TcpRequestManager", "Generator new rid:" + c6);
            if (this.f2289a.containsKey(Long.valueOf(c6))) {
                cn.jiguang.bb.f.j("TcpRequestManager", "Generator same rid,not do this msg");
                return;
            }
            j8 = c6;
        }
        long j9 = j7 <= 0 ? 10000L : j7;
        d dVar = new d(j6, str, i6, i7, j8, j9, bArr);
        if (g.a().d()) {
            g.a().c().e().a(a(context, dVar));
        } else {
            cn.jiguang.bb.f.k("TcpRequestManager", !o.c() ? "send error -tcp connect was invalid" : "current use not login success,wait a moment");
        }
        dVar.f2228h = System.nanoTime();
        this.f2289a.put(Long.valueOf(j8), dVar);
        cn.jiguang.bm.b.a().b((int) (j8 + 100000), j9, this.f2290b);
    }

    private byte[] a(Context context, d dVar) {
        return cn.jiguang.bk.b.a(context, dVar.f2224d, dVar.f2225e, dVar.f2226f, dVar.f2227g, 0L);
    }
}
