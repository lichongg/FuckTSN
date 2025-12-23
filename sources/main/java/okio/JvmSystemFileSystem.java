package okio;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmSystemFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,158:1\n11896#2,3:159\n*S KotlinDebug\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n*L\n77#1:159,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class JvmSystemFileSystem extends FileSystem {
    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        g0.p(dir, "dir");
        List<Path> list = list(dir, true);
        g0.m(list);
        return list;
    }

    private final List<Path> list(Path path, boolean z5) {
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                g0.m(str);
                arrayList.add(path.resolve(str));
            }
            f0.o0(arrayList);
            return arrayList;
        }
        if (!z5) {
            return null;
        }
        if (file.exists()) {
            throw new IOException("failed to list " + path);
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean z5) {
        g0.p(file, "file");
        if (z5) {
            requireExist(file);
        }
        return Okio.sink(file.toFile(), true);
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        g0.p(source, "source");
        g0.p(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        g0.p(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        Path.Companion companion = Path.Companion;
        g0.m(canonicalFile);
        return Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean z5) {
        g0.p(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        FileMetadata metadataOrNull = metadataOrNull(dir);
        if (metadataOrNull == null || !metadataOrNull.isDirectory()) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (z5) {
            throw new IOException(dir + " already exists.");
        }
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        g0.p(source, "source");
        g0.p(target, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean z5) {
        g0.p(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + path);
        }
        if (z5) {
            throw new FileNotFoundException("no such file: " + path);
        }
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
        g0.p(path, "path");
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(isFile, isDirectory, null, Long.valueOf(length), null, Long.valueOf(lastModified), null, null, 128, null);
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        g0.p(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.toFile(), t.f36150k));
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean z5, boolean z6) {
        g0.p(file, "file");
        if (z5 && z6) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z5) {
            requireCreate(file);
        }
        if (z6) {
            requireExist(file);
        }
        return new JvmFileHandle(true, new RandomAccessFile(file.toFile(), "rw"));
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean z5) {
        g0.p(file, "file");
        if (z5) {
            requireCreate(file);
        }
        return Okio__JvmOkioKt.sink$default(file.toFile(), false, 1, null);
    }

    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) {
        g0.p(file, "file");
        return Okio.source(file.toFile());
    }

    @NotNull
    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final void requireCreate(Path path) {
        if (!exists(path)) {
            return;
        }
        throw new IOException(path + " already exists.");
    }

    private final void requireExist(Path path) {
        if (exists(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }
}
