package com.bytedance.adsdk.xt.xt.xt.j;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq implements com.bytedance.adsdk.xt.xt.xt.j {
    private com.bytedance.adsdk.xt.xt.j.j cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.adsdk.xt.xt.xt.j[] f23974j;
    private String xt;

    public void j(com.bytedance.adsdk.xt.xt.xt.j[] jVarArr) {
        this.f23974j = jVarArr;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        com.bytedance.adsdk.xt.xt.j.j jVar = new com.bytedance.adsdk.xt.xt.j.j();
        this.cw = jVar;
        jVar.j(this.xt);
        Object[] objArr = new Object[this.f23974j.length];
        int i6 = 0;
        while (true) {
            com.bytedance.adsdk.xt.xt.xt.j[] jVarArr = this.f23974j;
            if (i6 >= jVarArr.length) {
                this.cw.j(objArr);
                return com.bytedance.adsdk.xt.qv.j(this.xt).j(map.get("default_key"), objArr);
            }
            com.bytedance.adsdk.xt.xt.xt.j jVar2 = jVarArr[i6];
            if (jVar2 != null) {
                objArr[i6] = jVar2.j(map);
            }
            i6++;
        }
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public String xt() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.xt);
        sb.append("(");
        com.bytedance.adsdk.xt.xt.xt.j[] jVarArr = this.f23974j;
        if (jVarArr != null && jVarArr.length > 0) {
            int i6 = 0;
            while (true) {
                com.bytedance.adsdk.xt.xt.xt.j[] jVarArr2 = this.f23974j;
                if (i6 >= jVarArr2.length) {
                    break;
                }
                sb.append(jVarArr2[i6].xt());
                sb.append(",");
                i6++;
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public oq(String str) {
        this.xt = str;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public com.bytedance.adsdk.xt.xt.r.up j() {
        return com.bytedance.adsdk.xt.xt.r.xt.METHOD;
    }
}
