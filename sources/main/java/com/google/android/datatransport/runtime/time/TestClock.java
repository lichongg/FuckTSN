package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class TestClock implements Clock {
    private final AtomicLong timestamp;

    public void advance(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("cannot advance time backwards.");
        }
        this.timestamp.addAndGet(j6);
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.timestamp.get();
    }

    public void tick() {
        advance(1L);
    }

    public TestClock(long j6) {
        this.timestamp = new AtomicLong(j6);
    }
}
