package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ThreadLocalRandom extends Random {
    private static final long addend = 11;
    private static volatile long initialSeedUniquifier = 0;
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static volatile long seedGeneratorEndTime = 0;
    private static final long seedGeneratorStartTime;
    private static final Thread seedGeneratorThread;
    private static final BlockingQueue<Long> seedQueue;
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ThreadLocalRandom.class);
    private static final AtomicLong seedUniquifier = new AtomicLong();

    public double nextDouble(double d6) {
        if (d6 > 0.0d) {
            return nextDouble() * d6;
        }
        throw new IllegalArgumentException("n must be positive");
    }

    public long nextLong(long j6) {
        long j7 = 0;
        if (j6 <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        while (j6 >= 2147483647L) {
            int next = next(2);
            long j8 = j6 >>> 1;
            if ((next & 2) != 0) {
                j8 = j6 - j8;
            }
            if ((next & 1) == 0) {
                j7 += j6 - j8;
            }
            j6 = j8;
        }
        return j7 + nextInt((int) j6);
    }

    static {
        initialSeedUniquifier = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0L);
        if (initialSeedUniquifier != 0) {
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0L;
        } else {
            if (!SystemPropertyUtil.getBoolean("java.util.secureRandomSeed", false)) {
                initialSeedUniquifier = mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
                seedGeneratorThread = null;
                seedQueue = null;
                seedGeneratorStartTime = 0L;
                return;
            }
            seedQueue = new LinkedBlockingQueue();
            seedGeneratorStartTime = System.nanoTime();
            Thread thread = new Thread("initialSeedUniquifierGenerator") { // from class: io.netty.util.internal.ThreadLocalRandom.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    byte[] generateSeed = new SecureRandom().generateSeed(8);
                    long unused = ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                    ThreadLocalRandom.seedQueue.add(Long.valueOf((generateSeed[7] & 255) | ((generateSeed[0] & 255) << 56) | ((generateSeed[1] & 255) << 48) | ((generateSeed[2] & 255) << 40) | ((generateSeed[3] & 255) << 32) | ((generateSeed[4] & 255) << 24) | ((generateSeed[5] & 255) << 16) | ((generateSeed[6] & 255) << 8)));
                }
            };
            seedGeneratorThread = thread;
            thread.setDaemon(true);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.netty.util.internal.ThreadLocalRandom.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    ThreadLocalRandom.logger.debug("An exception has been raised by {}", thread2.getName(), th);
                }
            });
            thread.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0042, code lost:
    
        r4 = r10.longValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getInitialSeedUniquifier() {
        /*
            long r0 = io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9
            return r0
        L9:
            java.lang.Class<io.netty.util.internal.ThreadLocalRandom> r0 = io.netty.util.internal.ThreadLocalRandom.class
            monitor-enter(r0)
            long r4 = io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier     // Catch: java.lang.Throwable -> L14
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r4
        L14:
            r1 = move-exception
            goto L8f
        L17:
            long r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorStartTime     // Catch: java.lang.Throwable -> L14
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L14
            r8 = 3
            long r10 = r1.toNanos(r8)     // Catch: java.lang.Throwable -> L14
            long r6 = r6 + r10
        L22:
            long r10 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L14
            long r10 = r6 - r10
            int r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r1 > 0) goto L35
            java.util.concurrent.BlockingQueue<java.lang.Long> r10 = io.netty.util.internal.ThreadLocalRandom.seedQueue     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
            java.lang.Object r10 = r10.poll()     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
            java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
            goto L3f
        L35:
            java.util.concurrent.BlockingQueue<java.lang.Long> r12 = io.netty.util.internal.ThreadLocalRandom.seedQueue     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
            java.lang.Object r10 = r12.poll(r10, r13)     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
            java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
        L3f:
            r11 = 0
            if (r10 == 0) goto L47
            long r4 = r10.longValue()     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L5a
            goto L62
        L47:
            if (r1 > 0) goto L22
            java.lang.Thread r1 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorThread     // Catch: java.lang.Throwable -> L14
            r1.interrupt()     // Catch: java.lang.Throwable -> L14
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.util.internal.ThreadLocalRandom.logger     // Catch: java.lang.Throwable -> L14
            java.lang.String r6 = "Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?"
            java.lang.Long r7 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L14
            r1.warn(r6, r7)     // Catch: java.lang.Throwable -> L14
            goto L62
        L5a:
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.util.internal.ThreadLocalRandom.logger     // Catch: java.lang.Throwable -> L14
            java.lang.String r6 = "Failed to generate a seed from SecureRandom due to an InterruptedException."
            r1.warn(r6)     // Catch: java.lang.Throwable -> L14
            r11 = 1
        L62:
            r6 = 3627065505421648153(0x3255ecdc33bae119, double:3.253008663204319E-66)
            long r4 = r4 ^ r6
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L14
            long r6 = java.lang.Long.reverse(r6)     // Catch: java.lang.Throwable -> L14
            long r4 = r4 ^ r6
            io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier = r4     // Catch: java.lang.Throwable -> L14
            if (r11 == 0) goto L81
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L14
            r1.interrupt()     // Catch: java.lang.Throwable -> L14
            java.lang.Thread r1 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorThread     // Catch: java.lang.Throwable -> L14
            r1.interrupt()     // Catch: java.lang.Throwable -> L14
        L81:
            long r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime     // Catch: java.lang.Throwable -> L14
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L8d
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L14
            io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime = r1     // Catch: java.lang.Throwable -> L14
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r4
        L8f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.ThreadLocalRandom.getInitialSeedUniquifier():long");
    }

    private static long mix64(long j6) {
        long j7 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
        long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
        return j8 ^ (j8 >>> 33);
    }

    private static long newSeed() {
        AtomicLong atomicLong;
        long j6;
        long initialSeedUniquifier2;
        long j7;
        do {
            atomicLong = seedUniquifier;
            j6 = atomicLong.get();
            initialSeedUniquifier2 = j6 != 0 ? j6 : getInitialSeedUniquifier();
            j7 = 181783497276652981L * initialSeedUniquifier2;
        } while (!atomicLong.compareAndSet(j6, j7));
        if (j6 == 0) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                if (seedGeneratorEndTime != 0) {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", Long.valueOf(initialSeedUniquifier2), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(seedGeneratorEndTime - seedGeneratorStartTime))));
                } else {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", Long.valueOf(initialSeedUniquifier2)));
                }
            }
        }
        return System.nanoTime() ^ j7;
    }

    public static void setInitialSeedUniquifier(long j6) {
        initialSeedUniquifier = j6;
    }

    @Override // java.util.Random
    protected int next(int i6) {
        long j6 = ((this.rnd * multiplier) + 11) & mask;
        this.rnd = j6;
        return (int) (j6 >>> (48 - i6));
    }

    public int nextInt(int i6, int i7) {
        if (i6 < i7) {
            return nextInt(i7 - i6) + i6;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.Random
    public void setSeed(long j6) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
        this.rnd = (j6 ^ multiplier) & mask;
    }

    ThreadLocalRandom() {
        super(newSeed());
        this.initialized = true;
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    public double nextDouble(double d6, double d7) {
        if (d6 < d7) {
            return (nextDouble() * (d7 - d6)) + d6;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong(long j6, long j7) {
        if (j6 < j7) {
            return nextLong(j7 - j6) + j6;
        }
        throw new IllegalArgumentException();
    }
}
