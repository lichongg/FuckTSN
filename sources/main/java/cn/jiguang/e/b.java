package cn.jiguang.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.by.d;
import cn.jiguang.bz.v;
import cn.jiguang.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, SharedPreferences> f2930a = new ConcurrentHashMap();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static volatile Handler f2933a;

        /* renamed from: b, reason: collision with root package name */
        private static final Object f2934b = new Object();

        /* renamed from: c, reason: collision with root package name */
        private static final LinkedList<Runnable> f2935c = new LinkedList<>();

        /* renamed from: d, reason: collision with root package name */
        private static boolean f2936d = true;

        /* renamed from: e, reason: collision with root package name */
        private static final Object f2937e = new Object();

        /* renamed from: cn.jiguang.e.b$a$a, reason: collision with other inner class name */
        private static class HandlerC0044a extends Handler {
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.e.b.a.a.1
                        @Override // cn.jiguang.by.b
                        public void a() {
                            a.c();
                        }
                    });
                }
            }

            HandlerC0044a(Looper looper) {
                super(looper);
            }
        }

        public static void a(Runnable runnable, boolean z5) {
            try {
                Handler b6 = b();
                if (b6 != null) {
                    synchronized (f2934b) {
                        try {
                            f2935c.add(runnable);
                            if (z5 && f2936d) {
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
                f.i("Sp", "sp task add queue failed, " + th2.getMessage());
            }
        }

        private static Handler b() {
            if (f2933a == null) {
                synchronized (f2934b) {
                    try {
                        if (f2933a == null) {
                            f2933a = new HandlerC0044a(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
            }
            return f2933a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c() {
            LinkedList linkedList;
            try {
                System.currentTimeMillis();
                synchronized (f2937e) {
                    try {
                        synchronized (f2934b) {
                            try {
                                LinkedList<Runnable> linkedList2 = f2935c;
                                linkedList = (LinkedList) linkedList2.clone();
                                linkedList2.clear();
                                Handler b6 = b();
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
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                f.i("Sp", "sp commit task error, " + th2.getMessage());
            }
        }
    }

    public static <T> T a(Context context, cn.jiguang.e.a<T> aVar) {
        T t5 = (T) b(context, aVar);
        return t5 != null ? t5 : aVar.f2927d;
    }

    private static <T> T a(SharedPreferences sharedPreferences, String str, T t5) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                String str2 = (T) sharedPreferences.getString(str, null);
                Object obj = str2;
                if (str2 != null) {
                    int length = str2.length();
                    obj = str2;
                    if (length > 0) {
                        obj = (T) v.b(str2, cn.jiguang.a.a.f1451i);
                    }
                }
                if (obj == null) {
                    return t5;
                }
                if (t5 instanceof Boolean) {
                    return (T) Boolean.valueOf((String) obj);
                }
                if (t5 instanceof String) {
                    return (T) obj;
                }
                if (t5 instanceof Integer) {
                    return (T) Integer.valueOf((String) obj);
                }
                if (t5 instanceof Long) {
                    return (T) Long.valueOf((String) obj);
                }
                if (t5 instanceof Float) {
                    return (T) Float.valueOf((String) obj);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static <T> T b(Context context, cn.jiguang.e.a<T> aVar) {
        T t5 = (T) a(e(context, aVar.f2925b), aVar.f2926c, aVar.f2927d, aVar.f2929f);
        if (t5 == null && aVar.f2928e) {
            t5 = (T) a(d(context, aVar.f2925b), aVar.f2926c, aVar.f2927d, aVar.f2929f);
        }
        if (t5 == null) {
            return null;
        }
        aVar.a((cn.jiguang.e.a<T>) t5);
        return t5;
    }

    private static SharedPreferences d(Context context, String str) {
        if (context == null) {
            return null;
        }
        context.getSharedPreferences(str, 4);
        return context.getSharedPreferences(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(SharedPreferences sharedPreferences, String str, T t5, boolean z5) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (z5) {
                    return (T) a(sharedPreferences, str, t5);
                }
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

    public static void b(Context context, cn.jiguang.e.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        a(context, false, aVarArr);
    }

    private static void c(Context context, String str) {
        String str2 = (String) a(context, cn.jiguang.e.a.aa());
        if (!TextUtils.isEmpty(str2)) {
            str2.startsWith("1.");
        }
        if (((Integer) a(context, cn.jiguang.e.a.Z())).intValue() == 0) {
            a(context, a.C0042a.C0043a.a(), a.C0042a.C0043a.b());
            a(context, a.C0042a.C0043a.c(), a.C0042a.C0043a.d());
        }
        a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.Z().a((cn.jiguang.e.a<Integer>) 1)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = f2930a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences == null && context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
            map.put(str, sharedPreferences2);
            c(context, str);
            return sharedPreferences2;
        }
        return sharedPreferences;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(Context context, cn.jiguang.e.a<T> aVar, cn.jiguang.e.a<T> aVar2) {
        Object b6;
        if (b(context, aVar) != null || (b6 = b(context, aVar2)) == null) {
            return;
        }
        a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{aVar.a((cn.jiguang.e.a<T>) b6)});
        a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{aVar2.a((cn.jiguang.e.a<T>) null)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t5, boolean z5) {
        if (editor != null) {
            if (t5 == 0) {
                editor.remove(str);
                return;
            }
            if (z5) {
                String valueOf = String.valueOf(t5);
                if (valueOf.length() > 0) {
                    valueOf = v.a(valueOf, cn.jiguang.a.a.f1451i);
                }
                editor.putString(str, valueOf);
                return;
            }
            if (t5 instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t5).booleanValue());
                return;
            }
            if (t5 instanceof String) {
                editor.putString(str, (String) t5);
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

    public static void a(Context context, String str) {
        SharedPreferences e6 = e(context, str);
        if (e6 != null) {
            e6.edit().clear().apply();
        }
    }

    private static void a(final Context context, boolean z5, final cn.jiguang.e.a<?>... aVarArr) {
        try {
            cn.jiguang.by.b bVar = new cn.jiguang.by.b() { // from class: cn.jiguang.e.b.1
                @Override // cn.jiguang.by.b
                public void a() {
                    SharedPreferences e6;
                    try {
                        HashMap hashMap = new HashMap();
                        for (cn.jiguang.e.a aVar : aVarArr) {
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(aVar.f2925b);
                            if (editor == null && (e6 = b.e(context, aVar.f2925b)) != null) {
                                editor = e6.edit();
                                hashMap.put(aVar.f2925b, editor);
                            }
                            b.b(editor, aVar.f2926c, aVar.f2927d, aVar.f2929f);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            SharedPreferences.Editor editor2 = (SharedPreferences.Editor) entry.getValue();
                            if (editor2 != null) {
                                editor2.apply();
                            }
                        }
                    } catch (Throwable th) {
                        f.i("Sp", "sp commit failed, " + th.getMessage());
                    }
                }
            };
            if (z5) {
                a.a(bVar, false);
            } else {
                bVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, cn.jiguang.e.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        if (!a()) {
            b(context, aVarArr);
        } else {
            f.c("Sp", "main thread, async sp set");
            a(context, true, aVarArr);
        }
    }

    private static boolean a() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            f.i("Sp", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }
}
