package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ void c(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.mPostedShow = false;
        if (contentLoadingProgressBar.mDismissed) {
            return;
        }
        contentLoadingProgressBar.mStartTime = System.currentTimeMillis();
        contentLoadingProgressBar.setVisibility(0);
    }

    public static /* synthetic */ void d(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.mPostedHide = false;
        contentLoadingProgressBar.mStartTime = -1L;
        contentLoadingProgressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void hideOnUiThread() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = this.mStartTime;
        long j7 = currentTimeMillis - j6;
        if (j7 >= 500 || j6 == -1) {
            setVisibility(8);
        } else {
            if (this.mPostedHide) {
                return;
            }
            postDelayed(this.mDelayedHide, 500 - j7);
            this.mPostedHide = true;
        }
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mStartTime = -1L;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new Runnable() { // from class: androidx.core.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.d(ContentLoadingProgressBar.this);
            }
        };
        this.mDelayedShow = new Runnable() { // from class: androidx.core.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.c(ContentLoadingProgressBar.this);
            }
        };
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void showOnUiThread() {
        this.mStartTime = -1L;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (this.mPostedShow) {
            return;
        }
        postDelayed(this.mDelayedShow, 500L);
        this.mPostedShow = true;
    }

    public void hide() {
        post(new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.hideOnUiThread();
            }
        });
    }

    public void show() {
        post(new Runnable() { // from class: androidx.core.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.showOnUiThread();
            }
        });
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }
}
