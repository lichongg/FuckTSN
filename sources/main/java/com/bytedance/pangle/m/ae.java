package com.bytedance.pangle.m;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {
    public static void j(File file, String str, int i6) throws IOException {
        ZipFile zipFile;
        String str2 = ".dex";
        String str3 = "classes";
        if (!file.exists() || str == null) {
            throw new IOException("Could not check apk info " + file.getAbsolutePath());
        }
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            ArrayList arrayList = new ArrayList();
            File file2 = new File(com.bytedance.pangle.up.cw.g(str, i6));
            j(file2);
            int i7 = 1;
            int i8 = 1;
            while (true) {
                StringBuilder sb = new StringBuilder(str3);
                Object obj = "";
                sb.append(i8 == i7 ? "" : Integer.valueOf(i8));
                sb.append(str2);
                ZipEntry entry = zipFile.getEntry(sb.toString());
                if (entry == null) {
                    j(str, i6, file.getName(), arrayList);
                    com.bytedance.pangle.util.ae.j(zipFile);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                if (i8 != i7) {
                    obj = Integer.valueOf(i8);
                }
                sb2.append(obj);
                sb2.append(str2);
                j jVar = new j(file2, sb2.toString());
                int i9 = 0;
                boolean z5 = false;
                while (i9 < 3 && !z5) {
                    try {
                        j(zipFile, entry, jVar, str3);
                        z5 = true;
                    } catch (IOException e6) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + jVar.getAbsolutePath(), e6);
                    }
                    i9++;
                    StringBuilder sb3 = new StringBuilder("Plugin-MultiDex Extraction ");
                    sb3.append(z5 ? "succeeded" : "failed");
                    sb3.append(" '");
                    sb3.append(jVar.getAbsolutePath());
                    sb3.append("': length ");
                    String str4 = str2;
                    String str5 = str3;
                    sb3.append(jVar.length());
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb3.toString());
                    if (!z5) {
                        jVar.delete();
                        if (jVar.exists()) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + jVar.getPath() + "'");
                        }
                    }
                    str2 = str4;
                    str3 = str5;
                }
                String str6 = str2;
                String str7 = str3;
                if (!z5) {
                    throw new IOException("Could not create zip file " + jVar.getAbsolutePath() + " for secondary dex (" + i8 + ")");
                }
                arrayList.add(jVar);
                i8++;
                str2 = str6;
                str3 = str7;
                i7 = 1;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            com.bytedance.pangle.util.ae.j(zipFile2);
            throw th;
        }
    }

    private static class j extends File {
        public j(File file, String str) {
            super(file, str);
        }
    }

    private static int xt(String str, int i6) {
        return j((str + "-" + i6) + ".dex.number");
    }

    public static String j(String str, int i6) {
        int xt = xt(str, i6);
        StringBuilder sb = new StringBuilder();
        for (int i7 = 1; i7 <= xt; i7++) {
            sb.append(new j(new File(com.bytedance.pangle.up.cw.g(str, i6)), i7 == 1 ? "classes.dex" : "classes" + i7 + ".dex").getAbsolutePath());
            sb.append(":");
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void j(ZipFile zipFile, ZipEntry zipEntry, j jVar, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".dex", jVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    if (createTempFile.renameTo(jVar)) {
                        j(inputStream);
                        createTempFile.delete();
                        return;
                    }
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + jVar.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + jVar.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            j(inputStream);
            createTempFile.delete();
            throw th2;
        }
    }

    private static void j(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e6) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e6);
        }
    }

    private static void j(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void j(String str, int i6, String str2, List<j> list) {
        String str3 = str + "-" + i6;
        SharedPreferences.Editor edit = j().edit();
        edit.putInt(str3 + ".dex.number", list.size());
        edit.commit();
    }

    private static SharedPreferences j() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static int j(String str) {
        return j().getInt(str, 0);
    }
}
