package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class r extends kotlin.reflect.jvm.internal.impl.protobuf.d {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f46518i;

    /* renamed from: c, reason: collision with root package name */
    private final int f46519c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f46520d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f46521e;

    /* renamed from: f, reason: collision with root package name */
    private final int f46522f;

    /* renamed from: g, reason: collision with root package name */
    private final int f46523g;

    /* renamed from: h, reason: collision with root package name */
    private int f46524h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements Iterator<m> {

        /* renamed from: a, reason: collision with root package name */
        private final Stack<r> f46526a;

        /* renamed from: b, reason: collision with root package name */
        private m f46527b;

        private c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f46526a = new Stack<>();
            this.f46527b = a(dVar);
        }

        private m a(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            while (dVar instanceof r) {
                r rVar = (r) dVar;
                this.f46526a.push(rVar);
                dVar = rVar.f46520d;
            }
            return (m) dVar;
        }

        private m b() {
            while (!this.f46526a.isEmpty()) {
                m a6 = a(this.f46526a.pop().f46521e);
                if (!a6.isEmpty()) {
                    return a6;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public m next() {
            m mVar = this.f46527b;
            if (mVar == null) {
                throw new NoSuchElementException();
            }
            this.f46527b = b();
            return mVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f46527b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final c f46528a;

        /* renamed from: b, reason: collision with root package name */
        private d.a f46529b;

        /* renamed from: c, reason: collision with root package name */
        int f46530c;

        private d() {
            c cVar = new c(r.this);
            this.f46528a = cVar;
            this.f46529b = cVar.next().iterator();
            this.f46530c = r.this.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte d() {
            if (!this.f46529b.hasNext()) {
                this.f46529b = this.f46528a.next().iterator();
            }
            this.f46530c--;
            return this.f46529b.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f46530c > 0;
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

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        private c f46532a;

        /* renamed from: b, reason: collision with root package name */
        private m f46533b;

        /* renamed from: c, reason: collision with root package name */
        private int f46534c;

        /* renamed from: d, reason: collision with root package name */
        private int f46535d;

        /* renamed from: e, reason: collision with root package name */
        private int f46536e;

        /* renamed from: f, reason: collision with root package name */
        private int f46537f;

        private int c(byte[] bArr, int i6, int i7) {
            int i8 = i7;
            while (true) {
                if (i8 <= 0) {
                    break;
                }
                a();
                if (this.f46533b != null) {
                    int min = Math.min(this.f46534c - this.f46535d, i8);
                    if (bArr != null) {
                        this.f46533b.m(bArr, this.f46535d, i6, min);
                        i6 += min;
                    }
                    this.f46535d += min;
                    i8 -= min;
                } else if (i8 == i7) {
                    return -1;
                }
            }
            return i7 - i8;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i6, int i7) {
            bArr.getClass();
            if (i6 < 0 || i7 < 0 || i7 > bArr.length - i6) {
                throw new IndexOutOfBoundsException();
            }
            return c(bArr, i6, i7);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            b();
            c(null, 0, this.f46537f);
        }

        public e() {
            b();
        }

        private void a() {
            if (this.f46533b != null) {
                int i6 = this.f46535d;
                int i7 = this.f46534c;
                if (i6 == i7) {
                    this.f46536e += i7;
                    this.f46535d = 0;
                    if (!this.f46532a.hasNext()) {
                        this.f46533b = null;
                        this.f46534c = 0;
                    } else {
                        m next = this.f46532a.next();
                        this.f46533b = next;
                        this.f46534c = next.size();
                    }
                }
            }
        }

        private void b() {
            c cVar = new c(r.this);
            this.f46532a = cVar;
            m next = cVar.next();
            this.f46533b = next;
            this.f46534c = next.size();
            this.f46535d = 0;
            this.f46536e = 0;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return r.this.size() - (this.f46536e + this.f46535d);
        }

        @Override // java.io.InputStream
        public void mark(int i6) {
            this.f46537f = this.f46536e + this.f46535d;
        }

        @Override // java.io.InputStream
        public long skip(long j6) {
            if (j6 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j6 > 2147483647L) {
                j6 = 2147483647L;
            }
            return c(null, 0, (int) j6);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            m mVar = this.f46533b;
            if (mVar == null) {
                return -1;
            }
            int i6 = this.f46535d;
            this.f46535d = i6 + 1;
            return mVar.C(i6) & 255;
        }
    }

    public boolean equals(Object obj) {
        int w5;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
        if (this.f46519c != dVar.size()) {
            return false;
        }
        if (this.f46519c == 0) {
            return true;
        }
        if (this.f46524h == 0 || (w5 = dVar.w()) == 0 || this.f46524h == w5) {
            return H(dVar);
        }
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Stack<kotlin.reflect.jvm.internal.impl.protobuf.d> f46525a;

        private b() {
            this.f46525a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public kotlin.reflect.jvm.internal.impl.protobuf.d b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
            c(dVar);
            c(dVar2);
            kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.f46525a.pop();
            while (!this.f46525a.isEmpty()) {
                pop = new r(this.f46525a.pop(), pop);
            }
            return pop;
        }

        private void c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            if (dVar.p()) {
                insert(dVar);
                return;
            }
            if (dVar instanceof r) {
                r rVar = (r) dVar;
                c(rVar.f46520d);
                c(rVar.f46521e);
            } else {
                String valueOf = String.valueOf(dVar.getClass());
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int d(int i6) {
            int binarySearch = Arrays.binarySearch(r.f46518i, i6);
            if (binarySearch < 0) {
                return (-(binarySearch + 1)) - 1;
            }
            return binarySearch;
        }

        private void insert(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            int d6 = d(dVar.size());
            int i6 = r.f46518i[d6 + 1];
            if (!this.f46525a.isEmpty() && this.f46525a.peek().size() < i6) {
                int i7 = r.f46518i[d6];
                kotlin.reflect.jvm.internal.impl.protobuf.d pop = this.f46525a.pop();
                while (true) {
                    if (this.f46525a.isEmpty() || this.f46525a.peek().size() >= i7) {
                        break;
                    } else {
                        pop = new r(this.f46525a.pop(), pop);
                    }
                }
                r rVar = new r(pop, dVar);
                while (!this.f46525a.isEmpty()) {
                    if (this.f46525a.peek().size() >= r.f46518i[d(rVar.size()) + 1]) {
                        break;
                    } else {
                        rVar = new r(this.f46525a.pop(), rVar);
                    }
                }
                this.f46525a.push(rVar);
                return;
            }
            this.f46525a.push(dVar);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        int i7 = 1;
        while (i6 > 0) {
            arrayList.add(Integer.valueOf(i6));
            int i8 = i7 + i6;
            i7 = i6;
            i6 = i8;
        }
        arrayList.add(Integer.MAX_VALUE);
        f46518i = new int[arrayList.size()];
        int i9 = 0;
        while (true) {
            int[] iArr = f46518i;
            if (i9 >= iArr.length) {
                return;
            }
            iArr[i9] = ((Integer) arrayList.get(i9)).intValue();
            i9++;
        }
    }

    private r(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        this.f46524h = 0;
        this.f46520d = dVar;
        this.f46521e = dVar2;
        int size = dVar.size();
        this.f46522f = size;
        this.f46519c = size + dVar2.size();
        this.f46523g = Math.max(dVar.o(), dVar2.o()) + 1;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.d F(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        r rVar = dVar instanceof r ? (r) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() == 0) {
            return dVar2;
        }
        int size = dVar.size() + dVar2.size();
        if (size < 128) {
            return G(dVar, dVar2);
        }
        if (rVar != null && rVar.f46521e.size() + dVar2.size() < 128) {
            return new r(rVar.f46520d, G(rVar.f46521e, dVar2));
        }
        if (rVar == null || rVar.f46520d.o() <= rVar.f46521e.o() || rVar.o() <= dVar2.o()) {
            return size >= f46518i[Math.max(dVar.o(), dVar2.o()) + 1] ? new r(dVar, dVar2) : new b().b(dVar, dVar2);
        }
        return new r(rVar.f46520d, new r(rVar.f46521e, dVar2));
    }

    private boolean H(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
        c cVar = new c(this);
        m next = cVar.next();
        c cVar2 = new c(dVar);
        m next2 = cVar2.next();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int size = next.size() - i6;
            int size2 = next2.size() - i7;
            int min = Math.min(size, size2);
            if (!(i6 == 0 ? next.D(next2, i7, min) : next2.D(next, i6, min))) {
                return false;
            }
            i8 += min;
            int i9 = this.f46519c;
            if (i8 >= i9) {
                if (i8 == i9) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = cVar.next();
                i6 = 0;
            } else {
                i6 += min;
            }
            if (min == size2) {
                next2 = cVar2.next();
                i7 = 0;
            } else {
                i7 += min;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void B(OutputStream outputStream, int i6, int i7) throws IOException {
        int i8 = i6 + i7;
        int i9 = this.f46522f;
        if (i8 <= i9) {
            this.f46520d.B(outputStream, i6, i7);
        } else {
            if (i6 >= i9) {
                this.f46521e.B(outputStream, i6 - i9, i7);
                return;
            }
            int i10 = i9 - i6;
            this.f46520d.B(outputStream, i6, i10);
            this.f46521e.B(outputStream, 0, i7 - i10);
        }
    }

    public int hashCode() {
        int i6 = this.f46524h;
        if (i6 == 0) {
            int i7 = this.f46519c;
            i6 = u(i7, 0, i7);
            if (i6 == 0) {
                i6 = 1;
            }
            this.f46524h = i6;
        }
        return i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void n(byte[] bArr, int i6, int i7, int i8) {
        int i9 = i6 + i8;
        int i10 = this.f46522f;
        if (i9 <= i10) {
            this.f46520d.n(bArr, i6, i7, i8);
        } else {
            if (i6 >= i10) {
                this.f46521e.n(bArr, i6 - i10, i7, i8);
                return;
            }
            int i11 = i10 - i6;
            this.f46520d.n(bArr, i6, i7, i11);
            this.f46521e.n(bArr, 0, i7 + i11, i8 - i11);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int o() {
        return this.f46523g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean p() {
        return this.f46519c >= f46518i[this.f46523g];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean q() {
        int v5 = this.f46520d.v(0, 0, this.f46522f);
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = this.f46521e;
        return dVar.v(v5, 0, dVar.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: r */
    public d.a iterator() {
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.e s() {
        return kotlin.reflect.jvm.internal.impl.protobuf.e.g(new e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f46519c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int u(int i6, int i7, int i8) {
        int i9 = i7 + i8;
        int i10 = this.f46522f;
        if (i9 <= i10) {
            return this.f46520d.u(i6, i7, i8);
        }
        if (i7 >= i10) {
            return this.f46521e.u(i6, i7 - i10, i8);
        }
        int i11 = i10 - i7;
        return this.f46521e.u(this.f46520d.u(i6, i7, i11), 0, i8 - i11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v(int i6, int i7, int i8) {
        int i9 = i7 + i8;
        int i10 = this.f46522f;
        if (i9 <= i10) {
            return this.f46520d.v(i6, i7, i8);
        }
        if (i7 >= i10) {
            return this.f46521e.v(i6, i7 - i10, i8);
        }
        int i11 = i10 - i7;
        return this.f46521e.v(this.f46520d.v(i6, i7, i11), 0, i8 - i11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w() {
        return this.f46524h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String y(String str) throws UnsupportedEncodingException {
        return new String(x(), str);
    }

    private static m G(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.m(bArr, 0, 0, size);
        dVar2.m(bArr, 0, size, size2);
        return new m(bArr);
    }
}
