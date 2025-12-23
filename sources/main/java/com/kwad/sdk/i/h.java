package com.kwad.sdk.i;

import android.text.TextUtils;
import com.kwad.sdk.i.e;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h {
    private static final AtomicBoolean aSP = new AtomicBoolean(false);
    private static final float avu = new Random().nextFloat();
    private final AtomicBoolean aSO;
    private d aSQ;
    private g aSR;
    private List<i> aSS;
    private f aST;
    private final AtomicBoolean mHasInit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        private static final h aSW = new h(0);
    }

    /* synthetic */ h(byte b6) {
        this();
    }

    private void b(final i iVar) {
        d dVar = this.aSQ;
        if (dVar == null || j.L(dVar.aSB) || this.aSR == null || this.aST == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.i.h.1
            @Override // com.kwad.sdk.i.n
            public final void doTask() {
                h hVar = h.this;
                e a6 = hVar.a(hVar.aSQ, iVar);
                if (a6 == null) {
                    return;
                }
                iVar.n(a6.avY);
                m.a(iVar, a6.aSC == 2);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.aOc;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aSR.getSdkVersion(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void Nf() {
        this.aSO.set(true);
    }

    public final synchronized void Ng() {
        this.aSO.set(false);
    }

    private h() {
        this.mHasInit = new AtomicBoolean(false);
        this.aSO = new AtomicBoolean(false);
    }

    private void Nk() {
        List<i> list = this.aSS;
        if (list == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.aSS.clear();
        this.aSS = null;
    }

    private boolean d(e.b bVar) {
        String androidId = this.aSR.getAndroidId();
        String deviceId = this.aSR.getDeviceId();
        String imei = this.aSR.getImei();
        String oaid = this.aSR.getOaid();
        List<String> list = bVar.aSK;
        if (j.L(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(str, androidId) || TextUtils.equals(str, deviceId) || TextUtils.equals(str, imei) || TextUtils.equals(str, oaid)) {
                return true;
            }
        }
        return false;
    }

    public final void Ne() {
        if (!this.mHasInit.get() || this.aSQ == null) {
            return;
        }
        j.No();
        m.Nq();
    }

    public final g Nh() {
        return this.aSR;
    }

    public final f Ni() {
        return this.aST;
    }

    public final long Nj() {
        return this.aSQ.MW();
    }

    public static h Nd() {
        return a.aSW;
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.aOb;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aSR.getAppId(), it.next())) {
                return true;
            }
        }
        return false;
    }

    private static d gi(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                d dVar = new d();
                dVar.parseJson(jSONObject);
                return dVar;
            }
            return null;
        } catch (Throwable unused) {
            j.Nn();
            return null;
        }
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            j.No();
            this.aSR = gVar;
            this.aST = fVar;
            this.aSQ = gi(str);
            this.mHasInit.set(true);
            Nk();
        } catch (Throwable unused) {
            aSP.set(true);
            j.Nn();
        }
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aSO.get()) {
                    j.No();
                    return;
                }
                i gl = i.Nm().gj(str).gk(str2).gl(str3);
                if (this.mHasInit.get()) {
                    b(gl);
                } else if (!aSP.get()) {
                    j.No();
                    a(gl);
                }
            }
        } catch (Throwable unused) {
            j.Nn();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.aSH;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.aSG;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private void a(i iVar) {
        if (this.aSS == null) {
            this.aSS = new CopyOnWriteArrayList();
        }
        this.aSS.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.aSB;
        if (j.L(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.aSD) && a(eVar.aSE, iVar)) {
                double d6 = eVar.avY;
                if (d6 > 0.0d && avu <= d6) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.aSL != e.b.aSI) {
            return bVar.MX();
        }
        bVar.bK(b(bVar) && c(bVar) && d(bVar));
        return bVar.MX();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.aSX) && b(aVar, iVar.aSY) && c(aVar, iVar.aSZ);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.aSF;
        if (j.L(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }
}
