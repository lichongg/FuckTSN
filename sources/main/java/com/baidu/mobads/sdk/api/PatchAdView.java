package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bt;
import com.baidu.mobads.sdk.internal.z;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PatchAdView extends RelativeLayout {
    private static final String AD_CLICKED = "onAdClicked";
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playFailure";
    private static final String PLAY_START = "onAdShow";
    private static final String TAG = "PacthAdView";
    private View mAdView;
    private IPatchAdListener mListener;
    private ClassLoader mLoader;
    private final String mRemoteClassName;
    private Context mViewContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class InvocationHandlerImp implements InvocationHandler {
        InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(PatchAdView.PLAY_END)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playCompletion();
                }
            } else if (name.equals(PatchAdView.PLAY_ERROR)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playError();
                }
            } else if (name.equals(PatchAdView.PLAY_START)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.onAdShow();
                }
            } else if (name.equals(PatchAdView.AD_CLICKED) && PatchAdView.this.mListener != null) {
                PatchAdView.this.mListener.onAdClicked();
            }
            return null;
        }
    }

    private void init(Context context) {
        this.mViewContext = context;
        Object[] objArr = {context};
        ClassLoader a6 = bt.a(context);
        this.mLoader = a6;
        View view = (View) av.a(this.mRemoteClassName, a6, (Class<?>[]) new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public long getCurrentPosition() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object a6 = av.a(this.mRemoteClassName, view, this.mLoader, "getCurrentPosition", new Class[0], new Object[0]);
        if (a6 instanceof Number) {
            return ((Long) a6).longValue();
        }
        return 0L;
    }

    public long getDuration() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object a6 = av.a(this.mRemoteClassName, view, this.mLoader, "getDuration", new Class[0], new Object[0]);
        if (a6 instanceof Number) {
            return ((Long) a6).longValue();
        }
        return 0L;
    }

    public void setAdData(XAdVideoResponse xAdVideoResponse) {
        View view;
        if (xAdVideoResponse == null || (view = this.mAdView) == null) {
            return;
        }
        av.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new Class[]{Object.class}, xAdVideoResponse);
    }

    public void setPatchAdListener(IPatchAdListener iPatchAdListener) {
        this.mListener = iPatchAdListener;
        try {
            Class<?> a6 = av.a("com.component.patchad.IPatchAdListener", this.mLoader);
            if (a6 != null) {
                Object newProxyInstance = Proxy.newProxyInstance(a6.getClassLoader(), new Class[]{a6}, new InvocationHandlerImp());
                View view = this.mAdView;
                if (view != null) {
                    av.a(this.mRemoteClassName, view, this.mLoader, "setPatchAdListener", new Class[]{a6}, newProxyInstance);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setVideoVolume(boolean z5) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setVideoVolume", new Class[]{Boolean.TYPE}, Boolean.valueOf(z5));
        }
    }

    public PatchAdView(Context context) {
        super(context);
        this.mRemoteClassName = z.f11219i;
        init(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }
}
