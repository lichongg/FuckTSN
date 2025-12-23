package cn.jpush.android.q;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.o.a;
import cn.jpush.android.r.b;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f3763a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerC0057a f3764b;

    /* renamed from: c, reason: collision with root package name */
    private String f3765c;

    /* renamed from: d, reason: collision with root package name */
    private d f3766d;

    /* renamed from: cn.jpush.android.q.a$a, reason: collision with other inner class name */
    static class HandlerC0057a extends Handler {
        /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:8:0x0036, B:9:0x003a, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:18:0x0056, B:21:0x0067, B:24:0x006e, B:26:0x0076, B:28:0x007e, B:30:0x0086, B:32:0x008e), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0046 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:8:0x0036, B:9:0x003a, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:18:0x0056, B:21:0x0067, B:24:0x006e, B:26:0x0076, B:28:0x007e, B:30:0x0086, B:32:0x008e), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006e A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:8:0x0036, B:9:0x003a, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:18:0x0056, B:21:0x0067, B:24:0x006e, B:26:0x0076, B:28:0x007e, B:30:0x0086, B:32:0x008e), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:8:0x0036, B:9:0x003a, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:18:0x0056, B:21:0x0067, B:24:0x006e, B:26:0x0076, B:28:0x007e, B:30:0x0086, B:32:0x008e), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007e A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:8:0x0036, B:9:0x003a, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:18:0x0056, B:21:0x0067, B:24:0x006e, B:26:0x0076, B:28:0x007e, B:30:0x0086, B:32:0x008e), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0086 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:8:0x0036, B:9:0x003a, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:18:0x0056, B:21:0x0067, B:24:0x006e, B:26:0x0076, B:28:0x007e, B:30:0x0086, B:32:0x008e), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008e A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:3:0x0005, B:5:0x0022, B:7:0x002e, B:8:0x0036, B:9:0x003a, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:18:0x0056, B:21:0x0067, B:24:0x006e, B:26:0x0076, B:28:0x007e, B:30:0x0086, B:32:0x008e), top: B:2:0x0005 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r5) {
            /*
                r4 = this;
                java.lang.String r0 = "InAppConnect"
                super.handleMessage(r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
                r1.<init>()     // Catch: java.lang.Throwable -> L33
                java.lang.String r2 = "send message to handle, what: "
                r1.append(r2)     // Catch: java.lang.Throwable -> L33
                int r2 = r5.what     // Catch: java.lang.Throwable -> L33
                r1.append(r2)     // Catch: java.lang.Throwable -> L33
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L33
                cn.jpush.android.helper.Logger.d(r0, r1)     // Catch: java.lang.Throwable -> L33
                android.os.Bundle r1 = r5.getData()     // Catch: java.lang.Throwable -> L33
                r2 = 0
                if (r1 == 0) goto L35
                java.lang.String r3 = "n_content"
                java.lang.String r1 = r1.getString(r3)     // Catch: java.lang.Throwable -> L33
                boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L33
                if (r3 != 0) goto L35
                cn.jpush.android.d.d r1 = cn.jpush.android.d.d.b(r1)     // Catch: java.lang.Throwable -> L33
                goto L36
            L33:
                r5 = move-exception
                goto L96
            L35:
                r1 = r2
            L36:
                android.content.Context r3 = cn.jpush.android.local.JPushConstants.mApplicationContext     // Catch: java.lang.Throwable -> L33
                int r5 = r5.what     // Catch: java.lang.Throwable -> L33
                switch(r5) {
                    case 1001: goto L8e;
                    case 1002: goto L86;
                    case 1003: goto L7e;
                    case 1004: goto L76;
                    case 1005: goto L6e;
                    case 1006: goto L46;
                    case 1007: goto L3e;
                    default: goto L3d;
                }     // Catch: java.lang.Throwable -> L33
            L3d:
                return
            L3e:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L33
                r5.e(r3, r1)     // Catch: java.lang.Throwable -> L33
                return
            L46:
                boolean r5 = cn.jpush.android.ad.a.j(r3)     // Catch: java.lang.Throwable -> L33
                if (r5 == 0) goto L6b
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L33
                boolean r5 = r5.c()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L65
                java.lang.String r5 = "no message is showing,start to handle cache message"
                cn.jpush.android.helper.Logger.d(r0, r5)     // Catch: java.lang.Throwable -> L33
                cn.jpush.android.q.a r5 = cn.jpush.android.q.a.a()     // Catch: java.lang.Throwable -> L33
                java.lang.String r1 = "handle_cache_message"
                r5.a(r3, r2, r1)     // Catch: java.lang.Throwable -> L33
                return
            L65:
                java.lang.String r5 = "inapp message is showing,do nothing "
            L67:
                cn.jpush.android.helper.Logger.d(r0, r5)     // Catch: java.lang.Throwable -> L33
                return
            L6b:
                java.lang.String r5 = " inapp message do not show in background,do nothing"
                goto L67
            L6e:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L33
                r5.g(r3, r1)     // Catch: java.lang.Throwable -> L33
                return
            L76:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L33
                r5.c(r3, r1)     // Catch: java.lang.Throwable -> L33
                return
            L7e:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L33
                r5.a(r3)     // Catch: java.lang.Throwable -> L33
                return
            L86:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L33
                r5.b(r3, r1)     // Catch: java.lang.Throwable -> L33
                return
            L8e:
                cn.jpush.android.o.a r5 = cn.jpush.android.o.a.a()     // Catch: java.lang.Throwable -> L33
                r5.a(r3, r1)     // Catch: java.lang.Throwable -> L33
                return
            L96:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "handleMessage failed, "
                r1.append(r2)
                java.lang.String r5 = r5.getMessage()
                r1.append(r5)
                java.lang.String r5 = r1.toString()
                cn.jpush.android.helper.Logger.w(r0, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.q.a.HandlerC0057a.handleMessage(android.os.Message):void");
        }

        public HandlerC0057a(Looper looper) {
            super(looper);
        }
    }

    public static a a() {
        if (f3763a == null) {
            synchronized (a.class) {
                try {
                    if (f3763a == null) {
                        f3763a = new a();
                    }
                } finally {
                }
            }
        }
        return f3763a;
    }

    private synchronized Handler b() {
        if (this.f3764b == null) {
            try {
                this.f3764b = new HandlerC0057a(Looper.getMainLooper());
            } catch (Throwable th) {
                Logger.w("InAppConnect", "build handle failed, " + th.getMessage());
                try {
                    this.f3764b = new HandlerC0057a(Looper.getMainLooper());
                } catch (Throwable unused) {
                }
            }
        }
        return this.f3764b;
    }

    public void a(int i6) {
        if (b().hasMessages(i6)) {
            Logger.d("InAppConnect", "removeHandler remove waht=" + i6);
            b().removeMessages(i6);
        }
    }

    public void b(Context context, d dVar, int i6) {
        long b6;
        if (i6 == 1003 || i6 == 1002) {
            try {
                a(1002);
            } catch (Throwable th) {
                Logger.w("InAppConnect", "sendToMainHandler failed, " + th.getMessage());
                return;
            }
        }
        int i7 = dVar.bu;
        long j6 = 0;
        if (1 == i7) {
            long j7 = dVar.aR;
            if (i6 == 1002) {
                j6 = b.a(context, j7, true);
            }
        } else if (4 == i7) {
            b6 = cn.jpush.android.o.a.a().b() ? b.b(context, dVar.bR) : 0L;
            if (i6 != 1002) {
            }
            j6 = b.a(context, b6, false);
        } else {
            b6 = cn.jpush.android.o.a.a().b() ? b.b(context, dVar.bR) : dVar.bQ;
            if (i6 != 1002) {
            }
            j6 = b.a(context, b6, false);
        }
        if (i6 == 1005) {
            j6 = 1000;
        }
        Bundle bundle = new Bundle();
        bundle.putString("n_content", dVar.c());
        Message message = new Message();
        message.what = i6;
        message.arg1 = (int) j6;
        message.setData(bundle);
        b().sendMessageDelayed(message, j6);
        Logger.dd("InAppConnect", "notify inapp send to handler succeed, delayTime: " + j6 + ", what: " + i6);
    }

    public void a(Context context) {
        if (cn.jpush.android.p.b.a().b() <= 0) {
            Logger.d("InAppConnect", "no notify inapp cache to deal");
            return;
        }
        Logger.d("InAppConnect", "checkCacheOnRemoteProcess target=" + this.f3765c);
        d b6 = cn.jpush.android.p.b.a().b(this.f3765c);
        this.f3766d = b6;
        if (b6 == null) {
            Logger.d("InAppConnect", "no find  message match target");
        } else {
            Logger.d("InAppConnect", "start to deal cache notify inapp message");
            JCoreHelper.majorExecutor(context, "InAppConnect", new a.C0056a(context, this.f3766d));
        }
    }

    public void b(Context context, d dVar, String str) {
        cn.jpush.android.x.b.a(context, str, dVar, (Intent) null);
    }

    public void a(Context context, Bundle bundle, String str) {
        if (context != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, str, bundle);
        }
    }

    public void b(Context context, String str) {
        Logger.d("InAppConnect", "onTargetChange localTarget=" + this.f3765c + " newTarget=" + str);
        this.f3765c = str;
        cn.jpush.android.p.b.a().c();
    }

    public void a(Context context, d dVar) {
        if (context == null || dVar == null) {
            return;
        }
        Logger.d("InAppConnect", "start to process notify message");
        cn.jpush.android.d.b.a(context, dVar);
    }

    public void a(Context context, d dVar, int i6) {
        b(context, dVar, i6);
    }

    public void a(Context context, d dVar, String str) {
        Logger.d("InAppConnect", "processOnRemoteProcess mCurrentTarget=" + this.f3765c);
        if (dVar == null) {
            Logger.d("InAppConnect", "parsing json failed");
            c.a(context, str, 2004L, 4);
        } else {
            if (40 != dVar.bt) {
                c.a(context, dVar.f3588d, 2005L, 4);
            }
            cn.jpush.android.p.b.a().a(dVar);
            a().b(context, dVar, "check_can_show_message");
        }
    }

    public void a(Context context, String str) {
        cn.jpush.android.o.a.a().b(context, str);
    }

    public void a(Context context, boolean z5) {
        if (z5) {
            cn.jpush.android.ad.c.d(context, this.f3766d.f3588d);
            cn.jpush.android.p.b.a().b(this.f3766d);
        }
        cn.jpush.android.p.b.a().c(this.f3766d.f3588d);
    }
}
