package io.reactivex.internal.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;
    T[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i6) {
        this(i6, 0.75f);
    }

    public boolean add(T t5) {
        T t6;
        T[] tArr = this.keys;
        int i6 = this.mask;
        int mix = mix(t5.hashCode()) & i6;
        T t7 = tArr[mix];
        if (t7 != null) {
            if (t7.equals(t5)) {
                return false;
            }
            do {
                mix = (mix + 1) & i6;
                t6 = tArr[mix];
                if (t6 == null) {
                }
            } while (!t6.equals(t5));
            return false;
        }
        tArr[mix] = t5;
        int i7 = this.size + 1;
        this.size = i7;
        if (i7 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public Object[] keys() {
        return this.keys;
    }

    void rehash() {
        T t5;
        T[] tArr = this.keys;
        int length = tArr.length;
        int i6 = length << 1;
        int i7 = i6 - 1;
        T[] tArr2 = (T[]) new Object[i6];
        int i8 = this.size;
        while (true) {
            int i9 = i8 - 1;
            if (i8 == 0) {
                this.mask = i7;
                this.maxSize = (int) (i6 * this.loadFactor);
                this.keys = tArr2;
                return;
            }
            do {
                length--;
                t5 = tArr[length];
            } while (t5 == null);
            int mix = mix(t5.hashCode()) & i7;
            if (tArr2[mix] != null) {
                do {
                    mix = (mix + 1) & i7;
                } while (tArr2[mix] != null);
            }
            tArr2[mix] = tArr[length];
            i8 = i9;
        }
    }

    public boolean remove(T t5) {
        T t6;
        T[] tArr = this.keys;
        int i6 = this.mask;
        int mix = mix(t5.hashCode()) & i6;
        T t7 = tArr[mix];
        if (t7 == null) {
            return false;
        }
        if (t7.equals(t5)) {
            return removeEntry(mix, tArr, i6);
        }
        do {
            mix = (mix + 1) & i6;
            t6 = tArr[mix];
            if (t6 == null) {
                return false;
            }
        } while (!t6.equals(t5));
        return removeEntry(mix, tArr, i6);
    }

    boolean removeEntry(int i6, T[] tArr, int i7) {
        int i8;
        T t5;
        this.size--;
        while (true) {
            int i9 = i6 + 1;
            while (true) {
                i8 = i9 & i7;
                t5 = tArr[i8];
                if (t5 == null) {
                    tArr[i6] = null;
                    return true;
                }
                int mix = mix(t5.hashCode()) & i7;
                if (i6 > i8) {
                    if (i6 >= mix && mix > i8) {
                        break;
                    }
                    i9 = i8 + 1;
                } else if (i6 < mix && mix <= i8) {
                    i9 = i8 + 1;
                }
            }
            tArr[i6] = t5;
            i6 = i8;
        }
    }

    public int size() {
        return this.size;
    }

    public OpenHashSet(int i6, float f6) {
        this.loadFactor = f6;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i6);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (f6 * roundToPowerOfTwo);
        this.keys = (T[]) new Object[roundToPowerOfTwo];
    }

    static int mix(int i6) {
        int i7 = i6 * INT_PHI;
        return i7 ^ (i7 >>> 16);
    }
}
