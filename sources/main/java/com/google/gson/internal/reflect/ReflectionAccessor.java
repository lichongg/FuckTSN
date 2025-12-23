package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    public abstract void makeAccessible(AccessibleObject accessibleObject);

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    static {
        ReflectionAccessor unsafeReflectionAccessor;
        if (JavaVersion.getMajorJavaVersion() < 9) {
            unsafeReflectionAccessor = new PreJava9ReflectionAccessor();
        } else {
            unsafeReflectionAccessor = new UnsafeReflectionAccessor();
        }
        instance = unsafeReflectionAccessor;
    }
}
