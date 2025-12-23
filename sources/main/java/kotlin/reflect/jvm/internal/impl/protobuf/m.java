package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class m extends d {

    /* renamed from: c, reason: collision with root package name */
    protected final byte[] f46513c;

    /* renamed from: d, reason: collision with root package name */
    private int f46514d = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private int f46515a;

        /* renamed from: b, reason: collision with root package name */
        private final int f46516b;

        private b() {
            this.f46515a = 0;
            this.f46516b = m.this.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte d() {
            try {
                byte[] bArr = m.this.f46513c;
                int i6 = this.f46515a;
                this.f46515a = i6 + 1;
                return bArr[i6];
            } catch (ArrayIndexOutOfBoundsException e6) {
                throw new NoSuchElementException(e6.getMessage());
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f46515a < this.f46516b;
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

    static int F(int i6, byte[] bArr, int i7, int i8) {
        for (int i9 = i7; i9 < i7 + i8; i9++) {
            i6 = (i6 * 31) + bArr[i9];
        }
        return i6;
    }

    protected int E() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof m) {
            return D((m) obj, 0, size());
        }
        if (obj instanceof r) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb = new StringBuilder(valueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int o() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean p() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void B(OutputStream outputStream, int i6, int i7) throws IOException {
        outputStream.write(this.f46513c, E() + i6, i7);
    }

    public byte C(int i6) {
        return this.f46513c[i6];
    }

    public int hashCode() {
        int i6 = this.f46514d;
        if (i6 == 0) {
            int size = size();
            i6 = u(size, 0, size);
            if (i6 == 0) {
                i6 = 1;
            }
            this.f46514d = i6;
        }
        return i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void n(byte[] bArr, int i6, int i7, int i8) {
        System.arraycopy(this.f46513c, i6, bArr, i7, i8);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f46513c.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int u(int i6, int i7, int i8) {
        return F(i6, this.f46513c, E() + i7, i8);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w() {
        return this.f46514d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String y(String str) throws UnsupportedEncodingException {
        return new String(this.f46513c, E(), size(), str);
    }

    m(byte[] bArr) {
        this.f46513c = bArr;
    }

    boolean D(m mVar, int i6, int i7) {
        if (i7 <= mVar.size()) {
            if (i6 + i7 <= mVar.size()) {
                byte[] bArr = this.f46513c;
                byte[] bArr2 = mVar.f46513c;
                int E = E() + i7;
                int E2 = E();
                int E3 = mVar.E() + i6;
                while (E2 < E) {
                    if (bArr[E2] != bArr2[E3]) {
                        return false;
                    }
                    E2++;
                    E3++;
                }
                return true;
            }
            int size = mVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i6);
            sb.append(", ");
            sb.append(i7);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i7);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean q() {
        int E = E();
        return u.f(this.f46513c, E, size() + E);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public e s() {
        return e.h(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v(int i6, int i7, int i8) {
        int E = E() + i7;
        return u.g(i6, this.f46513c, E, i8 + E);
    }
}
