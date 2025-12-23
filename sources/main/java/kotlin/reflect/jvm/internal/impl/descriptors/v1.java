package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class v1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f45056a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f45057b;

    protected v1(@NotNull String name, boolean z5) {
        kotlin.jvm.internal.g0.p(name, "name");
        this.f45056a = name;
        this.f45057b = z5;
    }

    @Nullable
    public Integer a(@NotNull v1 visibility) {
        kotlin.jvm.internal.g0.p(visibility, "visibility");
        return u1.f45044a.a(this, visibility);
    }

    @NotNull
    public String b() {
        return this.f45056a;
    }

    public final boolean c() {
        return this.f45057b;
    }

    @NotNull
    public final String toString() {
        return b();
    }

    @NotNull
    public v1 d() {
        return this;
    }
}
