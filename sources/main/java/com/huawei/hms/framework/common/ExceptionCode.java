package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ExceptionCode {
    public static final int CANCEL = 10000100;
    public static final int CONNECTION_ABORT = 10000402;
    public static final int CONNECTION_REFUSED = 10000404;
    public static final int CONNECTION_RESET = 10000401;
    public static final int CONNECT_FAILED = 10000403;
    public static final int CRASH_EXCEPTION = 10000000;
    public static final int INTERRUPT_CONNECT_CLOSE = 10000405;
    public static final int INTERRUPT_EXCEPTION = 10000804;
    public static final int NETWORK_CHANGED = 10000201;
    public static final int NETWORK_IO_EXCEPTION = 10000802;
    public static final int NETWORK_TIMEOUT = 10000101;
    public static final int NETWORK_UNREACHABLE = 10000200;
    public static final int NETWORK_UNSUPPORTED = 10000102;
    public static final int PROTOCOL_ERROR = 10000801;
    public static final int READ_ERROR = 10000601;
    public static final int ROUTE_FAILED = 10000301;
    public static final int SHUTDOWN_EXCEPTION = 10000202;
    public static final int SOCKET_CLOSE = 10000406;
    public static final int SOCKET_CONNECT_TIMEOUT = 10000400;
    public static final int SOCKET_READ_TIMEOUT = 10000600;
    public static final int SOCKET_TIMEOUT = 10000803;
    public static final int SOCKET_WRITE_TIMEOUT = 10000700;
    public static final int SSL_HANDSHAKE_EXCEPTION = 10000501;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 10000502;
    public static final int SSL_PROTOCOL_EXCEPTION = 10000500;
    public static final int UNABLE_TO_RESOLVE_HOST = 10000300;
    public static final int UNEXPECTED_EOF = 10000800;

    /* renamed from: a, reason: collision with root package name */
    private static final String f33303a = "connect";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33304b = "read";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33305c = "write";

    private static int c(String str) {
        return str.contains("unexpected end of stream") ? UNEXPECTED_EOF : str.contains("unable to resolve host") ? UNABLE_TO_RESOLVE_HOST : str.contains("read error") ? READ_ERROR : str.contains("connection reset") ? CONNECTION_RESET : str.contains("software caused connection abort") ? CONNECTION_ABORT : str.contains("failed to connect to") ? CONNECT_FAILED : str.contains("connection refused") ? CONNECTION_REFUSED : str.contains("connection timed out") ? SOCKET_CONNECT_TIMEOUT : str.contains("no route to host") ? ROUTE_FAILED : str.contains("network is unreachable") ? NETWORK_UNREACHABLE : str.contains("socket closed") ? SOCKET_CLOSE : NETWORK_IO_EXCEPTION;
    }

    private static int d(Exception exc) {
        String a6 = a(exc, f33303a, f33304b, f33305c);
        a6.getClass();
        switch (a6) {
            case "read":
                return SOCKET_READ_TIMEOUT;
            case "write":
                return SOCKET_WRITE_TIMEOUT;
            case "connect":
                return SOCKET_CONNECT_TIMEOUT;
            default:
                return SOCKET_TIMEOUT;
        }
    }

    private static String a(Exception exc, String... strArr) {
        return b(StringUtils.toLowerCase(exc.getMessage()), strArr);
    }

    private static String b(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static int getErrorCodeFromException(Exception exc) {
        if (exc == null) {
            return NETWORK_IO_EXCEPTION;
        }
        if (!(exc instanceof IOException)) {
            return 10000000;
        }
        String message = exc.getMessage();
        if (message == null) {
            return NETWORK_IO_EXCEPTION;
        }
        String lowerCase = StringUtils.toLowerCase(message);
        int c6 = c(lowerCase);
        if (c6 == 10000802) {
            if (exc instanceof SocketTimeoutException) {
                return d(exc);
            }
            if (exc instanceof ConnectException) {
                return CONNECT_FAILED;
            }
            if (exc instanceof NoRouteToHostException) {
                return ROUTE_FAILED;
            }
            if (exc instanceof SSLProtocolException) {
                return SSL_PROTOCOL_EXCEPTION;
            }
            if (exc instanceof SSLHandshakeException) {
                return SSL_HANDSHAKE_EXCEPTION;
            }
            if (exc instanceof SSLPeerUnverifiedException) {
                return SSL_PEERUNVERIFIED_EXCEPTION;
            }
            if (exc instanceof UnknownHostException) {
                return UNABLE_TO_RESOLVE_HOST;
            }
            if (exc instanceof InterruptedIOException) {
                if (lowerCase.contains("connection has been shut down")) {
                    return INTERRUPT_CONNECT_CLOSE;
                }
                return INTERRUPT_EXCEPTION;
            }
            if (exc instanceof ProtocolException) {
                return PROTOCOL_ERROR;
            }
        }
        return c6;
    }
}
