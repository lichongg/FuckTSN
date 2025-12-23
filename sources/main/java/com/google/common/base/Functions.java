package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Functions {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.base.Functions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        private final E value;

        @Override // com.google.common.base.Function
        public E apply(@NullableDecl Object obj) {
            return this.value;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof ConstantFunction) {
                return Objects.equal(this.value, ((ConstantFunction) obj).value);
            }
            return false;
        }

        public int hashCode() {
            E e6 = this.value;
            if (e6 == null) {
                return 0;
            }
            return e6.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.value + ")";
        }

        public ConstantFunction(@NullableDecl E e6) {
            this.value = e6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final V defaultValue;
        final Map<K, ? extends V> map;

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K k6) {
            V v5 = this.map.get(k6);
            return (v5 != null || this.map.containsKey(k6)) ? v5 : this.defaultValue;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof ForMapWithDefault) {
                ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
                if (this.map.equals(forMapWithDefault.map) && Objects.equal(this.defaultValue, forMapWithDefault.defaultValue)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.map, this.defaultValue);
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
        }

        ForMapWithDefault(Map<K, ? extends V> map, @NullableDecl V v5) {
            this.map = (Map) Preconditions.checkNotNull(map);
            this.defaultValue = v5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f, reason: collision with root package name */
        private final Function<A, ? extends B> f32732f;

        /* renamed from: g, reason: collision with root package name */
        private final Function<B, C> f32733g;

        @Override // com.google.common.base.Function
        public C apply(@NullableDecl A a6) {
            return (C) this.f32733g.apply(this.f32732f.apply(a6));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof FunctionComposition) {
                FunctionComposition functionComposition = (FunctionComposition) obj;
                if (this.f32732f.equals(functionComposition.f32732f) && this.f32733g.equals(functionComposition.f32733g)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f32732f.hashCode() ^ this.f32733g.hashCode();
        }

        public String toString() {
            return this.f32733g + "(" + this.f32732f + ")";
        }

        public FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
            this.f32733g = (Function) Preconditions.checkNotNull(function);
            this.f32732f = (Function) Preconditions.checkNotNull(function2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K k6) {
            V v5 = this.map.get(k6);
            Preconditions.checkArgument(v5 != null || this.map.containsKey(k6), "Key '%s' not present in map", k6);
            return v5;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.map.equals(((FunctionForMapNoDefault) obj).map);
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ")";
        }

        FunctionForMapNoDefault(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }

        @Override // com.google.common.base.Function
        @NullableDecl
        public Object apply(@NullableDecl Object obj) {
            return obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        /* synthetic */ PredicateFunction(Predicate predicate, AnonymousClass1 anonymousClass1) {
            this(predicate);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Boolean apply(@NullableDecl Object obj) {
            return apply((PredicateFunction<T>) obj);
        }

        private PredicateFunction(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Function
        public Boolean apply(@NullableDecl T t5) {
            return Boolean.valueOf(this.predicate.apply(t5));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.predicate.equals(((PredicateFunction) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.predicate + ")";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SupplierFunction<T> implements Function<Object, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        /* synthetic */ SupplierFunction(Supplier supplier, AnonymousClass1 anonymousClass1) {
            this(supplier);
        }

        private SupplierFunction(Supplier<T> supplier) {
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Function
        public T apply(@NullableDecl Object obj) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.supplier.equals(((SupplierFunction) obj).supplier);
            }
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.supplier + ")";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        @Override // com.google.common.base.Function
        public String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new FunctionForMapNoDefault(map);
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new FunctionComposition(function, function2);
    }

    public static <E> Function<Object, E> constant(@NullableDecl E e6) {
        return new ConstantFunction(e6);
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, @NullableDecl V v5) {
        return new ForMapWithDefault(map, v5);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new PredicateFunction(predicate, null);
    }

    public static <T> Function<Object, T> forSupplier(Supplier<T> supplier) {
        return new SupplierFunction(supplier, null);
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    private Functions() {
    }
}
