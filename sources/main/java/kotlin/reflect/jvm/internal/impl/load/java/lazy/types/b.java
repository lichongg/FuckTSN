package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTypeAttributes.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeAttributesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    @NotNull
    public static final a a(@NotNull TypeUsage typeUsage, boolean z5, boolean z6, @Nullable j1 j1Var) {
        g0.p(typeUsage, "<this>");
        return new a(typeUsage, null, z6, z5, j1Var != null ? u1.f(j1Var) : null, null, 34, null);
    }

    public static /* synthetic */ a b(TypeUsage typeUsage, boolean z5, boolean z6, j1 j1Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        if ((i6 & 2) != 0) {
            z6 = false;
        }
        if ((i6 & 4) != 0) {
            j1Var = null;
        }
        return a(typeUsage, z5, z6, j1Var);
    }
}
