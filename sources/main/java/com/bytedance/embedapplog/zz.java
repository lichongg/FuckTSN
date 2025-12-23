package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.embedapplog.sm;
import com.umeng.analytics.pro.bm;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class zz extends ya {
    long av;
    JSONArray az;

    /* renamed from: f, reason: collision with root package name */
    private JSONArray f24109f;

    /* renamed from: i, reason: collision with root package name */
    JSONArray f24110i;
    int jy;
    JSONArray kt;
    ry mi;
    long tj;

    /* renamed from: v, reason: collision with root package name */
    private aq f24111v;
    public byte[] vl;

    /* renamed from: w, reason: collision with root package name */
    long f24112w;
    public int ws;

    /* renamed from: x, reason: collision with root package name */
    private JSONObject f24113x;

    void j(JSONObject jSONObject, ry ryVar, aq aqVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i6) {
        j(0L);
        this.f24113x = jSONObject;
        this.mi = ryVar;
        this.f24111v = aqVar;
        this.f24109f = jSONArray;
        this.az = jSONArrayArr[0];
        this.av = jArr[0];
        this.f24110i = jSONArrayArr[1];
        this.f24112w = jArr[1];
        this.kt = jSONArrayArr[2];
        this.tj = jArr[2];
        this.oq = i6;
    }

    public byte[] oq() {
        this.vl = null;
        try {
            byte[] j6 = pz.j(m().toString());
            this.vl = j6;
            return j6;
        } catch (OutOfMemoryError e6) {
            StringBuilder sb = new StringBuilder();
            int i6 = 0;
            while (true) {
                sm.xt[] xtVarArr = sm.cw;
                if (i6 >= xtVarArr.length) {
                    throw new RuntimeException(sb.toString(), e6);
                }
                sm.xt xtVar = xtVarArr[i6];
                if (xtVar != null) {
                    sb.append(xtVar.toString());
                    sb.append(";");
                }
                i6++;
            }
        }
    }

    @Override // com.bytedance.embedapplog.ya
    protected JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.f24113x);
        jSONObject.put("time_sync", q.f24032j);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.mi != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.mi.m());
            jSONObject.put("launch", jSONArray);
        }
        aq aqVar = this.f24111v;
        int i6 = 0;
        if (aqVar != null) {
            JSONObject m6 = aqVar.m();
            JSONArray jSONArray2 = this.f24109f;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i7 = 0;
            long j6 = 0;
            while (i7 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.f24109f.optString(i7));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i6, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i6) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i8 = length;
                long optLong = jSONObject2.optLong("local_time_ms", 0L);
                if (optLong > j6) {
                    m6.put("$page_title", jSONObject3.optString(ArticleInfo.PAGE_TITLE, ""));
                    m6.put("$page_key", jSONObject3.optString("page_key", ""));
                    j6 = optLong;
                }
                i7++;
                length = i8;
                i6 = 0;
            }
            if (length > 0) {
                m6.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(m6);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.az;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.az);
        }
        JSONArray jSONArray7 = this.f24109f;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.f24110i;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.f24110i);
        }
        JSONArray jSONArray9 = this.kt;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.kt);
        }
        StringBuilder sb = new StringBuilder("pack {");
        sb.append("ts:");
        sb.append(this.xt);
        sb.append(", la:");
        Object obj = this.mi;
        if (obj == null) {
            obj = "0";
        }
        sb.append(obj);
        sb.append(", te:");
        aq aqVar2 = this.f24111v;
        sb.append(aqVar2 != null ? aqVar2 : "0");
        sb.append(", p:");
        sb.append(length3);
        sb.append(", v1:");
        sb.append(length2);
        sb.append(", v3:");
        sb.append(length4);
        sb.append(", m:");
        sb.append(length5);
        uc.j(sb.toString());
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ya
    @NonNull
    String r() {
        return "pack";
    }

    @Override // com.bytedance.embedapplog.ya
    protected String tl() {
        return String.valueOf(this.f24105j);
    }

    @Override // com.bytedance.embedapplog.ya
    protected List<String> j() {
        return Arrays.asList(bm.f41039d, "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "event_type", "integer");
    }

    @Override // com.bytedance.embedapplog.ya
    public int j(@NonNull Cursor cursor) {
        this.f24105j = cursor.getLong(0);
        this.xt = cursor.getLong(1);
        this.vl = cursor.getBlob(2);
        this.jy = cursor.getInt(3);
        this.oq = cursor.getInt(4);
        this.f24107r = "";
        this.f24113x = null;
        this.mi = null;
        this.f24111v = null;
        this.f24109f = null;
        this.az = null;
        this.f24110i = null;
        this.kt = null;
        return 5;
    }

    @Override // com.bytedance.embedapplog.ya
    protected void j(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.xt));
        contentValues.put("_data", oq());
        contentValues.put("event_type", Integer.valueOf(this.oq));
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
