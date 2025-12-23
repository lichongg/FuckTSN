package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0 extends n0<int[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final int[] f44010d;

    public final void h(int i6) {
        int[] iArr = this.f44010d;
        int b6 = b();
        e(b6 + 1);
        iArr[b6] = i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull int[] iArr) {
        g0.p(iArr, "<this>");
        return iArr.length;
    }

    @NotNull
    public final int[] j() {
        return g(this.f44010d, new int[f()]);
    }

    public f0(int i6) {
        super(i6);
        this.f44010d = new int[i6];
    }
}
