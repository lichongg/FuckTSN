package com.bytedance.sdk.component.cw.xt;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class qv {
    public static final qv cw;

    /* renamed from: j, reason: collision with root package name */
    public static final qv f26350j;
    private static final tl[] tl;
    public static final qv xt;
    final String[] ae;

    /* renamed from: m, reason: collision with root package name */
    final String[] f26351m;

    /* renamed from: r, reason: collision with root package name */
    final boolean f26352r;
    final boolean up;

    public static final class j {
        String[] cw;

        /* renamed from: j, reason: collision with root package name */
        boolean f26353j;

        /* renamed from: r, reason: collision with root package name */
        boolean f26354r;
        String[] xt;

        j(boolean z5) {
            this.f26353j = z5;
        }

        public j j(tl... tlVarArr) {
            if (!this.f26353j) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[tlVarArr.length];
            for (int i6 = 0; i6 < tlVarArr.length; i6++) {
                strArr[i6] = tlVarArr[i6].f26376i;
            }
            return j(strArr);
        }

        public j xt(String... strArr) {
            if (!this.f26353j) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.cw = (String[]) strArr.clone();
            return this;
        }

        public j(qv qvVar) {
            this.f26353j = qvVar.f26352r;
            this.xt = qvVar.f26351m;
            this.cw = qvVar.ae;
            this.f26354r = qvVar.up;
        }

        public j j(String... strArr) {
            if (this.f26353j) {
                if (strArr.length != 0) {
                    this.xt = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public j j(gq... gqVarArr) {
            if (this.f26353j) {
                String[] strArr = new String[gqVarArr.length];
                for (int i6 = 0; i6 < gqVarArr.length; i6++) {
                    strArr[i6] = gqVarArr[i6].f26141m;
                }
                return xt(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public j j(boolean z5) {
            if (this.f26353j) {
                this.f26354r = z5;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public qv j() {
            return new qv(this);
        }
    }

    public boolean j() {
        return this.f26352r;
    }

    public List<tl> xt() {
        String[] strArr = this.f26351m;
        if (strArr != null) {
            return tl.j(strArr);
        }
        return null;
    }

    static {
        tl[] tlVarArr = {tl.qv, tl.jy, tl.vl, tl.ws, tl.av, tl.az, tl.ae, tl.f26371g, tl.tl, tl.oq, tl.up, tl.f26373m, tl.cw, tl.f26374r, tl.xt};
        tl = tlVarArr;
        j j6 = new j(true).j(tlVarArr);
        gq gqVar = gq.TLS_1_0;
        qv j7 = j6.j(gq.TLS_1_3, gq.TLS_1_2, gq.TLS_1_1, gqVar).j(true).j();
        f26350j = j7;
        xt = new j(j7).j(gqVar).j(true).j();
        cw = new j(false).j();
    }

    private qv xt(SSLSocket sSLSocket, boolean z5) {
        String[] j6 = this.f26351m != null ? com.bytedance.sdk.component.cw.xt.j.cw.j(tl.f26372j, sSLSocket.getEnabledCipherSuites(), this.f26351m) : sSLSocket.getEnabledCipherSuites();
        String[] j7 = this.ae != null ? com.bytedance.sdk.component.cw.xt.j.cw.j(com.bytedance.sdk.component.cw.xt.j.cw.tl, sSLSocket.getEnabledProtocols(), this.ae) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int j8 = com.bytedance.sdk.component.cw.xt.j.cw.j(tl.f26372j, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z5 && j8 != -1) {
            j6 = com.bytedance.sdk.component.cw.xt.j.cw.j(j6, supportedCipherSuites[j8]);
        }
        return new j(this).j(j6).xt(j7).j();
    }

    public List<gq> cw() {
        String[] strArr = this.ae;
        if (strArr != null) {
            return gq.j(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qv)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        qv qvVar = (qv) obj;
        boolean z5 = this.f26352r;
        if (z5 != qvVar.f26352r) {
            return false;
        }
        return !z5 || (Arrays.equals(this.f26351m, qvVar.f26351m) && Arrays.equals(this.ae, qvVar.ae) && this.up == qvVar.up);
    }

    public int hashCode() {
        if (this.f26352r) {
            return ((((Arrays.hashCode(this.f26351m) + 527) * 31) + Arrays.hashCode(this.ae)) * 31) + (!this.up ? 1 : 0);
        }
        return 17;
    }

    void j(SSLSocket sSLSocket, boolean z5) {
        qv xt2 = xt(sSLSocket, z5);
        String[] strArr = xt2.ae;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = xt2.f26351m;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean r() {
        return this.up;
    }

    public String toString() {
        if (!this.f26352r) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f26351m != null ? xt().toString() : "[all enabled]") + ", tlsVersions=" + (this.ae != null ? cw().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.up + ")";
    }

    qv(j jVar) {
        this.f26352r = jVar.f26353j;
        this.f26351m = jVar.xt;
        this.ae = jVar.cw;
        this.up = jVar.f26354r;
    }

    public boolean j(SSLSocket sSLSocket) {
        if (!this.f26352r) {
            return false;
        }
        String[] strArr = this.ae;
        if (strArr != null && !com.bytedance.sdk.component.cw.xt.j.cw.xt(com.bytedance.sdk.component.cw.xt.j.cw.tl, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f26351m;
        return strArr2 == null || com.bytedance.sdk.component.cw.xt.j.cw.xt(tl.f26372j, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
