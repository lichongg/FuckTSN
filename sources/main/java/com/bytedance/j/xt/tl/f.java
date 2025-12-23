package com.bytedance.j.xt.tl;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static String f24231a;

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f24232b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f24233c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f24234d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f24235e;

    public static boolean b(Context context) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        r4 = r4.get(0).topActivity;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean h(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r4.getPackageName()
            java.lang.String r2 = "activity"
            java.lang.Object r4 = r4.getSystemService(r2)     // Catch: java.lang.Throwable -> L37
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4     // Catch: java.lang.Throwable -> L37
            if (r4 != 0) goto L13
            return r0
        L13:
            r2 = 1
            java.util.List r4 = r4.getRunningTasks(r2)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L37
            boolean r3 = r4.isEmpty()     // Catch: java.lang.Throwable -> L37
            if (r3 != 0) goto L37
            java.lang.Object r4 = r4.get(r0)     // Catch: java.lang.Throwable -> L37
            android.app.ActivityManager$RunningTaskInfo r4 = (android.app.ActivityManager.RunningTaskInfo) r4     // Catch: java.lang.Throwable -> L37
            android.content.ComponentName r4 = cn.jpush.android.ui.e.a(r4)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L37
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L37
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L37
            return r2
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.j.xt.tl.f.h(android.content.Context):boolean");
    }

    @Nullable
    private static Class<?> a(Context context) {
        if (f24232b == null && !f24235e) {
            try {
                f24232b = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            f24235e = true;
        }
        return f24232b;
    }

    private static long c(int i6) {
        if (i6 < 0) {
            return 0L;
        }
        return i6 * 1024;
    }

    @Nullable
    public static ActivityManager.ProcessErrorStateInfo d(Context context, int i6) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return null;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            SystemClock.sleep(200L);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        }
        return null;
    }

    private static void f(@NonNull JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", c(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", c(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", c(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", c(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", c(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", c(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", c(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", c(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", p.b(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", c(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", p.c(memoryInfo));
        jSONObject2.put("totalSharedDirty", c(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", c(p.a(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    private static void g(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    @Nullable
    public static String j(Context context) {
        String str = f24231a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            f24231a = n.c(context);
        } catch (Throwable unused) {
        }
        String str2 = f24231a;
        return str2 == null ? "" : str2;
    }

    private static void l(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", a.a(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    public static void e(@NonNull Context context, @NonNull JSONObject jSONObject) {
        try {
            f(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                l(jSONObject, activityManager);
            }
            g(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    public static int i(Context context) {
        Class<?> a6 = a(context);
        if (f24234d == null && a6 != null) {
            try {
                f24234d = a6.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = f24234d;
        if (field != null) {
            try {
                return ((Integer) field.get(null)).intValue();
            } catch (Throwable unused2) {
                return -1;
            }
        }
        return -1;
    }

    @NonNull
    public static String k(Context context) {
        Class<?> a6 = a(context);
        if (f24233c == null && a6 != null) {
            try {
                f24233c = a6.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = f24233c;
        if (field != null) {
            try {
                return (String) field.get(null);
            } catch (Throwable unused2) {
                return "";
            }
        }
        return "";
    }

    public static boolean m(Context context) {
        String j6 = j(context);
        if (j6 != null && j6.contains(":")) {
            return false;
        }
        if (j6 != null && j6.equals(context.getPackageName())) {
            return true;
        }
        if (j6 == null || !j6.equals(context.getApplicationInfo().processName)) {
            return false;
        }
        return true;
    }
}
