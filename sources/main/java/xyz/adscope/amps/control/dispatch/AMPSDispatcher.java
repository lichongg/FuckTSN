package xyz.adscope.amps.control.dispatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.AuctionStrategyModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.tool.AMPSListUtil;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSDispatcher implements IDispatcherInterface {
    private int mAdRequestType;
    private List<AdSourceModel> mC2SAdSourceList;
    private int mC2SMaxRequestNum;
    private int mCurrentHighestPrice;
    private List<AdSourceModel> mS2SAdSourceList;
    private LinkedList<AdSourceModel> mSamePriceAdSourceData;
    private List<AdSourceModel> mWFAdSourceList;
    private int mWFMaxRequestNum;
    private int mWeightRandomNum;
    private List<AdSourceModel> mWFSortAdSourceList = new ArrayList();
    private boolean isFirstDispatch = true;
    private boolean isDispatchWFSort = false;

    private boolean isHigherThanHasSuccessResultC2SOrS2S(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return false;
        }
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel2 : this.mC2SAdSourceList) {
                if (adSourceModel2 != null && AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel2.getBiddingType()) && adSourceModel2.getAdStatus() == 5 && adSourceModel2.getEcpm() >= adSourceModel.getEcpm()) {
                    return false;
                }
            }
        }
        List<AdSourceModel> list2 = this.mS2SAdSourceList;
        if (list2 == null || list2.size() <= 0) {
            return true;
        }
        for (AdSourceModel adSourceModel3 : this.mS2SAdSourceList) {
            if (adSourceModel3 != null && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(adSourceModel3.getBiddingType()) && adSourceModel3.getAdStatus() == 5 && adSourceModel3.getEcpm() > adSourceModel.getEcpm()) {
                return false;
            }
        }
        return true;
    }

    private boolean judgeIsContinueDispatchSamePriceAdSource(AdSourceModel adSourceModel) {
        if (adSourceModel == null || this.mWFAdSourceList == null) {
            return false;
        }
        int ecpm = adSourceModel.getEcpm();
        for (AdSourceModel adSourceModel2 : this.mWFAdSourceList) {
            if (ecpm == adSourceModel2.getEcpm() && adSourceModel2.getAdStatus() != 6) {
                return false;
            }
        }
        return true;
    }

    private List<AdSourceModel> dispatchAd(AdSourceModel adSourceModel) {
        List<AdSourceModel> waitSamePriceAdSourceList;
        if (!this.isFirstDispatch && adSourceModel == null) {
            return null;
        }
        this.isFirstDispatch = false;
        int i6 = this.mAdRequestType;
        if (i6 == 2) {
            if (adSourceModel == null) {
                ArrayList arrayList = new ArrayList();
                AMPSListUtil.addDataToList((List) arrayList, (List) getWaitDispatchC2SOrS2SAdSourceList());
                List<AdSourceModel> waitSamePriceAdSourceList2 = getWaitSamePriceAdSourceList();
                if (waitSamePriceAdSourceList2 != null) {
                    Iterator<AdSourceModel> it = waitSamePriceAdSourceList2.iterator();
                    while (it.hasNext()) {
                        it.next().setAdStatus(1);
                    }
                }
                AMPSListUtil.addDataToList((List) arrayList, (List) waitSamePriceAdSourceList2);
                return arrayList;
            }
            if (isC2SOrS2SAdSource(adSourceModel.getBiddingType())) {
                ArrayList arrayList2 = new ArrayList();
                AMPSListUtil.addDataToList(arrayList2, getOneWaitDispatchC2SOrS2SAdSource());
                return arrayList2;
            }
            if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 6 && !isExistHasSuccessResultWF() && judgeIsContinueDispatchSamePriceAdSource(adSourceModel) && (waitSamePriceAdSourceList = getWaitSamePriceAdSourceList()) != null && isHigherThanHasSuccessResultC2SOrS2S(waitSamePriceAdSourceList.get(0))) {
                return waitSamePriceAdSourceList;
            }
            return null;
        }
        if (adSourceModel == null) {
            ArrayList arrayList3 = new ArrayList();
            AMPSListUtil.addDataToList((List) arrayList3, (List) getWaitDispatchC2SOrS2SAdSourceList());
            int i7 = this.mAdRequestType;
            if (i7 != 0 && (i7 != 1 || isExistC2SOrS2SAdSource())) {
                return arrayList3;
            }
            AMPSListUtil.addDataToList((List) arrayList3, (List) getWaitDispatchWFAdSourceList());
            return arrayList3;
        }
        if (i6 == 0) {
            if (isC2SOrS2SAdSource(adSourceModel.getBiddingType())) {
                ArrayList arrayList4 = new ArrayList();
                AMPSListUtil.addDataToList(arrayList4, getOneWaitDispatchC2SOrS2SAdSource());
                return arrayList4;
            }
            if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 6 && !isExistHasSuccessResultWF()) {
                AdSourceModel oneWaitDispatchWFAdSource = getOneWaitDispatchWFAdSource();
                if (isHigherThanHasSuccessResultC2SOrS2S(oneWaitDispatchWFAdSource)) {
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.add(oneWaitDispatchWFAdSource);
                    return arrayList5;
                }
            }
            return null;
        }
        if (i6 != 1) {
            return null;
        }
        if (adSourceModel.getAdStatus() == 3) {
            this.mWFSortAdSourceList.add(adSourceModel);
            sortAdSourceListByEcpm(this.mWFSortAdSourceList);
        }
        if (adSourceModel.getAdStatus() == 5) {
            return null;
        }
        if (!isBidFinish()) {
            if (!isC2SOrS2SAdSource(adSourceModel.getBiddingType())) {
                return null;
            }
            ArrayList arrayList6 = new ArrayList();
            AMPSListUtil.addDataToList(arrayList6, getOneWaitDispatchC2SOrS2SAdSource());
            return arrayList6;
        }
        if (!this.isDispatchWFSort) {
            this.isDispatchWFSort = true;
            return getWaitDispatchWFSortAdSourceList();
        }
        if (judgeIsHasLoadingSuccessAdResource()) {
            return null;
        }
        ArrayList arrayList7 = new ArrayList();
        AMPSListUtil.addDataToList(arrayList7, getOneWaitDispatchWFSortAdSource());
        return arrayList7;
    }

    private AdSourceModel getOneWaitDispatchC2SOrS2SAdSource() {
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mC2SAdSourceList) {
                if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                    adSourceModel.setAdStatus(1);
                    return adSourceModel;
                }
            }
        }
        List<AdSourceModel> list2 = this.mS2SAdSourceList;
        if (list2 == null || list2.size() <= 0) {
            return null;
        }
        for (AdSourceModel adSourceModel2 : this.mS2SAdSourceList) {
            if (adSourceModel2 != null && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(adSourceModel2.getBiddingType()) && adSourceModel2.getAdStatus() == 0) {
                adSourceModel2.setAdStatus(1);
                return adSourceModel2;
            }
        }
        return null;
    }

    private AdSourceModel getOneWaitDispatchWFAdSource() {
        List<AdSourceModel> list = this.mWFAdSourceList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (AdSourceModel adSourceModel : this.mWFAdSourceList) {
            if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                adSourceModel.setAdStatus(1);
                return adSourceModel;
            }
        }
        return null;
    }

    private AdSourceModel getOneWaitDispatchWFSortAdSource() {
        List<AdSourceModel> list = this.mWFSortAdSourceList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (AdSourceModel adSourceModel : this.mWFSortAdSourceList) {
            if (adSourceModel != null && (adSourceModel.getAdStatus() == 0 || adSourceModel.getAdStatus() == 3)) {
                adSourceModel.setAdStatus(4);
                return adSourceModel;
            }
        }
        return null;
    }

    private List<AdSourceModel> getWaitDispatchC2SOrS2SAdSourceList() {
        ArrayList arrayList = new ArrayList();
        List<AdSourceModel> list = this.mC2SAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mC2SAdSourceList) {
                if (adSourceModel != null) {
                    if (arrayList.size() >= this.mC2SMaxRequestNum) {
                        break;
                    }
                    if (AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                        adSourceModel.setAdStatus(1);
                        arrayList.add(adSourceModel);
                    }
                }
            }
        }
        List<AdSourceModel> list2 = this.mS2SAdSourceList;
        if (list2 != null && list2.size() > 0) {
            for (AdSourceModel adSourceModel2 : this.mS2SAdSourceList) {
                if (adSourceModel2 != null) {
                    if (arrayList.size() >= this.mC2SMaxRequestNum) {
                        break;
                    }
                    if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(adSourceModel2.getBiddingType()) && adSourceModel2.getAdStatus() == 0) {
                        adSourceModel2.setAdStatus(1);
                        arrayList.add(adSourceModel2);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<AdSourceModel> getWaitDispatchWFAdSourceList() {
        ArrayList arrayList = new ArrayList();
        List<AdSourceModel> list = this.mWFAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mWFAdSourceList) {
                if (adSourceModel != null) {
                    if (arrayList.size() >= this.mWFMaxRequestNum) {
                        break;
                    }
                    if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 0) {
                        adSourceModel.setAdStatus(1);
                        arrayList.add(adSourceModel);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<AdSourceModel> getWaitDispatchWFSortAdSourceList() {
        ArrayList arrayList = new ArrayList();
        List<AdSourceModel> list = this.mWFSortAdSourceList;
        if (list != null && list.size() > 0) {
            for (AdSourceModel adSourceModel : this.mWFSortAdSourceList) {
                if (adSourceModel != null) {
                    if (arrayList.size() >= this.mWFMaxRequestNum) {
                        break;
                    }
                    if (adSourceModel.getAdStatus() == 0 || adSourceModel.getAdStatus() == 3) {
                        adSourceModel.setAdStatus(4);
                        arrayList.add(adSourceModel);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<AdSourceModel> getWaitSamePriceAdSourceList() {
        AdSourceModel poll;
        LinkedList<AdSourceModel> linkedList = this.mSamePriceAdSourceData;
        ArrayList arrayList = null;
        if (linkedList == null || (poll = linkedList.poll()) == null) {
            return null;
        }
        try {
            int ecpm = poll.getEcpm();
            ArrayList arrayList2 = new ArrayList();
            try {
                arrayList2.add(poll);
                while (true) {
                    LinkedList<AdSourceModel> linkedList2 = this.mSamePriceAdSourceData;
                    if (linkedList2 == null || linkedList2.isEmpty() || this.mSamePriceAdSourceData.getFirst() == null || this.mSamePriceAdSourceData.getFirst().getEcpm() != ecpm) {
                        break;
                    }
                    arrayList2.add(this.mSamePriceAdSourceData.poll());
                }
                return arrayList2;
            } catch (Exception e6) {
                e = e6;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e7) {
            e = e7;
        }
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

    private void handleWFRaisePrice(List<AdSourceModel> list) {
        AuctionStrategyModel auctionStrategy;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (AdSourceModel adSourceModel : list) {
            if (adSourceModel != null) {
                if (isC2SOrS2SAdSource(adSourceModel.getBiddingType()) && this.mAdRequestType == 1) {
                    handleBiddingRaisePrice(adSourceModel);
                } else if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && (auctionStrategy = adSourceModel.getAuctionStrategy()) != null && !auctionStrategy.isRaise()) {
                    int ecpm = adSourceModel.getEcpm();
                    auctionStrategy.setOriginEcpm(ecpm);
                    if (AMPSRandomUtil.isHitRandomNum(auctionStrategy.getEffectRate())) {
                        auctionStrategy.setHit(true);
                        auctionStrategy.setRaise(true);
                        int raiseSortPrice = auctionStrategy.getRaiseSortPrice();
                        int originEcpm = auctionStrategy.getOriginEcpm();
                        int i6 = ecpm + raiseSortPrice;
                        int i7 = this.mCurrentHighestPrice;
                        if (i6 >= i7 && originEcpm < i7) {
                            i6 = i7 - 1;
                        }
                        adSourceModel.setEcpm(i6);
                    }
                }
            }
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

    private boolean isExistHasSuccessResultWF() {
        List<AdSourceModel> list = this.mWFAdSourceList;
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (AdSourceModel adSourceModel : this.mWFAdSourceList) {
            if (adSourceModel != null && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean judgeIsHasLoadingSuccessAdResource() {
        List<AdSourceModel> list = this.mWFSortAdSourceList;
        if (list != null && list.size() != 0) {
            for (AdSourceModel adSourceModel : this.mWFSortAdSourceList) {
                if (adSourceModel != null && adSourceModel.getAdStatus() == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private void sortAdSourceListByEcpm(List<AdSourceModel> list) {
        Collections.sort(list, new Comparator<AdSourceModel>() { // from class: xyz.adscope.amps.control.dispatch.AMPSDispatcher.1
            @Override // java.util.Comparator
            public int compare(AdSourceModel adSourceModel, AdSourceModel adSourceModel2) {
                try {
                    int ecpm = adSourceModel.getEcpm() - adSourceModel2.getEcpm();
                    if (ecpm > 0) {
                        return -1;
                    }
                    if (ecpm < 0) {
                        return 1;
                    }
                    if (adSourceModel.isHitWeight() && adSourceModel2.isHitWeight()) {
                        return 0;
                    }
                    return adSourceModel.isHitWeight() ? -1 : 1;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return -1;
                }
            }
        });
        for (AdSourceModel adSourceModel : list) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, " sortAdSourceListByEcpm mWeightRandomNum:" + this.mWeightRandomNum + ";getStartWeight:" + adSourceModel.getStartWeight() + ";getEndWeight:" + adSourceModel.getEndWeight() + ";getSeatId:" + adSourceModel.getSeatId());
        }
    }

    @Override // xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface
    public List<AdSourceModel> biddingTimeOut() {
        List<AdSourceModel> waitDispatchWFSortAdSourceList;
        if (!this.isDispatchWFSort && this.mAdRequestType == 1) {
            updateAdSourceAdStatus(this.mS2SAdSourceList, 6);
            updateAdSourceAdStatus(this.mC2SAdSourceList, 6);
            this.isDispatchWFSort = true;
            if (this.mAdRequestType != 2 && (waitDispatchWFSortAdSourceList = getWaitDispatchWFSortAdSourceList()) != null && waitDispatchWFSortAdSourceList.size() > 0) {
                return waitDispatchWFSortAdSourceList;
            }
        }
        return null;
    }

    @Override // xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface
    public void updateAdSourceAdStatus(List<AdSourceModel> list, int i6) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (AdSourceModel adSourceModel : list) {
            if (adSourceModel != null) {
                if (i6 != 6) {
                    adSourceModel.setAdStatus(i6);
                } else if (adSourceModel.getAdStatus() != 3 && adSourceModel.getAdStatus() != 5) {
                    adSourceModel.setAdStatus(i6);
                }
            }
        }
    }

    public AMPSDispatcher(SpaceModel spaceModel) {
        this.mC2SMaxRequestNum = 0;
        this.mWFMaxRequestNum = 0;
        this.mAdRequestType = 0;
        this.mWeightRandomNum = 0;
        this.mS2SAdSourceList = null;
        this.mC2SAdSourceList = null;
        this.mWFAdSourceList = null;
        if (spaceModel != null) {
            this.mC2SMaxRequestNum = spaceModel.getBidParallelNum();
            this.mWFMaxRequestNum = spaceModel.getWaterfallParallelNum();
            this.mAdRequestType = spaceModel.getBidDistributionMethod();
            this.mWeightRandomNum = spaceModel.getWeightRandomNum();
            List<AdSourceModel> s2sAdSourceList = spaceModel.getS2sAdSourceList();
            List<AdSourceModel> c2sAdSourceList = spaceModel.getC2sAdSourceList();
            List<AdSourceModel> wfAdSourceList = spaceModel.getWfAdSourceList();
            if (s2sAdSourceList != null && s2sAdSourceList.size() > 0) {
                this.mS2SAdSourceList = s2sAdSourceList;
                for (AdSourceModel adSourceModel : s2sAdSourceList) {
                    adSourceModel.setHitWeight(AMPSRandomUtil.isHitRandomNum(adSourceModel.getStartWeight(), adSourceModel.getEndWeight(), this.mWeightRandomNum));
                }
            }
            if (c2sAdSourceList != null && c2sAdSourceList.size() > 0) {
                this.mC2SAdSourceList = c2sAdSourceList;
                for (AdSourceModel adSourceModel2 : c2sAdSourceList) {
                    adSourceModel2.setHitWeight(AMPSRandomUtil.isHitRandomNum(adSourceModel2.getStartWeight(), adSourceModel2.getEndWeight(), this.mWeightRandomNum));
                }
            }
            if (wfAdSourceList != null && wfAdSourceList.size() > 0) {
                this.mWFAdSourceList = wfAdSourceList;
                for (AdSourceModel adSourceModel3 : wfAdSourceList) {
                    adSourceModel3.setReportEcpm(adSourceModel3.getEcpm());
                    adSourceModel3.setHitWeight(AMPSRandomUtil.isHitRandomNum(adSourceModel3.getStartWeight(), adSourceModel3.getEndWeight(), this.mWeightRandomNum));
                }
                sortAdSourceListByEcpm(this.mWFAdSourceList);
                if (this.mAdRequestType == 1) {
                    this.mWFSortAdSourceList.addAll(this.mWFAdSourceList);
                }
                this.mCurrentHighestPrice = this.mWFAdSourceList.get(0).getEcpm();
                if (this.mAdRequestType == 2) {
                    this.mSamePriceAdSourceData = new LinkedList<>(this.mWFAdSourceList);
                }
            }
        }
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

    @Override // xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface
    public List<AdSourceModel> dispatch(AdSourceModel adSourceModel) {
        List<AdSourceModel> dispatchAd = dispatchAd(adSourceModel);
        handleWFRaisePrice(dispatchAd);
        return dispatchAd;
    }
}
