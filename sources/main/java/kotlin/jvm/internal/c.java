package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class c extends kotlin.collections.e0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final char[] f43997a;

    /* renamed from: b, reason: collision with root package name */
    private int f43998b;

    public c(@NotNull char[] array) {
        g0.p(array, "array");
        this.f43997a = array;
    }

    @Override // kotlin.collections.e0
    public char c() {
        try {
            char[] cArr = this.f43997a;
            int i6 = this.f43998b;
            this.f43998b = i6 + 1;
            return cArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f43998b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f43998b < this.f43997a.length;
    }
}
