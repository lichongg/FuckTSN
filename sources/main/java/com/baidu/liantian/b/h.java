package com.baidu.liantian.b;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.liantian.ac.F;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h {
    public static String a(Context context, String str, String str2, boolean z5) {
        return a(context, str, str2, z5, false);
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, false, false);
    }

    public static String a(Context context, String str, String str2, boolean z5, boolean z6) {
        byte[] bytes;
        String[] g6 = e.g(context);
        String str3 = g6[0];
        String str4 = g6[1];
        String valueOf = String.valueOf(new Date().getTime() / 1000);
        String a6 = o.a(str3 + valueOf + str4);
        byte[] a7 = com.baidu.liantian.core.i.a();
        new String(a7);
        com.baidu.liantian.b.a();
        String str5 = "";
        if (!TextUtils.isEmpty(str2)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            j.a(byteArrayInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            int length = byteArray.length;
            com.baidu.liantian.b.a();
            bytes = F.getInstance().ae(byteArray, a7);
        } else {
            bytes = "".getBytes();
        }
        int length2 = bytes.length;
        new String(bytes);
        com.baidu.liantian.b.a();
        byte[] bytes2 = o.a(g.a(context)).getBytes();
        new String(bytes2);
        com.baidu.liantian.b.a();
        byte[] re = F.getInstance().re(a7, bytes2);
        int length3 = re.length;
        com.baidu.liantian.b.a();
        String encodeToString = Base64.encodeToString(re, 0);
        com.baidu.liantian.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/150/");
        sb.append(str3);
        sb.append("/");
        sb.append(valueOf);
        sb.append("/");
        sb.append(a6);
        if (!TextUtils.isEmpty(encodeToString)) {
            sb.append("?skey=");
            sb.append(URLEncoder.encode(encodeToString, "utf-8"));
        }
        com.baidu.liantian.b.a();
        try {
            if (z6) {
                str5 = new m(context).a(sb.toString());
            } else {
                str5 = new m(context).a(sb.toString(), bytes);
            }
        } catch (Throwable unused) {
            e.a();
        }
        com.baidu.liantian.b.a();
        if (z5 && TextUtils.isEmpty(str5)) {
            try {
                com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = eVar.f10457a.getLong("pu_cl_fd", 0L);
                if (j6 == 0) {
                    j6 = System.currentTimeMillis();
                    eVar.j();
                }
                if (currentTimeMillis - j6 > 86400000) {
                    HashMap hashMap = new HashMap();
                    if (e.e(context)) {
                        hashMap.put("0", Integer.valueOf(eVar.l() + 1));
                        hashMap.put("1", Integer.valueOf(eVar.m()));
                    } else {
                        hashMap.put("0", Integer.valueOf(eVar.l()));
                        hashMap.put("1", Integer.valueOf(eVar.m() + 1));
                    }
                    eVar.f10459c.putInt("mo_fa_pu_cl", 0);
                    eVar.f10459c.commit();
                    eVar.f10459c.putInt("wi_fa_pu_cl", 0);
                    eVar.f10459c.commit();
                    eVar.j();
                    e.a(context, "1003112", hashMap);
                } else if (e.e(context)) {
                    eVar.a(eVar.l() + 1);
                } else {
                    eVar.b(eVar.m() + 1);
                }
            } catch (Throwable unused2) {
                e.a();
            }
            throw new NetworkErrorException("response is empty");
        }
        JSONObject jSONObject = new JSONObject(str5);
        String optString = jSONObject.optString("skey");
        com.baidu.liantian.b.a();
        byte[] decode = Base64.decode(optString, 0);
        int length4 = decode.length;
        com.baidu.liantian.b.a();
        byte[] rd = F.getInstance().rd(decode, bytes2);
        new String(rd);
        com.baidu.liantian.b.a();
        String optString2 = jSONObject.optString("response");
        jSONObject.optString("request_id");
        com.baidu.liantian.b.a();
        com.baidu.liantian.b.a();
        byte[] decode2 = Base64.decode(optString2, 0);
        int length5 = decode2.length;
        com.baidu.liantian.b.a();
        byte[] ad = F.getInstance().ad(decode2, rd);
        if (decode2.length > 0 && (ad == null || ad.length == 0)) {
            e.k(context);
            throw new NetworkErrorException("aes is fail");
        }
        return new String(ad);
    }

    public static boolean a(Context context) {
        PackageInfo packageInfo;
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pkg", packageName);
            PackageManager packageManager = context.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 64);
            } catch (Throwable unused) {
                e.a();
                packageInfo = null;
            }
            if (packageInfo != null) {
                PublicKey a6 = e.a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a6 != null) {
                    byte[] encoded = a6.getEncoded();
                    if (encoded != null) {
                        e.a(context, encoded);
                        jSONObject.put("sign", o.a(Base64.encodeToString(encoded, 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\r", "")));
                        com.baidu.liantian.b.a();
                    }
                } else {
                    jSONObject.put("sign", "");
                }
                jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, e.e(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
            } else {
                jSONObject.put("sign", "");
                jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.liantian.b.a();
            String a7 = a(context, e.b() + "p/1/auh", jSONObject2, false);
            com.baidu.liantian.b.a();
            JSONObject jSONObject3 = new JSONObject(a7);
            if (jSONObject3.length() <= 0) {
                return false;
            }
            int optInt = jSONObject3.optInt("code");
            com.baidu.liantian.b.a();
            if (optInt != 200) {
                return false;
            }
            String optString = jSONObject3.optString(SocializeProtocolConstants.PROTOCOL_KEY_AK);
            String optString2 = jSONObject3.optString("sk");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return false;
            }
            com.baidu.liantian.core.d a8 = com.baidu.liantian.core.d.a(context);
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && (!e.f10345d.equals(optString) || !e.f10346e.equals(optString2))) {
                    e.a(optString, optString2);
                    com.baidu.liantian.e eVar = a8.f10408a;
                    eVar.f10459c.putString("svi_n", optString + "-" + optString2);
                    eVar.f10459c.commit();
                }
            } catch (Throwable unused2) {
                e.a();
            }
            return true;
        } catch (Throwable th) {
            th.toString();
            com.baidu.liantian.b.a();
            e.a();
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i6 = 0; i6 < 256; i6++) {
            bArr3[i6] = (byte) i6;
        }
        if (bArr2 == null || bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < 256; i9++) {
                int i10 = bArr2[i7] & 255;
                byte b6 = bArr3[i9];
                i8 = (i10 + (b6 & 255) + i8) & 255;
                bArr3[i9] = bArr3[i8];
                bArr3[i8] = b6;
                i7 = (i7 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < bArr.length; i13++) {
            i11 = (i11 + 1) & 255;
            byte b7 = bArr3[i11];
            i12 = ((b7 & 255) + i12) & 255;
            bArr3[i11] = bArr3[i12];
            bArr3[i12] = b7;
            int i14 = ((bArr3[i11] & 255) + (b7 & 255)) & 255;
            byte b8 = (byte) (bArr3[i14] ^ bArr[i13]);
            bArr4[i13] = b8;
            bArr4[i13] = (byte) (b8 ^ 42);
        }
        return bArr4;
    }
}
