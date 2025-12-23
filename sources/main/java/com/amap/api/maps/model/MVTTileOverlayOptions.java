package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class MVTTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<MVTTileOverlayOptions> CREATOR = new Parcelable.Creator<MVTTileOverlayOptions>() { // from class: com.amap.api.maps.model.MVTTileOverlayOptions.1
        private static MVTTileOverlayOptions a(Parcel parcel) {
            TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(parcel.readString(), parcel.readString(), parcel.readString());
            if (tileProvider != null) {
                mVTTileOverlayOptions.setTileProvider(tileProvider);
            }
            return mVTTileOverlayOptions;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions[] newArray(int i6) {
            return a(i6);
        }

        private static MVTTileOverlayOptions[] a(int i6) {
            return new MVTTileOverlayOptions[i6];
        }
    };

    @JBindingInclude
    private String layerId;
    private TileProvider tileProvider;

    @JBindingInclude
    private TileProviderInner tileProviderInner;

    @JBindingInclude
    private boolean visible;

    @JBindingInclude
    private float zIndex;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private String id;
        private String key;
        private String url;
        private float zIndex = 0.0f;
        private boolean visible = true;

        public MVTTileOverlayOptions build() {
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(this.url, this.key, this.id);
            mVTTileOverlayOptions.setZIndex(this.zIndex);
            mVTTileOverlayOptions.setVisible(this.visible);
            return mVTTileOverlayOptions;
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder visible(boolean z5) {
            this.visible = z5;
            return this;
        }

        public Builder zIndex(float f6) {
            this.zIndex = f6;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileProviderInner getTileProviderInner() {
        return this.tileProviderInner;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public void setTileProvider(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    public void setVisible(boolean z5) {
        this.visible = z5;
    }

    public void setZIndex(float f6) {
        this.zIndex = f6;
    }

    public boolean visible() {
        return this.visible;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeValue(this.tileProviderInner);
    }

    public MVTTileOverlayOptions(String str, String str2, String str3) {
        this.type = "MVTTileOverlayOptions";
        MVTTileProvider mVTTileProvider = new MVTTileProvider(str, str2, str3);
        this.tileProvider = mVTTileProvider;
        this.tileProviderInner = new TileProviderInner(mVTTileProvider);
        this.layerId = str3;
    }
}
