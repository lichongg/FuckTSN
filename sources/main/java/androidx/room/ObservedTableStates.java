package androidx.room;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/ObservedTableStates\n+ 2 ReentrantLock.kt\nandroidx/room/concurrent/ReentrantLockKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,604:1\n28#2,5:605\n28#2,3:610\n32#2:615\n28#2,3:616\n32#2:621\n28#2,5:622\n28#2,5:627\n13423#3,2:613\n13423#3,2:619\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/ObservedTableStates\n*L\n508#1:605,5\n530#1:610,3\n530#1:615\n545#1:616,3\n545#1:621\n559#1:622,5\n565#1:627,5\n532#1:613,2\n547#1:619,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ObservedTableStates {

    @NotNull
    private final ReentrantLock lock = new ReentrantLock();
    private boolean needsSync;

    @NotNull
    private final boolean[] tableObservedState;

    @NotNull
    private final long[] tableObserversCount;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ObserveOp {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ ObserveOp[] $VALUES;
        public static final ObserveOp NO_OP = new ObserveOp("NO_OP", 0);
        public static final ObserveOp ADD = new ObserveOp("ADD", 1);
        public static final ObserveOp REMOVE = new ObserveOp("REMOVE", 2);

        private static final /* synthetic */ ObserveOp[] $values() {
            return new ObserveOp[]{NO_OP, ADD, REMOVE};
        }

        static {
            ObserveOp[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<ObserveOp> getEntries() {
            return $ENTRIES;
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) $VALUES.clone();
        }

        private ObserveOp(String str, int i6) {
        }
    }

    public final void forceNeedSync$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.needsSync = true;
            n1 n1Var = n1.f44123a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Nullable
    public final ObserveOp[] getTablesToSync$room_runtime_release() {
        ObserveOp observeOp;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.needsSync) {
                reentrantLock.unlock();
                return null;
            }
            this.needsSync = false;
            int length = this.tableObserversCount.length;
            ObserveOp[] observeOpArr = new ObserveOp[length];
            int i6 = 0;
            boolean z5 = false;
            while (i6 < length) {
                boolean z6 = true;
                boolean z7 = this.tableObserversCount[i6] > 0;
                boolean[] zArr = this.tableObservedState;
                if (z7 != zArr[i6]) {
                    zArr[i6] = z7;
                    observeOp = z7 ? ObserveOp.ADD : ObserveOp.REMOVE;
                } else {
                    z6 = z5;
                    observeOp = ObserveOp.NO_OP;
                }
                observeOpArr[i6] = observeOp;
                i6++;
                z5 = z6;
            }
            ObserveOp[] observeOpArr2 = z5 ? observeOpArr : null;
            reentrantLock.unlock();
            return observeOpArr2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean onObserverAdded$room_runtime_release(@NotNull int[] tableIds) {
        g0.p(tableIds, "tableIds");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z5 = false;
            for (int i6 : tableIds) {
                long[] jArr = this.tableObserversCount;
                long j6 = jArr[i6];
                jArr[i6] = 1 + j6;
                if (j6 == 0) {
                    z5 = true;
                    this.needsSync = true;
                }
            }
            return z5;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean onObserverRemoved$room_runtime_release(@NotNull int[] tableIds) {
        g0.p(tableIds, "tableIds");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z5 = false;
            for (int i6 : tableIds) {
                long[] jArr = this.tableObserversCount;
                long j6 = jArr[i6];
                jArr[i6] = j6 - 1;
                if (j6 == 1) {
                    z5 = true;
                    this.needsSync = true;
                }
            }
            return z5;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void resetTriggerState$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            kotlin.collections.n.X1(this.tableObservedState, false, 0, 0, 6, null);
            this.needsSync = true;
            n1 n1Var = n1.f44123a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public ObservedTableStates(int i6) {
        this.tableObserversCount = new long[i6];
        this.tableObservedState = new boolean[i6];
    }
}
