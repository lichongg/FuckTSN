package com.kwad.sdk.kgeo;

import android.content.Context;
import android.os.Build;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.s;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void Ll();

        void onSuccess(String str);
    }

    public static void a(final Context context, final a aVar) {
        String str;
        String str2;
        String str3;
        if (bc.useMacAddressDisable()) {
            aVar.Ll();
            return;
        }
        if (!s.PT()) {
            aVar.Ll();
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            aVar.Ll();
            return;
        }
        AtomicBoolean atomicBoolean = sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        boolean isArm64 = AbiUtil.isArm64(context);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.version = "1.0.3";
        if (isArm64) {
            str = "kmc-v8a";
        } else {
            str = "kmc-v7a";
        }
        bVar.arx = str;
        com.kwad.sdk.core.network.idc.a HF = com.kwad.sdk.core.network.idc.a.HF();
        if (isArm64) {
            str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64";
        } else {
            str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32";
        }
        bVar.ary = HF.ef(str2);
        if (isArm64) {
            str3 = "db9a8da62a0354ec5710ec03e2743f07";
        } else {
            str3 = "2440a8221230913d4287c6b1e02b49f1";
        }
        bVar.arA = str3;
        bVar.enable = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.kgeo.c.1
            @Override // com.kwad.library.solder.lib.ext.b.C0666b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                ws();
            }

            private void ws() {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onPostLoad");
                try {
                    System.loadLibrary("ipneigh-android");
                    a.this.onSuccess(com.kwai.library.ipneigh.c.es(context).bfm);
                } catch (Throwable unused) {
                    com.kwad.sdk.core.d.c.d("KGeoSoHelper", "loadLibrary fail");
                    a.this.Ll();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0666b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                a.this.Ll();
            }
        });
    }
}
