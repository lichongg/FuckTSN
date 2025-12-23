package com.kwad.components.core.l;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat Rq = new SimpleDateFormat("yyyy-MM-dd");
    public int Rr;
    public long Rs;

    public final boolean k(int i6, int i7) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i6 + ", forceActiveThreshold: " + i7);
        if (this.Rs <= 0) {
            qr();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = Rq.format(new Date(this.Rs));
        String format2 = Rq.format(new Date(currentTimeMillis));
        c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + format + ", currentDate: " + format2);
        if (!format.equals(format2)) {
            this.Rr = 0;
            qr();
            return true;
        }
        long j6 = this.Rs + (i6 * 3600000);
        c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j6 + ", currentActiveCount: " + this.Rr);
        if (j6 >= currentTimeMillis || this.Rr > i7) {
            return false;
        }
        qr();
        return true;
    }

    public final void qr() {
        this.Rs = System.currentTimeMillis();
        this.Rr++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.Rs + ", currentActiveCount " + this.Rr);
    }
}
