package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsLogoView extends LinearLayout {
    private boolean ajf;
    TextView ajg;
    ImageView ajh;
    private a aji;
    private SimpleImageLoadingListener hy;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void bE();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void aP(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        String str = this.ajf ? el.adBaseInfo.adGrayMarkIcon : el.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(el.adBaseInfo.adSourceDescription)) {
            this.ajg.setVisibility(0);
            this.ajg.setText(com.kwad.sdk.core.response.b.a.aD(el));
            this.ajh.setVisibility(0);
            we();
            a aVar = this.aji;
            if (aVar != null) {
                aVar.bE();
            }
        } else {
            if (TextUtils.isEmpty(el.adBaseInfo.adSourceDescription)) {
                this.ajg.setVisibility(8);
                this.ajg.setText("");
            } else {
                this.ajg.setText(com.kwad.sdk.core.response.b.a.aD(el));
                this.ajg.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.ajh.setVisibility(8);
                this.ajh.setImageDrawable(null);
                a aVar2 = this.aji;
                if (aVar2 != null) {
                    aVar2.bE();
                }
            } else {
                KSImageLoader.loadFeeImage(this.ajh, str, adTemplate, this.hy);
                this.ajh.setVisibility(0);
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.ajh;
    }

    public TextView getTextView() {
        return this.ajg;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.aji = aVar;
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(m.wrapContextIfNeed(context), attributeSet, i6);
        this.hy = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.we();
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }
        };
        init();
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        int i6;
        int i7;
        TextView textView = ksLogoView.getTextView();
        TextPaint paint = textView.getPaint();
        if (ksLogoView.getVisibility() == 0 && textView.getText() != null && textView.getText().length() > 0) {
            i6 = ((int) Math.ceil(paint.measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight();
        } else {
            i6 = 0;
        }
        if (ksLogoView.getIcon().getVisibility() == 0) {
            i7 = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 18.0f);
        } else {
            i7 = 0;
        }
        int i8 = i6 + i7;
        int a6 = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(i8, a6);
        ksLogoView.layout(0, 0, i8, a6);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        boolean z5;
        m.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.ajg = (TextView) findViewById(R.id.ksad_logo_text);
        this.ajh = (ImageView) findViewById(R.id.ksad_logo_icon);
        if (getBackground() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.ajf = z5;
        if (z5) {
            this.ajh.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.ajg.setTextColor(-6513508);
        } else {
            this.ajh.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            this.ajg.setTextColor(-1711276033);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we() {
        int i6;
        Resources resources = getContext().getResources();
        if (this.ajf) {
            i6 = R.drawable.ksad_logo_gray;
        } else {
            i6 = R.drawable.ksad_logo_white;
        }
        this.ajh.setImageDrawable(resources.getDrawable(i6));
    }

    public KsLogoView(Context context, boolean z5) {
        super(m.wrapContextIfNeed(context));
        this.hy = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.we();
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }
        };
        if (z5) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }
}
