package com.bytedance.sdk.openadsdk.m.xt;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Handler.Callback {

    /* renamed from: j, reason: collision with root package name */
    private Handler f31608j;

    /* renamed from: com.bytedance.sdk.openadsdk.m.xt.cw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        public static final cw f31609j = new cw(null);
    }

    /* synthetic */ cw(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static cw j() {
        return j.f31609j;
    }

    private cw() {
        this.f31608j = new Handler(tl.j().getLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    public void j(Runnable runnable) {
        Message obtain = Message.obtain();
        obtain.obj = runnable;
        this.f31608j.sendMessage(obtain);
    }

    public void j(Runnable runnable, long j6) {
        this.f31608j.postDelayed(runnable, j6);
    }
}
