package com.bytedance.sdk.openadsdk.core.live.j;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.c;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements r {
    protected JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    protected volatile Function<SparseArray<Object>, Object> f29472j = null;
    protected volatile String xt;

    public void a_(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public long cw() {
        return -1L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void j() {
    }

    protected abstract boolean x_();

    protected boolean a_(n nVar) {
        if (nVar == null) {
            return false;
        }
        return j(nVar.re(), nVar.ww());
    }

    protected int cw(n nVar) {
        i m111if;
        if (1 != com.bytedance.sdk.openadsdk.core.live.xt.j().up()) {
            return 2;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.up.j.j(nVar)) {
            return 3;
        }
        if (nVar != null && uf.xt(v.getContext()) && (m111if = nVar.m111if()) != null) {
            String xt = m111if.xt();
            if (!TextUtils.isEmpty(xt)) {
                Uri parse = Uri.parse(xt);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                return uf.xt(v.getContext(), intent, true) ? 0 : 4;
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(String str, n nVar, long j6) {
    }

    protected long xt(n nVar) {
        if (nVar == null) {
            return 0L;
        }
        String re = nVar.re();
        if (TextUtils.isEmpty(re)) {
            re = j(nVar.m111if());
        }
        try {
            return Long.parseLong(re);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        this.f29472j = function;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public boolean j(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i6) {
            }
            return false;
        }
    }

    protected String j(i iVar) {
        Map<String, String> j6;
        if (iVar == null) {
            return null;
        }
        String xt = iVar.xt();
        if (TextUtils.isEmpty(xt)) {
            return null;
        }
        if ((xt.startsWith("snssdk2329") || xt.startsWith("snssdk1128")) && (j6 = c.j(xt)) != null) {
            return j6.get("room_id");
        }
        return null;
    }

    protected String j(n nVar, String str, Map map) {
        if (map != null) {
            try {
                String str2 = (String) map.get("dpa_tag");
                if (!TextUtils.isEmpty(str2)) {
                    String up = com.bytedance.sdk.openadsdk.core.tj.v.up(nVar, str2);
                    if (!TextUtils.isEmpty(up)) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = new JSONObject(up);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.putOpt(next, jSONObject2.opt(next));
                        }
                        return jSONObject.toString();
                    }
                }
            } catch (Exception e6) {
                vl.xt("TTLiveSDkBridge", e6);
                ws.j().j("getEcomLiveParams", e6);
                return str;
            }
        }
        return str;
    }

    protected void j(n nVar, String str, int i6, int i7, int i8) {
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, str, i6, i7, i8, x_());
    }

    protected boolean j(n nVar, int i6) {
        return nVar.ww() == 7 || i6 == 103;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void r(n nVar) {
    }
}
