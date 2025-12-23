package com.bytedance.sdk.component.cw.xt.j.up;

import com.baidu.mobads.sdk.internal.cl;
import com.bytedance.sdk.component.cw.j.mi;
import com.google.common.primitives.SignedBytes;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;
import xyz.adscope.common.network.Headers;

/* loaded from: D:\Downloads\app\classes4.dex */
final class r {

    /* renamed from: j, reason: collision with root package name */
    static final cw[] f26285j;
    static final Map<com.bytedance.sdk.component.cw.j.m, Integer> xt;

    static final class j {
        private final int ae;
        int cw;

        /* renamed from: j, reason: collision with root package name */
        cw[] f26286j;

        /* renamed from: m, reason: collision with root package name */
        private final com.bytedance.sdk.component.cw.j.up f26287m;

        /* renamed from: r, reason: collision with root package name */
        int f26288r;
        private int tl;
        private final List<cw> up;
        int xt;

        j(int i6, mi miVar) {
            this(i6, i6, miVar);
        }

        private void ae() throws IOException {
            j(-1, new cw(r.j(cw()), cw()));
        }

        private int cw(int i6) {
            return this.xt + 1 + i6;
        }

        private int j(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.f26286j.length;
                while (true) {
                    length--;
                    i7 = this.xt;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    int i9 = this.f26286j[length].f26263g;
                    i6 -= i9;
                    this.f26288r -= i9;
                    this.cw--;
                    i8++;
                }
                cw[] cwVarArr = this.f26286j;
                System.arraycopy(cwVarArr, i7 + 1, cwVarArr, i7 + 1 + i8, this.cw);
                this.xt += i8;
            }
            return i8;
        }

        private void m() throws IOException {
            this.up.add(new cw(r.j(cw()), cw()));
        }

        private void r() {
            int i6 = this.tl;
            int i7 = this.f26288r;
            if (i6 < i7) {
                if (i6 == 0) {
                    up();
                } else {
                    j(i7 - i6);
                }
            }
        }

        private void up() {
            Arrays.fill(this.f26286j, (Object) null);
            this.xt = this.f26286j.length - 1;
            this.cw = 0;
            this.f26288r = 0;
        }

        public List<cw> xt() {
            ArrayList arrayList = new ArrayList(this.up);
            this.up.clear();
            return arrayList;
        }

        j(int i6, int i7, mi miVar) {
            this.up = new ArrayList();
            this.f26286j = new cw[8];
            this.xt = r0.length - 1;
            this.cw = 0;
            this.f26288r = 0;
            this.ae = i6;
            this.tl = i7;
            this.f26287m = com.bytedance.sdk.component.cw.j.vl.j(miVar);
        }

        private int tl() throws IOException {
            return this.f26287m.tl() & 255;
        }

        com.bytedance.sdk.component.cw.j.m cw() throws IOException {
            int tl = tl();
            boolean z5 = (tl & 128) == 128;
            int j6 = j(tl, 127);
            return z5 ? com.bytedance.sdk.component.cw.j.m.j(qv.j().j(this.f26287m.ae(j6))) : this.f26287m.cw(j6);
        }

        private void xt(int i6) throws IOException {
            if (ae(i6)) {
                this.up.add(r.f26285j[i6]);
                return;
            }
            int cw = cw(i6 - r.f26285j.length);
            if (cw >= 0) {
                cw[] cwVarArr = this.f26286j;
                if (cw <= cwVarArr.length - 1) {
                    this.up.add(cwVarArr[cw]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i6 + 1));
        }

        private boolean ae(int i6) {
            return i6 >= 0 && i6 <= r.f26285j.length - 1;
        }

        private com.bytedance.sdk.component.cw.j.m m(int i6) {
            if (ae(i6)) {
                return r.f26285j[i6].ae;
            }
            return this.f26286j[cw(i6 - r.f26285j.length)].ae;
        }

        private void r(int i6) throws IOException {
            this.up.add(new cw(m(i6), cw()));
        }

        private void up(int i6) throws IOException {
            j(-1, new cw(m(i6), cw()));
        }

        void j() throws IOException {
            while (!this.f26287m.up()) {
                byte tl = this.f26287m.tl();
                int i6 = tl & 255;
                if (i6 == 128) {
                    throw new IOException("index == 0");
                }
                if ((tl & 128) == 128) {
                    xt(j(i6, 127) - 1);
                } else if (i6 == 64) {
                    ae();
                } else if ((tl & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                    up(j(i6, 63) - 1);
                } else if ((tl & 32) == 32) {
                    int j6 = j(i6, 31);
                    this.tl = j6;
                    if (j6 >= 0 && j6 <= this.ae) {
                        r();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.tl);
                    }
                } else if (i6 != 16 && i6 != 0) {
                    r(j(i6, 15) - 1);
                } else {
                    m();
                }
            }
        }

        private void j(int i6, cw cwVar) {
            this.up.add(cwVar);
            int i7 = cwVar.f26263g;
            if (i6 != -1) {
                i7 -= this.f26286j[cw(i6)].f26263g;
            }
            int i8 = this.tl;
            if (i7 > i8) {
                up();
                return;
            }
            int j6 = j((this.f26288r + i7) - i8);
            if (i6 == -1) {
                int i9 = this.cw + 1;
                cw[] cwVarArr = this.f26286j;
                if (i9 > cwVarArr.length) {
                    cw[] cwVarArr2 = new cw[cwVarArr.length * 2];
                    System.arraycopy(cwVarArr, 0, cwVarArr2, cwVarArr.length, cwVarArr.length);
                    this.xt = this.f26286j.length - 1;
                    this.f26286j = cwVarArr2;
                }
                int i10 = this.xt;
                this.xt = i10 - 1;
                this.f26286j[i10] = cwVar;
                this.cw++;
            } else {
                this.f26286j[i6 + cw(i6) + j6] = cwVar;
            }
            this.f26288r += i7;
        }

        int j(int i6, int i7) throws IOException {
            int i8 = i6 & i7;
            if (i8 < i7) {
                return i8;
            }
            int i9 = 0;
            while (true) {
                int tl = tl();
                if ((tl & 128) == 0) {
                    return i7 + (tl << i9);
                }
                i7 += (tl & 127) << i9;
                i9 += 7;
            }
        }
    }

    static final class xt {
        private final com.bytedance.sdk.component.cw.j.cw ae;
        cw[] cw;

        /* renamed from: g, reason: collision with root package name */
        private int f26289g;

        /* renamed from: j, reason: collision with root package name */
        int f26290j;

        /* renamed from: m, reason: collision with root package name */
        int f26291m;
        private boolean oq;

        /* renamed from: r, reason: collision with root package name */
        int f26292r;
        private final boolean tl;
        int up;
        int xt;

        xt(com.bytedance.sdk.component.cw.j.cw cwVar) {
            this(4096, true, cwVar);
        }

        private void j() {
            Arrays.fill(this.cw, (Object) null);
            this.f26292r = this.cw.length - 1;
            this.up = 0;
            this.f26291m = 0;
        }

        private int xt(int i6) {
            int i7;
            int i8 = 0;
            if (i6 > 0) {
                int length = this.cw.length;
                while (true) {
                    length--;
                    i7 = this.f26292r;
                    if (length < i7 || i6 <= 0) {
                        break;
                    }
                    int i9 = this.cw[length].f26263g;
                    i6 -= i9;
                    this.f26291m -= i9;
                    this.up--;
                    i8++;
                }
                cw[] cwVarArr = this.cw;
                System.arraycopy(cwVarArr, i7 + 1, cwVarArr, i7 + 1 + i8, this.up);
                cw[] cwVarArr2 = this.cw;
                int i10 = this.f26292r;
                Arrays.fill(cwVarArr2, i10 + 1, i10 + 1 + i8, (Object) null);
                this.f26292r += i8;
            }
            return i8;
        }

        xt(int i6, boolean z5, com.bytedance.sdk.component.cw.j.cw cwVar) {
            this.f26289g = Integer.MAX_VALUE;
            this.cw = new cw[8];
            this.f26292r = r0.length - 1;
            this.up = 0;
            this.f26291m = 0;
            this.f26290j = i6;
            this.xt = i6;
            this.tl = z5;
            this.ae = cwVar;
        }

        private void j(cw cwVar) {
            int i6 = cwVar.f26263g;
            int i7 = this.xt;
            if (i6 > i7) {
                j();
                return;
            }
            xt((this.f26291m + i6) - i7);
            int i8 = this.up + 1;
            cw[] cwVarArr = this.cw;
            if (i8 > cwVarArr.length) {
                cw[] cwVarArr2 = new cw[cwVarArr.length * 2];
                System.arraycopy(cwVarArr, 0, cwVarArr2, cwVarArr.length, cwVarArr.length);
                this.f26292r = this.cw.length - 1;
                this.cw = cwVarArr2;
            }
            int i9 = this.f26292r;
            this.f26292r = i9 - 1;
            this.cw[i9] = cwVar;
            this.up++;
            this.f26291m += i6;
        }

        private void xt() {
            int i6 = this.xt;
            int i7 = this.f26291m;
            if (i6 < i7) {
                if (i6 == 0) {
                    j();
                } else {
                    xt(i7 - i6);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void j(java.util.List<com.bytedance.sdk.component.cw.xt.j.up.cw> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.up.r.xt.j(java.util.List):void");
        }

        void j(int i6, int i7, int i8) {
            if (i6 < i7) {
                this.ae.g(i6 | i8);
                return;
            }
            this.ae.g(i8 | i7);
            int i9 = i6 - i7;
            while (i9 >= 128) {
                this.ae.g(128 | (i9 & 127));
                i9 >>>= 7;
            }
            this.ae.g(i9);
        }

        void j(com.bytedance.sdk.component.cw.j.m mVar) throws IOException {
            if (this.tl && qv.j().j(mVar) < mVar.ae()) {
                com.bytedance.sdk.component.cw.j.cw cwVar = new com.bytedance.sdk.component.cw.j.cw();
                qv.j().j(mVar, cwVar);
                com.bytedance.sdk.component.cw.j.m ws = cwVar.ws();
                j(ws.ae(), 127, 128);
                this.ae.xt(ws);
                return;
            }
            j(mVar.ae(), 127, 0);
            this.ae.xt(mVar);
        }

        void j(int i6) {
            this.f26290j = i6;
            int min = Math.min(i6, 16384);
            int i7 = this.xt;
            if (i7 == min) {
                return;
            }
            if (min < i7) {
                this.f26289g = Math.min(this.f26289g, min);
            }
            this.oq = true;
            this.xt = min;
            xt();
        }
    }

    private static Map<com.bytedance.sdk.component.cw.j.m, Integer> j() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f26285j.length);
        int i6 = 0;
        while (true) {
            cw[] cwVarArr = f26285j;
            if (i6 >= cwVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cwVarArr[i6].ae)) {
                linkedHashMap.put(cwVarArr[i6].ae, Integer.valueOf(i6));
            }
            i6++;
        }
    }

    static {
        cw cwVar = new cw(cw.f26261m, "");
        com.bytedance.sdk.component.cw.j.m mVar = cw.cw;
        cw cwVar2 = new cw(mVar, "GET");
        cw cwVar3 = new cw(mVar, "POST");
        com.bytedance.sdk.component.cw.j.m mVar2 = cw.f26262r;
        cw cwVar4 = new cw(mVar2, "/");
        cw cwVar5 = new cw(mVar2, "/index.html");
        com.bytedance.sdk.component.cw.j.m mVar3 = cw.up;
        cw cwVar6 = new cw(mVar3, b.f50154a);
        cw cwVar7 = new cw(mVar3, b.f50155b);
        com.bytedance.sdk.component.cw.j.m mVar4 = cw.xt;
        f26285j = new cw[]{cwVar, cwVar2, cwVar3, cwVar4, cwVar5, cwVar6, cwVar7, new cw(mVar4, "200"), new cw(mVar4, "204"), new cw(mVar4, "206"), new cw(mVar4, "304"), new cw(mVar4, "400"), new cw(mVar4, cl.f10887b), new cw(mVar4, "500"), new cw("accept-charset", ""), new cw("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), new cw("accept-language", ""), new cw("accept-ranges", ""), new cw("accept", ""), new cw("access-control-allow-origin", ""), new cw("age", ""), new cw("allow", ""), new cw("authorization", ""), new cw("cache-control", ""), new cw("content-disposition", ""), new cw("content-encoding", ""), new cw("content-language", ""), new cw("content-length", ""), new cw("content-location", ""), new cw("content-range", ""), new cw("content-type", ""), new cw("cookie", ""), new cw("date", ""), new cw("etag", ""), new cw("expect", ""), new cw("expires", ""), new cw(Constants.FROM, ""), new cw("host", ""), new cw("if-match", ""), new cw("if-modified-since", ""), new cw("if-none-match", ""), new cw("if-range", ""), new cw("if-unmodified-since", ""), new cw("last-modified", ""), new cw("link", ""), new cw(SocializeConstants.KEY_LOCATION, ""), new cw("max-forwards", ""), new cw("proxy-authenticate", ""), new cw("proxy-authorization", ""), new cw("range", ""), new cw("referer", ""), new cw("refresh", ""), new cw("retry-after", ""), new cw("server", ""), new cw("set-cookie", ""), new cw("strict-transport-security", ""), new cw("transfer-encoding", ""), new cw("user-agent", ""), new cw("vary", ""), new cw(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, ""), new cw("www-authenticate", "")};
        xt = j();
    }

    static com.bytedance.sdk.component.cw.j.m j(com.bytedance.sdk.component.cw.j.m mVar) throws IOException {
        int ae = mVar.ae();
        for (int i6 = 0; i6 < ae; i6++) {
            byte j6 = mVar.j(i6);
            if (j6 >= 65 && j6 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + mVar.j());
            }
        }
        return mVar;
    }
}
