package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;
import kotlin.reflect.jvm.internal.impl.km.a0;
import kotlin.reflect.jvm.internal.impl.km.h;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.p;
import kotlin.reflect.jvm.internal.impl.km.s;
import kotlin.reflect.jvm.internal.impl.km.t;
import kotlin.reflect.jvm.internal.impl.km.u;
import kotlin.reflect.jvm.internal.impl.km.w;
import kotlin.reflect.jvm.internal.impl.km.x;
import kotlin.reflect.jvm.internal.impl.km.y;
import kotlin.reflect.jvm.internal.impl.km.z;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.i;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWriters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Writers.kt\nkotlin/metadata/internal/WritersKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,427:1\n1869#2,2:428\n1869#2,2:430\n1869#2,2:432\n1869#2,2:435\n1869#2,2:437\n1617#2,9:439\n1869#2:448\n1870#2:450\n1626#2:451\n1869#2,2:452\n1563#2:454\n1634#2,3:455\n1563#2:458\n1634#2,3:459\n1563#2:462\n1634#2,3:463\n1617#2,9:466\n1869#2:475\n1870#2:477\n1626#2:478\n1869#2,2:479\n1869#2,2:481\n1563#2:483\n1634#2,3:484\n1617#2,9:487\n1869#2:496\n1870#2:498\n1626#2:499\n1869#2,2:500\n1869#2,2:502\n1563#2:504\n1634#2,3:505\n1563#2:508\n1634#2,3:509\n1617#2,9:512\n1869#2:521\n1870#2:523\n1626#2:524\n1869#2,2:525\n1869#2,2:527\n1563#2:529\n1634#2,3:530\n1563#2:533\n1634#2,3:534\n1563#2:537\n1634#2,3:538\n1563#2:541\n1634#2,3:542\n1#3:434\n1#3:449\n1#3:476\n1#3:497\n1#3:522\n*S KotlinDebug\n*F\n+ 1 Writers.kt\nkotlin/metadata/internal/WritersKt\n*L\n39#1:428,2\n42#1:430,2\n85#1:432,2\n97#1:435,2\n112#1:437,2\n115#1:439,9\n115#1:448\n115#1:450\n115#1:451\n116#1:452,2\n129#1:454\n129#1:455,3\n133#1:458\n133#1:459,3\n134#1:462\n134#1:463,3\n136#1:466,9\n136#1:475\n136#1:477\n136#1:478\n141#1:479,2\n156#1:481,2\n162#1:483\n162#1:484,3\n165#1:487,9\n165#1:496\n165#1:498\n165#1:499\n167#1:500,2\n196#1:502,2\n210#1:504\n210#1:505,3\n213#1:508\n213#1:509,3\n214#1:512,9\n214#1:521\n214#1:523\n214#1:524\n215#1:525,2\n271#1:527,2\n280#1:529\n280#1:530,3\n290#1:533\n290#1:534,3\n325#1:537\n325#1:538,3\n326#1:541\n326#1:542,3\n115#1:449\n136#1:476\n165#1:497\n214#1:522\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45205a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f45206b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f45207c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f45208d;

        static {
            int[] iArr = new int[KmVersionRequirementVersionKind.values().length];
            try {
                iArr[KmVersionRequirementVersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f45205a = iArr;
            int[] iArr2 = new int[KmVersionRequirementLevel.values().length];
            try {
                iArr2[KmVersionRequirementLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[KmVersionRequirementLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[KmVersionRequirementLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f45206b = iArr2;
            int[] iArr3 = new int[KmEffectType.values().length];
            try {
                iArr3[KmEffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[KmEffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[KmEffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            f45207c = iArr3;
            int[] iArr4 = new int[KmEffectInvocationKind.values().length];
            try {
                iArr4[KmEffectInvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[KmEffectInvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[KmEffectInvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            f45208d = iArr4;
        }
    }

    @NotNull
    public static final ProtoBuf.Property.b c(@NotNull h hVar, @NotNull s kmProperty) {
        g0.p(hVar, "<this>");
        g0.p(kmProperty, "kmProperty");
        ProtoBuf.Property.b newBuilder = ProtoBuf.Property.newBuilder();
        Iterator<T> it = kmProperty.n().iterator();
        while (it.hasNext()) {
            newBuilder.F(e(hVar, (w) it.next()).build());
        }
        u j6 = kmProperty.j();
        if (j6 != null) {
            newBuilder.I0(d(hVar, j6).build());
        }
        List<u> c6 = kmProperty.c();
        ArrayList arrayList = new ArrayList(f0.d0(c6, 10));
        Iterator<T> it2 = c6.iterator();
        while (it2.hasNext()) {
            arrayList.add(d(hVar, (u) it2.next()).build());
        }
        newBuilder.z(arrayList);
        y m6 = kmProperty.m();
        if (m6 != null) {
            newBuilder.N0(g(hVar, m6).build());
        }
        newBuilder.K0(d(hVar, kmProperty.k()).build());
        List<a0> o5 = kmProperty.o();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it3 = o5.iterator();
        while (it3.hasNext()) {
            Integer h6 = h(hVar, (a0) it3.next());
            if (h6 != null) {
                arrayList2.add(h6);
            }
        }
        newBuilder.E(arrayList2);
        for (p pVar : hVar.c()) {
            g0.m(newBuilder);
            pVar.s(kmProperty, newBuilder, hVar);
        }
        newBuilder.G0(hVar.a(kmProperty.i()));
        int g6 = kmProperty.g();
        b.C0902b c0902b = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c;
        int e6 = g6 | c0902b.e(Boolean.valueOf(!kmProperty.a().isEmpty()));
        if (e6 != ProtoBuf.Property.getDefaultInstance().getFlags()) {
            newBuilder.E0(e6);
        }
        newBuilder.F0(kmProperty.h().b() | c0902b.e(Boolean.valueOf(!kmProperty.h().a().isEmpty())));
        t l6 = kmProperty.l();
        if (l6 != null) {
            newBuilder.M0(c0902b.e(Boolean.valueOf(!l6.a().isEmpty())) | l6.b());
        }
        g0.m(newBuilder);
        return newBuilder;
    }

    private static final ProtoBuf.Type.b d(h hVar, u uVar) {
        ProtoBuf.Type.b newBuilder = ProtoBuf.Type.newBuilder();
        kotlin.reflect.jvm.internal.impl.km.h c6 = uVar.c();
        if (c6 instanceof h.a) {
            newBuilder.U(hVar.b(((h.a) c6).a()));
        } else if (c6 instanceof h.b) {
            newBuilder.c0(hVar.b(((h.b) c6).a()));
        } else if (c6 instanceof h.c) {
            newBuilder.d0(((h.c) c6).a());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Iterator<T> it = uVar.b().iterator();
        while (it.hasNext()) {
            newBuilder.x(f(hVar, (x) it.next()));
        }
        u a6 = uVar.a();
        if (a6 != null) {
            newBuilder.S(d(hVar, a6).build());
        }
        u g6 = uVar.g();
        if (g6 != null) {
            newBuilder.a0(d(hVar, g6).build());
        }
        kotlin.reflect.jvm.internal.impl.km.p f6 = uVar.f();
        if (f6 != null) {
            ProtoBuf.Type.b d6 = d(hVar, f6.getType());
            String a7 = f6.a();
            if (a7 != null) {
                newBuilder.W(hVar.a(a7));
            }
            newBuilder.X(d6.build());
        }
        for (p pVar : hVar.c()) {
            g0.m(newBuilder);
            pVar.o(uVar, newBuilder, hVar);
        }
        if (kotlin.reflect.jvm.internal.impl.km.a.f(uVar)) {
            newBuilder.Z(true);
        }
        int e6 = uVar.e() >> 1;
        if (e6 != ProtoBuf.Type.getDefaultInstance().getFlags()) {
            newBuilder.V(e6);
        }
        g0.m(newBuilder);
        return newBuilder;
    }

    private static final ProtoBuf.TypeParameter.b e(h hVar, w wVar) {
        ProtoBuf.TypeParameter.b newBuilder = ProtoBuf.TypeParameter.newBuilder();
        Iterator<T> it = wVar.e().iterator();
        while (it.hasNext()) {
            newBuilder.x(d(hVar, (u) it.next()).build());
        }
        for (p pVar : hVar.c()) {
            g0.m(newBuilder);
            pVar.i(wVar, newBuilder, hVar);
        }
        newBuilder.N(hVar.a(wVar.d()));
        newBuilder.M(wVar.c());
        boolean g6 = kotlin.reflect.jvm.internal.impl.km.a.g(wVar);
        if (g6 != ProtoBuf.TypeParameter.getDefaultInstance().getReified()) {
            newBuilder.O(g6);
        }
        if (wVar.f() == KmVariance.IN) {
            newBuilder.P(ProtoBuf.TypeParameter.Variance.IN);
        } else if (wVar.f() == KmVariance.OUT) {
            newBuilder.P(ProtoBuf.TypeParameter.Variance.OUT);
        }
        g0.m(newBuilder);
        return newBuilder;
    }

    private static final ProtoBuf.Type.Argument.b f(h hVar, x xVar) {
        ProtoBuf.Type.Argument.b newBuilder = ProtoBuf.Type.Argument.newBuilder();
        if (g0.g(xVar, x.f45322d)) {
            newBuilder.y(ProtoBuf.Type.Argument.Projection.STAR);
        } else {
            KmVariance a6 = xVar.a();
            u b6 = xVar.b();
            if (a6 != null && b6 != null) {
                if (a6 == KmVariance.IN) {
                    newBuilder.y(ProtoBuf.Type.Argument.Projection.IN);
                } else if (a6 == KmVariance.OUT) {
                    newBuilder.y(ProtoBuf.Type.Argument.Projection.OUT);
                }
                newBuilder.z(d(hVar, b6).build());
            } else {
                throw new InconsistentKotlinMetadataException("Variance and type must be set for non-star type projection", null, 2, null);
            }
        }
        g0.m(newBuilder);
        return newBuilder;
    }

    private static final ProtoBuf.ValueParameter.b g(h hVar, y yVar) {
        ProtoBuf.ValueParameter.b newBuilder = ProtoBuf.ValueParameter.newBuilder();
        newBuilder.V(d(hVar, yVar.getType()).build());
        u e6 = yVar.e();
        if (e6 != null) {
            newBuilder.X(d(hVar, e6).build());
        }
        kotlin.reflect.jvm.internal.impl.km.e a6 = yVar.a();
        if (a6 != null) {
            newBuilder.S(i.c(a6, hVar.d()).build());
        }
        for (p pVar : hVar.c()) {
            g0.m(newBuilder);
            pVar.c(yVar, newBuilder, hVar);
        }
        int c6 = yVar.c() | kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c.e(Boolean.valueOf(!yVar.b().isEmpty()));
        if (c6 != ProtoBuf.ValueParameter.getDefaultInstance().getFlags()) {
            newBuilder.T(c6);
        }
        newBuilder.U(hVar.a(yVar.d()));
        g0.m(newBuilder);
        return newBuilder;
    }

    private static final Integer h(h hVar, a0 a0Var) {
        ProtoBuf.VersionRequirement.VersionKind versionKind;
        ProtoBuf.VersionRequirement.Level level;
        KmVersionRequirementVersionKind b6 = a0Var.b();
        KmVersionRequirementLevel c6 = a0Var.c();
        Integer a6 = a0Var.a();
        String d6 = a0Var.d();
        ProtoBuf.VersionRequirement.b newBuilder = ProtoBuf.VersionRequirement.newBuilder();
        int i6 = a.f45205a[b6.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                versionKind = ProtoBuf.VersionRequirement.VersionKind.API_VERSION;
            } else {
                versionKind = ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION;
            }
        } else {
            versionKind = ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
        }
        if (versionKind != newBuilder.h().getVersionKind()) {
            newBuilder.B(versionKind);
        }
        int i7 = a.f45206b[c6.ordinal()];
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 == 3) {
                    level = ProtoBuf.VersionRequirement.Level.HIDDEN;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                level = ProtoBuf.VersionRequirement.Level.ERROR;
            }
        } else {
            level = ProtoBuf.VersionRequirement.Level.WARNING;
        }
        if (level != newBuilder.h().getLevel()) {
            newBuilder.x(level);
        }
        if (a6 != null) {
            newBuilder.w(a6.intValue());
        }
        if (d6 != null) {
            newBuilder.y(hVar.a(d6));
        }
        z e6 = a0Var.e();
        new i.b(e6.a(), e6.b(), e6.c()).e(new j(newBuilder), new k(newBuilder));
        kotlin.reflect.jvm.internal.impl.metadata.serialization.c e7 = hVar.e();
        g0.m(newBuilder);
        return Integer.valueOf(e7.a(newBuilder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 i(ProtoBuf.VersionRequirement.b bVar, int i6) {
        g0.m(bVar);
        bVar.z(i6);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 j(ProtoBuf.VersionRequirement.b bVar, int i6) {
        g0.m(bVar);
        bVar.A(i6);
        return n1.f44123a;
    }
}
