package com.huawei.hms.feature.dynamic.e;

import dalvik.system.PathClassLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class a extends PathClassLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33236a = "a";

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z5) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z5);
    }

    public a(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }
}
