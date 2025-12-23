package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNioSystemFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NioSystemFileSystem.kt\nokio/NioSystemFileSystem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n1#2:93\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class NioSystemFileSystem extends JvmSystemFileSystem {
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        g0.p(path, "path");
        return metadataOrNull(path.toNioPath());
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        String message;
        StandardCopyOption standardCopyOption;
        StandardCopyOption standardCopyOption2;
        g0.p(source, "source");
        g0.p(target, "target");
        try {
            java.nio.file.Path nioPath = source.toNioPath();
            java.nio.file.Path nioPath2 = target.toNioPath();
            standardCopyOption = StandardCopyOption.ATOMIC_MOVE;
            standardCopyOption2 = StandardCopyOption.REPLACE_EXISTING;
            Files.move(nioPath, nioPath2, standardCopyOption, standardCopyOption2);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e6) {
            message = e6.getMessage();
            throw new FileNotFoundException(message);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        g0.p(source, "source");
        g0.p(target, "target");
        Files.createSymbolicLink(source.toNioPath(), target.toNioPath(), new FileAttribute[0]);
    }

    @Nullable
    protected final FileMetadata metadataOrNull(@NotNull java.nio.file.Path nioPath) {
        LinkOption linkOption;
        BasicFileAttributes readAttributes;
        boolean isSymbolicLink;
        boolean isRegularFile;
        boolean isDirectory;
        long size;
        FileTime creationTime;
        FileTime lastModifiedTime;
        FileTime lastAccessTime;
        g0.p(nioPath, "nioPath");
        try {
            Class a6 = cn.jiguang.i.g.a();
            linkOption = LinkOption.NOFOLLOW_LINKS;
            readAttributes = Files.readAttributes(nioPath, (Class<BasicFileAttributes>) a6, linkOption);
            isSymbolicLink = readAttributes.isSymbolicLink();
            java.nio.file.Path readSymbolicLink = isSymbolicLink ? Files.readSymbolicLink(nioPath) : null;
            isRegularFile = readAttributes.isRegularFile();
            isDirectory = readAttributes.isDirectory();
            Path path = readSymbolicLink != null ? Path.Companion.get$default(Path.Companion, readSymbolicLink, false, 1, (Object) null) : null;
            size = readAttributes.size();
            Long valueOf = Long.valueOf(size);
            creationTime = readAttributes.creationTime();
            Long zeroToNull = creationTime != null ? zeroToNull(creationTime) : null;
            lastModifiedTime = readAttributes.lastModifiedTime();
            Long zeroToNull2 = lastModifiedTime != null ? zeroToNull(lastModifiedTime) : null;
            lastAccessTime = readAttributes.lastAccessTime();
            return new FileMetadata(isRegularFile, isDirectory, path, valueOf, zeroToNull, zeroToNull2, lastAccessTime != null ? zeroToNull(lastAccessTime) : null, null, 128, null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    @Override // okio.JvmSystemFileSystem
    @NotNull
    public String toString() {
        return "NioSystemFileSystem";
    }

    private final Long zeroToNull(FileTime fileTime) {
        long millis;
        millis = fileTime.toMillis();
        Long valueOf = Long.valueOf(millis);
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }
}
