package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TextOptionsCreator implements Parcelable.Creator<TextOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TextOptions createFromParcel(Parcel parcel) {
        TextOptions textOptions = new TextOptions();
        textOptions.f8985a = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        textOptions.position(new LatLng(readBundle.getDouble(d.C), readBundle.getDouble(d.D)));
        textOptions.text(parcel.readString());
        textOptions.typeface(Typeface.defaultFromStyle(parcel.readInt()));
        textOptions.rotate(parcel.readFloat());
        textOptions.align(parcel.readInt(), parcel.readInt());
        textOptions.backgroundColor(parcel.readInt());
        textOptions.fontColor(parcel.readInt());
        textOptions.fontSize(parcel.readInt());
        textOptions.zIndex(parcel.readFloat());
        textOptions.visible(parcel.readByte() == 1);
        try {
            Parcelable parcelable = parcel.readBundle().getParcelable("obj");
            if (parcelable == null) {
                return textOptions;
            }
            textOptions.setObject(parcelable);
            return textOptions;
        } catch (Throwable th) {
            th.printStackTrace();
            return textOptions;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TextOptions[] newArray(int i6) {
        return new TextOptions[i6];
    }
}
