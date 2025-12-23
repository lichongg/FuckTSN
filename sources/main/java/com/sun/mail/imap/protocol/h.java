package com.sun.mail.imap.protocol;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.LiteralException;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.mail.Flags;
import javax.mail.Quota;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends com.sun.mail.iap.f {
    private static final byte[] A = {13, 10};
    private static final byte[] B = {68, 79, 78, 69, 13, 10};

    /* renamed from: q, reason: collision with root package name */
    private boolean f39442q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f39443r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f39444s;

    /* renamed from: t, reason: collision with root package name */
    private Map f39445t;

    /* renamed from: u, reason: collision with root package name */
    private List f39446u;

    /* renamed from: v, reason: collision with root package name */
    private String[] f39447v;

    /* renamed from: w, reason: collision with root package name */
    private String f39448w;

    /* renamed from: x, reason: collision with root package name */
    private s f39449x;

    /* renamed from: y, reason: collision with root package name */
    private com.sun.mail.iap.d f39450y;

    /* renamed from: z, reason: collision with root package name */
    private String f39451z;

    private com.sun.mail.iap.g[] K(String str, String str2, boolean z5) throws ProtocolException {
        if (z5) {
            return b("UID FETCH " + str + " (" + str2 + ")", null);
        }
        return b("FETCH " + str + " (" + str2 + ")", null);
    }

    private void N0(String str, Flags flags, boolean z5) throws ProtocolException {
        com.sun.mail.iap.g[] b6;
        if (z5) {
            b6 = b("STORE " + str + " +FLAGS " + D(flags), null);
        } else {
            b6 = b("STORE " + str + " -FLAGS " + D(flags), null);
        }
        j(b6);
        h(b6[b6.length - 1]);
    }

    private int[] j0(String str, SearchTerm searchTerm, String str2) throws ProtocolException, SearchException, IOException {
        int[] iArr = null;
        com.sun.mail.iap.b e6 = t.e(searchTerm, str2 == null ? null : MimeUtility.javaCharset(str2));
        e6.i(str);
        com.sun.mail.iap.g[] b6 = str2 == null ? b("SEARCH", e6) : b("SEARCH CHARSET " + str2, e6);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        if (gVar.h()) {
            Vector vector = new Vector();
            int length = b6.length;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("SEARCH")) {
                        while (true) {
                            int v5 = iVar.v();
                            if (v5 == -1) {
                                break;
                            }
                            vector.addElement(new Integer(v5));
                        }
                        b6[i6] = null;
                    }
                }
            }
            int size = vector.size();
            int[] iArr2 = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr2[i7] = ((Integer) vector.elementAt(i7)).intValue();
            }
            iArr = iArr2;
        }
        j(b6);
        h(gVar);
        return iArr;
    }

    public c M(int i6, String str) throws ProtocolException {
        return Q(i6, str, false);
    }

    public c N(int i6, String str, int i7, int i8) throws ProtocolException {
        return P(i6, str, i7, i8, false, null);
    }

    public c O(int i6, String str, int i7, int i8, com.sun.mail.iap.d dVar) throws ProtocolException {
        return P(i6, str, i7, i8, false, dVar);
    }

    public synchronized void g0() throws ProtocolException {
        com.sun.mail.iap.g a6;
        if (!e0("IDLE")) {
            throw new BadCommandException("IDLE not supported");
        }
        try {
            this.f39451z = q("IDLE", null);
            a6 = l();
        } catch (LiteralException e6) {
            a6 = e6.getResponse();
        } catch (Exception e7) {
            a6 = com.sun.mail.iap.g.a(e7);
        }
        if (!a6.f()) {
            h(a6);
        }
    }

    public void r(String str, Flags flags, Date date, com.sun.mail.iap.e eVar) throws ProtocolException {
        t(str, flags, date, eVar, false);
    }

    public com.sun.mail.imap.b s(String str, Flags flags, Date date, com.sun.mail.iap.e eVar) throws ProtocolException {
        return t(str, flags, date, eVar, true);
    }

    public synchronized void u(String str, String str2) throws ProtocolException {
        com.sun.mail.iap.g a6;
        boolean z5;
        String str3;
        Vector vector = new Vector();
        String str4 = null;
        try {
            a6 = null;
            str4 = q("AUTHENTICATE LOGIN", null);
            z5 = false;
        } catch (Exception e6) {
            a6 = com.sun.mail.iap.g.a(e6);
            z5 = true;
        }
        OutputStream e7 = e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        boolean z6 = true;
        while (!z5) {
            try {
                a6 = l();
            } catch (Exception e8) {
                a6 = com.sun.mail.iap.g.a(e8);
            }
            if (a6.f()) {
                if (z6) {
                    str3 = str;
                    z6 = false;
                } else {
                    str3 = str2;
                }
                bASE64EncoderStream.write(ASCIIUtility.getBytes(str3));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(A);
                e7.write(byteArrayOutputStream.toByteArray());
                e7.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!a6.j() || !a6.c().equals(str4)) && !a6.e()) {
                    vector.addElement(a6);
                }
                z5 = true;
            }
        }
        com.sun.mail.iap.g[] gVarArr = new com.sun.mail.iap.g[vector.size()];
        vector.copyInto(gVarArr);
        j(gVarArr);
        h(a6);
        H0(a6);
        this.f39444s = true;
    }

    public c u0(int i6, String str) throws ProtocolException {
        return Q(i6, str, true);
    }

    public synchronized void v(String str, String str2, String str3) throws ProtocolException {
        com.sun.mail.iap.g a6;
        boolean z5;
        Vector vector = new Vector();
        String str4 = null;
        try {
            z5 = false;
            a6 = null;
            str4 = q("AUTHENTICATE PLAIN", null);
        } catch (Exception e6) {
            a6 = com.sun.mail.iap.g.a(e6);
            z5 = true;
        }
        OutputStream e7 = e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        while (!z5) {
            try {
                a6 = l();
            } catch (Exception e8) {
                a6 = com.sun.mail.iap.g.a(e8);
            }
            if (a6.f()) {
                bASE64EncoderStream.write(ASCIIUtility.getBytes(String.valueOf(str) + "\u0000" + str2 + "\u0000" + str3));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(A);
                e7.write(byteArrayOutputStream.toByteArray());
                e7.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!a6.j() || !a6.c().equals(str4)) && !a6.e()) {
                    vector.addElement(a6);
                }
                z5 = true;
            }
        }
        com.sun.mail.iap.g[] gVarArr = new com.sun.mail.iap.g[vector.size()];
        vector.copyInto(gVarArr);
        j(gVarArr);
        h(a6);
        H0(a6);
        this.f39444s = true;
    }

    public c v0(int i6, String str, int i7, int i8) throws ProtocolException {
        return P(i6, str, i7, i8, true, null);
    }

    public void w() throws ProtocolException {
        com.sun.mail.iap.g[] b6 = b("CAPABILITY", null);
        if (!b6[b6.length - 1].h()) {
            throw new ProtocolException(b6[b6.length - 1].toString());
        }
        this.f39445t = new HashMap(10);
        this.f39446u = new ArrayList(5);
        for (com.sun.mail.iap.g gVar : b6) {
            if (gVar instanceof i) {
                i iVar = (i) gVar;
                if (iVar.F("CAPABILITY")) {
                    s0(iVar);
                }
            }
        }
    }

    public c w0(int i6, String str, int i7, int i8, com.sun.mail.iap.d dVar) throws ProtocolException {
        return P(i6, str, i7, i8, true, dVar);
    }

    public boolean x0(com.sun.mail.iap.g gVar) throws ProtocolException {
        j(new com.sun.mail.iap.g[]{gVar});
        boolean e6 = gVar.e();
        if (gVar.j() && gVar.c().equals(this.f39451z)) {
            e6 = true;
        }
        if (e6) {
            this.f39451z = null;
        }
        h(gVar);
        return !e6;
    }

    public synchronized com.sun.mail.iap.g z0() {
        com.sun.mail.iap.g a6;
        if (this.f39451z == null) {
            return null;
        }
        try {
            a6 = l();
        } catch (ProtocolException e6) {
            a6 = com.sun.mail.iap.g.a(e6);
        } catch (IOException e7) {
            a6 = com.sun.mail.iap.g.a(e7);
        }
        return a6;
    }

    public h(String str, String str2, int i6, boolean z5, PrintStream printStream, Properties properties, boolean z6) throws IOException, ProtocolException {
        super(str2, i6, z5, printStream, properties, "mail." + str, z6);
        this.f39442q = false;
        this.f39443r = false;
        this.f39445t = null;
        this.f39446u = null;
        try {
            this.f39448w = str;
            w();
            if (e0("IMAP4rev1")) {
                this.f39443r = true;
            }
            this.f39447v = new String[]{"UTF-8", MimeUtility.mimeCharset(MimeUtility.getDefaultJavaCharset())};
            this.f39442q = true;
        } catch (Throwable th) {
            if (!this.f39442q) {
                c();
            }
            throw th;
        }
    }

    private String D(Flags flags) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        boolean z5 = true;
        for (Flags.Flag flag : flags.getSystemFlags()) {
            if (flag == Flags.Flag.ANSWERED) {
                str = "\\Answered";
            } else if (flag == Flags.Flag.DELETED) {
                str = "\\Deleted";
            } else if (flag == Flags.Flag.DRAFT) {
                str = "\\Draft";
            } else if (flag == Flags.Flag.FLAGGED) {
                str = "\\Flagged";
            } else if (flag == Flags.Flag.RECENT) {
                str = "\\Recent";
            } else if (flag == Flags.Flag.SEEN) {
                str = "\\Seen";
            }
            if (z5) {
                z5 = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str);
        }
        String[] userFlags = flags.getUserFlags();
        for (String str2 : userFlags) {
            if (z5) {
                z5 = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str2);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public void B0(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        List list;
        if (this.f39449x == null) {
            try {
                this.f39449x = (s) j.class.getConstructor(h.class, String.class, Properties.class, Boolean.TYPE, PrintStream.class, String.class).newInstance(this, this.f39448w, this.f39186f, this.f39183c ? Boolean.TRUE : Boolean.FALSE, this.f39185e, this.f39181a);
            } catch (Exception e6) {
                if (this.f39183c) {
                    PrintStream printStream = this.f39185e;
                    e6.toString();
                    printStream.getClass();
                    return;
                }
                return;
            }
        }
        if (strArr == null || strArr.length <= 0) {
            list = this.f39446u;
        } else {
            list = new ArrayList(strArr.length);
            for (int i6 = 0; i6 < strArr.length; i6++) {
                if (this.f39446u.contains(strArr[i6])) {
                    list.add(strArr[i6]);
                }
            }
        }
        if (this.f39449x.a((String[]) list.toArray(new String[list.size()]), str, str2, str3, str4)) {
            this.f39444s = true;
        }
    }

    public int[] D0(SearchTerm searchTerm) throws ProtocolException, SearchException {
        return C0("ALL", searchTerm);
    }

    public void E(String str, String str2) throws ProtocolException {
        if (!e0("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        bVar.o(str2);
        com.sun.mail.iap.g[] b6 = b("DELETEACL", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        j(b6);
        h(gVar);
    }

    public void G0(String str, char c6, com.sun.mail.imap.a aVar) throws ProtocolException {
        if (!e0("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        bVar.o(aVar.a());
        String nVar = aVar.b().toString();
        if (c6 == '+' || c6 == '-') {
            nVar = String.valueOf(c6) + nVar;
        }
        bVar.o(nVar);
        com.sun.mail.iap.g[] b6 = b("SETACL", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        j(b6);
        h(gVar);
    }

    public void H() throws ProtocolException {
        n("EXPUNGE", null);
    }

    public com.sun.mail.iap.g[] I(int i6, int i7, String str) throws ProtocolException {
        return K(String.valueOf(String.valueOf(i6)) + ":" + String.valueOf(i7), str, false);
    }

    public void I0(Quota quota) throws ProtocolException {
        if (!e0("QUOTA")) {
            throw new BadCommandException("QUOTA not supported");
        }
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(quota.quotaRoot);
        com.sun.mail.iap.b bVar2 = new com.sun.mail.iap.b();
        if (quota.resources != null) {
            int i6 = 0;
            while (true) {
                Quota.Resource[] resourceArr = quota.resources;
                if (i6 >= resourceArr.length) {
                    break;
                }
                bVar2.i(resourceArr[i6].name);
                bVar2.n(quota.resources[i6].limit);
                i6++;
            }
        }
        bVar.h(bVar2);
        com.sun.mail.iap.g[] b6 = b("SETQUOTA", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        j(b6);
        h(gVar);
    }

    public void J0() throws ProtocolException {
        try {
            super.o("STARTTLS");
        } catch (ProtocolException e6) {
            throw e6;
        } catch (Exception e7) {
            j(new com.sun.mail.iap.g[]{com.sun.mail.iap.g.a(e7)});
            c();
        }
    }

    public void L0(int i6, int i7, Flags flags, boolean z5) throws ProtocolException {
        N0(String.valueOf(String.valueOf(i6)) + ":" + String.valueOf(i7), flags, z5);
    }

    protected c P(int i6, String str, int i7, int i8, boolean z5, com.sun.mail.iap.d dVar) throws ProtocolException {
        this.f39450y = dVar;
        StringBuilder sb = new StringBuilder(z5 ? "BODY.PEEK[" : "BODY[");
        String str2 = "]<";
        if (str != null) {
            str2 = str + "]<";
        }
        sb.append(str2);
        sb.append(String.valueOf(i7));
        sb.append(".");
        sb.append(String.valueOf(i8));
        sb.append(">");
        com.sun.mail.iap.g[] J = J(i6, sb.toString());
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (c) f.K(J, i6, c.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public void P0(String str) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(b.a(str));
        n("SUBSCRIBE", bVar);
    }

    protected c Q(int i6, String str, boolean z5) throws ProtocolException {
        com.sun.mail.iap.g[] J;
        String str2 = "]";
        if (z5) {
            StringBuilder sb = new StringBuilder("BODY.PEEK[");
            if (str != null) {
                str2 = str + "]";
            }
            sb.append(str2);
            J = J(i6, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder("BODY[");
            if (str != null) {
                str2 = str + "]";
            }
            sb2.append(str2);
            J = J(i6, sb2.toString());
        }
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (c) f.K(J, i6, c.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public void Q0(w[] wVarArr) throws ProtocolException {
        if (!e0("UIDPLUS")) {
            throw new BadCommandException("UID EXPUNGE not supported");
        }
        n("UID EXPUNGE " + w.d(wVarArr), null);
    }

    public d R(int i6) throws ProtocolException {
        com.sun.mail.iap.g[] J = J(i6, "BODYSTRUCTURE");
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (d) f.K(J, i6, d.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public void R0(String str) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(b.a(str));
        n("UNSUBSCRIBE", bVar);
    }

    public Flags S(int i6) throws ProtocolException {
        com.sun.mail.iap.g[] J = J(i6, "FLAGS");
        int length = J.length;
        int i7 = 0;
        Flags flags = null;
        while (true) {
            if (i7 >= length) {
                break;
            }
            com.sun.mail.iap.g gVar = J[i7];
            if (gVar != null && (gVar instanceof f) && ((f) gVar).E() == i6 && (flags = (Flags) ((f) J[i7]).J(Flags.class)) != null) {
                J[i7] = null;
                break;
            }
            i7++;
        }
        j(J);
        h(J[J.length - 1]);
        return flags;
    }

    public q T(int i6, String str) throws ProtocolException {
        String str2;
        if (str == null) {
            str2 = "RFC822";
        } else {
            str2 = "RFC822." + str;
        }
        com.sun.mail.iap.g[] J = J(i6, str2);
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (q) f.K(J, i6, q.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public v[] V(long j6, long j7) throws ProtocolException {
        v vVar;
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(j6)));
        sb.append(":");
        sb.append(j7 == -1 ? "*" : String.valueOf(j7));
        com.sun.mail.iap.g[] K = K(sb.toString(), "UID", true);
        Vector vector = new Vector();
        for (com.sun.mail.iap.g gVar : K) {
            if (gVar != null && (gVar instanceof f) && (vVar = (v) ((f) gVar).J(v.class)) != null) {
                vector.addElement(vVar);
            }
        }
        j(K);
        h(K[K.length - 1]);
        v[] vVarArr = new v[vector.size()];
        vector.copyInto(vVarArr);
        return vVarArr;
    }

    public v[] W(long[] jArr) throws ProtocolException {
        v vVar;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < jArr.length; i6++) {
            if (i6 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf(jArr[i6]));
        }
        com.sun.mail.iap.g[] K = K(stringBuffer.toString(), "UID", true);
        Vector vector = new Vector();
        for (com.sun.mail.iap.g gVar : K) {
            if (gVar != null && (gVar instanceof f) && (vVar = (v) ((f) gVar).J(v.class)) != null) {
                vector.addElement(vVar);
            }
        }
        j(K);
        h(K[K.length - 1]);
        v[] vVarArr = new v[vector.size()];
        vector.copyInto(vVarArr);
        return vVarArr;
    }

    public v X(int i6) throws ProtocolException {
        com.sun.mail.iap.g[] J = J(i6, "UID");
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (v) f.K(J, i6, v.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public com.sun.mail.imap.a[] Y(String str) throws ProtocolException {
        String q5;
        if (!e0("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        com.sun.mail.iap.g[] b6 = b("GETACL", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        Vector vector = new Vector();
        if (gVar.h()) {
            int length = b6.length;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("ACL")) {
                        iVar.q();
                        while (true) {
                            String q6 = iVar.q();
                            if (q6 != null && (q5 = iVar.q()) != null) {
                                vector.addElement(new com.sun.mail.imap.a(q6, new com.sun.mail.imap.n(q5)));
                            }
                        }
                        b6[i6] = null;
                    }
                }
            }
        }
        j(b6);
        h(gVar);
        com.sun.mail.imap.a[] aVarArr = new com.sun.mail.imap.a[vector.size()];
        vector.copyInto(aVarArr);
        return aVarArr;
    }

    public Map a0() {
        return this.f39445t;
    }

    public Quota[] c0(String str) throws ProtocolException {
        if (!e0("QUOTA")) {
            throw new BadCommandException("QUOTA not supported");
        }
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(str);
        com.sun.mail.iap.g[] b6 = b("GETQUOTA", bVar);
        Vector vector = new Vector();
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        if (gVar.h()) {
            int length = b6.length;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("QUOTA")) {
                        vector.addElement(t0(iVar));
                        b6[i6] = null;
                    }
                }
            }
        }
        j(b6);
        h(gVar);
        Quota[] quotaArr = new Quota[vector.size()];
        vector.copyInto(quotaArr);
        return quotaArr;
    }

    public Quota[] d0(String str) throws ProtocolException {
        if (!e0("QUOTA")) {
            throw new BadCommandException("GETQUOTAROOT not supported");
        }
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        com.sun.mail.iap.g[] b6 = b("GETQUOTAROOT", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        Hashtable hashtable = new Hashtable();
        int i6 = 0;
        if (gVar.h()) {
            int length = b6.length;
            for (int i7 = 0; i7 < length; i7++) {
                com.sun.mail.iap.g gVar2 = b6[i7];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("QUOTAROOT")) {
                        iVar.q();
                        while (true) {
                            String q5 = iVar.q();
                            if (q5 == null) {
                                break;
                            }
                            hashtable.put(q5, new Quota(q5));
                        }
                        b6[i7] = null;
                    } else if (iVar.F("QUOTA")) {
                        Quota t02 = t0(iVar);
                        hashtable.put(t02.quotaRoot, t02);
                        b6[i7] = null;
                    }
                }
            }
        }
        j(b6);
        h(gVar);
        Quota[] quotaArr = new Quota[hashtable.size()];
        Enumeration elements = hashtable.elements();
        while (elements.hasMoreElements()) {
            quotaArr[i6] = (Quota) elements.nextElement();
            i6++;
        }
        return quotaArr;
    }

    public boolean e0(String str) {
        return this.f39445t.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    @Override // com.sun.mail.iap.f
    protected com.sun.mail.iap.d f() {
        com.sun.mail.iap.d dVar = this.f39450y;
        this.f39450y = null;
        return dVar;
    }

    public boolean h0() {
        return this.f39444s;
    }

    public boolean i0() {
        return this.f39443r;
    }

    public m[] k0(String str, String str2) throws ProtocolException {
        return F("LIST", str, str2);
    }

    public com.sun.mail.imap.n[] l0(String str, String str2) throws ProtocolException {
        if (!e0("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        bVar.o(str2);
        com.sun.mail.iap.g[] b6 = b("LISTRIGHTS", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        Vector vector = new Vector();
        if (gVar.h()) {
            int length = b6.length;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("LISTRIGHTS")) {
                        iVar.q();
                        iVar.q();
                        while (true) {
                            String q5 = iVar.q();
                            if (q5 == null) {
                                break;
                            }
                            vector.addElement(new com.sun.mail.imap.n(q5));
                        }
                        b6[i6] = null;
                    }
                }
            }
        }
        j(b6);
        h(gVar);
        com.sun.mail.imap.n[] nVarArr = new com.sun.mail.imap.n[vector.size()];
        vector.copyInto(nVarArr);
        return nVarArr;
    }

    public void m0(String str, String str2) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(str);
        bVar.o(str2);
        com.sun.mail.iap.g[] b6 = b("LOGIN", bVar);
        j(b6);
        h(b6[b6.length - 1]);
        H0(b6[b6.length - 1]);
        this.f39444s = true;
    }

    public void n0() throws ProtocolException {
        com.sun.mail.iap.g[] b6 = b("LOGOUT", null);
        this.f39444s = false;
        j(b6);
        c();
    }

    public m[] o0(String str, String str2) throws ProtocolException {
        return F("LSUB", str, str2);
    }

    @Override // com.sun.mail.iap.f
    protected boolean p() {
        return e0("LITERAL+");
    }

    public com.sun.mail.imap.n p0(String str) throws ProtocolException {
        if (!e0("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        com.sun.mail.iap.g[] b6 = b("MYRIGHTS", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        com.sun.mail.imap.n nVar = null;
        if (gVar.h()) {
            int length = b6.length;
            com.sun.mail.imap.n nVar2 = null;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("MYRIGHTS")) {
                        iVar.q();
                        String q5 = iVar.q();
                        if (nVar2 == null) {
                            nVar2 = new com.sun.mail.imap.n(q5);
                        }
                        b6[i6] = null;
                    }
                }
            }
            nVar = nVar2;
        }
        j(b6);
        h(gVar);
        return nVar;
    }

    public p q0() throws ProtocolException {
        if (!e0("NAMESPACE")) {
            throw new BadCommandException("NAMESPACE not supported");
        }
        p pVar = null;
        com.sun.mail.iap.g[] b6 = b("NAMESPACE", null);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        if (gVar.h()) {
            int length = b6.length;
            p pVar2 = null;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("NAMESPACE")) {
                        if (pVar2 == null) {
                            pVar2 = new p(iVar);
                        }
                        b6[i6] = null;
                    }
                }
            }
            pVar = pVar2;
        }
        j(b6);
        h(gVar);
        return pVar;
    }

    public void r0() throws ProtocolException {
        if (this.f39183c) {
            this.f39185e.getClass();
        }
        n("NOOP", null);
    }

    protected void s0(com.sun.mail.iap.g gVar) {
        while (true) {
            String p5 = gVar.p(']');
            if (p5 == null) {
                return;
            }
            if (p5.length() != 0) {
                this.f39445t.put(p5.toUpperCase(Locale.ENGLISH), p5);
                if (p5.regionMatches(true, 0, "AUTH=", 0, 5)) {
                    this.f39446u.add(p5.substring(5));
                    if (this.f39183c) {
                        PrintStream printStream = this.f39185e;
                        p5.substring(5);
                        printStream.getClass();
                    }
                }
            } else if (gVar.n() == 93) {
                return;
            } else {
                gVar.C();
            }
        }
    }

    public void x() throws ProtocolException {
        n("CHECK", null);
    }

    public void y() throws ProtocolException {
        n("CLOSE", null);
    }

    public void y0(String str) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(str);
        n("PROXYAUTH", bVar);
    }

    public void z(int i6, int i7, String str) throws ProtocolException {
        A(String.valueOf(String.valueOf(i6)) + ":" + String.valueOf(i7), str);
    }

    private void A(String str, String str2) throws ProtocolException {
        String a6 = b.a(str2);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i(str);
        bVar.o(a6);
        n("COPY", bVar);
    }

    private int[] C0(String str, SearchTerm searchTerm) throws ProtocolException, SearchException {
        if (t.h(searchTerm)) {
            try {
                return j0(str, searchTerm, null);
            } catch (IOException unused) {
            }
        }
        int i6 = 0;
        while (true) {
            String[] strArr = this.f39447v;
            if (i6 < strArr.length) {
                String str2 = strArr[i6];
                if (str2 != null) {
                    try {
                        return j0(str, searchTerm, str2);
                    } catch (CommandFailedException unused2) {
                        this.f39447v[i6] = null;
                    } catch (ProtocolException e6) {
                        throw e6;
                    } catch (IOException unused3) {
                        continue;
                    } catch (SearchException e7) {
                        throw e7;
                    }
                }
                i6++;
            } else {
                throw new SearchException("Search failed");
            }
        }
    }

    private m[] F(String str, String str2, String str3) throws ProtocolException {
        String a6 = b.a(str2);
        String a7 = b.a(str3);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        bVar.o(a7);
        com.sun.mail.iap.g[] b6 = b(str, bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        m[] mVarArr = null;
        if (gVar.h()) {
            Vector vector = new Vector(1);
            int length = b6.length;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F(str)) {
                        vector.addElement(new m(iVar));
                        b6[i6] = null;
                    }
                }
            }
            if (vector.size() > 0) {
                mVarArr = new m[vector.size()];
                vector.copyInto(mVarArr);
            }
        }
        j(b6);
        h(gVar);
        return mVarArr;
    }

    private com.sun.mail.imap.b Z(com.sun.mail.iap.g gVar) {
        byte r5;
        if (!gVar.h()) {
            return null;
        }
        do {
            r5 = gVar.r();
            if (r5 <= 0) {
                break;
            }
        } while (r5 != 91);
        if (r5 == 0 || !gVar.o().equalsIgnoreCase("APPENDUID")) {
            return null;
        }
        return new com.sun.mail.imap.b(gVar.u(), gVar.u());
    }

    private Quota t0(com.sun.mail.iap.g gVar) throws ParsingException {
        Quota quota = new Quota(gVar.q());
        gVar.B();
        if (gVar.r() == 40) {
            Vector vector = new Vector();
            while (gVar.n() != 41) {
                String o5 = gVar.o();
                if (o5 != null) {
                    vector.addElement(new Quota.Resource(o5, gVar.u(), gVar.u()));
                }
            }
            gVar.r();
            Quota.Resource[] resourceArr = new Quota.Resource[vector.size()];
            quota.resources = resourceArr;
            vector.copyInto(resourceArr);
            return quota;
        }
        throw new ParsingException("parse error in QUOTA");
    }

    public void A0(String str, String str2) throws ProtocolException {
        String a6 = b.a(str);
        String a7 = b.a(str2);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        bVar.o(a7);
        n("RENAME", bVar);
    }

    public void B(o[] oVarArr, String str) throws ProtocolException {
        A(o.d(oVarArr), str);
    }

    public void C(String str) throws ProtocolException {
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        n("CREATE", bVar);
    }

    public int[] E0(o[] oVarArr, SearchTerm searchTerm) throws ProtocolException, SearchException {
        return C0(o.d(oVarArr), searchTerm);
    }

    public n F0(String str) throws ProtocolException {
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        com.sun.mail.iap.g[] b6 = b("SELECT", bVar);
        n nVar = new n(b6);
        j(b6);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        if (gVar.h()) {
            if (gVar.toString().indexOf("READ-ONLY") != -1) {
                nVar.f39485h = 1;
            } else {
                nVar.f39485h = 2;
            }
        }
        h(gVar);
        return nVar;
    }

    public n G(String str) throws ProtocolException {
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        com.sun.mail.iap.g[] b6 = b("EXAMINE", bVar);
        n nVar = new n(b6);
        nVar.f39485h = 1;
        j(b6);
        h(b6[b6.length - 1]);
        return nVar;
    }

    protected void H0(com.sun.mail.iap.g gVar) {
        byte r5;
        do {
            r5 = gVar.r();
            if (r5 <= 0) {
                break;
            }
        } while (r5 != 91);
        if (r5 == 0 || !gVar.o().equalsIgnoreCase("CAPABILITY")) {
            return;
        }
        this.f39445t = new HashMap(10);
        this.f39446u = new ArrayList(5);
        s0(gVar);
    }

    public com.sun.mail.iap.g[] J(int i6, String str) throws ProtocolException {
        return K(String.valueOf(i6), str, false);
    }

    public u K0(String str, String[] strArr) throws ProtocolException {
        if (!i0() && !e0("IMAP4SUNVERSION")) {
            throw new BadCommandException("STATUS not supported");
        }
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        com.sun.mail.iap.b bVar2 = new com.sun.mail.iap.b();
        if (strArr == null) {
            strArr = u.f39501g;
        }
        for (String str2 : strArr) {
            bVar2.i(str2);
        }
        bVar.h(bVar2);
        com.sun.mail.iap.g[] b6 = b("STATUS", bVar);
        com.sun.mail.iap.g gVar = b6[b6.length - 1];
        u uVar = null;
        if (gVar.h()) {
            int length = b6.length;
            u uVar2 = null;
            for (int i6 = 0; i6 < length; i6++) {
                com.sun.mail.iap.g gVar2 = b6[i6];
                if (gVar2 instanceof i) {
                    i iVar = (i) gVar2;
                    if (iVar.F("STATUS")) {
                        if (uVar2 == null) {
                            uVar2 = new u(iVar);
                        } else {
                            u.a(uVar2, new u(iVar));
                        }
                        b6[i6] = null;
                    }
                }
            }
            uVar = uVar2;
        }
        j(b6);
        h(gVar);
        return uVar;
    }

    public com.sun.mail.iap.g[] L(o[] oVarArr, String str) throws ProtocolException {
        return K(o.d(oVarArr), str, false);
    }

    public void M0(int i6, Flags flags, boolean z5) throws ProtocolException {
        N0(String.valueOf(i6), flags, z5);
    }

    public void O0(o[] oVarArr, Flags flags, boolean z5) throws ProtocolException {
        N0(o.d(oVarArr), flags, z5);
    }

    public v U(long j6) throws ProtocolException {
        com.sun.mail.iap.g[] K = K(String.valueOf(j6), "UID", true);
        v vVar = null;
        for (com.sun.mail.iap.g gVar : K) {
            if (gVar != null && (gVar instanceof f) && (vVar = (v) ((f) gVar).J(v.class)) != null) {
                if (vVar.f39510b == j6) {
                    break;
                }
                vVar = null;
            }
        }
        j(K);
        h(K[K.length - 1]);
        return vVar;
    }

    OutputStream b0() {
        return e();
    }

    @Override // com.sun.mail.iap.f
    public void c() {
        super.c();
        this.f39444s = false;
    }

    public void delete(String str) throws ProtocolException {
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        n("DELETE", bVar);
    }

    public void f0() throws ProtocolException {
        OutputStream e6 = e();
        try {
            e6.write(B);
            e6.flush();
        } catch (IOException unused) {
        }
    }

    @Override // com.sun.mail.iap.f
    protected void k(com.sun.mail.iap.g gVar) throws ProtocolException {
        super.k(gVar);
        if (gVar.h()) {
            H0(gVar);
        } else {
            if (((i) gVar).F("PREAUTH")) {
                this.f39444s = true;
                H0(gVar);
                return;
            }
            throw new ConnectionException(this, gVar);
        }
    }

    @Override // com.sun.mail.iap.f
    public com.sun.mail.iap.g l() throws IOException, ProtocolException {
        return i.G(this);
    }

    public com.sun.mail.imap.b t(String str, Flags flags, Date date, com.sun.mail.iap.e eVar, boolean z5) throws ProtocolException {
        String a6 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a6);
        if (flags != null) {
            Flags.Flag flag = Flags.Flag.RECENT;
            if (flags.contains(flag)) {
                Flags flags2 = new Flags(flags);
                flags2.remove(flag);
                flags = flags2;
            }
            bVar.i(D(flags));
        }
        if (date != null) {
            bVar.o(k.a(date));
        }
        bVar.j(eVar);
        com.sun.mail.iap.g[] b6 = b("APPEND", bVar);
        j(b6);
        h(b6[b6.length - 1]);
        if (z5) {
            return Z(b6[b6.length - 1]);
        }
        return null;
    }
}
