package com.bytedance.sdk.component.qv.j;

import android.text.TextUtils;
import com.bytedance.sdk.component.qv.r.cw;
import com.bytedance.sdk.component.qv.r.r;
import com.bytedance.sdk.component.qv.r.up;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements r {
    private Map<String, Object> cw;

    /* renamed from: j, reason: collision with root package name */
    private String f26738j;

    /* renamed from: m, reason: collision with root package name */
    private int f26739m;

    /* renamed from: r, reason: collision with root package name */
    private cw f26740r;
    private com.bytedance.sdk.component.qv.j.j up;
    private JSONObject xt;

    public static class j {
        private JSONObject ae;
        private StringBuilder cw;

        /* renamed from: j, reason: collision with root package name */
        private int f26742j = 1;

        /* renamed from: m, reason: collision with root package name */
        private cw f26743m;

        /* renamed from: r, reason: collision with root package name */
        private JSONObject f26744r;
        private Map<String, Object> up;
        private String xt;

        public j j(JSONObject jSONObject) {
            this.f26744r = jSONObject;
            return this;
        }

        public j xt(JSONObject jSONObject) {
            this.ae = jSONObject;
            return this;
        }

        public j(String str) {
            this.xt = str;
        }

        public j j(Map<String, Object> map) {
            this.up = map;
            return this;
        }

        public j j(cw cwVar) {
            this.f26743m = cwVar;
            return this;
        }

        public xt j() {
            return new xt(this);
        }
    }

    private xt(j jVar) {
        this.f26739m = 1;
        this.f26739m = jVar.f26742j;
        if (jVar.f26742j == 2) {
            this.up = new com.bytedance.sdk.component.qv.j.j(jVar.cw, jVar.f26744r, (Map<String, Object>) jVar.up);
            this.f26739m = 2;
        } else {
            this.f26738j = jVar.xt;
            if (jVar.ae != null) {
                com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(jVar.ae);
            }
        }
        this.xt = jVar.f26744r;
        this.cw = jVar.up;
        this.f26740r = jVar.f26743m;
    }

    @Override // com.bytedance.sdk.component.qv.r.r
    public up xt() {
        return new up() { // from class: com.bytedance.sdk.component.qv.j.xt.1
            @Override // com.bytedance.sdk.component.qv.r.up
            public void j(com.bytedance.sdk.component.qv.j.j jVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.qv.cw.j> it = com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(xt.this.f26738j).j(jVar.ae(), jVar.cw(), map).iterator();
                while (it.hasNext()) {
                    xt.this.j(it.next(), map);
                }
            }

            @Override // com.bytedance.sdk.component.qv.r.up
            public void xt(com.bytedance.sdk.component.qv.j.j jVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.qv.cw.j> it = com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(xt.this.f26738j).xt(jVar.ae(), jVar.cw(), map).iterator();
                while (it.hasNext()) {
                    xt.this.j(it.next(), map);
                }
            }
        };
    }

    public void j() {
        com.bytedance.sdk.component.qv.cw.cw j6;
        if (this.f26739m == 2) {
            cw cwVar = this.f26740r;
            if (cwVar != null) {
                cwVar.j(this.up);
            }
            this.up.m();
            return;
        }
        if (TextUtils.isEmpty(this.f26738j) || (j6 = com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(this.f26738j)) == null) {
            return;
        }
        j(j6.j(), this.cw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.component.qv.cw.j jVar, Map<String, Object> map) {
        if (jVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.bytedance.sdk.component.qv.j.j jVar2 = new com.bytedance.sdk.component.qv.j.j(jVar, this.xt, map);
        jVar2.j(this.f26738j);
        jVar2.j(this);
        cw cwVar = this.f26740r;
        if (cwVar != null) {
            cwVar.j(jVar2);
        }
        jVar2.m();
        for (com.bytedance.sdk.component.qv.cw.j jVar3 : com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(this.f26738j).cw(jVar, jVar2.cw(), map)) {
            if (jVar3 != null) {
                j(jVar3, map);
            }
        }
    }
}
