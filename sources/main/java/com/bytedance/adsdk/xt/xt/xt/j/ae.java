package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae implements com.bytedance.adsdk.xt.xt.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private final Object f23967j;

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        return this.f23967j;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public com.bytedance.adsdk.xt.xt.r.up j() {
        return com.bytedance.adsdk.xt.xt.r.m.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.f23967j + "]";
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public String xt() {
        Object obj = this.f23967j;
        return obj != null ? obj.toString() : "NULL";
    }

    public ae(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.f23967j = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.f23967j = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase("null")) {
                this.f23967j = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }
}
