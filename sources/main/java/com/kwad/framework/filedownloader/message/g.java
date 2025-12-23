package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private final e.b aoL;
    private final List<a> aoN = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a {
        private final List<Integer> aoO = new ArrayList();
        private final Executor aoP;

        public a(int i6) {
            this.aoP = com.kwad.framework.filedownloader.f.b.r(1, "Flow-" + i6);
        }

        public final void bU(int i6) {
            this.aoO.add(Integer.valueOf(i6));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.aoP.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aoL.r(messageSnapshot);
                    try {
                        a.this.aoO.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.aoN) {
                try {
                    int id = messageSnapshot.getId();
                    Iterator<a> it = this.aoN.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a next = it.next();
                        if (next.aoO.contains(Integer.valueOf(id))) {
                            aVar = next;
                            break;
                        }
                    }
                    if (aVar == null) {
                        Iterator<a> it2 = this.aoN.iterator();
                        int i6 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            a next2 = it2.next();
                            if (next2.aoO.size() <= 0) {
                                aVar = next2;
                                break;
                            } else if (i6 == 0 || next2.aoO.size() < i6) {
                                i6 = next2.aoO.size();
                                aVar = next2;
                            }
                        }
                    }
                    if (aVar != null) {
                        aVar.bU(id);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }

    g(int i6, e.b bVar) {
        this.aoL = bVar;
        for (int i7 = 0; i7 < 5; i7++) {
            this.aoN.add(new a(i7));
        }
    }
}
