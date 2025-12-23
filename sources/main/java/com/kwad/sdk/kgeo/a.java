package com.kwad.sdk.kgeo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static String aSg;
    private static KGeoInfo aSh;
    private static final AtomicBoolean aSi = new AtomicBoolean();

    @Nullable
    public static String Bo() {
        return aSg;
    }

    @Nullable
    public static KGeoInfo MS() {
        return aSh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MT() {
        try {
            if (aSi.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.Pp(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void Ll() {
                    a.MU();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.aSg = str;
                    a.MU();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MU() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @NonNull
                private static KGeoResultData ga(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final f createRequest() {
                    return new b();
                }

                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ KGeoResultData parseData(String str) {
                    return ga(str);
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                private static void a(@NonNull KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.aSh = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void ea(int i6) {
        if (i6 == 0) {
            return;
        }
        if (i6 == 1) {
            MT();
        } else if (i6 == 2) {
            com.kwad.components.core.request.b.sj().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void sl() {
                    com.kwad.components.core.request.b.sj().b(this);
                    a.MT();
                }
            });
        }
    }
}
