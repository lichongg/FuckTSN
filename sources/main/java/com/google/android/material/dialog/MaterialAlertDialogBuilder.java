package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {

    @AttrRes
    private static final int DEF_STYLE_ATTR = R.attr.alertDialogStyle;

    @StyleRes
    private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;

    @AttrRes
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;

    @Nullable
    private Drawable background;

    @NonNull
    private final Rect backgroundInsets;

    public MaterialAlertDialogBuilder(@NonNull Context context) {
        this(context, 0);
    }

    public MaterialAlertDialogBuilder(@NonNull Context context, int i6) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i6));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i7 = DEF_STYLE_ATTR;
        int i8 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, i7, i8);
        int color = MaterialColors.getColor(context2, R.attr.colorSurface, getClass().getCanonicalName());
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(null, R.styleable.MaterialAlertDialog, i7, i8);
        int color2 = obtainStyledAttributes.getColor(R.styleable.MaterialAlertDialog_backgroundTint, color);
        obtainStyledAttributes.recycle();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, i7, i8);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    private static int getMaterialAlertDialogThemeOverlay(@NonNull Context context) {
        TypedValue resolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private static int getOverridingThemeResId(@NonNull Context context, int i6) {
        return i6 == 0 ? getMaterialAlertDialogThemeOverlay(context) : i6;
    }

    @Nullable
    public Drawable getBackground() {
        return this.background;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setAdapter(@Nullable ListAdapter listAdapter, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setBackground(@Nullable Drawable drawable) {
        this.background = drawable;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int i6) {
        this.backgroundInsets.bottom = i6;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int i6) {
        this.backgroundInsets.top = i6;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setCancelable(boolean z5) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setCursor(@Nullable Cursor cursor, @Nullable DialogInterface.OnClickListener onClickListener, @NonNull String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setCustomTitle(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int i6) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(i6);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    private static Context createMaterialAlertDialogThemedContext(@NonNull Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context wrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        if (materialAlertDialogThemeOverlay == 0) {
            return wrap;
        }
        return new ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public AlertDialog create() {
        AlertDialog create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.background;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(ViewCompat.getElevation(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, this.backgroundInsets));
        return create;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int i6) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = i6;
            return this;
        }
        this.backgroundInsets.right = i6;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int i6) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = i6;
            return this;
        }
        this.backgroundInsets.left = i6;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setIcon(@DrawableRes int i6) {
        return (MaterialAlertDialogBuilder) super.setIcon(i6);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setItems(@ArrayRes int i6, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(i6, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setMessage(@StringRes int i6) {
        return (MaterialAlertDialogBuilder) super.setMessage(i6);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int i6, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i6, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setNeutralButton(@StringRes int i6, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(i6, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int i6, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i6, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setTitle(@StringRes int i6) {
        return (MaterialAlertDialogBuilder) super.setTitle(i6);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setView(int i6) {
        return (MaterialAlertDialogBuilder) super.setView(i6);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] charSequenceArr, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int i6, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i6, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setView(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] charSequenceArr, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int i6, int i7, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i6, i7, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor cursor, @NonNull String str, @NonNull String str2, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor cursor, int i6, @NonNull String str, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i6, str, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] charSequenceArr, int i6, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i6, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter listAdapter, int i6, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i6, onClickListener);
    }
}
