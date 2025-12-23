package com.kwad.components.offline.api.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ITkOfflineCompo extends IOfflineCompo<ITkOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.tachikoma.TkOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.tachikoma";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum TKState {
        READY,
        SO_FAIL
    }

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i6);

    IOfflineCompoTachikomaContext getContext(Context context, String str, int i6, int i7, boolean z5);

    String getJsBaseDir(Context context, String str);

    TKState getState();

    String getTKVersion();

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i6, TKDownloadListener tKDownloadListener);

    void onConfigRefresh(Context context, @NonNull JSONObject jSONObject);

    void onDestroy();
}
