package com.kwad.components.offline.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements com.kwad.components.core.o.a.d.a {
    private final IObiwanOfflineCompo ajX;

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.ajX.getLog();
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.ajX.priority();
    }

    public final void updateConfigs() {
        this.ajX.updateConfigs();
    }

    public a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.ajX = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
