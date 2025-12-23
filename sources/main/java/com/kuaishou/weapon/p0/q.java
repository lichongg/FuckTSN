package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.stub.StubApp;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\Downloads\app\classes6.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36095a = 3;

    /* renamed from: b, reason: collision with root package name */
    private static q f36096b = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f36097g = "1";

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f36098c = false;

    /* renamed from: d, reason: collision with root package name */
    private dp f36099d;

    /* renamed from: e, reason: collision with root package name */
    private Context f36100e;

    /* renamed from: f, reason: collision with root package name */
    private t f36101f;

    public static synchronized q a(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (f36096b == null) {
                    f36096b = new q(context);
                }
                qVar = f36096b;
            } catch (Exception unused) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    public synchronized void b() {
        String str;
        try {
            if (this.f36098c) {
                return;
            }
            this.f36098c = true;
            for (s sVar : this.f36101f.a()) {
                try {
                    str = this.f36100e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                    str = null;
                }
                if (str != null) {
                    sVar.f36127m = str + bi.f35777j + sVar.f36115a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(sVar.f36127m);
                    sb.append("/lib");
                    dn.c(sb.toString());
                    dn.c(sVar.f36127m);
                }
            }
            this.f36101f.b();
            if (this.f36099d.b(dp.f36025d)) {
                this.f36101f.c();
            } else {
                this.f36099d.a(dp.f36025d, Boolean.TRUE, true);
            }
            n.a().a(new u(this.f36100e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void c() {
        for (s sVar : this.f36101f.a()) {
            r a6 = r.a();
            if ((a6 != null ? a6.d(sVar.f36117c) : null) == null) {
                a(sVar.f36115a, sVar.f36118d, (PackageInfo) null);
            }
        }
    }

    private q(Context context) {
        this.f36100e = context;
        this.f36099d = dp.a(context);
        this.f36101f = t.a(context);
    }

    private static void d() {
        try {
            dp a6 = dp.a();
            if (a6 != null) {
                a6.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        d();
        if (WeaponHI.isLoad) {
            b();
        } else {
            WeaponHI.iD();
        }
    }

    public synchronized boolean a(int i6, String str, PackageInfo packageInfo) {
        return a(i6, str, null, false, packageInfo);
    }

    private synchronized boolean a(int i6, String str, String str2, boolean z5, PackageInfo packageInfo) {
        if (z5) {
            if (this.f36101f.c(i6) != 1) {
                return false;
            }
        }
        s a6 = this.f36101f.a(i6);
        if (a6 == null) {
            this.f36101f.b(i6, -1);
            return false;
        }
        if (!dn.a(new File(a6.f36119e))) {
            this.f36101f.b(i6, -1);
            return false;
        }
        if (packageInfo != null) {
            a6.f36132r = packageInfo;
        }
        r a7 = r.a(StubApp.getOrigApplicationContext(this.f36100e.getApplicationContext()), true);
        if (!a7.a(a6, false)) {
            this.f36101f.b(i6, -1);
            a7.a(a6.f36119e);
            return false;
        }
        s c6 = a7.c(a6.f36119e);
        c6.f36116b = 1;
        c6.f36130p = 1;
        this.f36101f.a(c6);
        return true;
    }

    public void b(String str) {
        r a6;
        try {
            if (!TextUtils.isEmpty(str) && (a6 = r.a()) != null) {
                a6.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        this.f36101f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(final String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final r a6;
                    try {
                        if (!TextUtils.isEmpty(str) && (a6 = r.a(StubApp.getOrigApplicationContext(q.this.f36100e.getApplicationContext()), true)) != null) {
                            final s d6 = a6.d(str);
                            if (d6 == null) {
                                s b6 = q.this.f36101f.b(str);
                                if (b6 != null) {
                                    q.this.a(str, b6.f36119e);
                                    return;
                                }
                                return;
                            }
                            new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                                @Override // java.util.TimerTask, java.lang.Runnable
                                public void run() {
                                    a6.b(str);
                                    q.this.f36101f.a(str);
                                    File file = new File(d6.f36119e);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                }
                            }, TTAdConstant.AD_MAX_EVENT_TIME);
                            a6.b(str);
                            q.this.f36101f.a(str);
                            File file = new File(d6.f36119e);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.kuaishou.weapon.p0.q] */
    public boolean a(s sVar, String str, String str2) {
        q qVar;
        r a6;
        if (sVar == null) {
            return false;
        }
        File file = new File(sVar.f36119e);
        if (!dn.a(file)) {
            return false;
        }
        try {
            if (!this.f36101f.b(sVar.f36115a)) {
                this.f36101f.a(sVar);
            }
            a6 = r.a(StubApp.getOrigApplicationContext(this.f36100e.getApplicationContext()), true);
            t tVar = this.f36101f;
            qVar = sVar.f36115a;
            tVar.a(qVar, 1);
            b(sVar.f36117c);
        } catch (Throwable unused) {
            qVar = this;
        }
        if (!a6.a(sVar, true)) {
            file.delete();
            a(sVar.f36115a, sVar.f36118d, null, true, null);
            this.f36101f.a(sVar.f36115a, 0);
            return false;
        }
        qVar = this;
        sVar = a6.c(sVar.f36119e);
        if (sVar == null) {
            qVar.f36101f.a(sVar.f36115a, 0);
            return false;
        }
        try {
            s a7 = qVar.f36101f.a(sVar.f36115a);
            File file2 = (a7 == null || a7.f36118d.equals(sVar.f36118d)) ? null : new File(a7.f36119e);
            sVar.f36116b = 1;
            sVar.f36130p = 1;
            if (qVar.f36101f.a(sVar) > 0 && file2 != null && file2.exists()) {
                file2.delete();
            }
            qVar.f36101f.a(sVar.f36115a, 0);
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
