package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.collections.m;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.l;
import kotlin.sequences.p;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-FileSystem")
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n58#2,4:156\n58#2,22:160\n66#2,10:182\n62#2,3:192\n77#2,3:195\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n*L\n65#1:156,4\n66#1:160,22\n65#1:182,10\n65#1:192,3\n65#1:195,3\n*E\n"})
/* renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class FileSystem {
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01cb, code lost:
    
        if (r10.c(r1, r4) == r5) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0110, code lost:
    
        if (r0 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0112, code lost:
    
        if (r11 != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0114, code lost:
    
        r6.addLast(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011b, code lost:
    
        r13 = r1;
        r1 = r6;
        r6 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0190, code lost:
    
        r12 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00c7, code lost:
    
        if (r17.c(r1, r4) == r5) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0127 A[Catch: all -> 0x017e, TRY_LEAVE, TryCatch #2 {all -> 0x017e, blocks: (B:23:0x0121, B:25:0x0127), top: B:22:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0173 -> B:21:0x0086). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object collectRecursively(@org.jetbrains.annotations.NotNull kotlin.sequences.o<? super okio.Path> r17, @org.jetbrains.annotations.NotNull okio.FileSystem r18, @org.jetbrains.annotations.NotNull kotlin.collections.m<okio.Path> r19, @org.jetbrains.annotations.NotNull okio.Path r20, boolean r21, boolean r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r23) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(kotlin.sequences.o, okio.FileSystem, kotlin.collections.m, okio.Path, boolean, boolean, kotlin.coroutines.e):java.lang.Object");
    }

    public static final void commonCopy(@NotNull okio.FileSystem fileSystem, @NotNull Path source, @NotNull Path target) throws IOException {
        Throwable th;
        Long l6;
        g0.p(fileSystem, "<this>");
        g0.p(source, "source");
        g0.p(target, "target");
        Source source2 = fileSystem.source(source);
        Throwable th2 = null;
        try {
            BufferedSink buffer = Okio.buffer(okio.FileSystem.sink$default(fileSystem, target, false, 2, null));
            try {
                l6 = Long.valueOf(buffer.writeAll(source2));
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (Throwable th5) {
                        l.a(th4, th5);
                    }
                }
                th = th4;
                l6 = null;
            }
        } catch (Throwable th6) {
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th7) {
                    l.a(th6, th7);
                }
            }
            th2 = th6;
        }
        if (th != null) {
            throw th;
        }
        l6.longValue();
        if (source2 != null) {
            try {
                source2.close();
            } catch (Throwable th8) {
                th2 = th8;
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }

    public static final void commonCreateDirectories(@NotNull okio.FileSystem fileSystem, @NotNull Path dir, boolean z5) throws IOException {
        g0.p(fileSystem, "<this>");
        g0.p(dir, "dir");
        m mVar = new m();
        for (Path path = dir; path != null && !fileSystem.exists(path); path = path.parent()) {
            mVar.addFirst(path);
        }
        if (z5 && mVar.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = mVar.iterator();
        while (it.hasNext()) {
            okio.FileSystem.createDirectory$default(fileSystem, (Path) it.next(), false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path fileOrDirectory, boolean z5) throws IOException {
        g0.p(fileSystem, "<this>");
        g0.p(fileOrDirectory, "fileOrDirectory");
        Iterator it = p.b(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z5 && !it.hasNext());
        }
    }

    public static final boolean commonExists(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        g0.p(fileSystem, "<this>");
        g0.p(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    @NotNull
    public static final kotlin.sequences.m<Path> commonListRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path dir, boolean z5) throws IOException {
        g0.p(fileSystem, "<this>");
        g0.p(dir, "dir");
        return p.b(new FileSystem$commonListRecursively$1(dir, fileSystem, z5, null));
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        g0.p(fileSystem, "<this>");
        g0.p(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        g0.p(fileSystem, "<this>");
        g0.p(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        g0.m(parent);
        return parent.resolve(symlinkTarget);
    }
}
