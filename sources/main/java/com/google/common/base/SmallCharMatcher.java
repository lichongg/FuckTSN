package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    @VisibleForTesting
    static int chooseTableSize(int i6) {
        if (i6 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i6 - 1) << 1;
        while (highestOneBit * 0.5d < i6) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    private boolean checkFilter(int i6) {
        return 1 == ((this.filter >> i6) & 1);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c6) {
        if (c6 == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c6)) {
            return false;
        }
        int length = this.table.length - 1;
        int smear = smear(c6) & length;
        int i6 = smear;
        do {
            char c7 = this.table[i6];
            if (c7 == 0) {
                return false;
            }
            if (c7 == c6) {
                return true;
            }
            i6 = (i6 + 1) & length;
        } while (i6 != smear);
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c6 : this.table) {
            if (c6 != 0) {
                bitSet.set(c6);
            }
        }
    }

    private SmallCharMatcher(char[] cArr, long j6, boolean z5, String str) {
        super(str);
        this.table = cArr;
        this.filter = j6;
        this.containsZero = z5;
    }

    static CharMatcher from(BitSet bitSet, String str) {
        int i6;
        int cardinality = bitSet.cardinality();
        boolean z5 = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int i7 = chooseTableSize - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j6 = 0;
        while (nextSetBit != -1) {
            long j7 = (1 << nextSetBit) | j6;
            int smear = smear(nextSetBit);
            while (true) {
                i6 = smear & i7;
                if (cArr[i6] == 0) {
                    break;
                }
                smear = i6 + 1;
            }
            cArr[i6] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j6 = j7;
        }
        return new SmallCharMatcher(cArr, j6, z5, str);
    }

    static int smear(int i6) {
        return Integer.rotateLeft(i6 * (-862048943), 15) * C2;
    }
}
