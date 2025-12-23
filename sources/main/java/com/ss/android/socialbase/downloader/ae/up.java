package com.ss.android.socialbase.downloader.ae;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes6.dex */
public class up implements Parcelable, Comparable {
    public static final Parcelable.Creator<up> CREATOR = new Parcelable.Creator<up>() { // from class: com.ss.android.socialbase.downloader.ae.up.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public up createFromParcel(Parcel parcel) {
            return new up(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public up[] newArray(int i6) {
            return new up[i6];
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private final String f38629j;
    private final String xt;

    public up(String str, String str2) {
        this.f38629j = str;
        this.xt = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            up upVar = (up) obj;
            if (TextUtils.equals(this.f38629j, upVar.f38629j) && TextUtils.equals(this.xt, upVar.xt)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof up)) {
            return 1;
        }
        up upVar = (up) obj;
        if (TextUtils.equals(this.f38629j, upVar.j())) {
            return 0;
        }
        String str = this.f38629j;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(upVar.j());
        if (compareTo > 0) {
            return 1;
        }
        return compareTo < 0 ? -1 : 0;
    }

    public int hashCode() {
        String str = this.f38629j;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.xt;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String j() {
        return this.f38629j;
    }

    public String toString() {
        return "HttpHeader{name='" + this.f38629j + "', value='" + this.xt + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f38629j);
        parcel.writeString(this.xt);
    }

    public String xt() {
        return this.xt;
    }

    protected up(Parcel parcel) {
        this.f38629j = parcel.readString();
        this.xt = parcel.readString();
    }
}
