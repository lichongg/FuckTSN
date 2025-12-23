package com.kwad.components.ad.b;

import android.app.Activity;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface b extends com.kwad.sdk.components.b {
    String getBidRequestToken(KsScene ksScene);

    String getBidRequestTokenV2(KsScene ksScene);

    boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener);
}
