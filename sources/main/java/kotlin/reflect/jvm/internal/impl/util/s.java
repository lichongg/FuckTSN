package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.util.a0;
import kotlin.reflect.jvm.internal.impl.util.k;
import kotlin.reflect.jvm.internal.impl.util.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nmodifierChecks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 modifierChecks.kt\norg/jetbrains/kotlin/util/OperatorChecks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 modifierChecks.kt\norg/jetbrains/kotlin/util/AbstractModifierChecks\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1#2:265\n171#3:266\n171#3:270\n171#3:271\n1761#4,3:267\n*S KotlinDebug\n*F\n+ 1 modifierChecks.kt\norg/jetbrains/kotlin/util/OperatorChecks\n*L\n189#1:266\n203#1:270\n220#1:271\n203#1:267,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s extends b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f47421a = new s();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<h> f47422b;

    static {
        kotlin.reflect.jvm.internal.impl.name.f fVar = t.f47440k;
        k.b bVar = k.b.f47410b;
        h hVar = new h(fVar, new f[]{bVar, new a0.a(1)}, (Function1) null, 4, (kotlin.jvm.internal.v) null);
        h hVar2 = new h(t.f47441l, new f[]{bVar, new a0.a(2)}, p.f47418a);
        kotlin.reflect.jvm.internal.impl.name.f fVar2 = t.f47425b;
        m mVar = m.f47412a;
        a0.a aVar = new a0.a(2);
        j jVar = j.f47406a;
        h hVar3 = new h(fVar2, new f[]{bVar, mVar, aVar, jVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null);
        h hVar4 = new h(t.f47427c, new f[]{bVar, mVar, new a0.a(3), jVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null);
        h hVar5 = new h(t.f47429d, new f[]{bVar, mVar, new a0.b(2), jVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null);
        h hVar6 = new h(t.f47438i, new f[]{bVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null);
        kotlin.reflect.jvm.internal.impl.name.f fVar3 = t.f47437h;
        a0.d dVar = a0.d.f47386b;
        v.a aVar2 = v.a.f47460d;
        h hVar7 = new h(fVar3, new f[]{bVar, dVar, mVar, aVar2}, (Function1) null, 4, (kotlin.jvm.internal.v) null);
        kotlin.reflect.jvm.internal.impl.name.f fVar4 = t.f47439j;
        a0.c cVar = a0.c.f47385b;
        f47422b = f0.Q(hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, new h(fVar4, new f[]{bVar, cVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.f47442m, new f[]{bVar, cVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.f47443n, new f[]{bVar, cVar, aVar2}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.H, new f[]{bVar, dVar, mVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.I, new f[]{bVar, dVar, mVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.f47431e, new f[]{k.a.f47409b}, q.f47419a), new h(t.f47435g, new f[]{bVar, v.b.f47461d, dVar, mVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.X, new f[]{bVar, dVar, mVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.W, new f[]{bVar, cVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(f0.Q(t.f47453x, t.f47454y), new f[]{bVar}, r.f47420a), new h(t.f47428c0, new f[]{bVar, v.c.f47462d, dVar, mVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null), new h(t.f47445p, new f[]{bVar, cVar}, (Function1) null, 4, (kotlin.jvm.internal.v) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(kotlin.reflect.jvm.internal.impl.descriptors.y Checks) {
        g0.p(Checks, "$this$Checks");
        List<q1> g6 = Checks.g();
        g0.o(g6, "getValueParameters(...)");
        q1 q1Var = (q1) f0.A3(g6);
        boolean z5 = false;
        if (q1Var != null && !kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.f(q1Var) && q1Var.z0() == null) {
            z5 = true;
        }
        if (z5) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String g(kotlin.reflect.jvm.internal.impl.descriptors.y r3) {
        /*
            java.lang.String r0 = "$this$Checks"
            kotlin.jvm.internal.g0.p(r3, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.k r0 = r3.b()
            java.lang.String r1 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.g0.o(r0, r1)
            boolean r0 = h(r0)
            if (r0 != 0) goto L50
            java.util.Collection r0 = r3.e()
            java.lang.String r2 = "getOverriddenDescriptors(...)"
            kotlin.jvm.internal.g0.o(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L29
            goto L47
        L29:
            java.util.Iterator r0 = r0.iterator()
        L2d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L47
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.y r2 = (kotlin.reflect.jvm.internal.impl.descriptors.y) r2
            kotlin.reflect.jvm.internal.impl.descriptors.k r2 = r2.b()
            kotlin.jvm.internal.g0.o(r2, r1)
            boolean r2 = h(r2)
            if (r2 == 0) goto L2d
            goto L50
        L47:
            boolean r0 = kotlin.reflect.jvm.internal.impl.descriptors.q.c(r3)
            if (r0 == 0) goto L4e
            goto L50
        L4e:
            r0 = 0
            goto L51
        L50:
            r0 = 1
        L51:
            if (r0 != 0) goto La6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "must override ''equals()'' in Any"
            r0.append(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.k r2 = r3.b()
            kotlin.jvm.internal.g0.o(r2, r1)
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.j.g(r2)
            if (r1 == 0) goto La1
            kotlin.reflect.jvm.internal.impl.renderer.m r1 = kotlin.reflect.jvm.internal.impl.renderer.m.f46583j
            kotlin.reflect.jvm.internal.impl.descriptors.k r3 = r3.b()
            java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.g0.n(r3, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.d r3 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r3
            kotlin.reflect.jvm.internal.impl.types.e1 r3 = r3.s()
            java.lang.String r2 = "getDefaultType(...)"
            kotlin.jvm.internal.g0.o(r3, r2)
            kotlin.reflect.jvm.internal.impl.types.t0 r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.E(r3)
            java.lang.String r3 = r1.T(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " or define ''equals(other: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "): Boolean''"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.append(r3)
        La1:
            java.lang.String r3 = r0.toString()
            return r3
        La6:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.s.g(kotlin.reflect.jvm.internal.impl.descriptors.y):java.lang.String");
    }

    private static final boolean h(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && kotlin.reflect.jvm.internal.impl.builtins.j.b0((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(kotlin.reflect.jvm.internal.impl.descriptors.y Checks) {
        boolean z5;
        g0.p(Checks, "$this$Checks");
        z0 c02 = Checks.c0();
        if (c02 == null) {
            c02 = Checks.f0();
        }
        s sVar = f47421a;
        boolean z6 = false;
        if (c02 != null) {
            t0 returnType = Checks.getReturnType();
            if (returnType != null) {
                t0 type = c02.getType();
                g0.o(type, "getType(...)");
                z5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.x(returnType, type);
            } else {
                z5 = false;
            }
            if (z5 || sVar.j(Checks, c02)) {
                z6 = true;
            }
        }
        if (z6) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @NotNull
    public List<h> b() {
        return f47422b;
    }

    private s() {
    }

    private final boolean j(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, z0 z0Var) {
        kotlin.reflect.jvm.internal.impl.name.b n6;
        i1 i1Var;
        t0 returnType;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h value = z0Var.getValue();
        g0.o(value, "getValue(...)");
        if (!(value instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d m6 = ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e) value).m();
        if (!m6.q0() || (n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(m6)) == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = kotlin.reflect.jvm.internal.impl.descriptors.x.c(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.s(m6), n6);
        if (c6 instanceof i1) {
            i1Var = (i1) c6;
        } else {
            i1Var = null;
        }
        if (i1Var == null || (returnType = yVar.getReturnType()) == null) {
            return false;
        }
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.x(returnType, i1Var.Z());
    }
}
