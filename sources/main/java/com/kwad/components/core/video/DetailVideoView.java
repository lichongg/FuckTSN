package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b aal;
    private b aam;
    private SurfaceTexture aan;
    private TextView aao;
    public Surface aap;
    private a aaq;
    private PhotoInfo.VideoInfo aar;
    private boolean aas;
    private final RectF aat;
    private int aau;
    private int aav;

    @NonNull
    private final d aaw;
    private Matrix mMatrix;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.aas = false;
        this.aat = new RectF();
        this.aau = 0;
        this.aav = 0;
        this.aaw = new d();
        B(context);
    }

    private void B(Context context) {
        this.mMatrix = new Matrix();
        this.aal = new com.kwad.components.core.page.widget.b(context);
        addView(this.aal, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        tH();
    }

    private void a(View view, long j6, long j7) {
        View view2;
        if (view == null || j6 == 0 || j7 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f6 = j6 / j7;
        float f7 = height * f6;
        float f8 = width;
        if (f7 > f8) {
            height = (int) (f8 / f6);
        } else {
            width = (int) f7;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.aal.setLayoutParams(layoutParams);
    }

    private void tH() {
        com.kwad.components.core.page.widget.b bVar;
        if (this.aas && (bVar = this.aal) != null) {
            bVar.setOpaque(false);
        }
        this.aal.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
                if (DetailVideoView.this.aan == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.aan = surfaceTexture;
                DetailVideoView.this.tI();
                DetailVideoView.this.aap = new Surface(surfaceTexture);
                if (DetailVideoView.this.aam != null) {
                    DetailVideoView.this.aam.setSurface(DetailVideoView.this.aap);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI() {
        Surface surface = this.aap;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            this.aap = null;
        }
    }

    public final void adaptVideoSize(int i6, int i7) {
        if (this.aal == null) {
            com.kwad.sdk.core.d.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.aav = i7;
        this.aau = i6;
        if (this.aaw.tJ()) {
            int tK = this.aaw.tK();
            c bVar = tK != 1 ? tK != 2 ? null : new VideoAdapters.b() : new VideoAdapters.c();
            if (bVar != null) {
                com.kwad.components.core.page.widget.b bVar2 = this.aal;
                bVar.a(bVar2, (View) bVar2.getParent(), i6, i7);
                return;
            }
            return;
        }
        if (this.aaw.tP()) {
            com.kwad.sdk.c.a.a.H(this.aal);
            return;
        }
        if (this.aaw.tL()) {
            com.kwad.sdk.c.a.a.e(this.aal, i6, i7);
            return;
        }
        if (this.aaw.tN()) {
            com.kwad.sdk.c.a.a.f(this.aal, i6, i7);
            return;
        }
        if (this.aaw.tM()) {
            com.kwad.sdk.c.a.a.d(this.aal, i6, i7);
            return;
        }
        if (this.aaw.tO()) {
            a(this.aal, i6, i7);
            return;
        }
        View view = (View) this.aal.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        PhotoInfo.VideoInfo videoInfo = this.aar;
        if (videoInfo == null || !com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
            ViewGroup.LayoutParams layoutParams = this.aal.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) ((i7 / (i6 * 1.0f)) * width);
            this.mMatrix.reset();
            this.aal.setTransform(this.mMatrix);
            this.aal.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.aal.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            this.aal.setTransform(this.mMatrix);
            this.aal.setLayoutParams(layoutParams2);
        }
        this.aat.set(this.aal.getLeft(), this.aal.getTop(), this.aal.getRight(), this.aal.getBottom());
    }

    public final void bc(int i6) {
        if (com.kwad.components.core.a.oz.booleanValue()) {
            if (this.aao == null) {
                if (getContext() == null) {
                    return;
                } else {
                    this.aao = new TextView(getContext());
                }
            }
            removeView(this.aao);
            this.aao.setText(String.valueOf(i6));
            this.aao.setTextColor(SupportMenu.CATEGORY_MASK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            addView(this.aao, getChildCount(), layoutParams);
        }
    }

    @Deprecated
    public final void fixWidth(boolean z5) {
        this.aaw.aU(z5);
    }

    public final void g(boolean z5, int i6) {
        this.aaw.setAd(true);
        this.aaw.bd(i6);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.aal;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aal) {
            a aVar = this.aaq;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.aaq;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Deprecated
    public void setAd(boolean z5) {
        this.aaw.setAd(z5);
    }

    public void setClickListener(a aVar) {
        this.aaq = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z5) {
        this.aaw.setFillXY(z5);
    }

    @Deprecated
    public void setForce(boolean z5) {
        this.aaw.setForce(z5);
    }

    public void setHorizontalVideo(boolean z5) {
        this.aaw.setHorizontalVideo(z5);
    }

    public void setIsAlphaVideoView(boolean z5) {
        com.kwad.components.core.page.widget.b bVar;
        this.aas = z5;
        if (!z5 || (bVar = this.aal) == null) {
            return;
        }
        bVar.setOpaque(false);
    }

    public void setMediaPlayer(b bVar) {
        this.aam = bVar;
        Surface surface = this.aap;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.aar = videoInfo;
    }

    public final void updateTextureViewGravity(int i6) {
        com.kwad.components.core.page.widget.b bVar = this.aal;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i6;
            this.aal.requestLayout();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tI();
        SurfaceTexture surfaceTexture = this.aan;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.aan = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i6, int i7, int i8, int i9) {
        int i10;
        super.onSizeChanged(i6, i7, i8, i9);
        int i11 = this.aau;
        if (i11 > 0 && (i10 = this.aav) > 0) {
            adaptVideoSize(i11, i10);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f6) {
        com.kwad.components.core.widget.h.b(this, f6);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aas = false;
        this.aat = new RectF();
        this.aau = 0;
        this.aav = 0;
        this.aaw = new d();
        B(context);
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i6, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean W = com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.b.e.el(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i6);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (W) {
                    int i7 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i7;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i7, intValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = intValue;
                        layoutParams3.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams3);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(create);
        return ofInt;
    }
}
