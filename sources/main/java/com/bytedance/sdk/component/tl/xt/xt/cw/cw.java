package com.bytedance.sdk.component.tl.xt.xt.cw;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends up implements Handler.Callback {
    private static int av = 200;
    private static int az = 10;
    private int ae;

    /* renamed from: f, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.j.xt f26811f;

    /* renamed from: g, reason: collision with root package name */
    private final long f26812g;

    /* renamed from: i, reason: collision with root package name */
    private final String f26813i;

    /* renamed from: j, reason: collision with root package name */
    protected com.bytedance.sdk.component.tl.xt.j.up f26814j;
    private final List<com.bytedance.sdk.component.tl.j.xt> jy;
    private volatile String kt;

    /* renamed from: m, reason: collision with root package name */
    private final int f26815m;
    private volatile int mi;
    private final long oq;
    private volatile Handler qv;

    /* renamed from: r, reason: collision with root package name */
    private final Object f26816r;
    private final HashMap<String, List<com.bytedance.sdk.component.tl.j.xt>> tj;
    private final AtomicInteger tl;
    private m up;
    private final List<com.bytedance.sdk.component.tl.j.xt> vl;

    /* renamed from: w, reason: collision with root package name */
    private final String f26817w;
    private volatile boolean ws;

    public com.bytedance.sdk.component.tl.xt.j.up j() {
        return this.f26814j;
    }

    public Handler xt() {
        return this.qv;
    }

    private void j(int i6, boolean z5) {
        xt((com.bytedance.sdk.component.tl.j.xt) null, i6, z5);
    }

    private void xt(int i6, boolean z5) {
        xt((com.bytedance.sdk.component.tl.j.xt) null, i6, z5);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i6 = message.what;
        try {
            boolean j6 = this.xt.r().j(this.xt.getContext());
            if (i6 == 1) {
                synchronized (cw.class) {
                    try {
                        if (!this.jy.isEmpty()) {
                            int size = this.jy.size();
                            for (int i7 = 0; i7 < size; i7++) {
                                j(this.jy.get(i7), 1, j6);
                            }
                        }
                        this.ws = true;
                        this.jy.clear();
                    } finally {
                    }
                }
            } else if (i6 == 3) {
                xt(3, j6);
            } else if (i6 == 5) {
                ArrayList arrayList = new ArrayList(this.vl);
                this.vl.clear();
                j(arrayList, false, "timeout_dispatch", 5);
            } else if (i6 == 74) {
                j((com.bytedance.sdk.component.tl.j.xt) message.obj, 74, j6);
            } else if (i6 == 71) {
                j(71, j6);
            } else if (i6 == 72) {
                j(72, j6);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_ms", "error:" + th.getMessage(), this.xt);
        }
        return true;
    }

    public boolean r() {
        return com.bytedance.sdk.component.tl.xt.cw.j.j(this.xt) && this.cw.cw();
    }

    public cw(com.bytedance.sdk.component.tl.j.up upVar, com.bytedance.sdk.component.tl.xt.xt.xt xtVar) {
        super(upVar, xtVar);
        this.f26816r = new Object();
        this.f26815m = 50;
        this.ae = 30;
        this.tl = new AtomicInteger(0);
        this.f26812g = 5000L;
        this.oq = 5000000000L;
        this.vl = new ArrayList();
        this.jy = new CopyOnWriteArrayList();
        this.ws = false;
        this.f26813i = "after_upload";
        this.f26817w = "prepare_upload";
        this.mi = 0;
        this.kt = "DEFAULT";
        this.tj = new HashMap<>();
        this.f26814j = new com.bytedance.sdk.component.tl.xt.j.cw(upVar, this);
        this.up = new m(this.xt, this.cw);
    }

    private boolean xt(com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5) {
        return com.bytedance.sdk.component.tl.xt.cw.j.j(this.xt) && this.xt.cw();
    }

    @Override // com.bytedance.sdk.component.tl.xt.xt.cw.up
    public void cw() {
        super.cw();
        this.qv = new Handler(ae(), this);
        this.cw.j(this.qv);
        this.qv.sendEmptyMessage(1);
    }

    public boolean j(int i6, String str, com.bytedance.sdk.component.tl.j.xt xtVar) {
        if (this.xt == null) {
            return false;
        }
        return this.f26814j.j(i6, str, xtVar);
    }

    private void xt(com.bytedance.sdk.component.tl.j.xt xtVar, int i6, boolean z5) {
        if (xt(xtVar, z5)) {
            com.bytedance.sdk.component.tl.xt.cw.cw.j("_error", " upload cancel cause config " + com.bytedance.sdk.component.tl.xt.cw.j.cw(xtVar, this.xt), this.xt);
            return;
        }
        boolean r5 = r();
        boolean z6 = false;
        boolean z7 = com.bytedance.sdk.component.tl.xt.cw.j.g(xtVar, this.xt) || i6 == 3;
        boolean j6 = com.bytedance.sdk.component.tl.xt.cw.j.j(i6);
        com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "serbusy:" + r5 + " isCsjBusy:" + z7 + " flush:" + j6, this.xt);
        if (r5 && !j6 && z7) {
            if (i6 == 3) {
                com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "start do flush", this.xt);
                j(72, z5);
                return;
            } else {
                if (i6 != 74 && i6 != 1) {
                    com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "server busy", this.xt);
                    return;
                }
                boolean hasMessages = this.qv.hasMessages(3);
                com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(hasMessages)), this.xt);
                if (hasMessages) {
                    return;
                }
                this.up.j(3, 15000L, this.qv);
                return;
            }
        }
        if (!z5) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "AdThread NET IS NOT AVAILABLE!!!", this.xt);
            return;
        }
        boolean j7 = j(i6, "needUpload check", xtVar);
        if (j7) {
            List<com.bytedance.sdk.component.tl.j.xt> j8 = this.f26814j.j(i6, xtVar, r5, this.mi + "_" + this.kt);
            if (j8 != null && j8.size() != 0) {
                com.bytedance.sdk.component.tl.xt.cw.cw.xt("_ms", "prepare get size =" + j8.size(), this.xt);
                j(j8, i6);
            } else {
                com.bytedance.sdk.component.tl.xt.cw.cw.xt("_ms", "prepare get no event need upload", this.xt);
                j("prepare_upload");
                com.bytedance.sdk.component.tl.xt.cw.cw.j("_ms", "prepare upload end needUpload:".concat(String.valueOf(z6)), this.xt);
            }
        } else {
            com.bytedance.sdk.component.tl.xt.cw.cw.xt("_ms", "prepare upload no need", this.xt);
            this.tj.clear();
            j("prepare_upload");
        }
        z6 = j7;
        com.bytedance.sdk.component.tl.xt.cw.cw.j("_ms", "prepare upload end needUpload:".concat(String.valueOf(z6)), this.xt);
    }

    public void j(com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5) {
        if (xtVar == null) {
            return;
        }
        if (z5) {
            if (this.qv != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(xtVar);
                j(arrayList, true, "ignore_result_dispatch", -1);
                return;
            }
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "other thread handler is null，ignore is true", this.xt);
            return;
        }
        if (this.ws) {
            Message obtain = Message.obtain();
            obtain.obj = xtVar;
            obtain.what = 74;
            this.qv.sendMessage(obtain);
            return;
        }
        this.jy.add(xtVar);
    }

    public void j(int i6, String str) {
        try {
            if (!this.xt.r().j(this.xt.getContext())) {
                com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "AdThread NET IS NOT AVAILABLE", this.xt);
                return;
            }
            boolean j6 = j(i6, str + " check", (com.bytedance.sdk.component.tl.j.xt) null);
            com.bytedance.sdk.component.tl.xt.cw.cw.xt("_flush", "notify runOnce check: ".concat(String.valueOf(j6)), this.xt);
            if (j6) {
                Message obtain = Message.obtain();
                obtain.what = i6;
                this.qv.sendMessage(obtain);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw(th.getMessage(), this.xt);
        }
    }

    private void j(com.bytedance.sdk.component.tl.j.xt xtVar, int i6, boolean z5) {
        try {
            j(xtVar);
            xt(xtVar, i6, z5);
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "run exception:" + th.getMessage(), this.xt);
            com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.cw(), 1, this.xt);
        }
    }

    private void j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        this.tl.set(0);
        com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.qv(), 1, this.xt);
        this.f26814j.j(xtVar);
        com.bytedance.sdk.component.tl.xt.cw.j.j(xtVar, this.xt, "_ad");
        com.bytedance.sdk.component.tl.xt.cw.j.tl(xtVar, this.xt);
    }

    private void xt(List<com.bytedance.sdk.component.tl.j.xt> list, String str, int i6) {
        this.vl.addAll(list);
        com.bytedance.sdk.component.tl.j.r r5 = this.xt.r();
        if (r5 != null && r5.vl() != null) {
            az = r5.vl().r();
        }
        if (this.vl.size() >= az) {
            if (this.qv.hasMessages(5)) {
                this.qv.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.vl);
            this.vl.clear();
            j(arrayList, false, "max_size_dispatch", i6);
            return;
        }
        j(str);
    }

    private void j(String str) {
        if (this.vl.size() != 0) {
            com.bytedance.sdk.component.tl.j.r r5 = this.xt.r();
            if (this.qv.hasMessages(5)) {
                this.qv.removeMessages(5);
            }
            long j6 = av;
            if (r5 != null && r5.vl() != null) {
                j6 = r5.vl().cw();
            }
            this.qv.sendEmptyMessageDelayed(5, j6);
            this.vl.size();
            return;
        }
        com.bytedance.sdk.component.tl.xt.cw.cw.j("_ms", "do nothing", this.xt);
    }

    private void j(List<com.bytedance.sdk.component.tl.j.xt> list, String str, int i6) {
        j(list, false, str, i6);
    }

    private void j(List<com.bytedance.sdk.component.tl.j.xt> list, int i6) {
        com.bytedance.sdk.component.tl.xt.cw.j.j(list, this.xt);
        com.bytedance.sdk.component.tl.j.xt xtVar = list.get(0);
        if (xtVar == null) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "adLogEvent is null", this.xt);
            return;
        }
        if (list.size() <= 1 && !com.bytedance.sdk.component.tl.xt.cw.j.xt(this.xt) && !com.bytedance.sdk.component.tl.xt.cw.j.r(this.xt)) {
            if (xtVar.up() == 1) {
                j(list, "highPriority", i6);
                return;
            }
            if (xtVar.r() == 0 && xtVar.up() == 2) {
                if (xtVar.xt() == 3) {
                    j(list, "version_v3_single_directly", i6);
                    return;
                } else {
                    xt(list, "singleOptimize", i6);
                    return;
                }
            }
            if (xtVar.r() == 1) {
                j(list, "stats_directly", i6);
                return;
            }
            if (xtVar.r() == 3) {
                j(list, "adType_v3_directly", i6);
                return;
            } else if (xtVar.r() != 2) {
                com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "adLogEvent adType error", this.xt);
                return;
            } else {
                j(list, "other_directly", i6);
                return;
            }
        }
        if (xtVar.r() == 0 && xtVar.up() == 2 && i6 == 74) {
            if (xtVar.xt() == 3) {
                j(list, "version_v3_batch", i6);
                return;
            } else {
                xt(list, "batchOptimize", i6);
                return;
            }
        }
        j(list, "batchRead", i6);
    }

    private void j(List<com.bytedance.sdk.component.tl.j.xt> list, boolean z5, String str, int i6) {
        this.up.j(list, z5, str, i6, this.f26816r, this.f26811f);
        if (z5) {
            return;
        }
        j(i6);
    }

    private void j(int i6) {
        long nanoTime;
        j("after_upload");
        com.bytedance.sdk.component.tl.xt.cw.j.xt(i6);
        if (i6 == 72) {
            synchronized (this.f26816r) {
                try {
                    long nanoTime2 = System.nanoTime();
                    this.f26816r.wait(5000L);
                    nanoTime = System.nanoTime() - nanoTime2;
                } catch (InterruptedException e6) {
                    com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "wait exception:" + e6.getMessage(), this.xt);
                }
                if (nanoTime < 5000000000L && 5000000000L - nanoTime >= 50000000) {
                    if (r()) {
                        com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "return wait serverBusy", this.xt);
                        return;
                    }
                    if (this.cw.r()) {
                        com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "return wait otherError", this.xt);
                        return;
                    }
                    com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.xt(), 1, this.xt);
                    int i7 = this.ae + 1;
                    this.ae = i7;
                    if (i7 < 50) {
                        com.bytedance.sdk.component.tl.xt.cw.cw.xt("_flush", "afterUpload send flush again:" + this.ae, this.xt);
                        j(72, "continue");
                    } else {
                        this.ae = 0;
                        if (this.qv.hasMessages(72)) {
                            this.qv.removeMessages(72);
                        }
                        com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "afterUpload send flush end:" + this.ae, this.xt);
                    }
                    return;
                }
                com.bytedance.sdk.component.tl.xt.cw.cw.cw("_error", "return wait timeout", this.xt);
                return;
            }
        }
        this.ae = 0;
        if (this.qv.hasMessages(72)) {
            this.qv.removeMessages(72);
        }
    }
}
