package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 extends n0<float[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final float[] f43994d;

    public final void h(float f6) {
        float[] fArr = this.f43994d;
        int b6 = b();
        e(b6 + 1);
        fArr[b6] = f6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull float[] fArr) {
        g0.p(fArr, "<this>");
        return fArr.length;
    }

    @NotNull
    public final float[] j() {
        return g(this.f43994d, new float[f()]);
    }

    public a0(int i6) {
        super(i6);
        this.f43994d = new float[i6];
    }
}
