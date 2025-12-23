package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f45821a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final f f45822b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45823a;

        static {
            int[] iArr = new int[NullabilityQualifier.values().length];
            try {
                iArr[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f45823a = iArr;
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.c ENHANCED_NULLABILITY_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.i0.f45467v;
        kotlin.jvm.internal.g0.o(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        f45821a = new f(ENHANCED_NULLABILITY_ANNOTATION);
        kotlin.reflect.jvm.internal.impl.name.c ENHANCED_MUTABILITY_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.i0.f45468w;
        kotlin.jvm.internal.g0.o(ENHANCED_MUTABILITY_ANNOTATION, "ENHANCED_MUTABILITY_ANNOTATION");
        f45822b = new f(ENHANCED_MUTABILITY_ANNOTATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.f f(kotlin.reflect.jvm.internal.impl.descriptors.f fVar, h hVar, TypeComponentPosition typeComponentPosition) {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f44483a;
        if (!m1.a(typeComponentPosition) || !(fVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            return null;
        }
        if (hVar.e() == MutabilityQualifier.READ_ONLY && typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) fVar;
            if (dVar.c(dVar2)) {
                return dVar.a(dVar2);
            }
        }
        if (hVar.e() == MutabilityQualifier.MUTABLE && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar3 = (kotlin.reflect.jvm.internal.impl.descriptors.d) fVar;
            if (dVar.d(dVar3)) {
                return dVar.b(dVar3);
            }
        }
        return null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g g() {
        return f45821a;
    }

    public static final boolean i(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        return p1.c(kotlin.reflect.jvm.internal.impl.types.checker.u.f47196a, t0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g e(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.g> list) {
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.n((List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.g>) kotlin.collections.f0.a6(list));
            }
            return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) kotlin.collections.f0.m5(list);
        }
        throw new IllegalStateException("At least one Annotations object expected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean h(h hVar, TypeComponentPosition typeComponentPosition) {
        int i6;
        if (!m1.a(typeComponentPosition)) {
            return null;
        }
        NullabilityQualifier f6 = hVar.f();
        if (f6 == null) {
            i6 = -1;
        } else {
            i6 = a.f45823a[f6.ordinal()];
        }
        if (i6 != 1) {
            if (i6 != 2) {
                return null;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
