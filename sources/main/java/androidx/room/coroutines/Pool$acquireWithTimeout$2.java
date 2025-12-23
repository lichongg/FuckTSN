package androidx.room.coroutines;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.Pool$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class Pool$acquireWithTimeout$2 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ Ref.ObjectRef<ConnectionWithLock> $connection;
    Object L$0;
    int label;
    final /* synthetic */ Pool this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Pool$acquireWithTimeout$2(Ref.ObjectRef<ConnectionWithLock> objectRef, Pool pool, kotlin.coroutines.e<? super Pool$acquireWithTimeout$2> eVar) {
        super(2, eVar);
        this.$connection = objectRef;
        this.this$0 = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new Pool$acquireWithTimeout$2(this.$connection, this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((Pool$acquireWithTimeout$2) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<ConnectionWithLock> objectRef;
        T t5;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                objectRef = (Ref.ObjectRef) this.L$0;
                g0.n(obj);
                t5 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            Ref.ObjectRef<ConnectionWithLock> objectRef2 = this.$connection;
            Pool pool = this.this$0;
            this.L$0 = objectRef2;
            this.label = 1;
            Object acquire = pool.acquire(this);
            if (acquire == l6) {
                return l6;
            }
            objectRef = objectRef2;
            t5 = acquire;
        }
        objectRef.element = t5;
        return n1.f44123a;
    }
}
