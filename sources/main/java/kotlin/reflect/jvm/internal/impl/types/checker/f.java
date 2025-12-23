package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.k0;
import kotlin.reflect.jvm.internal.impl.types.l2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKotlinTypePreparator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 5 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt$transformComponents$1\n*L\n1#1,76:1\n1#2:77\n1563#3:78\n1634#3,3:79\n1563#3:82\n1634#3,3:83\n1563#3:92\n1634#3,2:93\n1636#3:102\n98#4,6:86\n104#4:95\n105#4,5:97\n112#4,7:103\n99#5:96\n*S KotlinDebug\n*F\n+ 1 KotlinTypePreparator.kt\norg/jetbrains/kotlin/types/checker/KotlinTypePreparator\n*L\n27#1:78\n27#1:79,3\n37#1:82\n37#1:83,3\n48#1:92\n48#1:93,2\n48#1:102\n48#1:86,6\n48#1:95\n48#1:97,5\n48#1:103,7\n48#1:96\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class f extends kotlin.reflect.jvm.internal.impl.types.r {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<e4.g, m2> {
        b(Object obj) {
            super(1, obj, f.class, "prepareType", "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final m2 invoke(e4.g p02) {
            g0.p(p02, "p0");
            return ((f) this.receiver).a(p02);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends f {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f47169a = new a();

        private a() {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m2 a(@NotNull e4.g type) {
        m2 e6;
        g0.p(type, "type");
        if (!(type instanceof t0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        m2 L0 = ((t0) type).L0();
        if (L0 instanceof e1) {
            e6 = c((e1) L0);
        } else {
            if (!(L0 instanceof k0)) {
                throw new NoWhenBranchMatchedException();
            }
            k0 k0Var = (k0) L0;
            e1 c6 = c(k0Var.Q0());
            e1 c7 = c(k0Var.R0());
            e6 = (c6 == k0Var.Q0() && c7 == k0Var.R0()) ? L0 : w0.e(c6, c7);
        }
        return l2.c(e6, L0, new b(this));
    }

    private final e1 c(e1 e1Var) {
        t0 type;
        w1 I0 = e1Var.I0();
        s0 s0Var = null;
        r3 = null;
        m2 m2Var = null;
        t0 t0Var = null;
        if (I0 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c) {
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c cVar = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c) I0;
            c2 projection = cVar.getProjection();
            if (projection.c() != Variance.IN_VARIANCE) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                m2Var = type.L0();
            }
            m2 m2Var2 = m2Var;
            if (cVar.f() == null) {
                c2 projection2 = cVar.getProjection();
                Collection<t0> i6 = cVar.i();
                ArrayList arrayList = new ArrayList(f0.d0(i6, 10));
                Iterator<T> it = i6.iterator();
                while (it.hasNext()) {
                    arrayList.add(((t0) it.next()).L0());
                }
                cVar.h(new n(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            n f6 = cVar.f();
            g0.m(f6);
            return new i(captureStatus, f6, m2Var2, e1Var.H0(), e1Var.J0(), false, 32, null);
        }
        boolean z5 = false;
        if (I0 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.s) {
            Collection<t0> i7 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.s) I0).i();
            ArrayList arrayList2 = new ArrayList(f0.d0(i7, 10));
            Iterator<T> it2 = i7.iterator();
            while (it2.hasNext()) {
                t0 p5 = j2.p((t0) it2.next(), e1Var.J0());
                g0.o(p5, "makeNullableAsSpecified(...)");
                arrayList2.add(p5);
            }
            return w0.o(e1Var.H0(), new s0(arrayList2), f0.J(), false, e1Var.r());
        }
        if ((I0 instanceof s0) && e1Var.J0()) {
            s0 s0Var2 = (s0) I0;
            Collection<t0> i8 = s0Var2.i();
            ArrayList arrayList3 = new ArrayList(f0.d0(i8, 10));
            Iterator<T> it3 = i8.iterator();
            while (it3.hasNext()) {
                arrayList3.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.C((t0) it3.next()));
                z5 = true;
            }
            if (z5) {
                t0 l6 = s0Var2.l();
                if (l6 != null) {
                    t0Var = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.C(l6);
                }
                s0Var = new s0(arrayList3).s(t0Var);
            }
            if (s0Var != null) {
                s0Var2 = s0Var;
            }
            return s0Var2.j();
        }
        return e1Var;
    }
}
