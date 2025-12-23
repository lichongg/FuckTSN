package kotlin.io;

import com.umeng.analytics.pro.o;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class l extends j {
    public static /* synthetic */ Object H(File file, Charset charset, Function1 block, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        g0.p(block, "block");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            Object invoke = block.invoke(u.i(bufferedReader));
            d0.d(1);
            b.a(bufferedReader, null);
            d0.c(1);
            return invoke;
        } finally {
        }
    }

    public static /* synthetic */ List A(File file, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        return z(file, charset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 B(ArrayList arrayList, String it) {
        g0.p(it, "it");
        arrayList.add(it);
        return n1.f44123a;
    }

    @NotNull
    public static final String C(@NotNull File file, @NotNull Charset charset) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String m6 = u.m(inputStreamReader);
            b.a(inputStreamReader, null);
            return m6;
        } finally {
        }
    }

    public static /* synthetic */ String D(File file, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        return C(file, charset);
    }

    @InlineOnly
    private static final InputStreamReader E(File file, Charset charset) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ InputStreamReader F(File file, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T G(@NotNull File file, @NotNull Charset charset, @NotNull Function1<? super kotlin.sequences.m<String>, ? extends T> block) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        g0.p(block, "block");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            T invoke = block.invoke(u.i(bufferedReader));
            d0.d(1);
            b.a(bufferedReader, null);
            d0.c(1);
            return invoke;
        } finally {
        }
    }

    public static final void I(@NotNull File file, @NotNull byte[] array) {
        g0.p(file, "<this>");
        g0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            n1 n1Var = n1.f44123a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void J(@NotNull File file, @NotNull String text, @NotNull Charset charset) {
        g0.p(file, "<this>");
        g0.p(text, "text");
        g0.p(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            L(fileOutputStream, text, charset);
            n1 n1Var = n1.f44123a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ void K(File file, String str, Charset charset, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        J(file, str, charset);
    }

    public static void L(@NotNull OutputStream outputStream, @NotNull String text, @NotNull Charset charset) {
        g0.p(outputStream, "<this>");
        g0.p(text, "text");
        g0.p(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            g0.o(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder u5 = u(charset);
        CharBuffer allocate = CharBuffer.allocate(8192);
        g0.m(u5);
        ByteBuffer o5 = o(8192, u5);
        int i6 = 0;
        int i7 = 0;
        while (i6 < text.length()) {
            int min = Math.min(8192 - i7, text.length() - i6);
            int i8 = i6 + min;
            char[] array = allocate.array();
            g0.o(array, "array(...)");
            text.getChars(i6, i8, array, i7);
            allocate.limit(min + i7);
            i7 = 1;
            if (!u5.encode(allocate, o5, i8 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            outputStream.write(o5.array(), 0, o5.position());
            if (allocate.position() != allocate.limit()) {
                allocate.put(0, allocate.get());
            } else {
                i7 = 0;
            }
            allocate.clear();
            o5.clear();
            i6 = i8;
        }
    }

    @InlineOnly
    private static final OutputStreamWriter M(File file, Charset charset) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ OutputStreamWriter N(File file, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void h(@NotNull File file, @NotNull byte[] array) {
        g0.p(file, "<this>");
        g0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            n1 n1Var = n1.f44123a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void i(@NotNull File file, @NotNull String text, @NotNull Charset charset) {
        g0.p(file, "<this>");
        g0.p(text, "text");
        g0.p(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            L(fileOutputStream, text, charset);
            n1 n1Var = n1.f44123a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ void j(File file, String str, Charset charset, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        i(file, str, charset);
    }

    @InlineOnly
    private static final BufferedReader k(File file, Charset charset, int i6) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i6);
    }

    static /* synthetic */ BufferedReader l(File file, Charset charset, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        if ((i7 & 2) != 0) {
            i6 = 8192;
        }
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i6);
    }

    @InlineOnly
    private static final BufferedWriter m(File file, Charset charset, int i6) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i6);
    }

    static /* synthetic */ BufferedWriter n(File file, Charset charset, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        if ((i7 & 2) != 0) {
            i6 = 8192;
        }
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i6);
    }

    @NotNull
    public static ByteBuffer o(int i6, @NotNull CharsetEncoder encoder) {
        g0.p(encoder, "encoder");
        ByteBuffer allocate = ByteBuffer.allocate(i6 * ((int) Math.ceil(encoder.maxBytesPerChar())));
        g0.o(allocate, "allocate(...)");
        return allocate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void p(@NotNull File file, int i6, @NotNull Function2<? super byte[], ? super Integer, n1> action) {
        g0.p(file, "<this>");
        g0.p(action, "action");
        ?? r22 = new byte[kotlin.ranges.t.u(i6, 512)];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(r22);
                if (read <= 0) {
                    n1 n1Var = n1.f44123a;
                    b.a(fileInputStream, null);
                    return;
                }
                action.invoke(r22, Integer.valueOf(read));
            } finally {
            }
        }
    }

    public static final void q(@NotNull File file, @NotNull Function2<? super byte[], ? super Integer, n1> action) {
        g0.p(file, "<this>");
        g0.p(action, "action");
        p(file, 4096, action);
    }

    public static final void r(@NotNull File file, @NotNull Charset charset, @NotNull Function1<? super String, n1> action) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        g0.p(action, "action");
        u.h(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    public static /* synthetic */ void s(File file, Charset charset, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        r(file, charset, function1);
    }

    @InlineOnly
    private static final FileInputStream t(File file) {
        g0.p(file, "<this>");
        return new FileInputStream(file);
    }

    public static CharsetEncoder u(@NotNull Charset charset) {
        g0.p(charset, "<this>");
        CharsetEncoder newEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        return newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
    }

    @InlineOnly
    private static final FileOutputStream v(File file) {
        g0.p(file, "<this>");
        return new FileOutputStream(file);
    }

    @InlineOnly
    private static final PrintWriter w(File file, Charset charset) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    static /* synthetic */ PrintWriter x(File file, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    @NotNull
    public static final byte[] y(@NotNull File file) {
        g0.p(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i6 = (int) length;
            byte[] bArr = new byte[i6];
            int i7 = i6;
            int i8 = 0;
            while (i7 > 0) {
                int read = fileInputStream.read(bArr, i8, i7);
                if (read < 0) {
                    break;
                }
                i7 -= read;
                i8 += read;
            }
            if (i7 > 0) {
                bArr = Arrays.copyOf(bArr, i8);
                g0.o(bArr, "copyOf(...)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    f fVar = new f(o.a.f41411r);
                    fVar.write(read2);
                    a.l(fileInputStream, fVar, 0, 2, null);
                    int size = fVar.size() + i6;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] a6 = fVar.a();
                    byte[] copyOf = Arrays.copyOf(bArr, size);
                    g0.o(copyOf, "copyOf(...)");
                    bArr = kotlin.collections.n.v0(a6, copyOf, i6, 0, fVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    @NotNull
    public static final List<String> z(@NotNull File file, @NotNull Charset charset) {
        g0.p(file, "<this>");
        g0.p(charset, "charset");
        final ArrayList arrayList = new ArrayList();
        r(file, charset, new Function1() { // from class: kotlin.io.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 B;
                B = l.B(arrayList, (String) obj);
                return B;
            }
        });
        return arrayList;
    }
}
