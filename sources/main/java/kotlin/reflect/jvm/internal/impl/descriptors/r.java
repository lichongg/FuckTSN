package kotlin.reflect.jvm.internal.impl.descriptors;

import com.tencent.connect.common.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.u1;
import kotlin.reflect.jvm.internal.impl.util.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f44944a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final s f44945b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final s f44946c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final s f44947d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final s f44948e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final s f44949f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final s f44950g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final s f44951h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final s f44952i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set<s> f44953j;

    /* renamed from: k, reason: collision with root package name */
    private static final Map<s, Integer> f44954k;

    /* renamed from: l, reason: collision with root package name */
    public static final s f44955l;

    /* renamed from: m, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h f44956m;

    /* renamed from: n, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h f44957n;

    /* renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h f44958o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.util.l f44959p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final Map<v1, s> f44960q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h {
        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.t0 getType() {
            throw new IllegalStateException("This method should not be called");
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h {
        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.t0 getType() {
            throw new IllegalStateException("This method should not be called");
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h {
        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.t0 getType() {
            throw new IllegalStateException("This method should not be called");
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = Constants.FROM;
            } else if (i6 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i6 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i6 == 2 || i6 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.i.q(oVar, kotlin.reflect.jvm.internal.impl.descriptors.d.class);
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar3 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.i.r(kVar, kotlin.reflect.jvm.internal.impl.descriptors.d.class, false);
            if (dVar3 == null) {
                return false;
            }
            if (dVar2 != null && kotlin.reflect.jvm.internal.impl.resolve.i.x(dVar2) && (dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.i.q(dVar2, kotlin.reflect.jvm.internal.impl.descriptors.d.class)) != null && kotlin.reflect.jvm.internal.impl.resolve.i.H(dVar3, dVar)) {
                return true;
            }
            o M = kotlin.reflect.jvm.internal.impl.resolve.i.M(oVar);
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar4 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.reflect.jvm.internal.impl.resolve.i.q(M, kotlin.reflect.jvm.internal.impl.descriptors.d.class);
            if (dVar4 == null) {
                return false;
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.i.H(dVar3, dVar4) && h(hVar, M, dVar3)) {
                return true;
            }
            return e(hVar, oVar, dVar3.b(), z5);
        }

        private boolean h(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            if (oVar == null) {
                g(2);
            }
            if (dVar == null) {
                g(3);
            }
            if (hVar == r.f44958o) {
                return false;
            }
            if (!(oVar instanceof CallableMemberDescriptor) || (oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) || hVar == r.f44957n) {
                return true;
            }
            if (hVar == r.f44956m || hVar == null) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.types.t0 b6 = hVar instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.i ? ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.i) hVar).b() : hVar.getType();
            return kotlin.reflect.jvm.internal.impl.resolve.i.I(b6, dVar) || kotlin.reflect.jvm.internal.impl.types.g0.a(b6);
        }

        f(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return true;
        }

        h(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }

        i(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class j extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }

        j(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "what";
            } else if (i6 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i6 == 1 || i6 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (kVar == null) {
                g(0);
            }
            return kotlin.reflect.jvm.internal.impl.resolve.i.j(kVar) != f1.f44684a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.o] */
        /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.k] */
        /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.k] */
        /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.k] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == 0) {
                g(1);
            }
            if (kVar == null) {
                g(2);
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.i.J(oVar) && h(kVar)) {
                return r.f(oVar, kVar);
            }
            if (oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
                kotlin.reflect.jvm.internal.impl.descriptors.g b6 = ((kotlin.reflect.jvm.internal.impl.descriptors.j) oVar).b();
                if (z5 && kotlin.reflect.jvm.internal.impl.resolve.i.G(b6) && kotlin.reflect.jvm.internal.impl.resolve.i.J(b6) && (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) && kotlin.reflect.jvm.internal.impl.resolve.i.J(kVar.b()) && r.f(oVar, kVar)) {
                    return true;
                }
            }
            while (oVar != 0) {
                oVar = oVar.b();
                if (((oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && !kotlin.reflect.jvm.internal.impl.resolve.i.x(oVar)) || (oVar instanceof l0)) {
                    break;
                }
            }
            if (oVar == 0) {
                return false;
            }
            while (kVar != null) {
                if (oVar == kVar) {
                    return true;
                }
                if (kVar instanceof l0) {
                    return (oVar instanceof l0) && oVar.d().equals(((l0) kVar).d()) && kotlin.reflect.jvm.internal.impl.resolve.i.b(kVar, oVar);
                }
                kVar = kVar.b();
            }
            return false;
        }

        d(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            kotlin.reflect.jvm.internal.impl.descriptors.k q5;
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            if (r.f44944a.e(hVar, oVar, kVar, z5)) {
                if (hVar == r.f44957n) {
                    return true;
                }
                if (hVar != r.f44956m && (q5 = kotlin.reflect.jvm.internal.impl.resolve.i.q(oVar, kotlin.reflect.jvm.internal.impl.descriptors.d.class)) != null && (hVar instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.j)) {
                    return ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.j) hVar).m().a().equals(q5.a());
                }
            }
            return false;
        }

        e(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.i.g(kVar).B(kotlin.reflect.jvm.internal.impl.resolve.i.g(oVar))) {
                return r.f44959p.a(oVar, kVar);
            }
            return false;
        }

        g(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class k extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return false;
        }

        k(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class l extends p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return false;
        }

        l(v1 v1Var) {
            super(v1Var);
        }
    }

    static {
        d dVar = new d(u1.e.f45051c);
        f44944a = dVar;
        e eVar = new e(u1.f.f45052c);
        f44945b = eVar;
        f fVar = new f(u1.g.f45053c);
        f44946c = fVar;
        g gVar = new g(u1.b.f45048c);
        f44947d = gVar;
        h hVar = new h(u1.h.f45054c);
        f44948e = hVar;
        i iVar = new i(u1.d.f45050c);
        f44949f = iVar;
        j jVar = new j(u1.a.f45047c);
        f44950g = jVar;
        k kVar = new k(u1.c.f45049c);
        f44951h = kVar;
        l lVar = new l(u1.i.f45055c);
        f44952i = lVar;
        f44953j = Collections.unmodifiableSet(kotlin.collections.u1.u(dVar, eVar, gVar, iVar));
        HashMap e6 = kotlin.reflect.jvm.internal.impl.utils.a.e(4);
        e6.put(eVar, 0);
        e6.put(dVar, 0);
        e6.put(gVar, 1);
        e6.put(fVar, 1);
        e6.put(hVar, 2);
        f44954k = Collections.unmodifiableMap(e6);
        f44955l = hVar;
        f44956m = new a();
        f44957n = new b();
        f44958o = new c();
        Iterator it = ServiceLoader.load(kotlin.reflect.jvm.internal.impl.util.l.class, kotlin.reflect.jvm.internal.impl.util.l.class.getClassLoader()).iterator();
        f44959p = it.hasNext() ? (kotlin.reflect.jvm.internal.impl.util.l) it.next() : l.a.f47411a;
        f44960q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = 3
            goto L10
        Lf:
            r4 = 2
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.r.a(int):void");
    }

    @Nullable
    public static Integer d(@NotNull s sVar, @NotNull s sVar2) {
        if (sVar == null) {
            a(12);
        }
        if (sVar2 == null) {
            a(13);
        }
        Integer a6 = sVar.a(sVar2);
        if (a6 != null) {
            return a6;
        }
        Integer a7 = sVar2.a(sVar);
        if (a7 != null) {
            return Integer.valueOf(-a7.intValue());
        }
        return null;
    }

    @Nullable
    public static o e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
        o e6;
        if (oVar == null) {
            a(8);
        }
        if (kVar == null) {
            a(9);
        }
        for (o oVar2 = (o) oVar.a(); oVar2 != null && oVar2.getVisibility() != f44949f; oVar2 = (o) kotlin.reflect.jvm.internal.impl.resolve.i.q(oVar2, o.class)) {
            if (!oVar2.getVisibility().e(hVar, oVar2, kVar, z5)) {
                return oVar2;
            }
        }
        if (!(oVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.q0) || (e6 = e(hVar, ((kotlin.reflect.jvm.internal.impl.descriptors.impl.q0) oVar).F(), kVar, z5)) == null) {
            return null;
        }
        return e6;
    }

    public static boolean f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        if (kVar == null) {
            a(6);
        }
        if (kVar2 == null) {
            a(7);
        }
        f1 j6 = kotlin.reflect.jvm.internal.impl.resolve.i.j(kVar2);
        if (j6 != f1.f44684a) {
            return j6.equals(kotlin.reflect.jvm.internal.impl.resolve.i.j(kVar));
        }
        return false;
    }

    public static boolean g(@NotNull s sVar) {
        if (sVar == null) {
            a(14);
        }
        return sVar == f44944a || sVar == f44945b;
    }

    public static boolean h(@NotNull o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
        if (oVar == null) {
            a(2);
        }
        if (kVar == null) {
            a(3);
        }
        return e(f44957n, oVar, kVar, z5) == null;
    }

    private static void i(s sVar) {
        f44960q.put(sVar.b(), sVar);
    }

    @NotNull
    public static s j(@NotNull v1 v1Var) {
        if (v1Var == null) {
            a(15);
        }
        s sVar = f44960q.get(v1Var);
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + v1Var);
    }
}
