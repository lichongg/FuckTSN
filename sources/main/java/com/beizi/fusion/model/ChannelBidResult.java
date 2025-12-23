package com.beizi.fusion.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ChannelBidResult {
    private String bidType;
    private String channelName;
    private double ecpm;
    private int reason;

    public String getBidType() {
        return this.bidType;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public double getEcpm() {
        return this.ecpm;
    }

    public int getReason() {
        return this.reason;
    }

    public void setBidType(String str) {
        this.bidType = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setEcpm(double d6) {
        this.ecpm = d6;
    }

    public void setReason(int i6) {
        this.reason = i6;
    }

    public String toString() {
        return "ChannelBidResult{ecpm=" + this.ecpm + ", channelName='" + this.channelName + "', bidType='" + this.bidType + "', reason=" + this.reason + '}';
    }
}
