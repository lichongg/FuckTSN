package xyz.adscope.ad;

import xyz.adscope.common.analyse.model.IStringEventEnum;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum n1 implements IStringEventEnum {
    EVENT_REPORT_INIT_CODE("100.000"),
    EVENT_REPORT_INIT_SUCCESS_CODE("100.200"),
    EVENT_REPORT_INIT_FAIL_CODE("100.500"),
    EVENT_REPORT_LOAD_CODE("200.000"),
    EVENT_REPORT_REQUEST_CODE("250.000"),
    EVENT_REPORT_REQUEST_SUCCESS_CODE("250.200"),
    EVENT_REPORT_REQUEST_FAIL_CODE("250.500"),
    EVENT_REPORT_RENDER_CODE("260.000"),
    EVENT_REPORT_RENDER_SUCCESS_CODE("260.200"),
    EVENT_REPORT_RENDER_FAIL_CODE("260.500"),
    EVENT_REPORT_SHOW_CODE("270.000"),
    EVENT_REPORT_CALL_EXPOSURE_CODE("270.200"),
    EVENT_REPORT_EXPOSURE_CODE("270.201"),
    EVENT_REPORT_CALL_CLICK_CODE("280.200"),
    EVENT_REPORT_CLICK_CODE("280.201"),
    EVENT_REPORT_COMPLAIN_CODE("280.300"),
    EVENT_REPORT_CLOSE_CODE("290.000"),
    EVENT_REPORT_APP_INSTALLS_CODE("800.000"),
    EVENT_REPORT_CRASH_CODE("900.000");


    /* renamed from: a, reason: collision with root package name */
    private final String f55714a;

    @Override // xyz.adscope.common.analyse.model.IStringEventEnum
    public String getEventCode() {
        return this.f55714a;
    }

    n1(String str) {
        this.f55714a = str;
    }
}
