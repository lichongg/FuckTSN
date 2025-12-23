package org.junit.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.FixMethodOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<Method> f51384a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Comparator<Method> f51385b = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Comparator<Method> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            int hashCode = method.getName().hashCode();
            int hashCode2 = method2.getName().hashCode();
            if (hashCode != hashCode2) {
                if (hashCode < hashCode2) {
                    return -1;
                }
                return 1;
            }
            return f.f51385b.compare(method, method2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Comparator<Method> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            int compareTo = method.getName().compareTo(method2.getName());
            if (compareTo != 0) {
                return compareTo;
            }
            return method.toString().compareTo(method2.toString());
        }
    }

    public static Method[] a(Class<?> cls) {
        Comparator<Method> b6 = b((FixMethodOrder) cls.getAnnotation(FixMethodOrder.class));
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (b6 != null) {
            Arrays.sort(declaredMethods, b6);
        }
        return declaredMethods;
    }

    private static Comparator<Method> b(FixMethodOrder fixMethodOrder) {
        return fixMethodOrder == null ? f51384a : fixMethodOrder.value().getComparator();
    }

    private f() {
    }
}
