package androidx.room.support;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.support.AutoCloser$decrementCountAndScheduleClose$2", f = "AutoCloser.android.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoCloser$decrementCountAndScheduleClose$2 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    int label;
    final /* synthetic */ AutoCloser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoCloser$decrementCountAndScheduleClose$2(AutoCloser autoCloser, kotlin.coroutines.e<? super AutoCloser$decrementCountAndScheduleClose$2> eVar) {
        super(2, eVar);
        this.this$0 = autoCloser;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new AutoCloser$decrementCountAndScheduleClose$2(this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((AutoCloser$decrementCountAndScheduleClose$2) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j6;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            j6 = this.this$0.autoCloseTimeoutInMs;
            this.label = 1;
            if (a1.b(j6, this) == l6) {
                return l6;
            }
        }
        this.this$0.autoCloseDatabase();
        return n1.f44123a;
    }
}
