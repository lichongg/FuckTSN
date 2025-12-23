package com.google.android.material.timepicker;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import com.tencent.connect.common.Constants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private boolean broadcasting = false;
    private float hourRotation;
    private float minuteRotation;
    private final TimeModel time;
    private final TimePickerView timePickerView;
    private static final String[] HOUR_CLOCK_VALUES = {Constants.VIA_REPORT_TYPE_SET_AVATAR, "1", "2", "3", "4", "5", "6", "7", "8", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
    private static final String[] HOUR_CLOCK_24_VALUES = {"00", "1", "2", "3", "4", "5", "6", "7", "8", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_REPORT_TYPE_JOININ_GROUP, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_START_WAP, Constants.VIA_REPORT_TYPE_START_GROUP, "18", Constants.VIA_ACT_TYPE_NINETEEN, "20", "21", Constants.VIA_REPORT_TYPE_DATALINE, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR};
    private static final String[] MINUTE_CLOCK_VALUES = {"00", "5", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_WPA_STATE, "20", Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "30", "35", "40", "45", "50", "55"};

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float f6, boolean z5) {
        this.broadcasting = true;
        TimeModel timeModel = this.time;
        int i6 = timeModel.minute;
        int i7 = timeModel.hour;
        if (timeModel.selection == 10) {
            this.timePickerView.setHandRotation(this.hourRotation, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(this.timePickerView.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                setSelection(12, true);
            }
        } else {
            int round = Math.round(f6);
            if (!z5) {
                this.time.setMinute(((round + 15) / 30) * 5);
                this.minuteRotation = this.time.minute * 6;
            }
            this.timePickerView.setHandRotation(this.minuteRotation, z5);
        }
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(i7, i6);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int i6) {
        setSelection(i6, true);
    }

    private String[] getHourClockValues() {
        return this.time.format == 1 ? HOUR_CLOCK_24_VALUES : HOUR_CLOCK_VALUES;
    }

    private int getHourRotation() {
        return (this.time.getHourForDisplay() * 30) % 360;
    }

    private void performHapticFeedback(int i6, int i7) {
        TimeModel timeModel = this.time;
        if (timeModel.minute == i7 && timeModel.hour == i6) {
            return;
        }
        this.timePickerView.performHapticFeedback(4);
    }

    private void updateCurrentLevel() {
        TimeModel timeModel = this.time;
        int i6 = 1;
        if (timeModel.selection == 10 && timeModel.format == 1 && timeModel.hour >= 12) {
            i6 = 2;
        }
        this.timePickerView.setCurrentLevel(i6);
    }

    private void updateTime() {
        TimePickerView timePickerView = this.timePickerView;
        TimeModel timeModel = this.time;
        timePickerView.updateTime(timeModel.period, timeModel.getHourForDisplay(), this.time.minute);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        if (this.time.format == 0) {
            this.timePickerView.showToggle();
        }
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void onPeriodChange(int i6) {
        this.time.setPeriod(i6);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f6, boolean z5) {
        if (this.broadcasting) {
            return;
        }
        TimeModel timeModel = this.time;
        int i6 = timeModel.hour;
        int i7 = timeModel.minute;
        int round = Math.round(f6);
        TimeModel timeModel2 = this.time;
        if (timeModel2.selection == 12) {
            timeModel2.setMinute((round + 3) / 6);
            this.minuteRotation = (float) Math.floor(this.time.minute * 6);
        } else {
            int i8 = (round + 15) / 30;
            if (timeModel2.format == 1) {
                i8 %= 12;
                if (this.timePickerView.getCurrentLevel() == 2) {
                    i8 += 12;
                }
            }
            this.time.setHour(i8);
            this.hourRotation = getHourRotation();
        }
        if (z5) {
            return;
        }
        updateTime();
        performHapticFeedback(i6, i7);
    }

    void setSelection(int i6, boolean z5) {
        boolean z6 = i6 == 12;
        this.timePickerView.setAnimateOnTouchUp(z6);
        this.time.selection = i6;
        this.timePickerView.setValues(z6 ? MINUTE_CLOCK_VALUES : getHourClockValues(), z6 ? R.string.material_minute_suffix : this.time.getHourContentDescriptionResId());
        updateCurrentLevel();
        this.timePickerView.setHandRotation(z6 ? this.minuteRotation : this.hourRotation, z5);
        this.timePickerView.setActiveSelection(i6);
        this.timePickerView.setMinuteHourDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_hour_selection) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.1
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(TimePickerClockPresenter.this.time.getHourContentDescriptionResId(), String.valueOf(TimePickerClockPresenter.this.time.getHourForDisplay())));
            }
        });
        this.timePickerView.setHourClickDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_minute_selection) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.2
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R.string.material_minute_suffix, String.valueOf(TimePickerClockPresenter.this.time.minute)));
            }
        });
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.timePickerView = timePickerView;
        this.time = timeModel;
        initialize();
    }

    private void updateValues(String[] strArr, String str) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            strArr[i6] = TimeModel.formatText(this.timePickerView.getResources(), strArr[i6], str);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.hourRotation = getHourRotation();
        TimeModel timeModel = this.time;
        this.minuteRotation = timeModel.minute * 6;
        setSelection(timeModel.selection, false);
        updateTime();
    }
}
