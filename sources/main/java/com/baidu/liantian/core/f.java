package com.baidu.liantian.core;

import dalvik.system.DexClassLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f extends DexClassLoader {
    public f(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    public final Class<?> a(String str) {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                return findClass(str);
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
        return findLoadedClass;
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z5) {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
            } catch (Throwable unused) {
            }
            if (findLoadedClass == null) {
                try {
                    if (getParent() != null) {
                        findLoadedClass = getParent().loadClass(str);
                    } else {
                        findLoadedClass = (Class) f.class.getDeclaredMethod("findBootstrapClassOrNull", String.class).invoke(this, str);
                    }
                } catch (Throwable unused2) {
                    com.baidu.liantian.b.e.a();
                }
            }
        }
        if (z5) {
            resolveClass(findLoadedClass);
        }
        if (findLoadedClass == null) {
            try {
                return super.loadClass(str, z5);
            } catch (Throwable unused3) {
                com.baidu.liantian.b.e.a();
            }
        }
        return findLoadedClass;
    }
}
