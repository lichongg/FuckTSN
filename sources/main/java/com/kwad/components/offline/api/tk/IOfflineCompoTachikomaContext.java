package com.kwad.components.offline.api.tk;

import android.view.View;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IOfflineCompoTachikomaContext {
    Object execute(String str);

    void execute(String str, String str2, IOfflineTKRenderListener iOfflineTKRenderListener);

    IOfflineTKView getTKView(String str, Object... objArr);

    int getUniqId();

    View getView();

    void onDestroy();

    void registerApkLoadCreator(IOfflineApkLoaderHolder iOfflineApkLoaderHolder);

    void registerHostActionHandler(IOfflineHostActionHandler iOfflineHostActionHandler);

    void registerJsBridge(IOfflineCompoBridgeHandler iOfflineCompoBridgeHandler);

    void registerTKBridge(IOfflineCompoTKBridgeHandler iOfflineCompoTKBridgeHandler);

    void setCustomEnv(Map<String, Object> map);

    void unregisterJsBridge();
}
