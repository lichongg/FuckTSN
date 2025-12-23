package com.bytedance.sdk.component.m.cw;

import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r<T> implements qv {
    private Map<String, String> ae;
    private T cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f26578g;

    /* renamed from: j, reason: collision with root package name */
    private String f26579j;

    /* renamed from: m, reason: collision with root package name */
    private int f26580m;
    private com.bytedance.sdk.component.m.ae oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private T f26581r;
    private boolean tl;
    private int up;
    private String xt;

    public r j(cw cwVar, T t5) {
        this.cw = t5;
        this.f26579j = cwVar.ae();
        this.xt = cwVar.xt();
        this.up = cwVar.cw();
        this.f26580m = cwVar.r();
        this.f26578g = cwVar.av();
        this.oq = cwVar.i();
        this.qv = cwVar.w();
        return this;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(8)
    public Map<String, String> ae() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(3)
    public T cw() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(10)
    public boolean g() {
        return this.f26578g;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(7)
    public int m() {
        return this.f26580m;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(11)
    public com.bytedance.sdk.component.m.ae oq() {
        return this.oq;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(12)
    public int qv() {
        return this.qv;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(4)
    public T r() {
        return this.f26581r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(5)
    public void setResult(Object obj) {
        this.f26581r = this.cw;
        this.cw = obj;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(9)
    public boolean tl() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(6)
    public int up() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(2)
    public String xt() {
        return this.xt;
    }

    public r j(cw cwVar, T t5, Map<String, String> map, boolean z5) {
        this.ae = map;
        this.tl = z5;
        return j(cwVar, t5);
    }

    @Override // com.bytedance.sdk.component.m.qv
    @ATSMethod(1)
    public String j() {
        return this.f26579j;
    }
}
