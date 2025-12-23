package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.swiper.Swiper;
import io.netty.util.internal.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends com.bytedance.adsdk.ugeno.xt.j<Swiper> {

    /* renamed from: d, reason: collision with root package name */
    private boolean f23854d;
    private float et;
    private float fx;
    private com.bytedance.adsdk.ugeno.xt.cw gr;
    private String ll;
    private JSONArray na;
    private float nu;
    private float ov;
    private boolean oy;
    private float px;
    private float qe;
    private int tk;
    private int wi;
    private String xw;
    private boolean yl;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public View j() {
        Swiper swiper = new Swiper(this.xt);
        this.up = swiper;
        swiper.j((cw) this);
        return this.up;
    }

    public xt(Context context) {
        super(context);
        this.oy = true;
        this.yl = true;
        this.qe = 0.0f;
        this.px = 2000.0f;
        this.xw = PrerollVideoResponse.NORMAL;
        this.f23854d = true;
        this.wi = Color.parseColor("#666666");
        this.tk = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        JSONArray jSONArray = this.na;
        if (jSONArray != null && jSONArray.length() > 0) {
            ((Swiper) this.up).r((int) this.et).up((int) this.ov).m((int) this.nu).cw(this.f23854d).xt(this.tk).cw(this.wi).xt(this.xw).r(this.oy).j(this.fx).j(this.yl).j((int) this.px).cw(this.f23854d);
            for (int i6 = 0; i6 < this.na.length(); i6++) {
                az azVar = new az(this.xt);
                azVar.j(this.f23874t);
                com.bytedance.adsdk.ugeno.xt.cw<View> xt = azVar.xt(this.gr.l(), null);
                azVar.xt(this.na.optJSONObject(i6));
                ((Swiper) this.up).j((Swiper) xt);
            }
            if (this.yl) {
                ((Swiper) this.up).xt();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.gr = cwVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    c6 = 3;
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c6 = 4;
                    break;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    c6 = 5;
                    break;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    c6 = 6;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c6 = 7;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    c6 = 11;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                this.qe = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 1:
                this.wi = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case 2:
                this.nu = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
            case 3:
                this.xw = str2;
                break;
            case 4:
                this.ll = str2;
                break;
            case 5:
                this.f23854d = com.bytedance.adsdk.ugeno.m.cw.j(str2, true);
                break;
            case 6:
                this.ov = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
            case 7:
                this.oy = com.bytedance.adsdk.ugeno.m.cw.j(str2, true);
                break;
            case '\b':
                this.px = com.bytedance.adsdk.ugeno.m.cw.j(str2, 500.0f);
                break;
            case '\t':
                this.fx = com.bytedance.adsdk.ugeno.m.cw.j(str2, 1.0f);
                break;
            case '\n':
                this.et = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
            case 11:
                this.tk = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case '\f':
                this.yl = com.bytedance.adsdk.ugeno.m.cw.j(str2, true);
                break;
            case '\r':
                this.na = com.bytedance.adsdk.ugeno.m.xt.j(str2, (JSONArray) null);
                break;
        }
    }
}
