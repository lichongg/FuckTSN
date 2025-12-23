package org.junit.experimental.categories;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Categories extends Suite {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExcludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IncludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends org.junit.runner.manipulation.a {

        /* renamed from: b, reason: collision with root package name */
        private final Set<Class<?>> f51337b;

        /* renamed from: c, reason: collision with root package name */
        private final Set<Class<?>> f51338c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f51339d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f51340e;

        private static Class<?>[] i(Description description) {
            if (description == null) {
                return new Class[0];
            }
            Category category = (Category) description.getAnnotation(Category.class);
            return category == null ? new Class[0] : category.value();
        }

        public static a j(Class<?> cls) {
            return k(true, cls);
        }

        public static a l(Class<?>... clsArr) {
            return k(true, clsArr);
        }

        private static boolean n(Class<?>... clsArr) {
            if (clsArr == null) {
                return false;
            }
            for (Class<?> cls : clsArr) {
                if (cls == null) {
                    return true;
                }
            }
            return false;
        }

        public static a o(Class<?> cls) {
            return p(true, cls);
        }

        public static a q(Class<?>... clsArr) {
            return p(true, clsArr);
        }

        private static Set<Class<?>> f(Description description) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, i(description));
            Collections.addAll(hashSet, i(t(description)));
            return hashSet;
        }

        public static a g(boolean z5, Set<Class<?>> set, boolean z6, Set<Class<?>> set2) {
            return new a(z5, set, z6, set2);
        }

        private static Set<Class<?>> h(Set<Class<?>> set) {
            HashSet hashSet = new HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            hashSet.remove(null);
            return hashSet;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("categories ");
            sb.append(this.f51337b.isEmpty() ? "[all]" : this.f51337b);
            if (!this.f51338c.isEmpty()) {
                sb.append(" - ");
                sb.append(this.f51338c);
            }
            return sb.toString();
        }

        protected a(boolean z5, Set<Class<?>> set, boolean z6, Set<Class<?>> set2) {
            this.f51339d = z5;
            this.f51340e = z6;
            this.f51337b = h(set);
            this.f51338c = h(set2);
        }

        public static a k(boolean z5, Class<?>... clsArr) {
            if (!n(clsArr)) {
                return g(true, null, z5, Categories.O(clsArr));
            }
            throw new NullPointerException("has null category");
        }

        private boolean m(Description description) {
            Set<Class<?>> f6 = f(description);
            if (f6.isEmpty()) {
                return this.f51337b.isEmpty();
            }
            if (!this.f51338c.isEmpty()) {
                if (this.f51340e) {
                    if (s(f6, this.f51338c)) {
                        return false;
                    }
                } else if (r(f6, this.f51338c)) {
                    return false;
                }
            }
            if (this.f51337b.isEmpty()) {
                return true;
            }
            if (this.f51339d) {
                return s(f6, this.f51337b);
            }
            return r(f6, this.f51337b);
        }

        public static a p(boolean z5, Class<?>... clsArr) {
            if (!n(clsArr)) {
                return g(z5, Categories.O(clsArr), true, null);
            }
            throw new NullPointerException("has null category");
        }

        private boolean r(Set<Class<?>> set, Set<Class<?>> set2) {
            Iterator<Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (!Categories.R(set, it.next())) {
                    return false;
                }
            }
            return true;
        }

        private boolean s(Set<Class<?>> set, Set<Class<?>> set2) {
            Iterator<Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (Categories.R(set, it.next())) {
                    return true;
                }
            }
            return false;
        }

        private static Description t(Description description) {
            Class<?> testClass = description.getTestClass();
            if (testClass == null) {
                return null;
            }
            return Description.createSuiteDescription(testClass);
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return toString();
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(Description description) {
            if (m(description)) {
                return true;
            }
            Iterator<Description> it = description.getChildren().iterator();
            while (it.hasNext()) {
                if (e(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<Class<?>> O(Class<?>... clsArr) {
        HashSet hashSet = new HashSet();
        if (clsArr != null) {
            Collections.addAll(hashSet, clsArr);
        }
        return hashSet;
    }

    private static Set<Class<?>> P(Class<?> cls) {
        ExcludeCategory excludeCategory = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
        return O(excludeCategory == null ? null : excludeCategory.value());
    }

    private static Set<Class<?>> Q(Class<?> cls) {
        IncludeCategory includeCategory = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
        return O(includeCategory == null ? null : includeCategory.value());
    }

    private static boolean S(Class<?> cls) {
        ExcludeCategory excludeCategory = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
        return excludeCategory == null || excludeCategory.matchAny();
    }

    private static boolean T(Class<?> cls) {
        IncludeCategory includeCategory = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
        return includeCategory == null || includeCategory.matchAny();
    }

    public Categories(Class<?> cls, f fVar) throws InitializationError {
        super(cls, fVar);
        try {
            b(a.g(T(cls), Q(cls), S(cls), P(cls)));
            L(getDescription());
        } catch (NoTestsRemainException e6) {
            throw new InitializationError(e6);
        }
    }

    private static void L(Description description) throws InitializationError {
        if (!N(description)) {
            M(description);
        }
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            L(it.next());
        }
    }

    private static void M(Description description) throws InitializationError {
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            Description next = it.next();
            if (next.getAnnotation(Category.class) == null) {
                M(next);
            } else {
                throw new InitializationError("Category annotations on Parameterized classes are not supported on individual methods.");
            }
        }
    }

    private static boolean N(Description description) {
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().getTestClass() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean R(Set<Class<?>> set, Class<?> cls) {
        Iterator<Class<?>> it = set.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }
}
