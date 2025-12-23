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
public class kc extends ya {
    public String av;
    public String az;

    /* renamed from: i, reason: collision with root package name */
    public String f24004i;
    public String jy;
    public String kt;
    public int mi;
    public long vl;

    /* renamed from: w, reason: collision with root package name */
    public String f24005w;
    public String ws;

    @Override // com.bytedance.embedapplog.ya
    protected List<String> j() {
        List<String> j6 = super.j();
        ArrayList arrayList = new ArrayList(j6.size());
        arrayList.addAll(j6);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer", "last_session", "varchar", ArticleInfo.PAGE_TITLE, "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ya
    protected ya xt(@NonNull JSONObject jSONObject) {
        super.xt(jSONObject);
        this.ws = jSONObject.optString("page_key", null);
        this.jy = jSONObject.optString("refer_page_key", null);
        this.vl = jSONObject.optLong("duration", 0L);
        this.mi = jSONObject.optInt("is_back", 0);
        this.az = jSONObject.optString(ArticleInfo.PAGE_TITLE, null);
        this.av = jSONObject.optString("refer_page_title", null);
        this.f24004i = jSONObject.optString("page_path", null);
        this.f24005w = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    private JSONObject vl() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.ws);
        jSONObject.put("refer_page_key", this.jy);
        jSONObject.put("is_back", this.mi);
        jSONObject.put("duration", this.vl);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.az);
        jSONObject.put("refer_page_title", this.av);
        jSONObject.put("page_path", this.f24004i);
        jSONObject.put("referrer_page_path", this.f24005w);
        return jSONObject;
    }

    public boolean oq() {
        return this.vl == -1;
    }

    public boolean qv() {
        return this.ws.contains(":");
    }

    @Override // com.bytedance.embedapplog.ya
    @NonNull
    String r() {
        return "page";
    }

    @Override // com.bytedance.embedapplog.ya
    protected String tl() {
        return this.ws + ", " + this.vl;
    }

    @Override // com.bytedance.embedapplog.ya
    public int j(@NonNull Cursor cursor) {
        int j6 = super.j(cursor);
        this.ws = cursor.getString(j6);
        this.jy = cursor.getString(j6 + 1);
        this.vl = cursor.getLong(j6 + 2);
        this.mi = cursor.getInt(j6 + 3);
        this.kt = cursor.getString(j6 + 4);
        this.az = cursor.getString(j6 + 5);
        this.av = cursor.getString(j6 + 6);
        int i6 = j6 + 8;
        this.f24004i = cursor.getString(j6 + 7);
        int i7 = j6 + 9;
        this.f24005w = cursor.getString(i6);
        return i7;
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", vl());
        jSONObject.put("datetime", this.qv);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull ContentValues contentValues) {
        super.j(contentValues);
        contentValues.put("page_key", this.ws);
        contentValues.put("refer_page_key", this.jy);
        contentValues.put("duration", Long.valueOf(this.vl));
        contentValues.put("is_back", Integer.valueOf(this.mi));
        contentValues.put("last_session", this.kt);
        contentValues.put(ArticleInfo.PAGE_TITLE, this.az);
        contentValues.put("refer_page_title", this.av);
        contentValues.put("page_path", this.f24004i);
        contentValues.put("referrer_page_path", this.f24005w);
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull JSONObject jSONObject) {
        super.j(jSONObject);
        jSONObject.put("page_key", this.ws);
        jSONObject.put("refer_page_key", this.jy);
        jSONObject.put("duration", this.vl);
        jSONObject.put("is_back", this.mi);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.az);
        jSONObject.put("refer_page_title", this.av);
        jSONObject.put("page_path", this.f24004i);
        jSONObject.put("referrer_page_path", this.f24005w);
    }
}
