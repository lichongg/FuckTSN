package okio;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.sequences.m;
import kotlin.sequences.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nForwardingFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ForwardingFileSystem.kt\nokio/ForwardingFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,252:1\n1634#2,3:253\n1634#2,3:256\n*S KotlinDebug\n*F\n+ 1 ForwardingFileSystem.kt\nokio/ForwardingFileSystem\n*L\n170#1:253,3\n178#1:256,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ForwardingFileSystem extends FileSystem {

    @NotNull
    private final FileSystem delegate;

    public ForwardingFileSystem(@NotNull FileSystem delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path listRecursively$lambda$0(ForwardingFileSystem forwardingFileSystem, Path it) {
        g0.p(it, "it");
        return forwardingFileSystem.onPathResult(it, "listRecursively");
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean z5) throws IOException {
        g0.p(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", master.flame.danmaku.danmaku.parser.b.f50156c), z5);
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) throws IOException {
        g0.p(source, "source");
        g0.p(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", SocialConstants.PARAM_SOURCE), onPathParameter(target, "atomicMove", "target"));
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) throws IOException {
        g0.p(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // okio.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean z5) throws IOException {
        g0.p(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), z5);
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) throws IOException {
        g0.p(source, "source");
        g0.p(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", SocialConstants.PARAM_SOURCE), onPathParameter(target, "createSymlink", "target"));
    }

    @JvmName(name = "delegate")
    @NotNull
    public final FileSystem delegate() {
        return this.delegate;
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean z5) throws IOException {
        g0.p(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), z5);
    }

    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) throws IOException {
        g0.p(dir, "dir");
        List<Path> list = this.delegate.list(onPathParameter(dir, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "list"));
        }
        f0.o0(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        g0.p(dir, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listOrNull.iterator();
        while (it.hasNext()) {
            arrayList.add(onPathResult((Path) it.next(), "listOrNull"));
        }
        f0.o0(arrayList);
        return arrayList;
    }

    @Override // okio.FileSystem
    @NotNull
    public m<Path> listRecursively(@NotNull Path dir, boolean z5) {
        g0.p(dir, "dir");
        return p.N1(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", "dir"), z5), new Function1() { // from class: okio.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Path listRecursively$lambda$0;
                listRecursively$lambda$0 = ForwardingFileSystem.listRecursively$lambda$0(ForwardingFileSystem.this, (Path) obj);
                return listRecursively$lambda$0;
            }
        });
    }

    @Override // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) throws IOException {
        g0.p(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        return metadataOrNull.getSymlinkTarget() == null ? metadataOrNull : FileMetadata.copy$default(metadataOrNull, false, false, onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, 251, null);
    }

    @NotNull
    public Path onPathParameter(@NotNull Path path, @NotNull String functionName, @NotNull String parameterName) {
        g0.p(path, "path");
        g0.p(functionName, "functionName");
        g0.p(parameterName, "parameterName");
        return path;
    }

    @NotNull
    public Path onPathResult(@NotNull Path path, @NotNull String functionName) {
        g0.p(path, "path");
        g0.p(functionName, "functionName");
        return path;
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) throws IOException {
        g0.p(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", master.flame.danmaku.danmaku.parser.b.f50156c));
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean z5, boolean z6) throws IOException {
        g0.p(file, "file");
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", master.flame.danmaku.danmaku.parser.b.f50156c), z5, z6);
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean z5) throws IOException {
        g0.p(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", master.flame.danmaku.danmaku.parser.b.f50156c), z5);
    }

    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) throws IOException {
        g0.p(file, "file");
        return this.delegate.source(onPathParameter(file, SocialConstants.PARAM_SOURCE, master.flame.danmaku.danmaku.parser.b.f50156c));
    }

    @NotNull
    public String toString() {
        return o0.d(getClass()).D() + '(' + this.delegate + ')';
    }
}
