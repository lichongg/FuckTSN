package com.kwad.components.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.components.e;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.a.g;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.br;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends e implements h {
    private String Qa;
    private long Qb;
    private String Qc;
    private Context mContext;

    private void ao(Context context) {
        c.i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("64", 0);
            if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBs)) {
                jSONObject.put("64_level", 1);
            }
            com.kwad.sdk.core.f.c.handlePolicy(jSONObject);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        com.kwad.sdk.core.f.c.a(context, new com.kwad.sdk.core.f.a() { // from class: com.kwad.components.core.f.a.1
            @Override // com.kwad.sdk.core.f.a
            public final void ar(String str) {
                c.d("initGId onSuccess", "deviceInfo：" + str);
                a.this.qc();
                a.this.ap(str);
            }

            @Override // com.kwad.sdk.core.f.a
            public final void onFailed(int i6, String str) {
                c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i6 + "errorMessage :" + str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(String str) {
        if (this.mContext == null || bp.isNullString(str) || bp.isEquals(qh(), str)) {
            return;
        }
        this.Qc = str;
        ag.ai(this.mContext, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc() {
        String cW = ag.cW(this.mContext);
        String RT = br.RT();
        if (TextUtils.isEmpty(cW)) {
            ag.ab(this.mContext, RT);
            return;
        }
        if (TextUtils.equals(cW, RT)) {
            return;
        }
        this.Qa = "";
        this.Qb = 0L;
        this.Qc = "";
        ag.Y(this.mContext, "");
        ag.d(this.mContext, this.Qb);
        ag.ai(this.mContext, this.Qc);
        ag.ab(this.mContext, RT);
    }

    private String qf() {
        if (TextUtils.isEmpty(this.Qa)) {
            this.Qa = ag.cR(this.mContext);
        }
        return this.Qa;
    }

    private long qg() {
        if (this.Qb == 0) {
            this.Qb = ag.cU(this.mContext);
        }
        return this.Qb;
    }

    private String qh() {
        if (TextUtils.isEmpty(this.Qc)) {
            this.Qc = ag.cZ(this.mContext);
        }
        return this.Qc;
    }

    @Override // com.kwad.sdk.components.h
    public final void C(long j6) {
        if (this.mContext == null || j6 <= 0 || j6 == qg()) {
            return;
        }
        this.Qb = j6;
        ag.d(this.mContext, j6);
    }

    @Override // com.kwad.sdk.components.h
    public final void aq(String str) {
        if (this.mContext == null || bp.isNullString(str) || bp.isEquals(qf(), str)) {
            return;
        }
        try {
            this.Qa = str;
            ag.Y(this.mContext, str);
            com.kwad.sdk.core.f.c.setEgid(this.mContext, str);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        try {
            this.mContext = context;
            ao(context);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }

    @Override // com.kwad.sdk.components.h
    public final g qe() {
        return new com.kwad.sdk.core.a.a();
    }

    @Override // com.kwad.sdk.components.h
    public final String qd() {
        if (!com.kwad.sdk.core.config.e.Fs() && System.currentTimeMillis() < qg() && !TextUtils.isEmpty(qf())) {
            return "";
        }
        return qh();
    }
}
