package xyz.adscope.amps.model.config.response;

import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.model.inter.IDeepCopyModel;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;
import xyz.adscope.common.json.util.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SpaceModel implements IDeepCopyModel<SpaceModel> {
    private int adFloorEcpm;
    private long adTimeout;
    private String adType;
    private long adsTimeout;
    private int autoRefreshSwitch;
    private int autoRefreshTime;
    private long bidAdTimeout;
    private int bidDistributionMethod;
    private int bidFloorEcpm;
    private int bidParallelNum;
    private List<AdSourceModel> c2sAdSourceList;
    private int cachedOffersNum;
    private int cachedOffersTimeout;
    private String customData;
    private String ext;
    private FilterModel filter;
    private List<AdSourceModel> floorAdSourceList;
    private int floorDelayTime;
    private List<AdSourceModel> s2sAdSourceList;
    private String spaceId;
    private int waterfallParallelNum;
    private int weightRandomNum;
    private List<AdSourceModel> wfAdSourceList;

    public SpaceModel() {
        this.customData = "";
    }

    private List<AdSourceModel> deepCopyAdSourceList(List<AdSourceModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AdSourceModel adSourceModel : list) {
            if (adSourceModel != null) {
                arrayList.add(adSourceModel.deepCopy());
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.model.inter.IDeepCopyModel
    public SpaceModel deepCopy() {
        return new SpaceModel(this);
    }

    public int getAdFloorEcpm() {
        return this.adFloorEcpm;
    }

    public long getAdTimeout() {
        return this.adTimeout;
    }

    public String getAdType() {
        return this.adType;
    }

    public long getAdsTimeout() {
        return this.adsTimeout;
    }

    public int getAutoRefreshSwitch() {
        return this.autoRefreshSwitch;
    }

    public int getAutoRefreshTime() {
        return this.autoRefreshTime;
    }

    public long getBidAdTimeout() {
        return this.bidAdTimeout;
    }

    public int getBidDistributionMethod() {
        return this.bidDistributionMethod;
    }

    public int getBidFloorEcpm() {
        return this.bidFloorEcpm;
    }

    public int getBidParallelNum() {
        return this.bidParallelNum;
    }

    public List<AdSourceModel> getC2sAdSourceList() {
        return this.c2sAdSourceList;
    }

    public int getCachedOffersNum() {
        return this.cachedOffersNum;
    }

    public int getCachedOffersTimeout() {
        return this.cachedOffersTimeout;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getExt() {
        return this.ext;
    }

    public FilterModel getFilter() {
        return this.filter;
    }

    public List<AdSourceModel> getFloorAdSourceList() {
        return this.floorAdSourceList;
    }

    public int getFloorDelayTime() {
        return this.floorDelayTime;
    }

    public List<AdSourceModel> getS2sAdSourceList() {
        return this.s2sAdSourceList;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getWaterfallParallelNum() {
        return this.waterfallParallelNum;
    }

    public int getWeightRandomNum() {
        return this.weightRandomNum;
    }

    public List<AdSourceModel> getWfAdSourceList() {
        return this.wfAdSourceList;
    }

    public void setAdFloorEcpm(int i6) {
        this.adFloorEcpm = i6;
    }

    public void setAdTimeout(long j6) {
        this.adTimeout = j6;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAdsTimeout(long j6) {
        this.adsTimeout = j6;
    }

    public void setAutoRefreshSwitch(int i6) {
        this.autoRefreshSwitch = i6;
    }

    public void setAutoRefreshTime(int i6) {
        this.autoRefreshTime = i6;
    }

    public void setBidAdTimeout(long j6) {
        this.bidAdTimeout = j6;
    }

    public void setBidDistributionMethod(int i6) {
        this.bidDistributionMethod = i6;
    }

    public void setBidFloorEcpm(int i6) {
        this.bidFloorEcpm = i6;
    }

    public void setBidParallelNum(int i6) {
        this.bidParallelNum = i6;
    }

    public void setC2sAdSourceList(List<AdSourceModel> list) {
        this.c2sAdSourceList = list;
    }

    public void setCachedOffersNum(int i6) {
        this.cachedOffersNum = i6;
    }

    public void setCachedOffersTimeout(int i6) {
        this.cachedOffersTimeout = i6;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setFilter(FilterModel filterModel) {
        this.filter = filterModel;
    }

    public void setFloorAdSourceList(List<AdSourceModel> list) {
        this.floorAdSourceList = list;
    }

    public void setFloorDelayTime(int i6) {
        this.floorDelayTime = i6;
    }

    public void setS2sAdSourceList(List<AdSourceModel> list) {
        this.s2sAdSourceList = list;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setWaterfallParallelNum(int i6) {
        this.waterfallParallelNum = i6;
    }

    public void setWeightRandomNum(int i6) {
        this.weightRandomNum = i6;
    }

    public void setWfAdSourceList(List<AdSourceModel> list) {
        this.wfAdSourceList = list;
    }

    public String toString() {
        return "{\"spaceId\":\"" + this.spaceId + "\", \"bidDistributionMethod\":" + this.bidDistributionMethod + ", \"adType\":\"" + this.adType + "\", \"waterfallParallelNum\":" + this.waterfallParallelNum + ", \"adTimeout\":" + this.adTimeout + ", \"adsTimeout\":" + this.adsTimeout + ", \"bidAdTimeout\":" + this.bidAdTimeout + ", \"bidParallelNum\":" + this.bidParallelNum + ", \"adFloorEcpm\":" + this.adFloorEcpm + ", \"bidFloorEcpm\":" + this.bidFloorEcpm + ", \"cachedOffersNum\":" + this.cachedOffersNum + ", \"cachedOffersTimeout\":" + this.cachedOffersTimeout + ", \"autoRefreshSwitch\":" + this.autoRefreshSwitch + ", \"autoRefreshTime\":" + this.autoRefreshTime + ", \"floorDelayTime\":" + this.floorDelayTime + ", \"s2sAdSourceList\":" + this.s2sAdSourceList + ", \"c2sAdSourceList\":" + this.c2sAdSourceList + ", \"wfAdSourceList\":" + this.wfAdSourceList + ", \"floorAdSourceList\":" + this.floorAdSourceList + ", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"filter\":" + this.filter + ", \"ext\":\"" + this.ext + "\"}";
    }

    private SpaceModel(SpaceModel spaceModel) {
        this.customData = "";
        this.spaceId = spaceModel.getSpaceId();
        this.bidDistributionMethod = spaceModel.getBidDistributionMethod();
        this.adType = spaceModel.getAdType();
        this.waterfallParallelNum = spaceModel.getWaterfallParallelNum();
        this.adTimeout = spaceModel.getAdTimeout();
        this.adsTimeout = spaceModel.getAdsTimeout();
        this.bidAdTimeout = spaceModel.getBidAdTimeout();
        this.bidParallelNum = spaceModel.getBidParallelNum();
        this.adFloorEcpm = spaceModel.getAdFloorEcpm();
        this.bidFloorEcpm = spaceModel.getBidFloorEcpm();
        this.cachedOffersNum = spaceModel.getCachedOffersNum();
        this.cachedOffersTimeout = spaceModel.getCachedOffersTimeout();
        this.autoRefreshSwitch = spaceModel.getAutoRefreshSwitch();
        this.autoRefreshTime = spaceModel.getAutoRefreshTime();
        this.floorDelayTime = spaceModel.getFloorDelayTime();
        this.s2sAdSourceList = deepCopyAdSourceList(spaceModel.getS2sAdSourceList());
        this.c2sAdSourceList = deepCopyAdSourceList(spaceModel.getC2sAdSourceList());
        this.wfAdSourceList = deepCopyAdSourceList(spaceModel.getWfAdSourceList());
        this.floorAdSourceList = deepCopyAdSourceList(spaceModel.getFloorAdSourceList());
        FilterModel filter = spaceModel.getFilter();
        if (filter != null) {
            this.filter = filter.deepCopy();
        }
        this.ext = spaceModel.getExt();
        this.weightRandomNum = AMPSRandomUtil.getRandomNum(1000);
        this.customData = spaceModel.getCustomData();
    }
}
