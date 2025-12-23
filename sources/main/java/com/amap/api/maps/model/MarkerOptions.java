package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public final class MarkerOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f8981a;
    private LatLng gpsLatLng;
    private boolean isBelowMaskLayer;
    private LatLng latLng;
    private float rotate;
    private int screenX;
    private int screenY;
    private String snippet;
    private String title;
    private float anchorU = 0.5f;
    private float anchorV = 1.0f;
    private float zIndex = 0.0f;
    private boolean isDraggable = false;
    private boolean isVisible = true;
    private float altitude = 0.0f;

    @JBindingExclude
    private boolean perspective = false;
    private int offsetX = 0;
    private int offsetY = 0;
    private List<BitmapDescriptor> bitmapDescriptors = new ArrayList();
    private int period = 20;
    private boolean isGps = false;
    private boolean isFlat = false;
    private boolean isRotatingMode = false;
    private float angleOffset = 0.0f;
    private boolean isViewMode = false;
    private float alpha = 1.0f;
    private boolean autoOverturn = false;
    private boolean infoWindowEnabled = true;
    private int dispLevel = 5;
    private MarkerUpdateFlags updateFlags = new MarkerUpdateFlags();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final MarkerOptions period(int i6) {
        if (i6 <= 1) {
            this.period = 1;
            return this;
        }
        this.period = i6;
        return this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    protected static class MarkerUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean latlngUpdate = false;
        protected boolean gpsLatLngUpdate = false;
        protected boolean bitmapDescriptorsUpdate = false;

        protected MarkerUpdateFlags() {
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.latlngUpdate = false;
            this.gpsLatLngUpdate = false;
            this.bitmapDescriptorsUpdate = false;
        }
    }

    private void a() {
        if (this.bitmapDescriptors == null) {
            try {
                this.bitmapDescriptors = new ArrayList();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b() {
        LatLng latLng;
        try {
            if (!this.isGps || (latLng = this.latLng) == null) {
                return;
            }
            double[] a6 = com.autonavi.util.a.a(latLng.longitude, latLng.latitude);
            this.gpsLatLng = new LatLng(a6[1], a6[0]);
            this.updateFlags.gpsLatLngUpdate = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final MarkerOptions alpha(float f6) {
        this.alpha = f6;
        return this;
    }

    public final MarkerOptions altitude(float f6) {
        this.altitude = f6;
        return this;
    }

    public final MarkerOptions anchor(float f6, float f7) {
        this.anchorU = f6;
        this.anchorV = f7;
        return this;
    }

    protected final MarkerOptions angleOffset(float f6) {
        this.angleOffset = f6;
        return this;
    }

    public final MarkerOptions autoOverturnInfoWindow(boolean z5) {
        this.autoOverturn = z5;
        return this;
    }

    public final MarkerOptions belowMaskLayer(boolean z5) {
        this.isBelowMaskLayer = z5;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final MarkerOptions m54clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.latLng = this.latLng;
        markerOptions.gpsLatLng = this.gpsLatLng;
        markerOptions.title = this.title;
        markerOptions.snippet = this.snippet;
        markerOptions.anchorU = this.anchorU;
        markerOptions.anchorV = this.anchorV;
        markerOptions.zIndex = this.zIndex;
        markerOptions.isDraggable = this.isDraggable;
        markerOptions.isVisible = this.isVisible;
        markerOptions.f8981a = this.f8981a;
        markerOptions.perspective = this.perspective;
        markerOptions.offsetX = this.offsetX;
        markerOptions.offsetY = this.offsetY;
        markerOptions.bitmapDescriptors = this.bitmapDescriptors;
        markerOptions.period = this.period;
        markerOptions.isGps = this.isGps;
        markerOptions.isFlat = this.isFlat;
        markerOptions.isRotatingMode = this.isRotatingMode;
        markerOptions.angleOffset = this.angleOffset;
        markerOptions.screenX = this.screenX;
        markerOptions.screenY = this.screenY;
        markerOptions.isViewMode = this.isViewMode;
        markerOptions.alpha = this.alpha;
        markerOptions.autoOverturn = this.autoOverturn;
        markerOptions.infoWindowEnabled = this.infoWindowEnabled;
        markerOptions.dispLevel = this.dispLevel;
        markerOptions.rotate = this.rotate;
        markerOptions.isBelowMaskLayer = this.isBelowMaskLayer;
        markerOptions.updateFlags = this.updateFlags;
        markerOptions.altitude = this.altitude;
        return markerOptions;
    }

    public final MarkerOptions displayLevel(int i6) {
        this.dispLevel = i6;
        return this;
    }

    public final MarkerOptions draggable(boolean z5) {
        this.isDraggable = z5;
        return this;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getAltitude() {
        return this.altitude;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getAngleOffset() {
        return this.angleOffset;
    }

    public final int getDisplayLevel() {
        return this.dispLevel;
    }

    public final BitmapDescriptor getIcon() {
        List<BitmapDescriptor> list = this.bitmapDescriptors;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.bitmapDescriptors.get(0);
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        return (ArrayList) this.bitmapDescriptors;
    }

    public final int getInfoWindowOffsetX() {
        return this.offsetX;
    }

    public final int getInfoWindowOffsetY() {
        return this.offsetY;
    }

    public final int getPeriod() {
        return this.period;
    }

    public final LatLng getPosition() {
        return this.latLng;
    }

    public final float getRotateAngle() {
        return this.rotate;
    }

    protected final int getScreenX() {
        return this.screenX;
    }

    protected final int getScreenY() {
        return this.screenY;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final MarkerUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final MarkerOptions infoWindowEnable(boolean z5) {
        this.infoWindowEnabled = z5;
        return this;
    }

    public final boolean isBelowMaskLayer() {
        return this.isBelowMaskLayer;
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public final boolean isFlat() {
        return this.isFlat;
    }

    public final boolean isGps() {
        return this.isGps;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return this.autoOverturn;
    }

    public final boolean isInfoWindowEnable() {
        return this.infoWindowEnabled;
    }

    public final boolean isPerspective() {
        return this.perspective;
    }

    public final boolean isRotatingMode() {
        return this.isRotatingMode;
    }

    protected final boolean isViewMode() {
        return this.isViewMode;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final MarkerOptions perspective(boolean z5) {
        this.perspective = z5;
        return this;
    }

    public final MarkerOptions position(LatLng latLng) {
        this.latLng = latLng;
        this.isViewMode = false;
        b();
        this.updateFlags.latlngUpdate = true;
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final MarkerOptions rotateAngle(float f6) {
        this.rotate = f6;
        return this;
    }

    public final MarkerOptions rotatingIcons(ArrayList<BitmapDescriptor> arrayList, float f6) {
        if (arrayList != null && arrayList.size() > 0) {
            this.bitmapDescriptors = arrayList;
            if (f6 != 0.0f) {
                this.angleOffset = f6;
            } else {
                this.angleOffset = 360.0f / arrayList.size();
            }
            this.isRotatingMode = true;
            this.updateFlags.bitmapDescriptorsUpdate = true;
        }
        return this;
    }

    public final MarkerOptions setFlat(boolean z5) {
        this.isFlat = z5;
        return this;
    }

    public final MarkerOptions setGps(boolean z5) {
        this.isGps = z5;
        b();
        return this;
    }

    public final MarkerOptions setInfoWindowOffset(int i6, int i7) {
        this.offsetX = i6;
        this.offsetY = i7;
        return this;
    }

    protected final MarkerOptions setRotatingMode(boolean z5) {
        this.isRotatingMode = z5;
        return this;
    }

    protected final void setScreenPosition(int i6, int i7) {
        this.screenX = i6;
        this.screenY = i7;
        this.isViewMode = true;
    }

    public final MarkerOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.title = str;
        return this;
    }

    public final MarkerOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.latLng, i6);
        parcel.writeString(this.title);
        parcel.writeString(this.snippet);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeBooleanArray(new boolean[]{this.isVisible, this.isDraggable, this.isGps, this.isFlat, this.autoOverturn, this.infoWindowEnabled, this.isBelowMaskLayer, this.isRotatingMode});
        parcel.writeString(this.f8981a);
        parcel.writeInt(this.period);
        parcel.writeList(this.bitmapDescriptors);
        parcel.writeFloat(this.zIndex);
        parcel.writeFloat(this.alpha);
        parcel.writeInt(this.dispLevel);
        parcel.writeFloat(this.rotate);
        parcel.writeFloat(this.angleOffset);
        parcel.writeInt(this.screenX);
        parcel.writeInt(this.screenY);
        parcel.writeFloat(this.altitude);
        List<BitmapDescriptor> list = this.bitmapDescriptors;
        if (list == null || list.size() == 0) {
            return;
        }
        parcel.writeParcelable(this.bitmapDescriptors.get(0), i6);
    }

    public final MarkerOptions zIndex(float f6) {
        if (this.zIndex != f6) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f6;
        return this;
    }

    public MarkerOptions() {
        this.type = "MarkerOptions";
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            a();
            this.bitmapDescriptors.clear();
            this.bitmapDescriptors.add(bitmapDescriptor);
            this.isRotatingMode = false;
            this.updateFlags.bitmapDescriptorsUpdate = true;
            return this;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }
}
