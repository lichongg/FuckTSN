package com.huawei.hms.hatool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class i0 {
    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    y yVar = new y(1024);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        yVar.a(bArr, read);
                    }
                    if (yVar.c() == 0) {
                        c(fileInputStream);
                        return "";
                    }
                    String str = new String(yVar.b(), "UTF-8");
                    c(fileInputStream);
                    return str;
                } catch (FileNotFoundException unused) {
                    fileInputStream2 = fileInputStream;
                    j1.m("hmsSdk", "getInfoFromFile(): No files need to be read");
                    c(fileInputStream2);
                    return "";
                } catch (IOException unused2) {
                    fileInputStream2 = fileInputStream;
                    j1.m("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                    c(fileInputStream2);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    c(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                    c(byteArrayOutputStream);
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            c(byteArrayOutputStream);
            throw th;
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                j1.m("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static void d(File file, String str) {
        String str2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th) {
                th = th;
                c(fileOutputStream2);
                throw th;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
            } catch (FileNotFoundException unused3) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): No files need to be read";
                fileOutputStream = fileOutputStream2;
                j1.m("hmsSdk", str2);
                c(fileOutputStream);
            } catch (IOException unused4) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): io exc from write info to file!";
                fileOutputStream = fileOutputStream2;
                j1.m("hmsSdk", str2);
                c(fileOutputStream);
            }
            c(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            c(fileOutputStream2);
            throw th;
        }
    }

    private static void e(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                j1.m("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    public static void f(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            j1.m("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        j1.b("hmsSdk", " connHttp disconnect");
    }

    public static byte[] g(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        e(byteArrayOutputStream);
        return byteArray;
    }
}
