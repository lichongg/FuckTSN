package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private String Ne;
    private String Nf;
    private long Ng;
    private long Nh;
    private Timer Ni;
    private boolean Nj = false;
    private final long period;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.a.a$a, reason: collision with other inner class name */
    static final class C0604a {
        private static final a Nl = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        this.Nj = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.Ni;
        if (timer != null) {
            timer.cancel();
        }
        av(3);
    }

    public final void au() {
        if (this.Nj) {
            return;
        }
        this.Nj = true;
        if (this.period <= 0) {
            return;
        }
        this.Ni = new Timer();
        av(1);
        TimerTask timerTask = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.av(2);
            }
        };
        try {
            Timer timer = this.Ni;
            long j6 = this.period;
            timer.schedule(timerTask, j6, j6);
        } catch (Throwable unused) {
        }
    }

    public a() {
        this.Ng = -1L;
        try {
            this.Ng = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.Ng = System.currentTimeMillis();
            c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(e.Fa());
        d dVar = new d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.av();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.au();
            }
        };
        b.Ho();
        b.a(dVar);
    }

    public static a nX() {
        return C0604a.Nl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i6) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j6 = elapsedRealtime - this.Ng;
        this.Ng = elapsedRealtime;
        if (i6 == 1) {
            this.Nh = 0L;
            this.Nf = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.Ne)) {
                this.Ne = this.Nf;
            }
        }
        this.Nh++;
        n nVar = new n(10220L);
        nVar.aDb = this.Nh;
        if (j6 > 0) {
            nVar.aHK = j6;
        }
        nVar.aHL = i6;
        nVar.Ne = this.Ne;
        nVar.Nf = this.Nf;
        g.a2(nVar);
    }
}
