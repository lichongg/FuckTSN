package kotlin.io.encoding;

import java.io.IOException;
import java.io.InputStream;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalEncodingApi
/* loaded from: D:\Downloads\app\classes8.dex */
final class c extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final InputStream f43837a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Base64 f43838b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f43839c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f43840d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final byte[] f43841e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final byte[] f43842f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final byte[] f43843g;

    /* renamed from: h, reason: collision with root package name */
    private int f43844h;

    /* renamed from: i, reason: collision with root package name */
    private int f43845i;

    @Override // java.io.InputStream
    public int read() {
        int i6 = this.f43844h;
        if (i6 < this.f43845i) {
            int i7 = this.f43843g[i6] & 255;
            this.f43844h = i6 + 1;
            f();
            return i7;
        }
        int read = read(this.f43841e, 0, 1);
        if (read == -1) {
            return -1;
        }
        if (read == 1) {
            return this.f43841e[0] & 255;
        }
        throw new IllegalStateException("Unreachable");
    }

    public c(@NotNull InputStream input, @NotNull Base64 base64) {
        g0.p(input, "input");
        g0.p(base64, "base64");
        this.f43837a = input;
        this.f43838b = base64;
        this.f43841e = new byte[1];
        this.f43842f = new byte[1024];
        this.f43843g = new byte[1024];
    }

    private final void a(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = this.f43843g;
        int i8 = this.f43844h;
        n.v0(bArr2, bArr, i6, i8, i8 + i7);
        this.f43844h += i7;
        f();
    }

    private final int b(byte[] bArr, int i6, int i7, int i8) {
        int i9 = this.f43845i;
        this.f43845i = i9 + this.f43838b.p(this.f43842f, this.f43843g, i9, 0, i8);
        int min = Math.min(c(), i7 - i6);
        a(bArr, i6, min);
        h();
        return min;
    }

    private final int c() {
        return this.f43845i - this.f43844h;
    }

    private final int d(int i6) {
        this.f43842f[i6] = 61;
        if ((i6 & 3) != 2) {
            return i6 + 1;
        }
        int e6 = e();
        if (e6 >= 0) {
            this.f43842f[i6 + 1] = (byte) e6;
        }
        return i6 + 2;
    }

    private final int e() {
        int read;
        if (!this.f43838b.H()) {
            return this.f43837a.read();
        }
        do {
            read = this.f43837a.read();
            if (read == -1) {
                break;
            }
        } while (!b.e(read));
        return read;
    }

    private final void f() {
        if (this.f43844h == this.f43845i) {
            this.f43844h = 0;
            this.f43845i = 0;
        }
    }

    private final void h() {
        byte[] bArr = this.f43843g;
        int length = bArr.length;
        int i6 = this.f43845i;
        if ((this.f43842f.length / 4) * 3 > length - i6) {
            n.v0(bArr, bArr, 0, this.f43844h, i6);
            this.f43845i -= this.f43844h;
            this.f43844h = 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f43839c) {
            return;
        }
        this.f43839c = true;
        this.f43837a.close();
    }

    @Override // java.io.InputStream
    public int read(@NotNull byte[] destination, int i6, int i7) {
        int i8;
        boolean z5;
        boolean z6;
        g0.p(destination, "destination");
        if (i6 >= 0 && i7 >= 0 && (i8 = i6 + i7) <= destination.length) {
            if (!this.f43839c) {
                if (this.f43840d) {
                    return -1;
                }
                if (i7 == 0) {
                    return 0;
                }
                if (c() >= i7) {
                    a(destination, i6, i7);
                    return i7;
                }
                int c6 = (((i7 - c()) + 2) / 3) * 4;
                int i9 = i6;
                while (true) {
                    z5 = this.f43840d;
                    if (z5 || c6 <= 0) {
                        break;
                    }
                    int min = Math.min(this.f43842f.length, c6);
                    int i10 = 0;
                    while (true) {
                        z6 = this.f43840d;
                        if (z6 || i10 >= min) {
                            break;
                        }
                        int e6 = e();
                        if (e6 == -1) {
                            this.f43840d = true;
                        } else if (e6 != 61) {
                            this.f43842f[i10] = (byte) e6;
                            i10++;
                        } else {
                            i10 = d(i10);
                            this.f43840d = true;
                        }
                    }
                    if (!z6 && i10 != min) {
                        throw new IllegalStateException("Check failed.");
                    }
                    c6 -= i10;
                    i9 += b(destination, i9, i8, i10);
                }
                if (i9 == i6 && z5) {
                    return -1;
                }
                return i9 - i6;
            }
            throw new IOException("The input stream is closed.");
        }
        throw new IndexOutOfBoundsException("offset: " + i6 + ", length: " + i7 + ", buffer size: " + destination.length);
    }
}
