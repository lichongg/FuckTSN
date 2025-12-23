package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class CollectPreconditions {
    @CanIgnoreReturnValue
    static int checkNonnegative(int i6, String str) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i6);
    }

    static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    @CanIgnoreReturnValue
    static long checkNonnegative(long j6, String str) {
        if (j6 >= 0) {
            return j6;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j6);
    }

    static void checkPositive(int i6, String str) {
        if (i6 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i6);
    }

    static void checkRemove(boolean z5) {
        Preconditions.checkState(z5, "no calls to next() since the last call to remove()");
    }

    CollectPreconditions() {
    }
}
