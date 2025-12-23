package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapOptionsCreator implements Parcelable.Creator<AMapOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions createFromParcel(Parcel parcel) {
        AMapOptions aMapOptions = new AMapOptions();
        CameraPosition cameraPosition = (CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader());
        aMapOptions.mapType(parcel.readInt());
        aMapOptions.logoPosition(parcel.readInt());
        aMapOptions.camera(cameraPosition);
        boolean[] createBooleanArray = parcel.createBooleanArray();
        if (createBooleanArray != null && createBooleanArray.length >= 6) {
            aMapOptions.rotateGesturesEnabled(createBooleanArray[0]);
            aMapOptions.scrollGesturesEnabled(createBooleanArray[1]);
            aMapOptions.tiltGesturesEnabled(createBooleanArray[2]);
            aMapOptions.zoomGesturesEnabled(createBooleanArray[3]);
            aMapOptions.zoomControlsEnabled(createBooleanArray[4]);
            aMapOptions.zOrderOnTop(createBooleanArray[5]);
            aMapOptions.compassEnabled(createBooleanArray[6]);
            aMapOptions.scaleControlsEnabled(createBooleanArray[7]);
        }
        return aMapOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions[] newArray(int i6) {
        return new AMapOptions[i6];
    }
}
