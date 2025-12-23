package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import cn.jpush.android.local.JPushConstants;
import com.baidu.mobads.sdk.internal.by;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static String f40677a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f40678b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f40679c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f40680d = "";

    /* renamed from: e, reason: collision with root package name */
    private static int f40681e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static String f40682f = "0123456789ABCDEF";

    private static char a(int i6) {
        int i7 = i6 & 15;
        return (char) (i7 < 10 ? i7 + 48 : i7 + 87);
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", JPushConstants.HTTP_PRE));
            Bundle a6 = a(url.getQuery());
            a6.putAll(a(url.getRef()));
            return a6;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", JPushConstants.HTTP_PRE));
            JSONObject a6 = a((JSONObject) null, url.getQuery());
            a(a6, url.getRef());
            return a6;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            SLog.e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e6);
            return "";
        }
    }

    private static boolean g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (k.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                    messageDigest.update(signatureArr[0].toByteArray());
                    String a6 = a(messageDigest.digest());
                    messageDigest.reset();
                    if (a6.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e6) {
                    SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e6.getMessage());
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean h(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE);
    }

    public static boolean i(String str) {
        return str != null && new File(str).exists();
    }

    public static String k(String str) {
        return a(str, 2);
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] a6 = a(str2, ContainerUtils.KEY_VALUE_DELIMITER);
                    if (a6.length == 2) {
                        bundle.putString(URLDecoder.decode(a6[0]), URLDecoder.decode(a6[1]));
                    }
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return bundle;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        String d6 = d(context, str);
        f40679c = d6;
        return d6;
    }

    public static File h(Context context, String str) {
        File[] externalFilesDirs;
        if (context == null || (externalFilesDirs = context.getExternalFilesDirs(str)) == null || externalFilesDirs.length <= 0) {
            return null;
        }
        return externalFilesDirs[0];
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e6) {
            SLog.e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e6);
            return new byte[0];
        }
    }

    public static File l(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                    return file;
                }
                SLog.d("openSDK_LOG.Util", "createFile failed" + str);
                return file;
            }
            file.createNewFile();
        }
        return file;
    }

    private static boolean i(Context context, String str) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            checkSelfPermission = context.checkSelfPermission(str);
            return checkSelfPermission != 0;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.Util", "checkSelfPermission exception", e6);
            return false;
        }
    }

    public static boolean m(String str) {
        String b6 = b();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(b6) && str.contains(b6)) {
            return true;
        }
        return false;
    }

    public static boolean e(Context context) {
        return k.c(context, "8.1.8") >= 0;
    }

    public static boolean f(Context context, String str) {
        boolean z5 = !c(context) || k.a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z5 && k.a(context, Constants.PACKAGE_TIM) != null) {
            z5 = false;
        }
        return z5 ? k.c(context, str) < 0 : z5;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo[] networkInfoArr;
        if (context == null || i(context, com.kuaishou.weapon.p0.g.f36042b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        try {
            networkInfoArr = connectivityManager.getAllNetworkInfo();
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e6);
            networkInfoArr = null;
        }
        if (networkInfoArr != null && networkInfoArr.length != 0) {
            for (NetworkInfo networkInfo : networkInfoArr) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f40678b;
    }

    public static boolean f(Context context) {
        return k.c(context, "5.9.5") >= 0;
    }

    public static String[] a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
    }

    public static boolean c(Context context) {
        double d6;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d6 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d6 = 0.0d;
        }
        return d6 > 6.5d;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f40677a;
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    try {
                        split[0] = URLDecoder.decode(split[0]);
                        split[1] = URLDecoder.decode(split[1]);
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e6) {
                        SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e6.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(j(str));
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                sb.append(a(b6 >>> 4));
                sb.append(a(b6));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e6) {
            SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e6.getMessage());
            return str;
        }
    }

    public static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            f40678b = str2;
            f40677a = str2.substring(0, str2.lastIndexOf(46));
            String str3 = f40678b;
            f40680d = str3.substring(str3.lastIndexOf(46) + 1, f40678b.length());
            f40681e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e6) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e6.getMessage());
        } catch (Exception e7) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e7.getMessage());
        }
    }

    public static boolean d(Context context) {
        return k.c(context, "8.1.5") >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c A[Catch: all -> 0x00aa, Exception -> 0x00b1, TRY_LEAVE, TryCatch #22 {Exception -> 0x00b1, all -> 0x00aa, blocks: (B:25:0x0064, B:27:0x006c, B:39:0x00b7, B:41:0x00bd, B:42:0x00c0, B:44:0x00cf, B:45:0x00d2), top: B:24:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7 A[Catch: all -> 0x00aa, Exception -> 0x00b1, TRY_ENTER, TryCatch #22 {Exception -> 0x00b1, all -> 0x00aa, blocks: (B:25:0x0064, B:27:0x006c, B:39:0x00b7, B:41:0x00bd, B:42:0x00c0, B:44:0x00cf, B:45:0x00d2), top: B:24:0x0064 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r11, android.net.Uri r12) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.m.c(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        boolean z5;
        try {
            z5 = g(context);
            try {
                if (z5) {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } else {
                    a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception unused) {
                if (z5) {
                    try {
                        try {
                            try {
                                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            } catch (Exception unused2) {
                                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            }
                        } catch (Exception unused3) {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        }
                    } catch (Exception unused4) {
                        return false;
                    }
                }
                try {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused5) {
                        a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    }
                } catch (Exception unused6) {
                    return false;
                }
            }
        } catch (Exception unused7) {
            z5 = false;
        }
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str = split[0];
                if ("primary".equals(str)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                }
                return "/storage/".concat(str).concat("/").concat(split[1]);
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            }
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str2 = split2[0];
                if (SocializeProtocolConstants.IMAGE.equals(str2)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str2)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str2)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return c(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
            }
            return null;
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return c(context, uri);
        }
        if (master.flame.danmaku.danmaku.parser.b.f50156c.equals(scheme)) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean g(Context context, String str) {
        boolean z5 = !c(context) || k.a(context, Constants.PACKAGE_QQ_PAD) == null;
        return z5 ? k.c(context, str) < 0 : z5;
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b6 : bArr) {
            String num = Integer.toString(b6 & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static final String a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static final String a(String str, int i6, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length > i6) {
                int i7 = 0;
                int i8 = 0;
                while (i7 < str.length()) {
                    int i9 = i7 + 1;
                    i8 += str.substring(i7, i9).getBytes(str2).length;
                    if (i8 > i6) {
                        String substring = str.substring(0, i7);
                        if (TextUtils.isEmpty(str3)) {
                            return substring;
                        }
                        return substring + str3;
                    }
                    i7 = i9;
                }
            }
            return str;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e6.getMessage());
            return str;
        }
    }

    public static String b() {
        File e6 = g.e();
        if (e6 == null) {
            return null;
        }
        if (!e6.exists()) {
            e6.mkdirs();
        }
        return e6.toString();
    }

    public static boolean b(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            return a(file, l(str2));
        } catch (IOException e6) {
            SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e6);
            return false;
        }
    }

    public static Bundle a(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("result", str);
        return bundle;
    }

    public static boolean c() {
        Context a6 = g.a();
        return a6 != null && a6.getPackageManager().checkPermission(com.kuaishou.weapon.p0.g.f36050j, a6.getPackageName()) == 0;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, str4);
        bundle.putString("app_id", str5);
        bundle.putString("type", str6);
        bundle.putString("login_status", str7);
        bundle.putString("need_user_auth", str8);
        bundle.putString("to_uin", str9);
        bundle.putString("call_source", str10);
        bundle.putString("to_type", str11);
        bundle.putString("platform", "1");
        return bundle;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5) {
        return a(str, str3, str4, str2, str5, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return a(a(str, str2, str3, str4, str5, str7, str8, str9, str10, str11, str12), str6);
    }

    public static boolean a(Context context, boolean z5) {
        return (c(context) && k.a(context, Constants.PACKAGE_QQ_PAD) != null) || k.c(context, "4.1") >= 0 || k.a(context, Constants.PACKAGE_TIM) != null;
    }

    public static long a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
        long j6 = 0;
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    try {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_size");
                        if (query.moveToFirst()) {
                            j6 = query.getLong(columnIndexOrThrow);
                        }
                    } catch (Exception e6) {
                        SLog.e("openSDK_LOG.Util", "cursor exception", e6);
                    }
                    try {
                        query.close();
                    } catch (Exception e7) {
                        SLog.e("openSDK_LOG.Util", "cursor exception", e7);
                    }
                    return j6;
                }
            } finally {
            }
        }
        return 0L;
    }

    public static String a(String str, int i6) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), i6);
            } catch (UnsupportedEncodingException e6) {
                SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e6.getMessage());
                return "";
            }
        }
        return "";
    }

    public static Drawable a(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb;
        InputStream inputStream2 = null;
        r1 = null;
        Drawable drawable = null;
        if (context == null) {
            SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            try {
                inputStream2.close();
            } catch (Exception e7) {
                SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e7.getMessage());
            }
            throw th;
        }
        try {
            try {
                drawable = Drawable.createFromStream(inputStream, str);
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                inputStream2.close();
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
            try {
                inputStream.close();
            } catch (Exception e9) {
                e = e9;
                sb = new StringBuilder();
                sb.append("inputStream close exception: ");
                sb.append(e.getMessage());
                SLog.e("openSDK_LOG.Util", sb.toString());
                return drawable;
            }
            return drawable;
        }
        try {
            inputStream.close();
        } catch (Exception e10) {
            e = e10;
            sb = new StringBuilder();
            sb.append("inputStream close exception: ");
            sb.append(e.getMessage());
            SLog.e("openSDK_LOG.Util", sb.toString());
            return drawable;
        }
        return drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean a(File file, File file2) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream((File) file2);
                try {
                    file2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                        while (true) {
                            int read = file2.read(bArr);
                            if (read != -1) {
                                fileOutputStream2.write(bArr, 0, read);
                                fileOutputStream2.flush();
                            } else {
                                try {
                                    break;
                                } catch (IOException e6) {
                                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e6);
                                }
                            }
                        }
                        fileOutputStream2.close();
                        try {
                            file2.close();
                        } catch (IOException e7) {
                            SLog.e("openSDK_LOG.Util", "copyFile error, ", e7);
                        }
                        return true;
                    } catch (IOException e8) {
                        e = e8;
                        fileOutputStream = fileOutputStream2;
                        file2 = file2;
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e9) {
                                SLog.e("openSDK_LOG.Util", "copyFile error, ", e9);
                            }
                        }
                        if (file2 == 0) {
                            return false;
                        }
                        try {
                            file2.close();
                            return false;
                        } catch (IOException e10) {
                            SLog.e("openSDK_LOG.Util", "copyFile error, ", e10);
                            return false;
                        }
                    } catch (OutOfMemoryError e11) {
                        e = e11;
                        fileOutputStream = fileOutputStream2;
                        file2 = file2;
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e12) {
                                SLog.e("openSDK_LOG.Util", "copyFile error, ", e12);
                            }
                        }
                        if (file2 == 0) {
                            return false;
                        }
                        file2.close();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e13) {
                                SLog.e("openSDK_LOG.Util", "copyFile error, ", e13);
                            }
                        }
                        if (file2 != 0) {
                            try {
                                file2.close();
                                throw th;
                            } catch (IOException e14) {
                                SLog.e("openSDK_LOG.Util", "copyFile error, ", e14);
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (IOException e15) {
                    e = e15;
                    file2 = 0;
                } catch (OutOfMemoryError e16) {
                    e = e16;
                    file2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    file2 = 0;
                }
            } catch (IOException e17) {
                e = e17;
                file2 = 0;
            } catch (OutOfMemoryError e18) {
                e = e18;
                file2 = 0;
            } catch (Throwable th3) {
                th = th3;
                file2 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        boolean b6 = b(str, str2);
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + b6);
        return b6;
    }

    public static String a(String str, Activity activity, String str2, IUiListener iUiListener) {
        String str3;
        try {
            boolean m6 = m(str2);
            SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + m6 + ",hasSDPermission=" + c());
            if (!m6) {
                File a6 = g.a("Images");
                if (a6 != null) {
                    str3 = a6.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    File cacheDir = g.a().getCacheDir();
                    if (cacheDir == null) {
                        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = b(absolutePath, str4) ? str4 : null;
            }
            Uri a7 = a(activity, str, str2);
            if (a7 == null) {
                return null;
            }
            return a7.toString();
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e6);
            return null;
        }
    }

    public static boolean a(Map<String, Object> map, String str, boolean z5) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z5;
        }
        if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z5;
        }
        Object obj = map.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z5;
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        }
        if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        }
        Object obj = map.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public static Uri a(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
            return null;
        }
        try {
            String authorities = Tencent.getAuthorities(str);
            if (TextUtils.isEmpty(authorities)) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, new File(str2));
            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_TIM, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_PAD, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_SPEED, uriForFile, 3);
            return uriForFile;
        } catch (Exception e6) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e6);
            return null;
        }
    }
}
