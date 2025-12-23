package com.bytedance.pangle.j;

import com.bytedance.pangle.up.up;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    Throwable f25395j;
    private final CountDownLatch xt;

    /* renamed from: com.bytedance.pangle.j.j$j, reason: collision with other inner class name */
    public interface InterfaceC0386j {
        void j() throws Throwable;
    }

    public static void j(boolean z5, InterfaceC0386j... interfaceC0386jArr) throws Throwable {
        new j(z5, interfaceC0386jArr).j();
    }

    private j(boolean z5, InterfaceC0386j[] interfaceC0386jArr) {
        this.xt = new CountDownLatch(interfaceC0386jArr.length);
        for (final InterfaceC0386j interfaceC0386j : interfaceC0386jArr) {
            up.j(new Runnable() { // from class: com.bytedance.pangle.j.j.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0386j.j();
                    } catch (Throwable th) {
                        j.this.f25395j = th;
                    }
                    j.this.xt.countDown();
                }
            }, z5);
        }
    }

    private void j() throws Throwable {
        try {
            this.xt.await();
            Throwable th = this.f25395j;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e6) {
            throw new RuntimeException(e6);
        }
    }
}
