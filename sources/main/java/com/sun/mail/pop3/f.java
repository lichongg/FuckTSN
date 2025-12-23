package com.sun.mail.pop3;

import com.baidu.mobads.sdk.internal.by;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.StringTokenizer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class f {

    /* renamed from: g, reason: collision with root package name */
    private static final int f39539g = 110;

    /* renamed from: h, reason: collision with root package name */
    private static final String f39540h = "\r\n";

    /* renamed from: i, reason: collision with root package name */
    private static char[] f39541i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a, reason: collision with root package name */
    private Socket f39542a;

    /* renamed from: b, reason: collision with root package name */
    private DataInputStream f39543b;

    /* renamed from: c, reason: collision with root package name */
    private PrintWriter f39544c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39545d;

    /* renamed from: e, reason: collision with root package name */
    private PrintStream f39546e;

    /* renamed from: f, reason: collision with root package name */
    private String f39547f;

    private static String m(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = f39541i;
            cArr[i6] = cArr2[(b6 & 255) >> 4];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    synchronized boolean a(int i6) throws IOException {
        return k("DELE " + i6).f39548a;
    }

    synchronized int c(int i6) throws IOException {
        int i7;
        g k6 = k("LIST " + i6);
        if (k6.f39548a && k6.f39549b != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(k6.f39549b);
                stringTokenizer.nextToken();
                i7 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        i7 = -1;
        return i7;
    }

    synchronized InputStream d() throws IOException {
        return f("LIST", 128).f39550c;
    }

    synchronized String e(String str, String str2) throws IOException {
        g k6;
        try {
            String b6 = this.f39547f != null ? b(str2) : null;
            if (this.f39547f == null || b6 == null) {
                g k7 = k("USER " + str);
                if (!k7.f39548a) {
                    String str3 = k7.f39549b;
                    if (str3 == null) {
                        str3 = "USER command failed";
                    }
                    return str3;
                }
                k6 = k("PASS " + str2);
            } else {
                k6 = k("APOP " + str + " " + b6);
            }
            if (k6.f39548a) {
                return null;
            }
            String str4 = k6.f39549b;
            if (str4 == null) {
                str4 = "login failed";
            }
            return str4;
        } finally {
        }
    }

    synchronized boolean g() throws IOException {
        return k("NOOP").f39548a;
    }

    synchronized boolean h() throws IOException {
        boolean z5;
        try {
            z5 = k("QUIT").f39548a;
            try {
                this.f39542a.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                this.f39542a.close();
                throw th;
            } finally {
            }
        }
        return z5;
    }

    synchronized InputStream i(int i6, int i7) throws IOException {
        return f("RETR " + i6, i7).f39550c;
    }

    synchronized boolean j() throws IOException {
        return k("RSET").f39548a;
    }

    synchronized i l() throws IOException {
        i iVar;
        g k6 = k("STAT");
        iVar = new i();
        if (k6.f39548a && k6.f39549b != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(k6.f39549b);
                iVar.f39551a = Integer.parseInt(stringTokenizer.nextToken());
                iVar.f39552b = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return iVar;
    }

    synchronized InputStream n(int i6, int i7) throws IOException {
        return f("TOP " + i6 + " " + i7, 0).f39550c;
    }

    synchronized String o(int i6) throws IOException {
        g k6 = k("UIDL " + i6);
        if (!k6.f39548a) {
            return null;
        }
        int indexOf = k6.f39549b.indexOf(32);
        if (indexOf <= 0) {
            return null;
        }
        return k6.f39549b.substring(indexOf + 1);
    }

    synchronized boolean p(String[] strArr) throws IOException {
        int parseInt;
        g f6 = f("UIDL", strArr.length * 15);
        if (!f6.f39548a) {
            return false;
        }
        LineInputStream lineInputStream = new LineInputStream(f6.f39550c);
        while (true) {
            String readLine = lineInputStream.readLine();
            if (readLine == null) {
                return true;
            }
            int indexOf = readLine.indexOf(32);
            if (indexOf >= 1 && indexOf < readLine.length() && (parseInt = Integer.parseInt(readLine.substring(0, indexOf))) > 0 && parseInt <= strArr.length) {
                strArr[parseInt - 1] = readLine.substring(indexOf + 1);
            }
        }
    }

    private String b(String str) {
        try {
            return m(MessageDigest.getInstance(by.f10823a).digest((String.valueOf(this.f39547f) + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private g k(String str) throws IOException {
        if (this.f39542a == null) {
            throw new IOException("Folder is closed");
        }
        if (str != null) {
            if (this.f39545d) {
                this.f39546e.getClass();
            }
            this.f39544c.print(str + "\r\n");
            this.f39544c.flush();
        }
        String readLine = this.f39543b.readLine();
        if (readLine == null) {
            if (this.f39545d) {
                this.f39546e.getClass();
            }
            throw new EOFException("EOF on socket");
        }
        if (this.f39545d) {
            this.f39546e.getClass();
        }
        g gVar = new g();
        if (readLine.startsWith("+OK")) {
            gVar.f39548a = true;
        } else {
            if (!readLine.startsWith("-ERR")) {
                throw new IOException("Unexpected response: " + readLine);
            }
            gVar.f39548a = false;
        }
        int indexOf = readLine.indexOf(32);
        if (indexOf >= 0) {
            gVar.f39549b = readLine.substring(indexOf + 1);
        }
        return gVar;
    }

    f(String str, int i6, boolean z5, PrintStream printStream, Properties properties, String str2, boolean z6) throws IOException {
        boolean z7;
        this.f39547f = null;
        this.f39545d = z5;
        this.f39546e = printStream;
        String property = properties.getProperty(String.valueOf(str2) + ".apop.enable");
        if (property != null && property.equalsIgnoreCase("true")) {
            z7 = true;
        } else {
            z7 = false;
        }
        i6 = i6 == -1 ? 110 : i6;
        if (z5) {
            try {
                printStream.getClass();
            } catch (IOException e6) {
                try {
                    this.f39542a.close();
                } catch (Throwable unused) {
                }
                throw e6;
            }
        }
        this.f39542a = SocketFetcher.getSocket(str, i6, properties, str2, z6);
        this.f39543b = new DataInputStream(new BufferedInputStream(this.f39542a.getInputStream()));
        this.f39544c = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.f39542a.getOutputStream(), "iso-8859-1")));
        g k6 = k(null);
        if (k6.f39548a) {
            if (z7) {
                int indexOf = k6.f39549b.indexOf(60);
                int indexOf2 = k6.f39549b.indexOf(62, indexOf);
                if (indexOf != -1 && indexOf2 != -1) {
                    this.f39547f = k6.f39549b.substring(indexOf, indexOf2 + 1);
                }
                if (z5) {
                    printStream.getClass();
                    return;
                }
                return;
            }
            return;
        }
        try {
            this.f39542a.close();
        } catch (Throwable unused2) {
        }
        throw new IOException("Connect failed");
    }

    private g f(String str, int i6) throws IOException {
        int read;
        g k6 = k(str);
        if (!k6.f39548a) {
            return k6;
        }
        h hVar = new h(i6);
        int i7 = 10;
        while (true) {
            read = this.f39543b.read();
            if (read < 0) {
                break;
            }
            if (i7 == 10 && read == 46) {
                if (this.f39545d) {
                    this.f39546e.write(read);
                }
                i7 = this.f39543b.read();
                if (i7 == 13) {
                    if (this.f39545d) {
                        this.f39546e.write(i7);
                    }
                    read = this.f39543b.read();
                    if (this.f39545d) {
                        this.f39546e.write(read);
                    }
                }
            } else {
                i7 = read;
            }
            hVar.write(i7);
            if (this.f39545d) {
                this.f39546e.write(i7);
            }
        }
        if (read >= 0) {
            k6.f39550c = hVar.a();
            return k6;
        }
        throw new EOFException("EOF on socket");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f39542a != null) {
            h();
        }
    }
}
