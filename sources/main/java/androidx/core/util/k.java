package androidx.core.util;

import android.annotation.SuppressLint;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class k {
    @SuppressLint({"MissingNullability"})
    public static Predicate b(final Predicate predicate) {
        return new Predicate() { // from class: androidx.core.util.j
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return k.e(Predicate.this, obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate2) {
                return k.a(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate2) {
                return k.c(this, predicate2);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> g(@SuppressLint({"MissingNullability"}) final Object obj) {
        return obj == null ? new Predicate() { // from class: androidx.core.util.g
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return k.c(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                boolean a6;
                a6 = e.a(obj2);
                return a6;
            }
        } : new Predicate() { // from class: androidx.core.util.h
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                boolean equals;
                equals = obj.equals(obj2);
                return equals;
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return k.c(this, predicate);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate a(final Predicate predicate, @SuppressLint({"MissingNullability"}) final Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new Predicate() { // from class: androidx.core.util.i
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return k.d(Predicate.this, predicate2, obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate3) {
                return k.a(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate3) {
                return k.c(this, predicate3);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate c(final Predicate predicate, @SuppressLint({"MissingNullability"}) final Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new Predicate() { // from class: androidx.core.util.f
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return k.f(Predicate.this, predicate2, obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate3) {
                return k.a(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate3) {
                return k.c(this, predicate3);
            }
        };
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        if (predicate.test(obj) && predicate2.test(obj)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        if (!predicate.test(obj) && !predicate2.test(obj)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> j(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
