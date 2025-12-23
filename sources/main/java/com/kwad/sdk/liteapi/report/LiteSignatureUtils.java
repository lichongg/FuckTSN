package com.kwad.sdk.liteapi.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.FileUtils;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import com.kwad.sdk.liteapi.utils.LiteMd5Util;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteSignatureUtils {
    private static final int BUFFER_SIZE = 4096;
    private static String TAG = "LiteSignatureUtils";
    public static Signature[] currentSignatures = new Signature[0];

    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] getArchiveSignatures(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null) {
            return null;
        }
        return packageArchiveInfo.signatures;
    }

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] getSignatures(Context context) {
        Signature[] signatureArr = currentSignatures;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(context, context.getPackageName(), 64);
        if (packageInfo != null) {
            currentSignatures = packageInfo.signatures;
        }
        return currentSignatures;
    }

    public static boolean isSignaturesSame(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, signatureArr);
        HashSet hashSet2 = new HashSet();
        Collections.addAll(hashSet2, signatureArr2);
        return hashSet.equals(hashSet2);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:28), block:B:22:0x001b */
    private static Certificate[] loadCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                do {
                    try {
                    } catch (IOException e6) {
                        e = e6;
                        LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                        LiteApiLogger.w(TAG, e);
                        FileUtils.closeQuietly(bufferedInputStream);
                        return null;
                    } catch (RuntimeException e7) {
                        e = e7;
                        LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                        LiteApiLogger.w(TAG, e);
                        FileUtils.closeQuietly(bufferedInputStream);
                        return null;
                    }
                } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
                Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
                FileUtils.closeQuietly(bufferedInputStream);
                return certificates;
            } catch (IOException e8) {
                e = e8;
                bufferedInputStream = null;
                LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                LiteApiLogger.w(TAG, e);
                FileUtils.closeQuietly(bufferedInputStream);
                return null;
            } catch (RuntimeException e9) {
                e = e9;
                bufferedInputStream = null;
                LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                LiteApiLogger.w(TAG, e);
                FileUtils.closeQuietly(bufferedInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                FileUtils.closeQuietly(autoCloseable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            autoCloseable2 = autoCloseable;
            FileUtils.closeQuietly(autoCloseable2);
            throw th;
        }
    }

    public static String getSignMd5Str(Context context) {
        try {
            Signature[] signatures = getSignatures(context);
            if (signatures != null && signatures.length > 0) {
                return LiteMd5Util.md5ForByte(signatures[0].toByteArray());
            }
            return "";
        } catch (Exception e6) {
            LiteApiLogger.w(TAG, e6);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0167, code lost:
    
        if (r12.length == r14.length) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x016a, code lost:
    
        r10 = r10 + 1;
        r4 = r20;
        r0 = r17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0048: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:113:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0259  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.content.pm.Signature[] getArchiveSignatures(java.lang.String r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.liteapi.report.LiteSignatureUtils.getArchiveSignatures(java.lang.String, boolean):android.content.pm.Signature[]");
    }

    @Nullable
    public static Signature[] getSignatures(Context context, String str) {
        Signature[] archiveSignatures = getArchiveSignatures(context, str);
        if (archiveSignatures != null) {
            return archiveSignatures;
        }
        Signature[] archiveSignatures2 = getArchiveSignatures(str, false);
        return archiveSignatures2 == null ? getArchiveSignatures(str, true) : archiveSignatures2;
    }

    public static boolean isSignaturesSame(String str, Signature[] signatureArr) {
        if (TextUtils.isEmpty(str) || signatureArr == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            if (signature.toCharsString().toLowerCase().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
