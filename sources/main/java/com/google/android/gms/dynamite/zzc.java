package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzc extends PathClassLoader {
    @Override // java.lang.ClassLoader
    protected final Class loadClass(String str, boolean z5) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z5);
    }

    zzc(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }
}
