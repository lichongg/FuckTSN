package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s implements r {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f43928a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f43929b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Function2<? super Path, ? super IOException, ? extends FileVisitResult> f43930c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Function2<? super Path, ? super IOException, ? extends FileVisitResult> f43931d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f43932e;

    private final void f() {
        if (this.f43932e) {
            throw new IllegalStateException("This builder was already built");
        }
    }

    private final void g(Object obj, String str) {
        if (obj == null) {
            return;
        }
        throw new IllegalStateException(str + " was already defined");
    }

    @Override // kotlin.io.path.r
    public void a(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.g0.p(function, "function");
        f();
        g(this.f43931d, "onPostVisitDirectory");
        this.f43931d = function;
    }

    @Override // kotlin.io.path.r
    public void b(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.g0.p(function, "function");
        f();
        g(this.f43929b, "onVisitFile");
        this.f43929b = function;
    }

    @Override // kotlin.io.path.r
    public void c(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.g0.p(function, "function");
        f();
        g(this.f43928a, "onPreVisitDirectory");
        this.f43928a = function;
    }

    @Override // kotlin.io.path.r
    public void d(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        kotlin.jvm.internal.g0.p(function, "function");
        f();
        g(this.f43930c, "onVisitFileFailed");
        this.f43930c = function;
    }

    @NotNull
    public final FileVisitor<Path> e() {
        f();
        this.f43932e = true;
        return g.a(new u(this.f43928a, this.f43929b, this.f43930c, this.f43931d));
    }
}
