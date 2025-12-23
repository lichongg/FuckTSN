package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private final long WA = System.currentTimeMillis();
    private final Lifecycle.Event Wz;

    public final Lifecycle.Event sa() {
        return this.Wz;
    }

    public final long sb() {
        return this.WA;
    }

    public final String toString() {
        return "LifecycleStamp{mEvent=" + this.Wz + ", mEventTimestamp=" + this.WA + '}';
    }

    public d(Lifecycle.Event event) {
        this.Wz = event;
    }
}
