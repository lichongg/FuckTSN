package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.b2;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f extends h0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45713a;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f45713a = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.h0
    @NotNull
    public c2 a(@NotNull j1 parameter, @NotNull i0 typeAttr, @NotNull b2 typeParameterUpperBoundEraser, @NotNull t0 erasedUpperBound) {
        g0.p(parameter, "parameter");
        g0.p(typeAttr, "typeAttr");
        g0.p(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        g0.p(erasedUpperBound, "erasedUpperBound");
        if (!(typeAttr instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a)) {
            return super.a(parameter, typeAttr, typeParameterUpperBoundEraser, erasedUpperBound);
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a) typeAttr;
        if (!aVar.i()) {
            aVar = aVar.l(JavaTypeFlexibility.INFLEXIBLE);
        }
        int i6 = a.f45713a[aVar.g().ordinal()];
        if (i6 == 1) {
            return new e2(Variance.INVARIANT, erasedUpperBound);
        }
        if (i6 != 2 && i6 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (!parameter.l().getAllowsOutPosition()) {
            return new e2(Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(parameter).I());
        }
        List<j1> parameters = erasedUpperBound.I0().getParameters();
        g0.o(parameters, "getParameters(...)");
        if (!parameters.isEmpty()) {
            return new e2(Variance.OUT_VARIANCE, erasedUpperBound);
        }
        c2 t5 = j2.t(parameter, aVar);
        g0.m(t5);
        return t5;
    }
}
