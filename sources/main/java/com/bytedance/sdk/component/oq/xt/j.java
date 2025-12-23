package com.bytedance.sdk.component.oq.xt;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.MessageQueue;
import com.bytedance.sdk.component.utils.l;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private Handler cw;

    /* renamed from: j, reason: collision with root package name */
    private final r<xt> f26669j;
    private Handler xt;

    /* renamed from: com.bytedance.sdk.component.oq.xt.j$j, reason: collision with other inner class name */
    private static class C0415j {

        /* renamed from: j, reason: collision with root package name */
        private static final j f26672j = new j();
    }

    public Handler xt() {
        if (this.xt == null) {
            synchronized (j.class) {
                try {
                    if (this.xt == null) {
                        this.xt = j("csj_io_handler");
                    }
                } finally {
                }
            }
        }
        return this.xt;
    }

    private j() {
        this.f26669j = r.j(2);
    }

    public static j j() {
        return C0415j.f26672j;
    }

    public Handler cw() {
        if (this.cw == null) {
            synchronized (j.class) {
                try {
                    if (this.cw == null) {
                        this.cw = j("csj_main_handler");
                    }
                } finally {
                }
            }
        }
        return this.cw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final Handler handler, final Handler handler2) {
        MessageQueue queue;
        boolean isIdle;
        if (Build.VERSION.SDK_INT >= 23) {
            queue = handler.getLooper().getQueue();
            isIdle = queue.isIdle();
            if (isIdle) {
                handler.removeCallbacksAndMessages(null);
                handler.getLooper().quit();
            } else {
                handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.oq.xt.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.j(handler, handler2);
                    }
                }, 1000L);
            }
        }
    }

    private xt xt(l.j jVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new xt(handlerThread, jVar);
    }

    public l j(l.j jVar, final String str) {
        xt j6 = this.f26669j.j();
        if (j6 != null) {
            j6.j(jVar);
            j6.post(new Runnable() { // from class: com.bytedance.sdk.component.oq.xt.j.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return j6;
        }
        return xt(jVar, str);
    }

    public l j(String str) {
        return j((l.j) null, str);
    }

    public boolean j(l lVar) {
        if (!(lVar instanceof xt)) {
            return false;
        }
        xt xtVar = (xt) lVar;
        if (this.f26669j.j((r<xt>) xtVar)) {
            return true;
        }
        xtVar.xt();
        return true;
    }
}
