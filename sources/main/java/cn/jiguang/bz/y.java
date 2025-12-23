package cn.jiguang.bz;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.m.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\Downloads\app\classes2.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2798a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f2799b = new ConcurrentHashMap<>();

    public static long a() {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static String b(String str, boolean z5) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z5) {
                bytes = a(bytes);
            }
            String str2 = c.a.f3106j;
            return Base64.encodeToString(v.a(bytes, str2, str2, true), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static short c(byte[] bArr) {
        int i6;
        if (bArr == null || bArr.length == 0) {
            throw new Exception("byte could not be empty");
        }
        if (bArr.length == 1) {
            i6 = bArr[0];
        } else {
            i6 = ((short) (bArr[1] & 255)) | ((short) ((bArr[0] & 255) << 8));
        }
        return (short) i6;
    }

    public static String a(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            if (z5) {
                decode = b(decode);
            }
            String str2 = c.a.f3106j;
            return new String(v.a(decode, str2, str2, false));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b(long j6, long j7) {
        if (j7 <= 0) {
            throw new AssertionError();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j6 <= 0 || elapsedRealtime <= j6 || elapsedRealtime > j6 + j7;
    }

    public static LinkedHashSet<String> a(Context context, LinkedHashSet<String> linkedHashSet) {
        if (b.e(context)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.contains("ipv6")) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            linkedHashSet.clear();
            linkedHashSet.addAll(arrayList);
            linkedHashSet.addAll(arrayList2);
        }
        return linkedHashSet;
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th2) {
            gZIPInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    a((Closeable) byteArrayInputStream);
                    a((Closeable) gZIPInputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            a(byteArrayOutputStream);
            a((Closeable) byteArrayInputStream);
            a((Closeable) gZIPInputStream);
            throw th;
        }
    }

    public static LinkedList<InetAddress> a(Context context, LinkedList<InetAddress> linkedList) {
        if (!b.e(context)) {
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        Iterator<InetAddress> it = linkedList.iterator();
        while (it.hasNext()) {
            InetAddress next = it.next();
            if (next instanceof Inet6Address) {
                linkedList2.add(next);
            } else if (next instanceof Inet4Address) {
                linkedList3.add(next);
            }
        }
        linkedList.clear();
        linkedList.addAll(linkedList2);
        linkedList.addAll(linkedList3);
        return linkedList;
    }

    public static <T> LinkedList<T> a(Collection<T> collection) {
        LinkedList<T> linkedList = new LinkedList<>();
        int i6 = 0;
        int size = collection != null ? collection.size() : 0;
        if (size != 0) {
            if (size == 1) {
                linkedList.addAll(collection);
                return linkedList;
            }
            SecureRandom secureRandom = new SecureRandom();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                i6++;
                linkedList.add(secureRandom.nextInt(i6), it.next());
            }
        }
        return linkedList;
    }

    public static List<cn.jiguang.bg.g> a(List<cn.jiguang.bg.g> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < list.size() - 1; i6++) {
            cn.jiguang.bg.g gVar = list.get(i6);
            if (gVar.f2081a.contains("ipv6")) {
                arrayList.add(gVar);
            } else {
                arrayList2.add(gVar);
            }
        }
        list.clear();
        list.addAll(arrayList);
        list.addAll(arrayList2);
        return list;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            try {
                File file = new File(str);
                a(zipOutputStream, file, file.getName());
                zipOutputStream.flush();
                zipOutputStream.close();
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(zipOutputStream, file2, str + "/" + file2.getName());
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            zipOutputStream.putNextEntry(new ZipEntry(str));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read < 0) {
                    fileInputStream.close();
                    zipOutputStream.closeEntry();
                    return;
                }
                zipOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean a(long j6, long j7) {
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTimeInMillis(j6);
            calendar2.setTimeInMillis(j7);
            if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1)) {
                if (calendar.get(6) == calendar2.get(6)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        a(byteArrayOutputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(byteArrayOutputStream);
            a(gZIPOutputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            a(byteArrayOutputStream);
            a(gZIPOutputStream2);
            throw th;
        }
    }
}
