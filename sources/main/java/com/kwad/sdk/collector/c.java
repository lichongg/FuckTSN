package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void b(AppStatusRules appStatusRules);

        void s(int i6, String str);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void cB(String str) {
                com.kwad.sdk.core.d.c.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new l<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: DG, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.collector.a.a createRequest() {
                if (!s.PW()) {
                    return new com.kwad.sdk.collector.a.a(null);
                }
                return new com.kwad.sdk.collector.a.a(br.ec(context));
            }

            @NonNull
            private static AppStatusRules cC(String str) {
                return AppStatusRules.createFromJson(str);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return cC(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.a.a aVar2) {
                super.onStartRequest(aVar2);
            }

            private void a(@NonNull AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.sdk.collector.a.a aVar2, int i6, String str) {
                super.onError(aVar2, i6, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.s(i6, str);
                }
            }
        });
    }
}
