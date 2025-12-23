package cn.jpush.android.v;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import cn.jpush.android.ad.f;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f3911a;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f3912e = new Object();

    /* renamed from: b, reason: collision with root package name */
    private Handler f3913b;

    /* renamed from: c, reason: collision with root package name */
    private Context f3914c;

    /* renamed from: d, reason: collision with root package name */
    private String f3915d;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Context context) {
        Throwable th;
        Exception exc;
        Logger.d("JPushLocalNotificationCenter", "triggerLNKillProcess");
        b a6 = b.a(context);
        if (a6.a(false)) {
            Cursor cursor = null;
            try {
                try {
                    Cursor a7 = a6.a(1, System.currentTimeMillis());
                    try {
                        if (a7.moveToFirst()) {
                            do {
                                c a8 = b.a(a7);
                                if (a8 != null) {
                                    a(context, a8.d());
                                    a6.b(a8.a(), 0, 0, 0, a8.d(), a8.f(), a8.e());
                                }
                            } while (a7.moveToNext());
                        }
                        a7.close();
                    } catch (Exception e6) {
                        exc = e6;
                        cursor = a7;
                        Logger.ww("JPushLocalNotificationCenter", "triggerLNKillProcess: " + exc.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a6.b(false);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a7;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a6.b(false);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e7) {
                exc = e7;
            }
            a6.b(false);
        } else {
            Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt: db open failed");
        }
    }

    public synchronized void b(Context context) {
        Logger.dd("JPushLocalNotificationCenter", "clear all local notification ");
        int[] a6 = b.a(context).a();
        if (a6 != null && a6.length > 0) {
            Logger.d("JPushLocalNotificationCenter", " success");
            for (int i6 : a6) {
                JPushInterface.clearNotificationById(this.f3914c, i6);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r2 == null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #1 {all -> 0x0054, blocks: (B:19:0x004d, B:20:0x0050, B:49:0x0086, B:34:0x0072, B:35:0x0075, B:36:0x0078, B:44:0x0079), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c(android.content.Context r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = "JPushLocalNotificationCenter"
            java.lang.String r1 = "init LocalNotification"
            cn.jpush.android.helper.Logger.d(r0, r1)     // Catch: java.lang.Throwable -> L83
            cn.jpush.android.v.b r12 = cn.jpush.android.v.b.a(r12)     // Catch: java.lang.Throwable -> L83
            r1 = 0
            boolean r0 = r12.a(r1)     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L79
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            r5 = 300000(0x493e0, double:1.482197E-318)
            android.database.Cursor r2 = r12.a(r3, r5)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            if (r0 == 0) goto L4c
        L25:
            cn.jpush.android.v.c r0 = cn.jpush.android.v.b.a(r2)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            if (r0 == 0) goto L44
            long r6 = r0.a()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            long r8 = r0.f()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            long r8 = r8 - r3
            r10 = 0
            r5 = r11
            r5.a(r6, r8, r10)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            goto L45
        L3a:
            r0 = move-exception
            goto L70
        L3c:
            r0 = move-exception
            goto L57
        L3e:
            r0 = move-exception
            r5 = r11
            goto L70
        L41:
            r0 = move-exception
            r5 = r11
            goto L57
        L44:
            r5 = r11
        L45:
            boolean r0 = r2.moveToNext()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r0 != 0) goto L25
            goto L4d
        L4c:
            r5 = r11
        L4d:
            r2.close()     // Catch: java.lang.Throwable -> L54
        L50:
            r12.b(r1)     // Catch: java.lang.Throwable -> L54
            goto L81
        L54:
            r0 = move-exception
        L55:
            r12 = r0
            goto L86
        L57:
            java.lang.String r3 = "JPushLocalNotificationCenter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r4.<init>()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r6 = "init LocalNotification cast expt:"
            r4.append(r6)     // Catch: java.lang.Throwable -> L3a
            r4.append(r0)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L3a
            cn.jpush.android.helper.Logger.e(r3, r0)     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L50
            goto L4d
        L70:
            if (r2 == 0) goto L75
            r2.close()     // Catch: java.lang.Throwable -> L54
        L75:
            r12.b(r1)     // Catch: java.lang.Throwable -> L54
            throw r0     // Catch: java.lang.Throwable -> L54
        L79:
            r5 = r11
            java.lang.String r12 = "JPushLocalNotificationCenter"
            java.lang.String r0 = "init LocalNotification cast expt: db open failed"
            cn.jpush.android.helper.Logger.e(r12, r0)     // Catch: java.lang.Throwable -> L54
        L81:
            monitor-exit(r11)
            return
        L83:
            r0 = move-exception
            r5 = r11
            goto L55
        L86:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L54
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.v.a.c(android.content.Context):void");
    }

    public static a a(Context context) {
        Logger.v("JPushLocalNotificationCenter", "getInstance");
        if (f3911a == null) {
            synchronized (f3912e) {
                try {
                    if (f3911a == null) {
                        f3911a = new a(context);
                    }
                } finally {
                }
            }
        }
        return f3911a;
    }

    public void d(final Context context) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification onHeartBeat");
        JCoreHelper.futureExecutor(context, "JPushLocalNotificationCenter", new f("JPushLocationNotificationCenter#onHeartBeat") { // from class: cn.jpush.android.v.a.1
            @Override // cn.jpush.android.ad.f
            public void a() {
                a.this.e(context);
                a.this.c(context);
            }
        });
    }

    private a(Context context) {
        this.f3913b = null;
        this.f3914c = null;
        this.f3915d = "";
        Logger.d("JPushLocalNotificationCenter", "Constructor : JPushLocalNotificationCenter");
        this.f3913b = new Handler(Looper.getMainLooper());
        this.f3914c = context;
        this.f3915d = context.getPackageName();
    }

    private synchronized void a(final long j6, long j7, int i6) {
        try {
            Logger.d("JPushLocalNotificationCenter", "LocalNotification scheduleReadiedLN");
            if (this.f3913b != null) {
                Runnable runnable = new Runnable() { // from class: cn.jpush.android.v.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b a6 = b.a(a.this.f3914c);
                            c a7 = a6.a(j6, 0);
                            if (a7 != null) {
                                if (a7.c() == 1) {
                                    Logger.d("JPushLocalNotificationCenter", "remove ");
                                    a6.b(a7.a(), 0, 1, 0, a7.d(), a7.f(), a7.e());
                                    return;
                                }
                                if (a7.b() > 1) {
                                    Logger.d("JPushLocalNotificationCenter", "repeat add");
                                    a6.b(a7.a(), a7.b() - 1, 0, 0, a7.d(), a7.f(), a7.e());
                                    return;
                                }
                                if (a7.b() != 1) {
                                    Logger.d("JPushLocalNotificationCenter", "already triggered");
                                    return;
                                }
                                Logger.d("JPushLocalNotificationCenter", "send broadcast");
                                if (a7.f() > System.currentTimeMillis()) {
                                    Logger.d("JPushLocalNotificationCenter", "repeat add");
                                    return;
                                }
                                a aVar = a.this;
                                aVar.a(aVar.f3914c, a7.d());
                                a6.b(a7.a(), 0, 0, 0, a7.d(), a7.f(), a7.e());
                            }
                        } catch (Exception e6) {
                            Logger.e("JPushLocalNotificationCenter", "exception:" + e6.getMessage());
                        }
                    }
                };
                if (j7 <= 0) {
                    Logger.d("JPushLocalNotificationCenter", "post right now ");
                    this.f3913b.post(runnable);
                } else {
                    Logger.d("JPushLocalNotificationCenter", "post delayed : " + j7);
                    this.f3913b.postDelayed(runnable, j7);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(Context context, JPushLocalNotification jPushLocalNotification) {
        try {
            Logger.dd("JPushLocalNotificationCenter", "add LocalNotification");
            long currentTimeMillis = System.currentTimeMillis();
            long broadcastTime = jPushLocalNotification.getBroadcastTime() - currentTimeMillis;
            if (cn.jpush.android.cache.a.e(context)) {
                Logger.d("JPushLocalNotificationCenter", "push has stopped");
            }
            long notificationId = jPushLocalNotification.getNotificationId();
            try {
                b a6 = b.a(context);
                if (a6.a(notificationId, 0) != null) {
                    a6.b(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
                } else {
                    a6.a(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
                }
            } catch (Exception e6) {
                Logger.e("JPushLocalNotificationCenter", "exception:" + e6.getMessage());
            }
            if (broadcastTime < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                a(jPushLocalNotification.getNotificationId(), broadcastTime, 0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(Context context, String str) {
        Logger.d("JPushLocalNotificationCenter", "start LocalNotification broadCastToPushService");
        Bundle bundle = new Bundle();
        bundle.putString("local_notify_msg", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "show_local_notify", bundle);
        Logger.d("JPushLocalNotificationCenter", "end LocalNotification broadCastToPushService");
    }

    public synchronized boolean a(Context context, long j6) {
        Logger.dd("JPushLocalNotificationCenter", "remove LocalNotification ");
        long j7 = (int) j6;
        try {
            b a6 = b.a(context);
            c a7 = a6.a(j7, 0);
            if (a7 == null) {
                return false;
            }
            Logger.d("JPushLocalNotificationCenter", "remove local count : " + a7.b());
            a6.a(j7);
            JPushInterface.clearNotificationById(this.f3914c, (int) j7);
            return true;
        } catch (Exception e6) {
            Logger.e("JPushLocalNotificationCenter", "exception:" + e6.getMessage());
            return false;
        }
    }
}
