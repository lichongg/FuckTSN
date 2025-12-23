package androidx.room;

import java.util.Arrays;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1", f = "MultiInstanceInvalidationClient.android.kt", i = {0}, l = {87}, m = "invokeSuspend", n = {"invalidatedTablesSet"}, s = {"L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ String[] $tables;
    Object L$0;
    int label;
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(String[] strArr, MultiInstanceInvalidationClient multiInstanceInvalidationClient, kotlin.coroutines.e<? super MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1> eVar) {
        super(2, eVar);
        this.$tables = strArr;
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(this.$tables, this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlinx.coroutines.flow.s sVar;
        Set<String> set;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                set = (Set) this.L$0;
                g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            String[] strArr = this.$tables;
            Set<String> u5 = u1.u(Arrays.copyOf(strArr, strArr.length));
            sVar = this.this$0.invalidatedTables;
            this.L$0 = u5;
            this.label = 1;
            if (sVar.emit(u5, this) == l6) {
                return l6;
            }
            set = u5;
        }
        this.this$0.getInvalidationTracker().notifyObserversByTableNames$room_runtime_release(set);
        return n1.f44123a;
    }
}
