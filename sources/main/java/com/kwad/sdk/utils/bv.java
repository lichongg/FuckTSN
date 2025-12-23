package com.kwad.sdk.utils;

import android.os.SystemClock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bv {
    private long bbB;
    private long bbC;
    private boolean bbD;

    private void reset() {
        this.bbB = 0L;
        this.bbC = -1L;
    }

    public final void Sl() {
        if (this.bbD && this.bbC < 0) {
            this.bbC = SystemClock.elapsedRealtime();
        }
    }

    public final void Sm() {
        if (this.bbD && this.bbC > 0) {
            this.bbB += SystemClock.elapsedRealtime() - this.bbC;
            this.bbC = -1L;
        }
    }

    public final long Sn() {
        if (!this.bbD) {
            return 0L;
        }
        this.bbD = false;
        if (this.bbC > 0) {
            this.bbB += SystemClock.elapsedRealtime() - this.bbC;
            this.bbC = -1L;
        }
        return this.bbB;
    }

    public final long getTime() {
        return this.bbC > 0 ? (this.bbB + SystemClock.elapsedRealtime()) - this.bbC : this.bbB;
    }

    public bv() {
        reset();
    }

    public final void startTiming() {
        reset();
        this.bbD = true;
        this.bbC = SystemClock.elapsedRealtime();
    }
}
