package net.surina.soundtouch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SoundTouch {

    /* renamed from: a, reason: collision with root package name */
    long f50446a;

    private final native void deleteInstance(long j6);

    public static final native String getErrorString();

    public static final native String getVersionString();

    private static final native long newInstance();

    private final native int processFile(long j6, String str, String str2);

    private final native void setPitchSemiTones(long j6, float f6);

    private final native void setSpeed(long j6, float f6);

    private final native void setTempo(long j6, float f6);

    static {
        System.loadLibrary("soundtouch");
    }

    public void a() {
        deleteInstance(this.f50446a);
        this.f50446a = 0L;
    }

    public int b(String str, String str2) {
        return processFile(this.f50446a, str, str2);
    }

    public void c(float f6) {
        setPitchSemiTones(this.f50446a, f6);
    }

    public void d(float f6) {
        setSpeed(this.f50446a, f6);
    }

    public void e(float f6) {
        setTempo(this.f50446a, f6);
    }

    public SoundTouch() {
        this.f50446a = 0L;
        this.f50446a = newInstance();
    }
}
