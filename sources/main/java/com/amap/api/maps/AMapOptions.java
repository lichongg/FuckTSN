package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_MARGIN_BOTTOM = 2;
    public static final int LOGO_MARGIN_LEFT = 0;
    public static final int LOGO_MARGIN_RIGHT = 1;
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 2;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    private CameraPosition cameraPosition;
    private int mapType = 1;
    private boolean isRotateGesturesEnabled = true;
    private boolean isScrollGesturesEnabled = true;
    private boolean isTiltGesturesEnabled = true;
    private boolean isZoomGesturesEnabled = true;
    private boolean isZoomEnabled = true;
    private boolean isZOrderOnTop = false;
    private boolean isCompassEnabled = false;
    private boolean isScaleControlsEnabled = false;
    private int logoPosition = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.cameraPosition = cameraPosition;
        return this;
    }

    public AMapOptions compassEnabled(boolean z5) {
        this.isCompassEnabled = z5;
        return this;
    }

    public CameraPosition getCamera() {
        return this.cameraPosition;
    }

    public boolean getCompassEnabled() {
        return this.isCompassEnabled;
    }

    public int getLogoPosition() {
        return this.logoPosition;
    }

    public int getMapType() {
        return this.mapType;
    }

    public boolean getRotateGesturesEnabled() {
        return this.isRotateGesturesEnabled;
    }

    public boolean getScaleControlsEnabled() {
        return this.isScaleControlsEnabled;
    }

    public boolean getScrollGesturesEnabled() {
        return this.isScrollGesturesEnabled;
    }

    public boolean getTiltGesturesEnabled() {
        return this.isTiltGesturesEnabled;
    }

    public boolean getZOrderOnTop() {
        return this.isZOrderOnTop;
    }

    public boolean getZoomControlsEnabled() {
        return this.isZoomEnabled;
    }

    public boolean getZoomGesturesEnabled() {
        return this.isZoomGesturesEnabled;
    }

    public AMapOptions logoPosition(int i6) {
        this.logoPosition = i6;
        return this;
    }

    public AMapOptions mapType(int i6) {
        this.mapType = i6;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean z5) {
        this.isRotateGesturesEnabled = z5;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z5) {
        this.isScaleControlsEnabled = z5;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z5) {
        this.isScrollGesturesEnabled = z5;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean z5) {
        this.isTiltGesturesEnabled = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.cameraPosition, i6);
        parcel.writeInt(this.mapType);
        parcel.writeInt(this.logoPosition);
        parcel.writeBooleanArray(new boolean[]{this.isRotateGesturesEnabled, this.isScrollGesturesEnabled, this.isTiltGesturesEnabled, this.isZoomGesturesEnabled, this.isZoomEnabled, this.isZOrderOnTop, this.isCompassEnabled, this.isScaleControlsEnabled});
    }

    public AMapOptions zOrderOnTop(boolean z5) {
        this.isZOrderOnTop = z5;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z5) {
        this.isZoomEnabled = z5;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z5) {
        this.isZoomGesturesEnabled = z5;
        return this;
    }
}
