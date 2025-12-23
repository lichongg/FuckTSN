package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class h extends f {

    /* renamed from: m, reason: collision with root package name */
    static final String[] f51227m = {"netascii", "octet"};

    /* renamed from: n, reason: collision with root package name */
    private static final byte[][] f51228n = {new byte[]{110, 101, 116, 97, 115, 99, 105, 105, 0}, new byte[]{111, 99, 116, 101, 116, 0}};

    /* renamed from: k, reason: collision with root package name */
    private final int f51229k;

    /* renamed from: l, reason: collision with root package name */
    private final String f51230l;

    h(InetAddress inetAddress, int i6, int i7, String str, int i8) {
        super(i7, inetAddress, i6);
        this.f51230l = str;
        this.f51229k = i8;
    }

    @Override // org.apache.commons.net.tftp.f
    final DatagramPacket a(DatagramPacket datagramPacket, byte[] bArr) {
        int length = this.f51230l.length();
        byte[][] bArr2 = f51228n;
        int length2 = bArr2[this.f51229k].length;
        bArr[0] = 0;
        bArr[1] = (byte) this.f51224a;
        System.arraycopy(this.f51230l.getBytes(), 0, bArr, 2, length);
        bArr[length + 2] = 0;
        System.arraycopy(bArr2[this.f51229k], 0, bArr, length + 3, length2);
        datagramPacket.setAddress(this.f51226c);
        datagramPacket.setPort(this.f51225b);
        datagramPacket.setData(bArr);
        datagramPacket.setLength(length + length2 + 3);
        return datagramPacket;
    }

    @Override // org.apache.commons.net.tftp.f
    public final DatagramPacket d() {
        int length = this.f51230l.length();
        byte[][] bArr = f51228n;
        int length2 = bArr[this.f51229k].length;
        int i6 = length + length2 + 4;
        byte[] bArr2 = new byte[i6];
        bArr2[0] = 0;
        bArr2[1] = (byte) this.f51224a;
        System.arraycopy(this.f51230l.getBytes(), 0, bArr2, 2, length);
        bArr2[length + 2] = 0;
        System.arraycopy(bArr[this.f51229k], 0, bArr2, length + 3, length2);
        return new DatagramPacket(bArr2, i6, this.f51226c, this.f51225b);
    }

    public final String h() {
        return this.f51230l;
    }

    public final int i() {
        return this.f51229k;
    }

    h(int i6, DatagramPacket datagramPacket) throws TFTPPacketException {
        super(i6, datagramPacket.getAddress(), datagramPacket.getPort());
        byte[] data = datagramPacket.getData();
        if (getType() == data[1]) {
            StringBuilder sb = new StringBuilder();
            int length = datagramPacket.getLength();
            int i7 = 2;
            while (i7 < length) {
                byte b6 = data[i7];
                if (b6 == 0) {
                    break;
                }
                sb.append((char) b6);
                i7++;
            }
            this.f51230l = sb.toString();
            if (i7 < length) {
                int i8 = 0;
                sb.setLength(0);
                for (int i9 = i7 + 1; i9 < length; i9++) {
                    byte b7 = data[i9];
                    if (b7 == 0) {
                        break;
                    }
                    sb.append((char) b7);
                }
                String lowerCase = sb.toString().toLowerCase(Locale.ENGLISH);
                int length2 = f51227m.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        break;
                    }
                    if (lowerCase.equals(f51227m[i10])) {
                        i8 = i10;
                        break;
                    }
                    i10++;
                }
                this.f51229k = i8;
                if (i10 < length2) {
                    return;
                }
                throw new TFTPPacketException("Unrecognized TFTP transfer mode: " + lowerCase);
            }
            throw new TFTPPacketException("Bad filename and mode format.");
        }
        throw new TFTPPacketException("TFTP operator code does not match type.");
    }
}
