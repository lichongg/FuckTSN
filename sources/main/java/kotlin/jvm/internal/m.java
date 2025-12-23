package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m extends n0<boolean[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final boolean[] f44024d;

    public final void h(boolean z5) {
        boolean[] zArr = this.f44024d;
        int b6 = b();
        e(b6 + 1);
        zArr[b6] = z5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull boolean[] zArr) {
        g0.p(zArr, "<this>");
        return zArr.length;
    }

    @NotNull
    public final boolean[] j() {
        return g(this.f44024d, new boolean[f()]);
    }

    public m(int i6) {
        super(i6);
        this.f44024d = new boolean[i6];
    }
}
