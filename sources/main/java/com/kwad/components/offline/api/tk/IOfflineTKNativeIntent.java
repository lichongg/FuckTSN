package com.kwad.components.offline.api.tk;

import android.content.Intent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IOfflineTKNativeIntent {
    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z5, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
