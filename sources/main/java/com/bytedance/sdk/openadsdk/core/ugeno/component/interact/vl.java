package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends com.bytedance.adsdk.ugeno.xt.cw<InteractWebView> {

    /* renamed from: j, reason: collision with root package name */
    private String f30616j;
    private Map<String, Object> ll;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public InteractWebView j() {
        InteractWebView interactWebView = new InteractWebView(this.xt);
        this.up = interactWebView;
        return interactWebView;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        if (str.equals("src")) {
            if (TextUtils.isEmpty(this.f30616j) || !this.f30616j.startsWith(b.f50154a)) {
                this.f30616j = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            } else {
                this.f30616j = str2;
            }
        }
    }

    public void tl() {
        if (TextUtils.isEmpty(this.f30616j)) {
            this.f30616j = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.up).loadUrl(this.f30616j);
    }

    public vl(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        Map<String, Object> xt = this.f23861g.xt();
        this.ll = xt;
        ((InteractWebView) this.up).setUGenExtraMap(xt);
        ((InteractWebView) this.up).setUGenContext(this.f23861g);
        ((InteractWebView) this.up).m();
        ((InteractWebView) this.up).ae();
        JSONObject oq = oq();
        if (oq != null) {
            com.bytedance.sdk.component.widget.xt.j jVar = new com.bytedance.sdk.component.widget.xt.j();
            jVar.j(oq.optInt("meta_hashcode", 0));
            ((InteractWebView) this.up).setMaterialMeta(jVar);
        }
        tl();
    }
}
