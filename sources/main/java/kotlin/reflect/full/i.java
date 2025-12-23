package kotlin.reflect.full;

import e4.l;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.z2;
import kotlin.reflect.r;
import kotlin.reflect.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KClassifiers")
@SourceDebugExtension({"SMAP\nKClassifiers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassifiers.kt\nkotlin/reflect/full/KClassifiers\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1573#2:98\n1604#2,4:99\n1563#2:103\n1634#2,3:104\n*S KotlinDebug\n*F\n+ 1 KClassifiers.kt\nkotlin/reflect/full/KClassifiers\n*L\n69#1:98\n69#1:99,4\n95#1:103\n95#1:104,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44232a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f44232a = iArr;
        }
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final r b(@NotNull kotlin.reflect.g gVar, @NotNull List<t> arguments, boolean z5, @NotNull List<? extends Annotation> annotations) {
        kotlin.reflect.jvm.internal.impl.descriptors.f d6;
        g0.p(gVar, "<this>");
        g0.p(arguments, "arguments");
        g0.p(annotations, "annotations");
        Function0 function0 = null;
        byte b6 = 0;
        d1 d1Var = gVar instanceof d1 ? (d1) gVar : null;
        if (d1Var == null || (d6 = d1Var.d()) == null) {
            throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + gVar + " (" + gVar.getClass() + ')');
        }
        w1 o5 = d6.o();
        g0.o(o5, "getTypeConstructor(...)");
        List<j1> parameters = o5.getParameters();
        g0.o(parameters, "getParameters(...)");
        if (parameters.size() == arguments.size()) {
            return new z2(a(annotations.isEmpty() ? t1.f47332b.k() : t1.f47332b.k(), o5, arguments, z5), function0, 2, b6 == true ? 1 : 0);
        }
        throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
    }

    public static /* synthetic */ r c(kotlin.reflect.g gVar, List list, boolean z5, List list2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            list = f0.J();
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            list2 = f0.J();
        }
        return b(gVar, list, z5, list2);
    }

    @NotNull
    public static final r d(@NotNull kotlin.reflect.g gVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f d6;
        g0.p(gVar, "<this>");
        d1 d1Var = gVar instanceof d1 ? (d1) gVar : null;
        if (d1Var == null || (d6 = d1Var.d()) == null) {
            return c(gVar, null, false, null, 7, null);
        }
        List<j1> parameters = d6.o().getParameters();
        g0.o(parameters, "getParameters(...)");
        if (parameters.isEmpty()) {
            return c(gVar, null, false, null, 7, null);
        }
        List<j1> list = parameters;
        ArrayList arrayList = new ArrayList(f0.d0(list, 10));
        for (j1 j1Var : list) {
            arrayList.add(t.f47635c.c());
        }
        return c(gVar, arrayList, false, null, 6, null);
    }

    private static final e1 a(t1 t1Var, w1 w1Var, List<t> list, boolean z5) {
        t0 t0Var;
        int i6;
        l l1Var;
        List<j1> parameters = w1Var.getParameters();
        g0.o(parameters, "getParameters(...)");
        List<t> list2 = list;
        ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
        int i7 = 0;
        for (Object obj : list2) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                f0.b0();
            }
            t tVar = (t) obj;
            z2 z2Var = (z2) tVar.getType();
            if (z2Var != null) {
                t0Var = z2Var.getType();
            } else {
                t0Var = null;
            }
            KVariance g6 = tVar.g();
            if (g6 == null) {
                i6 = -1;
            } else {
                i6 = a.f44232a[g6.ordinal()];
            }
            if (i6 != -1) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            Variance variance = Variance.OUT_VARIANCE;
                            g0.m(t0Var);
                            l1Var = new e2(variance, t0Var);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        Variance variance2 = Variance.IN_VARIANCE;
                        g0.m(t0Var);
                        l1Var = new e2(variance2, t0Var);
                    }
                } else {
                    Variance variance3 = Variance.INVARIANT;
                    g0.m(t0Var);
                    l1Var = new e2(variance3, t0Var);
                }
            } else {
                j1 j1Var = parameters.get(i7);
                g0.o(j1Var, "get(...)");
                l1Var = new l1(j1Var);
            }
            arrayList.add(l1Var);
            i7 = i8;
        }
        return w0.m(t1Var, w1Var, arrayList, z5, null, 16, null);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void e(kotlin.reflect.g gVar) {
    }
}
