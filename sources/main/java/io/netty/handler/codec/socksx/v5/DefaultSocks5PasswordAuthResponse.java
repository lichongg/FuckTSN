package io.netty.handler.codec.socksx.v5;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSocks5PasswordAuthResponse extends AbstractSocks5Message implements Socks5PasswordAuthResponse {
    private final Socks5PasswordAuthStatus status;

    @Override // io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponse
    public Socks5PasswordAuthStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(status: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", status: ");
        }
        sb.append(status());
        sb.append(')');
        return sb.toString();
    }

    public DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        if (socks5PasswordAuthStatus != null) {
            this.status = socks5PasswordAuthStatus;
            return;
        }
        throw new NullPointerException(NotificationCompat.CATEGORY_STATUS);
    }
}
