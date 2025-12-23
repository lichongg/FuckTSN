package com.baidu.mobads.sdk.api;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13),
    RewardVideo(14),
    PrerollVideoNative(15),
    FeedNative(16),
    FeedH5TemplateNative(17);

    private int value;

    public int getValue() {
        return this.value;
    }

    AdSize(int i6) {
        this.value = i6;
    }
}
