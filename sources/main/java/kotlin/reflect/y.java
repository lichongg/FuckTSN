package kotlin.reflect;

import com.daimajia.numberprogressbar.BuildConfig;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.f0;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.h0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1563#3:232\n1634#3,3:233\n1563#3:236\n1634#3,3:237\n1563#3:240\n1634#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Class<?>, Class<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f47646a = new b();

        b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Class<?> invoke(Class<?> p02) {
            g0.p(p02, "p0");
            return p02.getComponentType();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47645a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f47645a = iArr;
        }
    }

    static /* synthetic */ Type d(r rVar, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return c(rVar, z5);
    }

    @NotNull
    public static final Type f(@NotNull r rVar) {
        Type b6;
        g0.p(rVar, "<this>");
        return (!(rVar instanceof h0) || (b6 = ((h0) rVar).b()) == null) ? d(rVar, false, 1, null) : b6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            g0.o(name, "getName(...)");
            return name;
        }
        kotlin.sequences.m t5 = kotlin.sequences.p.t(type, b.f47646a);
        return ((Class) kotlin.sequences.p.I1(t5)).getName() + kotlin.text.u.t2("[]", kotlin.sequences.p.E0(t5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalStdlibApi
    public static final Type c(r rVar, boolean z5) {
        Class e6;
        int i6;
        g n6 = rVar.n();
        if (n6 instanceof s) {
            return new x((s) n6);
        }
        if (n6 instanceof d) {
            d dVar = (d) n6;
            if (z5) {
                e6 = l3.a.g(dVar);
            } else {
                e6 = l3.a.e(dVar);
            }
            List<t> arguments = rVar.getArguments();
            if (arguments.isEmpty()) {
                return e6;
            }
            if (e6.isArray()) {
                if (!e6.getComponentType().isPrimitive()) {
                    t tVar = (t) f0.p5(arguments);
                    if (tVar != null) {
                        KVariance a6 = tVar.a();
                        r b6 = tVar.b();
                        if (a6 == null) {
                            i6 = -1;
                        } else {
                            i6 = a.f47645a[a6.ordinal()];
                        }
                        if (i6 != -1 && i6 != 1) {
                            if (i6 != 2 && i6 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            g0.m(b6);
                            Type d6 = d(b6, false, 1, null);
                            if (!(d6 instanceof Class)) {
                                return new kotlin.reflect.a(d6);
                            }
                            return e6;
                        }
                        return e6;
                    }
                    throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + rVar);
                }
                return e6;
            }
            return e(e6, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + rVar);
    }

    @ExperimentalStdlibApi
    private static final Type e(Class<?> cls, List<t> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<t> list2 = list;
            ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(g((t) it.next()));
            }
            return new u(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<t> list3 = list;
            ArrayList arrayList2 = new ArrayList(f0.d0(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((t) it2.next()));
            }
            return new u(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type e6 = e(declaringClass, list.subList(length, list.size()));
        List<t> subList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(f0.d0(subList, 10));
        Iterator<T> it3 = subList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((t) it3.next()));
        }
        return new u(cls, e6, arrayList3);
    }

    private static final Type g(t tVar) {
        KVariance g6 = tVar.g();
        if (g6 == null) {
            return z.f47647c.a();
        }
        r type = tVar.getType();
        g0.m(type);
        int i6 = a.f47645a[g6.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return new z(c(type, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return c(type, true);
        }
        return new z(null, c(type, true));
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalStdlibApi
    public static /* synthetic */ void h(r rVar) {
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void i(t tVar) {
    }
}
