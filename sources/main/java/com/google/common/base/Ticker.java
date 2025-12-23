package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new Ticker() { // from class: com.google.common.base.Ticker.1
        @Override // com.google.common.base.Ticker
        public long read() {
            return Platform.systemNanoTime();
        }
    };

    public abstract long read();

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }

    protected Ticker() {
    }
}
