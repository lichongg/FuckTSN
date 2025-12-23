package com.qq.e.mediation.interfaces;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public interface INoticeUrlProvider {
    public static final String IMPL_CLASS_NAME = "util.NoticeUrlProviderImpl";

    String getAssembledLossNoticeUrl(String str, String str2, boolean z5);

    String getAssembledWinNoticeUrl(String str, String str2, boolean z5);

    String getOtherAssembledLossNoticeUrl(String str, String str2);
}
