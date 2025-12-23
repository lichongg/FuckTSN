package com.bxkj.student.v2.common.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PointData implements Parcelable {
    public static final Parcelable.Creator<PointData> CREATOR = new Parcelable.Creator<PointData>() { // from class: com.bxkj.student.v2.common.data.PointData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointData createFromParcel(Parcel source) {
            return new PointData(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointData[] newArray(int size) {
            return new PointData[size];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private double f20640a;

    /* renamed from: c, reason: collision with root package name */
    private long f20641c;

    /* renamed from: e, reason: collision with root package name */
    private int f20642e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f20643f;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f20644h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20645i;

    /* renamed from: l, reason: collision with root package name */
    private int f20646l;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f20647m;

    /* renamed from: o, reason: collision with root package name */
    private double f20648o;

    /* renamed from: s, reason: collision with root package name */
    private float f20649s;

    /* renamed from: t, reason: collision with root package name */
    private long f20650t;

    public PointData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PointData(double a6, double o5, long t5, float s5, boolean i6, int l6, long c6, int e6) {
        this.f20640a = a6;
        this.f20648o = o5;
        this.f20650t = t5;
        this.f20649s = s5;
        this.f20645i = i6;
        this.f20646l = l6;
        this.f20641c = c6;
        this.f20642e = e6;
    }

    public double getA() {
        return this.f20640a;
    }

    public long getC() {
        return this.f20641c;
    }

    public long getE() {
        return this.f20642e;
    }

    public Boolean getF() {
        return this.f20643f;
    }

    public Boolean getH() {
        return this.f20644h;
    }

    public int getL() {
        return this.f20646l;
    }

    public Boolean getM() {
        return this.f20647m;
    }

    public double getO() {
        return this.f20648o;
    }

    public float getS() {
        return this.f20649s;
    }

    public long getT() {
        return this.f20650t;
    }

    public boolean isI() {
        return this.f20645i;
    }

    public PointData setA(double a6) {
        this.f20640a = a6;
        return this;
    }

    public PointData setC(long c6) {
        this.f20641c = c6;
        return this;
    }

    public PointData setE(int e6) {
        this.f20642e = e6;
        return this;
    }

    public PointData setF(Boolean f6) {
        this.f20643f = f6;
        return this;
    }

    public PointData setH(Boolean h6) {
        this.f20644h = h6;
        return this;
    }

    public PointData setI(boolean i6) {
        this.f20645i = i6;
        return this;
    }

    public PointData setL(int l6) {
        this.f20646l = l6;
        return this;
    }

    public PointData setM(Boolean m6) {
        this.f20647m = m6;
        return this;
    }

    public PointData setO(double o5) {
        this.f20648o = o5;
        return this;
    }

    public PointData setS(float s5) {
        this.f20649s = s5;
        return this;
    }

    public PointData setT(long t5) {
        this.f20650t = t5;
        return this;
    }

    public String toString() {
        return "PointData{a=" + this.f20640a + ", o=" + this.f20648o + ", t=" + this.f20650t + ", s=" + this.f20649s + ", i=" + this.f20645i + ", l=" + this.f20646l + ", c=" + this.f20641c + ", e=" + this.f20642e + ", f=" + this.f20643f + ", m=" + this.f20647m + ", h=" + this.f20644h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeDouble(this.f20640a);
        parcel.writeDouble(this.f20648o);
        parcel.writeLong(this.f20650t);
        parcel.writeFloat(this.f20649s);
        parcel.writeByte(this.f20645i ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f20646l);
        parcel.writeLong(this.f20641c);
        parcel.writeInt(this.f20642e);
        parcel.writeValue(this.f20643f);
        parcel.writeValue(this.f20647m);
        parcel.writeValue(this.f20644h);
    }

    public void readFromParcel(Parcel source) {
        boolean z5;
        this.f20640a = source.readDouble();
        this.f20648o = source.readDouble();
        this.f20650t = source.readLong();
        this.f20649s = source.readFloat();
        if (source.readByte() != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f20645i = z5;
        this.f20646l = source.readInt();
        this.f20641c = source.readLong();
        this.f20642e = source.readInt();
        this.f20643f = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.f20647m = (Boolean) source.readValue(Boolean.class.getClassLoader());
        this.f20644h = (Boolean) source.readValue(Boolean.class.getClassLoader());
    }

    protected PointData(Parcel in) {
        this.f20640a = in.readDouble();
        this.f20648o = in.readDouble();
        this.f20650t = in.readLong();
        this.f20649s = in.readFloat();
        this.f20645i = in.readByte() != 0;
        this.f20646l = in.readInt();
        this.f20641c = in.readLong();
        this.f20642e = in.readInt();
        this.f20643f = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.f20647m = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.f20644h = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }
}
