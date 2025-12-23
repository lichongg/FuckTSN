package cn.jiguang.ba;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: cn.jiguang.ba.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<String, e> f1958a;

        /* renamed from: cn.jiguang.ba.l$a$a, reason: collision with other inner class name */
        private static class C0029a implements e {
            private C0029a() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.ar.a.b();
            }

            /* synthetic */ C0029a(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.ar.a.b(context);
            }
        }

        private static class b implements e {
            private b() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.ba.h.c();
            }

            /* synthetic */ b(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.ba.h.b(context);
            }
        }

        private static class c implements e {
            private c() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.q.c.b().a();
            }

            /* synthetic */ c(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.q.c.b().a(context);
            }
        }

        private static class d implements e {
            private d() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Integer] */
            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                String str = "ConfigHandlerManager";
                try {
                    if (!cn.jiguang.a.a.b()) {
                        cn.jiguang.bb.f.c("ConfigHandlerManager", "getProtocolVersion - DY not supported");
                        return null;
                    }
                    try {
                        str = cn.jiguang.dy.b.a().b();
                        return str;
                    } catch (Throwable th) {
                        cn.jiguang.bb.f.l("ConfigHandlerManager", "getProtocolVersion failed - DY supported but error: " + th.getMessage());
                        return null;
                    }
                } catch (Throwable th2) {
                    cn.jiguang.bb.f.l(str, "getProtocolVersion failed - check DY support error: " + th2.getMessage());
                    return null;
                }
            }

            /* synthetic */ d(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(final Context context, JSONObject jSONObject) {
                String str;
                if (context == null || jSONObject == null) {
                    str = "updateImmediately failed: context or config is null";
                } else {
                    try {
                        if (jSONObject.has("dy_id")) {
                            final int optInt = jSONObject.optInt("dy_id");
                            cn.jiguang.bb.f.c("ConfigHandlerManager", "Processing dy config with dy_id: " + optInt);
                            if (cn.jiguang.a.a.b()) {
                                cn.jiguang.be.b.e(new cn.jiguang.by.b() { // from class: cn.jiguang.ba.l.a.d.1
                                    @Override // cn.jiguang.by.b
                                    public void a() {
                                        try {
                                            cn.jiguang.dy.b.a().b(context, optInt, "");
                                            cn.jiguang.bb.f.c("ConfigHandlerManager", "Successfully updated dy config for dy_id: " + optInt);
                                        } catch (Throwable th) {
                                            cn.jiguang.bb.f.l("ConfigHandlerManager", "Failed to update dy config for dy_id: " + optInt + ", error: " + th.getMessage());
                                        }
                                    }
                                });
                                return;
                            }
                            str = "Skip dy config update: dynamic loading not supported";
                        } else {
                            str = "updateImmediately failed: dy_id not found in config";
                        }
                    } catch (Throwable th) {
                        cn.jiguang.bb.f.l("ConfigHandlerManager", "updateImmediately failed: " + th.getMessage());
                        return;
                    }
                }
                cn.jiguang.bb.f.i("ConfigHandlerManager", str);
            }
        }

        public interface e {
            Integer a();

            void a(Context context, JSONObject jSONObject);
        }

        private static class f implements e {
            private f() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.ba.i.c();
            }

            /* synthetic */ f(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.ba.i.b(context);
            }
        }

        private static class g implements e {
            private g() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.al.f.a().c();
            }

            /* synthetic */ g(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.al.f.a().c(context);
            }
        }

        private static class h implements e {
            private h() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.bo.i.b();
            }

            /* synthetic */ h(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.bo.i.c(context);
            }
        }

        private static class i implements e {
            private i() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.bd.a.b().a();
            }

            /* synthetic */ i(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.bd.a.b().a(context);
            }
        }

        private static class j implements e {
            private j() {
            }

            @Override // cn.jiguang.ba.l.a.e
            public Integer a() {
                return cn.jiguang.aq.a.a().d();
            }

            /* synthetic */ j(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // cn.jiguang.ba.l.a.e
            public void a(Context context, JSONObject jSONObject) {
                cn.jiguang.aq.a.a().c(context);
            }
        }

        static {
            HashMap hashMap = new HashMap();
            f1958a = hashMap;
            AnonymousClass1 anonymousClass1 = null;
            hashMap.put("awake", new C0029a(anonymousClass1));
            hashMap.put("banned", new b(anonymousClass1));
            hashMap.put("dy", new d(anonymousClass1));
            hashMap.put("loc2", new g(anonymousClass1));
            hashMap.put("sis", new i(anonymousClass1));
            hashMap.put("data_conf", new c(anonymousClass1));
            hashMap.put("sentry", new h(anonymousClass1));
            hashMap.put("limit", new f(anonymousClass1));
            hashMap.put("uaid", new j(anonymousClass1));
        }

        public static e a(String str) {
            return f1958a.get(str);
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        Integer f1962a;

        /* renamed from: b, reason: collision with root package name */
        Integer f1963b;

        public boolean a(int i6) {
            Integer num = this.f1962a;
            if (num == null && this.f1963b == null) {
                return true;
            }
            if (num != null && i6 < num.intValue()) {
                return false;
            }
            Integer num2 = this.f1963b;
            return num2 == null || i6 <= num2.intValue();
        }

        public String toString() {
            return "VersionRange{min=" + this.f1962a + ", max=" + this.f1963b + '}';
        }

        b(Integer num, Integer num2) {
            this.f1962a = num;
            this.f1963b = num2;
        }
    }

    private static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("[") && trim.endsWith("]")) {
                String[] split = trim.split(",");
                if (split.length != 2) {
                    cn.jiguang.bb.f.c("ResetConfigurationHelper", "Failed to parse version range: invalid number of parts, expected 2 parts separated by comma, content: " + trim);
                    return null;
                }
                String trim2 = split[0].trim();
                if (trim2.startsWith("[")) {
                    trim2 = trim2.substring(1).trim();
                }
                Integer valueOf = !trim2.isEmpty() ? Integer.valueOf(Integer.parseInt(trim2)) : null;
                String trim3 = split[1].trim();
                if (trim3.endsWith("]")) {
                    trim3 = trim3.substring(0, trim3.length() - 1).trim();
                }
                return new b(valueOf, !trim3.isEmpty() ? Integer.valueOf(Integer.parseInt(trim3)) : null);
            }
            cn.jiguang.bb.f.c("ResetConfigurationHelper", "Parse version range failed: invalid format, should be like [1,5] or [1,] or [,5] or []");
            return null;
        } catch (Exception e6) {
            cn.jiguang.bb.f.l("ResetConfigurationHelper", "Parse version range failed: " + e6.getMessage() + ", input: " + str);
            return null;
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        Context context2;
        JSONObject jSONObject2;
        String optString;
        if (context == null || jSONObject == null) {
            cn.jiguang.bb.f.i("ResetConfigurationHelper", "resetConfiguration failed: context or jsonContent is null");
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("configs");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int i6 = 0;
                while (i6 < optJSONArray.length()) {
                    try {
                        jSONObject2 = optJSONArray.getJSONObject(i6);
                        optString = jSONObject2.optString("type");
                    } catch (Throwable th) {
                        th = th;
                        context2 = context;
                    }
                    if (TextUtils.isEmpty(optString)) {
                        cn.jiguang.bb.f.i("ResetConfigurationHelper", "Skip config: type is empty");
                    } else {
                        cn.jiguang.bb.f.c("ResetConfigurationHelper", "config :" + jSONObject2);
                        b a6 = a(jSONObject2.optString("ver_range"));
                        b a7 = a(jSONObject2.optString("sdk_range"));
                        boolean optBoolean = jSONObject2.optBoolean("partial_update", false);
                        cn.jiguang.bb.f.c("ResetConfigurationHelper", "verRange :" + a6);
                        cn.jiguang.bb.f.c("ResetConfigurationHelper", "sdkRange :" + a7);
                        cn.jiguang.bb.f.c("ResetConfigurationHelper", "partialUpdate :" + optBoolean);
                        if (a7 == null || a7.a(cn.jiguang.a.a.f1445c)) {
                            a.e a8 = a.a(optString);
                            context2 = context;
                            if (a8 != null) {
                                try {
                                    a(context2, jSONObject2, a6, optBoolean, a8, optString);
                                } catch (Throwable th2) {
                                    th = th2;
                                    cn.jiguang.bb.f.l("ResetConfigurationHelper", "Process config at index " + i6 + " failed: " + th.getMessage());
                                    i6++;
                                    context = context2;
                                }
                            } else {
                                cn.jiguang.bb.f.i("ResetConfigurationHelper", "Unknown config type: " + optString);
                            }
                            i6++;
                            context = context2;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Skip config type: ");
                            sb.append(optString);
                            sb.append(", current SDK version ");
                            sb.append(cn.jiguang.a.a.f1445c);
                            sb.append(" not in range [");
                            Object obj = a7.f1962a;
                            if (obj == null) {
                                obj = "";
                            }
                            sb.append(obj);
                            sb.append(",");
                            Integer num = a7.f1963b;
                            sb.append(num != null ? num : "");
                            sb.append("]");
                            cn.jiguang.bb.f.c("ResetConfigurationHelper", sb.toString());
                        }
                    }
                    context2 = context;
                    i6++;
                    context = context2;
                }
                return;
            }
            cn.jiguang.bb.f.i("ResetConfigurationHelper", "resetConfiguration failed: configs is empty");
        } catch (Throwable th3) {
            cn.jiguang.bb.f.l("ResetConfigurationHelper", "resetConfiguration failed: " + th3.getMessage());
        }
    }

    private static void a(Context context, JSONObject jSONObject, b bVar, boolean z5, a.e eVar, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Handle ");
        sb.append(str);
        sb.append(" config: verRange=[");
        if (bVar != null) {
            str2 = bVar.f1962a + "," + bVar.f1963b;
        } else {
            str2 = "null";
        }
        sb.append(str2);
        sb.append("], partialUpdate=");
        sb.append(z5);
        cn.jiguang.bb.f.c("ResetConfigurationHelper", sb.toString());
        Integer a6 = eVar.a();
        if (a6 == null || bVar == null || bVar.a(a6.intValue())) {
            eVar.a(context, jSONObject);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Skip ");
        sb2.append(str);
        sb2.append(" update: current protocol version ");
        sb2.append(a6);
        sb2.append(" not in range [");
        Object obj = bVar.f1962a;
        if (obj == null) {
            obj = "";
        }
        sb2.append(obj);
        sb2.append(",");
        Integer num = bVar.f1963b;
        sb2.append(num != null ? num : "");
        sb2.append("]");
        cn.jiguang.bb.f.c("ResetConfigurationHelper", sb2.toString());
    }
}
