package xyz.adscope.amps.model.preload;

import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSPreloadManagerInfo {
    private AMPSBaseOpenApiManager baseOpenApiManager;
    private long cachedOffersTimeout;
    private long cachedTime;
    private String spaceId;

    public AMPSBaseOpenApiManager getBaseOpenApiManager() {
        return this.baseOpenApiManager;
    }

    public long getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public long getCachedTime() {
        return this.cachedTime;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setBaseOpenApiManager(AMPSBaseOpenApiManager aMPSBaseOpenApiManager) {
        this.baseOpenApiManager = aMPSBaseOpenApiManager;
    }

    public void setCachedOffersTimeout(long j6) {
        this.cachedOffersTimeout = j6;
    }

    public void setCachedTime(long j6) {
        this.cachedTime = j6;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
