package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.r0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.s;
import kotlin.t;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAnnotationConstructorCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCallerKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n11228#2:182\n11563#2,3:183\n37#3:186\n36#3,3:187\n18#3:197\n1563#4:190\n1634#4,3:191\n1740#4,3:194\n*S KotlinDebug\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCallerKt\n*L\n75#1:182\n75#1:183,3\n75#1:186\n75#1:187,3\n173#1:197\n102#1:190\n102#1:191,3\n106#1:194,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    @NotNull
    public static final <T> T g(@NotNull Class<T> annotationClass, @NotNull Map<String, ? extends Object> values, @NotNull List<Method> methods) {
        g0.p(annotationClass, "annotationClass");
        g0.p(values, "values");
        g0.p(methods, "methods");
        s c6 = t.c(new a(values));
        T t5 = (T) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new c(annotationClass, values, t.c(new b(annotationClass, values)), c6, methods));
        g0.n(t5, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t5;
    }

    public static /* synthetic */ Object h(Class cls, Map map, List list, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            Set keySet = map.keySet();
            ArrayList arrayList = new ArrayList(f0.d0(keySet, 10));
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list = arrayList;
        }
        return g(cls, map, list);
    }

    private static final <T> boolean i(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) {
        boolean g6;
        boolean z5;
        kotlin.reflect.d a6;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (g0.g((annotation == null || (a6 = l3.a.a(annotation)) == null) ? null : l3.a.e(a6), cls)) {
            List<Method> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (Method method : list2) {
                    Object obj2 = map.get(method.getName());
                    Object invoke = method.invoke(obj, null);
                    if (obj2 instanceof boolean[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                        g6 = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                    } else if (obj2 instanceof char[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                        g6 = Arrays.equals((char[]) obj2, (char[]) invoke);
                    } else if (obj2 instanceof byte[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                        g6 = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                    } else if (obj2 instanceof short[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                        g6 = Arrays.equals((short[]) obj2, (short[]) invoke);
                    } else if (obj2 instanceof int[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                        g6 = Arrays.equals((int[]) obj2, (int[]) invoke);
                    } else if (obj2 instanceof float[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                        g6 = Arrays.equals((float[]) obj2, (float[]) invoke);
                    } else if (obj2 instanceof long[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                        g6 = Arrays.equals((long[]) obj2, (long[]) invoke);
                    } else if (obj2 instanceof double[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                        g6 = Arrays.equals((double[]) obj2, (double[]) invoke);
                    } else if (obj2 instanceof Object[]) {
                        g0.n(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                        g6 = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                    } else {
                        g6 = g0.g(obj2, invoke);
                    }
                    if (!g6) {
                        z5 = false;
                        break;
                    }
                }
            }
            z5 = true;
            if (z5) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String l(Class cls, Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(cls.getCanonicalName());
        r0.o3(map.entrySet(), sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : d.f44287a);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence m(Map.Entry entry) {
        String obj;
        g0.p(entry, "entry");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            obj = Arrays.toString((boolean[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof char[]) {
            obj = Arrays.toString((char[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof byte[]) {
            obj = Arrays.toString((byte[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof short[]) {
            obj = Arrays.toString((short[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof int[]) {
            obj = Arrays.toString((int[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof float[]) {
            obj = Arrays.toString((float[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof long[]) {
            obj = Arrays.toString((long[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof double[]) {
            obj = Arrays.toString((double[]) value);
            g0.o(obj, "toString(...)");
        } else if (value instanceof Object[]) {
            obj = Arrays.toString((Object[]) value);
            g0.o(obj, "toString(...)");
        } else {
            obj = value.toString();
        }
        return str + '=' + obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void p(int i6, String str, Class<?> cls) {
        String x5;
        kotlin.reflect.d d6 = g0.g(cls, Class.class) ? o0.d(kotlin.reflect.d.class) : (cls.isArray() && g0.g(cls.getComponentType(), Class.class)) ? o0.d(kotlin.reflect.d[].class) : l3.a.i(cls);
        if (g0.g(d6.x(), o0.d(Object[].class).x())) {
            StringBuilder sb = new StringBuilder();
            sb.append(d6.x());
            sb.append(v0.f47961e);
            Class<?> componentType = l3.a.e(d6).getComponentType();
            g0.o(componentType, "getComponentType(...)");
            sb.append(l3.a.i(componentType).x());
            sb.append(v0.f47962f);
            x5 = sb.toString();
        } else {
            x5 = d6.x();
        }
        throw new IllegalArgumentException("Argument #" + i6 + ' ' + str + " is not of the required type " + x5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object q(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof kotlin.reflect.d) {
            obj = l3.a.e((kotlin.reflect.d) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof kotlin.reflect.d[]) {
                g0.n(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                kotlin.reflect.d[] dVarArr = (kotlin.reflect.d[]) obj;
                ArrayList arrayList = new ArrayList(dVarArr.length);
                for (kotlin.reflect.d dVar : dVarArr) {
                    arrayList.add(l3.a.e(dVar));
                }
                obj = arrayList.toArray(new Class[0]);
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Map map) {
        int hashCode;
        int i6 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof boolean[]) {
                hashCode = Arrays.hashCode((boolean[]) value);
            } else if (value instanceof char[]) {
                hashCode = Arrays.hashCode((char[]) value);
            } else if (value instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) value);
            } else if (value instanceof short[]) {
                hashCode = Arrays.hashCode((short[]) value);
            } else if (value instanceof int[]) {
                hashCode = Arrays.hashCode((int[]) value);
            } else if (value instanceof float[]) {
                hashCode = Arrays.hashCode((float[]) value);
            } else if (value instanceof long[]) {
                hashCode = Arrays.hashCode((long[]) value);
            } else if (value instanceof double[]) {
                hashCode = Arrays.hashCode((double[]) value);
            } else if (value instanceof Object[]) {
                hashCode = Arrays.hashCode((Object[]) value);
            } else {
                hashCode = value.hashCode();
            }
            i6 += hashCode ^ (str.hashCode() * 127);
        }
        return i6;
    }

    private static final int k(s<Integer> sVar) {
        return sVar.getValue().intValue();
    }

    private static final String n(s<String> sVar) {
        return sVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object o(Class cls, Map map, s sVar, s sVar2, List list, Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (name != null) {
            int hashCode = name.hashCode();
            if (hashCode != -1776922004) {
                if (hashCode != 147696667) {
                    if (hashCode == 1444986633 && name.equals("annotationType")) {
                        return cls;
                    }
                } else if (name.equals("hashCode")) {
                    return Integer.valueOf(k(sVar2));
                }
            } else if (name.equals("toString")) {
                return n(sVar);
            }
        }
        if (g0.g(name, "equals") && objArr != null && objArr.length == 1) {
            return Boolean.valueOf(i(cls, list, map, kotlin.collections.n.At(objArr)));
        }
        if (map.containsKey(name)) {
            return map.get(name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method is not supported: ");
        sb.append(method);
        sb.append(" (args: ");
        if (objArr == null) {
            objArr = new Object[0];
        }
        sb.append(kotlin.collections.n.dz(objArr));
        sb.append(')');
        throw new KotlinReflectionInternalError(sb.toString());
    }
}
