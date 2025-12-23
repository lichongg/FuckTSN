package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AADateTimeLabelFormats {

    @Nullable
    private String day;

    @Nullable
    private String hour;

    @Nullable
    private String millisecond;

    @Nullable
    private String minute;

    @Nullable
    private String month;

    @Nullable
    private String second;

    @Nullable
    private String week;

    @Nullable
    private String year;

    @NotNull
    public final AADateTimeLabelFormats day(@Nullable String str) {
        this.day = str;
        return this;
    }

    @Nullable
    public final String getDay() {
        return this.day;
    }

    @Nullable
    public final String getHour() {
        return this.hour;
    }

    @Nullable
    public final String getMillisecond() {
        return this.millisecond;
    }

    @Nullable
    public final String getMinute() {
        return this.minute;
    }

    @Nullable
    public final String getMonth() {
        return this.month;
    }

    @Nullable
    public final String getSecond() {
        return this.second;
    }

    @Nullable
    public final String getWeek() {
        return this.week;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    @NotNull
    public final AADateTimeLabelFormats hour(@Nullable String str) {
        this.hour = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats millisecond(@Nullable String str) {
        this.millisecond = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats minute(@Nullable String str) {
        this.minute = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats month(@Nullable String str) {
        this.month = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats second(@Nullable String str) {
        this.second = str;
        return this;
    }

    public final void setDay(@Nullable String str) {
        this.day = str;
    }

    public final void setHour(@Nullable String str) {
        this.hour = str;
    }

    public final void setMillisecond(@Nullable String str) {
        this.millisecond = str;
    }

    public final void setMinute(@Nullable String str) {
        this.minute = str;
    }

    public final void setMonth(@Nullable String str) {
        this.month = str;
    }

    public final void setSecond(@Nullable String str) {
        this.second = str;
    }

    public final void setWeek(@Nullable String str) {
        this.week = str;
    }

    public final void setYear(@Nullable String str) {
        this.year = str;
    }

    @NotNull
    public final AADateTimeLabelFormats week(@Nullable String str) {
        this.week = str;
        return this;
    }

    @NotNull
    public final AADateTimeLabelFormats year(@Nullable String str) {
        this.year = str;
        return this;
    }
}
