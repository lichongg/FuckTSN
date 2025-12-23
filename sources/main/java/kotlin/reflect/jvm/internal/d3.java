package kotlin.reflect.jvm.internal;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMetadataUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MetadataUtil.kt\nkotlin/reflect/jvm/internal/MetadataUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,30:1\n1#2:31\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d3 {
    @Nullable
    public static final kotlin.reflect.d<?> a(@NotNull ClassLoader classLoader, @NotNull String name) {
        kotlin.jvm.internal.g0.p(classLoader, "<this>");
        kotlin.jvm.internal.g0.p(name, "name");
        Class q5 = p3.q(classLoader, b(name), 0, 2, null);
        if (q5 != null) {
            return l3.a.i(q5);
        }
        return null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.b b(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        boolean H2 = kotlin.text.u.H2(str, ".", false, 2, null);
        if (H2) {
            str = str.substring(1);
            kotlin.jvm.internal.g0.o(str, "substring(...)");
        }
        return new kotlin.reflect.jvm.internal.impl.name.b(new kotlin.reflect.jvm.internal.impl.name.c(kotlin.text.u.w2(kotlin.text.u.T5(str, '/', ""), '/', '.', false, 4, null)), new kotlin.reflect.jvm.internal.impl.name.c(kotlin.text.u.N5(str, '/', null, 2, null)), H2);
    }

    @NotNull
    public static final String c(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<this>");
        if (!kotlin.text.u.H2(str, ".", false, 2, null)) {
            return kotlin.text.u.N5(kotlin.text.u.N5(str, '/', null, 2, null), '.', null, 2, null);
        }
        throw new IllegalArgumentException(("Local class is not supported: " + str).toString());
    }
}
