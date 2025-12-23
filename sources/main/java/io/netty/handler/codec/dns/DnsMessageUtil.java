package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DnsMessageUtil {
    private static StringBuilder appendAddresses(StringBuilder sb, DnsMessage dnsMessage) {
        if (dnsMessage instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) dnsMessage;
            SocketAddress sender = addressedEnvelope.sender();
            if (sender != null) {
                sb.append("from: ");
                sb.append(sender);
                sb.append(", ");
            }
            SocketAddress recipient = addressedEnvelope.recipient();
            if (recipient != null) {
                sb.append("to: ");
                sb.append(recipient);
                sb.append(", ");
            }
        }
        return sb;
    }

    private static void appendAllRecords(StringBuilder sb, DnsMessage dnsMessage) {
        appendRecords(sb, dnsMessage, DnsSection.QUESTION);
        appendRecords(sb, dnsMessage, DnsSection.ANSWER);
        appendRecords(sb, dnsMessage, DnsSection.AUTHORITY);
        appendRecords(sb, dnsMessage, DnsSection.ADDITIONAL);
    }

    private DnsMessageUtil() {
    }

    static StringBuilder appendQuery(StringBuilder sb, DnsQuery dnsQuery) {
        appendQueryHeader(sb, dnsQuery);
        appendAllRecords(sb, dnsQuery);
        return sb;
    }

    private static void appendQueryHeader(StringBuilder sb, DnsQuery dnsQuery) {
        sb.append(StringUtil.simpleClassName(dnsQuery));
        sb.append('(');
        StringBuilder appendAddresses = appendAddresses(sb, dnsQuery);
        appendAddresses.append(dnsQuery.id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsQuery.opCode());
        if (dnsQuery.isRecursionDesired()) {
            sb.append(", RD");
        }
        if (dnsQuery.z() != 0) {
            sb.append(", Z: ");
            sb.append(dnsQuery.z());
        }
        sb.append(')');
    }

    static StringBuilder appendRecordClass(StringBuilder sb, int i6) {
        String str;
        int i7 = i6 & 65535;
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 3) {
                    if (i7 != 4) {
                        if (i7 != 254) {
                            if (i7 != 255) {
                                str = null;
                            } else {
                                str = "ANY";
                            }
                        } else {
                            str = "NONE";
                        }
                    } else {
                        str = "HESIOD";
                    }
                } else {
                    str = "CHAOS";
                }
            } else {
                str = "CSNET";
            }
        } else {
            str = "IN";
        }
        if (str != null) {
            sb.append(str);
            return sb;
        }
        sb.append("UNKNOWN(");
        sb.append(i7);
        sb.append(')');
        return sb;
    }

    private static void appendRecords(StringBuilder sb, DnsMessage dnsMessage, DnsSection dnsSection) {
        int count = dnsMessage.count(dnsSection);
        for (int i6 = 0; i6 < count; i6++) {
            sb.append(StringUtil.NEWLINE);
            sb.append('\t');
            sb.append(dnsMessage.recordAt(dnsSection, i6));
        }
    }

    static StringBuilder appendResponse(StringBuilder sb, DnsResponse dnsResponse) {
        appendResponseHeader(sb, dnsResponse);
        appendAllRecords(sb, dnsResponse);
        return sb;
    }

    private static void appendResponseHeader(StringBuilder sb, DnsResponse dnsResponse) {
        boolean z5;
        sb.append(StringUtil.simpleClassName(dnsResponse));
        sb.append('(');
        StringBuilder appendAddresses = appendAddresses(sb, dnsResponse);
        appendAddresses.append(dnsResponse.id());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.opCode());
        appendAddresses.append(", ");
        appendAddresses.append(dnsResponse.code());
        appendAddresses.append(StringUtil.COMMA);
        boolean z6 = false;
        if (dnsResponse.isRecursionDesired()) {
            sb.append(" RD");
            z5 = false;
        } else {
            z5 = true;
        }
        if (dnsResponse.isAuthoritativeAnswer()) {
            sb.append(" AA");
            z5 = false;
        }
        if (dnsResponse.isTruncated()) {
            sb.append(" TC");
            z5 = false;
        }
        if (dnsResponse.isRecursionAvailable()) {
            sb.append(" RA");
        } else {
            z6 = z5;
        }
        if (dnsResponse.z() != 0) {
            if (!z6) {
                sb.append(StringUtil.COMMA);
            }
            sb.append(" Z: ");
            sb.append(dnsResponse.z());
        }
        if (z6) {
            sb.setCharAt(sb.length() - 1, ')');
        } else {
            sb.append(')');
        }
    }
}
