package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class k extends ya {

    @NonNull
    private String jy;

    @NonNull
    private String vl;

    @Override // com.bytedance.embedapplog.ya
    protected List<String> j() {
        List<String> j6 = super.j();
        ArrayList arrayList = new ArrayList(j6.size());
        arrayList.addAll(j6);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
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
        jSONObject.put("log_type", this.jy);
        try {
            JSONObject jSONObject2 = new JSONObject(this.vl);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    uc.xt("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
            return jSONObject;
        } catch (Exception e6) {
            uc.cw("解析 event misc 失败", e6);
            return jSONObject;
        }
    }

    @Override // com.bytedance.embedapplog.ya
    protected String g() {
        return this.vl;
    }

    @Override // com.bytedance.embedapplog.ya
    @NonNull
    String r() {
        return "event_misc";
    }

    @Override // com.bytedance.embedapplog.ya
    protected String tl() {
        return "param:" + this.vl + " logType:" + this.jy;
    }

    public k(@NonNull String str, @NonNull JSONObject jSONObject) {
        this.jy = str;
        this.vl = jSONObject.toString();
        this.oq = 0;
    }

    @Override // com.bytedance.embedapplog.ya
    public int j(@NonNull Cursor cursor) {
        int j6 = super.j(cursor);
        int i6 = j6 + 1;
        this.vl = cursor.getString(j6);
        int i7 = j6 + 2;
        this.jy = cursor.getString(i6);
        return i7;
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull ContentValues contentValues) {
        super.j(contentValues);
        contentValues.put("params", this.vl);
        contentValues.put("log_type", this.jy);
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull JSONObject jSONObject) {
        super.j(jSONObject);
        jSONObject.put("params", this.vl);
        jSONObject.put("log_type", this.jy);
    }

    @Override // com.bytedance.embedapplog.ya
    protected ya xt(@NonNull JSONObject jSONObject) {
        super.xt(jSONObject);
        this.vl = jSONObject.optString("params", null);
        this.jy = jSONObject.optString("log_type", null);
        return this;
    }
}
