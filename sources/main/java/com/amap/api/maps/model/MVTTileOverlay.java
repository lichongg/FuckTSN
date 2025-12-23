package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class MVTTileOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private MVTTileOverlayOptions mMVTTileOverlayOptions;

    public final float getZIndex() {
        return this.mMVTTileOverlayOptions.getZIndex();
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    public final void setVisible(boolean z5) {
        this.mMVTTileOverlayOptions.setVisible(z5);
        updateOption();
    }

    public final void setZIndex(float f6) {
        this.mMVTTileOverlayOptions.setZIndex(f6);
        updateOption();
    }

    protected final void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mMVTTileOverlayOptions);
        } catch (Throwable unused) {
        }
    }

    public final boolean visible() {
        return this.mMVTTileOverlayOptions.visible();
    }

    public MVTTileOverlay(IGlOverlayLayer iGlOverlayLayer, MVTTileOverlayOptions mVTTileOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mMVTTileOverlayOptions = mVTTileOverlayOptions;
        if (mVTTileOverlayOptions != null) {
            mVTTileOverlayOptions.getTileProviderInner().init(iGlOverlayLayer, str);
        }
    }
}
