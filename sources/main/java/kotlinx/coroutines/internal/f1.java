package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/WeakMapCtorCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class f1 extends k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f1 f49260a = new f1();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ReentrantReadWriteLock f49261b = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> f49262c = new WeakHashMap<>();

    @Override // kotlinx.coroutines.internal.k
    @NotNull
    public Function1<Throwable, Throwable> a(@NotNull Class<? extends Throwable> cls) {
        Function1<Throwable, Throwable> b6;
        ReentrantReadWriteLock reentrantReadWriteLock = f49261b;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            Function1<Throwable, Throwable> function1 = f49262c.get(cls);
            if (function1 != null) {
                return function1;
            }
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
            int i6 = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i7 = 0; i7 < readHoldCount; i7++) {
                readLock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> weakHashMap = f49262c;
                Function1<Throwable, Throwable> function12 = weakHashMap.get(cls);
                if (function12 != null) {
                    return function12;
                }
                b6 = n.b(cls);
                weakHashMap.put(cls, b6);
                while (i6 < readHoldCount) {
                    readLock2.lock();
                    i6++;
                }
                writeLock.unlock();
                return b6;
            } finally {
                while (i6 < readHoldCount) {
                    readLock2.lock();
                    i6++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    private f1() {
    }
}
