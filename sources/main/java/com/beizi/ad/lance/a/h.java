package com.beizi.ad.lance.a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h {
    public static final File a(Context context) {
        File b6 = b(context);
        if (b6 == null) {
            return null;
        }
        File file = new File(b6.getPath() + "/Beizi/download/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "启动失败:" + str, 1).show();
        }
    }

    public static File d(Context context) {
        File file = new File(context.getCacheDir().getPath() + "/beizi/material/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f(Context context) {
        File file = new File(context.getCacheDir().getPath() + "/beizi/ad/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void g(Context context) {
        File[] listFiles;
        File[] listFiles2;
        if (context == null) {
            return;
        }
        try {
            File f6 = f(context);
            if (f6.exists() && f6.isDirectory() && (listFiles = f6.listFiles()) != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis() - 86400000);
                for (File file : listFiles) {
                    if (file.isDirectory() && (listFiles2 = file.listFiles()) != null) {
                        try {
                            for (File file2 : listFiles2) {
                                if (file2.isFile() && simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(file2.lastModified()))).before(date)) {
                                    file2.delete();
                                }
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File c(Context context) {
        return context.getCacheDir();
    }

    public static void e(Context context) {
        File[] listFiles;
        try {
            File d6 = d(context);
            if (d6.exists() && (listFiles = d6.listFiles()) != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis() - 1296000000);
                for (File file : listFiles) {
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File b(Context context) {
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

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            File f6 = f(context);
            if (f6.exists() && f6.isDirectory()) {
                File file = new File(f6.getPath() + "/" + str + "/", str2);
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(f(context).getPath() + "/" + str + "/");
            if (!file.exists()) {
                file.mkdirs();
            }
            fileWriter = new FileWriter(new File(file, str2), false);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedWriter.write(str3);
                try {
                    bufferedWriter.close();
                    fileWriter.close();
                    return true;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return true;
                }
            } catch (Throwable th3) {
                bufferedWriter2 = bufferedWriter;
                th = th3;
                try {
                    th.printStackTrace();
                    if (bufferedWriter2 != null) {
                        try {
                        } catch (Throwable th4) {
                            return false;
                        }
                    }
                    return false;
                } finally {
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Throwable th42) {
                            th42.printStackTrace();
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileWriter = null;
        }
    }

    public static String a(Context context, String str, String str2) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            File file = new File(f(context).getPath() + "/" + str + "/", str2);
            if (!file.exists()) {
                return null;
            }
            fileReader = new FileReader(file);
            try {
                if (!fileReader.ready()) {
                    try {
                        fileReader.close();
                        return null;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                bufferedReader = new BufferedReader(fileReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                                fileReader.close();
                                return sb2;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                return sb2;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        th.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                            } catch (Throwable th4) {
                                return null;
                            }
                        }
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th42) {
                                th42.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileReader = null;
            bufferedReader = null;
        }
    }
}
