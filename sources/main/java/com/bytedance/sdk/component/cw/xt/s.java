package com.bytedance.sdk.component.cw.xt;

import com.bytedance.sdk.component.cw.xt.w;
import java.net.URL;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class s {
    private volatile r ae;
    final w cw;

    /* renamed from: j, reason: collision with root package name */
    final mi f26362j;

    /* renamed from: m, reason: collision with root package name */
    public l f26363m;

    /* renamed from: r, reason: collision with root package name */
    final a f26364r;
    final Object up;
    final String xt;

    public static class j {
        w.j cw;

        /* renamed from: j, reason: collision with root package name */
        mi f26365j;

        /* renamed from: m, reason: collision with root package name */
        l f26366m;

        /* renamed from: r, reason: collision with root package name */
        a f26367r;
        Object up;
        String xt;

        public j() {
            this.xt = "GET";
            this.cw = new w.j();
        }

        public j delete(a aVar) {
            return j("DELETE", aVar);
        }

        public j j(mi miVar) {
            if (miVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f26365j = miVar;
            return this;
        }

        public j xt(String str, String str2) {
            this.cw.j(str, str2);
            return this;
        }

        public j delete() {
            return delete(com.bytedance.sdk.component.cw.xt.j.cw.f26165r);
        }

        public j xt(String str) {
            this.cw.xt(str);
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
                mi up = mi.up(str2);
                if (up != null) {
                    return j(up);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str2)));
            }
            throw new NullPointerException("url == null");
        }

        j(s sVar) {
            this.f26365j = sVar.f26362j;
            this.xt = sVar.xt;
            this.f26367r = sVar.f26364r;
            this.up = sVar.up;
            this.cw = sVar.cw.xt();
            this.f26366m = sVar.f26363m;
        }

        public j j(URL url) {
            if (url != null) {
                mi j6 = mi.j(url);
                if (j6 != null) {
                    return j(j6);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            throw new NullPointerException("url == null");
        }

        public j j(String str, String str2) {
            this.cw.cw(str, str2);
            return this;
        }

        public j j(w wVar) {
            this.cw = wVar.xt();
            return this;
        }

        public j j(r rVar) {
            String rVar2 = rVar.toString();
            return rVar2.isEmpty() ? xt("Cache-Control") : j("Cache-Control", rVar2);
        }

        public j j(String str, a aVar) {
            if (str != null) {
                if (str.length() == 0) {
                    throw new IllegalArgumentException("method.length() == 0");
                }
                if (aVar != null && !com.bytedance.sdk.component.cw.xt.j.cw.m.cw(str)) {
                    throw new IllegalArgumentException("method " + str + " must not have a request body.");
                }
                if (aVar == null && com.bytedance.sdk.component.cw.xt.j.cw.m.xt(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                }
                this.xt = str;
                this.f26367r = aVar;
                return this;
            }
            throw new NullPointerException("method == null");
        }

        public j j(Object obj) {
            this.up = obj;
            return this;
        }

        public s j() {
            if (this.f26365j != null) {
                return new s(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public mi j() {
        return this.f26362j;
    }

    public r ae() {
        r rVar = this.ae;
        if (rVar != null) {
            return rVar;
        }
        r j6 = r.j(this.cw);
        this.ae = j6;
        return j6;
    }

    public w cw() {
        return this.cw;
    }

    public String j(String str) {
        return this.cw.j(str);
    }

    public j m() {
        return new j(this);
    }

    public a r() {
        return this.f26364r;
    }

    public boolean tl() {
        return this.f26362j.r();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.xt);
        sb.append(", url=");
        sb.append(this.f26362j);
        sb.append(", tag=");
        Object obj = this.up;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public Object up() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    s(j jVar) {
        this.f26362j = jVar.f26365j;
        this.xt = jVar.xt;
        this.cw = jVar.cw.j();
        this.f26364r = jVar.f26367r;
        Object obj = jVar.up;
        this.up = obj == null ? this : obj;
        l lVar = jVar.f26366m;
        if (lVar != null) {
            this.f26363m = lVar;
        } else {
            this.f26363m = new l();
        }
    }
}
