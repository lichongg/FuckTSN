package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class Hashing {
    private static final long C1 = -862048943;
    private static final long C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    static int closedTableSize(int i6, double d6) {
        int max = Math.max(i6, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d6 * highestOneBit))) {
            return highestOneBit;
        }
        int i7 = highestOneBit << 1;
        if (i7 > 0) {
            return i7;
        }
        return 1073741824;
    }

    static boolean needsResizing(int i6, int i7, double d6) {
        return ((double) i6) > d6 * ((double) i7) && i7 < 1073741824;
    }

    static int smear(int i6) {
        return (int) (Integer.rotateLeft((int) (i6 * C1), 15) * C2);
    }

    static int smearedHash(@NullableDecl Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }

    private Hashing() {
    }
}
