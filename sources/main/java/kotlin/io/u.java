package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "TextStreamsKt")
@SourceDebugExtension({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,157:1\n57#1:158\n1#2:159\n1#2:162\n1321#3,2:160\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n35#1:158\n35#1:159\n35#1:160,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u {
    @InlineOnly
    private static final BufferedReader b(Reader reader, int i6) {
        g0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i6);
    }

    @InlineOnly
    private static final BufferedWriter c(Writer writer, int i6) {
        g0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i6);
    }

    static /* synthetic */ BufferedReader d(Reader reader, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 8192;
        }
        g0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i6);
    }

    static /* synthetic */ BufferedWriter e(Writer writer, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 8192;
        }
        g0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i6);
    }

    public static final long f(@NotNull Reader reader, @NotNull Writer out, int i6) {
        g0.p(reader, "<this>");
        g0.p(out, "out");
        char[] cArr = new char[i6];
        int read = reader.read(cArr);
        long j6 = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j6 += read;
            read = reader.read(cArr);
        }
        return j6;
    }

    public static /* synthetic */ long g(Reader reader, Writer writer, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 8192;
        }
        return f(reader, writer, i6);
    }

    public static final void h(@NotNull Reader reader, @NotNull Function1<? super String, n1> action) {
        g0.p(reader, "<this>");
        g0.p(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = i(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            n1 n1Var = n1.f44123a;
            b.a(bufferedReader, null);
        } finally {
        }
    }

    @NotNull
    public static final kotlin.sequences.m<String> i(@NotNull BufferedReader bufferedReader) {
        g0.p(bufferedReader, "<this>");
        return kotlin.sequences.p.k(new q(bufferedReader));
    }

    @NotNull
    public static final byte[] j(@NotNull URL url) {
        g0.p(url, "<this>");
        InputStream openStream = url.openStream();
        try {
            g0.m(openStream);
            byte[] p5 = a.p(openStream);
            b.a(openStream, null);
            return p5;
        } finally {
        }
    }

    @NotNull
    public static final List<String> k(@NotNull Reader reader) {
        g0.p(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        h(reader, new Function1() { // from class: kotlin.io.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l6;
                l6 = u.l(arrayList, (String) obj);
                return l6;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(ArrayList arrayList, String it) {
        g0.p(it, "it");
        arrayList.add(it);
        return n1.f44123a;
    }

    @NotNull
    public static final String m(@NotNull Reader reader) {
        g0.p(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        g(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        g0.o(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    @InlineOnly
    private static final String n(URL url, Charset charset) {
        g0.p(url, "<this>");
        g0.p(charset, "charset");
        return new String(j(url), charset);
    }

    static /* synthetic */ String o(URL url, Charset charset, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = kotlin.text.e.f47851b;
        }
        g0.p(url, "<this>");
        g0.p(charset, "charset");
        return new String(j(url), charset);
    }

    @InlineOnly
    private static final StringReader p(String str) {
        g0.p(str, "<this>");
        return new StringReader(str);
    }

    public static final <T> T q(@NotNull Reader reader, @NotNull Function1<? super kotlin.sequences.m<String>, ? extends T> block) {
        g0.p(reader, "<this>");
        g0.p(block, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T invoke = block.invoke(i(bufferedReader));
            d0.d(1);
            b.a(bufferedReader, null);
            d0.c(1);
            return invoke;
        } finally {
        }
    }
}
