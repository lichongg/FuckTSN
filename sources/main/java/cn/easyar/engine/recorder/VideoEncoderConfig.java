package cn.easyar.engine.recorder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class VideoEncoderConfig {
    private int mBitRate;
    private String mFormat = "avc";
    private int mHeight;
    private int mTexHeiht;
    private int mTexWidth;
    private int mWidth;
    private int zoomMode;

    public int getBitRate() {
        return this.mBitRate;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getTextureHeight() {
        return this.mTexHeiht;
    }

    public int getTextureWidth() {
        return this.mTexWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getZoomMode() {
        return this.zoomMode;
    }

    public void setHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public void setTextureHeight(int mHeight) {
        this.mTexHeiht = mHeight;
    }

    public void setTextureWidth(int mWidth) {
        this.mTexWidth = mWidth;
    }

    public void setWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public String toString() {
        return "VideoEncoderConfig{mFormat='" + this.mFormat + "', mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mBitRate=" + this.mBitRate + '}';
    }

    public VideoEncoderConfig(int width, int height, int texWidth, int texHeight, int mBitRate, int mode) {
        this.mWidth = width;
        this.mHeight = height;
        this.mTexWidth = texWidth;
        this.mTexHeiht = texHeight;
        this.mBitRate = mBitRate;
        this.zoomMode = mode;
    }
}
