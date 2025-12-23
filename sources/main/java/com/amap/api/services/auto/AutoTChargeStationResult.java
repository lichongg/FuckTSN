package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AutoTChargeStationResult implements Parcelable {
    public static final Parcelable.Creator<AutoTChargeStationResult> CREATOR = new Parcelable.Creator<AutoTChargeStationResult>() { // from class: com.amap.api.services.auto.AutoTChargeStationResult.1
        private static AutoTChargeStationResult a(Parcel parcel) {
            return new AutoTChargeStationResult(parcel);
        }

        private static AutoTChargeStationResult[] a(int i6) {
            return new AutoTChargeStationResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutoTChargeStationResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AutoTChargeStationResult[] newArray(int i6) {
            return a(i6);
        }
    };
    public Classify classify;
    public int code;
    public ListData listData;
    public Lqii lqii;
    public String message;
    public Meta meta;
    public String originJson;

    public AutoTChargeStationResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected AutoTChargeStationResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.classify = (Classify) parcel.readParcelable(Classify.class.getClassLoader());
        this.listData = (ListData) parcel.readParcelable(ListData.class.getClassLoader());
        this.lqii = (Lqii) parcel.readParcelable(Lqii.class.getClassLoader());
        this.meta = (Meta) parcel.readParcelable(Meta.class.getClassLoader());
        this.originJson = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.classify, i6);
        parcel.writeParcelable(this.listData, i6);
        parcel.writeParcelable(this.lqii, i6);
        parcel.writeParcelable(this.meta, i6);
        parcel.writeString(this.originJson);
    }
}
