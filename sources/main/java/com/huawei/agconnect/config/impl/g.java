package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* loaded from: D:\Downloads\app\classes5.dex */
public class g implements i {

    /* renamed from: a, reason: collision with root package name */
    private final f f32942a;

    /* renamed from: b, reason: collision with root package name */
    private SecretKey f32943b;

    private SecretKey b() {
        try {
            String a6 = this.f32942a.a("/code/code1", null);
            String a7 = this.f32942a.a("/code/code2", null);
            String a8 = this.f32942a.a("/code/code3", null);
            String a9 = this.f32942a.a("/code/code4", null);
            if (a6 != null && a7 != null && a8 != null && a9 != null) {
                this.f32943b = k.a(a.b(a6), a.b(a7), a.b(a8), a.b(a9), 10000);
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f32943b = null;
        }
        return this.f32943b;
    }

    static String d(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
        }
        return "";
    }

    @Override // com.huawei.agconnect.config.impl.i
    public String a(String str, String str2) {
        if (this.f32943b == null) {
            return str2;
        }
        if (c(str)) {
            try {
                return new String(k.b(this.f32943b, a.b(d(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
            }
        }
        return str2;
    }

    g(f fVar) {
        this.f32942a = fVar;
        b();
    }

    public static boolean c(String str) {
        if (!TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str)) {
            return true;
        }
        return false;
    }
}
