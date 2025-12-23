package com.bytedance.sdk.component.g.cw;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.ws;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private Context ae;
    private j cw;
    private int mi;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26437r;
    private r tl;
    private xt up;
    private long xt = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f26436m = false;

    /* renamed from: g, reason: collision with root package name */
    private int f26433g = 0;
    private long oq = 19700101000L;
    private int qv = 0;
    private HashMap<String, Integer> vl = new HashMap<>();
    private HashMap<String, Integer> jy = new HashMap<>();
    private int ws = 0;
    private HashMap<String, Integer> az = new HashMap<>();
    private HashMap<String, Integer> av = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private boolean f26434i = true;

    /* renamed from: w, reason: collision with root package name */
    private Map<String, Integer> f26438w = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    Handler f26435j = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.g.cw.up.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            up.this.xt(message.arg1 != 0);
        }
    };

    private up() {
    }

    private boolean j(int i6) {
        return i6 >= 200 && i6 < 400;
    }

    public boolean cw() {
        return this.f26437r;
    }

    public xt r() {
        return this.up;
    }

    public j xt() {
        return this.cw;
    }

    private void cw(String str) {
        if (!TextUtils.isEmpty(str) && this.f26438w.containsKey(str)) {
            this.f26438w.put(str, 0);
        }
    }

    private void g() {
        SharedPreferences xt = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(this.ae, j(), 0);
        this.f26433g = xt.getInt("tnc_probe_cmd", 0);
        this.oq = xt.getLong("tnc_probe_version", 19700101000L);
    }

    private void oq() {
        com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "resetTNCControlState");
        this.qv = 0;
        this.vl.clear();
        this.jy.clear();
        this.ws = 0;
        this.az.clear();
        this.av.clear();
    }

    private boolean r(String str) {
        Map<String, String> ae = ae();
        if (ae == null) {
            return false;
        }
        String str2 = ae.get(str);
        if (TextUtils.isEmpty(str2) || this.f26438w.get(str2) == null || this.f26438w.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(str)));
        return true;
    }

    private void xt(String str) {
        Map<String, String> ae;
        if (TextUtils.isEmpty(str) || (ae = ae()) == null || !ae.containsValue(str)) {
            return;
        }
        if (this.f26438w.get(str) == null) {
            this.f26438w.put(str, 1);
        } else {
            this.f26438w.put(str, Integer.valueOf(this.f26438w.get(str).intValue() + 1));
        }
    }

    public cw m() {
        r rVar = this.tl;
        if (rVar != null) {
            return rVar.cw();
        }
        return null;
    }

    public r tl() {
        return this.tl;
    }

    public void up() {
        this.f26438w.clear();
    }

    public Map<String, String> ae() {
        cw m6 = m();
        if (m6 != null) {
            return m6.f26422r;
        }
        return null;
    }

    public String j() {
        return "ttnet_tnc_config" + this.mi;
    }

    public void j(boolean z5) {
        this.f26437r = z5;
    }

    public void j(xt xtVar) {
        this.up = xtVar;
    }

    public synchronized void j(Context context, boolean z5) {
        try {
            if (!this.f26436m) {
                this.ae = context;
                this.f26434i = z5;
                this.tl = new r(context, z5, this.mi);
                if (z5) {
                    g();
                }
                com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "initTnc, isMainProc: " + z5 + " probeCmd: " + this.f26433g + " probeVersion: " + this.oq);
                this.cw = ae.j().j(this.mi, this.ae);
                this.f26436m = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(boolean z5) {
        if (m() == null) {
            return;
        }
        com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "doUpdateRemote, ".concat(String.valueOf(z5)));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z5 && this.xt + (r0.qv * 1000) > elapsedRealtime) {
            com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.xt = elapsedRealtime;
            ae.j().j(this.mi, this.ae).cw();
        }
    }

    public up(int i6) {
        this.mi = i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String j(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto Ld8
            java.lang.String r0 = "/network/get_network"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Ld8
            java.lang.String r0 = "/get_domains/v4"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Ld8
            java.lang.String r0 = "/ies/speed"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L20
            goto Ld8
        L20:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L31
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r1.getProtocol()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r1.getHost()     // Catch: java.lang.Throwable -> L2f
            goto L36
        L2f:
            r1 = move-exception
            goto L33
        L31:
            r1 = move-exception
            r2 = r0
        L33:
            com.bytedance.sdk.component.utils.vl.j(r1)
        L36:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto Ld8
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4c
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Ld8
        L4c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L54
            goto Ld8
        L54:
            boolean r1 = r6.r(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L6a
            java.lang.String r1 = "handleHostMapping, TNC host faild num over limit: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.g.r.cw.xt(r3, r0)
            return r7
        L6a:
            java.util.Map r1 = r6.ae()
            if (r1 == 0) goto Lcb
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L77
            goto Lcb
        L77:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L84
            goto Ld8
        L84:
            java.lang.String r4 = "handleHostMapping, match, origin: "
            java.lang.String r4 = r4.concat(r7)
            com.bytedance.sdk.component.g.r.cw.xt(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "://"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto Lbd
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        Lbd:
            java.lang.String r0 = "handleHostMapping, target: "
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r0 = r0.concat(r1)
            com.bytedance.sdk.component.g.r.cw.xt(r3, r0)
            return r7
        Lcb:
            java.lang.String r1 = "handleHostMapping, nomatch: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.g.r.cw.xt(r3, r0)
        Ld8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.cw.up.j(java.lang.String):java.lang.String");
    }

    private boolean xt(int i6) {
        if (i6 < 100 || i6 >= 1000) {
            return true;
        }
        cw m6 = m();
        return (m6 == null || TextUtils.isEmpty(m6.jy) || !m6.jy.contains(String.valueOf(i6))) ? false : true;
    }

    public synchronized void j(ws wsVar, av avVar) {
        URL url;
        if (wsVar == null || avVar == null) {
            return;
        }
        if (this.f26434i) {
            if (com.bytedance.sdk.component.g.r.m.j(this.ae)) {
                try {
                    url = wsVar.xt().j();
                } catch (Exception unused) {
                    url = null;
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String j6 = j(wsVar);
                int cw = avVar.cw();
                if (b.f50154a.equals(protocol) || b.f50155b.equals(protocol)) {
                    if (TextUtils.isEmpty(j6)) {
                        return;
                    }
                    com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + j6 + "#" + cw);
                    cw m6 = m();
                    if (m6 != null && m6.xt) {
                        j(avVar, host);
                    }
                    if (m6 == null) {
                        return;
                    }
                    com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + j6 + "#" + cw + " " + this.qv + "#" + this.vl.size() + "#" + this.jy.size() + " " + this.ws + "#" + this.az.size() + "#" + this.av.size());
                    if (cw > 0) {
                        if (j(cw)) {
                            if (this.qv > 0 || this.ws > 0) {
                                oq();
                            }
                            cw(host);
                            return;
                        }
                        if (!xt(cw)) {
                            this.ws++;
                            this.az.put(path, 0);
                            this.av.put(j6, 0);
                            if (this.ws >= m6.tl && this.az.size() >= m6.f26419g && this.av.size() >= m6.oq) {
                                com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + j6 + "#" + cw);
                                j(false, 0L);
                                oq();
                            }
                            xt(host);
                        }
                    }
                }
            }
        }
    }

    private String j(ws wsVar) {
        if (wsVar != null && wsVar.xt() != null && wsVar.xt().j() != null) {
            try {
                return InetAddress.getByName(wsVar.xt().j().getHost()).getHostAddress();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public synchronized void j(ws wsVar, Exception exc) {
        URL url;
        if (wsVar != null) {
            if (wsVar.xt() != null && exc != null) {
                if (this.f26434i) {
                    if (com.bytedance.sdk.component.g.r.m.j(this.ae)) {
                        try {
                            url = wsVar.xt().j();
                        } catch (Exception unused) {
                            url = null;
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String j6 = j(wsVar);
                        if (b.f50154a.equals(protocol) || b.f50155b.equals(protocol)) {
                            cw m6 = m();
                            if (m6 == null) {
                                return;
                            }
                            com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + j6 + "# " + this.qv + "#" + this.vl.size() + "#" + this.jy.size() + " " + this.ws + "#" + this.az.size() + "#" + this.av.size());
                            this.qv = this.qv + 1;
                            this.vl.put(path, 0);
                            this.jy.put(j6, 0);
                            if (this.qv >= m6.up && this.vl.size() >= m6.f26421m && this.jy.size() >= m6.ae) {
                                com.bytedance.sdk.component.g.r.cw.xt("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + j6);
                                j(false, 0L);
                                oq();
                            }
                            xt(host);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(com.bytedance.sdk.component.xt.j.av r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.cw.up.j(com.bytedance.sdk.component.xt.j.av, java.lang.String):void");
    }

    private void j(boolean z5, long j6) {
        if (this.f26435j.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.f26435j.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z5 ? 1 : 0;
        if (j6 > 0) {
            this.f26435j.sendMessageDelayed(obtainMessage, j6);
        } else {
            this.f26435j.sendMessage(obtainMessage);
        }
    }
}
