package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private String WH;
    private long WI;
    private long WJ;
    private long WK;
    private boolean WL;

    @Nullable
    private c WM;

    public final void L(long j6) {
        this.WI = j6;
        this.WJ = SystemClock.uptimeMillis();
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.WM;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }

    public final void aC(String str) {
        this.WH = str;
    }

    public final void report() {
        b bVar = new b();
        bVar.WH = this.WH;
        long j6 = this.WI;
        bVar.WP = j6 != 0 ? this.WJ - j6 : 0L;
        long j7 = this.WJ;
        bVar.WQ = j7 != 0 ? this.WK - j7 : 0L;
        bVar.WO = j6 != 0 ? this.WK - j6 : 0L;
        com.kwad.components.core.p.a.se().a(bVar);
        com.kwad.sdk.core.d.c.d("PageMonitor", bVar.toString());
    }

    public final void sd() {
        if (this.WL) {
            return;
        }
        this.WL = true;
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.WK = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public a(@Nullable c cVar) {
        this.WM = cVar;
    }
}
