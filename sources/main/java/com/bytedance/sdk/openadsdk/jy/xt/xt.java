package com.bytedance.sdk.openadsdk.jy.xt;

import com.bytedance.sdk.component.utils.vl;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static int j(InputStream inputStream, OutputStream outputStream) {
        long xt = xt(inputStream, outputStream);
        if (xt > 2147483647L) {
            return -1;
        }
        return (int) xt;
    }

    public static boolean j(HashMap<String, HashMap<String, byte[]>> hashMap, String str) {
        try {
            Set<String> keySet = hashMap.keySet();
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            byte[] bArr = new byte[4096];
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                HashMap<String, byte[]> hashMap2 = hashMap.get(it.next());
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        byte[] bArr2 = hashMap2.get(str2);
                        if (bArr2 != null) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
                            zipOutputStream.putNextEntry(new ZipEntry(str2));
                            while (true) {
                                int read = byteArrayInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            byteArrayInputStream.close();
                        }
                    }
                }
            }
            zipOutputStream.close();
            return true;
        } catch (Exception e6) {
            vl.j(e6);
            return false;
        }
    }

    private static long xt(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j6 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return j6;
                }
                outputStream.write(bArr, 0, read);
                j6 += read;
            } catch (Exception unused) {
                return 0L;
            }
        }
    }

    public static void j(String str, String str2) {
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                byte[] bArr = new byte[4096];
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
                for (String str3 : list) {
                    File file2 = new File(file, str3);
                    if (!file2.isDirectory()) {
                        String path = file2.getPath();
                        int lastIndexOf = path.lastIndexOf("/");
                        if (lastIndexOf != -1 && lastIndexOf != path.length()) {
                            path = path.substring(lastIndexOf + 1);
                        }
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        zipOutputStream.putNextEntry(new ZipEntry(path));
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileInputStream.close();
                    }
                }
                zipOutputStream.close();
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }
}
