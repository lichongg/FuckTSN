package com.yalantis.ucrop.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f42747a;

    /* renamed from: b, reason: collision with root package name */
    private int f42748b;

    /* renamed from: c, reason: collision with root package name */
    private int f42749c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f42747a == bVar.f42747a && this.f42748b == bVar.f42748b && this.f42749c == bVar.f42749c) {
                return true;
            }
        }
        return false;
    }

    public int a() {
        return this.f42748b;
    }

    public int b() {
        return this.f42747a;
    }

    public int c() {
        return this.f42749c;
    }

    public void d(int i6) {
        this.f42748b = i6;
    }

    public void e(int i6) {
        this.f42747a = i6;
    }

    public void f(int i6) {
        this.f42749c = i6;
    }

    public int hashCode() {
        return (((this.f42747a * 31) + this.f42748b) * 31) + this.f42749c;
    }

    public b(int i6, int i7, int i8) {
        this.f42747a = i6;
        this.f42748b = i7;
        this.f42749c = i8;
    }
}
