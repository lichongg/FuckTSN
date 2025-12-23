package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0653a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.wJ() == -3) {
            Iterator<a.InterfaceC0653a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().wS().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0653a> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().wS().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.wJ()) {
            Iterator<a.InterfaceC0653a> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().wS().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() != 1) {
            return false;
        }
        return list.get(0).wS().a(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            try {
                List<a.InterfaceC0653a> bt = h.xp().bt(messageSnapshot.getId());
                if (bt.size() > 0) {
                    a wR = bt.get(0).wR();
                    if (com.kwad.framework.filedownloader.f.d.apD) {
                        com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(wR.wJ()), Byte.valueOf(messageSnapshot.wJ()), Integer.valueOf(bt.size()));
                    }
                    if (!a(bt, messageSnapshot)) {
                        StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.wJ()) + " task-count:" + bt.size());
                        for (a.InterfaceC0653a interfaceC0653a : bt) {
                            sb.append(" | ");
                            sb.append((int) interfaceC0653a.wR().wJ());
                        }
                        com.kwad.framework.filedownloader.f.d.b(this, sb.toString(), new Object[0]);
                    }
                } else {
                    com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.wJ()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
