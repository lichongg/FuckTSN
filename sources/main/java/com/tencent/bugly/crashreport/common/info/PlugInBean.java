package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i6) {
            return new PlugInBean[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f39604a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39605b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39606c;

    public PlugInBean(String str, String str2, String str3) {
        this.f39604a = str;
        this.f39605b = str2;
        this.f39606c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f39604a + " plV:" + this.f39605b + " plUUID:" + this.f39606c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f39604a);
        parcel.writeString(this.f39605b);
        parcel.writeString(this.f39606c);
    }

    public PlugInBean(Parcel parcel) {
        this.f39604a = parcel.readString();
        this.f39605b = parcel.readString();
        this.f39606c = parcel.readString();
    }
}
