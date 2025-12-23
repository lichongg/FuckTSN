package cn.easyar.engine.recorder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AudioEncorderConfig {
    private int mBitRate;
    private int mChannel;
    private int mHz;

    public int getBitRate() {
        return this.mBitRate;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public int getSampleRate() {
        return this.mHz;
    }

    public String toString() {
        return "AudioEncorderConfig{mChannel=" + this.mChannel + ", mHz=" + this.mHz + ", mBitRate=" + this.mBitRate + '}';
    }

    public AudioEncorderConfig(int mBitRate, int mChannel, int mHz) {
        this.mBitRate = mBitRate;
        this.mChannel = mChannel;
        this.mHz = mHz;
    }
}
