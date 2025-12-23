package com.bytedance.sdk.openadsdk.core.mi;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum j {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);


    /* renamed from: m, reason: collision with root package name */
    private long f29520m;
    private long up;

    public long j() {
        return this.up;
    }

    j(int i6) {
        if (i6 >= 0 && i6 <= 63) {
            this.up = 1 << i6;
            this.f29520m = i6;
            return;
        }
        throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
    }
}
