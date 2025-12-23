package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static void a(Context context, com.kwad.sdk.core.network.idc.a.b bVar) {
        ag.a(context, "ksadsdk_idc", "idc_data", bVar == null ? "" : bVar.toJson().toString());
    }

    public static com.kwad.sdk.core.network.idc.a.b bA(Context context) {
        return com.kwad.sdk.core.network.idc.a.b.eh(ag.b(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static Map<String, String> bB(Context context) {
        return aa.parseJSON2MapString(ag.b(context, "ksadsdk_idc", "idc_current", ""));
    }

    public static com.kwad.sdk.core.network.idc.a.b bz(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.a.b.eh(h.L(context, "ksad_idc.json"));
        } catch (IOException e6) {
            c.printStackTraceOnly(e6);
            return new com.kwad.sdk.core.network.idc.a.b();
        }
    }

    public static void a(Context context, Map<String, String> map) {
        String str;
        if (map != null && !map.isEmpty()) {
            str = new JSONObject(map).toString();
        } else {
            str = "";
        }
        ag.a(context, "ksadsdk_idc", "idc_current", str);
    }
}
