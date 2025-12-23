package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d implements Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f46469a = new m(new byte[0]);

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f46470b = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a extends Iterator<Byte> {
        byte d();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends OutputStream {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f46471f = new byte[0];

        /* renamed from: a, reason: collision with root package name */
        private final int f46472a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<d> f46473b;

        /* renamed from: c, reason: collision with root package name */
        private int f46474c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f46475d;

        /* renamed from: e, reason: collision with root package name */
        private int f46476e;

        public synchronized int d() {
            return this.f46474c + this.f46476e;
        }

        public synchronized d e() {
            c();
            return d.e(this.f46473b);
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i6) {
            try {
                if (this.f46476e == this.f46475d.length) {
                    b(1);
                }
                byte[] bArr = this.f46475d;
                int i7 = this.f46476e;
                this.f46476e = i7 + 1;
                bArr[i7] = (byte) i6;
            } catch (Throwable th) {
                throw th;
            }
        }

        private byte[] a(byte[] bArr, int i6) {
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i6));
            return bArr2;
        }

        private void b(int i6) {
            this.f46473b.add(new m(this.f46475d));
            int length = this.f46474c + this.f46475d.length;
            this.f46474c = length;
            this.f46475d = new byte[Math.max(this.f46472a, Math.max(i6, length >>> 1))];
            this.f46476e = 0;
        }

        private void c() {
            int i6 = this.f46476e;
            byte[] bArr = this.f46475d;
            if (i6 >= bArr.length) {
                this.f46473b.add(new m(this.f46475d));
                this.f46475d = f46471f;
            } else if (i6 > 0) {
                this.f46473b.add(new m(a(bArr, i6)));
            }
            this.f46474c += this.f46476e;
            this.f46476e = 0;
        }

        b(int i6) {
            if (i6 >= 0) {
                this.f46472a = i6;
                this.f46473b = new ArrayList<>();
                this.f46475d = new byte[i6];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i6, int i7) {
            try {
                byte[] bArr2 = this.f46475d;
                int length = bArr2.length;
                int i8 = this.f46476e;
                if (i7 <= length - i8) {
                    System.arraycopy(bArr, i6, bArr2, i8, i7);
                    this.f46476e += i7;
                } else {
                    int length2 = bArr2.length - i8;
                    System.arraycopy(bArr, i6, bArr2, i8, length2);
                    int i9 = i7 - length2;
                    b(i9);
                    System.arraycopy(bArr, i6 + length2, this.f46475d, 0, i9);
                    this.f46476e = i9;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static d a(Iterator<d> it, int i6) {
        if (i6 == 1) {
            return it.next();
        }
        int i7 = i6 >>> 1;
        return a(it, i7).d(a(it, i6 - i7));
    }

    public static d f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    abstract void B(OutputStream outputStream, int i6, int i7) throws IOException;

    protected abstract void n(byte[] bArr, int i6, int i7, int i8);

    protected abstract int o();

    protected abstract boolean p();

    public abstract boolean q();

    @Override // java.lang.Iterable
    /* renamed from: r */
    public abstract a iterator();

    public abstract e s();

    public abstract int size();

    protected abstract int u(int i6, int i7, int i8);

    protected abstract int v(int i6, int i7, int i8);

    protected abstract int w();

    public abstract String y(String str) throws UnsupportedEncodingException;

    public static d e(Iterable<d> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = new ArrayList();
            Iterator<d> it = iterable.iterator();
            while (it.hasNext()) {
                collection.add(it.next());
            }
        }
        return collection.isEmpty() ? f46469a : a(collection.iterator(), collection.size());
    }

    public static d g(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, i6, bArr2, 0, i7);
        return new m(bArr2);
    }

    public static d j(String str) {
        try {
            return new m(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("UTF-8 not supported?", e6);
        }
    }

    public static b t() {
        return new b(128);
    }

    void A(OutputStream outputStream, int i6, int i7) throws IOException {
        if (i6 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i6);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i7 < 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("Length < 0: ");
            sb2.append(i7);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i8 = i6 + i7;
        if (i8 <= size()) {
            if (i7 > 0) {
                B(outputStream, i6, i7);
            }
        } else {
            StringBuilder sb3 = new StringBuilder(39);
            sb3.append("Source end offset exceeded: ");
            sb3.append(i8);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public void m(byte[] bArr, int i6, int i7, int i8) {
        if (i6 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i6);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i7 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i7);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i8 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i8);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i9 = i6 + i8;
        if (i9 > size()) {
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i9);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i10 = i7 + i8;
        if (i10 <= bArr.length) {
            if (i8 > 0) {
                n(bArr, i6, i7, i8);
            }
        } else {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Target end offset < 0: ");
            sb5.append(i10);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    public String z() {
        try {
            return y("UTF-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("UTF-8 not supported?", e6);
        }
    }

    d() {
    }

    public d d(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (size + size2 < 2147483647L) {
            return r.F(this, dVar);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append(Marker.ANY_NON_NULL_MARKER);
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public byte[] x() {
        int size = size();
        if (size == 0) {
            return h.f46502a;
        }
        byte[] bArr = new byte[size];
        n(bArr, 0, 0, size);
        return bArr;
    }
}
