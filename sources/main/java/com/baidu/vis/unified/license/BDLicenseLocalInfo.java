package com.baidu.vis.unified.license;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDLicenseLocalInfo {
    public int algorithmId;
    public String deviceId;
    public String fingerVersion;
    public String licenseKey;
    public String licenseSdkVersion;
    public String md5;
    public String packageName;

    public String toString() {
        return "licenseKey:" + this.licenseKey + ",algorithmId:" + this.algorithmId + ";packageName:" + this.packageName + ",md5:" + this.md5 + ";deviceId:" + this.deviceId + ",fingerVersion:" + this.fingerVersion + ";licenseSdkVersion:" + this.licenseSdkVersion;
    }

    public BDLicenseLocalInfo(String str, int i6, String str2, String str3, String str4, String str5, String str6) {
        this.licenseKey = str;
        this.algorithmId = i6;
        this.packageName = str2;
        this.md5 = str3;
        this.deviceId = str4;
        this.fingerVersion = str5;
        this.licenseSdkVersion = str6;
    }
}
