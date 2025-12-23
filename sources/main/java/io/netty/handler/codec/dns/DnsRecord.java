package io.netty.handler.codec.dns;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsRecord {
    public static final int CLASS_ANY = 255;
    public static final int CLASS_CHAOS = 3;
    public static final int CLASS_CSNET = 2;
    public static final int CLASS_HESIOD = 4;
    public static final int CLASS_IN = 1;
    public static final int CLASS_NONE = 254;

    int dnsClass();

    String name();

    long timeToLive();

    DnsRecordType type();
}
