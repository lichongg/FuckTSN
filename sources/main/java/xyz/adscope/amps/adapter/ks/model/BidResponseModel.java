package xyz.adscope.amps.adapter.ks.model;

import java.util.List;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BidResponseModel {
    private List<AdBidsModel> adBids;
    private String adxId;
    private String cookie;
    private String egid;
    private String errorMsg;
    private String extra;
    private boolean hasMore;
    private String impAdInfo;
    private long llsid;
    private int result;

    public List<AdBidsModel> getAdBids() {
        return this.adBids;
    }

    public String getAdxId() {
        return this.adxId;
    }

    public String getCookie() {
        return this.cookie;
    }

    public String getEgid() {
        return this.egid;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getImpAdInfo() {
        return this.impAdInfo;
    }

    public long getLlsid() {
        return this.llsid;
    }

    public int getResult() {
        return this.result;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setAdBids(List<AdBidsModel> list) {
        this.adBids = list;
    }

    public void setAdxId(String str) {
        this.adxId = str;
    }

    public void setCookie(String str) {
        this.cookie = str;
    }

    public void setEgid(String str) {
        this.egid = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setHasMore(boolean z5) {
        this.hasMore = z5;
    }

    public void setImpAdInfo(String str) {
        this.impAdInfo = str;
    }

    public void setLlsid(long j6) {
        this.llsid = j6;
    }

    public void setResult(int i6) {
        this.result = i6;
    }
}
