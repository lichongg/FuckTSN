package io.netty.handler.codec.http;

import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.net.ftp.l;
import org.apache.commons.net.nntp.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    private final byte[] bytes;
    private final int code;
    private final AsciiString codeAsText;
    private HttpStatusClass codeClass;
    private final String reasonPhrase;
    public static final HttpResponseStatus CONTINUE = newStatus(100, "Continue");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");
    public static final HttpResponseStatus PROCESSING = newStatus(102, "Processing");
    public static final HttpResponseStatus OK = newStatus(200, ca.f10845k);
    public static final HttpResponseStatus CREATED = newStatus(201, "Created");
    public static final HttpResponseStatus ACCEPTED = newStatus(202, "Accepted");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = newStatus(203, "Non-Authoritative Information");
    public static final HttpResponseStatus NO_CONTENT = newStatus(204, "No Content");
    public static final HttpResponseStatus RESET_CONTENT = newStatus(205, "Reset Content");
    public static final HttpResponseStatus PARTIAL_CONTENT = newStatus(206, "Partial Content");
    public static final HttpResponseStatus MULTI_STATUS = newStatus(207, "Multi-Status");
    public static final HttpResponseStatus MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");
    public static final HttpResponseStatus MOVED_PERMANENTLY = newStatus(301, "Moved Permanently");
    public static final HttpResponseStatus FOUND = newStatus(302, "Found");
    public static final HttpResponseStatus SEE_OTHER = newStatus(303, "See Other");
    public static final HttpResponseStatus NOT_MODIFIED = newStatus(304, "Not Modified");
    public static final HttpResponseStatus USE_PROXY = newStatus(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, "Use Proxy");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = newStatus(307, "Temporary Redirect");
    public static final HttpResponseStatus PERMANENT_REDIRECT = newStatus(308, "Permanent Redirect");
    public static final HttpResponseStatus BAD_REQUEST = newStatus(400, "Bad Request");
    public static final HttpResponseStatus UNAUTHORIZED = newStatus(401, "Unauthorized");
    public static final HttpResponseStatus PAYMENT_REQUIRED = newStatus(402, "Payment Required");
    public static final HttpResponseStatus FORBIDDEN = newStatus(403, "Forbidden");
    public static final HttpResponseStatus NOT_FOUND = newStatus(404, "Not Found");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");
    public static final HttpResponseStatus NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = newStatus(407, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUEST_TIMEOUT = newStatus(TTAdConstant.INTERACTION_TYPE_CODE, "Request Timeout");
    public static final HttpResponseStatus CONFLICT = newStatus(TTAdConstant.IMAGE_LIST_CODE, "Conflict");
    public static final HttpResponseStatus GONE = newStatus(TTAdConstant.IMAGE_LIST_SIZE_CODE, "Gone");
    public static final HttpResponseStatus LENGTH_REQUIRED = newStatus(411, "Length Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = newStatus(412, "Precondition Failed");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = newStatus(TTAdConstant.VIDEO_INFO_CODE, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = newStatus(TTAdConstant.VIDEO_URL_CODE, "Request-URI Too Long");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = newStatus(TTAdConstant.VIDEO_COVER_URL_CODE, "Unsupported Media Type");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = newStatus(TTAdConstant.LIVE_AD_CODE, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus EXPECTATION_FAILED = newStatus(TTAdConstant.LIVE_FEED_URL_CODE, "Expectation Failed");
    public static final HttpResponseStatus MISDIRECTED_REQUEST = newStatus(421, "Misdirected Request");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = newStatus(h.f50926y, "Unprocessable Entity");
    public static final HttpResponseStatus LOCKED = newStatus(h.f50927z, "Locked");
    public static final HttpResponseStatus FAILED_DEPENDENCY = newStatus(424, "Failed Dependency");
    public static final HttpResponseStatus UNORDERED_COLLECTION = newStatus(l.f50698y, "Unordered Collection");
    public static final HttpResponseStatus UPGRADE_REQUIRED = newStatus(l.f50699z, "Upgrade Required");
    public static final HttpResponseStatus PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");
    public static final HttpResponseStatus TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");
    public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE = newStatus(l.S, "Request Header Fields Too Large");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = newStatus(500, "Internal Server Error");
    public static final HttpResponseStatus NOT_IMPLEMENTED = newStatus(501, "Not Implemented");
    public static final HttpResponseStatus BAD_GATEWAY = newStatus(502, "Bad Gateway");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = newStatus(503, "Service Unavailable");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = newStatus(504, "Gateway Timeout");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = newStatus(505, "HTTP Version Not Supported");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = newStatus(506, "Variant Also Negotiates");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = newStatus(507, "Insufficient Storage");
    public static final HttpResponseStatus NOT_EXTENDED = newStatus(MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR, "Not Extended");
    public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = newStatus(511, "Network Authentication Required");

    private HttpResponseStatus(int i6) {
        this(i6, ((Object) HttpStatusClass.valueOf(i6).defaultReasonPhrase()) + " (" + i6 + ')', false);
    }

    public static HttpResponseStatus parseLine(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? parseLine((AsciiString) charSequence) : parseLine(charSequence.toString());
    }

    public static HttpResponseStatus valueOf(int i6) {
        HttpResponseStatus valueOf0 = valueOf0(i6);
        return valueOf0 != null ? valueOf0 : new HttpResponseStatus(i6);
    }

    public HttpResponseStatus(int i6, String str) {
        this(i6, str, false);
    }

    private static HttpResponseStatus newStatus(int i6, String str) {
        return new HttpResponseStatus(i6, str, true);
    }

    public static HttpResponseStatus parseLine(String str) {
        try {
            int indexOf = str.indexOf(32);
            return indexOf == -1 ? valueOf(Integer.parseInt(str)) : valueOf(Integer.parseInt(str.substring(0, indexOf)), str.substring(indexOf + 1));
        } catch (Exception e6) {
            throw new IllegalArgumentException("malformed status line: " + str, e6);
        }
    }

    private static HttpResponseStatus valueOf0(int i6) {
        if (i6 == 307) {
            return TEMPORARY_REDIRECT;
        }
        if (i6 == 308) {
            return PERMANENT_REDIRECT;
        }
        if (i6 == 428) {
            return PRECONDITION_REQUIRED;
        }
        if (i6 == 429) {
            return TOO_MANY_REQUESTS;
        }
        if (i6 == 431) {
            return REQUEST_HEADER_FIELDS_TOO_LARGE;
        }
        if (i6 == 510) {
            return NOT_EXTENDED;
        }
        if (i6 == 511) {
            return NETWORK_AUTHENTICATION_REQUIRED;
        }
        switch (i6) {
            case 100:
                return CONTINUE;
            case 101:
                return SWITCHING_PROTOCOLS;
            case 102:
                return PROCESSING;
            default:
                switch (i6) {
                    case 200:
                        return OK;
                    case 201:
                        return CREATED;
                    case 202:
                        return ACCEPTED;
                    case 203:
                        return NON_AUTHORITATIVE_INFORMATION;
                    case 204:
                        return NO_CONTENT;
                    case 205:
                        return RESET_CONTENT;
                    case 206:
                        return PARTIAL_CONTENT;
                    case 207:
                        return MULTI_STATUS;
                    default:
                        switch (i6) {
                            case 300:
                                return MULTIPLE_CHOICES;
                            case 301:
                                return MOVED_PERMANENTLY;
                            case 302:
                                return FOUND;
                            case 303:
                                return SEE_OTHER;
                            case 304:
                                return NOT_MODIFIED;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO /* 305 */:
                                return USE_PROXY;
                            default:
                                switch (i6) {
                                    case 400:
                                        return BAD_REQUEST;
                                    case 401:
                                        return UNAUTHORIZED;
                                    case 402:
                                        return PAYMENT_REQUIRED;
                                    case 403:
                                        return FORBIDDEN;
                                    case 404:
                                        return NOT_FOUND;
                                    case 405:
                                        return METHOD_NOT_ALLOWED;
                                    case 406:
                                        return NOT_ACCEPTABLE;
                                    case 407:
                                        return PROXY_AUTHENTICATION_REQUIRED;
                                    case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                        return REQUEST_TIMEOUT;
                                    case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                        return CONFLICT;
                                    case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                        return GONE;
                                    case 411:
                                        return LENGTH_REQUIRED;
                                    case 412:
                                        return PRECONDITION_FAILED;
                                    case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                        return REQUEST_ENTITY_TOO_LARGE;
                                    case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                        return REQUEST_URI_TOO_LONG;
                                    case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                        return UNSUPPORTED_MEDIA_TYPE;
                                    case TTAdConstant.LIVE_AD_CODE /* 416 */:
                                        return REQUESTED_RANGE_NOT_SATISFIABLE;
                                    case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                                        return EXPECTATION_FAILED;
                                    default:
                                        switch (i6) {
                                            case 421:
                                                return MISDIRECTED_REQUEST;
                                            case h.f50926y /* 422 */:
                                                return UNPROCESSABLE_ENTITY;
                                            case h.f50927z /* 423 */:
                                                return LOCKED;
                                            case 424:
                                                return FAILED_DEPENDENCY;
                                            case l.f50698y /* 425 */:
                                                return UNORDERED_COLLECTION;
                                            case l.f50699z /* 426 */:
                                                return UPGRADE_REQUIRED;
                                            default:
                                                switch (i6) {
                                                    case 500:
                                                        return INTERNAL_SERVER_ERROR;
                                                    case 501:
                                                        return NOT_IMPLEMENTED;
                                                    case 502:
                                                        return BAD_GATEWAY;
                                                    case 503:
                                                        return SERVICE_UNAVAILABLE;
                                                    case 504:
                                                        return GATEWAY_TIMEOUT;
                                                    case 505:
                                                        return HTTP_VERSION_NOT_SUPPORTED;
                                                    case 506:
                                                        return VARIANT_ALSO_NEGOTIATES;
                                                    case 507:
                                                        return INSUFFICIENT_STORAGE;
                                                    default:
                                                        return null;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public int code() {
        return this.code;
    }

    public AsciiString codeAsText() {
        return this.codeAsText;
    }

    public HttpStatusClass codeClass() {
        HttpStatusClass httpStatusClass = this.codeClass;
        if (httpStatusClass != null) {
            return httpStatusClass;
        }
        HttpStatusClass valueOf = HttpStatusClass.valueOf(this.code);
        this.codeClass = valueOf;
        return valueOf;
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpResponseStatus httpResponseStatus) {
        return code() - httpResponseStatus.code();
    }

    void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            byteBuf.writeBytes(bArr);
            return;
        }
        ByteBufUtil.copy(this.codeAsText, byteBuf);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(this.reasonPhrase, CharsetUtil.US_ASCII);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpResponseStatus) && code() == ((HttpResponseStatus) obj).code();
    }

    public String reasonPhrase() {
        return this.reasonPhrase;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.reasonPhrase.length() + 4);
        sb.append((CharSequence) this.codeAsText);
        sb.append(' ');
        sb.append(this.reasonPhrase);
        return sb.toString();
    }

    private HttpResponseStatus(int i6, String str, boolean z5) {
        ObjectUtil.checkPositiveOrZero(i6, "code");
        if (str != null) {
            for (int i7 = 0; i7 < str.length(); i7++) {
                char charAt = str.charAt(i7);
                if (charAt == '\n' || charAt == '\r') {
                    throw new IllegalArgumentException("reasonPhrase contains one of the following prohibited characters: \\r\\n: " + str);
                }
            }
            this.code = i6;
            String num = Integer.toString(i6);
            this.codeAsText = new AsciiString(num);
            this.reasonPhrase = str;
            if (z5) {
                this.bytes = (num + ' ' + str).getBytes(CharsetUtil.US_ASCII);
                return;
            }
            this.bytes = null;
            return;
        }
        throw new NullPointerException("reasonPhrase");
    }

    public static HttpResponseStatus valueOf(int i6, String str) {
        HttpResponseStatus valueOf0 = valueOf0(i6);
        return (valueOf0 == null || !valueOf0.reasonPhrase().contentEquals(str)) ? new HttpResponseStatus(i6, str) : valueOf0;
    }

    public int hashCode() {
        return code();
    }

    public static HttpResponseStatus parseLine(AsciiString asciiString) {
        try {
            int forEachByte = asciiString.forEachByte(ByteProcessor.FIND_ASCII_SPACE);
            return forEachByte == -1 ? valueOf(asciiString.parseInt()) : valueOf(asciiString.parseInt(0, forEachByte), asciiString.toString(forEachByte + 1));
        } catch (Exception e6) {
            throw new IllegalArgumentException("malformed status line: " + ((Object) asciiString), e6);
        }
    }
}
