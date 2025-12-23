package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41439a = "fs_lc_tl_uapp";

    /* renamed from: f, reason: collision with root package name */
    private static final String f41440f = "-1";

    /* renamed from: g, reason: collision with root package name */
    private static Context f41441g;

    /* renamed from: b, reason: collision with root package name */
    private final int f41442b;

    /* renamed from: c, reason: collision with root package name */
    private final int f41443c;

    /* renamed from: d, reason: collision with root package name */
    private final int f41444d;

    /* renamed from: e, reason: collision with root package name */
    private final int f41445e;

    /* renamed from: h, reason: collision with root package name */
    private JSONObject f41446h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.s$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final s f41447a = new s(null);

        private a() {
        }
    }

    /* synthetic */ s(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static s a(Context context) {
        if (f41441g == null && context != null) {
            f41441g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f41447a;
    }

    private void b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f41439a, null);
            if (!TextUtils.isEmpty(string)) {
                this.f41446h = new JSONObject(string);
            }
            a();
        } catch (Exception unused) {
        }
    }

    private void c(Context context) {
        try {
            if (this.f41446h != null) {
                PreferenceWrapper.getDefault(f41441g).edit().putString(f41439a, this.f41446h.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private s() {
        this.f41442b = 128;
        this.f41443c = 256;
        this.f41444d = 1024;
        this.f41445e = 10;
        this.f41446h = null;
        try {
            b(f41441g);
        } catch (Throwable unused) {
        }
    }

    private boolean c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(String str, String str2, long j6, int i6, String str3) {
        String a6;
        try {
            if (a(str) && b(str2)) {
                if (Arrays.asList(d.aM).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(j.f41327m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j6 > 0) {
                    jSONObject.put(d.ac, j6);
                }
                jSONObject.put("__t", 2049);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                if (UMUtils.isMainProgress(f41441g)) {
                    a6 = y.a().d(UMGlobalContext.getAppContext(f41441g));
                } else {
                    a6 = y.a().a(UMGlobalContext.getAppContext(f41441g), currentTimeMillis);
                }
                if (TextUtils.isEmpty(a6)) {
                    a6 = "-1";
                }
                jSONObject.put("__i", a6);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(d.aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f41441g).getProcessName(f41441g));
                a();
                JSONObject jSONObject3 = this.f41446h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f41446h.get(str)).booleanValue()) {
                    jSONObject.put(d.ae, 1);
                    this.f41446h.put(str, true);
                    c(f41441g);
                }
                Context context = f41441g;
                UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                return;
            }
            UMLog.aq(j.f41326l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.e("value is " + str + ", please check value, illegal");
        return false;
    }

    private boolean b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!a(entry.getKey())) {
                            UMLog.aq(j.f41322h, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() == null) {
                            UMLog.aq(j.f41323i, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() instanceof String) {
                            if (d.aK.equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq(j.P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!b(entry.getValue().toString())) {
                                UMLog.aq(j.f41324j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        UMLog.aq(j.f41321g, 0, "\\|");
        return false;
    }

    public void a(String str, Map<String, Object> map, long j6, String str2, boolean z5) {
        String a6;
        try {
            if (!a(str)) {
                UMLog.aq(j.f41320f, 0, "\\|");
                return;
            }
            if (b(map)) {
                if (map.size() > 100) {
                    MLog.e("map size is " + map.size() + ", please check");
                    return;
                }
                if (Arrays.asList(d.aM).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(j.f41316b, 0, "\\|");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                if (j6 > 0) {
                    jSONObject.put(d.ac, j6);
                }
                jSONObject.put("__t", 2049);
                ULog.i("befort ekv map, event is " + jSONObject.toString());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!Arrays.asList(d.aM).contains(entry.getKey())) {
                        Object value = entry.getValue();
                        if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    if (iArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray = new JSONArray();
                                    for (int i6 : iArr) {
                                        jSONArray.put(i6);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    if (dArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (double d6 : dArr) {
                                        jSONArray2.put(d6);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    if (jArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (long j7 : jArr) {
                                        jSONArray3.put(j7);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    if (fArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (float f6 : fArr) {
                                        jSONArray4.put(f6);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    if (sArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray5 = new JSONArray();
                                    for (short s5 : sArr) {
                                        jSONArray5.put((int) s5);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray5);
                                } else if (value instanceof String[]) {
                                    String[] strArr = (String[]) value;
                                    if (strArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray6 = new JSONArray();
                                    for (int i7 = 0; i7 < strArr.length; i7++) {
                                        String str3 = strArr[i7];
                                        if (str3 == null) {
                                            MLog.e("please check array, null item!");
                                            return;
                                        } else {
                                            if (!b(str3)) {
                                                return;
                                            }
                                            jSONArray6.put(strArr[i7]);
                                        }
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray6);
                                } else {
                                    MLog.e("please check key or value, illegal type!");
                                    return;
                                }
                            } else {
                                MLog.e("please check key or value, illegal type!");
                                return;
                            }
                        }
                        jSONObject.put(entry.getKey(), value);
                    } else {
                        UMLog.aq(j.f41319e, 0, "\\|");
                        return;
                    }
                }
                if (!UMUtils.isMainProgress(f41441g)) {
                    a6 = y.a().a(UMGlobalContext.getAppContext(f41441g), jSONObject.getLong("ts"));
                } else {
                    a6 = y.a().d(UMGlobalContext.getAppContext(f41441g));
                }
                if (TextUtils.isEmpty(a6)) {
                    a6 = "-1";
                }
                jSONObject.put("__i", a6);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(d.aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f41441g).getProcessName(f41441g));
                a();
                JSONObject jSONObject3 = this.f41446h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f41446h.get(str)).booleanValue()) {
                    jSONObject.put(d.ae, 1);
                    this.f41446h.put(str, true);
                    c(f41441g);
                }
                ULog.i("----->>>>>ekv event json is " + jSONObject.toString());
                if (!z5) {
                    Context context = f41441g;
                    UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                } else {
                    Context context2 = f41441g;
                    UMWorkDispatch.sendEvent(context2, o.a.f41407n, CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, Map<String, Object> map, String str2) {
        try {
            if (a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(d.ac, 0);
                jSONObject.put("__t", i.f41296b);
                ULog.i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i6 = 0; i6 < 10 && it.hasNext(); i6++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!d.ae.equals(next.getKey()) && !d.ac.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                String d6 = y.a().d(UMGlobalContext.getAppContext(f41441g));
                if (TextUtils.isEmpty(d6)) {
                    d6 = "-1";
                }
                jSONObject.put("__i", d6);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(d.aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f41441g).getProcessName(f41441g));
                ULog.i("----->>>>>gkv event json is " + jSONObject.toString());
                Context context = f41441g;
                UMWorkDispatch.sendEvent(context, 4098, CoreProtocol.getInstance(context), jSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    private void a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f41441g, "track_list", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            String[] split = imprintProperty.split("!");
            JSONObject jSONObject = new JSONObject();
            int i6 = 0;
            if (this.f41446h != null) {
                for (String str : split) {
                    String subStr = HelperUtils.subStr(str, 128);
                    if (this.f41446h.has(subStr)) {
                        jSONObject.put(subStr, this.f41446h.get(subStr));
                    }
                }
            }
            this.f41446h = new JSONObject();
            if (split.length >= 10) {
                while (i6 < 10) {
                    a(split[i6], jSONObject);
                    i6++;
                }
            } else {
                while (i6 < split.length) {
                    a(split[i6], jSONObject);
                    i6++;
                }
            }
            c(f41441g);
        } catch (Exception unused) {
        }
    }

    private void a(String str, JSONObject jSONObject) throws JSONException {
        String subStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            a(subStr, ((Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            a(subStr, false);
        }
    }

    private void a(String str, boolean z5) {
        try {
            if (d.ae.equals(str) || d.ac.equals(str) || "id".equals(str) || "ts".equals(str) || this.f41446h.has(str)) {
                return;
            }
            this.f41446h.put(str, z5);
        } catch (Exception unused) {
        }
    }

    public void a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    JSONObject jSONObject = this.f41446h;
                    if (jSONObject == null) {
                        this.f41446h = new JSONObject();
                        int size = list.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            JSONObject jSONObject2 = this.f41446h;
                            if (jSONObject2 == null) {
                                this.f41446h = new JSONObject();
                            } else if (jSONObject2.length() >= 5) {
                                break;
                            }
                            String str = list.get(i6);
                            if (!TextUtils.isEmpty(str)) {
                                a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        c(f41441g);
                        return;
                    }
                    if (jSONObject.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                        return;
                    }
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        if (this.f41446h.length() >= 5) {
                            MLog.d(" add setFistLaunchEvent over.");
                            return;
                        }
                        a(HelperUtils.subStr(list.get(i7), 128), false);
                    }
                    c(f41441g);
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.aq(j.ak, 0, "\\|");
    }

    private JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String subStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i6 = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    while (i6 < iArr.length) {
                                        jSONArray.put(iArr[i6]);
                                        i6++;
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    while (i6 < dArr.length) {
                                        jSONArray2.put(dArr[i6]);
                                        i6++;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    while (i6 < jArr.length) {
                                        jSONArray3.put(jArr[i6]);
                                        i6++;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    while (i6 < fArr.length) {
                                        jSONArray4.put(fArr[i6]);
                                        i6++;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    while (i6 < sArr.length) {
                                        jSONArray5.put((int) sArr[i6]);
                                        i6++;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                while (i6 < list.size()) {
                                    Object obj = list.get(i6);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i6));
                                    }
                                    i6++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(subStr, HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                    MLog.e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (Exception e6) {
                    MLog.e(e6);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.e("key is " + str + ", please check key, illegal");
        return false;
    }
}
