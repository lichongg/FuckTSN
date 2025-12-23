package com.bxkj.student.run.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\Downloads\app\classes3.dex */
public @interface RunBroadcastActionType {
    public static final String ADD_LINE = "ADD_LINE";
    public static final String ADD_OLD_LINE = "ADD_OLD_LINE";
    public static final String ADD_START_POINT = "ADD_START_POINT";
    public static final String CURRENT_LATLNG = "CURRENT_LATLNG";
    public static final String GET_FIRST_LOCATION_SUCCESS = "GET_FIRST_LOCATION_SUCCESS";
    public static final String NOTIFY_RUN_DATA = "NOTIFY_RUN_DATA";
    public static final String RUN_CONTINUE_NOTIFICATION = "RUN_CONTINUE_NOTIFICATION";
    public static final String RUN_DEBUG_INFO = "RUN_DEBUG_INFO";
    public static final String RUN_PAUSE_NOTIFICATION = "RUN_PAUSE_NOTIFICATION";
    public static final String SAVE_LOCAL_DB = "SAVE_LOCAL_DB";
    public static final String SET_RUNNING_PAUSE = "SET_RUNNING_PAUSE";
    public static final String STOP_LOCATION = "STOP_LOCATION";
    public static final String TIME_CHANGE = "TIME_CHANGE";
    public static final String UPDATE_DISTANCE = "UPDATE_DISTANCE";
    public static final String UPDATE_GPS_STATUS = "UPDATE_GPS_STATUS";
    public static final String UPDATE_STEP = "UPDATE_STEP";
}
