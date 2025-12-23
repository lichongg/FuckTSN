package xyz.adscope.common.tool.utils;

import android.content.Context;
import android.os.Environment;
import com.baidu.mobads.sdk.internal.bn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FileUtils {
    private static List<File> a(File file, List<File> list) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(file2, list);
            } else {
                list.add(file2);
            }
        }
        return list;
    }

    public static File getExternalFileDirectory(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File externalFilesDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalFilesDir(null) : null;
            return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static List<File> getFileList(String str) {
        File file = new File(str);
        if (file.exists()) {
            return a(file, new ArrayList());
        }
        return null;
    }

    public static File getResourceCacheDirectory(Context context) {
        File file = new File(context.getCacheDir().getPath() + "/asnp/material/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void deleteOldFiles(Context context) {
        File[] listFiles;
        try {
            File resourceCacheDirectory = getResourceCacheDirectory(context);
            if (resourceCacheDirectory.exists() && (listFiles = resourceCacheDirectory.listFiles()) != null) {
                long a6 = a(listFiles);
                if (a6 > 524288000) {
                    a(listFiles, new Date(System.currentTimeMillis() - bn.f10748d));
                    listFiles = resourceCacheDirectory.listFiles();
                    a6 = a(listFiles);
                }
                int i6 = 1;
                while (a6 > 262144000) {
                    a(listFiles, new Date(System.currentTimeMillis() - ((7 / ((int) Math.pow(2.0d, i6 - 1))) * 86400000)));
                    listFiles = resourceCacheDirectory.listFiles();
                    a6 = a(listFiles);
                    i6++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File getAppRootPath(Context context) {
        return context.getFilesDir();
    }

    public static String readFileContent(File file) {
        if (!file.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            fileInputStream.close();
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
        }
        return sb.toString();
    }

    public static boolean sdCardIsAvailable() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        }
        return false;
    }

    private static long a(File[] fileArr) {
        long j6 = 0;
        for (File file : fileArr) {
            if (file.isFile()) {
                j6 += file.length();
            }
        }
        return j6;
    }

    private static void a(File[] fileArr, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (File file : fileArr) {
            if (file.isFile()) {
                try {
                    if (simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(file.lastModified()))).before(date)) {
                        file.delete();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
    }
}
