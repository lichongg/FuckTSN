package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import m3.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class u0 {
    public static int A(Object obj) {
        if (obj instanceof c0) {
            return ((c0) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof Function3) {
            return 3;
        }
        if (obj instanceof Function4) {
            return 4;
        }
        if (obj instanceof Function5) {
            return 5;
        }
        if (obj instanceof Function6) {
            return 6;
        }
        if (obj instanceof Function7) {
            return 7;
        }
        if (obj instanceof Function8) {
            return 8;
        }
        if (obj instanceof Function9) {
            return 9;
        }
        if (obj instanceof Function10) {
            return 10;
        }
        if (obj instanceof Function11) {
            return 11;
        }
        if (obj instanceof Function12) {
            return 12;
        }
        if (obj instanceof Function13) {
            return 13;
        }
        if (obj instanceof Function14) {
            return 14;
        }
        if (obj instanceof Function15) {
            return 15;
        }
        if (obj instanceof Function16) {
            return 16;
        }
        if (obj instanceof Function17) {
            return 17;
        }
        if (obj instanceof Function18) {
            return 18;
        }
        if (obj instanceof Function19) {
            return 19;
        }
        if (obj instanceof Function20) {
            return 20;
        }
        if (obj instanceof Function21) {
            return 21;
        }
        return obj instanceof Function22 ? 22 : -1;
    }

    public static boolean B(Object obj, int i6) {
        return (obj instanceof kotlin.n) && A(obj) == i6;
    }

    public static boolean C(Object obj) {
        if (obj instanceof Collection) {
            return !(obj instanceof m3.a) || (obj instanceof m3.b);
        }
        return false;
    }

    public static boolean D(Object obj) {
        if (obj instanceof Iterable) {
            return !(obj instanceof m3.a) || (obj instanceof m3.c);
        }
        return false;
    }

    public static boolean E(Object obj) {
        if (obj instanceof Iterator) {
            return !(obj instanceof m3.a) || (obj instanceof m3.d);
        }
        return false;
    }

    public static boolean F(Object obj) {
        if (obj instanceof List) {
            return !(obj instanceof m3.a) || (obj instanceof m3.e);
        }
        return false;
    }

    public static boolean G(Object obj) {
        if (obj instanceof ListIterator) {
            return !(obj instanceof m3.a) || (obj instanceof m3.f);
        }
        return false;
    }

    public static boolean H(Object obj) {
        if (obj instanceof Map) {
            return !(obj instanceof m3.a) || (obj instanceof m3.g);
        }
        return false;
    }

    public static boolean I(Object obj) {
        if (obj instanceof Map.Entry) {
            return !(obj instanceof m3.a) || (obj instanceof g.a);
        }
        return false;
    }

    public static boolean J(Object obj) {
        if (obj instanceof Set) {
            return !(obj instanceof m3.a) || (obj instanceof m3.h);
        }
        return false;
    }

    private static <T extends Throwable> T K(T t5) {
        return (T) g0.B(t5, u0.class.getName());
    }

    public static void M(Object obj, String str) {
        N((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void N(String str) {
        throw L(new ClassCastException(str));
    }

    public static Collection a(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.b)) {
            M(obj, "kotlin.collections.MutableCollection");
        }
        return s(obj);
    }

    public static Collection b(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.b)) {
            N(str);
        }
        return s(obj);
    }

    public static Iterable c(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.c)) {
            M(obj, "kotlin.collections.MutableIterable");
        }
        return t(obj);
    }

    public static Iterable d(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.c)) {
            N(str);
        }
        return t(obj);
    }

    public static Iterator e(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.d)) {
            M(obj, "kotlin.collections.MutableIterator");
        }
        return u(obj);
    }

    public static Iterator f(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.d)) {
            N(str);
        }
        return u(obj);
    }

    public static List g(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.e)) {
            M(obj, "kotlin.collections.MutableList");
        }
        return v(obj);
    }

    public static List h(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.e)) {
            N(str);
        }
        return v(obj);
    }

    public static ListIterator i(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.f)) {
            M(obj, "kotlin.collections.MutableListIterator");
        }
        return w(obj);
    }

    public static ListIterator j(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.f)) {
            N(str);
        }
        return w(obj);
    }

    public static Map k(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.g)) {
            M(obj, "kotlin.collections.MutableMap");
        }
        return x(obj);
    }

    public static Map l(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.g)) {
            N(str);
        }
        return x(obj);
    }

    public static Map.Entry m(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof g.a)) {
            M(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return y(obj);
    }

    public static Map.Entry n(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof g.a)) {
            N(str);
        }
        return y(obj);
    }

    public static Set o(Object obj) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.h)) {
            M(obj, "kotlin.collections.MutableSet");
        }
        return z(obj);
    }

    public static Set p(Object obj, String str) {
        if ((obj instanceof m3.a) && !(obj instanceof m3.h)) {
            N(str);
        }
        return z(obj);
    }

    public static Object q(Object obj, int i6) {
        if (obj != null && !B(obj, i6)) {
            M(obj, "kotlin.jvm.functions.Function" + i6);
        }
        return obj;
    }

    public static Object r(Object obj, int i6, String str) {
        if (obj != null && !B(obj, i6)) {
            N(str);
        }
        return obj;
    }

    public static Collection s(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static Iterable t(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static Iterator u(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static List v(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static ListIterator w(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static Map x(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static Map.Entry y(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static Set z(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e6) {
            throw L(e6);
        }
    }

    public static ClassCastException L(ClassCastException classCastException) {
        throw ((ClassCastException) K(classCastException));
    }
}
