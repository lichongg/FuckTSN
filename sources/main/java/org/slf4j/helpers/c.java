package org.slf4j.helpers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static c f51743d = new c(null);

    /* renamed from: a, reason: collision with root package name */
    private String f51744a;

    /* renamed from: b, reason: collision with root package name */
    private Throwable f51745b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f51746c;

    public c(String str) {
        this(str, null, null);
    }

    public c(String str, Object[] objArr, Throwable th) {
        this.f51744a = str;
        this.f51745b = th;
        this.f51746c = objArr;
    }

    public Object[] a() {
        return this.f51746c;
    }

    public String b() {
        return this.f51744a;
    }

    public Throwable c() {
        return this.f51745b;
    }
}
