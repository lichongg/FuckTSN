package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n204#1:208\n204#1:209\n204#1:210\n1#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:208\n175#1:209\n188#1:210\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class t1<T> extends d<T> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Object[] f43689a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43690b;

    /* renamed from: c, reason: collision with root package name */
    private int f43691c;

    /* renamed from: d, reason: collision with root package name */
    private int f43692d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n+ 2 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n1#1,206:1\n204#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n*L\n121#1:207\n*E\n"})
    public static final class a extends c<T> {

        /* renamed from: c, reason: collision with root package name */
        private int f43693c;

        /* renamed from: d, reason: collision with root package name */
        private int f43694d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ t1<T> f43695e;

        a(t1<T> t1Var) {
            this.f43695e = t1Var;
            this.f43693c = t1Var.size();
            this.f43694d = ((t1) t1Var).f43691c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.c
        protected void a() {
            if (this.f43693c == 0) {
                c();
                return;
            }
            e(((t1) this.f43695e).f43689a[this.f43694d]);
            this.f43694d = (this.f43694d + 1) % ((t1) this.f43695e).f43690b;
            this.f43693c--;
        }
    }

    public t1(@NotNull Object[] buffer, int i6) {
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        this.f43689a = buffer;
        if (i6 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i6).toString());
        }
        if (i6 <= buffer.length) {
            this.f43690b = buffer.length;
            this.f43692d = i6;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i6 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    private final int n(int i6, int i7) {
        return (i6 + i7) % this.f43690b;
    }

    @Override // kotlin.collections.b, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.g0.p(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.g0.o(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = this.f43691c; i7 < size && i8 < this.f43690b; i8++) {
            objArr[i7] = this.f43689a[i8];
            i7++;
        }
        while (i7 < size) {
            objArr[i7] = this.f43689a[i6];
            i7++;
            i6++;
        }
        return (T[]) g0.o(size, objArr);
    }

    @Override // kotlin.collections.d, java.util.List
    public T get(int i6) {
        d.Companion.b(i6, size());
        return (T) this.f43689a[(this.f43691c + i6) % this.f43690b];
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    public int getSize() {
        return this.f43692d;
    }

    @Override // kotlin.collections.d, kotlin.collections.b, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final t1<T> m(int i6) {
        Object[] array;
        int i7 = this.f43690b;
        int B = kotlin.ranges.t.B(i7 + (i7 >> 1) + 1, i6);
        if (this.f43691c == 0) {
            array = Arrays.copyOf(this.f43689a, B);
            kotlin.jvm.internal.g0.o(array, "copyOf(...)");
        } else {
            array = toArray(new Object[B]);
        }
        return new t1<>(array, size());
    }

    public final void p(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i6).toString());
        }
        if (i6 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i6 + ", size = " + size()).toString());
        }
        if (i6 > 0) {
            int i7 = this.f43691c;
            int i8 = (i7 + i6) % this.f43690b;
            if (i7 > i8) {
                q.M1(this.f43689a, null, i7, this.f43690b);
                q.M1(this.f43689a, null, 0, i8);
            } else {
                q.M1(this.f43689a, null, i7, i8);
            }
            this.f43691c = i8;
            this.f43692d = size() - i6;
        }
    }

    public final void j(T t5) {
        if (!o()) {
            this.f43689a[(this.f43691c + size()) % this.f43690b] = t5;
            this.f43692d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    public final boolean o() {
        if (size() == this.f43690b) {
            return true;
        }
        return false;
    }

    public t1(int i6) {
        this(new Object[i6], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.b, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
