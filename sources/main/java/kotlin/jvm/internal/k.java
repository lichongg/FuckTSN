package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class k extends y1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final short[] f44020a;

    /* renamed from: b, reason: collision with root package name */
    private int f44021b;

    public k(@NotNull short[] array) {
        g0.p(array, "array");
        this.f44020a = array;
    }

    @Override // kotlin.collections.y1
    public short c() {
        try {
            short[] sArr = this.f44020a;
            int i6 = this.f44021b;
            this.f44021b = i6 + 1;
            return sArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f44021b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44021b < this.f44020a.length;
    }
}
