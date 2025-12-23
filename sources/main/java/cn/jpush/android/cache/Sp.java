package cn.jpush.android.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class Sp {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, SharedPreferences> f3570a = new ConcurrentHashMap();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Handler f3573a;

        /* renamed from: e, reason: collision with root package name */
        private static Context f3577e;

        /* renamed from: b, reason: collision with root package name */
        private static final Object f3574b = new Object();

        /* renamed from: c, reason: collision with root package name */
        private static final LinkedList<Runnable> f3575c = new LinkedList<>();

        /* renamed from: d, reason: collision with root package name */
        private static boolean f3576d = true;

        /* renamed from: f, reason: collision with root package name */
        private static final Object f3578f = new Object();

        /* renamed from: cn.jpush.android.cache.Sp$a$a, reason: collision with other inner class name */
        private static class HandlerC0054a extends Handler {
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JCoreHelper.futureExecutor(a.f3577e, new f() { // from class: cn.jpush.android.cache.Sp.a.a.1
                        @Override // cn.jpush.android.ad.f
                        public void a() {
                            a.c(a.f3577e);
                        }
                    });
                }
            }

            HandlerC0054a(Looper looper) {
                super(looper);
            }
        }

        private static Handler b(Context context) {
            f3577e = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : JPushConstants.getAppContext(null);
            if (f3573a == null) {
                synchronized (f3574b) {
                    try {
                        if (f3573a == null) {
                            f3573a = new HandlerC0054a(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
            }
            return f3573a;
        }

        public static void a(Context context, Runnable runnable, boolean z5) {
            try {
                Handler b6 = b(context);
                if (b6 != null) {
                    synchronized (f3574b) {
                        try {
                            f3575c.add(runnable);
                            if (z5 && f3576d) {
                                b6.sendEmptyMessageDelayed(1, 100L);
                            } else {
                                b6.sendEmptyMessage(1);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Logger.w("Sp", "sp task add queue failed, " + th2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            LinkedList linkedList;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (f3578f) {
                    try {
                        synchronized (f3574b) {
                            try {
                                LinkedList<Runnable> linkedList2 = f3575c;
                                linkedList = (LinkedList) linkedList2.clone();
                                linkedList2.clear();
                                Handler b6 = b(context);
                                if (b6 != null) {
                                    b6.removeMessages(1);
                                }
                            } finally {
                            }
                        }
                        if (linkedList.size() > 0) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                            if (JConstants.DEBUG_MODE) {
                                Logger.d("Sp", "sp processing " + linkedList.size() + " items took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Logger.w("Sp", "sp commit task error, " + th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences b(Context context, String str) {
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = f3570a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || (appContext = JPushConstants.getAppContext(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = appContext.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        c(appContext, str);
        return sharedPreferences2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(SharedPreferences sharedPreferences, String str, T t5) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t5 instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t5).booleanValue()));
                }
                if (t5 instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t5);
                }
                if (t5 instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t5).intValue()));
                }
                if (t5 instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t5).longValue()));
                }
                if (t5 instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t5).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t5, boolean z5) {
        if (editor != null) {
            if (t5 == 0) {
                editor.remove(str);
                return;
            }
            if (t5 instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t5).booleanValue());
                return;
            }
            if (t5 instanceof String) {
                String str2 = (String) t5;
                String str3 = t5;
                if (z5) {
                    str3 = t5;
                    if (str2.length() > 0) {
                        str3 = (T) l.a(str2, m.f3488a);
                    }
                }
                editor.putString(str, str3);
                return;
            }
            if (t5 instanceof Integer) {
                editor.putInt(str, ((Integer) t5).intValue());
            } else if (t5 instanceof Long) {
                editor.putLong(str, ((Long) t5).longValue());
            } else if (t5 instanceof Float) {
                editor.putFloat(str, ((Float) t5).floatValue());
            }
        }
    }

    public static <T> T getWithNull(Context context, Key<T> key) {
        Object a6 = a(b(context, key.f3565a), key.f3566b, key.f3567c);
        if (a6 == null && key.f3568d) {
            a6 = (T) a(reload(context, key.f3565a), key.f3566b, key.f3567c);
        }
        if (a6 == null) {
            return null;
        }
        if (key.f3569e && (a6 instanceof String)) {
            String str = a6;
            if (str.length() > 0) {
                a6 = (T) l.b(str, m.f3488a);
            }
        }
        key.set(a6);
        return (T) a6;
    }

    public static void read(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        for (Key<?> key : keyArr) {
            get(context, key);
        }
    }

    public static void set(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        if (!a()) {
            sync_set(context, keyArr);
        } else {
            Logger.d("Sp", "main thread, async sp set");
            a(context, true, keyArr);
        }
    }

    public static void sync_set(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        a(context, false, keyArr);
    }

    private static void a(final Context context, boolean z5, final Key<?>... keyArr) {
        f fVar = new f() { // from class: cn.jpush.android.cache.Sp.1
            @Override // cn.jpush.android.ad.f
            public void a() {
                SharedPreferences b6;
                try {
                    HashMap hashMap = new HashMap();
                    for (Key key : keyArr) {
                        SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(key.f3565a);
                        if (editor == null && (b6 = Sp.b(context, key.f3565a)) != null) {
                            editor = b6.edit();
                            hashMap.put(key.f3565a, editor);
                        }
                        Sp.b(editor, key.f3566b, key.f3567c, key.f3569e);
                    }
                    for (String str : hashMap.keySet()) {
                        SharedPreferences.Editor editor2 = (SharedPreferences.Editor) hashMap.get(str);
                        if (editor2 != null && !editor2.commit()) {
                            Logger.w("Sp", "sp commit failed, sp_file: " + str);
                        }
                    }
                } catch (Throwable th) {
                    Logger.w("Sp", "sp commit failed, " + th.getMessage());
                }
            }
        };
        try {
            if (z5) {
                a.a(context, fVar, false);
            } else {
                fVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static void clear(Context context, String str) {
        SharedPreferences b6 = b(context, str);
        if (b6 != null) {
            b6.edit().clear().apply();
        }
    }

    public static <T> T get(Context context, Key<T> key) {
        T t5 = (T) getWithNull(context, key);
        if (t5 != null) {
            return t5;
        }
        return key.f3567c;
    }

    public static SharedPreferences reload(Context context, String str) {
        Context appContext = JPushConstants.getAppContext(context);
        if (appContext != null) {
            appContext.getSharedPreferences(str, 4);
            return appContext.getSharedPreferences(str, 0);
        }
        return null;
    }

    private static boolean a() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private static void c(Context context, String str) {
    }
}
