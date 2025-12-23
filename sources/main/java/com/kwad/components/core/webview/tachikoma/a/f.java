package com.kwad.components.core.webview.tachikoma.a;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class f implements m {
    private Handler acR = new Handler(Looper.getMainLooper());

    protected abstract void a(al.a aVar);

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    final al.a aVar = new al.a();
                    aVar.parseJson(objArr[0] instanceof String ? new JSONObject((String) objArr[0]) : null);
                    this.acR.post(new bg() { // from class: com.kwad.components.core.webview.tachikoma.a.f.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            f.this.a(aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        return null;
    }
}
