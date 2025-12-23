package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private com.kwad.sdk.crash.b.b aOP;
    private c aOQ;
    private long aOR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final e aOS = new e(0);
    }

    /* synthetic */ e(byte b6) {
        this();
    }

    private e() {
        this.aOP = new com.kwad.sdk.crash.b.b();
        this.aOQ = new c.a().Lq();
    }

    public final String[] Ls() {
        return this.aOP.LE();
    }

    public final String[] Lt() {
        return this.aOP.Lt();
    }

    public final String Lu() {
        return this.aOQ.aOn.aPt;
    }

    public final int Lv() {
        return this.aOQ.aOn.aPx;
    }

    public final c Lw() {
        return this.aOQ;
    }

    public final h Lx() {
        return this.aOQ.aOp;
    }

    public final void a(@NonNull c cVar) {
        this.aOQ = cVar;
        this.aOR = SystemClock.elapsedRealtime();
        this.aOP.a(cVar.aOq, cVar.aOr);
    }

    public final void b(int i6, ExceptionMessage exceptionMessage) {
        f Ln = this.aOQ.Ln();
        if (Ln != null) {
            Ln.a(i6, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aOQ.aOo.mAppId;
    }

    public final Context getContext() {
        return this.aOQ.context;
    }

    public final String getSdkVersion() {
        return this.aOQ.aOn.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aOQ.Lo();
    }

    public static e Lr() {
        return a.aOS;
    }

    public final long Ly() {
        return SystemClock.elapsedRealtime() - this.aOR;
    }
}
