package androidx.room;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt", f = "RoomDatabase.kt", i = {0}, l = {496}, m = "useWriterConnection", n = {"$this$useWriterConnection"}, s = {"L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1<R> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.useWriterConnection(null, null, this);
    }

    RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1(kotlin.coroutines.e<? super RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1> eVar) {
        super(eVar);
    }
}
