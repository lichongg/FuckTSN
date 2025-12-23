package androidx.lifecycle;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt$withStateAtLeastUnchecked$2\n*L\n1#1,206:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2<R> extends Lambda implements Function0<R> {
    final /* synthetic */ Function0<R> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(Function0<? extends R> function0) {
        super(0);
        this.$block = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final R invoke() {
        return this.$block.invoke();
    }
}
