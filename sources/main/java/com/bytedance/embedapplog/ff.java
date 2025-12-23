package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ff extends ya {
    protected String jy;
    protected String vl;
    private boolean ws;

    public ff(String str, boolean z5, String str2) {
        this.jy = str;
        this.ws = z5;
        this.vl = str2;
        this.oq = 0;
    }

    @Override // com.bytedance.embedapplog.ya
    protected List<String> j() {
        List<String> j6 = super.j();
        ArrayList arrayList = new ArrayList(j6.size());
        arrayList.addAll(j6);
        arrayList.addAll(Arrays.asList("event", "varchar", "params", "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ya
    protected JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.xt);
        jSONObject.put("tea_event_index", this.cw);
        jSONObject.put("session_id", this.f24107r);
        long j6 = this.up;
        if (j6 > 0) {
            jSONObject.put(SocializeConstants.TENCENT_UID, j6);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f24106m) ? JSONObject.NULL : this.f24106m);
        if (!TextUtils.isEmpty(this.ae)) {
            jSONObject.put("ssid", this.ae);
        }
        jSONObject.put("event", this.jy);
        if (this.ws) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.vl)) {
            jSONObject.put("params", new JSONObject(this.vl));
        }
        jSONObject.put("datetime", this.qv);
        if (!TextUtils.isEmpty(this.tl)) {
            jSONObject.put("ab_sdk_version", this.tl);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ya
    public String g() {
        return this.vl;
    }

    @Override // com.bytedance.embedapplog.ya
    @NonNull
    String r() {
        return "eventv3";
    }

    @Override // com.bytedance.embedapplog.ya
    protected String tl() {
        return this.jy;
    }

    @Override // com.bytedance.embedapplog.ya
    public int j(@NonNull Cursor cursor) {
        int j6 = super.j(cursor);
        this.jy = cursor.getString(j6);
        int i6 = j6 + 2;
        this.vl = cursor.getString(j6 + 1);
        int i7 = j6 + 3;
        this.ws = cursor.getInt(i6) == 1;
        return i7;
    }

    public ff(String str, boolean z5, String str2, int i6) {
        this.jy = str;
        this.ws = z5;
        this.vl = str2;
        this.oq = i6;
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull ContentValues contentValues) {
        super.j(contentValues);
        contentValues.put("event", this.jy);
        contentValues.put("params", this.vl);
        contentValues.put("is_bav", Integer.valueOf(this.ws ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull JSONObject jSONObject) {
        super.j(jSONObject);
        jSONObject.put("event", this.jy);
        jSONObject.put("params", this.vl);
        jSONObject.put("is_bav", this.ws);
    }

    @Override // com.bytedance.embedapplog.ya
    protected ya xt(@NonNull JSONObject jSONObject) {
        super.xt(jSONObject);
        this.jy = jSONObject.optString("event", null);
        this.vl = jSONObject.optString("params", null);
        this.ws = jSONObject.optBoolean("is_bav", false);
        return this;
    }
}
