package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r extends n0<char[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final char[] f44056d;

    public final void h(char c6) {
        char[] cArr = this.f44056d;
        int b6 = b();
        e(b6 + 1);
        cArr[b6] = c6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull char[] cArr) {
        g0.p(cArr, "<this>");
        return cArr.length;
    }

    @NotNull
    public final char[] j() {
        return g(this.f44056d, new char[f()]);
    }

    public r(int i6) {
        super(i6);
        this.f44056d = new char[i6];
    }
}
