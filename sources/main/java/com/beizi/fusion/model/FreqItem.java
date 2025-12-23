package com.beizi.fusion.model;

import androidx.annotation.NonNull;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FreqItem {

    @JsonNode(key = "componentType")
    private int componentType;

    @JsonNode(key = "eventCode")
    private String eventCode;

    @JsonNode(key = bi.aX)
    private long interval = Long.MAX_VALUE;

    @JsonNode(key = "count")
    private int count = Integer.MAX_VALUE;

    public int getComponentType() {
        return this.componentType;
    }

    public int getCount() {
        return this.count;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public long getInterval() {
        return this.interval;
    }

    public void setComponentType(int i6) {
        this.componentType = i6;
    }

    public void setCount(int i6) {
        this.count = i6;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setInterval(long j6) {
        this.interval = j6;
    }

    @NonNull
    public String toString() {
        return "FreqItem{interval=" + this.interval + ", count=" + this.count + ", eventCode='" + this.eventCode + "', componentType=" + this.componentType + '}';
    }
}
