package com.bytedance.sdk.component.oq.xt;

import com.bytedance.sdk.component.oq.xt.cw;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r<T extends cw> {

    /* renamed from: j, reason: collision with root package name */
    private int f26673j;
    private BlockingQueue<T> xt = new LinkedBlockingQueue();

    public static r j(int i6) {
        return new r(i6);
    }

    public T j() {
        return this.xt.poll();
    }

    private r(int i6) {
        this.f26673j = i6;
    }

    public boolean j(T t5) {
        if (t5 == null) {
            return false;
        }
        t5.j();
        if (this.xt.size() >= this.f26673j) {
            return false;
        }
        return this.xt.offer(t5);
    }
}
