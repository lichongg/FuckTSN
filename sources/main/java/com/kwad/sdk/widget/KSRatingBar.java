package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSRatingBar extends LinearLayout {
    private boolean bdj;
    private boolean bdk;
    private int bdl;
    private int bdm;
    private a bdn;
    private float bdo;
    private float bdp;
    private float bdq;
    private Drawable bdr;
    private Drawable bds;
    private Drawable bdt;
    private boolean bdu;

    /* renamed from: y, reason: collision with root package name */
    private int f36353y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
    }

    public void setStar(float f6) {
        int i6 = (int) f6;
        float floatValue = new BigDecimal(Float.toString(f6)).subtract(new BigDecimal(Integer.toString(i6))).floatValue();
        int i7 = this.bdl;
        float f7 = i6 > i7 ? i7 : i6;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        for (int i8 = 0; i8 < f7; i8++) {
            ((ImageView) getChildAt(i8)).setImageDrawable(this.bds);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i6)).setImageDrawable(this.bdt);
            int i9 = this.bdl;
            while (true) {
                i9--;
                if (i9 < 1.0f + f7) {
                    return;
                } else {
                    ((ImageView) getChildAt(i9)).setImageDrawable(this.bdr);
                }
            }
        } else {
            int i10 = this.bdl;
            while (true) {
                i10--;
                if (i10 < f7) {
                    return;
                } else {
                    ((ImageView) getChildAt(i10)).setImageDrawable(this.bdr);
                }
            }
        }
    }

    static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i6 = kSRatingBar.f36353y;
        kSRatingBar.f36353y = i6 + 1;
        return i6;
    }

    private ImageView y(Context context, boolean z5) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.bdo), Math.round(this.bdp)));
        imageView.setPadding(0, 0, Math.round(this.bdq), 0);
        if (z5) {
            imageView.setImageDrawable(this.bdr);
            return imageView;
        }
        imageView.setImageDrawable(this.bds);
        return imageView;
    }

    public void setImagePadding(float f6) {
        this.bdq = f6;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.bdn = aVar;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.bdr = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.bds = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.bdt = drawable;
    }

    public void setStarImageHeight(float f6) {
        this.bdp = f6;
    }

    public void setStarImageWidth(float f6) {
        this.bdo = f6;
    }

    public void setTotalStarCount(int i6) {
        this.bdl = i6;
    }

    public void setmClickable(boolean z5) {
        this.bdj = z5;
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36353y = 1;
        this.bdu = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.bdt = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.bdr = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.bds = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.bdo = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.bdp = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.bdq = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.bdl = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.bdm = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.bdj = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.bdk = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i6 = 0; i6 < this.bdl; i6++) {
            ImageView y5 = y(context, this.bdu);
            y5.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.bdj) {
                        if (!KSRatingBar.this.bdk) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.bdn != null) {
                                a unused = KSRatingBar.this.bdn;
                                KSRatingBar.this.indexOfChild(view);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.f36353y % 2 == 0) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        } else {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                        }
                        if (KSRatingBar.this.bdn != null) {
                            if (KSRatingBar.this.f36353y % 2 == 0) {
                                a unused2 = KSRatingBar.this.bdn;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.e(KSRatingBar.this);
                            } else {
                                a unused3 = KSRatingBar.this.bdn;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.e(KSRatingBar.this);
                            }
                        }
                    }
                }
            });
            addView(y5);
        }
        setStar(this.bdm);
    }
}
