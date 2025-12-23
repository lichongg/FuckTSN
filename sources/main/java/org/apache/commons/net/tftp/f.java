package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class f {

    /* renamed from: d, reason: collision with root package name */
    static final int f51217d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f51218e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f51219f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f51220g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f51221h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final int f51222i = 5;

    /* renamed from: j, reason: collision with root package name */
    public static final int f51223j = 512;

    /* renamed from: a, reason: collision with root package name */
    int f51224a;

    /* renamed from: b, reason: collision with root package name */
    int f51225b;

    /* renamed from: c, reason: collision with root package name */
    InetAddress f51226c;

    abstract DatagramPacket a(DatagramPacket datagramPacket, byte[] bArr);

    public abstract DatagramPacket d();

    public final InetAddress b() {
        return this.f51226c;
    }

    public final int c() {
        return this.f51225b;
    }

    public final void f(InetAddress inetAddress) {
        this.f51226c = inetAddress;
    }

    public final void g(int i6) {
        this.f51225b = i6;
    }

    public final int getType() {
        return this.f51224a;
    }

    public String toString() {
        return this.f51226c + " " + this.f51225b + " " + this.f51224a;
    }

    f(int i6, InetAddress inetAddress, int i7) {
        this.f51224a = i6;
        this.f51226c = inetAddress;
        this.f51225b = i7;
    }

    public static final f e(DatagramPacket datagramPacket) throws TFTPPacketException {
        if (datagramPacket.getLength() >= 4) {
            byte b6 = datagramPacket.getData()[1];
            if (b6 != 1) {
                if (b6 != 2) {
                    if (b6 != 3) {
                        if (b6 != 4) {
                            if (b6 == 5) {
                                return new e(datagramPacket);
                            }
                            throw new TFTPPacketException("Bad packet.  Invalid TFTP operator code.");
                        }
                        return new b(datagramPacket);
                    }
                    return new d(datagramPacket);
                }
                return new i(datagramPacket);
            }
            return new g(datagramPacket);
        }
        throw new TFTPPacketException("Bad packet. Datagram data length is too short.");
    }
}
