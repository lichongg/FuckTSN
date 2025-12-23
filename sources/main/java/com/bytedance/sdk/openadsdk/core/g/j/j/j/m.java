package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    private View ae;
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.g.j.j.j f28985j;

    /* renamed from: m, reason: collision with root package name */
    private int f28986m;

    /* renamed from: r, reason: collision with root package name */
    private String f28987r;
    private Map<String, Object> tl;
    private String up;
    private n xt;

    public static boolean j(int i6) {
        switch (i6) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public void xt(Map<String, Object> map) {
        this.tl = map;
    }

    private void xt() {
        n nVar = this.xt;
        if (nVar != null) {
            this.f28986m = nVar.ww();
        } else {
            this.f28986m = -1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(Map<String, Object> map) {
        boolean j6 = j();
        xt();
        if (j6) {
            return true;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("event_tag", this.f28987r);
        if (!TextUtils.isEmpty(this.up)) {
            hashMap.put("dpa_tag", this.up);
        }
        if ((com.bytedance.sdk.openadsdk.core.live.xt.j().j(this.cw, this.xt, hashMap) & 255) == 0) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.g.j.j.j jVar = this.f28985j;
        return jVar != null && jVar.j(map);
    }

    public m(n nVar, Context context, String str, String str2) {
        this.xt = nVar;
        this.cw = context;
        this.f28987r = str;
        this.up = str2;
        xt();
    }

    public void xt(int i6) {
        this.f28986m = i6;
    }

    private boolean j() {
        if (this.f28986m < 2) {
            return false;
        }
        HashMap hashMap = new HashMap(2);
        if (j(this.f28986m)) {
            hashMap.put("live_saas_param_interaction_type", Integer.valueOf(this.f28986m));
        }
        hashMap.put("event_tag", this.f28987r);
        String str = this.up;
        if (str != null) {
            hashMap.put("dpa_tag", str);
        }
        if (this.tl == null) {
            this.tl = new HashMap();
        }
        com.bytedance.sdk.openadsdk.core.live.xt.j().j(this.ae, this.xt.yx(), hashMap, this.tl);
        int j6 = com.bytedance.sdk.openadsdk.core.live.xt.j().j(this.cw, this.xt, hashMap);
        int i6 = j6 & 255;
        int i7 = (j6 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i7 > 0) {
            this.tl.put("click_saas_action", Integer.valueOf(i7));
        }
        return i6 == 0;
    }

    public void j(View view) {
        this.ae = view;
    }
}
