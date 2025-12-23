package kotlin.reflect.jvm.internal.impl.builtins;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nsuspendFunctionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 suspendFunctionTypes.kt\norg/jetbrains/kotlin/builtins/SuspendFunctionTypesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1563#2:66\n1634#2,3:67\n1#3:70\n*S KotlinDebug\n*F\n+ 1 suspendFunctionTypes.kt\norg/jetbrains/kotlin/builtins/SuspendFunctionTypesKt\n*L\n54#1:66\n54#1:67,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final g0 f44635a;

    static {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.p pVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.p(kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.i(), o.f44575s);
        ClassKind classKind = ClassKind.INTERFACE;
        kotlin.reflect.jvm.internal.impl.name.f f6 = o.f44579w.f();
        e1 e1Var = e1.f44683a;
        kotlin.reflect.jvm.internal.impl.storage.n nVar = kotlin.reflect.jvm.internal.impl.storage.f.f47092e;
        g0 g0Var = new g0(pVar, classKind, false, false, f6, e1Var, nVar);
        g0Var.H0(Modality.ABSTRACT);
        g0Var.J0(r.f44948e);
        g0Var.I0(f0.l(t0.M0(g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), false, Variance.IN_VARIANCE, kotlin.reflect.jvm.internal.impl.name.f.h(ExifInterface.GPS_DIRECTION_TRUE), 0, nVar)));
        g0Var.F0();
        f44635a = g0Var;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.e1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 suspendFunType) {
        kotlin.reflect.jvm.internal.impl.types.e1 b6;
        kotlin.jvm.internal.g0.p(suspendFunType, "suspendFunType");
        i.r(suspendFunType);
        j o5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(suspendFunType);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = suspendFunType.getAnnotations();
        kotlin.reflect.jvm.internal.impl.types.t0 k6 = i.k(suspendFunType);
        List<kotlin.reflect.jvm.internal.impl.types.t0> e6 = i.e(suspendFunType);
        List<c2> m6 = i.m(suspendFunType);
        ArrayList arrayList = new ArrayList(f0.d0(m6, 10));
        Iterator<T> it = m6.iterator();
        while (it.hasNext()) {
            arrayList.add(((c2) it.next()).getType());
        }
        t1 k7 = t1.f47332b.k();
        w1 o6 = f44635a.o();
        kotlin.jvm.internal.g0.o(o6, "getTypeConstructor(...)");
        List J4 = f0.J4(arrayList, w0.m(k7, o6, f0.l(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e(i.l(suspendFunType))), false, null, 16, null));
        kotlin.reflect.jvm.internal.impl.types.e1 J = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(suspendFunType).J();
        kotlin.jvm.internal.g0.o(J, "getNullableAnyType(...)");
        b6 = i.b(o5, annotations, k6, e6, J4, null, J, (r17 & 128) != 0 ? false : false);
        return b6.M0(suspendFunType.J0());
    }
}
