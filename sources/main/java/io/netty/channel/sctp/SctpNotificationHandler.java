package io.netty.channel.sctp;

import com.sun.nio.sctp.AbstractNotificationHandler;
import com.sun.nio.sctp.AssociationChangeNotification;
import com.sun.nio.sctp.HandlerResult;
import com.sun.nio.sctp.Notification;
import com.sun.nio.sctp.PeerAddressChangeNotification;
import com.sun.nio.sctp.SendFailedNotification;
import com.sun.nio.sctp.ShutdownNotification;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SctpNotificationHandler extends AbstractNotificationHandler<Object> {
    private final SctpChannel sctpChannel;

    public HandlerResult handleNotification(AssociationChangeNotification associationChangeNotification, Object obj) {
        fireEvent(associationChangeNotification);
        return HandlerResult.CONTINUE;
    }

    private void fireEvent(Notification notification) {
        this.sctpChannel.pipeline().fireUserEventTriggered((Object) notification);
    }

    public SctpNotificationHandler(SctpChannel sctpChannel) {
        if (sctpChannel != null) {
            this.sctpChannel = sctpChannel;
            return;
        }
        throw new NullPointerException("sctpChannel");
    }

    public HandlerResult handleNotification(PeerAddressChangeNotification peerAddressChangeNotification, Object obj) {
        fireEvent(peerAddressChangeNotification);
        return HandlerResult.CONTINUE;
    }

    public HandlerResult handleNotification(SendFailedNotification sendFailedNotification, Object obj) {
        fireEvent(sendFailedNotification);
        return HandlerResult.CONTINUE;
    }

    public HandlerResult handleNotification(ShutdownNotification shutdownNotification, Object obj) {
        fireEvent(shutdownNotification);
        this.sctpChannel.close();
        return HandlerResult.RETURN;
    }
}
