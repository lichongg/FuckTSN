package androidx.room.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.AndroidSQLiteDriverPooledConnection", f = "AndroidSQLiteDriverConnectionPool.android.kt", i = {0, 0}, l = {87}, m = "transaction", n = {"this", "db"}, s = {"L$0", "L$1"})
/* loaded from: D:\Downloads\app\classes.dex */
final class AndroidSQLiteDriverPooledConnection$transaction$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidSQLiteDriverPooledConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidSQLiteDriverPooledConnection$transaction$1(AndroidSQLiteDriverPooledConnection androidSQLiteDriverPooledConnection, kotlin.coroutines.e<? super AndroidSQLiteDriverPooledConnection$transaction$1> eVar) {
        super(eVar);
        this.this$0 = androidSQLiteDriverPooledConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transaction(null, null, this);
    }
}
