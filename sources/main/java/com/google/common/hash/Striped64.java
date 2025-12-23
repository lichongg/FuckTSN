package com.google.common.hash;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;

    @NullableDecl
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* renamed from: p0, reason: collision with root package name */
        volatile long f32766p0;

        /* renamed from: p1, reason: collision with root package name */
        volatile long f32767p1;

        /* renamed from: p2, reason: collision with root package name */
        volatile long f32768p2;

        /* renamed from: p3, reason: collision with root package name */
        volatile long f32769p3;

        /* renamed from: p4, reason: collision with root package name */
        volatile long f32770p4;
        volatile long p5;
        volatile long p6;

        /* renamed from: q0, reason: collision with root package name */
        volatile long f32771q0;

        /* renamed from: q1, reason: collision with root package name */
        volatile long f32772q1;

        /* renamed from: q2, reason: collision with root package name */
        volatile long f32773q2;

        /* renamed from: q3, reason: collision with root package name */
        volatile long f32774q3;

        /* renamed from: q4, reason: collision with root package name */
        volatile long f32775q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        final boolean cas(long j6, long j7) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j6, j7);
        }

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e6) {
                throw new Error(e6);
            }
        }

        Cell(long j6) {
            this.value = j6;
        }
    }

    abstract long fn(long j6, long j7);

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e6) {
            throw new Error(e6);
        }
    }

    final boolean casBase(long j6, long j7) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j6, j7);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    final void internalReset(long j6) {
        Cell[] cellArr = this.cells;
        this.base = j6;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j6;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void retryUpdate(long r17, @org.checkerframework.checker.nullness.compatqual.NullableDecl int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Striped64.retryUpdate(long, int[], boolean):void");
    }

    Striped64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.Striped64.1
                    @Override // java.security.PrivilegedExceptionAction
                    public Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
        } catch (PrivilegedActionException e6) {
            throw new RuntimeException("Could not initialize intrinsics", e6.getCause());
        }
    }
}
