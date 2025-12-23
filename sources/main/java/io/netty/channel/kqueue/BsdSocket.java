package io.netty.channel.kqueue;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class BsdSocket extends Socket {
    private static final int APPLE_SND_LOW_AT_MAX = 131072;
    static final int BSD_SND_LOW_AT_MAX = Math.min(131072, 32768);
    private static final int FREEBSD_SND_LOW_AT_MAX = 32768;

    private static native String[] getAcceptFilter(int i6) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i6) throws IOException;

    private static native int getSndLowAt(int i6) throws IOException;

    private static native int getTcpNoPush(int i6) throws IOException;

    private static native long sendFile(int i6, DefaultFileRegion defaultFileRegion, long j6, long j7, long j8) throws IOException;

    private static native void setAcceptFilter(int i6, String str, String str2) throws IOException;

    private static native void setSndLowAt(int i6, int i7) throws IOException;

    private static native void setTcpNoPush(int i6, int i7) throws IOException;

    AcceptFilter getAcceptFilter() throws IOException {
        String[] acceptFilter = getAcceptFilter(intValue());
        return acceptFilter == null ? AcceptFilter.PLATFORM_UNSUPPORTED : new AcceptFilter(acceptFilter[0], acceptFilter[1]);
    }

    PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    int getSndLowAt() throws IOException {
        return getSndLowAt(intValue());
    }

    long sendFile(DefaultFileRegion defaultFileRegion, long j6, long j7, long j8) throws IOException {
        defaultFileRegion.open();
        long sendFile = sendFile(intValue(), defaultFileRegion, j6, j7, j8);
        return sendFile >= 0 ? sendFile : Errors.ioResult("sendfile", (int) sendFile);
    }

    void setAcceptFilter(AcceptFilter acceptFilter) throws IOException {
        setAcceptFilter(intValue(), acceptFilter.filterName(), acceptFilter.filterArgs());
    }

    void setSndLowAt(int i6) throws IOException {
        setSndLowAt(intValue(), i6);
    }

    void setTcpNoPush(boolean z5) throws IOException {
        setTcpNoPush(intValue(), z5 ? 1 : 0);
    }

    public static BsdSocket newSocketDgram() {
        return new BsdSocket(Socket.newSocketDgram0());
    }

    public static BsdSocket newSocketDomain() {
        return new BsdSocket(Socket.newSocketDomain0());
    }

    public static BsdSocket newSocketStream() {
        return new BsdSocket(Socket.newSocketStream0());
    }

    BsdSocket(int i6) {
        super(i6);
    }

    boolean isTcpNoPush() throws IOException {
        if (getTcpNoPush(intValue()) != 0) {
            return true;
        }
        return false;
    }
}
