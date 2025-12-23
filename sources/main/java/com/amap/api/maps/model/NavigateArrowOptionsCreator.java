package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NavigateArrowOptionsCreator implements Parcelable.Creator<NavigateArrowOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NavigateArrowOptions createFromParcel(Parcel parcel) {
        NavigateArrowOptions navigateArrowOptions = new NavigateArrowOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z5 = parcel.readByte() == 1;
        boolean z6 = parcel.readByte() == 1;
        navigateArrowOptions.addAll(arrayList);
        navigateArrowOptions.width(readFloat);
        navigateArrowOptions.topColor(readInt);
        navigateArrowOptions.sideColor(readInt2);
        navigateArrowOptions.zIndex(readFloat2);
        navigateArrowOptions.visible(z5);
        navigateArrowOptions.f8982a = parcel.readString();
        navigateArrowOptions.set3DModel(z6);
        return navigateArrowOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NavigateArrowOptions[] newArray(int i6) {
        return new NavigateArrowOptions[i6];
    }
}
