package androidx.room;

import com.baidu.idl.face.platform.utils.FileUtils;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", i = {0, 1}, l = {org.apache.commons.net.nntp.h.E, FileUtils.S_IRWXU}, m = "checkInvalidatedTables", n = {"connection", "invalidatedTableIds"}, s = {"L$0", "L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class TriggerBasedInvalidationTracker$checkInvalidatedTables$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$checkInvalidatedTables$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, kotlin.coroutines.e<? super TriggerBasedInvalidationTracker$checkInvalidatedTables$1> eVar) {
        super(eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object checkInvalidatedTables;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkInvalidatedTables = this.this$0.checkInvalidatedTables(null, this);
        return checkInvalidatedTables;
    }
}
