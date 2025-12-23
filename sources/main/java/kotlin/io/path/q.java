package kotlin.io.path;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    private final int f43924a;

    /* renamed from: b, reason: collision with root package name */
    private int f43925b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<Exception> f43926c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Path f43927d;

    public q() {
        this(0, 1, null);
    }

    public q(int i6) {
        this.f43924a = i6;
        this.f43926c = new ArrayList();
    }

    public final void a(@NotNull Exception exception) {
        Throwable initCause;
        kotlin.jvm.internal.g0.p(exception, "exception");
        this.f43925b++;
        if (this.f43926c.size() < this.f43924a) {
            if (this.f43927d != null) {
                p.a();
                initCause = o.a(String.valueOf(this.f43927d)).initCause(exception);
                kotlin.jvm.internal.g0.n(initCause, "null cannot be cast to non-null type java.nio.file.FileSystemException");
                exception = n.a(initCause);
            }
            this.f43926c.add(exception);
        }
    }

    public final void b(@NotNull Path name) {
        kotlin.jvm.internal.g0.p(name, "name");
        Path path = this.f43927d;
        this.f43927d = path != null ? path.resolve(name) : null;
    }

    public final void c(@NotNull Path name) {
        kotlin.jvm.internal.g0.p(name, "name");
        Path path = this.f43927d;
        if (!kotlin.jvm.internal.g0.g(name, path != null ? path.getFileName() : null)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Path path2 = this.f43927d;
        this.f43927d = path2 != null ? path2.getParent() : null;
    }

    @NotNull
    public final List<Exception> d() {
        return this.f43926c;
    }

    @Nullable
    public final Path e() {
        return this.f43927d;
    }

    public final int f() {
        return this.f43925b;
    }

    public final void g(@Nullable Path path) {
        this.f43927d = path;
    }

    public /* synthetic */ q(int i6, int i7, kotlin.jvm.internal.v vVar) {
        this((i7 & 1) != 0 ? 64 : i6);
    }
}
