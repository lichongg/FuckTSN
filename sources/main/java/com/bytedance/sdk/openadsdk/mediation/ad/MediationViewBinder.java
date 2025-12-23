package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    public static class Builder {
        protected int ae;
        protected int cw;

        /* renamed from: g, reason: collision with root package name */
        protected int f31649g;

        /* renamed from: j, reason: collision with root package name */
        protected int f31650j;
        protected int jy;

        /* renamed from: m, reason: collision with root package name */
        protected int f31651m;
        protected int oq;
        protected int qv;

        /* renamed from: r, reason: collision with root package name */
        protected int f31652r;
        protected int tl;
        protected int up;
        protected int vl;
        protected Map<String, Integer> ws;
        protected int xt;

        public Builder addExtra(String str, int i6) {
            this.ws.put(str, Integer.valueOf(i6));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.ws = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i6) {
            this.f31652r = i6;
            return this;
        }

        public Builder descriptionTextId(int i6) {
            this.cw = i6;
            return this;
        }

        public Builder groupImage1Id(int i6) {
            this.oq = i6;
            return this;
        }

        public Builder groupImage2Id(int i6) {
            this.qv = i6;
            return this;
        }

        public Builder groupImage3Id(int i6) {
            this.vl = i6;
            return this;
        }

        public Builder iconImageId(int i6) {
            this.up = i6;
            return this;
        }

        public Builder logoLayoutId(int i6) {
            this.f31649g = i6;
            return this;
        }

        public Builder mainImageId(int i6) {
            this.f31651m = i6;
            return this;
        }

        public Builder mediaViewIdId(int i6) {
            this.ae = i6;
            return this;
        }

        public Builder shakeViewContainerId(int i6) {
            this.jy = i6;
            return this;
        }

        public Builder sourceId(int i6) {
            this.tl = i6;
            return this;
        }

        public Builder titleId(int i6) {
            this.xt = i6;
            return this;
        }

        public Builder(int i6) {
            this.ws = Collections.EMPTY_MAP;
            this.f31650j = i6;
            this.ws = new HashMap();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }

    protected MediationViewBinder(Builder builder) {
        this.layoutId = builder.f31650j;
        this.titleId = builder.xt;
        this.decriptionTextId = builder.cw;
        this.callToActionId = builder.f31652r;
        this.iconImageId = builder.up;
        this.mainImageId = builder.f31651m;
        this.mediaViewId = builder.ae;
        this.sourceId = builder.tl;
        this.extras = builder.ws;
        this.groupImage1Id = builder.oq;
        this.groupImage2Id = builder.qv;
        this.groupImage3Id = builder.vl;
        this.logoLayoutId = builder.f31649g;
        this.shakeViewContainerId = builder.jy;
    }
}
