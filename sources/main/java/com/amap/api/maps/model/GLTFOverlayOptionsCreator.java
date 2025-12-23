package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLTFOverlayOptionsCreator implements Parcelable.Creator<GLTFOverlayOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions createFromParcel(Parcel parcel) {
        LatLng latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        double readDouble = parcel.readDouble();
        double readDouble2 = parcel.readDouble();
        double readDouble3 = parcel.readDouble();
        GLTFOverlayOptions gLTFOverlayOptions = new GLTFOverlayOptions(latLng, parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readArrayList(GLTFResourceIterm.class.getClassLoader()));
        gLTFOverlayOptions.rotationDegree(readDouble2, readDouble3, readDouble);
        return gLTFOverlayOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions[] newArray(int i6) {
        return new GLTFOverlayOptions[0];
    }
}
