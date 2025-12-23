package cn.jiguang.bg;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.bz.y;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    Context f2099a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<m> f2100b;

    /* renamed from: c, reason: collision with root package name */
    private int f2101c = 0;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f2102d;

    /* renamed from: e, reason: collision with root package name */
    private int f2103e;

    public l a(long j6) {
        FutureTask futureTask = new FutureTask(new i(this));
        this.f2101c = 0;
        cn.jiguang.be.b.e(futureTask);
        if (j6 < 10) {
            j6 = 10;
        }
        try {
            return (l) futureTask.get(j6, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public int b() {
        this.f2101c = 3;
        int b6 = cn.jiguang.bz.b.e(this.f2099a) ? 3 : cn.jiguang.bj.c.a().b(this.f2101c);
        cn.jiguang.bb.f.c("SisConnContext", "ipvsupport=" + this.f2101c + ", prefer=" + b6);
        return b6;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.jiguang.bg.n a(int r18) {
        /*
            r17 = this;
            r0 = r17
            android.content.Context r1 = r0.f2099a
            java.lang.String r4 = cn.jiguang.d.a.e(r1)
            android.content.Context r1 = r0.f2099a
            long r6 = cn.jiguang.d.a.f(r1)
            android.content.Context r1 = r0.f2099a
            r2 = 0
            java.lang.String r8 = cn.jiguang.bz.x.a(r1, r2)
            long r9 = java.lang.System.currentTimeMillis()
            android.content.Context r1 = r0.f2099a
            java.lang.String r3 = "get_loc_info"
            r5 = 0
            java.lang.Object r1 = cn.jiguang.v.a.a(r1, r3, r5)
            boolean r3 = r1 instanceof android.os.Bundle
            r11 = 4641240890982006784(0x4069000000000000, double:200.0)
            if (r3 == 0) goto L4c
            android.os.Bundle r1 = (android.os.Bundle) r1     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "lat"
            double r13 = r1.getDouble(r3)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "lot"
            double r11 = r1.getDouble(r3)     // Catch: java.lang.Throwable -> L40
            java.lang.String r3 = "time"
            long r9 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L40
            r15 = r13
            r13 = r9
            r9 = r15
            goto L4e
        L40:
            r15 = r13
            r13 = r11
            r11 = r15
            goto L47
        L45:
            r13 = r11
        L47:
            r15 = r13
            r13 = r9
            r9 = r11
            r11 = r15
            goto L4e
        L4c:
            r13 = r9
            r9 = r11
        L4e:
            android.content.Context r1 = r0.f2099a
            boolean r1 = cn.jiguang.bg.c.d(r1)
            if (r1 == 0) goto L5c
            int r2 = cn.jiguang.ba.j.b()
            r1 = r2
            goto L5d
        L5c:
            r1 = 0
        L5d:
            cn.jiguang.bg.n r2 = new cn.jiguang.bg.n
            java.lang.String r5 = cn.jiguang.a.a.f1444b
            r3 = r18
            r2.<init>(r3, r4, r5, r6, r8, r9, r11, r13)
            cn.jiguang.bg.n r1 = r2.a(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bg.k.a(int):cn.jiguang.bg.n");
    }

    public k(Context context) {
        this.f2099a = context;
        this.f2100b = m.a((String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.am()));
    }

    public void a(int i6, String str, int i7, long j6, long j7, int i8) {
        if (g.a(str, i7)) {
            m mVar = new m();
            mVar.f2115a = cn.jiguang.d.a.e(this.f2099a);
            mVar.f2116b = i6;
            mVar.f2117c = new g(str, i7);
            mVar.f2119e = j6;
            mVar.f2120f = j7;
            mVar.f2125k = i8;
            mVar.f2121g = cn.jiguang.bz.o.b(this.f2099a);
            mVar.f2118d = cn.jiguang.d.a.f(this.f2099a);
            mVar.f2122h = 200.0d;
            mVar.f2123i = 200.0d;
            mVar.f2124j = System.currentTimeMillis();
            Object a6 = cn.jiguang.v.a.a(this.f2099a, "get_loc_info", null);
            if (a6 instanceof Bundle) {
                try {
                    Bundle bundle = (Bundle) a6;
                    mVar.f2122h = bundle.getDouble(com.umeng.analytics.pro.d.C);
                    mVar.f2123i = bundle.getDouble("lot");
                    mVar.f2124j = bundle.getLong("time");
                } catch (Throwable unused) {
                }
            }
            a(mVar);
        }
    }

    public void a(final g gVar) {
        if (((Boolean) cn.jiguang.e.b.a(this.f2099a, cn.jiguang.e.a.as())).booleanValue()) {
            if (y.b(((Long) cn.jiguang.e.b.a(this.f2099a, cn.jiguang.e.a.au())).longValue(), 3600000L)) {
                cn.jiguang.be.b.c(new cn.jiguang.by.b("SisConnContext#asyncSisReportIfNeed") { // from class: cn.jiguang.bg.k.1
                    @Override // cn.jiguang.by.b
                    public void a() {
                        DatagramSocket datagramSocket;
                        Object th;
                        StringBuilder sb;
                        try {
                            datagramSocket = new DatagramSocket();
                            try {
                                String str = (String) cn.jiguang.e.b.a(k.this.f2099a, cn.jiguang.e.a.am());
                                if (TextUtils.isEmpty(str)) {
                                    cn.jiguang.bb.f.c("SisConnContext", "reportInfo is Empty, quit report");
                                    try {
                                        datagramSocket.close();
                                        return;
                                    } catch (Throwable th2) {
                                        cn.jiguang.bb.f.i("SisConnContext", "sisReport ,close udpsocket error:" + th2.getMessage());
                                        return;
                                    }
                                }
                                byte[] a6 = c.a("DG", str);
                                cn.jiguang.bb.f.c("SisConnContext", "sis report data(" + a6.length + ") at " + gVar.f2083c + ":" + gVar.f2082b);
                                k kVar = k.this;
                                g gVar2 = gVar;
                                if (kVar.a(gVar2.f2083c, gVar2.f2082b, datagramSocket, a6)) {
                                    cn.jiguang.bb.f.c("SisConnContext", "report succeed : " + str);
                                    cn.jiguang.e.b.a(k.this.f2099a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.au().a((cn.jiguang.e.a<Long>) Long.valueOf(SystemClock.elapsedRealtime()))});
                                    cn.jiguang.e.b.a(k.this.f2099a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.am().a((cn.jiguang.e.a<String>) null)});
                                } else {
                                    cn.jiguang.bb.f.i("SisConnContext", "report failed" + str);
                                }
                                try {
                                    datagramSocket.close();
                                } catch (Throwable th3) {
                                    th = th3;
                                    sb = new StringBuilder();
                                    sb.append("sisReport ,close udpsocket error:");
                                    sb.append(th.getMessage());
                                    cn.jiguang.bb.f.i("SisConnContext", sb.toString());
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                try {
                                    cn.jiguang.bb.f.i("SisConnContext", "sisReport failed, error:" + th);
                                    if (datagramSocket != null) {
                                        try {
                                            datagramSocket.close();
                                        } catch (Throwable th5) {
                                            th = th5;
                                            sb = new StringBuilder();
                                            sb.append("sisReport ,close udpsocket error:");
                                            sb.append(th.getMessage());
                                            cn.jiguang.bb.f.i("SisConnContext", sb.toString());
                                        }
                                    }
                                } catch (Throwable th6) {
                                    if (datagramSocket != null) {
                                        try {
                                            datagramSocket.close();
                                        } catch (Throwable th7) {
                                            cn.jiguang.bb.f.i("SisConnContext", "sisReport ,close udpsocket error:" + th7.getMessage());
                                        }
                                    }
                                    throw th6;
                                }
                            }
                        } catch (Throwable th8) {
                            datagramSocket = null;
                            th = th8;
                        }
                    }
                });
            } else {
                cn.jiguang.bb.f.c("SisConnContext", "sis report: not yet");
            }
        }
    }

    private synchronized void a(m mVar) {
        try {
            this.f2100b.add(mVar);
            cn.jiguang.bb.f.c("SisConnContext", "addSisReportInfo:" + mVar.a().toString());
            while (this.f2100b.size() > 30) {
                this.f2100b.removeFirst();
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<m> it = this.f2100b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
            cn.jiguang.e.b.a(this.f2099a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.am().a((cn.jiguang.e.a<String>) jSONArray.toString())});
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(boolean z5) {
        this.f2101c = (z5 ? 1 : 2) | this.f2101c;
        cn.jiguang.bj.c.a().a(this.f2099a, this.f2101c);
    }

    public boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(InetAddress inetAddress, int i6, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            return y.c(c.a(c.a(datagramSocket, new DatagramPacket(bArr, bArr.length, inetAddress, i6)))) == 0;
        } catch (Throwable th) {
            cn.jiguang.bb.f.l("SisConnContext", "report failed : " + th);
            return false;
        }
    }

    public byte[] a(Set<String> set) {
        int b6 = cn.jiguang.bz.o.b(this.f2099a);
        if (this.f2102d == null || b6 != this.f2103e) {
            this.f2103e = b6;
            try {
                this.f2102d = c.a("UG", a(b6).a(set).toString());
            } catch (Exception e6) {
                throw new cn.jiguang.bi.e(2, "Failed to package data - " + e6);
            }
        }
        return this.f2102d;
    }
}
