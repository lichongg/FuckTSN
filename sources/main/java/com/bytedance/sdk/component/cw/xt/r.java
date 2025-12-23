package com.bytedance.sdk.component.cw.xt;

import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class r {

    /* renamed from: j, reason: collision with root package name */
    public static final r f26355j = new j().j().cw();
    public static final r xt = new j().xt().j(Integer.MAX_VALUE, TimeUnit.SECONDS).cw();
    private final int ae;
    private final boolean az;
    String cw;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f26356g;
    private final boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private final int f26357m;
    private final boolean oq;
    private final int qv;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f26358r;
    private final boolean tl;
    private final boolean up;
    private final int vl;
    private final boolean ws;

    public static final class j {
        boolean ae;

        /* renamed from: j, reason: collision with root package name */
        boolean f26359j;

        /* renamed from: m, reason: collision with root package name */
        boolean f26360m;
        boolean tl;
        boolean xt;
        int cw = -1;

        /* renamed from: r, reason: collision with root package name */
        int f26361r = -1;
        int up = -1;

        public j j() {
            this.f26359j = true;
            return this;
        }

        public j xt() {
            this.f26360m = true;
            return this;
        }

        public r cw() {
            return new r(this);
        }

        public j j(int i6, TimeUnit timeUnit) {
            if (i6 < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i6)));
            }
            long seconds = timeUnit.toSeconds(i6);
            this.f26361r = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }
    }

    private r(boolean z5, boolean z6, int i6, int i7, boolean z7, boolean z8, boolean z9, int i8, int i9, boolean z10, boolean z11, boolean z12, String str) {
        this.f26358r = z5;
        this.up = z6;
        this.f26357m = i6;
        this.ae = i7;
        this.tl = z7;
        this.f26356g = z8;
        this.oq = z9;
        this.qv = i8;
        this.vl = i9;
        this.jy = z10;
        this.ws = z11;
        this.az = z12;
        this.cw = str;
    }

    public boolean j() {
        return this.f26358r;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.cw.xt.r j(com.bytedance.sdk.component.cw.xt.w r23) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.r.j(com.bytedance.sdk.component.cw.xt.w):com.bytedance.sdk.component.cw.xt.r");
    }

    private String qv() {
        StringBuilder sb = new StringBuilder();
        if (this.f26358r) {
            sb.append("no-cache, ");
        }
        if (this.up) {
            sb.append("no-store, ");
        }
        if (this.f26357m != -1) {
            sb.append("max-age=");
            sb.append(this.f26357m);
            sb.append(", ");
        }
        if (this.ae != -1) {
            sb.append("s-maxage=");
            sb.append(this.ae);
            sb.append(", ");
        }
        if (this.tl) {
            sb.append("private, ");
        }
        if (this.f26356g) {
            sb.append("public, ");
        }
        if (this.oq) {
            sb.append("must-revalidate, ");
        }
        if (this.qv != -1) {
            sb.append("max-stale=");
            sb.append(this.qv);
            sb.append(", ");
        }
        if (this.vl != -1) {
            sb.append("min-fresh=");
            sb.append(this.vl);
            sb.append(", ");
        }
        if (this.jy) {
            sb.append("only-if-cached, ");
        }
        if (this.ws) {
            sb.append("no-transform, ");
        }
        if (this.az) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public int ae() {
        return this.qv;
    }

    public int cw() {
        return this.f26357m;
    }

    public boolean g() {
        return this.jy;
    }

    public boolean m() {
        return this.oq;
    }

    public boolean oq() {
        return this.az;
    }

    public boolean r() {
        return this.tl;
    }

    public int tl() {
        return this.vl;
    }

    public String toString() {
        String str = this.cw;
        if (str != null) {
            return str;
        }
        String qv = qv();
        this.cw = qv;
        return qv;
    }

    public boolean up() {
        return this.f26356g;
    }

    public boolean xt() {
        return this.up;
    }

    r(j jVar) {
        this.f26358r = jVar.f26359j;
        this.up = jVar.xt;
        this.f26357m = jVar.cw;
        this.ae = -1;
        this.tl = false;
        this.f26356g = false;
        this.oq = false;
        this.qv = jVar.f26361r;
        this.vl = jVar.up;
        this.jy = jVar.f26360m;
        this.ws = jVar.ae;
        this.az = jVar.tl;
    }
}
