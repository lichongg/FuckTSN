package com.google.android.material.textfield;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private ColorStateList dropDownBackgroundTint;

    @NonNull
    private final ListPopupWindow modalListPopup;
    private final float popupElevation;

    @LayoutRes
    private final int simpleItemLayout;
    private int simpleItemSelectedColor;

    @Nullable
    private ColorStateList simpleItemSelectedRippleColor;

    @NonNull
    private final Rect tempRect;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class MaterialArrayAdapter<T> extends ArrayAdapter<String> {

        @Nullable
        private ColorStateList pressedRippleColor;

        @Nullable
        private ColorStateList selectedItemRippleOverlaidColor;

        MaterialArrayAdapter(@NonNull Context context, int i6, @NonNull String[] strArr) {
            super(context, i6, strArr);
            updateSelectedItemColorStateList();
        }

        private boolean hasSelectedColor() {
            return MaterialAutoCompleteTextView.this.simpleItemSelectedColor != 0;
        }

        private boolean hasSelectedRippleColor() {
            return MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor != null;
        }

        @Nullable
        private ColorStateList createItemSelectedColorStateList() {
            if (hasSelectedColor() && hasSelectedRippleColor()) {
                int[] iArr = {R.attr.state_hovered, -16842919};
                int[] iArr2 = {R.attr.state_selected, -16842919};
                return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{MaterialColors.layer(MaterialAutoCompleteTextView.this.simpleItemSelectedColor, MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(iArr2, 0)), MaterialColors.layer(MaterialAutoCompleteTextView.this.simpleItemSelectedColor, MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.simpleItemSelectedColor});
            }
            return null;
        }

        @Nullable
        private Drawable getSelectedItemDrawable() {
            if (!hasSelectedColor()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.simpleItemSelectedColor);
            if (this.pressedRippleColor != null) {
                DrawableCompat.setTintList(colorDrawable, this.selectedItemRippleOverlaidColor);
                return new RippleDrawable(this.pressedRippleColor, colorDrawable, null);
            }
            return colorDrawable;
        }

        private ColorStateList sanitizeDropdownItemSelectedRippleColor() {
            if (!hasSelectedRippleColor()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(iArr, 0), 0});
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i6, @Nullable View view, ViewGroup viewGroup) {
            Drawable drawable;
            View view2 = super.getView(i6, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText())) {
                    drawable = getSelectedItemDrawable();
                } else {
                    drawable = null;
                }
                ViewCompat.setBackground(textView, drawable);
            }
            return view2;
        }

        void updateSelectedItemColorStateList() {
            this.pressedRippleColor = sanitizeDropdownItemSelectedRippleColor();
            this.selectedItemRippleOverlaidColor = createItemSelectedColorStateList();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
    }

    public void setSimpleItems(@ArrayRes int i6) {
        setSimpleItems(getResources().getStringArray(i6));
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.autoCompleteTextViewStyle);
    }

    private boolean isTouchExplorationEnabled() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.dropDownBackgroundTint;
    }

    public float getPopupElevation() {
        return this.popupElevation;
    }

    public int getSimpleItemSelectedColor() {
        return this.simpleItemSelectedColor;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.simpleItemSelectedRippleColor;
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.dropDownBackgroundTint = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) dropDownBackground).setFillColor(this.dropDownBackgroundTint);
        }
    }

    public void setSimpleItemSelectedColor(int i6) {
        this.simpleItemSelectedColor = i6;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        }
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList colorStateList) {
        this.simpleItemSelectedRippleColor = colorStateList;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).updateSelectedItemColorStateList();
        }
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new MaterialArrayAdapter(getContext(), this.simpleItemLayout, strArr));
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i6, 0), attributeSet, i6);
        this.tempRect = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, i6, com.google.android.material.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i7 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (obtainStyledAttributes.hasValue(i7) && obtainStyledAttributes.getInt(i7, 0) == 0) {
            setKeyListener(null);
        }
        this.simpleItemLayout = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, com.google.android.material.R.layout.mtrl_auto_complete_simple_item);
        this.popupElevation = obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_popupElevation, com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int i8 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.dropDownBackgroundTint = ColorStateList.valueOf(obtainStyledAttributes.getColor(i8, 0));
        }
        this.simpleItemSelectedColor = obtainStyledAttributes.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.simpleItemSelectedRippleColor = MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.modalListPopup = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.textfield.MaterialAutoCompleteTextView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i9, long j6) {
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                MaterialAutoCompleteTextView.this.updateText(i9 < 0 ? materialAutoCompleteTextView.modalListPopup.getSelectedItem() : materialAutoCompleteTextView.getAdapter().getItem(i9));
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i9 < 0) {
                        view = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedView();
                        i9 = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemPosition();
                        j6 = MaterialAutoCompleteTextView.this.modalListPopup.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.modalListPopup.getListView(), view, i9, j6);
                }
                MaterialAutoCompleteTextView.this.modalListPopup.dismiss();
            }
        });
        int i9 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems;
        if (obtainStyledAttributes.hasValue(i9)) {
            setSimpleItems(obtainStyledAttributes.getResourceId(i9, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int measureContentWidth() {
        ListAdapter adapter = getAdapter();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        int i6 = 0;
        if (adapter == null || findTextInputLayoutAncestor == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        View view = null;
        int i7 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            view = adapter.getView(max, view, findTextInputLayoutAncestor);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i7 = Math.max(i7, view.getMeasuredWidth());
        }
        Drawable background = this.modalListPopup.getBackground();
        if (background != null) {
            background.getPadding(this.tempRect);
            Rect rect = this.tempRect;
            i7 += rect.left + rect.right;
        }
        return i7 + findTextInputLayoutAncestor.getEndIconView().getMeasuredWidth();
    }

    private void onInputTypeChanged() {
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null) {
            findTextInputLayoutAncestor.updateEditTextBoxBackgroundIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void updateText(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (isTouchExplorationEnabled()) {
            this.modalListPopup.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint()) {
            return findTextInputLayoutAncestor.getHint();
        }
        return super.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.modalListPopup.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(i6)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        if (isTouchExplorationEnabled()) {
            return;
        }
        super.onWindowFocusChanged(z5);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t5) {
        super.setAdapter(t5);
        this.modalListPopup.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.modalListPopup;
        if (listPopupWindow != null) {
            listPopupWindow.setBackgroundDrawable(drawable);
        }
    }

    public void setDropDownBackgroundTint(@ColorInt int i6) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i6));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.modalListPopup.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i6) {
        super.setRawInputType(i6);
        onInputTypeChanged();
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (isTouchExplorationEnabled()) {
            this.modalListPopup.show();
        } else {
            super.showDropDown();
        }
    }
}
