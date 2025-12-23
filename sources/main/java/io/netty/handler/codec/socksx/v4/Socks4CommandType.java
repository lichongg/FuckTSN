package io.netty.handler.codec.socksx.v4;

import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks4CommandType implements Comparable<Socks4CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandType CONNECT = new Socks4CommandType(1, "CONNECT");
    public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");

    public Socks4CommandType(int i6) {
        this(i6, "UNKNOWN");
    }

    public static Socks4CommandType valueOf(byte b6) {
        return b6 != 1 ? b6 != 2 ? new Socks4CommandType(b6) : BIND : CONNECT;
    }

    public Socks4CommandType(int i6, String str) {
        if (str == null) {
            throw new NullPointerException(CommonNetImpl.NAME);
        }
        this.byteValue = (byte) i6;
        this.name = str;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks4CommandType socks4CommandType) {
        return this.byteValue - socks4CommandType.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandType) && this.byteValue == ((Socks4CommandType) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = this.name + '(' + (this.byteValue & 255) + ')';
        this.text = str2;
        return str2;
    }
}
