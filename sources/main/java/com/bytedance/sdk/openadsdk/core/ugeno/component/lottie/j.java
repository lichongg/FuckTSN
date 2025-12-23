package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.kt;
import com.bytedance.adsdk.lottie.r;
import com.bytedance.adsdk.lottie.tj;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {
    private View px;
    private boolean qe;

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j$5, reason: invalid class name */
    class AnonymousClass5 implements r {
        @Override // com.bytedance.adsdk.lottie.r
        public Bitmap j(final g gVar) {
            final String str;
            if (gVar == null) {
                return null;
            }
            String jy = gVar.jy();
            String vl = gVar.vl();
            String r5 = gVar.r();
            if (!TextUtils.isEmpty(r5) && r5.startsWith("${") && "image:".equals(jy)) {
                str = com.bytedance.adsdk.ugeno.r.xt.j(r5, ((cw) j.this).f23872r);
            } else if (!TextUtils.isEmpty(jy) && TextUtils.isEmpty(vl)) {
                str = com.bytedance.adsdk.ugeno.r.xt.j(jy, ((cw) j.this).f23872r);
            } else if (!TextUtils.isEmpty(vl) && TextUtils.isEmpty(jy)) {
                str = com.bytedance.adsdk.ugeno.r.xt.j(vl, ((cw) j.this).f23872r);
            } else if (TextUtils.isEmpty(vl) || TextUtils.isEmpty(jy)) {
                str = null;
            } else {
                str = com.bytedance.adsdk.ugeno.r.xt.j(jy, ((cw) j.this).f23872r) + com.bytedance.adsdk.ugeno.r.xt.j(vl, ((cw) j.this).f23872r);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap bitmap = ((xt) j.this).ll.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.r.j().xt().j(((cw) j.this).f23861g, str, new j.InterfaceC0320j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j.5.1
                @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                public void j(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, gVar.j(), gVar.xt(), false);
                        ((xt) j.this).ll.put(str, createScaledBitmap);
                        tl.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((UgenLottieView) ((cw) j.this).up).j(gVar.qv(), createScaledBitmap);
                            }
                        });
                    }
                }
            });
            return ((xt) j.this).ll.get(str);
        }

        AnonymousClass5() {
        }
    }

    private void qb() {
        av avVar = new av();
        avVar.j(21);
        avVar.j(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", ((xt) this).f30641j);
            avVar.j(jSONObject);
            this.f23874t.j(avVar, this, this);
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt, com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae */
    public UgenLottieView j() {
        UgenLottieView j6 = super.j();
        j6.setTextDelegate(new kt(j6) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j.1
            @Override // com.bytedance.adsdk.lottie.kt
            public String j(String str) {
                return com.bytedance.adsdk.ugeno.r.xt.j(str, ((cw) j.this).f23872r);
            }
        });
        j6.setViewDelegate(new tj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j.2
            @Override // com.bytedance.adsdk.lottie.tj
            public View j(String str, Map<String, Object> map) {
                if (!"view:".equals(str) || map == null || map.isEmpty()) {
                    return null;
                }
                if (!j.this.qe) {
                    j.this.qe = true;
                    j.this.j(map);
                }
                return j.this.px;
            }
        });
        j6.setLottieClicklistener(new LottieAnimationView.xt() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j.3
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.xt
            public void j(String str, JSONArray jSONArray) {
                av avVar = new av();
                avVar.j(1);
                avVar.j(j.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    j.this.j(avVar, jSONArray);
                }
                if (((cw) j.this).f23874t != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lottieEvent", true);
                        jSONObject.put("uttieUrl", ((xt) j.this).f30641j);
                        if (TextUtils.equals("CSJCLOSE", str)) {
                            jSONObject.put("type", "close");
                        } else if (TextUtils.equals("clickEvent", str)) {
                            jSONObject.put("type", "clickEvent");
                        }
                        avVar.j(jSONObject);
                        w wVar = ((cw) j.this).f23874t;
                        j jVar = j.this;
                        wVar.j(avVar, jVar, jVar);
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
            }
        });
        j6.setLottieAnimListener(new LottieAnimationView.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j.4
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.j
            public void j(Map<String, Object> map) {
                j.this.j(map, 19);
            }

            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.j
            public void xt(Map<String, Object> map) {
                j.this.j(map, 20);
            }
        });
        return j6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt
    protected void tl() {
        T t5 = this.up;
        if (t5 == 0 || ((UgenLottieView) t5).getVisibility() != 0) {
            return;
        }
        ((UgenLottieView) this.up).setImageAssetDelegate(new AnonymousClass5());
        ((UgenLottieView) this.up).j();
        qb();
    }

    public j(Context context) {
        super(context);
        this.qe = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Map<String, Object> map, int i6) {
        av avVar = new av();
        avVar.j(i6);
        avVar.j(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                j(avVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get("duration");
                if (obj2 instanceof Long) {
                    jSONObject.put("duration", obj2);
                    jSONObject.put("uttieUrl", ((xt) this).f30641j);
                }
            }
            avVar.j(jSONObject);
            this.f23874t.j(avVar, this, this);
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(av avVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("vid");
                    if (!TextUtils.isEmpty(optString)) {
                        int optInt = optJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        cw j6 = j(avVar.j(), optString);
                        if (j6 != null) {
                            j6.xt(optInt == 0 ? 0 : 8);
                            View g6 = j6.g();
                            if (g6 instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) g6;
                                if (optInt == 0) {
                                    ugenLottieView.j();
                                    qb();
                                } else {
                                    ugenLottieView.m();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private cw j(cw cwVar, String str) {
        if (cwVar == null) {
            return null;
        }
        while (cwVar.h() != null) {
            cwVar = cwVar.h();
        }
        return cwVar.r(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Map<String, Object> map) {
        Object obj = map.get("ugen_url");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("ugen_md5");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        final int intValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
        Object obj5 = map.get("ugen_h");
        final int intValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (intValue <= 0 || intValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        JSONObject xt = oq.xt(str2, str);
        if (xt != null && xt.length() > 0) {
            j(xt, intValue, intValue2, str3);
        } else {
            oq.j(str2, str, new com.bytedance.sdk.openadsdk.core.ugeno.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.j.6
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.cw
                public void j(String str4) {
                    try {
                        j.this.j(new JSONObject(str4), intValue, intValue2, str3);
                    } catch (Throwable th) {
                        vl.j(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject, int i6, int i7, String str) {
        cw<View> j6;
        az azVar = new az(this.xt);
        if (str.startsWith("2")) {
            j6 = azVar.j(jSONObject);
            azVar.xt(this.f23872r);
        } else {
            j6 = str.startsWith("3") ? azVar.j(jSONObject, this.f23872r, (JSONObject) null) : null;
        }
        if (j6 != null) {
            this.px = j6.g();
        }
    }
}
