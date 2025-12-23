package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.SinceKotlin;
import kotlin.d1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
final class a0 implements Iterator<d1>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    private final long f44155a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f44156b;

    /* renamed from: c, reason: collision with root package name */
    private final long f44157c;

    /* renamed from: d, reason: collision with root package name */
    private long f44158d;

    public /* synthetic */ a0(long j6, long j7, long j8, kotlin.jvm.internal.v vVar) {
        this(j6, j7, j8);
    }

    private a0(long j6, long j7, long j8) {
        int compare;
        this.f44155a = j7;
        boolean z5 = false;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
        if (j8 <= 0 ? compare >= 0 : compare <= 0) {
            z5 = true;
        }
        this.f44156b = z5;
        this.f44157c = d1.k(j8);
        this.f44158d = this.f44156b ? j6 : j7;
    }

    public long a() {
        long j6 = this.f44158d;
        if (j6 != this.f44155a) {
            this.f44158d = d1.k(this.f44157c + j6);
            return j6;
        }
        if (!this.f44156b) {
            throw new NoSuchElementException();
        }
        this.f44156b = false;
        return j6;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44156b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ d1 next() {
        return d1.b(a());
    }
}
