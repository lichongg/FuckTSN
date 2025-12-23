package com.clj.fastble.data;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public enum BleScanState {
    STATE_IDLE(-1),
    STATE_SCANNING(1);

    private int code;

    public int getCode() {
        return this.code;
    }

    BleScanState(int i6) {
        this.code = i6;
    }
}
