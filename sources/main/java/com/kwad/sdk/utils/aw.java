package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aw {
    private static volatile aw bad = new aw();
    private volatile boolean bae;
    private volatile long baf = 0;
    private volatile PowerManager bag;

    public static aw Rh() {
        return bad;
    }

    public final boolean dl(Context context) {
        if (this.baf > 0 && SystemClock.elapsedRealtime() - this.baf < 600) {
            return this.bae;
        }
        if (this.bag == null && context != null) {
            synchronized (this) {
                try {
                    if (this.bag == null) {
                        this.bag = (PowerManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("power");
                    }
                } finally {
                }
            }
        }
        this.bae = this.bag != null ? this.bag.isInteractive() : false;
        this.baf = SystemClock.elapsedRealtime();
        return this.bae;
    }
}
