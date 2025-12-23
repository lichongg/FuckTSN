package com.bytedance.sdk.openadsdk.core.component.splash.cw.j;

import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends j {
    private com.bytedance.sdk.openadsdk.i.cw.xt.xt av;
    private boolean az;

    /* renamed from: g, reason: collision with root package name */
    private long f28676g;

    /* renamed from: i, reason: collision with root package name */
    private String f28677i;
    private String jy;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.g.xt f28678m;
    private long oq;
    private long qv;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.v.j.xt f28679r;
    private Map<String, String> vl;

    /* renamed from: w, reason: collision with root package name */
    private long f28680w;
    private boolean ws;
    private boolean up = false;
    private boolean ae = false;
    private boolean tl = false;
    private AtomicBoolean mi = new AtomicBoolean(false);

    public tl(n nVar, boolean z5) {
        this.xt = nVar;
        this.ws = z5;
    }

    public void cw(long j6) {
        this.oq = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.j.j
    public int j() {
        return this.f28668j;
    }

    public com.bytedance.sdk.openadsdk.core.v.j.xt r() {
        return this.f28679r;
    }

    public boolean up() {
        return this.up;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.j.j
    public n xt() {
        return this.xt;
    }

    public long ae() {
        return this.f28676g;
    }

    public boolean az() {
        return this.mi.get();
    }

    public void cw(boolean z5) {
        this.tl = z5;
    }

    public Map<String, String> g() {
        return this.vl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.j.j
    public void j(int i6) {
        this.f28668j = i6;
    }

    public String jy() {
        return this.f28677i;
    }

    public boolean m() {
        return this.ae;
    }

    public boolean oq() {
        return this.tl;
    }

    public boolean qv() {
        return this.ws;
    }

    public void r(long j6) {
        this.qv = j6;
    }

    public long tl() {
        return this.qv;
    }

    public void up(long j6) {
        this.f28680w = j6;
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.xt vl() {
        return this.av;
    }

    public long ws() {
        return this.f28680w;
    }

    public void xt(boolean z5) {
        this.ae = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.j.j
    public void j(n nVar) {
        this.xt = nVar;
    }

    public void r(boolean z5) {
        this.az = z5;
    }

    public void up(boolean z5) {
        this.mi.set(z5);
    }

    public void xt(long j6) {
        this.f28676g = j6;
    }

    public void j(boolean z5) {
        this.up = z5;
    }

    public void xt(String str) {
        this.f28677i = str;
    }

    public void j(com.bytedance.sdk.component.g.xt xtVar) {
        this.f28678m = xtVar;
    }

    public void j(Map<String, String> map) {
        this.vl = map;
    }

    public void j(String str) {
        this.jy = str;
    }

    public tl(com.bytedance.sdk.openadsdk.core.v.j.xt xtVar, n nVar, boolean z5) {
        this.f28679r = xtVar;
        this.xt = nVar;
        this.ws = z5;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        this.av = xtVar;
    }
}
