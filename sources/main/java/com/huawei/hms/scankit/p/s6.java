package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s6 implements Parcelable {
    public static final Parcelable.Creator<s6> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f34793a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f34794b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34795c;

    /* renamed from: d, reason: collision with root package name */
    private u6[] f34796d;

    /* renamed from: e, reason: collision with root package name */
    private BarcodeFormat f34797e;

    /* renamed from: f, reason: collision with root package name */
    private final long f34798f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34799g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f34800h;

    /* renamed from: i, reason: collision with root package name */
    private final float f34801i;

    /* renamed from: j, reason: collision with root package name */
    private int f34802j;

    /* renamed from: k, reason: collision with root package name */
    private List<Rect> f34803k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f34804l;

    /* renamed from: m, reason: collision with root package name */
    private int f34805m;

    /* renamed from: n, reason: collision with root package name */
    private List<Rect> f34806n;

    /* renamed from: o, reason: collision with root package name */
    private long f34807o;

    /* renamed from: p, reason: collision with root package name */
    private long f34808p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f34809q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f34810r;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Parcelable.Creator<s6> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s6 createFromParcel(Parcel parcel) {
            return new s6(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s6[] newArray(int i6) {
            return new s6[i6];
        }

        a() {
        }
    }

    public s6(float f6) {
        this.f34799g = false;
        this.f34809q = false;
        this.f34810r = false;
        this.f34801i = f6;
        this.f34793a = null;
        this.f34794b = new byte[0];
        this.f34795c = 0;
        this.f34796d = new u6[0];
        this.f34797e = BarcodeFormat.NONE;
        this.f34798f = 0L;
        this.f34800h = false;
        this.f34802j = 0;
        this.f34804l = false;
        this.f34805m = 0;
        this.f34803k = new ArrayList();
        this.f34806n = new ArrayList();
    }

    public void a(float f6) {
        if (f6 < 20.0f) {
            this.f34802j = 0;
            return;
        }
        if (f6 < 50.0f) {
            this.f34802j = 2;
            return;
        }
        if (f6 < 90.0f) {
            this.f34802j = 1;
            return;
        }
        if (f6 < 140.0f) {
            this.f34802j = 0;
        } else if (f6 < 190.0f) {
            this.f34802j = -1;
        } else if (f6 <= 255.0f) {
            this.f34802j = -2;
        }
    }

    public void b(float f6) {
        if (f6 < 50.0f) {
            this.f34805m = 2;
            return;
        }
        if (f6 < 90.0f) {
            this.f34805m = 1;
            return;
        }
        if (f6 < 140.0f) {
            this.f34805m = 0;
        } else if (f6 < 190.0f) {
            this.f34805m = -1;
        } else if (f6 <= 255.0f) {
            this.f34805m = -2;
        }
    }

    public void c(boolean z5) {
        this.f34799g = z5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BarcodeFormat c() {
        return this.f34797e;
    }

    public List<Rect> d() {
        return this.f34803k;
    }

    public long e() {
        return this.f34807o;
    }

    public int f() {
        return this.f34802j;
    }

    public List<Rect> g() {
        return this.f34806n;
    }

    public int h() {
        return this.f34805m;
    }

    public byte[] i() {
        return this.f34794b;
    }

    public u6[] j() {
        return this.f34796d;
    }

    public String k() {
        return this.f34793a;
    }

    public float l() {
        return this.f34801i;
    }

    public boolean m() {
        return this.f34809q;
    }

    public boolean n() {
        return this.f34804l;
    }

    public boolean o() {
        return this.f34810r;
    }

    public boolean p() {
        return this.f34799g;
    }

    public String toString() {
        return this.f34793a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f34793a);
        parcel.writeByteArray(this.f34794b);
        parcel.writeInt(this.f34795c);
        parcel.writeTypedArray(this.f34796d, i6);
        parcel.writeParcelable(this.f34797e, i6);
        parcel.writeLong(this.f34798f);
        parcel.writeInt(this.f34799g ? 1 : 0);
        parcel.writeInt(this.f34800h ? 1 : 0);
        parcel.writeFloat(this.f34801i);
        parcel.writeInt(this.f34802j);
        parcel.writeList(this.f34803k);
        parcel.writeLong(this.f34807o);
        parcel.writeLong(this.f34808p);
        parcel.writeInt(this.f34809q ? 1 : 0);
    }

    public void b(i2 i2Var) {
        int d6 = (int) i2Var.d();
        int e6 = (int) i2Var.e();
        this.f34806n.add(new Rect(d6, e6, ((int) i2Var.f()) + d6, ((int) i2Var.c()) + e6));
    }

    public void a(i2 i2Var) {
        int d6 = (int) i2Var.d();
        int e6 = (int) i2Var.e();
        this.f34803k.add(new Rect(d6, e6, ((int) i2Var.f()) + d6, ((int) i2Var.c()) + e6));
    }

    public void b(boolean z5) {
        this.f34804l = z5;
    }

    public void a(int i6) {
        this.f34805m = i6;
    }

    public void b(long j6) {
        this.f34807o = j6;
    }

    public void a(u6[] u6VarArr) {
        u6[] u6VarArr2 = this.f34796d;
        if (u6VarArr2 == null) {
            this.f34796d = u6VarArr;
            return;
        }
        if (u6VarArr == null || u6VarArr.length <= 0) {
            return;
        }
        u6[] u6VarArr3 = new u6[u6VarArr2.length + u6VarArr.length];
        System.arraycopy(u6VarArr2, 0, u6VarArr3, 0, u6VarArr2.length);
        System.arraycopy(u6VarArr, 0, u6VarArr3, u6VarArr2.length, u6VarArr.length);
        this.f34796d = u6VarArr3;
    }

    public long b() {
        return this.f34808p;
    }

    public void b(u6[] u6VarArr) {
        this.f34796d = u6VarArr;
    }

    public s6(float f6, boolean z5) {
        this.f34799g = false;
        this.f34809q = false;
        this.f34810r = false;
        this.f34801i = f6;
        this.f34793a = null;
        this.f34794b = new byte[0];
        this.f34795c = 0;
        this.f34796d = new u6[0];
        this.f34797e = BarcodeFormat.NONE;
        this.f34798f = 0L;
        this.f34800h = false;
        this.f34802j = 0;
        this.f34804l = false;
        this.f34805m = 0;
        this.f34810r = z5;
        this.f34803k = new ArrayList();
        this.f34806n = new ArrayList();
    }

    public void a(long j6) {
        this.f34808p = j6;
    }

    public void a(boolean z5) {
        this.f34809q = z5;
    }

    public void a() {
        this.f34796d = new u6[0];
    }

    public s6(String str, byte[] bArr, u6[] u6VarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, u6VarArr, barcodeFormat, System.currentTimeMillis());
    }

    public s6(String str, byte[] bArr, u6[] u6VarArr, BarcodeFormat barcodeFormat, long j6) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, u6VarArr, barcodeFormat, j6);
    }

    public s6(String str, byte[] bArr, int i6, u6[] u6VarArr, BarcodeFormat barcodeFormat, long j6) {
        this.f34799g = false;
        this.f34809q = false;
        this.f34810r = false;
        this.f34793a = str;
        this.f34794b = bArr;
        this.f34795c = i6;
        this.f34796d = u6VarArr;
        this.f34797e = barcodeFormat;
        this.f34798f = j6;
        this.f34801i = 1.0f;
        this.f34800h = false;
    }

    protected s6(Parcel parcel) {
        this.f34799g = false;
        this.f34809q = false;
        this.f34810r = false;
        this.f34793a = parcel.readString();
        this.f34794b = parcel.createByteArray();
        this.f34795c = parcel.readInt();
        this.f34796d = (u6[]) parcel.createTypedArray(u6.CREATOR);
        this.f34797e = (BarcodeFormat) parcel.readParcelable(s6.class.getClassLoader());
        this.f34798f = parcel.readLong();
        this.f34799g = parcel.readInt() == 1;
        this.f34800h = parcel.readInt() == 1;
        this.f34801i = parcel.readFloat();
        this.f34802j = parcel.readInt();
        if (this.f34803k == null) {
            this.f34803k = new ArrayList();
        }
        parcel.readList(this.f34803k, s6.class.getClassLoader());
        this.f34807o = parcel.readLong();
        this.f34808p = parcel.readLong();
        this.f34809q = parcel.readInt() == 1;
    }
}
