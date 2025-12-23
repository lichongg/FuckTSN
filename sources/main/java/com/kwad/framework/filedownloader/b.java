package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements s.a, s.b {
    private long alc;
    private long ald;
    private long ale;
    private int alf;
    private int alg = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.alf = 0;
        this.alc = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void U(long j6) {
        if (this.alg <= 0) {
            return;
        }
        if (this.alc != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.alc;
            if (uptimeMillis < this.alg && (this.alf != 0 || uptimeMillis <= 0)) {
                return;
            }
            int i6 = (int) ((j6 - this.ald) / uptimeMillis);
            this.alf = i6;
            this.alf = Math.max(0, i6);
        }
        this.ald = j6;
        this.alc = SystemClock.uptimeMillis();
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j6) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j7 = j6 - this.ale;
        this.alc = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.alf = (int) j7;
        } else {
            this.alf = (int) (j7 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.alf;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j6) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.ale = j6;
    }
}
