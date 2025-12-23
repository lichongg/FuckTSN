package com.autonavi.base.ae.gmap.gloverlay;

import android.graphics.Rect;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLCrossVector extends GLOverlay {
    private long mDiceNativeInstance;

    private static native void nativeAddVectorCar(long j6, int i6, int i7, int i8);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAddVectorData(long j6, int[] iArr, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitTextureCallback(long j6, Object obj, boolean z5);

    private static native void nativeSetArrowResId(long j6, boolean z5, int i6);

    private static native void nativeSetBackgroundResId(long j6, int i6);

    private static native void nativeSetCarResId(long j6, int i6);

    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, final byte[] bArr, int i6) {
        if (aVectorCrossAttr == null || bArr == null || i6 == 0) {
            return -1;
        }
        Rect rect = aVectorCrossAttr.stAreaRect;
        final int[] iArr = {rect.left, rect.top, rect.right, rect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode};
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate == null) {
            return 0;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.2
            @Override // java.lang.Runnable
            public void run() {
                GLCrossVector.nativeAddVectorData(GLCrossVector.this.mNativeInstance, iArr, bArr);
            }
        });
        return 0;
    }

    public void initTextureCallback(final CrossVectorOverlay crossVectorOverlay, final boolean z5) {
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.3
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.nativeInitTextureCallback(GLCrossVector.this.mNativeInstance, crossVectorOverlay, z5);
                }
            });
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    void releaseInstance() {
        long j6 = this.mNativeInstance;
        this.mNativeInstance = 0L;
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, j6);
        super.releaseInstance();
    }

    public void setArrowResId(boolean z5, int i6) {
        nativeSetArrowResId(this.mNativeInstance, z5, i6);
    }

    public void setBackgroundResId(int i6) {
        nativeSetBackgroundResId(this.mNativeInstance, i6);
    }

    public void setCarResId(int i6) {
        nativeSetCarResId(this.mNativeInstance, i6);
    }

    public GLCrossVector(final int i6, final IAMapDelegate iAMapDelegate, int i7) {
        super(i6, iAMapDelegate, i7);
        this.mDiceNativeInstance = 0L;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.1
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.this.mNativeInstance = iAMapDelegate.getGLMapEngine().createOverlay(i6, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.getId());
                }
            });
        }
    }
}
