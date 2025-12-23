package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "kotlinx.coroutines.flow.LintKt$retry$1", f = "Lint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Lint.kt\nkotlinx/coroutines/flow/LintKt$retry$1\n*L\n1#1,193:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class LintKt$retry$1 extends SuspendLambda implements Function2<Throwable, kotlin.coroutines.e<? super Boolean>, Object> {
    int label;

    public LintKt$retry$1(kotlin.coroutines.e<? super LintKt$retry$1> eVar) {
        super(2, eVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        return new LintKt$retry$1(eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull Throwable th, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
        return ((LintKt$retry$1) create(th, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlin.coroutines.intrinsics.a.l();
        if (this.label == 0) {
            kotlin.g0.n(obj);
            return kotlin.coroutines.jvm.internal.a.a(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
