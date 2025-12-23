package io.netty.util.internal;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ReferenceCountUpdater<T extends ReferenceCounted> {
    private static int realRefCnt(int i6) {
        if (i6 == 2 || i6 == 4 || (i6 & 1) == 0) {
            return i6 >>> 1;
        }
        return 0;
    }

    private static int toLiveRealRefCnt(int i6, int i7) {
        if (i6 == 2 || i6 == 4 || (i6 & 1) == 0) {
            return i6 >>> 1;
        }
        throw new IllegalReferenceCountException(0, -i7);
    }

    public final int initialValue() {
        return 2;
    }

    public final boolean release(T t5) {
        int nonVolatileRawCnt = nonVolatileRawCnt(t5);
        return nonVolatileRawCnt == 2 ? tryFinalRelease0(t5, 2) || retryRelease0(t5, 1) : nonFinalRelease0(t5, 1, nonVolatileRawCnt, toLiveRealRefCnt(nonVolatileRawCnt, 1));
    }

    public final T retain(T t5) {
        return retain0(t5, 1, 2);
    }

    protected abstract long unsafeOffset();

    protected abstract AtomicIntegerFieldUpdater<T> updater();

    private boolean nonFinalRelease0(T t5, int i6, int i7, int i8) {
        if (i6 >= i8 || !updater().compareAndSet(t5, i7, i7 - (i6 << 1))) {
            return retryRelease0(t5, i6);
        }
        return false;
    }

    public final T retain(T t5, int i6) {
        return retain0(t5, i6, ObjectUtil.checkPositive(i6, "increment") << 1);
    }

    protected ReferenceCountUpdater() {
    }

    public static long getUnsafeOffset(Class<? extends ReferenceCounted> cls, String str) {
        try {
            if (PlatformDependent.hasUnsafe()) {
                return PlatformDependent.objectFieldOffset(cls.getDeclaredField(str));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private int nonVolatileRawCnt(T t5) {
        long unsafeOffset = unsafeOffset();
        if (unsafeOffset != -1) {
            return PlatformDependent.getInt(t5, unsafeOffset);
        }
        return updater().get(t5);
    }

    private T retain0(T t5, int i6, int i7) {
        int andAdd = updater().getAndAdd(t5, i7);
        if (andAdd != 2 && andAdd != 4 && (andAdd & 1) != 0) {
            throw new IllegalReferenceCountException(0, i6);
        }
        if ((andAdd <= 0 && andAdd + i7 >= 0) || (andAdd >= 0 && andAdd + i7 < andAdd)) {
            updater().getAndAdd(t5, -i7);
            throw new IllegalReferenceCountException(realRefCnt(andAdd), i6);
        }
        return t5;
    }

    private boolean retryRelease0(T t5, int i6) {
        while (true) {
            int i7 = updater().get(t5);
            int liveRealRefCnt = toLiveRealRefCnt(i7, i6);
            if (i6 == liveRealRefCnt) {
                if (tryFinalRelease0(t5, i7)) {
                    return true;
                }
            } else if (i6 < liveRealRefCnt) {
                if (updater().compareAndSet(t5, i7, i7 - (i6 << 1))) {
                    return false;
                }
            } else {
                throw new IllegalReferenceCountException(liveRealRefCnt, -i6);
            }
            Thread.yield();
        }
    }

    private boolean tryFinalRelease0(T t5, int i6) {
        return updater().compareAndSet(t5, i6, 1);
    }

    public final boolean isLiveNonVolatile(T t5) {
        int i6;
        long unsafeOffset = unsafeOffset();
        if (unsafeOffset != -1) {
            i6 = PlatformDependent.getInt(t5, unsafeOffset);
        } else {
            i6 = updater().get(t5);
        }
        if (i6 == 2 || i6 == 4 || i6 == 6 || i6 == 8 || (i6 & 1) == 0) {
            return true;
        }
        return false;
    }

    public final int refCnt(T t5) {
        return realRefCnt(updater().get(t5));
    }

    public final void resetRefCnt(T t5) {
        updater().set(t5, initialValue());
    }

    public final void setRefCnt(T t5, int i6) {
        AtomicIntegerFieldUpdater<T> updater = updater();
        int i7 = 1;
        if (i6 > 0) {
            i7 = i6 << 1;
        }
        updater.set(t5, i7);
    }

    public final boolean release(T t5, int i6) {
        int nonVolatileRawCnt = nonVolatileRawCnt(t5);
        int liveRealRefCnt = toLiveRealRefCnt(nonVolatileRawCnt, ObjectUtil.checkPositive(i6, "decrement"));
        if (i6 == liveRealRefCnt) {
            return tryFinalRelease0(t5, nonVolatileRawCnt) || retryRelease0(t5, i6);
        }
        return nonFinalRelease0(t5, i6, nonVolatileRawCnt, liveRealRefCnt);
    }
}
