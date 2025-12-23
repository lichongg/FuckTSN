package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class MonthAdapter extends BaseAdapter {
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;

    @Nullable
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection<Long> previouslySelectedDates;
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    private static final int MAXIMUM_GRID_CELLS = (UtcDates.getUtcCalendar().getMaximum(5) + UtcDates.getUtcCalendar().getMaximum(7)) - 1;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean isLastInRow(int i6) {
        return (i6 + 1) % this.month.daysInWeek == 0;
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    private boolean isSelected(long j6) {
        Iterator<Long> it = this.dateSelector.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (UtcDates.canonicalYearMonthDay(j6) == UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void updateSelectedState(@Nullable TextView textView, long j6, int i6) {
        CalendarItemStyle calendarItemStyle;
        boolean z5;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String dayContentDescription = getDayContentDescription(context, j6);
        textView.setContentDescription(dayContentDescription);
        boolean isValid = this.calendarConstraints.getDateValidator().isValid(j6);
        if (isValid) {
            textView.setEnabled(true);
            boolean isSelected = isSelected(j6);
            textView.setSelected(isSelected);
            calendarItemStyle = isSelected ? this.calendarStyle.selectedDay : isToday(j6) ? this.calendarStyle.todayDay : this.calendarStyle.day;
            z5 = isSelected;
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.calendarStyle.invalidDay;
            z5 = false;
        }
        DayViewDecorator dayViewDecorator = this.dayViewDecorator;
        if (dayViewDecorator == null || i6 == -1) {
            calendarItemStyle.styleItem(textView);
            return;
        }
        Month month = this.month;
        int i7 = month.year;
        int i8 = month.month;
        calendarItemStyle.styleItem(textView, dayViewDecorator.getBackgroundColor(context, i7, i8, i6, isValid, z5), this.dayViewDecorator.getTextColor(context, i7, i8, i6, isValid, z5));
        textView.setCompoundDrawables(this.dayViewDecorator.getCompoundDrawableLeft(context, i7, i8, i6, isValid, z5), this.dayViewDecorator.getCompoundDrawableTop(context, i7, i8, i6, isValid, z5), this.dayViewDecorator.getCompoundDrawableRight(context, i7, i8, i6, isValid, z5), this.dayViewDecorator.getCompoundDrawableBottom(context, i7, i8, i6, isValid, z5));
        textView.setContentDescription(this.dayViewDecorator.getContentDescription(context, i7, i8, i6, isValid, z5, dayContentDescription));
    }

    int dayToPosition(int i6) {
        return firstPositionInMonth() + (i6 - 1);
    }

    int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int i6) {
        if (i6 < firstPositionInMonth() || i6 > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i6)));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return i6 / this.month.daysInWeek;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.initializeStyles(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.firstPositionInMonth()
            int r7 = r6 - r7
            if (r7 < 0) goto L54
            com.google.android.material.datepicker.Month r8 = r5.month
            int r2 = r8.daysInMonth
            if (r7 < r2) goto L2d
            goto L54
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r1] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L5d
        L54:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L5d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L64
            return r0
        L64:
            long r1 = r6.longValue()
            r5.updateSelectedState(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    @VisibleForTesting
    boolean isEndOfRange(long j6) {
        Iterator<Pair<Long, Long>> it = this.dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Long l6 = it.next().second;
            if (l6 != null && l6.longValue() == j6) {
                return true;
            }
        }
        return false;
    }

    boolean isFirstInRow(int i6) {
        return i6 % this.month.daysInWeek == 0;
    }

    @VisibleForTesting
    boolean isStartOfRange(long j6) {
        Iterator<Pair<Long, Long>> it = this.dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Long l6 = it.next().first;
            if (l6 != null && l6.longValue() == j6) {
                return true;
            }
        }
        return false;
    }

    public void updateSelectedStates(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.previouslySelectedDates.iterator();
        while (it.hasNext()) {
            updateSelectedStateForDate(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.dateSelector;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
            while (it2.hasNext()) {
                updateSelectedStateForDate(materialCalendarGridView, it2.next().longValue());
            }
            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, @Nullable DayViewDecorator dayViewDecorator) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
        this.dayViewDecorator = dayViewDecorator;
        this.previouslySelectedDates = dateSelector.getSelectedDays();
    }

    private String getDayContentDescription(Context context, long j6) {
        return DateStrings.getDayContentDescription(context, j6, isToday(j6), isStartOfRange(j6), isEndOfRange(j6));
    }

    private boolean isToday(long j6) {
        if (UtcDates.getTodayCalendar().getTimeInMillis() == j6) {
            return true;
        }
        return false;
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j6) {
        if (Month.create(j6).equals(this.month)) {
            int dayOfMonth = this.month.getDayOfMonth(j6);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(dayOfMonth) - materialCalendarGridView.getFirstVisiblePosition()), j6, dayOfMonth);
        }
    }

    int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    int positionToDay(int i6) {
        return (i6 - firstPositionInMonth()) + 1;
    }

    boolean withinMonth(int i6) {
        if (i6 >= firstPositionInMonth() && i6 <= lastPositionInMonth()) {
            return true;
        }
        return false;
    }
}
