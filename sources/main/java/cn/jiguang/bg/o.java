package cn.jiguang.bg;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class o implements Callable<l> {

    /* renamed from: a, reason: collision with root package name */
    private final k f2137a;

    /* renamed from: b, reason: collision with root package name */
    private final p f2138b;

    /* renamed from: c, reason: collision with root package name */
    private final f f2139c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f2140d;

    /* renamed from: e, reason: collision with root package name */
    private g f2141e;

    public o(k kVar, g gVar, Set<String> set) {
        this.f2137a = kVar;
        this.f2138b = null;
        this.f2139c = null;
        this.f2141e = gVar;
        this.f2140d = set;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l call() {
        g gVar;
        try {
            if (this.f2139c != null) {
                gVar = this.f2139c.a(this.f2137a.b());
            } else {
                gVar = this.f2141e;
            }
            return a(gVar);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("SisTask", "run e:" + th);
            return null;
        }
    }

    public o(k kVar, p pVar, f fVar) {
        this.f2137a = kVar;
        this.f2138b = pVar;
        this.f2139c = fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f5, code lost:
    
        if (r5 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jiguang.bg.l a(cn.jiguang.bg.g r21) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bg.o.a(cn.jiguang.bg.g):cn.jiguang.bg.l");
    }

    private static void a(Context context, l lVar) {
        if (lVar == null || lVar.a()) {
            return;
        }
        String a6 = g.a(lVar.f2106a);
        String a7 = g.a(lVar.f2107b);
        String a8 = cn.jiguang.bz.o.a(context);
        cn.jiguang.bb.f.c("SisTask", "updateSisInfo ips=" + a6 + " sslIps=" + a7 + " net=" + a8);
        a(context, a6, a7);
        cn.jiguang.e.a<String> a9 = cn.jiguang.e.a.d(false).a((cn.jiguang.e.a<String>) g.a(lVar.f2108c));
        cn.jiguang.e.a<String> a10 = cn.jiguang.e.a.d(true).a((cn.jiguang.e.a<String>) g.a(lVar.f2109d));
        cn.jiguang.e.a<String> a11 = cn.jiguang.e.a.av().a((cn.jiguang.e.a<String>) g.a(lVar.f2110e));
        cn.jiguang.e.a<String> ay = cn.jiguang.e.a.ay();
        JSONObject jSONObject = lVar.f2111f;
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{a9, a10, a11, ay.a((cn.jiguang.e.a<String>) (jSONObject != null ? jSONObject.toString() : null)), cn.jiguang.e.a.as().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(lVar.f2113h)), cn.jiguang.e.a.at().a((cn.jiguang.e.a<Long>) Long.valueOf(SystemClock.elapsedRealtime()))});
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.al().a((cn.jiguang.e.a<String>) a8)});
        cn.jiguang.ba.j.a(context, lVar.f2114i);
    }

    private static void a(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ar());
        String str4 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aq());
        if (TextUtils.isEmpty(str4)) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aq().a((cn.jiguang.e.a<String>) (str + "-sis-" + currentTimeMillis))});
        } else {
            String[] split = str4.split("-sis-");
            if (split == null || split.length <= 0) {
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aq().a((cn.jiguang.e.a<String>) (str + "-sis-" + currentTimeMillis))});
            } else if (!TextUtils.equals(split[0], str)) {
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aq().a((cn.jiguang.e.a<String>) (str + "-sis-" + currentTimeMillis))});
            } else if (split.length > 1 && g.b(split[1])) {
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aq().a((cn.jiguang.e.a<String>) (str + "-sis-" + currentTimeMillis))});
            }
        }
        if (TextUtils.isEmpty(str3)) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ar().a((cn.jiguang.e.a<String>) (str2 + "-sis-" + currentTimeMillis))});
            return;
        }
        String[] split2 = str3.split("-sis-");
        if (split2 == null || split2.length <= 0) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ar().a((cn.jiguang.e.a<String>) (str2 + "-sis-" + currentTimeMillis))});
            return;
        }
        if (!TextUtils.equals(split2[0], str2)) {
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ar().a((cn.jiguang.e.a<String>) (str2 + "-sis-" + currentTimeMillis))});
            return;
        }
        if (split2.length <= 1 || !g.b(split2[1])) {
            return;
        }
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ar().a((cn.jiguang.e.a<String>) (str2 + "-sis-" + currentTimeMillis))});
    }

    private Object[] a(DatagramSocket datagramSocket, InetAddress inetAddress, int i6) {
        Object[] objArr = new Object[2];
        objArr[1] = 0;
        try {
            byte[] a6 = this.f2137a.a(this.f2140d);
            String b6 = cn.jiguang.bq.c.a().b(inetAddress.getHostAddress(), i6);
            cn.jiguang.bq.b.a().b(inetAddress.getHostAddress() + ":" + i6, "sis", a6.length);
            DatagramPacket datagramPacket = new DatagramPacket(a6, a6.length, inetAddress, i6);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                byte[] a7 = c.a(datagramSocket, datagramPacket);
                cn.jiguang.bq.b.a().c(inetAddress.getHostAddress() + ":" + i6, "sis", a7.length);
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                try {
                    l lVar = new l(new String(c.a(a7)));
                    if (lVar.a()) {
                        objArr[0] = 6;
                        cn.jiguang.bq.c.a().c(b6, 6);
                        return objArr;
                    }
                    cn.jiguang.bq.c.a().c(b6, 0);
                    a(this.f2137a.f2099a, lVar);
                    lVar.f2112g = new g(inetAddress, i6);
                    objArr[0] = lVar;
                    return objArr;
                } catch (cn.jiguang.bi.e e6) {
                    objArr[0] = Integer.valueOf(e6.a());
                    cn.jiguang.bq.c.a().c(b6, e6.a());
                    return objArr;
                }
            } catch (Exception unused) {
                cn.jiguang.bq.c.a().c(b6, 3);
                objArr[0] = 3;
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                return objArr;
            }
        } catch (cn.jiguang.bi.e e7) {
            objArr[0] = Integer.valueOf(e7.a());
            return objArr;
        }
    }
}
