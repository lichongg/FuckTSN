package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.e1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o extends e1 {

    /* renamed from: a, reason: collision with root package name */
    private final long f44189a;

    /* renamed from: b, reason: collision with root package name */
    private final long f44190b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f44191c;

    /* renamed from: d, reason: collision with root package name */
    private long f44192d;

    public final long a() {
        return this.f44189a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44191c;
    }

    @Override // kotlin.collections.e1
    public long nextLong() {
        long j6 = this.f44192d;
        if (j6 != this.f44190b) {
            this.f44192d = this.f44189a + j6;
            return j6;
        }
        if (!this.f44191c) {
            throw new NoSuchElementException();
        }
        this.f44191c = false;
        return j6;
    }

    public o(long j6, long j7, long j8) {
        this.f44189a = j8;
        this.f44190b = j7;
        boolean z5 = false;
        if (j8 <= 0 ? j6 >= j7 : j6 <= j7) {
            z5 = true;
        }
        this.f44191c = z5;
        this.f44192d = z5 ? j6 : j7;
    }
}
