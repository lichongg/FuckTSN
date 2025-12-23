package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class Stat extends ProcFile {
    public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator<Stat>() { // from class: cn.jiguang.common.app.entity.Stat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Stat createFromParcel(Parcel parcel) {
            return new Stat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Stat[] newArray(int i6) {
            return new Stat[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final String[] f2819a;

    private Stat(Parcel parcel) {
        super(parcel);
        this.f2819a = parcel.createStringArray();
    }

    public static Stat a(int i6) {
        return new Stat(String.format(Locale.ENGLISH, "/proc/%d/stat", Integer.valueOf(i6)));
    }

    public String a() {
        return this.f2819a[1].replace("(", "").replace(")", "");
    }

    public char b() {
        return this.f2819a[2].charAt(0);
    }

    public int c() {
        return Integer.parseInt(this.f2819a[7]);
    }

    public long d() {
        return Long.parseLong(this.f2819a[13]);
    }

    public long e() {
        return Long.parseLong(this.f2819a[14]);
    }

    public long f() {
        return Long.parseLong(this.f2819a[15]);
    }

    public long g() {
        return Long.parseLong(this.f2819a[16]);
    }

    public long h() {
        return Long.parseLong(this.f2819a[17]);
    }

    public long i() {
        return Long.parseLong(this.f2819a[19]);
    }

    public long j() {
        return Long.parseLong(this.f2819a[21]);
    }

    public long k() {
        return Long.parseLong(this.f2819a[22]);
    }

    public int l() {
        return Integer.parseInt(this.f2819a[39]);
    }

    public int m() {
        return Integer.parseInt(this.f2819a[40]);
    }

    private Stat(String str) {
        super(str);
        this.f2819a = this.f2818b.split("\\s+");
    }

    @Override // cn.jiguang.common.app.entity.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeStringArray(this.f2819a);
    }
}
