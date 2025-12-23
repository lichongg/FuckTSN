package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class HeatMapLayer extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private HeatMapLayerOptions options;

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof HeatMapLayer)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((HeatMapLayer) obj).getId().equals(getId());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public float getZIndex() {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                return heatMapLayerOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public boolean isVisible() {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                return heatMapLayerOptions.isVisible();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public HeatMapItem getHeatMapItem(LatLng latLng) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer == null) {
                return null;
            }
            Object nativeProperties = iGlOverlayLayer.getNativeProperties(this.overlayName, "getHeatMapItem", new Object[]{latLng});
            if (nativeProperties instanceof HeatMapItem) {
                return (HeatMapItem) nativeProperties;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public HeatMapLayerOptions getOptions() {
        try {
            return this.options;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void setOptions(HeatMapLayerOptions heatMapLayerOptions) {
        try {
            this.options = heatMapLayerOptions;
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                heatMapLayerOptions.visible(z5);
                a();
            }
        } catch (Throwable unused) {
        }
    }

    public void setZIndex(float f6) {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                heatMapLayerOptions.zIndex(f6);
                a();
            }
        } catch (Throwable unused) {
        }
    }

    public HeatMapLayer(IGlOverlayLayer iGlOverlayLayer, HeatMapLayerOptions heatMapLayerOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = heatMapLayerOptions;
        a();
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable unused) {
            return 0;
        }
    }
}
