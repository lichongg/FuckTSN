package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8881b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f8882c = 2;

    /* renamed from: d, reason: collision with root package name */
    private int f8883d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f8884e = "UNKNOWN";

    /* renamed from: f, reason: collision with root package name */
    private long f8885f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8886g = false;

    /* renamed from: a, reason: collision with root package name */
    AMapLocationClientOption.AMapLocationMode f8880a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocationQualityReport m47clone() {
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        try {
            aMapLocationQualityReport.setGpsStatus(this.f8882c);
            aMapLocationQualityReport.setGPSSatellites(this.f8883d);
            aMapLocationQualityReport.setWifiAble(this.f8881b);
            aMapLocationQualityReport.setNetUseTime(this.f8885f);
            aMapLocationQualityReport.setNetworkType(this.f8884e);
            aMapLocationQualityReport.setLocationMode(this.f8880a);
            aMapLocationQualityReport.setInstallHighDangerMockApp(this.f8886g);
        } catch (Throwable th) {
            b.a(th, "AMapLocationQualityReport", "clone");
        }
        return aMapLocationQualityReport;
    }

    public String getAdviseMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        AMapLocationClientOption.AMapLocationMode aMapLocationMode = this.f8880a;
        if (aMapLocationMode != AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
            int i6 = this.f8882c;
            if (i6 != 0) {
                if (i6 == 1) {
                    stringBuffer.append("您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n");
                } else if (i6 == 2) {
                    stringBuffer.append("您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n");
                } else if (i6 == 3) {
                    stringBuffer.append("您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n");
                } else if (i6 == 4) {
                    stringBuffer.append("您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n");
                }
            } else if (aMapLocationMode == AMapLocationClientOption.AMapLocationMode.Device_Sensors && this.f8883d < 4) {
                stringBuffer.append("当前GPS信号弱，位置更新可能会延迟\n");
            }
        }
        if (this.f8880a != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            if ("DISCONNECTED".equals(this.f8884e)) {
                stringBuffer.append("您的设备未连接到网络，无法进行网络定位\n");
            } else if ("2G".equals(this.f8884e)) {
                stringBuffer.append("您的设备网络状态不太好，网络定位可能会有延迟\n");
            }
            if (!this.f8881b) {
                stringBuffer.append("您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n");
            }
        }
        return stringBuffer.toString();
    }

    public int getGPSSatellites() {
        return this.f8883d;
    }

    public int getGPSStatus() {
        return this.f8882c;
    }

    public long getNetUseTime() {
        return this.f8885f;
    }

    public String getNetworkType() {
        return this.f8884e;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.f8886g;
    }

    public boolean isWifiAble() {
        return this.f8881b;
    }

    public void setGPSSatellites(int i6) {
        this.f8883d = i6;
    }

    public void setGpsStatus(int i6) {
        this.f8882c = i6;
    }

    public void setInstallHighDangerMockApp(boolean z5) {
        this.f8886g = z5;
    }

    public void setLocationMode(AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.f8880a = aMapLocationMode;
    }

    public void setNetUseTime(long j6) {
        this.f8885f = j6;
    }

    public void setNetworkType(String str) {
        this.f8884e = str;
    }

    public void setWifiAble(boolean z5) {
        this.f8881b = z5;
    }
}
