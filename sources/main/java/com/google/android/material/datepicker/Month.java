package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() { // from class: com.google.android.material.datepicker.Month.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month[] newArray(int i6) {
            return new Month[i6];
        }
    };
    final int daysInMonth;
    final int daysInWeek;

    @NonNull
    private final Calendar firstOfMonth;

    @Nullable
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    @NonNull
    static Month create(long j6) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j6);
        return new Month(utcCalendar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.month == month.month && this.year == month.year;
    }

    @NonNull
    static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    int daysFromStartOfWeekToFirstOfMonth(int i6) {
        int i7 = this.firstOfMonth.get(7);
        if (i6 <= 0) {
            i6 = this.firstOfMonth.getFirstDayOfWeek();
        }
        int i8 = i7 - i6;
        return i8 < 0 ? i8 + this.daysInWeek : i8;
    }

    long getDay(int i6) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.set(5, i6);
        return dayCopy.getTimeInMillis();
    }

    int getDayOfMonth(long j6) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.setTimeInMillis(j6);
        return dayCopy.get(5);
    }

    @NonNull
    String getLongName() {
        if (this.longName == null) {
            this.longName = DateStrings.getYearMonth(this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    Month monthsLater(int i6) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i6);
        return new Month(dayCopy);
    }

    int monthsUntil(@NonNull Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.year - this.year) * 12) + (month.month - this.month);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar dayCopy = UtcDates.getDayCopy(calendar);
        this.firstOfMonth = dayCopy;
        this.month = dayCopy.get(2);
        this.year = dayCopy.get(1);
        this.daysInWeek = dayCopy.getMaximum(7);
        this.daysInMonth = dayCopy.getActualMaximum(5);
        this.timeInMillis = dayCopy.getTimeInMillis();
    }

    @NonNull
    static Month create(int i6, int i7) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.set(1, i6);
        utcCalendar.set(2, i7);
        return new Month(utcCalendar);
    }
}
