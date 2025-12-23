package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class GLOverlay {
    protected int mCode;
    protected int mEngineID;
    protected IAMapDelegate mGLMapView;
    protected boolean isNightStyle = false;
    boolean mIsInBundle = false;
    protected long mNativeInstance = 0;
    protected int mItemPriority = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum EAMapOverlayTpye {
        AMAPOVERLAY_ARROW(4),
        AMAPOVERLAY_VECTOR(5),
        AMAPROUTE_OVERLAY(16);

        private int id;

        public final int getId() {
            return this.id;
        }

        EAMapOverlayTpye(int i6) {
            this.id = i6;
        }
    }

    private static native int nativeGetCount(long j6);

    private static native int nativeGetOverlayPriority(long j6);

    private static native int nativeGetSubType(long j6);

    private static native int nativeGetType(long j6);

    private static native boolean nativeIsClickable(long j6);

    private static native boolean nativeIsVisible(long j6);

    private static native void nativeRemoveAll(long j6);

    private static native void nativeRemoveItem(long j6, int i6);

    private static native void nativeSetClickable(long j6, boolean z5);

    private static native void nativeSetMaxDisplayLevel(long j6, float f6);

    private static native void nativeSetMinDisplayLevel(long j6, float f6);

    private static native void nativeSetOverlayOnTop(long j6, boolean z5);

    private static native void nativeSetOverlayPriority(long j6, int i6);

    private static native void nativeSetOverlayPriorityOnly(long j6, int i6);

    protected static native void nativeSetVisible(long j6, boolean z5);

    public int getCode() {
        return this.mCode;
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public int getSize() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return 0;
        }
        return nativeGetCount(j6);
    }

    public int getSubType() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return -1;
        }
        return nativeGetSubType(j6);
    }

    public int getType() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return -1;
        }
        return nativeGetType(j6);
    }

    public boolean isClickable() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return false;
        }
        return nativeIsClickable(j6);
    }

    public boolean isVisible() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return false;
        }
        return nativeIsVisible(j6);
    }

    void releaseInstance() {
        if (this.mNativeInstance != 0) {
            this.mNativeInstance = 0L;
        }
    }

    public void removeAll() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeRemoveAll(j6);
    }

    public void removeItem(int i6) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeRemoveItem(j6, i6);
    }

    public void setClickable(boolean z5) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetClickable(j6, z5);
    }

    public void setMaxDisplayLevel(float f6) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, f6);
    }

    public void setMinDisplayLevel(float f6) {
        nativeSetMinDisplayLevel(this.mNativeInstance, f6);
    }

    public void setOverlayItemPriority(int i6) {
        this.mItemPriority = i6;
    }

    public void setOverlayOnTop(boolean z5) {
        nativeSetOverlayOnTop(this.mNativeInstance, z5);
    }

    public void setOverlayPriority(int i6) {
        GLOverlayBundle overlayBundle;
        nativeSetOverlayPriority(this.mNativeInstance, i6);
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null || (overlayBundle = this.mGLMapView.getGLMapEngine().getOverlayBundle(this.mEngineID)) == null) {
            return;
        }
        overlayBundle.sortOverlay();
    }

    public void setOverlayPriorityOnly(int i6) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetOverlayPriorityOnly(j6, i6);
    }

    public void setVisible(boolean z5) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetVisible(j6, z5);
    }

    public void useNightStyle(boolean z5) {
        this.isNightStyle = z5;
    }

    public GLOverlay(int i6, IAMapDelegate iAMapDelegate, int i7) {
        this.mEngineID = i6;
        this.mGLMapView = iAMapDelegate;
        this.mCode = i7;
    }

    public void clearFocus() {
    }
}
