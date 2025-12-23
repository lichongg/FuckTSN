package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMConfigureImpl {

    /* renamed from: e, reason: collision with root package name */
    private static final int f41608e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private static ScheduledExecutorService f41609f;

    /* renamed from: g, reason: collision with root package name */
    private static Context f41610g;

    /* renamed from: a, reason: collision with root package name */
    private static String f41604a = au.b().b(au.f40910o);

    /* renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f41605b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static int f41606c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f41607d = false;

    /* renamed from: h, reason: collision with root package name */
    private static int f41611h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static Runnable f41612i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f41606c == 0 || UMConfigureImpl.f41611h >= 10) {
                    if (!UMConfigureImpl.f41607d) {
                        boolean unused = UMConfigureImpl.f41607d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f41610g);
                    }
                    if (UMConfigureImpl.f41609f != null) {
                        UMConfigureImpl.f41609f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f41609f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f41605b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f41605b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f41604a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(f41604a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f41604a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f41604a, false);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static /* synthetic */ int f() {
        int i6 = f41611h;
        f41611h = i6 + 1;
        return i6;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f41610g = context;
        try {
            if (f41606c < 1) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                return;
            }
            if (d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                return;
            }
            UMEnvelopeBuild.setTransmissionSendFlag(false);
            c(context);
            if (f41609f == null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                f41609f = newScheduledThreadPool;
                newScheduledThreadPool.scheduleAtFixedRate(f41612i, 0L, 100L, TimeUnit.MILLISECONDS);
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f41606c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = f41605b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = f41605b) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f41605b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f41606c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f41605b;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }
}
