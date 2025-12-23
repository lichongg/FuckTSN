package com.ss.android.socialbase.downloader.az;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.j;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.ae;
import com.ss.android.socialbase.downloader.r.av;
import com.ss.android.socialbase.downloader.r.az;
import com.ss.android.socialbase.downloader.r.ch;
import com.ss.android.socialbase.downloader.r.ed;
import com.ss.android.socialbase.downloader.r.f;
import com.ss.android.socialbase.downloader.r.g;
import com.ss.android.socialbase.downloader.r.gx;
import com.ss.android.socialbase.downloader.r.h;
import com.ss.android.socialbase.downloader.r.i;
import com.ss.android.socialbase.downloader.r.jy;
import com.ss.android.socialbase.downloader.r.kt;
import com.ss.android.socialbase.downloader.r.l;
import com.ss.android.socialbase.downloader.r.m;
import com.ss.android.socialbase.downloader.r.mi;
import com.ss.android.socialbase.downloader.r.n;
import com.ss.android.socialbase.downloader.r.oq;
import com.ss.android.socialbase.downloader.r.p;
import com.ss.android.socialbase.downloader.r.qv;
import com.ss.android.socialbase.downloader.r.rn;
import com.ss.android.socialbase.downloader.r.s;
import com.ss.android.socialbase.downloader.r.tj;
import com.ss.android.socialbase.downloader.r.tl;
import com.ss.android.socialbase.downloader.r.v;
import com.ss.android.socialbase.downloader.r.w;
import com.ss.android.socialbase.downloader.r.wq;
import com.ss.android.socialbase.downloader.r.ws;
import com.ss.android.socialbase.downloader.r.x;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private static Handler f38637j = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.ae.j j(final com.ss.android.socialbase.downloader.ae.r rVar) {
        if (rVar == null) {
            return null;
        }
        return new j.AbstractBinderC0775j() { // from class: com.ss.android.socialbase.downloader.az.ae.1
            @Override // com.ss.android.socialbase.downloader.ae.j
            public p cw() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.oq());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.ae.cw j() throws RemoteException {
                return com.ss.android.socialbase.downloader.ae.r.this.j();
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.m xt() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.m());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public v ae() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.tl());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public jy cw(int i6) throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.m(i6));
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public i g() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.g());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public int j(int i6) throws RemoteException {
                return com.ss.android.socialbase.downloader.ae.r.this.xt(m.up(i6));
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.ae m() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.r());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public qv oq() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.up());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.tl qv() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.ws());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public rn r() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.qv());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public ed tl() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.ae());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.g up() throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.cw());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public int vl() throws RemoteException {
                return com.ss.android.socialbase.downloader.ae.r.this.tj().size();
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.oq xt(int i6) throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.cw(m.up(i6)), i6 != com.ss.android.socialbase.downloader.xt.tl.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.ae.j
            public com.ss.android.socialbase.downloader.r.oq j(int i6, int i7) throws RemoteException {
                return ae.j(com.ss.android.socialbase.downloader.ae.r.this.j(m.up(i6), i7), i6 != com.ss.android.socialbase.downloader.xt.tl.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.r.oq j(final a aVar, final boolean z5) {
        if (aVar == null) {
            return null;
        }
        return new oq.j() { // from class: com.ss.android.socialbase.downloader.az.ae.12
            @Override // com.ss.android.socialbase.downloader.r.oq
            public void cw(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.cw(cwVar);
                        }
                    });
                } else {
                    a.this.cw(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public int j() throws RemoteException {
                return a.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void xt(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.xt(cwVar);
                        }
                    });
                } else {
                    a.this.xt(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void ae(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.tl(cwVar);
                        }
                    });
                } else {
                    a.this.tl(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void g(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                a aVar2 = a.this;
                if (aVar2 instanceof kt) {
                    if (z5) {
                        ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((kt) a.this).ae(cwVar);
                            }
                        });
                    } else {
                        ((kt) aVar2).ae(cwVar);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void j(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.j(cwVar);
                        }
                    });
                } else {
                    a.this.j(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void m(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.m(cwVar);
                        }
                    });
                } else {
                    a.this.m(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void r(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.r(cwVar);
                        }
                    });
                } else {
                    a.this.r(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void tl(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.g(cwVar);
                        }
                    });
                } else {
                    a.this.g(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void up(final com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.up(cwVar);
                        }
                    });
                } else {
                    a.this.up(cwVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void cw(final com.ss.android.socialbase.downloader.ae.cw cwVar, final com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.cw(cwVar, jVar);
                        }
                    });
                } else {
                    a.this.cw(cwVar, jVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void xt(final com.ss.android.socialbase.downloader.ae.cw cwVar, final com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.xt(cwVar, jVar);
                        }
                    });
                } else {
                    a.this.xt(cwVar, jVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.oq
            public void j(final com.ss.android.socialbase.downloader.ae.cw cwVar, final com.ss.android.socialbase.downloader.up.j jVar) throws RemoteException {
                if (z5) {
                    ae.f38637j.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.az.ae.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.j(cwVar, jVar);
                        }
                    });
                } else {
                    a.this.j(cwVar, jVar);
                }
            }
        };
    }

    public static p j(final h hVar) {
        if (hVar == null) {
            return null;
        }
        return new p.j() { // from class: com.ss.android.socialbase.downloader.az.ae.23
            @Override // com.ss.android.socialbase.downloader.r.p
            public void j(int i6, com.ss.android.socialbase.downloader.ae.cw cwVar, String str, String str2) throws RemoteException {
                h.this.j(i6, cwVar, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.r.p
            public boolean j(boolean z5) throws RemoteException {
                return h.this.j(z5);
            }

            @Override // com.ss.android.socialbase.downloader.r.p
            public String j() throws RemoteException {
                return h.this.j();
            }
        };
    }

    public static rn j(final wq wqVar) {
        if (wqVar == null) {
            return null;
        }
        return new rn.j() { // from class: com.ss.android.socialbase.downloader.az.ae.26
            @Override // com.ss.android.socialbase.downloader.r.rn
            public boolean cw(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                return wq.this.cw(cwVar);
            }

            @Override // com.ss.android.socialbase.downloader.r.rn
            public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                return wq.this.j(cwVar);
            }

            @Override // com.ss.android.socialbase.downloader.r.rn
            public boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                return wq.this.xt(cwVar);
            }
        };
    }

    public static ed j(final com.ss.android.socialbase.downloader.downloader.kt ktVar) {
        if (ktVar == null) {
            return null;
        }
        return new ed.j() { // from class: com.ss.android.socialbase.downloader.az.ae.27
            @Override // com.ss.android.socialbase.downloader.r.ed
            public long j(int i6, int i7) throws RemoteException {
                return com.ss.android.socialbase.downloader.downloader.kt.this.j(i6, i7);
            }
        };
    }

    public static v j(final ch chVar) {
        if (chVar == null) {
            return null;
        }
        return new v.j() { // from class: com.ss.android.socialbase.downloader.az.ae.28
            @Override // com.ss.android.socialbase.downloader.r.v
            public boolean j(f fVar) throws RemoteException {
                return ch.this.j(ae.j(fVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.r.tl j(final tj tjVar) {
        if (tjVar == null) {
            return null;
        }
        return new tl.j() { // from class: com.ss.android.socialbase.downloader.az.ae.29
            @Override // com.ss.android.socialbase.downloader.r.tl
            public Uri j(String str, String str2) throws RemoteException {
                return tj.this.j(str, str2);
            }
        };
    }

    public static x j(final f fVar) {
        if (fVar == null) {
            return null;
        }
        return new x() { // from class: com.ss.android.socialbase.downloader.az.ae.30
            @Override // com.ss.android.socialbase.downloader.r.x
            public void j(List<String> list) {
                try {
                    f.this.j(list);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.x
            public boolean j() {
                try {
                    return f.this.j();
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }
        };
    }

    public static i j(final mi miVar) {
        if (miVar == null) {
            return null;
        }
        return new i.j() { // from class: com.ss.android.socialbase.downloader.az.ae.31
            @Override // com.ss.android.socialbase.downloader.r.i
            public boolean j(long j6, long j7, av avVar) throws RemoteException {
                return mi.this.j(j6, j7, ae.j(avVar));
            }
        };
    }

    public static w j(final av avVar) {
        if (avVar == null) {
            return null;
        }
        return new w() { // from class: com.ss.android.socialbase.downloader.az.ae.2
            @Override // com.ss.android.socialbase.downloader.r.w
            public void j() {
                try {
                    av.this.j();
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.r.ae j(final az azVar) {
        if (azVar == null) {
            return null;
        }
        return new ae.j() { // from class: com.ss.android.socialbase.downloader.az.ae.3
            @Override // com.ss.android.socialbase.downloader.r.ae
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) throws RemoteException {
                az.this.j(cwVar, jVar, i6);
            }
        };
    }

    public static qv j(final l lVar) {
        if (lVar == null) {
            return null;
        }
        return new qv.j() { // from class: com.ss.android.socialbase.downloader.az.ae.4
            @Override // com.ss.android.socialbase.downloader.r.qv
            public void j(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    l.this.j(new JSONObject(str));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.qv
            public int[] xt() throws RemoteException {
                l lVar2 = l.this;
                if (lVar2 instanceof com.ss.android.socialbase.downloader.r.r) {
                    return ((com.ss.android.socialbase.downloader.r.r) lVar2).j();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.r.qv
            public String j() throws RemoteException {
                return l.this.xt();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.r.m j(final com.ss.android.socialbase.downloader.downloader.oq oqVar) {
        if (oqVar == null) {
            return null;
        }
        return new m.j() { // from class: com.ss.android.socialbase.downloader.az.ae.5
            @Override // com.ss.android.socialbase.downloader.r.m
            public int j(long j6) throws RemoteException {
                return com.ss.android.socialbase.downloader.downloader.oq.this.j(j6);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.r.g j(final s sVar) {
        if (sVar == null) {
            return null;
        }
        return new g.j() { // from class: com.ss.android.socialbase.downloader.az.ae.6
            @Override // com.ss.android.socialbase.downloader.r.g
            public boolean j() throws RemoteException {
                return s.this.j();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.ae.r j(com.ss.android.socialbase.downloader.ae.j jVar) {
        if (jVar == null) {
            return null;
        }
        try {
            com.ss.android.socialbase.downloader.ae.r rVar = new com.ss.android.socialbase.downloader.ae.r(jVar.j());
            rVar.j(j(jVar.xt())).j(j(jVar.cw())).j(j(jVar.up())).j(j(jVar.m())).j(j(jVar.oq())).j(j(jVar.ae())).j(j(jVar.g())).j(j(jVar.qv())).j(j(jVar.r())).j(j(jVar.tl()));
            com.ss.android.socialbase.downloader.xt.tl tlVar = com.ss.android.socialbase.downloader.xt.tl.MAIN;
            com.ss.android.socialbase.downloader.r.oq xt = jVar.xt(tlVar.ordinal());
            if (xt != null) {
                rVar.j(xt.hashCode(), j(xt));
            }
            com.ss.android.socialbase.downloader.xt.tl tlVar2 = com.ss.android.socialbase.downloader.xt.tl.SUB;
            com.ss.android.socialbase.downloader.r.oq xt2 = jVar.xt(tlVar2.ordinal());
            if (xt2 != null) {
                rVar.xt(xt2.hashCode(), j(xt2));
            }
            com.ss.android.socialbase.downloader.xt.tl tlVar3 = com.ss.android.socialbase.downloader.xt.tl.NOTIFICATION;
            com.ss.android.socialbase.downloader.r.oq xt3 = jVar.xt(tlVar3.ordinal());
            if (xt3 != null) {
                rVar.cw(xt3.hashCode(), j(xt3));
            }
            j(rVar, jVar, tlVar);
            j(rVar, jVar, tlVar2);
            j(rVar, jVar, tlVar3);
            j(rVar, jVar);
            return rVar;
        } catch (RemoteException e6) {
            vl.j(e6);
            return null;
        }
    }

    private static void j(com.ss.android.socialbase.downloader.ae.r rVar, com.ss.android.socialbase.downloader.ae.j jVar, com.ss.android.socialbase.downloader.xt.tl tlVar) throws RemoteException {
        SparseArray<a> sparseArray = new SparseArray<>();
        for (int i6 = 0; i6 < jVar.j(tlVar.ordinal()); i6++) {
            com.ss.android.socialbase.downloader.r.oq j6 = jVar.j(tlVar.ordinal(), i6);
            if (j6 != null) {
                sparseArray.put(j6.j(), j(j6));
            }
        }
        rVar.j(sparseArray, tlVar);
    }

    private static void j(com.ss.android.socialbase.downloader.ae.r rVar, com.ss.android.socialbase.downloader.ae.j jVar) throws RemoteException {
        for (int i6 = 0; i6 < jVar.vl(); i6++) {
            jy cw = jVar.cw(i6);
            if (cw != null) {
                rVar.j(j(cw));
            }
        }
    }

    public static h j(final p pVar) {
        if (pVar == null) {
            return null;
        }
        return new h() { // from class: com.ss.android.socialbase.downloader.az.ae.7
            @Override // com.ss.android.socialbase.downloader.r.h
            public void j(int i6, com.ss.android.socialbase.downloader.ae.cw cwVar, String str, String str2) {
                try {
                    p.this.j(i6, cwVar, str, str2);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.h
            public boolean j(boolean z5) {
                try {
                    return p.this.j(z5);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.h
            public String j() {
                try {
                    return p.this.j();
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return null;
                }
            }
        };
    }

    public static ws j(final jy jyVar) {
        if (jyVar == null) {
            return null;
        }
        return new ws() { // from class: com.ss.android.socialbase.downloader.az.ae.8
            @Override // com.ss.android.socialbase.downloader.r.ws
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws com.ss.android.socialbase.downloader.up.j {
                try {
                    jy.this.j(cwVar);
                } catch (RemoteException e6) {
                    throw new com.ss.android.socialbase.downloader.up.j(1008, e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.ws
            public boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    return jy.this.xt(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }
        };
    }

    public static jy j(final ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return new jy.j() { // from class: com.ss.android.socialbase.downloader.az.ae.9
            @Override // com.ss.android.socialbase.downloader.r.jy
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                try {
                    ws.this.j(cwVar);
                } catch (com.ss.android.socialbase.downloader.up.j e6) {
                    throw new IllegalArgumentException(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.jy
            public boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) throws RemoteException {
                return ws.this.xt(cwVar);
            }
        };
    }

    public static wq j(final rn rnVar) {
        if (rnVar == null) {
            return null;
        }
        return new wq() { // from class: com.ss.android.socialbase.downloader.az.ae.10
            @Override // com.ss.android.socialbase.downloader.r.wq
            public boolean cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    return rn.this.cw(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.wq
            public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    return rn.this.j(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.wq
            public boolean xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    return rn.this.xt(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.oq j(final com.ss.android.socialbase.downloader.r.m mVar) {
        if (mVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.oq() { // from class: com.ss.android.socialbase.downloader.az.ae.11
            @Override // com.ss.android.socialbase.downloader.downloader.oq
            public int j(long j6) {
                try {
                    return com.ss.android.socialbase.downloader.r.m.this.j(j6);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return 0;
                }
            }
        };
    }

    public static az j(final com.ss.android.socialbase.downloader.r.ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        return new az() { // from class: com.ss.android.socialbase.downloader.az.ae.13
            @Override // com.ss.android.socialbase.downloader.r.az
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
                if (cwVar == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.r.ae.this.j(cwVar, jVar, i6);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }
        };
    }

    public static l j(final qv qvVar) {
        if (qvVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.r.r() { // from class: com.ss.android.socialbase.downloader.az.ae.14
            @Override // com.ss.android.socialbase.downloader.r.l
            public void j(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    qv.this.j(jSONObject.toString());
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.l
            public String xt() {
                try {
                    return qv.this.j();
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.r
            public int[] j() {
                try {
                    return qv.this.xt();
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return null;
                }
            }
        };
    }

    public static ch j(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new ch() { // from class: com.ss.android.socialbase.downloader.az.ae.15
            @Override // com.ss.android.socialbase.downloader.r.ch
            public boolean j(x xVar) {
                try {
                    return v.this.j(ae.j(xVar));
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }
        };
    }

    public static f j(final x xVar) {
        if (xVar == null) {
            return null;
        }
        return new f.j() { // from class: com.ss.android.socialbase.downloader.az.ae.16
            @Override // com.ss.android.socialbase.downloader.r.f
            public void j(List<String> list) {
                x.this.j(list);
            }

            @Override // com.ss.android.socialbase.downloader.r.f
            public boolean j() {
                return x.this.j();
            }
        };
    }

    public static gx j(final n nVar) {
        if (nVar == null) {
            return null;
        }
        return new gx.j() { // from class: com.ss.android.socialbase.downloader.az.ae.17
            @Override // com.ss.android.socialbase.downloader.r.gx
            public void j(int i6, int i7) {
                n.this.j(i6, i7);
            }
        };
    }

    public static n j(final gx gxVar) {
        if (gxVar == null) {
            return null;
        }
        return new n() { // from class: com.ss.android.socialbase.downloader.az.ae.18
            @Override // com.ss.android.socialbase.downloader.r.n
            public void j(int i6, int i7) {
                try {
                    gx.this.j(i6, i7);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }
        };
    }

    public static mi j(final i iVar) {
        if (iVar == null) {
            return null;
        }
        return new mi() { // from class: com.ss.android.socialbase.downloader.az.ae.19
            @Override // com.ss.android.socialbase.downloader.r.mi
            public boolean j(long j6, long j7, w wVar) {
                try {
                    return i.this.j(j6, j7, ae.j(wVar));
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }
        };
    }

    public static av j(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new av.j() { // from class: com.ss.android.socialbase.downloader.az.ae.20
            @Override // com.ss.android.socialbase.downloader.r.av
            public void j() throws RemoteException {
                w.this.j();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.kt j(final ed edVar) {
        if (edVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.kt() { // from class: com.ss.android.socialbase.downloader.az.ae.21
            @Override // com.ss.android.socialbase.downloader.downloader.kt
            public long j(int i6, int i7) {
                try {
                    return ed.this.j(i6, i7);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return 0L;
                }
            }
        };
    }

    public static s j(final com.ss.android.socialbase.downloader.r.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.downloader.az.ae.22
            @Override // com.ss.android.socialbase.downloader.r.s
            public boolean j() {
                try {
                    return com.ss.android.socialbase.downloader.r.g.this.j();
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return false;
                }
            }
        };
    }

    public static tj j(final com.ss.android.socialbase.downloader.r.tl tlVar) {
        if (tlVar == null) {
            return null;
        }
        return new tj() { // from class: com.ss.android.socialbase.downloader.az.ae.24
            @Override // com.ss.android.socialbase.downloader.r.tj
            public Uri j(String str, String str2) {
                try {
                    return com.ss.android.socialbase.downloader.r.tl.this.j(str, str2);
                } catch (RemoteException e6) {
                    vl.j(e6);
                    return null;
                }
            }
        };
    }

    public static a j(final com.ss.android.socialbase.downloader.r.oq oqVar) {
        if (oqVar == null) {
            return null;
        }
        return new kt() { // from class: com.ss.android.socialbase.downloader.az.ae.25
            @Override // com.ss.android.socialbase.downloader.r.a
            public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.cw(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.j(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.xt(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.kt
            public void ae(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.g(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void g(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.tl(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void m(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.m(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void r(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.r(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void tl(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.ae(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void up(com.ss.android.socialbase.downloader.ae.cw cwVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.up(cwVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void cw(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.cw(cwVar, jVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void j(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.j(cwVar, jVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.ss.android.socialbase.downloader.r.a
            public void xt(com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
                try {
                    com.ss.android.socialbase.downloader.r.oq.this.xt(cwVar, jVar);
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }
        };
    }
}
