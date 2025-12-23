package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationAdEcpmInfo {
    private String ae;
    private Map<String, String> av;
    private String az;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f31737g;

    /* renamed from: j, reason: collision with root package name */
    private String f31738j;
    private String jy;

    /* renamed from: m, reason: collision with root package name */
    private int f31739m;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private String f31740r;
    private String tl;
    private String up;
    private String vl;
    private String ws;
    private String xt;

    public MediationAdEcpmInfo() {
        this.av = new HashMap();
    }

    public String getAbTestId() {
        return this.ws;
    }

    public String getChannel() {
        return this.vl;
    }

    public Map<String, String> getCustomData() {
        return this.av;
    }

    public String getCustomSdkName() {
        return this.xt;
    }

    public String getEcpm() {
        return this.up;
    }

    public String getErrorMsg() {
        return this.ae;
    }

    public String getLevelTag() {
        return this.f31740r;
    }

    public int getReqBiddingType() {
        return this.f31739m;
    }

    public String getRequestId() {
        return this.tl;
    }

    public String getRitType() {
        return this.f31737g;
    }

    public String getScenarioId() {
        return this.az;
    }

    public String getSdkName() {
        return this.f31738j;
    }

    public String getSegmentId() {
        return this.qv;
    }

    public String getSlotId() {
        return this.cw;
    }

    public String getSubChannel() {
        return this.jy;
    }

    public String getSubRitType() {
        return this.oq;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i6, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.av = hashMap;
        this.f31738j = str;
        this.xt = str2;
        this.cw = str3;
        this.f31740r = str4;
        this.up = str5;
        this.f31739m = i6;
        this.ae = str6;
        this.tl = str7;
        this.f31737g = str8;
        this.oq = str9;
        this.qv = str10;
        this.vl = str11;
        this.jy = str12;
        this.ws = str13;
        this.az = str14;
        if (map != null) {
            this.av = map;
        } else {
            hashMap.clear();
        }
    }
}
