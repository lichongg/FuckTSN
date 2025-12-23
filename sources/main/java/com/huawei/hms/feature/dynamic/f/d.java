package com.huawei.hms.feature.dynamic.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33250a = "SignVerifier";

    /* renamed from: b, reason: collision with root package name */
    public static final String f33251b = "com.huawei.hms.fingerprint_signature";

    /* renamed from: c, reason: collision with root package name */
    public static final String f33252c = "com.huawei.hms.sign_certchain";

    public static String a(PackageInfo packageInfo) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length == 0) {
            Logger.e(f33250a, "Failed to get application signature certificate fingerprint.");
            return null;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return b.b(a(byteArray), true);
    }

    public static boolean b(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "The context is null or module path is invalid.";
        } else if (!a(str)) {
            str2 = "The module file is in wrong format.";
        } else {
            if (a(context, str)) {
                return true;
            }
            str2 = "check signature failed.";
        }
        Logger.e(f33250a, str2);
        return false;
    }

    public static boolean a(Context context, String str) {
        String str2;
        ApplicationInfo applicationInfo;
        StringBuilder sb;
        String str3;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 192);
        if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
            str2 = "PackageArchiveInfo is null.";
        } else {
            String str4 = packageArchiveInfo.packageName;
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                sb = new StringBuilder();
                sb.append("Verify package ");
                sb.append(str4);
                str3 = " failed for metadata is null.";
            } else if (!bundle.containsKey(f33251b)) {
                sb = new StringBuilder();
                sb.append("Verify package ");
                sb.append(str4);
                str3 = " failed for no signer.";
            } else if (bundle.containsKey(f33252c)) {
                String a6 = a(packageArchiveInfo);
                if (TextUtils.isEmpty(a6)) {
                    str2 = "Get PackageSignature failed: null.";
                } else {
                    if (a(bundle.getString(f33251b), bundle.getString(f33252c), str4 + ContainerUtils.FIELD_DELIMITER + a6)) {
                        Logger.i(f33250a, "verify signature with cert chain success.");
                        return true;
                    }
                    str2 = "Check CertChain failed.";
                }
            } else {
                sb = new StringBuilder();
                sb.append("Verify package ");
                sb.append(str4);
                str3 = " failed for no cert chain.";
            }
            sb.append(str3);
            str2 = sb.toString();
        }
        Logger.e(f33250a, str2);
        return false;
    }

    public static boolean a(String str) {
        String str2;
        try {
            new ZipFile(str).close();
            return true;
        } catch (ZipException unused) {
            str2 = "Check module file ZipException: not a valid zip.";
            Logger.w(f33250a, str2);
            return false;
        } catch (IOException unused2) {
            str2 = "Check module file IOException";
            Logger.w(f33250a, str2);
            return false;
        }
    }

    public static boolean a(String str, String str2, String str3) {
        String str4;
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str4 = "Args is invalid.";
        } else {
            List<X509Certificate> b6 = e.b(str2);
            if (b6.size() == 0) {
                str4 = "CertChain is empty.";
            } else if (e.a(e.a(), b6)) {
                X509Certificate x509Certificate = b6.get(0);
                if (!e.a(x509Certificate, "Huawei CBG HMS Kit")) {
                    str4 = "CN is invalid";
                } else if (e.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                    try {
                        bArr = str3.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e6) {
                        Logger.e(f33250a, "checkCertChain UnsupportedEncodingException:", e6);
                        bArr = null;
                    }
                    if (e.a(x509Certificate, bArr, a.a(str))) {
                        return true;
                    }
                    str4 = "signature is invalid: ";
                } else {
                    str4 = "OU is invalid";
                }
            } else {
                str4 = "failed to verify cert chain";
            }
        }
        Logger.e(f33250a, str4);
        return false;
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e6) {
            Logger.e(f33250a, "NoSuchAlgorithmException" + e6.getMessage());
            return new byte[0];
        }
    }
}
