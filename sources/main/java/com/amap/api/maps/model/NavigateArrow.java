package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NavigateArrow extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private NavigateArrowOptions options;

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavigateArrow)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((NavigateArrow) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public List<LatLng> getPoints() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public int getSideColor() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getSideColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getTopColor() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getTopColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getWidth() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public boolean is3DModel() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.is3DModel();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
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

    public void set3DModel(boolean z5) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.set3DModel(z5);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.setPoints(list);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSideColor(int i6) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.sideColor(i6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTopColor(int i6) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.topColor(i6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.visible(z5);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f6) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.width(f6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f6) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.zIndex(f6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NavigateArrow(IGlOverlayLayer iGlOverlayLayer, NavigateArrowOptions navigateArrowOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = navigateArrowOptions;
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
