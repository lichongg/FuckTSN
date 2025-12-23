package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public enum QosTier {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);

    private static final SparseArray<QosTier> valueMap;
    private final int value;

    static {
        QosTier qosTier = DEFAULT;
        QosTier qosTier2 = UNMETERED_ONLY;
        QosTier qosTier3 = UNMETERED_OR_DAILY;
        QosTier qosTier4 = FAST_IF_RADIO_AWAKE;
        QosTier qosTier5 = NEVER;
        QosTier qosTier6 = UNRECOGNIZED;
        SparseArray<QosTier> sparseArray = new SparseArray<>();
        valueMap = sparseArray;
        sparseArray.put(0, qosTier);
        sparseArray.put(1, qosTier2);
        sparseArray.put(2, qosTier3);
        sparseArray.put(3, qosTier4);
        sparseArray.put(4, qosTier5);
        sparseArray.put(-1, qosTier6);
    }

    @Nullable
    public static QosTier forNumber(int i6) {
        if (i6 == 0) {
            return DEFAULT;
        }
        if (i6 == 1) {
            return UNMETERED_ONLY;
        }
        if (i6 == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i6 == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i6 != 4) {
            return null;
        }
        return NEVER;
    }

    public final int getNumber() {
        return this.value;
    }

    QosTier(int i6) {
        this.value = i6;
    }
}
