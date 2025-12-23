package com.sun.mail.imap.protocol;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sun.mail.iap.ParsingException;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Vector;
import javax.mail.internet.ParameterList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d implements l {

    /* renamed from: r, reason: collision with root package name */
    static final char[] f39401r = {'B', 'O', 'D', 'Y', 'S', 'T', 'R', 'U', 'C', 'T', 'U', 'R', 'E'};

    /* renamed from: s, reason: collision with root package name */
    private static int f39402s = 1;

    /* renamed from: t, reason: collision with root package name */
    private static int f39403t = 2;

    /* renamed from: u, reason: collision with root package name */
    private static int f39404u = 3;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f39405v;

    /* renamed from: a, reason: collision with root package name */
    public int f39406a;

    /* renamed from: b, reason: collision with root package name */
    public String f39407b;

    /* renamed from: c, reason: collision with root package name */
    public String f39408c;

    /* renamed from: d, reason: collision with root package name */
    public String f39409d;

    /* renamed from: e, reason: collision with root package name */
    public int f39410e;

    /* renamed from: f, reason: collision with root package name */
    public int f39411f;

    /* renamed from: g, reason: collision with root package name */
    public String f39412g;

    /* renamed from: h, reason: collision with root package name */
    public String f39413h;

    /* renamed from: i, reason: collision with root package name */
    public String f39414i;

    /* renamed from: j, reason: collision with root package name */
    public String f39415j;

    /* renamed from: k, reason: collision with root package name */
    public String f39416k;

    /* renamed from: l, reason: collision with root package name */
    public ParameterList f39417l;

    /* renamed from: m, reason: collision with root package name */
    public ParameterList f39418m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f39419n;

    /* renamed from: o, reason: collision with root package name */
    public d[] f39420o;

    /* renamed from: p, reason: collision with root package name */
    public e f39421p;

    /* renamed from: q, reason: collision with root package name */
    private int f39422q;

    static {
        boolean z5 = true;
        f39405v = false;
        try {
            String property = System.getProperty("mail.imap.parse.debug");
            if (property == null || !property.equalsIgnoreCase("true")) {
                z5 = false;
            }
            f39405v = z5;
        } catch (SecurityException unused) {
        }
    }

    public boolean a() {
        return this.f39422q == f39403t;
    }

    public boolean b() {
        return this.f39422q == f39404u;
    }

    public boolean c() {
        return this.f39422q == f39402s;
    }

    public d(f fVar) throws ParsingException {
        this.f39410e = -1;
        this.f39411f = -1;
        if (f39405v) {
            System.out.getClass();
        }
        this.f39406a = fVar.E();
        if (f39405v) {
            System.out.getClass();
        }
        fVar.B();
        if (fVar.r() == 40) {
            if (fVar.n() == 40) {
                if (f39405v) {
                    System.out.getClass();
                }
                this.f39407b = "multipart";
                this.f39422q = f39403t;
                Vector vector = new Vector(1);
                do {
                    vector.addElement(new d(fVar));
                    fVar.B();
                } while (fVar.n() == 40);
                d[] dVarArr = new d[vector.size()];
                this.f39420o = dVarArr;
                vector.copyInto(dVarArr);
                this.f39408c = fVar.w();
                if (f39405v) {
                    System.out.getClass();
                }
                if (fVar.r() == 41) {
                    if (f39405v) {
                        System.out.getClass();
                        return;
                    }
                    return;
                }
                if (f39405v) {
                    System.out.getClass();
                }
                this.f39417l = e(fVar);
                if (fVar.r() == 41) {
                    if (f39405v) {
                        System.out.getClass();
                        return;
                    }
                    return;
                }
                byte r5 = fVar.r();
                if (r5 == 40) {
                    if (f39405v) {
                        System.out.getClass();
                    }
                    this.f39412g = fVar.w();
                    if (f39405v) {
                        System.out.getClass();
                    }
                    this.f39418m = e(fVar);
                    if (fVar.r() == 41) {
                        if (f39405v) {
                            System.out.getClass();
                        }
                    } else {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition in multipart");
                    }
                } else {
                    if (r5 != 78 && r5 != 110) {
                        throw new ParsingException("BODYSTRUCTURE parse error: " + this.f39407b + "/" + this.f39408c + ": bad multipart disposition, b " + ((int) r5));
                    }
                    if (f39405v) {
                        System.out.getClass();
                    }
                    fVar.A(2);
                }
                byte r6 = fVar.r();
                if (r6 == 41) {
                    if (f39405v) {
                        System.out.getClass();
                        return;
                    }
                    return;
                }
                if (r6 == 32) {
                    if (fVar.n() == 40) {
                        this.f39419n = fVar.y();
                        if (f39405v) {
                            PrintStream printStream = System.out;
                            int length = this.f39419n.length;
                            printStream.getClass();
                        }
                    } else {
                        String w5 = fVar.w();
                        if (w5 != null) {
                            this.f39419n = new String[]{w5};
                            if (f39405v) {
                                System.out.getClass();
                            }
                        }
                    }
                    while (fVar.r() == 32) {
                        d(fVar);
                    }
                    return;
                }
                throw new ParsingException("BODYSTRUCTURE parse error: missing space after disposition");
            }
            if (f39405v) {
                System.out.getClass();
            }
            this.f39407b = fVar.w();
            if (f39405v) {
                System.out.getClass();
            }
            this.f39422q = f39402s;
            this.f39408c = fVar.w();
            if (f39405v) {
                System.out.getClass();
            }
            if (this.f39407b == null) {
                this.f39407b = "application";
                this.f39408c = "octet-stream";
            }
            this.f39417l = e(fVar);
            if (f39405v) {
                PrintStream printStream2 = System.out;
                Objects.toString(this.f39417l);
                printStream2.getClass();
            }
            this.f39413h = fVar.w();
            if (f39405v) {
                System.out.getClass();
            }
            this.f39414i = fVar.w();
            if (f39405v) {
                System.out.getClass();
            }
            this.f39409d = fVar.w();
            if (f39405v) {
                System.out.getClass();
            }
            this.f39411f = fVar.v();
            if (f39405v) {
                System.out.getClass();
            }
            if (this.f39411f >= 0) {
                if (this.f39407b.equalsIgnoreCase(com.baidu.mobads.sdk.internal.a.f10501b)) {
                    this.f39410e = fVar.v();
                    if (f39405v) {
                        System.out.getClass();
                    }
                    if (this.f39410e < 0) {
                        throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                    }
                } else if (this.f39407b.equalsIgnoreCase(CrashHianalyticsData.MESSAGE) && this.f39408c.equalsIgnoreCase("rfc822")) {
                    this.f39422q = f39404u;
                    this.f39421p = new e(fVar);
                    this.f39420o = new d[]{new d(fVar)};
                    this.f39410e = fVar.v();
                    if (f39405v) {
                        System.out.getClass();
                    }
                    if (this.f39410e < 0) {
                        throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                    }
                } else {
                    fVar.B();
                    if (Character.isDigit((char) fVar.n())) {
                        throw new ParsingException("BODYSTRUCTURE parse error: server erroneously included ``lines'' element with type " + this.f39407b + "/" + this.f39408c);
                    }
                }
                if (fVar.n() == 41) {
                    fVar.r();
                    if (f39405v) {
                        System.out.getClass();
                        return;
                    }
                    return;
                }
                this.f39415j = fVar.w();
                if (fVar.r() == 41) {
                    if (f39405v) {
                        System.out.getClass();
                        return;
                    }
                    return;
                }
                byte r7 = fVar.r();
                if (r7 == 40) {
                    this.f39412g = fVar.w();
                    if (f39405v) {
                        System.out.getClass();
                    }
                    this.f39418m = e(fVar);
                    if (f39405v) {
                        PrintStream printStream3 = System.out;
                        Objects.toString(this.f39418m);
                        printStream3.getClass();
                    }
                    if (fVar.r() != 41) {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition");
                    }
                } else {
                    if (r7 != 78 && r7 != 110) {
                        throw new ParsingException("BODYSTRUCTURE parse error: " + this.f39407b + "/" + this.f39408c + ": bad single part disposition, b " + ((int) r7));
                    }
                    if (f39405v) {
                        System.out.getClass();
                    }
                    fVar.A(2);
                }
                if (fVar.r() == 41) {
                    if (f39405v) {
                        System.out.getClass();
                        return;
                    }
                    return;
                }
                if (fVar.n() == 40) {
                    this.f39419n = fVar.y();
                    if (f39405v) {
                        PrintStream printStream4 = System.out;
                        int length2 = this.f39419n.length;
                        printStream4.getClass();
                    }
                } else {
                    String w6 = fVar.w();
                    if (w6 != null) {
                        this.f39419n = new String[]{w6};
                        if (f39405v) {
                            System.out.getClass();
                        }
                    }
                }
                while (fVar.r() == 32) {
                    d(fVar);
                }
                if (f39405v) {
                    System.out.getClass();
                    return;
                }
                return;
            }
            throw new ParsingException("BODYSTRUCTURE parse error: bad ``size'' element");
        }
        throw new ParsingException("BODYSTRUCTURE parse error: missing ``('' at start");
    }

    private void d(com.sun.mail.iap.g gVar) throws ParsingException {
        gVar.B();
        byte n6 = gVar.n();
        if (n6 == 40) {
            gVar.A(1);
            do {
                d(gVar);
            } while (gVar.r() != 41);
        } else if (Character.isDigit((char) n6)) {
            gVar.v();
        } else {
            gVar.w();
        }
    }

    private ParameterList e(com.sun.mail.iap.g gVar) throws ParsingException {
        gVar.B();
        byte r5 = gVar.r();
        if (r5 == 40) {
            ParameterList parameterList = new ParameterList();
            do {
                String w5 = gVar.w();
                if (f39405v) {
                    System.out.getClass();
                }
                if (w5 != null) {
                    String w6 = gVar.w();
                    if (f39405v) {
                        System.out.getClass();
                    }
                    parameterList.set(w5, w6);
                } else {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.f39407b + "/" + this.f39408c + ": null name in parameter list");
                }
            } while (gVar.r() != 41);
            parameterList.set(null, "DONE");
            return parameterList;
        }
        if (r5 != 78 && r5 != 110) {
            throw new ParsingException("Parameter list parse error");
        }
        if (f39405v) {
            System.out.getClass();
        }
        gVar.A(2);
        return null;
    }
}
