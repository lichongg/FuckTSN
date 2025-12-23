package io.netty.handler.codec.socksx.v5;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks5AddressType implements Comparable<Socks5AddressType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5AddressType IPv4 = new Socks5AddressType(1, "IPv4");
    public static final Socks5AddressType DOMAIN = new Socks5AddressType(3, Field.DOMAIN);
    public static final Socks5AddressType IPv6 = new Socks5AddressType(4, "IPv6");

    public Socks5AddressType(int i6) {
        this(i6, "UNKNOWN");
    }

    public static Socks5AddressType valueOf(byte b6) {
        return b6 != 1 ? b6 != 3 ? b6 != 4 ? new Socks5AddressType(b6) : IPv6 : DOMAIN : IPv4;
    }

    public Socks5AddressType(int i6, String str) {
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
    public int compareTo(Socks5AddressType socks5AddressType) {
        return this.byteValue - socks5AddressType.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5AddressType) && this.byteValue == ((Socks5AddressType) obj).byteValue;
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
