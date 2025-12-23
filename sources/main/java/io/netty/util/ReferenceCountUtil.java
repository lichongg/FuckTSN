package io.netty.util;

import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ReferenceCountUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountUtil.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ReleasingTask implements Runnable {
        private final int decrement;
        private final ReferenceCounted obj;

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.obj.release(this.decrement)) {
                    ReferenceCountUtil.logger.debug("Released: {}", this);
                } else {
                    ReferenceCountUtil.logger.warn("Non-zero refCnt: {}", this);
                }
            } catch (Exception e6) {
                ReferenceCountUtil.logger.warn("Failed to release an object: {}", this.obj, e6);
            }
        }

        public String toString() {
            return StringUtil.simpleClassName(this.obj) + ".release(" + this.decrement + ") refCnt: " + this.obj.refCnt();
        }

        ReleasingTask(ReferenceCounted referenceCounted, int i6) {
            this.obj = referenceCounted;
            this.decrement = i6;
        }
    }

    public static boolean release(Object obj) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).release();
        }
        return false;
    }

    @Deprecated
    public static <T> T releaseLater(T t5) {
        return (T) releaseLater(t5, 1);
    }

    public static <T> T retain(T t5) {
        return t5 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t5).retain() : t5;
    }

    public static void safeRelease(Object obj) {
        try {
            release(obj);
        } catch (Throwable th) {
            logger.warn("Failed to release a message: {}", obj, th);
        }
    }

    public static <T> T touch(T t5) {
        return t5 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t5).touch() : t5;
    }

    static {
        ResourceLeakDetector.addExclusions(ReferenceCountUtil.class, "touch");
    }

    public static int refCnt(Object obj) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).refCnt();
        }
        return -1;
    }

    @Deprecated
    public static <T> T releaseLater(T t5, int i6) {
        if (t5 instanceof ReferenceCounted) {
            ThreadDeathWatcher.watch(Thread.currentThread(), new ReleasingTask((ReferenceCounted) t5, i6));
        }
        return t5;
    }

    private ReferenceCountUtil() {
    }

    public static boolean release(Object obj, int i6) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).release(i6);
        }
        return false;
    }

    public static <T> T retain(T t5, int i6) {
        return t5 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t5).retain(i6) : t5;
    }

    public static void safeRelease(Object obj, int i6) {
        try {
            release(obj, i6);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to release a message: {} (decrement: {})", obj, Integer.valueOf(i6), th);
            }
        }
    }

    public static <T> T touch(T t5, Object obj) {
        return t5 instanceof ReferenceCounted ? (T) ((ReferenceCounted) t5).touch(obj) : t5;
    }
}
