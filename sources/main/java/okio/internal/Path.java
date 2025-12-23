package okio.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-Path")
@SourceDebugExtension({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/internal/-Path\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,405:1\n53#1,22:406\n203#1:432\n203#1:433\n1563#2:428\n1634#2,3:429\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/internal/-Path\n*L\n47#1:406,22\n193#1:432\n198#1:433\n47#1:428\n47#1:429,3\n*E\n"})
/* renamed from: okio.internal.-Path, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Path {

    @NotNull
    private static final ByteString ANY_SLASH;

    @NotNull
    private static final ByteString BACKSLASH;

    @NotNull
    private static final ByteString DOT;

    @NotNull
    private static final ByteString DOT_DOT;

    @NotNull
    private static final ByteString SLASH;

    @NotNull
    public static final okio.Path commonResolve(@NotNull okio.Path path, @NotNull String child, boolean z5) {
        g0.p(path, "<this>");
        g0.p(child, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(child), false), z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString toSlash(String str) {
        if (g0.g(str, "/")) {
            return SLASH;
        }
        if (g0.g(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        DOT = companion.encodeUtf8(".");
        DOT_DOT = companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(@NotNull okio.Path path, @NotNull okio.Path other) {
        g0.p(path, "<this>");
        g0.p(other, "other");
        return path.getBytes$okio().compareTo(other.getBytes$okio());
    }

    public static final boolean commonEquals(@NotNull okio.Path path, @Nullable Object obj) {
        g0.p(path, "<this>");
        return (obj instanceof okio.Path) && g0.g(((okio.Path) obj).getBytes$okio(), path.getBytes$okio());
    }

    public static final int commonHashCode(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        return rootLength(path) != -1;
    }

    public static final boolean commonIsRelative(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        return rootLength(path) == -1;
    }

    public static final boolean commonIsRoot(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        return rootLength(path) == path.getBytes$okio().size();
    }

    @NotNull
    public static final String commonName(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        return path.nameBytes().utf8();
    }

    @NotNull
    public static final ByteString commonNameBytes(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        int indexOfLastSlash = getIndexOfLastSlash(path);
        return indexOfLastSlash != -1 ? ByteString.substring$default(path.getBytes$okio(), indexOfLastSlash + 1, 0, 2, null) : (path.volumeLetter() == null || path.getBytes$okio().size() != 2) ? path.getBytes$okio() : ByteString.EMPTY;
    }

    @NotNull
    public static final okio.Path commonNormalized(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        return okio.Path.Companion.get(path.toString(), true);
    }

    @Nullable
    public static final okio.Path commonParent(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        if (g0.g(path.getBytes$okio(), DOT) || g0.g(path.getBytes$okio(), SLASH) || g0.g(path.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int indexOfLastSlash = getIndexOfLastSlash(path);
        if (indexOfLastSlash == 2 && path.volumeLetter() != null) {
            if (path.getBytes$okio().size() == 3) {
                return null;
            }
            return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, null));
        }
        if (indexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
            return null;
        }
        if (indexOfLastSlash != -1 || path.volumeLetter() == null) {
            return indexOfLastSlash == -1 ? new okio.Path(DOT) : indexOfLastSlash == 0 ? new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, null)) : new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, indexOfLastSlash, 1, null));
        }
        if (path.getBytes$okio().size() == 2) {
            return null;
        }
        return new okio.Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, null));
    }

    @NotNull
    public static final okio.Path commonRelativeTo(@NotNull okio.Path path, @NotNull okio.Path other) {
        g0.p(path, "<this>");
        g0.p(other, "other");
        if (!g0.g(path.getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = path.getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i6 = 0;
        while (i6 < min && g0.g(segmentsBytes.get(i6), segmentsBytes2.get(i6))) {
            i6++;
        }
        if (i6 == min && path.getBytes$okio().size() == other.getBytes$okio().size()) {
            return Path.Companion.get$default(okio.Path.Companion, ".", false, 1, (Object) null);
        }
        if (segmentsBytes2.subList(i6, segmentsBytes2.size()).indexOf(DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + other).toString());
        }
        if (g0.g(other.getBytes$okio(), DOT)) {
            return path;
        }
        Buffer buffer = new Buffer();
        ByteString slash = getSlash(other);
        if (slash == null && (slash = getSlash(path)) == null) {
            slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i7 = i6; i7 < size; i7++) {
            buffer.write(DOT_DOT);
            buffer.write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i6 < size2) {
            buffer.write(segmentsBytes.get(i6));
            buffer.write(slash);
            i6++;
        }
        return toPath(buffer, false);
    }

    @Nullable
    public static final okio.Path commonRoot(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            return null;
        }
        return new okio.Path(path.getBytes$okio().substring(0, rootLength));
    }

    @NotNull
    public static final List<String> commonSegments(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i6 = rootLength;
        while (rootLength < size) {
            if (path.getBytes$okio().getByte(rootLength) == 47 || path.getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(path.getBytes$okio().substring(i6, rootLength));
                i6 = rootLength + 1;
            }
            rootLength++;
        }
        if (i6 < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i6, path.getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(f0.d0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @NotNull
    public static final List<ByteString> commonSegmentsBytes(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i6 = rootLength;
        while (rootLength < size) {
            if (path.getBytes$okio().getByte(rootLength) == 47 || path.getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(path.getBytes$okio().substring(i6, rootLength));
                i6 = rootLength + 1;
            }
            rootLength++;
        }
        if (i6 < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i6, path.getBytes$okio().size()));
        }
        return arrayList;
    }

    @NotNull
    public static final okio.Path commonToPath(@NotNull String str, boolean z5) {
        g0.p(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z5);
    }

    @NotNull
    public static final String commonToString(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        return path.getBytes$okio().utf8();
    }

    @Nullable
    public static final Character commonVolumeLetter(@NotNull okio.Path path) {
        g0.p(path, "<this>");
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || path.getBytes$okio().size() < 2 || path.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c6 = (char) path.getBytes$okio().getByte(0);
        if (('a' > c6 || c6 >= '{') && ('A' > c6 || c6 >= '[')) {
            return null;
        }
        return Character.valueOf(c6);
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if (!g0.g(byteString, BACKSLASH) || buffer.size() < 2 || buffer.getByte(1L) != 58) {
            return false;
        }
        char c6 = (char) buffer.getByte(0L);
        if ('a' > c6 || c6 >= '{') {
            return 'A' <= c6 && c6 < '[';
        }
        return true;
    }

    @NotNull
    public static final okio.Path toPath(@NotNull Buffer buffer, boolean z5) {
        ByteString byteString;
        ByteString readByteString;
        g0.p(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteString2 = null;
        int i6 = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString2 == null) {
                byteString2 = toSlash(readByte);
            }
            i6++;
        }
        boolean z6 = i6 >= 2 && g0.g(byteString2, byteString);
        if (z6) {
            g0.m(byteString2);
            buffer2.write(byteString2);
            buffer2.write(byteString2);
        } else if (i6 > 0) {
            g0.m(byteString2);
            buffer2.write(byteString2);
        } else {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            if (byteString2 == null) {
                byteString2 = indexOfElement == -1 ? toSlash(okio.Path.DIRECTORY_SEPARATOR) : toSlash(buffer.getByte(indexOfElement));
            }
            if (startsWithVolumeLetterAndColon(buffer, byteString2)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
            n1 n1Var = n1.f44123a;
        }
        boolean z7 = buffer2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                readByteString = buffer.readByteString();
            } else {
                readByteString = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString3 = DOT_DOT;
            if (g0.g(readByteString, byteString3)) {
                if (!z7 || !arrayList.isEmpty()) {
                    if (!z5 || (!z7 && (arrayList.isEmpty() || g0.g(f0.u3(arrayList), byteString3)))) {
                        arrayList.add(readByteString);
                    } else if (!z6 || arrayList.size() != 1) {
                        f0.R0(arrayList);
                    }
                }
            } else if (!g0.g(readByteString, DOT) && !g0.g(readByteString, ByteString.EMPTY)) {
                arrayList.add(readByteString);
            }
        }
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (i7 > 0) {
                buffer2.write(byteString2);
            }
            buffer2.write((ByteString) arrayList.get(i7));
        }
        if (buffer2.size() == 0) {
            buffer2.write(DOT);
        }
        return new okio.Path(buffer2.readByteString());
    }

    @NotNull
    public static final okio.Path commonResolve(@NotNull okio.Path path, @NotNull ByteString child, boolean z5) {
        g0.p(path, "<this>");
        g0.p(child, "child");
        return commonResolve(path, toPath(new Buffer().write(child), false), z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getIndexOfLastSlash(okio.Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        if (lastIndexOf$default != -1) {
            return lastIndexOf$default;
        }
        return ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString getSlash(okio.Path path) {
        ByteString bytes$okio = path.getBytes$okio();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes$okio, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString bytes$okio2 = path.getBytes$okio();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes$okio2, byteString2, 0, 2, (Object) null) == -1) {
            return null;
        }
        return byteString2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lastSegmentIsDotDot(okio.Path path) {
        if (!path.getBytes$okio().endsWith(DOT_DOT) || (path.getBytes$okio().size() != 2 && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1) && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rootLength(okio.Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        if (path.getBytes$okio().getByte(0) == 47) {
            return 1;
        }
        if (path.getBytes$okio().getByte(0) == 92) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != 92) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            if (indexOf == -1) {
                return path.getBytes$okio().size();
            }
            return indexOf;
        }
        if (path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(1) == 58 && path.getBytes$okio().getByte(2) == 92) {
            char c6 = (char) path.getBytes$okio().getByte(0);
            if ('a' > c6 || c6 >= '{') {
                if ('A' <= c6 && c6 < '[') {
                    return 3;
                }
            } else {
                return 3;
            }
        }
        return -1;
    }

    private static final ByteString toSlash(byte b6) {
        if (b6 == 47) {
            return SLASH;
        }
        if (b6 == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b6));
    }

    @NotNull
    public static final okio.Path commonResolve(@NotNull okio.Path path, @NotNull Buffer child, boolean z5) {
        g0.p(path, "<this>");
        g0.p(child, "child");
        return commonResolve(path, toPath(child, false), z5);
    }

    @NotNull
    public static final okio.Path commonResolve(@NotNull okio.Path path, @NotNull okio.Path child, boolean z5) {
        g0.p(path, "<this>");
        g0.p(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(child)) == null) {
            slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(child.getBytes$okio());
        return toPath(buffer, z5);
    }
}
