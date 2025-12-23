package d0;

import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface b {
    @FormUrlEncoded
    @POST("app/fieldPlan/fieldPlanAppointedList")
    e<c0<ResponseBody>> a(@Field("userId") String userId, @Field("type") int type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/syscampus/getCampusList")
    e<c0<ResponseBody>> b();

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    e<c0<ResponseBody>> c(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("detailId") String detailId, @Field("status") String status);

    @FormUrlEncoded
    @POST("app/userInfoUserByUserNum2App")
    e<c0<ResponseBody>> d(@Field("userId") String userId, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/fieldPlan/getFieldAppHelp")
    e<c0<ResponseBody>> e(@Field("type") int type);

    @FormUrlEncoded
    @POST("app/fieldPlan/getFieldplanList")
    e<c0<ResponseBody>> f(@Field("userId") String userId, @Field("type") int type, @Field("pid") String pid, @Field("applyDate") String applyDate);

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    e<c0<ResponseBody>> g(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("companions") String companions, @Field("note") String note, @Field("appointType") int appointType, @Field("status") String status);

    @FormUrlEncoded
    @POST("app/field/getFieldByCampus")
    e<c0<ResponseBody>> h(@Field("campusId") String campusId);
}
