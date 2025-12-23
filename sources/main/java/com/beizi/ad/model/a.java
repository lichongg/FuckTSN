package com.beizi.ad.model;

import com.beizi.ad.model.e;
import com.beizi.ad.model.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.model.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.model.a$a, reason: collision with other inner class name */
    public static class C0120a {

        /* renamed from: a, reason: collision with root package name */
        private String f12768a;

        /* renamed from: b, reason: collision with root package name */
        private String f12769b;

        /* renamed from: c, reason: collision with root package name */
        private String f12770c;

        /* renamed from: d, reason: collision with root package name */
        private long f12771d;

        /* renamed from: e, reason: collision with root package name */
        private String f12772e;

        /* renamed from: f, reason: collision with root package name */
        private int f12773f;

        /* renamed from: g, reason: collision with root package name */
        private List<String> f12774g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.ad.model.a$a$a, reason: collision with other inner class name */
        public static final class C0121a {

            /* renamed from: a, reason: collision with root package name */
            private String f12775a;

            /* renamed from: b, reason: collision with root package name */
            private String f12776b;

            /* renamed from: c, reason: collision with root package name */
            private String f12777c;

            /* renamed from: d, reason: collision with root package name */
            private long f12778d;

            /* renamed from: e, reason: collision with root package name */
            private String f12779e;

            /* renamed from: f, reason: collision with root package name */
            private int f12780f;

            /* renamed from: g, reason: collision with root package name */
            private List<String> f12781g;

            public C0121a a(String str) {
                this.f12775a = str;
                return this;
            }

            public C0121a a(int i6) {
                this.f12780f = i6;
                return this;
            }

            public C0121a b(String str) {
                this.f12776b = str;
                return this;
            }

            public C0121a c(String str) {
                this.f12777c = str;
                return this;
            }

            public C0121a a(List<String> list) {
                this.f12781g = list;
                return this;
            }

            public C0120a a() {
                C0120a c0120a = new C0120a(null);
                c0120a.f12771d = this.f12778d;
                c0120a.f12770c = this.f12777c;
                c0120a.f12772e = this.f12779e;
                c0120a.f12769b = this.f12776b;
                c0120a.f12768a = this.f12775a;
                c0120a.f12773f = this.f12780f;
                c0120a.f12774g = this.f12781g;
                return c0120a;
            }
        }

        /* synthetic */ C0120a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private C0120a() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("spaceID", this.f12768a);
                jSONObject.put("spaceParam", this.f12769b);
                jSONObject.put("requestUUID", this.f12770c);
                jSONObject.put("channelReserveTs", this.f12771d);
                jSONObject.put("sdkExtInfo", this.f12772e);
                jSONObject.put("isCache", this.f12773f);
                List<String> list = this.f12774g;
                if (list != null && list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i6 = 0; i6 < this.f12774g.size(); i6++) {
                        jSONArray.put(this.f12774g.get(i6));
                    }
                    jSONObject.put("orderList", jSONArray);
                }
                return jSONObject;
            } catch (JSONException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f12782a;

        /* renamed from: b, reason: collision with root package name */
        private f.i f12783b;

        /* renamed from: c, reason: collision with root package name */
        private f.g f12784c;

        /* renamed from: d, reason: collision with root package name */
        private long f12785d;

        /* renamed from: e, reason: collision with root package name */
        private String f12786e;

        /* renamed from: f, reason: collision with root package name */
        private String f12787f;

        /* renamed from: g, reason: collision with root package name */
        private String f12788g;

        /* renamed from: h, reason: collision with root package name */
        private long f12789h;

        /* renamed from: i, reason: collision with root package name */
        private long f12790i;

        /* renamed from: j, reason: collision with root package name */
        private e.a f12791j;

        /* renamed from: k, reason: collision with root package name */
        private e.c f12792k;

        /* renamed from: l, reason: collision with root package name */
        private ArrayList<C0120a> f12793l;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.ad.model.a$b$a, reason: collision with other inner class name */
        public static final class C0122a {

            /* renamed from: a, reason: collision with root package name */
            private String f12794a;

            /* renamed from: b, reason: collision with root package name */
            private f.i f12795b;

            /* renamed from: c, reason: collision with root package name */
            private f.g f12796c;

            /* renamed from: d, reason: collision with root package name */
            private long f12797d;

            /* renamed from: e, reason: collision with root package name */
            private String f12798e;

            /* renamed from: f, reason: collision with root package name */
            private String f12799f;

            /* renamed from: g, reason: collision with root package name */
            private String f12800g;

            /* renamed from: h, reason: collision with root package name */
            private long f12801h;

            /* renamed from: i, reason: collision with root package name */
            private long f12802i;

            /* renamed from: j, reason: collision with root package name */
            private e.a f12803j;

            /* renamed from: k, reason: collision with root package name */
            private e.c f12804k;

            /* renamed from: l, reason: collision with root package name */
            private ArrayList<C0120a> f12805l = new ArrayList<>();

            public C0122a a(String str) {
                this.f12794a = str;
                return this;
            }

            public C0122a b(String str) {
                this.f12798e = str;
                return this;
            }

            public C0122a c(String str) {
                this.f12799f = str;
                return this;
            }

            public C0122a a(f.i iVar) {
                this.f12795b = iVar;
                return this;
            }

            public C0122a b(long j6) {
                this.f12801h = j6;
                return this;
            }

            public C0122a c(long j6) {
                this.f12802i = j6;
                return this;
            }

            public C0122a d(String str) {
                this.f12800g = str;
                return this;
            }

            public C0122a a(f.g gVar) {
                this.f12796c = gVar;
                return this;
            }

            public C0122a a(long j6) {
                this.f12797d = j6;
                return this;
            }

            public C0122a a(e.a aVar) {
                this.f12803j = aVar;
                return this;
            }

            public C0122a a(e.c cVar) {
                this.f12804k = cVar;
                return this;
            }

            public b a() {
                b bVar = new b(null);
                bVar.f12786e = this.f12798e;
                bVar.f12791j = this.f12803j;
                bVar.f12784c = this.f12796c;
                bVar.f12789h = this.f12801h;
                bVar.f12783b = this.f12795b;
                bVar.f12785d = this.f12797d;
                bVar.f12788g = this.f12800g;
                bVar.f12790i = this.f12802i;
                bVar.f12792k = this.f12804k;
                bVar.f12793l = this.f12805l;
                bVar.f12787f = this.f12799f;
                bVar.f12782a = this.f12794a;
                return bVar;
            }

            public void a(C0120a c0120a) {
                this.f12805l.add(c0120a);
            }
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        private b() {
        }

        public String toString() {
            return a();
        }

        private String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", this.f12782a);
                jSONObject.put("srcType", this.f12783b);
                jSONObject.put("reqType", this.f12784c);
                jSONObject.put("timeStamp", this.f12785d);
                jSONObject.put("appid", this.f12786e);
                jSONObject.put("appVersion", this.f12787f);
                jSONObject.put("apkName", this.f12788g);
                jSONObject.put("appInstallTime", this.f12789h);
                jSONObject.put("appUpdateTime", this.f12790i);
                e.a aVar = this.f12791j;
                if (aVar != null) {
                    jSONObject.put("devInfo", aVar.a());
                }
                e.c cVar = this.f12792k;
                if (cVar != null) {
                    jSONObject.put("envInfo", cVar.a());
                }
                ArrayList<C0120a> arrayList = this.f12793l;
                if (arrayList != null && arrayList.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i6 = 0; i6 < this.f12793l.size(); i6++) {
                        jSONArray.put(this.f12793l.get(i6).a());
                    }
                    jSONObject.put("adReqInfo", jSONArray);
                }
                return jSONObject.toString();
            } catch (JSONException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }
}
