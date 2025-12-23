package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* renamed from: h, reason: collision with root package name */
    private volatile int f36640h;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f36641i;

    /* renamed from: j, reason: collision with root package name */
    private List<Integer> f36642j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k, reason: collision with root package name */
    private VideoOption f36643k;

    /* renamed from: l, reason: collision with root package name */
    private ADSize f36644l;

    /* renamed from: m, reason: collision with root package name */
    private NativeExpressADListener f36645m;

    /* renamed from: n, reason: collision with root package name */
    private final ADListenerAdapter f36646n;

    /* renamed from: o, reason: collision with root package name */
    private LoadAdParams f36647o;

    /* renamed from: p, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f36648p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeExpressADListener f36649a;

        /* renamed from: b, reason: collision with root package name */
        private NativeExpressMediaListener f36650b;

        /* renamed from: c, reason: collision with root package name */
        private NegativeFeedbackListener f36651c;

        /* renamed from: d, reason: collision with root package name */
        private ADRewardListener f36652d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f36649a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f36650b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.b(this.f36649a, aDEvent) || NativeExpressAD.b(this.f36650b, aDEvent) || NativeExpressAD.b(this.f36651c, aDEvent)) {
                return;
            }
            NativeExpressAD.b(this.f36652d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f36652d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f36650b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f36651c = negativeFeedbackListener;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.f36645m = nativeExpressADListener;
        this.f36646n = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NEADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f36644l, str, str2, str3, this.f36646n);
    }

    public void loadAD(int i6) {
        loadAD(i6, null);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f36645m = nativeExpressADListener;
        this.f36646n = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener == null) {
            return false;
        }
        int type = aDEvent.getType();
        if (type == 100) {
            List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
            if (list == null) {
                return true;
            }
            nativeExpressADListener.onADLoaded(list);
            return true;
        }
        if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null) {
                return true;
            }
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
            return true;
        }
        if (type == 103) {
            NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
            if (nativeExpressADView == null) {
                return true;
            }
            nativeExpressADListener.onADExposure(nativeExpressADView);
            return true;
        }
        if (type == 303) {
            NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
            if (nativeExpressADView2 == null) {
                return true;
            }
            nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
            return true;
        }
        if (type == 105) {
            NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
            if (nativeExpressADView3 == null) {
                return true;
            }
            nativeExpressADListener.onADClicked(nativeExpressADView3);
            return true;
        }
        if (type == 106) {
            NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
            if (nativeExpressADView4 == null) {
                return true;
            }
            nativeExpressADListener.onADClosed(nativeExpressADView4);
            nativeExpressADView4.negativeFeedback();
            return true;
        }
        if (type == 109) {
            NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
            if (nativeExpressADView5 == null) {
                return true;
            }
            nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
            return true;
        }
        if (type != 110) {
            return false;
        }
        NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
        if (nativeExpressADView6 == null) {
            return true;
        }
        nativeExpressADListener.onRenderFail(nativeExpressADView6);
        return true;
    }

    public String getAdNetWorkName() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((NEADI) t5).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i6, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f36642j) {
                    this.f36642j.add(Integer.valueOf(i6));
                }
                return;
            }
            T t5 = this.f36545a;
            if (t5 == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f36647o;
            NEADI neadi = (NEADI) t5;
            if (loadAdParams2 != null) {
                neadi.loadAd(i6, loadAdParams2);
            } else {
                neadi.loadAd(i6);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f36647o = loadAdParams;
    }

    public void setMaxVideoDuration(int i6) {
        this.f36641i = i6;
        if (this.f36641i > 0 && this.f36640h > this.f36641i) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NEADI) t5).setMaxVideoDuration(this.f36641i);
        }
    }

    public void setMinVideoDuration(int i6) {
        this.f36640h = i6;
        if (this.f36641i > 0 && this.f36640h > this.f36641i) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NEADI) t5).setMinVideoDuration(this.f36640h);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f36646n.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f36648p = serverSideVerificationOptions;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NEADI) t5).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f36643k = videoOption;
        T t5 = this.f36545a;
        if (t5 == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t5).setVideoOption(videoOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener == null || (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) == null) {
            return false;
        }
        int type = aDEvent.getType();
        if (type == 201) {
            nativeExpressMediaListener.onVideoCached(nativeExpressADView);
        } else if (type == 202) {
            nativeExpressMediaListener.onVideoStart(nativeExpressADView);
        } else if (type == 204) {
            nativeExpressMediaListener.onVideoPause(nativeExpressADView);
        } else if (type == 206) {
            nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
        } else if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(1, Integer.class);
            if (num != null) {
                nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
            }
        } else if (type == 301) {
            nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
        } else if (type != 302) {
            switch (type) {
                case 209:
                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                    break;
                case 210:
                    if (((Integer) aDEvent.getParam(1, Integer.class)) != null) {
                        nativeExpressMediaListener.onVideoReady(nativeExpressADView, r7.intValue());
                        break;
                    }
                    break;
                case 211:
                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                    break;
                default:
                    return false;
            }
        } else {
            nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
            return false;
        }
        negativeFeedbackListener.onComplainSuccess();
        return true;
    }

    private boolean a(ADSize aDSize) {
        if (aDSize != null) {
            this.f36644l = aDSize;
            return false;
        }
        GDTLogger.e("初始化错误：参数adSize不能为空");
        a(2001);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        if (aDRewardListener == null || aDEvent.getType() != 104) {
            return false;
        }
        String str = (String) aDEvent.getParam(String.class);
        if (str == null) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("transId", str);
        aDRewardListener.onReward(hashMap);
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        NativeExpressADListener nativeExpressADListener = this.f36645m;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i6));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEADI neadi) {
        super.a((NativeExpressAD) neadi);
        neadi.setMinVideoDuration(this.f36640h);
        neadi.setMaxVideoDuration(this.f36641i);
        ((NEADI) this.f36545a).setServerSideVerificationOptions(this.f36648p);
        VideoOption videoOption = this.f36643k;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f36642j) {
            try {
                Iterator<Integer> it = this.f36642j.iterator();
                while (it.hasNext()) {
                    T t5 = this.f36545a;
                    if (t5 != 0) {
                        if (this.f36647o != null) {
                            ((NEADI) t5).loadAd(it.next().intValue(), this.f36647o);
                        } else {
                            ((NEADI) t5).loadAd(it.next().intValue());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
