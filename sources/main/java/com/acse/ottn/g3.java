package com.acse.ottn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class g3<T, V> {

    /* renamed from: a, reason: collision with root package name */
    public final String f4545a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<V> f4546b;

    public static <T, V> g3<T, V> a(Class<T> cls, Class<V> cls2, String str) {
        return new l3(cls, cls2, str);
    }

    public abstract V a(T t5);

    public boolean c() {
        return false;
    }

    public void a(T t5, V v5) {
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }

    public Class<V> b() {
        return this.f4546b;
    }

    public g3(Class<V> cls, String str) {
        this.f4545a = str;
        this.f4546b = cls;
    }

    public String a() {
        return this.f4545a;
    }
}
