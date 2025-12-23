package com.baidu.vis.unified.license;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDLicenseAuthInfo {
    public int algorithmId;
    public String deviceId;
    public long expireTime;
    public String functionList;
    public String licenseKey;
    public String md5;
    public String packageName;

    public String toString() {
        return "licenseKey:" + this.licenseKey + ",algorithmId:" + this.algorithmId + ";packageName:" + this.packageName + ",md5:" + this.md5 + ";deviceId:" + this.deviceId + ",expireTime:" + this.expireTime + ";functionList:" + this.functionList;
    }

    public BDLicenseAuthInfo(String str, int i6, String str2, String str3, String str4, long j6, String str5) {
        this.licenseKey = str;
        this.algorithmId = i6;
        this.packageName = str2;
        this.md5 = str3;
        this.deviceId = str4;
        this.expireTime = j6;
        this.functionList = str5;
    }
}
