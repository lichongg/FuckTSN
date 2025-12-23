package com.kwad.sdk.crash.utils;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class JvmtiHelper {
    private static final String AGENT_LIB = "ti-monitor";
    private static final long DELAY_MS = 200;
    public static final String KEY = "TI_PERF_MONITOR";
    private static final long LOW_MEM_THRESHOLD = 209715200;
    private static final int MB = 1048576;
    private static final int MIN_ALLOC_SIZE = 3145728;
    private static final int MIN_CLASS_LEN = 10485760;
    private static final int MIN_INTERVAL = 10;
    public static final String TAG = "jvmti";
    private static boolean isJdwpEnable;
    private static int mAllocRealSetting;
    private static int mLoadSizeRealSetting;
    private static boolean mLoaded;
    private static long preAllocEventTime;
    private static String preAllocMsg;
    private static String preClassLoadMsg;

    public static native boolean avoidDeoptForReleaseBuild();

    public static native boolean disableJdwp();

    public static native boolean enableJdwp();

    private static native StackTraceElement[] frameInfoToTrace(String str);

    private static native long getObjectSize(Object obj);

    private static native boolean loadTiAgent();

    private static native void setConfig(int i6, int i7, int i8, int i9, boolean z5, boolean z6, String str, boolean z7);

    private static native boolean unloadAgent();

    @RequiresApi(api = 26)
    public static boolean ensureAgentLoad() {
        loadLibrary("openjdkjvmti");
        return true;
    }

    public static int getAllocSizeRealSetting() {
        return mAllocRealSetting;
    }

    public static int getLoadSizeRealSetting() {
        return mLoadSizeRealSetting;
    }

    public static boolean isJDWPEnable() {
        return isJdwpEnable;
    }

    public static boolean isLoaded() {
        return mLoaded;
    }

    public static boolean loadLibrary(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "java.lang.System");
            ((Method) declaredMethod2.invoke(cls, "loadLibrary", new Class[]{String.class})).invoke(cls, str);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        } catch (NoSuchMethodException e7) {
            e7.printStackTrace();
        } catch (InvocationTargetException e8) {
            e8.printStackTrace();
        }
        return true;
    }

    public static void unloadTiAgent() {
        if (mLoaded) {
            unloadAgent();
            mLoaded = false;
        }
    }

    private static void doClazzLoadAsyncReport(String str) {
        System.currentTimeMillis();
    }

    private static void doGCAsyncReport(String str) {
        System.currentTimeMillis();
    }

    @Keep
    public static void fastUnwindStack(String str) {
        try {
            for (StackTraceElement stackTraceElement : frameInfoToTrace(str)) {
                stackTraceElement.toString();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Keep
    public static void logEvent(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("alloc_obj")) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - preAllocEventTime >= 10 && !str.equals(preAllocMsg)) {
                        preAllocEventTime = currentTimeMillis;
                        preAllocMsg = str;
                        doAllocAsyncReport(str, currentTimeMillis);
                        return;
                    }
                    preAllocEventTime = currentTimeMillis;
                    preAllocMsg = str;
                    return;
                }
                if (str.startsWith("gc_start")) {
                    doGCAsyncReport(str);
                    return;
                }
                if (str.startsWith("class_load") && !str.equals(preClassLoadMsg)) {
                    preClassLoadMsg = str;
                    doClazzLoadAsyncReport(str);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private static boolean unlikely(boolean z5) {
        return z5;
    }

    private static void doAllocAsyncReport(String str, long j6) {
    }
}
