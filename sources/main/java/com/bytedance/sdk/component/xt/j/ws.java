package com.bytedance.sdk.component.xt.j;

import com.bytedance.sdk.component.xt.j.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ws {

    /* renamed from: j, reason: collision with root package name */
    public vl f27316j;

    public static class j {
        m.j ae;
        ae cw;

        /* renamed from: j, reason: collision with root package name */
        com.bytedance.sdk.component.xt.j.j f27317j;

        /* renamed from: m, reason: collision with root package name */
        az f27318m;

        /* renamed from: r, reason: collision with root package name */
        String f27319r;
        Object up;
        public Map<String, List<String>> xt;

        public j() {
            this.xt = new HashMap();
            this.ae = new m.j();
        }

        public j j(com.bytedance.sdk.component.xt.j.j jVar) {
            this.f27317j = jVar;
            return this;
        }

        public j xt(String str, String str2) {
            if (!this.xt.containsKey(str)) {
                this.xt.put(str, new ArrayList());
            }
            this.xt.get(str).add(str2);
            return this;
        }

        public j j(Object obj) {
            this.up = obj;
            return this;
        }

        public j j(String str) {
            String str2;
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str2 = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str2 = "https:" + str.substring(4);
                } else {
                    str2 = str;
                }
                ae cw = ae.cw(str2);
                if (cw != null) {
                    return j(cw);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str2)));
            }
            throw new NullPointerException("url == null");
        }

        j(ws wsVar) {
            this.cw = wsVar.xt();
            this.f27319r = wsVar.cw();
            this.xt = wsVar.r();
            this.up = wsVar.j();
            this.f27318m = wsVar.m();
            this.f27317j = wsVar.up();
        }

        public ws xt() {
            return new ws() { // from class: com.bytedance.sdk.component.xt.j.ws.j.1
                @Override // com.bytedance.sdk.component.xt.j.ws
                public String cw() {
                    return j.this.f27319r;
                }

                @Override // com.bytedance.sdk.component.xt.j.ws
                public Object j() {
                    return j.this.up;
                }

                @Override // com.bytedance.sdk.component.xt.j.ws
                public az m() {
                    return j.this.f27318m;
                }

                @Override // com.bytedance.sdk.component.xt.j.ws
                public Map r() {
                    return j.this.xt;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.xt.j.ws
                public com.bytedance.sdk.component.xt.j.j up() {
                    return j.this.f27317j;
                }

                @Override // com.bytedance.sdk.component.xt.j.ws
                public ae xt() {
                    return j.this.cw;
                }
            };
        }

        public j j(ae aeVar) {
            this.cw = aeVar;
            return this;
        }

        public j j(String str, String str2) {
            return xt(str, str2);
        }

        public j j(m mVar) {
            if (mVar != null) {
                this.xt = mVar.xt();
            }
            return this;
        }

        public j j() {
            return j("GET", (az) null);
        }

        public j j(String str, az azVar) {
            this.f27319r = str;
            this.f27318m = azVar;
            return this;
        }

        public j j(az azVar) {
            return j("POST", azVar);
        }
    }

    public abstract String cw();

    public abstract Object j();

    public void j(vl vlVar) {
        this.f27316j = vlVar;
    }

    public az m() {
        return null;
    }

    public abstract Map<String, List<String>> r();

    public abstract com.bytedance.sdk.component.xt.j.j up();

    public abstract ae xt();

    public j ae() {
        return new j(this);
    }
}
