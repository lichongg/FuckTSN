package xyz.adscope.amps.control.bid;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.AuctionStrategyModel;
import xyz.adscope.amps.model.config.response.SortAdSourceModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSPriceComparator implements IPriceComparatorInterface {
    private int mAdRequestType;
    private List<AdSourceModel> mC2SAdSourceList;
    private Map<String, AdSourceModel> mRequestAdSourceDatas;
    private List<AdSourceModel> mS2SAdSourceList;
    private int mWeightRandomNum;
    private AdSourceModel mCandidateAdSourceModel = null;
    private AdSourceModel mWinAdSourceModel = null;

    private int getBiddingSuccessCompareResult(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return 4;
        }
        AdSourceModel adSourceModel2 = this.mCandidateAdSourceModel;
        return (adSourceModel2 == null || isSameAdSource(adSourceModel, getComparePriceWinAdSource(adSourceModel2, adSourceModel))) ? 2 : 4;
    }

    private int getCycleQueueCompareResult(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return 4;
        }
        for (AdSourceModel adSourceModel2 : this.mRequestAdSourceDatas.values()) {
            if (adSourceModel2 != null && !isSameAdSource(adSourceModel2, adSourceModel)) {
                if (adSourceModel2.getAdStatus() == 5) {
                    if (!isSameAdSource(getComparePriceWinAdSource(adSourceModel, adSourceModel2), adSourceModel)) {
                        return 4;
                    }
                } else if (adSourceModel2.getAdStatus() > 0 && adSourceModel2.getAdStatus() <= 4 && (adSourceModel2.getEcpm() != adSourceModel.getEcpm() || (!adSourceModel.isHitWeight() && adSourceModel2.isHitWeight()))) {
                    if (this.mAdRequestType != 1 || adSourceModel2.getEcpm() >= adSourceModel.getEcpm()) {
                        if (this.mAdRequestType != 2 || !isBidFinish() || adSourceModel2.getEcpm() >= adSourceModel.getEcpm()) {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice wait channel:" + adSourceModel2.getSeatId() + ",spaceId:" + adSourceModel2.getSpaceId() + ",adStatus:" + adSourceModel2.getAdStatus());
                            return 1;
                        }
                    }
                }
            }
        }
        int i6 = this.mAdRequestType;
        if ((i6 == 0 || i6 == 2) && !isBidFinish()) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice wait bidding not finish:");
            return 1;
        }
        this.mWinAdSourceModel = adSourceModel;
        return 3;
    }

    private boolean isSameAdSource(AdSourceModel adSourceModel, AdSourceModel adSourceModel2) {
        if (adSourceModel != null && adSourceModel2 != null) {
            String spaceId = adSourceModel.getSpaceId();
            String spaceId2 = adSourceModel2.getSpaceId();
            if (!TextUtils.isEmpty(spaceId) && !TextUtils.isEmpty(spaceId2) && spaceId.equalsIgnoreCase(spaceId2)) {
                return true;
            }
        }
        return false;
    }

    @Override // xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface
    public int getComparePriceResult(AdSourceModel adSourceModel) {
        Map<String, AdSourceModel> map;
        if (adSourceModel == null || (map = this.mRequestAdSourceDatas) == null || map.size() == 0 || this.mWinAdSourceModel != null) {
            return 4;
        }
        if (adSourceModel.getAdStatus() == 3) {
            handleBiddingRaisePrice(adSourceModel);
            return getBiddingSuccessCompareResult(adSourceModel);
        }
        if (adSourceModel.getAdStatus() != 5) {
            return 4;
        }
        AdSourceModel adSourceModel2 = this.mCandidateAdSourceModel;
        if (adSourceModel2 == null) {
            this.mCandidateAdSourceModel = adSourceModel;
            return getCycleQueueCompareResult(adSourceModel);
        }
        if (isSameAdSource(adSourceModel2, adSourceModel)) {
            return getCycleQueueCompareResult(this.mCandidateAdSourceModel);
        }
        AdSourceModel comparePriceWinAdSource = getComparePriceWinAdSource(this.mCandidateAdSourceModel, adSourceModel);
        if (isSameAdSource(comparePriceWinAdSource, this.mCandidateAdSourceModel)) {
            return 4;
        }
        this.mCandidateAdSourceModel = comparePriceWinAdSource;
        return getCycleQueueCompareResult(comparePriceWinAdSource);
    }

    private AdSourceModel getComparePriceWinAdSource(AdSourceModel adSourceModel, AdSourceModel adSourceModel2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SortAdSourceModel(adSourceModel, adSourceModel.getEcpm(), true));
        int secondPrice = getSecondPrice(adSourceModel);
        if (secondPrice > 0) {
            arrayList.add(new SortAdSourceModel(adSourceModel, secondPrice, true));
        }
        arrayList.add(new SortAdSourceModel(adSourceModel2, adSourceModel2.getEcpm(), false));
        int secondPrice2 = getSecondPrice(adSourceModel2);
        if (secondPrice2 > 0) {
            arrayList.add(new SortAdSourceModel(adSourceModel2, secondPrice2, false));
        }
        sortAdSourceModel(arrayList);
        if (arrayList.size() == 2) {
            return arrayList.get(0).getAdSourceModel();
        }
        if (arrayList.size() > 2) {
            adSourceModel = arrayList.get(0).getAdSourceModel();
            AdSourceModel adSourceModel3 = arrayList.get(1).getAdSourceModel();
            AdSourceModel adSourceModel4 = arrayList.get(2).getAdSourceModel();
            if (isSameAdSource(adSourceModel, adSourceModel3)) {
                int secondPrice3 = getSecondPrice(adSourceModel4);
                if (secondPrice3 > 0) {
                    modifyAdSourceAuctionStrategy(adSourceModel4, secondPrice3);
                    return adSourceModel;
                }
            } else {
                int secondPrice4 = getSecondPrice(adSourceModel);
                if (secondPrice4 > 0) {
                    modifyAdSourceAuctionStrategy(adSourceModel, secondPrice4);
                }
                int secondPrice5 = getSecondPrice(adSourceModel3);
                if (secondPrice5 > 0) {
                    modifyAdSourceAuctionStrategy(adSourceModel3, secondPrice5);
                }
            }
        }
        return adSourceModel;
    }

    private void handleBiddingRaisePrice(AdSourceModel adSourceModel) {
        AuctionStrategyModel auctionStrategy;
        if (adSourceModel == null || !isC2SOrS2SAdSource(adSourceModel.getBiddingType()) || (auctionStrategy = adSourceModel.getAuctionStrategy()) == null || auctionStrategy.isRaise() || !AMPSRandomUtil.isHitRandomNum(auctionStrategy.getEffectRate())) {
            return;
        }
        auctionStrategy.setHit(true);
        auctionStrategy.setRaise(true);
        int raiseSortPrice = auctionStrategy.getRaiseSortPrice();
        int ecpm = adSourceModel.getEcpm() + raiseSortPrice;
        adSourceModel.setEcpm(ecpm);
        auctionStrategy.setOriginEcpm(ecpm);
        if (auctionStrategy.getSecondPrice() > 0) {
            auctionStrategy.setSecondPrice(auctionStrategy.getSecondPrice() + raiseSortPrice);
        }
    }

    private boolean isC2SOrS2SAdSource(String str) {
        return AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(str) || AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(str);
    }

    private boolean isExistC2SOrS2SAdSource() {
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list != null && list.size() != 0) {
            return true;
        }
        List<AdSourceModel> list2 = this.mS2SAdSourceList;
        return (list2 == null || list2.size() == 0) ? false : true;
    }

    private void modifyAdSourceAuctionStrategy(AdSourceModel adSourceModel, int i6) {
        if (adSourceModel == null || i6 <= 0) {
            return;
        }
        adSourceModel.setEcpm(i6);
        AuctionStrategyModel auctionStrategy = adSourceModel.getAuctionStrategy();
        if (auctionStrategy != null) {
            auctionStrategy.setUseLastLook(true);
            auctionStrategy.setOriginEcpm(i6);
        }
    }

    private void sortAdSourceModel(List<SortAdSourceModel> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(list, new Comparator<SortAdSourceModel>() { // from class: xyz.adscope.amps.control.bid.AMPSPriceComparator.1
            @Override // java.util.Comparator
            public int compare(SortAdSourceModel sortAdSourceModel, SortAdSourceModel sortAdSourceModel2) {
                try {
                    if (sortAdSourceModel.getEcpm() > sortAdSourceModel2.getEcpm()) {
                        return -1;
                    }
                    if (sortAdSourceModel.getEcpm() != sortAdSourceModel2.getEcpm()) {
                        return 1;
                    }
                    if (sortAdSourceModel.isHitWeight() && sortAdSourceModel2.isHitWeight()) {
                        return sortAdSourceModel.isCandidate() ? -1 : 1;
                    }
                    if (sortAdSourceModel.isHitWeight()) {
                        return -1;
                    }
                    return sortAdSourceModel.isHitWeight() ? 1 : 0;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return -1;
                }
            }
        });
    }

    @Override // xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface
    public void comparePriceTimeout() {
        AdSourceModel adSourceModel;
        if (this.mWinAdSourceModel == null && (adSourceModel = this.mCandidateAdSourceModel) != null) {
            this.mWinAdSourceModel = adSourceModel;
        }
    }

    @Override // xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface
    public AdSourceModel getWinAdSourceModel() {
        AdSourceModel adSourceModel = this.mWinAdSourceModel;
        if (adSourceModel != null) {
            return adSourceModel;
        }
        AdSourceModel adSourceModel2 = this.mCandidateAdSourceModel;
        if (adSourceModel2 != null && getCycleQueueCompareResult(adSourceModel2) == 3) {
            return this.mWinAdSourceModel;
        }
        return null;
    }

    public AMPSPriceComparator(SpaceModel spaceModel, Map<String, AdSourceModel> map) {
        this.mWeightRandomNum = 0;
        this.mS2SAdSourceList = null;
        this.mC2SAdSourceList = null;
        this.mAdRequestType = 0;
        if (spaceModel == null) {
            return;
        }
        this.mWeightRandomNum = spaceModel.getWeightRandomNum();
        this.mS2SAdSourceList = spaceModel.getS2sAdSourceList();
        this.mC2SAdSourceList = spaceModel.getC2sAdSourceList();
        this.mRequestAdSourceDatas = map;
        this.mAdRequestType = spaceModel.getBidDistributionMethod();
    }

    private int getSecondPrice(AdSourceModel adSourceModel) {
        AuctionStrategyModel auctionStrategy;
        int secondPrice;
        if (!isC2SOrS2SAdSource(adSourceModel.getBiddingType()) || (auctionStrategy = adSourceModel.getAuctionStrategy()) == null || !auctionStrategy.isHit() || auctionStrategy.getIsLastLook() != 1 || (secondPrice = auctionStrategy.getSecondPrice()) <= 0 || secondPrice <= adSourceModel.getEcpm()) {
            return 0;
        }
        return secondPrice;
    }

    private boolean isBidFinish() {
        if (!isExistC2SOrS2SAdSource()) {
            return true;
        }
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mC2SAdSourceList) {
                if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() <= 2) {
                    return false;
                }
            }
        }
        List<AdSourceModel> list2 = this.mS2SAdSourceList;
        if (list2 != null && list2.size() > 0) {
            for (AdSourceModel adSourceModel2 : this.mS2SAdSourceList) {
                if (adSourceModel2 != null && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(adSourceModel2.getBiddingType()) && adSourceModel2.getAdStatus() <= 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
