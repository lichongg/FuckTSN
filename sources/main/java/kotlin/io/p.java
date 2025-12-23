package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n1#2:303\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f43879a = new p();

    /* renamed from: b, reason: collision with root package name */
    private static final int f43880b = 32;

    /* renamed from: c, reason: collision with root package name */
    private static CharsetDecoder f43881c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f43882d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final byte[] f43883e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final char[] f43884f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final ByteBuffer f43885g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final CharBuffer f43886h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final StringBuilder f43887i;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        if (r10 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
    
        r0 = kotlin.io.p.f43884f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
    
        if (r0[r10 - 1] != '\n') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        r1 = r10 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r1 <= 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        if (r0[r10 - 2] != '\r') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
    
        r10 = r10 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0092, code lost:
    
        r0 = kotlin.io.p.f43887i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        if (r0.length() != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a2, code lost:
    
        return new java.lang.String(kotlin.io.p.f43884f, 0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
    
        r0.append(kotlin.io.p.f43884f, 0, r10);
        r10 = r0.toString();
        kotlin.jvm.internal.g0.o(r10, "toString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        if (r0.length() <= 32) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:
    
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
    
        r0.setLength(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (kotlin.jvm.internal.g0.g(r0.charset(), r11) == false) goto L11;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String d(@org.jetbrains.annotations.NotNull java.io.InputStream r10, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.g0.p(r10, r0)     // Catch: java.lang.Throwable -> L19
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.g0.p(r11, r0)     // Catch: java.lang.Throwable -> L19
            java.nio.charset.CharsetDecoder r0 = kotlin.io.p.f43881c     // Catch: java.lang.Throwable -> L19
            r1 = 0
            if (r0 == 0) goto L26
            if (r0 != 0) goto L1c
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.g0.S(r0)     // Catch: java.lang.Throwable -> L19
            r0 = r1
            goto L1c
        L19:
            r10 = move-exception
            goto Lc5
        L1c:
            java.nio.charset.Charset r0 = r0.charset()     // Catch: java.lang.Throwable -> L19
            boolean r0 = kotlin.jvm.internal.g0.g(r0, r11)     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L29
        L26:
            r9.g(r11)     // Catch: java.lang.Throwable -> L19
        L29:
            r11 = 0
            r0 = 0
            r2 = 0
        L2c:
            int r3 = r10.read()     // Catch: java.lang.Throwable -> L19
            r4 = 32
            r5 = -1
            r6 = 10
            if (r3 != r5) goto L4a
            java.lang.StringBuilder r10 = kotlin.io.p.f43887i     // Catch: java.lang.Throwable -> L19
            int r10 = r10.length()     // Catch: java.lang.Throwable -> L19
            if (r10 != 0) goto L45
            if (r0 != 0) goto L45
            if (r2 != 0) goto L45
            monitor-exit(r9)
            return r1
        L45:
            int r10 = r9.c(r0, r2)     // Catch: java.lang.Throwable -> L19
            goto L78
        L4a:
            byte[] r5 = kotlin.io.p.f43883e     // Catch: java.lang.Throwable -> L19
            int r7 = r0 + 1
            byte r8 = (byte) r3     // Catch: java.lang.Throwable -> L19
            r5[r0] = r8     // Catch: java.lang.Throwable -> L19
            if (r3 == r6) goto L5c
            if (r7 == r4) goto L5c
            boolean r0 = kotlin.io.p.f43882d     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L5a
            goto L5c
        L5a:
            r0 = r7
            goto L2c
        L5c:
            java.nio.ByteBuffer r0 = kotlin.io.p.f43885g     // Catch: java.lang.Throwable -> L19
            r0.limit(r7)     // Catch: java.lang.Throwable -> L19
            java.nio.CharBuffer r3 = kotlin.io.p.f43886h     // Catch: java.lang.Throwable -> L19
            r3.position(r2)     // Catch: java.lang.Throwable -> L19
            int r2 = r9.b(r11)     // Catch: java.lang.Throwable -> L19
            if (r2 <= 0) goto Lbf
            char[] r3 = kotlin.io.p.f43884f     // Catch: java.lang.Throwable -> L19
            int r5 = r2 + (-1)
            char r3 = r3[r5]     // Catch: java.lang.Throwable -> L19
            if (r3 != r6) goto Lbf
            r0.position(r11)     // Catch: java.lang.Throwable -> L19
            r10 = r2
        L78:
            if (r10 <= 0) goto L92
            char[] r0 = kotlin.io.p.f43884f     // Catch: java.lang.Throwable -> L19
            int r1 = r10 + (-1)
            char r1 = r0[r1]     // Catch: java.lang.Throwable -> L19
            if (r1 != r6) goto L92
            int r1 = r10 + (-1)
            if (r1 <= 0) goto L91
            int r2 = r10 + (-2)
            char r0 = r0[r2]     // Catch: java.lang.Throwable -> L19
            r2 = 13
            if (r0 != r2) goto L91
            int r10 = r10 + (-2)
            goto L92
        L91:
            r10 = r1
        L92:
            java.lang.StringBuilder r0 = kotlin.io.p.f43887i     // Catch: java.lang.Throwable -> L19
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto La3
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L19
            char[] r1 = kotlin.io.p.f43884f     // Catch: java.lang.Throwable -> L19
            r0.<init>(r1, r11, r10)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r9)
            return r0
        La3:
            char[] r1 = kotlin.io.p.f43884f     // Catch: java.lang.Throwable -> L19
            r0.append(r1, r11, r10)     // Catch: java.lang.Throwable -> L19
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L19
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.g0.o(r10, r1)     // Catch: java.lang.Throwable -> L19
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L19
            if (r1 <= r4) goto Lba
            r9.f()     // Catch: java.lang.Throwable -> L19
        Lba:
            r0.setLength(r11)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r9)
            return r10
        Lbf:
            int r0 = r9.a()     // Catch: java.lang.Throwable -> L19
            goto L2c
        Lc5:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L19
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.p.d(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    static {
        byte[] bArr = new byte[32];
        f43883e = bArr;
        char[] cArr = new char[32];
        f43884f = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        g0.o(wrap, "wrap(...)");
        f43885g = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        g0.o(wrap2, "wrap(...)");
        f43886h = wrap2;
        f43887i = new StringBuilder();
    }

    private final int a() {
        ByteBuffer byteBuffer = f43885g;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    private final int b(boolean z5) {
        while (true) {
            CharsetDecoder charsetDecoder = f43881c;
            if (charsetDecoder == null) {
                g0.S("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f43885g;
            CharBuffer charBuffer = f43886h;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z5);
            g0.o(decode, "decode(...)");
            if (decode.isError()) {
                e();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            StringBuilder sb = f43887i;
            char[] cArr = f43884f;
            int i6 = position - 1;
            sb.append(cArr, 0, i6);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i6]);
        }
    }

    private final int c(int i6, int i7) {
        ByteBuffer byteBuffer = f43885g;
        byteBuffer.limit(i6);
        f43886h.position(i7);
        int b6 = b(true);
        CharsetDecoder charsetDecoder = f43881c;
        if (charsetDecoder == null) {
            g0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return b6;
    }

    private final void e() {
        CharsetDecoder charsetDecoder = f43881c;
        if (charsetDecoder == null) {
            g0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        f43885g.position(0);
        f43887i.setLength(0);
    }

    private final void f() {
        StringBuilder sb = f43887i;
        sb.setLength(32);
        sb.trimToSize();
    }

    private p() {
    }

    private final void g(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        g0.o(newDecoder, "newDecoder(...)");
        f43881c = newDecoder;
        ByteBuffer byteBuffer = f43885g;
        byteBuffer.clear();
        CharBuffer charBuffer = f43886h;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f43881c;
        if (charsetDecoder == null) {
            g0.S("decoder");
            charsetDecoder = null;
        }
        boolean z5 = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z5 = true;
        }
        f43882d = z5;
        e();
    }
}
