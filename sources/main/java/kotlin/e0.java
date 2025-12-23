package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,146:1\n1#2:147\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class e0 extends d0 {
    @InlineOnly
    private static final void c(boolean z5) {
        if (!z5) {
            throw new IllegalStateException("Check failed.");
        }
    }

    @InlineOnly
    private static final void d(boolean z5, Function0<? extends Object> lazyMessage) {
        kotlin.jvm.internal.g0.p(lazyMessage, "lazyMessage");
        if (!z5) {
            throw new IllegalStateException(lazyMessage.invoke().toString());
        }
    }

    @InlineOnly
    private static final <T> T e(T t5) {
        if (t5 != null) {
            return t5;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @InlineOnly
    private static final <T> T f(T t5, Function0<? extends Object> lazyMessage) {
        kotlin.jvm.internal.g0.p(lazyMessage, "lazyMessage");
        if (t5 != null) {
            return t5;
        }
        throw new IllegalStateException(lazyMessage.invoke().toString());
    }

    @InlineOnly
    private static final Void g(Object message) {
        kotlin.jvm.internal.g0.p(message, "message");
        throw new IllegalStateException(message.toString());
    }

    @InlineOnly
    private static final void h(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @InlineOnly
    private static final void i(boolean z5, Function0<? extends Object> lazyMessage) {
        kotlin.jvm.internal.g0.p(lazyMessage, "lazyMessage");
        if (!z5) {
            throw new IllegalArgumentException(lazyMessage.invoke().toString());
        }
    }

    @InlineOnly
    private static final <T> T j(T t5) {
        if (t5 != null) {
            return t5;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @InlineOnly
    private static final <T> T k(T t5, Function0<? extends Object> lazyMessage) {
        kotlin.jvm.internal.g0.p(lazyMessage, "lazyMessage");
        if (t5 != null) {
            return t5;
        }
        throw new IllegalArgumentException(lazyMessage.invoke().toString());
    }
}
