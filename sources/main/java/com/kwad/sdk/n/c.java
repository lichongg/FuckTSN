package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.n.a.b;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {
    public static final String TAG = "Ranger_" + c.class.getSimpleName();
    private String value;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final c aXb = new c(0);
    }

    /* synthetic */ c(byte b6) {
        this();
    }

    static /* synthetic */ com.kwad.sdk.n.b.a.d a(c cVar, String str, String str2) {
        return an(str, str2);
    }

    public final void c(d dVar) {
        List<com.kwad.sdk.n.a.b> list;
        if (dVar == null || (list = dVar.aXe) == null || list.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.n.a.b> list2 = dVar.aXe;
        h.schedule(new bg() { // from class: com.kwad.sdk.n.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.n.a.b bVar : list2) {
                    if (bVar != null && !TextUtils.isEmpty(bVar.aXu)) {
                        String str = bVar.aXu;
                        c cVar = c.this;
                        cVar.value = cVar.a(bVar);
                        c cVar2 = c.this;
                        com.kwad.sdk.n.b.a.d a6 = c.a(cVar2, str, cVar2.value);
                        if (a6 != null) {
                            arrayList.add(a6);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.n.b.a.e eVar = new com.kwad.sdk.n.b.a.e();
                eVar.aXP = arrayList;
                com.kwad.sdk.n.b.a.a(eVar);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    private c() {
    }

    private Object b(com.kwad.sdk.n.a.b bVar) {
        Class<?> cls;
        if (bVar.aXv.aXE) {
            try {
                if (TextUtils.isEmpty(bVar.aXr)) {
                    Object obj = bVar.aXq;
                    cls = obj != null ? obj.getClass() : null;
                } else {
                    cls = Class.forName(bVar.aXr);
                }
                if (cls != null) {
                    return a(bVar, true, cls);
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e6));
            }
        } else if (bVar.aXq != null) {
            return a(bVar, false, (Class<?>) null);
        }
        return null;
    }

    private static String o(Object obj) {
        if (obj != null) {
            return String.valueOf(obj);
        }
        com.kwad.sdk.core.d.c.w(TAG, "value is null by ob null");
        return "";
    }

    public static c OV() {
        return a.aXb;
    }

    @Nullable
    private static com.kwad.sdk.n.b.a.d an(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.kwad.sdk.n.b.a.d dVar = new com.kwad.sdk.n.b.a.d();
            dVar.name = str;
            dVar.aXO = str2;
            return dVar;
        }
        return null;
    }

    private static Object c(com.kwad.sdk.n.a.b bVar) {
        if (bVar.aXt) {
            try {
                return z.c(Class.forName(bVar.aXr), bVar.aXs);
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e6));
                return null;
            }
        }
        Object obj = bVar.aXq;
        if (obj != null) {
            return z.getField(obj, bVar.aXs);
        }
        return null;
    }

    public final String a(com.kwad.sdk.n.a.b bVar) {
        com.kwad.sdk.n.a.b bVar2 = bVar.aXw;
        if (bVar2 != null && !bVar2.Pb()) {
            if (!TextUtils.isEmpty(bVar.aXs)) {
                bVar.aXw.aXq = c(bVar);
            } else {
                b.C0706b c0706b = bVar.aXv;
                if (c0706b != null && !c0706b.Pb()) {
                    bVar.aXw.aXq = b(bVar);
                }
            }
            return a(bVar.aXw);
        }
        if (!TextUtils.isEmpty(bVar.aXs)) {
            return o(c(bVar));
        }
        b.C0706b c0706b2 = bVar.aXv;
        if (c0706b2 != null && !c0706b2.Pb()) {
            return o(b(bVar));
        }
        com.kwad.sdk.core.d.c.d(TAG, "node.nodeClassName:" + bVar.aXr);
        return z.classExists(bVar.aXr) ? "true" : "false";
    }

    private static Object a(com.kwad.sdk.n.a.b bVar, boolean z5, Class<?> cls) {
        Object[] Pe = bVar.aXv.Pe();
        if (Pe == null || Pe.length == 0) {
            if (z5) {
                return z.callStaticMethod(cls, bVar.aXv.name, new Object[0]);
            }
            return z.callMethod(bVar.aXq, bVar.aXv.name, new Object[0]);
        }
        if (z5) {
            return z.callStaticMethod(cls, bVar.aXv.name, Pe);
        }
        return z.callMethod(bVar.aXq, bVar.aXv.name, Pe);
    }
}
