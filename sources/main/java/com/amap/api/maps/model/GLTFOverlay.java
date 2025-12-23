package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLTFOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private GLTFOverlayOptions mOptions;

    private Object a(String str) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                return iGlOverlayLayer.getNativeProperties(this.overlayName, str, null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public int getCurrentAnimationIndex() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions == null) {
            return -1;
        }
        gLTFOverlayOptions.getCurrentAnimationIndex();
        return -1;
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public BitmapDescriptor getInfoWindowView() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getInfoWindowView();
        }
        return null;
    }

    public LatLng getLatlng() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getLatLng();
        }
        return null;
    }

    public GLTFOverlayOptions getOptions() {
        return this.mOptions.m51clone();
    }

    public float getZIndex() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getZIndex();
        }
        return 0.0f;
    }

    public boolean isAnimated() {
        Object a6 = a("isAnimated");
        if (a6 instanceof Boolean) {
            return ((Boolean) a6).booleanValue();
        }
        return false;
    }

    public boolean isClickable() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isClickable();
        }
        return false;
    }

    public boolean isDraggable() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isDraggable();
        }
        return true;
    }

    public boolean isInfoWindowShow() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isInfoWindowShow();
        }
        return false;
    }

    public void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setClickable(boolean z5) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setClickable(z5);
        }
    }

    public void setCurrentAnimationIndex(int i6) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setCurrentAnimationIndex(i6);
            a();
        }
    }

    public void setDraggable(boolean z5) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setDraggable(z5);
        }
    }

    public void setInfoWindowView(BitmapDescriptor bitmapDescriptor) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.infoWindowView(bitmapDescriptor);
            a();
        }
    }

    public void setLatLng(LatLng latLng) {
        try {
            GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
            if (gLTFOverlayOptions != null) {
                gLTFOverlayOptions.latLng(latLng);
                a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setZIndex(float f6) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setZIndex(f6);
            a();
        }
    }

    public void tapClick() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.tapClick();
        }
        try {
            a("tapClick");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public GLTFOverlay(IGlOverlayLayer iGlOverlayLayer, GLTFOverlayOptions gLTFOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mOptions = gLTFOverlayOptions;
    }

    public int hashCode() {
        return super.hashCode();
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mOptions);
        } catch (Throwable unused) {
        }
    }
}
