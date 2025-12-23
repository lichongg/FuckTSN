package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.d1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l extends d1 {

    /* renamed from: a, reason: collision with root package name */
    private final int f44179a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44180b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f44181c;

    /* renamed from: d, reason: collision with root package name */
    private int f44182d;

    public final int a() {
        return this.f44179a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44181c;
    }

    @Override // kotlin.collections.d1
    public int nextInt() {
        int i6 = this.f44182d;
        if (i6 != this.f44180b) {
            this.f44182d = this.f44179a + i6;
            return i6;
        }
        if (!this.f44181c) {
            throw new NoSuchElementException();
        }
        this.f44181c = false;
        return i6;
    }

    public l(int i6, int i7, int i8) {
        this.f44179a = i8;
        this.f44180b = i7;
        boolean z5 = false;
        if (i8 <= 0 ? i6 >= i7 : i6 <= i7) {
            z5 = true;
        }
        this.f44181c = z5;
        this.f44182d = z5 ? i6 : i7;
    }
}
