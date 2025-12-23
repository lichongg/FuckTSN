package com.amap.api.col.p0003l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class w9 {

    /* renamed from: o, reason: collision with root package name */
    static final Charset f7597o = Charset.forName("UTF-8");

    /* renamed from: p, reason: collision with root package name */
    static final /* synthetic */ boolean f7598p = true;

    /* renamed from: a, reason: collision with root package name */
    ByteBuffer f7599a;

    /* renamed from: b, reason: collision with root package name */
    int f7600b;

    /* renamed from: c, reason: collision with root package name */
    int f7601c;

    /* renamed from: d, reason: collision with root package name */
    int[] f7602d;

    /* renamed from: e, reason: collision with root package name */
    int f7603e;

    /* renamed from: f, reason: collision with root package name */
    boolean f7604f;

    /* renamed from: g, reason: collision with root package name */
    boolean f7605g;

    /* renamed from: h, reason: collision with root package name */
    int f7606h;

    /* renamed from: i, reason: collision with root package name */
    int[] f7607i;

    /* renamed from: j, reason: collision with root package name */
    int f7608j;

    /* renamed from: k, reason: collision with root package name */
    int f7609k;

    /* renamed from: l, reason: collision with root package name */
    boolean f7610l;

    /* renamed from: m, reason: collision with root package name */
    CharsetEncoder f7611m;

    /* renamed from: n, reason: collision with root package name */
    ByteBuffer f7612n;

    private w9() {
        this.f7601c = 1;
        this.f7602d = null;
        this.f7603e = 0;
        this.f7604f = false;
        this.f7605g = false;
        this.f7607i = new int[16];
        this.f7608j = 0;
        this.f7609k = 0;
        this.f7610l = false;
        this.f7611m = f7597o.newEncoder();
        this.f7600b = 1024;
        this.f7599a = B(1024);
    }

    private void E(int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            ByteBuffer byteBuffer = this.f7599a;
            int i8 = this.f7600b - 1;
            this.f7600b = i8;
            byteBuffer.put(i8, (byte) 0);
        }
    }

    private void H(int i6) {
        x(4, 0);
        G(i6);
    }

    private void t(short s5) {
        x(2, 0);
        l(s5);
    }

    private void y(boolean z5) {
        x(1, 0);
        u(z5);
    }

    public final void d(byte b6) {
        x(1, 0);
        p(b6);
    }

    public final void e(int i6) {
        x(4, 0);
        if (!f7598p && i6 > A()) {
            throw new AssertionError();
        }
        G((A() - i6) + 4);
    }

    private int A() {
        return this.f7599a.capacity() - this.f7600b;
    }

    private void D() {
        if (!this.f7605g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    private void F() {
        if (this.f7604f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void G(int i6) {
        ByteBuffer byteBuffer = this.f7599a;
        int i7 = this.f7600b - 4;
        this.f7600b = i7;
        byteBuffer.putInt(i7, i6);
    }

    private void I(int i6) {
        this.f7602d[i6] = A();
    }

    private void k(long j6) {
        ByteBuffer byteBuffer = this.f7599a;
        int i6 = this.f7600b - 8;
        this.f7600b = i6;
        byteBuffer.putLong(i6, j6);
    }

    private void l(short s5) {
        ByteBuffer byteBuffer = this.f7599a;
        int i6 = this.f7600b - 2;
        this.f7600b = i6;
        byteBuffer.putShort(i6, s5);
    }

    private void p(byte b6) {
        ByteBuffer byteBuffer = this.f7599a;
        int i6 = this.f7600b - 1;
        this.f7600b = i6;
        byteBuffer.put(i6, b6);
    }

    private void s(long j6) {
        x(8, 0);
        k(j6);
    }

    private void u(boolean z5) {
        ByteBuffer byteBuffer = this.f7599a;
        int i6 = this.f7600b - 1;
        this.f7600b = i6;
        byteBuffer.put(i6, z5 ? (byte) 1 : (byte) 0);
    }

    private void x(int i6, int i7) {
        if (i6 > this.f7601c) {
            this.f7601c = i6;
        }
        int i8 = ((~((this.f7599a.capacity() - this.f7600b) + i7)) + 1) & (i6 - 1);
        while (this.f7600b < i8 + i6 + i7) {
            int capacity = this.f7599a.capacity();
            ByteBuffer o5 = o(this.f7599a);
            this.f7599a = o5;
            this.f7600b += o5.capacity() - capacity;
        }
        E(i8);
    }

    public final int a() {
        if (!this.f7604f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f7604f = false;
        G(this.f7609k);
        return A();
    }

    public final w9 c(ByteBuffer byteBuffer) {
        this.f7599a = byteBuffer;
        byteBuffer.clear();
        this.f7599a.order(ByteOrder.LITTLE_ENDIAN);
        this.f7601c = 1;
        this.f7600b = this.f7599a.capacity();
        this.f7603e = 0;
        this.f7604f = false;
        this.f7605g = false;
        this.f7606h = 0;
        this.f7608j = 0;
        this.f7609k = 0;
        return this;
    }

    public final void f(int i6, byte b6) {
        if (this.f7610l || b6 != 0) {
            d(b6);
            I(i6);
        }
    }

    public final void g(int i6, int i7) {
        if (this.f7610l || i7 != 0) {
            H(i7);
            I(i6);
        }
    }

    public final void i(int i6, long j6) {
        if (this.f7610l || j6 != 0) {
            s(j6);
            I(i6);
        }
    }

    public final void j(int i6, short s5) {
        if (this.f7610l || s5 != 0) {
            t(s5);
            I(i6);
        }
    }

    public final void m(boolean z5) {
        if (this.f7610l || z5) {
            y(z5);
            I(0);
        }
    }

    public final int n() {
        int i6;
        int i7;
        if (this.f7602d == null || !this.f7604f) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        H(0);
        int A = A();
        for (int i8 = this.f7603e - 1; i8 >= 0; i8--) {
            int i9 = this.f7602d[i8];
            t((short) (i9 != 0 ? A - i9 : 0));
        }
        t((short) (A - this.f7606h));
        t((short) ((this.f7603e + 2) * 2));
        int i10 = 0;
        loop1: while (true) {
            if (i10 >= this.f7608j) {
                i6 = 0;
                break;
            }
            int capacity = this.f7599a.capacity() - this.f7607i[i10];
            int i11 = this.f7600b;
            short s5 = this.f7599a.getShort(capacity);
            if (s5 == this.f7599a.getShort(i11)) {
                while (i7 < s5) {
                    i7 = this.f7599a.getShort(capacity + i7) == this.f7599a.getShort(i11 + i7) ? i7 + 2 : 2;
                }
                i6 = this.f7607i[i10];
                break loop1;
            }
            i10++;
        }
        if (i6 != 0) {
            int capacity2 = this.f7599a.capacity() - A;
            this.f7600b = capacity2;
            this.f7599a.putInt(capacity2, i6 - A);
        } else {
            int i12 = this.f7608j;
            int[] iArr = this.f7607i;
            if (i12 == iArr.length) {
                this.f7607i = Arrays.copyOf(iArr, i12 * 2);
            }
            int[] iArr2 = this.f7607i;
            int i13 = this.f7608j;
            this.f7608j = i13 + 1;
            iArr2[i13] = A();
            ByteBuffer byteBuffer = this.f7599a;
            byteBuffer.putInt(byteBuffer.capacity() - A, A() - A);
        }
        this.f7604f = false;
        return A;
    }

    public final void r(int i6, int i7) {
        if (this.f7610l || i7 != 0) {
            e(i7);
            I(i6);
        }
    }

    public final void w(int i6) {
        x(this.f7601c, 4);
        e(i6);
        this.f7599a.position(this.f7600b);
        this.f7605g = true;
    }

    public final byte[] z() {
        return C(this.f7600b, this.f7599a.capacity() - this.f7600b);
    }

    private static ByteBuffer B(int i6) {
        ByteBuffer allocate = ByteBuffer.allocate(i6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private byte[] C(int i6, int i7) {
        D();
        byte[] bArr = new byte[i7];
        this.f7599a.position(i6);
        this.f7599a.get(bArr);
        return bArr;
    }

    private static ByteBuffer o(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            int i6 = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer B = B(i6);
            B.position(i6 - capacity);
            B.put(byteBuffer);
            return B;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private int v(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        d((byte) 0);
        h(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f7599a;
        int i6 = this.f7600b - remaining;
        this.f7600b = i6;
        byteBuffer2.position(i6);
        this.f7599a.put(byteBuffer);
        return a();
    }

    public int b(CharSequence charSequence) {
        CharBuffer wrap;
        int length = (int) (charSequence.length() * this.f7611m.maxBytesPerChar());
        ByteBuffer byteBuffer = this.f7612n;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.f7612n = ByteBuffer.allocate(Math.max(128, length));
        }
        this.f7612n.clear();
        if (charSequence instanceof CharBuffer) {
            wrap = (CharBuffer) charSequence;
        } else {
            wrap = CharBuffer.wrap(charSequence);
        }
        CoderResult encode = this.f7611m.encode(wrap, this.f7612n, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e6) {
                throw new Error(e6);
            }
        }
        this.f7612n.flip();
        return v(this.f7612n);
    }

    public final void h(int i6, int i7, int i8) {
        F();
        this.f7609k = i7;
        int i9 = i6 * i7;
        x(4, i9);
        x(i8, i9);
        this.f7604f = true;
    }

    public final void q(int i6) {
        F();
        int[] iArr = this.f7602d;
        if (iArr == null || iArr.length < i6) {
            this.f7602d = new int[i6];
        }
        this.f7603e = i6;
        Arrays.fill(this.f7602d, 0, i6, 0);
        this.f7604f = true;
        this.f7606h = A();
    }

    public w9(ByteBuffer byteBuffer) {
        this.f7601c = 1;
        this.f7602d = null;
        this.f7603e = 0;
        this.f7604f = false;
        this.f7605g = false;
        this.f7607i = new int[16];
        this.f7608j = 0;
        this.f7609k = 0;
        this.f7610l = false;
        this.f7611m = f7597o.newEncoder();
        c(byteBuffer);
    }
}
