package kotlin.reflect.jvm.internal.impl.resolve;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class OverridingUtil {

    /* renamed from: e, reason: collision with root package name */
    private static final List<ExternalOverridabilityCondition> f46632e = f0.a6(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));

    /* renamed from: f, reason: collision with root package name */
    public static final OverridingUtil f46633f;

    /* renamed from: g, reason: collision with root package name */
    private static final e.a f46634g;

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f46635h = false;

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f46636a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.f f46637b;

    /* renamed from: c, reason: collision with root package name */
    private final e.a f46638c;

    /* renamed from: d, reason: collision with root package name */
    private final Function2<t0, t0, Boolean> f46639d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class OverrideCompatibilityInfo {

        /* renamed from: c, reason: collision with root package name */
        private static final OverrideCompatibilityInfo f46640c = new OverrideCompatibilityInfo(Result.OVERRIDABLE, MonitorResult.SUCCESS);

        /* renamed from: a, reason: collision with root package name */
        private final Result f46641a;

        /* renamed from: b, reason: collision with root package name */
        private final String f46642b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = 2
                goto L1c
            L1b:
                r5 = 3
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.a(int):void");
        }

        public OverrideCompatibilityInfo(@NotNull Result result, @NotNull String str) {
            if (result == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f46641a = result;
            this.f46642b = str;
        }

        @NotNull
        public static OverrideCompatibilityInfo b(@NotNull String str) {
            if (str == null) {
                a(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo d(@NotNull String str) {
            if (str == null) {
                a(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo e() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = f46640c;
            if (overrideCompatibilityInfo == null) {
                a(0);
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public Result c() {
            Result result = this.f46641a;
            if (result == null) {
                a(5);
            }
            return result;
        }

        public String toString() {
            return this.f46641a + ": " + this.f46642b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements e.a {
        private static /* synthetic */ void b(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.e.a
        public boolean a(@NotNull w1 w1Var, @NotNull w1 w1Var2) {
            if (w1Var == null) {
                b(0);
            }
            if (w1Var2 == null) {
                b(1);
            }
            return w1Var.equals(w1Var2);
        }

        a() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<D> implements Function2<D, D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> {
        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/a;Lkotlin/reflect/jvm/internal/impl/descriptors/a;>; */
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair invoke(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            return new Pair(aVar, aVar2);
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements Function1<CallableMemberDescriptor, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.k f46643a;

        c(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            this.f46643a = kVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            boolean z5;
            if (callableMemberDescriptor.b() == this.f46643a) {
                z5 = true;
            } else {
                z5 = false;
            }
            return Boolean.valueOf(z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements Function1<CallableMemberDescriptor, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f46644a;

        e(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            this.f46644a = dVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            boolean z5 = false;
            if (!kotlin.reflect.jvm.internal.impl.descriptors.r.g(callableMemberDescriptor.getVisibility()) && kotlin.reflect.jvm.internal.impl.descriptors.r.h(callableMemberDescriptor, this.f46644a, false)) {
                z5 = true;
            }
            return Boolean.valueOf(z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g implements Function1<CallableMemberDescriptor, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f46645a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CallableMemberDescriptor f46646b;

        g(m mVar, CallableMemberDescriptor callableMemberDescriptor) {
            this.f46645a = mVar;
            this.f46646b = callableMemberDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n1 invoke(CallableMemberDescriptor callableMemberDescriptor) {
            this.f46645a.b(this.f46646b, callableMemberDescriptor);
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements Function1<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f implements Function1<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.a invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class h {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46647a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f46648b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f46649c;

        static {
            int[] iArr = new int[Modality.values().length];
            f46649c = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46649c[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46649c[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46649c[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            f46648b = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46648b[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f46648b[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            f46647a = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f46647a[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f46647a[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        a aVar = new a();
        f46634g = aVar;
        f46633f = new OverridingUtil(aVar, g.a.f47170a, f.a.f47169a, null);
    }

    private OverridingUtil(@NotNull e.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.f fVar, @Nullable Function2<t0, t0, Boolean> function2) {
        if (aVar == null) {
            a(5);
        }
        if (gVar == null) {
            a(6);
        }
        if (fVar == null) {
            a(7);
        }
        this.f46638c = aVar;
        this.f46636a = gVar;
        this.f46637b = fVar;
        this.f46639d = function2;
    }

    private static boolean A(@Nullable v0 v0Var, @Nullable v0 v0Var2) {
        if (v0Var == null || v0Var2 == null) {
            return true;
        }
        return H(v0Var, v0Var2);
    }

    public static boolean B(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if (aVar == null) {
            a(65);
        }
        if (aVar2 == null) {
            a(66);
        }
        t0 returnType = aVar.getReturnType();
        t0 returnType2 = aVar2.getReturnType();
        if (!H(aVar, aVar2)) {
            return false;
        }
        TypeCheckerState l6 = f46633f.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
        if (aVar instanceof y) {
            return G(aVar, returnType, aVar2, returnType2, l6);
        }
        if (!(aVar instanceof w0)) {
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        w0 w0Var = (w0) aVar;
        w0 w0Var2 = (w0) aVar2;
        if (A(w0Var.getSetter(), w0Var2.getSetter())) {
            return (w0Var.C() && w0Var2.C()) ? kotlin.reflect.jvm.internal.impl.types.h.f47257a.m(l6, returnType.L0(), returnType2.L0()) : (w0Var.C() || !w0Var2.C()) && G(aVar, returnType, aVar2, returnType2, l6);
        }
        return false;
    }

    private static boolean C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.a> collection) {
        if (aVar == null) {
            a(69);
        }
        if (collection == null) {
            a(70);
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.a> it = collection.iterator();
        while (it.hasNext()) {
            if (!B(aVar, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean G(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, @NotNull t0 t0Var2, @NotNull TypeCheckerState typeCheckerState) {
        if (aVar == null) {
            a(71);
        }
        if (t0Var == null) {
            a(72);
        }
        if (aVar2 == null) {
            a(73);
        }
        if (t0Var2 == null) {
            a(74);
        }
        if (typeCheckerState == null) {
            a(75);
        }
        return kotlin.reflect.jvm.internal.impl.types.h.f47257a.t(typeCheckerState, t0Var.L0(), t0Var2.L0());
    }

    private static boolean H(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar2) {
        if (oVar == null) {
            a(67);
        }
        if (oVar2 == null) {
            a(68);
        }
        Integer d6 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(oVar.getVisibility(), oVar2.getVisibility());
        return d6 == null || d6.intValue() >= 0;
    }

    public static boolean I(@NotNull c0 c0Var, @NotNull c0 c0Var2, boolean z5) {
        if (c0Var == null) {
            a(55);
        }
        if (c0Var2 == null) {
            a(56);
        }
        return !kotlin.reflect.jvm.internal.impl.descriptors.r.g(c0Var2.getVisibility()) && kotlin.reflect.jvm.internal.impl.descriptors.r.h(c0Var2, c0Var, z5);
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> boolean J(@NotNull D d6, @NotNull D d7, boolean z5, boolean z6) {
        if (d6 == null) {
            a(13);
        }
        if (d7 == null) {
            a(14);
        }
        if (!d6.equals(d7) && kotlin.reflect.jvm.internal.impl.resolve.g.f46707a.k(d6.a(), d7.a(), z5, z6)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a a6 = d7.a();
        Iterator it = i.d(d6).iterator();
        while (it.hasNext()) {
            if (kotlin.reflect.jvm.internal.impl.resolve.g.f46707a.k(a6, (kotlin.reflect.jvm.internal.impl.descriptors.a) it.next(), z5, z6)) {
                return true;
            }
        }
        return false;
    }

    public static void K(@NotNull CallableMemberDescriptor callableMemberDescriptor, @Nullable Function1<CallableMemberDescriptor, n1> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar;
        if (callableMemberDescriptor == null) {
            a(105);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.e()) {
            if (callableMemberDescriptor2.getVisibility() == kotlin.reflect.jvm.internal.impl.descriptors.r.f44950g) {
                K(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != kotlin.reflect.jvm.internal.impl.descriptors.r.f44950g) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.s h6 = h(callableMemberDescriptor);
        if (h6 == null) {
            if (function1 != null) {
                function1.invoke(callableMemberDescriptor);
            }
            sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e;
        } else {
            sVar = h6;
        }
        if (callableMemberDescriptor instanceof k0) {
            ((k0) callableMemberDescriptor).Y0(sVar);
            Iterator<v0> it = ((w0) callableMemberDescriptor).x().iterator();
            while (it.hasNext()) {
                K(it.next(), h6 == null ? null : function1);
            }
            return;
        }
        if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.s) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.s) callableMemberDescriptor).e1(sVar);
            return;
        }
        j0 j0Var = (j0) callableMemberDescriptor;
        j0Var.J0(sVar);
        if (sVar != j0Var.h0().getVisibility()) {
            j0Var.H0(false);
        }
    }

    @NotNull
    public static <H> H L(@NotNull Collection<H> collection, @NotNull Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.a> function1) {
        H h6;
        if (collection == null) {
            a(76);
        }
        if (function1 == null) {
            a(77);
        }
        if (collection.size() == 1) {
            H h7 = (H) f0.E2(collection);
            if (h7 == null) {
                a(78);
            }
            return h7;
        }
        ArrayList arrayList = new ArrayList(2);
        List C3 = f0.C3(collection, function1);
        H h8 = (H) f0.E2(collection);
        kotlin.reflect.jvm.internal.impl.descriptors.a invoke = function1.invoke(h8);
        for (H h9 : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.a invoke2 = function1.invoke(h9);
            if (C(invoke2, C3)) {
                arrayList.add(h9);
            }
            if (B(invoke2, invoke) && !B(invoke, invoke2)) {
                h8 = h9;
            }
        }
        if (arrayList.isEmpty()) {
            if (h8 == null) {
                a(79);
            }
            return h8;
        }
        if (arrayList.size() == 1) {
            H h10 = (H) f0.E2(arrayList);
            if (h10 == null) {
                a(80);
            }
            return h10;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                h6 = null;
                break;
            }
            h6 = (H) it.next();
            if (!n0.b(function1.invoke(h6).getReturnType())) {
                break;
            }
        }
        if (h6 != null) {
            return h6;
        }
        H h11 = (H) f0.E2(arrayList);
        if (h11 == null) {
            a(82);
        }
        return h11;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0255 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 1298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.a(int):void");
    }

    private static boolean b(@NotNull Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            a(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        return f0.A1(collection, new c(collection.iterator().next().b()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 r4, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 r5, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r6) {
        /*
            if (r4 != 0) goto L7
            r0 = 47
            a(r0)
        L7:
            if (r5 != 0) goto Le
            r0 = 48
            a(r0)
        Le:
            if (r6 != 0) goto L15
            r0 = 49
            a(r0)
        L15:
            java.util.List r4 = r4.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r5 = r5.getUpperBounds()
            r0.<init>(r5)
            int r5 = r4.size()
            int r1 = r0.size()
            r2 = 0
            if (r5 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r4 = r4.iterator()
        L32:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L59
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.t0 r5 = (kotlin.reflect.jvm.internal.impl.types.t0) r5
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.t0 r3 = (kotlin.reflect.jvm.internal.impl.types.t0) r3
            boolean r3 = d(r5, r3, r6)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.c(kotlin.reflect.jvm.internal.impl.descriptors.j1, kotlin.reflect.jvm.internal.impl.descriptors.j1, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState):boolean");
    }

    private static boolean d(@NotNull t0 t0Var, @NotNull t0 t0Var2, @NotNull TypeCheckerState typeCheckerState) {
        if (t0Var == null) {
            a(44);
        }
        if (t0Var2 == null) {
            a(45);
        }
        if (typeCheckerState == null) {
            a(46);
        }
        if (x0.a(t0Var) && x0.a(t0Var2)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.types.h.f47257a.m(typeCheckerState, t0Var.L0(), t0Var2.L0());
    }

    private static void f(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(17);
        }
        if (set == null) {
            a(18);
        }
        if (callableMemberDescriptor.h().isReal()) {
            set.add(callableMemberDescriptor);
            return;
        }
        if (callableMemberDescriptor.e().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
        Iterator<? extends CallableMemberDescriptor> it = callableMemberDescriptor.e().iterator();
        while (it.hasNext()) {
            f(it.next(), set);
        }
    }

    @Nullable
    private static kotlin.reflect.jvm.internal.impl.descriptors.s h(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(106);
        }
        Collection<? extends CallableMemberDescriptor> e6 = callableMemberDescriptor.e();
        kotlin.reflect.jvm.internal.impl.descriptors.s u5 = u(e6);
        if (u5 == null) {
            return null;
        }
        if (callableMemberDescriptor.h() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return u5.f();
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : e6) {
            if (callableMemberDescriptor2.i() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(u5)) {
                return null;
            }
        }
        return u5;
    }

    @NotNull
    public static OverridingUtil i(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar, @NotNull e.a aVar) {
        if (gVar == null) {
            a(3);
        }
        if (aVar == null) {
            a(4);
        }
        return new OverridingUtil(aVar, gVar, f.a.f47169a, null);
    }

    private static void j(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull m mVar) {
        if (collection == null) {
            a(83);
        }
        if (dVar == null) {
            a(84);
        }
        if (mVar == null) {
            a(85);
        }
        Collection<CallableMemberDescriptor> t5 = t(dVar, collection);
        boolean isEmpty = t5.isEmpty();
        if (!isEmpty) {
            collection = t5;
        }
        CallableMemberDescriptor e02 = ((CallableMemberDescriptor) L(collection, new d())).e0(dVar, n(collection, dVar), isEmpty ? kotlin.reflect.jvm.internal.impl.descriptors.r.f44951h : kotlin.reflect.jvm.internal.impl.descriptors.r.f44950g, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        mVar.d(e02, collection);
        mVar.a(e02);
    }

    private static void k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull Collection<CallableMemberDescriptor> collection, @NotNull m mVar) {
        if (dVar == null) {
            a(62);
        }
        if (collection == null) {
            a(63);
        }
        if (mVar == null) {
            a(64);
        }
        if (b(collection)) {
            Iterator<CallableMemberDescriptor> it = collection.iterator();
            while (it.hasNext()) {
                j(Collections.singleton(it.next()), dVar, mVar);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                j(q(v.a(linkedList), linkedList, mVar), dVar, mVar);
            }
        }
    }

    @NotNull
    private TypeCheckerState l(@NotNull List<j1> list, @NotNull List<j1> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        if (list.isEmpty()) {
            TypeCheckerState Y = new n(null, this.f46638c, this.f46636a, this.f46637b, this.f46639d).Y(true, true, false);
            if (Y == null) {
                a(42);
            }
            return Y;
        }
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < list.size(); i6++) {
            hashMap.put(list.get(i6).o(), list2.get(i6).o());
        }
        TypeCheckerState Y2 = new n(hashMap, this.f46638c, this.f46636a, this.f46637b, this.f46639d).Y(true, true, false);
        if (Y2 == null) {
            a(43);
        }
        return Y2;
    }

    @NotNull
    public static OverridingUtil m(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            a(0);
        }
        return new OverridingUtil(f46634g, gVar, f.a.f47169a, null);
    }

    @NotNull
    private static Modality n(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (collection == null) {
            a(86);
        }
        if (dVar == null) {
            a(87);
        }
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i6 = h.f46649c[callableMemberDescriptor.i().ordinal()];
            if (i6 == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    a(88);
                }
                return modality;
            }
            if (i6 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            }
            if (i6 == 3) {
                z6 = true;
            } else if (i6 == 4) {
                z7 = true;
            }
        }
        if (dVar.q0() && dVar.i() != Modality.ABSTRACT && dVar.i() != Modality.SEALED) {
            z5 = true;
        }
        if (z6 && !z7) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                a(89);
            }
            return modality2;
        }
        if (!z6 && z7) {
            Modality i7 = z5 ? dVar.i() : Modality.ABSTRACT;
            if (i7 == null) {
                a(90);
            }
            return i7;
        }
        HashSet hashSet = new HashSet();
        Iterator<CallableMemberDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(z(it.next()));
        }
        return y(r(hashSet), z5, dVar.i());
    }

    private Collection<CallableMemberDescriptor> o(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull m mVar) {
        if (callableMemberDescriptor == null) {
            a(57);
        }
        if (collection == null) {
            a(58);
        }
        if (dVar == null) {
            a(59);
        }
        if (mVar == null) {
            a(60);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        kotlin.reflect.jvm.internal.impl.utils.k a6 = kotlin.reflect.jvm.internal.impl.utils.k.a();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result c6 = D(callableMemberDescriptor2, callableMemberDescriptor, dVar).c();
            boolean I = I(callableMemberDescriptor, callableMemberDescriptor2, false);
            int i6 = h.f46648b[c6.ordinal()];
            if (i6 == 1) {
                if (I) {
                    a6.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i6 == 2) {
                if (I) {
                    mVar.c(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        mVar.d(callableMemberDescriptor, a6);
        return arrayList;
    }

    @NotNull
    public static <H> Collection<H> p(@NotNull H h6, @NotNull Collection<H> collection, @NotNull Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.a> function1, @NotNull Function1<H, n1> function12) {
        if (h6 == null) {
            a(97);
        }
        if (collection == null) {
            a(98);
        }
        if (function1 == null) {
            a(99);
        }
        if (function12 == null) {
            a(100);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h6);
        kotlin.reflect.jvm.internal.impl.descriptors.a invoke = function1.invoke(h6);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.a invoke2 = function1.invoke(next);
            if (h6 == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result x5 = x(invoke, invoke2);
                if (x5 == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (x5 == OverrideCompatibilityInfo.Result.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> q(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Queue<CallableMemberDescriptor> queue, @NotNull m mVar) {
        if (callableMemberDescriptor == null) {
            a(102);
        }
        if (queue == null) {
            a(103);
        }
        if (mVar == null) {
            a(104);
        }
        return p(callableMemberDescriptor, queue, new f(), new g(mVar, callableMemberDescriptor));
    }

    @NotNull
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> r(@NotNull Set<D> set) {
        if (set == null) {
            a(8);
        }
        return s(set, !set.isEmpty() && kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.y(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.s(set.iterator().next())), null, new b());
    }

    @NotNull
    public static <D> Set<D> s(@NotNull Set<D> set, boolean z5, @Nullable Function0<?> function0, @NotNull Function2<? super D, ? super D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> function2) {
        if (set == null) {
            a(9);
        }
        if (function2 == null) {
            a(10);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> invoke = function2.invoke(obj, (Object) it.next());
                kotlin.reflect.jvm.internal.impl.descriptors.a component1 = invoke.component1();
                kotlin.reflect.jvm.internal.impl.descriptors.a component2 = invoke.component2();
                if (!J(component1, component2, z5, true)) {
                    if (J(component2, component1, z5, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public static Collection<CallableMemberDescriptor> t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull Collection<CallableMemberDescriptor> collection) {
        if (dVar == null) {
            a(94);
        }
        if (collection == null) {
            a(95);
        }
        List r22 = f0.r2(collection, new e(dVar));
        if (r22 == null) {
            a(96);
        }
        return r22;
    }

    @Nullable
    public static kotlin.reflect.jvm.internal.impl.descriptors.s u(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar;
        if (collection == null) {
            a(107);
        }
        if (collection.isEmpty()) {
            return kotlin.reflect.jvm.internal.impl.descriptors.r.f44955l;
        }
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        loop0: while (true) {
            sVar = null;
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.s visibility = it.next().getVisibility();
                if (sVar != null) {
                    Integer d6 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(visibility, sVar);
                    if (d6 == null) {
                        break;
                    }
                    if (d6.intValue() > 0) {
                    }
                }
                sVar = visibility;
            }
        }
        if (sVar == null) {
            return null;
        }
        Iterator<? extends CallableMemberDescriptor> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer d7 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(sVar, it2.next().getVisibility());
            if (d7 == null || d7.intValue() < 0) {
                return null;
            }
        }
        return sVar;
    }

    @Nullable
    public static OverrideCompatibilityInfo w(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z5;
        if (aVar == null) {
            a(38);
        }
        if (aVar2 == null) {
            a(39);
        }
        boolean z6 = aVar instanceof y;
        if ((z6 && !(aVar2 instanceof y)) || (((z5 = aVar instanceof w0)) && !(aVar2 instanceof w0))) {
            return OverrideCompatibilityInfo.d("Member kind mismatch");
        }
        if (!z6 && !z5) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
        }
        if (!aVar.getName().equals(aVar2.getName())) {
            return OverrideCompatibilityInfo.d("Name mismatch");
        }
        OverrideCompatibilityInfo e6 = e(aVar, aVar2);
        if (e6 != null) {
            return e6;
        }
        return null;
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result x(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        OverridingUtil overridingUtil = f46633f;
        OverrideCompatibilityInfo.Result c6 = overridingUtil.D(aVar2, aVar, null).c();
        OverrideCompatibilityInfo.Result c7 = overridingUtil.D(aVar, aVar2, null).c();
        OverrideCompatibilityInfo.Result result = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (c6 == result && c7 == result) {
            return result;
        }
        OverrideCompatibilityInfo.Result result2 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (c6 == result2 || c7 == result2) ? result2 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    @NotNull
    private static Modality y(@NotNull Collection<CallableMemberDescriptor> collection, boolean z5, @NotNull Modality modality) {
        if (collection == null) {
            a(91);
        }
        if (modality == null) {
            a(92);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Modality i6 = (z5 && callableMemberDescriptor.i() == Modality.ABSTRACT) ? modality : callableMemberDescriptor.i();
            if (i6.compareTo(modality2) < 0) {
                modality2 = i6;
            }
        }
        if (modality2 == null) {
            a(93);
        }
        return modality2;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> z(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(15);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    @NotNull
    public OverrideCompatibilityInfo D(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (aVar == null) {
            a(19);
        }
        if (aVar2 == null) {
            a(20);
        }
        OverrideCompatibilityInfo E = E(aVar, aVar2, dVar, false);
        if (E == null) {
            a(21);
        }
        return E;
    }

    @NotNull
    public OverrideCompatibilityInfo E(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar, boolean z5) {
        if (aVar == null) {
            a(22);
        }
        if (aVar2 == null) {
            a(23);
        }
        OverrideCompatibilityInfo F = F(aVar, aVar2, z5);
        boolean z6 = F.c() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : f46632e) {
            if (externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z6 || externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i6 = h.f46647a[externalOverridabilityCondition.b(aVar, aVar2, dVar).ordinal()];
                if (i6 == 1) {
                    z6 = true;
                } else if (i6 == 2) {
                    OverrideCompatibilityInfo d6 = OverrideCompatibilityInfo.d("External condition");
                    if (d6 == null) {
                        a(24);
                    }
                    return d6;
                }
            }
        }
        if (!z6) {
            return F;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : f46632e) {
            if (externalOverridabilityCondition2.a() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i7 = h.f46647a[externalOverridabilityCondition2.b(aVar, aVar2, dVar).ordinal()];
                if (i7 == 1) {
                    throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i7 == 2) {
                    OverrideCompatibilityInfo d7 = OverrideCompatibilityInfo.d("External condition");
                    if (d7 == null) {
                        a(26);
                    }
                    return d7;
                }
            }
        }
        OverrideCompatibilityInfo e6 = OverrideCompatibilityInfo.e();
        if (e6 == null) {
            a(27);
        }
        return e6;
    }

    @NotNull
    public OverrideCompatibilityInfo F(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z5) {
        if (aVar == null) {
            a(28);
        }
        if (aVar2 == null) {
            a(29);
        }
        OverrideCompatibilityInfo w5 = w(aVar, aVar2);
        if (w5 != null) {
            return w5;
        }
        List<t0> g6 = g(aVar);
        List<t0> g7 = g(aVar2);
        List<j1> typeParameters = aVar.getTypeParameters();
        List<j1> typeParameters2 = aVar2.getTypeParameters();
        int i6 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i6 < g6.size()) {
                if (!kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a.a(g6.get(i6), g7.get(i6))) {
                    OverrideCompatibilityInfo d6 = OverrideCompatibilityInfo.d("Type parameter number mismatch");
                    if (d6 == null) {
                        a(31);
                    }
                    return d6;
                }
                i6++;
            }
            OverrideCompatibilityInfo b6 = OverrideCompatibilityInfo.b("Type parameter number mismatch");
            if (b6 == null) {
                a(32);
            }
            return b6;
        }
        TypeCheckerState l6 = l(typeParameters, typeParameters2);
        for (int i7 = 0; i7 < typeParameters.size(); i7++) {
            if (!c(typeParameters.get(i7), typeParameters2.get(i7), l6)) {
                OverrideCompatibilityInfo d7 = OverrideCompatibilityInfo.d("Type parameter bounds mismatch");
                if (d7 == null) {
                    a(33);
                }
                return d7;
            }
        }
        while (i6 < g6.size()) {
            if (!d(g6.get(i6), g7.get(i6), l6)) {
                OverrideCompatibilityInfo d8 = OverrideCompatibilityInfo.d("Value parameter type mismatch");
                if (d8 == null) {
                    a(34);
                }
                return d8;
            }
            i6++;
        }
        if ((aVar instanceof y) && (aVar2 instanceof y) && ((y) aVar).isSuspend() != ((y) aVar2).isSuspend()) {
            OverrideCompatibilityInfo b7 = OverrideCompatibilityInfo.b("Incompatible suspendability");
            if (b7 == null) {
                a(35);
            }
            return b7;
        }
        if (z5) {
            t0 returnType = aVar.getReturnType();
            t0 returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null && ((!x0.a(returnType2) || !x0.a(returnType)) && !kotlin.reflect.jvm.internal.impl.types.h.f47257a.t(l6, returnType2.L0(), returnType.L0()))) {
                OverrideCompatibilityInfo b8 = OverrideCompatibilityInfo.b("Return type mismatch");
                if (b8 == null) {
                    a(36);
                }
                return b8;
            }
        }
        OverrideCompatibilityInfo e6 = OverrideCompatibilityInfo.e();
        if (e6 == null) {
            a(37);
        }
        return e6;
    }

    public void v(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull Collection<? extends CallableMemberDescriptor> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull m mVar) {
        if (fVar == null) {
            a(50);
        }
        if (collection == null) {
            a(51);
        }
        if (collection2 == null) {
            a(52);
        }
        if (dVar == null) {
            a(53);
        }
        if (mVar == null) {
            a(54);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends CallableMemberDescriptor> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(o(it.next(), collection, dVar, mVar));
        }
        k(dVar, linkedHashSet, mVar);
    }

    @Nullable
    private static OverrideCompatibilityInfo e(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z5;
        boolean z6 = false;
        if (aVar.f0() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (aVar2.f0() == null) {
            z6 = true;
        }
        if (z5 != z6) {
            return OverrideCompatibilityInfo.d("Receiver presence mismatch");
        }
        if (aVar.g().size() != aVar2.g().size()) {
            return OverrideCompatibilityInfo.d("Value parameter number mismatch");
        }
        return null;
    }

    private static List<t0> g(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        z0 f02 = aVar.f0();
        ArrayList arrayList = new ArrayList();
        if (f02 != null) {
            arrayList.add(f02.getType());
        }
        Iterator<q1> it = aVar.g().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }
}
