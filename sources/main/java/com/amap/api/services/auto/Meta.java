package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Meta implements Parcelable {
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() { // from class: com.amap.api.services.auto.Meta.1
        private static Meta a(Parcel parcel) {
            return new Meta(parcel);
        }

        private static Meta[] a(int i6) {
            return new Meta[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta[] newArray(int i6) {
            return a(i6);
        }
    };
    public String listBizType;

    public Meta() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected Meta(Parcel parcel) {
        this.listBizType = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.listBizType);
    }
}
