package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class gq extends l {

    /* renamed from: m, reason: collision with root package name */
    private final rn f23993m;
    private final Context up;

    gq(Context context, rn rnVar) {
        super(false, false);
        this.up = context;
        this.f23993m = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put("sdk_version_name", "3.9.1.baseChina-rc.42");
        jSONObject.put("channel", this.f23993m.oq());
        wq.j(jSONObject, CommonNetImpl.AID, this.f23993m.g());
        wq.j(jSONObject, "release_build", this.f23993m.s());
        wq.j(jSONObject, "app_region", this.f23993m.jy());
        wq.j(jSONObject, "app_language", this.f23993m.vl());
        wq.j(jSONObject, "user_agent", this.f23993m.a());
        wq.j(jSONObject, "ab_sdk_version", this.f23993m.az());
        wq.j(jSONObject, "ab_version", this.f23993m.mi());
        wq.j(jSONObject, "aliyun_uuid", this.f23993m.j());
        String qv = this.f23993m.qv();
        if (TextUtils.isEmpty(qv)) {
            qv = qa.j(this.up, this.f23993m);
        }
        if (!TextUtils.isEmpty(qv)) {
            wq.j(jSONObject, "google_aid", qv);
        }
        String ch = this.f23993m.ch();
        if (!TextUtils.isEmpty(ch)) {
            try {
                jSONObject.put("app_track", new JSONObject(ch));
            } catch (Throwable th) {
                uc.xt(th);
            }
        }
        String ws = this.f23993m.ws();
        if (ws != null && ws.length() > 0) {
            jSONObject.put("custom", new JSONObject(ws));
        }
        wq.j(jSONObject, "user_unique_id", this.f23993m.av());
        return true;
    }
}
