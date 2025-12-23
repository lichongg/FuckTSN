package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions createFromParcel(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle readBundle = parcel.readBundle();
        circleOptions.center(new LatLng(readBundle.getDouble(d.C), readBundle.getDouble(d.D)));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex(parcel.readFloat());
        circleOptions.visible(parcel.readByte() == 1);
        circleOptions.f8964a = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, BaseHoleOptions.class.getClassLoader());
        circleOptions.addHoles(arrayList);
        circleOptions.setStrokeDottedLineType(parcel.readInt());
        circleOptions.usePolylineStroke(parcel.readByte() == 1);
        return circleOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions[] newArray(int i6) {
        return new CircleOptions[i6];
    }
}
