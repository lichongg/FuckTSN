package com.kwad.components.core.o.a.e;

import android.content.Context;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.t;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface c extends com.kwad.sdk.components.b {
    t a(Context context, String str, int i6, int i7, boolean z5);

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i6);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i6, TKDownloadListener tKDownloadListener);

    void onDestroy();
}
