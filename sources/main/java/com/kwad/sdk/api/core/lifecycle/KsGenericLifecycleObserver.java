package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class KsGenericLifecycleObserver extends KsLifecycleObserver {
    @Keep
    public abstract void onStateChanged(KsLifecycle.KsLifeEvent ksLifeEvent);
}
