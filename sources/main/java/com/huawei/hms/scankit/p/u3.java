package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.stub.StubApp;
import java.util.LinkedHashMap;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
abstract class u3 {

    /* renamed from: d, reason: collision with root package name */
    static String f34856d = "FORMAT_UNKNOWN";

    /* renamed from: e, reason: collision with root package name */
    static String f34857e = "OTHER";

    /* renamed from: f, reason: collision with root package name */
    static SparseArray<String> f34858f = new a();

    /* renamed from: g, reason: collision with root package name */
    static SparseArray<String> f34859g = new b();

    /* renamed from: a, reason: collision with root package name */
    Context f34860a;

    /* renamed from: b, reason: collision with root package name */
    LinkedHashMap<String, String> f34861b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    volatile long f34862c;

    private void b(Bundle bundle) {
        try {
            String packageName = this.f34860a.getPackageName();
            this.f34861b.put(WiseOpenHianalyticsData.UNION_PACKAGE, packageName);
            if (bundle == null || !bundle.containsKey("appid")) {
                this.f34861b.put("appid", packageName);
            } else {
                this.f34861b.put("appid", bundle.getString("appid"));
            }
            PackageManager packageManager = this.f34860a.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            this.f34861b.put("appName", applicationInfo.loadLabel(packageManager).toString());
            this.f34861b.put("version", a(applicationInfo.metaData));
            String d6 = d();
            this.f34861b.put("hmscoreVersion", d6);
            this.f34861b.put("isHMSCore", "unknown".equals(d6) ? "0" : "1");
        } catch (PackageManager.NameNotFoundException unused) {
            o4.b("HaLog", "PackageManager.NameNotFoundException");
        } catch (Exception unused2) {
            o4.b("HaLog", "initValue Exception");
        }
        try {
            this.f34861b.put("sdkName", "scankit");
            this.f34861b.put("algopt", b());
            this.f34861b.put("isFullSdk", "FULLSDK");
            this.f34861b.put(WiseOpenHianalyticsData.UNION_APP_VERSION, c());
            if (b4.f34021a) {
                this.f34861b.put("apkVersion", b4.f34022b);
            } else {
                this.f34861b.put("apkVersion", "unknown");
            }
            this.f34861b.put("service", "com.huawei.hms.scankit");
            this.f34861b.put("operator", b4.b(this.f34860a));
            this.f34861b.put("networkType", b4.a(this.f34860a));
            this.f34861b.put(MLApplicationSetting.BundleKeyConstants.AppInfo.COUNTRY_CODE, b4.a(this.f34860a, false));
            this.f34861b.put("deviceType", b4.c());
            this.f34861b.put("emuiVersion", b4.d());
            this.f34861b.put("androidVersion", b4.a());
            this.f34861b.put("deviceCategory", b4.b());
        } catch (RuntimeException unused3) {
            o4.b("HaLog", "initValue RuntimeException");
        } catch (Exception unused4) {
            o4.b("HaLog", "initValue Exception");
        }
    }

    private boolean f() {
        return true;
    }

    boolean a() {
        if (w7.c(this.f34860a)) {
            return false;
        }
        try {
            if (!f() && !e()) {
                if (Settings.Secure.getInt(this.f34860a.getContentResolver(), "hw_app_analytics_state", 0) != 1) {
                    return false;
                }
            }
            return true;
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends SparseArray<String> {
        a() {
            put(HmsScanBase.AZTEC_SCAN_TYPE, "AZTEC");
            put(HmsScanBase.CODABAR_SCAN_TYPE, "CODABAR");
            put(HmsScanBase.CODE39_SCAN_TYPE, "CODE39");
            put(HmsScanBase.CODE93_SCAN_TYPE, "CODE93");
            put(HmsScanBase.CODE128_SCAN_TYPE, "CODE128");
            put(HmsScanBase.DATAMATRIX_SCAN_TYPE, "DATAMATRIX");
            put(HmsScanBase.EAN8_SCAN_TYPE, "EAN8");
            put(HmsScanBase.EAN13_SCAN_TYPE, "EAN13");
            put(HmsScanBase.ITF14_SCAN_TYPE, "ITF14");
            put(HmsScanBase.PDF417_SCAN_TYPE, "PDF417");
            put(HmsScanBase.QRCODE_SCAN_TYPE, "QRCODE");
            put(HmsScanBase.UPCCODE_A_SCAN_TYPE, "UPCCODE_A");
            put(HmsScanBase.UPCCODE_E_SCAN_TYPE, "UPCCODE_E");
            put(HmsScanBase.FORMAT_UNKNOWN, u3.f34856d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends SparseArray<String> {
        b() {
            put(HmsScan.ARTICLE_NUMBER_FORM, "ARTICLE_NUMBER");
            put(HmsScan.EMAIL_CONTENT_FORM, "EMAIL_CONTENT");
            put(HmsScan.TEL_PHONE_NUMBER_FORM, "TEL_PHONE_NUMBER");
            put(HmsScan.PURE_TEXT_FORM, "PURE_TEXT");
            put(HmsScan.SMS_FORM, "SMS");
            put(HmsScan.URL_FORM, Field.URL);
            put(HmsScan.WIFI_CONNECT_INFO_FORM, "WIFI_CONNECT_INFO");
            put(HmsScan.EVENT_INFO_FORM, "EVENT_INFO");
            put(HmsScan.CONTACT_DETAIL_FORM, "CONTACT_DETAIL");
            put(HmsScan.DRIVER_INFO_FORM, "DRIVER_INFO");
            put(HmsScan.LOCATION_COORDINATE_FORM, "LOCATION_COORDINATE");
            put(HmsScan.ISBN_NUMBER_FORM, "ISBN_NUMBER");
            put(-1, u3.f34857e);
        }
    }

    private String c() {
        try {
            return this.f34860a.getPackageManager().getPackageInfo(this.f34860a.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return "unknown";
        }
    }

    private String d() {
        try {
            return this.f34860a.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return "unknown";
        }
    }

    private boolean e() {
        try {
            String property = SystemPropUtils.getProperty(com.acse.ottn.l3.f4736f, "ro.hw.country", "android.os.SystemProperties", "UNKNOWN");
            TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(this.f34860a.getApplicationContext()).getSystemService("phone");
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (com.huawei.hms.feature.dynamic.f.e.f33257e.equalsIgnoreCase(property) && com.huawei.hms.feature.dynamic.f.e.f33257e.equalsIgnoreCase(networkCountryIso)) {
                if (com.huawei.hms.feature.dynamic.f.e.f33257e.equalsIgnoreCase(simCountryIso)) {
                    return true;
                }
            }
        } catch (RuntimeException | Exception unused) {
        }
        return false;
    }

    void g() {
        String str;
        o4.d("HaLog", "update HiAnalyticsLogUtils.apk_mode " + b4.f34021a + " HiAnalyticsLogUtils.apkVersion " + b4.f34022b);
        if (!b4.f34021a || (str = b4.f34022b) == null) {
            return;
        }
        this.f34861b.put("apkVersion", str);
    }

    u3(Bundle bundle, Context context) {
        this.f34860a = context;
        b(bundle);
    }

    static String a(int i6) {
        return f34858f.get(i6, f34856d);
    }

    private String a(Bundle bundle) {
        String[] strArr = {"huawei_module_scankit_sdk_version", "com.huawei.hms.client.service.name:scan", "com.huawei.hms.client.service.name:scanplus", "com.huawei.hms.client.service.name:scankit"};
        if (bundle != null) {
            for (int i6 = 0; i6 < 4; i6++) {
                String str = strArr[i6];
                if (bundle.getString(str) != null) {
                    return bundle.getString(str);
                }
            }
            return "scankit:1.0.2.300";
        }
        return "scankit:1.0.2.300";
    }

    private String b() {
        if (Build.VERSION.SDK_INT == 24) {
            return "full-noso";
        }
        return "full";
    }

    static String b(int i6) {
        return f34859g.get(i6, f34857e);
    }
}
