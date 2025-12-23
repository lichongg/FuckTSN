package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class Status extends ProcFile {
    public static final Parcelable.Creator<Status> CREATOR = new Parcelable.Creator<Status>() { // from class: cn.jiguang.common.app.entity.Status.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status[] newArray(int i6) {
            return new Status[i6];
        }
    };

    private Status(Parcel parcel) {
        super(parcel);
    }

    public int a() {
        try {
            return Integer.parseInt(a("Uid").split("\\s+")[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static Status a(int i6) {
        return new Status(String.format(Locale.ENGLISH, "/proc/%d/status", Integer.valueOf(i6)));
    }

    private Status(String str) {
        super(str);
    }

    public String a(String str) {
        for (String str2 : this.f2818b.split(com.snail.antifake.deviceid.e.f37542d)) {
            if (str2.startsWith(str + ":")) {
                return str2.split(str + ":")[1].trim();
            }
        }
        return null;
    }
}
