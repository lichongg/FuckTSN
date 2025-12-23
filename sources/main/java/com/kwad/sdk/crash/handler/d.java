package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements Thread.UncaughtExceptionHandler {
    private volatile boolean aPi = false;
    private Thread.UncaughtExceptionHandler aPj = Thread.getDefaultUncaughtExceptionHandler();
    private Context context;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.aPi) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.aPj;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
                return;
            }
            this.aPi = true;
            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
            if (com.kwad.sdk.crash.b.a.o(th)) {
                JavaExceptionMessage javaExceptionMessage = new JavaExceptionMessage();
                javaExceptionMessage.mCrashSource = 1;
                c.LG().a(th, javaExceptionMessage, this.context);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.aPj;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        } catch (Throwable unused) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.aPj;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
        }
    }

    public d(Context context) {
        this.context = context;
    }
}
