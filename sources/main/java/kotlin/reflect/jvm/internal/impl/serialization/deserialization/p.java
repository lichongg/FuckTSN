package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeserializedClassDataFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDataFinder.kt\norg/jetbrains/kotlin/serialization/deserialization/DeserializedClassDataFinder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p implements i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.m0 f47051a;

    public p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m0 packageFragmentProvider) {
        kotlin.jvm.internal.g0.p(packageFragmentProvider, "packageFragmentProvider");
        this.f47051a = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.i
    @Nullable
    public h a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        h a6;
        kotlin.jvm.internal.g0.p(classId, "classId");
        for (kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var : kotlin.reflect.jvm.internal.impl.descriptors.q0.c(this.f47051a, classId.f())) {
            if ((l0Var instanceof q) && (a6 = ((q) l0Var).E0().a(classId)) != null) {
                return a6;
            }
        }
        return null;
    }
}
