package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C7B4D5C9C")
/* loaded from: D:\Downloads\app\classes2.dex */
public class RecorderConfiguration extends RefBase {
    protected RecorderConfiguration(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("CEA9D9CE0")
    public native void setAudioBitrate(int bitrate);

    @MethodId("C12BD63E3")
    public native void setAudioSampleRate(int samplerate);

    @MethodId("C1AE339B1")
    public native void setChannelCount(int count);

    @MethodId("C6DF14130")
    public native void setOutputFile(String path);

    @MethodId("CC996899B")
    public native boolean setProfile(int profile);

    @MethodId("C6B68105C")
    public native void setVideoBitrate(int bitrate);

    @MethodId("CCFA93291")
    public native void setVideoOrientation(int mode);

    @MethodId("C13427EFD")
    public native void setVideoSize(int framesize);

    @MethodId("C499ECB84")
    public native void setZoomMode(int mode);

    public RecorderConfiguration() {
        super(_ctor(), null);
    }
}
