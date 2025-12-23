package io.netty.handler.codec.socksx.v5;

import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks5AuthMethod implements Comparable<Socks5AuthMethod> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5AuthMethod NO_AUTH = new Socks5AuthMethod(0, "NO_AUTH");
    public static final Socks5AuthMethod GSSAPI = new Socks5AuthMethod(1, "GSSAPI");
    public static final Socks5AuthMethod PASSWORD = new Socks5AuthMethod(2, "PASSWORD");
    public static final Socks5AuthMethod UNACCEPTED = new Socks5AuthMethod(255, "UNACCEPTED");

    public Socks5AuthMethod(int i6) {
        this(i6, "UNKNOWN");
    }

    public static Socks5AuthMethod valueOf(byte b6) {
        return b6 != -1 ? b6 != 0 ? b6 != 1 ? b6 != 2 ? new Socks5AuthMethod(b6) : PASSWORD : GSSAPI : NO_AUTH : UNACCEPTED;
    }

    public Socks5AuthMethod(int i6, String str) {
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
    public int compareTo(Socks5AuthMethod socks5AuthMethod) {
        return this.byteValue - socks5AuthMethod.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5AuthMethod) && this.byteValue == ((Socks5AuthMethod) obj).byteValue;
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
