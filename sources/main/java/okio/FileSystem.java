package okio;

import com.acse.ottn.l3;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.sequences.m;
import okio.Path;
import okio.internal.ResourceFileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,191:1\n58#2,22:192\n58#2,22:214\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n*L\n73#1:192,22\n95#1:214,22\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class FileSystem implements Closeable {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final FileSystem RESOURCES;

    @JvmField
    @NotNull
    public static final FileSystem SYSTEM;

    @JvmField
    @NotNull
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        public final FileSystem get(@NotNull java.nio.file.FileSystem fileSystem) {
            g0.p(fileSystem, "<this>");
            return new NioFileSystemWrappingFileSystem(fileSystem);
        }
    }

    @NotNull
    public final Sink appendingSink(@NotNull Path file) throws IOException {
        g0.p(file, "file");
        return appendingSink(file, false);
    }

    @NotNull
    public abstract Sink appendingSink(@NotNull Path path, boolean z5) throws IOException;

    public abstract void atomicMove(@NotNull Path path, @NotNull Path path2) throws IOException;

    @NotNull
    public abstract Path canonicalize(@NotNull Path path) throws IOException;

    public final void createDirectories(@NotNull Path dir, boolean z5) throws IOException {
        g0.p(dir, "dir");
        okio.internal.FileSystem.commonCreateDirectories(this, dir, z5);
    }

    public final void createDirectory(@NotNull Path dir) throws IOException {
        g0.p(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(@NotNull Path path, boolean z5) throws IOException;

    public abstract void createSymlink(@NotNull Path path, @NotNull Path path2) throws IOException;

    public final void delete(@NotNull Path path) throws IOException {
        g0.p(path, "path");
        delete(path, false);
    }

    public abstract void delete(@NotNull Path path, boolean z5) throws IOException;

    public void deleteRecursively(@NotNull Path fileOrDirectory, boolean z5) throws IOException {
        g0.p(fileOrDirectory, "fileOrDirectory");
        okio.internal.FileSystem.commonDeleteRecursively(this, fileOrDirectory, z5);
    }

    @NotNull
    public abstract List<Path> list(@NotNull Path path) throws IOException;

    @Nullable
    public abstract List<Path> listOrNull(@NotNull Path path);

    @NotNull
    public m<Path> listRecursively(@NotNull Path dir, boolean z5) {
        g0.p(dir, "dir");
        return okio.internal.FileSystem.commonListRecursively(this, dir, z5);
    }

    @Nullable
    public abstract FileMetadata metadataOrNull(@NotNull Path path) throws IOException;

    @NotNull
    public abstract FileHandle openReadOnly(@NotNull Path path) throws IOException;

    @NotNull
    public final FileHandle openReadWrite(@NotNull Path file) throws IOException {
        g0.p(file, "file");
        return openReadWrite(file, false, false);
    }

    @NotNull
    public abstract FileHandle openReadWrite(@NotNull Path path, boolean z5, boolean z6) throws IOException;

    @NotNull
    public final Sink sink(@NotNull Path file) throws IOException {
        g0.p(file, "file");
        return sink(file, false);
    }

    @NotNull
    public abstract Sink sink(@NotNull Path path, boolean z5) throws IOException;

    @NotNull
    public abstract Source source(@NotNull Path path) throws IOException;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m308write$default(FileSystem fileSystem, Path file, boolean z5, Function1 writerAction, int i6, Object obj) throws IOException {
        ?? r42;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        g0.p(file, "file");
        g0.p(writerAction, "writerAction");
        BufferedSink buffer = Okio.buffer(fileSystem.sink(file, z5));
        Object th = null;
        try {
            Object invoke = writerAction.invoke(buffer);
            d0.d(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            d0.c(1);
            r42 = th;
            th = invoke;
        } catch (Throwable th3) {
            d0.d(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th4) {
                    kotlin.l.a(th3, th4);
                }
            }
            d0.c(1);
            r42 = th3;
        }
        if (r42 == 0) {
            return th;
        }
        throw r42;
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        g0.o(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        g0.o(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader, false, null, 4, null);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return fileSystem.appendingSink(path, z5);
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.createDirectories(path, z5);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.createDirectory(path, z5);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.delete(path, z5);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        fileSystem.deleteRecursively(path, z5);
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    public static final FileSystem get(@NotNull java.nio.file.FileSystem fileSystem) {
        return Companion.get(fileSystem);
    }

    public static /* synthetic */ m listRecursively$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return fileSystem.listRecursively(path, z5);
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z5, boolean z6, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            z6 = false;
        }
        return fileSystem.openReadWrite(path, z5, z6);
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z5, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return fileSystem.sink(path, z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    @JvmName(name = "-read")
    /* renamed from: -read, reason: not valid java name */
    public final <T> T m309read(@NotNull Path file, @NotNull Function1<? super BufferedSource, ? extends T> readerAction) throws IOException {
        ?? r5;
        g0.p(file, "file");
        g0.p(readerAction, "readerAction");
        BufferedSource buffer = Okio.buffer(source(file));
        T th = null;
        try {
            T invoke = readerAction.invoke(buffer);
            d0.d(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            d0.c(1);
            T t5 = th;
            th = invoke;
            r5 = t5;
        } catch (Throwable th3) {
            d0.d(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th4) {
                    kotlin.l.a(th3, th4);
                }
            }
            d0.c(1);
            r5 = th3;
        }
        if (r5 == 0) {
            return th;
        }
        throw r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    @JvmName(name = "-write")
    /* renamed from: -write, reason: not valid java name */
    public final <T> T m310write(@NotNull Path file, boolean z5, @NotNull Function1<? super BufferedSink, ? extends T> writerAction) throws IOException {
        ?? r5;
        g0.p(file, "file");
        g0.p(writerAction, "writerAction");
        BufferedSink buffer = Okio.buffer(sink(file, z5));
        T th = null;
        try {
            T invoke = writerAction.invoke(buffer);
            d0.d(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            d0.c(1);
            T t5 = th;
            th = invoke;
            r5 = t5;
        } catch (Throwable th3) {
            d0.d(1);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th4) {
                    kotlin.l.a(th3, th4);
                }
            }
            d0.c(1);
            r5 = th3;
        }
        if (r5 == 0) {
            return th;
        }
        throw r5;
    }

    public void copy(@NotNull Path source, @NotNull Path target) throws IOException {
        g0.p(source, "source");
        g0.p(target, "target");
        okio.internal.FileSystem.commonCopy(this, source, target);
    }

    public final void createDirectories(@NotNull Path dir) throws IOException {
        g0.p(dir, "dir");
        createDirectories(dir, false);
    }

    public final void deleteRecursively(@NotNull Path fileOrDirectory) throws IOException {
        g0.p(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    public final boolean exists(@NotNull Path path) throws IOException {
        g0.p(path, "path");
        return okio.internal.FileSystem.commonExists(this, path);
    }

    @NotNull
    public final m<Path> listRecursively(@NotNull Path dir) {
        g0.p(dir, "dir");
        return listRecursively(dir, false);
    }

    @NotNull
    public final FileMetadata metadata(@NotNull Path path) throws IOException {
        g0.p(path, "path");
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
