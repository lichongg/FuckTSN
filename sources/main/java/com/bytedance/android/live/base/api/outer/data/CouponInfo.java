package com.bytedance.android.live.base.api.outer.data;

/* loaded from: D:\Downloads\app\classes3.dex */
public class CouponInfo {
    long amount;
    boolean applied;
    long threshold;
    long type;

    public long getAmount() {
        return this.amount;
    }

    public long getThreshold() {
        return this.threshold;
    }

    public long getType() {
        return this.type;
    }

    public boolean isApplied() {
        return this.applied;
    }

    public CouponInfo(long j6, long j7, long j8, boolean z5) {
        this.type = j6;
        this.threshold = j7;
        this.amount = j8;
        this.applied = z5;
    }
}
