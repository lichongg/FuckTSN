package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String NEGATIVE_BUTTON_TEXT_KEY = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_RES_ID_KEY = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String POSITIVE_BUTTON_TEXT_KEY = "POSITIVE_BUTTON_TEXT_KEY";
    private static final String POSITIVE_BUTTON_TEXT_RES_ID_KEY = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";

    @Nullable
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;

    @Nullable
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;

    @Nullable
    private DateSelector<S> dateSelector;

    @Nullable
    private DayViewDecorator dayViewDecorator;
    private boolean edgeToEdgeEnabled;

    @Nullable
    private CharSequence fullTitleText;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private TextView headerTitleTextView;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonText;

    @StringRes
    private int negativeButtonTextResId;

    @StyleRes
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence positiveButtonText;

    @StringRes
    private int positiveButtonTextResId;

    @Nullable
    private CharSequence singleLineTitleText;
    private CharSequence titleText;

    @StringRes
    private int titleTextResId;
    static final Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
    static final Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
    static final Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners = new LinkedHashSet<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder<S> {
        CalendarConstraints calendarConstraints;
        final DateSelector<S> dateSelector;

        @Nullable
        DayViewDecorator dayViewDecorator;
        int overrideThemeResId = 0;
        int titleTextResId = 0;
        CharSequence titleText = null;
        int positiveButtonTextResId = 0;
        CharSequence positiveButtonText = null;
        int negativeButtonTextResId = 0;
        CharSequence negativeButtonText = null;

        @Nullable
        S selection = null;
        int inputMode = 0;

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setNegativeButtonText(@StringRes int i6) {
            this.negativeButtonTextResId = i6;
            this.negativeButtonText = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setPositiveButtonText(@StringRes int i6) {
            this.positiveButtonTextResId = i6;
            this.positiveButtonText = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setTitleText(@StringRes int i6) {
            this.titleTextResId = i6;
            this.titleText = null;
            return this;
        }

        private Month createDefaultOpenAt() {
            if (!this.dateSelector.getSelectedDays().isEmpty()) {
                Month create = Month.create(this.dateSelector.getSelectedDays().iterator().next().longValue());
                if (monthInValidRange(create, this.calendarConstraints)) {
                    return create;
                }
            }
            Month current = Month.current();
            return monthInValidRange(current, this.calendarConstraints) ? current : this.calendarConstraints.getStart();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> dateSelector) {
            return new Builder<>(dateSelector);
        }

        @NonNull
        public static Builder<Long> datePicker() {
            return new Builder<>(new SingleDateSelector());
        }

        @NonNull
        public static Builder<Pair<Long, Long>> dateRangePicker() {
            return new Builder<>(new RangeDateSelector());
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            if (this.calendarConstraints == null) {
                this.calendarConstraints = new CalendarConstraints.Builder().build();
            }
            if (this.titleTextResId == 0) {
                this.titleTextResId = this.dateSelector.getDefaultTitleResId();
            }
            S s5 = this.selection;
            if (s5 != null) {
                this.dateSelector.setSelection(s5);
            }
            if (this.calendarConstraints.getOpenAt() == null) {
                this.calendarConstraints.setOpenAt(createDefaultOpenAt());
            }
            return MaterialDatePicker.newInstance(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setCalendarConstraints(CalendarConstraints calendarConstraints) {
            this.calendarConstraints = calendarConstraints;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setDayViewDecorator(@Nullable DayViewDecorator dayViewDecorator) {
            this.dayViewDecorator = dayViewDecorator;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setInputMode(int i6) {
            this.inputMode = i6;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setSelection(S s5) {
            this.selection = s5;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
            this.dateSelector.setTextInputFormat(simpleDateFormat);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setTheme(@StyleRes int i6) {
            this.overrideThemeResId = i6;
            return this;
        }

        private Builder(DateSelector<S> dateSelector) {
            this.dateSelector = dateSelector;
        }

        private static boolean monthInValidRange(Month month, CalendarConstraints calendarConstraints) {
            if (month.compareTo(calendarConstraints.getStart()) >= 0 && month.compareTo(calendarConstraints.getEnd()) <= 0) {
                return true;
            }
            return false;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setNegativeButtonText(@Nullable CharSequence charSequence) {
            this.negativeButtonText = charSequence;
            this.negativeButtonTextResId = 0;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setPositiveButtonText(@Nullable CharSequence charSequence) {
            this.positiveButtonText = charSequence;
            this.positiveButtonTextResId = 0;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder<S> setTitleText(@Nullable CharSequence charSequence) {
            this.titleText = charSequence;
            this.titleTextResId = 0;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
    }

    public static /* synthetic */ void b(MaterialDatePicker materialDatePicker, View view) {
        materialDatePicker.confirmButton.setEnabled(materialDatePicker.getDateSelector().isSelectionComplete());
        materialDatePicker.headerToggleButton.toggle();
        materialDatePicker.inputMode = materialDatePicker.inputMode == 1 ? 0 : 1;
        materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
        materialDatePicker.startPickerFragment();
    }

    @NonNull
    private static Drawable createHeaderToggleDrawable(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AppCompatResources.getDrawable(context, com.google.android.material.R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, com.google.android.material.R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void enableEdgeToEdgeIfNeeded(Window window) {
        if (this.edgeToEdgeEnabled) {
            return;
        }
        final View findViewById = requireView().findViewById(com.google.android.material.R.id.fullscreen_header);
        EdgeToEdgeUtils.applyEdgeToEdge(window, true, ViewUtils.getBackgroundColor(findViewById), null);
        final int paddingTop = findViewById.getPaddingTop();
        final int i6 = findViewById.getLayoutParams().height;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                int i7 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).f836top;
                if (i6 >= 0) {
                    findViewById.getLayoutParams().height = i6 + i7;
                    View view2 = findViewById;
                    view2.setLayoutParams(view2.getLayoutParams());
                }
                View view3 = findViewById;
                view3.setPadding(view3.getPaddingLeft(), paddingTop + i7, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
                return windowInsetsCompat;
            }
        });
        this.edgeToEdgeEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> getDateSelector() {
        if (this.dateSelector == null) {
            this.dateSelector = (DateSelector) getArguments().getParcelable(DATE_SELECTOR_KEY);
        }
        return this.dateSelector;
    }

    @Nullable
    private static CharSequence getFirstLineBySeparator(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] split = TextUtils.split(String.valueOf(charSequence), com.snail.antifake.deviceid.e.f37542d);
        return split.length > 1 ? split[0] : charSequence;
    }

    private int getThemeResId(Context context) {
        int i6 = this.overrideThemeResId;
        return i6 != 0 ? i6 : getDateSelector().getDefaultThemeResId(context);
    }

    private void initHeaderToggle(Context context) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(context));
        this.headerToggleButton.setChecked(this.inputMode != 0);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker.b(MaterialDatePicker.this, view);
            }
        });
    }

    static boolean isNestedScrollable(@NonNull Context context) {
        return readMaterialCalendarStyleBoolean(context, com.google.android.material.R.attr.nestedScrollable);
    }

    @NonNull
    static <S> MaterialDatePicker<S> newInstance(@NonNull Builder<S> builder) {
        MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, builder.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.calendarConstraints);
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, builder.dayViewDecorator);
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, builder.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, builder.titleText);
        bundle.putInt(INPUT_MODE_KEY, builder.inputMode);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, builder.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, builder.positiveButtonText);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, builder.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, builder.negativeButtonText);
        materialDatePicker.setArguments(bundle);
        return materialDatePicker;
    }

    static boolean readMaterialCalendarStyleBoolean(@NonNull Context context, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, com.google.android.material.R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i6});
        boolean z5 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z5;
    }

    private void updateTitle() {
        this.headerTitleTextView.setText((this.inputMode == 1 && isLandscape()) ? this.singleLineTitleText : this.fullTitleText);
    }

    private void updateToggleContentDescription(@NonNull CheckableImageButton checkableImageButton) {
        this.headerToggleButton.setContentDescription(this.inputMode == 1 ? checkableImageButton.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.add(materialPickerOnPositiveButtonClickListener);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        int i6 = com.google.android.material.R.attr.materialCalendarStyle;
        int i7 = com.google.android.material.R.style.Widget_MaterialComponents_MaterialCalendar;
        this.background = new MaterialShapeDrawable(context, null, i6, i7);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, com.google.android.material.R.styleable.MaterialCalendar, i6, i7);
        int color = obtainStyledAttributes.getColor(com.google.android.material.R.styleable.MaterialCalendar_backgroundTint, 0);
        obtainStyledAttributes.recycle();
        this.background.initializeElevationOverlay(context);
        this.background.setFillColor(ColorStateList.valueOf(color));
        this.background.setElevation(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(this.fullscreen ? com.google.android.material.R.layout.mtrl_picker_fullscreen : com.google.android.material.R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.dayViewDecorator;
        if (dayViewDecorator != null) {
            dayViewDecorator.initialize(context);
        }
        if (this.fullscreen) {
            inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.headerToggleButton = (CheckableImageButton) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_header_toggle);
        this.headerTitleTextView = (TextView) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_title_text);
        initHeaderToggle(context);
        this.confirmButton = (Button) inflate.findViewById(com.google.android.material.R.id.confirm_button);
        if (getDateSelector().isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        CharSequence charSequence = this.positiveButtonText;
        if (charSequence != null) {
            this.confirmButton.setText(charSequence);
        } else {
            int i6 = this.positiveButtonTextResId;
            if (i6 != 0) {
                this.confirmButton.setText(i6);
            }
        }
        this.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.onPositiveButtonClickListeners.iterator();
                while (it.hasNext()) {
                    ((MaterialPickerOnPositiveButtonClickListener) it.next()).onPositiveButtonClick(MaterialDatePicker.this.getSelection());
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(com.google.android.material.R.id.cancel_button);
        button.setTag(CANCEL_BUTTON_TAG);
        CharSequence charSequence2 = this.negativeButtonText;
        if (charSequence2 != null) {
            button.setText(charSequence2);
        } else {
            int i7 = this.negativeButtonTextResId;
            if (i7 != 0) {
                button.setText(i7);
            }
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.onNegativeButtonClickListeners.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.remove(materialPickerOnPositiveButtonClickListener);
    }

    @VisibleForTesting
    void updateHeader(String str) {
        this.headerSelectionText.setContentDescription(getHeaderContentDescription());
        this.headerSelectionText.setText(str);
    }

    private String getHeaderContentDescription() {
        return getDateSelector().getSelectionContentDescription(requireContext());
    }

    private static int getPaddedPickerWidth(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_content_padding);
        int i6 = Month.current().daysInWeek;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_width) * i6) + ((i6 - 1) * resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    static boolean isFullscreen(@NonNull Context context) {
        return readMaterialCalendarStyleBoolean(context, R.attr.windowFullscreen);
    }

    private boolean isLandscape() {
        if (getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private void startPickerFragment() {
        int themeResId = getThemeResId(requireContext());
        MaterialTextInputPicker newInstance = MaterialCalendar.newInstance(getDateSelector(), themeResId, this.calendarConstraints, this.dayViewDecorator);
        this.calendar = newInstance;
        if (this.inputMode == 1) {
            newInstance = MaterialTextInputPicker.newInstance(getDateSelector(), themeResId, this.calendarConstraints);
        }
        this.pickerFragment = newInstance;
        updateTitle();
        updateHeader(getHeaderText());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(com.google.android.material.R.id.mtrl_calendar_frame, this.pickerFragment);
        beginTransaction.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener<S>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void onIncompleteSelectionChanged() {
                MaterialDatePicker.this.confirmButton.setEnabled(false);
            }

            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void onSelectionChanged(S s5) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.updateHeader(materialDatePicker.getHeaderText());
                MaterialDatePicker.this.confirmButton.setEnabled(MaterialDatePicker.this.getDateSelector().isSelectionComplete());
            }
        });
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    public String getHeaderText() {
        return getDateSelector().getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) bundle.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) bundle.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.titleTextResId = bundle.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = bundle.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = bundle.getInt(INPUT_MODE_KEY);
        this.positiveButtonTextResId = bundle.getInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY);
        this.positiveButtonText = bundle.getCharSequence(POSITIVE_BUTTON_TEXT_KEY);
        this.negativeButtonTextResId = bundle.getInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY);
        this.negativeButtonText = bundle.getCharSequence(NEGATIVE_BUTTON_TEXT_KEY);
        CharSequence charSequence = this.titleText;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.titleTextResId);
        }
        this.fullTitleText = charSequence;
        this.singleLineTitleText = getFirstLineBySeparator(charSequence);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        Month currentMonth;
        super.onSaveInstanceState(bundle);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.calendarConstraints);
        MaterialCalendar<S> materialCalendar = this.calendar;
        if (materialCalendar == null) {
            currentMonth = null;
        } else {
            currentMonth = materialCalendar.getCurrentMonth();
        }
        if (currentMonth != null) {
            builder.setOpenAt(currentMonth.timeInMillis);
        }
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.build());
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, this.titleText);
        bundle.putInt(INPUT_MODE_KEY, this.inputMode);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, this.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, this.positiveButtonText);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, this.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, this.negativeButtonText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
            enableEdgeToEdgeIfNeeded(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }
}
