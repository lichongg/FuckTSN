package com.qq.e.ads.immersive;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.IAFD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ImmersiveADFlow extends AbstractAD<IAFD> implements IAFD {

    /* renamed from: h, reason: collision with root package name */
    private final ImmersiveADFlowListener f36619h;

    /* renamed from: i, reason: collision with root package name */
    private final ADListenerAdapter f36620i;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, String> f36621j;

    /* renamed from: k, reason: collision with root package name */
    private VideoOption f36622k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f36623l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f36624m = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ADListenerAdapter implements ADListener {
        public ImmersiveADFlowListener adListener;

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.adListener == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.adListener.onADLoaded();
                    break;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        this.adListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        if (num.intValue() == 6000) {
                            GDTLogger.e(getClass().getSimpleName() + ":未找到RecyclerView依赖或当前不支持平板设备");
                            break;
                        }
                    }
                    break;
                case 102:
                    this.adListener.onADPageShow();
                    break;
                case 103:
                    String str = (String) aDEvent.getParam(String.class);
                    this.adListener.onADExpose(str != null ? str : "");
                    break;
                case 105:
                    String str2 = (String) aDEvent.getParam(String.class);
                    this.adListener.onADClick(str2 != null ? str2 : "");
                    break;
                case 106:
                    this.adListener.onADPageDestroy();
                    break;
            }
        }

        public ADListenerAdapter(ImmersiveADFlowListener immersiveADFlowListener) {
            this.adListener = immersiveADFlowListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IAFD a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getImmersiveADFlowDelegate(context, str, str2, str3, this.f36620i, this.f36621j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(IAFD iafd) {
        T t5;
        T t6;
        T t7;
        VideoOption videoOption = this.f36622k;
        if (videoOption != null && (t7 = this.f36545a) != 0) {
            ((IAFD) t7).setVideoOption(videoOption);
        }
        if (this.f36624m && (t6 = this.f36545a) != 0) {
            ((IAFD) t6).showImmersiveADFlow();
            this.f36624m = false;
        } else {
            if (!this.f36623l || (t5 = this.f36545a) == 0) {
                return;
            }
            ((IAFD) t5).preloadImmersiveADFlow();
            this.f36623l = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        ImmersiveADFlowListener immersiveADFlowListener = this.f36619h;
        if (immersiveADFlowListener != null) {
            immersiveADFlowListener.onNoAD(AdErrorConvertor.formatErrorCode(i6));
        }
    }

    @Override // com.qq.e.comm.pi.IAFD
    public String getOperationInfo() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((IAFD) t5).getOperationInfo();
        }
        a("getOperationInfo");
        return "";
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void preloadImmersiveADFlow() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((IAFD) t5).preloadImmersiveADFlow();
        } else {
            this.f36623l = true;
        }
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void setVideoOption(VideoOption videoOption) {
        this.f36622k = videoOption;
        T t5 = this.f36545a;
        if (t5 == 0 || videoOption == null) {
            return;
        }
        ((IAFD) t5).setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void showImmersiveADFlow() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((IAFD) t5).showImmersiveADFlow();
        } else {
            this.f36624m = true;
        }
    }

    public ImmersiveADFlow(Context context, String str, ImmersiveADFlowListener immersiveADFlowListener, Map<String, String> map) {
        String str2;
        this.f36619h = immersiveADFlowListener;
        this.f36620i = new ADListenerAdapter(immersiveADFlowListener);
        this.f36621j = map;
        if (map != null) {
            str2 = map.get("TOKEN");
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            a(context, str);
        } else {
            a(context, str, str2);
        }
    }
}
