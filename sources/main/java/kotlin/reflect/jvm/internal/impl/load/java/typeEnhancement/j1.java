package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1563#2:297\n1634#2,3:298\n1563#2:301\n1634#2,3:302\n1563#2:306\n1634#2,3:307\n1761#2,3:310\n1761#2,3:313\n1573#2:316\n1604#2,4:317\n1563#2:321\n1634#2,3:322\n1563#2:325\n1634#2,3:326\n1#3:305\n*S KotlinDebug\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n*L\n55#1:297\n55#1:298,3\n66#1:301\n66#1:302,3\n123#1:306\n123#1:307,3\n144#1:310,3\n150#1:313,3\n156#1:316\n156#1:317,4\n170#1:321\n170#1:322,3\n220#1:325\n220#1:326,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final g f45795a;

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0225, code lost:
    
        if (r3 == null) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ff A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D l(D r18, kotlin.reflect.jvm.internal.impl.load.java.lazy.k r19) {
        /*
            Method dump skipped, instructions count: 647
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j1.l(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.k):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    public j1(@NotNull g typeEnhancement) {
        kotlin.jvm.internal.g0.p(typeEnhancement, "typeEnhancement");
        this.f45795a = typeEnhancement;
    }

    private final boolean f(kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        return j2.c(t0Var, i1.f45790a);
    }

    private final kotlin.reflect.jvm.internal.impl.types.t0 h(CallableMemberDescriptor callableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z5, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, n1 n1Var, boolean z6, Function1<? super CallableMemberDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.t0> function1) {
        l1 l1Var = new l1(aVar, z5, kVar, annotationQualifierApplicabilityType, false, 16, null);
        kotlin.reflect.jvm.internal.impl.types.t0 invoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> e6 = callableMemberDescriptor.e();
        kotlin.jvm.internal.g0.o(e6, "getOverriddenDescriptors(...)");
        Collection<? extends CallableMemberDescriptor> collection = e6;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(collection, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            kotlin.jvm.internal.g0.m(callableMemberDescriptor2);
            arrayList.add(function1.invoke(callableMemberDescriptor2));
        }
        return i(l1Var, invoke, arrayList, n1Var, z6);
    }

    private final kotlin.reflect.jvm.internal.impl.types.t0 i(l1 l1Var, kotlin.reflect.jvm.internal.impl.types.t0 t0Var, List<? extends kotlin.reflect.jvm.internal.impl.types.t0> list, n1 n1Var, boolean z5) {
        return this.f45795a.a(t0Var, l1Var.d(t0Var, list, n1Var, z5), l1Var.z());
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.t0 j(j1 j1Var, CallableMemberDescriptor callableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z5, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, n1 n1Var, boolean z6, Function1 function1, int i6, Object obj) {
        return j1Var.h(callableMemberDescriptor, aVar, z5, kVar, annotationQualifierApplicabilityType, n1Var, (i6 & 32) != 0 ? false : z6, function1);
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.t0 k(j1 j1Var, l1 l1Var, kotlin.reflect.jvm.internal.impl.types.t0 t0Var, List list, n1 n1Var, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            n1Var = null;
        }
        return j1Var.i(l1Var, t0Var, list, n1Var, (i6 & 8) != 0 ? false : z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.t0 m(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = it.getReturnType();
        kotlin.jvm.internal.g0.m(returnType);
        return returnType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.t0 n(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        kotlin.reflect.jvm.internal.impl.descriptors.z0 f02 = it.f0();
        kotlin.jvm.internal.g0.m(f02);
        kotlin.reflect.jvm.internal.impl.types.t0 type = f02.getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.t0 o(q1 q1Var, CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        kotlin.reflect.jvm.internal.impl.types.t0 type = it.g().get(q1Var.getIndex()).getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(m2 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it instanceof kotlin.reflect.jvm.internal.impl.types.d1;
    }

    private final kotlin.reflect.jvm.internal.impl.types.t0 t(CallableMemberDescriptor callableMemberDescriptor, q1 q1Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, n1 n1Var, boolean z5, Function1<? super CallableMemberDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.t0> function1) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.k k6;
        return h(callableMemberDescriptor, q1Var, false, (q1Var == null || (k6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.k(kVar, q1Var.getAnnotations())) == null) ? kVar : k6, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, n1Var, z5, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> p(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull Collection<? extends D> platformSignatures) {
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(platformSignatures, "platformSignatures");
        Collection<? extends D> collection = platformSignatures;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(l((CallableMemberDescriptor) it.next(), c6));
        }
        return arrayList;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.t0 q(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 type, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k context) {
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.jvm.internal.g0.p(context, "context");
        kotlin.reflect.jvm.internal.impl.types.t0 k6 = k(this, new l1(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true), type, kotlin.collections.f0.J(), null, false, 12, null);
        return k6 == null ? type : k6;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.types.t0> r(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 typeParameter, @NotNull List<? extends kotlin.reflect.jvm.internal.impl.types.t0> bounds, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k context) {
        kotlin.reflect.jvm.internal.impl.types.t0 t0Var;
        kotlin.reflect.jvm.internal.impl.types.t0 k6;
        kotlin.jvm.internal.g0.p(typeParameter, "typeParameter");
        kotlin.jvm.internal.g0.p(bounds, "bounds");
        kotlin.jvm.internal.g0.p(context, "context");
        List<? extends kotlin.reflect.jvm.internal.impl.types.t0> list = bounds;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        for (kotlin.reflect.jvm.internal.impl.types.t0 t0Var2 : list) {
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.e.f(t0Var2, h1.f45787a)) {
                t0Var = t0Var2;
            } else {
                t0Var = t0Var2;
                k6 = k(this, new l1(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), t0Var, kotlin.collections.f0.J(), null, false, 12, null);
                if (k6 != null) {
                    arrayList.add(k6);
                }
            }
            k6 = t0Var;
            arrayList.add(k6);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean g(m2 m2Var) {
        boolean z5;
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = m2Var.I0().c();
        if (c6 == null) {
            return Boolean.FALSE;
        }
        kotlin.reflect.jvm.internal.impl.name.f name = c6.getName();
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a;
        if (kotlin.jvm.internal.g0.g(name, cVar.h().f()) && kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.k(c6), cVar.h())) {
            z5 = true;
        } else {
            z5 = false;
        }
        return Boolean.valueOf(z5);
    }

    private final <D extends CallableMemberDescriptor> kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u(D d6, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n nVar;
        kotlin.reflect.jvm.internal.impl.descriptors.f a6 = kotlin.reflect.jvm.internal.impl.descriptors.q.a(d6);
        if (a6 == null) {
            return d6.getAnnotations();
        }
        List<y3.a> list = null;
        if (a6 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n) {
            nVar = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n) a6;
        } else {
            nVar = null;
        }
        if (nVar != null) {
            list = nVar.O0();
        }
        List<y3.a> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            List<y3.a> list3 = list;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j(kVar, (y3.a) it.next(), true));
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(kotlin.collections.f0.E4(d6.getAnnotations(), arrayList));
        }
        return d6.getAnnotations();
    }
}
