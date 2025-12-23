package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ck;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bu {

    /* renamed from: a, reason: collision with root package name */
    private final cq f41065a;

    /* renamed from: b, reason: collision with root package name */
    private final dd f41066b;

    public bu() {
        this(new ck.a());
    }

    public void a(br brVar, byte[] bArr) throws bx {
        try {
            this.f41066b.a(bArr);
            brVar.read(this.f41065a);
        } finally {
            this.f41066b.e();
            this.f41065a.B();
        }
    }

    public Byte b(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Byte) a((byte) 3, bArr, byVar, byVarArr);
    }

    public Double c(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Double) a((byte) 4, bArr, byVar, byVarArr);
    }

    public Short d(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Short) a((byte) 6, bArr, byVar, byVarArr);
    }

    public bu(cs csVar) {
        dd ddVar = new dd();
        this.f41066b = ddVar;
        this.f41065a = csVar.a(ddVar);
    }

    private cl j(byte[] bArr, by byVar, by... byVarArr) throws bx {
        this.f41066b.a(bArr);
        int length = byVarArr.length + 1;
        by[] byVarArr2 = new by[length];
        int i6 = 0;
        byVarArr2[0] = byVar;
        int i7 = 0;
        while (i7 < byVarArr.length) {
            int i8 = i7 + 1;
            byVarArr2[i8] = byVarArr[i7];
            i7 = i8;
        }
        this.f41065a.j();
        cl clVar = null;
        while (i6 < length) {
            clVar = this.f41065a.l();
            if (clVar.f41141b == 0 || clVar.f41142c > byVarArr2[i6].a()) {
                return null;
            }
            if (clVar.f41142c != byVarArr2[i6].a()) {
                ct.a(this.f41065a, clVar.f41141b);
                this.f41065a.m();
            } else {
                i6++;
                if (i6 < length) {
                    this.f41065a.j();
                }
            }
        }
        return clVar;
    }

    public Integer e(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Integer) a((byte) 8, bArr, byVar, byVarArr);
    }

    public Long f(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Long) a((byte) 10, bArr, byVar, byVarArr);
    }

    public String g(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (String) a((byte) 11, bArr, byVar, byVarArr);
    }

    public ByteBuffer h(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (ByteBuffer) a((byte) 100, bArr, byVar, byVarArr);
    }

    public Short i(byte[] bArr, by byVar, by... byVarArr) throws bx {
        try {
            try {
                if (j(bArr, byVar, byVarArr) != null) {
                    this.f41065a.j();
                    return Short.valueOf(this.f41065a.l().f41142c);
                }
                this.f41066b.e();
                this.f41065a.B();
                return null;
            } catch (Exception e6) {
                throw new bx(e6);
            }
        } finally {
            this.f41066b.e();
            this.f41065a.B();
        }
    }

    public void a(br brVar, String str, String str2) throws bx {
        try {
            try {
                a(brVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bx("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f41065a.B();
        }
    }

    public void a(br brVar, byte[] bArr, by byVar, by... byVarArr) throws bx {
        try {
            try {
                if (j(bArr, byVar, byVarArr) != null) {
                    brVar.read(this.f41065a);
                }
            } catch (Exception e6) {
                throw new bx(e6);
            }
        } finally {
            this.f41066b.e();
            this.f41065a.B();
        }
    }

    public Boolean a(byte[] bArr, by byVar, by... byVarArr) throws bx {
        return (Boolean) a((byte) 2, bArr, byVar, byVarArr);
    }

    private Object a(byte b6, byte[] bArr, by byVar, by... byVarArr) throws bx {
        try {
            try {
                cl j6 = j(bArr, byVar, byVarArr);
                if (j6 != null) {
                    if (b6 != 2) {
                        if (b6 != 3) {
                            if (b6 != 4) {
                                if (b6 != 6) {
                                    if (b6 != 8) {
                                        if (b6 != 100) {
                                            if (b6 != 10) {
                                                if (b6 == 11 && j6.f41141b == 11) {
                                                    return this.f41065a.z();
                                                }
                                            } else if (j6.f41141b == 10) {
                                                return Long.valueOf(this.f41065a.x());
                                            }
                                        } else if (j6.f41141b == 11) {
                                            return this.f41065a.A();
                                        }
                                    } else if (j6.f41141b == 8) {
                                        return Integer.valueOf(this.f41065a.w());
                                    }
                                } else if (j6.f41141b == 6) {
                                    return Short.valueOf(this.f41065a.v());
                                }
                            } else if (j6.f41141b == 4) {
                                return Double.valueOf(this.f41065a.y());
                            }
                        } else if (j6.f41141b == 3) {
                            return Byte.valueOf(this.f41065a.u());
                        }
                    } else if (j6.f41141b == 2) {
                        return Boolean.valueOf(this.f41065a.t());
                    }
                }
                this.f41066b.e();
                this.f41065a.B();
                return null;
            } catch (Exception e6) {
                throw new bx(e6);
            }
        } finally {
            this.f41066b.e();
            this.f41065a.B();
        }
    }

    public void a(br brVar, String str) throws bx {
        a(brVar, str.getBytes());
    }
}
