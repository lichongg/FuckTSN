package io.netty.channel.socket.nio;

import io.netty.channel.socket.InternetProtocolFamily;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ProtocolFamilyConverter {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.socket.nio.ProtocolFamilyConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] iArr = new int[InternetProtocolFamily.values().length];
            $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = iArr;
            try {
                iArr[InternetProtocolFamily.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static ProtocolFamily convert(InternetProtocolFamily internetProtocolFamily) {
        StandardProtocolFamily standardProtocolFamily;
        StandardProtocolFamily standardProtocolFamily2;
        int i6 = AnonymousClass1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[internetProtocolFamily.ordinal()];
        if (i6 == 1) {
            standardProtocolFamily = StandardProtocolFamily.INET;
            return standardProtocolFamily;
        }
        if (i6 != 2) {
            throw new IllegalArgumentException();
        }
        standardProtocolFamily2 = StandardProtocolFamily.INET6;
        return standardProtocolFamily2;
    }

    private ProtocolFamilyConverter() {
    }
}
