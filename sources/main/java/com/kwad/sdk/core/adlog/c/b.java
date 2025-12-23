package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.aj;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private final a ayy = new a();

    public final b b(a.C0675a c0675a) {
        this.ayy.Pk = c0675a;
        return this;
    }

    public final a EM() {
        return this.ayy;
    }

    public final b aw(long j6) {
        this.ayy.yU = j6;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
        a aVar2 = this.ayy;
        if (aVar2.Pk == null) {
            aVar2.Pk = new a.C0675a();
        }
        this.ayy.Pk.a(adTemplate, str, str2, aVar);
        return this;
    }

    public final b dd(int i6) {
        this.ayy.mI = i6;
        return this;
    }

    public final b de(int i6) {
        this.ayy.axL = i6;
        return this;
    }

    public final b df(int i6) {
        this.ayy.axM = i6;
        return this;
    }

    public final b dg(int i6) {
        this.ayy.downloadSource = i6;
        return this;
    }

    public final b dh(int i6) {
        this.ayy.aye = i6;
        return this;
    }

    public final b di(int i6) {
        this.ayy.ayh = i6;
        return this;
    }

    public final b dj(int i6) {
        this.ayy.ayi = i6;
        return this;
    }

    public final b dk(int i6) {
        this.ayy.axW = i6;
        return this;
    }

    public final b dl(int i6) {
        this.ayy.ayo = i6;
        return this;
    }

    public final b dm(int i6) {
        this.ayy.ays = i6;
        return this;
    }

    public final b dn(int i6) {
        this.ayy.cW(i6);
        return this;
    }

    /* renamed from: do, reason: not valid java name */
    public final b m120do(int i6) {
        this.ayy.ayu = i6;
        return this;
    }

    public final b dp(int i6) {
        this.ayy.Pm = i6;
        return this;
    }

    public final b dq(int i6) {
        this.ayy.ayw = i6;
        return this;
    }

    public final b dr(int i6) {
        this.ayy.Pl = i6;
        return this;
    }

    public final b ds(String str) {
        this.ayy.Pj = str;
        return this;
    }

    public final b dt(String str) {
        this.ayy.ayf = str;
        return this;
    }

    public final b du(String str) {
        this.ayy.ayg = str;
        return this;
    }

    public final b dv(String str) {
        this.ayy.ayq = str;
        return this;
    }

    public final b f(aj.a aVar) {
        this.ayy.mK = aVar;
        return this;
    }

    public final b l(double d6) {
        this.ayy.mL = d6;
        return this;
    }

    public final b w(int i6, int i7) {
        this.ayy.axN = i6 + "," + i7;
        return this;
    }
}
