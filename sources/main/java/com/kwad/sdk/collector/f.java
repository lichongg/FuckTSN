package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    @NonNull
    private static List<g> bl(Context context) {
        String[] cN;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (context != null && (cN = y.cN(context)) != null) {
            for (String str : cN) {
                int at = au.at(context, str);
                copyOnWriteArrayList.add(new g(str, at == 0 ? g.PERMISSION_GRANTED : at == -1 ? g.PERMISSION_DENIED : g.avh));
            }
        }
        return copyOnWriteArrayList;
    }

    @Nullable
    public static JSONArray DI() {
        Context context = ServiceProvider.getContext();
        List<g> bl = bl(context);
        bl.add(bk(context));
        return g.w(bl);
    }

    private static g bk(Context context) {
        int i6;
        boolean dk = au.dk(context);
        com.kwad.sdk.core.d.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + dk);
        if (dk) {
            i6 = g.PERMISSION_GRANTED;
        } else {
            i6 = g.PERMISSION_DENIED;
        }
        return new g(com.kuaishou.weapon.p0.g.f36051k, i6);
    }
}
