package com.bytedance.sdk.component.g.cw;

import android.content.Context;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    private static HashMap<Integer, j> cw;

    /* renamed from: j, reason: collision with root package name */
    private static volatile ae f26418j;
    private static HashMap<Integer, up> xt;

    public static synchronized ae j() {
        ae aeVar;
        synchronized (ae.class) {
            try {
                if (f26418j == null) {
                    synchronized (ae.class) {
                        try {
                            if (f26418j == null) {
                                f26418j = new ae();
                            }
                        } finally {
                        }
                    }
                }
                aeVar = f26418j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aeVar;
    }

    private ae() {
        xt = new HashMap<>();
        cw = new HashMap<>();
    }

    public up j(int i6) {
        up upVar = xt.get(Integer.valueOf(i6));
        if (upVar != null) {
            return upVar;
        }
        up upVar2 = new up(i6);
        xt.put(Integer.valueOf(i6), upVar2);
        return upVar2;
    }

    public j j(int i6, Context context) {
        j jVar = cw.get(Integer.valueOf(i6));
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(context, i6);
        cw.put(Integer.valueOf(i6), jVar2);
        return jVar2;
    }
}
