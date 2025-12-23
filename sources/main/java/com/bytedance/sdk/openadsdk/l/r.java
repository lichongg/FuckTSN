package com.bytedance.sdk.openadsdk.l;

import com.bytedance.sdk.component.utils.vl;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e6) {
                vl.xt("FileUtils", e6);
            }
        }
    }

    public static File j(File file, String str) {
        File file2;
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file2 = new File(file.getParentFile(), str);
                try {
                    if (file.exists() && file.isDirectory()) {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                        try {
                            for (File file3 : file.listFiles()) {
                                zipOutputStream2.putNextEntry(new ZipEntry(file3.getName()));
                                j(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream = zipOutputStream2;
                        } catch (IOException e6) {
                            e = e6;
                            zipOutputStream = zipOutputStream2;
                            vl.xt("FileUtils", e);
                            j(zipOutputStream);
                            return file2;
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            j(zipOutputStream);
                            throw th;
                        }
                    }
                    j(zipOutputStream);
                    return file2;
                } catch (IOException e7) {
                    e = e7;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            e = e8;
            file2 = null;
        }
    }

    private static void xt(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j(file2);
            }
        }
    }

    public static void j(String str, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter2.write(str);
                    j(bufferedWriter2);
                } catch (FileNotFoundException e6) {
                    e = e6;
                    bufferedWriter = bufferedWriter2;
                    vl.xt("FileUtils", e);
                    j(bufferedWriter);
                } catch (IOException e7) {
                    e = e7;
                    bufferedWriter = bufferedWriter2;
                    vl.xt("FileUtils", e);
                    j(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    j(bufferedWriter);
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void j(OutputStream outputStream, File file) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            j(fileInputStream2);
                            return;
                        }
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    fileInputStream = fileInputStream2;
                    vl.xt("FileUtils", e);
                    j(fileInputStream);
                } catch (IOException e7) {
                    e = e7;
                    fileInputStream = fileInputStream2;
                    vl.xt("FileUtils", e);
                    j(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    j(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void j(File file) {
        if (file.isDirectory()) {
            xt(file);
        } else {
            file.delete();
        }
    }
}
