package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class FullArbiterMissed extends FullArbiterPad1 {
    final AtomicLong missedRequested = new AtomicLong();

    FullArbiterMissed() {
    }
}
