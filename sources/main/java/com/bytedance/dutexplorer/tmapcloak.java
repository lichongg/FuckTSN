package com.bytedance.dutexplorer;

import com.bytedance.component.sdk.annotation.Keep;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.l.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class tmapcloak {
    static int DexNum;
    public static boolean loadLibSuccess;

    public static native byte bob_bytedance_call(int i6, int i7, Object... objArr);

    public static native char cob_bytedance_call(int i6, int i7, Object... objArr);

    public static native double dob_bytedance_call(int i6, int i7, Object... objArr);

    public static native float fob_bytedance_call(int i6, int i7, Object... objArr);

    public static native int iob_bytedance_call(int i6, int i7, Object... objArr);

    public static native long job_bytedance_call(int i6, int i7, Object... objArr);

    public static native Object obj_bytedance_call(int i6, int i7, Object... objArr);

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(null);
    }

    public static native short sob_bytedance_call(int i6, int i7, Object... objArr);

    public static native void voi_bytedance_call(int i6, int i7, Object... objArr);

    public static native boolean zob_bytedance_call(int i6, int i7, Object... objArr);

    static {
        try {
            if (DexNum > 0) {
                m.j("maparmor");
            }
            loadLibSuccess = true;
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }
}
