package androidx.room.concurrent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ExclusiveLock {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Map<String, ReentrantLock> threadLocksMap = new LinkedHashMap();

    @Nullable
    private final FileLock fileLock;

    @NotNull
    private final ReentrantLock threadLock;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nExclusiveLock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExclusiveLock.kt\nandroidx/room/concurrent/ExclusiveLock$Companion\n+ 2 Synchronized.jvmAndroid.kt\nandroidx/room/concurrent/Synchronized_jvmAndroidKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,77:1\n22#2:78\n381#3,7:79\n*S KotlinDebug\n*F\n+ 1 ExclusiveLock.kt\nandroidx/room/concurrent/ExclusiveLock$Companion\n*L\n70#1:78\n71#1:79,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock getThreadLock(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = ExclusiveLock.threadLocksMap;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    reentrantLock = (ReentrantLock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FileLock getFileLock(String str) {
            return new FileLock(str);
        }
    }

    public ExclusiveLock(@NotNull String filename, boolean z5) {
        g0.p(filename, "filename");
        Companion companion = Companion;
        this.threadLock = companion.getThreadLock(filename);
        this.fileLock = z5 ? companion.getFileLock(filename) : null;
    }

    public final <T> T withLock(@NotNull Function0<? extends T> onLocked, @NotNull Function1 onLockError) {
        g0.p(onLocked, "onLocked");
        g0.p(onLockError, "onLockError");
        this.threadLock.lock();
        boolean z5 = false;
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.lock();
            }
            z5 = true;
            try {
                T invoke = onLocked.invoke();
                this.threadLock.unlock();
                return invoke;
            } finally {
                FileLock fileLock2 = this.fileLock;
                if (fileLock2 != null) {
                    fileLock2.unlock();
                }
            }
        } catch (Throwable th) {
            try {
                if (z5) {
                    throw th;
                }
                onLockError.invoke(th);
                throw new KotlinNothingValueException();
            } catch (Throwable th2) {
                this.threadLock.unlock();
                throw th2;
            }
        }
    }
}
