package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class CardViewApi21Impl implements CardViewImpl {
    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f6, float f7, float f8) {
        cardViewDelegate.setCardBackground(new RoundRectDrawable(colorStateList, f6));
        View cardView = cardViewDelegate.getCardView();
        cardView.setClipToOutline(true);
        cardView.setElevation(f7);
        setMaxElevation(cardViewDelegate, f8);
    }

    CardViewApi21Impl() {
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.getCardView().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).getPadding();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).getRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        getCardBackground(cardViewDelegate).setColor(colorStateList);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate cardViewDelegate, float f6) {
        cardViewDelegate.getCardView().setElevation(f6);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f6) {
        getCardBackground(cardViewDelegate).setPadding(f6, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate cardViewDelegate, float f6) {
        getCardBackground(cardViewDelegate).setRadius(f6);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.getUseCompatPadding()) {
            cardViewDelegate.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float maxElevation = getMaxElevation(cardViewDelegate);
        float radius = getRadius(cardViewDelegate);
        int ceil = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
        cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
    }
}
