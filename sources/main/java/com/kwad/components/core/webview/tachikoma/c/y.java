package com.kwad.components.core.webview.tachikoma.c;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class y extends com.kwad.sdk.core.response.a.a {
    public String ahn;
    public int errorCode;
    public String errorReason;
    public int qz;

    public final boolean isFailed() {
        return TextUtils.equals("failed", this.ahn);
    }

    public final boolean vA() {
        return TextUtils.equals("end", this.ahn);
    }

    public final boolean vB() {
        return TextUtils.equals(NotificationCompat.CATEGORY_PROGRESS, this.ahn);
    }

    public final boolean vC() {
        return TextUtils.equals("pause", this.ahn);
    }

    public final boolean vD() {
        return TextUtils.equals("resume", this.ahn);
    }

    public final int vE() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return 0;
        }
    }

    public final boolean vz() {
        return TextUtils.equals("start", this.ahn);
    }
}
