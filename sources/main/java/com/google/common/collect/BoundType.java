package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    static BoundType forBoolean(boolean z5) {
        return z5 ? CLOSED : OPEN;
    }

    BoundType flip() {
        return forBoolean(!this.inclusive);
    }

    BoundType(boolean z5) {
        this.inclusive = z5;
    }
}
