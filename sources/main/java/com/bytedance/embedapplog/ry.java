package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ry extends ya {
    public int av;
    public String az;

    /* renamed from: i, reason: collision with root package name */
    public String f24046i;
    public String jy;
    public boolean kt;
    public boolean mi;
    public int vl;

    /* renamed from: w, reason: collision with root package name */
    public String f24047w;
    public boolean ws;

    @Override // com.bytedance.embedapplog.ya
    protected List<String> j() {
        List<String> j6 = super.j();
        ArrayList arrayList = new ArrayList(j6.size());
        arrayList.addAll(j6);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", ArticleInfo.PAGE_TITLE, "varchar", "page_key", "varchar", "resume_from_background", "integer"));
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
        boolean z5 = this.ws;
        if (z5) {
            jSONObject.put("is_background", z5);
        }
        jSONObject.put("datetime", this.qv);
        if (!TextUtils.isEmpty(this.tl)) {
            jSONObject.put("ab_sdk_version", this.tl);
        }
        if (!TextUtils.isEmpty(this.az)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.az);
        }
        if (this.av == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.kt);
        jSONObject.put("is_background", !this.kt);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ya
    @NonNull
    String r() {
        return "launch";
    }

    @Override // com.bytedance.embedapplog.ya
    protected String tl() {
        return this.ws ? "bg" : "fg";
    }

    public ry(boolean z5) {
        this.kt = z5;
    }

    @Override // com.bytedance.embedapplog.ya
    public int j(@NonNull Cursor cursor) {
        int j6 = super.j(cursor);
        this.jy = cursor.getString(j6);
        this.vl = cursor.getInt(j6 + 1);
        this.az = cursor.getString(j6 + 2);
        this.av = cursor.getInt(j6 + 3);
        this.f24046i = cursor.getString(j6 + 4);
        int i6 = j6 + 6;
        this.f24047w = cursor.getString(j6 + 5);
        int i7 = j6 + 7;
        this.mi = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull ContentValues contentValues) {
        super.j(contentValues);
        contentValues.put("ver_name", this.jy);
        contentValues.put("ver_code", Integer.valueOf(this.vl));
        contentValues.put("last_session", this.az);
        contentValues.put("is_first_time", Integer.valueOf(this.av));
        contentValues.put(ArticleInfo.PAGE_TITLE, this.f24046i);
        contentValues.put("page_key", this.f24047w);
        contentValues.put("resume_from_background", Integer.valueOf(this.mi ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull JSONObject jSONObject) {
        uc.xt((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.ya
    protected ya xt(@NonNull JSONObject jSONObject) {
        uc.xt((Throwable) null);
        return null;
    }
}
