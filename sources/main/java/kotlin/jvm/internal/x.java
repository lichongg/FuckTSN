package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x extends n0<double[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final double[] f44081d;

    public final void h(double d6) {
        double[] dArr = this.f44081d;
        int b6 = b();
        e(b6 + 1);
        dArr[b6] = d6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull double[] dArr) {
        g0.p(dArr, "<this>");
        return dArr.length;
    }

    @NotNull
    public final double[] j() {
        return g(this.f44081d, new double[f()]);
    }

    public x(int i6) {
        super(i6);
        this.f44081d = new double[i6];
    }
}
