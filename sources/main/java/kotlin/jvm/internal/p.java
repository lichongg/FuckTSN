package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p extends n0<byte[]> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final byte[] f44038d;

    public final void h(byte b6) {
        byte[] bArr = this.f44038d;
        int b7 = b();
        e(b7 + 1);
        bArr[b7] = b6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.n0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@NotNull byte[] bArr) {
        g0.p(bArr, "<this>");
        return bArr.length;
    }

    @NotNull
    public final byte[] j() {
        return g(this.f44038d, new byte[f()]);
    }

    public p(int i6) {
        super(i6);
        this.f44038d = new byte[i6];
    }
}
