package kotlin.coroutines.intrinsics;

import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.coroutines.e;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b extends IntrinsicsKt__IntrinsicsJvmKt {
    @NotNull
    public static Object l() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object n(Function1<? super e<? super T>, ? extends Object> function1, e<? super T> eVar) {
        throw new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void m() {
    }
}
