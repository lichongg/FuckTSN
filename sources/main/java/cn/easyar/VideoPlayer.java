package cn.easyar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("CB14117C8")
/* loaded from: D:\Downloads\app\classes2.dex */
public class VideoPlayer extends RefBase {
    protected VideoPlayer(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }

    @MethodId("CD33483F0")
    private static native long _ctor();

    @MethodId("CE93DF2A9")
    public static native boolean isAvailable();

    @MethodId("C310FF200")
    public native void close();

    @MethodId("CC48265F6")
    public native int currentPosition();

    @MethodId("CCAA79AF4")
    public native int duration();

    @MethodId("C8155C934")
    public native boolean isRenderTextureAvailable();

    @MethodId("C2348F998")
    public native void open(String path, int storageType, CallbackScheduler callbackScheduler, FunctorOfVoidFromVideoStatus callback);

    @MethodId("C6210C0BF")
    public native void pause();

    @MethodId("CABA4CC9B")
    public native boolean play();

    @MethodId("CCBD345D6")
    public native boolean seek(int position);

    @MethodId("C410CEEFD")
    public native void setRenderTexture(TextureId texture);

    @MethodId("CC213EC3E")
    public native void setVideoType(int videoType);

    @MethodId("CAA5D06BC")
    public native boolean setVolume(float volume);

    @MethodId("CCCDCBE84")
    public native Vec2I size();

    @MethodId("C6C45CB72")
    public native void stop();

    @MethodId("C14F3B6CB")
    public native void updateFrame();

    @MethodId("C62D7A6B1")
    public native float volume();

    public VideoPlayer() {
        super(_ctor(), null);
    }
}
