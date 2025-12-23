package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class j0 {
    @InlineOnly
    private static final Void a() {
        throw new NotImplementedError(null, 1, null);
    }

    @InlineOnly
    private static final Void b(String reason) {
        kotlin.jvm.internal.g0.p(reason, "reason");
        throw new NotImplementedError("An operation is not implemented: " + reason);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T c(T t5, Function1<? super T, n1> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        block.invoke(t5);
        return t5;
    }

    @InlineOnly
    private static final <T> T d(T t5, Function1<? super T, n1> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        block.invoke(t5);
        return t5;
    }

    @InlineOnly
    private static final <T, R> R e(T t5, Function1<? super T, ? extends R> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        return block.invoke(t5);
    }

    @InlineOnly
    private static final void f(int i6, Function1<? super Integer, n1> action) {
        kotlin.jvm.internal.g0.p(action, "action");
        for (int i7 = 0; i7 < i6; i7++) {
            action.invoke(Integer.valueOf(i7));
        }
    }

    @InlineOnly
    private static final <T, R> R g(T t5, Function1<? super T, ? extends R> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        return block.invoke(t5);
    }

    @InlineOnly
    private static final <R> R h(Function0<? extends R> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        return block.invoke();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T i(T t5, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if (predicate.invoke(t5).booleanValue()) {
            return t5;
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T j(T t5, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        if (predicate.invoke(t5).booleanValue()) {
            return null;
        }
        return t5;
    }

    @InlineOnly
    private static final <T, R> R k(T t5, Function1<? super T, ? extends R> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        return block.invoke(t5);
    }
}
