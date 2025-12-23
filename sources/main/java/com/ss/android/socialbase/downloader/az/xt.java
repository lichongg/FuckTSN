package com.ss.android.socialbase.downloader.az;

import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.apache.commons.net.ftp.l;
import org.apache.commons.net.nntp.h;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt {
    public static String j(int i6) {
        if (i6 == 449) {
            return "Retry With";
        }
        if (i6 == 451) {
            return "Unavailable For Legal Reasons";
        }
        if (i6 == 600) {
            return "Unparseable Response Headers";
        }
        if (i6 == 509) {
            return "Bandwidth Limit Exceeded";
        }
        if (i6 == 510) {
            return "Not Extended";
        }
        switch (i6) {
            case 100:
                return "Continue";
            case 101:
                return "Switching Protocols";
            case 102:
                return "Processing";
            default:
                switch (i6) {
                    case 200:
                        return ca.f10845k;
                    case 201:
                        return "Created";
                    case 202:
                        return "Accepted";
                    case 203:
                        return "Non-Authoritative Information";
                    case 204:
                        return "No Content";
                    case 205:
                        return "Reset Content";
                    case 206:
                        return "Partial Content";
                    case 207:
                        return "Multi-Status";
                    default:
                        switch (i6) {
                            case 300:
                                return "Multiple Choices";
                            case 301:
                                return "Moved Permanently";
                            case 302:
                                return "Move Temporarily";
                            case 303:
                                return "See Other";
                            case 304:
                                return "Not Modified";
                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO /* 305 */:
                                return "Use Proxy";
                            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY /* 306 */:
                                return "Switch Proxy";
                            case 307:
                                return "Temporary Redirect";
                            default:
                                switch (i6) {
                                    case 400:
                                        return "Bad Request";
                                    case 401:
                                        return "Unauthorized";
                                    case 402:
                                        return "Payment Required";
                                    case 403:
                                        return "Forbidden";
                                    case 404:
                                        return "Not Found";
                                    case 405:
                                        return "Method Not Allowed";
                                    case 406:
                                        return "Not Acceptable";
                                    case 407:
                                        return "Proxy Authentication Required";
                                    case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                        return "Request Timeout";
                                    case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                        return "Conflict";
                                    case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                        return "Gone";
                                    case 411:
                                        return "Length Required";
                                    case 412:
                                        return "Precondition Failed";
                                    case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                        return "Request Entity Too Large";
                                    case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                        return "Request-URI Too Long";
                                    case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                        return "Unsupported Media Type";
                                    case TTAdConstant.LIVE_AD_CODE /* 416 */:
                                        return "Requested Range Not Satisfiable";
                                    case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                                        return "Expectation Failed";
                                    case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                        return "I'm a teapot";
                                    default:
                                        switch (i6) {
                                            case 421:
                                                return "Too Many Connections";
                                            case h.f50926y /* 422 */:
                                                return "Unprocessable Entity";
                                            case h.f50927z /* 423 */:
                                                return "Locked";
                                            case 424:
                                                return "Failed Dependency";
                                            case l.f50698y /* 425 */:
                                                return "Unordered Collection";
                                            case l.f50699z /* 426 */:
                                                return "Upgrade Required";
                                            default:
                                                switch (i6) {
                                                    case 500:
                                                        return "Internal Server Error";
                                                    case 501:
                                                        return "Not Implemented";
                                                    case 502:
                                                        return "Bad Gateway";
                                                    case 503:
                                                        return "Service Unavailable";
                                                    case 504:
                                                        return "Gateway Timeout";
                                                    case 505:
                                                        return "HTTP Version Not Supported";
                                                    case 506:
                                                        return "Variant Also Negotiates";
                                                    case 507:
                                                        return "Insufficient Storage";
                                                    default:
                                                        return "";
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
