package cn.jiguang.au;

import android.content.Context;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private cn.jiguang.as.a f1761a;

    /* renamed from: b, reason: collision with root package name */
    private cn.jiguang.at.a f1762b;

    /* renamed from: c, reason: collision with root package name */
    private cn.jiguang.at.b f1763c;

    /* renamed from: d, reason: collision with root package name */
    private long f1764d;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f1767a = new f();
    }

    private f() {
        this.f1764d = System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x0019, B:10:0x0023, B:11:0x002b, B:13:0x002f, B:14:0x003c, B:19:0x0010), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x0019, B:10:0x0023, B:11:0x002b, B:13:0x002f, B:14:0x003c, B:19:0x0010), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized cn.jiguang.at.a a(android.content.Context r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            cn.jiguang.at.b r0 = r2.f1763c     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L10
            java.lang.Thread$State r0 = r0.getState()     // Catch: java.lang.Throwable -> Le
            java.lang.Thread$State r1 = java.lang.Thread.State.TERMINATED     // Catch: java.lang.Throwable -> Le
            if (r0 != r1) goto L19
            goto L10
        Le:
            r3 = move-exception
            goto L40
        L10:
            cn.jiguang.at.b r0 = new cn.jiguang.at.b     // Catch: java.lang.Throwable -> Le
            java.lang.String r1 = "jg_wk_thread"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Le
            r2.f1763c = r0     // Catch: java.lang.Throwable -> Le
        L19:
            cn.jiguang.at.b r0 = r2.f1763c     // Catch: java.lang.Throwable -> Le
            java.lang.Thread$State r0 = r0.getState()     // Catch: java.lang.Throwable -> Le
            java.lang.Thread$State r1 = java.lang.Thread.State.NEW     // Catch: java.lang.Throwable -> Le
            if (r0 != r1) goto L2b
            cn.jiguang.at.b r0 = r2.f1763c     // Catch: java.lang.Throwable -> Le
            r0.start()     // Catch: java.lang.Throwable -> Le
            r0 = 0
            r2.f1762b = r0     // Catch: java.lang.Throwable -> Le
        L2b:
            cn.jiguang.at.a r0 = r2.f1762b     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L3c
            cn.jiguang.at.a r0 = new cn.jiguang.at.a     // Catch: java.lang.Throwable -> Le
            cn.jiguang.at.b r1 = r2.f1763c     // Catch: java.lang.Throwable -> Le
            android.os.Looper r1 = r1.getLooper()     // Catch: java.lang.Throwable -> Le
            r0.<init>(r3, r1)     // Catch: java.lang.Throwable -> Le
            r2.f1762b = r0     // Catch: java.lang.Throwable -> Le
        L3c:
            cn.jiguang.at.a r3 = r2.f1762b     // Catch: java.lang.Throwable -> Le
            monitor-exit(r2)
            return r3
        L40:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Le
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.au.f.a(android.content.Context):cn.jiguang.at.a");
    }

    public static f a() {
        return a.f1767a;
    }

    private void b(Context context, cn.jiguang.as.c cVar) {
        cn.jiguang.bb.f.c("JWakeTaskHelper", "the delay w task time up, start to process it, tPkg: " + cVar.f1718a);
        List<cn.jiguang.as.b> a6 = cn.jiguang.ar.a.a(context, (List<cn.jiguang.as.c>) new ArrayList<cn.jiguang.as.c>(cVar) { // from class: cn.jiguang.au.f.1

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ cn.jiguang.as.c f1765a;

            {
                this.f1765a = cVar;
                add(cVar);
            }
        });
        if (a6 == null || a6.isEmpty()) {
            return;
        }
        c.a(context, this.f1761a, a6);
    }

    public void a(Context context, int i6, Object obj) {
        if (i6 == 1000 && (obj instanceof cn.jiguang.as.c)) {
            b(context, (cn.jiguang.as.c) obj);
        }
    }

    public void a(Context context, cn.jiguang.as.a aVar, List<cn.jiguang.as.c> list) {
        this.f1761a = aVar;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (cn.jiguang.as.c cVar : list) {
                if (a(cVar.f1728k * 1000)) {
                    arrayList.add(cVar);
                    a(context, cVar);
                }
            }
            if (!arrayList.isEmpty()) {
                list.removeAll(arrayList);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("start w task, wakeTarget size: ");
        sb.append(list != null ? list.size() : 0);
        sb.append(", dWakeTarget size: ");
        sb.append(arrayList.size());
        cn.jiguang.bb.f.c("JWakeTaskHelper", sb.toString());
        c.a(context, this.f1761a, cn.jiguang.ar.a.a(context, list));
    }

    private void a(Context context, cn.jiguang.as.c cVar) {
        long max = Math.max(0L, (cVar.f1728k * 1000) - Math.max(0L, System.currentTimeMillis() - this.f1764d));
        Message obtain = Message.obtain();
        obtain.what = 1000;
        obtain.obj = cVar;
        a(context).sendMessageDelayed(obtain, max);
        cn.jiguang.bb.f.c("JWakeTaskHelper", "add delay w task, delayTime: " + max + ", tPkg: " + cVar.f1718a);
    }

    public void a(Context context, List<cn.jiguang.as.c> list) {
        cn.jiguang.as.a b6 = b.b(context);
        a(context, b6, cn.jiguang.ar.a.a(context, b6, list));
    }

    public void a(Context context, boolean z5) {
        if (z5) {
            this.f1764d = System.currentTimeMillis();
        }
    }

    public boolean a(int i6) {
        return cn.jiguang.be.b.f2036b.get() && i6 > 0 && System.currentTimeMillis() - this.f1764d < ((long) i6);
    }
}
