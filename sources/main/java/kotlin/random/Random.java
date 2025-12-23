package kotlin.random;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,387:1\n1#2:388\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Random {

    @NotNull
    public static final Default Default = new Default(null);

    @NotNull
    private static final Random defaultRandom = kotlin.internal.b.f43804a.b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Default extends Random implements Serializable {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class a implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f44139a = new a();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return Random.Default;
            }

            private a() {
            }
        }

        public /* synthetic */ Default(v vVar) {
            this();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array) {
            g0.p(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        private Default() {
        }

        private final void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final Object writeReplace() {
            return a.f44139a;
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(int i6) {
            return Random.defaultRandom.nextBytes(i6);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d6) {
            return Random.defaultRandom.nextDouble(d6);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i6) {
            return Random.defaultRandom.nextInt(i6);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j6) {
            return Random.defaultRandom.nextLong(j6);
        }

        @Override // kotlin.random.Random
        public int nextBits(int i6) {
            return Random.defaultRandom.nextBits(i6);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array, int i6, int i7) {
            g0.p(array, "array");
            return Random.defaultRandom.nextBytes(array, i6, i7);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d6, double d7) {
            return Random.defaultRandom.nextDouble(d6, d7);
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt(int i6, int i7) {
            return Random.defaultRandom.nextInt(i6, i7);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j6, long j7) {
            return Random.defaultRandom.nextLong(j6, j7);
        }
    }

    public abstract int nextBits(int i6);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] array, int i6, int i7) {
        g0.p(array, "array");
        if (i6 < 0 || i6 > array.length || i7 < 0 || i7 > array.length) {
            throw new IllegalArgumentException(("fromIndex (" + i6 + ") or toIndex (" + i7 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (i6 > i7) {
            throw new IllegalArgumentException(("fromIndex (" + i6 + ") must be not greater than toIndex (" + i7 + ").").toString());
        }
        int i8 = (i7 - i6) / 4;
        for (int i9 = 0; i9 < i8; i9++) {
            int nextInt = nextInt();
            array[i6] = (byte) nextInt;
            array[i6 + 1] = (byte) (nextInt >>> 8);
            array[i6 + 2] = (byte) (nextInt >>> 16);
            array[i6 + 3] = (byte) (nextInt >>> 24);
            i6 += 4;
        }
        int i10 = i7 - i6;
        int nextBits = nextBits(i10 * 8);
        for (int i11 = 0; i11 < i10; i11++) {
            array[i6 + i11] = (byte) (nextBits >>> (i11 * 8));
        }
        return array;
    }

    public double nextDouble() {
        return e.d(nextBits(26), nextBits(27));
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = bArr.length;
        }
        return random.nextBytes(bArr, i6, i7);
    }

    public double nextDouble(double d6) {
        return nextDouble(0.0d, d6);
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt(int i6) {
        return nextInt(0, i6);
    }

    public long nextLong(long j6) {
        return nextLong(0L, j6);
    }

    public double nextDouble(double d6, double d7) {
        double nextDouble;
        f.d(d6, d7);
        double d8 = d7 - d6;
        if (Double.isInfinite(d8) && Math.abs(d6) <= Double.MAX_VALUE && Math.abs(d7) <= Double.MAX_VALUE) {
            double d9 = 2;
            double nextDouble2 = nextDouble() * ((d7 / d9) - (d6 / d9));
            nextDouble = d6 + nextDouble2 + nextDouble2;
        } else {
            nextDouble = d6 + (nextDouble() * d8);
        }
        return nextDouble >= d7 ? Math.nextAfter(d7, Double.NEGATIVE_INFINITY) : nextDouble;
    }

    public int nextInt(int i6, int i7) {
        int nextInt;
        int i8;
        int i9;
        f.e(i6, i7);
        int i10 = i7 - i6;
        if (i10 > 0 || i10 == Integer.MIN_VALUE) {
            if (((-i10) & i10) == i10) {
                i9 = nextBits(f.g(i10));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i8 = nextInt % i10;
                } while ((nextInt - i8) + (i10 - 1) < 0);
                i9 = i8;
            }
            return i6 + i9;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i6 <= nextInt2 && nextInt2 < i7) {
                return nextInt2;
            }
        }
    }

    public long nextLong(long j6, long j7) {
        long nextLong;
        long j8;
        long j9;
        int nextInt;
        f.f(j6, j7);
        long j10 = j7 - j6;
        if (j10 > 0) {
            if (((-j10) & j10) == j10) {
                int i6 = (int) j10;
                int i7 = (int) (j10 >>> 32);
                if (i6 != 0) {
                    nextInt = nextBits(f.g(i6));
                } else if (i7 == 1) {
                    nextInt = nextInt();
                } else {
                    j9 = (nextBits(f.g(i7)) << 32) + (nextInt() & 4294967295L);
                }
                j9 = nextInt & 4294967295L;
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j8 = nextLong % j10;
                } while ((nextLong - j8) + (j10 - 1) < 0);
                j9 = j8;
            }
            return j6 + j9;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j6 <= nextLong2 && nextLong2 < j7) {
                return nextLong2;
            }
        }
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        g0.p(array, "array");
        return nextBytes(array, 0, array.length);
    }

    @NotNull
    public byte[] nextBytes(int i6) {
        return nextBytes(new byte[i6]);
    }
}
