package com.acse.ottn.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ShowWindowModel {
    private String appName = "";
    private String showBigWindowData = "";
    private int showSmailWindowSize = 0;
    private long shawWindowTime = 0;

    public String getAppName() {
        return this.appName;
    }

    public long getShawWindowTime() {
        return this.shawWindowTime;
    }

    public String getShowBigWindowData() {
        return this.showBigWindowData;
    }

    public int getShowSmailWindowSize() {
        return this.showSmailWindowSize;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setShawWindowTime(long j6) {
        this.shawWindowTime = j6;
    }

    public void setShowBigWindowData(String str) {
        this.showBigWindowData = str;
    }

    public void setShowSmailWindowSize(int i6) {
        this.showSmailWindowSize = i6;
    }

    public String toString() {
        return "ShowWindowModel{appName='" + this.appName + "', showBigWindowData='" + this.showBigWindowData + "', showSmailWindowSize=" + this.showSmailWindowSize + ", shawWindowTime=" + this.shawWindowTime + '}';
    }
}
