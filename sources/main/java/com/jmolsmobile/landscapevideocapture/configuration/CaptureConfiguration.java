package com.jmolsmobile.landscapevideocapture.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class CaptureConfiguration implements Parcelable {
    public static final Parcelable.Creator<CaptureConfiguration> CREATOR = new a();

    /* renamed from: n, reason: collision with root package name */
    public static final int f35616n = 1048576;

    /* renamed from: o, reason: collision with root package name */
    public static final int f35617o = 1000;

    /* renamed from: p, reason: collision with root package name */
    public static final int f35618p = -1;

    /* renamed from: q, reason: collision with root package name */
    public static final int f35619q = -1;

    /* renamed from: a, reason: collision with root package name */
    private int f35620a;

    /* renamed from: b, reason: collision with root package name */
    private int f35621b;

    /* renamed from: c, reason: collision with root package name */
    private int f35622c;

    /* renamed from: d, reason: collision with root package name */
    private int f35623d;

    /* renamed from: e, reason: collision with root package name */
    private int f35624e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f35625f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f35626g;

    /* renamed from: h, reason: collision with root package name */
    private int f35627h;

    /* renamed from: i, reason: collision with root package name */
    private int f35628i;

    /* renamed from: j, reason: collision with root package name */
    private int f35629j;

    /* renamed from: k, reason: collision with root package name */
    private int f35630k;

    /* renamed from: l, reason: collision with root package name */
    private int f35631l;

    /* renamed from: m, reason: collision with root package name */
    private int f35632m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Parcelable.Creator<CaptureConfiguration> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CaptureConfiguration createFromParcel(Parcel parcel) {
            return new CaptureConfiguration(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CaptureConfiguration[] newArray(int i6) {
            return new CaptureConfiguration[i6];
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final CaptureConfiguration f35633a;

        public b(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality) {
            CaptureConfiguration captureConfiguration = new CaptureConfiguration((a) null);
            this.f35633a = captureConfiguration;
            captureConfiguration.f35620a = captureResolution.width;
            captureConfiguration.f35621b = captureResolution.height;
            captureConfiguration.f35622c = captureResolution.getBitrate(captureQuality);
        }

        public CaptureConfiguration a() {
            return this.f35633a;
        }

        public b b(int i6) {
            this.f35633a.f35627h = i6;
            return this;
        }

        public b c(int i6) {
            this.f35633a.f35623d = i6 * 1000;
            return this;
        }

        public b d(int i6) {
            this.f35633a.f35624e = i6 * 1048576;
            return this;
        }

        public b e() {
            this.f35633a.f35626g = false;
            return this;
        }

        public b f() {
            this.f35633a.f35625f = true;
            return this;
        }

        public b(int i6, int i7, int i8) {
            CaptureConfiguration captureConfiguration = new CaptureConfiguration((a) null);
            this.f35633a = captureConfiguration;
            captureConfiguration.f35620a = i6;
            captureConfiguration.f35621b = i7;
            captureConfiguration.f35622c = i8;
        }
    }

    /* synthetic */ CaptureConfiguration(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CaptureConfiguration(a aVar) {
        this();
    }

    public static CaptureConfiguration n() {
        return new CaptureConfiguration();
    }

    public boolean i() {
        return this.f35626g;
    }

    public int k() {
        return this.f35630k;
    }

    public int l() {
        return this.f35629j;
    }

    public int o() {
        return this.f35623d;
    }

    public int p() {
        return this.f35624e;
    }

    public int q() {
        return this.f35628i;
    }

    public boolean s() {
        return this.f35625f;
    }

    public int t() {
        return this.f35622c;
    }

    public int u() {
        return this.f35632m;
    }

    public int v() {
        return this.f35627h;
    }

    public int w() {
        return this.f35621b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f35620a);
        parcel.writeInt(this.f35621b);
        parcel.writeInt(this.f35622c);
        parcel.writeInt(this.f35623d);
        parcel.writeInt(this.f35624e);
        parcel.writeInt(this.f35627h);
        parcel.writeByte(this.f35625f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f35626g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f35628i);
        parcel.writeInt(this.f35629j);
        parcel.writeInt(this.f35630k);
        parcel.writeInt(this.f35631l);
        parcel.writeInt(this.f35632m);
    }

    public int x() {
        return this.f35631l;
    }

    public int y() {
        return this.f35620a;
    }

    private CaptureConfiguration() {
        this.f35620a = PredefinedCaptureConfigurations.f35648o;
        this.f35621b = PredefinedCaptureConfigurations.f35647n;
        this.f35622c = 5000000;
        this.f35623d = -1;
        this.f35624e = -1;
        this.f35625f = false;
        this.f35626g = true;
        this.f35627h = 30;
        this.f35628i = 2;
        this.f35629j = 0;
        this.f35630k = 3;
        this.f35631l = 1;
        this.f35632m = 2;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality) {
        this.f35620a = PredefinedCaptureConfigurations.f35648o;
        this.f35621b = PredefinedCaptureConfigurations.f35647n;
        this.f35622c = 5000000;
        this.f35623d = -1;
        this.f35624e = -1;
        this.f35625f = false;
        this.f35626g = true;
        this.f35627h = 30;
        this.f35628i = 2;
        this.f35629j = 0;
        this.f35630k = 3;
        this.f35631l = 1;
        this.f35632m = 2;
        this.f35620a = captureResolution.width;
        this.f35621b = captureResolution.height;
        this.f35622c = captureResolution.getBitrate(captureQuality);
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i6, int i7, boolean z5) {
        this(captureResolution, captureQuality, i6, i7, z5, false);
        this.f35625f = z5;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i6, int i7, boolean z5, boolean z6) {
        this(captureResolution, captureQuality, i6, i7);
        this.f35625f = z5;
        this.f35626g = z6;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i6, int i7, boolean z5, boolean z6, int i8) {
        this(captureResolution, captureQuality, i6, i7, z5, z6);
        this.f35627h = i8;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i6, int i7) {
        this(captureResolution, captureQuality);
        this.f35623d = i6 * 1000;
        this.f35624e = i7 * 1048576;
    }

    @Deprecated
    public CaptureConfiguration(int i6, int i7, int i8) {
        this.f35623d = -1;
        this.f35624e = -1;
        this.f35625f = false;
        this.f35626g = true;
        this.f35627h = 30;
        this.f35628i = 2;
        this.f35629j = 0;
        this.f35630k = 3;
        this.f35631l = 1;
        this.f35632m = 2;
        this.f35620a = i6;
        this.f35621b = i7;
        this.f35622c = i8;
    }

    @Deprecated
    public CaptureConfiguration(int i6, int i7, int i8, int i9, int i10) {
        this(i6, i7, i8);
        this.f35623d = i9 * 1000;
        this.f35624e = i10 * 1048576;
    }

    private CaptureConfiguration(Parcel parcel) {
        this.f35620a = PredefinedCaptureConfigurations.f35648o;
        this.f35621b = PredefinedCaptureConfigurations.f35647n;
        this.f35622c = 5000000;
        this.f35623d = -1;
        this.f35624e = -1;
        this.f35625f = false;
        this.f35626g = true;
        this.f35627h = 30;
        this.f35628i = 2;
        this.f35629j = 0;
        this.f35630k = 3;
        this.f35631l = 1;
        this.f35632m = 2;
        this.f35620a = parcel.readInt();
        this.f35621b = parcel.readInt();
        this.f35622c = parcel.readInt();
        this.f35623d = parcel.readInt();
        this.f35624e = parcel.readInt();
        this.f35627h = parcel.readInt();
        this.f35625f = parcel.readByte() != 0;
        this.f35626g = parcel.readByte() != 0;
        this.f35628i = parcel.readInt();
        this.f35629j = parcel.readInt();
        this.f35630k = parcel.readInt();
        this.f35631l = parcel.readInt();
        this.f35632m = parcel.readInt();
    }
}
