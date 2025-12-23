package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class u extends SimpleFileVisitor<Path> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Function2<Path, BasicFileAttributes, FileVisitResult> f43934a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Function2<Path, BasicFileAttributes, FileVisitResult> f43935b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final Function2<Path, IOException, FileVisitResult> f43936c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final Function2<Path, IOException, FileVisitResult> f43937d;

    @NotNull
    public FileVisitResult a(@NotNull Path dir, @Nullable IOException iOException) {
        FileVisitResult a6;
        kotlin.jvm.internal.g0.p(dir, "dir");
        Function2<Path, IOException, FileVisitResult> function2 = this.f43937d;
        if (function2 != null && (a6 = t.a(function2.invoke(dir, iOException))) != null) {
            return a6;
        }
        FileVisitResult postVisitDirectory = super.postVisitDirectory(dir, iOException);
        kotlin.jvm.internal.g0.o(postVisitDirectory, "postVisitDirectory(...)");
        return postVisitDirectory;
    }

    @NotNull
    public FileVisitResult b(@NotNull Path dir, @NotNull BasicFileAttributes attrs) {
        FileVisitResult a6;
        kotlin.jvm.internal.g0.p(dir, "dir");
        kotlin.jvm.internal.g0.p(attrs, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.f43934a;
        if (function2 != null && (a6 = t.a(function2.invoke(dir, attrs))) != null) {
            return a6;
        }
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        kotlin.jvm.internal.g0.o(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    @NotNull
    public FileVisitResult c(@NotNull Path file, @NotNull BasicFileAttributes attrs) {
        FileVisitResult a6;
        kotlin.jvm.internal.g0.p(file, "file");
        kotlin.jvm.internal.g0.p(attrs, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.f43935b;
        if (function2 != null && (a6 = t.a(function2.invoke(file, attrs))) != null) {
            return a6;
        }
        FileVisitResult visitFile = super.visitFile(file, attrs);
        kotlin.jvm.internal.g0.o(visitFile, "visitFile(...)");
        return visitFile;
    }

    @NotNull
    public FileVisitResult d(@NotNull Path file, @NotNull IOException exc) {
        FileVisitResult a6;
        kotlin.jvm.internal.g0.p(file, "file");
        kotlin.jvm.internal.g0.p(exc, "exc");
        Function2<Path, IOException, FileVisitResult> function2 = this.f43936c;
        if (function2 != null && (a6 = t.a(function2.invoke(file, exc))) != null) {
            return a6;
        }
        FileVisitResult visitFileFailed = super.visitFileFailed(file, exc);
        kotlin.jvm.internal.g0.o(visitFileFailed, "visitFileFailed(...)");
        return visitFileFailed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(@Nullable Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2, @Nullable Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function22, @Nullable Function2<? super Path, ? super IOException, ? extends FileVisitResult> function23, @Nullable Function2<? super Path, ? super IOException, ? extends FileVisitResult> function24) {
        this.f43934a = function2;
        this.f43935b = function22;
        this.f43936c = function23;
        this.f43937d = function24;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
        return a(f.a(obj), iOException);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return b(f.a(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return c(f.a(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object obj, IOException iOException) {
        return d(f.a(obj), iOException);
    }
}
