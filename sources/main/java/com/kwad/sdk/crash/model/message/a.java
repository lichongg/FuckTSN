package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.d;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private JSONObject aPy = new JSONObject();

    private void put(String str, Object obj) {
        try {
            this.aPy.put(str, obj);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final void fE(String str) {
        put(d.aOO, str);
    }

    public final String toString() {
        return this.aPy.toString();
    }

    public final void a(String str, JSONObject jSONObject) {
        put(str, jSONObject);
    }

    public final void putInt(String str, int i6) {
        put(str, Integer.valueOf(i6));
    }

    public final void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.length() <= 100) {
            put(str, str2);
        } else {
            c.d("AnrAndNativeAdExceptionCollector", "string value to long ,max is 100");
        }
    }
}
