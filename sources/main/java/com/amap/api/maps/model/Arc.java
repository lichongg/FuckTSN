package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class Arc extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ArcOptions options;

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Arc)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((Arc) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final int getStrokeColor() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final float getStrokeWidth() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final boolean isVisible() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
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

    public final String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeColor(int i6) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeColor(i6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeWidth(float f6) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeWidth(f6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z5) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.visible(z5);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f6) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.zIndex(f6);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Arc(IGlOverlayLayer iGlOverlayLayer, ArcOptions arcOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = arcOptions;
    }

    public final int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
