package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.l3;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DevicesIDsHelper {
    private static final String TAG = "DevicesIDsHelper";
    private AppIdsUpdater _listener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface AppIdsUpdater {
        void OnIdsValid(String str);
    }

    private String getProperty(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }

    private String getBrand() {
        return Build.BRAND.toUpperCase();
    }

    private void getIDFromNewThead(Context context) {
        if (context == null) {
            return;
        }
        try {
            if ("ASUS".equalsIgnoreCase(getManufacturer())) {
                new ASUSDeviceIDHelper(context).getID(this._listener);
                return;
            }
            if (isHuawei()) {
                new HWDeviceIDHelper(context).getHWID(this._listener);
                return;
            }
            if (isOppo()) {
                new OppoDeviceIDHelper(context).getID(this._listener);
                return;
            }
            if ("ONEPLUS".equalsIgnoreCase(getManufacturer())) {
                new OnePlusDeviceIDHelper(context).getID(this._listener);
                return;
            }
            if ("ZTE".equalsIgnoreCase(getManufacturer())) {
                new ZTEDeviceIDHelper(context).getID(this._listener);
                return;
            }
            if (!"FERRMEOS".equalsIgnoreCase(getManufacturer()) && !isFreeMeOS()) {
                if (!"SSUI".equalsIgnoreCase(getManufacturer()) && !isSSUIOS()) {
                    if ("SAMSUNG".equalsIgnoreCase(getManufacturer())) {
                        new SamsungDeviceIDHelper(context).getSumsungID(this._listener);
                        return;
                    }
                    return;
                }
                new ZTEDeviceIDHelper(context).getID(this._listener);
                return;
            }
            new ZTEDeviceIDHelper(context).getID(this._listener);
        } catch (Throwable th) {
            SDKLog.e(TAG, "getIDFromNewThead exception");
            SDKLog.stack(th);
        }
    }

    private String getManufacturer() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean isHuawei() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR");
    }

    public static boolean isOppo() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""));
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e6) {
            SDKLog.e(TAG, "System property invoke error: " + e6);
            SDKLog.stack(e6);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public void getOAID(Context context) {
        String oaid;
        AppIdsUpdater appIdsUpdater;
        try {
            SDKLog.d(TAG, "init oaid " + getManufacturer());
            if ("ASUS".equalsIgnoreCase(getManufacturer())) {
                getIDFromNewThead(context);
            } else if (isHuawei()) {
                getIDFromNewThead(context);
            } else if ("LENOVO".equalsIgnoreCase(getManufacturer())) {
                new LenovoDeviceIDHelper(context).getIdRun(this._listener);
            } else if ("MOTOLORA".equalsIgnoreCase(getManufacturer())) {
                new LenovoDeviceIDHelper(context).getIdRun(this._listener);
            } else {
                if (!"MEIZU".equalsIgnoreCase(getManufacturer())) {
                    if ("NUBIA".equalsIgnoreCase(getManufacturer())) {
                        oaid = new NubiaDeviceIDHelper(context).getNubiaID();
                    } else if (isOppo()) {
                        getIDFromNewThead(context);
                    } else if ("SAMSUNG".equalsIgnoreCase(getManufacturer())) {
                        getIDFromNewThead(context);
                    } else if ("VIVO".equalsIgnoreCase(getManufacturer())) {
                        oaid = new VivoDeviceIDHelper(context).getOaid();
                    } else if ("XIAOMI".equalsIgnoreCase(getManufacturer())) {
                        oaid = new XiaomiDeviceIDHelper(context).getOAID();
                    } else if ("BLACKSHARK".equalsIgnoreCase(getManufacturer())) {
                        oaid = new XiaomiDeviceIDHelper(context).getOAID();
                    } else if ("ONEPLUS".equalsIgnoreCase(getManufacturer())) {
                        getIDFromNewThead(context);
                    } else if ("ZTE".equalsIgnoreCase(getManufacturer())) {
                        getIDFromNewThead(context);
                    } else {
                        if (!"FERRMEOS".equalsIgnoreCase(getManufacturer()) && !isFreeMeOS()) {
                            if ("SSUI".equalsIgnoreCase(getManufacturer()) || isSSUIOS()) {
                                getIDFromNewThead(context);
                            }
                        }
                        getIDFromNewThead(context);
                    }
                    appIdsUpdater = this._listener;
                    if (appIdsUpdater != null || oaid == null) {
                    }
                    appIdsUpdater.OnIdsValid(oaid);
                    return;
                }
                new MeizuDeviceIDHelper(context).getMeizuID(this._listener);
            }
            oaid = null;
            appIdsUpdater = this._listener;
            if (appIdsUpdater != null) {
            }
        } catch (Throwable th) {
            SDKLog.stack(th);
        }
    }

    public boolean isFreeMeOS() {
        String property = getProperty("ro.build.freeme.label");
        return !TextUtils.isEmpty(property) && property.equalsIgnoreCase("FREEMEOS");
    }

    public boolean isSSUIOS() {
        String property = getProperty("ro.ssui.product");
        return (TextUtils.isEmpty(property) || property.equalsIgnoreCase("unknown")) ? false : true;
    }

    public DevicesIDsHelper(AppIdsUpdater appIdsUpdater) {
        this._listener = appIdsUpdater;
    }
}
