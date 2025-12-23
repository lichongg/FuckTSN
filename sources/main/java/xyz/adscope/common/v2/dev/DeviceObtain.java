package xyz.adscope.common.v2.dev;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import xyz.adscope.common.v2.dev.info.DeviceUtil;
import xyz.adscope.common.v2.dev.info.NetworkUtil;
import xyz.adscope.common.v2.dev.info.OEMSystemInfo;
import xyz.adscope.common.v2.dev.info.PackageUtil;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.dev.info.SettingCheckCompilation;
import xyz.adscope.common.v2.dev.info.UserAgentHelper;
import xyz.adscope.common.v2.dev.oaid.OAIDHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class DeviceObtain implements IDeviceInterface {
    private String av;
    private String bootMark;
    private String brand;
    private String carrier;
    private int connectType;
    private String country;
    private float density;
    private String deviceName;
    private int deviceType;
    private String fileMark;
    private String hardDiskSize;
    private String hmsCoreVersion;
    private String hmsStoreVersion;
    private String language;
    private final Context mContext;
    private String mHonorOAID;
    private String manufacturer;
    private String model;
    private String oaid;
    private int orientation;
    private String osVersion;
    private String physicalMemory;
    private int ppi;
    private float pxRation;
    private int resolutionHeight;
    private int resolutionWidth;
    private String romVersion;
    private int screenHeight;
    private int screenWidth;
    private String timeZone;
    private String updateMark;
    private String userAgent;
    private int country_CN = -1;
    private final int os = DeviceUtil.getOS();

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getAndroidRelease() {
        if (TextUtils.isEmpty(this.osVersion)) {
            this.osVersion = DeviceUtil.getAndroidRelease();
        }
        return this.osVersion;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getAndroidVersion() {
        if (TextUtils.isEmpty(this.av)) {
            this.av = DeviceUtil.getAndroidVersion() + "";
        }
        return this.av;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getBrand() {
        if (TextUtils.isEmpty(this.brand)) {
            this.brand = DeviceUtil.getBrand();
        }
        return this.brand;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getCarrier() {
        if (TextUtils.isEmpty(this.carrier)) {
            this.carrier = DeviceUtil.getCarrier(this.mContext);
        }
        return this.carrier;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getConnectType() {
        if (this.connectType == 0) {
            this.connectType = NetworkUtil.getConnectType(this.mContext);
        }
        return this.connectType;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getCountryCN() {
        if (this.country_CN == -1) {
            this.country_CN = DeviceUtil.getCountryCN(this.mContext);
        }
        return this.country_CN;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getCountryCode() {
        if (TextUtils.isEmpty(this.country)) {
            this.country = DeviceUtil.getCountryCode(this.mContext);
        }
        return this.country;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public float getDensity() {
        if (this.density == 0.0f) {
            this.density = ScreenUtil.getDensity(this.mContext);
        }
        return this.density;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getDensityDpi() {
        if (this.ppi == 0) {
            this.ppi = ScreenUtil.getDensityDpi(this.mContext);
        }
        return this.ppi;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getDeveloperState() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "development_settings_enabled", 0);
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getDeviceName() {
        if (TextUtils.isEmpty(this.deviceName)) {
            this.deviceName = DeviceUtil.getDeviceName(this.mContext);
        }
        return this.deviceName;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getDeviceType() {
        if (this.deviceType == 0) {
            this.deviceType = DeviceUtil.getDeviceType(this.mContext);
        }
        return this.deviceType;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getDeviceUpdateMark() {
        if (TextUtils.isEmpty(this.updateMark)) {
            this.updateMark = DeviceUtil.getDeviceUpdateMark();
        }
        return this.updateMark;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getFileMark() {
        if (TextUtils.isEmpty(this.fileMark)) {
            this.fileMark = DeviceUtil.getFileMark() + "";
        }
        return this.fileMark;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getGAID() {
        return "";
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getHardDisk() {
        if (TextUtils.isEmpty(this.hardDiskSize)) {
            this.hardDiskSize = DeviceUtil.getHardDisk();
        }
        return this.hardDiskSize;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getHmsCoreVersion() {
        if (TextUtils.isEmpty(this.hmsCoreVersion)) {
            this.hmsCoreVersion = PackageUtil.getHmsCoreVersionCode(this.mContext);
        }
        return this.hmsCoreVersion;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getHmsStoreVersion() {
        if (TextUtils.isEmpty(this.hmsStoreVersion)) {
            this.hmsStoreVersion = PackageUtil.getHmsStoreVersionCode(this.mContext);
        }
        return this.hmsStoreVersion;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getHonorOAID() {
        if (TextUtils.isEmpty(this.mHonorOAID)) {
            this.mHonorOAID = OAIDHelper.getInstance().getHonorOAID(this.mContext);
        }
        return this.mHonorOAID;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getLanguage() {
        if (TextUtils.isEmpty(this.language)) {
            this.language = DeviceUtil.getLanguage();
        }
        return this.language;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getManufacturer() {
        if (TextUtils.isEmpty(this.manufacturer)) {
            this.manufacturer = DeviceUtil.getManufacturer();
        }
        return this.manufacturer;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getModel() {
        if (TextUtils.isEmpty(this.model)) {
            this.model = DeviceUtil.getModel();
        }
        return this.model;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getOAID() {
        if (TextUtils.isEmpty(this.oaid)) {
            this.oaid = OAIDHelper.getInstance().getOAID(this.mContext);
        }
        return this.oaid;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getOMERomVersion() {
        if (TextUtils.isEmpty(this.romVersion)) {
            OEMSystemInfo.getInstance().initializeOEMInfo();
            this.romVersion = OEMSystemInfo.getInstance().getRomVersion();
        }
        return this.romVersion;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getOrientation() {
        if (this.orientation == 0) {
            this.orientation = ScreenUtil.getOrientation(this.mContext);
        }
        return this.orientation;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getOs() {
        return this.os;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getPhysicalMemory() {
        if (TextUtils.isEmpty(this.physicalMemory)) {
            this.physicalMemory = DeviceUtil.getPhysicalMemory(this.mContext);
        }
        return this.physicalMemory;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getPromptTag() {
        return SettingCheckCompilation.checkIntentPrompt(this.mContext);
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getResolutionHeight() {
        if (this.resolutionHeight == 0) {
            this.resolutionHeight = ScreenUtil.getScreenHeightDp(this.mContext);
        }
        return this.resolutionHeight;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getResolutionWidth() {
        if (this.resolutionWidth == 0) {
            this.resolutionWidth = ScreenUtil.getScreenWidthDp(this.mContext);
        }
        return this.resolutionWidth;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getScreenHeightPX() {
        if (this.screenHeight == 0) {
            this.screenHeight = ScreenUtil.getScreenHeight(this.mContext);
        }
        return this.screenHeight;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getScreenWidthPX() {
        if (this.screenWidth == 0) {
            this.screenWidth = ScreenUtil.getScreenWidth(this.mContext);
        }
        return this.screenWidth;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getTimeZone() {
        if (TextUtils.isEmpty(this.timeZone)) {
            this.timeZone = DeviceUtil.getTimeZone();
        }
        return this.timeZone;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public String getUserAgent() {
        if (TextUtils.isEmpty(this.userAgent)) {
            this.userAgent = UserAgentHelper.getInstance().getUserAgent(this.mContext);
        }
        return this.userAgent;
    }

    DeviceObtain(Context context) {
        this.mContext = context;
    }

    @Override // xyz.adscope.common.v2.dev.IDeviceInterface
    public int getDeveloperTag() {
        if (getDeveloperState() == 1 || NetworkUtil.isVPNConnected()) {
            return 1;
        }
        return 0;
    }
}
