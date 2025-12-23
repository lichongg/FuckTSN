package xyz.adscope.amps.model.cache;

import xyz.adscope.amps.base.AMPSBaseAdapter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSAdSourceCacheInfo {
    private String appId;
    private AMPSBaseAdapter baseAdapter;
    private long cachedOffersTimeout;
    private long cachedTime;
    private int ecpm;
    private String spaceId;

    public String getAppId() {
        return this.appId;
    }

    public AMPSBaseAdapter getBaseAdapter() {
        return this.baseAdapter;
    }

    public long getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public long getCachedTime() {
        return this.cachedTime;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBaseAdapter(AMPSBaseAdapter aMPSBaseAdapter) {
        this.baseAdapter = aMPSBaseAdapter;
    }

    public void setCachedOffersTimeout(long j6) {
        this.cachedOffersTimeout = j6;
    }

    public void setCachedTime(long j6) {
        this.cachedTime = j6;
    }

    public void setEcpm(int i6) {
        this.ecpm = i6;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public String toString() {
        return "AMPSAdSourceCacheInfo{appId='" + this.appId + "', spaceId='" + this.spaceId + "', ecpm=" + this.ecpm + ", baseAdapter=" + this.baseAdapter + ", cachedTime=" + this.cachedTime + ", cachedOffersTimeout=" + this.cachedOffersTimeout + '}';
    }
}
