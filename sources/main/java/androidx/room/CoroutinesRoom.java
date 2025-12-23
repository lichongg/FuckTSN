package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.CoroutinesRoom;
import androidx.room.coroutines.FlowUtil;
import androidx.sqlite.SQLiteConnection;
import java.util.concurrent.Callable;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class CoroutinesRoom {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCoroutinesRoom.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutinesRoom.android.kt\nandroidx/room/CoroutinesRoom$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,93:1\n314#2,11:94\n*S KotlinDebug\n*F\n+ 1 CoroutinesRoom.android.kt\nandroidx/room/CoroutinesRoom$Companion\n*L\n65#1:94,11\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
        
            if (r9 == r1) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @kotlin.Deprecated(message = "No longer called by generated implementation")
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <R> java.lang.Object execute(@org.jetbrains.annotations.NotNull androidx.room.RoomDatabase r6, boolean r7, @org.jetbrains.annotations.NotNull java.util.concurrent.Callable<R> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r9) {
            /*
                r5 = this;
                boolean r0 = r9 instanceof androidx.room.CoroutinesRoom$Companion$execute$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = (androidx.room.CoroutinesRoom$Companion$execute$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = new androidx.room.CoroutinesRoom$Companion$execute$1
                r0.<init>(r5, r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3d
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.g0.n(r9)
                return r9
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.L$0
                r8 = r6
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                kotlin.g0.n(r9)
                goto L5c
            L3d:
                kotlin.g0.n(r9)
                boolean r9 = r6.isOpenInternal()
                if (r9 == 0) goto L51
                boolean r9 = r6.inTransaction()
                if (r9 == 0) goto L51
                java.lang.Object r6 = r8.call()
                return r6
            L51:
                r0.L$0 = r8
                r0.label = r4
                java.lang.Object r9 = androidx.room.util.DBUtil.getCoroutineContext(r6, r7, r0)
                if (r9 != r1) goto L5c
                goto L6e
            L5c:
                kotlin.coroutines.i r9 = (kotlin.coroutines.i) r9
                androidx.room.CoroutinesRoom$Companion$execute$2 r6 = new androidx.room.CoroutinesRoom$Companion$execute$2
                r7 = 0
                r6.<init>(r8, r7)
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r6 = kotlinx.coroutines.i.h(r9, r6, r0)
                if (r6 != r1) goto L6f
            L6e:
                return r1
            L6f:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, java.util.concurrent.Callable, kotlin.coroutines.e):java.lang.Object");
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createFlow$lambda$1(Callable callable, SQLiteConnection it) {
            g0.p(it, "it");
            return callable.call();
        }

        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        @NotNull
        public final <R> kotlinx.coroutines.flow.i<R> createFlow(@NotNull RoomDatabase db, boolean z5, @NotNull String[] tableNames, @NotNull final Callable<R> callable) {
            g0.p(db, "db");
            g0.p(tableNames, "tableNames");
            g0.p(callable, "callable");
            return FlowUtil.createFlow(db, z5, tableNames, new Function1() { // from class: androidx.room.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object createFlow$lambda$1;
                    createFlow$lambda$1 = CoroutinesRoom.Companion.createFlow$lambda$1(callable, (SQLiteConnection) obj);
                    return createFlow$lambda$1;
                }
            });
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
        
            if (r8 == r4) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00cb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00cc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
        @kotlin.Deprecated(message = "No longer called by generated implementation")
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <R> java.lang.Object execute(@org.jetbrains.annotations.NotNull androidx.room.RoomDatabase r17, boolean r18, @org.jetbrains.annotations.Nullable android.os.CancellationSignal r19, @org.jetbrains.annotations.NotNull java.util.concurrent.Callable<R> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r21) {
            /*
                r16 = this;
                r0 = r17
                r1 = r21
                boolean r2 = r1 instanceof androidx.room.CoroutinesRoom$Companion$execute$3
                if (r2 == 0) goto L19
                r2 = r1
                androidx.room.CoroutinesRoom$Companion$execute$3 r2 = (androidx.room.CoroutinesRoom$Companion$execute$3) r2
                int r3 = r2.label
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = r3 & r4
                if (r5 == 0) goto L19
                int r3 = r3 - r4
                r2.label = r3
                r3 = r16
                goto L20
            L19:
                androidx.room.CoroutinesRoom$Companion$execute$3 r2 = new androidx.room.CoroutinesRoom$Companion$execute$3
                r3 = r16
                r2.<init>(r3, r1)
            L20:
                java.lang.Object r1 = r2.result
                java.lang.Object r4 = kotlin.coroutines.intrinsics.a.l()
                int r5 = r2.label
                r6 = 2
                r7 = 1
                if (r5 == 0) goto L61
                if (r5 == r7) goto L4c
                if (r5 != r6) goto L44
                java.lang.Object r0 = r2.L$3
                kotlin.coroutines.i r0 = (kotlin.coroutines.i) r0
                java.lang.Object r0 = r2.L$2
                java.util.concurrent.Callable r0 = (java.util.concurrent.Callable) r0
                java.lang.Object r0 = r2.L$1
                android.os.CancellationSignal r0 = (android.os.CancellationSignal) r0
                java.lang.Object r0 = r2.L$0
                androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
                kotlin.g0.n(r1)
                return r1
            L44:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L4c:
                java.lang.Object r0 = r2.L$2
                java.util.concurrent.Callable r0 = (java.util.concurrent.Callable) r0
                java.lang.Object r5 = r2.L$1
                android.os.CancellationSignal r5 = (android.os.CancellationSignal) r5
                java.lang.Object r8 = r2.L$0
                androidx.room.RoomDatabase r8 = (androidx.room.RoomDatabase) r8
                kotlin.g0.n(r1)
                r15 = r5
                r5 = r0
                r0 = r8
                r8 = r1
                r1 = r15
                goto L8a
            L61:
                kotlin.g0.n(r1)
                boolean r1 = r0.isOpenInternal()
                if (r1 == 0) goto L75
                boolean r1 = r0.inTransaction()
                if (r1 == 0) goto L75
                java.lang.Object r0 = r20.call()
                return r0
            L75:
                r2.L$0 = r0
                r1 = r19
                r2.L$1 = r1
                r5 = r20
                r2.L$2 = r5
                r2.label = r7
                r8 = r18
                java.lang.Object r8 = androidx.room.util.DBUtil.getCoroutineContext(r0, r8, r2)
                if (r8 != r4) goto L8a
                goto Lcb
            L8a:
                r10 = r8
                kotlin.coroutines.i r10 = (kotlin.coroutines.i) r10
                r2.L$0 = r0
                r2.L$1 = r1
                r2.L$2 = r5
                r2.L$3 = r10
                r2.label = r6
                kotlinx.coroutines.q r6 = new kotlinx.coroutines.q
                kotlin.coroutines.e r8 = kotlin.coroutines.intrinsics.a.e(r2)
                r6.<init>(r8, r7)
                r6.Q()
                kotlinx.coroutines.r0 r9 = r0.getCoroutineScope()
                androidx.room.CoroutinesRoom$Companion$execute$4$job$1 r12 = new androidx.room.CoroutinesRoom$Companion$execute$4$job$1
                r0 = 0
                r12.<init>(r5, r6, r0)
                r13 = 2
                r14 = 0
                r11 = 0
                kotlinx.coroutines.e2 r0 = kotlinx.coroutines.i.e(r9, r10, r11, r12, r13, r14)
                androidx.room.CoroutinesRoom$Companion$execute$4$1 r5 = new androidx.room.CoroutinesRoom$Companion$execute$4$1
                r5.<init>()
                r6.I(r5)
                java.lang.Object r0 = r6.x()
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                if (r0 != r1) goto Lc9
                kotlin.coroutines.jvm.internal.e.c(r2)
            Lc9:
                if (r0 != r4) goto Lcc
            Lcb:
                return r4
            Lcc:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, android.os.CancellationSignal, java.util.concurrent.Callable, kotlin.coroutines.e):java.lang.Object");
        }
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z5, @Nullable CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return Companion.execute(roomDatabase, z5, cancellationSignal, callable, eVar);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    @NotNull
    public static final <R> kotlinx.coroutines.flow.i<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z5, @NotNull String[] strArr, @NotNull Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z5, strArr, callable);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z5, @NotNull Callable<R> callable, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return Companion.execute(roomDatabase, z5, callable, eVar);
    }

    private CoroutinesRoom() {
    }
}
