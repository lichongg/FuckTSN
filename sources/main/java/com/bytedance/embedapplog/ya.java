package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.bm;
import com.umeng.socialize.common.SocializeConstants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ya implements Cloneable {
    private static final SimpleDateFormat vl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public String ae;
    public long cw;

    /* renamed from: g, reason: collision with root package name */
    public int f24104g;

    /* renamed from: j, reason: collision with root package name */
    long f24105j;

    /* renamed from: m, reason: collision with root package name */
    public String f24106m;
    public int oq;
    String qv;

    /* renamed from: r, reason: collision with root package name */
    public String f24107r;
    public String tl;
    public long up;
    public long xt;

    public static String xt(long j6) {
        return vl.format(new Date(j6));
    }

    protected String g() {
        return null;
    }

    public void j(long j6) {
        if (j6 == 0) {
            j6 = System.currentTimeMillis();
        }
        this.xt = j6;
    }

    @NonNull
    abstract String r();

    protected abstract JSONObject xt();

    @NonNull
    public final JSONObject m() {
        try {
            this.qv = xt(this.xt);
            return xt();
        } catch (JSONException e6) {
            uc.xt(e6);
            return null;
        }
    }

    protected String tl() {
        return "sid:" + this.f24107r;
    }

    @NonNull
    public final JSONObject up() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", r());
            j(jSONObject);
            return jSONObject;
        } catch (JSONException e6) {
            uc.xt(e6);
            return jSONObject;
        }
    }

    protected ya xt(@NonNull JSONObject jSONObject) {
        this.xt = jSONObject.optLong("local_time_ms", 0L);
        this.f24105j = 0L;
        this.cw = 0L;
        this.f24104g = 0;
        this.up = 0L;
        this.f24107r = null;
        this.f24106m = null;
        this.ae = null;
        this.tl = null;
        return this;
    }

    public ya() {
        j(0L);
    }

    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public ya clone() {
        try {
            return (ya) super.clone();
        } catch (CloneNotSupportedException e6) {
            uc.xt(e6);
            return null;
        }
    }

    final String cw() {
        List<String> j6 = j();
        if (j6 != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("create table if not exists ");
            sb.append(r());
            sb.append("(");
            for (int i6 = 0; i6 < j6.size(); i6 += 2) {
                sb.append(j6.get(i6));
                sb.append(" ");
                sb.append(j6.get(i6 + 1));
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(")");
            return sb.toString();
        }
        return null;
    }

    protected List<String> j() {
        return Arrays.asList(bm.f41039d, "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", SocializeConstants.TENCENT_UID, "integer", "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", "integer");
    }

    @NonNull
    public String toString() {
        String r5 = r();
        if (!getClass().getSimpleName().equalsIgnoreCase(r5)) {
            r5 = r5 + ", " + getClass().getSimpleName();
        }
        String str = this.f24107r;
        String str2 = "-";
        if (str != null) {
            int indexOf = str.indexOf("-");
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            str2 = str;
        }
        return "{" + r5 + ", " + tl() + ", " + str2 + ", " + this.xt + "}";
    }

    public int j(@NonNull Cursor cursor) {
        this.f24105j = cursor.getLong(0);
        this.xt = cursor.getLong(1);
        this.cw = cursor.getLong(2);
        this.f24104g = cursor.getInt(3);
        this.up = cursor.getLong(4);
        this.f24107r = cursor.getString(5);
        this.f24106m = cursor.getString(6);
        this.ae = cursor.getString(7);
        this.tl = cursor.getString(8);
        this.oq = cursor.getInt(9);
        return 10;
    }

    final ContentValues xt(@Nullable ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        j(contentValues);
        return contentValues;
    }

    protected void j(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.xt));
        contentValues.put("tea_event_index", Long.valueOf(this.cw));
        contentValues.put("nt", Integer.valueOf(this.f24104g));
        contentValues.put(SocializeConstants.TENCENT_UID, Long.valueOf(this.up));
        contentValues.put("session_id", this.f24107r);
        contentValues.put("user_unique_id", this.f24106m);
        contentValues.put("ssid", this.ae);
        contentValues.put("ab_sdk_version", this.tl);
        contentValues.put("event_type", Integer.valueOf(this.oq));
    }

    protected void j(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.xt);
    }

    public static ya j(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return sm.xt.get(jSONObject.optString("k_cls", "")).clone().xt(jSONObject);
        } catch (Throwable th) {
            uc.xt(th);
            return null;
        }
    }
}
