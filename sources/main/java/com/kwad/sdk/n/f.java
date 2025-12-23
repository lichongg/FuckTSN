package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {
    public static final String TAG = "Ranger_" + f.class.getSimpleName();

    public static void cS(final String str) {
        h.schedule(new bg() { // from class: com.kwad.sdk.n.f.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.c.w(f.TAG, "config is empty");
                    return;
                }
                d gH = f.gH(str2);
                if (gH != null) {
                    com.kwad.sdk.core.d.c.d(f.TAG, "config:" + gH.toJson().toString());
                }
                if (gH == null || gH.OX()) {
                    return;
                }
                f.d(gH);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    public static void d(@NonNull d dVar) {
        if (new Random().nextFloat() >= dVar.sampleRate) {
            com.kwad.sdk.core.d.c.d(TAG, "config.sampleRate：" + dVar.sampleRate + " return");
            return;
        }
        if (dVar.OY()) {
            a(dVar);
        }
        if (dVar.OZ()) {
            e(dVar);
        }
        if (dVar.Pa()) {
            f(dVar);
        }
    }

    private static void a(@NonNull d dVar) {
        try {
            a.a(dVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
        }
    }

    private static void e(d dVar) {
        c.OV().c(dVar);
    }

    private static void f(final d dVar) {
        GlobalThreadPools.Jn().execute(new Runnable() { // from class: com.kwad.sdk.n.f.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    b.OQ().b(d.this);
                    b.OQ().OS();
                    b.OQ().clearAll();
                    b.OQ().start();
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.e(f.TAG, Log.getStackTraceString(e6));
                }
            }
        });
    }

    public static d gH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.w(TAG, e6);
            return null;
        }
    }
}
