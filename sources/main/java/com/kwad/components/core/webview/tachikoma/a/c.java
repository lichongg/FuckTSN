package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.sdk.components.m;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class c implements m {
    public abstract void b(a.C0637a c0637a);

    @Override // com.kwad.sdk.components.m
    public final Object call(@Nullable Object... objArr) {
        String str = " ";
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        str = (String) obj;
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return null;
            }
        }
        a.C0637a c0637a = new a.C0637a();
        c0637a.parseJson(new JSONObject(str));
        b(c0637a);
        return null;
    }
}
