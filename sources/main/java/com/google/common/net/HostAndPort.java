package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private static String[] getHostAndPortFromBracketedHost(String str) {
        Preconditions.checkArgument(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        Preconditions.checkArgument(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
        String substring = str.substring(1, lastIndexOf);
        int i6 = lastIndexOf + 1;
        if (i6 == str.length()) {
            return new String[]{substring, ""};
        }
        Preconditions.checkArgument(str.charAt(i6) == ':', "Only a colon may follow a close bracket: %s", str);
        int i7 = lastIndexOf + 2;
        for (int i8 = i7; i8 < str.length(); i8++) {
            Preconditions.checkArgument(Character.isDigit(str.charAt(i8)), "Port must be numeric: %s", str);
        }
        return new String[]{substring, str.substring(i7)};
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostAndPort) {
            HostAndPort hostAndPort = (HostAndPort) obj;
            if (Objects.equal(this.host, hostAndPort.host) && this.port == hostAndPort.port) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidPort(int i6) {
        return i6 >= 0 && i6 <= 65535;
    }

    public String getHost() {
        return this.host;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return Objects.hashCode(this.host, Integer.valueOf(this.port));
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.host);
            sb.append(']');
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(':');
            sb.append(this.port);
        }
        return sb.toString();
    }

    private HostAndPort(String str, int i6, boolean z5) {
        this.host = str;
        this.port = i6;
        this.hasBracketlessColons = z5;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i6) {
        Preconditions.checkArgument(isValidPort(i6), "Port out of range: %s", i6);
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(fromString.host, i6, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
        Preconditions.checkNotNull(str);
        int i6 = -1;
        boolean z5 = false;
        if (str.startsWith("[")) {
            String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
            str3 = hostAndPortFromBracketedHost[0];
            str2 = hostAndPortFromBracketedHost[1];
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                int i7 = indexOf + 1;
                if (str.indexOf(58, i7) == -1) {
                    str3 = str.substring(0, indexOf);
                    str2 = str.substring(i7);
                }
            }
            if (indexOf >= 0) {
                z5 = true;
            }
            str2 = null;
            str3 = str;
        }
        if (!Strings.isNullOrEmpty(str2)) {
            Preconditions.checkArgument(!str2.startsWith(Marker.ANY_NON_NULL_MARKER), "Unparseable port number: %s", str);
            try {
                i6 = Integer.parseInt(str2);
                Preconditions.checkArgument(isValidPort(i6), "Port number out of range: %s", str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Unparseable port number: " + str);
            }
        }
        return new HostAndPort(str3, i6, z5);
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i6) {
        if (hasPort()) {
            return this.port;
        }
        return i6;
    }

    public HostAndPort withDefaultPort(int i6) {
        Preconditions.checkArgument(isValidPort(i6));
        if (hasPort()) {
            return this;
        }
        return new HostAndPort(this.host, i6, this.hasBracketlessColons);
    }
}
