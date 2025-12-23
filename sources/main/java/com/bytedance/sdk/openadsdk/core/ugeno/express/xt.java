package com.bytedance.sdk.openadsdk.core.ugeno.express;

import com.bytedance.adsdk.ugeno.cw.f;
import com.bytedance.sdk.component.adexpress.xt.jy;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends jy {
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f30723j;

    /* renamed from: r, reason: collision with root package name */
    private float f30724r;
    private boolean up;
    private f xt;

    public static class j extends jy.j {
        private float cw;

        /* renamed from: j, reason: collision with root package name */
        private JSONObject f30725j;

        /* renamed from: r, reason: collision with root package name */
        private float f30726r;
        private boolean up;
        private f xt;

        public j r(boolean z5) {
            this.up = z5;
            return this;
        }

        public j up(JSONObject jSONObject) {
            this.f30725j = jSONObject;
            return this;
        }

        public j xt(float f6) {
            this.f30726r = f6;
            return this;
        }

        public j j(f fVar) {
            this.xt = fVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.xt.jy.j
        /* renamed from: xt, reason: merged with bridge method [inline-methods] */
        public xt j() {
            return new xt(this);
        }

        public j j(float f6) {
            this.cw = f6;
            return this;
        }
    }

    public JSONObject gq() {
        return this.f30723j;
    }

    public float h() {
        return this.cw;
    }

    public float la() {
        return this.f30724r;
    }

    public f rn() {
        return this.xt;
    }

    public boolean wq() {
        return this.up;
    }

    public xt(j jVar) {
        super(jVar);
        this.f30723j = jVar.f30725j;
        this.xt = jVar.xt;
        this.cw = jVar.cw;
        this.f30724r = jVar.f30726r;
        this.up = jVar.up;
    }
}
