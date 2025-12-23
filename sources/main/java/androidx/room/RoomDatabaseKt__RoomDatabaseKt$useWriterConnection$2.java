package androidx.room;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2", f = "RoomDatabase.kt", i = {}, l = {496}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2<R> extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super R>, Object> {
    final /* synthetic */ Function2<Transactor, kotlin.coroutines.e<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_useWriterConnection;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2(RoomDatabase roomDatabase, Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, kotlin.coroutines.e<? super RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2> eVar) {
        super(2, eVar);
        this.$this_useWriterConnection = roomDatabase;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2(this.$this_useWriterConnection, this.$block, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super R> eVar) {
        return ((RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        g0.n(obj);
        RoomDatabase roomDatabase = this.$this_useWriterConnection;
        Function2<Transactor, kotlin.coroutines.e<? super R>, Object> function2 = this.$block;
        this.label = 1;
        Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, function2, this);
        if (useConnection$room_runtime_release == l6) {
            return l6;
        }
        return useConnection$room_runtime_release;
    }
}
