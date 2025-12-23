package xyz.adscope.ad;

import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kwad.library.solder.lib.ext.PluginError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum y0 {
    ERROR_NO_FILL(2001, "no bid model fill"),
    ERROR_RESPONSE_PARSE_FAILED(2002, "ad response parse failed"),
    ERROR_SDK_NOT_INIT(2003, "sdk not init"),
    ERROR_REQUEST_TOO_OFTEN(PluginError.ERROR_UPD_EXTRACT, "request too often"),
    ERROR_AD_BEING_COMPLAINED(PluginError.ERROR_UPD_CAPACITY, "ad type being complained"),
    ERROR_REQUEST_TIME_OUT(PluginError.ERROR_UPD_REQUEST, "request timeout"),
    ERROR_REQUEST_FAILED(PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD, "request error"),
    ERROR_INVALID_CONFIG(PluginError.ERROR_UPD_NO_DOWNLOADER, "invalid config"),
    ERROR_AD_REQUESTING(PluginError.ERROR_UPD_FILE_NOT_FOUND, "ad is requesting"),
    ERROR_UNITE_CONTROL(2010, "unite control"),
    ERROR_RENDER_FAILED(GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE, "render failed"),
    ERROR_ACTIVITY_ISSUE(GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP, "local activity error"),
    ERROR_INVALID_SPACE_ID(GLMapStaticValue.AM_PARAMETERNAME_MAPMODESTATE, "invalid space id"),
    ERROR_AD_NOT_READY_TO_SHOW(2014, "ad not ready to show"),
    ERROR_S2S_VERIFICATION_FAILED(2015, "s2s verification failed"),
    ERROR_S2S_EXPRESS_TYPE_ERROR(2016, "s2s express type error"),
    ERROR_UNEXPECTED(2099, "error unexpected");


    /* renamed from: a, reason: collision with root package name */
    private final int f56158a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56159b;

    public int b() {
        return this.f56158a;
    }

    public String c() {
        return this.f56159b;
    }

    y0(int i6, String str) {
        this.f56158a = i6;
        this.f56159b = str;
    }
}
