package com.acse.ottn.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PlunInstallModel {
    private String appName;
    private boolean isInstallPlun;
    private boolean isNewApk;
    private String packageName;
    private String version;

    public String getAppName() {
        return this.appName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isInstallApk() {
        return this.isInstallPlun;
    }

    public boolean isNewApk() {
        return this.isNewApk;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setInstallApk(boolean z5) {
        this.isInstallPlun = z5;
    }

    public void setNewApk(boolean z5) {
        this.isNewApk = z5;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
