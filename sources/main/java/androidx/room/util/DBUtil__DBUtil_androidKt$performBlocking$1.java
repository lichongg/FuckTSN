package androidx.room.util;

import androidx.room.RoomDatabase;
import androidx.sqlite.SQLiteConnection;
import kotlin.coroutines.e;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1", f = "DBUtil.android.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nDBUtil.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DBUtil.android.kt\nandroidx/room/util/DBUtil__DBUtil_androidKt$performBlocking$1\n+ 2 DBUtil.kt\nandroidx/room/util/DBUtil__DBUtilKt\n*L\n1#1,246:1\n48#2:247\n67#2:248\n*S KotlinDebug\n*F\n+ 1 DBUtil.android.kt\nandroidx/room/util/DBUtil__DBUtil_androidKt$performBlocking$1\n*L\n74#1:247\n74#1:248\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final class DBUtil__DBUtil_androidKt$performBlocking$1<R> extends SuspendLambda implements Function2<r0, e<? super R>, Object> {
    final /* synthetic */ Function1<SQLiteConnection, R> $block;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DBUtil__DBUtil_androidKt$performBlocking$1(RoomDatabase roomDatabase, boolean z5, boolean z6, Function1<? super SQLiteConnection, ? extends R> function1, e<? super DBUtil__DBUtil_androidKt$performBlocking$1> eVar) {
        super(2, eVar);
        this.$db = roomDatabase;
        this.$inTransaction = z5;
        this.$isReadOnly = z6;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final e<n1> create(Object obj, e<?> eVar) {
        return new DBUtil__DBUtil_androidKt$performBlocking$1(this.$db, this.$inTransaction, this.$isReadOnly, this.$block, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, e<? super R> eVar) {
        return ((DBUtil__DBUtil_androidKt$performBlocking$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z5;
        Object l6 = a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        g0.n(obj);
        if ((!this.$db.inCompatibilityMode$room_runtime_release() || !this.$db.inTransaction()) && this.$inTransaction) {
            z5 = true;
        } else {
            z5 = false;
        }
        RoomDatabase roomDatabase = this.$db;
        boolean z6 = this.$isReadOnly;
        DBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1(z5, z6, roomDatabase, null, this.$block);
        this.label = 1;
        Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(z6, dBUtil__DBUtil_androidKt$performBlocking$1$invokeSuspend$$inlined$internalPerform$1, this);
        if (useConnection$room_runtime_release == l6) {
            return l6;
        }
        return useConnection$room_runtime_release;
    }
}
