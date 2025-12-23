package com.kwad.components.offline.d.a;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.IOfflineTKFunction;
import com.kwad.components.offline.api.tk.IOfflineTKView;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.r;
import com.kwad.sdk.components.s;
import com.kwad.sdk.components.t;
import com.kwad.sdk.utils.ax;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i implements t {
    private final IOfflineCompoTachikomaContext akI;

    @Override // com.kwad.sdk.components.t
    public final o a(String str, Object... objArr) {
        final IOfflineTKView tKView = this.akI.getTKView(str, objArr);
        return new o() { // from class: com.kwad.components.offline.d.a.i.1
            @Override // com.kwad.sdk.components.o
            public final Object b(String str2, String str3, final m mVar) {
                return tKView.callJSFunc(str2, str3, new IOfflineTKFunction() { // from class: com.kwad.components.offline.d.a.i.1.1
                    @Override // com.kwad.components.offline.api.tk.IOfflineTKFunction
                    public final Object call(Object... objArr2) {
                        return mVar.call(objArr2);
                    }
                });
            }

            @Override // com.kwad.sdk.components.o
            public final void bindActivity(Activity activity) {
                tKView.bindActivity(activity);
            }

            @Override // com.kwad.sdk.components.o
            public final View getView() {
                return tKView.getView();
            }

            @Override // com.kwad.sdk.components.o
            public final boolean onBackPressed() {
                return tKView.onBackPressed();
            }

            @Override // com.kwad.sdk.components.o
            public final void render() {
                tKView.render();
            }

            @Override // com.kwad.sdk.components.o
            public final void setDownloadProgress(String str2) {
                tKView.setDownloadProgress(str2);
            }
        };
    }

    @Override // com.kwad.sdk.components.t
    public final void b(com.kwad.sdk.core.webview.c.g gVar) {
        if (gVar == null) {
            return;
        }
        this.akI.registerTKBridge(new f(gVar));
    }

    @Override // com.kwad.sdk.components.t
    public final void c(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.akI.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.t
    public final Object execute(String str) {
        return this.akI.execute(str);
    }

    @Override // com.kwad.sdk.components.t
    public final int getUniqId() {
        return this.akI.getUniqId();
    }

    @Override // com.kwad.sdk.components.t
    public final View getView() {
        return this.akI.getView();
    }

    @Override // com.kwad.sdk.components.t
    public final void onDestroy() {
        this.akI.onDestroy();
    }

    @Override // com.kwad.sdk.components.t
    public final void setCustomEnv(Map<String, Object> map) {
        this.akI.setCustomEnv(map);
    }

    public i(@NonNull IOfflineCompoTachikomaContext iOfflineCompoTachikomaContext) {
        ax.checkNotNull(iOfflineCompoTachikomaContext);
        this.akI = iOfflineCompoTachikomaContext;
    }

    @Override // com.kwad.sdk.components.t
    public final void a(String str, String str2, s sVar) {
        this.akI.execute(str, str2, new h(sVar));
    }

    @Override // com.kwad.sdk.components.t
    public final void a(r rVar) {
        if (rVar != null) {
            this.akI.registerHostActionHandler(new c(rVar));
        }
    }

    @Override // com.kwad.sdk.components.t
    public final void a(k kVar) {
        if (kVar != null) {
            this.akI.registerApkLoadCreator(new e(kVar));
        }
    }
}
