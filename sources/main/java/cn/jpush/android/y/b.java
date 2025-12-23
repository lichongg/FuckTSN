package cn.jpush.android.y;

import dalvik.system.DexClassLoader;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private ClassLoader f4015a;

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, DexClassLoader.class.getClassLoader());
        this.f4015a = classLoader;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) {
        try {
            return super.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return this.f4015a.loadClass(str);
        }
    }
}
