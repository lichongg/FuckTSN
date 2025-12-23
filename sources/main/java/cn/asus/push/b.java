package cn.asus.push;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\Downloads\app\classes2.dex */
final class b implements Parcelable.Creator<DataBuffer> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataBuffer createFromParcel(Parcel parcel) {
        return new DataBuffer(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DataBuffer[] newArray(int i6) {
        return new DataBuffer[i6];
    }

    b() {
    }
}
