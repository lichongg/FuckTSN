package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m0 implements s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f44025a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f44026b;

    public m0(@NotNull Class<?> jClass, @NotNull String moduleName) {
        g0.p(jClass, "jClass");
        g0.p(moduleName, "moduleName");
        this.f44025a = jClass;
        this.f44026b = moduleName;
    }

    @Override // kotlin.jvm.internal.s
    @NotNull
    public Class<?> c() {
        return this.f44025a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof m0) && g0.g(c(), ((m0) obj).c());
    }

    @Override // kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> o() {
        throw new KotlinReflectionNotSupportedError();
    }

    @NotNull
    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }

    public int hashCode() {
        return c().hashCode();
    }
}
