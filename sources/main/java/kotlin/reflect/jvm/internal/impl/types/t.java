package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t extends r1<t> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f47330a;

    public t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        this.f47330a = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r1
    @NotNull
    public kotlin.reflect.d<? extends t> b() {
        return kotlin.jvm.internal.o0.d(t.class);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r1
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public t a(@Nullable t tVar) {
        return tVar == null ? this : new t(kotlin.reflect.jvm.internal.impl.descriptors.annotations.i.a(this.f47330a, tVar.f47330a));
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g e() {
        return this.f47330a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof t) {
            return kotlin.jvm.internal.g0.g(((t) obj).f47330a, this.f47330a);
        }
        return false;
    }

    public int hashCode() {
        return this.f47330a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r1
    @Nullable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public t c(@Nullable t tVar) {
        if (kotlin.jvm.internal.g0.g(tVar, this)) {
            return this;
        }
        return null;
    }
}
