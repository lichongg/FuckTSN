package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class e extends kotlin.collections.v0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final float[] f44001a;

    /* renamed from: b, reason: collision with root package name */
    private int f44002b;

    public e(@NotNull float[] array) {
        g0.p(array, "array");
        this.f44001a = array;
    }

    @Override // kotlin.collections.v0
    public float c() {
        try {
            float[] fArr = this.f44001a;
            int i6 = this.f44002b;
            this.f44002b = i6 + 1;
            return fArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f44002b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44002b < this.f44001a.length;
    }
}
