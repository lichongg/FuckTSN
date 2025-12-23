package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l2 {

    /* renamed from: a, reason: collision with root package name */
    private final int f34516a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34517b;

    public int a() {
        return this.f34517b;
    }

    public int b() {
        return this.f34516a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l2) {
            l2 l2Var = (l2) obj;
            if (this.f34516a == l2Var.f34516a && this.f34517b == l2Var.f34517b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f34516a * 32713) + this.f34517b;
    }

    public String toString() {
        return this.f34516a + "x" + this.f34517b;
    }
}
