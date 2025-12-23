package x;

import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54749a = "https://w.boxkj.com/";

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getDeliverWithdrawMoney")
    rx.e<c0<ResponseBody>> a(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/updateDeliverTaskPublishStatus")
    rx.e<c0<ResponseBody>> b(@Field("schoolId") String str, @Field("userId") String str2, @Field("taskStatus") String str3, @Field("taskId") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/userPt/userHasGranted")
    rx.e<c0<ResponseBody>> c(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/addDeliverTaskOrder")
    rx.e<c0<ResponseBody>> d(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @POST("https://w.boxkj.com/app/appDeliverItemType/getAllItemType")
    rx.e<c0<ResponseBody>> e();

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/userPt/grantUser")
    rx.e<c0<ResponseBody>> f(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskProcess/addDeliverTaskFinishProcess")
    rx.e<c0<ResponseBody>> g(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("taskCode") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverUserBasicInfo/getDeliverUserBasicInfo")
    rx.e<c0<ResponseBody>> h(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/getDeliverTaskPublish")
    rx.e<c0<ResponseBody>> i(@Field("taskId") String str, @Field("orderId") String str2, @Field("schoolId") String str3, @Field("userId") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getExpendDeliverMoney")
    rx.e<c0<ResponseBody>> j(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/appMyDeliverTaskPublishList")
    rx.e<c0<ResponseBody>> k(@Field("schoolId") String str, @Field("userId") String str2, @Field("taskStatus") String str3, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverUserBasicInfo/addDeliverUserBasicInfo")
    rx.e<c0<ResponseBody>> l(@Field("schoolId") String str, @Field("userId") String str2, @Field("telPhone") String str3, @Field("birthday") String str4, @Field("identificate") String str5, @Field("userAddress") String str6, @Field("cardFrontImg") String str7, @Field("cardReverseImg") String str8, @Field("cardHandImg") String str9);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/appMyDeliverTaskOrderList")
    rx.e<c0<ResponseBody>> m(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderStatus") String str3, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getIncomeDeliverMoney")
    rx.e<c0<ResponseBody>> n(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/weixinpayController/appPay")
    rx.e<c0<ResponseBody>> o(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskAppraise/addDeliverTaskAppraise")
    rx.e<c0<ResponseBody>> p(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("appraiseStar") String str4, @Field("appraiseContent") String str5, @Field("images") String str6, @Field("imgNames") String str7);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/updateDeliverTaskOrderStatus")
    rx.e<c0<ResponseBody>> q(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/alipayController/appPay")
    rx.e<c0<ResponseBody>> r(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/addDeliverTaskPublish")
    rx.e<c0<ResponseBody>> s(@Field("taskName") String str, @Field("taskContent") String str2, @Field("goodsTypeId") String str3, @Field("schoolId") String str4, @Field("userId") String str5, @Field("publishUser") String str6, @Field("publishTelPhone") String str7, @Field("taskStartAddress") String str8, @Field("startLat") String str9, @Field("startLng") String str10, @Field("taskStartTime") String str11, @Field("receverUser") String str12, @Field("receverTelPhone") String str13, @Field("taskEndAddress") String str14, @Field("endLat") String str15, @Field("endLng") String str16, @Field("taskEndTime") String str17, @Field("taskPrice") String str18);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskProcess/addDelivertaskTakeProcess")
    rx.e<c0<ResponseBody>> t(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("images") String str4, @Field("imgNames") String str5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/appDeliverTaskPublishList")
    rx.e<c0<ResponseBody>> u(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverWithdrawApply/addDeliverWithdrawApplyRecord")
    rx.e<c0<ResponseBody>> v(@Field("schoolId") String str, @Field("userId") String str2, @Field("withDrawMoney") double d6);
}
