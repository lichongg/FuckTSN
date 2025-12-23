package okio;

import com.acse.ottn.l3;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/Path\n+ 2 Path.kt\nokio/internal/-Path\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n39#2,3:133\n47#2,28:136\n53#2,22:168\n106#2:190\n111#2:191\n116#2,6:192\n133#2,5:198\n143#2:203\n148#2,25:204\n188#2:229\n193#2,11:230\n198#2,6:241\n193#2,11:247\n198#2,6:258\n222#2,41:264\n267#2:305\n281#2:306\n286#2:307\n291#2:308\n296#2:309\n1563#3:164\n1634#3,3:165\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/Path\n*L\n44#1:133,3\n47#1:136,28\n50#1:168,22\n53#1:190\n56#1:191\n60#1:192,6\n64#1:198,5\n68#1:203\n72#1:204,25\n75#1:229\n78#1:230,11\n81#1:241,6\n87#1:247,11\n90#1:258,6\n95#1:264,41\n97#1:305\n104#1:306\n106#1:307\n108#1:308\n110#1:309\n47#1:164\n47#1:165,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Path implements Comparable<Path> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final String DIRECTORY_SEPARATOR;

    @NotNull
    private final ByteString bytes;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            return companion.get(str, z5);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File file) {
            g0.p(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            return companion.get(file, z5);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String str) {
            g0.p(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            return companion.get(path, z5);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path path) {
            g0.p(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String str, boolean z5) {
            g0.p(str, "<this>");
            return okio.internal.Path.commonToPath(str, z5);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File file, boolean z5) {
            g0.p(file, "<this>");
            String file2 = file.toString();
            g0.o(file2, "toString(...)");
            return get(file2, z5);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path path, boolean z5) {
            g0.p(path, "<this>");
            return get(path.toString(), z5);
        }
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File file) {
        return Companion.get(file);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return path.resolve(str, z5);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull Path child) {
        g0.p(child, "child");
        return okio.internal.Path.commonResolve(this, child, false);
    }

    static {
        String separator = File.separator;
        g0.o(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(@NotNull ByteString bytes) {
        g0.p(bytes, "bytes");
        this.bytes = bytes;
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File file, boolean z5) {
        return Companion.get(file, z5);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return path.resolve(byteString, z5);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Path other) {
        g0.p(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Path) && g0.g(((Path) obj).getBytes$okio(), getBytes$okio());
    }

    @NotNull
    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    @NotNull
    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < getBytes$okio().size() && getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = getBytes$okio().size();
        int i6 = rootLength;
        while (rootLength < size) {
            if (getBytes$okio().getByte(rootLength) == 47 || getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i6, rootLength));
                i6 = rootLength + 1;
            }
            rootLength++;
        }
        if (i6 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i6, getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(f0.d0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @NotNull
    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < getBytes$okio().size() && getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = getBytes$okio().size();
        int i6 = rootLength;
        while (rootLength < size) {
            if (getBytes$okio().getByte(rootLength) == 47 || getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i6, rootLength));
                i6 = rootLength + 1;
            }
            rootLength++;
        }
        if (i6 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i6, getBytes$okio().size()));
        }
        return arrayList;
    }

    @NotNull
    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    @NotNull
    public final Path relativeTo(@NotNull Path other) {
        g0.p(other, "other");
        if (!g0.g(getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i6 = 0;
        while (i6 < min && g0.g(segmentsBytes.get(i6), segmentsBytes2.get(i6))) {
            i6++;
        }
        if (i6 == min && getBytes$okio().size() == other.getBytes$okio().size()) {
            return Companion.get$default(Companion, ".", false, 1, (Object) null);
        }
        if (segmentsBytes2.subList(i6, segmentsBytes2.size()).indexOf(okio.internal.Path.DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        if (g0.g(other.getBytes$okio(), okio.internal.Path.DOT)) {
            return this;
        }
        Buffer buffer = new Buffer();
        ByteString slash = okio.internal.Path.getSlash(other);
        if (slash == null && (slash = okio.internal.Path.getSlash(this)) == null) {
            slash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i7 = i6; i7 < size; i7++) {
            buffer.write(okio.internal.Path.DOT_DOT);
            buffer.write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i6 < size2) {
            buffer.write(segmentsBytes.get(i6));
            buffer.write(slash);
            i6++;
        }
        return okio.internal.Path.toPath(buffer, false);
    }

    @NotNull
    public final Path resolve(@NotNull Path child, boolean z5) {
        g0.p(child, "child");
        return okio.internal.Path.commonResolve(this, child, z5);
    }

    @NotNull
    public final File toFile() {
        return new File(toString());
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String str) {
        return Companion.get(str);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return path.resolve(path2, z5);
    }

    @Nullable
    public final Path getRoot() {
        int rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, rootLength));
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        if (okio.internal.Path.rootLength(this) != -1) {
            return true;
        }
        return false;
    }

    public final boolean isRelative() {
        if (okio.internal.Path.rootLength(this) == -1) {
            return true;
        }
        return false;
    }

    public final boolean isRoot() {
        if (okio.internal.Path.rootLength(this) == getBytes$okio().size()) {
            return true;
        }
        return false;
    }

    @JvmName(name = CommonNetImpl.NAME)
    @NotNull
    public final String name() {
        return nameBytes().utf8();
    }

    @JvmName(name = "nameBytes")
    @NotNull
    public final ByteString nameBytes() {
        int indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (indexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes$okio(), indexOfLastSlash + 1, 0, 2, null);
        }
        if (volumeLetter() != null && getBytes$okio().size() == 2) {
            return ByteString.EMPTY;
        }
        return getBytes$okio();
    }

    @JvmName(name = "parent")
    @Nullable
    public final Path parent() {
        if (!g0.g(getBytes$okio(), okio.internal.Path.DOT) && !g0.g(getBytes$okio(), okio.internal.Path.SLASH) && !g0.g(getBytes$okio(), okio.internal.Path.BACKSLASH) && !okio.internal.Path.lastSegmentIsDotDot(this)) {
            int indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
            if (indexOfLastSlash == 2 && volumeLetter() != null) {
                if (getBytes$okio().size() == 3) {
                    return null;
                }
                return new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
            }
            if (indexOfLastSlash == 1 && getBytes$okio().startsWith(okio.internal.Path.BACKSLASH)) {
                return null;
            }
            if (indexOfLastSlash == -1 && volumeLetter() != null) {
                if (getBytes$okio().size() == 2) {
                    return null;
                }
                return new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
            }
            if (indexOfLastSlash == -1) {
                return new Path(okio.internal.Path.DOT);
            }
            if (indexOfLastSlash == 0) {
                return new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
            }
            return new Path(ByteString.substring$default(getBytes$okio(), 0, indexOfLastSlash, 1, null));
        }
        return null;
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull String child) {
        g0.p(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), false);
    }

    @NotNull
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path;
        path = Paths.get(toString(), new String[0]);
        g0.o(path, "get(...)");
        return path;
    }

    @NotNull
    public String toString() {
        return getBytes$okio().utf8();
    }

    @JvmName(name = "volumeLetter")
    @Nullable
    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes$okio(), okio.internal.Path.SLASH, 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c6 = (char) getBytes$okio().getByte(0);
        if (('a' > c6 || c6 >= '{') && ('A' > c6 || c6 >= '[')) {
            return null;
        }
        return Character.valueOf(c6);
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String str, boolean z5) {
        return Companion.get(str, z5);
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path path) {
        return Companion.get(path);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull ByteString child) {
        g0.p(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), false);
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path path, boolean z5) {
        return Companion.get(path, z5);
    }

    @NotNull
    public final Path resolve(@NotNull String child, boolean z5) {
        g0.p(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), z5);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString child, boolean z5) {
        g0.p(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), z5);
    }
}
