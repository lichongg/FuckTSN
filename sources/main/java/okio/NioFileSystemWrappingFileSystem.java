package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.io.path.k0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNioFileSystemWrappingFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,196:1\n1634#2,3:197\n1#3:200\n37#4,2:201\n37#4,2:203\n37#4,2:205\n*S KotlinDebug\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n*L\n77#1:197,3\n104#1:201,2\n125#1:203,2\n138#1:205,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {

    @NotNull
    private final java.nio.file.FileSystem nioFileSystem;

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        g0.p(dir, "dir");
        List<Path> list = list(dir, true);
        g0.m(list);
        return list;
    }

    public NioFileSystemWrappingFileSystem(@NotNull java.nio.file.FileSystem nioFileSystem) {
        g0.p(nioFileSystem, "nioFileSystem");
        this.nioFileSystem = nioFileSystem;
    }

    private final List<Path> list(Path path, boolean z5) {
        boolean exists;
        java.nio.file.Path resolve = resolve(path);
        try {
            List u12 = k0.u1(resolve, null, 1, null);
            ArrayList arrayList = new ArrayList();
            Iterator it = u12.iterator();
            while (it.hasNext()) {
                arrayList.add(Path.Companion.get$default(Path.Companion, kotlin.io.path.f.a(it.next()), false, 1, (Object) null));
            }
            f0.o0(arrayList);
            return arrayList;
        } catch (Exception unused) {
            if (!z5) {
                return null;
            }
            exists = Files.exists(resolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
            if (exists) {
                throw new IOException("failed to list " + path);
            }
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    private final java.nio.file.Path resolve(Path path) {
        java.nio.file.Path path2;
        path2 = this.nioFileSystem.getPath(path.toString(), new String[0]);
        g0.o(path2, "getPath(...)");
        return path2;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean z5) {
        StandardOpenOption standardOpenOption;
        OutputStream newOutputStream;
        StandardOpenOption standardOpenOption2;
        g0.p(file, "file");
        List j6 = f0.j();
        standardOpenOption = StandardOpenOption.APPEND;
        j6.add(standardOpenOption);
        if (!z5) {
            standardOpenOption2 = StandardOpenOption.CREATE;
            j6.add(standardOpenOption2);
        }
        List b6 = f0.b(j6);
        java.nio.file.Path resolve = resolve(file);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) b6.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        newOutputStream = Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        g0.o(newOutputStream, "newOutputStream(...)");
        return Okio.sink(newOutputStream);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        String message;
        StandardCopyOption standardCopyOption;
        StandardCopyOption standardCopyOption2;
        java.nio.file.Path move;
        g0.p(source, "source");
        g0.p(target, "target");
        try {
            java.nio.file.Path resolve = resolve(source);
            java.nio.file.Path resolve2 = resolve(target);
            standardCopyOption = StandardCopyOption.ATOMIC_MOVE;
            standardCopyOption2 = StandardCopyOption.REPLACE_EXISTING;
            move = Files.move(resolve, resolve2, (CopyOption[]) Arrays.copyOf(new CopyOption[]{standardCopyOption, standardCopyOption2}, 2));
            g0.o(move, "move(...)");
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e6) {
            message = e6.getMessage();
            throw new FileNotFoundException(message);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        java.nio.file.Path realPath;
        g0.p(path, "path");
        try {
            Path.Companion companion = Path.Companion;
            realPath = resolve(path).toRealPath(new LinkOption[0]);
            g0.o(realPath, "toRealPath(...)");
            return Path.Companion.get$default(companion, realPath, false, 1, (Object) null);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override // okio.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.nioFileSystem.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0.isDirectory() == true) goto L8;
     */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void createDirectory(@org.jetbrains.annotations.NotNull okio.Path r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "dir"
            kotlin.jvm.internal.g0.p(r4, r0)
            okio.FileMetadata r0 = r3.metadataOrNull(r4)
            r1 = 0
            if (r0 == 0) goto L14
            boolean r0 = r0.isDirectory()
            r2 = 1
            if (r0 != r2) goto L14
            goto L15
        L14:
            r2 = 0
        L15:
            if (r2 == 0) goto L31
            if (r5 != 0) goto L1a
            goto L31
        L1a:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " already exists."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L31:
            java.nio.file.Path r5 = r3.resolve(r4)     // Catch: java.io.IOException -> L47
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]     // Catch: java.io.IOException -> L47
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch: java.io.IOException -> L47
            java.nio.file.attribute.FileAttribute[] r0 = (java.nio.file.attribute.FileAttribute[]) r0     // Catch: java.io.IOException -> L47
            java.nio.file.Path r5 = kotlin.io.path.p2.a(r5, r0)     // Catch: java.io.IOException -> L47
            java.lang.String r0 = "createDirectory(...)"
            kotlin.jvm.internal.g0.o(r5, r0)     // Catch: java.io.IOException -> L47
            return
        L47:
            r5 = move-exception
            if (r2 == 0) goto L4b
            return
        L4b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "failed to create directory: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemWrappingFileSystem.createDirectory(okio.Path, boolean):void");
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        java.nio.file.Path createSymbolicLink;
        g0.p(source, "source");
        g0.p(target, "target");
        createSymbolicLink = Files.createSymbolicLink(resolve(source), resolve(target), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0));
        g0.o(createSymbolicLink, "createSymbolicLink(...)");
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void delete(@NotNull Path path, boolean z5) {
        boolean exists;
        g0.p(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        java.nio.file.Path resolve = resolve(path);
        try {
            Files.delete(resolve);
        } catch (NoSuchFileException unused) {
            if (z5) {
                throw new FileNotFoundException("no such file: " + path);
            }
        } catch (IOException unused2) {
            exists = Files.exists(resolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
            if (exists) {
                throw new IOException("failed to delete " + path);
            }
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        g0.p(dir, "dir");
        return list(dir, false);
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        g0.p(path, "path");
        return metadataOrNull(resolve(path));
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        StandardOpenOption standardOpenOption;
        FileChannel open;
        g0.p(file, "file");
        try {
            java.nio.file.Path resolve = resolve(file);
            standardOpenOption = StandardOpenOption.READ;
            open = FileChannel.open(resolve, standardOpenOption);
            g0.m(open);
            return new NioFileSystemFileHandle(false, open);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean z5, boolean z6) {
        StandardOpenOption standardOpenOption;
        StandardOpenOption standardOpenOption2;
        StandardOpenOption standardOpenOption3;
        FileChannel open;
        StandardOpenOption standardOpenOption4;
        g0.p(file, "file");
        if (z5 && z6) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        List j6 = f0.j();
        standardOpenOption = StandardOpenOption.READ;
        j6.add(standardOpenOption);
        standardOpenOption2 = StandardOpenOption.WRITE;
        j6.add(standardOpenOption2);
        if (z5) {
            standardOpenOption4 = StandardOpenOption.CREATE_NEW;
            j6.add(standardOpenOption4);
        } else if (!z6) {
            standardOpenOption3 = StandardOpenOption.CREATE;
            j6.add(standardOpenOption3);
        }
        List b6 = f0.b(j6);
        try {
            java.nio.file.Path resolve = resolve(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) b6.toArray(new StandardOpenOption[0]);
            open = FileChannel.open(resolve, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            g0.m(open);
            return new NioFileSystemFileHandle(true, open);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean z5) {
        OutputStream newOutputStream;
        StandardOpenOption standardOpenOption;
        g0.p(file, "file");
        List j6 = f0.j();
        if (z5) {
            standardOpenOption = StandardOpenOption.CREATE_NEW;
            j6.add(standardOpenOption);
        }
        List b6 = f0.b(j6);
        try {
            java.nio.file.Path resolve = resolve(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) b6.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            newOutputStream = Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            g0.o(newOutputStream, "newOutputStream(...)");
            return Okio.sink(newOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) {
        InputStream newInputStream;
        g0.p(file, "file");
        try {
            newInputStream = Files.newInputStream(resolve(file), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            g0.o(newInputStream, "newInputStream(...)");
            return Okio.source(newInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + file);
        }
    }

    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem
    @NotNull
    public String toString() {
        String D = o0.d(this.nioFileSystem.getClass()).D();
        g0.m(D);
        return D;
    }
}
