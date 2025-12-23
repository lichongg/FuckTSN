package kotlin.io.encoding;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalEncodingApi
/* loaded from: D:\Downloads\app\classes8.dex */
final class d extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final OutputStream f43846a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Base64 f43847b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f43848c;

    /* renamed from: d, reason: collision with root package name */
    private int f43849d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final byte[] f43850e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final byte[] f43851f;

    /* renamed from: g, reason: collision with root package name */
    private int f43852g;

    @Override // java.io.OutputStream
    public void write(int i6) {
        a();
        byte[] bArr = this.f43851f;
        int i7 = this.f43852g;
        int i8 = i7 + 1;
        this.f43852g = i8;
        bArr[i7] = (byte) i6;
        if (i8 == 3) {
            c();
        }
    }

    public d(@NotNull OutputStream output, @NotNull Base64 base64) {
        g0.p(output, "output");
        g0.p(base64, "base64");
        this.f43846a = output;
        this.f43847b = base64;
        this.f43849d = base64.H() ? base64.E() : -1;
        this.f43850e = new byte[1024];
        this.f43851f = new byte[3];
    }

    private final void a() {
        if (this.f43848c) {
            throw new IOException("The output stream is closed.");
        }
    }

    private final int b(byte[] bArr, int i6, int i7) {
        int min = Math.min(3 - this.f43852g, i7 - i6);
        n.v0(bArr, this.f43851f, this.f43852g, i6, i6 + min);
        int i8 = this.f43852g + min;
        this.f43852g = i8;
        if (i8 == 3) {
            c();
        }
        return min;
    }

    private final void c() {
        if (d(this.f43851f, 0, this.f43852g) != 4) {
            throw new IllegalStateException("Check failed.");
        }
        this.f43852g = 0;
    }

    private final int d(byte[] bArr, int i6, int i7) {
        int v5 = this.f43847b.v(bArr, this.f43850e, 0, i6, i7);
        if (this.f43849d == 0) {
            this.f43846a.write(Base64.f43816f.N());
            this.f43849d = this.f43847b.E();
            if (v5 > this.f43847b.E()) {
                throw new IllegalStateException("Check failed.");
            }
        }
        this.f43846a.write(this.f43850e, 0, v5);
        this.f43849d -= v5;
        return v5;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f43848c) {
            return;
        }
        this.f43848c = true;
        if (this.f43852g != 0) {
            c();
        }
        this.f43846a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f43846a.flush();
    }

    @Override // java.io.OutputStream
    public void write(@NotNull byte[] source, int i6, int i7) {
        int i8;
        g0.p(source, "source");
        a();
        if (i6 < 0 || i7 < 0 || (i8 = i6 + i7) > source.length) {
            throw new IndexOutOfBoundsException("offset: " + i6 + ", length: " + i7 + ", source size: " + source.length);
        }
        if (i7 == 0) {
            return;
        }
        int i9 = this.f43852g;
        if (i9 < 3) {
            if (i9 != 0) {
                i6 += b(source, i6, i8);
                if (this.f43852g != 0) {
                    return;
                }
            }
            while (i6 + 3 <= i8) {
                int min = Math.min((this.f43847b.H() ? this.f43849d : this.f43850e.length) / 4, (i8 - i6) / 3);
                int i10 = (min * 3) + i6;
                if (d(source, i6, i10) != min * 4) {
                    throw new IllegalStateException("Check failed.");
                }
                i6 = i10;
            }
            n.v0(source, this.f43851f, 0, i6, i8);
            this.f43852g = i8 - i6;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }
}
