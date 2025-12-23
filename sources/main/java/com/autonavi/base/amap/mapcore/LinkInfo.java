package com.autonavi.base.amap.mapcore;

import com.huawei.hms.common.util.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LinkInfo {
    private int state = 0;
    private int time = 0;
    private int length = 0;

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int i6) {
        this.length = i6;
    }

    public void setState(int i6) {
        this.state = i6;
    }

    public void setTime(int i6) {
        this.time = i6;
    }

    public String toString() {
        return "状态：" + this.state + Logger.f33116c + "时间：" + this.time + Logger.f33116c + "长度：" + this.length;
    }
}
