package com.kwad.sdk.core.webview.b.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static void f(Context context, String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String bX = bX(context);
            if (!new File(bX, name).getAbsolutePath().startsWith(bX)) {
                break;
            }
            if (!nextEntry.isDirectory()) {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            } else if (!name.contains("../")) {
                new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }

    public static String fb(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = (pathSegments == null || pathSegments.size() <= 0) ? null : pathSegments.get(pathSegments.size() - 1);
            return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.c.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    private static boolean fc(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static String H(Context context, String str) {
        String bX = bX(context);
        if (TextUtils.isEmpty(bX)) {
            return null;
        }
        return bX + File.separator + str;
    }

    public static String I(Context context, String str) {
        String bX = bX(context);
        if (TextUtils.isEmpty(bX)) {
            return null;
        }
        return bX + File.separator + str + ".zip";
    }

    public static String J(Context context, String str) {
        String bX = bX(context);
        if (TextUtils.isEmpty(bX)) {
            return null;
        }
        return bX + File.separator + str;
    }

    public static String K(Context context, String str) {
        String bX = bX(context);
        if (TextUtils.isEmpty(bX)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bX);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append("_manifest_.json");
        return sb.toString();
    }

    private static File bW(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return new File("/data/data/" + context.getPackageName() + "/file/");
        }
        return filesDir;
    }

    private static String bX(Context context) {
        String str = bW(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File bY(Context context) {
        String bX = bX(context);
        if (TextUtils.isEmpty(bX)) {
            return null;
        }
        fc(bX);
        File file = new File(bX, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static String fa(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.c.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }
}
