package com.kwad.sdk.core.adlog.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public long PL;
    public String Pj;
    public a.C0675a Pk;
    public int To;

    @NonNull
    public AdTemplate adTemplate;
    public int adnMaterialType;
    public String adnMaterialUrl;
    public String adnName;
    public int adnType;
    public int awx;
    public JSONObject axI;
    public int axJ;
    public int axK;
    public int axL;
    public int axM;
    public String axN;
    public String axR;
    public String axS;
    public String axT;
    public int axU;
    public int axV;
    public int axX;
    public String axY;
    public int axZ;
    public int aya;
    public String ayc;
    public int ayd;
    public int aye;
    public String ayf;
    public String ayg;
    public int ayh;
    public int ayi;
    public long ayj;
    public long ayk;
    public int ayn;
    public int ayo;
    public String ayq;
    public int ays;
    public int ayt;
    public int ayu;
    public int ayv;
    public String ayx;
    public int downloadSource;
    public int mI;
    public aj.a mK;
    public double mL;
    public long yU;
    public long axO = -1;
    public int axP = -1;
    public long axQ = -1;
    public int axW = -1;
    public int Pl = 0;
    public String ayb = "";
    public int ayl = -1;
    public int aym = -1;
    public int downloadStatus = 0;
    public int ayp = -1;
    public int Pi = -1;
    public int ayr = -1;
    public int adxResult = -1;
    public int Pm = -1;
    public int ayw = 0;

    public final void a(@Nullable h hVar) {
        if (hVar != null) {
            this.ayx = hVar.Iu();
        }
    }

    public final void cW(int i6) {
        if (i6 == 0) {
            this.ayt = 1;
        } else if (i6 == 1) {
            this.ayt = 2;
        } else {
            if (i6 != 2) {
                return;
            }
            this.ayt = 3;
        }
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0675a c0675a = this.Pk;
        if (c0675a == null) {
            a.C0675a c0675a2 = new a.C0675a();
            this.Pk = c0675a2;
            c0675a2.a(adTemplate, null, null, null);
        } else if (c0675a.axk == null) {
            c0675a.a(adTemplate, null, null, null);
        }
    }

    public static a EK() {
        return new a();
    }

    public final a.C0675a EL() {
        return this.Pk;
    }

    public final a a(a.C0675a c0675a) {
        this.Pk = c0675a;
        return this;
    }

    public final a au(long j6) {
        this.yU = j6;
        return this;
    }

    public final a av(long j6) {
        this.PL = j6;
        return this;
    }

    public final a cX(int i6) {
        this.mI = i6;
        return this;
    }

    public final a cY(int i6) {
        this.Pl = i6;
        return this;
    }

    public final a cZ(int i6) {
        this.Pm = i6;
        return this;
    }

    public final a da(int i6) {
        this.Pi = i6;
        return this;
    }

    public final a db(int i6) {
        this.To = i6;
        return this;
    }

    public final a dc(int i6) {
        this.ayd = i6;
        return this;
    }

    public final a dr(String str) {
        this.Pj = str;
        return this;
    }

    public final a e(aj.a aVar) {
        this.mK = aVar;
        return this;
    }
}
