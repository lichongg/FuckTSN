package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b extends kotlin.collections.d0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final byte[] f43995a;

    /* renamed from: b, reason: collision with root package name */
    private int f43996b;

    public b(@NotNull byte[] array) {
        g0.p(array, "array");
        this.f43995a = array;
    }

    @Override // kotlin.collections.d0
    public byte d() {
        try {
            byte[] bArr = this.f43995a;
            int i6 = this.f43996b;
            this.f43996b = i6 + 1;
            return bArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f43996b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f43996b < this.f43995a.length;
    }
}
