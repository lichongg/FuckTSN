package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudItemDetail extends CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = new Parcelable.Creator<CloudItemDetail>() { // from class: com.amap.api.services.cloud.CloudItemDetail.1
        private static CloudItemDetail a(Parcel parcel) {
            return new CloudItemDetail(parcel);
        }

        private static CloudItemDetail[] a(int i6) {
            return new CloudItemDetail[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItemDetail createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItemDetail[] newArray(int i6) {
            return a(i6);
        }
    };

    public CloudItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected CloudItemDetail(Parcel parcel) {
        super(parcel);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
    }
}
