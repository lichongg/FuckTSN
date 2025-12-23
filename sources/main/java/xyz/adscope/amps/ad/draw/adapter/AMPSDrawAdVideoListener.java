package xyz.adscope.amps.ad.draw.adapter;

import xyz.adscope.amps.base.AMPSBaseListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSDrawAdVideoListener implements AMPSBaseListener {
    public abstract void onProgressUpdate(long j6, long j7);

    public abstract void onVideoAdComplete();

    public abstract void onVideoAdContinuePlay();

    public abstract void onVideoAdPaused();

    public abstract void onVideoAdStartPlay();

    public abstract void onVideoError(int i6, int i7);

    public abstract void onVideoLoad();
}
