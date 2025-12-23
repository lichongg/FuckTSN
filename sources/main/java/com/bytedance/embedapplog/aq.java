package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.umeng.socialize.common.SocializeConstants;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class aq extends ya {
    public int az = 0;
    long jy;
    long vl;
    String ws;

    @Override // com.bytedance.embedapplog.ya
    protected List<String> j() {
        return null;
    }

    @Override // com.bytedance.embedapplog.ya
    protected JSONObject xt() {
        ry ryVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.xt);
        jSONObject.put("tea_event_index", this.cw);
        jSONObject.put("session_id", this.f24107r);
        jSONObject.put("stop_timestamp", this.jy / 1000);
        jSONObject.put("duration", this.vl / 1000);
        jSONObject.put("datetime", this.qv);
        long j6 = this.up;
        if (j6 > 0) {
            jSONObject.put(SocializeConstants.TENCENT_UID, j6);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f24106m) ? JSONObject.NULL : this.f24106m);
        if (!TextUtils.isEmpty(this.ae)) {
            jSONObject.put("ssid", this.ae);
        }
        if (!TextUtils.isEmpty(this.tl)) {
            jSONObject.put("ab_sdk_version", this.tl);
        }
        if (!TextUtils.isEmpty(this.ws)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.ws, this.f24107r)) {
                jSONObject.put("original_session_id", this.ws);
            }
        }
        if (this.az == 0 && (ryVar = (ry) sm.xt.get("launch")) != null && !ryVar.kt) {
            this.az = 6;
        }
        jSONObject.put("launch_from", this.az);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ya
    public int j(@NonNull Cursor cursor) {
        uc.xt((Throwable) null);
        return 0;
    }

    @Override // com.bytedance.embedapplog.ya
    @NonNull
    String r() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.ya
    protected String tl() {
        return String.valueOf(this.vl);
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull ContentValues contentValues) {
        uc.xt((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull JSONObject jSONObject) {
        uc.xt((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.ya
    protected ya xt(@NonNull JSONObject jSONObject) {
        uc.xt((Throwable) null);
        return this;
    }
}
