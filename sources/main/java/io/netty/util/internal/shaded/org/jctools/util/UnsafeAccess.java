package io.netty.util.internal.shaded.org.jctools.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class UnsafeAccess {
    public static final boolean SUPPORTS_GET_AND_SET;
    public static final Unsafe UNSAFE;

    static {
        Unsafe unsafe;
        boolean z5 = false;
        try {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                unsafe = (Unsafe) declaredField.get(null);
            } catch (Exception unused) {
                Constructor declaredConstructor = Unsafe.class.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                unsafe = (Unsafe) declaredConstructor.newInstance(null);
            }
            try {
                Unsafe.class.getMethod("getAndSetObject", Object.class, Long.TYPE, Object.class);
                z5 = true;
            } catch (Exception unused2) {
            }
            UNSAFE = unsafe;
            SUPPORTS_GET_AND_SET = z5;
        } catch (Exception e6) {
            SUPPORTS_GET_AND_SET = false;
            throw new RuntimeException(e6);
        }
    }
}
