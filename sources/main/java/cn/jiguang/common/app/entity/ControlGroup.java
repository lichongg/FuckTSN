package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public class ControlGroup implements Parcelable {
    public static final Parcelable.Creator<ControlGroup> CREATOR = new Parcelable.Creator<ControlGroup>() { // from class: cn.jiguang.common.app.entity.ControlGroup.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlGroup createFromParcel(Parcel parcel) {
            return new ControlGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlGroup[] newArray(int i6) {
            return new ControlGroup[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f2815a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2817c;

    protected ControlGroup(Parcel parcel) {
        this.f2815a = parcel.readInt();
        this.f2816b = parcel.readString();
        this.f2817c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ControlGroup(String str) {
        String[] split = str.split(":");
        this.f2815a = Integer.parseInt(split[0]);
        this.f2816b = split[1];
        this.f2817c = split[2];
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%d:%s:%s", Integer.valueOf(this.f2815a), this.f2816b, this.f2817c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f2815a);
        parcel.writeString(this.f2816b);
        parcel.writeString(this.f2817c);
    }
}
