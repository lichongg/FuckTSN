package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f44965a = new c();

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f a(Class<?> cls) {
        int i6 = 0;
        while (cls.isArray()) {
            i6++;
            cls = cls.getComponentType();
            g0.o(cls, "getComponentType(...)");
        }
        if (cls.isPrimitive()) {
            if (g0.g(cls, Void.TYPE)) {
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(o.a.f44593f.m()), i6);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            g0.o(primitiveType, "getPrimitiveType(...)");
            return i6 > 0 ? new kotlin.reflect.jvm.internal.impl.resolve.constants.f(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(primitiveType.getArrayTypeFqName()), i6 - 1) : new kotlin.reflect.jvm.internal.impl.resolve.constants.f(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(primitiveType.getTypeFqName()), i6);
        }
        kotlin.reflect.jvm.internal.impl.name.b e6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(cls);
        kotlin.reflect.jvm.internal.impl.name.b m6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.m(e6.a());
        if (m6 != null) {
            e6 = m6;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(e6, i6);
    }

    public final void b(@NotNull Class<?> klass, @NotNull x.c visitor) {
        g0.p(klass, "klass");
        g0.p(visitor, "visitor");
        Iterator a6 = kotlin.jvm.internal.h.a(klass.getDeclaredAnnotations());
        while (a6.hasNext()) {
            Annotation annotation = (Annotation) a6.next();
            g0.m(annotation);
            f(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final void i(@NotNull Class<?> klass, @NotNull x.d memberVisitor) {
        g0.p(klass, "klass");
        g0.p(memberVisitor, "memberVisitor");
        e(klass, memberVisitor);
        c(klass, memberVisitor);
        d(klass, memberVisitor);
    }

    private c() {
    }

    private final void c(Class<?> cls, x.d dVar) {
        boolean z5;
        Iterator a6 = kotlin.jvm.internal.h.a(cls.getDeclaredConstructors());
        while (a6.hasNext()) {
            Constructor<?> constructor = (Constructor) a6.next();
            kotlin.reflect.jvm.internal.impl.name.f fVar = kotlin.reflect.jvm.internal.impl.name.h.f46364j;
            m mVar = m.f44979a;
            g0.m(constructor);
            x.e a7 = dVar.a(fVar, mVar.a(constructor));
            if (a7 != null) {
                Iterator a8 = kotlin.jvm.internal.h.a(constructor.getDeclaredAnnotations());
                while (a8.hasNext()) {
                    Annotation annotation = (Annotation) a8.next();
                    g0.m(annotation);
                    f(a7, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                g0.m(parameterAnnotations);
                if (parameterAnnotations.length == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z5) {
                    int length = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length2 = parameterAnnotations.length;
                    for (int i6 = 0; i6 < length2; i6++) {
                        Iterator a9 = kotlin.jvm.internal.h.a(parameterAnnotations[i6]);
                        while (a9.hasNext()) {
                            Annotation annotation2 = (Annotation) a9.next();
                            Class<?> e6 = l3.a.e(l3.a.a(annotation2));
                            kotlin.reflect.jvm.internal.impl.name.b e7 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(e6);
                            g0.m(annotation2);
                            x.a a10 = a7.a(i6 + length, e7, new b(annotation2));
                            if (a10 != null) {
                                f44965a.h(a10, annotation2, e6);
                            }
                        }
                    }
                }
                a7.visitEnd();
            }
        }
    }

    private final void d(Class<?> cls, x.d dVar) {
        Iterator a6 = kotlin.jvm.internal.h.a(cls.getDeclaredFields());
        while (a6.hasNext()) {
            Field field = (Field) a6.next();
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(field.getName());
            g0.o(h6, "identifier(...)");
            m mVar = m.f44979a;
            g0.m(field);
            x.c b6 = dVar.b(h6, mVar.b(field), null);
            if (b6 != null) {
                Iterator a7 = kotlin.jvm.internal.h.a(field.getDeclaredAnnotations());
                while (a7.hasNext()) {
                    Annotation annotation = (Annotation) a7.next();
                    g0.m(annotation);
                    f(b6, annotation);
                }
                b6.visitEnd();
            }
        }
    }

    private final void e(Class<?> cls, x.d dVar) {
        Iterator a6 = kotlin.jvm.internal.h.a(cls.getDeclaredMethods());
        while (a6.hasNext()) {
            Method method = (Method) a6.next();
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(method.getName());
            g0.o(h6, "identifier(...)");
            m mVar = m.f44979a;
            g0.m(method);
            x.e a7 = dVar.a(h6, mVar.c(method));
            if (a7 != null) {
                Iterator a8 = kotlin.jvm.internal.h.a(method.getDeclaredAnnotations());
                while (a8.hasNext()) {
                    Annotation annotation = (Annotation) a8.next();
                    g0.m(annotation);
                    f(a7, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                g0.o(parameterAnnotations, "getParameterAnnotations(...)");
                Annotation[][] annotationArr = parameterAnnotations;
                int length = annotationArr.length;
                for (int i6 = 0; i6 < length; i6++) {
                    Iterator a9 = kotlin.jvm.internal.h.a(annotationArr[i6]);
                    while (a9.hasNext()) {
                        Annotation annotation2 = (Annotation) a9.next();
                        Class<?> e6 = l3.a.e(l3.a.a(annotation2));
                        kotlin.reflect.jvm.internal.impl.name.b e7 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(e6);
                        g0.m(annotation2);
                        x.a a10 = a7.a(i6, e7, new b(annotation2));
                        if (a10 != null) {
                            f44965a.h(a10, annotation2, e6);
                        }
                    }
                }
                a7.visitEnd();
            }
        }
    }

    private final void f(x.c cVar, Annotation annotation) {
        Class<?> e6 = l3.a.e(l3.a.a(annotation));
        x.a b6 = cVar.b(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(e6), new b(annotation));
        if (b6 != null) {
            f44965a.h(b6, annotation, e6);
        }
    }

    private final void g(x.a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (!g0.g(cls, Class.class)) {
            set = i.f44972a;
            if (set.contains(cls)) {
                aVar.d(fVar, obj);
                return;
            }
            if (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.l(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                g0.m(cls);
                kotlin.reflect.jvm.internal.impl.name.b e6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(cls);
                g0.n(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(((Enum) obj).name());
                g0.o(h6, "identifier(...)");
                aVar.a(fVar, e6, h6);
                return;
            }
            if (Annotation.class.isAssignableFrom(cls)) {
                Class<?>[] interfaces = cls.getInterfaces();
                g0.o(interfaces, "getInterfaces(...)");
                Class<?> cls2 = (Class) n.At(interfaces);
                g0.m(cls2);
                x.a b6 = aVar.b(fVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(cls2));
                if (b6 != null) {
                    g0.n(obj, "null cannot be cast to non-null type kotlin.Annotation");
                    h(b6, (Annotation) obj, cls2);
                    return;
                }
                return;
            }
            if (cls.isArray()) {
                x.b e7 = aVar.e(fVar);
                if (e7 == null) {
                    return;
                }
                Class<?> componentType = cls.getComponentType();
                int i6 = 0;
                if (componentType.isEnum()) {
                    g0.m(componentType);
                    kotlin.reflect.jvm.internal.impl.name.b e8 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(componentType);
                    g0.n(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i6 < length) {
                        Object obj2 = objArr[i6];
                        g0.n(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h(((Enum) obj2).name());
                        g0.o(h7, "identifier(...)");
                        e7.c(e8, h7);
                        i6++;
                    }
                } else if (g0.g(componentType, Class.class)) {
                    g0.n(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i6 < length2) {
                        Object obj3 = objArr2[i6];
                        g0.n(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        e7.d(a((Class) obj3));
                        i6++;
                    }
                } else if (Annotation.class.isAssignableFrom(componentType)) {
                    g0.n(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i6 < length3) {
                        Object obj4 = objArr3[i6];
                        g0.m(componentType);
                        x.a b7 = e7.b(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(componentType));
                        if (b7 != null) {
                            g0.n(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                            h(b7, (Annotation) obj4, componentType);
                        }
                        i6++;
                    }
                } else {
                    g0.n(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr4 = (Object[]) obj;
                    int length4 = objArr4.length;
                    while (i6 < length4) {
                        e7.a(objArr4[i6]);
                        i6++;
                    }
                }
                e7.visitEnd();
                return;
            }
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
        g0.n(obj, "null cannot be cast to non-null type java.lang.Class<*>");
        aVar.c(fVar, a((Class) obj));
    }

    private final void h(x.a aVar, Annotation annotation, Class<?> cls) {
        Iterator a6 = kotlin.jvm.internal.h.a(cls.getDeclaredMethods());
        while (a6.hasNext()) {
            Method method = (Method) a6.next();
            try {
                Object invoke = method.invoke(annotation, null);
                g0.m(invoke);
                kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(method.getName());
                g0.o(h6, "identifier(...)");
                g(aVar, h6, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.visitEnd();
    }
}
