package org.apache.commons.net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements b {
    @Override // org.apache.commons.net.b
    public DatagramSocket a(int i6, InetAddress inetAddress) throws SocketException {
        return new DatagramSocket(i6, inetAddress);
    }

    @Override // org.apache.commons.net.b
    public DatagramSocket b(int i6) throws SocketException {
        return new DatagramSocket(i6);
    }

    @Override // org.apache.commons.net.b
    public DatagramSocket c() throws SocketException {
        return new DatagramSocket();
    }
}
