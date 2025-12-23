package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy<T> {

    /* renamed from: j, reason: collision with root package name */
    public static Executor f23319j = com.bytedance.sdk.component.oq.cw.xt(new com.bytedance.sdk.component.oq.oq("ie/LottieTask"));
    private final Set<oq<Throwable>> cw;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f23320r;
    private volatile vl<T> up;
    private final Set<oq<T>> xt;

    private class j extends FutureTask<vl<T>> {
        j(Callable<vl<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    jy.this.setResult(get());
                } catch (InterruptedException | ExecutionException e6) {
                    jy.this.setResult(new vl(e6));
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public jy(Callable<vl<T>> callable) {
        this(callable, false);
    }

    public synchronized jy<T> cw(oq<Throwable> oqVar) {
        try {
            vl<T> vlVar = this.up;
            if (vlVar != null && vlVar.xt() != null) {
                oqVar.j(vlVar.xt());
            }
            this.cw.add(oqVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized jy<T> r(oq<Throwable> oqVar) {
        this.cw.remove(oqVar);
        return this;
    }

    public synchronized jy<T> xt(oq<T> oqVar) {
        this.xt.remove(oqVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    jy(Callable<vl<T>> callable, boolean z5) {
        this.xt = new LinkedHashSet(1);
        this.cw = new LinkedHashSet(1);
        this.f23320r = new Handler(Looper.getMainLooper());
        this.up = null;
        if (!z5) {
            f23319j.execute(new j(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new vl<>(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(vl<T> vlVar) {
        if (this.up != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.up = vlVar;
        j();
    }

    public synchronized jy<T> j(oq<T> oqVar) {
        try {
            vl<T> vlVar = this.up;
            if (vlVar != null && vlVar.j() != null) {
                oqVar.j(vlVar.j());
            }
            this.xt.add(oqVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    private void j() {
        this.f23320r.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.jy.1
            @Override // java.lang.Runnable
            public void run() {
                vl vlVar = jy.this.up;
                if (vlVar == null) {
                    return;
                }
                if (vlVar.j() != null) {
                    jy.this.j((jy) vlVar.j());
                } else {
                    jy.this.j(vlVar.xt());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(T t5) {
        Iterator it = new ArrayList(this.xt).iterator();
        while (it.hasNext()) {
            ((oq) it.next()).j(t5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(Throwable th) {
        ArrayList arrayList = new ArrayList(this.cw);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.up.up.j("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((oq) it.next()).j(th);
        }
    }
}
