package okhttp3.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.l;
import kotlin.n1;
import kotlin.text.u;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Options;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n-UtilCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -UtilCommon.kt\nokhttp3/internal/_UtilCommonKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,400:1\n37#2,2:401\n1772#3,6:403\n72#4:409\n58#4,22:410\n*S KotlinDebug\n*F\n+ 1 -UtilCommon.kt\nokhttp3/internal/_UtilCommonKt\n*L\n68#1:401,2\n97#1:403,6\n303#1:409\n303#1:410,22\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class _UtilCommonKt {

    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @NotNull
    private static final Options UNICODE_BOMS;

    @NotNull
    public static final String USER_AGENT = "okhttp/5.3.0";

    static {
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe0000"), companion2.decodeHex("fffe"), companion2.decodeHex("0000feff"));
    }

    public static final int and(byte b6, int i6) {
        return b6 & i6;
    }

    public static final int delimiterOffset(@NotNull String str, @NotNull String delimiters, int i6, int i7) {
        g0.p(str, "<this>");
        g0.p(delimiters, "delimiters");
        while (i6 < i7) {
            if (u.k3(delimiters, str.charAt(i6), false, 2, null)) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = str.length();
        }
        return delimiterOffset(str, str2, i6, i7);
    }

    public static final <E> void addIfAbsent(@NotNull List<E> list, E e6) {
        g0.p(list, "<this>");
        if (list.contains(e6)) {
            return;
        }
        list.add(e6);
    }

    public static final int and(short s5, int i6) {
        return s5 & i6;
    }

    public static final void checkOffsetAndCount(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException("length=" + j6 + ", offset=" + j7 + ", count=" + j7);
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeable) {
        g0.p(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e6) {
            throw e6;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String[] concat(@NotNull String[] strArr, @NotNull String value) {
        g0.p(strArr, "<this>");
        g0.p(value, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        g0.o(copyOf, "copyOf(...)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[n.Oe(strArr2)] = value;
        return strArr2;
    }

    public static final void deleteContents(@NotNull FileSystem fileSystem, @NotNull Path directory) {
        g0.p(fileSystem, "<this>");
        g0.p(directory, "directory");
        try {
            IOException iOException = null;
            for (Path path : fileSystem.list(directory)) {
                try {
                    if (fileSystem.metadata(path).isDirectory()) {
                        deleteContents(fileSystem, path);
                    }
                    fileSystem.delete(path);
                } catch (IOException e6) {
                    if (iOException == null) {
                        iOException = e6;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void deleteIfExists(@NotNull FileSystem fileSystem, @NotNull Path path) {
        g0.p(fileSystem, "<this>");
        g0.p(path, "path");
        try {
            fileSystem.delete(path);
        } catch (FileNotFoundException unused) {
        }
    }

    public static final int delimiterOffset(@NotNull String str, char c6, int i6, int i7) {
        g0.p(str, "<this>");
        while (i6 < i7) {
            if (str.charAt(i6) == c6) {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> predicate) {
        g0.p(iterable, "<this>");
        g0.p(predicate, "predicate");
        List<T> J = f0.J();
        for (T t5 : iterable) {
            if (predicate.invoke(t5).booleanValue()) {
                if (J.isEmpty()) {
                    J = new ArrayList<>();
                }
                g0.n(J, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal._UtilCommonKt.filterList>");
                u0.g(J).add(t5);
            }
        }
        return J;
    }

    @NotNull
    public static final Options getUNICODE_BOMS() {
        return UNICODE_BOMS;
    }

    public static final boolean hasIntersection(@NotNull String[] strArr, @Nullable String[] strArr2, @NotNull Comparator<? super String> comparator) {
        g0.p(strArr, "<this>");
        g0.p(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final void ignoreIoExceptions(@NotNull Function0<n1> block) {
        g0.p(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    public static final int indexOf(@NotNull String[] strArr, @NotNull String value, @NotNull Comparator<String> comparator) {
        g0.p(strArr, "<this>");
        g0.p(value, "value");
        g0.p(comparator, "comparator");
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (comparator.compare(strArr[i6], value) == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String str) {
        g0.p(str, "<this>");
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (g0.t(charAt, 31) <= 0 || g0.t(charAt, 127) >= 0) {
                return i6;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String str, int i6, int i7) {
        g0.p(str, "<this>");
        while (i6 < i7) {
            char charAt = str.charAt(i6);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i6;
            }
            i6++;
        }
        return i7;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i6, i7);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String str, int i6, int i7) {
        g0.p(str, "<this>");
        int i8 = i7 - 1;
        if (i6 <= i8) {
            while (true) {
                char charAt = str.charAt(i8);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i8 + 1;
                }
                if (i8 == i6) {
                    break;
                }
                i8--;
            }
        }
        return i6;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i6, i7);
    }

    public static final int indexOfNonWhitespace(@NotNull String str, int i6) {
        g0.p(str, "<this>");
        int length = str.length();
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt != ' ' && charAt != '\t') {
                return i6;
            }
            i6++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        return indexOfNonWhitespace(str, i6);
    }

    @NotNull
    public static final <T> List<T> interleave(@NotNull Iterable<? extends T> a6, @NotNull Iterable<? extends T> b6) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        Iterator<? extends T> it = a6.iterator();
        Iterator<? extends T> it2 = b6.iterator();
        List j6 = f0.j();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return f0.b(j6);
            }
            if (it.hasNext()) {
                j6.add(it.next());
            }
            if (it2.hasNext()) {
                j6.add(it2.next());
            }
        }
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] strArr, @NotNull String[] other, @NotNull Comparator<? super String> comparator) {
        g0.p(strArr, "<this>");
        g0.p(other, "other");
        g0.p(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i6]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i6++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isCivilized(@org.jetbrains.annotations.NotNull okio.FileSystem r2, @org.jetbrains.annotations.NotNull okio.Path r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.g0.p(r3, r0)
            okio.Sink r0 = r2.sink(r3)
            r2.delete(r3)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L1a
            r2 = 1
            if (r0 == 0) goto L17
            r0.close()     // Catch: java.lang.Throwable -> L17
        L17:
            return r2
        L18:
            r1 = move-exception
            goto L26
        L1a:
            kotlin.n1 r1 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L24
            r0.close()     // Catch: java.lang.Throwable -> L22
            goto L24
        L22:
            r0 = move-exception
            goto L31
        L24:
            r0 = 0
            goto L31
        L26:
            if (r0 == 0) goto L30
            r0.close()     // Catch: java.lang.Throwable -> L2c
            goto L30
        L2c:
            r0 = move-exception
            kotlin.l.a(r1, r0)
        L30:
            r0 = r1
        L31:
            if (r0 != 0) goto L38
            r2.delete(r3)
            r2 = 0
            return r2
        L38:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._UtilCommonKt.isCivilized(okio.FileSystem, okio.Path):boolean");
    }

    public static final boolean isSensitiveHeader(@NotNull String name) {
        g0.p(name, "name");
        return u.a2(name, "Authorization", true) || u.a2(name, "Cookie", true) || u.a2(name, "Proxy-Authorization", true) || u.a2(name, "Set-Cookie", true);
    }

    public static final int parseHexDigit(char c6) {
        if ('0' <= c6 && c6 < ':') {
            return c6 - '0';
        }
        if ('a' <= c6 && c6 < 'g') {
            return c6 - 'W';
        }
        if ('A' > c6 || c6 >= 'G') {
            return -1;
        }
        return c6 - '7';
    }

    public static final int readMedium(@NotNull BufferedSource bufferedSource) throws IOException {
        g0.p(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    public static final int skipAll(@NotNull Buffer buffer, byte b6) {
        g0.p(buffer, "<this>");
        int i6 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b6) {
            i6++;
            buffer.readByte();
        }
        return i6;
    }

    public static final long toLongOrDefault(@NotNull String str, long j6) {
        g0.p(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j6;
        }
    }

    public static final int toNonNegativeInt(@Nullable String str, int i6) {
        if (str == null) {
            return i6;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i6;
        }
    }

    @NotNull
    public static final String trimSubstring(@NotNull String str, int i6, int i7) {
        g0.p(str, "<this>");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i6, i7);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i7));
        g0.o(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        return trimSubstring(str, i6, i7);
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception exc, @NotNull List<? extends Exception> suppressed) {
        g0.p(exc, "<this>");
        g0.p(suppressed, "suppressed");
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            l.a(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(@NotNull BufferedSink bufferedSink, int i6) throws IOException {
        g0.p(bufferedSink, "<this>");
        bufferedSink.writeByte((i6 >>> 16) & 255);
        bufferedSink.writeByte((i6 >>> 8) & 255);
        bufferedSink.writeByte(i6 & 255);
    }

    public static final long and(int i6, long j6) {
        return j6 & i6;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = str.length();
        }
        return delimiterOffset(str, c6, i6, i7);
    }
}
