package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.h;
import com.umeng.analytics.pro.bi;
import java.io.File;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class s {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements f<a.C0668a> {
        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0668a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        Objects.toString(bVar);
                        if (bVar.isLegal()) {
                            cVar.j(bVar.atE);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.aW(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c<T> {
        void j(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements f<a.C0668a> {
        f<a.C0668a> auH;

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0668a> cVar) {
            this.auH.a(abVar, new a<a.C0668a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                @WorkerThread
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(@NonNull a.C0668a c0668a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        l.a(c0668a);
                        file = j.s(abVar.getContext(), c0668a.sdkVersion);
                        k.c(c0668a.atC, file);
                        l.a(c0668a, System.currentTimeMillis() - currentTimeMillis);
                        c0668a.atD = file;
                        cVar.j(c0668a);
                    } catch (Throwable th) {
                        l.a(c0668a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        j.j(file);
                    }
                }
            });
        }

        d(f<a.C0668a> fVar) {
            this.auH = fVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements f<Boolean> {
        f<a.C0668a> auH;

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.auH.a(abVar, new c<a.C0668a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                private void a(a.C0668a c0668a, int i6, Throwable th) {
                    j.j(c0668a.atD);
                    l.b(c0668a, i6, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(@NonNull a.C0668a c0668a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0668a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), AnonymousClass1.class.getClassLoader(), c0668a.atD.getPath(), c0668a.sdkVersion)) {
                            a(c0668a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.q(abVar.getContext(), c0668a.sdkVersion);
                        j.j(c0668a.atD);
                        l.b(c0668a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.j(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0668a, 2, th);
                    }
                }
            });
        }

        e(f<a.C0668a> fVar) {
            this.auH = fVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g implements f<a.C0668a> {
        f<a.C0668a> auH;

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<a.C0668a> cVar) {
            this.auH.a(abVar, new a<a.C0668a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                private void a(a.C0668a c0668a, int i6, Throwable th) {
                    j.j(c0668a.atD);
                    l.a(c0668a, i6, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(@NonNull a.C0668a c0668a) {
                    try {
                        File file = c0668a.atD;
                        if (!x.k(file)) {
                            a(c0668a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (x.a(file, c0668a.md5)) {
                            cVar.j(c0668a);
                        } else {
                            a(c0668a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0668a, 3, th);
                    }
                }
            });
        }

        g(f<a.C0668a> fVar) {
            this.auH = fVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h implements f<a.C0668a> {
        f<a.C0668a> auH;

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0668a> cVar) {
            this.auH.a(abVar, new c<a.C0668a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(a.C0668a c0668a) {
                    String aX = i.aX(abVar.getContext());
                    if (TextUtils.isEmpty(aX)) {
                        aX = com.kwad.sdk.api.c.Dd().getSDKVersion();
                    }
                    String str = c0668a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), bi.aX, c0668a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0668a.Dj()) {
                        aa.be(abVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + aX);
                        return;
                    }
                    if (i.L(c0668a.sdkVersion, aX) && c0668a.Di()) {
                        cVar.j(c0668a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0668a.sdkVersion + " currentDynamicVersion:" + aX + " dynamicType:" + c0668a.atB);
                }
            });
        }

        h(f<a.C0668a> fVar) {
            this.auH = fVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class a<T> implements c<T> {
        c<T> auD;

        a(c<T> cVar) {
            this.auD = cVar;
        }
    }

    static f<Boolean> Ds() {
        return new e(new g(new d(new h(new b()))));
    }
}
