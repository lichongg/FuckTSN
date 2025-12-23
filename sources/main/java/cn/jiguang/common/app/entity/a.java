package cn.jiguang.common.app.entity;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f2820a;

    /* renamed from: b, reason: collision with root package name */
    public long f2821b;

    /* renamed from: c, reason: collision with root package name */
    public int f2822c;

    /* renamed from: e, reason: collision with root package name */
    public List<Long> f2824e = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public List<Integer> f2823d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public List<String> f2825f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public List<Long> f2826g = new ArrayList();

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f2820a = jSONObject.optString("pkg");
            aVar.f2822c = jSONObject.optInt("launch_cnt");
            aVar.f2821b = jSONObject.optLong("active_duration");
            aVar.f2824e = c(jSONObject.optString("active_time"));
            aVar.f2823d = d(jSONObject.optString(SocialConstants.PARAM_SOURCE));
            aVar.f2826g = c(jSONObject.optString("traffic_usage"));
            aVar.f2825f = b(jSONObject.optString(com.umeng.analytics.pro.d.f41203v));
        } catch (Throwable unused) {
        }
        return aVar;
    }

    private static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Collections.addAll(arrayList, str.split(ContainerUtils.FIELD_DELIMITER));
        return arrayList;
    }

    private static CharSequence a(CharSequence charSequence, int i6) {
        return (i6 < 0 || i6 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i6);
    }

    private static List<Long> c(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                arrayList.add(Long.valueOf(Long.parseLong(str2)));
            }
        }
        return arrayList;
    }

    private static List<Integer> d(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        return arrayList;
    }

    public JSONObject b(int i6) {
        try {
            if (this.f2821b == 0 && this.f2824e.isEmpty() && this.f2825f.isEmpty()) {
                return null;
            }
            JSONObject put = new JSONObject().put("pkg", a(this.f2820a, i6));
            long j6 = this.f2821b;
            if (j6 > 0) {
                put.put("active_duration", j6);
            }
            if (this.f2824e.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Long> it = this.f2824e.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    if (longValue > 0) {
                        jSONArray.put(longValue);
                    }
                }
                put.put("active_time", jSONArray);
            }
            if (this.f2823d.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (Integer num : this.f2823d) {
                    if (num.intValue() > 0) {
                        jSONArray2.put(num);
                    }
                }
                put.put(SocialConstants.PARAM_SOURCE, jSONArray2);
            }
            if (this.f2825f.size() > 0) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str : this.f2825f) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray3.put(str);
                    }
                }
                put.put(com.umeng.analytics.pro.d.f41203v, jSONArray3);
            }
            put.put("launch_count", this.f2822c);
            return put;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(Collection<?> collection, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public JSONObject a(int i6) {
        try {
            return new JSONObject().put("pkg", a(this.f2820a, i6)).put("active_time", a(this.f2824e, ContainerUtils.FIELD_DELIMITER)).put(SocialConstants.PARAM_SOURCE, a(this.f2823d, ContainerUtils.FIELD_DELIMITER)).put("active_duration", this.f2821b).put("launch_cnt", this.f2822c).put(com.umeng.analytics.pro.d.f41203v, a(this.f2825f, ContainerUtils.FIELD_DELIMITER)).put("traffic_usage", a(this.f2826g, ContainerUtils.FIELD_DELIMITER));
        } catch (Throwable unused) {
            return null;
        }
    }
}
