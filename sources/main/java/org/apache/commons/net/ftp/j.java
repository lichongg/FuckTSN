package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j extends c {
    private static final byte[] Q0 = {13, 10};
    private final String K0;
    private final int L0;
    private final String M0;
    private final String N0;
    private final org.apache.commons.net.util.a O0;
    private String P0;

    public j(String str, int i6, String str2, String str3) {
        this.O0 = new org.apache.commons.net.util.a();
        this.K0 = str;
        this.L0 = i6;
        this.M0 = str2;
        this.N0 = str3;
        this.P0 = null;
    }

    private BufferedReader Y3(String str, int i6, InputStream inputStream, OutputStream outputStream) throws IOException, UnsupportedEncodingException {
        String str2 = "CONNECT " + str + ":" + i6 + " HTTP/1.1";
        this.P0 = str;
        outputStream.write(str2.getBytes("UTF-8"));
        byte[] bArr = Q0;
        outputStream.write(bArr);
        outputStream.write(("Host: " + str + ":" + i6).getBytes("UTF-8"));
        outputStream.write(bArr);
        if (this.M0 != null && this.N0 != null) {
            outputStream.write(("Proxy-Authorization: Basic " + this.O0.v((this.M0 + ":" + this.N0).getBytes("UTF-8"))).getBytes("UTF-8"));
        }
        outputStream.write(bArr);
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, q()));
        for (String readLine = bufferedReader.readLine(); readLine != null && readLine.length() > 0; readLine = bufferedReader.readLine()) {
            arrayList.add(readLine);
        }
        if (arrayList.size() == 0) {
            throw new IOException("No response from proxy");
        }
        String str3 = (String) arrayList.get(0);
        if (!str3.startsWith("HTTP/") || str3.length() < 12) {
            throw new IOException("Invalid response from proxy: " + str3);
        }
        if ("200".equals(str3.substring(9, 12))) {
            return bufferedReader;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HTTPTunnelConnector: connection failed\r\n");
        sb.append("Response received from the proxy:\r\n");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(org.apache.commons.net.g.f50795q);
        }
        throw new IOException(sb.toString());
    }

    @Override // org.apache.commons.net.g
    public void h(String str, int i6) throws SocketException, IOException {
        Socket createSocket = this.f50806j.createSocket(this.K0, this.L0);
        this.f50801e = createSocket;
        this.f50804h = createSocket.getInputStream();
        OutputStream outputStream = this.f50801e.getOutputStream();
        this.f50805i = outputStream;
        try {
            super.h0(Y3(str, i6, this.f50804h, outputStream));
        } catch (Exception e6) {
            IOException iOException = new IOException("Could not connect to " + str + " using port " + i6);
            iOException.initCause(e6);
            throw iOException;
        }
    }

    @Override // org.apache.commons.net.ftp.c
    @Deprecated
    protected Socket B1(int i6, String str) throws IOException {
        return super.B1(i6, str);
    }

    @Override // org.apache.commons.net.ftp.c
    protected Socket C1(String str, String str2) throws IOException {
        String str3;
        if (k2() == 2) {
            boolean z5 = B() instanceof Inet6Address;
            if ((L2() || z5) && r0() == 229) {
                E1(this.f50559v.get(0));
                str3 = this.P0;
            } else {
                if (z5 || Q0() != 227) {
                    return null;
                }
                F1(this.f50559v.get(0));
                str3 = r2();
            }
            Socket createSocket = this.f50806j.createSocket(this.K0, this.L0);
            Y3(str3, t2(), createSocket.getInputStream(), createSocket.getOutputStream());
            if (w2() > 0 && !n3(w2())) {
                createSocket.close();
                return null;
            }
            if (!l.e(d1(str, str2))) {
                createSocket.close();
                return null;
            }
            return createSocket;
        }
        throw new IllegalStateException("Only passive connection mode supported");
    }

    public j(String str, int i6) {
        this(str, i6, null, null);
    }
}
