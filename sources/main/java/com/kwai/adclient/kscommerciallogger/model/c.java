package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private final d avM;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private final String beV;
        private BusinessType beW;
        private SubBusinessType beX;
        private d beY;
        private JSONObject beZ;
        private String bfa;
        private String mTag;
        private JSONObject msg;

        public static a Tn() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a To() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a A(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.beX = subBusinessType;
            return this;
        }

        public final a c(BusinessType businessType) {
            this.beW = businessType;
            return this;
        }

        public final a hN(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        public final a hO(@NonNull String str) {
            this.bfa = str;
            return this;
        }

        private a(@NonNull String str) {
            this.beV = str;
        }

        public final c Tp() {
            if (com.kwai.adclient.kscommerciallogger.a.Te().isDebug()) {
                if (!TextUtils.isEmpty(this.beV) && !TextUtils.isEmpty(this.mTag) && !TextUtils.isEmpty(this.bfa)) {
                    if (com.kwai.adclient.kscommerciallogger.a.Te().Tg() && !com.kwai.adclient.kscommerciallogger.b.hM(this.bfa)) {
                        throw new IllegalArgumentException("event_id format error, please check it");
                    }
                } else {
                    throw new IllegalArgumentException("param is error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.beV) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.bfa)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.Te().Tg() && !com.kwai.adclient.kscommerciallogger.b.hM(this.bfa)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.Te().Tf() != null) {
                this.beZ = com.kwai.adclient.kscommerciallogger.a.Te().Tf();
            }
            return new c(this, (byte) 0);
        }

        public final a b(d dVar) {
            this.beY = dVar;
            return this;
        }
    }

    /* synthetic */ c(a aVar, byte b6) {
        this(aVar);
    }

    private c(a aVar) {
        this.category = aVar.beV;
        this.biz = aVar.beW;
        this.subBiz = aVar.beX;
        this.tag = aVar.mTag;
        this.avM = aVar.beY;
        this.extraParam = aVar.beZ;
        this.eventId = aVar.bfa;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }

    public final String Th() {
        return this.category;
    }

    public final SubBusinessType Ti() {
        return this.subBiz;
    }

    public final d Tj() {
        return this.avM;
    }

    public final JSONObject Tk() {
        return this.msg;
    }

    public final JSONObject Tl() {
        return this.extraParam;
    }

    public final String Tm() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put("biz", businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put(CommonNetImpl.TAG, this.tag);
            d dVar = this.avM;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return jSONObject.toString();
    }
}
