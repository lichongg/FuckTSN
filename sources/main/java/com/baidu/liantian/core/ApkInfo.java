package com.baidu.liantian.core;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ApkInfo {
    public ActivityInfo[] activities;
    public String apkMD5;
    public int apkParseSuc;
    public int applicationTheme;
    public ClassLoader classLoader;
    public String className;
    public PackageInfo cloudPkgInfo;
    public String dataDir;
    public String dexPath;
    public String downloadURL;
    public int duration;
    public Context hostContext;
    public int initStatus;
    public List<h> intentFilters;
    public int isOnce;
    public int key;
    public String libPath;
    public int network;
    public String packageName;
    public String pkgPath;
    public String signMD5;
    public long startTime;
    public String versionName;
    public int priority = -1;
    public boolean isMem = false;

    public ApkInfo() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApkInfo apkInfo = (ApkInfo) obj;
        String str = this.packageName;
        if (str == null) {
            if (apkInfo.packageName != null) {
                return false;
            }
        } else if (!str.equals(apkInfo.packageName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.packageName;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public ApkInfo(int i6, String str, String str2) {
        this.key = i6;
        this.versionName = str;
        this.pkgPath = str2;
    }

    public ApkInfo(String str, String str2) {
        this.versionName = str;
        this.pkgPath = str2;
    }

    public ApkInfo(int i6, String str, String str2, String str3, String str4) {
        this.key = i6;
        this.packageName = str;
        this.versionName = str2;
        this.downloadURL = str3;
        this.apkMD5 = str4;
    }
}
