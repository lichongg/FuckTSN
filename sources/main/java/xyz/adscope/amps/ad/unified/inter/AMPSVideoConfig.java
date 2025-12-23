package xyz.adscope.amps.ad.unified.inter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSVideoConfig {
    private final int autoPlayPrivacy;
    private final boolean isMute;
    private int videoMaxTime;

    public int getAutoPlayPrivacy() {
        return this.autoPlayPrivacy;
    }

    public int getVideoMaxTime() {
        return this.videoMaxTime;
    }

    public boolean isMute() {
        return this.isMute;
    }

    public void setVideoMaxTime(int i6) {
        this.videoMaxTime = i6;
    }

    public AMPSVideoConfig(boolean z5, int i6) {
        this.isMute = z5;
        this.autoPlayPrivacy = i6;
    }
}
