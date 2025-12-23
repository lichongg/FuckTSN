package com.kwad.components.core.o.b.a;

import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.sdk.utils.bq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o implements ISystemProperties {
    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final String get(String str, String str2) {
        return bq.get(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final boolean getBoolean(String str, boolean z5) {
        return bq.getBoolean(str, z5);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final int getInt(String str, int i6) {
        return bq.getInt(str, i6);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final long getLong(String str, long j6) {
        return bq.getLong(str, j6);
    }
}
