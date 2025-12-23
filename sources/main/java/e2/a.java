package e2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.huawei.secure.android.common.util.e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f43000a = "HiPkgSignManager";

    public static List<String> j(Context context, String str) {
        PackageManager packageManager;
        Signature[] signatureArr;
        SigningInfo signingInfo;
        SigningInfo signingInfo2;
        boolean hasMultipleSigners;
        SigningInfo signingInfo3;
        Signature[] signingCertificateHistory;
        SigningInfo signingInfo4;
        Signature[] apkContentsSigners;
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable unused) {
        }
        if (Build.VERSION.SDK_INT < 28) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0 && signatureArr[0] != null) {
                return c(signatureArr);
            }
            return null;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, AMapEngineUtils.HALF_MAX_P20_WIDTH);
        if (packageInfo2 != null) {
            signingInfo = packageInfo2.signingInfo;
            if (signingInfo != null) {
                signingInfo2 = packageInfo2.signingInfo;
                hasMultipleSigners = signingInfo2.hasMultipleSigners();
                if (hasMultipleSigners) {
                    signingInfo4 = packageInfo2.signingInfo;
                    apkContentsSigners = signingInfo4.getApkContentsSigners();
                    return c(apkContentsSigners);
                }
                signingInfo3 = packageInfo2.signingInfo;
                signingCertificateHistory = signingInfo3.getSigningCertificateHistory();
                return c(signingCertificateHistory);
            }
        }
        return null;
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < length; i6++) {
            byte b6 = bArr[i6];
            if ((b6 & 255) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i6] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(b6 & 255));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    private static List<String> c(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        if (signatureArr != null && signatureArr.length != 0) {
            for (Signature signature : signatureArr) {
                arrayList.add(d(signature.toByteArray()));
            }
        }
        return arrayList;
    }

    private static String d(byte[] bArr) {
        try {
            return b(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e6) {
            e.l(f43000a, "NoSuchAlgorithmException" + e6.getMessage());
            return "";
        }
    }

    public static byte[] h(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            e.l(f43000a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e6) {
            e.q(f43000a, "PackageManager.NameNotFoundException : " + e6.getMessage(), true);
        } catch (Exception e7) {
            e.q(f43000a, "Exception : " + e7.getMessage(), true);
        }
        return new byte[0];
    }

    public static String k(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            e.l(f43000a, "archiveFilePath is null or context is null");
            return "";
        }
        PackageInfo a6 = a(context, str);
        return a6 != null ? a6.packageName : "";
    }

    public static byte[] l(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            e.l(f43000a, "archiveFilePath is null or context is null");
            return new byte[0];
        }
        PackageInfo a6 = a(context, str);
        if (a6 != null) {
            Signature signature = a6.signatures[0];
            if (signature != null) {
                return signature.toByteArray();
            }
        } else {
            e.l(f43000a, "PackageInfo is null ");
        }
        return new byte[0];
    }

    private static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageArchiveInfo(str, 64);
            }
            return null;
        } catch (Exception e6) {
            e.q(f43000a, "Exception : " + e6.getMessage(), true);
            return null;
        }
    }

    public static boolean e(Context context, String str, String str2, String str3) {
        PackageInfo a6;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && context != null && !TextUtils.isEmpty(str3) && (a6 = a(context, str2)) != null) {
            String d6 = d(a6.signatures[0].toByteArray());
            String str4 = a6.packageName;
            if (str.equalsIgnoreCase(d6) && str3.equals(str4)) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && context != null) {
            return str.equalsIgnoreCase(i(context, str2));
        }
        return false;
    }

    public static boolean g(Context context, List<String> list, String str) {
        List<String> j6;
        if (TextUtils.isEmpty(str) || list == null || context == null || (j6 = j(context, str)) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
        }
        Iterator<String> it2 = j6.iterator();
        while (it2.hasNext()) {
            if (!arrayList.contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static String i(Context context, String str) {
        byte[] h6 = h(context, str);
        if (h6 != null && h6.length > 0) {
            return d(h6);
        }
        return "";
    }

    public static String m(Context context, String str) {
        byte[] l6 = l(context, str);
        if (l6 != null && l6.length > 0) {
            return d(l6);
        }
        return "";
    }
}
