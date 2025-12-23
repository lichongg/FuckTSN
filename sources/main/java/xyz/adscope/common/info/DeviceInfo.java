package xyz.adscope.common.info;

import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.sp.CommonSpUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DeviceInfo {
    private static DeviceInfo J;
    String A;
    String B;
    String C;
    String D;
    String E;
    String F;
    private String H;

    /* renamed from: a, reason: collision with root package name */
    private Context f56376a;

    /* renamed from: b, reason: collision with root package name */
    long f56377b;

    /* renamed from: c, reason: collision with root package name */
    String f56378c;

    /* renamed from: e, reason: collision with root package name */
    String f56380e;

    /* renamed from: f, reason: collision with root package name */
    String f56381f;

    /* renamed from: g, reason: collision with root package name */
    String f56382g;

    /* renamed from: h, reason: collision with root package name */
    String f56383h;

    /* renamed from: i, reason: collision with root package name */
    String f56384i;

    /* renamed from: j, reason: collision with root package name */
    String f56385j;

    /* renamed from: k, reason: collision with root package name */
    String f56386k;

    /* renamed from: l, reason: collision with root package name */
    String f56387l;

    /* renamed from: t, reason: collision with root package name */
    String f56395t;

    /* renamed from: u, reason: collision with root package name */
    String f56396u;

    /* renamed from: v, reason: collision with root package name */
    String f56397v;

    /* renamed from: w, reason: collision with root package name */
    String f56398w;

    /* renamed from: x, reason: collision with root package name */
    String f56399x;

    /* renamed from: y, reason: collision with root package name */
    String f56400y;

    /* renamed from: z, reason: collision with root package name */
    String f56401z;

    /* renamed from: d, reason: collision with root package name */
    int f56379d = -1;

    /* renamed from: m, reason: collision with root package name */
    int f56388m = -1;

    /* renamed from: n, reason: collision with root package name */
    int f56389n = -1;

    /* renamed from: o, reason: collision with root package name */
    int f56390o = -1;

    /* renamed from: p, reason: collision with root package name */
    int f56391p = -1;

    /* renamed from: q, reason: collision with root package name */
    int f56392q = -1;

    /* renamed from: r, reason: collision with root package name */
    float f56393r = -1.0f;

    /* renamed from: s, reason: collision with root package name */
    float f56394s = -1.0f;
    int G = -1;
    private int I = -1;

    public static DeviceInfo getInstance(Context context) {
        if (J == null) {
            synchronized (DeviceInfo.class) {
                try {
                    if (J == null) {
                        J = new DeviceInfo(context);
                    }
                } finally {
                }
            }
        }
        return J;
    }

    public String getAv() {
        if (TextUtils.isEmpty(this.F)) {
            this.F = DeviceInfoUtil.getAndroidVersion();
        }
        return this.F;
    }

    public String getBootMark() {
        if (TextUtils.isEmpty(this.f56395t)) {
            this.f56395t = DeviceInfoUtil.getDeviceBootMark();
        }
        return this.f56395t;
    }

    public String getBrand() {
        if (TextUtils.isEmpty(this.f56381f)) {
            this.f56381f = DeviceInfoUtil.getBrand();
        }
        return this.f56381f;
    }

    public String getCarrier() {
        if (TextUtils.isEmpty(this.f56385j)) {
            this.f56385j = DeviceInfoUtil.getCarrier(this.f56376a);
        }
        return this.f56385j;
    }

    public String getConnectType() {
        if (TextUtils.isEmpty(this.f56386k)) {
            this.f56386k = DeviceInfoUtil.getConnectType(this.f56376a) + "";
        }
        return this.f56386k;
    }

    public String getCountry() {
        if (TextUtils.isEmpty(this.C)) {
            this.C = DeviceInfoUtil.getCountry(this.f56376a);
        }
        return this.C;
    }

    public int getCountry_CN() {
        if (this.G == -1) {
            this.G = DeviceInfoUtil.getCountryCN(this.f56376a);
        }
        return this.G;
    }

    public String getDensity() {
        if (TextUtils.isEmpty(this.B)) {
            this.B = DeviceInfoUtil.getDensity(this.f56376a) + "";
        }
        return this.B;
    }

    public String getDeviceName() {
        if (TextUtils.isEmpty(this.E)) {
            this.E = DeviceInfoUtil.getDeviceName(this.f56376a);
        }
        return this.E;
    }

    public int getDeviceType() {
        if (this.f56379d == -1) {
            this.f56379d = DeviceInfoUtil.getDeviceType(this.f56376a);
        }
        return this.f56379d;
    }

    public String getFileMark() {
        if (TextUtils.isEmpty(this.D)) {
            this.D = DeviceInfoUtil.getFileMark();
        }
        return this.D;
    }

    public String getGaid() {
        if (TextUtils.isEmpty(this.f56400y)) {
            this.f56400y = CommonSpUtil.getString(this.f56376a, CommonConstants.DEVICE_GAID_KEY);
        }
        return this.f56400y;
    }

    public String getHardDiskSize() {
        if (TextUtils.isEmpty(this.f56398w)) {
            this.f56398w = DeviceInfoUtil.getHardDisk();
        }
        return this.f56398w;
    }

    public String getHmsCoreVersion() {
        if (TextUtils.isEmpty(this.H)) {
            this.H = DeviceInfoUtil.getHmsCoreVersion(this.f56376a);
        }
        return this.H;
    }

    public int getIsDevelop() {
        if (this.I == -1) {
            this.I = DeviceInfoUtil.isDevelop(this.f56376a);
        }
        return this.I;
    }

    public String getLanguage() {
        if (TextUtils.isEmpty(this.f56387l)) {
            this.f56387l = DeviceInfoUtil.getLanguage();
        }
        return this.f56387l;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.f56380e)) {
            this.f56380e = DeviceInfoUtil.getManufacturer();
        }
        return this.f56380e;
    }

    public String getModel() {
        if (TextUtils.isEmpty(this.f56382g)) {
            this.f56382g = DeviceInfoUtil.getModel();
        }
        return this.f56382g;
    }

    public String getOaid() {
        if (TextUtils.isEmpty(this.f56399x)) {
            this.f56399x = CommonSpUtil.getString(this.f56376a, CommonConstants.DEVICE_OAID_KEY);
        }
        return this.f56399x;
    }

    public int getOrientation() {
        if (this.f56392q == -1) {
            this.f56392q = DeviceInfoUtil.getOrientation(this.f56376a);
        }
        return this.f56392q;
    }

    public String getOs() {
        if (TextUtils.isEmpty(this.f56383h)) {
            this.f56383h = DeviceInfoUtil.getOs() + "";
        }
        return this.f56383h;
    }

    public String getOsVersion() {
        if (TextUtils.isEmpty(this.f56384i)) {
            this.f56384i = DeviceInfoUtil.getOsVersion();
        }
        return this.f56384i;
    }

    public String getPhysicalMemory() {
        if (TextUtils.isEmpty(this.f56397v)) {
            this.f56397v = DeviceInfoUtil.getPhysicalMemory(this.f56376a);
        }
        return this.f56397v;
    }

    public float getPpi() {
        if (this.f56394s < 0.0f) {
            this.f56394s = DeviceInfoUtil.getPPI(this.f56376a);
        }
        return this.f56394s;
    }

    public float getPxRation() {
        if (this.f56393r < 0.0f) {
            this.f56393r = DeviceInfoUtil.getPxRatio(this.f56376a);
        }
        return this.f56393r;
    }

    public int getResolutionHeight() {
        if (this.f56390o == -1) {
            this.f56390o = DeviceInfoUtil.getScreenHeight(this.f56376a);
        }
        return this.f56390o;
    }

    public int getResolutionWidth() {
        if (this.f56391p == -1) {
            this.f56391p = DeviceInfoUtil.getScreenWidth(this.f56376a);
        }
        return this.f56391p;
    }

    public int getScreenHeight() {
        if (this.f56388m == -1) {
            this.f56388m = DeviceInfoUtil.getScreenHeightDp(this.f56376a);
        }
        return this.f56388m;
    }

    public int getScreenWidth() {
        if (this.f56389n == -1) {
            this.f56389n = DeviceInfoUtil.getScreenWidthDp(this.f56376a);
        }
        return this.f56389n;
    }

    public String getSdkid() {
        if (TextUtils.isEmpty(this.A)) {
            this.A = DeviceInfoUtil.getSdkId(this.f56376a);
        }
        return this.A;
    }

    public String getTimeZone() {
        if (TextUtils.isEmpty(this.f56401z)) {
            this.f56401z = DeviceInfoUtil.getTimeZone();
        }
        return this.f56401z;
    }

    public String getUpdateMark() {
        if (TextUtils.isEmpty(this.f56396u)) {
            this.f56396u = DeviceInfoUtil.getDeviceUpdateMark();
        }
        return this.f56396u;
    }

    public String getUserAgent() {
        if (TextUtils.isEmpty(this.f56378c)) {
            this.f56378c = DeviceInfoUtil.getUserAgent(this.f56376a);
        }
        return this.f56378c;
    }

    public void setAv(String str) {
        this.F = str;
    }

    public void setBootMark(String str) {
        this.f56395t = str;
    }

    public void setBrand(String str) {
        this.f56381f = str;
    }

    public void setCarrier(String str) {
        this.f56385j = str;
    }

    public void setConnectType(String str) {
        this.f56386k = str;
    }

    public void setCountry(String str) {
        this.C = str;
    }

    public void setCountry_CN(int i6) {
        this.G = i6;
    }

    public void setDensity(String str) {
        this.B = str;
    }

    public void setDeviceName(String str) {
        this.E = str;
    }

    public void setDeviceType(int i6) {
        this.f56379d = i6;
    }

    public void setFileMark(String str) {
        this.D = str;
    }

    public void setGaid(String str) {
        this.f56400y = str;
    }

    public void setHardDiskSize(String str) {
        this.f56398w = str;
    }

    public void setHmsCoreVersion(String str) {
        this.H = str;
    }

    public void setIsDevelop(int i6) {
        this.I = i6;
    }

    public void setLanguage(String str) {
        this.f56387l = str;
    }

    public void setManufacturer(String str) {
        this.f56380e = str;
    }

    public void setModel(String str) {
        this.f56382g = str;
    }

    public void setOaid(String str) {
        this.f56399x = str;
    }

    public void setOrientation(int i6) {
        this.f56392q = i6;
    }

    public void setOs(String str) {
        this.f56383h = str;
    }

    public void setOsVersion(String str) {
        this.f56384i = str;
    }

    public void setPhysicalMemory(String str) {
        this.f56397v = str;
    }

    public void setPpi(float f6) {
        this.f56394s = f6;
    }

    public void setPxRation(float f6) {
        this.f56393r = f6;
    }

    public void setResolutionHeight(int i6) {
        this.f56390o = i6;
    }

    public void setResolutionWidth(int i6) {
        this.f56391p = i6;
    }

    public void setScreenHeight(int i6) {
        this.f56388m = i6;
    }

    public void setScreenWidth(int i6) {
        this.f56389n = i6;
    }

    public void setSdkid(String str) {
        this.A = str;
    }

    public void setTimeStamp(long j6) {
        this.f56377b = j6;
    }

    public void setTimeZone(String str) {
        this.f56401z = str;
    }

    public void setUpdateMark(String str) {
        this.f56396u = str;
    }

    public void setUserAgent(String str) {
        this.f56378c = str;
    }

    private DeviceInfo(Context context) {
        this.f56376a = context;
    }

    public long getTimeStamp() {
        return DeviceInfoUtil.getTimeStamp();
    }
}
