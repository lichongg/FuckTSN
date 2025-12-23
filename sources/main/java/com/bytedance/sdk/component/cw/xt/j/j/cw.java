package com.bytedance.sdk.component.cw.xt.j.j;

import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.w;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw {

    /* renamed from: j, reason: collision with root package name */
    public final s f26188j;
    public final p xt;

    public static class j {
        private String ae;
        final p cw;

        /* renamed from: g, reason: collision with root package name */
        private long f26189g;

        /* renamed from: j, reason: collision with root package name */
        final long f26190j;

        /* renamed from: m, reason: collision with root package name */
        private Date f26191m;
        private long oq;
        private String qv;

        /* renamed from: r, reason: collision with root package name */
        private Date f26192r;
        private Date tl;
        private String up;
        private int vl;
        final s xt;

        public cw j() {
            cw xt = xt();
            return (xt.f26188j == null || !this.xt.ae().g()) ? xt : new cw(null, null);
        }

        private long cw() {
            if (this.cw.vl().cw() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.cw());
            }
            if (this.tl != null) {
                Date date = this.f26192r;
                long time = this.tl.getTime() - (date != null ? date.getTime() : this.oq);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f26191m != null && this.cw.j().j().query() == null) {
                Date date2 = this.f26192r;
                long time2 = (date2 != null ? date2.getTime() : this.f26189g) - this.f26191m.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private long r() {
            Date date = this.f26192r;
            long max = date != null ? Math.max(0L, this.oq - date.getTime()) : 0L;
            int i6 = this.vl;
            if (i6 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i6));
            }
            long j6 = this.oq;
            return max + (j6 - this.f26189g) + (this.f26190j - j6);
        }

        private boolean up() {
            return this.cw.vl().cw() == -1 && this.tl == null;
        }

        private cw xt() {
            String str;
            if (this.cw == null) {
                return new cw(this.xt, null);
            }
            if (this.xt.tl() && this.cw.m() == null) {
                return new cw(this.xt, null);
            }
            if (!cw.j(this.cw, this.xt)) {
                return new cw(this.xt, null);
            }
            com.bytedance.sdk.component.cw.xt.r ae = this.xt.ae();
            if (ae.j() || j(this.xt)) {
                return new cw(this.xt, null);
            }
            com.bytedance.sdk.component.cw.xt.r vl = this.cw.vl();
            if (vl.oq()) {
                return new cw(null, this.cw);
            }
            long r5 = r();
            long cw = cw();
            if (ae.cw() != -1) {
                cw = Math.min(cw, TimeUnit.SECONDS.toMillis(ae.cw()));
            }
            long j6 = 0;
            long millis = ae.tl() != -1 ? TimeUnit.SECONDS.toMillis(ae.tl()) : 0L;
            if (!vl.m() && ae.ae() != -1) {
                j6 = TimeUnit.SECONDS.toMillis(ae.ae());
            }
            if (!vl.j()) {
                long j7 = millis + r5;
                if (j7 < j6 + cw) {
                    p.j g6 = this.cw.g();
                    if (j7 >= cw) {
                        g6.j("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (r5 > 86400000 && up()) {
                        g6.j("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new cw(null, g6.j());
                }
            }
            String str2 = this.qv;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.f26191m != null) {
                    str2 = this.ae;
                } else {
                    if (this.f26192r == null) {
                        return new cw(this.xt, null);
                    }
                    str2 = this.up;
                }
                str = "If-Modified-Since";
            }
            w.j xt = this.xt.cw().xt();
            com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(xt, str, str2);
            return new cw(this.xt.m().j(xt.j()).j(), this.cw);
        }

        public j(long j6, s sVar, p pVar) {
            this.vl = -1;
            this.f26190j = j6;
            this.xt = sVar;
            this.cw = pVar;
            if (pVar != null) {
                this.f26189g = pVar.jy();
                this.oq = pVar.ws();
                w ae = pVar.ae();
                int j7 = ae.j();
                for (int i6 = 0; i6 < j7; i6++) {
                    String j8 = ae.j(i6);
                    String xt = ae.xt(i6);
                    if ("Date".equalsIgnoreCase(j8)) {
                        this.f26192r = com.bytedance.sdk.component.cw.xt.j.cw.r.j(xt);
                        this.up = xt;
                    } else if ("Expires".equalsIgnoreCase(j8)) {
                        this.tl = com.bytedance.sdk.component.cw.xt.j.cw.r.j(xt);
                    } else if ("Last-Modified".equalsIgnoreCase(j8)) {
                        this.f26191m = com.bytedance.sdk.component.cw.xt.j.cw.r.j(xt);
                        this.ae = xt;
                    } else if ("ETag".equalsIgnoreCase(j8)) {
                        this.qv = xt;
                    } else if ("Age".equalsIgnoreCase(j8)) {
                        this.vl = com.bytedance.sdk.component.cw.xt.j.cw.up.xt(xt, -1);
                    }
                }
            }
        }

        private static boolean j(s sVar) {
            return (sVar.j("If-Modified-Since") == null && sVar.j("If-None-Match") == null) ? false : true;
        }
    }

    cw(s sVar, p pVar) {
        this.f26188j = sVar;
        this.xt = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.vl().r() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean j(com.bytedance.sdk.component.cw.xt.p r3, com.bytedance.sdk.component.cw.xt.s r4) {
        /*
            int r0 = r3.cw()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L59
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L59
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L59
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L59
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L59
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L59
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L59
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L59
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L59
            switch(r0) {
                case 300: goto L59;
                case 301: goto L59;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L58
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.j(r0)
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.cw.xt.r r0 = r3.vl()
            int r0 = r0.cw()
            r1 = -1
            if (r0 != r1) goto L59
            com.bytedance.sdk.component.cw.xt.r r0 = r3.vl()
            boolean r0 = r0.up()
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.cw.xt.r r0 = r3.vl()
            boolean r0 = r0.r()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            com.bytedance.sdk.component.cw.xt.r r3 = r3.vl()
            boolean r3 = r3.xt()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.component.cw.xt.r r3 = r4.ae()
            boolean r3 = r3.xt()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.j.cw.j(com.bytedance.sdk.component.cw.xt.p, com.bytedance.sdk.component.cw.xt.s):boolean");
    }
}
