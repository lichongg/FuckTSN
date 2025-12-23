package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    private volatile boolean abc;
    private long abd;
    private a abe = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private long abf = 0;
        private int abg = 0;

        public final void accumulate(long j6) {
            this.abf += j6;
            this.abg++;
        }

        public final void reset() {
            this.abf = 0L;
            this.abg = 0;
        }

        public final int ui() {
            return this.abg;
        }

        public final long uj() {
            return this.abf;
        }
    }

    public final void reset() {
        this.abc = false;
        this.abd = 0L;
        this.abe.reset();
    }

    public final void ud() {
        if (this.abc) {
            return;
        }
        this.abc = true;
        this.abd = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.a.a.eE("videoStartBlock");
    }

    public final void ue() {
        if (this.abc) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.abd;
            this.abe.accumulate(elapsedRealtime);
            this.abc = false;
            com.kwad.sdk.core.video.a.a.a.eE("videoEndBlock");
            com.kwad.sdk.core.video.a.a.a.eE("videoBlockTime_" + elapsedRealtime);
        }
    }

    public final boolean uf() {
        return this.abc;
    }

    @NonNull
    public final a ug() {
        if (this.abc) {
            this.abe.accumulate(SystemClock.elapsedRealtime() - this.abd);
            this.abc = false;
        }
        return this.abe;
    }

    public final long uh() {
        return this.abd;
    }
}
