package cn.jiguang.h;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.bz.v;
import cn.jiguang.m.c;
import com.baidu.mobads.sdk.internal.bn;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3004a;

    /* renamed from: b, reason: collision with root package name */
    private a f3005b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, Integer> f3006c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, Integer> f3007d;

    /* renamed from: cn.jiguang.h.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f3008a;

        /* renamed from: b, reason: collision with root package name */
        private String f3009b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3010c;

        public a a(String str) {
            this.f3009b = str;
            return this;
        }

        public a b(String str) {
            this.f3008a = str;
            return this;
        }

        public a a(boolean z5) {
            this.f3010c = z5;
            return this;
        }

        public boolean b() {
            return this.f3010c;
        }

        public String c() {
            return this.f3008a;
        }

        public String a() {
            return this.f3009b;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f3011a = new e(null);
    }

    private e() {
        this.f3006c = new HashMap<>();
        this.f3007d = new HashMap<>();
    }

    public static e a() {
        return b.f3011a;
    }

    private int b(String str) {
        HashMap<String, Integer> hashMap = this.f3006c;
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<String, Integer> entry : this.f3006c.entrySet()) {
                if (entry.getKey().contains(str)) {
                    return entry.getValue().intValue();
                }
            }
        }
        return -1;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (cn.jiguang.g.a.a().e(1106)) {
            a aVar = this.f3005b;
            if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                cn.jiguang.bb.f.c("JAppProbe", "not app probe, because config is null");
                return;
            }
            cn.jiguang.bb.f.c("JAppProbe", "start probe, p idx: " + this.f3005b.a());
            System.currentTimeMillis();
            for (String str2 : this.f3005b.a().split("&&")) {
                String[] split = str2.split(ContainerUtils.FIELD_DELIMITER);
                if (split != null && split.length > 1) {
                    this.f3006c.put(split[1], Integer.valueOf(Integer.parseInt(split[0])));
                }
            }
            ArrayList arrayList = new ArrayList();
            if (cn.jiguang.common.app.helper.b.a(context, false, (Object) arrayList) instanceof List) {
                cn.jiguang.bb.f.c("JAppProbe", "app probe by list");
                Iterator<String> it = this.f3006c.keySet().iterator();
                while (it.hasNext()) {
                    String a6 = a(it.next());
                    if (arrayList.contains(a6)) {
                        this.f3007d.put(a6, 1);
                    } else {
                        this.f3007d.put(a6, 0);
                    }
                }
            } else if (!this.f3005b.b()) {
                cn.jiguang.bb.f.c("JAppProbe", "app probe by dy activity");
                for (String str3 : this.f3006c.keySet()) {
                    String a7 = a(str3);
                    if (cn.jiguang.bz.a.g(context, str3)) {
                        this.f3007d.put(a7, 1);
                    } else {
                        this.f3007d.put(a7, 0);
                    }
                }
            } else if (cn.jiguang.common.app.helper.b.d(context)) {
                cn.jiguang.bb.f.c("JAppProbe", "app probe by launch intent");
                Iterator<String> it2 = this.f3006c.keySet().iterator();
                while (it2.hasNext()) {
                    String a8 = a(it2.next());
                    if (cn.jiguang.bz.a.f(context, a8)) {
                        this.f3007d.put(a8, 1);
                    } else {
                        this.f3007d.put(a8, 0);
                    }
                }
            } else {
                cn.jiguang.bb.f.c("JAppProbe", "it can't probe app by launch intent, because no QUERY_ALL_PACKAGES permission on android R");
            }
            super.c(context, str);
        }
    }

    /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3004a = context;
        return "JAppProbe";
    }

    public a b() {
        return this.f3005b;
    }

    private String a(String str) {
        try {
            return str.split("\\|")[0];
        } catch (Throwable unused) {
            return str;
        }
    }

    public String b(Context context) {
        String e6 = j.e("prb.catch");
        if (TextUtils.isEmpty(e6)) {
            return null;
        }
        try {
            return new String(v.a(e6, c.a.f3104h, c.a.f3105i), "UTF-8");
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JAppProbe", "readProbesFromCache failed, " + th.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (!cn.jiguang.g.a.a().e(1106)) {
            return;
        }
        if (this.f3007d.size() == 0) {
            cn.jiguang.bb.f.c("JAppProbe", "no probe data to report");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : this.f3007d.keySet()) {
            int b6 = b(str2);
            int intValue = this.f3007d.get(str2).intValue();
            sb.append(b6);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(intValue);
            sb.append(Logger.f33116c);
        }
        int length = sb.length();
        sb.delete(length - 1, length);
        cn.jiguang.bb.f.c("JAppProbe", "probe data package ready and start to report, data: " + ((Object) sb));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", sb);
            cn.jiguang.be.b.a(context, jSONObject, "app_probe");
            this.f3007d.clear();
            super.d(context, str);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JAppProbe", "report probe data failed, error: " + th.getMessage());
        }
    }

    public void f(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                j.a("prb.catch", v.a(str.getBytes(), c.a.f3104h, c.a.f3105i));
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JAppProbe", "writeProbesToCache failed, " + th.getMessage());
            }
        }
    }

    public void a(a aVar) {
        this.f3005b = aVar;
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        return true;
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        if (System.currentTimeMillis() >= cn.jiguang.d.a.g(context) + bn.f10748d) {
            return super.a(context, str);
        }
        cn.jiguang.bb.f.c("JAppProbe", "can't probe because r time");
        return false;
    }
}
