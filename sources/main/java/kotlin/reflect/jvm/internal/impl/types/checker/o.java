package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1#2:291\n1#2:310\n1669#3,8:292\n1617#3,9:300\n1869#3:309\n1870#3:311\n1626#3:312\n1740#3,3:313\n1563#3:316\n1634#3,3:317\n1634#3,3:320\n1563#3:323\n1634#3,3:324\n*S KotlinDebug\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeKt\n*L\n122#1:310\n117#1:292,8\n122#1:300,9\n122#1:309\n122#1:311\n122#1:312\n154#1:313,3\n156#1:316\n156#1:317,3\n176#1:320,3\n81#1:323\n81#1:324,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {
    @Nullable
    public static final e1 b(@NotNull e1 type, @NotNull CaptureStatus status) {
        g0.p(type, "type");
        g0.p(status, "status");
        List<c2> a6 = a(type, status);
        if (a6 != null) {
            return c(type, a6);
        }
        return null;
    }

    private static final List<c2> a(m2 m2Var, CaptureStatus captureStatus) {
        m2 m2Var2;
        if (m2Var.G0().size() != m2Var.I0().getParameters().size()) {
            return null;
        }
        List<c2> G0 = m2Var.G0();
        List<c2> list = G0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((c2) it.next()).c() != Variance.INVARIANT) {
                    List<j1> parameters = m2Var.I0().getParameters();
                    g0.o(parameters, "getParameters(...)");
                    List<Pair> o6 = f0.o6(list, parameters);
                    ArrayList arrayList = new ArrayList(f0.d0(o6, 10));
                    for (Pair pair : o6) {
                        c2 c2Var = (c2) pair.component1();
                        j1 j1Var = (j1) pair.component2();
                        if (c2Var.c() != Variance.INVARIANT) {
                            if (!c2Var.b() && c2Var.c() == Variance.IN_VARIANCE) {
                                m2Var2 = c2Var.getType().L0();
                            } else {
                                m2Var2 = null;
                            }
                            g0.m(j1Var);
                            c2Var = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e(new i(captureStatus, m2Var2, c2Var, j1Var));
                        }
                        arrayList.add(c2Var);
                    }
                    h2 c6 = x1.f47366c.b(m2Var.I0(), arrayList).c();
                    int size = G0.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        c2 c2Var2 = G0.get(i6);
                        c2 c2Var3 = (c2) arrayList.get(i6);
                        if (c2Var2.c() != Variance.INVARIANT) {
                            List<t0> upperBounds = m2Var.I0().getParameters().get(i6).getUpperBounds();
                            g0.o(upperBounds, "getUpperBounds(...)");
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(f.a.f47169a.a(c6.n((t0) it2.next(), Variance.INVARIANT).L0()));
                            }
                            if (!c2Var2.b() && c2Var2.c() == Variance.OUT_VARIANCE) {
                                arrayList2.add(f.a.f47169a.a(c2Var2.getType().L0()));
                            }
                            t0 type = c2Var3.getType();
                            g0.n(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            ((i) type).I0().n(arrayList2);
                        }
                    }
                    return arrayList;
                }
            }
        }
        return null;
    }

    private static final e1 c(m2 m2Var, List<? extends c2> list) {
        return w0.m(m2Var.H0(), m2Var.I0(), list, m2Var.J0(), null, 16, null);
    }
}
