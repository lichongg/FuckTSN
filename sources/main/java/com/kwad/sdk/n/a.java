package com.kwad.sdk.n;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.n.d;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static final String TAG = "Ranger_" + c.class.getSimpleName();

    static void a(@NonNull d dVar) {
        final List<d.a> list = dVar.aXd;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.n.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.e(a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String e(Object obj, String str) {
        Object field;
        if (!TextUtils.isEmpty(str) && (field = z.getField(obj, str)) != null) {
            return field.getClass().getName();
        }
        return "";
    }

    static void a(Activity activity, @NonNull List<d.a> list) {
        try {
            for (d.a aVar : list) {
                if (aVar != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.aXf)) {
                        str = aVar.aXf;
                    } else if (!TextUtils.isEmpty(aVar.aXg) && activity.getClass().getName().startsWith(aVar.aXf)) {
                        str = e(activity, aVar.aXg);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int c6 = ag.c("ksadsdk_perf_ranger_v2", str, 0) + 1;
                        ag.b("ksadsdk_perf_ranger_v2", str, c6);
                        com.kwad.sdk.core.d.c.d(TAG, "act:" + str + " num:" + c6);
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, "record:" + Log.getStackTraceString(th));
        }
    }
}
