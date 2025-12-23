package com.kwad.sdk.i;

import androidx.annotation.WorkerThread;
import com.kwad.sdk.i.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class m {
    private static final Map<String, k> aTf = new ConcurrentHashMap();
    private static long aTg;

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void B(List<k> list) {
        synchronized (m.class) {
            if (list != null) {
                Iterator<k> it = list.iterator();
                while (it.hasNext()) {
                    aTf.remove(it.next().actionId);
                }
            }
        }
    }

    @WorkerThread
    static synchronized void a(i iVar, boolean z5) {
        synchronized (m.class) {
            try {
                Map<String, k> map = aTf;
                if (map.size() > 200) {
                    j.ak("LogRequestManger", "enqueueAction fail size limit");
                } else {
                    k b6 = b(iVar, z5);
                    map.put(b6.actionId, b6);
                }
                Nq();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static k b(i iVar, boolean z5) {
        com.kwai.adclient.kscommerciallogger.model.c Tp = (z5 ? c.a.Tn() : c.a.To()).c(BusinessType.OTHER).b(SubBusinessType.OTHER).hO("ad_sdk_local_log").hN(iVar.aSY).A(iVar.toJson()).Tp();
        return new k(Tp.Th(), Tp.toString(), iVar);
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        synchronized (m.class) {
            Map<String, k> map = aTf;
            arrayList = new ArrayList(map.size());
            Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        return arrayList;
    }

    static void Nq() {
        long currentTimeMillis = System.currentTimeMillis() - aTg;
        if (aTf.size() > 0 && currentTimeMillis > h.Nd().Nj()) {
            aTg = System.currentTimeMillis();
            final List<k> actionList = getActionList();
            actionList.size();
            j.No();
            l.a(actionList, new l.a() { // from class: com.kwad.sdk.i.m.1
                @Override // com.kwad.sdk.i.l.a
                public final void onSuccess() {
                    j.No();
                    m.B(actionList);
                }
            });
        }
    }
}
