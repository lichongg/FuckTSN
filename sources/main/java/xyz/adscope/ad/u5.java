package xyz.adscope.ad;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import androidx.annotation.NonNull;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class u5 extends xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c implements u2 {

    /* renamed from: h, reason: collision with root package name */
    private DownloadInfoModel f56007h;

    /* renamed from: i, reason: collision with root package name */
    private String f56008i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends StringUtil.StringStyleBean {

        /* renamed from: a, reason: collision with root package name */
        private final String f56009a;

        public a(String str, String str2, String str3) {
            super(str, str2);
            this.f56009a = str3;
        }

        @Override // xyz.adscope.common.v2.tool.str.StringUtil.StringStyleBean, android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            u5.this.f56008i = this.f56009a;
        }
    }

    public void e() {
        this.f56008i = null;
    }

    private void f() {
        DownloadInfoModel downloadInfoModel = this.f56007h;
        if (downloadInfoModel == null || !downloadInfoModel.m()) {
            return;
        }
        SpannableString parseSpannableString = StringUtil.parseSpannableString("应用名称: " + this.f56007h.f() + " | 开发者: " + this.f56007h.d() + " | 应用版本: " + this.f56007h.l() + " | 权限详情 | 隐私协议 | 功能介绍", new a("权限详情", "#02cbf7", "permission"), new a("隐私协议", "#02cbf7", "privacy"), new a("功能介绍", "#02cbf7", "introduction"));
        setHighlightColor(0);
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(parseSpannableString);
    }

    @Override // xyz.adscope.ad.i6, xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        f();
        super.a(aVar);
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c, xyz.adscope.ad.j3
    public String getActionType() {
        return "downloadInfo";
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c, xyz.adscope.ad.j3
    public String getInteractionType() {
        return AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK;
    }

    public String getWhereDetailActivityTab() {
        return this.f56008i;
    }

    public u5(@NonNull Context context) {
        super(context);
        this.f56008i = null;
    }

    @Override // xyz.adscope.ad.u2
    public void a(DownloadInfoModel downloadInfoModel) {
        this.f56007h = downloadInfoModel;
    }
}
