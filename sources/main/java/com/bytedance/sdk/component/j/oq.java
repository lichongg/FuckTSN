package com.bytedance.sdk.component.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.j.qv;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    boolean ae;
    qv.xt av;
    boolean az;

    /* renamed from: g, reason: collision with root package name */
    jy f26497g;

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.sdk.component.jy.cw f26498j;

    /* renamed from: m, reason: collision with root package name */
    boolean f26499m;
    ws oq;

    /* renamed from: r, reason: collision with root package name */
    tl f26500r;
    boolean tl;
    Context up;
    boolean ws;
    j xt;
    String cw = "IESJSBridge";
    String qv = "host";
    final Set<String> vl = new LinkedHashSet();
    final Set<String> jy = new LinkedHashSet();

    oq(com.bytedance.sdk.component.jy.cw cwVar) {
        this.f26498j = cwVar;
    }

    public oq j(j jVar) {
        this.xt = jVar;
        return this;
    }

    public oq xt(boolean z5) {
        this.ae = z5;
        return this;
    }

    private void cw() {
        if ((this.f26498j == null && !this.ws && this.xt == null) || ((TextUtils.isEmpty(this.cw) && this.f26498j != null) || this.f26500r == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public Context getContext() {
        return this.up;
    }

    public oq j(String str) {
        this.cw = str;
        return this;
    }

    public i xt() {
        cw();
        return new i(this);
    }

    public oq j(vl vlVar) {
        this.f26500r = tl.j(vlVar);
        return this;
    }

    public oq j(boolean z5) {
        this.f26499m = z5;
        return this;
    }

    public oq j() {
        this.az = true;
        return this;
    }

    oq() {
    }
}
