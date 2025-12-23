package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class CoroutineLiveDataKt$addDisposableSource$2 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super EmittedSource>, Object> {
    final /* synthetic */ LiveData<T> $source;
    final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineLiveDataKt$addDisposableSource$2(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, kotlin.coroutines.e<? super CoroutineLiveDataKt$addDisposableSource$2> eVar) {
        super(2, eVar);
        this.$this_addDisposableSource = mediatorLiveData;
        this.$source = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        return new CoroutineLiveDataKt$addDisposableSource$2(this.$this_addDisposableSource, this.$source, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super EmittedSource> eVar) {
        return ((CoroutineLiveDataKt$addDisposableSource$2) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlin.coroutines.intrinsics.a.l();
        if (this.label == 0) {
            g0.n(obj);
            final MediatorLiveData<T> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.addSource(this.$source, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new Function1<T, n1>() { // from class: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Object obj2) {
                    invoke2((AnonymousClass1<T>) obj2);
                    return n1.f44123a;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(T t5) {
                    mediatorLiveData.setValue(t5);
                }
            }));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
