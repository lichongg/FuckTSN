package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.v1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/load/java/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,49:1\n1#2:50\n12637#3,2:51\n*S KotlinDebug\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/load/java/UtilsKt\n*L\n47#1:51,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0 {
    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull y3.c0 wildcardType) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar;
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(wildcardType, "wildcardType");
        if (wildcardType.getBound() == null) {
            throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported");
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = new kotlin.reflect.jvm.internal.impl.load.java.lazy.g(c6, wildcardType, false, 4, null).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            cVar = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar2 = cVar;
            for (kotlin.reflect.jvm.internal.impl.name.c cVar3 : a0.e()) {
                if (kotlin.jvm.internal.g0.g(cVar2.d(), cVar3)) {
                    break loop0;
                }
            }
        }
        return cVar;
    }

    public static final boolean b(@NotNull CallableMemberDescriptor memberDescriptor) {
        kotlin.jvm.internal.g0.p(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && kotlin.jvm.internal.g0.g(memberDescriptor.N(kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.H), Boolean.TRUE);
    }

    public static final boolean c(@NotNull d0 javaTypeEnhancementState) {
        kotlin.jvm.internal.g0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.b().invoke(a0.d()) == ReportLevel.STRICT;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s d(@NotNull v1 v1Var) {
        kotlin.jvm.internal.g0.p(v1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.s g6 = x.g(v1Var);
        kotlin.jvm.internal.g0.o(g6, "toDescriptorVisibility(...)");
        return g6;
    }
}
