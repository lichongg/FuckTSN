package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g extends b<n, f> {
    private static volatile boolean aGw;
    private static volatile g aGx;
    private static r<n, f> aGy;

    private static String D(List<n> list) {
        if (list.get(0) == null || TextUtils.isEmpty(list.get(0).aHM)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(",\"actionList\":[");
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().aHM);
            sb.append(StringUtil.COMMA);
        }
        int length = sb.length();
        sb.replace(length - 1, length, "]");
        return sb.toString();
    }

    private void b(final n nVar, boolean z5) {
        if (nVar == null || !aGw) {
            return;
        }
        if (z5 || ah(nVar.actionType)) {
            aGx.b(new k<n>() { // from class: com.kwad.sdk.core.report.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: It, reason: merged with bridge method [inline-methods] */
                public n Io() {
                    return nVar.Iv();
                }
            });
        } else {
            aGx.a(new k<n>() { // from class: com.kwad.sdk.core.report.g.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: It, reason: merged with bridge method [inline-methods] */
                public n Io() {
                    return nVar.Iv();
                }
            });
        }
    }

    private synchronized void checkInit() {
        try {
            if (aGw) {
                return;
            }
            com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
            if (fVar == null) {
                return;
            }
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar == null) {
                return;
            }
            Context context = fVar.getContext();
            if (context == null) {
                return;
            }
            int aO = hVar.aO(context);
            j(context, aO);
            t.init(context);
            t.IB();
            com.kwad.sdk.core.d.c.d("BatchReporter", "cache type = " + aO);
            if (aO == 2) {
                a(q.bD(context));
            }
            aGw = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public f A(List<n> list) {
        r<n, f> rVar = aGy;
        if (rVar != null) {
            return rVar.IA();
        }
        String D = D(list);
        return !TextUtils.isEmpty(D) ? new f(D) : new f(list);
    }

    private static g Is() {
        if (aGx == null) {
            synchronized (g.class) {
                try {
                    if (aGx == null) {
                        aGx = new g();
                    }
                } finally {
                }
            }
        }
        aGx.checkInit();
        return aGx;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public static void a2(@NonNull n nVar) {
        a(nVar, false);
    }

    private static boolean ah(long j6) {
        s sVar = (s) ServiceProvider.get(s.class);
        return sVar != null && sVar.ah(j6);
    }

    private g() {
    }

    public static void a(@NonNull n nVar, boolean z5) {
        Is().b(nVar, z5);
    }

    @Override // com.kwad.sdk.core.report.b
    protected final Runnable a(Context context, l<n> lVar, AtomicInteger atomicInteger) {
        u<n, f> Iy;
        r<n, f> rVar = aGy;
        return (rVar == null || (Iy = rVar.Iy()) == null) ? super.a(context, lVar, atomicInteger) : Iy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(n nVar) {
        r<n, f> rVar = aGy;
        if (rVar != null) {
            return rVar.Iz();
        }
        return (f) super.a((g) nVar);
    }
}
