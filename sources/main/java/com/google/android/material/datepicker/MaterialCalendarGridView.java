package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    private static boolean skipMonth(@Nullable Long l6, @Nullable Long l7, @Nullable Long l8, @Nullable Long l9) {
        return l6 == null || l7 == null || l8 == null || l9 == null || l8.longValue() > l7.longValue() || l9.longValue() < l6.longValue();
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void gainFocus(int i6, Rect rect) {
        if (i6 == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i6 == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i6, rect);
        }
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas canvas) {
        int dayToPosition;
        int horizontalMidPoint;
        int dayToPosition2;
        int horizontalMidPoint2;
        int i6;
        int i7;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = materialCalendarGridView.getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        int max = Math.max(adapter.firstPositionInMonth(), materialCalendarGridView.getFirstVisiblePosition());
        int min = Math.min(adapter.lastPositionInMonth(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            Long l6 = next.first;
            if (l6 == null) {
                materialCalendarGridView = this;
            } else if (next.second != null) {
                Long l7 = l6;
                long longValue = l7.longValue();
                Long l8 = next.second;
                long longValue2 = l8.longValue();
                if (!skipMonth(item, item2, l7, l8)) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(materialCalendarGridView);
                    if (longValue < item.longValue()) {
                        horizontalMidPoint = adapter.isFirstInRow(max) ? 0 : !isLayoutRtl ? materialCalendarGridView.getChildAtPosition(max - 1).getRight() : materialCalendarGridView.getChildAtPosition(max - 1).getLeft();
                        dayToPosition = max;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                        dayToPosition = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        horizontalMidPoint = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(dayToPosition));
                    }
                    if (longValue2 > item2.longValue()) {
                        horizontalMidPoint2 = adapter.isLastInRow(min) ? materialCalendarGridView.getWidth() : !isLayoutRtl ? materialCalendarGridView.getChildAtPosition(min).getRight() : materialCalendarGridView.getChildAtPosition(min).getLeft();
                        dayToPosition2 = min;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                        dayToPosition2 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        horizontalMidPoint2 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(dayToPosition2));
                    }
                    int itemId = (int) adapter.getItemId(dayToPosition);
                    int i8 = max;
                    int i9 = min;
                    int itemId2 = (int) adapter.getItemId(dayToPosition2);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        MonthAdapter monthAdapter = adapter;
                        int numColumns2 = (numColumns + materialCalendarGridView.getNumColumns()) - 1;
                        View childAtPosition = materialCalendarGridView.getChildAtPosition(numColumns);
                        int top2 = childAtPosition.getTop() + calendarStyle.day.getTopInset();
                        Iterator<Pair<Long, Long>> it2 = it;
                        int bottom = childAtPosition.getBottom() - calendarStyle.day.getBottomInset();
                        if (isLayoutRtl) {
                            int i10 = dayToPosition2 > numColumns2 ? 0 : horizontalMidPoint2;
                            int width = numColumns > dayToPosition ? getWidth() : horizontalMidPoint;
                            i6 = i10;
                            i7 = width;
                        } else {
                            i6 = numColumns > dayToPosition ? 0 : horizontalMidPoint;
                            i7 = dayToPosition2 > numColumns2 ? getWidth() : horizontalMidPoint2;
                        }
                        canvas.drawRect(i6, top2, i7, bottom, calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter = monthAdapter;
                        it = it2;
                    }
                    materialCalendarGridView = this;
                    max = i8;
                    min = i9;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z5, int i6, Rect rect) {
        if (z5) {
            gainFocus(i6, rect);
        } else {
            super.onFocusChanged(false, i6, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i6, int i7) {
        if (!this.nestedScrollable) {
            super.onMeasure(i6, i7);
            return;
        }
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof MonthAdapter)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo(null);
            }
        });
    }

    private View getChildAtPosition(int i6) {
        return getChildAt(i6 - getFirstVisiblePosition());
    }

    private static int horizontalMidPoint(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public ListAdapter getAdapter2() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (!super.onKeyDown(i6, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i6) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i6) {
        if (i6 < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i6);
        }
    }
}
