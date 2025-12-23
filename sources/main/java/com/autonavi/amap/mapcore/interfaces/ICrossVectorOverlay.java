package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ICrossVectorOverlay {
    void remove();

    void setAttribute(AVectorCrossAttr aVectorCrossAttr);

    int setData(byte[] bArr);

    void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener);

    void setImageMode(boolean z5);

    void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener);

    void setVisible(boolean z5);
}
