package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nZipFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,142:1\n58#2,4:143\n58#2,22:147\n66#2,10:169\n62#2,3:179\n77#2,3:182\n58#2,22:185\n*S KotlinDebug\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n*L\n55#1:143,4\n56#1:147,22\n55#1:169,10\n55#1:179,3\n55#1:182,3\n99#1:185,22\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ZipFileSystem extends FileSystem {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @NotNull
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);

    @Nullable
    private final String comment;

    @NotNull
    private final Map<Path, ZipEntry> entries;

    @NotNull
    private final FileSystem fileSystem;

    @NotNull
    private final Path zipPath;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }

    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        g0.p(dir, "dir");
        List<Path> list = list(dir, true);
        g0.m(list);
        return list;
    }

    public ZipFileSystem(@NotNull Path zipPath, @NotNull FileSystem fileSystem, @NotNull Map<Path, ZipEntry> entries, @Nullable String str) {
        g0.p(zipPath, "zipPath");
        g0.p(fileSystem, "fileSystem");
        g0.p(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Path> list(Path path, boolean z5) {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            return f0.a6(zipEntry.getChildren());
        }
        if (!z5) {
            return null;
        }
        throw new IOException("not a directory: " + path);
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean z5) {
        g0.p(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        g0.p(source, "source");
        g0.p(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        g0.p(path, "path");
        Path canonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(canonicalizeInternal)) {
            return canonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean z5) {
        g0.p(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        g0.p(source, "source");
        g0.p(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean z5) {
        g0.p(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        g0.p(dir, "dir");
        return list(dir, false);
    }

    @Override // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Throwable th;
        Throwable th2;
        g0.p(path, "path");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry == null) {
            return null;
        }
        if (zipEntry.getOffset() != -1) {
            FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
            try {
                BufferedSource buffer = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
                try {
                    zipEntry = ZipFilesKt.readLocalHeader(buffer, zipEntry);
                    if (buffer != null) {
                        try {
                            buffer.close();
                        } catch (Throwable th3) {
                            th2 = th3;
                        }
                    }
                    th2 = null;
                } catch (Throwable th4) {
                    if (buffer != null) {
                        try {
                            buffer.close();
                        } catch (Throwable th5) {
                            kotlin.l.a(th4, th5);
                        }
                    }
                    th2 = th4;
                    zipEntry = null;
                }
            } catch (Throwable th6) {
                if (openReadOnly != null) {
                    try {
                        openReadOnly.close();
                    } catch (Throwable th7) {
                        kotlin.l.a(th6, th7);
                    }
                }
                th = th6;
                zipEntry = null;
            }
            if (th2 != null) {
                throw th2;
            }
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th8) {
                    th = th8;
                }
            }
            th = null;
            if (th != null) {
                throw th;
            }
        }
        return new FileMetadata(!zipEntry.isDirectory(), zipEntry.isDirectory(), null, zipEntry.isDirectory() ? null : Long.valueOf(zipEntry.getSize()), zipEntry.getCreatedAtMillis$okio(), zipEntry.getLastModifiedAtMillis$okio(), zipEntry.getLastAccessedAtMillis$okio(), null, 128, null);
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        g0.p(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean z5, boolean z6) {
        g0.p(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean z5) {
        g0.p(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) throws IOException {
        g0.p(file, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(file));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        BufferedSource th = null;
        try {
            BufferedSource buffer = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            th = th;
            th = buffer;
        } catch (Throwable th3) {
            th = th3;
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th4) {
                    kotlin.l.a(th, th4);
                }
            }
        }
        if (th != 0) {
            throw th;
        }
        ZipFilesKt.skipLocalHeader(th);
        return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(th, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(th, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
    }
}
