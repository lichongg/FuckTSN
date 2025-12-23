package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k0 extends n0<long[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final long[] f44022d;

    public final void h(long j6) {
        long[] jArr = this.f44022d;
        int b6 = b();
        e(b6 + 1);
        jArr[b6] = j6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull long[] jArr) {
        g0.p(jArr, "<this>");
        return jArr.length;
    }

    @NotNull
    public final long[] j() {
        return g(this.f44022d, new long[f()]);
    }

    public k0(int i6) {
        super(i6);
        this.f44022d = new long[i6];
    }
}
