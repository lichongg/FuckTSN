package com.acse.ottn;

import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdInfoModel;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface f4 {
    @POST("api/close_remind")
    rx.e<String> A(@Body RequestBody requestBody);

    @POST("api/an/gc/mt_ele")
    rx.e<String> B(@Body RequestBody requestBody);

    @POST("api/check_session")
    rx.e<String> a(@Body RequestBody requestBody);

    @POST("api/an/gc/set_close_status")
    rx.e<String> b(@Body RequestBody requestBody);

    @POST("api/an/gc/get_app_list")
    rx.e<String> c(@Body RequestBody requestBody);

    @POST("api/mobile_app")
    rx.e<String> d(@Body RequestBody requestBody);

    @POST("api/an/gc/allocation_result")
    rx.e<String> e(@Body RequestBody requestBody);

    @POST("api/an/gc/verify")
    rx.e<String> f(@Body RequestBody requestBody);

    @POST("api/cut_down")
    rx.e<AdInfoModel> g(@Body RequestBody requestBody);

    @POST("api/report")
    rx.e<String> h(@Body RequestBody requestBody);

    @POST("api/an/gc/get_close_status")
    rx.e<String> i(@Body RequestBody requestBody);

    @POST("api/member")
    rx.e<String> j(@Body RequestBody requestBody);

    @POST("api/an/gc/scroll")
    rx.e<AccessiblityModel> k(@Body RequestBody requestBody);

    @POST("api/time_limit")
    rx.e<String> l(@Body RequestBody requestBody);

    @POST("api/push_ad_ecpm")
    rx.e<String> m(@Body RequestBody requestBody);

    @POST("api/an/gc/save_settings")
    rx.e<String> n(@Body RequestBody requestBody);

    @POST("api/an/gc/lon_lat")
    rx.e<String> o(@Body RequestBody requestBody);

    @POST("api/data_check")
    rx.e<String> p(@Body RequestBody requestBody);

    @POST("api/clear_ad_time")
    rx.e<String> q(@Body RequestBody requestBody);

    @POST("api/limit_tips")
    rx.e<String> r(@Body RequestBody requestBody);

    @POST("api/close_plugin")
    rx.e<String> s(@Body RequestBody requestBody);

    @POST("api/mobile_check")
    rx.e<String> t(@Body RequestBody requestBody);

    @POST("api/an/gc/local_ref")
    rx.e<String> u(@Body RequestBody requestBody);

    @POST("api/an/gc/allocation_app")
    rx.e<String> v(@Body RequestBody requestBody);

    @POST("api/plugin_check")
    rx.e<String> w(@Body RequestBody requestBody);

    @POST("api/plugin_change")
    rx.e<String> x(@Body RequestBody requestBody);

    @POST("api/an/gc/pn")
    rx.e<AccessiblityModel> y(@Body RequestBody requestBody);

    @POST("api/an/gc/jlj")
    rx.e<String> z(@Body RequestBody requestBody);
}
