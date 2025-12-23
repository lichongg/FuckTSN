package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class UiSettings {
    private final IUiSettings uiSettingsDelegate;

    public final float getLogoMarginRate(int i6) {
        try {
            return this.uiSettingsDelegate.getLogoMarginRate(i6);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int getLogoPosition() {
        try {
            return this.uiSettingsDelegate.getLogoPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getZoomPosition() {
        try {
            return this.uiSettingsDelegate.getZoomPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 2;
        }
    }

    public final boolean isCompassEnabled() {
        try {
            return this.uiSettingsDelegate.isCompassEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isGestureScaleByMapCenter() {
        try {
            return this.uiSettingsDelegate.isGestureScaleByMapCenter();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isIndoorSwitchEnabled() {
        try {
            return this.uiSettingsDelegate.isIndoorSwitchEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    protected final boolean isLogoEnable() {
        try {
            return this.uiSettingsDelegate.isLogoEnable();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.uiSettingsDelegate.isMyLocationButtonEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isRotateGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isRotateGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isScaleControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isScaleControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isScrollGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTiltGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isTiltGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final void setAllGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setAllGesturesEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCompassEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setCompassEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setGestureScaleByMapCenter(boolean z5) {
        try {
            this.uiSettingsDelegate.setGestureScaleByMapCenter(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setIndoorSwitchEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setIndoorSwitchEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoBottomMargin(int i6) {
        try {
            this.uiSettingsDelegate.setLogoBottomMargin(i6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected final void setLogoEnable(boolean z5) {
        try {
            this.uiSettingsDelegate.setLogoEnable(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoLeftMargin(int i6) {
        try {
            this.uiSettingsDelegate.setLogoLeftMargin(i6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoMarginRate(int i6, float f6) {
        try {
            this.uiSettingsDelegate.setLogoMarginRate(i6, f6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoPosition(int i6) {
        try {
            this.uiSettingsDelegate.setLogoPosition(i6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationButtonEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setMyLocationButtonEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setRotateGesturesEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScaleControlsEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setScaleControlsEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScrollGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setScrollGesturesEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTiltGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setTiltGesturesEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomControlsEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setZoomControlsEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomGesturesEnabled(boolean z5) {
        try {
            this.uiSettingsDelegate.setZoomGesturesEnabled(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomInByScreenCenter(boolean z5) {
        try {
            this.uiSettingsDelegate.setZoomInByScreenCenter(z5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomPosition(int i6) {
        try {
            this.uiSettingsDelegate.setZoomPosition(i6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public UiSettings(IUiSettings iUiSettings) {
        this.uiSettingsDelegate = iUiSettings;
    }

    public final void setLogoCenter(int i6, int i7) {
    }
}
