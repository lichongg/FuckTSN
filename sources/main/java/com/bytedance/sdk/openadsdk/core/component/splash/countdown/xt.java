package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.l;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements l.j {
    private AtomicBoolean cw = new AtomicBoolean(true);

    /* renamed from: j, reason: collision with root package name */
    protected final l f28627j = new l(Looper.getMainLooper(), this);

    /* renamed from: r, reason: collision with root package name */
    private int f28628r = 5;
    private int up = 1;
    private j xt;

    public interface j {
        void j();

        void j(int i6);
    }

    public void j() {
        cw();
    }

    private void cw() {
        this.f28627j.removeMessages(1);
        this.up = 1;
    }

    private void m() {
        try {
            int i6 = this.up;
            if (i6 >= this.f28628r + 1) {
                j jVar = this.xt;
                if (jVar != null) {
                    jVar.j();
                    return;
                }
                return;
            }
            int i7 = i6 + 1;
            this.up = i7;
            j jVar2 = this.xt;
            if (jVar2 != null) {
                jVar2.j(i7);
            }
            this.f28627j.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    private void r() {
        try {
            this.f28627j.removeMessages(1);
        } catch (Throwable unused) {
        }
    }

    private void up() {
        try {
            this.f28627j.sendEmptyMessage(1);
        } catch (Throwable unused) {
        }
    }

    public void j(boolean z5) {
        this.cw.set(z5);
        if (this.cw.get()) {
            up();
        } else {
            r();
        }
    }

    public void xt() {
        cw();
        this.f28627j.sendEmptyMessage(1);
    }

    public void j(j jVar) {
        this.xt = jVar;
    }

    public void j(int i6) {
        this.f28628r = i6;
        cw();
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what == 1) {
            m();
        }
    }
}
