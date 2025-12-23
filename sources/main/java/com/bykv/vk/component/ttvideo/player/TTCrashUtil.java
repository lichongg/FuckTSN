package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.util.Base64;
import androidx.work.Data;
import com.bytedance.sdk.component.utils.vl;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class TTCrashUtil {
    public static void addTrackInfo(long j6, String str, String str2) {
        appendTrackInfo(getTrackFilePath(j6, str), true, str2);
    }

    private static void appendTrackInfo(String str, boolean z5, String str2) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(str, z5);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(str2);
                fileWriter.close();
            } catch (Exception unused2) {
                fileWriter2 = fileWriter;
                fileWriter2.close();
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                try {
                    fileWriter2.close();
                } catch (Exception e6) {
                    vl.j(e6);
                }
                throw th;
            }
        } catch (Exception e7) {
            vl.j(e7);
        }
    }

    private static void deleteTrackFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static String getCrashFileContext(Context context, String str, StringBuilder sb) {
        FileInputStream fileInputStream;
        if (context == null && str == null) {
            sb.append("context or path is null.\r\n");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            sb.append("file not exist.path:");
            sb.append(str);
            sb.append(org.apache.commons.net.g.f50795q);
            return null;
        }
        if (file.length() == 0) {
            sb.append("file size is zore.\r\n");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                compress(fileInputStream, byteArrayOutputStream);
                fileInputStream.close();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                byteArrayOutputStream.close();
                return encodeToString;
            } catch (Exception e6) {
                e = e6;
                vl.j(e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        vl.j(e7);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                sb.append("gzip file is error.error:");
                sb.append(e.getMessage());
                return null;
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
        }
    }

    private static boolean getTrackFileInfos(File file, StringBuilder sb) {
        int read;
        FileReader fileReader = null;
        try {
            if (!file.exists()) {
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    read = fileReader2.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    sb.append("track message:");
                    sb.append(th.getMessage());
                    sb.append(org.apache.commons.net.g.f50795q);
                    return true;
                }
            } while (read >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final boolean moveFile(String str, String str2, boolean z5) {
        return copyFile(str, str2, z5, true);
    }

    public static void addTrackInfo(long j6, String str, String str2, boolean z5) {
        appendTrackInfo(getTrackFilePath(j6, str), z5, str2);
    }

    public static void checkLogDir(String str) {
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists()) {
            if (file.mkdir()) {
                return;
            }
            file.getName();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!file2.delete()) {
                        file2.getName();
                    }
                }
            }
            if (file.delete()) {
                return;
            }
            file.getName();
        }
    }

    public static void checkTrackDir(String str) {
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        while (true) {
            int read = inputStream.read(bArr, 0, Data.MAX_DATA_BYTES);
            if (read == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
            gZIPOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x008f A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #4 {IOException -> 0x008b, blocks: (B:69:0x0087, B:62:0x008f), top: B:68:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean copyFile(java.lang.String r4, java.lang.String r5, boolean r6, boolean r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto Ld
            return r1
        Ld:
            boolean r5 = r0.isFile()
            if (r5 != 0) goto L14
            return r1
        L14:
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            boolean r2 = r5.exists()
            if (r2 == 0) goto L2a
            if (r6 == 0) goto L3f
            java.io.File r6 = new java.io.File
            r6.<init>(r4)
            r6.delete()
            goto L3f
        L2a:
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.exists()
            if (r4 != 0) goto L3f
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L3f
            return r1
        L3f:
            r4 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L81 java.io.FileNotFoundException -> L83
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L81 java.io.FileNotFoundException -> L83
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79 java.io.FileNotFoundException -> L7b
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79 java.io.FileNotFoundException -> L7b
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b java.io.FileNotFoundException -> L5d
        L4e:
            int r5 = r6.read(r4)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b java.io.FileNotFoundException -> L5d
            r3 = -1
            if (r5 == r3) goto L5f
            r2.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b java.io.FileNotFoundException -> L5d
            goto L4e
        L59:
            r4 = move-exception
            goto L85
        L5b:
            goto L71
        L5d:
            goto L73
        L5f:
            if (r7 == 0) goto L64
            r0.delete()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b java.io.FileNotFoundException -> L5d
        L64:
            r2.close()     // Catch: java.io.IOException -> L6b
            r6.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r4 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r4)
        L6f:
            r4 = 1
            return r4
        L71:
            r4 = r2
            goto L98
        L73:
            r4 = r2
            goto Lab
        L75:
            r5 = move-exception
            r2 = r4
        L77:
            r4 = r5
            goto L85
        L79:
            goto L98
        L7b:
            goto Lab
        L7d:
            r5 = move-exception
            r6 = r4
            r2 = r6
            goto L77
        L81:
            goto L97
        L83:
            goto Laa
        L85:
            if (r2 == 0) goto L8d
            r2.close()     // Catch: java.io.IOException -> L8b
            goto L8d
        L8b:
            r5 = move-exception
            goto L93
        L8d:
            if (r6 == 0) goto L96
            r6.close()     // Catch: java.io.IOException -> L8b
            goto L96
        L93:
            com.bytedance.sdk.component.utils.vl.j(r5)
        L96:
            throw r4
        L97:
            r6 = r4
        L98:
            if (r4 == 0) goto La0
            r4.close()     // Catch: java.io.IOException -> L9e
            goto La0
        L9e:
            r4 = move-exception
            goto La6
        La0:
            if (r6 == 0) goto La9
            r6.close()     // Catch: java.io.IOException -> L9e
            goto La9
        La6:
            com.bytedance.sdk.component.utils.vl.j(r4)
        La9:
            return r1
        Laa:
            r6 = r4
        Lab:
            if (r4 == 0) goto Lb3
            r4.close()     // Catch: java.io.IOException -> Lb1
            goto Lb3
        Lb1:
            r4 = move-exception
            goto Lb9
        Lb3:
            if (r6 == 0) goto Lbc
            r6.close()     // Catch: java.io.IOException -> Lb1
            goto Lbc
        Lb9:
            com.bytedance.sdk.component.utils.vl.j(r4)
        Lbc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.TTCrashUtil.copyFile(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    public static void deleteCrashFile(Context context, String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean existsCrashFile(Context context, String str) {
        if (context == null && str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static final String existsCrashFilePath(Context context) {
        if (TTPlayerConfiger.getValue(18, 1) == 1) {
            String appCrashFilePath = TTPlayerConfiger.getAppCrashFilePath(context);
            if (appCrashFilePath == null || !new File(appCrashFilePath).exists()) {
                return null;
            }
            return appCrashFilePath;
        }
        String appCrashFilePath2 = TTPlayerConfiger.getAppCrashFilePath2(context);
        if (appCrashFilePath2 != null && new File(appCrashFilePath2).exists()) {
            return appCrashFilePath2;
        }
        String plugerCrashFilePath = TTPlayerConfiger.getPlugerCrashFilePath(context);
        if (plugerCrashFilePath != null && new File(plugerCrashFilePath).exists()) {
            return plugerCrashFilePath;
        }
        String externalStorageDirectoryCrashFilePath = TTPlayerConfiger.getExternalStorageDirectoryCrashFilePath();
        if (externalStorageDirectoryCrashFilePath == null || new File(externalStorageDirectoryCrashFilePath).exists()) {
            return externalStorageDirectoryCrashFilePath;
        }
        return null;
    }

    public static boolean existsTrackFile(long j6, String str) {
        return new File(getTrackFilePath(j6, str)).exists();
    }

    private static String getDebugTrackFilePath(long j6, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d_d.log", str, Long.valueOf(j6));
    }

    public static String getTrackFilePath(long j6, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d.log", str, Long.valueOf(j6));
    }

    public static boolean moveTrackFile(long j6, long j7, String str) {
        return new File(getTrackFilePath(j6, str)).renameTo(new File(getTrackFilePath(j7, str)));
    }

    public static final void saveException(Throwable th, String str) {
        FileOutputStream fileOutputStream;
        PrintStream printStream;
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        PrintStream printStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    printStream = new PrintStream(fileOutputStream);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    printStream.write("EXCE".getBytes());
                    th.printStackTrace(printStream);
                    printStream.close();
                    fileOutputStream.close();
                } catch (Exception unused2) {
                    printStream2 = printStream;
                    if (printStream2 != null) {
                        printStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    printStream2 = printStream;
                    if (printStream2 != null) {
                        printStream2.close();
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e6) {
                            vl.j(e6);
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } catch (Exception e7) {
            vl.j(e7);
        }
    }

    public static void saveLowMemoryInfo(int i6, String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        fileWriter2.write("LOWM\r\nrecv low memory warring info.level:" + i6);
                        fileWriter2.close();
                    } catch (IOException e6) {
                        e = e6;
                        fileWriter = fileWriter2;
                        vl.j(e);
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e7) {
                                vl.j(e7);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } catch (IOException e9) {
                vl.j(e9);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void saveStopInfo(java.lang.String r2, java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto Lc
            goto L50
        Lc:
            r2 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.String r0 = "STOP recv stop info:"
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r2.append(r3)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.String r3 = ".time:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.String r3 = com.bykv.vk.component.ttvideo.utils.AVTime.getFormatNow()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r2.append(r3)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.String r3 = "\r\n"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r1.write(r2)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            r1.close()     // Catch: java.io.IOException -> L38
            return
        L38:
            r2 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r2)
            return
        L3d:
            r2 = move-exception
            goto L51
        L3f:
            r2 = move-exception
            goto L48
        L41:
            r3 = move-exception
            r1 = r2
            r2 = r3
            goto L51
        L45:
            r3 = move-exception
            r1 = r2
            r2 = r3
        L48:
            com.bytedance.sdk.component.utils.vl.j(r2)     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L38
        L50:
            return
        L51:
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.io.IOException -> L57
            goto L5b
        L57:
            r3 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r3)
        L5b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.TTCrashUtil.saveStopInfo(java.lang.String, java.lang.String):void");
    }

    public static void addDebugTrackInfo(long j6, String str, String str2, boolean z5) {
        appendTrackInfo(getDebugTrackFilePath(j6, str), z5, str2);
    }

    public static void deleteDebugTrackFile(long j6, String str) {
        deleteTrackFile(getDebugTrackFilePath(j6, str));
    }

    public static boolean existLogsFile(long j6, String str) {
        File[] listFiles;
        String valueOf = String.valueOf(j6);
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            vl.j("ttmp", "<TTCrashUtils,existLogsFile,375>file:" + name + ",pname:" + valueOf);
            if (name != null && !name.startsWith(valueOf)) {
                return true;
            }
        }
        return false;
    }

    public static String getBase64SampleCrash(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static boolean readDebugTrackInfos(long j6, String str, StringBuilder sb) {
        return getTrackFileInfos(getDebugTrackFilePath(j6, str), sb);
    }

    public static boolean readLogsInfo(long j6, String str, StringBuilder sb) {
        File[] listFiles;
        String valueOf = String.valueOf(j6);
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (name != null && !name.startsWith(valueOf) && getTrackFileInfos(file2, sb)) {
                boolean delete = file2.delete();
                if (!delete) {
                    file2.getName();
                }
                return delete;
            }
        }
        return false;
    }

    public static boolean readTrackInfos(long j6, String str, StringBuilder sb) {
        return getTrackFileInfos(getTrackFilePath(j6, str), sb);
    }

    public static void deleteTrackFile(long j6, String str) {
        deleteTrackFile(getTrackFilePath(j6, str));
    }

    private static boolean getTrackFileInfos(String str, StringBuilder sb) {
        int read;
        FileReader fileReader = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                sb.append("path");
                sb.append(str);
                sb.append(" not exists.\r\n");
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    read = fileReader2.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    sb.append("track message:");
                    sb.append(th.getMessage());
                    sb.append(org.apache.commons.net.g.f50795q);
                    return true;
                }
            } while (read >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
