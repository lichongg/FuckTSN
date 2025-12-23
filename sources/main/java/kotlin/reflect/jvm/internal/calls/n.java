package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.g2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.p3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nValueClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCallerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,392:1\n1#2:393\n1563#3:394\n1634#3,3:395\n1563#3:398\n1634#3,3:399\n1634#3,3:402\n1761#3,3:405\n1761#3,3:408\n1374#3:411\n1460#3,2:412\n1563#3:414\n1634#3,3:415\n1462#3,3:418\n*S KotlinDebug\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCallerKt\n*L\n262#1:394\n262#1:395,3\n264#1:398\n264#1:399,3\n308#1:402,3\n328#1:405,3\n329#1:408,3\n257#1:411\n257#1:412,2\n258#1:414\n258#1:415,3\n257#1:418,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {
    @Nullable
    public static final Object h(@Nullable Object obj, @NotNull CallableMemberDescriptor descriptor) {
        t0 l6;
        Class<?> t5;
        Method m6;
        g0.p(descriptor, "descriptor");
        return (((descriptor instanceof w0) && kotlin.reflect.jvm.internal.impl.resolve.j.e((s1) descriptor)) || (l6 = l(descriptor)) == null || (t5 = t(l6)) == null || (m6 = m(t5, descriptor)) == null) ? obj : m6.invoke(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <M extends Member> g<M> i(@NotNull g<? extends M> gVar, @NotNull CallableMemberDescriptor descriptor, boolean z5) {
        g0.p(gVar, "<this>");
        g0.p(descriptor, "descriptor");
        if (!kotlin.reflect.jvm.internal.impl.resolve.j.a(descriptor)) {
            List<z0> A0 = descriptor.A0();
            g0.o(A0, "getContextReceiverParameters(...)");
            List<z0> list = A0;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    t0 type = ((z0) it.next()).getType();
                    g0.o(type, "getType(...)");
                    if (kotlin.reflect.jvm.internal.impl.resolve.j.h(type)) {
                        break;
                    }
                }
            }
            List<q1> g6 = descriptor.g();
            g0.o(g6, "getValueParameters(...)");
            List<q1> list2 = g6;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    t0 type2 = ((q1) it2.next()).getType();
                    g0.o(type2, "getType(...)");
                    if (kotlin.reflect.jvm.internal.impl.resolve.j.h(type2)) {
                        break;
                    }
                }
            }
            t0 returnType = descriptor.getReturnType();
            if ((returnType == null || !kotlin.reflect.jvm.internal.impl.resolve.j.c(returnType)) && !q(descriptor)) {
                return gVar;
            }
        }
        return new m(descriptor, gVar, z5);
    }

    public static /* synthetic */ g j(g gVar, CallableMemberDescriptor callableMemberDescriptor, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return i(gVar, callableMemberDescriptor, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method k(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", m(cls, callableMemberDescriptor).getReturnType());
            g0.m(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    @NotNull
    public static final Method m(@NotNull Class<?> cls, @NotNull CallableMemberDescriptor descriptor) {
        g0.p(cls, "<this>");
        g0.p(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            g0.m(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    @Nullable
    public static final List<Method> n(@NotNull e1 type) {
        g0.p(type, "type");
        List<String> o5 = o(g2.a(type));
        if (o5 == null) {
            return null;
        }
        List<String> list = o5;
        ArrayList arrayList = new ArrayList(f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("unbox-impl-" + ((String) it.next()));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = type.I0().c();
        g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> s5 = p3.s((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
        g0.m(s5);
        ArrayList arrayList2 = new ArrayList(f0.d0(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(s5.getDeclaredMethod((String) it2.next(), null));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<t0> r(CallableMemberDescriptor callableMemberDescriptor, Member member, Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.d, Boolean> function1) {
        ArrayList arrayList = new ArrayList();
        z0 f02 = callableMemberDescriptor.f0();
        t0 type = f02 != null ? f02.getType() : null;
        if (type != null) {
            arrayList.add(type);
        } else if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
            kotlin.reflect.jvm.internal.impl.descriptors.d J = ((kotlin.reflect.jvm.internal.impl.descriptors.j) callableMemberDescriptor).J();
            g0.o(J, "getConstructedClass(...)");
            if (J.k()) {
                kotlin.reflect.jvm.internal.impl.descriptors.k b6 = J.b();
                g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.d) b6).s());
            }
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.k b7 = callableMemberDescriptor.b();
            g0.o(b7, "getContainingDeclaration(...)");
            if ((b7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && function1.invoke(b7).booleanValue()) {
                if (member == null || !a(member)) {
                    arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.d) b7).s());
                } else {
                    e1 s5 = ((kotlin.reflect.jvm.internal.impl.descriptors.d) b7).s();
                    g0.o(s5, "getDefaultType(...)");
                    arrayList.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.C(s5));
                }
            }
        }
        List<q1> g6 = callableMemberDescriptor.g();
        g0.o(g6, "getValueParameters(...)");
        Iterator<T> it = g6.iterator();
        while (it.hasNext()) {
            arrayList.add(((q1) it.next()).getType());
        }
        return arrayList;
    }

    @Nullable
    public static final Class<?> s(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (!(kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) || !kotlin.reflect.jvm.internal.impl.resolve.j.b(kVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar;
        Class<?> s5 = p3.s(dVar);
        if (s5 != null) {
            return s5;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + dVar.getName() + " cannot be found (classId=" + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n((kotlin.reflect.jvm.internal.impl.descriptors.f) kVar) + ')');
    }

    @NotNull
    public static final String u(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        g0.p(fVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(fVar);
        g0.m(n6);
        return kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.b.b(n6.b());
    }

    private static final boolean a(Member member) {
        if (member.getDeclaringClass() == null) {
            return false;
        }
        return !l3.a.i(r0).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(g<?> gVar, int i6, CallableMemberDescriptor callableMemberDescriptor, boolean z5) {
        if (i.a(gVar) == i6) {
            return;
        }
        throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + i.a(gVar) + " != " + i6 + "\nCalling: " + callableMemberDescriptor + "\nParameter types: " + gVar.b() + ")\nDefault: " + z5);
    }

    private static final t0 l(CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
        z0 f02 = callableMemberDescriptor.f0();
        z0 c02 = callableMemberDescriptor.c0();
        if (f02 != null) {
            return f02.getType();
        }
        if (c02 == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
            return c02.getType();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = callableMemberDescriptor.b();
        if (b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) b6;
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return null;
        }
        return dVar.s();
    }

    private static final List<String> o(e1 e1Var) {
        Collection l6;
        if (kotlin.reflect.jvm.internal.impl.resolve.j.i(e1Var)) {
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = e1Var.I0().c();
            g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            kotlin.reflect.jvm.internal.impl.descriptors.g0<e1> t5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.t((kotlin.reflect.jvm.internal.impl.descriptors.d) c6);
            g0.m(t5);
            List<Pair<kotlin.reflect.jvm.internal.impl.name.f, e1>> c7 = t5.c();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = c7.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) pair.component1();
                List<String> o5 = o((e1) pair.component2());
                if (o5 != null) {
                    List<String> list = o5;
                    l6 = new ArrayList(f0.d0(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        l6.add(fVar.getIdentifier() + '-' + ((String) it2.next()));
                    }
                } else {
                    l6 = f0.l(fVar.getIdentifier());
                }
                f0.s0(arrayList, l6);
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Method> p(e1 e1Var, CallableMemberDescriptor callableMemberDescriptor) {
        Method m6;
        List<Method> n6 = n(e1Var);
        if (n6 == null) {
            Class<?> t5 = t(e1Var);
            if (t5 != null && (m6 = m(t5, callableMemberDescriptor)) != null) {
                return f0.l(m6);
            }
            return null;
        }
        return n6;
    }

    private static final boolean q(CallableMemberDescriptor callableMemberDescriptor) {
        t0 l6 = l(callableMemberDescriptor);
        if (l6 == null || !kotlin.reflect.jvm.internal.impl.resolve.j.h(l6)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Class<?> t(t0 t0Var) {
        t0 k6;
        Class<?> s5 = s(t0Var.I0().c());
        if (s5 == null) {
            return null;
        }
        if (j2.l(t0Var) && ((k6 = kotlin.reflect.jvm.internal.impl.resolve.j.k(t0Var)) == null || j2.l(k6) || kotlin.reflect.jvm.internal.impl.builtins.j.t0(k6))) {
            return null;
        }
        return s5;
    }
}
