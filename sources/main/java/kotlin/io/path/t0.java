package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPathReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,327:1\n1#2:328\n1#2:330\n57#3:329\n1321#4,2:331\n*S KotlinDebug\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n*L\n208#1:330\n208#1:329\n208#1:331,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class t0 {
    static /* synthetic */ void m(Path path, Charset charset, Function1 action, int i6, Object obj) throws IOException {
        BufferedReader newBufferedReader;
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(action, "action");
        newBufferedReader = Files.newBufferedReader(path, charset);
        kotlin.jvm.internal.g0.o(newBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<String> it = kotlin.io.u.i(newBufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newBufferedReader, null);
            kotlin.jvm.internal.d0.c(1);
        } finally {
        }
    }

    static /* synthetic */ Object x(Path path, Charset charset, Function1 block, int i6, Object obj) throws IOException {
        BufferedReader newBufferedReader;
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(block, "block");
        newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            kotlin.jvm.internal.g0.m(newBufferedReader);
            Object invoke = block.invoke(kotlin.io.u.i(newBufferedReader));
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newBufferedReader, null);
            kotlin.jvm.internal.d0.c(1);
            return invoke;
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path A(Path path, kotlin.sequences.m<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Path write;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        write = Files.write(path, kotlin.sequences.p.l0(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }

    static /* synthetic */ Path B(Path path, Iterable lines, Charset charset, OpenOption[] options, int i6, Object obj) throws IOException {
        Path write;
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        write = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }

    static /* synthetic */ Path C(Path path, kotlin.sequences.m lines, Charset charset, OpenOption[] options, int i6, Object obj) throws IOException {
        Path write;
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        write = Files.write(path, kotlin.sequences.p.l0(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    public static final void D(@NotNull Path path, @NotNull CharSequence text, @NotNull Charset charset, @NotNull OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(text, "text");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        try {
            if (text instanceof String) {
                kotlin.jvm.internal.g0.m(newOutputStream);
                kotlin.io.i.L(newOutputStream, (String) text, charset);
            } else {
                CharsetEncoder u5 = kotlin.io.i.u(charset);
                CharBuffer asReadOnlyBuffer = text instanceof CharBuffer ? ((CharBuffer) text).asReadOnlyBuffer() : CharBuffer.wrap(text);
                int min = Math.min(text.length(), 8192);
                kotlin.jvm.internal.g0.m(u5);
                ByteBuffer o5 = kotlin.io.i.o(min, u5);
                while (asReadOnlyBuffer.hasRemaining()) {
                    if (u5.encode(asReadOnlyBuffer, o5, true).isError()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    newOutputStream.write(o5.array(), 0, o5.position());
                    o5.clear();
                }
            }
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            kotlin.io.b.a(newOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.b.a(newOutputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        D(path, charSequence, charset, openOptionArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final OutputStreamWriter F(Path path, Charset charset, OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new OutputStreamWriter(newOutputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter G(Path path, Charset charset, OpenOption[] options, int i6, Object obj) throws IOException {
        OutputStream newOutputStream;
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new OutputStreamWriter(newOutputStream, charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final void a(Path path, byte[] array) throws IOException {
        StandardOpenOption standardOpenOption;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(array, "array");
        standardOpenOption = StandardOpenOption.APPEND;
        Files.write(path, array, standardOpenOption);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path b(Path path, Iterable<? extends CharSequence> lines, Charset charset) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, lines, charset, standardOpenOption);
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path c(Path path, kotlin.sequences.m<? extends CharSequence> lines, Charset charset) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        Iterable l02 = kotlin.sequences.p.l0(lines);
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, l02, charset, standardOpenOption);
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }

    static /* synthetic */ Path d(Path path, Iterable lines, Charset charset, int i6, Object obj) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, lines, charset, standardOpenOption);
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }

    static /* synthetic */ Path e(Path path, kotlin.sequences.m lines, Charset charset, int i6, Object obj) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        Iterable l02 = kotlin.sequences.p.l0(lines);
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, l02, charset, standardOpenOption);
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }

    @SinceKotlin(version = "1.5")
    public static final void f(@NotNull Path path, @NotNull CharSequence text, @NotNull Charset charset) throws IOException {
        StandardOpenOption standardOpenOption;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(text, "text");
        kotlin.jvm.internal.g0.p(charset, "charset");
        standardOpenOption = StandardOpenOption.APPEND;
        D(path, text, charset, standardOpenOption);
    }

    public static /* synthetic */ void g(Path path, CharSequence charSequence, Charset charset, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        f(path, charSequence, charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final BufferedReader h(Path path, Charset charset, int i6, OpenOption... options) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedReader(new InputStreamReader(newInputStream, charset), i6);
    }

    static /* synthetic */ BufferedReader i(Path path, Charset charset, int i6, OpenOption[] options, int i7, Object obj) throws IOException {
        InputStream newInputStream;
        if ((i7 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        if ((i7 & 2) != 0) {
            i6 = 8192;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedReader(new InputStreamReader(newInputStream, charset), i6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final BufferedWriter j(Path path, Charset charset, int i6, OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedWriter(new OutputStreamWriter(newOutputStream, charset), i6);
    }

    static /* synthetic */ BufferedWriter k(Path path, Charset charset, int i6, OpenOption[] options, int i7, Object obj) throws IOException {
        OutputStream newOutputStream;
        if ((i7 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        if ((i7 & 2) != 0) {
            i6 = 8192;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedWriter(new OutputStreamWriter(newOutputStream, charset), i6);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final void l(Path path, Charset charset, Function1<? super String, kotlin.n1> action) throws IOException {
        BufferedReader newBufferedReader;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(action, "action");
        newBufferedReader = Files.newBufferedReader(path, charset);
        kotlin.jvm.internal.g0.o(newBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<String> it = kotlin.io.u.i(newBufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newBufferedReader, null);
            kotlin.jvm.internal.d0.c(1);
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final InputStream n(Path path, OpenOption... options) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(newInputStream, "newInputStream(...)");
        return newInputStream;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final OutputStream o(Path path, OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(newOutputStream, "newOutputStream(...)");
        return newOutputStream;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte[] p(Path path) throws IOException {
        byte[] readAllBytes;
        kotlin.jvm.internal.g0.p(path, "<this>");
        readAllBytes = Files.readAllBytes(path);
        kotlin.jvm.internal.g0.o(readAllBytes, "readAllBytes(...)");
        return readAllBytes;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final List<String> q(Path path, Charset charset) throws IOException {
        List<String> readAllLines;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        readAllLines = Files.readAllLines(path, charset);
        kotlin.jvm.internal.g0.o(readAllLines, "readAllLines(...)");
        return readAllLines;
    }

    static /* synthetic */ List r(Path path, Charset charset, int i6, Object obj) throws IOException {
        List readAllLines;
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        readAllLines = Files.readAllLines(path, charset);
        kotlin.jvm.internal.g0.o(readAllLines, "readAllLines(...)");
        return readAllLines;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String s(@NotNull Path path, @NotNull Charset charset) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
        InputStreamReader inputStreamReader = new InputStreamReader(newInputStream, charset);
        try {
            String m6 = kotlin.io.u.m(inputStreamReader);
            kotlin.io.b.a(inputStreamReader, null);
            return m6;
        } finally {
        }
    }

    public static /* synthetic */ String t(Path path, Charset charset, int i6, Object obj) throws IOException {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        return s(path, charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final InputStreamReader u(Path path, Charset charset, OpenOption... options) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new InputStreamReader(newInputStream, charset);
    }

    static /* synthetic */ InputStreamReader v(Path path, Charset charset, OpenOption[] options, int i6, Object obj) throws IOException {
        InputStream newInputStream;
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new InputStreamReader(newInputStream, charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T> T w(Path path, Charset charset, Function1<? super kotlin.sequences.m<String>, ? extends T> block) throws IOException {
        BufferedReader newBufferedReader;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(block, "block");
        newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            kotlin.jvm.internal.g0.m(newBufferedReader);
            T invoke = block.invoke(kotlin.io.u.i(newBufferedReader));
            kotlin.jvm.internal.d0.d(1);
            kotlin.io.b.a(newBufferedReader, null);
            kotlin.jvm.internal.d0.c(1);
            return invoke;
        } finally {
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final void y(Path path, byte[] array, OpenOption... options) throws IOException {
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(array, "array");
        kotlin.jvm.internal.g0.p(options, "options");
        Files.write(path, array, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final Path z(Path path, Iterable<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Path write;
        kotlin.jvm.internal.g0.p(path, "<this>");
        kotlin.jvm.internal.g0.p(lines, "lines");
        kotlin.jvm.internal.g0.p(charset, "charset");
        kotlin.jvm.internal.g0.p(options, "options");
        write = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.g0.o(write, "write(...)");
        return write;
    }
}
