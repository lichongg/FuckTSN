package xyz.adscope.amps.base;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSBidResult {
    private String bidType;
    private String channelName;
    private int ecpm;
    private int reason;
    private int winPrice;

    public String getBidType() {
        return this.bidType;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public int getReason() {
        return this.reason;
    }

    public int getWinPrice() {
        return this.winPrice;
    }

    public void setBidType(String str) {
        this.bidType = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setEcpm(int i6) {
        this.ecpm = i6;
    }

    public void setReason(int i6) {
        this.reason = i6;
    }

    public void setWinPrice(int i6) {
        this.winPrice = i6;
    }
}
