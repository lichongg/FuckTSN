package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
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
public class FeedPortraitVideoView extends RelativeLayout {
    private static final String FEED_CLICK = "pauseBtnClick";
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playError";
    private static final String PLAY_PAUSE = "playPause";
    private static final String PLAY_RESUME = "playResume";
    private static final String PLAY_START = "playRenderingStart";
    private static final String TAG = "FeedPortraitVideoView";
    private View mAdView;
    private IFeedPortraitListener mFeedVideoListener;
    private ClassLoader mLoader;
    private String mRemoteClassName;
    private Context mViewContext;
    private boolean useDownloadFrame;

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
            if (name.equals(FeedPortraitVideoView.PLAY_END)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playCompletion();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_ERROR)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playError();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_START)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playRenderingStart();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_PAUSE)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playPause();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_RESUME)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playResume();
                }
            } else if (name.equals(FeedPortraitVideoView.FEED_CLICK) && FeedPortraitVideoView.this.mFeedVideoListener != null) {
                FeedPortraitVideoView.this.mFeedVideoListener.pauseBtnClick();
            }
            return null;
        }
    }

    public FeedPortraitVideoView(Context context) {
        this(context, null);
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
        if (a6 instanceof Long) {
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
        if (a6 instanceof Long) {
            return ((Long) a6).longValue();
        }
        return 0L;
    }

    public void handleFeedCover(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "handleCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedCoverPic(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "hideFeedCoverPic", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedPauseBtn(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "hidePauseBtn", new Class[]{Object.class}, abstractData);
        }
    }

    public boolean isPlaying() {
        View view = this.mAdView;
        if (view != null) {
            Object a6 = av.a(this.mRemoteClassName, view, this.mLoader, "isPlaying", new Class[0], new Object[0]);
            if (a6 instanceof Boolean) {
                return ((Boolean) a6).booleanValue();
            }
        }
        return false;
    }

    public boolean isShowEndFrame() {
        View view = this.mAdView;
        if (view != null) {
            Object a6 = av.a(this.mRemoteClassName, view, this.mLoader, "isShowEndFrame", new Class[0], new Object[0]);
            if (a6 instanceof Boolean) {
                return ((Boolean) a6).booleanValue();
            }
        }
        return false;
    }

    public void pause() {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "pause", new Class[0], new Object[0]);
        }
    }

    public void play() {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "play", new Class[0], new Object[0]);
        }
    }

    public void resume() {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "resume", new Class[0], new Object[0]);
        }
    }

    public void seekTo(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "seekTo", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setAdData(AbstractData abstractData) {
        View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        if (abstractData instanceof NativeCPUAdData) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setCpuAdData", new Class[]{Object.class}, abstractData);
        } else {
            av.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new Class[]{Object.class}, abstractData);
        }
    }

    public void setCanClickVideo(boolean z5) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setCanClickVideo", new Class[]{Boolean.TYPE}, Boolean.valueOf(z5));
        }
    }

    public void setFeedPortraitListener(IFeedPortraitListener iFeedPortraitListener) {
        this.mFeedVideoListener = iFeedPortraitListener;
        try {
            Class<?> a6 = av.a("com.component.feed.IFeedPortraitListener", this.mLoader);
            if (a6 != null) {
                Object newProxyInstance = Proxy.newProxyInstance(a6.getClassLoader(), new Class[]{a6}, new InvocationHandlerImp());
                View view = this.mAdView;
                if (view != null) {
                    av.a(this.mRemoteClassName, view, this.mLoader, "setFeedPortraitListener", new Class[]{a6}, newProxyInstance);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setPlayBackSpeed(float f6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setPlayBackSpeed", new Class[]{Float.TYPE}, Float.valueOf(f6));
        }
    }

    public void setProgressBackgroundColor(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setProgressBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setProgressBarColor(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setProgressBarColor", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setProgressHeightInDp(int i6) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setProgressHeightDp", new Class[]{Integer.TYPE}, Integer.valueOf(i6));
        }
    }

    public void setShowProgress(boolean z5) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setShowProgressBar", new Class[]{Boolean.TYPE}, Boolean.valueOf(z5));
        }
    }

    public void setUseDownloadFrame(boolean z5) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "setUseDownloadFrame", new Class[]{Boolean.TYPE}, Boolean.valueOf(z5));
        }
    }

    public void setVideoMute(boolean z5) {
        try {
            View view = this.mAdView;
            if (view != null) {
                av.a(this.mRemoteClassName, view, this.mLoader, "userSetVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z5));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void showFeedVideoCover(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "showFeedVideoCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void showNormalPic(AbstractData abstractData) {
        View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        av.a(this.mRemoteClassName, view, this.mLoader, "showNormalPic", new Class[]{Object.class}, abstractData);
    }

    public void stop() {
        View view = this.mAdView;
        if (view != null) {
            av.a(this.mRemoteClassName, view, this.mLoader, "stop", new Class[0], new Object[0]);
        }
    }

    public void systemSetVideoMute(boolean z5) {
        try {
            View view = this.mAdView;
            if (view != null) {
                av.a(this.mRemoteClassName, view, this.mLoader, "setVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z5));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mRemoteClassName = z.f11214d;
        this.useDownloadFrame = false;
        init(context);
    }
}
