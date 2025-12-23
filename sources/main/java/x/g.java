package x;

import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54748a = "https://mall.boxkj.com/";

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/generatingOrder")
    rx.e<c0<ResponseBody>> A(@Field("ids") String str, @Field("addressId") String str2, @Field("memo") String str3, @Field("comm") String str4);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/setDefaultAddress")
    rx.e<c0<ResponseBody>> B(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/clearUserfavorites")
    rx.e<c0<ResponseBody>> C(@Field("userId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/user/grantUser")
    rx.e<c0<ResponseBody>> D(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserShoppingCarList")
    rx.e<c0<ResponseBody>> E(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadSecondGoodsRelative")
    rx.e<c0<ResponseBody>> a(@Field("firstTypeId") String str, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/alipayController/appPay")
    rx.e<c0<ResponseBody>> b(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/addCommodityToShoppingCar")
    rx.e<c0<ResponseBody>> c(@Field("regionUserId") String str, @Field("commId") String str2, @Field("modelId") String str3, @Field("commNum") int i6);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCommodityDetail")
    rx.e<c0<ResponseBody>> d(@Field("commId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteOrder")
    rx.e<c0<ResponseBody>> e(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadOrderDetail")
    rx.e<c0<ResponseBody>> f(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getSettlementCenter2")
    rx.e<c0<ResponseBody>> g(@Field("regionUserId") String str, @Field("commId") String str2, @Field("modelId") String str3, @Field("commNum") int i6);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/askForRefund")
    rx.e<c0<ResponseBody>> h(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/favoriteComm")
    rx.e<c0<ResponseBody>> i(@Field("commId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCommodityList")
    rx.e<c0<ResponseBody>> j(@Field("typeId") String str, @Field("keyword") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserOrders")
    rx.e<c0<ResponseBody>> k(@Field("orderMode") String str, @Field("regionUserId") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadLoggicInfo")
    rx.e<c0<ResponseBody>> l(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/weixinpayController/appPay")
    rx.e<c0<ResponseBody>> m(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserShoppingCarNum")
    rx.e<c0<ResponseBody>> n(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/findUserfavorites")
    rx.e<c0<ResponseBody>> o(@Field("keyword") String str, @Field("userId") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getSettlementCenter1")
    rx.e<c0<ResponseBody>> p(@Field("regionUserId") String str, @Field("ids") String str2);

    @POST("https://mall.boxkj.com/app/show/loadFirstGoodsType")
    rx.e<c0<ResponseBody>> q();

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/confirmReceipt")
    rx.e<c0<ResponseBody>> r(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getReceiveAddressList")
    rx.e<c0<ResponseBody>> s(@Field("regionUserId") String str, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCityStandard")
    rx.e<c0<ResponseBody>> t(@Field("parentId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteReceiveAddress")
    rx.e<c0<ResponseBody>> u(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/batchUpdateUserShoppingCar")
    rx.e<c0<ResponseBody>> v(@Field("data") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteShoppingCar")
    rx.e<c0<ResponseBody>> w(@Field("ids") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/cancelOrder")
    rx.e<c0<ResponseBody>> x(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/addReceiveAddress")
    rx.e<c0<ResponseBody>> y(@Field("id") String str, @Field("regionUserId") String str2, @Field("cityId") String str3, @Field("detailAddress") String str4, @Field("receiverName") String str5, @Field("receiverPhone") String str6);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/user/userHasGranted")
    rx.e<c0<ResponseBody>> z(@Field("regionUserId") String str);
}
