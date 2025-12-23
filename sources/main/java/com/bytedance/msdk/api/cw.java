package com.bytedance.msdk.api;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private int ae;
    private String av;
    private String az;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f24329g;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, String> f24330i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private int f24331j;
    private String jy;

    /* renamed from: m, reason: collision with root package name */
    private String f24332m;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private String f24333r;
    private String tl;
    private String up;
    private String vl;
    private String ws;
    private String xt;

    @Nullable
    public String ae() {
        return this.az;
    }

    @Nullable
    public String cw() {
        return this.qv;
    }

    @Nullable
    public String g() {
        return this.xt;
    }

    public void j(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f24330i.clear();
        this.f24330i.putAll(map);
    }

    @Nullable
    public String jy() {
        return this.f24332m;
    }

    @Nullable
    public String m() {
        return this.ws;
    }

    @Nullable
    public String oq() {
        return this.cw;
    }

    @Nullable
    public String qv() {
        return this.f24333r;
    }

    @Nullable
    public String r() {
        return this.vl;
    }

    @Nullable
    public String tl() {
        return this.av;
    }

    @Nullable
    public String up() {
        return this.jy;
    }

    @Nullable
    public String vl() {
        return TextUtils.isEmpty(this.cw) ? this.xt : this.cw;
    }

    @Nullable
    public String ws() {
        return this.up;
    }

    @Nullable
    public String xt() {
        return this.oq;
    }

    public void ae(String str) {
        this.av = str;
    }

    @Nullable
    public String av() {
        return this.tl;
    }

    public int az() {
        return this.ae;
    }

    public void cw(String str) {
        this.vl = str;
    }

    public void g(String str) {
        this.cw = str;
    }

    @Nullable
    public String i() {
        return this.f24329g;
    }

    public void jy(String str) {
        this.tl = str;
    }

    public void m(String str) {
        this.az = str;
    }

    public void oq(String str) {
        this.f24333r = str;
    }

    public void qv(String str) {
        this.f24332m = str;
    }

    public void r(String str) {
        this.jy = str;
    }

    public void tl(String str) {
        this.xt = str;
    }

    public String toString() {
        return "{mSdkNum='" + this.f24331j + "', mSlotId='" + this.f24333r + "', mLevelTag='" + this.up + "', mEcpm=" + this.f24332m + ", mReqBiddingType=" + this.ae + "', mRequestId=" + this.f24329g + ", mSubRitType=" + this.qv + '}';
    }

    public void up(String str) {
        this.ws = str;
    }

    public void vl(String str) {
        this.up = str;
    }

    public void ws(String str) {
        this.f24329g = str;
    }

    public void xt(String str) {
        this.qv = str;
    }

    public void xt(int i6) {
        this.ae = i6;
    }

    public Map<String, String> j() {
        return this.f24330i;
    }

    public void j(String str) {
        this.oq = str;
    }

    public void j(int i6) {
        this.f24331j = i6;
    }
}
