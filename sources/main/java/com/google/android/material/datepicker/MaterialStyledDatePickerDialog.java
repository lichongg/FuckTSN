package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {

    @AttrRes
    private static final int DEF_STYLE_ATTR = 16843612;

    @StyleRes
    private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;

    @NonNull
    private final Drawable background;

    @NonNull
    private final Rect backgroundInsets;

    public MaterialStyledDatePickerDialog(@NonNull Context context) {
        this(context, 0);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i6) {
        this(context, i6, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i6, int i7, int i8) {
        this(context, 0, onDateSetListener, i6, i7, i8);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i6, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i7, int i8, int i9) {
        super(context, i6, onDateSetListener, i7, i8, i9);
        Context context2 = getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i10 = DEF_STYLE_RES;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, 16843612, i10);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Rect dialogBackgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, 16843612, i10);
        this.backgroundInsets = dialogBackgroundInsets;
        this.background = MaterialDialogs.insetDrawable(materialShapeDrawable, dialogBackgroundInsets);
    }
}
