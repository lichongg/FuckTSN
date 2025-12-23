package cn.jpush.android.ad;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.camera.view.p;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3488a = d.b(new byte[]{85, 118, 97, BinaryMemcacheOpcodes.SASL_AUTH, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, HttpConstants.COMMA});

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3489b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f3490c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicReference<Context> f3491d = new AtomicReference<>();

    private static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a, reason: collision with root package name */
        private String f3492a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f3492a, Locale.ENGLISH);
        }

        a(String str) {
            this.f3492a = str;
        }
    }

    public static double a(double d6, double d7, double d8, double d9) {
        double d10 = d7 * 0.008726646259971648d;
        double d11 = d9 * 0.008726646259971648d;
        return Math.round((Math.asin(Math.sqrt(Math.pow(Math.sin(d10 - d11), 2.0d) + ((Math.cos(d10 * 2.0d) * Math.cos(d11 * 2.0d)) * Math.pow(Math.sin((d6 - d8) * 0.008726646259971648d), 2.0d)))) * 1.2756274E7d) * 10000.0d) / 10000;
    }

    public static int b(Context context, int i6) {
        return (int) (a(context).widthPixels * (i6 / 375.0f));
    }

    public static int c(Context context, int i6) {
        return (int) (a(context).heightPixels * (i6 / 667.0f));
    }

    private static Object d() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Object e() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(Context context, int i6) {
        return context == null ? i6 : (int) TypedValue.applyDimension(1, i6, context.getResources().getDisplayMetrics());
    }

    public static int b(String str) {
        try {
            return Integer.valueOf(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim()).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static Object c() {
        Object d6 = d();
        return d6 != null ? d6 : e();
    }

    public static Context a() {
        return b((Context) null);
    }

    public static Application b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", null).invoke(c(), null);
            if (invoke == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static LinkedList<String> c(String str) {
        try {
            LinkedList<String> linkedList = new LinkedList<>();
            if (str != null && str.length() > 0) {
                for (String str2 : str.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        linkedList.add(str2);
                    }
                }
            }
            return linkedList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static DisplayMetrics a(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static Context b(Context context) {
        AtomicReference<Context> atomicReference = f3491d;
        Context context2 = atomicReference.get();
        if (context2 != null) {
            return context2;
        }
        Context origApplicationContext = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : b();
        return !p.a(atomicReference, null, origApplicationContext) ? atomicReference.get() : origApplicationContext;
    }

    public static ViewGroup.LayoutParams a(Context context, View view, boolean z5, int i6, int i7, int i8, int i9) {
        if (context == null || view == null) {
            return null;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : new ViewGroup.MarginLayoutParams(layoutParams);
            if (z5) {
                i6 = a(context, i6);
                i8 = a(context, i8);
                i7 = a(context, i7);
                i9 = a(context, i9);
            }
            marginLayoutParams.setMargins(i6, i7, i8, i9);
            view.setLayoutParams(marginLayoutParams);
            return marginLayoutParams;
        } catch (Throwable th) {
            Logger.w("Utils", "[setViewMargin] failed. err: " + th.getMessage());
            return null;
        }
    }

    public static byte[] b(InputStream inputStream) {
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

    public static String a(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f3490c.get(str);
        if (threadLocal == null) {
            synchronized (f3489b) {
                try {
                    threadLocal = f3490c.get(str);
                    if (threadLocal == null) {
                        threadLocal = new a(str);
                        f3490c.put(str, threadLocal);
                    }
                } finally {
                }
            }
        }
        return threadLocal.get();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                String optString = jSONArray.optString(i6);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    public static void a(Context context, List<String> list) {
        if (!JCoreHelper.isIpv6Priority(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
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
}
