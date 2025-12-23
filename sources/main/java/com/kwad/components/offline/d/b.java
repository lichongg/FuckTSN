package com.kwad.components.offline.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.d.a.i;
import com.kwad.sdk.components.t;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements com.kwad.components.core.o.a.e.c {
    private final ITkOfflineCompo ake;

    @Override // com.kwad.components.core.o.a.e.c
    public final t a(Context context, String str, int i6, int i7, boolean z5) {
        IOfflineCompoTachikomaContext context2 = this.ake.getContext(context, str, i6, i7, z5);
        if (context2 == null) {
            return null;
        }
        return new i(context2);
    }

    @Override // com.kwad.components.core.o.a.e.c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i6) {
        return this.ake.checkStyleTemplateById(context, str, str2, str3, i6);
    }

    @Override // com.kwad.sdk.components.b
    public final Class<b> getComponentsType() {
        return b.class;
    }

    @Override // com.kwad.components.core.o.a.e.c
    public final String getJsBaseDir(Context context, String str) {
        return this.ake.getJsBaseDir(context, str);
    }

    @Override // com.kwad.components.core.o.a.e.c
    public final ITkOfflineCompo.TKState getState() {
        return this.ake.getState();
    }

    @Override // com.kwad.components.core.o.a.e.c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i6, TKDownloadListener tKDownloadListener) {
        this.ake.loadTkFileByTemplateId(context, str, str2, str3, i6, tKDownloadListener);
    }

    public final void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        this.ake.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.o.a.e.c
    public final void onDestroy() {
        this.ake.onDestroy();
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.ake.priority();
    }

    public b(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        this.ake = iTkOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
