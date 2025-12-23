package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected Vector f39175a = new Vector(1);

    private void e(byte[] bArr, f fVar) throws IOException, ProtocolException {
        f(fVar, bArr.length).write(bArr);
    }

    public void a(b bVar) {
        Vector vector = this.f39175a;
        vector.ensureCapacity(vector.size() + bVar.f39175a.size());
        for (int i6 = 0; i6 < bVar.f39175a.size(); i6++) {
            this.f39175a.addElement(bVar.f39175a.elementAt(i6));
        }
    }

    public void g(f fVar) throws IOException, ProtocolException {
        Vector vector = this.f39175a;
        int size = vector != null ? vector.size() : 0;
        DataOutputStream dataOutputStream = (DataOutputStream) fVar.e();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 > 0) {
                dataOutputStream.write(32);
            }
            Object elementAt = this.f39175a.elementAt(i6);
            if (elementAt instanceof c) {
                dataOutputStream.writeBytes(((c) elementAt).f39176a);
            } else if (elementAt instanceof Number) {
                dataOutputStream.writeBytes(((Number) elementAt).toString());
            } else if (elementAt instanceof a) {
                b(((a) elementAt).f39174a, fVar);
            } else if (elementAt instanceof byte[]) {
                e((byte[]) elementAt, fVar);
            } else if (elementAt instanceof ByteArrayOutputStream) {
                d((ByteArrayOutputStream) elementAt, fVar);
            } else if (elementAt instanceof e) {
                c((e) elementAt, fVar);
            } else if (elementAt instanceof b) {
                dataOutputStream.write(40);
                ((b) elementAt).g(fVar);
                dataOutputStream.write(41);
            }
        }
    }

    public void h(b bVar) {
        this.f39175a.addElement(bVar);
    }

    public void i(String str) {
        this.f39175a.addElement(new c(str));
    }

    public void j(e eVar) {
        this.f39175a.addElement(eVar);
    }

    public void k(ByteArrayOutputStream byteArrayOutputStream) {
        this.f39175a.addElement(byteArrayOutputStream);
    }

    public void l(byte[] bArr) {
        this.f39175a.addElement(bArr);
    }

    public void m(int i6) {
        this.f39175a.addElement(new Integer(i6));
    }

    public void n(long j6) {
        this.f39175a.addElement(new Long(j6));
    }

    public void o(String str) {
        this.f39175a.addElement(new a(ASCIIUtility.getBytes(str)));
    }

    public void p(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            o(str);
        } else {
            this.f39175a.addElement(new a(str.getBytes(str2)));
        }
    }

    private void b(byte[] bArr, f fVar) throws IOException, ProtocolException {
        boolean z5;
        int i6;
        DataOutputStream dataOutputStream = (DataOutputStream) fVar.e();
        int length = bArr.length;
        if (length > 1024) {
            e(bArr, fVar);
            return;
        }
        if (length == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z6 = false;
        for (byte b6 : bArr) {
            if (b6 != 0 && b6 != 13 && b6 != 10 && (i6 = b6 & 255) <= 127) {
                if (b6 == 42 || b6 == 37 || b6 == 40 || b6 == 41 || b6 == 123 || b6 == 34 || b6 == 92 || i6 <= 32) {
                    if (b6 != 34 && b6 != 92) {
                        z5 = true;
                    } else {
                        z5 = true;
                        z6 = true;
                    }
                }
            } else {
                e(bArr, fVar);
                return;
            }
        }
        if (z5) {
            dataOutputStream.write(34);
        }
        if (z6) {
            for (byte b7 : bArr) {
                if (b7 == 34 || b7 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b7);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z5) {
            dataOutputStream.write(34);
        }
    }

    private void c(e eVar, f fVar) throws IOException, ProtocolException {
        eVar.writeTo(f(fVar, eVar.size()));
    }

    private void d(ByteArrayOutputStream byteArrayOutputStream, f fVar) throws IOException, ProtocolException {
        byteArrayOutputStream.writeTo(f(fVar, byteArrayOutputStream.size()));
    }

    private OutputStream f(f fVar, int i6) throws IOException, ProtocolException {
        g l6;
        DataOutputStream dataOutputStream = (DataOutputStream) fVar.e();
        boolean p5 = fVar.p();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i6));
        if (p5) {
            dataOutputStream.writeBytes("+}\r\n");
        } else {
            dataOutputStream.writeBytes("}\r\n");
        }
        dataOutputStream.flush();
        if (!p5) {
            do {
                l6 = fVar.l();
                if (l6.f()) {
                }
            } while (!l6.j());
            throw new LiteralException(l6);
        }
        return dataOutputStream;
    }
}
