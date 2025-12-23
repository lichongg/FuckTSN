package com.huawei.hms.feature.dynamic.e;

import dalvik.system.DexClassLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class b extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33237a = "b";

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

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }
}
