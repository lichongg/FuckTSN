package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f51358c = a();

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f51359a;

    /* renamed from: b, reason: collision with root package name */
    private final Annotation[] f51360b;

    private <T extends Annotation> T f(Annotation[] annotationArr, Class<T> cls, int i6) {
        if (i6 == 0) {
            return null;
        }
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
            Annotation f6 = f(annotation.annotationType().getAnnotations(), cls, i6 - 1);
            if (f6 != null) {
                return cls.cast(f6);
            }
        }
        return null;
    }

    private static Map<Class<?>, Class<?>> a() {
        HashMap hashMap = new HashMap();
        k(hashMap, Boolean.TYPE, Boolean.class);
        k(hashMap, Byte.TYPE, Byte.class);
        k(hashMap, Short.TYPE, Short.class);
        k(hashMap, Character.TYPE, Character.class);
        k(hashMap, Integer.TYPE, Integer.class);
        k(hashMap, Long.TYPE, Long.class);
        k(hashMap, Float.TYPE, Float.class);
        k(hashMap, Double.TYPE, Double.class);
        return Collections.unmodifiableMap(hashMap);
    }

    private boolean j(Class<?> cls, Class<?> cls2) {
        Map<Class<?>, Class<?>> map = f51358c;
        if (map.containsKey(cls2)) {
            return cls.isAssignableFrom(map.get(cls2));
        }
        return false;
    }

    private static ArrayList<a> m(Class<?>[] clsArr, Annotation[][] annotationArr) {
        ArrayList<a> arrayList = new ArrayList<>();
        for (int i6 = 0; i6 < clsArr.length; i6++) {
            arrayList.add(new a(clsArr[i6], annotationArr[i6]));
        }
        return arrayList;
    }

    public boolean b(Class<?> cls) {
        return this.f51359a.isAssignableFrom(cls) || j(this.f51359a, cls);
    }

    public boolean c(Object obj) {
        return obj == null ? !this.f51359a.isPrimitive() : b(obj.getClass());
    }

    public boolean d(Class<?> cls) {
        return cls.isAssignableFrom(this.f51359a) || j(cls, this.f51359a) || b(cls);
    }

    public <T extends Annotation> T e(Class<T> cls) {
        return (T) f(this.f51360b, cls, 3);
    }

    public Class<?> getType() {
        return this.f51359a;
    }

    public List<Annotation> h() {
        return Arrays.asList(this.f51360b);
    }

    private a(Class<?> cls, Annotation[] annotationArr) {
        this.f51359a = cls;
        this.f51360b = annotationArr;
    }

    private static <T> void k(Map<T, T> map, T t5, T t6) {
        map.put(t5, t6);
        map.put(t6, t5);
    }

    public static ArrayList<a> l(Method method) {
        return m(method.getParameterTypes(), method.getParameterAnnotations());
    }

    public static List<a> n(Constructor<?> constructor) {
        return m(constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }

    public <T extends Annotation> T g(Class<T> cls) {
        for (Annotation annotation : h()) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public boolean i(Class<? extends Annotation> cls) {
        if (g(cls) != null) {
            return true;
        }
        return false;
    }
}
