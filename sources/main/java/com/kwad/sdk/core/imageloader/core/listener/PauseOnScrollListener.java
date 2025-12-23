package com.kwad.sdk.core.imageloader.core.listener;

import android.widget.AbsListView;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    private final AbsListView.OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z5, boolean z6) {
        this(imageLoader, z5, z6, null);
    }

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z5, boolean z6, AbsListView.OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = z5;
        this.pauseOnFling = z6;
        this.externalListener = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i6, int i7, int i8) {
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i6, i7, i8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i6) {
        if (i6 == 0) {
            this.imageLoader.resume();
        } else if (i6 != 1) {
            if (i6 == 2 && this.pauseOnFling) {
                this.imageLoader.pause();
            }
        } else if (this.pauseOnScroll) {
            this.imageLoader.pause();
        }
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i6);
        }
    }
}
