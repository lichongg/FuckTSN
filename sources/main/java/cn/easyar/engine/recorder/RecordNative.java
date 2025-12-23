package cn.easyar.engine.recorder;

import android.view.Surface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RecordNative {
    private static final String TAG = "easyar.RecordNative";
    private long id = 0;
    private int width = 0;
    private int height = 0;

    private native boolean nativeInit(Surface surface, int texWidth, int texHeight, int zoomMode);

    private native void nativeRelease();

    private native void nativeUpdateRecord(int textureId, int texWidth, int texHeight, long timestamp);

    private native void nativeUpdateRecord(int textureId, long timestamp);

    public native int nativeHeight();

    public native int nativeWidth();

    public void updateRecord(int texId, long timestamp) throws Exception {
        nativeUpdateRecord(texId, timestamp);
    }

    public void updateRecord(int texId, int texWidth, int texHeight, long timestamp) throws Exception {
        nativeUpdateRecord(texId, texWidth, texHeight, timestamp);
    }

    RecordNative(Surface surface, int texWidth, int texHeight, int zoomMode) throws Exception {
        if (nativeInit(surface, texWidth, texHeight, zoomMode)) {
        } else {
            throw new Exception("RecordNative init failed");
        }
    }

    public void release() {
        nativeRelease();
    }
}
