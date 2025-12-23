package androidx.databinding.adapters;

import androidx.annotation.RestrictTo;
import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@BindingMethods({@BindingMethod(attribute = "cardCornerRadius", method = "setRadius", type = CardView.class), @BindingMethod(attribute = "cardMaxElevation", method = "setMaxCardElevation", type = CardView.class), @BindingMethod(attribute = "cardPreventCornerOverlap", method = "setPreventCornerOverlap", type = CardView.class), @BindingMethod(attribute = "cardUseCompatPadding", method = "setUseCompatPadding", type = CardView.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class CardViewBindingAdapter {
    @BindingAdapter({"contentPadding"})
    public static void setContentPadding(CardView cardView, int i6) {
        cardView.setContentPadding(i6, i6, i6, i6);
    }

    @BindingAdapter({"contentPaddingBottom"})
    public static void setContentPaddingBottom(CardView cardView, int i6) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), i6);
    }

    @BindingAdapter({"contentPaddingLeft"})
    public static void setContentPaddingLeft(CardView cardView, int i6) {
        cardView.setContentPadding(i6, cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }

    @BindingAdapter({"contentPaddingRight"})
    public static void setContentPaddingRight(CardView cardView, int i6) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), i6, cardView.getContentPaddingBottom());
    }

    @BindingAdapter({"contentPaddingTop"})
    public static void setContentPaddingTop(CardView cardView, int i6) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), i6, cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }
}
