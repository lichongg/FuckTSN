package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.d0;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "ByteStreamsKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.io.a$a, reason: collision with other inner class name */
    public static final class C0865a extends d0 {

        /* renamed from: a, reason: collision with root package name */
        private int f43809a = -1;

        /* renamed from: b, reason: collision with root package name */
        private boolean f43810b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f43811c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BufferedInputStream f43812d;

        C0865a(BufferedInputStream bufferedInputStream) {
            this.f43812d = bufferedInputStream;
        }

        private final void g() {
            if (this.f43810b || this.f43811c) {
                return;
            }
            int read = this.f43812d.read();
            this.f43809a = read;
            this.f43810b = true;
            this.f43811c = read == -1;
        }

        public final boolean c() {
            return this.f43811c;
        }

        public final int e() {
            return this.f43809a;
        }

        public final boolean f() {
            return this.f43810b;
        }

        public final void h(boolean z5) {
            this.f43811c = z5;
        }

        public final void i(int i6) {
            this.f43809a = i6;
        }

        public final void j(boolean z5) {
            this.f43810b = z5;
        }

        @Override // kotlin.collections.d0
        public byte d() {
            g();
            if (!this.f43811c) {
                byte b6 = (byte) this.f43809a;
                this.f43810b = false;
                return b6;
            }
            throw new NoSuchElementException("Input stream is over.");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            g();
            return !this.f43811c;
        }
    }

    @InlineOnly
    private static final BufferedInputStream a(InputStream inputStream, int i6) {
        g0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i6);
    }

    @InlineOnly
    private static final BufferedOutputStream b(OutputStream outputStream, int i6) {
        g0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i6);
    }

    static /* synthetic */ BufferedInputStream c(InputStream inputStream, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 8192;
        }
        g0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i6);
    }

    static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 8192;
        }
        g0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i6);
    }

    @InlineOnly
    private static final BufferedReader e(InputStream inputStream, Charset charset) {
        g0.p(inputStream, "<this>");
        g0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    static /* synthetic */ BufferedReader f(InputStream inputStream, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(inputStream, "<this>");
        g0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    @InlineOnly
    private static final BufferedWriter g(OutputStream outputStream, Charset charset) {
        g0.p(outputStream, "<this>");
        g0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(outputStream, "<this>");
        g0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    @InlineOnly
    private static final ByteArrayInputStream i(String str, Charset charset) {
        g0.p(str, "<this>");
        g0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        g0.o(bytes, "getBytes(...)");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ ByteArrayInputStream j(String str, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(str, "<this>");
        g0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        g0.o(bytes, "getBytes(...)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long k(@NotNull InputStream inputStream, @NotNull OutputStream out, int i6) {
        g0.p(inputStream, "<this>");
        g0.p(out, "out");
        byte[] bArr = new byte[i6];
        int read = inputStream.read(bArr);
        long j6 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j6 += read;
            read = inputStream.read(bArr);
        }
        return j6;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 8192;
        }
        return k(inputStream, outputStream, i6);
    }

    @InlineOnly
    private static final ByteArrayInputStream m(byte[] bArr) {
        g0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    @InlineOnly
    private static final ByteArrayInputStream n(byte[] bArr, int i6, int i7) {
        g0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i6, i7);
    }

    @NotNull
    public static final d0 o(@NotNull BufferedInputStream bufferedInputStream) {
        g0.p(bufferedInputStream, "<this>");
        return new C0865a(bufferedInputStream);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] p(@NotNull InputStream inputStream) {
        g0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        g0.o(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    @NotNull
    public static final byte[] q(@NotNull InputStream inputStream, int i6) {
        g0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i6, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        g0.o(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 8192;
        }
        return q(inputStream, i6);
    }

    @InlineOnly
    private static final InputStreamReader s(InputStream inputStream, Charset charset) {
        g0.p(inputStream, "<this>");
        g0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(inputStream, "<this>");
        g0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @InlineOnly
    private static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        g0.p(outputStream, "<this>");
        g0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(outputStream, "<this>");
        g0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }
}
