package com.bytedance.pangle.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    static int cw = 8192;

    /* renamed from: j, reason: collision with root package name */
    static String f25542j;
    static String xt;

    public static void j(String str) {
        j(new File(str));
    }

    public static String xt(Context context) {
        File parentFile;
        if (xt == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                xt = parentFile.getCanonicalPath();
            } catch (IOException e6) {
                com.bytedance.sdk.openadsdk.api.m.j(e6);
            }
        }
        return xt;
    }

    public static void j(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                j(file2);
            }
        }
        file.delete();
    }

    public static void xt(String str, String str2) throws Exception {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("..")) {
                            if (nextEntry.isDirectory()) {
                                new File(str2 + File.separator + name).mkdirs();
                            } else {
                                File file = new File(str2 + File.separator + name);
                                if (file.exists()) {
                                    file.delete();
                                } else {
                                    file.getParentFile().mkdirs();
                                }
                                file.createNewFile();
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream2.write(bArr, 0, read);
                                        }
                                    }
                                    bufferedOutputStream2.flush();
                                    bufferedOutputStream2.close();
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Exception e6) {
                                    e = e6;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    j(bufferedOutputStream);
                                    j(zipInputStream);
                                    throw e;
                                }
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            }
        } catch (Exception e8) {
            e = e8;
            zipInputStream = null;
        }
    }

    public static void j(InputStream inputStream, OutputStream outputStream) throws IOException {
        j(inputStream, outputStream, 0L, 1048576);
    }

    private static void j(InputStream inputStream, OutputStream outputStream, long j6, int i6) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[i6];
            int i7 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i7 += read;
            }
            bufferedOutputStream.flush();
            if (j6 > 0 && i7 != j6) {
                throw new IOException("copy is not completed");
            }
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void j(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String j(Context context) {
        File parentFile;
        if (f25542j == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            f25542j = parentFile.getAbsolutePath();
        }
        return f25542j;
    }

    public static void j(String str, String str2) throws Exception {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file2.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        return;
                    }
                    for (File file3 : listFiles) {
                        String str3 = file2 + File.separator + file3.getName();
                        if (file3.isDirectory()) {
                            j(file3.getAbsolutePath(), str3);
                        } else if (!new File(str3).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                            byte[] bArr = new byte[cw];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                            }
                            bufferedOutputStream.close();
                            bufferedInputStream.close();
                        }
                    }
                    return;
                }
                throw new Exception("目标文件夹不是目录");
            }
            throw new Exception("源文件夹不是目录");
        }
        throw new Exception("文件夹不存在");
    }

    public static boolean xt(File file) {
        FileInputStream fileInputStream = null;
        if (file == null) {
            j((Closeable) null);
            return false;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[6];
                if (fileInputStream2.read(bArr) != 6) {
                    j(fileInputStream2);
                    return false;
                }
                byte[] bArr2 = {80, 75, 3, 4};
                for (int i6 = 0; i6 < 4; i6++) {
                    if (bArr2[i6] != bArr[i6]) {
                        j(fileInputStream2);
                        return false;
                    }
                }
                byte b6 = bArr[4];
                if (b6 == 0 && bArr[5] == 0) {
                    j(fileInputStream2);
                    return false;
                }
                if (b6 == 20) {
                    if (bArr[5] == 3) {
                        j(fileInputStream2);
                        return true;
                    }
                }
                j(fileInputStream2);
                return false;
            } catch (Throwable unused) {
                fileInputStream = fileInputStream2;
                j(fileInputStream);
                return false;
            }
        } catch (Throwable unused2) {
        }
    }

    public static void j(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j6, long j7, String str) throws IOException {
        byte[] bArr;
        long j8 = 0;
        if (j6 < 0 || j7 < 0 || j6 > j7) {
            throw new IOException("invalid offsets  ".concat(String.valueOf(str)));
        }
        if (j6 == j7) {
            return;
        }
        randomAccessFile.seek(j6);
        long j9 = j7 - j6;
        int i6 = cw;
        if (j9 < i6) {
            bArr = new byte[(int) j9];
        } else {
            bArr = new byte[i6];
        }
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read == -1) {
                return;
            }
            randomAccessFile2.write(bArr, 0, read);
            j8 += read;
            if (j8 == j9) {
                return;
            }
            if (bArr.length + j8 > j9) {
                bArr = new byte[(int) (j9 - j8)];
            }
        }
    }
}
