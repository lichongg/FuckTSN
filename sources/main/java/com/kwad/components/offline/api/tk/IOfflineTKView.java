package com.kwad.components.offline.api.tk;

import android.app.Activity;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IOfflineTKView {
    void bindActivity(Activity activity);

    Object callJSFunc(String str, String str2, IOfflineTKFunction iOfflineTKFunction);

    View getView();

    boolean onBackPressed();

    void render();

    void setData(Object... objArr);

    void setDownloadProgress(String str);

    void setLifeStatus(String str);
}
