package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>> {
    private int mEngineID;
    private long mNativeInstance;
    private final List<E> mOverlayList = new ArrayList();
    private SparseArray<GLOverlayTexture> mTextureCaches = new SparseArray<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class GLAmapFocusHits {
        public long mOverlayHashCode = 0;
        public long mHitedIndex = 0;
        public long mHitedTimes = 1000;
    }

    private int getOverlyExType(E e6) {
        return 0;
    }

    private static native void nativeAddGLOverlay(long j6, long j7, long j8);

    private static native void nativeAddGLOverlayEx(long j6, long j7, long j8, int i6);

    private static native void nativeClearAllGLOverlay(long j6, boolean z5);

    private static native boolean nativeOnSingleTapLineOverlay(long j6, int i6, int i7, long[] jArr);

    private static native boolean nativeOnSingleTapPointOverlay(long j6, int i6, int i7, long[] jArr);

    private static native void nativeRemoveGLOverlay(long j6, long j7);

    private static native void nativeRemoveGLOverlayEx(long j6, long j7, int i6);

    private static native void nativeSortAllGLOverlay(long j6);

    public boolean addOverlayTextureItem(int i6, int i7, int i8, int i9) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i6, i7, i8, i9);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i6, gLOverlayTexture);
        }
        return true;
    }

    public long checkSingleTapOnLine(int i6, int i7) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapLineOverlay(this.mNativeInstance, i6, i7, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public long checkSingleTapOnPoint(int i6, int i7) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapPointOverlay(this.mNativeInstance, i6, i7, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    boolean onSingleTapLines(int i6, int i7, int i8) {
        return false;
    }

    boolean onSingleTapPoints(int i6, int i7, int i8) {
        return false;
    }

    public static void intClr2PVRClr(float[] fArr, int i6) {
        fArr[2] = (i6 & 255) / 255.0f;
        fArr[1] = ((i6 >> 8) & 255) / 255.0f;
        fArr[0] = ((i6 >> 16) & 255) / 255.0f;
        fArr[3] = ((i6 >> 24) & 255) / 255.0f;
    }

    public void addOverlay(E e6) {
        if (e6 == null) {
            return;
        }
        nativeAddGLOverlay(this.mNativeInstance, e6.getGLOverlay().getNativeInstatnce(), e6.getGLOverlay().getCode());
        e6.getGLOverlay().mIsInBundle = true;
        synchronized (this.mOverlayList) {
            this.mOverlayList.add(e6);
        }
    }

    public void clearFocus() {
        List<E> list = this.mOverlayList;
        if (list != null) {
            synchronized (list) {
                for (int i6 = 0; i6 < this.mOverlayList.size(); i6++) {
                    try {
                        E e6 = this.mOverlayList.get(i6);
                        if (e6 != null) {
                            e6.clearFocus();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public void clearOverlayTexture() {
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.clear();
        }
    }

    public boolean cotainsOverlay(E e6) {
        boolean contains;
        if (e6 == null) {
            return false;
        }
        synchronized (this.mOverlayList) {
            contains = this.mOverlayList.contains(e6);
        }
        return contains;
    }

    public E getOverlay(int i6) {
        synchronized (this.mOverlayList) {
            if (i6 >= 0) {
                try {
                    if (i6 <= this.mOverlayList.size() - 1) {
                        return this.mOverlayList.get(i6);
                    }
                } finally {
                }
            }
            return null;
        }
    }

    public int getOverlayCount() {
        int size;
        synchronized (this.mOverlayList) {
            size = this.mOverlayList.size();
        }
        return size;
    }

    public GLOverlayTexture getOverlayTextureItem(int i6) {
        GLOverlayTexture gLOverlayTexture;
        synchronized (this.mTextureCaches) {
            gLOverlayTexture = this.mTextureCaches.get(i6);
        }
        return gLOverlayTexture;
    }

    public boolean onSingleTap(int i6, int i7, int i8, int i9) {
        boolean onSingleTapPoints = (i9 & 1) == 1 ? onSingleTapPoints(i6, i7, i8) : false;
        if (onSingleTapPoints) {
            return true;
        }
        if ((i9 & 2) == 2) {
            onSingleTapPoints = onSingleTapLines(i6, i7, i8);
        }
        return onSingleTapPoints;
    }

    public void removeAll(boolean z5) {
        nativeClearAllGLOverlay(this.mNativeInstance, z5);
        synchronized (this.mOverlayList) {
            for (int i6 = 0; i6 < this.mOverlayList.size(); i6++) {
                try {
                    E e6 = this.mOverlayList.get(i6);
                    if (e6 != null) {
                        e6.getGLOverlay().mIsInBundle = false;
                        e6.getGLOverlay().releaseInstance();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.mOverlayList.clear();
        }
    }

    public void removeOverlay(E e6) {
        if (e6 == null) {
            return;
        }
        nativeRemoveGLOverlay(this.mNativeInstance, e6.getGLOverlay().getNativeInstatnce());
        e6.getGLOverlay().mIsInBundle = false;
        synchronized (this.mOverlayList) {
            this.mOverlayList.remove(e6);
        }
    }

    public void sortOverlay() {
        nativeSortAllGLOverlay(this.mNativeInstance);
    }

    public GLOverlayBundle(int i6, IAMapDelegate iAMapDelegate) {
        this.mNativeInstance = 0L;
        this.mEngineID = i6;
        if (iAMapDelegate != null) {
            try {
                this.mNativeInstance = iAMapDelegate.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);
            } catch (Throwable unused) {
            }
        }
    }

    public boolean addOverlayTextureItem(int i6, int i7, float f6, float f7, int i8, int i9) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i6, i7, f6, f7, i8, i9);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i6, gLOverlayTexture);
        }
        return true;
    }

    public void reculateRouteBoard(IAMapDelegate iAMapDelegate) {
    }
}
