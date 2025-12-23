package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f implements Handler.Callback, Comparator<ya> {
    private static long jy;
    private static f xt;
    private wq ae;
    private mi cw;

    /* renamed from: g, reason: collision with root package name */
    private ch f23987g;

    /* renamed from: j, reason: collision with root package name */
    public Application f23988j;

    /* renamed from: m, reason: collision with root package name */
    private sm f23989m;
    private com.bytedance.embedapplog.util.j oq;
    private Handler qv;

    /* renamed from: r, reason: collision with root package name */
    private rn f23990r;
    private Handler tl;
    private final ArrayList<ya> up = new ArrayList<>(32);
    private x vl;

    public static void j() {
        if (xt != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - jy) > 10000) {
                jy = currentTimeMillis;
                xt.j((String[]) null, true);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i6 = message.what;
            if (i6 == 1) {
                uc.f24071j = this.f23990r.f();
                if (!this.ae.m()) {
                    this.qv.removeMessages(1);
                    this.qv.sendEmptyMessageDelayed(1, 1000L);
                } else if (this.f23990r.i()) {
                    Looper xt2 = ri.xt(this.f23990r);
                    if (xt2 == null) {
                        HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                        handlerThread.start();
                        xt2 = handlerThread.getLooper();
                    }
                    Handler handler = new Handler(xt2, this);
                    this.tl = handler;
                    handler.sendEmptyMessage(2);
                    if (this.up.size() > 0) {
                        this.qv.removeMessages(4);
                        this.qv.sendEmptyMessageDelayed(4, 1000L);
                    }
                    uc.r("net|worker start", null);
                }
                a.j();
            } else if (i6 == 2) {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(new v(this));
                arrayList.add(new tj(this));
                x xVar = new x(this);
                this.vl = xVar;
                arrayList.add(xVar);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    kt ktVar = (kt) it.next();
                    if (ktVar instanceof x) {
                        this.vl.j(ri.j());
                    }
                    long ae = ktVar.ae();
                    if (ae < 864000000) {
                        this.tl.sendMessageDelayed(this.qv.obtainMessage(6, ktVar), ae);
                    }
                }
                this.vl.j(true);
                oq();
            } else if (i6 == 4) {
                j((String[]) null, false);
            } else if (i6 == 5) {
                j((String[]) message.obj, false);
            } else if (i6 == 6) {
                kt ktVar2 = (kt) message.obj;
                if (!ktVar2.m()) {
                    long ae2 = ktVar2.ae();
                    if (ae2 < 864000000) {
                        this.tl.sendMessageDelayed(this.qv.obtainMessage(6, ktVar2), ae2);
                    }
                    oq();
                }
                this.vl.j(true);
            } else if (i6 == 7) {
                synchronized (this.up) {
                    this.up.add(ch.up());
                }
                j((String[]) null, false);
            } else if (i6 != 89) {
                uc.xt((Throwable) null);
            } else {
                wq wqVar = this.ae;
                if (wqVar != null) {
                    wqVar.up();
                }
            }
        } catch (Throwable th) {
            uc.j("engine:" + th.getMessage());
        }
        return true;
    }

    public static f m() {
        if (xt == null) {
            synchronized (f.class) {
                try {
                    if (xt == null) {
                        xt = new f();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    private void oq() {
        if (this.f23990r.tj()) {
            if (this.cw == null) {
                mi miVar = new mi(this);
                this.cw = miVar;
                this.tl.obtainMessage(6, miVar).sendToTarget();
                return;
            }
            return;
        }
        mi miVar2 = this.cw;
        if (miVar2 != null) {
            miVar2.up();
            this.cw = null;
        }
    }

    private void qv() {
        if (uc.xt) {
            uc.j("packAndSend once, " + this.f23987g.j() + ", hadUI:" + this.f23987g.xt(), null);
        }
        x xVar = this.vl;
        if (xVar != null) {
            xVar.tl();
        }
        if (this.tl != null) {
            this.vl.j(ri.j());
            this.tl.sendMessage(this.qv.obtainMessage(6, this.vl));
        }
    }

    public ch ae() {
        return this.f23987g;
    }

    public sm cw() {
        return this.f23989m;
    }

    public void g() {
        Handler handler = this.qv;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.qv.sendEmptyMessage(89);
    }

    public rn r() {
        return this.f23990r;
    }

    public com.bytedance.embedapplog.util.j tl() {
        if (this.oq == null) {
            com.bytedance.embedapplog.util.j qv = this.f23990r.hh().qv();
            this.oq = qv;
            if (qv == null) {
                this.oq = com.bytedance.embedapplog.util.xt.j(0);
            }
        }
        return this.oq;
    }

    public wq up() {
        return this.ae;
    }

    public Context xt() {
        return this.f23988j;
    }

    private f() {
    }

    public void j(Application application, rn rnVar, wq wqVar, w wVar) {
        this.f23988j = application;
        this.f23989m = new sm(this);
        this.f23990r = rnVar;
        this.ae = wqVar;
        this.f23987g = new ch(this.ae, this.f23990r);
        this.f23988j.registerActivityLifecycleCallbacks(wVar);
        Looper j6 = ri.j(rnVar);
        if (j6 == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            j6 = handlerThread.getLooper();
        }
        Handler handler = new Handler(j6, this);
        this.qv = handler;
        handler.sendEmptyMessage(1);
        im.j(rnVar.tl() != 0);
    }

    private void j(String[] strArr, boolean z5) {
        ArrayList<ya> arrayList;
        synchronized (this.up) {
            arrayList = (ArrayList) this.up.clone();
            this.up.clear();
        }
        int i6 = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(ya.j(str));
            }
        }
        boolean j6 = this.f23990r.j(arrayList);
        if (arrayList.size() > 0) {
            if (this.f23990r.i()) {
                if (!j6 && arrayList.size() <= 100) {
                    synchronized (this.up) {
                        this.up.addAll(arrayList);
                    }
                    return;
                }
                Collections.sort(arrayList, this);
                ArrayList<ya> arrayList2 = new ArrayList<>(arrayList.size());
                Iterator<ya> it = arrayList.iterator();
                boolean z6 = false;
                boolean z7 = false;
                while (it.hasNext()) {
                    ya next = it.next();
                    z6 |= this.f23987g.j(next, arrayList2);
                    if (next instanceof kc) {
                        z7 = ch.j(next);
                        i6 = 1;
                    }
                }
                this.f23989m.j(arrayList2);
                if (i6 != 0) {
                    if (z7) {
                        this.qv.removeMessages(7);
                    } else if (!ri.xt() && ri.j()) {
                        this.qv.sendEmptyMessageDelayed(7, this.f23990r.v());
                    }
                }
                if (z6 || z5) {
                    qv();
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.f23988j, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int i7 = 0;
            while (i6 < size) {
                String jSONObject = arrayList.get(i6).up().toString();
                strArr2[i6] = jSONObject;
                i7 += jSONObject.length();
                i6++;
            }
            if (i7 >= 307200) {
                uc.xt((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.f23988j.sendBroadcast(intent);
            } catch (Exception e6) {
                uc.xt(e6);
            }
        }
    }

    public static void j(ya yaVar) {
        int size;
        Handler handler;
        f fVar = xt;
        if (fVar == null) {
            uc.xt("Init comes First!", null);
            a.j(yaVar);
            return;
        }
        if (yaVar.xt == 0) {
            uc.xt((Throwable) null);
        }
        synchronized (fVar.up) {
            size = fVar.up.size();
            fVar.up.add(yaVar);
        }
        if (size % 10 != 0 || (handler = fVar.qv) == null) {
            return;
        }
        handler.removeMessages(4);
        fVar.qv.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void j(String[] strArr) {
        f fVar = xt;
        if (fVar == null) {
            uc.xt(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = fVar.qv;
        if (handler != null) {
            handler.removeMessages(4);
            fVar.qv.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compare(ya yaVar, ya yaVar2) {
        long j6 = yaVar.xt - yaVar2.xt;
        if (j6 < 0) {
            return -1;
        }
        return j6 > 0 ? 1 : 0;
    }
}
