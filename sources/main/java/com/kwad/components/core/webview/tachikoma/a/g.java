package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class g implements m {
    protected abstract void a(y yVar);

    protected abstract void bP();

    protected abstract void bQ();

    protected abstract void bR();

    protected abstract void bS();

    @Override // com.kwad.sdk.components.m
    public final Object call(@Nullable Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                final y yVar = new y();
                if (objArr[0] instanceof String) {
                    yVar.parseJson(new JSONObject((String) objArr[0]));
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.a.g.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (yVar.vz()) {
                                g.this.bS();
                                return;
                            }
                            if (yVar.vB()) {
                                return;
                            }
                            if (yVar.vC()) {
                                g.this.bQ();
                                return;
                            }
                            if (yVar.vD()) {
                                g.this.bP();
                            } else if (yVar.vA()) {
                                g.this.bR();
                            } else if (yVar.isFailed()) {
                                g.this.a(yVar);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
