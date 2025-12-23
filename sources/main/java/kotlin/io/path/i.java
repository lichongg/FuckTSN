package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/DirectoryEntriesReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class i extends SimpleFileVisitor<Path> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f43921a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private x f43922b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private kotlin.collections.m<x> f43923c = new kotlin.collections.m<>();

    public final boolean a() {
        return this.f43921a;
    }

    @NotNull
    public FileVisitResult b(@NotNull Path dir, @NotNull BasicFileAttributes attrs) {
        Object fileKey;
        kotlin.jvm.internal.g0.p(dir, "dir");
        kotlin.jvm.internal.g0.p(attrs, "attrs");
        fileKey = attrs.fileKey();
        this.f43923c.add(new x(dir, fileKey, this.f43922b));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        kotlin.jvm.internal.g0.o(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    @NotNull
    public final List<x> c(@NotNull x directoryNode) {
        kotlin.jvm.internal.g0.p(directoryNode, "directoryNode");
        this.f43922b = directoryNode;
        Files.walkFileTree(directoryNode.d(), w.f43945a.b(this.f43921a), 1, g.a(this));
        this.f43923c.removeFirst();
        kotlin.collections.m<x> mVar = this.f43923c;
        this.f43923c = new kotlin.collections.m<>();
        return mVar;
    }

    @NotNull
    public FileVisitResult d(@NotNull Path file, @NotNull BasicFileAttributes attrs) {
        kotlin.jvm.internal.g0.p(file, "file");
        kotlin.jvm.internal.g0.p(attrs, "attrs");
        this.f43923c.add(new x(file, null, this.f43922b));
        FileVisitResult visitFile = super.visitFile(file, attrs);
        kotlin.jvm.internal.g0.o(visitFile, "visitFile(...)");
        return visitFile;
    }

    public i(boolean z5) {
        this.f43921a = z5;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return b(f.a(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return d(f.a(obj), basicFileAttributes);
    }
}
