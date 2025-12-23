package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Path f43956a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Object f43957b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final x f43958c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Iterator<x> f43959d;

    public x(@NotNull Path path, @Nullable Object obj, @Nullable x xVar) {
        kotlin.jvm.internal.g0.p(path, "path");
        this.f43956a = path;
        this.f43957b = obj;
        this.f43958c = xVar;
    }

    @Nullable
    public final Iterator<x> a() {
        return this.f43959d;
    }

    @Nullable
    public final Object b() {
        return this.f43957b;
    }

    @Nullable
    public final x c() {
        return this.f43958c;
    }

    @NotNull
    public final Path d() {
        return this.f43956a;
    }

    public final void e(@Nullable Iterator<x> it) {
        this.f43959d = it;
    }
}
