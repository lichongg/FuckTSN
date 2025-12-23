package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() { // from class: com.amap.api.services.route.TimeInfo.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfo[] newArray(int i6) {
            return null;
        }

        private static TimeInfo a(Parcel parcel) {
            return new TimeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfo createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private long f9782a;

    /* renamed from: b, reason: collision with root package name */
    private List<TimeInfosElement> f9783b;

    public TimeInfo(Parcel parcel) {
        this.f9783b = new ArrayList();
        this.f9782a = parcel.readInt();
        this.f9783b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TimeInfosElement> getElements() {
        return this.f9783b;
    }

    public long getStartTime() {
        return this.f9782a;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.f9783b = list;
    }

    public void setStartTime(long j6) {
        this.f9782a = j6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f9782a);
        parcel.writeTypedList(this.f9783b);
    }

    public TimeInfo() {
        this.f9783b = new ArrayList();
    }
}
