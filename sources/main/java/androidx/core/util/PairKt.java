package androidx.core.util;

import android.annotation.SuppressLint;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull Pair<F, S> pair) {
        return pair.second;
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    @NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        return new android.util.Pair<>(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <F, S> Pair<F, S> toAndroidXPair(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
