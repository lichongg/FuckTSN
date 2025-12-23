package io.netty.handler.codec.socksx.v4;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socks4CommandStatus implements Comparable<Socks4CommandStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandStatus SUCCESS = new Socks4CommandStatus(90, MonitorResult.SUCCESS);
    public static final Socks4CommandStatus REJECTED_OR_FAILED = new Socks4CommandStatus(91, "REJECTED_OR_FAILED");
    public static final Socks4CommandStatus IDENTD_UNREACHABLE = new Socks4CommandStatus(92, "IDENTD_UNREACHABLE");
    public static final Socks4CommandStatus IDENTD_AUTH_FAILURE = new Socks4CommandStatus(93, "IDENTD_AUTH_FAILURE");

    public Socks4CommandStatus(int i6) {
        this(i6, "UNKNOWN");
    }

    public Socks4CommandStatus(int i6, String str) {
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
    public int compareTo(Socks4CommandStatus socks4CommandStatus) {
        return this.byteValue - socks4CommandStatus.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks4CommandStatus) && this.byteValue == ((Socks4CommandStatus) obj).byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 90;
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

    public static Socks4CommandStatus valueOf(byte b6) {
        switch (b6) {
            case 90:
                return SUCCESS;
            case 91:
                return REJECTED_OR_FAILED;
            case 92:
                return IDENTD_UNREACHABLE;
            case 93:
                return IDENTD_AUTH_FAILURE;
            default:
                return new Socks4CommandStatus(b6);
        }
    }
}
