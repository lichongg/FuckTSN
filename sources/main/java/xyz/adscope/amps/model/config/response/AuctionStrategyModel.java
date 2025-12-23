package xyz.adscope.amps.model.config.response;

import xyz.adscope.amps.model.inter.IDeepCopyModel;
import xyz.adscope.common.json.util.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AuctionStrategyModel implements IDeepCopyModel<AuctionStrategyModel> {
    private int auctionType;
    private String customData;
    private int effectRate;
    private boolean isHit;
    private int isLastLook;
    private boolean isRaise;
    private boolean isUseLastLook;
    private int originEcpm;
    private int raiseSortPrice;
    private int secondPrice;
    private String winPriceMax;
    private String winPriceMin;

    public AuctionStrategyModel() {
    }

    private AuctionStrategyModel(AuctionStrategyModel auctionStrategyModel) {
        this.raiseSortPrice = auctionStrategyModel.getRaiseSortPrice();
        this.effectRate = auctionStrategyModel.getEffectRate();
        this.auctionType = auctionStrategyModel.getAuctionType();
        this.isLastLook = auctionStrategyModel.getIsLastLook();
        this.winPriceMin = auctionStrategyModel.getWinPriceMin();
        this.winPriceMax = auctionStrategyModel.getWinPriceMax();
        this.secondPrice = auctionStrategyModel.getSecondPrice();
        this.customData = auctionStrategyModel.getCustomData();
        this.originEcpm = auctionStrategyModel.getOriginEcpm();
        this.isHit = auctionStrategyModel.isHit();
        this.isRaise = auctionStrategyModel.isRaise();
        this.isUseLastLook = auctionStrategyModel.isUseLastLook();
    }

    @Override // xyz.adscope.amps.model.inter.IDeepCopyModel
    public AuctionStrategyModel deepCopy() {
        return new AuctionStrategyModel(this);
    }

    public int getAuctionType() {
        return this.auctionType;
    }

    public String getCustomData() {
        return this.customData;
    }

    public int getEffectRate() {
        return this.effectRate;
    }

    public int getIsLastLook() {
        return this.isLastLook;
    }

    public int getOriginEcpm() {
        return this.originEcpm;
    }

    public int getRaiseSortPrice() {
        return this.raiseSortPrice;
    }

    public int getSecondPrice() {
        return this.secondPrice;
    }

    public String getWinPriceMax() {
        return this.winPriceMax;
    }

    public String getWinPriceMin() {
        return this.winPriceMin;
    }

    public boolean isHit() {
        return this.isHit;
    }

    public boolean isRaise() {
        return this.isRaise;
    }

    public boolean isUseLastLook() {
        return this.isUseLastLook;
    }

    public void setAuctionType(int i6) {
        this.auctionType = i6;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setEffectRate(int i6) {
        this.effectRate = i6;
    }

    public void setHit(boolean z5) {
        this.isHit = z5;
    }

    public void setIsLastLook(int i6) {
        this.isLastLook = i6;
    }

    public void setOriginEcpm(int i6) {
        this.originEcpm = i6;
    }

    public void setRaise(boolean z5) {
        this.isRaise = z5;
    }

    public void setRaiseSortPrice(int i6) {
        this.raiseSortPrice = i6;
    }

    public void setSecondPrice(int i6) {
        this.secondPrice = i6;
    }

    public void setUseLastLook(boolean z5) {
        this.isUseLastLook = z5;
    }

    public void setWinPriceMax(String str) {
        this.winPriceMax = str;
    }

    public void setWinPriceMin(String str) {
        this.winPriceMin = str;
    }

    public String toString() {
        return "{\"raiseSortPrice\":" + this.raiseSortPrice + ", \"effectRate\":" + this.effectRate + ", \"auctionType\":" + this.auctionType + ", \"isLastLook\":" + this.isLastLook + ", \"winPriceMin\":\"" + this.winPriceMin + "\", \"winPriceMax\":\"" + this.winPriceMax + "\", \"secondPrice\":" + this.secondPrice + ", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\"}";
    }
}
