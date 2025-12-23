package cn.jiguang.bw;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;
import cn.jiguang.bz.j;
import cn.jiguang.bz.m;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Bundle f2609a;

    /* renamed from: b, reason: collision with root package name */
    private static long f2610b;

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<Integer, String> f2611i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private static List<String> f2612j;

    /* renamed from: c, reason: collision with root package name */
    private Context f2613c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f2614d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f2615e;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Bundle> f2616f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicInteger f2617g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f2618h;

    /* renamed from: cn.jiguang.bw.a$a, reason: collision with other inner class name */
    private static final class C0037a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f2622a = new a();
    }

    private a() {
        this.f2614d = new AtomicBoolean(true);
        this.f2615e = new AtomicBoolean(false);
        this.f2616f = new ConcurrentLinkedQueue<>();
        this.f2617g = new AtomicInteger(0);
        this.f2618h = new Runnable() { // from class: cn.jiguang.bw.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f2615e.get()) {
                    return;
                }
                a.this.c();
            }
        };
        Context a6 = d.a();
        this.f2613c = a6;
        this.f2614d.set(((Boolean) cn.jiguang.e.b.a(a6, cn.jiguang.e.a.N())).booleanValue());
        f.c("ExceptionStatsManager", "default exception_switch=" + this.f2614d.get());
    }

    public static a a() {
        return C0037a.f2622a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<JSONArray> b(JSONArray jSONArray) {
        StringBuilder sb;
        String str;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList<JSONArray> arrayList = new ArrayList<>();
                int i6 = 0;
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i7);
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        int length = optJSONObject.toString().getBytes("UTF-8").length;
                        i6 += length;
                        if (i6 > 102400) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            jSONArray2 = new JSONArray();
                            jSONArray2.put(optJSONObject);
                            i6 = length;
                        } else {
                            jSONArray2.put(optJSONObject);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    arrayList.add(jSONArray2);
                }
                return arrayList;
            } catch (UnsupportedEncodingException e6) {
                e = e6;
                sb = new StringBuilder();
                str = "partition exception:";
                sb.append(str);
                sb.append(e.getMessage());
                f.i("ExceptionStatsManager", sb.toString());
                return null;
            } catch (Throwable th) {
                e = th;
                sb = new StringBuilder();
                str = "partition throwable:";
                sb.append(str);
                sb.append(e.getMessage());
                f.i("ExceptionStatsManager", sb.toString());
                return null;
            }
        }
        return null;
    }

    private Bundle c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString(JThirdPlatFormInterface.KEY_EXTRA, bundle.getString(JThirdPlatFormInterface.KEY_EXTRA));
        bundle2.putString(JThirdPlatFormInterface.EXCEPTION_TYPE, bundle.getString(JThirdPlatFormInterface.EXCEPTION_TYPE));
        bundle2.putString("code", bundle.getString("code"));
        return bundle2;
    }

    public void f(Object obj) {
        a(obj + "", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
    }

    static {
        ArrayList arrayList = new ArrayList();
        f2612j = arrayList;
        arrayList.add("JLocation");
        f2612j.add("JAppAll");
        f2611i.put(1100, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
        f2611i.put(1500, "6");
        f2611i.put(Integer.valueOf(AVMDLDataLoader.KeyIsIsTestSpeedVersion), "7");
        f2611i.put(Integer.valueOf(AVMDLDataLoader.KeyIsIsEncryptVersion), "9");
        f2611i.put(1501, "8");
    }

    private void d(Bundle bundle) {
        f2609a = c(bundle);
        f2610b = System.currentTimeMillis();
    }

    public void b() {
        boolean z5 = this.f2614d.get();
        f.c("ExceptionStatsManager", "startReport exception_switch=" + z5);
        if (z5) {
            cn.jiguang.by.d.a("DELAY_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bw.a.3
                @Override // cn.jiguang.by.b
                public void a() {
                    String str;
                    try {
                        if (a.this.f2613c == null) {
                            str = "context is null,return";
                        } else if (a.this.d()) {
                            j.c("e_s.catch", "e_s.temp");
                            j.d("e_s.catch");
                            f.c("ExceptionStatsManager", "start to  report");
                            JSONObject a6 = j.a("e_s.temp");
                            f.c("ExceptionStatsManager", "local cache=" + a6);
                            if (a6 == null) {
                                a6 = new JSONObject();
                            }
                            JSONArray optJSONArray = a6.optJSONArray("data");
                            if (optJSONArray == null) {
                                optJSONArray = new JSONArray();
                            }
                            if (optJSONArray.length() != 0) {
                                ArrayList b6 = a.b(optJSONArray);
                                if (b6 != null && !b6.isEmpty()) {
                                    int size = b6.size();
                                    int i6 = 0;
                                    while (i6 < size) {
                                        JSONObject jSONObject = new JSONObject();
                                        JSONArray jSONArray = (JSONArray) b6.get(i6);
                                        i6++;
                                        jSONObject.put("slice_index", i6);
                                        jSONObject.put("slice_count", size);
                                        jSONObject.put("data", jSONArray);
                                        jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                                        cn.jiguang.be.b.a(a.this.f2613c, jSONObject, "exception_stats");
                                    }
                                    cn.jiguang.e.b.a(a.this.f2613c, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ac().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                                    j.d("e_s.temp");
                                    return;
                                }
                                return;
                            }
                            str = " report content is  null";
                        } else {
                            str = "no report";
                        }
                        f.c("ExceptionStatsManager", str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void e(Object obj) {
        a(obj + "", "9");
    }

    public void g(Object obj) {
        a(obj + "", Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bw.a.2
            @Override // cn.jiguang.by.b
            public void a() {
                a.this.f2615e.set(true);
                try {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        Bundle bundle = (Bundle) a.this.f2616f.poll();
                        if (bundle == null) {
                            break;
                        }
                        arrayList.add(bundle);
                        a.this.f2617g.decrementAndGet();
                    }
                    if (!arrayList.isEmpty()) {
                        a.this.a((List<Bundle>) arrayList);
                    }
                    a.this.f2615e.set(false);
                } catch (Throwable th) {
                    a.this.f2615e.set(false);
                    throw th;
                }
            }
        });
    }

    public void b(int i6) {
        a(i6 + "", "3");
    }

    public void d(Object obj) {
        a(obj + "", "8");
    }

    public void h(Object obj) {
        a(String.valueOf(obj), "20");
    }

    private JSONObject a(JSONObject jSONObject, Bundle bundle) {
        JSONObject jSONObject2;
        String str;
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (Throwable unused) {
                return jSONObject;
            }
        } else {
            jSONObject2 = jSONObject;
        }
        try {
            if (TextUtils.isEmpty(bundle.getString("code"))) {
                return jSONObject2;
            }
            String string = bundle.getString("code");
            if (jSONObject2.has("result")) {
                String[] split = jSONObject2.optString("result").split(ContainerUtils.FIELD_DELIMITER);
                StringBuilder sb = new StringBuilder();
                boolean z5 = false;
                for (int i6 = 0; i6 < split.length; i6++) {
                    String[] split2 = split[i6].split("_");
                    String str2 = split2[0];
                    int intValue = Integer.valueOf(split2[1]).intValue();
                    sb.append(str2);
                    sb.append("_");
                    if (string.equals(str2)) {
                        sb.append(intValue + 1);
                        z5 = true;
                    } else {
                        sb.append(intValue);
                    }
                    if (i6 != split.length - 1) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                }
                if (!z5) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    sb.append(string);
                    sb.append("_1");
                }
                str = sb.toString();
            } else {
                str = string + "_1";
            }
            jSONObject2.put("result", str);
            jSONObject2.put(JThirdPlatFormInterface.EXCEPTION_TYPE, bundle.getString(JThirdPlatFormInterface.EXCEPTION_TYPE));
            jSONObject2.put(JThirdPlatFormInterface.KEY_EXTRA, new JSONObject(bundle.getString(JThirdPlatFormInterface.KEY_EXTRA)));
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return Math.abs(System.currentTimeMillis() - ((Long) cn.jiguang.e.b.a(this.f2613c, cn.jiguang.e.a.ac())).longValue()) >= 3600000;
    }

    public void c(Object obj) {
        a(obj + "", "6");
    }

    public void a(int i6) {
        a(i6 + "", "2");
    }

    public void b(Object obj) {
        a(obj + "", "7");
    }

    private boolean b(Bundle bundle) {
        if (f2609a == null) {
            d(bundle);
            return false;
        }
        Bundle c6 = c(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        if (a(f2609a, c6) && currentTimeMillis - f2610b < 300) {
            return true;
        }
        d(bundle);
        return false;
    }

    public void a(int i6, int i7) {
        if (f2611i.containsKey(Integer.valueOf(i6))) {
            a(i7 + "", f2611i.get(Integer.valueOf(i6)));
        }
    }

    public void a(Bundle bundle) {
        if (this.f2614d.get() && bundle != null && this.f2616f.offer(bundle)) {
            if (this.f2617g.incrementAndGet() >= 50) {
                m.a().a(this.f2618h);
            } else {
                m.a().a("exception_stats_save", this.f2618h, 500L);
            }
        }
    }

    public void a(Integer num, int i6) {
        if (num != null && f2611i.containsKey(num)) {
            a(i6 + "", f2611i.get(num));
        }
    }

    public void a(Object obj) {
        a(obj + "", "4");
    }

    public void a(String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("code", str);
            bundle.putString(JThirdPlatFormInterface.EXCEPTION_TYPE, str2);
            a(bundle);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Bundle> list) {
        JSONObject a6;
        if (this.f2613c == null || list == null || list.isEmpty()) {
            return;
        }
        try {
            JSONObject a7 = j.a("e_s.catch");
            if (a7 == null) {
                a7 = new JSONObject();
            }
            for (Bundle bundle : list) {
                if (bundle != null) {
                    JSONArray optJSONArray = a7.optJSONArray("data");
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    String string = bundle.getString(JThirdPlatFormInterface.EXCEPTION_TYPE);
                    if (!TextUtils.isEmpty(string) && (!string.equals("1") || !b(bundle))) {
                        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i6);
                            if (jSONObject != null) {
                                String optString = jSONObject.optString(JThirdPlatFormInterface.EXCEPTION_TYPE);
                                if (!TextUtils.isEmpty(optString) && optString.equals(string)) {
                                    if ("1".equals(string) && jSONObject.has(JThirdPlatFormInterface.KEY_EXTRA)) {
                                        String string2 = bundle.getString(JThirdPlatFormInterface.KEY_EXTRA);
                                        String string3 = jSONObject.getString(JThirdPlatFormInterface.KEY_EXTRA);
                                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && string3.equals(string2)) {
                                            a6 = a(jSONObject, bundle);
                                        }
                                    } else {
                                        a6 = a(jSONObject, bundle);
                                    }
                                    optJSONArray.remove(i6);
                                    break;
                                }
                            }
                        }
                        a6 = a((JSONObject) null, bundle);
                        optJSONArray.put(a6);
                        a7.put("data", optJSONArray);
                    }
                }
            }
            j.a("e_s.catch", a7);
            f.c("ExceptionStatsManager", "saveData success, cache=" + a7);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z5) {
        this.f2614d.set(z5);
        f.c("ExceptionStatsManager", "updateSwitchState exception_switch=" + this.f2614d.get() + " origin switchState=" + z5);
    }

    private boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null || bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!(obj2 instanceof Bundle) || !a((Bundle) obj, (Bundle) obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }
}
