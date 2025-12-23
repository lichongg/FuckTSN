package com.bxkj.base.v2.data;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class UserType {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ UserType[] $VALUES;
    public static final UserType STUDENT = new UserType("STUDENT", 0);
    public static final UserType TEACHER = new UserType("TEACHER", 1);

    private static final /* synthetic */ UserType[] $values() {
        return new UserType[]{STUDENT, TEACHER};
    }

    static {
        UserType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<UserType> getEntries() {
        return $ENTRIES;
    }

    public static UserType valueOf(String str) {
        return (UserType) Enum.valueOf(UserType.class, str);
    }

    public static UserType[] values() {
        return (UserType[]) $VALUES.clone();
    }

    private UserType(String str, int i6) {
    }
}
