package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.autonavi.aps.amapapi.utils.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static int f8849d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f8850e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static int f8851f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static int f8852g = 4;
    private boolean A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private float G;
    private AMapLocationPurpose H;

    /* renamed from: b, reason: collision with root package name */
    boolean f8854b;

    /* renamed from: c, reason: collision with root package name */
    String f8855c;

    /* renamed from: h, reason: collision with root package name */
    private long f8856h;

    /* renamed from: i, reason: collision with root package name */
    private long f8857i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8858j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8859k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8860l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8861m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8862n;

    /* renamed from: o, reason: collision with root package name */
    private AMapLocationMode f8863o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8864q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8865r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8866s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8867t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8868u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f8869v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f8870w;

    /* renamed from: x, reason: collision with root package name */
    private long f8871x;

    /* renamed from: y, reason: collision with root package name */
    private long f8872y;

    /* renamed from: z, reason: collision with root package name */
    private GeoLanguage f8873z;

    /* renamed from: p, reason: collision with root package name */
    private static AMapLocationProtocol f8853p = AMapLocationProtocol.HTTP;

    /* renamed from: a, reason: collision with root package name */
    static String f8848a = "";
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() { // from class: com.amap.api.location.AMapLocationClientOption.1
        private static AMapLocationClientOption a(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        private static AMapLocationClientOption[] a(int i6) {
            return new AMapLocationClientOption[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption[] newArray(int i6) {
            return a(i6);
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);


        /* renamed from: a, reason: collision with root package name */
        private int f8877a;

        public final int getValue() {
            return this.f8877a;
        }

        AMapLocationProtocol(int i6) {
            this.f8877a = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.f8856h = 2000L;
        this.f8857i = b.f10242i;
        this.f8858j = false;
        this.f8859k = true;
        this.f8860l = true;
        this.f8861m = true;
        this.f8862n = true;
        this.f8863o = AMapLocationMode.Hight_Accuracy;
        this.f8864q = false;
        this.f8865r = false;
        this.f8866s = true;
        this.f8867t = true;
        this.f8868u = false;
        this.f8869v = false;
        this.f8870w = true;
        this.f8871x = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f8872y = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f8873z = GeoLanguage.DEFAULT;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = 0.0f;
        this.H = null;
        this.f8854b = false;
        this.f8855c = null;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f6) {
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        this.G = f6;
        return this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.location.AMapLocationClientOption$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8874a;

        static {
            int[] iArr = new int[AMapLocationPurpose.values().length];
            f8874a = iArr;
            try {
                iArr[AMapLocationPurpose.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8874a[AMapLocationPurpose.Transport.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8874a[AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private AMapLocationClientOption a(AMapLocationClientOption aMapLocationClientOption) {
        this.f8856h = aMapLocationClientOption.f8856h;
        this.f8858j = aMapLocationClientOption.f8858j;
        this.f8863o = aMapLocationClientOption.f8863o;
        this.f8859k = aMapLocationClientOption.f8859k;
        this.f8864q = aMapLocationClientOption.f8864q;
        this.f8865r = aMapLocationClientOption.f8865r;
        this.D = aMapLocationClientOption.D;
        this.f8860l = aMapLocationClientOption.f8860l;
        this.f8861m = aMapLocationClientOption.f8861m;
        this.f8857i = aMapLocationClientOption.f8857i;
        this.f8866s = aMapLocationClientOption.f8866s;
        this.f8867t = aMapLocationClientOption.f8867t;
        this.f8868u = aMapLocationClientOption.f8868u;
        this.f8869v = aMapLocationClientOption.isSensorEnable();
        this.f8870w = aMapLocationClientOption.isWifiScan();
        this.f8871x = aMapLocationClientOption.f8871x;
        setLocationProtocol(aMapLocationClientOption.getLocationProtocol());
        this.f8873z = aMapLocationClientOption.f8873z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.G = aMapLocationClientOption.G;
        this.H = aMapLocationClientOption.H;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(aMapLocationClientOption.getScanWifiInterval());
        this.f8872y = aMapLocationClientOption.f8872y;
        this.C = aMapLocationClientOption.getCacheTimeOut();
        this.A = aMapLocationClientOption.getCacheCallBack();
        this.B = aMapLocationClientOption.getCacheCallBackTime();
        this.E = aMapLocationClientOption.isSelfStartServiceEnable();
        this.F = aMapLocationClientOption.isNoLocReqCgiEnable();
        return this;
    }

    public static String getAPIKEY() {
        return f8848a;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        f8853p = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z5) {
        OPEN_ALWAYS_SCAN_WIFI = z5;
    }

    public static void setScanWifiInterval(long j6) {
        SCAN_WIFI_INTERVAL = j6;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocationClientOption m46clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new AMapLocationClientOption().a(this);
    }

    public boolean getCacheCallBack() {
        return this.A;
    }

    public int getCacheCallBackTime() {
        return this.B;
    }

    public int getCacheTimeOut() {
        return this.C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.G;
    }

    public GeoLanguage getGeoLanguage() {
        return this.f8873z;
    }

    public long getGpsFirstTimeout() {
        return this.f8872y;
    }

    public long getHttpTimeOut() {
        return this.f8857i;
    }

    public long getInterval() {
        return this.f8856h;
    }

    public long getLastLocationLifeCycle() {
        return this.f8871x;
    }

    public AMapLocationMode getLocationMode() {
        return this.f8863o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return f8853p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.H;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.D;
    }

    public boolean isGpsFirst() {
        return this.f8865r;
    }

    public boolean isKillProcess() {
        return this.f8864q;
    }

    public boolean isLocationCacheEnable() {
        return this.f8867t;
    }

    public boolean isMockEnable() {
        return this.f8859k;
    }

    public boolean isNeedAddress() {
        return this.f8860l;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.F;
    }

    public boolean isOffset() {
        return this.f8866s;
    }

    public boolean isOnceLocation() {
        return this.f8858j;
    }

    public boolean isOnceLocationLatest() {
        return this.f8868u;
    }

    public boolean isSelfStartServiceEnable() {
        return this.E;
    }

    public boolean isSensorEnable() {
        return this.f8869v;
    }

    public boolean isWifiActiveScan() {
        return this.f8861m;
    }

    public boolean isWifiScan() {
        return this.f8870w;
    }

    public AMapLocationClientOption setBeidouFirst(boolean z5) {
        this.D = z5;
        return this;
    }

    public void setCacheCallBack(boolean z5) {
        this.A = z5;
    }

    public void setCacheCallBackTime(int i6) {
        this.B = i6;
    }

    public void setCacheTimeOut(int i6) {
        this.C = i6;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.f8873z = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z5) {
        this.f8865r = z5;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j6) {
        if (j6 < 5000) {
            j6 = 5000;
        }
        if (j6 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            j6 = 30000;
        }
        this.f8872y = j6;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j6) {
        this.f8857i = j6;
        return this;
    }

    public AMapLocationClientOption setInterval(long j6) {
        if (j6 <= 800) {
            j6 = 800;
        }
        this.f8856h = j6;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z5) {
        this.f8864q = z5;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j6) {
        this.f8871x = j6;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z5) {
        this.f8867t = z5;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f8863o = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.H = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i6 = AnonymousClass2.f8874a[aMapLocationPurpose.ordinal()];
            if (i6 == 1) {
                this.f8863o = AMapLocationMode.Hight_Accuracy;
                this.f8858j = true;
                this.f8868u = true;
                this.f8865r = false;
                this.D = false;
                this.f8859k = false;
                this.f8870w = true;
                this.E = true;
                this.F = true;
                int i7 = f8849d;
                int i8 = f8850e;
                if ((i7 & i8) == 0) {
                    this.f8854b = true;
                    f8849d = i7 | i8;
                    this.f8855c = "signin";
                }
            } else {
                if (i6 == 2) {
                    int i9 = f8849d;
                    int i10 = f8851f;
                    if ((i9 & i10) == 0) {
                        this.f8854b = true;
                        f8849d = i9 | i10;
                        this.f8855c = NotificationCompat.CATEGORY_TRANSPORT;
                    }
                    this.f8863o = AMapLocationMode.Hight_Accuracy;
                    this.f8858j = false;
                    this.f8868u = false;
                    this.f8865r = true;
                    this.D = false;
                    this.E = true;
                    this.F = true;
                    this.f8859k = false;
                    this.f8870w = true;
                    return this;
                }
                if (i6 == 3) {
                    int i11 = f8849d;
                    int i12 = f8852g;
                    if ((i11 & i12) == 0) {
                        this.f8854b = true;
                        f8849d = i11 | i12;
                        this.f8855c = "sport";
                    }
                    this.f8863o = AMapLocationMode.Hight_Accuracy;
                    this.f8858j = false;
                    this.f8868u = false;
                    this.f8865r = true;
                    this.D = false;
                    this.E = true;
                    this.F = true;
                    this.f8859k = false;
                    this.f8870w = true;
                    return this;
                }
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z5) {
        this.f8859k = z5;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z5) {
        this.f8860l = z5;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean z5) {
        this.F = z5;
    }

    public AMapLocationClientOption setOffset(boolean z5) {
        this.f8866s = z5;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z5) {
        this.f8858j = z5;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z5) {
        this.f8868u = z5;
        return this;
    }

    public void setSelfStartServiceEnable(boolean z5) {
        this.E = z5;
    }

    public AMapLocationClientOption setSensorEnable(boolean z5) {
        this.f8869v = z5;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z5) {
        this.f8861m = z5;
        this.f8862n = z5;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z5) {
        this.f8870w = z5;
        if (z5) {
            this.f8861m = this.f8862n;
            return this;
        }
        this.f8861m = false;
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f8856h) + "#isOnceLocation:" + String.valueOf(this.f8858j) + "#locationMode:" + String.valueOf(this.f8863o) + "#locationProtocol:" + String.valueOf(f8853p) + "#isMockEnable:" + String.valueOf(this.f8859k) + "#isKillProcess:" + String.valueOf(this.f8864q) + "#isGpsFirst:" + String.valueOf(this.f8865r) + "#isBeidouFirst:" + String.valueOf(this.D) + "#isSelfStartServiceEnable:" + String.valueOf(this.E) + "#noLocReqCgiEnable:" + String.valueOf(this.F) + "#isNeedAddress:" + String.valueOf(this.f8860l) + "#isWifiActiveScan:" + String.valueOf(this.f8861m) + "#wifiScan:" + String.valueOf(this.f8870w) + "#httpTimeOut:" + String.valueOf(this.f8857i) + "#isLocationCacheEnable:" + String.valueOf(this.f8867t) + "#isOnceLocationLatest:" + String.valueOf(this.f8868u) + "#sensorEnable:" + String.valueOf(this.f8869v) + "#geoLanguage:" + String.valueOf(this.f8873z) + "#locationPurpose:" + String.valueOf(this.H) + "#callback:" + String.valueOf(this.A) + "#time:" + String.valueOf(this.B) + "#";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f8856h);
        parcel.writeLong(this.f8857i);
        parcel.writeByte(this.f8858j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8859k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8860l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8861m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8862n ? (byte) 1 : (byte) 0);
        AMapLocationMode aMapLocationMode = this.f8863o;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.f8864q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8865r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8866s ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8867t ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8868u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8869v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8870w ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8871x);
        parcel.writeInt(f8853p == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.f8873z;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.G);
        AMapLocationPurpose aMapLocationPurpose = this.H;
        parcel.writeInt(aMapLocationPurpose != null ? aMapLocationPurpose.ordinal() : -1);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.f8872y);
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z5) {
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.f8856h = 2000L;
        this.f8857i = b.f10242i;
        this.f8858j = false;
        this.f8859k = true;
        this.f8860l = true;
        this.f8861m = true;
        this.f8862n = true;
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        this.f8863o = aMapLocationMode;
        this.f8864q = false;
        this.f8865r = false;
        this.f8866s = true;
        this.f8867t = true;
        this.f8868u = false;
        this.f8869v = false;
        this.f8870w = true;
        this.f8871x = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f8872y = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        GeoLanguage geoLanguage = GeoLanguage.DEFAULT;
        this.f8873z = geoLanguage;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = 0.0f;
        this.H = null;
        this.f8854b = false;
        this.f8855c = null;
        this.f8856h = parcel.readLong();
        this.f8857i = parcel.readLong();
        this.f8858j = parcel.readByte() != 0;
        this.f8859k = parcel.readByte() != 0;
        this.f8860l = parcel.readByte() != 0;
        this.f8861m = parcel.readByte() != 0;
        this.f8862n = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.f8863o = readInt != -1 ? AMapLocationMode.values()[readInt] : aMapLocationMode;
        this.f8864q = parcel.readByte() != 0;
        this.f8865r = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = parcel.readByte() != 0;
        this.F = parcel.readByte() != 0;
        this.f8866s = parcel.readByte() != 0;
        this.f8867t = parcel.readByte() != 0;
        this.f8868u = parcel.readByte() != 0;
        this.f8869v = parcel.readByte() != 0;
        this.f8870w = parcel.readByte() != 0;
        this.f8871x = parcel.readLong();
        int readInt2 = parcel.readInt();
        f8853p = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.f8873z = readInt3 != -1 ? GeoLanguage.values()[readInt3] : geoLanguage;
        this.G = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.H = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : null;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0;
        this.f8872y = parcel.readLong();
    }
}
