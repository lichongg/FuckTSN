package com.bytedance.msdk.up;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f25321j;
    private List<j> xt = new CopyOnWriteArrayList();

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private r f25322j;
        private JSONObject xt;

        public r j() {
            return this.f25322j;
        }

        public JSONObject xt() {
            return this.xt;
        }

        public j(r rVar, JSONObject jSONObject) {
            this.f25322j = rVar;
            this.xt = jSONObject;
        }
    }

    public static xt j() {
        if (f25321j == null) {
            synchronized (xt.class) {
                try {
                    if (f25321j == null) {
                        f25321j = new xt();
                    }
                } finally {
                }
            }
        }
        return f25321j;
    }

    public void cw() {
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 清空埋点辅助模块");
        List<j> list = this.xt;
        if (list != null) {
            list.clear();
        }
    }

    public List<j> xt() {
        return this.xt;
    }

    private xt() {
    }

    public void j(r rVar, JSONObject jSONObject) {
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- 保存到埋点辅助模块");
        this.xt.add(new j(rVar, jSONObject));
    }
}
