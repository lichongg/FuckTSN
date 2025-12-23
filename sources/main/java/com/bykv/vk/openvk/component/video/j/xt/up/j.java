package com.bykv.vk.openvk.component.video.j.xt.up;

import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.j.xt.g;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j {

    /* renamed from: j, reason: collision with root package name */
    List<g.xt> f23107j;
    up xt;

    public abstract List<g.xt> cw();

    public abstract int j();

    protected g.xt j(String str) {
        List<g.xt> list;
        if (str != null && (list = this.f23107j) != null && list.size() > 0) {
            for (g.xt xtVar : this.f23107j) {
                if (str.equals(xtVar.f23051j)) {
                    return xtVar;
                }
            }
        }
        return null;
    }

    public abstract String j(String str, String str2);

    public abstract String m();

    public abstract InputStream r();

    public abstract String up();

    public abstract boolean xt();

    public up ae() {
        return this.xt;
    }

    protected String j(int i6) {
        switch (i6) {
            case 200:
                return ca.f10845k;
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i6) {
                    case 300:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO /* 305 */:
                        return "Use Proxy";
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
                                return "Request Time-Out";
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
                                return "Request-URI Too Large";
                            case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                return "Unsupported Media Type";
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
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }
}
