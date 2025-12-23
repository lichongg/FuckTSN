package com.bykv.vk.component.ttvideo.utils;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class Error {
    public static final int AUDIO_HARDWARE_DECODER_WRITE_ERROR = -499978;
    public static final int BUFFERING_TIME_OUT_ERROR = -499982;
    public static final String DataLoaderPreload = "kTTVideoErrorDomainDataLoaderPreload";
    public static final int ERROR_TYPE_CDN = 1003;
    public static final int ERROR_TYPE_PLAYER = 1002;
    public static final int OPEN_TIME_OUT_ERROR = -1414092869;
    public static final int PlayerStateIllegal = -9992;
    public static final int PreloadInvalidParameter = -100001;
    public static final int PreloadMDLStateError = -100002;
    public static final int PreloadSameKeyError = -100003;
    public static final int PreloadTrackEmptyError = -100004;
    public static final int TCP_READ_NETWORK_TIMEOUT = -499793;
    public static final int VIDEO_HARDWARE_DECODER_WRITE_ERROR = -499977;
    public static final String VideoOSPlayer = "kTTVideoErrorDomainVideoOSPlayer";
    public static final String VideoOwnPlayer = "kTTVideoErrorDomainVideoOwnPlayer";

    /* renamed from: a, reason: collision with root package name */
    public int f22934a;

    /* renamed from: b, reason: collision with root package name */
    public int f22935b;

    /* renamed from: c, reason: collision with root package name */
    public String f22936c;

    /* renamed from: d, reason: collision with root package name */
    public String f22937d;

    /* renamed from: e, reason: collision with root package name */
    public Map f22938e;

    public Error(String str, int i6) {
        this(str, i6, 0);
    }

    public Error(String str, int i6, int i7) {
        this(str, i6, i7, null);
    }

    public int getCode() {
        return this.f22934a;
    }

    public String getDescription() {
        return this.f22937d;
    }

    public String getDomain() {
        return this.f22936c;
    }

    public int getInternalCode() {
        return this.f22935b;
    }

    public Map getParameters() {
        return this.f22938e;
    }

    public int getType() {
        return (this.f22936c.equals(VideoOwnPlayer) && needRestartPlayer()) ? 1002 : 1003;
    }

    public boolean needFallbackOS() {
        int i6 = this.f22934a;
        return i6 == -499978 || i6 == -499977;
    }

    public boolean needRestartPlayer() {
        int i6 = this.f22934a;
        return i6 == -499999 || i6 == -499997 || i6 == -499996 || i6 == -499992 || i6 == -499991 || i6 == -499990 || i6 == -499989 || i6 == -2139062143;
    }

    public boolean notNeedRetry() {
        int i6 = this.f22934a;
        return i6 == -499982 || i6 == -499793 || i6 == -1414092869;
    }

    public String toString() {
        String str = this.f22936c;
        Integer valueOf = Integer.valueOf(this.f22934a);
        Integer valueOf2 = Integer.valueOf(this.f22935b);
        String str2 = this.f22937d;
        if (str2 == null) {
            str2 = "";
        }
        return String.format("domain:%s, code:%d, internalCode:%d, description:%s", str, valueOf, valueOf2, str2);
    }

    public Error(String str, int i6, int i7, String str2) {
        this.f22936c = str;
        this.f22934a = i6;
        this.f22935b = i7;
        this.f22937d = str2;
        this.f22938e = new HashMap();
    }

    public Error(String str, int i6, String str2) {
        this(str, i6, 0, str2);
    }
}
