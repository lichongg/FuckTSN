package cn.jiguang.bm;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.bb.f;
import cn.jiguang.bi.g;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2359a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, cn.jiguang.bm.a> f2360b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f2361c;

    /* renamed from: d, reason: collision with root package name */
    private HandlerThread f2362d;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f2364a = new b();
    }

    /* renamed from: cn.jiguang.bm.b$b, reason: collision with other inner class name */
    class HandlerC0034b extends Handler {
        public HandlerC0034b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                cn.jiguang.bm.a aVar = (cn.jiguang.bm.a) b.this.f2360b.get(Integer.valueOf(message.what));
                if (aVar == null) {
                    f.i("TaskHandlerManager_xxx", "miss task:" + message.what);
                    return;
                }
                aVar.a(message);
                int i6 = aVar.f2358c;
                if (i6 == 1) {
                    sendEmptyMessageDelayed(message.what, g.a().f() * 1000);
                } else {
                    if (i6 == 3) {
                        return;
                    }
                    b.this.f2360b.remove(Integer.valueOf(message.what));
                }
            } catch (Throwable th) {
                f.i("TaskHandlerManager_xxx", "handleMessage,e:" + th);
            }
        }
    }

    private b() {
        this.f2359a = false;
        this.f2360b = new ConcurrentHashMap<>();
    }

    public static b a() {
        return a.f2364a;
    }

    public void b(int i6) {
        if (this.f2361c == null) {
            return;
        }
        this.f2360b.remove(Integer.valueOf(i6));
        this.f2361c.removeMessages(i6);
    }

    public void b(int i6, long j6, cn.jiguang.bm.a aVar) {
        if (this.f2361c == null) {
            return;
        }
        aVar.f2358c = 2;
        this.f2360b.put(Integer.valueOf(i6), aVar);
        if (this.f2361c.hasMessages(i6)) {
            f.c("TaskHandlerManager_xxx", "sendMsg,replace:" + i6);
            this.f2361c.removeMessages(i6);
        } else {
            f.c("TaskHandlerManager_xxx", "sendMsg,action=" + i6);
        }
        this.f2361c.sendEmptyMessageDelayed(i6, j6);
    }

    private void a(int i6, int i7, long j6, cn.jiguang.bm.a aVar) {
        if (this.f2361c == null) {
            return;
        }
        aVar.f2357b = j6;
        aVar.f2358c = i6;
        this.f2360b.put(Integer.valueOf(i7), aVar);
        if (this.f2361c.hasMessages(i7)) {
            f.i("TaskHandlerManager_xxx", "register,same action in handler,will replace " + i7);
            this.f2361c.removeMessages(i7);
        }
        this.f2361c.sendEmptyMessageDelayed(i7, j6);
    }

    public void a(int i6, long j6, cn.jiguang.bm.a aVar) {
        a(1, i6, j6, aVar);
    }

    public synchronized void a(Context context) {
        if (this.f2359a) {
            return;
        }
        if (context == null) {
            f.c("TaskHandlerManager_xxx", "init context is null");
            return;
        }
        f.c("TaskHandlerManager_xxx", "init task manager...");
        try {
            HandlerThread handlerThread = this.f2362d;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("jg_tsk_thread") { // from class: cn.jiguang.bm.b.1
                    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            super.run();
                        } catch (RuntimeException e6) {
                            f.l("TaskHandlerManager_xxx", "handler thread run e:" + e6 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                        }
                    }
                };
                this.f2362d = handlerThread2;
                handlerThread2.start();
            }
            this.f2361c = new HandlerC0034b(this.f2362d.getLooper() == null ? Looper.getMainLooper() : this.f2362d.getLooper());
        } catch (Exception unused) {
            this.f2361c = new HandlerC0034b(Looper.getMainLooper());
        }
        this.f2359a = true;
    }

    public boolean a(int i6) {
        Handler handler = this.f2361c;
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(i6);
    }
}
