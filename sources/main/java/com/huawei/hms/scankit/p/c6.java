package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c6 implements Comparable<c6> {

    /* renamed from: a, reason: collision with root package name */
    public i2 f34088a;

    /* renamed from: b, reason: collision with root package name */
    public int f34089b;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c6 c6Var) {
        return Float.compare((-c6Var.f34088a.g()) + c6Var.f34088a.h(), (-this.f34088a.g()) + this.f34088a.h());
    }

    public c6(i2 i2Var, int i6) {
        this.f34088a = i2Var;
        this.f34089b = i6;
    }
}
