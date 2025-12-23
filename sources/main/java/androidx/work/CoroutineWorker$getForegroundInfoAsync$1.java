package androidx.work;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class CoroutineWorker$getForegroundInfoAsync$1 extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {
    final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
    Object L$0;
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineWorker$getForegroundInfoAsync$1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, e<? super CoroutineWorker$getForegroundInfoAsync$1> eVar) {
        super(2, eVar);
        this.$jobFuture = jobListenableFuture;
        this.this$0 = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final e<n1> create(@Nullable Object obj, @NotNull e<?> eVar) {
        return new CoroutineWorker$getForegroundInfoAsync$1(this.$jobFuture, this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull r0 r0Var, @Nullable e<? super n1> eVar) {
        return ((CoroutineWorker$getForegroundInfoAsync$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JobListenableFuture jobListenableFuture;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                jobListenableFuture = (JobListenableFuture) this.L$0;
                g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            JobListenableFuture<ForegroundInfo> jobListenableFuture2 = this.$jobFuture;
            CoroutineWorker coroutineWorker = this.this$0;
            this.L$0 = jobListenableFuture2;
            this.label = 1;
            Object foregroundInfo = coroutineWorker.getForegroundInfo(this);
            if (foregroundInfo == l6) {
                return l6;
            }
            jobListenableFuture = jobListenableFuture2;
            obj = foregroundInfo;
        }
        jobListenableFuture.complete(obj);
        return n1.f44123a;
    }
}
