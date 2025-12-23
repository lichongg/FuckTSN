package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.AMapPara;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PolygonOptionsCreator implements Parcelable.Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions createFromParcel(Parcel parcel) {
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z5 = parcel.readByte() == 1;
        LatLng[] latLngArr = new LatLng[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            latLngArr[i6] = (LatLng) arrayList.get(i6);
        }
        polygonOptions.add(latLngArr);
        polygonOptions.strokeWidth(readFloat);
        polygonOptions.strokeColor(readInt);
        polygonOptions.fillColor(readInt2);
        polygonOptions.zIndex(readFloat2);
        polygonOptions.visible(z5);
        polygonOptions.f8983a = parcel.readString();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, BaseHoleOptions.class.getClassLoader());
        polygonOptions.addHoles(arrayList2);
        polygonOptions.lineJoinType(AMapPara.LineJoinType.valueOf(parcel.readInt()));
        polygonOptions.usePolylineStroke(parcel.readByte() == 1);
        return polygonOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions[] newArray(int i6) {
        return new PolygonOptions[i6];
    }
}
