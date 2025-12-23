package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = new Parcelable.Creator<CloudItem>() { // from class: com.amap.api.services.cloud.CloudItem.1
        private static CloudItem a(Parcel parcel) {
            return new CloudItem(parcel);
        }

        private static CloudItem[] a(int i6) {
            return new CloudItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9160a;

    /* renamed from: b, reason: collision with root package name */
    private int f9161b;

    /* renamed from: c, reason: collision with root package name */
    private String f9162c;

    /* renamed from: d, reason: collision with root package name */
    private String f9163d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f9164e;

    /* renamed from: f, reason: collision with root package name */
    private List<CloudImage> f9165f;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    public CloudItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f9161b = -1;
        this.f9160a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CloudItem)) {
            return false;
        }
        CloudItem cloudItem = (CloudItem) obj;
        String str = this.f9160a;
        if (str == null) {
            if (cloudItem.f9160a != null) {
                return false;
            }
        } else if (!str.equals(cloudItem.f9160a)) {
            return false;
        }
        return true;
    }

    public List<CloudImage> getCloudImage() {
        return this.f9165f;
    }

    public String getCreatetime() {
        return this.f9162c;
    }

    public HashMap<String, String> getCustomfield() {
        return this.f9164e;
    }

    public int getDistance() {
        return this.f9161b;
    }

    public String getID() {
        return this.f9160a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUpdatetime() {
        return this.f9163d;
    }

    public int hashCode() {
        String str = this.f9160a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setCreatetime(String str) {
        this.f9162c = str;
    }

    public void setCustomfield(HashMap<String, String> hashMap) {
        this.f9164e = hashMap;
    }

    public void setDistance(int i6) {
        this.f9161b = i6;
    }

    public void setUpdatetime(String str) {
        this.f9163d = str;
    }

    public void setmCloudImage(List<CloudImage> list) {
        this.f9165f = list;
    }

    public String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9160a);
        parcel.writeInt(this.f9161b);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f9162c);
        parcel.writeString(this.f9163d);
        parcel.writeMap(this.f9164e);
        parcel.writeList(this.f9165f);
    }

    protected CloudItem(Parcel parcel) {
        this.f9161b = -1;
        this.f9160a = parcel.readString();
        this.f9161b = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f9162c = parcel.readString();
        this.f9163d = parcel.readString();
        HashMap<String, String> hashMap = new HashMap<>();
        this.f9164e = hashMap;
        parcel.readMap(hashMap, HashMap.class.getClassLoader());
        List arrayList = new ArrayList();
        this.f9165f = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }
}
