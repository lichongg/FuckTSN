package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    @NonNull
    public final ImpInfo Rw;

    @NonNull
    public final com.kwad.components.core.request.c Xc;

    @Nullable
    public j Xd;

    @Nullable
    public List<String> Xe;
    public boolean Xf;
    public boolean Xg;

    @Nullable
    public c Xh;
    private String Xi;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    public static class C0634a {
        public ImpInfo Rw;
        public com.kwad.components.core.request.c Xc;
        public boolean Xf;
        public boolean Xg;
        public j Xj;

        public final C0634a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.Xc = cVar;
            return this;
        }

        public final C0634a aL(boolean z5) {
            this.Xf = true;
            return this;
        }

        public final C0634a a(j jVar) {
            this.Xj = jVar;
            return this;
        }

        public final C0634a aM(boolean z5) {
            this.Xg = z5;
            return this;
        }

        public final C0634a e(ImpInfo impInfo) {
            this.Rw = impInfo;
            return this;
        }

        public final a sw() {
            if (com.kwad.components.ad.f.a.oz.booleanValue() && (this.Rw == null || this.Xc == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }

    /* synthetic */ a(C0634a c0634a, byte b6) {
        this(c0634a);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z5) {
        com.kwad.sdk.commercial.d.d.a(aVar.Rw.adScene, aVar.sv(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.Xc.a(e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.aEq.msg : adResultData.testErrorMsg, z5);
        } else {
            aVar.Xc.a(adResultData, z5);
        }
    }

    private a(C0634a c0634a) {
        this.Rw = c0634a.Rw;
        this.Xc = c0634a.Xc;
        this.Xf = c0634a.Xf;
        this.Xg = c0634a.Xg;
        this.Xd = c0634a.Xj;
    }

    public final void aE(String str) {
        this.Xi = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.Rw.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.Rw.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.Rw.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final j su() {
        return this.Xd;
    }

    public final String sv() {
        return !TextUtils.isEmpty(this.Xi) ? this.Xi : "network_only";
    }

    public static void a(@NonNull a aVar, int i6, String str, boolean z5) {
        aVar.Xc.a(i6, str, z5);
        com.kwad.sdk.commercial.d.d.a(aVar.getAdStyle(), i6, str, aVar.sv());
    }
}
