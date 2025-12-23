package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.d.a;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements com.kwad.sdk.service.a.a {
        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.service.a.a
        public final void h(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.e.d.a.a(new a.C0616a(context).aB(adTemplate).as(true));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements com.kwad.sdk.service.a.f {
        private b() {
        }

        /* synthetic */ b(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject Bt() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getBodyParams();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Map<String, String> Bu() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getHeader();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean aR(AdTemplate adTemplate) {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            return aVar != null && aVar.wo();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean qt() {
            com.kwad.components.core.o.a.a.a aVar = (com.kwad.components.core.o.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.a.a.class);
            if (aVar != null) {
                return aVar.qt();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean qu() {
            com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
            if (aVar != null) {
                return aVar.qu();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.response.b.g wp() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.wp();
            }
            return null;
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Bk() {
            return l.Cf().Bk();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Bl() {
            return l.Cf().Bl();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Bm() {
            return l.Cf().Bm();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Bn() {
            return l.Cf().Bn();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String Bo() {
            return com.kwad.sdk.kgeo.a.Bo();
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.b Bp() {
            return com.kwad.sdk.kgeo.a.MS();
        }

        @Override // com.kwad.sdk.service.a.f
        public final List<AdTemplate> Bq() {
            return com.kwad.sdk.core.download.b.GR().Bq();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String Br() {
            return h.AP();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject Bs() {
            return com.kwad.components.core.p.a.se().m("", "").toJson();
        }

        @Override // com.kwad.sdk.service.a.f
        public final void a(String str, Map<String, String> map, String str2) {
            com.kwad.sdk.core.a.d.a(str, map, str2);
        }

        @Override // com.kwad.sdk.service.a.f
        public final String as(String str) {
            return com.kwad.sdk.core.a.d.as(str);
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getApiVersion() {
            return l.Cf().getApiVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final int getApiVersionCode() {
            return l.Cf().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppName() {
            return ServiceProvider.getAppName();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Context getContext() {
            return ServiceProvider.getContext();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getSDKVersion() {
            l.Cf();
            return l.getSDKVersion();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements com.kwad.sdk.service.a.h {
        private c() {
        }

        /* synthetic */ c(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BM() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBo);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BN() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBp);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BO() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBq);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String BS() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBy);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BT() {
            return com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBC);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BU() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.azU);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String BV() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.azV);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String BW() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBI);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BX() {
            return com.kwad.sdk.core.config.c.aBO.getValue().booleanValue();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int BY() {
            return com.kwad.sdk.core.config.c.aBP.getValue().intValue();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Bw() {
            return com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.azH);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String BA() {
            return com.kwad.sdk.core.config.e.BA();
        }

        @Override // com.kwad.sdk.service.a.h
        public final List<String> BB() {
            return com.kwad.sdk.core.config.e.BB();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BC() {
            return com.kwad.sdk.core.config.e.BC();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BD() {
            return com.kwad.sdk.core.config.e.BD();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BE() {
            return com.kwad.sdk.core.config.e.BE();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BF() {
            return com.kwad.sdk.core.config.e.FB();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BG() {
            return com.kwad.sdk.core.config.e.BG();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BH() {
            return com.kwad.sdk.core.config.e.BH();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int BI() {
            return com.kwad.sdk.core.config.e.BI();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int BJ() {
            return com.kwad.sdk.core.config.e.BJ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final double BK() {
            return com.kwad.sdk.core.config.e.BK();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BL() {
            return com.kwad.sdk.core.config.e.BL();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BP() {
            return com.kwad.sdk.core.config.e.BP();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int BQ() {
            return com.kwad.sdk.core.config.e.BQ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BR() {
            return com.kwad.sdk.core.config.e.BR();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean BZ() {
            return com.kwad.sdk.core.config.e.BZ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Bv() {
            return com.kwad.sdk.core.config.e.Bv();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Bx() {
            return com.kwad.sdk.core.config.e.Bx();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean By() {
            return com.kwad.sdk.core.config.e.By();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String Bz() {
            return com.kwad.sdk.core.config.e.Bz();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int Ca() {
            return com.kwad.sdk.core.config.e.Ca();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int aO(Context context) {
            return com.kwad.sdk.core.config.item.c.bt(context);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean ai(long j6) {
            return com.kwad.sdk.core.config.e.ai(j6);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean cg(String str) {
            return com.kwad.sdk.core.config.a.cg(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int ch(String str) {
            return com.kwad.sdk.core.config.e.ch(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int ci(String str) {
            return com.kwad.sdk.core.config.e.ci(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final <T> T getAppConfigData(T t5, com.kwad.sdk.g.b<JSONObject, T> bVar) {
            return (T) com.kwad.sdk.core.config.e.Fw().getAppConfigData(null, bVar);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.e.getUserAgent();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zx() {
            return com.kwad.sdk.core.config.e.zx();
        }
    }

    public static void Be() {
        byte b6 = 0;
        ServiceProvider.put(com.kwad.sdk.service.a.f.class, new b(b6));
        ServiceProvider.put(com.kwad.sdk.service.a.h.class, new c(b6));
        ServiceProvider.put(com.kwad.sdk.service.a.e.class, new com.kwad.sdk.service.a.e() { // from class: com.kwad.sdk.j.1
            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.c cVar) {
                com.kwad.components.core.d.a.a(new a.b() { // from class: com.kwad.sdk.j.1.1
                    @Override // com.kwad.components.core.d.a.b
                    public final String getKey() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.components.core.d.a.b
                    public final JSONObject getValue() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getValue();
                        }
                        return null;
                    }
                });
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.g gVar) {
                com.kwad.components.core.d.a.a(new a.c() { // from class: com.kwad.sdk.j.1.2
                    @Override // com.kwad.components.core.d.a.c
                    public final void onCrashOccur(int i6, String str) {
                        com.kwad.sdk.service.a.g gVar2 = gVar;
                        if (gVar2 != null) {
                            gVar2.l(i6, str);
                        }
                    }
                });
            }

            @Override // com.kwad.sdk.service.a.e
            public final void H(String str, String str2) {
                com.kwad.components.core.d.a.j(str, str2);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void gatherException(Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.d.class, new com.kwad.sdk.service.a.d() { // from class: com.kwad.sdk.j.2
            @Override // com.kwad.sdk.service.a.d
            public final void a(boolean z5, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.b.a.GP().dG(str);
            }

            @Override // com.kwad.sdk.service.a.d
            public final File cf(String str) {
                return com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.j.class, new com.kwad.sdk.service.a.j() { // from class: com.kwad.sdk.j.3
            @Override // com.kwad.sdk.service.a.j
            public final int sA() {
                com.kwad.components.core.q.b.sy();
                return com.kwad.components.core.q.b.sA();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int sB() {
                return com.kwad.components.core.q.b.sy().sB();
            }

            @Override // com.kwad.sdk.service.a.j
            public final boolean sz() {
                com.kwad.components.core.q.b.sy();
                return com.kwad.components.core.q.b.sz();
            }

            @Override // com.kwad.sdk.service.a.j
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.q.b.sy();
                return com.kwad.components.core.q.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.network.k.class, new com.kwad.sdk.core.network.k() { // from class: com.kwad.sdk.j.4
            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.j jVar) {
                com.kwad.sdk.commercial.b.b(jVar);
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.i iVar) {
                com.kwad.sdk.commercial.b.b(iVar);
            }

            @Override // com.kwad.sdk.core.network.k
            public final com.kwad.sdk.core.b Bf() {
                return com.kwad.components.core.request.model.b.sx();
            }
        });
        ImageLoaderProxy imageLoaderProxy = ImageLoaderProxy.INSTANCE;
        ServiceProvider.put(com.kwad.sdk.service.a.i.class, imageLoaderProxy);
        int a6 = com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBc);
        if (a6 > 0) {
            imageLoaderProxy.setCacheSize(a6);
        }
        ServiceProvider.put(com.kwad.sdk.service.a.b.class, new com.kwad.sdk.service.a.b() { // from class: com.kwad.sdk.j.5
            @Override // com.kwad.sdk.service.a.b
            public final void I(String str, String str2) {
                com.kwad.sdk.core.d.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void Bg() {
                com.kwad.components.core.p.a.se().az(ServiceProvider.getContext());
            }

            @Override // com.kwad.sdk.service.a.b
            public final void aQ(AdTemplate adTemplate) {
                com.kwad.components.core.p.a.se().f(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void e(@NonNull JSONObject jSONObject, int i6) {
                com.kwad.components.core.p.a.se().e(jSONObject, i6);
            }
        });
        ServiceProvider.put(s.class, new s() { // from class: com.kwad.sdk.j.6
            @Override // com.kwad.sdk.core.report.s
            public final boolean ah(long j6) {
                p pVar = com.kwad.sdk.core.config.c.azu;
                return p.ah(j6);
            }

            @Override // com.kwad.sdk.core.report.s
            public final int wm() {
                com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
                if (aVar != null) {
                    return aVar.wm();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.s
            public final int Bh() {
                return com.kwad.sdk.core.config.e.Bh();
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.video.a.f.class, new com.kwad.sdk.core.video.a.f() { // from class: com.kwad.sdk.j.7
            @Override // com.kwad.sdk.core.video.a.f
            public final boolean wn() {
                return ((com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class)).wn();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean Bi() {
                return com.kwad.sdk.core.config.e.Bi();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean Bj() {
                return com.kwad.sdk.core.config.e.Bj();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.b.b.class, new com.kwad.sdk.utils.b.b() { // from class: com.kwad.sdk.j.8
            @Override // com.kwad.sdk.utils.b.b
            public final void a(com.kwad.sdk.utils.b.a aVar) {
                if (aVar == null) {
                    return;
                }
                com.kwad.sdk.commercial.b.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.a.class, new a(b6));
    }
}
