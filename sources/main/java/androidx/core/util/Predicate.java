package androidx.core.util;

import android.annotation.SuppressLint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"UnknownNullness"})
/* loaded from: D:\Downloads\app\classes.dex */
public interface Predicate<T> {
    @SuppressLint({"MissingNullability"})
    Predicate<T> and(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    @SuppressLint({"MissingNullability"})
    Predicate<T> negate();

    @SuppressLint({"MissingNullability"})
    Predicate<T> or(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate);

    boolean test(T t5);
}
