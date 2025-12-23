package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes5.dex */
class l implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f32946a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32947b;

    private static String a(String str) {
        try {
            return "agc_" + a.c(b(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static byte[] b(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }

    @Override // com.huawei.agconnect.config.impl.f
    public String a(String str, String str2) {
        int identifier;
        String a6 = a(str);
        if (!TextUtils.isEmpty(a6) && (identifier = this.f32946a.getResources().getIdentifier(a6, ResIdentify.RES_TYPE_STRING, this.f32947b)) != 0) {
            try {
                return this.f32946a.getResources().getString(identifier);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return str2;
    }

    l(Context context, String str) {
        this.f32946a = context;
        this.f32947b = str;
    }
}
