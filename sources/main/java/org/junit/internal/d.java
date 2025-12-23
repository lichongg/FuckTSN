package org.junit.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public Object f51383a;

    public d(double d6) {
        this.f51383a = Double.valueOf(d6);
    }

    @Override // org.junit.internal.b
    protected void c(Object obj, Object obj2) {
        if (obj instanceof Double) {
            org.junit.a.t(((Double) obj).doubleValue(), ((Double) obj2).doubleValue(), ((Double) this.f51383a).doubleValue());
        } else {
            org.junit.a.u(((Float) obj).floatValue(), ((Float) obj2).floatValue(), ((Float) this.f51383a).floatValue());
        }
    }

    public d(float f6) {
        this.f51383a = Float.valueOf(f6);
    }
}
