package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaWildcardType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaWildcardType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaWildcardType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h0 extends e0 implements y3.c0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final WildcardType f45014b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Collection<y3.a> f45015c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f45016d;

    public h0(@NotNull WildcardType reflectType) {
        kotlin.jvm.internal.g0.p(reflectType, "reflectType");
        this.f45014b = reflectType;
        this.f45015c = kotlin.collections.f0.J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0
    @NotNull
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public WildcardType M() {
        return this.f45014b;
    }

    @Override // y3.d
    @NotNull
    public Collection<y3.a> getAnnotations() {
        return this.f45015c;
    }

    @Override // y3.d
    public boolean s() {
        return this.f45016d;
    }

    @Override // y3.c0
    public boolean J() {
        kotlin.jvm.internal.g0.o(M().getUpperBounds(), "getUpperBounds(...)");
        return !kotlin.jvm.internal.g0.g(kotlin.collections.n.Fc(r0), Object.class);
    }

    @Override // y3.c0
    @Nullable
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public e0 getBound() {
        Type[] upperBounds = M().getUpperBounds();
        Type[] lowerBounds = M().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                e0.a aVar = e0.f45001a;
                kotlin.jvm.internal.g0.m(lowerBounds);
                Object At = kotlin.collections.n.At(lowerBounds);
                kotlin.jvm.internal.g0.o(At, "single(...)");
                return aVar.a((Type) At);
            }
            if (upperBounds.length == 1) {
                kotlin.jvm.internal.g0.m(upperBounds);
                Type type = (Type) kotlin.collections.n.At(upperBounds);
                if (!kotlin.jvm.internal.g0.g(type, Object.class)) {
                    e0.a aVar2 = e0.f45001a;
                    kotlin.jvm.internal.g0.m(type);
                    return aVar2.a(type);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + M());
    }
}
