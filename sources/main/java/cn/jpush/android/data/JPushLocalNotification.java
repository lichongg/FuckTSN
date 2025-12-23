package cn.jpush.android.data;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.Logger;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushLocalNotification implements Serializable {
    private static final long serialVersionUID = 1472982106750878137L;

    /* renamed from: f, reason: collision with root package name */
    private String f3629f;

    /* renamed from: g, reason: collision with root package name */
    private String f3630g;

    /* renamed from: h, reason: collision with root package name */
    private String f3631h;

    /* renamed from: i, reason: collision with root package name */
    private long f3632i;

    /* renamed from: a, reason: collision with root package name */
    private int f3624a = 1;

    /* renamed from: b, reason: collision with root package name */
    private String f3625b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f3626c = "00";

    /* renamed from: d, reason: collision with root package name */
    private String f3627d = "00";

    /* renamed from: e, reason: collision with root package name */
    private long f3628e = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f3633j = 1;

    /* renamed from: k, reason: collision with root package name */
    private int f3634k = 1;

    /* renamed from: l, reason: collision with root package name */
    private String f3635l = "";

    /* renamed from: m, reason: collision with root package name */
    private String f3636m = "";

    /* renamed from: n, reason: collision with root package name */
    private int f3637n = 0;

    /* renamed from: o, reason: collision with root package name */
    private String f3638o = "";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f3633j == ((JPushLocalNotification) obj).f3633j;
    }

    public void setBroadcastTime(int i6, int i7, int i8, int i9, int i10, int i11) {
        if (i6 < 0 || i7 < 1 || i7 > 12 || i8 < 1 || i8 > 31 || i9 < 0 || i9 > 23 || i10 < 0 || i10 > 59 || i11 < 0 || i11 > 59) {
            Logger.ee("JPushLocalNotification", "Set time fail! Please check your args!");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i6, i7 - 1, i8, i9, i10, i11);
        Date time = calendar.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (time.getTime() < currentTimeMillis) {
            this.f3628e = currentTimeMillis;
        } else {
            this.f3628e = time.getTime();
        }
    }

    public void setNotificationId(long j6) {
        this.f3633j = (int) j6;
    }

    public long getBroadcastTime() {
        return this.f3628e;
    }

    public long getBuilderId() {
        return this.f3632i;
    }

    public String getCategory() {
        return this.f3638o;
    }

    public String getContent() {
        return this.f3629f;
    }

    public String getExtras() {
        return this.f3631h;
    }

    public long getNotificationId() {
        return this.f3633j;
    }

    public int getPriority() {
        return this.f3637n;
    }

    public String getTitle() {
        return this.f3630g;
    }

    public int hashCode() {
        long j6 = this.f3633j;
        return (int) (j6 ^ (j6 >>> 32));
    }

    public void setBroadcastTime(long j6) {
        this.f3628e = j6;
    }

    public void setBuilderId(long j6) {
        this.f3632i = j6;
    }

    public void setCategory(String str) {
        this.f3638o = str;
    }

    public void setContent(String str) {
        this.f3629f = str;
    }

    public void setExtras(String str) {
        this.f3631h = str;
    }

    public void setPriority(int i6) {
        this.f3637n = i6;
    }

    public void setTitle(String str) {
        this.f3630g = str;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.f3631h)) {
                jSONObject2.put("n_extras", new JSONObject(this.f3631h));
            }
            jSONObject2.put("n_priority", this.f3637n);
            a("n_category", this.f3638o, jSONObject2);
            a("n_content", this.f3629f, jSONObject2);
            a("n_title", this.f3630g, jSONObject2);
            a("n_content", this.f3629f, jSONObject2);
            jSONObject2.put("ad_t", 0);
            jSONObject.put("m_content", jSONObject2);
            a(JThirdPlatFormInterface.KEY_MSG_ID, "" + this.f3633j, jSONObject);
            a("content_type", this.f3636m, jSONObject);
            a("override_msg_id", this.f3635l, jSONObject);
            jSONObject.put("n_only", this.f3634k);
            jSONObject.put("n_builder_id", this.f3632i);
            jSONObject.put("show_type", 3);
            jSONObject.put("notificaion_type", 1);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    private void a(String str, String str2, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public void setBroadcastTime(Date date) {
        this.f3628e = date.getTime();
    }
}
