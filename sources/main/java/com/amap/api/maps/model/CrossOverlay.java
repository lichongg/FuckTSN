package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CrossOverlay {
    public static final int UPDATE_TYPE_DATA = 0;

    /* renamed from: a, reason: collision with root package name */
    ICrossVectorOverlay f8965a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface GenerateCrossImageListener {
        void onGenerateComplete(Bitmap bitmap, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnCrossVectorUpdateListener {
        void onUpdate(int i6, UpdateItem updateItem);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class UpdateItem {
        public int dataUpdateFlag = -1;
    }

    public void remove() {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8965a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.remove();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        try {
            this.f8965a.setAttribute(aVectorCrossAttr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int setData(byte[] bArr) {
        ICrossVectorOverlay iCrossVectorOverlay;
        if (bArr == null || (iCrossVectorOverlay = this.f8965a) == null) {
            return 0;
        }
        try {
            iCrossVectorOverlay.setData(bArr);
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setGenerateCrossImageListener(GenerateCrossImageListener generateCrossImageListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8965a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setGenerateCrossImageListener(generateCrossImageListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setImageMode(boolean z5) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8965a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setImageMode(z5);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setOnCrossVectorUpdateListener(OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8965a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setOnCrossVectorUpdateListener(onCrossVectorUpdateListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setVisible(boolean z5) {
        ICrossVectorOverlay iCrossVectorOverlay = this.f8965a;
        if (iCrossVectorOverlay != null) {
            try {
                iCrossVectorOverlay.setVisible(z5);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public CrossOverlay(CrossOverlayOptions crossOverlayOptions, ICrossVectorOverlay iCrossVectorOverlay) {
        this.f8965a = iCrossVectorOverlay;
    }
}
