package com.ss.android.socialbase.downloader.ws;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes6.dex */
public final class up implements Handler.Callback {

    /* renamed from: j, reason: collision with root package name */
    private volatile Handler f39015j = new Handler(j.f39016j, this);

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static final Looper f39016j;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            f39016j = handlerThread.getLooper();
        }
    }

    public interface xt {
        long j();
    }

    public static Looper j() {
        return j.f39016j;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            xt xtVar = (xt) message.obj;
            long j6 = xtVar.j();
            if (j6 <= 0) {
                return true;
            }
            j(xtVar, j6);
            return true;
        } catch (Throwable th) {
            vl.j(th);
            return true;
        }
    }

    public void j(xt xtVar, long j6) {
        Handler handler = this.f39015j;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = xtVar;
        handler.sendMessageDelayed(obtain, j6);
    }

    public void xt() {
        Handler handler = this.f39015j;
        if (handler == null) {
            return;
        }
        this.f39015j = null;
        handler.removeCallbacksAndMessages(null);
    }
}
