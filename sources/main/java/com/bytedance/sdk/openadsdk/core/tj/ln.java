package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ln {
    private com.bykv.vk.openvk.component.video.api.cw.j cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.cw.cw f30327j;
    private com.bykv.vk.openvk.component.video.api.cw.cw xt;

    public ln() {
    }

    public static com.bykv.vk.openvk.component.video.api.cw.r i(n nVar) {
        ln zs;
        com.bykv.vk.openvk.component.video.api.cw.r j6 = j(4, nVar);
        j6.j(true);
        if (nVar != null && (zs = nVar.zs()) != null) {
            com.bykv.vk.openvk.component.video.api.cw.cw ch = j6.ch();
            com.bykv.vk.openvk.component.video.api.cw.j jVar = zs.cw;
            if (jVar != null && ch != null) {
                ch.cw(jVar.up());
                ch.up(0);
                ch.r(0);
                ch.up(zs.cw.xt());
                ch.j(zs.cw.cw());
                ch.xt(zs.cw.r());
                ch.j(zs.cw.m() * (zs.cw.ae() + 1));
            }
        }
        return j6;
    }

    public static com.bykv.vk.openvk.component.video.api.cw.cw jy(n nVar) {
        return j(nVar, 0);
    }

    public void j(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.cw.cw cwVar = this.f30327j;
            if (cwVar != null) {
                jSONObject.put("video", cwVar.mi());
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        try {
            com.bykv.vk.openvk.component.video.api.cw.cw cwVar2 = this.xt;
            if (cwVar2 != null) {
                jSONObject.put("h265_video", cwVar2.mi());
            }
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
        }
        try {
            com.bykv.vk.openvk.component.video.api.cw.j jVar = this.cw;
            if (jVar != null) {
                jSONObject.put("audio", jVar.j());
            }
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.vl.j(e8);
        }
    }

    public ln(JSONObject jSONObject) {
        ln lnVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject != null) {
            com.bykv.vk.openvk.component.video.api.cw.cw cwVar = new com.bykv.vk.openvk.component.video.api.cw.cw();
            cwVar.xt(optJSONObject.optInt("cover_height"));
            cwVar.cw(optJSONObject.optInt("cover_width"));
            cwVar.j(optJSONObject.optString("resolution"));
            str4 = "cover_width";
            cwVar.j(optJSONObject.optLong("size"));
            cwVar.j(optJSONObject.optDouble("video_duration"));
            cwVar.xt(optJSONObject.optString("cover_url"));
            cwVar.cw(optJSONObject.optString("video_url"));
            cwVar.r(optJSONObject.optString("endcard"));
            cwVar.up(optJSONObject.optString("file_hash"));
            str = "endcard";
            str2 = "video_url";
            cwVar.j((float) optJSONObject.optDouble("play_speed_ratio", -1.0d));
            cwVar.j(optJSONObject.optInt("fallback_endcard_judge", 0));
            cwVar.r(optJSONObject.optInt("video_preload_size", 307200));
            str5 = "reward_video_cached_type";
            cwVar.up(optJSONObject.optInt(str5, 0));
            cwVar.m(optJSONObject.optInt("execute_cached_type", 0));
            str3 = "resolution";
            cwVar.xt(optJSONObject.optDouble("start", -1.0d));
            lnVar = this;
            lnVar.f30327j = cwVar;
        } else {
            lnVar = this;
            str = "endcard";
            str2 = "video_url";
            str3 = "resolution";
            str4 = "cover_width";
            str5 = "reward_video_cached_type";
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (optJSONObject2 != null) {
            com.bykv.vk.openvk.component.video.api.cw.cw cwVar2 = new com.bykv.vk.openvk.component.video.api.cw.cw();
            cwVar2.xt(optJSONObject2.optInt("cover_height"));
            cwVar2.cw(optJSONObject2.optInt(str4));
            cwVar2.j(optJSONObject2.optString(str3));
            cwVar2.j(optJSONObject2.optLong("size"));
            cwVar2.j(optJSONObject2.optDouble("video_duration"));
            cwVar2.xt(optJSONObject2.optString("cover_url"));
            cwVar2.cw(optJSONObject2.optString(str2));
            cwVar2.r(optJSONObject2.optString(str));
            cwVar2.up(optJSONObject2.optString("file_hash"));
            cwVar2.j((float) optJSONObject2.optDouble("play_speed_ratio", -1.0d));
            cwVar2.j(optJSONObject2.optInt("fallback_endcard_judge", 0));
            cwVar2.r(optJSONObject2.optInt("video_preload_size", 307200));
            cwVar2.up(optJSONObject2.optInt(str5, 0));
            cwVar2.m(optJSONObject2.optInt("execute_cached_type", 0));
            cwVar2.xt(optJSONObject2.optDouble("start", -1.0d));
            lnVar.xt = cwVar2;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("audio");
        if (optJSONObject3 != null) {
            com.bykv.vk.openvk.component.video.api.cw.j jVar = new com.bykv.vk.openvk.component.video.api.cw.j();
            jVar.xt(optJSONObject3.optString("audio_url"));
            jVar.j(optJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            jVar.xt(optJSONObject3.optLong("audio_preload_size", -2147483648L));
            jVar.j(optJSONObject3.optLong("size", -2147483648L));
            jVar.j(optJSONObject3.optString("file_hash"));
            jVar.xt(optJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            jVar.j(optJSONObject3.optDouble("start", -1.0d));
            jVar.xt(optJSONObject3.optInt("repeat_count", 0));
            lnVar.cw = jVar;
        }
    }

    public static int[] up(n nVar) {
        com.bykv.vk.openvk.component.video.api.cw.cw az;
        if (nVar == null) {
            return null;
        }
        if (nVar.ve() == 166 && ed.j(nVar)) {
            return new int[]{ed.vl(nVar), ed.jy(nVar)};
        }
        if (nVar.ly() == 1 && nVar.qg() == 1 && (az = az(nVar)) != null) {
            return az.oq();
        }
        com.bykv.vk.openvk.component.video.api.cw.cw ws = ws(nVar);
        if (ws != null) {
            return ws.oq();
        }
        return null;
    }

    private static ln w(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.zs();
    }

    public static String ae(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            return com.bykv.vk.openvk.component.video.api.m.xt.j(ed.ae(nVar));
        }
        if (com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
            return av(nVar).xt();
        }
        return w5.f30327j.az();
    }

    public static com.bykv.vk.openvk.component.video.api.cw.j av(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return null;
        }
        return w5.cw;
    }

    public static com.bykv.vk.openvk.component.video.api.cw.cw az(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return null;
        }
        return w5.xt;
    }

    public static int cw(n nVar) {
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar;
        ln w5 = w(nVar);
        if (w5 == null || (cwVar = w5.f30327j) == null) {
            return 0;
        }
        return cwVar.xt();
    }

    public static int g(n nVar) {
        if (w(nVar) == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(j(nVar))) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (TextUtils.isEmpty(xt(nVar))) {
            return TTAdConstant.VIDEO_COVER_URL_CODE;
        }
        return 200;
    }

    public static double m(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return 0.0d;
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            int xt = ed.xt(nVar);
            com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = nVar.rr();
            if (rr != null && rr.kt() == 9) {
                xt *= 2;
            }
            return xt;
        }
        if (com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
            return ((int) av(nVar).m()) * (av(nVar).ae() + 1);
        }
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar = w5.f30327j;
        if (cwVar == null) {
            return 0.0d;
        }
        return cwVar.m();
    }

    public static boolean oq(n nVar) {
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar;
        ln w5 = w(nVar);
        if (w5 == null || (cwVar = w5.f30327j) == null || cwVar.j() != 1) {
            return false;
        }
        return true;
    }

    public static boolean qv(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null || w5.cw == null) {
            return false;
        }
        return true;
    }

    public static int r(n nVar) {
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar;
        ln w5 = w(nVar);
        if (w5 == null || (cwVar = w5.f30327j) == null) {
            return 0;
        }
        return cwVar.cw();
    }

    public static String tl(n nVar) {
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar;
        ln w5 = w(nVar);
        if (w5 == null || (cwVar = w5.f30327j) == null) {
            return "";
        }
        return cwVar.jy();
    }

    public static boolean vl(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return false;
        }
        return w5.f30327j.f();
    }

    public static com.bykv.vk.openvk.component.video.api.cw.cw ws(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar = w5.f30327j;
        if (cwVar != null) {
            return cwVar;
        }
        if (com.bytedance.sdk.openadsdk.l.oq.j(nVar) && hh.xt(nVar) == 3) {
            return cwVar;
        }
        if (!com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
            return w5.f30327j;
        }
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar2 = new com.bykv.vk.openvk.component.video.api.cw.cw();
        if (com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
            cwVar2.cw(w5.cw.up());
            cwVar2.up(0);
            cwVar2.r(0);
            cwVar2.up(w5.cw.xt());
            cwVar2.j(w5.cw.cw());
            cwVar2.j(w5.cw.m() * (w5.cw.ae() + 1));
        }
        w5.f30327j = cwVar2;
        return cwVar2;
    }

    public static String xt(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            return ed.tl(nVar);
        }
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar = w5.f30327j;
        if (cwVar == null) {
            return "";
        }
        return cwVar.qv();
    }

    public void j(com.bykv.vk.openvk.component.video.api.cw.cw cwVar) {
        this.f30327j = cwVar;
    }

    public static String j(n nVar) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            return ed.ae(nVar);
        }
        if (com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
            return av(nVar).up();
        }
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar = w5.f30327j;
        if (cwVar == null) {
            return "";
        }
        return cwVar.vl();
    }

    public static com.bykv.vk.openvk.component.video.api.cw.cw j(n nVar, int i6) {
        ln w5 = w(nVar);
        if (w5 == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar = new com.bykv.vk.openvk.component.video.api.cw.cw();
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar2 = w5.f30327j;
        if (cwVar2 != null) {
            cwVar.xt(cwVar2.xt());
            cwVar.cw(w5.f30327j.cw());
            cwVar.j(w5.f30327j.g());
            cwVar.j(w5.f30327j.up());
            cwVar.j(w5.f30327j.m());
            cwVar.xt(w5.f30327j.qv());
            cwVar.cw(w5.f30327j.vl());
            cwVar.r(w5.f30327j.jy());
            cwVar.up(w5.f30327j.az());
            cwVar.j(w5.f30327j.j());
            cwVar.r(w5.f30327j.av());
            cwVar.up(w5.f30327j.i());
            cwVar.m(w5.f30327j.w());
            cwVar.j(w5.f30327j.tl());
            cwVar.xt(w5.f30327j.ae());
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            cwVar.xt(ed.tl(nVar));
            cwVar.cw(ed.ae(nVar));
            cwVar.up(com.bykv.vk.openvk.component.video.api.m.xt.j(ed.ae(nVar)));
            cwVar.j(-1L);
            cwVar.j(ed.xt(nVar));
            cwVar.r(0);
            cwVar.up(1);
        }
        if (com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
            cwVar.cw(w5.cw.up());
            cwVar.up(0);
            cwVar.r(0);
            cwVar.up(w5.cw.xt());
            cwVar.j(w5.cw.cw());
            cwVar.xt(w5.cw.r());
            cwVar.j(w5.cw.m() * (w5.cw.ae() + 1));
        }
        return cwVar;
    }

    public static com.bykv.vk.openvk.component.video.api.cw.r j(int i6, n nVar, int i7) {
        String j6;
        if (nVar.ly() == 1 && !com.bytedance.sdk.openadsdk.core.h.r()) {
            nVar.b(0);
        }
        if (com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
            nVar.b(0);
        }
        if (i6 == 1) {
            j6 = com.bytedance.sdk.openadsdk.l.g.j(nVar.ly()).j();
        } else if (i6 == 2) {
            j6 = com.bytedance.sdk.openadsdk.l.g.j(nVar.ly()).xt();
        } else if (i6 == 3) {
            j6 = com.bytedance.sdk.openadsdk.l.g.j(nVar.ly()).cw();
        } else if (i6 != 4) {
            j6 = "";
        } else {
            j6 = com.bytedance.sdk.openadsdk.l.g.j(nVar.ly()).r();
        }
        com.bykv.vk.openvk.component.video.api.cw.r rVar = new com.bykv.vk.openvk.component.video.api.cw.r(j6, j(nVar, i7), az(nVar), nVar.ly(), nVar.qg());
        rVar.j(nVar.tz());
        return rVar;
    }

    public static com.bykv.vk.openvk.component.video.api.cw.r j(int i6, n nVar) {
        return j(i6, nVar, 0);
    }
}
