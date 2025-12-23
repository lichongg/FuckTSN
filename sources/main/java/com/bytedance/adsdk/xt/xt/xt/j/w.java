package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class w extends i {

    /* renamed from: r, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f23976r = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.xt.xt.xt.j.w.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public w() {
        super(com.bytedance.adsdk.xt.xt.r.cw.PLUS);
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        Object j6;
        Object j7 = this.f23971j.j(map);
        if (j7 == null || (j6 = this.xt.j(map)) == null) {
            return null;
        }
        if (!(j7 instanceof String) && !(j6 instanceof String)) {
            return com.bytedance.adsdk.xt.xt.up.j.tl.j((Number) j7, (Number) j6);
        }
        StringBuilder sb = f23976r.get();
        sb.append(j7);
        sb.append(j6);
        String sb2 = sb.toString();
        sb.setLength(0);
        return sb2;
    }
}
