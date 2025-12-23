package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i implements org.junit.runners.model.a {

    /* renamed from: d, reason: collision with root package name */
    private static final b f51559d;

    /* renamed from: e, reason: collision with root package name */
    private static final c f51560e;

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f51561a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<? extends Annotation>, List<d>> f51562b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<? extends Annotation>, List<org.junit.runners.model.b>> f51563c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements Comparator<Field> {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements Comparator<d> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return org.junit.internal.f.f51385b.compare(dVar.i(), dVar2.i());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f51561a == ((i) obj).f51561a;
    }

    static {
        a aVar = null;
        f51559d = new b(aVar);
        f51560e = new c(aVar);
    }

    private <T> List<T> b(Map<?, List<T>> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<List<T>> it = map.values().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next());
        }
        return new ArrayList(linkedHashSet);
    }

    private static List<Class<?>> n(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private static <T extends org.junit.runners.model.c<T>> Map<Class<? extends Annotation>, List<T>> q(Map<Class<? extends Annotation>, List<T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Class<? extends Annotation>, List<T>> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static boolean r(Class<? extends Annotation> cls) {
        return cls.equals(Before.class) || cls.equals(BeforeClass.class);
    }

    public <T> List<T> c(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runners.model.b> it = e(cls).iterator();
        while (it.hasNext()) {
            try {
                Object h6 = it.next().h(obj);
                if (cls2.isInstance(h6)) {
                    arrayList.add(cls2.cast(h6));
                }
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e6);
            }
        }
        return arrayList;
    }

    public List<org.junit.runners.model.b> d() {
        return b(this.f51563c);
    }

    public List<org.junit.runners.model.b> e(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(f(this.f51563c, cls, false));
    }

    public <T> List<T> g(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (d dVar : i(cls)) {
            try {
                if (cls2.isAssignableFrom(dVar.k())) {
                    arrayList.add(cls2.cast(dVar.l(obj, new Object[0])));
                }
            } catch (Throwable th) {
                throw new RuntimeException("Exception in " + dVar.c(), th);
            }
        }
        return arrayList;
    }

    @Override // org.junit.runners.model.a
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Class<?> cls2 = this.f51561a;
        if (cls2 == null) {
            return null;
        }
        return (T) cls2.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.a
    public Annotation[] getAnnotations() {
        Class<?> cls = this.f51561a;
        return cls == null ? new Annotation[0] : cls.getAnnotations();
    }

    public List<d> h() {
        List<d> b6 = b(this.f51562b);
        Collections.sort(b6, f51560e);
        return b6;
    }

    public int hashCode() {
        Class<?> cls = this.f51561a;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public List<d> i(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(f(this.f51562b, cls, false));
    }

    public Class<?> j() {
        return this.f51561a;
    }

    public String k() {
        Class<?> cls = this.f51561a;
        return cls == null ? "null" : cls.getName();
    }

    public Constructor<?> l() {
        Constructor<?>[] constructors = this.f51561a.getConstructors();
        org.junit.a.v(1L, constructors.length);
        return constructors[0];
    }

    public boolean o() {
        return this.f51561a.isMemberClass() && !Modifier.isStatic(this.f51561a.getModifiers());
    }

    public boolean p() {
        return Modifier.isPublic(this.f51561a.getModifiers());
    }

    protected void s(Map<Class<? extends Annotation>, List<d>> map, Map<Class<? extends Annotation>, List<org.junit.runners.model.b>> map2) {
        for (Class<?> cls : n(this.f51561a)) {
            for (Method method : org.junit.internal.f.a(cls)) {
                a(new d(method), map);
            }
            for (Field field : m(cls)) {
                a(new org.junit.runners.model.b(field), map2);
            }
        }
    }

    public i(Class<?> cls) {
        this.f51561a = cls;
        if (cls != null && cls.getConstructors().length > 1) {
            throw new IllegalArgumentException("Test class can only have one constructor");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        s(linkedHashMap, linkedHashMap2);
        this.f51562b = q(linkedHashMap);
        this.f51563c = q(linkedHashMap2);
    }

    protected static <T extends org.junit.runners.model.c<T>> void a(T t5, Map<Class<? extends Annotation>, List<T>> map) {
        for (Annotation annotation : t5.getAnnotations()) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            List<T> f6 = f(map, annotationType, true);
            if (!t5.e(f6)) {
                if (r(annotationType)) {
                    f6.add(0, t5);
                } else {
                    f6.add(t5);
                }
            } else {
                return;
            }
        }
    }

    private static <T> List<T> f(Map<Class<? extends Annotation>, List<T>> map, Class<? extends Annotation> cls, boolean z5) {
        if (!map.containsKey(cls) && z5) {
            map.put(cls, new ArrayList());
        }
        List<T> list = map.get(cls);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }

    private static Field[] m(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.sort(declaredFields, f51559d);
        return declaredFields;
    }
}
