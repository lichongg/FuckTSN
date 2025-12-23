package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r0 extends n0<short[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final short[] f44057d;

    public final void h(short s5) {
        short[] sArr = this.f44057d;
        int b6 = b();
        e(b6 + 1);
        sArr[b6] = s5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull short[] sArr) {
        g0.p(sArr, "<this>");
        return sArr.length;
    }

    @NotNull
    public final short[] j() {
        return g(this.f44057d, new short[f()]);
    }

    public r0(int i6) {
        super(i6);
        this.f44057d = new short[i6];
    }
}
