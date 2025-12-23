package cn.jiguang.common.app.helper;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.jiguang.common.app.entity.Cgroup;
import cn.jiguang.common.app.entity.ProcFile;
import cn.jiguang.common.app.entity.Stat;
import cn.jiguang.common.app.entity.Status;
import java.io.IOException;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public class AndroidProcess implements Parcelable {
    public static final Parcelable.Creator<AndroidProcess> CREATOR = new Parcelable.Creator<AndroidProcess>() { // from class: cn.jiguang.common.app.helper.AndroidProcess.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AndroidProcess createFromParcel(Parcel parcel) {
            return new AndroidProcess(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AndroidProcess[] newArray(int i6) {
            return new AndroidProcess[i6];
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public final String f2876c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2877d;

    public AndroidProcess(int i6) {
        this.f2877d = i6;
        this.f2876c = a(i6);
    }

    private String a(int i6) {
        String str;
        try {
            str = ProcFile.b(String.format(Locale.ENGLISH, "/proc/%d/cmdline", Integer.valueOf(i6))).trim();
        } catch (IOException unused) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Stat.a(i6).a();
        } catch (Exception unused2) {
            throw new IOException(String.format(Locale.ENGLISH, "Error reading /proc/%d/stat", Integer.valueOf(i6)));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected AndroidProcess(Parcel parcel) {
        this.f2876c = parcel.readString();
        this.f2877d = parcel.readInt();
    }

    public String a(String str) {
        return ProcFile.b(String.format(Locale.ENGLISH, "/proc/%d/%s", Integer.valueOf(this.f2877d), str));
    }

    public Cgroup b() {
        return Cgroup.a(this.f2877d);
    }

    public int c() {
        return Integer.parseInt(a("oom_score"));
    }

    public int d() {
        return Integer.parseInt(a("oom_adj"));
    }

    public int e() {
        return Integer.parseInt(a("oom_score_adj"));
    }

    public Stat f() {
        return Stat.a(this.f2877d);
    }

    public Status g() {
        return Status.a(this.f2877d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f2876c);
        parcel.writeInt(this.f2877d);
    }
}
