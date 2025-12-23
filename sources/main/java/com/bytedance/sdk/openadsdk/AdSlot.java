package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class AdSlot implements SlotType {

    /* renamed from: a, reason: collision with root package name */
    private String f27477a;
    private boolean ae;
    private int[] av;
    private boolean az;
    private IMediationAdSlot ch;
    private int cw;

    /* renamed from: f, reason: collision with root package name */
    private String f27478f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f27479g;

    /* renamed from: i, reason: collision with root package name */
    private int f27480i;

    /* renamed from: j, reason: collision with root package name */
    private String f27481j;
    private int jy;
    private String kt;

    /* renamed from: m, reason: collision with root package name */
    private int f27482m;
    private String mi;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private float f27483r;

    /* renamed from: s, reason: collision with root package name */
    private int f27484s;
    private String tj;
    private boolean tl;
    private float up;

    /* renamed from: v, reason: collision with root package name */
    private String f27485v;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private String f27486w;
    private int ws;

    /* renamed from: x, reason: collision with root package name */
    private TTAdLoadType f27487x;
    private int xt;

    /* renamed from: com.bytedance.sdk.openadsdk.AdSlot$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f27488a;
        private int[] av;
        private IMediationAdSlot ch;

        /* renamed from: f, reason: collision with root package name */
        private String f27489f;

        /* renamed from: i, reason: collision with root package name */
        private int f27491i;

        /* renamed from: j, reason: collision with root package name */
        private String f27492j;
        private float jy;
        private String kt;
        private String mi;
        private int qv;

        /* renamed from: s, reason: collision with root package name */
        private int f27495s;
        private String tl;

        /* renamed from: v, reason: collision with root package name */
        private String f27496v;
        private int vl;

        /* renamed from: w, reason: collision with root package name */
        private String f27497w;
        private float ws;

        /* renamed from: x, reason: collision with root package name */
        private String f27498x;
        private int xt = 640;
        private int cw = 320;

        /* renamed from: r, reason: collision with root package name */
        private boolean f27494r = true;
        private boolean up = false;

        /* renamed from: m, reason: collision with root package name */
        private boolean f27493m = false;
        private int ae = 1;

        /* renamed from: g, reason: collision with root package name */
        private String f27490g = "defaultUser";
        private int oq = 2;
        private boolean az = true;
        private TTAdLoadType tj = TTAdLoadType.UNKNOWN;

        public Builder supportIconStyle() {
            this.f27493m = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.up = true;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot(null);
            adSlot.f27481j = this.f27492j;
            adSlot.f27482m = this.ae;
            adSlot.ae = this.f27494r;
            adSlot.tl = this.up;
            adSlot.f27479g = this.f27493m;
            adSlot.xt = this.xt;
            adSlot.cw = this.cw;
            adSlot.f27483r = this.jy;
            adSlot.up = this.ws;
            adSlot.oq = this.tl;
            adSlot.qv = this.f27490g;
            adSlot.vl = this.oq;
            adSlot.ws = this.qv;
            adSlot.az = this.az;
            adSlot.av = this.av;
            adSlot.f27480i = this.f27491i;
            adSlot.f27486w = this.f27497w;
            adSlot.kt = this.f27489f;
            adSlot.tj = this.f27496v;
            adSlot.f27478f = this.f27498x;
            adSlot.jy = this.vl;
            adSlot.mi = this.mi;
            adSlot.f27485v = this.kt;
            adSlot.f27487x = this.tj;
            adSlot.f27477a = this.f27488a;
            adSlot.f27484s = this.f27495s;
            adSlot.ch = this.ch;
            return adSlot;
        }

        public Builder setAdCount(int i6) {
            if (i6 <= 0) {
                i6 = 1;
            }
            if (i6 > 20) {
                i6 = 20;
            }
            this.ae = i6;
            return this;
        }

        public Builder setAdId(String str) {
            this.f27489f = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.tj = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i6) {
            this.vl = i6;
            return this;
        }

        public Builder setAdloadSeq(int i6) {
            this.f27491i = i6;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f27492j = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.f27496v = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f6, float f7) {
            this.jy = f6;
            this.ws = f7;
            return this;
        }

        public Builder setExt(String str) {
            this.f27498x = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.av = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i6, int i7) {
            this.xt = i6;
            this.cw = i7;
            return this;
        }

        public Builder setIsAutoPlay(boolean z5) {
            this.az = z5;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.tl = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.ch = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i6) {
            this.qv = i6;
            return this;
        }

        public Builder setOrientation(int i6) {
            this.oq = i6;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.f27497w = str;
            return this;
        }

        public Builder setRewardAmount(int i6) {
            this.f27495s = i6;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f27488a = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z5) {
            this.f27494r = z5;
            return this;
        }

        public Builder setUserData(String str) {
            this.kt = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f27490g = str;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.mi = str;
            return this;
        }
    }

    /* synthetic */ AdSlot(AnonymousClass1 anonymousClass1) {
        this();
    }

    private AdSlot() {
        this.vl = 2;
        this.az = true;
    }

    public int getAdCount() {
        return this.f27482m;
    }

    public String getAdId() {
        return this.kt;
    }

    public TTAdLoadType getAdLoadType() {
        return this.f27487x;
    }

    public int getAdType() {
        return this.jy;
    }

    public int getAdloadSeq() {
        return this.f27480i;
    }

    public String getBidAdm() {
        return this.mi;
    }

    public String getCodeId() {
        return this.f27481j;
    }

    public String getCreativeId() {
        return this.tj;
    }

    public float getExpressViewAcceptedHeight() {
        return this.up;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f27483r;
    }

    public String getExt() {
        return this.f27478f;
    }

    public int[] getExternalABVid() {
        return this.av;
    }

    public int getImgAcceptedHeight() {
        return this.cw;
    }

    public int getImgAcceptedWidth() {
        return this.xt;
    }

    public String getMediaExtra() {
        return this.oq;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.ch;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.ws;
    }

    public int getOrientation() {
        return this.vl;
    }

    public String getPrimeRit() {
        String str = this.f27486w;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.f27484s;
    }

    public String getRewardName() {
        return this.f27477a;
    }

    public String getUserData() {
        return this.f27485v;
    }

    public String getUserID() {
        return this.qv;
    }

    public boolean isAutoPlay() {
        return this.az;
    }

    public boolean isSupportDeepLink() {
        return this.ae;
    }

    public boolean isSupportIconStyle() {
        return this.f27479g;
    }

    public boolean isSupportRenderConrol() {
        return this.tl;
    }

    public void setAdCount(int i6) {
        this.f27482m = i6;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.f27487x = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.av = iArr;
    }

    public void setNativeAdType(int i6) {
        this.ws = i6;
    }

    public void setUserData(String str) {
        this.f27485v = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f27481j);
            jSONObject.put("mIsAutoPlay", this.az);
            jSONObject.put("mImgAcceptedWidth", this.xt);
            jSONObject.put("mImgAcceptedHeight", this.cw);
            jSONObject.put("mExpressViewAcceptedWidth", this.f27483r);
            jSONObject.put("mExpressViewAcceptedHeight", this.up);
            jSONObject.put("mAdCount", this.f27482m);
            jSONObject.put("mSupportDeepLink", this.ae);
            jSONObject.put("mSupportRenderControl", this.tl);
            jSONObject.put("mSupportIconStyle", this.f27479g);
            jSONObject.put("mMediaExtra", this.oq);
            jSONObject.put("mUserID", this.qv);
            jSONObject.put("mOrientation", this.vl);
            jSONObject.put("mNativeAdType", this.ws);
            jSONObject.put("mAdloadSeq", this.f27480i);
            jSONObject.put("mPrimeRit", this.f27486w);
            jSONObject.put("mAdId", this.kt);
            jSONObject.put("mCreativeId", this.tj);
            jSONObject.put("mExt", this.f27478f);
            jSONObject.put("mBidAdm", this.mi);
            jSONObject.put("mUserData", this.f27485v);
            jSONObject.put("mAdLoadType", this.f27487x);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f27481j + "', mImgAcceptedWidth=" + this.xt + ", mImgAcceptedHeight=" + this.cw + ", mExpressViewAcceptedWidth=" + this.f27483r + ", mExpressViewAcceptedHeight=" + this.up + ", mAdCount=" + this.f27482m + ", mSupportDeepLink=" + this.ae + ", mSupportRenderControl=" + this.tl + ", mSupportIconStyle=" + this.f27479g + ", mMediaExtra='" + this.oq + "', mUserID='" + this.qv + "', mOrientation=" + this.vl + ", mNativeAdType=" + this.ws + ", mIsAutoPlay=" + this.az + ", mPrimeRit" + this.f27486w + ", mAdloadSeq" + this.f27480i + ", mAdId" + this.kt + ", mCreativeId" + this.tj + ", mExt" + this.f27478f + ", mUserData" + this.f27485v + ", mAdLoadType" + this.f27487x + '}';
    }
}
