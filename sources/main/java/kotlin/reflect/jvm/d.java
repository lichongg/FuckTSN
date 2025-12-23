package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.h;
import kotlin.reflect.i;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.a2;
import kotlin.reflect.jvm.internal.calls.g;
import kotlin.reflect.jvm.internal.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.jvm.internal.p3;
import kotlin.reflect.jvm.internal.z2;
import kotlin.reflect.n;
import kotlin.reflect.r;
import kotlin.reflect.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "ReflectJvmMapping")
@SourceDebugExtension({"SMAP\nReflectJvmMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJvmMapping.kt\nkotlin/reflect/jvm/ReflectJvmMapping\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n1#2:180\n295#3,2:181\n*S KotlinDebug\n*F\n+ 1 ReflectJvmMapping.kt\nkotlin/reflect/jvm/ReflectJvmMapping\n*L\n177#1:181,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44233a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f44233a = iArr;
        }
    }

    @Nullable
    public static final <T> Constructor<T> c(@NotNull i<? extends T> iVar) {
        g<?> W;
        g0.p(iVar, "<this>");
        e0<?> b6 = p3.b(iVar);
        Object c6 = (b6 == null || (W = b6.W()) == null) ? null : W.c();
        if (c6 instanceof Constructor) {
            return (Constructor) c6;
        }
        return null;
    }

    @Nullable
    public static final Field e(@NotNull n<?> nVar) {
        g0.p(nVar, "<this>");
        p2<?> d6 = p3.d(nVar);
        if (d6 != null) {
            return d6.o0();
        }
        return null;
    }

    @Nullable
    public static final Method f(@NotNull n<?> nVar) {
        g0.p(nVar, "<this>");
        return g(nVar.n0());
    }

    @Nullable
    public static final Method g(@NotNull i<?> iVar) {
        g<?> W;
        g0.p(iVar, "<this>");
        e0<?> b6 = p3.b(iVar);
        Object c6 = (b6 == null || (W = b6.W()) == null) ? null : W.c();
        if (c6 instanceof Method) {
            return (Method) c6;
        }
        return null;
    }

    @Nullable
    public static final Method h(@NotNull j<?> jVar) {
        g0.p(jVar, "<this>");
        return g(jVar.getSetter());
    }

    @NotNull
    public static final Type i(@NotNull r rVar) {
        g0.p(rVar, "<this>");
        Type b6 = ((z2) rVar).b();
        return b6 == null ? y.f(rVar) : b6;
    }

    private static final h j(Member member) {
        KotlinClassHeader e6;
        f.a aVar = f.f44967c;
        Class<?> declaringClass = member.getDeclaringClass();
        g0.o(declaringClass, "getDeclaringClass(...)");
        f a6 = aVar.a(declaringClass);
        KotlinClassHeader.Kind c6 = (a6 == null || (e6 = a6.e()) == null) ? null : e6.c();
        int i6 = c6 == null ? -1 : a.f44233a[c6.ordinal()];
        if (i6 != 1 && i6 != 2 && i6 != 3) {
            return null;
        }
        Class<?> declaringClass2 = member.getDeclaringClass();
        g0.o(declaringClass2, "getDeclaringClass(...)");
        return new a2(declaringClass2);
    }

    @Nullable
    public static final <T> i<T> k(@NotNull Constructor<T> constructor) {
        T t5;
        g0.p(constructor, "<this>");
        Class<T> declaringClass = constructor.getDeclaringClass();
        g0.o(declaringClass, "getDeclaringClass(...)");
        Iterator<T> it = l3.a.i(declaringClass).f().iterator();
        while (true) {
            if (!it.hasNext()) {
                t5 = null;
                break;
            }
            t5 = it.next();
            if (g0.g(c((i) t5), constructor)) {
                break;
            }
        }
        return (i) t5;
    }

    @Nullable
    public static final i<?> l(@NotNull Method method) {
        i<?> a6;
        g0.p(method, "<this>");
        if (Modifier.isStatic(method.getModifiers())) {
            h j6 = j(method);
            if (j6 != null) {
                return a(j6.o(), method);
            }
            Class<?> declaringClass = method.getDeclaringClass();
            g0.o(declaringClass, "getDeclaringClass(...)");
            kotlin.reflect.d<?> m6 = kotlin.reflect.full.h.m(l3.a.i(declaringClass));
            if (m6 != null) {
                Class e6 = l3.a.e(m6);
                String name = method.getName();
                g0.o(name, "getName(...)");
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method j7 = p3.j(e6, name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
                if (j7 != null && (a6 = a(kotlin.reflect.full.h.E(m6), j7)) != null) {
                    return a6;
                }
            }
        }
        Class<?> declaringClass2 = method.getDeclaringClass();
        g0.o(declaringClass2, "getDeclaringClass(...)");
        return a(kotlin.reflect.full.h.E(l3.a.i(declaringClass2)), method);
    }

    @Nullable
    public static final n<?> m(@NotNull Field field) {
        n<?> b6;
        g0.p(field, "<this>");
        if (field.isSynthetic()) {
            return null;
        }
        if (Modifier.isStatic(field.getModifiers())) {
            h j6 = j(field);
            if (j6 != null) {
                return b(j6.o(), field);
            }
            Class<?> declaringClass = field.getDeclaringClass();
            g0.o(declaringClass, "getDeclaringClass(...)");
            kotlin.reflect.d<?> m6 = kotlin.reflect.full.h.m(l3.a.i(declaringClass));
            if (m6 != null) {
                Class<?> declaringClass2 = field.getDeclaringClass();
                g0.o(declaringClass2, "getDeclaringClass(...)");
                String name = field.getName();
                g0.o(name, "getName(...)");
                Field i6 = p3.i(declaringClass2, name);
                if (i6 != null && (b6 = b(kotlin.reflect.full.h.M(m6), i6)) != null) {
                    return b6;
                }
            }
        }
        Class<?> declaringClass3 = field.getDeclaringClass();
        g0.o(declaringClass3, "getDeclaringClass(...)");
        return b(kotlin.reflect.full.h.M(l3.a.i(declaringClass3)), field);
    }

    private static final i<?> a(Collection<? extends kotlin.reflect.c<?>> collection, Method method) {
        for (kotlin.reflect.c<?> cVar : collection) {
            if (cVar instanceof i) {
                i<?> iVar = (i) cVar;
                if (g0.g(iVar.getName(), method.getName()) && g0.g(g(iVar), method)) {
                    return iVar;
                }
            }
        }
        for (kotlin.reflect.c<?> cVar2 : collection) {
            if (cVar2 instanceof i) {
                i<?> iVar2 = (i) cVar2;
                if (!g0.g(iVar2.getName(), method.getName()) && g0.g(g(iVar2), method)) {
                    return iVar2;
                }
            }
        }
        return null;
    }

    private static final n<?> b(Collection<? extends kotlin.reflect.c<?>> collection, Field field) {
        for (kotlin.reflect.c<?> cVar : collection) {
            if (cVar instanceof n) {
                n<?> nVar = (n) cVar;
                if (g0.g(nVar.getName(), field.getName()) && g0.g(e(nVar), field)) {
                    return nVar;
                }
            }
        }
        for (kotlin.reflect.c<?> cVar2 : collection) {
            if (cVar2 instanceof n) {
                n<?> nVar2 = (n) cVar2;
                if (!g0.g(nVar2.getName(), field.getName()) && g0.g(e(nVar2), field)) {
                    return nVar2;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ void d(i iVar) {
    }
}
