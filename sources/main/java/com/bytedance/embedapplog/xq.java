package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xq extends ya {
    public long av;
    public String az;

    /* renamed from: i, reason: collision with root package name */
    long f24100i;
    public String jy;
    public String vl;
    public String ws;

    @Override // com.bytedance.embedapplog.ya
    protected List<String> j() {
        List<String> j6 = super.j();
        ArrayList arrayList = new ArrayList(j6.size());
        arrayList.addAll(j6);
        arrayList.addAll(Arrays.asList("category", "varchar", CommonNetImpl.TAG, "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ya
    protected ya xt(@NonNull JSONObject jSONObject) {
        super.xt(jSONObject);
        this.cw = jSONObject.optLong("tea_event_index", 0L);
        this.vl = jSONObject.optString("category", null);
        this.jy = jSONObject.optString(CommonNetImpl.TAG, null);
        this.av = jSONObject.optLong("value", 0L);
        this.f24100i = jSONObject.optLong("ext_value", 0L);
        this.az = jSONObject.optString("params", null);
        this.ws = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.ya
    protected String g() {
        return this.az;
    }

    @Override // com.bytedance.embedapplog.ya
    @NonNull
    String r() {
        return "event";
    }

    @Override // com.bytedance.embedapplog.ya
    protected String tl() {
        return this.jy + ", " + this.ws;
    }

    xq() {
    }

    @Override // com.bytedance.embedapplog.ya
    public int j(@NonNull Cursor cursor) {
        int j6 = super.j(cursor);
        this.vl = cursor.getString(j6);
        this.jy = cursor.getString(j6 + 1);
        this.av = cursor.getLong(j6 + 2);
        this.f24100i = cursor.getLong(j6 + 3);
        int i6 = j6 + 5;
        this.az = cursor.getString(j6 + 4);
        int i7 = j6 + 6;
        this.ws = cursor.getString(i6);
        return i7;
    }

    @Override // com.bytedance.embedapplog.ya
    protected JSONObject xt() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.az) ? new JSONObject(this.az) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
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
        jSONObject.put("category", this.vl);
        jSONObject.put(CommonNetImpl.TAG, this.jy);
        jSONObject.put("value", this.av);
        jSONObject.put("ext_value", this.f24100i);
        jSONObject.put("label", this.ws);
        jSONObject.put("datetime", this.qv);
        if (!TextUtils.isEmpty(this.tl)) {
            jSONObject.put("ab_sdk_version", this.tl);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull ContentValues contentValues) {
        super.j(contentValues);
        contentValues.put("category", this.vl);
        contentValues.put(CommonNetImpl.TAG, this.jy);
        contentValues.put("value", Long.valueOf(this.av));
        contentValues.put("ext_value", Long.valueOf(this.f24100i));
        contentValues.put("params", this.az);
        contentValues.put("label", this.ws);
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull JSONObject jSONObject) {
        super.j(jSONObject);
        jSONObject.put("tea_event_index", this.cw);
        jSONObject.put("category", this.vl);
        jSONObject.put(CommonNetImpl.TAG, this.jy);
        jSONObject.put("value", this.av);
        jSONObject.put("ext_value", this.f24100i);
        jSONObject.put("params", this.az);
        jSONObject.put("label", this.ws);
    }
}
