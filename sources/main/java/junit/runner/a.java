package junit.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.framework.AssertionFailedError;
import junit.framework.f;
import junit.framework.i;
import junit.framework.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final String f43495b = "suite";

    /* renamed from: c, reason: collision with root package name */
    private static Properties f43496c = null;

    /* renamed from: d, reason: collision with root package name */
    static int f43497d = k("maxmessage", 500);

    /* renamed from: e, reason: collision with root package name */
    static boolean f43498e = true;

    /* renamed from: a, reason: collision with root package name */
    boolean f43499a = true;

    private static void r() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(n());
            } catch (IOException unused) {
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            try {
                w(new Properties(m()));
                m().load(fileInputStream);
                fileInputStream.close();
            } catch (IOException unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
    }

    public abstract void A(String str);

    @Override // junit.framework.i
    public synchronized void a(f fVar, Throwable th) {
        z(1, fVar, th);
    }

    @Override // junit.framework.i
    public synchronized void b(f fVar, AssertionFailedError assertionFailedError) {
        z(2, fVar, assertionFailedError);
    }

    @Override // junit.framework.i
    public synchronized void c(f fVar) {
        y(fVar.toString());
    }

    @Override // junit.framework.i
    public synchronized void d(f fVar) {
        A(fVar.toString());
    }

    protected String q(String[] strArr) {
        String str = null;
        int i6 = 0;
        while (i6 < strArr.length) {
            if (strArr[i6].equals("-noloading")) {
                u(false);
            } else if (strArr[i6].equals("-nofilterstack")) {
                f43498e = false;
            } else if (strArr[i6].equals("-c")) {
                i6++;
                if (strArr.length > i6) {
                    str = g(strArr[i6]);
                } else {
                    System.out.getClass();
                }
            } else {
                str = strArr[i6];
            }
            i6++;
        }
        return str;
    }

    protected abstract void s(String str);

    public abstract void y(String str);

    public abstract void z(int i6, f fVar, Throwable th);

    public static String B(String str) {
        if (f43497d == -1 || str.length() <= f43497d) {
            return str;
        }
        return str.substring(0, f43497d) + "...";
    }

    static boolean h(String str) {
        String[] strArr = {"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("};
        for (int i6 = 0; i6 < 8; i6++) {
            if (str.indexOf(strArr[i6]) > 0) {
                return true;
            }
        }
        return false;
    }

    public static String j(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return i(stringWriter.toString());
    }

    protected static Properties m() {
        if (f43496c == null) {
            Properties properties = new Properties();
            f43496c = properties;
            properties.put("loading", "true");
            f43496c.put("filterstack", "true");
            r();
        }
        return f43496c;
    }

    private static File n() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    public static void t() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(n());
        try {
            m().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    protected static void w(Properties properties) {
        f43496c = properties;
    }

    protected static boolean x() {
        return (l("filterstack").equals("true") && f43498e) ? false : true;
    }

    protected boolean C() {
        return l("loading").equals("true") && this.f43499a;
    }

    public String g(String str) {
        return str.startsWith("Default package for") ? str.substring(str.lastIndexOf(".") + 1) : str;
    }

    public f o(String str) {
        if (str.length() <= 0) {
            e();
            return null;
        }
        try {
            Class<?> p5 = p(str);
            try {
                Method method = p5.getMethod(f43495b, null);
                if (!Modifier.isStatic(method.getModifiers())) {
                    s("Suite() method must be static");
                    return null;
                }
                try {
                    f fVar = (f) method.invoke(null, null);
                    if (fVar == null) {
                        return fVar;
                    }
                    e();
                    return fVar;
                } catch (IllegalAccessException e6) {
                    s("Failed to invoke suite():" + e6.toString());
                    return null;
                } catch (InvocationTargetException e7) {
                    s("Failed to invoke suite():" + e7.getTargetException().toString());
                    return null;
                }
            } catch (Exception unused) {
                e();
                return new k(p5);
            }
        } catch (ClassNotFoundException e8) {
            String message = e8.getMessage();
            if (message != null) {
                str = message;
            }
            s("Class not found \"" + str + "\"");
            return null;
        } catch (Exception e9) {
            s("Error: " + e9.toString());
            return null;
        }
    }

    public void u(boolean z5) {
        this.f43499a = z5;
    }

    public static String i(String str) {
        if (!x()) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!h(readLine)) {
                            printWriter.println(readLine);
                        }
                    } else {
                        return stringWriter.toString();
                    }
                } catch (Exception unused) {
                    return str;
                }
            }
        } else {
            return str;
        }
    }

    public static int k(String str, int i6) {
        String l6 = l(str);
        if (l6 == null) {
            return i6;
        }
        try {
            return Integer.parseInt(l6);
        } catch (NumberFormatException unused) {
            return i6;
        }
    }

    public static String l(String str) {
        return m().getProperty(str);
    }

    public static void v(String str, String str2) {
        m().put(str, str2);
    }

    public String f(long j6) {
        return NumberFormat.getInstance().format(j6 / 1000.0d);
    }

    protected Class<?> p(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    protected void e() {
    }
}
