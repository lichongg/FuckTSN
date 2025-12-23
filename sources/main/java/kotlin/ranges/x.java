package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.SinceKotlin;
import kotlin.z0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
final class x implements Iterator<z0>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    private final int f44203a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f44204b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44205c;

    /* renamed from: d, reason: collision with root package name */
    private int f44206d;

    public /* synthetic */ x(int i6, int i7, int i8, kotlin.jvm.internal.v vVar) {
        this(i6, i7, i8);
    }

    private x(int i6, int i7, int i8) {
        int compare;
        this.f44203a = i7;
        boolean z5 = false;
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
        if (i8 <= 0 ? compare >= 0 : compare <= 0) {
            z5 = true;
        }
        this.f44204b = z5;
        this.f44205c = z0.k(i8);
        this.f44206d = this.f44204b ? i6 : i7;
    }

    public int a() {
        int i6 = this.f44206d;
        if (i6 != this.f44203a) {
            this.f44206d = z0.k(this.f44205c + i6);
            return i6;
        }
        if (!this.f44204b) {
            throw new NoSuchElementException();
        }
        this.f44204b = false;
        return i6;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44204b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ z0 next() {
        return z0.b(a());
    }
}
