package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nfindClassInModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n1#1,66:1\n43#1,2:67\n*S KotlinDebug\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n23#1:67,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x {
    @Nullable
    public static final d b(@NotNull f0 f0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.g0.p(f0Var, "<this>");
        kotlin.jvm.internal.g0.p(classId, "classId");
        f c6 = c(f0Var, classId);
        if (c6 instanceof d) {
            return (d) c6;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.f c(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 r6, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.b r7) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.x.c(kotlin.reflect.jvm.internal.impl.descriptors.f0, kotlin.reflect.jvm.internal.impl.name.b):kotlin.reflect.jvm.internal.impl.descriptors.f");
    }

    @NotNull
    public static final d d(@NotNull f0 f0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull k0 notFoundClasses) {
        kotlin.jvm.internal.g0.p(f0Var, "<this>");
        kotlin.jvm.internal.g0.p(classId, "classId");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        d b6 = b(f0Var, classId);
        return b6 != null ? b6 : notFoundClasses.d(classId, kotlin.sequences.p.I3(kotlin.sequences.p.N1(kotlin.sequences.p.t(classId, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.x.a
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return ((kotlin.reflect.jvm.internal.impl.name.b) obj).e();
            }
        }), w.f45058a)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(kotlin.reflect.jvm.internal.impl.name.b it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return 0;
    }

    @Nullable
    public static final i1 f(@NotNull f0 f0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.g0.p(f0Var, "<this>");
        kotlin.jvm.internal.g0.p(classId, "classId");
        f c6 = c(f0Var, classId);
        if (c6 instanceof i1) {
            return (i1) c6;
        }
        return null;
    }
}
