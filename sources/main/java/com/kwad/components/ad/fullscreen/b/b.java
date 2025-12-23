package com.kwad.components.ad.fullscreen.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long jC;
    public int jD;

    public b() {
        this.jC = -1L;
        this.jD = -1;
    }

    public final boolean F(int i6) {
        int i7 = this.jD;
        return i7 > 0 && i7 >= i6;
    }

    public final boolean j(long j6) {
        if (this.jC > 0 && j6 > 0) {
            try {
                return jB.format(new Date(this.jC)).equals(jB.format(new Date(j6)));
            } catch (Exception e6) {
                c.printStackTraceOnly(e6);
            }
        }
        return false;
    }

    public b(long j6, int i6) {
        this.jC = j6;
        this.jD = 1;
    }
}
