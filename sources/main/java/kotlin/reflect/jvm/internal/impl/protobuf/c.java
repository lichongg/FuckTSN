package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class c extends m {

    /* renamed from: e, reason: collision with root package name */
    private final int f46464e;

    /* renamed from: f, reason: collision with root package name */
    private final int f46465f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private int f46466a;

        /* renamed from: b, reason: collision with root package name */
        private final int f46467b;

        private b() {
            int E = c.this.E();
            this.f46466a = E;
            this.f46467b = E + c.this.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte d() {
            int i6 = this.f46466a;
            if (i6 >= this.f46467b) {
                throw new NoSuchElementException();
            }
            byte[] bArr = c.this.f46513c;
            this.f46466a = i6 + 1;
            return bArr[i6];
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f46466a < this.f46467b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(d());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m
    public byte C(int i6) {
        if (i6 < 0) {
            StringBuilder sb = new StringBuilder(28);
            sb.append("Index too small: ");
            sb.append(i6);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        if (i6 < size()) {
            return this.f46513c[this.f46464e + i6];
        }
        int size = size();
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("Index too large: ");
        sb2.append(i6);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m
    protected int E() {
        return this.f46464e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m, kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void n(byte[] bArr, int i6, int i7, int i8) {
        System.arraycopy(this.f46513c, E() + i6, bArr, i7, i8);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m, kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: r */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.m, kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f46465f;
    }

    c(byte[] bArr, int i6, int i7) {
        super(bArr);
        if (i6 >= 0) {
            if (i7 >= 0) {
                if (i6 + i7 <= bArr.length) {
                    this.f46464e = i6;
                    this.f46465f = i7;
                    return;
                }
                StringBuilder sb = new StringBuilder(48);
                sb.append("Offset+Length too large: ");
                sb.append(i6);
                sb.append(Marker.ANY_NON_NULL_MARKER);
                sb.append(i7);
                throw new IllegalArgumentException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Length too small: ");
            sb2.append(i6);
            throw new IllegalArgumentException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(29);
        sb3.append("Offset too small: ");
        sb3.append(i6);
        throw new IllegalArgumentException(sb3.toString());
    }
}
