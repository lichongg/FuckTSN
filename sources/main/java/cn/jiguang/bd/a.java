package cn.jiguang.bd;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.analytics.page.PushSA;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.baidu.mobads.sdk.internal.bn;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.internal.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f1981a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, LinkedHashSet<String>> f1982b;

    /* renamed from: cn.jiguang.bd.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.bd.a$a, reason: collision with other inner class name */
    private static final class C0030a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f1983a = new a(null);
    }

    private a() {
        this.f1982b = new HashMap();
    }

    public static a b() {
        return C0030a.f1983a;
    }

    public Integer a() {
        return null;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return PrerollVideoResponse.NORMAL;
        }
        str.getClass();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals(PushSA.REPORT_ACTIVE_LAUNCH)) {
                    c6 = 0;
                    break;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1051289244:
                if (str.equals(com.umeng.analytics.pro.d.L)) {
                    c6 = 3;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals(PrerollVideoResponse.NORMAL)) {
                    c6 = 4;
                    break;
                }
                break;
            case -820729752:
                if (str.equals(PushSA.REPORT_ACTIVE_TERMINATE)) {
                    c6 = 5;
                    break;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    c6 = 6;
                    break;
                }
                break;
            case -295020531:
                if (str.equals("android_notification_state")) {
                    c6 = 7;
                    break;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 96275:
                if (str.equals("aa3")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 2986591:
                if (str.equals("aat3")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    c6 = 11;
                    break;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    c6 = 14;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 3:
            case 5:
                break;
            case 1:
            case '\f':
            case 14:
                break;
            case 2:
            case 6:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\r':
                break;
            case 4:
                break;
            case 7:
                break;
            default:
                if (!this.f1982b.containsKey(str)) {
                }
                break;
        }
        return PrerollVideoResponse.NORMAL;
    }

    public a b(Context context) {
        try {
            long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.X())).longValue();
            long j6 = this.f1981a;
            if (j6 == 0 || j6 != longValue) {
                this.f1981a = longValue;
                String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.V());
                if (!TextUtils.isEmpty(str)) {
                    a(new JSONObject(str));
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public a c(Context context) {
        boolean z5;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            b(context);
            long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.Y())).longValue();
            if (longValue < 0) {
                longValue = 3600000;
            } else if (longValue < 60000) {
                longValue = 60000;
            }
            if (longValue > bn.f10748d) {
                longValue = 604800000;
            }
            SimpleDateFormat a6 = cn.jiguang.bz.f.a("yyyy-MM-dd HH:mm:ss");
            cn.jiguang.bb.f.c("AddressGroupManager", "lastUpdateTime=" + a6.format(new Date(this.f1981a)) + " now=" + a6.format(new Date(currentTimeMillis)) + " expire=" + (longValue / 1000));
            long j6 = this.f1981a;
            if (j6 != 0 && j6 + longValue >= currentTimeMillis) {
                return this;
            }
            cn.jiguang.bb.f.c("AddressGroupManager", "cache invalid, fetch new urls");
            Map<String, LinkedHashSet<String>> map = this.f1982b;
            if (map != null && !map.isEmpty()) {
                z5 = false;
                e.a(context, z5);
                return this;
            }
            z5 = true;
            e.a(context, z5);
            return this;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("AddressGroupManager", "refresh e" + th);
            return this;
        }
    }

    public String a(Set<String> set) {
        if (set != null) {
            try {
                if (!set.isEmpty()) {
                    Iterator<String> it = set.iterator();
                    String str = null;
                    while (it.hasNext()) {
                        String a6 = a(it.next());
                        if (str == null) {
                            str = a6;
                        } else if (!str.equals(a6)) {
                            cn.jiguang.bb.f.i("AddressGroupManager", "Report JSONArray belong more than one space, using normal-space");
                            return PrerollVideoResponse.NORMAL;
                        }
                    }
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        return PrerollVideoResponse.NORMAL;
    }

    public Set<String> b(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            Iterator<String> it = set.iterator();
            LinkedHashSet<String> linkedHashSet = null;
            while (it.hasNext()) {
                LinkedHashSet<String> linkedHashSet2 = this.f1982b.get(a(it.next()));
                if (linkedHashSet2 != null && !linkedHashSet2.isEmpty()) {
                    if (linkedHashSet == null) {
                        linkedHashSet = linkedHashSet2;
                    } else {
                        linkedHashSet.retainAll(linkedHashSet2);
                    }
                    if (linkedHashSet.isEmpty()) {
                    }
                }
            }
            return linkedHashSet;
        }
        return this.f1982b.get(PrerollVideoResponse.NORMAL);
    }

    public void a(Context context) {
        e.a(context, false);
    }

    public void a(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("sis_ips");
        long j6 = 3600000;
        try {
            long j7 = jSONObject.getLong(RtspHeaders.Values.TTL);
            if (j7 >= 0) {
                j6 = j7;
            }
        } catch (JSONException unused) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ips");
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.W().a((cn.jiguang.e.a<String>) optJSONArray.toString()), cn.jiguang.e.a.Y().a((cn.jiguang.e.a<Long>) Long.valueOf(j6 * 1000)), cn.jiguang.e.a.X().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis())), cn.jiguang.e.a.V().a((cn.jiguang.e.a<String>) (optJSONObject != null ? optJSONObject.toString() : ""))});
        a(optJSONObject);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (optJSONArray != null) {
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        linkedHashSet.add(optJSONArray.getString(i6));
                    }
                }
                hashMap.put(next, linkedHashSet);
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.f1982b = hashMap;
        } catch (JSONException unused) {
        }
    }
}
