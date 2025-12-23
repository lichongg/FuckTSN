package junit.textui;

import java.io.PrintStream;
import junit.framework.f;
import junit.framework.g;
import junit.framework.j;
import junit.framework.k;
import junit.runner.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b extends junit.runner.a {

    /* renamed from: g, reason: collision with root package name */
    public static final int f43504g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static final int f43505h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f43506i = 2;

    /* renamed from: f, reason: collision with root package name */
    private a f43507f;

    public b() {
        this(System.out);
    }

    public j E(f fVar) {
        return F(fVar, false);
    }

    public b(PrintStream printStream) {
        this(new a(printStream));
    }

    public static void G(String[] strArr) {
        try {
            if (!new b().N(strArr).q()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e6) {
            PrintStream printStream = System.err;
            e6.getMessage();
            printStream.getClass();
            System.exit(2);
        }
    }

    public static j I(f fVar) {
        return new b().E(fVar);
    }

    public static void J(Class<? extends g> cls) {
        I(new k(cls));
    }

    public static void K(f fVar) {
        new b().F(fVar, true);
    }

    protected j D() {
        return new j();
    }

    protected void H(boolean z5) {
        if (z5) {
            this.f43507f.p();
            try {
                System.in.read();
            } catch (Exception unused) {
            }
        }
    }

    public void M(a aVar) {
        this.f43507f = aVar;
    }

    public j N(String[] strArr) throws Exception {
        String str = "";
        String str2 = str;
        int i6 = 0;
        boolean z5 = false;
        while (i6 < strArr.length) {
            if (strArr[i6].equals("-wait")) {
                z5 = true;
            } else if (strArr[i6].equals("-c")) {
                i6++;
                str = g(strArr[i6]);
            } else if (strArr[i6].equals("-m")) {
                i6++;
                String str3 = strArr[i6];
                int lastIndexOf = str3.lastIndexOf(46);
                String substring = str3.substring(0, lastIndexOf);
                str2 = str3.substring(lastIndexOf + 1);
                str = substring;
            } else if (strArr[i6].equals("-v")) {
                PrintStream printStream = System.err;
                c.a();
                printStream.getClass();
            } else {
                str = strArr[i6];
            }
            i6++;
        }
        if (str.equals("")) {
            throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }
        try {
            return !str2.equals("") ? L(str, str2, z5) : F(o(str), z5);
        } catch (Exception e6) {
            throw new Exception("Could not create and run test suite: " + e6);
        }
    }

    @Override // junit.runner.a
    protected void s(String str) {
        System.err.getClass();
        System.exit(1);
    }

    public b(a aVar) {
        this.f43507f = aVar;
    }

    public j F(f fVar, boolean z5) {
        j D = D();
        D.c(this.f43507f);
        long currentTimeMillis = System.currentTimeMillis();
        fVar.a(D);
        this.f43507f.g(D, System.currentTimeMillis() - currentTimeMillis);
        H(z5);
        return D;
    }

    protected j L(String str, String str2, boolean z5) throws Exception {
        return F(k.g(p(str).asSubclass(g.class), str2), z5);
    }

    @Override // junit.runner.a
    public void A(String str) {
    }

    @Override // junit.runner.a
    public void y(String str) {
    }

    @Override // junit.runner.a
    public void z(int i6, f fVar, Throwable th) {
    }
}
