package io.netty.handler.codec.socksx.v5;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks5PasswordAuthStatus implements Comparable<Socks5PasswordAuthStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5PasswordAuthStatus SUCCESS = new Socks5PasswordAuthStatus(0, MonitorResult.SUCCESS);
    public static final Socks5PasswordAuthStatus FAILURE = new Socks5PasswordAuthStatus(255, "FAILURE");

    public Socks5PasswordAuthStatus(int i6) {
        this(i6, "UNKNOWN");
    }

    public static Socks5PasswordAuthStatus valueOf(byte b6) {
        return b6 != -1 ? b6 != 0 ? new Socks5PasswordAuthStatus(b6) : SUCCESS : FAILURE;
    }

    public Socks5PasswordAuthStatus(int i6, String str) {
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
    public int compareTo(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        return this.byteValue - socks5PasswordAuthStatus.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5PasswordAuthStatus) && this.byteValue == ((Socks5PasswordAuthStatus) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 0;
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
