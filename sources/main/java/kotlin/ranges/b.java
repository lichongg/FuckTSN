package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.e0;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b extends e0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f44159a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44160b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f44161c;

    /* renamed from: d, reason: collision with root package name */
    private int f44162d;

    @Override // kotlin.collections.e0
    public char c() {
        int i6 = this.f44162d;
        if (i6 != this.f44160b) {
            this.f44162d = this.f44159a + i6;
        } else {
            if (!this.f44161c) {
                throw new NoSuchElementException();
            }
            this.f44161c = false;
        }
        return (char) i6;
    }

    public final int e() {
        return this.f44159a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44161c;
    }

    public b(char c6, char c7, int i6) {
        this.f44159a = i6;
        this.f44160b = c7;
        boolean z5 = false;
        if (i6 <= 0 ? g0.t(c6, c7) >= 0 : g0.t(c6, c7) <= 0) {
            z5 = true;
        }
        this.f44161c = z5;
        this.f44162d = z5 ? c6 : c7;
    }
}
