package com.bxkj.student.life.mall.order;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\Downloads\app\classes3.dex */
public @interface OrderStatus {
    public static final int AFTER_SALES = 7;
    public static final int CANCEL = 5;
    public static final int CLOSE = 6;
    public static final int COMPLETE = 4;
    public static final int WAIT_ACCEPT = 3;
    public static final int WAIT_DELIVEDER = 2;
    public static final int WAIT_PAY = 1;
}
