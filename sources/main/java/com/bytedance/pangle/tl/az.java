package com.bytedance.pangle.tl;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
final class az {

    /* renamed from: j, reason: collision with root package name */
    public static final az f25518j = new az(null, 0, null, null, null);
    public final int cw;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final int[] f25519m;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public final ArraySet<PublicKey> f25520r;

    @Nullable
    public final Signature[] up;

    @Nullable
    public final Signature[] xt;

    public az(Signature[] signatureArr, int i6, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.xt = signatureArr;
        this.cw = i6;
        this.f25520r = arraySet;
        this.up = signatureArr2;
        this.f25519m = iArr;
    }

    public static ArraySet<PublicKey> j(Signature[] signatureArr) throws CertificateException {
        Method method;
        e.a();
        ArraySet<PublicKey> a6 = d.a(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", null);
            } catch (NoSuchMethodException e6) {
                com.bytedance.sdk.openadsdk.api.m.j(e6);
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    a6.add((PublicKey) method.invoke(signature, null));
                } catch (IllegalAccessException e7) {
                    com.bytedance.sdk.openadsdk.api.m.j(e7);
                } catch (InvocationTargetException e8) {
                    com.bytedance.sdk.openadsdk.api.m.j(e8);
                } catch (Exception e9) {
                    com.bytedance.sdk.openadsdk.api.m.j(e9);
                }
            }
        }
        return a6;
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof az)) {
            return false;
        }
        az azVar = (az) obj;
        if (this.cw != azVar.cw || !j(this.xt, azVar.xt)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f25520r;
        if (arraySet != null) {
            equals = arraySet.equals(azVar.f25520r);
            if (!equals) {
                return false;
            }
        } else if (azVar.f25520r != null) {
            return false;
        }
        return Arrays.equals(this.up, azVar.up) && Arrays.equals(this.f25519m, azVar.f25519m);
    }

    public int hashCode() {
        int hashCode = ((Arrays.hashCode(this.xt) * 31) + this.cw) * 31;
        ArraySet<PublicKey> arraySet = this.f25520r;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.up)) * 31) + Arrays.hashCode(this.f25519m);
    }

    public az(Signature[] signatureArr, int i6, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i6, j(signatureArr), signatureArr2, iArr);
    }

    public az(Signature[] signatureArr, int i6) throws CertificateException {
        this(signatureArr, i6, null, null);
    }

    public static boolean j(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.r.j((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.r.j((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean j(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i6 = 0; i6 < bArr.length; i6++) {
            if (bArr[i6] != bArr2[i6]) {
                return false;
            }
        }
        return true;
    }
}
