package xyz.adscope.ad.download.service;

import xyz.adscope.ad.b1;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.download.service.a$a, reason: collision with other inner class name */
    public static class C1087a {

        /* renamed from: a, reason: collision with root package name */
        private final String f55095a;

        /* renamed from: b, reason: collision with root package name */
        private final String f55096b;

        /* renamed from: c, reason: collision with root package name */
        private final String f55097c;

        /* renamed from: d, reason: collision with root package name */
        private final b1 f55098d;

        /* renamed from: e, reason: collision with root package name */
        private final String f55099e;

        /* renamed from: f, reason: collision with root package name */
        private final String f55100f;

        /* renamed from: g, reason: collision with root package name */
        private final String f55101g;

        /* renamed from: h, reason: collision with root package name */
        private b f55102h;

        /* renamed from: i, reason: collision with root package name */
        private long f55103i;

        /* renamed from: j, reason: collision with root package name */
        private int f55104j;

        private String a(DownloadInfoModel downloadInfoModel) {
            return downloadInfoModel != null ? downloadInfoModel.a() : "";
        }

        private String b(DownloadInfoModel downloadInfoModel) {
            return downloadInfoModel != null ? downloadInfoModel.c() : "";
        }

        private String c(DownloadInfoModel downloadInfoModel) {
            return downloadInfoModel != null ? downloadInfoModel.f() : "";
        }

        public b1 d() {
            return this.f55098d;
        }

        public String e() {
            return this.f55097c;
        }

        public C1087a(String str, DownloadInfoModel downloadInfoModel, String str2, String str3, b1 b1Var) {
            this.f55095a = str;
            this.f55100f = b(downloadInfoModel);
            this.f55096b = str2;
            this.f55097c = str3;
            this.f55098d = b1Var;
            this.f55099e = c(downloadInfoModel);
            this.f55101g = a(downloadInfoModel);
        }

        public String a() {
            return this.f55101g;
        }

        public String b() {
            return this.f55095a;
        }

        public String c() {
            return this.f55099e;
        }

        public void a(b bVar) {
            this.f55102h = bVar;
        }

        public void a(long j6) {
            this.f55103i = j6;
        }

        public void a(int i6) {
            b bVar;
            b bVar2;
            b bVar3;
            if (this.f55104j == 16 && (bVar3 = this.f55102h) != null) {
                bVar3.a(this);
            }
            if (this.f55104j == 4 && i6 == 2 && (bVar2 = this.f55102h) != null) {
                bVar2.b(this);
            }
            if (this.f55104j == 2 && i6 == 4 && (bVar = this.f55102h) != null) {
                bVar.c(this);
            }
            this.f55104j = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(C1087a c1087a);

        void b(C1087a c1087a);

        void c(C1087a c1087a);
    }

    void a(C1087a c1087a);
}
