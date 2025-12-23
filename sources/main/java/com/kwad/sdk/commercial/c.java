package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public double avH = 0.01d;
    public double avI = 1.0d;
    public double avJ = 0.001d;
    public BusinessType avK = BusinessType.OTHER;
    public SubBusinessType avL = SubBusinessType.OTHER;
    public com.kwai.adclient.kscommerciallogger.model.d avM;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;

    public final c a(SubBusinessType subBusinessType) {
        this.avL = subBusinessType;
        return this;
    }

    public static c DS() {
        return new c();
    }

    public final c O(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final c a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
        this.avM = dVar;
        return this;
    }

    public final c b(BusinessType businessType) {
        this.avK = businessType;
        return this;
    }

    public final c cF(String str) {
        this.category = str;
        return this;
    }

    public final c cG(String str) {
        this.tag = str;
        return this;
    }

    @Deprecated
    public final c h(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }

    public final c i(double d6) {
        this.avH = d6;
        return this;
    }

    public final c j(double d6) {
        this.avI = d6;
        return this;
    }

    @NonNull
    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.avK + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }

    private c() {
    }

    public final c z(com.kwad.sdk.commercial.c.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    public final c k(double d6) {
        this.avJ = 0.001d;
        return this;
    }
}
