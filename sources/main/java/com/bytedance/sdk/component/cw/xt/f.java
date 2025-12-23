package com.bytedance.sdk.component.cw.xt;

import io.netty.handler.codec.http.HttpConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class f extends a {

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.sdk.component.cw.j.m f26136g;
    private long jy = -1;
    private final tj oq;
    private final tj qv;
    private final List<xt> vl;

    /* renamed from: j, reason: collision with root package name */
    public static final tj f26133j = tj.j("multipart/mixed");
    public static final tj xt = tj.j("multipart/alternative");
    public static final tj cw = tj.j("multipart/digest");

    /* renamed from: r, reason: collision with root package name */
    public static final tj f26135r = tj.j("multipart/parallel");
    public static final tj up = tj.j("multipart/form-data");

    /* renamed from: m, reason: collision with root package name */
    private static final byte[] f26134m = {HttpConstants.COLON, 32};
    private static final byte[] ae = {13, 10};
    private static final byte[] tl = {45, 45};

    public static final class j {
        private final List<xt> cw;

        /* renamed from: j, reason: collision with root package name */
        private final com.bytedance.sdk.component.cw.j.m f26137j;
        private tj xt;

        public j() {
            this(UUID.randomUUID().toString());
        }

        public j j(tj tjVar) {
            if (tjVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!tjVar.j().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(tjVar)));
            }
            this.xt = tjVar;
            return this;
        }

        public j(String str) {
            this.xt = f.f26133j;
            this.cw = new ArrayList();
            this.f26137j = com.bytedance.sdk.component.cw.j.m.j(str);
        }

        public j j(String str, String str2, a aVar) {
            return j(xt.j(str, str2, aVar));
        }

        public j j(xt xtVar) {
            if (xtVar != null) {
                this.cw.add(xtVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public f j() {
            if (!this.cw.isEmpty()) {
                return new f(this.f26137j, this.xt, this.cw);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.a
    public tj j() {
        return this.qv;
    }

    public static final class xt {

        /* renamed from: j, reason: collision with root package name */
        final w f26138j;
        final a xt;

        public static xt j(w wVar, a aVar) {
            if (aVar == null) {
                throw new NullPointerException("body == null");
            }
            if (wVar != null && wVar.j("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (wVar == null || wVar.j("Content-Length") == null) {
                return new xt(wVar, aVar);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        private xt(w wVar, a aVar) {
            this.f26138j = wVar;
            this.xt = aVar;
        }

        public static xt j(String str, String str2, a aVar) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                f.j(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    f.j(sb, str2);
                }
                return j(w.j("Content-Disposition", sb.toString()), aVar);
            }
            throw new NullPointerException("name == null");
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.a
    public void j(com.bytedance.sdk.component.cw.j.r rVar) throws IOException {
        j(rVar, false);
    }

    @Override // com.bytedance.sdk.component.cw.xt.a
    public long xt() throws IOException {
        long j6 = this.jy;
        if (j6 != -1) {
            return j6;
        }
        long j7 = j((com.bytedance.sdk.component.cw.j.r) null, true);
        this.jy = j7;
        return j7;
    }

    f(com.bytedance.sdk.component.cw.j.m mVar, tj tjVar, List<xt> list) {
        this.f26136g = mVar;
        this.oq = tjVar;
        this.qv = tj.j(tjVar + "; boundary=" + mVar.j());
        this.vl = com.bytedance.sdk.component.cw.xt.j.cw.j(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long j(com.bytedance.sdk.component.cw.j.r rVar, boolean z5) throws IOException {
        com.bytedance.sdk.component.cw.j.cw cwVar;
        if (z5) {
            rVar = new com.bytedance.sdk.component.cw.j.cw();
            cwVar = rVar;
        } else {
            cwVar = 0;
        }
        int size = this.vl.size();
        long j6 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            xt xtVar = this.vl.get(i6);
            w wVar = xtVar.f26138j;
            a aVar = xtVar.xt;
            rVar.cw(tl);
            rVar.xt(this.f26136g);
            rVar.cw(ae);
            if (wVar != null) {
                int j7 = wVar.j();
                for (int i7 = 0; i7 < j7; i7++) {
                    rVar.xt(wVar.j(i7)).cw(f26134m).xt(wVar.xt(i7)).cw(ae);
                }
            }
            tj j8 = aVar.j();
            if (j8 != null) {
                rVar.xt("Content-Type: ").xt(j8.toString()).cw(ae);
            }
            long xt2 = aVar.xt();
            if (xt2 != -1) {
                rVar.xt("Content-Length: ").vl(xt2).cw(ae);
            } else if (z5) {
                cwVar.w();
                return -1L;
            }
            byte[] bArr = ae;
            rVar.cw(bArr);
            if (z5) {
                j6 += xt2;
            } else {
                aVar.j(rVar);
            }
            rVar.cw(bArr);
        }
        byte[] bArr2 = tl;
        rVar.cw(bArr2);
        rVar.xt(this.f26136g);
        rVar.cw(bArr2);
        rVar.cw(ae);
        if (!z5) {
            return j6;
        }
        long xt3 = j6 + cwVar.xt();
        cwVar.w();
        return xt3;
    }

    static StringBuilder j(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }
}
