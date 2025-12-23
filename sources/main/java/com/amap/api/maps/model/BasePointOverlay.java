package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class BasePointOverlay extends BaseOverlay {
    public abstract void destroy();

    public abstract String getId();

    public abstract Object getObject();

    public abstract LatLng getPosition();

    public abstract float getRotateAngle();

    public abstract String getSnippet();

    public abstract String getTitle();

    public abstract boolean isInfoWindowEnable();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setAnimation(Animation animation);

    public abstract void setGeoPoint(IPoint iPoint);

    public abstract void setObject(Object obj);

    public abstract void setPosition(LatLng latLng);

    public abstract void setRotateAngle(float f6);

    public abstract void setSnippet(String str);

    public abstract void setTitle(String str);

    public abstract void setVisible(boolean z5);

    public abstract void showInfoWindow();

    public abstract boolean startAnimation();

    public BasePointOverlay(String str) {
        super(str);
    }
}
