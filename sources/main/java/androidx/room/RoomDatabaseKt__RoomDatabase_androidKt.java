package androidx.room;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRoomDatabase.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabaseKt__RoomDatabase_androidKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,2151:1\n314#2,11:2152\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabaseKt__RoomDatabase_androidKt\n*L\n2038#1:2152,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.coroutines.i createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(RoomDatabase roomDatabase, kotlin.coroutines.f fVar) {
        TransactionElement transactionElement = new TransactionElement(fVar);
        return fVar.plus(transactionElement).plus(f3.a(roomDatabase.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement))));
    }

    @Deprecated(message = "Replaced by equivalent API in InvalidationTracker.", replaceWith = @ReplaceWith(expression = "this.invalidationTracker.createFlow(*tables)", imports = {}))
    @NotNull
    public static final kotlinx.coroutines.flow.i<Set<String>> invalidationTrackerFlow(@NotNull RoomDatabase roomDatabase, @NotNull String[] tables, boolean z5) {
        g0.p(roomDatabase, "<this>");
        g0.p(tables, "tables");
        return roomDatabase.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(tables, tables.length), z5);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.i invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = true;
        }
        return RoomDatabaseKt.invalidationTrackerFlow(roomDatabase, strArr, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(final RoomDatabase roomDatabase, final kotlin.coroutines.i iVar, final Function2<? super r0, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, kotlin.coroutines.e<? super R> eVar) {
        final kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", i = {}, l = {2048}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
                    final /* synthetic */ kotlinx.coroutines.p<R> $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ Function2<r0, kotlin.coroutines.e<? super R>, Object> $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(RoomDatabase roomDatabase, kotlinx.coroutines.p<? super R> pVar, Function2<? super r0, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, kotlin.coroutines.e<? super AnonymousClass1> eVar) {
                        super(2, eVar);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = pVar;
                        this.$transactionBlock = function2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, eVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                        return ((AnonymousClass1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        kotlin.coroutines.i createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt;
                        kotlin.coroutines.e eVar;
                        Object l6 = kotlin.coroutines.intrinsics.a.l();
                        int i6 = this.label;
                        if (i6 != 0) {
                            if (i6 == 1) {
                                eVar = (kotlin.coroutines.e) this.L$0;
                                kotlin.g0.n(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            kotlin.g0.n(obj);
                            i.b bVar = ((r0) this.L$0).getCoroutineContext().get(kotlin.coroutines.f.f43765o0);
                            g0.m(bVar);
                            createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt = RoomDatabaseKt__RoomDatabase_androidKt.createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(this.$this_startTransactionCoroutine, (kotlin.coroutines.f) bVar);
                            kotlin.coroutines.e eVar2 = this.$continuation;
                            Result.a aVar = Result.Companion;
                            Function2<r0, kotlin.coroutines.e<? super R>, Object> function2 = this.$transactionBlock;
                            this.L$0 = eVar2;
                            this.label = 1;
                            obj = kotlinx.coroutines.i.h(createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt, function2, this);
                            if (obj == l6) {
                                return l6;
                            }
                            eVar = eVar2;
                        }
                        eVar.resumeWith(Result.m130constructorimpl(obj));
                        return n1.f44123a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        kotlinx.coroutines.i.f(kotlin.coroutines.i.this.minusKey(kotlin.coroutines.f.f43765o0), new AnonymousClass1(roomDatabase, qVar, function2, null));
                    } catch (Throwable th) {
                        qVar.a(th);
                    }
                }
            });
        } catch (RejectedExecutionException e6) {
            qVar.a(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e6));
        }
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @Nullable
    public static final <R> Object withTransaction(@NotNull RoomDatabase roomDatabase, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return RoomDatabaseKt.withTransactionContext(roomDatabase, new RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(roomDatabase, function1, null), eVar);
    }

    @Nullable
    public static final <R> Object withTransactionContext(@NotNull RoomDatabase roomDatabase, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(function1, null);
        TransactionElement transactionElement = (TransactionElement) eVar.getContext().get(TransactionElement.Key);
        kotlin.coroutines.f transactionDispatcher$room_runtime_release = transactionElement != null ? transactionElement.getTransactionDispatcher$room_runtime_release() : null;
        return transactionDispatcher$room_runtime_release != null ? kotlinx.coroutines.i.h(transactionDispatcher$room_runtime_release, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, eVar) : startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(roomDatabase, eVar.getContext(), roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, eVar);
    }
}
