package xyz.adscope.amps.model.config.response;

import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.model.inter.IDeepCopyModel;
import xyz.adscope.common.json.util.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AdSourceModel implements IDeepCopyModel<AdSourceModel> {
    private String accountId;
    private int adComparePriceStatus;
    private int adStatus;
    private String adType;
    private String adapterClass;
    private String adapterManagerClass;
    private int adsTimeout;
    private String appId;
    private AuctionStrategyModel auctionStrategy;
    private int autoRefreshSwitch;
    private String bidSeatId;
    private String bidSpaceId;
    private long biddingStartTime;
    private int biddingTimeout;
    private String biddingType;
    private int cachedOffersTimeout;
    private String customData;
    private long durationTime;
    private int ecpm;
    private int endWeight;
    private String errorCode;
    private String errorMsg;
    private FilterModel filter;
    private int floorEcpm;
    private boolean isCache;
    private int isFloor;
    private boolean isHitWeight;
    private int isSendBidData;
    private List<AdSourceNoticeRuleModel> lossNoticeRule;
    private String lossReason;
    private String noticePrice;
    private String orientation;
    private int priority;
    private String publicKey;
    private String realPrice;
    private String renderType;
    private int reportEcpm;
    private long requestStartTime;
    private String seatId;
    private String serverUrl;
    private String spaceId;
    private int startWeight;
    private List<Integer> templateTypes;
    private int videoAutoPlay;
    private int videoMaxTime;
    private int videoSound;
    private List<AdSourceNoticeRuleModel> winNoticeRule;
    private String zoomout;

    public AdSourceModel() {
        this.appId = "";
        this.spaceId = "";
        this.adType = "";
        this.seatId = "";
        this.adapterManagerClass = "";
        this.adapterClass = "";
        this.biddingType = "";
        this.renderType = "";
        this.orientation = "";
        this.zoomout = "";
        this.errorCode = "";
        this.errorMsg = "";
        this.customData = "";
        this.durationTime = 0L;
    }

    public String toString() {
        return "{\"appId\":\"" + this.appId + "\", \"spaceId\":\"" + this.spaceId + "\", \"adType\":\"" + this.adType + "\", \"seatId\":\"" + this.seatId + "\", \"adapterManagerClass\":\"" + this.adapterManagerClass + "\", \"adapterClass\":\"" + this.adapterClass + "\", \"biddingType\":\"" + this.biddingType + "\", \"renderType\":\"" + this.renderType + "\", \"ecpm\":" + this.ecpm + ", \"floorEcpm\":" + this.floorEcpm + ", \"isFloor\":" + this.isFloor + ", \"priority\":" + this.priority + ", \"adsTimeout\":" + this.adsTimeout + ", \"biddingTimeout\":" + this.biddingTimeout + ", \"cachedOffersTimeout\":" + this.cachedOffersTimeout + ", \"autoRefreshSwitch\":" + this.autoRefreshSwitch + ", \"orientation\":\"" + this.orientation + "\", \"zoomout\":\"" + this.zoomout + "\", \"videoSound\":" + this.videoSound + ", \"videoMaxTime\":" + this.videoMaxTime + ", \"videoAutoPlay\":" + this.videoAutoPlay + ", \"filter\":" + this.filter + ", \"startWeight\":" + this.startWeight + ", \"endWeight\":" + this.endWeight + ", \"templateTypes\":" + this.templateTypes + ", \"adStatus\":" + this.adStatus + ", \"isCache\":" + this.isCache + ", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"errorCode\":\"" + this.errorCode + "\", \"errorMsg\":\"" + this.errorMsg + "\", \"isSendBidData\":" + this.isSendBidData + ", \"auctionStrategy\":" + this.auctionStrategy + ", \"accountId\":\"" + this.accountId + "\", \"serverUrl\":\"" + this.serverUrl + "\", \"publicKey\":\"" + this.publicKey + "\", \"winNoticeRule\":" + this.winNoticeRule + ", \"lossNoticeRule\":" + this.lossNoticeRule + ", \"noticePrice\":\"" + this.noticePrice + "\", \"lossReason\":\"" + this.lossReason + "\", \"realPrice\":\"" + this.realPrice + "\", \"bidSeatId\":\"" + this.bidSeatId + "\", \"bidSpaceId\":\"" + this.bidSpaceId + "\"}";
    }

    private List<AdSourceNoticeRuleModel> deepCopyAdSourceNoticeRuleList(List<AdSourceNoticeRuleModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AdSourceNoticeRuleModel adSourceNoticeRuleModel : list) {
            if (adSourceNoticeRuleModel != null) {
                arrayList.add(adSourceNoticeRuleModel.deepCopy());
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.model.inter.IDeepCopyModel
    public AdSourceModel deepCopy() {
        return new AdSourceModel(this);
    }

    public String getAccountId() {
        return this.accountId;
    }

    public int getAdComparePriceStatus() {
        return this.adComparePriceStatus;
    }

    public int getAdStatus() {
        return this.adStatus;
    }

    public String getAdType() {
        return this.adType;
    }

    public String getAdapterClass() {
        return this.adapterClass;
    }

    public String getAdapterManagerClass() {
        return this.adapterManagerClass;
    }

    public int getAdsTimeout() {
        return this.adsTimeout;
    }

    public String getAppId() {
        return this.appId;
    }

    public AuctionStrategyModel getAuctionStrategy() {
        return this.auctionStrategy;
    }

    public int getAutoRefreshSwitch() {
        return this.autoRefreshSwitch;
    }

    public String getBidSeatId() {
        return this.bidSeatId;
    }

    public String getBidSpaceId() {
        return this.bidSpaceId;
    }

    public long getBiddingStartTime() {
        return this.biddingStartTime;
    }

    public int getBiddingTimeout() {
        return this.biddingTimeout;
    }

    public String getBiddingType() {
        return this.biddingType;
    }

    public int getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public String getCustomData() {
        return this.customData;
    }

    public long getDurationTime() {
        return this.durationTime;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public int getEndWeight() {
        return this.endWeight;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public FilterModel getFilter() {
        return this.filter;
    }

    public int getFloorEcpm() {
        return this.floorEcpm;
    }

    public int getIsFloor() {
        return this.isFloor;
    }

    public int getIsSendBidData() {
        return this.isSendBidData;
    }

    public List<AdSourceNoticeRuleModel> getLossNoticeRule() {
        return this.lossNoticeRule;
    }

    public String getLossReason() {
        return this.lossReason;
    }

    public String getNoticePrice() {
        return this.noticePrice;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getRealPrice() {
        return this.realPrice;
    }

    public String getRenderType() {
        return this.renderType;
    }

    public int getReportEcpm() {
        return this.reportEcpm;
    }

    public long getRequestStartTime() {
        return this.requestStartTime;
    }

    public String getSeatId() {
        return this.seatId;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getStartWeight() {
        return this.startWeight;
    }

    public List<Integer> getTemplateTypes() {
        return this.templateTypes;
    }

    public int getVideoAutoPlay() {
        return this.videoAutoPlay;
    }

    public int getVideoMaxTime() {
        return this.videoMaxTime;
    }

    public int getVideoSound() {
        return this.videoSound;
    }

    public List<AdSourceNoticeRuleModel> getWinNoticeRule() {
        return this.winNoticeRule;
    }

    public String getZoomout() {
        return this.zoomout;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public boolean isHitWeight() {
        return this.isHitWeight;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAdComparePriceStatus(int i6) {
        this.adComparePriceStatus = i6;
    }

    public void setAdStatus(int i6) {
        this.adStatus = i6;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAdapterClass(String str) {
        this.adapterClass = str;
    }

    public void setAdapterManagerClass(String str) {
        this.adapterManagerClass = str;
    }

    public void setAdsTimeout(int i6) {
        this.adsTimeout = i6;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAuctionStrategy(AuctionStrategyModel auctionStrategyModel) {
        this.auctionStrategy = auctionStrategyModel;
    }

    public void setAutoRefreshSwitch(int i6) {
        this.autoRefreshSwitch = i6;
    }

    public void setBidSeatId(String str) {
        this.bidSeatId = str;
    }

    public void setBidSpaceId(String str) {
        this.bidSpaceId = str;
    }

    public void setBiddingStartTime(long j6) {
        this.biddingStartTime = j6;
    }

    public void setBiddingTimeout(int i6) {
        this.biddingTimeout = i6;
    }

    public void setBiddingType(String str) {
        this.biddingType = str;
    }

    public void setCache(boolean z5) {
        this.isCache = z5;
    }

    public void setCachedOffersTimeout(int i6) {
        this.cachedOffersTimeout = i6;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setDurationTime(long j6) {
        this.durationTime = j6;
    }

    public void setEcpm(int i6) {
        this.ecpm = i6;
    }

    public void setEndWeight(int i6) {
        this.endWeight = i6;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setFilter(FilterModel filterModel) {
        this.filter = filterModel;
    }

    public void setFloorEcpm(int i6) {
        this.floorEcpm = i6;
    }

    public void setHitWeight(boolean z5) {
        this.isHitWeight = z5;
    }

    public void setIsFloor(int i6) {
        this.isFloor = i6;
    }

    public void setIsSendBidData(int i6) {
        this.isSendBidData = i6;
    }

    public void setLossNoticeRule(List<AdSourceNoticeRuleModel> list) {
        this.lossNoticeRule = list;
    }

    public void setLossReason(String str) {
        this.lossReason = str;
    }

    public void setNoticePrice(String str) {
        this.noticePrice = str;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setPriority(int i6) {
        this.priority = i6;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public void setRealPrice(String str) {
        this.realPrice = str;
    }

    public void setRenderType(String str) {
        this.renderType = str;
    }

    public void setReportEcpm(int i6) {
        this.reportEcpm = i6;
    }

    public void setRequestStartTime(long j6) {
        this.requestStartTime = j6;
    }

    public void setSeatId(String str) {
        this.seatId = str;
    }

    public void setServerUrl(String str) {
        this.serverUrl = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setStartWeight(int i6) {
        this.startWeight = i6;
    }

    public void setTemplateTypes(List<Integer> list) {
        this.templateTypes = list;
    }

    public void setVideoAutoPlay(int i6) {
        this.videoAutoPlay = i6;
    }

    public void setVideoMaxTime(int i6) {
        this.videoMaxTime = i6;
    }

    public void setVideoSound(int i6) {
        this.videoSound = i6;
    }

    public void setWinNoticeRule(List<AdSourceNoticeRuleModel> list) {
        this.winNoticeRule = list;
    }

    public void setZoomout(String str) {
        this.zoomout = str;
    }

    public AdSourceModel(AdSourceModel adSourceModel) {
        this.appId = "";
        this.spaceId = "";
        this.adType = "";
        this.seatId = "";
        this.adapterManagerClass = "";
        this.adapterClass = "";
        this.biddingType = "";
        this.renderType = "";
        this.orientation = "";
        this.zoomout = "";
        this.errorCode = "";
        this.errorMsg = "";
        this.customData = "";
        this.durationTime = 0L;
        this.appId = adSourceModel.getAppId();
        this.spaceId = adSourceModel.getSpaceId();
        this.adType = adSourceModel.getAdType();
        this.seatId = adSourceModel.getSeatId();
        this.adapterManagerClass = adSourceModel.getAdapterManagerClass();
        this.adapterClass = adSourceModel.getAdapterClass();
        this.biddingType = adSourceModel.getBiddingType();
        this.renderType = adSourceModel.getRenderType();
        this.ecpm = adSourceModel.getEcpm();
        this.floorEcpm = adSourceModel.getFloorEcpm();
        this.isFloor = adSourceModel.getIsFloor();
        this.priority = adSourceModel.getPriority();
        this.adsTimeout = adSourceModel.getAdsTimeout();
        this.biddingTimeout = adSourceModel.getBiddingTimeout();
        this.cachedOffersTimeout = adSourceModel.getCachedOffersTimeout();
        this.autoRefreshSwitch = adSourceModel.getAutoRefreshSwitch();
        this.orientation = adSourceModel.getOrientation();
        this.zoomout = adSourceModel.getZoomout();
        this.videoSound = adSourceModel.getVideoSound();
        this.videoMaxTime = adSourceModel.getVideoMaxTime();
        this.videoAutoPlay = adSourceModel.getVideoAutoPlay();
        FilterModel filter = adSourceModel.getFilter();
        if (filter != null) {
            this.filter = filter.deepCopy();
        }
        this.startWeight = adSourceModel.getStartWeight();
        this.endWeight = adSourceModel.getEndWeight();
        this.templateTypes = adSourceModel.getTemplateTypes();
        this.adStatus = adSourceModel.getAdStatus();
        this.adComparePriceStatus = adSourceModel.getAdComparePriceStatus();
        this.isCache = adSourceModel.isCache();
        this.errorCode = adSourceModel.getErrorCode();
        this.errorMsg = adSourceModel.getErrorMsg();
        this.customData = adSourceModel.getCustomData();
        this.durationTime = adSourceModel.getDurationTime();
        this.isSendBidData = adSourceModel.getIsSendBidData();
        this.biddingStartTime = adSourceModel.getBiddingStartTime();
        this.requestStartTime = adSourceModel.getRequestStartTime();
        this.isHitWeight = adSourceModel.isHitWeight();
        this.reportEcpm = adSourceModel.getReportEcpm();
        AuctionStrategyModel auctionStrategy = adSourceModel.getAuctionStrategy();
        if (auctionStrategy != null) {
            this.auctionStrategy = auctionStrategy.deepCopy();
        }
        this.accountId = adSourceModel.getAccountId();
        this.serverUrl = adSourceModel.getServerUrl();
        this.publicKey = adSourceModel.getPublicKey();
        this.winNoticeRule = deepCopyAdSourceNoticeRuleList(adSourceModel.getWinNoticeRule());
        this.lossNoticeRule = deepCopyAdSourceNoticeRuleList(adSourceModel.getLossNoticeRule());
        this.noticePrice = adSourceModel.getNoticePrice();
        this.lossReason = adSourceModel.getLossReason();
        this.realPrice = adSourceModel.getRealPrice();
        this.bidSeatId = adSourceModel.getBidSeatId();
        this.bidSpaceId = adSourceModel.getBidSpaceId();
    }
}
