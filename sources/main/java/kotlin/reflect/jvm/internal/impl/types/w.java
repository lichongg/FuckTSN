package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nClassifierBasedTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassifierBasedTypeConstructor.kt\norg/jetbrains/kotlin/types/ClassifierBasedTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class w implements w1 {

    /* renamed from: a, reason: collision with root package name */
    private int f47360a;

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.f c();

    protected abstract boolean g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar);

    protected final boolean e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f first, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f second) {
        kotlin.jvm.internal.g0.p(first, "first");
        kotlin.jvm.internal.g0.p(second, "second");
        if (!kotlin.jvm.internal.g0.g(first.getName(), second.getName())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = first.b();
        for (kotlin.reflect.jvm.internal.impl.descriptors.k b7 = second.b(); b6 != null && b7 != null; b7 = b7.b()) {
            if (b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.f0) {
                return b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.f0;
            }
            if (b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.f0) {
                return false;
            }
            if (b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0) {
                return (b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0) && kotlin.jvm.internal.g0.g(((kotlin.reflect.jvm.internal.impl.descriptors.l0) b6).d(), ((kotlin.reflect.jvm.internal.impl.descriptors.l0) b7).d());
            }
            if ((b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0) || !kotlin.jvm.internal.g0.g(b6.getName(), b7.getName())) {
                return false;
            }
            b6 = b6.b();
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1) || obj.hashCode() != hashCode()) {
            return false;
        }
        w1 w1Var = (w1) obj;
        if (w1Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = c();
        kotlin.reflect.jvm.internal.impl.descriptors.f c7 = w1Var.c();
        if (c7 != null && f(c6) && f(c7)) {
            return g(c7);
        }
        return false;
    }

    public int hashCode() {
        int i6 = this.f47360a;
        if (i6 != 0) {
            return i6;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = c();
        int hashCode = f(c6) ? kotlin.reflect.jvm.internal.impl.resolve.i.m(c6).hashCode() : System.identityHashCode(this);
        this.f47360a = hashCode;
        return hashCode;
    }

    private final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        if (!kotlin.reflect.jvm.internal.impl.types.error.i.m(fVar) && !kotlin.reflect.jvm.internal.impl.resolve.i.E(fVar)) {
            return true;
        }
        return false;
    }
}
