package com.bytedance.msdk.up;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bi;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private static volatile tl f25318j;
    private Cipher cw;
    private Key xt;

    public static tl j() {
        if (f25318j == null) {
            synchronized (tl.class) {
                try {
                    if (f25318j == null) {
                        f25318j = new tl();
                    }
                } finally {
                }
            }
        }
        return f25318j;
    }

    private tl() {
        try {
            this.xt = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.xt.xt().z(), 0)));
            this.cw = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public String j(byte[] bArr) throws Exception {
        byte[] doFinal;
        if (bArr == null) {
            return null;
        }
        if (this.cw == null) {
            this.xt = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.xt.xt().z(), 0)));
            this.cw = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        this.cw.init(1, this.xt);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = length - i6;
            if (i8 > 0) {
                if (i8 > 117) {
                    doFinal = this.cw.doFinal(bArr, i6, 117);
                } else {
                    doFinal = this.cw.doFinal(bArr, i6, i8);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i7++;
                i6 = i7 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    public String j(com.bytedance.msdk.xt.cw cwVar) {
        if (cwVar == null || MediationConstant.ADN_PANGLE.equals(cwVar.ff())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(cwVar.zs())) {
                jSONObject.putOpt(bi.aL, cwVar.zs());
            }
            if (!TextUtils.isEmpty(cwVar.qg())) {
                jSONObject.putOpt("d", cwVar.qg());
            }
            jSONObject.putOpt("e", String.valueOf(cwVar.t()));
            if (!TextUtils.isEmpty(cwVar.ln())) {
                jSONObject.putOpt("an", cwVar.ln());
            }
            if (!TextUtils.isEmpty(cwVar.xp())) {
                jSONObject.putOpt("aun", cwVar.xp());
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        try {
            return j(jSONObject.toString().getBytes());
        } catch (Exception e7) {
            vl.j(e7);
            return null;
        }
    }
}
