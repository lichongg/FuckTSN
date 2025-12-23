package com.bytedance.sdk.component.tl.xt.xt.cw;

import android.os.Handler;
import com.bytedance.sdk.component.tl.j.oq;
import com.bytedance.sdk.component.utils.vl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private cw cw;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.sdk.component.tl.xt.xt.xt f26820m;
    private final com.bytedance.sdk.component.tl.j.up up;

    /* renamed from: r, reason: collision with root package name */
    private volatile long f26821r = 0;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicInteger f26819j = new AtomicInteger(0);
    public final AtomicInteger xt = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(List<com.bytedance.sdk.component.tl.j.xt> list, boolean z5, long j6, int i6, Object obj) {
        xt j7;
        try {
            com.bytedance.sdk.component.tl.j.xt xtVar = list.get(0);
            com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.kt(), 1, this.up);
            if (xtVar.r() == 0) {
                j7 = com.bytedance.sdk.component.tl.xt.xt.m().j(list);
                j(j7, list);
                if (j7 != null) {
                    com.bytedance.sdk.component.tl.xt.cw.j.j(list, j7.f26830r, this.up);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().ae());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e6) {
                    com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "json exception:" + e6.getMessage(), this.up);
                }
                j7 = com.bytedance.sdk.component.tl.xt.xt.m().j(jSONObject);
            }
            xt xtVar2 = j7;
            this.xt.decrementAndGet();
            j(z5, xtVar2, list, j6, obj, i6);
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "inner exception:" + th.getMessage(), this.up);
            com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.cw(), 1, this.up);
            this.xt.decrementAndGet();
        }
    }

    public m(com.bytedance.sdk.component.tl.j.up upVar, com.bytedance.sdk.component.tl.xt.xt.xt xtVar) {
        this.up = upVar;
        this.f26820m = xtVar;
    }

    public void j(List<com.bytedance.sdk.component.tl.j.xt> list, boolean z5, String str, int i6, Object obj, com.bytedance.sdk.component.tl.xt.j.xt xtVar) {
        this.cw = this.f26820m.up();
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.tl.xt.cw.j.j(list, i6, str, this.up);
        if (this.up.oq() != null) {
            j(list, z5, currentTimeMillis, obj, i6);
        } else {
            com.bytedance.sdk.component.tl.xt.cw.j.j(list, str, xtVar);
            j(list, z5, currentTimeMillis, i6, obj);
        }
    }

    private void j(final List<com.bytedance.sdk.component.tl.j.xt> list, final boolean z5, final long j6, final int i6, final Object obj) {
        com.bytedance.sdk.component.tl.j.r r5 = this.up.r();
        if (r5 != null) {
            Executor g6 = r5.g();
            if (list.get(0).up() == 1) {
                g6 = r5.tl();
            }
            Executor executor = g6;
            if (executor == null) {
                return;
            }
            this.xt.incrementAndGet();
            executor.execute(new com.bytedance.sdk.component.tl.xt.up.xt("csj_log_upload") { // from class: com.bytedance.sdk.component.tl.xt.xt.cw.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.xt(list, z5, j6, i6, obj);
                }
            });
        }
    }

    private void j(xt xtVar, List<com.bytedance.sdk.component.tl.j.xt> list) {
        if (xtVar == null || !xtVar.f26829j) {
            return;
        }
        List<com.bytedance.sdk.component.tl.j.cw> j6 = com.bytedance.sdk.component.tl.xt.j.j();
        if (list == null || j6 == null || j6.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.tl.j.xt xtVar2 : list) {
            if (xtVar2.up() == 1) {
                String j7 = com.bytedance.sdk.component.tl.xt.cw.j.j(xtVar2, this.up);
                String m6 = com.bytedance.sdk.component.tl.xt.cw.j.m(xtVar2, this.up);
                for (com.bytedance.sdk.component.tl.j.cw cwVar : j6) {
                    if (cwVar != null) {
                        cwVar.j(j7, m6);
                    }
                }
            }
        }
    }

    private void j(List<com.bytedance.sdk.component.tl.j.xt> list, final boolean z5, final long j6, final Object obj, final int i6) {
        this.xt.incrementAndGet();
        com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.kt(), 1, this.up);
        try {
            this.up.oq().j(list, new oq() { // from class: com.bytedance.sdk.component.tl.xt.xt.cw.m.2
                @Override // com.bytedance.sdk.component.tl.j.oq
                public void j(List<j> list2) {
                    try {
                        m.this.xt.decrementAndGet();
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        int size = list2.size();
                        for (int i7 = 0; i7 < size; i7++) {
                            j jVar = list2.get(i7);
                            if (jVar != null) {
                                m.this.j(z5, jVar.j(), jVar.xt(), j6, obj, i6);
                            }
                        }
                    } catch (Exception e6) {
                        vl.j(e6);
                    }
                }
            });
        } catch (Exception e6) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "outer exception：" + e6.getMessage(), this.up);
            com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.cw(), 1, this.up);
            this.xt.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z5, xt xtVar, List<com.bytedance.sdk.component.tl.j.xt> list, long j6, Object obj, int i6) {
        if (z5) {
            return;
        }
        if (xtVar != null) {
            int i7 = xtVar.xt;
            if (xtVar.up) {
                i7 = -1;
            } else if (i7 < 0) {
                i7 = -2;
            }
            if (i7 == 510 || i7 == 511) {
                i7 = -2;
            }
            int i8 = (xtVar.f26829j || ((i7 < 500 || i7 >= 509) && i7 <= 513)) ? i7 : -2;
            if (list != null) {
                list.size();
                this.xt.get();
            }
            j(i8, list, j6, obj, i6, xtVar);
            return;
        }
        j(-1, list, j6, obj, i6, (xt) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c2, code lost:
    
        r13.notify();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(int r9, java.util.List<com.bytedance.sdk.component.tl.j.xt> r10, long r11, java.lang.Object r13, int r14, com.bytedance.sdk.component.tl.xt.xt.cw.xt r15) {
        /*
            r8 = this;
            com.bytedance.sdk.component.tl.xt.xt.cw.cw r0 = r8.cw
            monitor-enter(r13)
            if (r10 == 0) goto Lc7
            if (r0 != 0) goto L9
            goto Lc7
        L9:
            android.os.Handler r1 = r0.xt()     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.j.up r6 = r8.up     // Catch: java.lang.Throwable -> L29
            r2 = r9
            r3 = r10
            r4 = r11
            r7 = r15
            com.bytedance.sdk.component.tl.xt.cw.j.j(r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.xt.j.up r9 = r0.j()     // Catch: java.lang.Throwable -> L29
            r9.j(r2, r3, r14)     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.j.up r9 = r8.up     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.j.r r9 = r9.r()     // Catch: java.lang.Throwable -> L29
            if (r9 == 0) goto L2d
            r9.vl()     // Catch: java.lang.Throwable -> L29
            goto L2d
        L29:
            r0 = move-exception
            r9 = r0
            goto Lc9
        L2d:
            r10 = -2
            r11 = 72
            if (r2 == r10) goto L8e
            r10 = -1
            if (r2 == r10) goto L6d
            if (r2 == 0) goto L8e
            r9 = 200(0xc8, float:2.8E-43)
            if (r2 == r9) goto L6d
            r9 = 509(0x1fd, float:7.13E-43)
            if (r2 == r9) goto L41
            goto Lc0
        L41:
            com.bytedance.sdk.component.tl.j.up r9 = r8.up     // Catch: java.lang.Throwable -> L29
            boolean r9 = com.bytedance.sdk.component.tl.xt.cw.j.xt(r3, r9)     // Catch: java.lang.Throwable -> L29
            if (r9 == 0) goto Lc0
            com.bytedance.sdk.component.tl.xt.xt.xt r9 = r8.f26820m     // Catch: java.lang.Throwable -> L29
            r10 = 1
            r9.j(r10)     // Catch: java.lang.Throwable -> L29
            r9 = 3
            boolean r10 = r1.hasMessages(r9)     // Catch: java.lang.Throwable -> L29
            if (r10 != 0) goto Lc0
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L29
            long r4 = r8.f26821r     // Catch: java.lang.Throwable -> L29
            long r2 = r2 - r4
            r4 = 15000(0x3a98, double:7.411E-320)
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 < 0) goto Lc0
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L29
            r8.f26821r = r2     // Catch: java.lang.Throwable -> L29
            r8.j(r9, r4, r1)     // Catch: java.lang.Throwable -> L29
            goto Lc0
        L6d:
            com.bytedance.sdk.component.tl.xt.xt.xt r9 = r8.f26820m     // Catch: java.lang.Throwable -> L29
            boolean r9 = r9.r()     // Catch: java.lang.Throwable -> L29
            if (r9 == 0) goto L84
            java.lang.String r9 = "_flush"
            java.lang.String r10 = "send reset error"
            com.bytedance.sdk.component.tl.j.up r12 = r8.up     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.xt.cw.cw.cw(r9, r10, r12)     // Catch: java.lang.Throwable -> L29
            java.lang.String r9 = "handle_result"
            r0.j(r11, r9)     // Catch: java.lang.Throwable -> L29
            goto Lc0
        L84:
            com.bytedance.sdk.component.tl.xt.xt.xt r9 = r8.f26820m     // Catch: java.lang.Throwable -> L29
            r10 = 0
            r9.j(r10)     // Catch: java.lang.Throwable -> L29
            r8.j(r1, r3, r0)     // Catch: java.lang.Throwable -> L29
            goto Lc0
        L8e:
            if (r9 == 0) goto Lb7
            java.lang.String r10 = "_error"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29
            java.lang.String r15 = "net is available:"
            r12.<init>(r15)     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.j.up r15 = r8.up     // Catch: java.lang.Throwable -> L29
            android.content.Context r15 = r15.getContext()     // Catch: java.lang.Throwable -> L29
            boolean r9 = r9.j(r15)     // Catch: java.lang.Throwable -> L29
            r12.append(r9)     // Catch: java.lang.Throwable -> L29
            java.lang.String r9 = " code:"
            r12.append(r9)     // Catch: java.lang.Throwable -> L29
            r12.append(r2)     // Catch: java.lang.Throwable -> L29
            java.lang.String r9 = r12.toString()     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.j.up r12 = r8.up     // Catch: java.lang.Throwable -> L29
            com.bytedance.sdk.component.tl.xt.cw.cw.cw(r10, r9, r12)     // Catch: java.lang.Throwable -> L29
        Lb7:
            com.bytedance.sdk.component.tl.xt.xt.xt r9 = r8.f26820m     // Catch: java.lang.Throwable -> L29
            r10 = 2
            r9.j(r10)     // Catch: java.lang.Throwable -> L29
            r8.j(r1, r3, r0)     // Catch: java.lang.Throwable -> L29
        Lc0:
            if (r14 != r11) goto Lc5
            r13.notify()     // Catch: java.lang.Throwable -> L29
        Lc5:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L29
            return
        Lc7:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L29
            return
        Lc9:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L29
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.xt.cw.m.j(int, java.util.List, long, java.lang.Object, int, com.bytedance.sdk.component.tl.xt.xt.cw.xt):void");
    }

    private void j(Handler handler, List<com.bytedance.sdk.component.tl.j.xt> list, cw cwVar) {
        boolean r5 = cwVar.r();
        boolean xt = com.bytedance.sdk.component.tl.xt.cw.j.xt(list, this.up);
        if (r5 && xt) {
            if (handler.hasMessages(3)) {
                handler.removeMessages(3);
            }
            this.f26819j.set(0);
            this.f26821r = 0L;
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_flush", "send reset busy", this.up);
            com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.r(), 1, this.up);
            cwVar.j(72, "handle_result");
        }
    }

    public void j(int i6, long j6, Handler handler) {
        if (handler == null) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "mHandler == null", this.up);
            return;
        }
        if (i6 != 3) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "sendBusyMsg error state", this.up);
            return;
        }
        if (handler.hasMessages(i6)) {
            handler.removeMessages(i6);
        }
        long j7 = (((r1 - 1) % 4) + 1) * j6;
        com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "sendBusyMsg:" + i6 + "  retryCount:" + this.f26819j.incrementAndGet() + " delayTime:" + (j7 / 1000), this.up);
        handler.sendEmptyMessageDelayed(i6, j7);
    }
}
