package com.beizi.ad.internal.h;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12176a;

    /* renamed from: l, reason: collision with root package name */
    private static SimpleDateFormat f12177l;

    /* renamed from: m, reason: collision with root package name */
    private static SimpleDateFormat f12178m;

    /* renamed from: b, reason: collision with root package name */
    private String f12179b;

    /* renamed from: c, reason: collision with root package name */
    private String f12180c;

    /* renamed from: d, reason: collision with root package name */
    private String f12181d;

    /* renamed from: e, reason: collision with root package name */
    private String f12182e;

    /* renamed from: f, reason: collision with root package name */
    private String f12183f;

    /* renamed from: g, reason: collision with root package name */
    private String f12184g;

    /* renamed from: h, reason: collision with root package name */
    private String f12185h;

    /* renamed from: i, reason: collision with root package name */
    private String f12186i;

    /* renamed from: j, reason: collision with root package name */
    private String f12187j;

    /* renamed from: k, reason: collision with root package name */
    private w f12188k;

    public static v j(String str) {
        v vVar = new v();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("id")) {
                vVar.a(jSONObject.getString("id"));
            }
            if (!jSONObject.isNull(SocialConstants.PARAM_COMMENT)) {
                vVar.b(jSONObject.getString(SocialConstants.PARAM_COMMENT));
            }
            if (!jSONObject.isNull(SocializeConstants.KEY_LOCATION)) {
                vVar.c(jSONObject.getString(SocializeConstants.KEY_LOCATION));
            }
            if (!jSONObject.isNull("summary")) {
                vVar.d(jSONObject.getString("summary"));
            }
            if (!jSONObject.isNull("start")) {
                vVar.e(jSONObject.getString("start"));
            }
            if (!jSONObject.isNull("end")) {
                if (jSONObject.isNull("start")) {
                    vVar.e(jSONObject.getString("end"));
                }
                vVar.f(jSONObject.getString("end"));
            }
            if (!jSONObject.isNull(NotificationCompat.CATEGORY_STATUS)) {
                vVar.g(jSONObject.getString(NotificationCompat.CATEGORY_STATUS));
            }
            if (!jSONObject.isNull("freebusy")) {
                vVar.h(jSONObject.getString("freebusy"));
            }
            if (!jSONObject.isNull(NotificationCompat.CATEGORY_REMINDER)) {
                vVar.i(jSONObject.getString(NotificationCompat.CATEGORY_REMINDER));
            }
            if (!jSONObject.isNull("recurrence")) {
                vVar.a(new w());
                JSONObject jSONObject2 = jSONObject.getJSONObject("recurrence");
                if (!jSONObject2.isNull("frequency")) {
                    vVar.i().a(jSONObject2.getString("frequency"));
                }
                if (!jSONObject2.isNull(bi.aX)) {
                    vVar.i().a(jSONObject2.getInt(bi.aX));
                }
                if (!jSONObject2.isNull("expires")) {
                    vVar.i().b(jSONObject2.getString("expires"));
                }
                if (!jSONObject2.isNull("exceptionDates")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("exceptionDates");
                    int length = jSONArray.length();
                    vVar.i().a(new String[length]);
                    for (int i6 = 0; i6 < length; i6++) {
                        vVar.i().d()[i6] = jSONArray.getString(i6);
                    }
                }
                if (!jSONObject2.isNull("daysInWeek")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("daysInWeek");
                    int length2 = jSONArray2.length();
                    vVar.i().a(new int[length2]);
                    for (int i7 = 0; i7 < length2; i7++) {
                        vVar.i().e()[i7] = jSONArray2.getInt(i7);
                    }
                }
                if (!jSONObject2.isNull("daysInMonth")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("daysInMonth");
                    int length3 = jSONArray3.length();
                    vVar.i().b(new int[length3]);
                    for (int i8 = 0; i8 < length3; i8++) {
                        vVar.i().f()[i8] = jSONArray3.getInt(i8);
                    }
                }
                if (!jSONObject2.isNull("daysInYear")) {
                    JSONArray jSONArray4 = jSONObject2.getJSONArray("daysInYear");
                    int length4 = jSONArray4.length();
                    vVar.i().c(new int[length4]);
                    for (int i9 = 0; i9 < length4; i9++) {
                        vVar.i().g()[i9] = jSONArray4.getInt(i9);
                    }
                }
                if (!jSONObject2.isNull("weeksInMonth")) {
                    JSONArray jSONArray5 = jSONObject2.getJSONArray("weeksInMonth");
                    int length5 = jSONArray5.length();
                    vVar.i().e(new int[length5]);
                    for (int i10 = 0; i10 < length5; i10++) {
                        vVar.i().i()[i10] = jSONArray5.getInt(i10);
                    }
                }
                if (!jSONObject2.isNull("monthsInYear")) {
                    JSONArray jSONArray6 = jSONObject2.getJSONArray("monthsInYear");
                    int length6 = jSONArray6.length();
                    vVar.i().d(new int[length6]);
                    for (int i11 = 0; i11 < length6; i11++) {
                        vVar.i().h()[i11] = jSONArray6.getInt(i11);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return vVar;
    }

    public void a(String str) {
        this.f12179b = str;
    }

    public void b(String str) {
        this.f12180c = str;
    }

    public void c(String str) {
        this.f12181d = str;
    }

    public void d(String str) {
        this.f12182e = str;
    }

    public void e(String str) {
        this.f12183f = str;
    }

    public void f(String str) {
        this.f12184g = str;
    }

    public void g(String str) {
        this.f12185h = str;
    }

    public void h(String str) {
        this.f12186i = str;
    }

    public void i(String str) {
        this.f12187j = str;
    }

    static {
        Locale locale = Locale.US;
        f12177l = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", locale);
        f12178m = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", locale);
    }

    private long k(String str) {
        try {
            try {
                try {
                    return f12177l.parse(str).getTime();
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            } catch (ParseException unused2) {
                return f12178m.parse(str).getTime();
            }
        } catch (ParseException unused3) {
            return Long.parseLong(str);
        }
    }

    public String a() {
        return this.f12180c;
    }

    public String b() {
        return this.f12181d;
    }

    public String c() {
        return this.f12182e;
    }

    public String d() {
        return this.f12183f;
    }

    public String e() {
        return this.f12184g;
    }

    public String f() {
        return this.f12185h;
    }

    public String g() {
        return this.f12186i;
    }

    public String h() {
        return this.f12187j;
    }

    public w i() {
        return this.f12188k;
    }

    private v() {
    }

    public void a(w wVar) {
        this.f12188k = wVar;
    }

    @SuppressLint({"NewApi", "InlinedApi"})
    public Intent j() {
        Intent type;
        boolean z5 = f12176a;
        if (!z5) {
            type = new Intent("android.intent.action.EDIT").setData(Uri.parse(com.beizi.ad.lance.a.b.b("Y29udGVudDovL2NvbS5hbmRyb2lkLmNhbGVuZGFyL2V2ZW50cw==")));
        } else {
            type = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event");
        }
        if (!o.a(a())) {
            type.putExtra("title", a());
        }
        if (!o.a(b())) {
            type.putExtra("eventLocation", b());
        }
        if (!o.a(c())) {
            type.putExtra(SocialConstants.PARAM_COMMENT, c());
        }
        if (!o.a(d())) {
            long k6 = k(d());
            if (k6 > 0) {
                type.putExtra("beginTime", k6);
            }
        }
        if (!o.a(e())) {
            long k7 = k(e());
            if (k7 > 0) {
                type.putExtra("endTime", k7);
            }
        }
        if (!o.a(f()) && !z5) {
            type.putExtra("eventStatus", f());
        }
        if (!o.a(g()) && !z5) {
            type.putExtra("visible", !g().equals("opaque"));
        }
        if (!o.a(h())) {
            long k8 = k(h());
            if (k8 < 0) {
                if (!z5) {
                    type.putExtra("minutes", Math.abs(k8 / 60000));
                }
            } else if (!o.a(d()) && !z5) {
                long k9 = k(d());
                if (k9 > 0) {
                    type.putExtra("minutes", Math.abs((k9 - k8) / 60000));
                }
            }
        }
        String str = "";
        StringBuilder sb = new StringBuilder("");
        if (i() != null) {
            String a6 = i().a();
            if (!o.a(a6)) {
                if ("daily".equals(a6)) {
                    sb.append("FREQ=DAILY;");
                } else if ("weekly".equals(a6)) {
                    sb.append("FREQ=WEEKLY;");
                } else if ("monthly".equals(a6)) {
                    sb.append("FREQ=MONTHLY;");
                } else if ("yearly".equals(a6)) {
                    sb.append("FREQ=YEARLY;");
                }
                str = a6;
            }
            if (i().b() > 0) {
                sb.append("INTERVAL=");
                sb.append(i().b());
                sb.append(";");
            }
            if ("weekly".equals(str) && i().e() != null && i().e().length > 0) {
                sb.append("BYDAY=");
                for (int i6 : i().e()) {
                    switch (i6) {
                        case 0:
                            sb.append("SU,");
                            break;
                        case 1:
                            sb.append("MO,");
                            break;
                        case 2:
                            sb.append("TU,");
                            break;
                        case 3:
                            sb.append("WE,");
                            break;
                        case 4:
                            sb.append("TH,");
                            break;
                        case 5:
                            sb.append("FR,");
                            break;
                        case 6:
                            sb.append("SA,");
                            break;
                    }
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str) && i().f() != null && i().f().length > 0) {
                sb.append("BYMONTHDAY=");
                for (int i7 : i().f()) {
                    sb.append(i7);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && i().g() != null && i().g().length > 0) {
                sb.append("BYYEARDAY=");
                for (int i8 : i().g()) {
                    sb.append(i8);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("yearly".equals(str) && i().h() != null && i().h().length > 0) {
                sb.append("BYMONTH=");
                for (int i9 : i().h()) {
                    sb.append(i9);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if ("monthly".equals(str) && i().i() != null && i().i().length > 0) {
                sb.append("BYWEEKNO=");
                for (int i10 : i().i()) {
                    sb.append(i10);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!o.a(i().c())) {
                sb.append("UNTIL=");
                sb.append(i().c());
                sb.append(";");
            }
            if (i().d() != null && i().d().length > 0) {
                sb.append("EXDATE=");
                for (String str2 : i().d()) {
                    sb.append(str2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            type.putExtra("rrule", sb.toString());
        }
        return type;
    }
}
