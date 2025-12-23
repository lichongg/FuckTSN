package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.d1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f extends d1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final int[] f44008a;

    /* renamed from: b, reason: collision with root package name */
    private int f44009b;

    public f(@NotNull int[] array) {
        g0.p(array, "array");
        this.f44008a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44009b < this.f44008a.length;
    }

    @Override // kotlin.collections.d1
    public int nextInt() {
        try {
            int[] iArr = this.f44008a;
            int i6 = this.f44009b;
            this.f44009b = i6 + 1;
            return iArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f44009b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }
}
