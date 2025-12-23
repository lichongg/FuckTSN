package kotlin.reflect.jvm.internal.impl.renderer;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.mail.Part;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.r0;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.renderer.m;
import kotlin.reflect.jvm.internal.impl.resolve.constants.t;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.k0;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.n2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDescriptorRendererImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRendererImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1225:1\n152#1,10:1226\n152#1,10:1236\n2746#2,3:1246\n774#2:1249\n865#2,2:1250\n1563#2:1252\n1634#2,3:1253\n774#2:1256\n865#2,2:1257\n1563#2:1259\n1634#2,3:1260\n1563#2:1263\n1634#2,3:1264\n1617#2,9:1268\n1869#2:1277\n1870#2:1279\n1626#2:1280\n2746#2,3:1281\n2746#2,3:1284\n774#2:1287\n865#2,2:1288\n1634#2,3:1290\n1#3:1267\n1#3:1278\n*S KotlinDebug\n*F\n+ 1 DescriptorRendererImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererImpl\n*L\n138#1:1226,10\n145#1:1236,10\n200#1:1246,3\n501#1:1249\n501#1:1250,2\n502#1:1252\n502#1:1253,3\n504#1:1256\n504#1:1257,2\n504#1:1259\n504#1:1260,3\n506#1:1263\n506#1:1264,3\n515#1:1268,9\n515#1:1277\n515#1:1279\n515#1:1280\n606#1:1281,3\n608#1:1284,3\n824#1:1287\n824#1:1288,2\n847#1:1290,3\n515#1:1278\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t extends m implements u {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final x f46594m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final kotlin.s f46595n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class a implements kotlin.reflect.jvm.internal.impl.descriptors.m<n1, StringBuilder> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.t$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0910a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f46597a;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                try {
                    iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f46597a = iArr;
            }
        }

        public a() {
        }

        private final void t(v0 v0Var, StringBuilder sb, String str) {
            int i6 = C0910a.f46597a[t.this.Q0().ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    p(v0Var, sb);
                    return;
                } else {
                    if (i6 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                }
            }
            t.this.x1(v0Var, sb);
            sb.append(str + " for ");
            t tVar = t.this;
            w0 h02 = v0Var.h0();
            g0.o(h02, "getCorrespondingProperty(...)");
            tVar.i2(h02, sb);
        }

        public void A(@NotNull q1 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.C2(descriptor, true, builder, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
            n(dVar, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 b(s0 s0Var, StringBuilder sb) {
            s(s0Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 c(w0 w0Var, StringBuilder sb) {
            u(w0Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 d(y0 y0Var, StringBuilder sb) {
            w(y0Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 e(q1 q1Var, StringBuilder sb) {
            A(q1Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 f(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, StringBuilder sb) {
            o(jVar, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 g(z0 z0Var, StringBuilder sb) {
            x(z0Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 h(j1 j1Var, StringBuilder sb) {
            z(j1Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 i(i1 i1Var, StringBuilder sb) {
            y(i1Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 j(x0 x0Var, StringBuilder sb) {
            v(x0Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 k(l0 l0Var, StringBuilder sb) {
            r(l0Var, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 l(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, StringBuilder sb) {
            p(yVar, sb);
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ n1 m(f0 f0Var, StringBuilder sb) {
            q(f0Var, sb);
            return n1.f44123a;
        }

        public void n(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.D1(descriptor, builder);
        }

        public void o(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j constructorDescriptor, @NotNull StringBuilder builder) {
            g0.p(constructorDescriptor, "constructorDescriptor");
            g0.p(builder, "builder");
            t.this.I1(constructorDescriptor, builder);
        }

        public void p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.Q1(descriptor, builder);
        }

        public void q(@NotNull f0 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.a2(descriptor, builder, true);
        }

        public void r(@NotNull l0 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.e2(descriptor, builder);
        }

        public void s(@NotNull s0 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.g2(descriptor, builder);
        }

        public void u(@NotNull w0 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.i2(descriptor, builder);
        }

        public void v(@NotNull x0 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t(descriptor, builder, "getter");
        }

        public void w(@NotNull y0 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t(descriptor, builder, "setter");
        }

        public void x(@NotNull z0 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            builder.append(descriptor.getName());
        }

        public void y(@NotNull i1 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.r2(descriptor, builder);
        }

        public void z(@NotNull j1 descriptor, @NotNull StringBuilder builder) {
            g0.p(descriptor, "descriptor");
            g0.p(builder, "builder");
            t.this.x2(descriptor, builder, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void I1(kotlin.reflect.jvm.internal.impl.descriptors.j r18, java.lang.StringBuilder r19) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.t.I1(kotlin.reflect.jvm.internal.impl.descriptors.j, java.lang.StringBuilder):void");
    }

    private final void K1(List<? extends z0> list, StringBuilder sb) {
        if (list.isEmpty()) {
            return;
        }
        sb.append("context(");
        int i6 = 0;
        for (z0 z0Var : list) {
            int i7 = i6 + 1;
            A1(sb, z0Var, AnnotationUseSiteTarget.RECEIVER);
            t0 type = z0Var.getType();
            g0.o(type, "getType(...)");
            sb.append(O1(type));
            if (i6 == kotlin.collections.f0.L(list)) {
                sb.append(") ");
            } else {
                sb.append(", ");
            }
            i6 = i7;
        }
    }

    private final void L1(StringBuilder sb, t0 t0Var) {
        B1(this, sb, t0Var, null, 2, null);
        kotlin.reflect.jvm.internal.impl.types.z zVar = t0Var instanceof kotlin.reflect.jvm.internal.impl.types.z ? (kotlin.reflect.jvm.internal.impl.types.z) t0Var : null;
        e1 U0 = zVar != null ? zVar.U0() : null;
        if (kotlin.reflect.jvm.internal.impl.types.x0.a(t0Var)) {
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.e.A(t0Var) && P0()) {
                sb.append(M1(kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.p(t0Var)));
            } else {
                if (!(t0Var instanceof kotlin.reflect.jvm.internal.impl.types.error.g) || I0()) {
                    sb.append(t0Var.I0().toString());
                } else {
                    sb.append(((kotlin.reflect.jvm.internal.impl.types.error.g) t0Var).R0());
                }
                sb.append(s2(t0Var.G0()));
            }
        } else if (t0Var instanceof kotlin.reflect.jvm.internal.impl.types.n1) {
            sb.append(((kotlin.reflect.jvm.internal.impl.types.n1) t0Var).R0().toString());
        } else if (U0 instanceof kotlin.reflect.jvm.internal.impl.types.n1) {
            sb.append(((kotlin.reflect.jvm.internal.impl.types.n1) U0).R0().toString());
        } else {
            w2(this, sb, t0Var, null, 2, null);
            n1 n1Var = n1.f44123a;
        }
        if (t0Var.J0()) {
            sb.append("?");
        }
        if (kotlin.reflect.jvm.internal.impl.types.i1.c(t0Var)) {
            sb.append(" & Any");
        }
    }

    private final void o0(StringBuilder sb, List<? extends c2> list) {
        r0.o3(list, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new p(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(i1 i1Var, StringBuilder sb) {
        B1(this, sb, i1Var, null, 2, null);
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = i1Var.getVisibility();
        g0.o(visibility, "getVisibility(...)");
        F2(visibility, sb);
        V1(i1Var, sb);
        sb.append(T1("typealias"));
        sb.append(" ");
        a2(i1Var, sb, true);
        List<j1> t5 = i1Var.t();
        g0.o(t5, "getDeclaredTypeParameters(...)");
        z2(t5, sb, false);
        C1(i1Var, sb);
        sb.append(" = ");
        sb.append(T(i1Var.y0()));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46598a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f46599b;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            try {
                iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderingFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f46598a = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            try {
                iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f46599b = iArr2;
        }
    }

    public t(@NotNull x options) {
        g0.p(options, "options");
        this.f46594m = options;
        options.q0();
        this.f46595n = kotlin.t.c(new n(this));
    }

    private final void A2(s1 s1Var, StringBuilder sb, boolean z5) {
        if (z5 || !(s1Var instanceof q1)) {
            sb.append(T1(s1Var.C() ? "var" : "val"));
            sb.append(" ");
        }
    }

    static /* synthetic */ void B1(t tVar, StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        tVar.A1(sb, aVar, annotationUseSiteTarget);
    }

    static /* synthetic */ void B2(t tVar, s1 s1Var, StringBuilder sb, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        tVar.A2(s1Var, sb, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C2(kotlin.reflect.jvm.internal.impl.descriptors.q1 r9, boolean r10, java.lang.StringBuilder r11, boolean r12) {
        /*
            r8 = this;
            if (r12 == 0) goto L10
            java.lang.String r2 = "value-parameter"
            java.lang.String r2 = r8.T1(r2)
            r11.append(r2)
            java.lang.String r2 = " "
            r11.append(r2)
        L10:
            boolean r2 = r8.k1()
            if (r2 == 0) goto L27
            java.lang.String r2 = "/*"
            r11.append(r2)
            int r2 = r9.getIndex()
            r11.append(r2)
        */
        //  java.lang.String r2 = "*/ "
        /*
            r11.append(r2)
        L27:
            r4 = 2
            r5 = 0
            r3 = 0
            r0 = r8
            r2 = r9
            r1 = r11
            B1(r0, r1, r2, r3, r4, r5)
            boolean r2 = r9.w0()
            java.lang.String r3 = "crossinline"
            r8.Z1(r11, r2, r3)
            boolean r2 = r9.u0()
            java.lang.String r3 = "noinline"
            r8.Z1(r11, r2, r3)
            boolean r2 = r8.Z0()
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L60
            kotlin.reflect.jvm.internal.impl.descriptors.a r2 = r9.b()
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.c
            if (r3 == 0) goto L55
            kotlin.reflect.jvm.internal.impl.descriptors.c r2 = (kotlin.reflect.jvm.internal.impl.descriptors.c) r2
            goto L56
        L55:
            r2 = 0
        L56:
            if (r2 == 0) goto L60
            boolean r2 = r2.m0()
            if (r2 != r7) goto L60
            r5 = 1
            goto L61
        L60:
            r5 = 0
        L61:
            if (r5 == 0) goto L6c
            boolean r2 = r8.u0()
            java.lang.String r3 = "actual"
            r8.Z1(r11, r2, r3)
        L6c:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.E2(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function1 r0 = r8.A0()
            if (r0 == 0) goto L8c
            boolean r0 = r8.d()
            if (r0 == 0) goto L85
            boolean r0 = r9.Q()
            goto L89
        L85:
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.f(r9)
        L89:
            if (r0 == 0) goto L8c
            r6 = 1
        L8c:
            if (r6 == 0) goto Laf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " = "
            r0.append(r2)
            kotlin.jvm.functions.Function1 r2 = r8.A0()
            kotlin.jvm.internal.g0.m(r2)
            java.lang.Object r2 = r2.invoke(r9)
            java.lang.String r2 = (java.lang.String) r2
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r11.append(r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.t.C2(kotlin.reflect.jvm.internal.impl.descriptors.q1, boolean, java.lang.StringBuilder, boolean):void");
    }

    private final t D0() {
        return (t) this.f46595n.getValue();
    }

    private final void E1(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
        sb.append(T1(m.f46574a.a(dVar)));
    }

    private final String H1(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar) {
        Function1<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>, String> Q = this.f46594m.Q();
        if (Q != null) {
            return Q.invoke(gVar);
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a6 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).a();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = a6.iterator();
            while (it.hasNext()) {
                String H1 = H1((kotlin.reflect.jvm.internal.impl.resolve.constants.g) it.next());
                if (H1 != null) {
                    arrayList.add(H1);
                }
            }
            return kotlin.collections.f0.r3(arrayList, ", ", "{", "}", 0, null, null, 56, null);
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
            return kotlin.text.u.v4(m.P(this, ((kotlin.reflect.jvm.internal.impl.resolve.constants.a) gVar).a(), null, 2, null), "@");
        }
        if (!(gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.t)) {
            return gVar.toString();
        }
        t.b a7 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.t) gVar).a();
        if (a7 instanceof t.b.a) {
            return ((t.b.a) a7).getType() + "::class";
        }
        if (!(a7 instanceof t.b.C0913b)) {
            throw new NoWhenBranchMatchedException();
        }
        t.b.C0913b c0913b = (t.b.C0913b) a7;
        String a8 = c0913b.b().a().a();
        int a9 = c0913b.a();
        for (int i6 = 0; i6 < a9; i6++) {
            a8 = "kotlin.Array<" + a8 + kotlin.text.v0.f47962f;
        }
        return a8 + "::class";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence J1(q1 q1Var) {
        return "";
    }

    private final void Z1(StringBuilder sb, boolean z5, String str) {
        if (z5) {
            sb.append(T1(str));
            sb.append(" ");
        }
    }

    private final void c2(StringBuilder sb, t0 t0Var) {
        if ((t0Var instanceof n2) && d() && !((n2) t0Var).N0()) {
            sb.append("<Not computed yet>");
            return;
        }
        m2 L0 = t0Var.L0();
        if (L0 instanceof k0) {
            sb.append(((k0) L0).S0(this, this));
        } else {
            if (!(L0 instanceof e1)) {
                throw new NoWhenBranchMatchedException();
            }
            m2(sb, (e1) L0);
        }
    }

    private final void m2(StringBuilder sb, e1 e1Var) {
        if (g0.g(e1Var, j2.f47278b) || j2.k(e1Var)) {
            sb.append("???");
            return;
        }
        if (kotlin.reflect.jvm.internal.impl.types.error.i.o(e1Var)) {
            if (!h1()) {
                sb.append("???");
                return;
            }
            w1 I0 = e1Var.I0();
            g0.n(I0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
            sb.append(M1(((kotlin.reflect.jvm.internal.impl.types.error.h) I0).f(0)));
            return;
        }
        if (kotlin.reflect.jvm.internal.impl.types.x0.a(e1Var)) {
            L1(sb, e1Var);
        } else if (H2(e1Var)) {
            R1(sb, e1Var);
        } else {
            L1(sb, e1Var);
        }
    }

    private final void n0(StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6;
        String name;
        if ((kVar instanceof l0) || (kVar instanceof s0) || (b6 = kVar.b()) == null || (b6 instanceof f0)) {
            return;
        }
        sb.append(" ");
        sb.append(W1("defined in"));
        sb.append(" ");
        kotlin.reflect.jvm.internal.impl.name.d m6 = kotlin.reflect.jvm.internal.impl.resolve.i.m(b6);
        g0.o(m6, "getFqName(...)");
        sb.append(m6.e() ? "root package" : R(m6));
        if (m1() && (b6 instanceof l0) && (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.n) && (name = ((kotlin.reflect.jvm.internal.impl.descriptors.n) kVar).getSource().b().getName()) != null) {
            sb.append(" ");
            sb.append(W1("in file"));
            sb.append(" ");
            sb.append(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence p0(t tVar, c2 it) {
        g0.p(it, "it");
        if (it.b()) {
            return "*";
        }
        t0 type = it.getType();
        g0.o(type, "getType(...)");
        String T = tVar.T(type);
        if (it.c() == Variance.INVARIANT) {
            return T;
        }
        return it.c() + ' ' + T;
    }

    private final String q1() {
        return r0(">");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t s0(t tVar) {
        m V = tVar.V(s.f46593a);
        g0.n(V, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (t) V;
    }

    private final Modality s1(c0 c0Var) {
        if (c0Var instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.d) c0Var).h() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = c0Var.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b6 : null;
        if (dVar == null) {
            return Modality.FINAL;
        }
        if (!(c0Var instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) c0Var;
        Collection<? extends CallableMemberDescriptor> e6 = callableMemberDescriptor.e();
        g0.o(e6, "getOverriddenDescriptors(...)");
        if (!e6.isEmpty() && dVar.i() != Modality.FINAL) {
            return Modality.OPEN;
        }
        if (dVar.h() != ClassKind.INTERFACE || g0.g(callableMemberDescriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a)) {
            return Modality.FINAL;
        }
        Modality i6 = callableMemberDescriptor.i();
        Modality modality = Modality.ABSTRACT;
        return i6 == modality ? modality : Modality.OPEN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 t0(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.f(u1.C(withOptions.c(), kotlin.collections.f0.Q(o.a.C, o.a.D)));
        return n1.f44123a;
    }

    private final String u1() {
        return r0("<");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object u2(t0 it) {
        g0.p(it, "it");
        return it instanceof kotlin.reflect.jvm.internal.impl.types.n1 ? ((kotlin.reflect.jvm.internal.impl.types.n1) it).R0() : it;
    }

    static /* synthetic */ void w2(t tVar, StringBuilder sb, t0 t0Var, w1 w1Var, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            w1Var = t0Var.I0();
        }
        tVar.v2(sb, t0Var, w1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2(j1 j1Var, StringBuilder sb, boolean z5) {
        if (z5) {
            sb.append(u1());
        }
        if (k1()) {
            sb.append("/*");
            sb.append(j1Var.getIndex());
            sb.append("*/ ");
        }
        Z1(sb, j1Var.j(), "reified");
        String label = j1Var.l().getLabel();
        boolean z6 = true;
        Z1(sb, label.length() > 0, label);
        B1(this, sb, j1Var, null, 2, null);
        a2(j1Var, sb, z5);
        int size = j1Var.getUpperBounds().size();
        if ((size > 1 && !z5) || size == 1) {
            t0 next = j1Var.getUpperBounds().iterator().next();
            if (!kotlin.reflect.jvm.internal.impl.builtins.j.k0(next)) {
                sb.append(" : ");
                g0.m(next);
                sb.append(T(next));
            }
        } else if (z5) {
            for (t0 t0Var : j1Var.getUpperBounds()) {
                if (!kotlin.reflect.jvm.internal.impl.builtins.j.k0(t0Var)) {
                    if (z6) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    g0.m(t0Var);
                    sb.append(T(t0Var));
                    z6 = false;
                }
            }
        }
        if (z5) {
            sb.append(q1());
        }
    }

    @Nullable
    public Function1<q1, String> A0() {
        return this.f46594m.B();
    }

    public boolean B0() {
        return this.f46594m.C();
    }

    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> C0() {
        return this.f46594m.D();
    }

    public boolean E0() {
        return this.f46594m.E();
    }

    public boolean F0() {
        return this.f46594m.F();
    }

    @NotNull
    public String F1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f klass) {
        g0.p(klass, "klass");
        return kotlin.reflect.jvm.internal.impl.types.error.i.m(klass) ? klass.o().toString() : z0().a(klass, this);
    }

    public boolean G0() {
        return this.f46594m.G();
    }

    public boolean H0() {
        return this.f46594m.H();
    }

    public boolean I0() {
        return this.f46594m.I();
    }

    @NotNull
    public Set<DescriptorRendererModifier> J0() {
        return this.f46594m.J();
    }

    public boolean K0() {
        return this.f46594m.K();
    }

    @NotNull
    public final x L0() {
        return this.f46594m;
    }

    @NotNull
    public OverrideRenderingPolicy M0() {
        return this.f46594m.L();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.m
    @NotNull
    public String N(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k declarationDescriptor) {
        g0.p(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.W(new a(), sb);
        if (l1()) {
            n0(sb, declarationDescriptor);
        }
        return sb.toString();
    }

    @NotNull
    public ParameterNameRenderingPolicy N0() {
        return this.f46594m.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.m
    @NotNull
    public String O(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotation, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget) {
        g0.p(annotation, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(annotationUseSiteTarget.getRenderName() + ':');
        }
        t0 type = annotation.getType();
        sb.append(T(type));
        if (F0()) {
            List<String> z12 = z1(annotation);
            if (G0() || !z12.isEmpty()) {
                r0.o3(z12, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
            }
        }
        if (k1() && (kotlin.reflect.jvm.internal.impl.types.x0.a(type) || (type.I0().c() instanceof k0.b))) {
            sb.append(" /* annotation class not found */");
        }
        return sb.toString();
    }

    public boolean O0() {
        return this.f46594m.N();
    }

    public boolean P0() {
        return this.f46594m.O();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.m
    @NotNull
    public String Q(@NotNull String lowerRendered, @NotNull String upperRendered, @NotNull kotlin.reflect.jvm.internal.impl.builtins.j builtIns) {
        g0.p(lowerRendered, "lowerRendered");
        g0.p(upperRendered, "upperRendered");
        g0.p(builtIns, "builtIns");
        if (a0.f(lowerRendered, upperRendered)) {
            if (!kotlin.text.u.H2(upperRendered, "(", false, 2, null)) {
                return lowerRendered + '!';
            }
            return '(' + lowerRendered + ")!";
        }
        kotlin.reflect.jvm.internal.impl.renderer.a z02 = z0();
        kotlin.reflect.jvm.internal.impl.descriptors.d x5 = builtIns.x();
        g0.o(x5, "getCollection(...)");
        String S5 = kotlin.text.u.S5(z02.a(x5, this), "Collection", null, 2, null);
        String d6 = a0.d(lowerRendered, S5 + "Mutable", upperRendered, S5, S5 + "(Mutable)");
        if (d6 != null) {
            return d6;
        }
        String d7 = a0.d(lowerRendered, S5 + "MutableMap.MutableEntry", upperRendered, S5 + "Map.Entry", S5 + "(Mutable)Map.(Mutable)Entry");
        if (d7 != null) {
            return d7;
        }
        kotlin.reflect.jvm.internal.impl.renderer.a z03 = z0();
        kotlin.reflect.jvm.internal.impl.descriptors.d j6 = builtIns.j();
        g0.o(j6, "getArray(...)");
        String S52 = kotlin.text.u.S5(z03.a(j6, this), "Array", null, 2, null);
        String d8 = a0.d(lowerRendered, S52 + r0("Array<"), upperRendered, S52 + r0("Array<out "), S52 + r0("Array<(out) "));
        if (d8 != null) {
            return d8;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    @NotNull
    public PropertyAccessorRenderingPolicy Q0() {
        return this.f46594m.P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.m
    @NotNull
    public String R(@NotNull kotlin.reflect.jvm.internal.impl.name.d fqName) {
        g0.p(fqName, "fqName");
        return P1(fqName.h());
    }

    public boolean R0() {
        return this.f46594m.R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.m
    @NotNull
    public String S(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, boolean z5) {
        g0.p(name, "name");
        String r02 = r0(a0.b(name));
        if (!x0() || f1() != RenderingFormat.HTML || !z5) {
            return r02;
        }
        return "<b>" + r02 + "</b>";
    }

    public boolean S0() {
        return this.f46594m.S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.m
    @NotNull
    public String T(@NotNull t0 type) {
        g0.p(type, "type");
        StringBuilder sb = new StringBuilder();
        b2(sb, g1().invoke(type));
        return sb.toString();
    }

    public boolean T0() {
        return this.f46594m.T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.m
    @NotNull
    public String U(@NotNull c2 typeProjection) {
        g0.p(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        o0(sb, kotlin.collections.f0.l(typeProjection));
        return sb.toString();
    }

    public boolean U0() {
        return this.f46594m.U();
    }

    public boolean V0() {
        return this.f46594m.V();
    }

    public boolean W0() {
        return this.f46594m.W();
    }

    @NotNull
    public String W1(@NotNull String message) {
        g0.p(message, "message");
        int i6 = b.f46598a[f1().ordinal()];
        if (i6 == 1) {
            return message;
        }
        if (i6 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "<i>" + message + "</i>";
    }

    public boolean X0() {
        return this.f46594m.X();
    }

    public boolean Y0() {
        return this.f46594m.Y();
    }

    public boolean Z0() {
        return this.f46594m.Z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void a(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        g0.p(parameterNameRenderingPolicy, "<set-?>");
        this.f46594m.a(parameterNameRenderingPolicy);
    }

    public boolean a1() {
        return this.f46594m.a0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public boolean b() {
        return this.f46594m.b();
    }

    public boolean b1() {
        return this.f46594m.b0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> c() {
        return this.f46594m.c();
    }

    public boolean c1() {
        return this.f46594m.c0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public boolean d() {
        return this.f46594m.d();
    }

    public boolean d1() {
        return this.f46594m.d0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    @NotNull
    public AnnotationArgumentsRenderingPolicy e() {
        return this.f46594m.e();
    }

    public boolean e1() {
        return this.f46594m.e0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void f(@NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> set) {
        g0.p(set, "<set-?>");
        this.f46594m.f(set);
    }

    @NotNull
    public RenderingFormat f1() {
        return this.f46594m.f0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void g(@NotNull Set<? extends DescriptorRendererModifier> set) {
        g0.p(set, "<set-?>");
        this.f46594m.g(set);
    }

    @NotNull
    public Function1<t0, t0> g1() {
        return this.f46594m.g0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void h(boolean z5) {
        this.f46594m.h(z5);
    }

    public boolean h1() {
        return this.f46594m.h0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void i(boolean z5) {
        this.f46594m.i(z5);
    }

    public boolean i1() {
        return this.f46594m.i0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void j(boolean z5) {
        this.f46594m.j(z5);
    }

    @NotNull
    public m.b j1() {
        return this.f46594m.j0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void k(boolean z5) {
        this.f46594m.k(z5);
    }

    public boolean k1() {
        return this.f46594m.k0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void l(boolean z5) {
        this.f46594m.l(z5);
    }

    public boolean l1() {
        return this.f46594m.l0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void m(boolean z5) {
        this.f46594m.m(z5);
    }

    public boolean m1() {
        return this.f46594m.m0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void n(@NotNull RenderingFormat renderingFormat) {
        g0.p(renderingFormat, "<set-?>");
        this.f46594m.n(renderingFormat);
    }

    public boolean n1() {
        return this.f46594m.n0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void o(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        g0.p(annotationArgumentsRenderingPolicy, "<set-?>");
        this.f46594m.o(annotationArgumentsRenderingPolicy);
    }

    public boolean o1() {
        return this.f46594m.o0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void p(@NotNull kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        g0.p(aVar, "<set-?>");
        this.f46594m.p(aVar);
    }

    public boolean p1() {
        return this.f46594m.p0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void q(boolean z5) {
        this.f46594m.q(z5);
    }

    @NotNull
    public String s2(@NotNull List<? extends c2> typeArguments) {
        g0.p(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(u1());
        o0(sb, typeArguments);
        sb.append(q1());
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.u
    public void setVerbose(boolean z5) {
        this.f46594m.setVerbose(z5);
    }

    @NotNull
    public String t2(@NotNull w1 typeConstructor) {
        g0.p(typeConstructor, "typeConstructor");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = typeConstructor.c();
        if ((c6 instanceof j1) || (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) || (c6 instanceof i1)) {
            return F1(c6);
        }
        if (c6 == null) {
            return typeConstructor instanceof kotlin.reflect.jvm.internal.impl.types.s0 ? ((kotlin.reflect.jvm.internal.impl.types.s0) typeConstructor).m(o.f46589a) : typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + c6.getClass()).toString());
    }

    public boolean u0() {
        return this.f46594m.v();
    }

    public boolean v0() {
        return this.f46594m.w();
    }

    @Nullable
    public Function1<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> w0() {
        return this.f46594m.x();
    }

    public boolean x0() {
        return this.f46594m.y();
    }

    public boolean y0() {
        return this.f46594m.z();
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.renderer.a z0() {
        return this.f46594m.A();
    }

    private final void A1(StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Set<kotlin.reflect.jvm.internal.impl.name.c> C0;
        if (J0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            if (aVar instanceof t0) {
                C0 = c();
            } else {
                C0 = C0();
            }
            Function1<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> w02 = w0();
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : aVar.getAnnotations()) {
                if (!kotlin.collections.f0.a2(C0, cVar.d()) && !t1(cVar) && (w02 == null || w02.invoke(cVar).booleanValue())) {
                    sb.append(O(cVar, annotationUseSiteTarget));
                    if (B0()) {
                        sb.append('\n');
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    private final void C1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, StringBuilder sb) {
        List<j1> t5 = gVar.t();
        g0.o(t5, "getDeclaredTypeParameters(...)");
        List<j1> parameters = gVar.o().getParameters();
        g0.o(parameters, "getParameters(...)");
        if (k1() && gVar.k() && parameters.size() > t5.size()) {
            sb.append(" /*captured type parameters: ");
            y2(sb, parameters.subList(t5.size(), parameters.size()));
            sb.append("*/");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
        boolean z5;
        kotlin.reflect.jvm.internal.impl.descriptors.c z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        if (dVar.h() == ClassKind.ENUM_ENTRY) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!e1()) {
            List<z0> j02 = dVar.j0();
            g0.o(j02, "getContextReceivers(...)");
            K1(j02, sb);
            B1(this, sb, dVar, null, 2, null);
            if (!z5) {
                kotlin.reflect.jvm.internal.impl.descriptors.s visibility = dVar.getVisibility();
                g0.o(visibility, "getVisibility(...)");
                F2(visibility, sb);
            }
            if ((dVar.h() != ClassKind.INTERFACE || dVar.i() != Modality.ABSTRACT) && (!dVar.h().isSingleton() || dVar.i() != Modality.FINAL)) {
                Modality i6 = dVar.i();
                g0.o(i6, "getModality(...)");
                X1(i6, sb, s1(dVar));
            }
            V1(dVar, sb);
            if (J0().contains(DescriptorRendererModifier.INNER) && dVar.k()) {
                z7 = true;
            } else {
                z7 = false;
            }
            Z1(sb, z7, bi.ax);
            if (J0().contains(DescriptorRendererModifier.DATA) && dVar.w()) {
                z8 = true;
            } else {
                z8 = false;
            }
            Z1(sb, z8, "data");
            if (J0().contains(DescriptorRendererModifier.INLINE) && dVar.isInline()) {
                z9 = true;
            } else {
                z9 = false;
            }
            Z1(sb, z9, Part.INLINE);
            if (J0().contains(DescriptorRendererModifier.VALUE) && dVar.v()) {
                z10 = true;
            } else {
                z10 = false;
            }
            Z1(sb, z10, "value");
            if (J0().contains(DescriptorRendererModifier.FUN) && dVar.u()) {
                z11 = true;
            } else {
                z11 = false;
            }
            Z1(sb, z11, "fun");
            E1(dVar, sb);
        }
        if (!kotlin.reflect.jvm.internal.impl.resolve.i.x(dVar)) {
            if (!e1()) {
                n2(sb);
            }
            a2(dVar, sb, true);
        } else {
            G1(dVar, sb);
        }
        if (z5) {
            return;
        }
        List<j1> t5 = dVar.t();
        g0.o(t5, "getDeclaredTypeParameters(...)");
        z2(t5, sb, false);
        C1(dVar, sb);
        if (!dVar.h().isSingleton() && y0() && (z6 = dVar.z()) != null) {
            sb.append(" ");
            B1(this, sb, z6, null, 2, null);
            kotlin.reflect.jvm.internal.impl.descriptors.s visibility2 = z6.getVisibility();
            g0.o(visibility2, "getVisibility(...)");
            F2(visibility2, sb);
            sb.append(T1("constructor"));
            List<q1> g6 = z6.g();
            g0.o(g6, "getValueParameters(...)");
            D2(g6, z6.n0(), sb);
        }
        o2(dVar, sb);
        G2(t5, sb);
    }

    private final void D2(Collection<? extends q1> collection, boolean z5, StringBuilder sb) {
        boolean I2 = I2(z5);
        int size = collection.size();
        j1().a(size, sb);
        int i6 = 0;
        for (q1 q1Var : collection) {
            j1().c(q1Var, i6, size, sb);
            C2(q1Var, I2, sb, false);
            j1().d(q1Var, i6, size, sb);
            i6++;
        }
        j1().b(size, sb);
    }

    private final void E2(s1 s1Var, boolean z5, StringBuilder sb, boolean z6, boolean z7) {
        q1 q1Var;
        t0 t0Var;
        boolean z8;
        t0 type = s1Var.getType();
        g0.o(type, "getType(...)");
        t0 t0Var2 = null;
        if (s1Var instanceof q1) {
            q1Var = (q1) s1Var;
        } else {
            q1Var = null;
        }
        if (q1Var != null) {
            t0Var2 = q1Var.z0();
        }
        if (t0Var2 == null) {
            t0Var = type;
        } else {
            t0Var = t0Var2;
        }
        if (t0Var2 != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        Z1(sb, z8, "vararg");
        if (z7 || (z6 && !e1())) {
            A2(s1Var, sb, z7);
        }
        if (z5) {
            a2(s1Var, sb, z6);
            sb.append(": ");
        }
        sb.append(T(t0Var));
        S1(s1Var, sb);
        if (k1() && t0Var2 != null) {
            sb.append(" /*");
            sb.append(T(type));
            sb.append("*/");
        }
    }

    private final boolean F2(kotlin.reflect.jvm.internal.impl.descriptors.s sVar, StringBuilder sb) {
        if (!J0().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (K0()) {
            sVar = sVar.f();
        }
        if (!Y0() && g0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f44955l)) {
            return false;
        }
        sb.append(T1(sVar.c()));
        sb.append(" ");
        return true;
    }

    private final void G1(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, StringBuilder sb) {
        if (T0()) {
            if (e1()) {
                sb.append("companion object");
            }
            n2(sb);
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = kVar.b();
            if (b6 != null) {
                sb.append("of ");
                kotlin.reflect.jvm.internal.impl.name.f name = b6.getName();
                g0.o(name, "getName(...)");
                sb.append(S(name, false));
            }
        }
        if (!k1() && g0.g(kVar.getName(), kotlin.reflect.jvm.internal.impl.name.h.f46358d)) {
            return;
        }
        if (!e1()) {
            n2(sb);
        }
        kotlin.reflect.jvm.internal.impl.name.f name2 = kVar.getName();
        g0.o(name2, "getName(...)");
        sb.append(S(name2, true));
    }

    private final void G2(List<? extends j1> list, StringBuilder sb) {
        if (!p1()) {
            ArrayList arrayList = new ArrayList(0);
            for (j1 j1Var : list) {
                List<t0> upperBounds = j1Var.getUpperBounds();
                g0.o(upperBounds, "getUpperBounds(...)");
                for (t0 t0Var : kotlin.collections.f0.g2(upperBounds, 1)) {
                    StringBuilder sb2 = new StringBuilder();
                    kotlin.reflect.jvm.internal.impl.name.f name = j1Var.getName();
                    g0.o(name, "getName(...)");
                    sb2.append(S(name, false));
                    sb2.append(" : ");
                    g0.m(t0Var);
                    sb2.append(T(t0Var));
                    arrayList.add(sb2.toString());
                }
            }
            if (!arrayList.isEmpty()) {
                sb.append(" ");
                sb.append(T1("where"));
                sb.append(" ");
                r0.o3(arrayList, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
            }
        }
    }

    private final boolean H2(t0 t0Var) {
        if (kotlin.reflect.jvm.internal.impl.builtins.i.p(t0Var)) {
            List<c2> G0 = t0Var.G0();
            if (!(G0 instanceof Collection) || !G0.isEmpty()) {
                Iterator<T> it = G0.iterator();
                while (it.hasNext()) {
                    if (((c2) it.next()).b()) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private final boolean I2(boolean z5) {
        int i6 = b.f46599b[N0().ordinal()];
        if (i6 == 1) {
            return true;
        }
        if (i6 != 2) {
            if (i6 == 3) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!z5) {
            return true;
        }
        return false;
    }

    private final String M1(String str) {
        int i6 = b.f46598a[f1().ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                return "<font color=red><b>" + str + "</b></font>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final void N1(StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.a aVar) {
        RenderingFormat f12 = f1();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (f12 == renderingFormat) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* ");
        sb.append("= ");
        c2(sb, aVar.Z());
        sb.append(" */");
        if (f1() == renderingFormat) {
            sb.append("</i></font>");
        }
    }

    private final String O1(t0 t0Var) {
        String T = T(t0Var);
        if ((H2(t0Var) && !j2.l(t0Var)) || (t0Var instanceof kotlin.reflect.jvm.internal.impl.types.z)) {
            return '(' + T + ')';
        }
        return T;
    }

    private final String P1(List<kotlin.reflect.jvm.internal.impl.name.f> list) {
        return r0(a0.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.descriptors.y yVar2;
        StringBuilder sb2;
        String T;
        if (!e1()) {
            if (!d1()) {
                List<z0> A0 = yVar.A0();
                g0.o(A0, "getContextReceiverParameters(...)");
                K1(A0, sb);
                yVar2 = yVar;
                sb2 = sb;
                B1(this, sb2, yVar2, null, 2, null);
                kotlin.reflect.jvm.internal.impl.descriptors.s visibility = yVar2.getVisibility();
                g0.o(visibility, "getVisibility(...)");
                F2(visibility, sb2);
                Y1(yVar2, sb2);
                if (E0()) {
                    V1(yVar2, sb2);
                }
                d2(yVar2, sb2);
                if (E0()) {
                    y1(yVar2, sb2);
                } else {
                    q2(yVar2, sb2);
                }
                U1(yVar2, sb2);
                if (k1()) {
                    if (yVar2.D0()) {
                        sb2.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (yVar2.S()) {
                        sb2.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            } else {
                yVar2 = yVar;
                sb2 = sb;
            }
            sb2.append(T1("fun"));
            sb2.append(" ");
            List<j1> typeParameters = yVar2.getTypeParameters();
            g0.o(typeParameters, "getTypeParameters(...)");
            z2(typeParameters, sb2, true);
            k2(yVar2, sb2);
        } else {
            yVar2 = yVar;
            sb2 = sb;
        }
        a2(yVar2, sb2, true);
        List<q1> g6 = yVar2.g();
        g0.o(g6, "getValueParameters(...)");
        D2(g6, yVar2.n0(), sb2);
        l2(yVar2, sb2);
        t0 returnType = yVar2.getReturnType();
        if (!n1() && (i1() || returnType == null || !kotlin.reflect.jvm.internal.impl.builtins.j.D0(returnType))) {
            sb2.append(": ");
            if (returnType == null) {
                T = "[NULL]";
            } else {
                T = T(returnType);
            }
            sb2.append(T);
        }
        List<j1> typeParameters2 = yVar2.getTypeParameters();
        g0.o(typeParameters2, "getTypeParameters(...)");
        G2(typeParameters2, sb2);
    }

    private final void R1(StringBuilder sb, t0 t0Var) {
        boolean z5;
        boolean z6;
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        boolean z7;
        int length = sb.length();
        B1(D0(), sb, t0Var, null, 2, null);
        if (sb.length() != length) {
            z5 = true;
        } else {
            z5 = false;
        }
        t0 k6 = kotlin.reflect.jvm.internal.impl.builtins.i.k(t0Var);
        List<t0> e6 = kotlin.reflect.jvm.internal.impl.builtins.i.e(t0Var);
        boolean r5 = kotlin.reflect.jvm.internal.impl.builtins.i.r(t0Var);
        boolean J0 = t0Var.J0();
        if (!J0 && (!z5 || k6 == null)) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z6) {
            if (r5) {
                sb.insert(length, '(');
            } else {
                if (z5) {
                    kotlin.text.b.r(kotlin.text.u.U7(sb));
                    if (sb.charAt(kotlin.text.u.y3(sb) - 1) != ')') {
                        sb.insert(kotlin.text.u.y3(sb), "()");
                    }
                }
                sb.append("(");
            }
        }
        Z1(sb, r5, "suspend");
        if (!e6.isEmpty()) {
            sb.append("context(");
            Iterator<t0> it = e6.subList(0, kotlin.collections.f0.L(e6)).iterator();
            while (it.hasNext()) {
                b2(sb, it.next());
                sb.append(", ");
            }
            b2(sb, (t0) kotlin.collections.f0.u3(e6));
            sb.append(") ");
        }
        if (k6 != null) {
            if ((!H2(k6) || k6.J0()) && !r1(k6) && !(k6 instanceof kotlin.reflect.jvm.internal.impl.types.z)) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                sb.append("(");
            }
            b2(sb, k6);
            if (z7) {
                sb.append(")");
            }
            sb.append(".");
        }
        sb.append("(");
        if (kotlin.reflect.jvm.internal.impl.builtins.i.n(t0Var) && t0Var.G0().size() <= 1) {
            sb.append("???");
        } else {
            int i6 = 0;
            for (c2 c2Var : kotlin.reflect.jvm.internal.impl.builtins.i.m(t0Var)) {
                int i7 = i6 + 1;
                if (i6 > 0) {
                    sb.append(", ");
                }
                if (O0()) {
                    t0 type = c2Var.getType();
                    g0.o(type, "getType(...)");
                    fVar = kotlin.reflect.jvm.internal.impl.builtins.i.d(type);
                } else {
                    fVar = null;
                }
                if (fVar != null) {
                    sb.append(S(fVar, false));
                    sb.append(": ");
                }
                sb.append(U(c2Var));
                i6 = i7;
            }
        }
        sb.append(") ");
        sb.append(q0());
        sb.append(" ");
        b2(sb, kotlin.reflect.jvm.internal.impl.builtins.i.l(t0Var));
        if (z6) {
            sb.append(")");
        }
        if (J0) {
            sb.append("?");
        }
    }

    private final void S1(s1 s1Var, StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> t02;
        String H1;
        if (H0() && (t02 = s1Var.t0()) != null && (H1 = H1(t02)) != null) {
            sb.append(" = ");
            sb.append(r0(H1));
        }
    }

    private final String T1(String str) {
        int i6 = b.f46598a[f1().ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                if (!x0()) {
                    return "<b>" + str + "</b>";
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return str;
    }

    private final void U1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (J0().contains(DescriptorRendererModifier.MEMBER_KIND) && k1() && callableMemberDescriptor.h() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            sb.append(f4.a.f(callableMemberDescriptor.h().name()));
            sb.append("*/ ");
        }
    }

    private final void V1(c0 c0Var, StringBuilder sb) {
        boolean z5;
        Z1(sb, c0Var.isExternal(), "external");
        boolean z6 = false;
        if (J0().contains(DescriptorRendererModifier.EXPECT) && c0Var.q0()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Z1(sb, z5, "expect");
        if (J0().contains(DescriptorRendererModifier.ACTUAL) && c0Var.i0()) {
            z6 = true;
        }
        Z1(sb, z6, "actual");
    }

    private final void X1(Modality modality, StringBuilder sb, Modality modality2) {
        if (!X0() && modality == modality2) {
            return;
        }
        Z1(sb, J0().contains(DescriptorRendererModifier.MODALITY), f4.a.f(modality.name()));
    }

    private final void Y1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (!kotlin.reflect.jvm.internal.impl.resolve.i.J(callableMemberDescriptor) || callableMemberDescriptor.i() != Modality.FINAL) {
            if (M0() == OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.i() == Modality.OPEN && v1(callableMemberDescriptor)) {
                return;
            }
            Modality i6 = callableMemberDescriptor.i();
            g0.o(i6, "getModality(...)");
            X1(i6, sb, s1(callableMemberDescriptor));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, StringBuilder sb, boolean z5) {
        kotlin.reflect.jvm.internal.impl.name.f name = kVar.getName();
        g0.o(name, "getName(...)");
        sb.append(S(name, z5));
    }

    private final void b2(StringBuilder sb, t0 t0Var) {
        kotlin.reflect.jvm.internal.impl.types.a aVar;
        m2 L0 = t0Var.L0();
        if (L0 instanceof kotlin.reflect.jvm.internal.impl.types.a) {
            aVar = (kotlin.reflect.jvm.internal.impl.types.a) L0;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if (a1()) {
                c2(sb, aVar.Z());
                if (S0()) {
                    w1(sb, aVar);
                    return;
                }
                return;
            }
            c2(sb, aVar.U0());
            if (b1()) {
                N1(sb, aVar);
                return;
            }
            return;
        }
        c2(sb, t0Var);
    }

    private final void d2(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (J0().contains(DescriptorRendererModifier.OVERRIDE) && v1(callableMemberDescriptor) && M0() != OverrideRenderingPolicy.RENDER_OPEN) {
            Z1(sb, true, "override");
            if (k1()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.e().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(l0 l0Var, StringBuilder sb) {
        f2(l0Var.d(), "package-fragment", sb);
        if (d()) {
            sb.append(" in ");
            a2(l0Var.b(), sb, false);
        }
    }

    private final void f2(kotlin.reflect.jvm.internal.impl.name.c cVar, String str, StringBuilder sb) {
        sb.append(T1(str));
        String R = R(cVar.i());
        if (R.length() > 0) {
            sb.append(" ");
            sb.append(R);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(s0 s0Var, StringBuilder sb) {
        f2(s0Var.d(), WiseOpenHianalyticsData.UNION_PACKAGE, sb);
        if (d()) {
            sb.append(" in context of ");
            a2(s0Var.C0(), sb, false);
        }
    }

    private final void h2(StringBuilder sb, u0 u0Var) {
        u0 c6 = u0Var.c();
        if (c6 != null) {
            h2(sb, c6);
            sb.append('.');
            kotlin.reflect.jvm.internal.impl.name.f name = u0Var.b().getName();
            g0.o(name, "getName(...)");
            sb.append(S(name, false));
        } else {
            w1 o5 = u0Var.b().o();
            g0.o(o5, "getTypeConstructor(...)");
            sb.append(t2(o5));
        }
        sb.append(s2(u0Var.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2(w0 w0Var, StringBuilder sb) {
        w0 w0Var2;
        StringBuilder sb2;
        boolean z5;
        if (!e1()) {
            if (!d1()) {
                List<z0> A0 = w0Var.A0();
                g0.o(A0, "getContextReceiverParameters(...)");
                K1(A0, sb);
                j2(w0Var, sb);
                kotlin.reflect.jvm.internal.impl.descriptors.s visibility = w0Var.getVisibility();
                g0.o(visibility, "getVisibility(...)");
                F2(visibility, sb);
                boolean z6 = false;
                if (J0().contains(DescriptorRendererModifier.CONST) && w0Var.isConst()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Z1(sb, z5, "const");
                V1(w0Var, sb);
                Y1(w0Var, sb);
                d2(w0Var, sb);
                if (J0().contains(DescriptorRendererModifier.LATEINIT) && w0Var.B0()) {
                    z6 = true;
                }
                Z1(sb, z6, "lateinit");
                U1(w0Var, sb);
            }
            w0Var2 = w0Var;
            sb2 = sb;
            B2(this, w0Var2, sb2, false, 4, null);
            List<j1> typeParameters = w0Var2.getTypeParameters();
            g0.o(typeParameters, "getTypeParameters(...)");
            z2(typeParameters, sb2, true);
            k2(w0Var2, sb2);
        } else {
            w0Var2 = w0Var;
            sb2 = sb;
        }
        a2(w0Var2, sb2, true);
        sb2.append(": ");
        t0 type = w0Var2.getType();
        g0.o(type, "getType(...)");
        sb2.append(T(type));
        l2(w0Var2, sb2);
        S1(w0Var2, sb2);
        List<j1> typeParameters2 = w0Var2.getTypeParameters();
        g0.o(typeParameters2, "getTypeParameters(...)");
        G2(typeParameters2, sb2);
    }

    private final void j2(w0 w0Var, StringBuilder sb) {
        if (J0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            B1(this, sb, w0Var, null, 2, null);
            kotlin.reflect.jvm.internal.impl.descriptors.v O = w0Var.O();
            if (O != null) {
                A1(sb, O, AnnotationUseSiteTarget.FIELD);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.v D = w0Var.D();
            if (D != null) {
                A1(sb, D, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (Q0() == PropertyAccessorRenderingPolicy.NONE) {
                x0 getter = w0Var.getGetter();
                if (getter != null) {
                    A1(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                y0 setter = w0Var.getSetter();
                if (setter != null) {
                    A1(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                    List<q1> g6 = setter.g();
                    g0.o(g6, "getValueParameters(...)");
                    q1 q1Var = (q1) kotlin.collections.f0.m5(g6);
                    g0.m(q1Var);
                    A1(sb, q1Var, AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void k2(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb) {
        z0 f02 = aVar.f0();
        if (f02 != null) {
            A1(sb, f02, AnnotationUseSiteTarget.RECEIVER);
            t0 type = f02.getType();
            g0.o(type, "getType(...)");
            sb.append(O1(type));
            sb.append(".");
        }
    }

    private final void l2(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb) {
        z0 f02;
        if (R0() && (f02 = aVar.f0()) != null) {
            sb.append(" on ");
            t0 type = f02.getType();
            g0.o(type, "getType(...)");
            sb.append(T(type));
        }
    }

    private final void n2(StringBuilder sb) {
        int length = sb.length();
        if (length != 0 && sb.charAt(length - 1) == ' ') {
            return;
        }
        sb.append(' ');
    }

    private final void o2(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
        if (!o1() && !kotlin.reflect.jvm.internal.impl.builtins.j.o0(dVar.s())) {
            Collection<t0> i6 = dVar.o().i();
            g0.o(i6, "getSupertypes(...)");
            if (!i6.isEmpty()) {
                if (i6.size() != 1 || !kotlin.reflect.jvm.internal.impl.builtins.j.c0(i6.iterator().next())) {
                    n2(sb);
                    sb.append(": ");
                    r0.o3(i6, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new r(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence p2(t tVar, t0 t0Var) {
        g0.m(t0Var);
        return tVar.T(t0Var);
    }

    private final String q0() {
        int i6 = b.f46598a[f1().ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                return "&rarr;";
            }
            throw new NoWhenBranchMatchedException();
        }
        return r0("->");
    }

    private final void q2(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, StringBuilder sb) {
        Z1(sb, yVar.isSuspend(), "suspend");
    }

    private final String r0(String str) {
        return f1().escape(str);
    }

    private final boolean r1(t0 t0Var) {
        if (!kotlin.reflect.jvm.internal.impl.builtins.i.r(t0Var) && t0Var.getAnnotations().isEmpty()) {
            return false;
        }
        return true;
    }

    private final boolean t1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        return g0.g(cVar.d(), o.a.E);
    }

    private final boolean v1(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.e().isEmpty();
    }

    private final void v2(StringBuilder sb, t0 t0Var, w1 w1Var) {
        u0 d6 = kotlin.reflect.jvm.internal.impl.descriptors.n1.d(t0Var);
        if (d6 == null) {
            sb.append(t2(w1Var));
            sb.append(s2(t0Var.G0()));
        } else {
            h2(sb, d6);
        }
    }

    private final void w1(StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.a aVar) {
        RenderingFormat f12 = f1();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (f12 == renderingFormat) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* ");
        sb.append("from: ");
        c2(sb, aVar.U0());
        sb.append(" */");
        if (f1() == renderingFormat) {
            sb.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(v0 v0Var, StringBuilder sb) {
        V1(v0Var, sb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (v0() != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
    
        if (v0() != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void y1(kotlin.reflect.jvm.internal.impl.descriptors.y r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.isOperator()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "getOverriddenDescriptors(...)"
            if (r0 == 0) goto L3b
            java.util.Collection r0 = r6.e()
            kotlin.jvm.internal.g0.o(r0, r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L1d
            goto L39
        L1d:
            java.util.Iterator r0 = r0.iterator()
        L21:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L39
            java.lang.Object r4 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.y r4 = (kotlin.reflect.jvm.internal.impl.descriptors.y) r4
            boolean r4 = r4.isOperator()
            if (r4 == 0) goto L21
            boolean r0 = r5.v0()
            if (r0 == 0) goto L3b
        L39:
            r0 = 1
            goto L3c
        L3b:
            r0 = 0
        L3c:
            boolean r4 = r6.isInfix()
            if (r4 == 0) goto L72
            java.util.Collection r4 = r6.e()
            kotlin.jvm.internal.g0.o(r4, r3)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L55
            goto L71
        L55:
            java.util.Iterator r3 = r4.iterator()
        L59:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L71
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.descriptors.y r4 = (kotlin.reflect.jvm.internal.impl.descriptors.y) r4
            boolean r4 = r4.isInfix()
            if (r4 == 0) goto L59
            boolean r3 = r5.v0()
            if (r3 == 0) goto L72
        L71:
            r1 = 1
        L72:
            boolean r2 = r6.y()
            java.lang.String r3 = "tailrec"
            r5.Z1(r7, r2, r3)
            r5.q2(r6, r7)
            boolean r6 = r6.isInline()
            java.lang.String r2 = "inline"
            r5.Z1(r7, r6, r2)
            java.lang.String r6 = "infix"
            r5.Z1(r7, r1, r6)
            java.lang.String r6 = "operator"
            r5.Z1(r7, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.t.y1(kotlin.reflect.jvm.internal.impl.descriptors.y, java.lang.StringBuilder):void");
    }

    private final void y2(StringBuilder sb, List<? extends j1> list) {
        Iterator<? extends j1> it = list.iterator();
        while (it.hasNext()) {
            x2(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    private final List<String> z1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
        String str;
        kotlin.reflect.jvm.internal.impl.descriptors.c z5;
        List<q1> g6;
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a6 = cVar.a();
        List list = null;
        if (W0()) {
            dVar = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.l(cVar);
        } else {
            dVar = null;
        }
        if (dVar != null && (z5 = dVar.z()) != null && (g6 = z5.g()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : g6) {
                if (((q1) obj).Q()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((q1) it.next()).getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!a6.containsKey((kotlin.reflect.jvm.internal.impl.name.f) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(kotlin.collections.f0.d0(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((kotlin.reflect.jvm.internal.impl.name.f) it2.next()).b() + " = ...");
        }
        Set<Map.Entry<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> entrySet = a6.entrySet();
        ArrayList arrayList5 = new ArrayList(kotlin.collections.f0.d0(entrySet, 10));
        Iterator<T> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.g) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(fVar.b());
            sb.append(" = ");
            if (!list.contains(fVar)) {
                str = H1(gVar);
            } else {
                str = "...";
            }
            sb.append(str);
            arrayList5.add(sb.toString());
        }
        return kotlin.collections.f0.v5(kotlin.collections.f0.I4(arrayList4, arrayList5));
    }

    private final void z2(List<? extends j1> list, StringBuilder sb, boolean z5) {
        if (!p1() && !list.isEmpty()) {
            sb.append(u1());
            y2(sb, list);
            sb.append(q1());
            if (z5) {
                sb.append(" ");
            }
        }
    }
}
