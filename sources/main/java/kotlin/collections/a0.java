package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import defpackage.H5BaseWebChromeClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.comparisons.g;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,25600:1\n13020#1,2:25601\n13030#1,2:25603\n1400#1,2:25605\n1408#1,2:25607\n1416#1,2:25609\n1424#1,2:25611\n1432#1,2:25613\n1440#1,2:25615\n1448#1,2:25617\n1456#1,2:25619\n1464#1,2:25621\n2443#1,5:25623\n2456#1,5:25628\n2469#1,5:25633\n2482#1,5:25638\n2495#1,5:25643\n2508#1,5:25648\n2521#1,5:25653\n2534#1,5:25658\n2547#1,5:25663\n4434#1,2:25669\n4444#1,2:25671\n4454#1,2:25673\n4464#1,2:25675\n4474#1,2:25677\n4484#1,2:25679\n4494#1,2:25681\n4504#1,2:25683\n4514#1,2:25685\n4101#1:25687\n13870#1,2:25688\n4102#1,2:25690\n13872#1:25692\n4104#1:25693\n4115#1:25694\n13880#1,2:25695\n4116#1,2:25697\n13882#1:25699\n4118#1:25700\n4129#1:25701\n13890#1,2:25702\n4130#1,2:25704\n13892#1:25706\n4132#1:25707\n4143#1:25708\n13900#1,2:25709\n4144#1,2:25711\n13902#1:25713\n4146#1:25714\n4157#1:25715\n13910#1,2:25716\n4158#1,2:25718\n13912#1:25720\n4160#1:25721\n4171#1:25722\n13920#1,2:25723\n4172#1,2:25725\n13922#1:25727\n4174#1:25728\n4185#1:25729\n13930#1,2:25730\n4186#1,2:25732\n13932#1:25734\n4188#1:25735\n4199#1:25736\n13940#1,2:25737\n4200#1,2:25739\n13942#1:25741\n4202#1:25742\n4213#1:25743\n13950#1,2:25744\n4214#1,2:25746\n13952#1:25748\n4216#1:25749\n13870#1,3:25750\n13880#1,3:25753\n13890#1,3:25756\n13900#1,3:25759\n13910#1,3:25762\n13920#1,3:25765\n13930#1,3:25768\n13940#1,3:25771\n13950#1,3:25774\n4234#1,2:25777\n4344#1,2:25779\n4354#1,2:25781\n4364#1,2:25783\n4374#1,2:25785\n4384#1,2:25787\n4394#1,2:25789\n4404#1,2:25791\n4414#1,2:25793\n4424#1,2:25795\n9584#1,4:25797\n9599#1,4:25801\n9614#1,4:25805\n9629#1,4:25809\n9644#1,4:25813\n9659#1,4:25817\n9674#1,4:25821\n9689#1,4:25825\n9704#1,4:25829\n9297#1,4:25833\n9313#1,4:25837\n9329#1,4:25841\n9345#1,4:25845\n9361#1,4:25849\n9377#1,4:25853\n9393#1,4:25857\n9409#1,4:25861\n9425#1,4:25865\n9441#1,4:25869\n9457#1,4:25873\n9473#1,4:25877\n9489#1,4:25881\n9505#1,4:25885\n9521#1,4:25889\n9537#1,4:25893\n9553#1,4:25897\n9569#1,4:25901\n9872#1,4:25905\n10890#1,5:25909\n10901#1,5:25914\n10912#1,5:25919\n10923#1,5:25924\n10934#1,5:25929\n10945#1,5:25934\n10956#1,5:25939\n10967#1,5:25944\n10978#1,5:25949\n10993#1,5:25954\n11234#1,3:25959\n11237#1,3:25969\n11251#1,3:25972\n11254#1,3:25982\n11268#1,3:25985\n11271#1,3:25995\n11285#1,3:25998\n11288#1,3:26008\n11302#1,3:26011\n11305#1,3:26021\n11319#1,3:26024\n11322#1,3:26034\n11336#1,3:26037\n11339#1,3:26047\n11353#1,3:26050\n11356#1,3:26060\n11370#1,3:26063\n11373#1,3:26073\n11388#1,3:26076\n11391#1,3:26086\n11406#1,3:26089\n11409#1,3:26099\n11424#1,3:26102\n11427#1,3:26112\n11442#1,3:26115\n11445#1,3:26125\n11460#1,3:26128\n11463#1,3:26138\n11478#1,3:26141\n11481#1,3:26151\n11496#1,3:26154\n11499#1,3:26164\n11514#1,3:26167\n11517#1,3:26177\n11532#1,3:26180\n11535#1,3:26190\n11896#1,3:26319\n11906#1,3:26322\n11916#1,3:26325\n11926#1,3:26328\n11936#1,3:26331\n11946#1,3:26334\n11956#1,3:26337\n11966#1,3:26340\n11976#1,3:26343\n11762#1,4:26346\n11775#1,4:26350\n11788#1,4:26354\n11801#1,4:26358\n11814#1,4:26362\n11827#1,4:26366\n11840#1,4:26370\n11853#1,4:26374\n11866#1,4:26378\n11751#1:26382\n13870#1,2:26383\n13872#1:26386\n11752#1:26387\n13870#1,3:26388\n11887#1:26391\n13805#1:26392\n13806#1:26394\n11888#1:26395\n13805#1,2:26396\n13870#1,3:26398\n13880#1,3:26401\n13890#1,3:26404\n13900#1,3:26407\n13910#1,3:26410\n13920#1,3:26413\n13930#1,3:26416\n13940#1,3:26419\n13950#1,3:26422\n21873#1,2:26425\n21875#1,6:26428\n22089#1,2:26434\n22091#1,6:26437\n24212#1,6:26443\n24228#1,6:26449\n24244#1,6:26455\n24260#1,6:26461\n24276#1,6:26467\n24292#1,6:26473\n24308#1,6:26479\n24324#1,6:26485\n24340#1,6:26491\n24446#1,8:26497\n24464#1,8:26505\n24482#1,8:26513\n24500#1,8:26521\n24518#1,8:26529\n24536#1,8:26537\n24554#1,8:26545\n24572#1,8:26553\n24590#1,8:26561\n24688#1,6:26569\n24704#1,6:26575\n24720#1,6:26581\n24736#1,6:26587\n24752#1,6:26593\n24768#1,6:26599\n24784#1,6:26605\n24800#1,6:26611\n1#2:25668\n1#2:26385\n1#2:26393\n1#2:26427\n1#2:26436\n382#3,7:25962\n382#3,7:25975\n382#3,7:25988\n382#3,7:26001\n382#3,7:26014\n382#3,7:26027\n382#3,7:26040\n382#3,7:26053\n382#3,7:26066\n382#3,7:26079\n382#3,7:26092\n382#3,7:26105\n382#3,7:26118\n382#3,7:26131\n382#3,7:26144\n382#3,7:26157\n382#3,7:26170\n382#3,7:26183\n382#3,7:26193\n382#3,7:26200\n382#3,7:26207\n382#3,7:26214\n382#3,7:26221\n382#3,7:26228\n382#3,7:26235\n382#3,7:26242\n382#3,7:26249\n382#3,7:26256\n382#3,7:26263\n382#3,7:26270\n382#3,7:26277\n382#3,7:26284\n382#3,7:26291\n382#3,7:26298\n382#3,7:26305\n382#3,7:26312\n*S KotlinDebug\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n647#1:25601,2\n656#1:25603,2\n950#1:25605,2\n960#1:25607,2\n970#1:25609,2\n980#1:25611,2\n990#1:25613,2\n1000#1:25615,2\n1010#1:25617,2\n1020#1:25619,2\n1030#1:25621,2\n1040#1:25623,5\n1050#1:25628,5\n1060#1:25633,5\n1070#1:25638,5\n1080#1:25643,5\n1090#1:25648,5\n1100#1:25653,5\n1110#1:25658,5\n1120#1:25663,5\n3919#1:25669,2\n3928#1:25671,2\n3937#1:25673,2\n3946#1:25675,2\n3955#1:25677,2\n3964#1:25679,2\n3973#1:25681,2\n3982#1:25683,2\n3991#1:25685,2\n4002#1:25687\n4002#1:25688,2\n4002#1:25690,2\n4002#1:25692\n4002#1:25693\n4013#1:25694\n4013#1:25695,2\n4013#1:25697,2\n4013#1:25699\n4013#1:25700\n4024#1:25701\n4024#1:25702,2\n4024#1:25704,2\n4024#1:25706\n4024#1:25707\n4035#1:25708\n4035#1:25709,2\n4035#1:25711,2\n4035#1:25713\n4035#1:25714\n4046#1:25715\n4046#1:25716,2\n4046#1:25718,2\n4046#1:25720\n4046#1:25721\n4057#1:25722\n4057#1:25723,2\n4057#1:25725,2\n4057#1:25727\n4057#1:25728\n4068#1:25729\n4068#1:25730,2\n4068#1:25732,2\n4068#1:25734\n4068#1:25735\n4079#1:25736\n4079#1:25737,2\n4079#1:25739,2\n4079#1:25741\n4079#1:25742\n4090#1:25743\n4090#1:25744,2\n4090#1:25746,2\n4090#1:25748\n4090#1:25749\n4101#1:25750,3\n4115#1:25753,3\n4129#1:25756,3\n4143#1:25759,3\n4157#1:25762,3\n4171#1:25765,3\n4185#1:25768,3\n4199#1:25771,3\n4213#1:25774,3\n4225#1:25777,2\n4244#1:25779,2\n4253#1:25781,2\n4262#1:25783,2\n4271#1:25785,2\n4280#1:25787,2\n4289#1:25789,2\n4298#1:25791,2\n4307#1:25793,2\n4316#1:25795,2\n8903#1:25797,4\n8918#1:25801,4\n8933#1:25805,4\n8948#1:25809,4\n8963#1:25813,4\n8978#1:25817,4\n8993#1:25821,4\n9008#1:25825,4\n9023#1:25829,4\n9038#1:25833,4\n9053#1:25837,4\n9068#1:25841,4\n9083#1:25845,4\n9098#1:25849,4\n9113#1:25853,4\n9128#1:25857,4\n9143#1:25861,4\n9158#1:25865,4\n9172#1:25869,4\n9186#1:25873,4\n9200#1:25877,4\n9214#1:25881,4\n9228#1:25885,4\n9242#1:25889,4\n9256#1:25893,4\n9270#1:25897,4\n9284#1:25901,4\n9723#1:25905,4\n10468#1:25909,5\n10477#1:25914,5\n10486#1:25919,5\n10495#1:25924,5\n10504#1:25929,5\n10513#1:25934,5\n10522#1:25939,5\n10531#1:25944,5\n10540#1:25949,5\n10553#1:25954,5\n11009#1:25959,3\n11009#1:25969,3\n11021#1:25972,3\n11021#1:25982,3\n11033#1:25985,3\n11033#1:25995,3\n11045#1:25998,3\n11045#1:26008,3\n11057#1:26011,3\n11057#1:26021,3\n11069#1:26024,3\n11069#1:26034,3\n11081#1:26037,3\n11081#1:26047,3\n11093#1:26050,3\n11093#1:26060,3\n11105#1:26063,3\n11105#1:26073,3\n11118#1:26076,3\n11118#1:26086,3\n11131#1:26089,3\n11131#1:26099,3\n11144#1:26102,3\n11144#1:26112,3\n11157#1:26115,3\n11157#1:26125,3\n11170#1:26128,3\n11170#1:26138,3\n11183#1:26141,3\n11183#1:26151,3\n11196#1:26154,3\n11196#1:26164,3\n11209#1:26167,3\n11209#1:26177,3\n11222#1:26180,3\n11222#1:26190,3\n11561#1:26319,3\n11571#1:26322,3\n11581#1:26325,3\n11591#1:26328,3\n11601#1:26331,3\n11611#1:26334,3\n11621#1:26337,3\n11631#1:26340,3\n11641#1:26343,3\n11651#1:26346,4\n11661#1:26350,4\n11671#1:26354,4\n11681#1:26358,4\n11691#1:26362,4\n11701#1:26366,4\n11711#1:26370,4\n11721#1:26374,4\n11731#1:26378,4\n11741#1:26382\n11741#1:26383,2\n11741#1:26386\n11741#1:26387\n11751#1:26388,3\n11879#1:26391\n11879#1:26392\n11879#1:26394\n11879#1:26395\n11887#1:26396,2\n20159#1:26398,3\n20171#1:26401,3\n20183#1:26404,3\n20195#1:26407,3\n20207#1:26410,3\n20219#1:26413,3\n20231#1:26416,3\n20243#1:26419,3\n20255#1:26422,3\n22703#1:26425,2\n22703#1:26428,6\n22856#1:26434,2\n22856#1:26437,6\n24121#1:26443,6\n24131#1:26449,6\n24141#1:26455,6\n24151#1:26461,6\n24161#1:26467,6\n24171#1:26473,6\n24181#1:26479,6\n24191#1:26485,6\n24201#1:26491,6\n24355#1:26497,8\n24365#1:26505,8\n24375#1:26513,8\n24385#1:26521,8\n24395#1:26529,8\n24405#1:26537,8\n24415#1:26545,8\n24425#1:26553,8\n24435#1:26561,8\n24607#1:26569,6\n24617#1:26575,6\n24627#1:26581,6\n24637#1:26587,6\n24647#1:26593,6\n24657#1:26599,6\n24667#1:26605,6\n24677#1:26611,6\n11741#1:26385\n11879#1:26393\n22703#1:26427\n22856#1:26436\n11009#1:25962,7\n11021#1:25975,7\n11033#1:25988,7\n11045#1:26001,7\n11057#1:26014,7\n11069#1:26027,7\n11081#1:26040,7\n11093#1:26053,7\n11105#1:26066,7\n11118#1:26079,7\n11131#1:26092,7\n11144#1:26105,7\n11157#1:26118,7\n11170#1:26131,7\n11183#1:26144,7\n11196#1:26157,7\n11209#1:26170,7\n11222#1:26183,7\n11236#1:26193,7\n11253#1:26200,7\n11270#1:26207,7\n11287#1:26214,7\n11304#1:26221,7\n11321#1:26228,7\n11338#1:26235,7\n11355#1:26242,7\n11372#1:26249,7\n11390#1:26256,7\n11408#1:26263,7\n11426#1:26270,7\n11444#1:26277,7\n11462#1:26284,7\n11480#1:26291,7\n11498#1:26298,7\n11516#1:26305,7\n11534#1:26312,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class a0 extends kotlin.collections.q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25143#2:71\n*E\n"})
    public static final class a<T> implements Iterable<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f43579a;

        public a(Object[] objArr) {
            this.f43579a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.h.a(this.f43579a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25151#2:71\n*E\n"})
    public static final class b implements Iterable<Byte>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f43580a;

        public b(byte[] bArr) {
            this.f43580a = bArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.i.b(this.f43580a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25159#2:71\n*E\n"})
    public static final class c implements Iterable<Short>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f43581a;

        public c(short[] sArr) {
            this.f43581a = sArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.i.h(this.f43581a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25167#2:71\n*E\n"})
    public static final class d implements Iterable<Integer>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f43582a;

        public d(int[] iArr) {
            this.f43582a = iArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.i.f(this.f43582a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25175#2:71\n*E\n"})
    public static final class e implements Iterable<Long>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f43583a;

        public e(long[] jArr) {
            this.f43583a = jArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.i.g(this.f43583a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25183#2:71\n*E\n"})
    public static final class f implements Iterable<Float>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f43584a;

        public f(float[] fArr) {
            this.f43584a = fArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.i.e(this.f43584a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25191#2:71\n*E\n"})
    public static final class g implements Iterable<Double>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double[] f43585a;

        public g(double[] dArr) {
            this.f43585a = dArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.i.d(this.f43585a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25199#2:71\n*E\n"})
    public static final class h implements Iterable<Boolean>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f43586a;

        public h(boolean[] zArr) {
            this.f43586a = zArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.i.a(this.f43586a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n25207#2:71\n*E\n"})
    public static final class i implements Iterable<Character>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f43587a;

        public i(char[] cArr) {
            this.f43587a = cArr;
        }

        @Override // java.lang.Iterable
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.i.c(this.f43587a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25217#2:732\n*E\n"})
    public static final class j<T> implements kotlin.sequences.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f43588a;

        public j(Object[] objArr) {
            this.f43588a = objArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.h.a(this.f43588a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25227#2:732\n*E\n"})
    public static final class k implements kotlin.sequences.m<Byte> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f43589a;

        public k(byte[] bArr) {
            this.f43589a = bArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.i.b(this.f43589a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25237#2:732\n*E\n"})
    public static final class l implements kotlin.sequences.m<Short> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f43590a;

        public l(short[] sArr) {
            this.f43590a = sArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.i.h(this.f43590a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25247#2:732\n*E\n"})
    public static final class m implements kotlin.sequences.m<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f43591a;

        public m(int[] iArr) {
            this.f43591a = iArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.i.f(this.f43591a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25257#2:732\n*E\n"})
    public static final class n implements kotlin.sequences.m<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f43592a;

        public n(long[] jArr) {
            this.f43592a = jArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.i.g(this.f43592a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25267#2:732\n*E\n"})
    public static final class o implements kotlin.sequences.m<Float> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f43593a;

        public o(float[] fArr) {
            this.f43593a = fArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.i.e(this.f43593a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25277#2:732\n*E\n"})
    public static final class p implements kotlin.sequences.m<Double> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double[] f43594a;

        public p(double[] dArr) {
            this.f43594a = dArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.i.d(this.f43594a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25287#2:732\n*E\n"})
    public static final class q implements kotlin.sequences.m<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f43595a;

        public q(boolean[] zArr) {
            this.f43595a = zArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.i.a(this.f43595a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,731:1\n25297#2:732\n*E\n"})
    public static final class r implements kotlin.sequences.m<Character> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f43596a;

        public r(char[] cArr) {
            this.f43596a = cArr;
        }

        @Override // kotlin.sequences.m
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.i.c(this.f43596a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt$groupingBy$1\n*L\n1#1,25600:1\n*E\n"})
    public static final class s<K, T> implements w0<T, K> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ T[] f43597a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<T, K> f43598b;

        /* JADX WARN: Multi-variable type inference failed */
        public s(T[] tArr, Function1<? super T, ? extends K> function1) {
            this.f43597a = tArr;
            this.f43598b = function1;
        }

        @Override // kotlin.collections.w0
        public K a(T t5) {
            return this.f43598b.invoke(t5);
        }

        @Override // kotlin.collections.w0
        public Iterator<T> b() {
            return kotlin.jvm.internal.h.a(this.f43597a);
        }
    }

    public static boolean A5(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M A6(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (char c6 : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c6)), valueTransform.invoke(Character.valueOf(c6)));
        }
        return destination;
    }

    @JvmName(name = "averageOfLong")
    public static final double A7(@NotNull Long[] lArr) {
        kotlin.jvm.internal.g0.p(lArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (Long l6 : lArr) {
            d6 += l6.longValue();
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    public static boolean A8(@NotNull long[] jArr, long j6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return ag(jArr, j6) >= 0;
    }

    @NotNull
    public static final List<Float> A9(@NotNull float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (i6 >= 0) {
            return ay(fArr, kotlin.ranges.t.u(fArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> AA(@NotNull double[] dArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            double d6 = dArr[i6];
            arrayList.add(kotlin.o0.a(Double.valueOf(d6), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> Aa(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                arrayList.add(Character.valueOf(c6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C Ab(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                destination.add(Integer.valueOf(i6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Float Ac(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return Float.valueOf(f6);
            }
        }
        return null;
    }

    public static final <R> R Ad(@NotNull float[] fArr, R r5, @NotNull Function2<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (float f6 : fArr) {
            r5 = operation.invoke(r5, Float.valueOf(f6));
        }
        return r5;
    }

    @NotNull
    public static final kotlin.ranges.m Ae(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return new kotlin.ranges.m(0, Je(cArr));
    }

    @NotNull
    public static final <K> Map<K, List<Boolean>> Af(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z5 : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z5));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z5));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Set<Integer> Ag(@NotNull int[] iArr, @NotNull Iterable<Integer> other) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Integer> uz = uz(iArr);
        m0.T0(uz, other);
        return uz;
    }

    public static /* synthetic */ String Ah(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return rh(dArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <R> List<R> Ai(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b6 : bArr) {
            arrayList.add(transform.invoke(Byte.valueOf(b6)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> float Aj(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        if (Le != 0) {
            R invoke = selector.invoke(Float.valueOf(f6));
            int i6 = 1;
            if (1 <= Le) {
                while (true) {
                    float f7 = fArr[i6];
                    R invoke2 = selector.invoke(Float.valueOf(f7));
                    if (invoke.compareTo(invoke2) < 0) {
                        f6 = f7;
                        invoke = invoke2;
                    }
                    if (i6 == Le) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Ak(char[] cArr, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(cArr[i6])).floatValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long Al(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) < 0) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Am(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T extends Comparable<? super T>> T An(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (t5.compareTo(t6) > 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    public static final boolean Ao(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Character Ap(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return Bp(cArr, Random.Default);
    }

    public static final double Aq(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ke = Ke(dArr);
        if (Ke < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double d6 = dArr[Ke];
        for (int i6 = Ke - 1; i6 >= 0; i6--) {
            d6 = operation.invoke(Double.valueOf(dArr[i6]), Double.valueOf(d6)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Ar(@NotNull boolean[] zArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, zArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            boolean z5 = zArr[i6];
            zArr[i6] = zArr[i9];
            zArr[i9] = z5;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <S, T extends S> List<S> As(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return h0.J();
        }
        S s5 = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s5);
        int length = tArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            s5 = operation.invoke(Integer.valueOf(i6), s5, (Object) tArr[i6]);
            arrayList.add(s5);
        }
        return arrayList;
    }

    public static <T> T At(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static long[] Au(@NotNull long[] jArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            jArr2[i6] = jArr[it.next().intValue()];
            i6++;
        }
        return jArr2;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> Av(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return aw(cArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int Aw(@NotNull float[] fArr, @NotNull Function1<? super Float, Integer> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (float f6 : fArr) {
            i6 += selector.invoke(Float.valueOf(f6)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int Ax(int[] iArr, Function1<? super Integer, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (int i6 : iArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Integer.valueOf(i6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final byte[] Ay(@NotNull Byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr2[i6] = bArr[i6].byteValue();
        }
        return bArr2;
    }

    @NotNull
    public static final Set<Character> Az(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? (Set) Dy(cArr, new LinkedHashSet(k1.j(kotlin.ranges.t.B(cArr.length, 128)))) : v1.f(Character.valueOf(cArr[0])) : w1.k();
    }

    public static final boolean B5(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Double>> M B6(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (double d6 : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d6)), Double.valueOf(d6));
        }
        return destination;
    }

    @JvmName(name = "averageOfShort")
    public static final double B7(@NotNull Short[] shArr) {
        kotlin.jvm.internal.g0.p(shArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (Short sh : shArr) {
            d6 += sh.shortValue();
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    public static <T> boolean B8(@NotNull T[] tArr, T t5) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return bg(tArr, t5) >= 0;
    }

    @NotNull
    public static final List<Integer> B9(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (i6 >= 0) {
            return cy(iArr, kotlin.ranges.t.u(iArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, V> List<V> BA(@NotNull double[] dArr, @NotNull R[] other, @NotNull Function2<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> Ba(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                arrayList.add(Double.valueOf(d6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C Bb(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                destination.add(Long.valueOf(j6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Integer Bc(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static final <R> R Bd(@NotNull int[] iArr, R r5, @NotNull Function2<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int i6 : iArr) {
            r5 = operation.invoke(r5, Integer.valueOf(i6));
        }
        return r5;
    }

    @NotNull
    public static final kotlin.ranges.m Be(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return new kotlin.ranges.m(0, Ke(dArr));
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> Bf(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z5 : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z5));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Boolean.valueOf(z5)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Set<Long> Bg(@NotNull long[] jArr, @NotNull Iterable<Long> other) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Long> vz = vz(jArr);
        m0.T0(vz, other);
        return vz;
    }

    public static /* synthetic */ String Bh(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return sh(fArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <R> List<R> Bi(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c6 : cArr) {
            arrayList.add(transform.invoke(Character.valueOf(c6)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> int Bj(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        if (Me != 0) {
            R invoke = selector.invoke(Integer.valueOf(i6));
            int i7 = 1;
            if (1 <= Me) {
                while (true) {
                    int i8 = iArr[i7];
                    R invoke2 = selector.invoke(Integer.valueOf(i8));
                    if (invoke.compareTo(invoke2) < 0) {
                        i6 = i8;
                        invoke = invoke2;
                    }
                    if (i7 == Me) {
                        break;
                    }
                    i7++;
                }
            }
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Bk(double[] dArr, Function1<? super Double, Float> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Double.valueOf(dArr[i6])).floatValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T Bl(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (comparator.compare(t5, t6) < 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Bm(long[] jArr, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double Bn(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = Math.min(d6, dArr[i6]);
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    public static final boolean Bo(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character Bp(@NotNull char[] cArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.nextInt(cArr.length)]);
    }

    public static final float Bq(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Le = Le(fArr);
        if (Le < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float f6 = fArr[Le];
        for (int i6 = Le - 1; i6 >= 0; i6--) {
            f6 = operation.invoke(Float.valueOf(fArr[i6]), Float.valueOf(f6)).floatValue();
        }
        return f6;
    }

    @NotNull
    public static final List<Byte> Br(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return h0.J();
        }
        List<Byte> hz = hz(bArr);
        o0.t1(hz);
        return hz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Short> Bs(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return h0.J();
        }
        short s5 = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(s5));
        int length = sArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            s5 = operation.invoke(Integer.valueOf(i6), Short.valueOf(s5), Short.valueOf(sArr[i6])).shortValue();
            arrayList.add(Short.valueOf(s5));
        }
        return arrayList;
    }

    public static final <T> T Bt(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        boolean z5 = false;
        for (T t6 : tArr) {
            if (predicate.invoke(t6).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                t5 = t6;
                z5 = true;
            }
        }
        if (z5) {
            return t5;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static long[] Bu(@NotNull long[] jArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new long[0] : kotlin.collections.q.k1(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> Bv(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return bw(dArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int Bw(@NotNull int[] iArr, @NotNull Function1<? super Integer, Integer> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (int i7 : iArr) {
            i6 += selector.invoke(Integer.valueOf(i7)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int Bx(long[] jArr, Function1<? super Long, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (long j6 : jArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Long.valueOf(j6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final char[] By(@NotNull Character[] chArr) {
        kotlin.jvm.internal.g0.p(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i6 = 0; i6 < length; i6++) {
            cArr[i6] = chArr[i6].charValue();
        }
        return cArr;
    }

    @NotNull
    public static final Set<Double> Bz(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? (Set) Ey(dArr, new LinkedHashSet(k1.j(dArr.length))) : v1.f(Double.valueOf(dArr[0])) : w1.k();
    }

    public static final boolean C5(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M C6(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (double d6 : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d6)), valueTransform.invoke(Double.valueOf(d6)));
        }
        return destination;
    }

    @InlineOnly
    private static final byte C7(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr[0];
    }

    public static boolean C8(@NotNull short[] sArr, short s5) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return cg(sArr, s5) >= 0;
    }

    @NotNull
    public static final List<Long> C9(@NotNull long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (i6 >= 0) {
            return dy(jArr, kotlin.ranges.t.u(jArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> CA(@NotNull float[] fArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Float.valueOf(fArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> Ca(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C Cb(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                destination.add(t5);
            }
        }
        return destination;
    }

    @Nullable
    public static final Integer Cc(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                return Integer.valueOf(i6);
            }
        }
        return null;
    }

    public static final <R> R Cd(@NotNull long[] jArr, R r5, @NotNull Function2<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (long j6 : jArr) {
            r5 = operation.invoke(r5, Long.valueOf(j6));
        }
        return r5;
    }

    @NotNull
    public static final kotlin.ranges.m Ce(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return new kotlin.ranges.m(0, Le(fArr));
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Byte>>> M Cf(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (byte b6 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b6));
        }
        return destination;
    }

    @NotNull
    public static final <T> Set<T> Cg(@NotNull T[] tArr, @NotNull Iterable<? extends T> other) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<T> wz = wz(tArr);
        m0.T0(wz, other);
        return wz;
    }

    public static /* synthetic */ String Ch(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return th(iArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <R> List<R> Ci(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d6 : dArr) {
            arrayList.add(transform.invoke(Double.valueOf(d6)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> long Cj(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        if (Ne != 0) {
            R invoke = selector.invoke(Long.valueOf(j6));
            int i6 = 1;
            if (1 <= Ne) {
                while (true) {
                    long j7 = jArr[i6];
                    R invoke2 = selector.invoke(Long.valueOf(j7));
                    if (invoke.compareTo(invoke2) < 0) {
                        j6 = j7;
                        invoke = invoke2;
                    }
                    if (i6 == Ne) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Ck(float[] fArr, Function1<? super Float, Float> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Float.valueOf(fArr[i6])).floatValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short Cl(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (comparator.compare(Short.valueOf(s5), Short.valueOf(s6)) < 0) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R Cm(T[] tArr, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                R invoke2 = selector.invoke(tArr[i6]);
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double Cn(@NotNull Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        int Oe = Oe(dArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.min(doubleValue, dArr[i6].doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    public static final boolean Co(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Double Cp(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return Dp(dArr, Random.Default);
    }

    public static final int Cq(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Me = Me(iArr);
        if (Me < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int i6 = iArr[Me];
        for (int i7 = Me - 1; i7 >= 0; i7--) {
            i6 = operation.invoke(Integer.valueOf(iArr[i7]), Integer.valueOf(i6)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Character> Cr(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return h0.J();
        }
        List<Character> iz = iz(cArr);
        o0.t1(iz);
        return iz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Boolean> Cs(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return h0.J();
        }
        boolean z5 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z5));
        int length = zArr.length;
        int i6 = 1;
        while (i6 < length) {
            Boolean invoke = operation.invoke(Integer.valueOf(i6), Boolean.valueOf(z5), Boolean.valueOf(zArr[i6]));
            boolean booleanValue = invoke.booleanValue();
            arrayList.add(invoke);
            i6++;
            z5 = booleanValue;
        }
        return arrayList;
    }

    public static short Ct(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final <T> T[] Cu(@NotNull T[] tArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        T[] tArr2 = (T[]) kotlin.collections.o.a(tArr, indices.size());
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            tArr2[i6] = tArr[it.next().intValue()];
            i6++;
        }
        return tArr2;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> Cv(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return cw(fArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int Cw(@NotNull long[] jArr, @NotNull Function1<? super Long, Integer> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (long j6 : jArr) {
            i6 += selector.invoke(Long.valueOf(j6)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final <T> int Cx(T[] tArr, Function1<? super T, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (T t5 : tArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(t5).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C Cy(@NotNull byte[] bArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (byte b6 : bArr) {
            destination.add(Byte.valueOf(b6));
        }
        return destination;
    }

    @NotNull
    public static final Set<Float> Cz(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? (Set) Fy(fArr, new LinkedHashSet(k1.j(fArr.length))) : v1.f(Float.valueOf(fArr[0])) : w1.k();
    }

    public static final boolean D5(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Float>> M D6(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (float f6 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f6)), Float.valueOf(f6));
        }
        return destination;
    }

    @InlineOnly
    private static final char D7(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr[0];
    }

    public static final boolean D8(@NotNull boolean[] zArr, boolean z5) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return dg(zArr, z5) >= 0;
    }

    @NotNull
    public static <T> List<T> D9(@NotNull T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (i6 >= 0) {
            return ey(tArr, kotlin.ranges.t.u(tArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, V> List<V> DA(@NotNull float[] fArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Float.valueOf(fArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> Da(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C Db(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                destination.add(Short.valueOf(s5));
            }
        }
        return destination;
    }

    @Nullable
    public static final Long Dc(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Dd(@NotNull T[] tArr, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (H5BaseWebChromeClient h5BaseWebChromeClient : tArr) {
            r5 = operation.invoke(r5, h5BaseWebChromeClient);
        }
        return r5;
    }

    @NotNull
    public static kotlin.ranges.m De(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return new kotlin.ranges.m(0, Me(iArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Df(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (byte b6 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Byte.valueOf(b6)));
        }
        return destination;
    }

    @NotNull
    public static final Set<Short> Dg(@NotNull short[] sArr, @NotNull Iterable<Short> other) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Short> xz = xz(sArr);
        m0.T0(xz, other);
        return xz;
    }

    public static /* synthetic */ String Dh(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return uh(jArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <R> List<R> Di(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f6 : fArr) {
            arrayList.add(transform.invoke(Float.valueOf(f6)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T Dj(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        if (Oe != 0) {
            R invoke = selector.invoke(t5);
            int i6 = 1;
            if (1 <= Oe) {
                while (true) {
                    T t6 = tArr[i6];
                    R invoke2 = selector.invoke(t6);
                    if (invoke.compareTo(invoke2) < 0) {
                        t5 = t6;
                        invoke = invoke2;
                    }
                    if (i6 == Oe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Dk(int[] iArr, Function1<? super Integer, Float> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Integer.valueOf(iArr[i6])).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final byte Dl(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (comparator.compare(Byte.valueOf(b6), Byte.valueOf(b7)) < 0) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Dm(short[] sArr, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float Dn(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = Math.min(f6, fArr[i6]);
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final byte[] Do(byte[] bArr, Function1<? super Byte, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (byte b6 : bArr) {
            action.invoke(Byte.valueOf(b6));
        }
        return bArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double Dp(@NotNull double[] dArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.nextInt(dArr.length)]);
    }

    public static final long Dq(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ne = Ne(jArr);
        if (Ne < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long j6 = jArr[Ne];
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            j6 = operation.invoke(Long.valueOf(jArr[i6]), Long.valueOf(j6)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Double> Dr(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return h0.J();
        }
        List<Double> jz = jz(dArr);
        o0.t1(jz);
        return jz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ds(byte[] bArr, R r5, Function2<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r5);
        for (byte b6 : bArr) {
            r5 = operation.invoke(r5, Byte.valueOf(b6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    public static final short Dt(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Short sh = null;
        boolean z5 = false;
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                sh = Short.valueOf(s5);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(sh, "null cannot be cast to non-null type kotlin.Short");
        return sh.shortValue();
    }

    @NotNull
    public static final <T> T[] Du(@NotNull T[] tArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? (T[]) kotlin.collections.q.l1(tArr, 0, 0) : (T[]) kotlin.collections.q.l1(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> Dv(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return dw(iArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int Dw(@NotNull T[] tArr, @NotNull Function1<? super T, Integer> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (T t5 : tArr) {
            i6 += selector.invoke(t5).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int Dx(short[] sArr, Function1<? super Short, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (short s5 : sArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Short.valueOf(s5)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C Dy(@NotNull char[] cArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (char c6 : cArr) {
            destination.add(Character.valueOf(c6));
        }
        return destination;
    }

    @NotNull
    public static final Set<Integer> Dz(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? (Set) Gy(iArr, new LinkedHashSet(k1.j(iArr.length))) : v1.f(Integer.valueOf(iArr[0])) : w1.k();
    }

    @NotNull
    public static final Iterable<Byte> E5(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr.length == 0 ? h0.J() : new b(bArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M E6(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (float f6 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f6)), valueTransform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    @InlineOnly
    private static final double E7(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr[0];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final byte[] E8(byte[] bArr, int i6, Function1<? super Integer, Byte> init) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        byte[] copyOf = Arrays.copyOf(bArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = bArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).byteValue();
        }
        return copyOf;
    }

    @NotNull
    public static final List<Short> E9(@NotNull short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (i6 >= 0) {
            return fy(sArr, kotlin.ranges.t.u(sArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final List<Pair<Float, Float>> EA(@NotNull float[] fArr, @NotNull float[] other) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Float.valueOf(fArr[i6]), Float.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> Ea(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C Eb(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                destination.add(Boolean.valueOf(z5));
            }
        }
        return destination;
    }

    @Nullable
    public static final Long Ec(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return Long.valueOf(j6);
            }
        }
        return null;
    }

    public static final <R> R Ed(@NotNull short[] sArr, R r5, @NotNull Function2<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (short s5 : sArr) {
            r5 = operation.invoke(r5, Short.valueOf(s5));
        }
        return r5;
    }

    @NotNull
    public static kotlin.ranges.m Ee(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return new kotlin.ranges.m(0, Ne(jArr));
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Character>>> M Ef(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (char c6 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c6));
        }
        return destination;
    }

    @NotNull
    public static final Set<Boolean> Eg(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> other) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Boolean> yz = yz(zArr);
        m0.T0(yz, other);
        return yz;
    }

    public static /* synthetic */ String Eh(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return vh(objArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <R> List<R> Ei(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i6 : iArr) {
            arrayList.add(transform.invoke(Integer.valueOf(i6)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> short Ej(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        if (Pe != 0) {
            R invoke = selector.invoke(Short.valueOf(s5));
            int i6 = 1;
            if (1 <= Pe) {
                while (true) {
                    short s6 = sArr[i6];
                    R invoke2 = selector.invoke(Short.valueOf(s6));
                    if (invoke.compareTo(invoke2) < 0) {
                        s5 = s6;
                        invoke = invoke2;
                    }
                    if (i6 == Pe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Ek(long[] jArr, Function1<? super Long, Float> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Long.valueOf(jArr[i6])).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final char El(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (comparator.compare(Character.valueOf(c6), Character.valueOf(c7)) < 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return c6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Em(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float En(@NotNull Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        int Oe = Oe(fArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.min(floatValue, fArr[i6].floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final char[] Eo(char[] cArr, Function1<? super Character, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (char c6 : cArr) {
            action.invoke(Character.valueOf(c6));
        }
        return cArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Float Ep(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return Fp(fArr, Random.Default);
    }

    public static final <S, T extends S> S Eq(@NotNull T[] tArr, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Oe = Oe(tArr);
        if (Oe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s5 = (S) tArr[Oe];
        for (int i6 = Oe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke((Object) tArr[i6], s5);
        }
        return s5;
    }

    @NotNull
    public static final List<Float> Er(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return h0.J();
        }
        List<Float> kz = kz(fArr);
        o0.t1(kz);
        return kz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Es(char[] cArr, R r5, Function2<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r5);
        for (char c6 : cArr) {
            r5 = operation.invoke(r5, Character.valueOf(c6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    public static final boolean Et(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static short[] Eu(@NotNull short[] sArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            sArr2[i6] = sArr[it.next().intValue()];
            i6++;
        }
        return sArr2;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> Ev(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return ew(jArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int Ew(@NotNull short[] sArr, @NotNull Function1<? super Short, Integer> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (short s5 : sArr) {
            i6 += selector.invoke(Short.valueOf(s5)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int Ex(boolean[] zArr, Function1<? super Boolean, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (boolean z5 : zArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Boolean.valueOf(z5)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C Ey(@NotNull double[] dArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (double d6 : dArr) {
            destination.add(Double.valueOf(d6));
        }
        return destination;
    }

    @NotNull
    public static final Set<Long> Ez(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? (Set) Hy(jArr, new LinkedHashSet(k1.j(jArr.length))) : v1.f(Long.valueOf(jArr[0])) : w1.k();
    }

    @NotNull
    public static final Iterable<Character> F5(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr.length == 0 ? h0.J() : new i(cArr);
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Integer>> M F6(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (int i6 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i6)), Integer.valueOf(i6));
        }
        return destination;
    }

    @InlineOnly
    private static final float F7(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr[0];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final char[] F8(char[] cArr, int i6, Function1<? super Integer, Character> init) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        char[] copyOf = Arrays.copyOf(cArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = cArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).charValue();
        }
        return copyOf;
    }

    @NotNull
    public static final List<Boolean> F9(@NotNull boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (i6 >= 0) {
            return gy(zArr, kotlin.ranges.t.u(zArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <V> List<V> FA(@NotNull float[] fArr, @NotNull float[] other, @NotNull Function2<? super Float, ? super Float, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i6]), Float.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> Fa(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    @InlineOnly
    private static final Boolean Fb(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return Boolean.valueOf(z5);
            }
        }
        return null;
    }

    @Nullable
    public static <T> T Fc(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <R> R Fd(@NotNull boolean[] zArr, R r5, @NotNull Function2<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (boolean z5 : zArr) {
            r5 = operation.invoke(r5, Boolean.valueOf(z5));
        }
        return r5;
    }

    @NotNull
    public static final <T> kotlin.ranges.m Fe(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return new kotlin.ranges.m(0, Oe(tArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Ff(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (char c6 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(c6)));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Fg(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    public static /* synthetic */ String Fh(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return wh(sArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <R> List<R> Fi(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j6 : jArr) {
            arrayList.add(transform.invoke(Long.valueOf(j6)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> boolean Fj(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        if (Qe != 0) {
            R invoke = selector.invoke(Boolean.valueOf(z5));
            int i6 = 1;
            if (1 <= Qe) {
                while (true) {
                    boolean z6 = zArr[i6];
                    R invoke2 = selector.invoke(Boolean.valueOf(z6));
                    if (invoke.compareTo(invoke2) < 0) {
                        z5 = z6;
                        invoke = invoke2;
                    }
                    if (i6 == Qe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return z5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Float Fk(T[] tArr, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(tArr[i6]).floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final double Fl(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                if (comparator.compare(Double.valueOf(d6), Double.valueOf(d7)) < 0) {
                    d6 = d7;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Fm(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer Fn(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (i6 > i8) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final double[] Fo(double[] dArr, Function1<? super Double, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (double d6 : dArr) {
            action.invoke(Double.valueOf(d6));
        }
        return dArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float Fp(@NotNull float[] fArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.nextInt(fArr.length)]);
    }

    public static final short Fq(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Pe = Pe(sArr);
        if (Pe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s5 = sArr[Pe];
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke(Short.valueOf(sArr[i6]), Short.valueOf(s5)).shortValue();
        }
        return s5;
    }

    @NotNull
    public static final List<Integer> Fr(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return h0.J();
        }
        List<Integer> lz = lz(iArr);
        o0.t1(lz);
        return lz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Fs(double[] dArr, R r5, Function2<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r5);
        for (double d6 : dArr) {
            r5 = operation.invoke(r5, Double.valueOf(d6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    public static final boolean Ft(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Boolean bool = null;
        boolean z5 = false;
        for (boolean z6 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z6)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                bool = Boolean.valueOf(z6);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(bool, "null cannot be cast to non-null type kotlin.Boolean");
        return bool.booleanValue();
    }

    @NotNull
    public static short[] Fu(@NotNull short[] sArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new short[0] : kotlin.collections.q.m1(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> Fv(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return fw(tArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int Fw(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (boolean z5 : zArr) {
            i6 += selector.invoke(Boolean.valueOf(z5)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Fx(byte[] bArr, Function1<? super Byte, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (byte b6 : bArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Byte.valueOf(b6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C Fy(@NotNull float[] fArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (float f6 : fArr) {
            destination.add(Float.valueOf(f6));
        }
        return destination;
    }

    @NotNull
    public static <T> Set<T> Fz(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) Iy(tArr, new LinkedHashSet(k1.j(tArr.length))) : v1.f(tArr[0]) : w1.k();
    }

    @NotNull
    public static final Iterable<Double> G5(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr.length == 0 ? h0.J() : new g(dArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M G6(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (int i6 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i6)), valueTransform.invoke(Integer.valueOf(i6)));
        }
        return destination;
    }

    @InlineOnly
    private static final int G7(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr[0];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final double[] G8(double[] dArr, int i6, Function1<? super Integer, Double> init) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        double[] copyOf = Arrays.copyOf(dArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = dArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).doubleValue();
        }
        return copyOf;
    }

    @NotNull
    public static final List<Byte> G9(@NotNull byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (i6 >= 0) {
            return Ox(bArr, kotlin.ranges.t.u(bArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> GA(@NotNull float[] fArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            float f6 = fArr[i6];
            arrayList.add(kotlin.o0.a(Float.valueOf(f6), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> Ga(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                arrayList.add(Short.valueOf(s5));
            }
        }
        return arrayList;
    }

    @InlineOnly
    private static final Byte Gb(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return Byte.valueOf(b6);
            }
        }
        return null;
    }

    @Nullable
    public static final <T> T Gc(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        return null;
    }

    public static final <R> R Gd(@NotNull byte[] bArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Byte.valueOf(bArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    @NotNull
    public static kotlin.ranges.m Ge(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return new kotlin.ranges.m(0, Pe(sArr));
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Double>>> M Gf(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (double d6 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d6));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Gg(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    public static /* synthetic */ String Gh(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return xh(zArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @NotNull
    public static final <T, R> List<R> Gi(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t5 : tArr) {
            arrayList.add(transform.invoke(t5));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Gj(byte[] bArr, Function1<? super Byte, Double> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Byte.valueOf(bArr[i6])).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Gk(short[] sArr, Function1<? super Short, Float> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Short.valueOf(sArr[i6])).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final float Gl(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) < 0) {
                    f6 = f7;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Gm(char[] cArr, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long Gn(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (j6 > j7) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final float[] Go(float[] fArr, Function1<? super Float, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (float f6 : fArr) {
            action.invoke(Float.valueOf(f6));
        }
        return fArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Integer Gp(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return Hp(iArr, Random.Default);
    }

    public static final boolean Gq(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Qe = Qe(zArr);
        if (Qe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z5 = zArr[Qe];
        for (int i6 = Qe - 1; i6 >= 0; i6--) {
            z5 = operation.invoke(Boolean.valueOf(zArr[i6]), Boolean.valueOf(z5)).booleanValue();
        }
        return z5;
    }

    @NotNull
    public static final List<Long> Gr(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return h0.J();
        }
        List<Long> mz = mz(jArr);
        o0.t1(mz);
        return mz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Gs(float[] fArr, R r5, Function2<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r5);
        for (float f6 : fArr) {
            r5 = operation.invoke(r5, Float.valueOf(f6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Boolean Gt(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    @NotNull
    public static final boolean[] Gu(@NotNull boolean[] zArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            zArr2[i6] = zArr[it.next().intValue()];
            i6++;
        }
        return zArr2;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> Gv(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return gw(sArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Gw(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Double> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (byte b6 : bArr) {
            d6 += selector.invoke(Byte.valueOf(b6)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Gx(char[] cArr, Function1<? super Character, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (char c6 : cArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Character.valueOf(c6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C Gy(@NotNull int[] iArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (int i6 : iArr) {
            destination.add(Integer.valueOf(i6));
        }
        return destination;
    }

    @NotNull
    public static final Set<Short> Gz(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? (Set) Jy(sArr, new LinkedHashSet(k1.j(sArr.length))) : v1.f(Short.valueOf(sArr[0])) : w1.k();
    }

    @NotNull
    public static final Iterable<Float> H5(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr.length == 0 ? h0.J() : new f(fArr);
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Long>> M H6(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (long j6 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j6)), Long.valueOf(j6));
        }
        return destination;
    }

    @InlineOnly
    private static final long H7(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr[0];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final float[] H8(float[] fArr, int i6, Function1<? super Integer, Float> init) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        float[] copyOf = Arrays.copyOf(fArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = fArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).floatValue();
        }
        return copyOf;
    }

    @NotNull
    public static final List<Character> H9(@NotNull char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (i6 >= 0) {
            return Px(cArr, kotlin.ranges.t.u(cArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, V> List<V> HA(@NotNull float[] fArr, @NotNull R[] other, @NotNull Function2<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> Ha(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z5));
            }
        }
        return arrayList;
    }

    @InlineOnly
    private static final Character Hb(char[] cArr, Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return Character.valueOf(c6);
            }
        }
        return null;
    }

    @Nullable
    public static final Short Hc(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final <R> R Hd(@NotNull char[] cArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Character.valueOf(cArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    @NotNull
    public static final kotlin.ranges.m He(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return new kotlin.ranges.m(0, Qe(zArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Hf(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (double d6 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Double.valueOf(d6)));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Hg(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    public static byte Hh(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[Ie(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R> List<R> Hi(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s5 : sArr) {
            arrayList.add(transform.invoke(Short.valueOf(s5)));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Hj(char[] cArr, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(cArr[i6])).doubleValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Hk(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Boolean.valueOf(zArr[i6])).floatValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final int Hl(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (comparator.compare(Integer.valueOf(i6), Integer.valueOf(i8)) < 0) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Hm(double[] dArr, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short Hn(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (s5 > s6) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int[] Ho(int[] iArr, Function1<? super Integer, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (int i6 : iArr) {
            action.invoke(Integer.valueOf(i6));
        }
        return iArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer Hp(@NotNull int[] iArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.nextInt(iArr.length)]);
    }

    public static final byte Hq(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ie = Ie(bArr);
        if (Ie < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte b6 = bArr[Ie];
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            b6 = operation.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i6]), Byte.valueOf(b6)).byteValue();
        }
        return b6;
    }

    @NotNull
    public static final <T> List<T> Hr(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return h0.J();
        }
        List<T> nz = nz(tArr);
        o0.t1(nz);
        return nz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Hs(int[] iArr, R r5, Function2<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r5);
        for (int i6 : iArr) {
            r5 = operation.invoke(r5, Integer.valueOf(i6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Boolean Ht(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Boolean bool = null;
        boolean z5 = false;
        for (boolean z6 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z6)).booleanValue()) {
                if (z5) {
                    return null;
                }
                bool = Boolean.valueOf(z6);
                z5 = true;
            }
        }
        if (z5) {
            return bool;
        }
        return null;
    }

    @NotNull
    public static final boolean[] Hu(@NotNull boolean[] zArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new boolean[0] : kotlin.collections.q.n1(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> Hv(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return hw(zArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Hw(@NotNull char[] cArr, @NotNull Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (char c6 : cArr) {
            d6 += selector.invoke(Character.valueOf(c6)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Hx(double[] dArr, Function1<? super Double, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (double d6 : dArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Double.valueOf(d6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C Hy(@NotNull long[] jArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (long j6 : jArr) {
            destination.add(Long.valueOf(j6));
        }
        return destination;
    }

    @NotNull
    public static final Set<Boolean> Hz(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? (Set) Ky(zArr, new LinkedHashSet(k1.j(zArr.length))) : v1.f(Boolean.valueOf(zArr[0])) : w1.k();
    }

    @NotNull
    public static final Iterable<Integer> I5(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr.length == 0 ? h0.J() : new d(iArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M I6(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (long j6 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j6)), valueTransform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    @InlineOnly
    private static final <T> T I7(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr[0];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int[] I8(int[] iArr, int i6, Function1<? super Integer, Integer> init) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        int[] copyOf = Arrays.copyOf(iArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = iArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).intValue();
        }
        return copyOf;
    }

    @NotNull
    public static final List<Double> I9(@NotNull double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (i6 >= 0) {
            return Qx(dArr, kotlin.ranges.t.u(dArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> IA(@NotNull int[] iArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Integer.valueOf(iArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> Ia(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            byte b6 = bArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Byte.valueOf(b6)).booleanValue()) {
                arrayList.add(Byte.valueOf(b6));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Double Ib(double[] dArr, Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return Double.valueOf(d6);
            }
        }
        return null;
    }

    @Nullable
    public static final Short Ic(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return Short.valueOf(s5);
            }
        }
        return null;
    }

    public static final <R> R Id(@NotNull double[] dArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Double.valueOf(dArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    public static int Ie(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr.length - 1;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Float>>> M If(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (float f6 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f6));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Ig(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    public static final byte Ih(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                byte b6 = bArr[length];
                if (!predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return b6;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R> List<R> Ii(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z5 : zArr) {
            arrayList.add(transform.invoke(Boolean.valueOf(z5)));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Ij(double[] dArr, Function1<? super Double, Double> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Double.valueOf(dArr[i6])).doubleValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Ik(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final long Il(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) < 0) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Im(float[] fArr, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final byte In(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (b6 > b7) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final long[] Io(long[] jArr, Function1<? super Long, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (long j6 : jArr) {
            action.invoke(Long.valueOf(j6));
        }
        return jArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Long Ip(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return Jp(jArr, Random.Default);
    }

    public static final char Iq(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Je = Je(cArr);
        if (Je < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char c6 = cArr[Je];
        for (int i6 = Je - 1; i6 >= 0; i6--) {
            c6 = operation.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i6]), Character.valueOf(c6)).charValue();
        }
        return c6;
    }

    @NotNull
    public static final List<Short> Ir(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return h0.J();
        }
        List<Short> oz = oz(sArr);
        o0.t1(oz);
        return oz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Is(long[] jArr, R r5, Function2<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r5);
        for (long j6 : jArr) {
            r5 = operation.invoke(r5, Long.valueOf(j6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Byte It(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void Iu(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.q.h4(tArr, new g.a(selector));
        }
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> Iv(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return Zv(bArr, new g.c(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Iw(@NotNull double[] dArr, @NotNull Function1<? super Double, Double> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (double d7 : dArr) {
            d6 += selector.invoke(Double.valueOf(d7)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Ix(float[] fArr, Function1<? super Float, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (float f6 : fArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Float.valueOf(f6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C Iy(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (T t5 : tArr) {
            destination.add(t5);
        }
        return destination;
    }

    @NotNull
    public static final short[] Iz(@NotNull Short[] shArr) {
        kotlin.jvm.internal.g0.p(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i6 = 0; i6 < length; i6++) {
            sArr[i6] = shArr[i6].shortValue();
        }
        return sArr;
    }

    @NotNull
    public static final Iterable<Long> J5(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr.length == 0 ? h0.J() : new e(jArr);
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M J6(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (T t5 : tArr) {
            destination.put(keySelector.invoke(t5), t5);
        }
        return destination;
    }

    @InlineOnly
    private static final short J7(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr[0];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long[] J8(long[] jArr, int i6, Function1<? super Integer, Long> init) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        long[] copyOf = Arrays.copyOf(jArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = jArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).longValue();
        }
        return copyOf;
    }

    @NotNull
    public static final List<Float> J9(@NotNull float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (i6 >= 0) {
            return Rx(fArr, kotlin.ranges.t.u(fArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, V> List<V> JA(@NotNull int[] iArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> Ja(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            char c6 = cArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Character.valueOf(c6)).booleanValue()) {
                arrayList.add(Character.valueOf(c6));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Float Jb(float[] fArr, Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return Float.valueOf(f6);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> Jc(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b6 : bArr) {
            m0.s0(arrayList, transform.invoke(Byte.valueOf(b6)));
        }
        return arrayList;
    }

    public static final <R> R Jd(@NotNull float[] fArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Float.valueOf(fArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    public static final int Je(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Jf(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (float f6 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Jg(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    public static final char Jh(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[Je(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R> List<R> Ji(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Byte.valueOf(bArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Jj(float[] fArr, Function1<? super Float, Double> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Float.valueOf(fArr[i6])).doubleValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Jk(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final <T> T Jl(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (comparator.compare(t5, t6) < 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Jm(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final char Jn(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (kotlin.jvm.internal.g0.t(c6, c7) > 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return c6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T> T[] Jo(T[] tArr, Function1<? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (T t5 : tArr) {
            action.invoke(t5);
        }
        return tArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long Jp(@NotNull long[] jArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.nextInt(jArr.length)]);
    }

    public static final double Jq(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ke = Ke(dArr);
        if (Ke < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double d6 = dArr[Ke];
        for (int i6 = Ke - 1; i6 >= 0; i6--) {
            d6 = operation.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i6]), Double.valueOf(d6)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Boolean> Jr(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return h0.J();
        }
        List<Boolean> pz = pz(zArr);
        o0.t1(pz);
        return pz;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> Js(@NotNull T[] tArr, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r5);
        for (H5BaseWebChromeClient h5BaseWebChromeClient : tArr) {
            r5 = operation.invoke(r5, h5BaseWebChromeClient);
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Byte Jt(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Byte b6 = null;
        boolean z5 = false;
        for (byte b7 : bArr) {
            if (predicate.invoke(Byte.valueOf(b7)).booleanValue()) {
                if (z5) {
                    return null;
                }
                b6 = Byte.valueOf(b7);
                z5 = true;
            }
        }
        if (z5) {
            return b6;
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void Ju(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.q.h4(tArr, new g.c(selector));
        }
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> Jv(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return aw(cArr, new g.c(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Jw(@NotNull float[] fArr, @NotNull Function1<? super Float, Double> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (float f6 : fArr) {
            d6 += selector.invoke(Float.valueOf(f6)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Jx(int[] iArr, Function1<? super Integer, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (int i6 : iArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Integer.valueOf(i6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C Jy(@NotNull short[] sArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (short s5 : sArr) {
            destination.add(Short.valueOf(s5));
        }
        return destination;
    }

    @NotNull
    public static final Set<Byte> Jz(@NotNull byte[] bArr, @NotNull Iterable<Byte> other) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Byte> qz = qz(bArr);
        m0.s0(qz, other);
        return qz;
    }

    @NotNull
    public static <T> Iterable<T> K5(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr.length == 0 ? h0.J() : new a(tArr);
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M K6(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (T t5 : tArr) {
            destination.put(keySelector.invoke(t5), valueTransform.invoke(t5));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean K7(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr[0];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <T> T[] K8(T[] tArr, int i6, Function1<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i6);
        kotlin.jvm.internal.g0.o(tArr2, "copyOf(...)");
        for (int length = tArr.length; length < i6; length++) {
            tArr2[length] = init.invoke(Integer.valueOf(length));
        }
        return tArr2;
    }

    @NotNull
    public static final List<Integer> K9(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (i6 >= 0) {
            return Sx(iArr, kotlin.ranges.t.u(iArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final List<Pair<Integer, Integer>> KA(@NotNull int[] iArr, @NotNull int[] other) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Integer.valueOf(iArr[i6]), Integer.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> Ka(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            double d6 = dArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Double.valueOf(d6)).booleanValue()) {
                arrayList.add(Double.valueOf(d6));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Integer Kb(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                return Integer.valueOf(i6);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> Kc(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c6 : cArr) {
            m0.s0(arrayList, transform.invoke(Character.valueOf(c6)));
        }
        return arrayList;
    }

    public static final <R> R Kd(@NotNull int[] iArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Integer.valueOf(iArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    public static final int Ke(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr.length - 1;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Integer>>> M Kf(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (int i6 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i6));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Kg(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    public static final char Kh(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                char c6 = cArr[length];
                if (!predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return c6;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R> List<R> Ki(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Character.valueOf(cArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Kj(int[] iArr, Function1<? super Integer, Double> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Integer.valueOf(iArr[i6])).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Kk(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final short Kl(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (comparator.compare(Short.valueOf(s5), Short.valueOf(s6)) < 0) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Km(long[] jArr, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double Kn(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = Math.min(d6, dArr[i6]);
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final short[] Ko(short[] sArr, Function1<? super Short, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (short s5 : sArr) {
            action.invoke(Short.valueOf(s5));
        }
        return sArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T> T Kp(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (T) Lp(tArr, Random.Default);
    }

    public static final float Kq(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Le = Le(fArr);
        if (Le < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float f6 = fArr[Le];
        for (int i6 = Le - 1; i6 >= 0; i6--) {
            f6 = operation.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i6]), Float.valueOf(f6)).floatValue();
        }
        return f6;
    }

    @NotNull
    public static byte[] Kr(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int Ie = Ie(bArr);
        if (Ie >= 0) {
            int i6 = 0;
            while (true) {
                bArr2[Ie - i6] = bArr[i6];
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return bArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ks(short[] sArr, R r5, Function2<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r5);
        for (short s5 : sArr) {
            r5 = operation.invoke(r5, Short.valueOf(s5));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Character Kt(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final void Ku(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length > 1) {
            kotlin.collections.q.G3(bArr);
            jr(bArr);
        }
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> Kv(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return bw(dArr, new g.c(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Kw(@NotNull int[] iArr, @NotNull Function1<? super Integer, Double> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (int i6 : iArr) {
            d6 += selector.invoke(Integer.valueOf(i6)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Kx(long[] jArr, Function1<? super Long, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (long j6 : jArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Long.valueOf(j6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C Ky(@NotNull boolean[] zArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (boolean z5 : zArr) {
            destination.add(Boolean.valueOf(z5));
        }
        return destination;
    }

    @NotNull
    public static final Set<Character> Kz(@NotNull char[] cArr, @NotNull Iterable<Character> other) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Character> rz = rz(cArr);
        m0.s0(rz, other);
        return rz;
    }

    @NotNull
    public static final Iterable<Short> L5(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr.length == 0 ? h0.J() : new c(sArr);
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Short>> M L6(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (short s5 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s5)), Short.valueOf(s5));
        }
        return destination;
    }

    @InlineOnly
    private static final byte L7(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr[1];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final short[] L8(short[] sArr, int i6, Function1<? super Integer, Short> init) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        short[] copyOf = Arrays.copyOf(sArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = sArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).shortValue();
        }
        return copyOf;
    }

    @NotNull
    public static final List<Long> L9(@NotNull long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (i6 >= 0) {
            return Tx(jArr, kotlin.ranges.t.u(jArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <V> List<V> LA(@NotNull int[] iArr, @NotNull int[] other, @NotNull Function2<? super Integer, ? super Integer, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i6]), Integer.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> La(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            float f6 = fArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Float.valueOf(f6)).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Long Lb(long[] jArr, Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return Long.valueOf(j6);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> Lc(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d6 : dArr) {
            m0.s0(arrayList, transform.invoke(Double.valueOf(d6)));
        }
        return arrayList;
    }

    public static final <R> R Ld(@NotNull long[] jArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Long.valueOf(jArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    public static final int Le(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Lf(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (int i6 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Integer.valueOf(i6)));
        }
        return destination;
    }

    @InlineOnly
    private static final <T> boolean Lg(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    public static final double Lh(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[Ke(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R> List<R> Li(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Double.valueOf(dArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Lj(long[] jArr, Function1<? super Long, Double> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Long.valueOf(jArr[i6])).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Lk(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final boolean Ll(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                if (comparator.compare(Boolean.valueOf(z5), Boolean.valueOf(z6)) < 0) {
                    z5 = z6;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return z5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R Lm(T[] tArr, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                R invoke2 = selector.invoke(tArr[i6]);
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double Ln(@NotNull Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = dArr[0].doubleValue();
        int Oe = Oe(dArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.min(doubleValue, dArr[i6].doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean[] Lo(boolean[] zArr, Function1<? super Boolean, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (boolean z5 : zArr) {
            action.invoke(Boolean.valueOf(z5));
        }
        return zArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T Lp(@NotNull T[] tArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.nextInt(tArr.length)];
    }

    public static final int Lq(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Me = Me(iArr);
        if (Me < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int i6 = iArr[Me];
        for (int i7 = Me - 1; i7 >= 0; i7--) {
            i6 = operation.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i7]), Integer.valueOf(i6)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final char[] Lr(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int Je = Je(cArr);
        if (Je >= 0) {
            int i6 = 0;
            while (true) {
                cArr2[Je - i6] = cArr[i6];
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return cArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ls(boolean[] zArr, R r5, Function2<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r5);
        for (boolean z5 : zArr) {
            r5 = operation.invoke(r5, Boolean.valueOf(z5));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Character Lt(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Character ch = null;
        boolean z5 = false;
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                if (z5) {
                    return null;
                }
                ch = Character.valueOf(c6);
                z5 = true;
            }
        }
        if (z5) {
            return ch;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Lu(@NotNull byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.collections.q.H3(bArr, i6, i7);
        kr(bArr, i6, i7);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> Lv(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return cw(fArr, new g.c(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Lw(@NotNull long[] jArr, @NotNull Function1<? super Long, Double> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (long j6 : jArr) {
            d6 += selector.invoke(Long.valueOf(j6)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long Lx(T[] tArr, Function1<? super T, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (T t5 : tArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(t5).q0());
        }
        return k6;
    }

    @NotNull
    public static final double[] Ly(@NotNull Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i6 = 0; i6 < length; i6++) {
            dArr2[i6] = dArr[i6].doubleValue();
        }
        return dArr2;
    }

    @NotNull
    public static final Set<Double> Lz(@NotNull double[] dArr, @NotNull Iterable<Double> other) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Double> sz = sz(dArr);
        m0.s0(sz, other);
        return sz;
    }

    @NotNull
    public static final Iterable<Boolean> M5(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr.length == 0 ? h0.J() : new h(zArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M M6(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (short s5 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s5)), valueTransform.invoke(Short.valueOf(s5)));
        }
        return destination;
    }

    @InlineOnly
    private static final char M7(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr[1];
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final boolean[] M8(boolean[] zArr, int i6, Function1<? super Integer, Boolean> init) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        boolean[] copyOf = Arrays.copyOf(zArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        for (int length = zArr.length; length < i6; length++) {
            copyOf[length] = init.invoke(Integer.valueOf(length)).booleanValue();
        }
        return copyOf;
    }

    @NotNull
    public static final <T> List<T> M9(@NotNull T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (i6 >= 0) {
            return Ux(tArr, kotlin.ranges.t.u(tArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> MA(@NotNull int[] iArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            int i7 = iArr[i6];
            arrayList.add(kotlin.o0.a(Integer.valueOf(i7), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> Ma(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = iArr[i6];
            int i9 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Integer.valueOf(i8)).booleanValue()) {
                arrayList.add(Integer.valueOf(i8));
            }
            i6++;
            i7 = i9;
        }
        return arrayList;
    }

    @InlineOnly
    private static final <T> T Mb(T[] tArr, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> Mc(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            m0.s0(arrayList, transform.invoke(Float.valueOf(f6)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Md(@NotNull T[] tArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            r5 = operation.invoke(Integer.valueOf(i7), r5, tArr[i6]);
            i6++;
            i7++;
        }
        return r5;
    }

    public static int Me(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr.length - 1;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Long>>> M Mf(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (long j6 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j6));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Mg(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    public static final double Mh(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                double d6 = dArr[length];
                if (!predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return d6;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R> List<R> Mi(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Float.valueOf(fArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double Mj(T[] tArr, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(tArr[i6]).doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Mk(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Boolean Ml(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        if (Qe == 0) {
            return Boolean.valueOf(z5);
        }
        R invoke = selector.invoke(Boolean.valueOf(z5));
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                R invoke2 = selector.invoke(Boolean.valueOf(z6));
                if (invoke.compareTo(invoke2) > 0) {
                    z5 = z6;
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Mm(short[] sArr, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final float Mn(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = Math.min(f6, fArr[i6]);
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final byte[] Mo(byte[] bArr, Function2<? super Integer, ? super Byte, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Byte.valueOf(bArr[i6]));
            i6++;
            i7++;
        }
        return bArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Short Mp(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return Np(sArr, Random.Default);
    }

    public static final long Mq(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ne = Ne(jArr);
        if (Ne < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long j6 = jArr[Ne];
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            j6 = operation.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i6]), Long.valueOf(j6)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final double[] Mr(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int Ke = Ke(dArr);
        if (Ke >= 0) {
            int i6 = 0;
            while (true) {
                dArr2[Ke - i6] = dArr[i6];
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return dArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ms(byte[] bArr, R r5, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r5);
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Byte.valueOf(bArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Double Mt(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final void Mu(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length > 1) {
            kotlin.collections.q.I3(cArr);
            lr(cArr);
        }
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> Mv(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return dw(iArr, new g.c(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double Mw(@NotNull T[] tArr, @NotNull Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (T t5 : tArr) {
            d6 += selector.invoke(t5).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Mx(short[] sArr, Function1<? super Short, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (short s5 : sArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Short.valueOf(s5)).q0());
        }
        return k6;
    }

    @NotNull
    public static final float[] My(@NotNull Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i6 = 0; i6 < length; i6++) {
            fArr2[i6] = fArr[i6].floatValue();
        }
        return fArr2;
    }

    @NotNull
    public static final Set<Float> Mz(@NotNull float[] fArr, @NotNull Iterable<Float> other) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Float> tz = tz(fArr);
        m0.s0(tz, other);
        return tz;
    }

    @NotNull
    public static final kotlin.sequences.m<Byte> N5(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr.length == 0 ? kotlin.sequences.p.l() : new k(bArr);
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Boolean>> M N6(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (boolean z5 : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z5)), Boolean.valueOf(z5));
        }
        return destination;
    }

    @InlineOnly
    private static final double N7(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr[1];
    }

    @InlineOnly
    private static final int N8(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr.length;
    }

    @NotNull
    public static final List<Short> N9(@NotNull short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (i6 >= 0) {
            return Vx(sArr, kotlin.ranges.t.u(sArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, V> List<V> NA(@NotNull int[] iArr, @NotNull R[] other, @NotNull Function2<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> Na(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            long j6 = jArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Long.valueOf(j6)).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Short Nb(short[] sArr, Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return Short.valueOf(s5);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> Nc(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i6)));
        }
        return arrayList;
    }

    public static final <R> R Nd(@NotNull short[] sArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Short.valueOf(sArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    public static int Ne(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Nf(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (long j6 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j6));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Ng(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    public static final float Nh(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[Le(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R> List<R> Ni(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Nj(short[] sArr, Function1<? super Short, Double> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Short.valueOf(sArr[i6])).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Nk(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Byte Nl(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        if (Ie == 0) {
            return Byte.valueOf(b6);
        }
        R invoke = selector.invoke(Byte.valueOf(b6));
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                R invoke2 = selector.invoke(Byte.valueOf(b7));
                if (invoke.compareTo(invoke2) > 0) {
                    b6 = b7;
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Nm(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final float Nn(@NotNull Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = fArr[0].floatValue();
        int Oe = Oe(fArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.min(floatValue, fArr[i6].floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final char[] No(char[] cArr, Function2<? super Integer, ? super Character, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Character.valueOf(cArr[i6]));
            i6++;
            i7++;
        }
        return cArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short Np(@NotNull short[] sArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.nextInt(sArr.length)]);
    }

    public static final <S, T extends S> S Nq(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Oe = Oe(tArr);
        if (Oe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s5 = (S) tArr[Oe];
        for (int i6 = Oe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke(Integer.valueOf(i6), (Object) tArr[i6], s5);
        }
        return s5;
    }

    @NotNull
    public static final float[] Nr(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int Le = Le(fArr);
        if (Le >= 0) {
            int i6 = 0;
            while (true) {
                fArr2[Le - i6] = fArr[i6];
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return fArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ns(char[] cArr, R r5, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r5);
        int length = cArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Character.valueOf(cArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Double Nt(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Double d6 = null;
        boolean z5 = false;
        for (double d7 : dArr) {
            if (predicate.invoke(Double.valueOf(d7)).booleanValue()) {
                if (z5) {
                    return null;
                }
                d6 = Double.valueOf(d7);
                z5 = true;
            }
        }
        if (z5) {
            return d6;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Nu(@NotNull char[] cArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.collections.q.J3(cArr, i6, i7);
        mr(cArr, i6, i7);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> Nv(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return ew(jArr, new g.c(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Nw(@NotNull short[] sArr, @NotNull Function1<? super Short, Double> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (short s5 : sArr) {
            d6 += selector.invoke(Short.valueOf(s5)).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long Nx(boolean[] zArr, Function1<? super Boolean, kotlin.d1> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long k6 = kotlin.d1.k(0L);
        for (boolean z5 : zArr) {
            k6 = kotlin.d1.k(k6 + selector.invoke(Boolean.valueOf(z5)).q0());
        }
        return k6;
    }

    @NotNull
    public static final HashSet<Byte> Ny(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return (HashSet) Cy(bArr, new HashSet(k1.j(bArr.length)));
    }

    @NotNull
    public static final Set<Integer> Nz(@NotNull int[] iArr, @NotNull Iterable<Integer> other) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Integer> uz = uz(iArr);
        m0.s0(uz, other);
        return uz;
    }

    @NotNull
    public static final kotlin.sequences.m<Character> O5(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr.length == 0 ? kotlin.sequences.p.l() : new r(cArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M O6(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (boolean z5 : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z5)), valueTransform.invoke(Boolean.valueOf(z5)));
        }
        return destination;
    }

    @InlineOnly
    private static final float O7(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr[1];
    }

    public static final int O8(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final List<Boolean> O9(@NotNull boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (i6 >= 0) {
            return Wx(zArr, kotlin.ranges.t.u(zArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> OA(@NotNull long[] jArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Long.valueOf(jArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> Oa(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            T t5 = tArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), t5).booleanValue()) {
                arrayList.add(t5);
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Boolean Ob(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            boolean z5 = zArr[length];
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return Boolean.valueOf(z5);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @NotNull
    public static final <R> List<R> Oc(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            m0.s0(arrayList, transform.invoke(Long.valueOf(j6)));
        }
        return arrayList;
    }

    public static final <R> R Od(@NotNull boolean[] zArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Boolean.valueOf(zArr[i6]));
            i6++;
            i7++;
        }
        return r5;
    }

    public static <T> int Oe(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr.length - 1;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M Of(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (T t5 : tArr) {
            K invoke = keySelector.invoke(t5);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(t5);
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Og(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final float Oh(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                float f6 = fArr[length];
                if (!predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return f6;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R> List<R> Oi(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Long.valueOf(jArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double Oj(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Boolean.valueOf(zArr[i6])).doubleValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R Ok(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                Object obj2 = (R) selector.invoke(tArr[i6]);
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Character Ol(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        if (Je == 0) {
            return Character.valueOf(c6);
        }
        R invoke = selector.invoke(Character.valueOf(c6));
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                R invoke2 = selector.invoke(Character.valueOf(c7));
                if (invoke.compareTo(invoke2) > 0) {
                    c6 = c7;
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Om(byte[] bArr, Function1<? super Byte, Double> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Byte.valueOf(bArr[i6])).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final int On(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (i6 > i8) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final double[] Oo(double[] dArr, Function2<? super Integer, ? super Double, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Double.valueOf(dArr[i6]));
            i6++;
            i7++;
        }
        return dArr;
    }

    public static final byte Op(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                b6 = operation.invoke(Byte.valueOf(b6), Byte.valueOf(bArr[i6])).byteValue();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return b6;
    }

    public static final short Oq(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Pe = Pe(sArr);
        if (Pe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s5 = sArr[Pe];
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i6]), Short.valueOf(s5)).shortValue();
        }
        return s5;
    }

    @NotNull
    public static int[] Or(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int Me = Me(iArr);
        if (Me >= 0) {
            int i6 = 0;
            while (true) {
                iArr2[Me - i6] = iArr[i6];
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return iArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Os(double[] dArr, R r5, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r5);
        int length = dArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Double.valueOf(dArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Float Ot(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final void Ou(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length > 1) {
            kotlin.collections.q.K3(dArr);
            nr(dArr);
        }
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> Ov(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return fw(tArr, new g.c(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double Ow(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Double> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (boolean z5 : zArr) {
            d6 += selector.invoke(Boolean.valueOf(z5)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Byte> Ox(@NotNull byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= bArr.length) {
            return Xy(bArr);
        }
        if (i6 == 1) {
            return g0.l(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (byte b6 : bArr) {
            arrayList.add(Byte.valueOf(b6));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final HashSet<Character> Oy(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return (HashSet) Dy(cArr, new HashSet(k1.j(kotlin.ranges.t.B(cArr.length, 128))));
    }

    @NotNull
    public static final Set<Long> Oz(@NotNull long[] jArr, @NotNull Iterable<Long> other) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Long> vz = vz(jArr);
        m0.s0(vz, other);
        return vz;
    }

    @NotNull
    public static final kotlin.sequences.m<Double> P5(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr.length == 0 ? kotlin.sequences.p.l() : new p(dArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M P6(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (byte b6 : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b6));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final int P7(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr[1];
    }

    @InlineOnly
    private static final int P8(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr.length;
    }

    @NotNull
    public static final List<Byte> P9(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Ie = Ie(bArr); -1 < Ie; Ie--) {
            if (!predicate.invoke(Byte.valueOf(bArr[Ie])).booleanValue()) {
                return Ox(bArr, Ie + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static final <R, V> List<V> PA(@NotNull long[] jArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Long.valueOf(jArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> Pa(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            short s5 = sArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Short.valueOf(s5)).booleanValue()) {
                arrayList.add(Short.valueOf(s5));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Byte Pb(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            byte b6 = bArr[length];
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return Byte.valueOf(b6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @NotNull
    public static final <T, R> List<R> Pc(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            m0.s0(arrayList, transform.invoke(t5));
        }
        return arrayList;
    }

    public static final <R> R Pd(@NotNull byte[] bArr, R r5, @NotNull Function2<? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Ie = Ie(bArr); Ie >= 0; Ie--) {
            r5 = operation.invoke(Byte.valueOf(bArr[Ie]), r5);
        }
        return r5;
    }

    public static int Pe(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M Pf(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (T t5 : tArr) {
            K invoke = keySelector.invoke(t5);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(t5));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Pg(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static int Ph(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[Me(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <T, R> List<R> Pi(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), tArr[i6]));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Pj(byte[] bArr, Function1<? super Byte, Float> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Byte.valueOf(bArr[i6])).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Pk(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Double Pl(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        if (Ke == 0) {
            return Double.valueOf(d6);
        }
        R invoke = selector.invoke(Double.valueOf(d6));
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                R invoke2 = selector.invoke(Double.valueOf(d7));
                if (invoke.compareTo(invoke2) > 0) {
                    d6 = d7;
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Pm(char[] cArr, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(cArr[i6])).doubleValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final long Pn(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (j6 > j7) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final float[] Po(float[] fArr, Function2<? super Integer, ? super Float, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Float.valueOf(fArr[i6]));
            i6++;
            i7++;
        }
        return fArr;
    }

    public static final char Pp(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                c6 = operation.invoke(Character.valueOf(c6), Character.valueOf(cArr[i6])).charValue();
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return c6;
    }

    public static final boolean Pq(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Qe = Qe(zArr);
        if (Qe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z5 = zArr[Qe];
        for (int i6 = Qe - 1; i6 >= 0; i6--) {
            z5 = operation.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i6]), Boolean.valueOf(z5)).booleanValue();
        }
        return z5;
    }

    @NotNull
    public static long[] Pr(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int Ne = Ne(jArr);
        if (Ne >= 0) {
            int i6 = 0;
            while (true) {
                jArr2[Ne - i6] = jArr[i6];
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return jArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ps(float[] fArr, R r5, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r5);
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Float.valueOf(fArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Float Pt(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Float f6 = null;
        boolean z5 = false;
        for (float f7 : fArr) {
            if (predicate.invoke(Float.valueOf(f7)).booleanValue()) {
                if (z5) {
                    return null;
                }
                f6 = Float.valueOf(f7);
                z5 = true;
            }
        }
        if (z5) {
            return f6;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Pu(@NotNull double[] dArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.collections.q.L3(dArr, i6, i7);
        or(dArr, i6, i7);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> Pv(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return gw(sArr, new g.c(selector));
    }

    @JvmName(name = "sumOfByte")
    public static final int Pw(@NotNull Byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int i6 = 0;
        for (Byte b6 : bArr) {
            i6 += b6.byteValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Character> Px(@NotNull char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= cArr.length) {
            return Yy(cArr);
        }
        if (i6 == 1) {
            return g0.l(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (char c6 : cArr) {
            arrayList.add(Character.valueOf(c6));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final HashSet<Double> Py(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return (HashSet) Ey(dArr, new HashSet(k1.j(dArr.length)));
    }

    @NotNull
    public static final <T> Set<T> Pz(@NotNull T[] tArr, @NotNull Iterable<? extends T> other) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<T> wz = wz(tArr);
        m0.s0(wz, other);
        return wz;
    }

    @NotNull
    public static final kotlin.sequences.m<Float> Q5(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr.length == 0 ? kotlin.sequences.p.l() : new o(fArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M Q6(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (char c6 : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c6));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final long Q7(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr[1];
    }

    public static final int Q8(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final List<Character> Q9(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Je = Je(cArr); -1 < Je; Je--) {
            if (!predicate.invoke(Character.valueOf(cArr[Je])).booleanValue()) {
                return Px(cArr, Je + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static final List<Pair<Long, Long>> QA(@NotNull long[] jArr, @NotNull long[] other) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Long.valueOf(jArr[i6]), Long.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> Qa(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            boolean z5 = zArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Boolean.valueOf(z5)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z5));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Character Qb(char[] cArr, Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            char c6 = cArr[length];
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return Character.valueOf(c6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @NotNull
    public static final <R> List<R> Qc(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s5 : sArr) {
            m0.s0(arrayList, transform.invoke(Short.valueOf(s5)));
        }
        return arrayList;
    }

    public static final <R> R Qd(@NotNull char[] cArr, R r5, @NotNull Function2<? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Je = Je(cArr); Je >= 0; Je--) {
            r5 = operation.invoke(Character.valueOf(cArr[Je]), r5);
        }
        return r5;
    }

    public static final int Qe(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr.length - 1;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Short>>> M Qf(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (short s5 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s5));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Qg(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static final int Qh(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                int i7 = iArr[length];
                if (!predicate.invoke(Integer.valueOf(i7)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R> List<R> Qi(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Short.valueOf(sArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Qj(char[] cArr, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(cArr[i6])).floatValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Qk(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Float Ql(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        if (Le == 0) {
            return Float.valueOf(f6);
        }
        R invoke = selector.invoke(Float.valueOf(f6));
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                R invoke2 = selector.invoke(Float.valueOf(f7));
                if (invoke.compareTo(invoke2) > 0) {
                    f6 = f7;
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Qm(double[] dArr, Function1<? super Double, Double> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Double.valueOf(dArr[i6])).doubleValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T Qn(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (t5.compareTo(t6) > 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int[] Qo(int[] iArr, Function2<? super Integer, ? super Integer, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i6]));
            i6++;
            i7++;
        }
        return iArr;
    }

    public static final double Qp(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = operation.invoke(Double.valueOf(d6), Double.valueOf(dArr[i6])).doubleValue();
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Boolean Qq(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Qe = Qe(zArr);
        if (Qe < 0) {
            return null;
        }
        boolean z5 = zArr[Qe];
        for (int i6 = Qe - 1; i6 >= 0; i6--) {
            z5 = operation.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i6]), Boolean.valueOf(z5)).booleanValue();
        }
        return Boolean.valueOf(z5);
    }

    @NotNull
    public static final <T> T[] Qr(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) kotlin.collections.o.a(tArr, tArr.length);
        int Oe = Oe(tArr);
        if (Oe >= 0) {
            int i6 = 0;
            while (true) {
                tArr2[Oe - i6] = tArr[i6];
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return tArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Qs(int[] iArr, R r5, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r5);
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Integer.valueOf(iArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Integer Qt(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static final void Qu(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length > 1) {
            kotlin.collections.q.M3(fArr);
            pr(fArr);
        }
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> Qv(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return hw(zArr, new g.c(selector));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Qw(byte[] bArr, Function1<? super Byte, Double> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (byte b6 : bArr) {
            d6 += selector.invoke(Byte.valueOf(b6)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Double> Qx(@NotNull double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= dArr.length) {
            return Zy(dArr);
        }
        if (i6 == 1) {
            return g0.l(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (double d6 : dArr) {
            arrayList.add(Double.valueOf(d6));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final HashSet<Float> Qy(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return (HashSet) Fy(fArr, new HashSet(k1.j(fArr.length)));
    }

    @NotNull
    public static final Set<Short> Qz(@NotNull short[] sArr, @NotNull Iterable<Short> other) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Short> xz = xz(sArr);
        m0.s0(xz, other);
        return xz;
    }

    @NotNull
    public static final kotlin.sequences.m<Integer> R5(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr.length == 0 ? kotlin.sequences.p.l() : new m(iArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M R6(@NotNull double[] dArr, @NotNull M destination, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (double d6 : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d6));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final <T> T R7(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr[1];
    }

    @InlineOnly
    private static final int R8(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr.length;
    }

    @NotNull
    public static final List<Double> R9(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Ke = Ke(dArr); -1 < Ke; Ke--) {
            if (!predicate.invoke(Double.valueOf(dArr[Ke])).booleanValue()) {
                return Qx(dArr, Ke + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static final <V> List<V> RA(@NotNull long[] jArr, @NotNull long[] other, @NotNull Function2<? super Long, ? super Long, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i6]), Long.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C Ra(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            byte b6 = bArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Byte.valueOf(b6)).booleanValue()) {
                destination.add(Byte.valueOf(b6));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @InlineOnly
    private static final Double Rb(double[] dArr, Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            double d6 = dArr[length];
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return Double.valueOf(d6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @NotNull
    public static final <R> List<R> Rc(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z5 : zArr) {
            m0.s0(arrayList, transform.invoke(Boolean.valueOf(z5)));
        }
        return arrayList;
    }

    public static final <R> R Rd(@NotNull double[] dArr, R r5, @NotNull Function2<? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Ke = Ke(dArr); Ke >= 0; Ke--) {
            r5 = operation.invoke(Double.valueOf(dArr[Ke]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final byte Re(byte[] bArr, int i6, Function1<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= bArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).byteValue() : bArr[i6];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Rf(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (short s5 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Short.valueOf(s5)));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Rg(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    public static long Rh(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[Ne(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R> List<R> Ri(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), Boolean.valueOf(zArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Rj(double[] dArr, Function1<? super Double, Float> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Double.valueOf(dArr[i6])).floatValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Rk(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Integer Rl(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        if (Me == 0) {
            return Integer.valueOf(i6);
        }
        R invoke = selector.invoke(Integer.valueOf(i6));
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                R invoke2 = selector.invoke(Integer.valueOf(i8));
                if (invoke.compareTo(invoke2) > 0) {
                    i6 = i8;
                    invoke = invoke2;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Rm(float[] fArr, Function1<? super Float, Double> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Float.valueOf(fArr[i6])).doubleValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final short Rn(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (s5 > s6) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final long[] Ro(long[] jArr, Function2<? super Integer, ? super Long, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Long.valueOf(jArr[i6]));
            i6++;
            i7++;
        }
        return jArr;
    }

    public static final float Rp(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = operation.invoke(Float.valueOf(f6), Float.valueOf(fArr[i6])).floatValue();
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte Rq(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ie = Ie(bArr);
        if (Ie < 0) {
            return null;
        }
        byte b6 = bArr[Ie];
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            b6 = operation.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i6]), Byte.valueOf(b6)).byteValue();
        }
        return Byte.valueOf(b6);
    }

    @NotNull
    public static short[] Rr(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int Pe = Pe(sArr);
        if (Pe >= 0) {
            int i6 = 0;
            while (true) {
                sArr2[Pe - i6] = sArr[i6];
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return sArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Rs(long[] jArr, R r5, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r5);
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Long.valueOf(jArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Integer Rt(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Integer num = null;
        boolean z5 = false;
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                if (z5) {
                    return null;
                }
                num = Integer.valueOf(i6);
                z5 = true;
            }
        }
        if (z5) {
            return num;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void Ru(@NotNull float[] fArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.collections.q.N3(fArr, i6, i7);
        qr(fArr, i6, i7);
    }

    @NotNull
    public static final List<Byte> Rv(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.G3(copyOf);
        return Br(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Rw(char[] cArr, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (char c6 : cArr) {
            d6 += selector.invoke(Character.valueOf(c6)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Float> Rx(@NotNull float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= fArr.length) {
            return az(fArr);
        }
        if (i6 == 1) {
            return g0.l(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (float f6 : fArr) {
            arrayList.add(Float.valueOf(f6));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final HashSet<Integer> Ry(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return (HashSet) Gy(iArr, new HashSet(k1.j(iArr.length)));
    }

    @NotNull
    public static final Set<Boolean> Rz(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> other) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Boolean> yz = yz(zArr);
        m0.s0(yz, other);
        return yz;
    }

    @NotNull
    public static final kotlin.sequences.m<Long> S5(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr.length == 0 ? kotlin.sequences.p.l() : new n(jArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M S6(@NotNull float[] fArr, @NotNull M destination, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (float f6 : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f6));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final short S7(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr[1];
    }

    public static final int S8(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final List<Float> S9(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Le = Le(fArr); -1 < Le; Le--) {
            if (!predicate.invoke(Float.valueOf(fArr[Le])).booleanValue()) {
                return Rx(fArr, Le + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> SA(@NotNull long[] jArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            long j6 = jArr[i6];
            arrayList.add(kotlin.o0.a(Long.valueOf(j6), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C Sa(@NotNull char[] cArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            char c6 = cArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Character.valueOf(c6)).booleanValue()) {
                destination.add(Character.valueOf(c6));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @InlineOnly
    private static final Float Sb(float[] fArr, Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            float f6 = fArr[length];
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return Float.valueOf(f6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> Sc(byte[] bArr, Function2<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Byte.valueOf(bArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R Sd(@NotNull float[] fArr, R r5, @NotNull Function2<? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Le = Le(fArr); Le >= 0; Le--) {
            r5 = operation.invoke(Float.valueOf(fArr[Le]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final char Se(char[] cArr, int i6, Function1<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= cArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).charValue() : cArr[i6];
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Boolean>>> M Sf(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (boolean z5 : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z5));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Sg(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final long Sh(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                long j6 = jArr[length];
                if (!predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return j6;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <T, R> List<R> Si(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i7 + 1;
            R invoke = transform.invoke(Integer.valueOf(i7), tArr[i6]);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Sj(float[] fArr, Function1<? super Float, Float> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Float.valueOf(fArr[i6])).floatValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Sk(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Long Sl(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        if (Ne == 0) {
            return Long.valueOf(j6);
        }
        R invoke = selector.invoke(Long.valueOf(j6));
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                R invoke2 = selector.invoke(Long.valueOf(j7));
                if (invoke.compareTo(invoke2) > 0) {
                    j6 = j7;
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Sm(int[] iArr, Function1<? super Integer, Double> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Integer.valueOf(iArr[i6])).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Boolean Sn(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                if (comparator.compare(Boolean.valueOf(z5), Boolean.valueOf(z6)) > 0) {
                    z5 = z6;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T> T[] So(T[] tArr, Function2<? super Integer, ? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), tArr[i6]);
            i6++;
            i7++;
        }
        return tArr;
    }

    public static final int Sp(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                i6 = operation.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i7])).intValue();
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character Sq(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Je = Je(cArr);
        if (Je < 0) {
            return null;
        }
        char c6 = cArr[Je];
        for (int i6 = Je - 1; i6 >= 0; i6--) {
            c6 = operation.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i6]), Character.valueOf(c6)).charValue();
        }
        return Character.valueOf(c6);
    }

    @NotNull
    public static final boolean[] Sr(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int Qe = Qe(zArr);
        if (Qe >= 0) {
            int i6 = 0;
            while (true) {
                zArr2[Qe - i6] = zArr[i6];
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return zArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> Ss(@NotNull T[] tArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r5);
        int length = tArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, tArr[i6]);
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Long St(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final void Su(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length > 1) {
            kotlin.collections.q.O3(iArr);
            rr(iArr);
        }
    }

    @NotNull
    public static final List<Character> Sv(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.I3(copyOf);
        return Cr(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Sw(double[] dArr, Function1<? super Double, Double> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (double d7 : dArr) {
            d6 += selector.invoke(Double.valueOf(d7)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Integer> Sx(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= iArr.length) {
            return bz(iArr);
        }
        if (i6 == 1) {
            return g0.l(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (int i8 : iArr) {
            arrayList.add(Integer.valueOf(i8));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final HashSet<Long> Sy(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return (HashSet) Hy(jArr, new HashSet(k1.j(jArr.length)));
    }

    @NotNull
    public static final Iterable<a1<Byte>> Sz(@NotNull final byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator cA;
                cA = a0.cA(bArr);
                return cA;
            }
        });
    }

    @NotNull
    public static <T> kotlin.sequences.m<T> T5(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr.length == 0 ? kotlin.sequences.p.l() : new j(tArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M T6(@NotNull int[] iArr, @NotNull M destination, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i6));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final boolean T7(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr[1];
    }

    @InlineOnly
    private static final int T8(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr.length;
    }

    @NotNull
    public static final List<Integer> T9(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Me = Me(iArr); -1 < Me; Me--) {
            if (!predicate.invoke(Integer.valueOf(iArr[Me])).booleanValue()) {
                return Sx(iArr, Me + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static final <R, V> List<V> TA(@NotNull long[] jArr, @NotNull R[] other, @NotNull Function2<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C Ta(@NotNull double[] dArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            double d6 = dArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Double.valueOf(d6)).booleanValue()) {
                destination.add(Double.valueOf(d6));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @InlineOnly
    private static final Integer Tb(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            int i7 = iArr[length];
            if (predicate.invoke(Integer.valueOf(i7)).booleanValue()) {
                return Integer.valueOf(i7);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> Tc(char[] cArr, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Character.valueOf(cArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R Td(@NotNull int[] iArr, R r5, @NotNull Function2<? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Me = Me(iArr); Me >= 0; Me--) {
            r5 = operation.invoke(Integer.valueOf(iArr[Me]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final double Te(double[] dArr, int i6, Function1<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= dArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).doubleValue() : dArr[i6];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M Tf(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (boolean z5 : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Boolean.valueOf(z5)));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean Tg(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static <T> T Th(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[Oe(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C Ti(@NotNull T[] tArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i7 + 1;
            R invoke = transform.invoke(Integer.valueOf(i7), tArr[i6]);
            if (invoke != null) {
                destination.add(invoke);
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Tj(int[] iArr, Function1<? super Integer, Float> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Integer.valueOf(iArr[i6])).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Tk(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T, R extends Comparable<? super R>> T Tl(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        if (Oe != 0) {
            R invoke = selector.invoke(t5);
            int i6 = 1;
            if (1 <= Oe) {
                while (true) {
                    T t6 = tArr[i6];
                    R invoke2 = selector.invoke(t6);
                    if (invoke.compareTo(invoke2) > 0) {
                        t5 = t6;
                        invoke = invoke2;
                    }
                    if (i6 == Oe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Tm(long[] jArr, Function1<? super Long, Double> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Long.valueOf(jArr[i6])).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte Tn(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (comparator.compare(Byte.valueOf(b6), Byte.valueOf(b7)) > 0) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final short[] To(short[] sArr, Function2<? super Integer, ? super Short, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Short.valueOf(sArr[i6]));
            i6++;
            i7++;
        }
        return sArr;
    }

    public static final long Tp(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                j6 = operation.invoke(Long.valueOf(j6), Long.valueOf(jArr[i6])).longValue();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double Tq(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ke = Ke(dArr);
        if (Ke < 0) {
            return null;
        }
        double d6 = dArr[Ke];
        for (int i6 = Ke - 1; i6 >= 0; i6--) {
            d6 = operation.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i6]), Double.valueOf(d6)).doubleValue();
        }
        return Double.valueOf(d6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Tr(byte[] bArr, R r5, Function2<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r5);
        for (byte b6 : bArr) {
            r5 = operation.invoke(r5, Byte.valueOf(b6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ts(short[] sArr, R r5, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r5);
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Short.valueOf(sArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static final Long Tt(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Long l6 = null;
        boolean z5 = false;
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                if (z5) {
                    return null;
                }
                l6 = Long.valueOf(j6);
                z5 = true;
            }
        }
        if (z5) {
            return l6;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void Tu(@NotNull int[] iArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.collections.q.P3(iArr, i6, i7);
        sr(iArr, i6, i7);
    }

    @NotNull
    public static final List<Double> Tv(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.K3(copyOf);
        return Dr(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Tw(float[] fArr, Function1<? super Float, Double> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (float f6 : fArr) {
            d6 += selector.invoke(Float.valueOf(f6)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Long> Tx(@NotNull long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= jArr.length) {
            return cz(jArr);
        }
        if (i6 == 1) {
            return g0.l(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (long j6 : jArr) {
            arrayList.add(Long.valueOf(j6));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> HashSet<T> Ty(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (HashSet) Iy(tArr, new HashSet(k1.j(tArr.length)));
    }

    @NotNull
    public static final Iterable<a1<Character>> Tz(@NotNull final char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator jA;
                jA = a0.jA(cArr);
                return jA;
            }
        });
    }

    @NotNull
    public static final kotlin.sequences.m<Short> U5(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr.length == 0 ? kotlin.sequences.p.l() : new l(sArr);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M U6(@NotNull long[] jArr, @NotNull M destination, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (long j6 : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j6));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final byte U7(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr[2];
    }

    public static final int U8(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final List<Long> U9(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Ne = Ne(jArr); -1 < Ne; Ne--) {
            if (!predicate.invoke(Long.valueOf(jArr[Ne])).booleanValue()) {
                return Tx(jArr, Ne + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static <T, R> List<Pair<T, R>> UA(@NotNull T[] tArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(tArr[i6], r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C Ua(@NotNull float[] fArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            float f6 = fArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Float.valueOf(f6)).booleanValue()) {
                destination.add(Float.valueOf(f6));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @InlineOnly
    private static final Long Ub(long[] jArr, Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            long j6 = jArr[length];
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return Long.valueOf(j6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> Uc(double[] dArr, Function2<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Double.valueOf(dArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R Ud(@NotNull long[] jArr, R r5, @NotNull Function2<? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Ne = Ne(jArr); Ne >= 0; Ne--) {
            r5 = operation.invoke(Long.valueOf(jArr[Ne]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final float Ue(float[] fArr, int i6, Function1<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= fArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).floatValue() : fArr[i6];
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> w0<T, K> Uf(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        return new s(tArr, keySelector);
    }

    @InlineOnly
    private static final <T> boolean Ug(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static final <T> T Uh(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                T t5 = tArr[length];
                if (!predicate.invoke(t5).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return t5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C Ui(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Byte.valueOf(bArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Uj(long[] jArr, Function1<? super Long, Float> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Long.valueOf(jArr[i6])).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Uk(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Short Ul(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        if (Pe == 0) {
            return Short.valueOf(s5);
        }
        R invoke = selector.invoke(Short.valueOf(s5));
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                R invoke2 = selector.invoke(Short.valueOf(s6));
                if (invoke.compareTo(invoke2) > 0) {
                    s5 = s6;
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Double Um(T[] tArr, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(tArr[i6]).doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character Un(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (comparator.compare(Character.valueOf(c6), Character.valueOf(c7)) > 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean[] Uo(boolean[] zArr, Function2<? super Integer, ? super Boolean, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Boolean.valueOf(zArr[i6]));
            i6++;
            i7++;
        }
        return zArr;
    }

    public static final <S, T extends S> S Up(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s5 = (Object) tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                s5 = operation.invoke(s5, (Object) tArr[i6]);
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float Uq(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Le = Le(fArr);
        if (Le < 0) {
            return null;
        }
        float f6 = fArr[Le];
        for (int i6 = Le - 1; i6 >= 0; i6--) {
            f6 = operation.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i6]), Float.valueOf(f6)).floatValue();
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Ur(char[] cArr, R r5, Function2<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r5);
        for (char c6 : cArr) {
            r5 = operation.invoke(r5, Character.valueOf(c6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Us(boolean[] zArr, R r5, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r5);
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Boolean.valueOf(zArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @Nullable
    public static <T> T Ut(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final void Uu(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length > 1) {
            kotlin.collections.q.Q3(jArr);
            tr(jArr);
        }
    }

    @NotNull
    public static final List<Float> Uv(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.M3(copyOf);
        return Er(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Uw(int[] iArr, Function1<? super Integer, Double> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (int i6 : iArr) {
            d6 += selector.invoke(Integer.valueOf(i6)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final <T> List<T> Ux(@NotNull T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= tArr.length) {
            return dz(tArr);
        }
        if (i6 == 1) {
            return g0.l(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (T t5 : tArr) {
            arrayList.add(t5);
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final HashSet<Short> Uy(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return (HashSet) Jy(sArr, new HashSet(k1.j(sArr.length)));
    }

    @NotNull
    public static final Iterable<a1<Double>> Uz(@NotNull final double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator hA;
                hA = a0.hA(dArr);
                return hA;
            }
        });
    }

    @NotNull
    public static final kotlin.sequences.m<Boolean> V5(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr.length == 0 ? kotlin.sequences.p.l() : new q(zArr);
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M V6(@NotNull T[] tArr, @NotNull M destination, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (T t5 : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(t5);
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final char V7(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr[2];
    }

    @InlineOnly
    private static final int V8(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr.length;
    }

    @NotNull
    public static final <T> List<T> V9(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Oe = Oe(tArr); -1 < Oe; Oe--) {
            if (!predicate.invoke(tArr[Oe]).booleanValue()) {
                return Ux(tArr, Oe + 1);
            }
        }
        return h0.J();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, R, V> List<V> VA(@NotNull T[] tArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(tArr[i6], r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C Va(@NotNull int[] iArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = iArr[i6];
            int i9 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Integer.valueOf(i8)).booleanValue()) {
                destination.add(Integer.valueOf(i8));
            }
            i6++;
            i7 = i9;
        }
        return destination;
    }

    @InlineOnly
    private static final <T> T Vb(T[] tArr, Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            T t5 = tArr[length];
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> Vc(float[] fArr, Function2<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Float.valueOf(fArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Vd(@NotNull T[] tArr, R r5, @NotNull Function2<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Oe = Oe(tArr); Oe >= 0; Oe--) {
            r5 = operation.invoke(tArr[Oe], r5);
        }
        return r5;
    }

    @InlineOnly
    private static final int Ve(int[] iArr, int i6, Function1<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= iArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).intValue() : iArr[i6];
    }

    public static int Vf(@NotNull byte[] bArr, byte b6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (b6 == bArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    @InlineOnly
    private static final boolean Vg(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static short Vh(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[Pe(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C Vi(@NotNull char[] cArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Character.valueOf(cArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> float Vj(T[] tArr, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(tArr[i6]).floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Vk(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> byte Vl(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        if (Ie != 0) {
            R invoke = selector.invoke(Byte.valueOf(b6));
            int i6 = 1;
            if (1 <= Ie) {
                while (true) {
                    byte b7 = bArr[i6];
                    R invoke2 = selector.invoke(Byte.valueOf(b7));
                    if (invoke.compareTo(invoke2) > 0) {
                        b6 = b7;
                        invoke = invoke2;
                    }
                    if (i6 == Ie) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Vm(short[] sArr, Function1<? super Short, Double> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Short.valueOf(sArr[i6])).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double Vn(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                if (comparator.compare(Double.valueOf(d6), Double.valueOf(d7)) > 0) {
                    d6 = d7;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    @NotNull
    public static final Pair<List<Byte>, List<Byte>> Vo(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                arrayList.add(Byte.valueOf(b6));
            } else {
                arrayList2.add(Byte.valueOf(b6));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final short Vp(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                s5 = operation.invoke(Short.valueOf(s5), Short.valueOf(sArr[i6])).shortValue();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer Vq(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Me = Me(iArr);
        if (Me < 0) {
            return null;
        }
        int i6 = iArr[Me];
        for (int i7 = Me - 1; i7 >= 0; i7--) {
            i6 = operation.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i7]), Integer.valueOf(i6)).intValue();
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Vr(double[] dArr, R r5, Function2<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r5);
        for (double d6 : dArr) {
            r5 = operation.invoke(r5, Double.valueOf(d6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Vs(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        Ws(bArr, Random.Default);
    }

    @Nullable
    public static final <T> T Vt(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        T t5 = null;
        boolean z5 = false;
        for (T t6 : tArr) {
            if (predicate.invoke(t6).booleanValue()) {
                if (z5) {
                    return null;
                }
                z5 = true;
                t5 = t6;
            }
        }
        if (z5) {
            return t5;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void Vu(@NotNull long[] jArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.collections.q.R3(jArr, i6, i7);
        ur(jArr, i6, i7);
    }

    @NotNull
    public static final List<Integer> Vv(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.O3(copyOf);
        return Fr(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Vw(long[] jArr, Function1<? super Long, Double> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (long j6 : jArr) {
            d6 += selector.invoke(Long.valueOf(j6)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Short> Vx(@NotNull short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= sArr.length) {
            return ez(sArr);
        }
        if (i6 == 1) {
            return g0.l(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (short s5 : sArr) {
            arrayList.add(Short.valueOf(s5));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final HashSet<Boolean> Vy(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return (HashSet) Ky(zArr, new HashSet(k1.j(zArr.length)));
    }

    @NotNull
    public static final Iterable<a1<Float>> Vz(@NotNull final float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator gA;
                gA = a0.gA(fArr);
                return gA;
            }
        });
    }

    @NotNull
    public static final <K, V> Map<K, V> W5(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(bArr.length), 16));
        for (byte b6 : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b6));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M W6(@NotNull short[] sArr, @NotNull M destination, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (short s5 : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s5));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final double W7(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr[2];
    }

    public static final int W8(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (int i7 : iArr) {
            if (predicate.invoke(Integer.valueOf(i7)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final List<Short> W9(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Pe = Pe(sArr); -1 < Pe; Pe--) {
            if (!predicate.invoke(Short.valueOf(sArr[Pe])).booleanValue()) {
                return Vx(sArr, Pe + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static <T, R> List<Pair<T, R>> WA(@NotNull T[] tArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(tArr[i6], other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C Wa(@NotNull long[] jArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            long j6 = jArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Long.valueOf(j6)).booleanValue()) {
                destination.add(Long.valueOf(j6));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @InlineOnly
    private static final Short Wb(short[] sArr, Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            short s5 = sArr[length];
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return Short.valueOf(s5);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> Wc(int[] iArr, Function2<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R Wd(@NotNull short[] sArr, R r5, @NotNull Function2<? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Pe = Pe(sArr); Pe >= 0; Pe--) {
            r5 = operation.invoke(Short.valueOf(sArr[Pe]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final long We(long[] jArr, int i6, Function1<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= jArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).longValue() : jArr[i6];
    }

    public static final int Wf(@NotNull char[] cArr, char c6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        int length = cArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (c6 == cArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    @InlineOnly
    private static final boolean Wg(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final short Wh(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                short s5 = sArr[length];
                if (!predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return s5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C Wi(@NotNull double[] dArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Double.valueOf(dArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Wj(short[] sArr, Function1<? super Short, Float> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Short.valueOf(sArr[i6])).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Wk(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char Wl(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        if (Je != 0) {
            R invoke = selector.invoke(Character.valueOf(c6));
            int i6 = 1;
            if (1 <= Je) {
                while (true) {
                    char c7 = cArr[i6];
                    R invoke2 = selector.invoke(Character.valueOf(c7));
                    if (invoke.compareTo(invoke2) > 0) {
                        c6 = c7;
                        invoke = invoke2;
                    }
                    if (i6 == Je) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return c6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double Wm(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Boolean.valueOf(zArr[i6])).doubleValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float Wn(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) > 0) {
                    f6 = f7;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @NotNull
    public static final Pair<List<Character>, List<Character>> Wo(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                arrayList.add(Character.valueOf(c6));
            } else {
                arrayList2.add(Character.valueOf(c6));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean Wp(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                z5 = operation.invoke(Boolean.valueOf(z5), Boolean.valueOf(zArr[i6])).booleanValue();
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return z5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long Wq(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ne = Ne(jArr);
        if (Ne < 0) {
            return null;
        }
        long j6 = jArr[Ne];
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            j6 = operation.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i6]), Long.valueOf(j6)).longValue();
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Wr(float[] fArr, R r5, Function2<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r5);
        for (float f6 : fArr) {
            r5 = operation.invoke(r5, Float.valueOf(f6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Ws(@NotNull byte[] bArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Ie = Ie(bArr); Ie > 0; Ie--) {
            int nextInt = random.nextInt(Ie + 1);
            byte b6 = bArr[Ie];
            bArr[Ie] = bArr[nextInt];
            bArr[nextInt] = b6;
        }
    }

    @Nullable
    public static final Short Wt(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final <T extends Comparable<? super T>> void Wu(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.collections.q.h4(tArr, kotlin.comparisons.a.x());
    }

    @NotNull
    public static final List<Long> Wv(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.Q3(copyOf);
        return Gr(copyOf);
    }

    @JvmName(name = "sumOfDouble")
    public static final double Ww(@NotNull Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        double d6 = 0.0d;
        for (Double d7 : dArr) {
            d6 += d7.doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Boolean> Wx(@NotNull boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        if (i6 >= zArr.length) {
            return fz(zArr);
        }
        if (i6 == 1) {
            return g0.l(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = 0;
        for (boolean z5 : zArr) {
            arrayList.add(Boolean.valueOf(z5));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final int[] Wy(@NotNull Integer[] numArr) {
        kotlin.jvm.internal.g0.p(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = numArr[i6].intValue();
        }
        return iArr;
    }

    @NotNull
    public static final Iterable<a1<Integer>> Wz(@NotNull final int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator eA;
                eA = a0.eA(iArr);
                return eA;
            }
        });
    }

    @NotNull
    public static final <K, V> Map<K, V> X5(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(cArr.length), 16));
        for (char c6 : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c6));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M X6(@NotNull boolean[] zArr, @NotNull M destination, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (boolean z5 : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z5));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @InlineOnly
    private static final float X7(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr[2];
    }

    @InlineOnly
    private static final int X8(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr.length;
    }

    @NotNull
    public static final List<Boolean> X9(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Qe = Qe(zArr); -1 < Qe; Qe--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[Qe])).booleanValue()) {
                return Wx(zArr, Qe + 1);
            }
        }
        return h0.J();
    }

    @NotNull
    public static final <T, R, V> List<V> XA(@NotNull T[] tArr, @NotNull R[] other, @NotNull Function2<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(tArr[i6], other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C Xa(@NotNull T[] tArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            T t5 = tArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), t5).booleanValue()) {
                destination.add(t5);
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    public static byte Xb(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> Xc(long[] jArr, Function2<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Long.valueOf(jArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R Xd(@NotNull boolean[] zArr, R r5, @NotNull Function2<? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Qe = Qe(zArr); Qe >= 0; Qe--) {
            r5 = operation.invoke(Boolean.valueOf(zArr[Qe]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final <T> T Xe(T[] tArr, int i6, Function1<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= tArr.length) ? defaultValue.invoke(Integer.valueOf(i6)) : tArr[i6];
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfFirst { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = cn.bluemobi.dylan.photoview.a.f1297f, hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int Xf(double[] dArr, double d6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = dArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (d6 == dArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A Xg(@NotNull byte[] bArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (byte b6 : bArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Byte.valueOf(b6)));
            } else {
                buffer.append(String.valueOf((int) b6));
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean Xh(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[Qe(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C Xi(@NotNull float[] fArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Float.valueOf(fArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float Xj(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Boolean.valueOf(zArr[i6])).floatValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R Xk(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                Object obj2 = (R) selector.invoke(tArr[i6]);
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> double Xl(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        if (Ke != 0) {
            R invoke = selector.invoke(Double.valueOf(d6));
            int i6 = 1;
            if (1 <= Ke) {
                while (true) {
                    double d7 = dArr[i6];
                    R invoke2 = selector.invoke(Double.valueOf(d7));
                    if (invoke.compareTo(invoke2) > 0) {
                        d6 = d7;
                        invoke = invoke2;
                    }
                    if (i6 == Ke) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Xm(byte[] bArr, Function1<? super Byte, Float> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Byte.valueOf(bArr[i6])).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer Xn(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (comparator.compare(Integer.valueOf(i6), Integer.valueOf(i8)) > 0) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @NotNull
    public static final Pair<List<Double>, List<Double>> Xo(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                arrayList.add(Double.valueOf(d6));
            } else {
                arrayList2.add(Double.valueOf(d6));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final byte Xp(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                b6 = operation.invoke(Integer.valueOf(i6), Byte.valueOf(b6), Byte.valueOf(bArr[i6])).byteValue();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S Xq(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Oe = Oe(tArr);
        if (Oe < 0) {
            return null;
        }
        S s5 = (S) tArr[Oe];
        for (int i6 = Oe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke(Integer.valueOf(i6), (Object) tArr[i6], s5);
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Xr(int[] iArr, R r5, Function2<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r5);
        for (int i6 : iArr) {
            r5 = operation.invoke(r5, Integer.valueOf(i6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Xs(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        Ys(cArr, Random.Default);
    }

    @Nullable
    public static final Short Xt(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Short sh = null;
        boolean z5 = false;
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                if (z5) {
                    return null;
                }
                sh = Short.valueOf(s5);
                z5 = true;
            }
        }
        if (z5) {
            return sh;
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T extends Comparable<? super T>> void Xu(@NotNull T[] tArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.collections.q.i4(tArr, kotlin.comparisons.a.x(), i6, i7);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> Xv(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return fw(tArr, kotlin.comparisons.a.x());
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final <T> double Xw(T[] tArr, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (T t5 : tArr) {
            d6 += selector.invoke(t5).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Byte> Xx(@NotNull byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = bArr.length;
        if (i6 >= length) {
            return Xy(bArr);
        }
        if (i6 == 1) {
            return g0.l(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Byte.valueOf(bArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static List<Byte> Xy(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? hz(bArr) : g0.l(Byte.valueOf(bArr[0])) : h0.J();
    }

    @NotNull
    public static final Iterable<a1<Long>> Xz(@NotNull final long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator fA;
                fA = a0.fA(jArr);
                return fA;
            }
        });
    }

    @NotNull
    public static final <K, V> Map<K, V> Y5(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(dArr.length), 16));
        for (double d6 : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d6));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Byte, V> Y6(byte[] bArr, Function1<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(bArr.length), 16));
        for (byte b6 : bArr) {
            linkedHashMap.put(Byte.valueOf(b6), valueSelector.invoke(Byte.valueOf(b6)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final int Y7(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr[2];
    }

    public static final int Y8(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final List<Byte> Y9(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (byte b6 : bArr) {
            if (z5) {
                arrayList.add(Byte.valueOf(b6));
            } else if (!predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                arrayList.add(Byte.valueOf(b6));
                z5 = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> YA(@NotNull short[] sArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Short.valueOf(sArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C Ya(@NotNull short[] sArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            short s5 = sArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Short.valueOf(s5)).booleanValue()) {
                destination.add(Short.valueOf(s5));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    public static final byte Yb(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return b6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R> List<R> Yc(T[] tArr, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), tArr[i6]));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R Yd(@NotNull byte[] bArr, R r5, @NotNull Function3<? super Integer, ? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Ie = Ie(bArr); Ie >= 0; Ie--) {
            r5 = operation.invoke(Integer.valueOf(Ie), Byte.valueOf(bArr[Ie]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final short Ye(short[] sArr, int i6, Function1<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= sArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).shortValue() : sArr[i6];
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfFirst { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = cn.bluemobi.dylan.photoview.a.f1297f, hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int Yf(float[] fArr, float f6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (f6 == fArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A Yg(@NotNull char[] cArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (char c6 : cArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Character.valueOf(c6)));
            } else {
                buffer.append(c6);
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean Yh(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                boolean z5 = zArr[length];
                if (!predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                } else {
                    return z5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C Yi(@NotNull int[] iArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Yj(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Yk(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> float Yl(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        if (Le != 0) {
            R invoke = selector.invoke(Float.valueOf(f6));
            int i6 = 1;
            if (1 <= Le) {
                while (true) {
                    float f7 = fArr[i6];
                    R invoke2 = selector.invoke(Float.valueOf(f7));
                    if (invoke.compareTo(invoke2) > 0) {
                        f6 = f7;
                        invoke = invoke2;
                    }
                    if (i6 == Le) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Ym(char[] cArr, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(cArr[i6])).floatValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long Yn(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) > 0) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @NotNull
    public static final Pair<List<Float>, List<Float>> Yo(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            } else {
                arrayList2.add(Float.valueOf(f6));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final char Yp(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                c6 = operation.invoke(Integer.valueOf(i6), Character.valueOf(c6), Character.valueOf(cArr[i6])).charValue();
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return c6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short Yq(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Pe = Pe(sArr);
        if (Pe < 0) {
            return null;
        }
        short s5 = sArr[Pe];
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i6]), Short.valueOf(s5)).shortValue();
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> Yr(long[] jArr, R r5, Function2<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r5);
        for (long j6 : jArr) {
            r5 = operation.invoke(r5, Long.valueOf(j6));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Ys(@NotNull char[] cArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Je = Je(cArr); Je > 0; Je--) {
            int nextInt = random.nextInt(Je + 1);
            char c6 = cArr[Je];
            cArr[Je] = cArr[nextInt];
            cArr[nextInt] = c6;
        }
    }

    @NotNull
    public static final List<Byte> Yt(@NotNull byte[] bArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final void Yu(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length > 1) {
            kotlin.collections.q.W3(sArr);
            xr(sArr);
        }
    }

    @NotNull
    public static final List<Short> Yv(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.W3(copyOf);
        return Ir(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Yw(short[] sArr, Function1<? super Short, Double> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (short s5 : sArr) {
            d6 += selector.invoke(Short.valueOf(s5)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Character> Yx(@NotNull char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = cArr.length;
        if (i6 >= length) {
            return Yy(cArr);
        }
        if (i6 == 1) {
            return g0.l(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Character.valueOf(cArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static List<Character> Yy(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? iz(cArr) : g0.l(Character.valueOf(cArr[0])) : h0.J();
    }

    @NotNull
    public static <T> Iterable<a1<T>> Yz(@NotNull final T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator bA;
                bA = a0.bA(tArr);
                return bA;
            }
        });
    }

    @NotNull
    public static final <K, V> Map<K, V> Z5(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(fArr.length), 16));
        for (float f6 : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f6));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Character, V> Z6(char[] cArr, Function1<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(kotlin.ranges.t.B(cArr.length, 128)), 16));
        for (char c6 : cArr) {
            linkedHashMap.put(Character.valueOf(c6), valueSelector.invoke(Character.valueOf(c6)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final long Z7(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr[2];
    }

    @InlineOnly
    private static final <T> int Z8(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr.length;
    }

    @NotNull
    public static final List<Character> Z9(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (char c6 : cArr) {
            if (z5) {
                arrayList.add(Character.valueOf(c6));
            } else if (!predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                arrayList.add(Character.valueOf(c6));
                z5 = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> ZA(@NotNull short[] sArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Short.valueOf(sArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C Za(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            boolean z5 = zArr[i6];
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), Boolean.valueOf(z5)).booleanValue()) {
                destination.add(Boolean.valueOf(z5));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    public static final char Zb(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> Zc(short[] sArr, Function2<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Short.valueOf(sArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R Zd(@NotNull char[] cArr, R r5, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Je = Je(cArr); Je >= 0; Je--) {
            r5 = operation.invoke(Integer.valueOf(Je), Character.valueOf(cArr[Je]), r5);
        }
        return r5;
    }

    @InlineOnly
    private static final boolean Ze(boolean[] zArr, int i6, Function1<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= zArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).booleanValue() : zArr[i6];
    }

    public static int Zf(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int length = iArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i6 == iArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A Zg(@NotNull double[] dArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (double d6 : dArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Double.valueOf(d6)));
            } else {
                buffer.append(String.valueOf(d6));
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static int Zh(@NotNull byte[] bArr, byte b6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (b6 == bArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C Zi(@NotNull long[] jArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Long.valueOf(jArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R Zj(char[] cArr, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R Zk(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i6]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> int Zl(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        if (Me != 0) {
            R invoke = selector.invoke(Integer.valueOf(i6));
            int i7 = 1;
            if (1 <= Me) {
                while (true) {
                    int i8 = iArr[i7];
                    R invoke2 = selector.invoke(Integer.valueOf(i8));
                    if (invoke.compareTo(invoke2) > 0) {
                        i6 = i8;
                        invoke = invoke2;
                    }
                    if (i7 == Me) {
                        break;
                    }
                    i7++;
                }
            }
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float Zm(double[] dArr, Function1<? super Double, Float> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Double.valueOf(dArr[i6])).floatValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T> T Zn(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (comparator.compare(t5, t6) > 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    @NotNull
    public static final Pair<List<Integer>, List<Integer>> Zo(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                arrayList.add(Integer.valueOf(i6));
            } else {
                arrayList2.add(Integer.valueOf(i6));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final double Zp(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = operation.invoke(Integer.valueOf(i6), Double.valueOf(d6), Double.valueOf(dArr[i6])).doubleValue();
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Boolean Zq(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Qe = Qe(zArr);
        if (Qe < 0) {
            return null;
        }
        boolean z5 = zArr[Qe];
        for (int i6 = Qe - 1; i6 >= 0; i6--) {
            z5 = operation.invoke(Boolean.valueOf(zArr[i6]), Boolean.valueOf(z5)).booleanValue();
        }
        return Boolean.valueOf(z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> Zr(@NotNull T[] tArr, R r5, @NotNull Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r5);
        for (H5BaseWebChromeClient h5BaseWebChromeClient : tArr) {
            r5 = operation.invoke(r5, h5BaseWebChromeClient);
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Zs(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        at(dArr, Random.Default);
    }

    @NotNull
    public static final List<Byte> Zt(@NotNull byte[] bArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.n(kotlin.collections.q.f1(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void Zu(@NotNull short[] sArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.collections.q.X3(sArr, i6, i7);
        yr(sArr, i6, i7);
    }

    @NotNull
    public static final List<Byte> Zv(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Byte[] N4 = kotlin.collections.q.N4(bArr);
        kotlin.collections.q.h4(N4, comparator);
        return kotlin.collections.q.t(N4);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Zw(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        double d6 = 0.0d;
        for (boolean z5 : zArr) {
            d6 += selector.invoke(Boolean.valueOf(z5)).doubleValue();
        }
        return d6;
    }

    @NotNull
    public static final List<Double> Zx(@NotNull double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = dArr.length;
        if (i6 >= length) {
            return Zy(dArr);
        }
        if (i6 == 1) {
            return g0.l(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Double.valueOf(dArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static List<Double> Zy(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? jz(dArr) : g0.l(Double.valueOf(dArr[0])) : h0.J();
    }

    @NotNull
    public static final Iterable<a1<Short>> Zz(@NotNull final short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator dA;
                dA = a0.dA(sArr);
                return dA;
            }
        });
    }

    @NotNull
    public static final <K, V> Map<K, V> a6(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(iArr.length), 16));
        for (int i6 : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i6));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Double, V> a7(double[] dArr, Function1<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(dArr.length), 16));
        for (double d6 : dArr) {
            linkedHashMap.put(Double.valueOf(d6), valueSelector.invoke(Double.valueOf(d6)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final <T> T a8(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr[2];
    }

    public static final <T> int a9(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final Iterable<a1<Boolean>> aA(@NotNull final boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return new b1(new Function0() { // from class: kotlin.collections.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator iA;
                iA = a0.iA(zArr);
                return iA;
            }
        });
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> aB(@NotNull short[] sArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            short s5 = sArr[i6];
            arrayList.add(kotlin.o0.a(Short.valueOf(s5), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> aa(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (double d6 : dArr) {
            if (z5) {
                arrayList.add(Double.valueOf(d6));
            } else if (!predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                arrayList.add(Double.valueOf(d6));
                z5 = true;
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R> List<R> ab(Object[] objArr) {
        kotlin.jvm.internal.g0.p(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            kotlin.jvm.internal.g0.y(3, "R");
            if (androidx.activity.k.a(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final char ac(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return c6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterable")
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> ad(boolean[] zArr, Function2<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(arrayList, transform.invoke(Integer.valueOf(i7), Boolean.valueOf(zArr[i6])));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final <R> R ae(@NotNull double[] dArr, R r5, @NotNull Function3<? super Integer, ? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Ke = Ke(dArr); Ke >= 0; Ke--) {
            r5 = operation.invoke(Integer.valueOf(Ke), Double.valueOf(dArr[Ke]), r5);
        }
        return r5;
    }

    @Nullable
    public static final Boolean af(@NotNull boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (i6 < 0 || i6 >= zArr.length) {
            return null;
        }
        return Boolean.valueOf(zArr[i6]);
    }

    public static int ag(@NotNull long[] jArr, long j6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (j6 == jArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A ah(@NotNull float[] fArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (float f6 : fArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Float.valueOf(f6)));
            } else {
                buffer.append(String.valueOf(f6));
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final int ai(@NotNull char[] cArr, char c6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (c6 == cArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C aj(@NotNull T[] tArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), tArr[i6]));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R ak(double[] dArr, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte al(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (b6 < b7) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> long am(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        if (Ne != 0) {
            R invoke = selector.invoke(Long.valueOf(j6));
            int i6 = 1;
            if (1 <= Ne) {
                while (true) {
                    long j7 = jArr[i6];
                    R invoke2 = selector.invoke(Long.valueOf(j7));
                    if (invoke.compareTo(invoke2) > 0) {
                        j6 = j7;
                        invoke = invoke2;
                    }
                    if (i6 == Ne) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float an(float[] fArr, Function1<? super Float, Float> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Float.valueOf(fArr[i6])).floatValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short ao(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (comparator.compare(Short.valueOf(s5), Short.valueOf(s6)) > 0) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @NotNull
    public static final Pair<List<Long>, List<Long>> ap(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            } else {
                arrayList2.add(Long.valueOf(j6));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final float aq(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = operation.invoke(Integer.valueOf(i6), Float.valueOf(f6), Float.valueOf(fArr[i6])).floatValue();
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte ar(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ie = Ie(bArr);
        if (Ie < 0) {
            return null;
        }
        byte b6 = bArr[Ie];
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            b6 = operation.invoke(Byte.valueOf(bArr[i6]), Byte.valueOf(b6)).byteValue();
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> as(short[] sArr, R r5, Function2<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r5);
        for (short s5 : sArr) {
            r5 = operation.invoke(r5, Short.valueOf(s5));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void at(@NotNull double[] dArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Ke = Ke(dArr); Ke > 0; Ke--) {
            int nextInt = random.nextInt(Ke + 1);
            double d6 = dArr[Ke];
            dArr[Ke] = dArr[nextInt];
            dArr[nextInt] = d6;
        }
    }

    @NotNull
    public static final List<Character> au(@NotNull char[] cArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> av(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        Byte[] N4 = kotlin.collections.q.N4(bArr);
        kotlin.collections.q.U3(N4);
        return kotlin.collections.q.t(N4);
    }

    @NotNull
    public static final List<Character> aw(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Character[] O4 = kotlin.collections.q.O4(cArr);
        kotlin.collections.q.h4(O4, comparator);
        return kotlin.collections.q.t(O4);
    }

    @JvmName(name = "sumOfFloat")
    public static final float ax(@NotNull Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        float f6 = 0.0f;
        for (Float f7 : fArr) {
            f6 += f7.floatValue();
        }
        return f6;
    }

    @NotNull
    public static final List<Float> ay(@NotNull float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = fArr.length;
        if (i6 >= length) {
            return az(fArr);
        }
        if (i6 == 1) {
            return g0.l(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Float.valueOf(fArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static List<Float> az(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? kz(fArr) : g0.l(Float.valueOf(fArr[0])) : h0.J();
    }

    @NotNull
    public static final <K, V> Map<K, V> b6(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(jArr.length), 16));
        for (long j6 : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j6));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Float, V> b7(float[] fArr, Function1<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(fArr.length), 16));
        for (float f6 : fArr) {
            linkedHashMap.put(Float.valueOf(f6), valueSelector.invoke(Float.valueOf(f6)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final short b8(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr[2];
    }

    @InlineOnly
    private static final int b9(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr.length;
    }

    @NotNull
    public static final <R, V> List<V> bB(@NotNull short[] sArr, @NotNull R[] other, @NotNull Function2<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> ba(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (float f6 : fArr) {
            if (z5) {
                arrayList.add(Float.valueOf(f6));
            } else if (!predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
                z5 = true;
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C bb(Object[] objArr, C destination) {
        kotlin.jvm.internal.g0.p(objArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (Object obj : objArr) {
            kotlin.jvm.internal.g0.y(3, "R");
            if (androidx.activity.k.a(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final double bc(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C bd(byte[] bArr, C destination, Function2<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Byte.valueOf(bArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final <R> R be(@NotNull float[] fArr, R r5, @NotNull Function3<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Le = Le(fArr); Le >= 0; Le--) {
            r5 = operation.invoke(Integer.valueOf(Le), Float.valueOf(fArr[Le]), r5);
        }
        return r5;
    }

    @Nullable
    public static final Byte bf(@NotNull byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (i6 < 0 || i6 >= bArr.length) {
            return null;
        }
        return Byte.valueOf(bArr[i6]);
    }

    public static <T> int bg(@NotNull T[] tArr, T t5) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        int i6 = 0;
        if (t5 == null) {
            int length = tArr.length;
            while (i6 < length) {
                if (tArr[i6] == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i6 < length2) {
            if (kotlin.jvm.internal.g0.g(t5, tArr[i6])) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A bh(@NotNull int[] iArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (int i8 : iArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Integer.valueOf(i8)));
            } else {
                buffer.append(String.valueOf(i8));
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfLast { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = cn.bluemobi.dylan.photoview.a.f1297f, hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int bi(double[] dArr, double d6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (d6 == dArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C bj(@NotNull short[] sArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Short.valueOf(sArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R bk(float[] fArr, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character bl(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (kotlin.jvm.internal.g0.t(c6, c7) < 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T bm(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        if (Oe != 0) {
            R invoke = selector.invoke(t5);
            int i6 = 1;
            if (1 <= Oe) {
                while (true) {
                    T t6 = tArr[i6];
                    R invoke2 = selector.invoke(t6);
                    if (invoke.compareTo(invoke2) > 0) {
                        t5 = t6;
                        invoke = invoke2;
                    }
                    if (i6 == Oe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float bn(int[] iArr, Function1<? super Integer, Float> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Integer.valueOf(iArr[i6])).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final byte bo(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (comparator.compare(Byte.valueOf(b6), Byte.valueOf(b7)) > 0) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return b6;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> bp(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            } else {
                arrayList2.add(t5);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final int bq(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                i6 = operation.invoke(Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(iArr[i7])).intValue();
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character br(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Je = Je(cArr);
        if (Je < 0) {
            return null;
        }
        char c6 = cArr[Je];
        for (int i6 = Je - 1; i6 >= 0; i6--) {
            c6 = operation.invoke(Character.valueOf(cArr[i6]), Character.valueOf(c6)).charValue();
        }
        return Character.valueOf(c6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> bs(boolean[] zArr, R r5, Function2<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r5);
        for (boolean z5 : zArr) {
            r5 = operation.invoke(r5, Boolean.valueOf(z5));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void bt(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        ct(fArr, Random.Default);
    }

    @NotNull
    public static final List<Character> bu(@NotNull char[] cArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.o(kotlin.collections.q.g1(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Character> bv(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        Character[] O4 = kotlin.collections.q.O4(cArr);
        kotlin.collections.q.U3(O4);
        return kotlin.collections.q.t(O4);
    }

    @NotNull
    public static final List<Double> bw(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Double[] P4 = kotlin.collections.q.P4(dArr);
        kotlin.collections.q.h4(P4, comparator);
        return kotlin.collections.q.t(P4);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int bx(byte[] bArr, Function1<? super Byte, Integer> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (byte b6 : bArr) {
            i6 += selector.invoke(Byte.valueOf(b6)).intValue();
        }
        return i6;
    }

    @NotNull
    public static List<Integer> bz(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? lz(iArr) : g0.l(Integer.valueOf(iArr[0])) : h0.J();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> c6(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(tArr.length), 16));
        for (H5BaseWebChromeClient h5BaseWebChromeClient : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(h5BaseWebChromeClient);
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Integer, V> c7(int[] iArr, Function1<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(iArr.length), 16));
        for (int i6 : iArr) {
            linkedHashMap.put(Integer.valueOf(i6), valueSelector.invoke(Integer.valueOf(i6)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final boolean c8(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr[2];
    }

    public static final int c9(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final List<Pair<Short, Short>> cB(@NotNull short[] sArr, @NotNull short[] other) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Short.valueOf(sArr[i6]), Short.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> ca(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (int i6 : iArr) {
            if (z5) {
                arrayList.add(Integer.valueOf(i6));
            } else if (!predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                arrayList.add(Integer.valueOf(i6));
                z5 = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> cb(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b6 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                arrayList.add(Byte.valueOf(b6));
            }
        }
        return arrayList;
    }

    public static final double cc(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return d6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C cd(char[] cArr, C destination, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Character.valueOf(cArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final <R> R ce(@NotNull int[] iArr, R r5, @NotNull Function3<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Me = Me(iArr); Me >= 0; Me--) {
            r5 = operation.invoke(Integer.valueOf(Me), Integer.valueOf(iArr[Me]), r5);
        }
        return r5;
    }

    @Nullable
    public static final Character cf(@NotNull char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (i6 < 0 || i6 >= cArr.length) {
            return null;
        }
        return Character.valueOf(cArr[i6]);
    }

    public static int cg(@NotNull short[] sArr, short s5) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (s5 == sArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A ch(@NotNull long[] jArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (long j6 : jArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Long.valueOf(j6)));
            } else {
                buffer.append(String.valueOf(j6));
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfLast { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = cn.bluemobi.dylan.photoview.a.f1297f, hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int ci(float[] fArr, float f6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (f6 == fArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C cj(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            destination.add(transform.invoke(Integer.valueOf(i7), Boolean.valueOf(zArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R ck(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T extends Comparable<? super T>> T cl(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (t5.compareTo(t6) < 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> short cm(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        if (Pe != 0) {
            R invoke = selector.invoke(Short.valueOf(s5));
            int i6 = 1;
            if (1 <= Pe) {
                while (true) {
                    short s6 = sArr[i6];
                    R invoke2 = selector.invoke(Short.valueOf(s6));
                    if (invoke.compareTo(invoke2) > 0) {
                        s5 = s6;
                        invoke = invoke2;
                    }
                    if (i6 == Pe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float cn(long[] jArr, Function1<? super Long, Float> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Long.valueOf(jArr[i6])).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final char co(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (comparator.compare(Character.valueOf(c6), Character.valueOf(c7)) > 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return c6;
    }

    @NotNull
    public static final Pair<List<Short>, List<Short>> cp(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                arrayList.add(Short.valueOf(s5));
            } else {
                arrayList2.add(Short.valueOf(s5));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final long cq(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                j6 = operation.invoke(Integer.valueOf(i6), Long.valueOf(j6), Long.valueOf(jArr[i6])).longValue();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double cr(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ke = Ke(dArr);
        if (Ke < 0) {
            return null;
        }
        double d6 = dArr[Ke];
        for (int i6 = Ke - 1; i6 >= 0; i6--) {
            d6 = operation.invoke(Double.valueOf(dArr[i6]), Double.valueOf(d6)).doubleValue();
        }
        return Double.valueOf(d6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> cs(byte[] bArr, R r5, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r5);
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Byte.valueOf(bArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void ct(@NotNull float[] fArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Le = Le(fArr); Le > 0; Le--) {
            int nextInt = random.nextInt(Le + 1);
            float f6 = fArr[Le];
            fArr[Le] = fArr[nextInt];
            fArr[nextInt] = f6;
        }
    }

    @NotNull
    public static final List<Double> cu(@NotNull double[] dArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> cv(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        Double[] P4 = kotlin.collections.q.P4(dArr);
        kotlin.collections.q.U3(P4);
        return kotlin.collections.q.t(P4);
    }

    @NotNull
    public static final List<Float> cw(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Float[] Q4 = kotlin.collections.q.Q4(fArr);
        kotlin.collections.q.h4(Q4, comparator);
        return kotlin.collections.q.t(Q4);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int cx(char[] cArr, Function1<? super Character, Integer> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (char c6 : cArr) {
            i6 += selector.invoke(Character.valueOf(c6)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Integer> cy(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = iArr.length;
        if (i6 >= length) {
            return bz(iArr);
        }
        if (i6 == 1) {
            return g0.l(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Integer.valueOf(iArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static List<Long> cz(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? mz(jArr) : g0.l(Long.valueOf(jArr[0])) : h0.J();
    }

    public static final boolean d5(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K, V> Map<K, V> d6(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(sArr.length), 16));
        for (short s5 : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s5));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Long, V> d7(long[] jArr, Function1<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(jArr.length), 16));
        for (long j6 : jArr) {
            linkedHashMap.put(Long.valueOf(j6), valueSelector.invoke(Long.valueOf(j6)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final byte d8(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr[3];
    }

    @InlineOnly
    private static final int d9(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr.length;
    }

    @NotNull
    public static final <V> List<V> dB(@NotNull short[] sArr, @NotNull short[] other, @NotNull Function2<? super Short, ? super Short, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i6]), Short.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> da(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (long j6 : jArr) {
            if (z5) {
                arrayList.add(Long.valueOf(j6));
            } else if (!predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
                z5 = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> db(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c6 : cArr) {
            if (!predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                arrayList.add(Character.valueOf(c6));
            }
        }
        return arrayList;
    }

    public static final float dc(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C dd(double[] dArr, C destination, Function2<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Double.valueOf(dArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final <R> R de(@NotNull long[] jArr, R r5, @NotNull Function3<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Ne = Ne(jArr); Ne >= 0; Ne--) {
            r5 = operation.invoke(Integer.valueOf(Ne), Long.valueOf(jArr[Ne]), r5);
        }
        return r5;
    }

    @Nullable
    public static final Double df(@NotNull double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (i6 < 0 || i6 >= dArr.length) {
            return null;
        }
        return Double.valueOf(dArr[i6]);
    }

    public static final int dg(@NotNull boolean[] zArr, boolean z5) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (z5 == zArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T, A extends Appendable> A dh(@NotNull T[] tArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (T t5 : tArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            kotlin.text.u.b(buffer, t5, function1);
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static int di(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (i6 == iArr[length]) {
                    return length;
                }
                if (i7 < 0) {
                    break;
                }
                length = i7;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T, R> List<R> dj(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            R invoke = transform.invoke(t5);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R dk(long[] jArr, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double dl(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = Math.max(d6, dArr[i6]);
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> boolean dm(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        if (Qe != 0) {
            R invoke = selector.invoke(Boolean.valueOf(z5));
            int i6 = 1;
            if (1 <= Qe) {
                while (true) {
                    boolean z6 = zArr[i6];
                    R invoke2 = selector.invoke(Boolean.valueOf(z6));
                    if (invoke.compareTo(invoke2) > 0) {
                        z5 = z6;
                        invoke = invoke2;
                    }
                    if (i6 == Qe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return z5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Float dn(T[] tArr, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(tArr[i6]).floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @NotNull
    public static final Pair<List<Boolean>, List<Boolean>> dp(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z5));
            } else {
                arrayList2.add(Boolean.valueOf(z5));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final <S, T extends S> S dq(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s5 = (Object) tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                s5 = operation.invoke(Integer.valueOf(i6), s5, (Object) tArr[i6]);
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float dr(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Le = Le(fArr);
        if (Le < 0) {
            return null;
        }
        float f6 = fArr[Le];
        for (int i6 = Le - 1; i6 >= 0; i6--) {
            f6 = operation.invoke(Float.valueOf(fArr[i6]), Float.valueOf(f6)).floatValue();
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> ds(char[] cArr, R r5, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r5);
        int length = cArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Character.valueOf(cArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void dt(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        et(iArr, Random.Default);
    }

    @NotNull
    public static final List<Double> du(@NotNull double[] dArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.p(kotlin.collections.q.h1(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Float> dv(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        Float[] Q4 = kotlin.collections.q.Q4(fArr);
        kotlin.collections.q.U3(Q4);
        return kotlin.collections.q.t(Q4);
    }

    @NotNull
    public static final List<Integer> dw(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Integer[] R4 = kotlin.collections.q.R4(iArr);
        kotlin.collections.q.h4(R4, comparator);
        return kotlin.collections.q.t(R4);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int dx(double[] dArr, Function1<? super Double, Integer> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (double d6 : dArr) {
            i6 += selector.invoke(Double.valueOf(d6)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Long> dy(@NotNull long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = jArr.length;
        if (i6 >= length) {
            return cz(jArr);
        }
        if (i6 == 1) {
            return g0.l(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Long.valueOf(jArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> dz(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? nz(tArr) : g0.l(tArr[0]) : h0.J();
    }

    public static final boolean e5(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (!predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K, V> Map<K, V> e6(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(zArr.length), 16));
        for (boolean z5 : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z5));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <K, V> Map<K, V> e7(@NotNull K[] kArr, @NotNull Function1<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(kArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(kArr.length), 16));
        for (K k6 : kArr) {
            linkedHashMap.put(k6, valueSelector.invoke(k6));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final char e8(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr[3];
    }

    public static final int e9(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int i6 = 0;
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> eB(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Boolean.valueOf(zArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> ea(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (T t5 : tArr) {
            if (z5) {
                arrayList.add(t5);
            } else if (!predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
                z5 = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> eb(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d6 : dArr) {
            if (!predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                arrayList.add(Double.valueOf(d6));
            }
        }
        return arrayList;
    }

    public static final float ec(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return f6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C ed(float[] fArr, C destination, Function2<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Float.valueOf(fArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R ee(@NotNull T[] tArr, R r5, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Oe = Oe(tArr); Oe >= 0; Oe--) {
            r5 = operation.invoke(Integer.valueOf(Oe), tArr[Oe], r5);
        }
        return r5;
    }

    @Nullable
    public static final Float ef(@NotNull float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (i6 < 0 || i6 >= fArr.length) {
            return null;
        }
        return Float.valueOf(fArr[i6]);
    }

    public static final int eg(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Byte.valueOf(bArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A eh(@NotNull short[] sArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (short s5 : sArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Short.valueOf(s5)));
            } else {
                buffer.append(String.valueOf((int) s5));
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static int ei(@NotNull long[] jArr, long j6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (j6 == jArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C ej(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (T t5 : tArr) {
            R invoke = transform.invoke(t5);
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R ek(T[] tArr, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                R invoke2 = selector.invoke(tArr[i6]);
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double el(@NotNull Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        int Oe = Oe(dArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.max(doubleValue, dArr[i6].doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double em(byte[] bArr, Function1<? super Byte, Double> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Byte.valueOf(bArr[i6])).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float en(short[] sArr, Function1<? super Short, Float> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Short.valueOf(sArr[i6])).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final double eo(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                if (comparator.compare(Double.valueOf(d6), Double.valueOf(d7)) > 0) {
                    d6 = d7;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final byte ep(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return fp(bArr, Random.Default);
    }

    public static final short eq(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                s5 = operation.invoke(Integer.valueOf(i6), Short.valueOf(s5), Short.valueOf(sArr[i6])).shortValue();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer er(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Me = Me(iArr);
        if (Me < 0) {
            return null;
        }
        int i6 = iArr[Me];
        for (int i7 = Me - 1; i7 >= 0; i7--) {
            i6 = operation.invoke(Integer.valueOf(iArr[i7]), Integer.valueOf(i6)).intValue();
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> es(double[] dArr, R r5, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r5);
        int length = dArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Double.valueOf(dArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void et(@NotNull int[] iArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Me = Me(iArr); Me > 0; Me--) {
            int nextInt = random.nextInt(Me + 1);
            int i6 = iArr[Me];
            iArr[Me] = iArr[nextInt];
            iArr[nextInt] = i6;
        }
    }

    @NotNull
    public static final List<Float> eu(@NotNull float[] fArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> ev(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        Integer[] R4 = kotlin.collections.q.R4(iArr);
        kotlin.collections.q.U3(R4);
        return kotlin.collections.q.t(R4);
    }

    @NotNull
    public static final List<Long> ew(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Long[] S4 = kotlin.collections.q.S4(jArr);
        kotlin.collections.q.h4(S4, comparator);
        return kotlin.collections.q.t(S4);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int ex(float[] fArr, Function1<? super Float, Integer> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (float f6 : fArr) {
            i6 += selector.invoke(Float.valueOf(f6)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final <T> List<T> ey(@NotNull T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = tArr.length;
        if (i6 >= length) {
            return dz(tArr);
        }
        if (i6 == 1) {
            return g0.l(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(tArr[i7]);
        }
        return arrayList;
    }

    @NotNull
    public static List<Short> ez(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? oz(sArr) : g0.l(Short.valueOf(sArr[0])) : h0.J();
    }

    public static final boolean f5(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (!predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K> Map<K, Byte> f6(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(bArr.length), 16));
        for (byte b6 : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b6)), Byte.valueOf(b6));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Short, V> f7(short[] sArr, Function1<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(sArr.length), 16));
        for (short s5 : sArr) {
            linkedHashMap.put(Short.valueOf(s5), valueSelector.invoke(Short.valueOf(s5)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final double f8(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr[3];
    }

    @NotNull
    public static final List<Byte> f9(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return r0.a6(qz(bArr));
    }

    @NotNull
    public static final <R, V> List<V> fB(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> fa(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (short s5 : sArr) {
            if (z5) {
                arrayList.add(Short.valueOf(s5));
            } else if (!predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                arrayList.add(Short.valueOf(s5));
                z5 = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> fb(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (!predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            }
        }
        return arrayList;
    }

    public static int fc(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C fd(int[] iArr, C destination, Function2<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final <R> R fe(@NotNull short[] sArr, R r5, @NotNull Function3<? super Integer, ? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Pe = Pe(sArr); Pe >= 0; Pe--) {
            r5 = operation.invoke(Integer.valueOf(Pe), Short.valueOf(sArr[Pe]), r5);
        }
        return r5;
    }

    @Nullable
    public static Integer ff(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (i6 < 0 || i6 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i6]);
    }

    public static final int fg(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = cArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Character.valueOf(cArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <A extends Appendable> A fh(@NotNull boolean[] zArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(buffer, "buffer");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        buffer.append(prefix);
        int i7 = 0;
        for (boolean z5 : zArr) {
            i7++;
            if (i7 > 1) {
                buffer.append(separator);
            }
            if (i6 >= 0 && i7 > i6) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Boolean.valueOf(z5)));
            } else {
                buffer.append(String.valueOf(z5));
            }
        }
        if (i6 >= 0 && i7 > i6) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> int fi(@NotNull T[] tArr, T t5) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (t5 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i7 = length2 - 1;
                    if (kotlin.jvm.internal.g0.g(t5, tArr[length2])) {
                        return length2;
                    }
                    if (i7 < 0) {
                        break;
                    }
                    length2 = i7;
                }
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C fj(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (byte b6 : bArr) {
            destination.add(transform.invoke(Byte.valueOf(b6)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R fk(short[] sArr, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float fl(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = Math.max(f6, fArr[i6]);
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double fm(char[] cArr, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(cArr[i6])).doubleValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float fn(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Boolean.valueOf(zArr[i6])).floatValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final float fo(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) > 0) {
                    f6 = f7;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return f6;
    }

    @SinceKotlin(version = "1.3")
    public static final byte fp(@NotNull byte[] bArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (bArr.length != 0) {
            return bArr[random.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final boolean fq(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                z5 = operation.invoke(Integer.valueOf(i6), Boolean.valueOf(z5), Boolean.valueOf(zArr[i6])).booleanValue();
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return z5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long fr(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ne = Ne(jArr);
        if (Ne < 0) {
            return null;
        }
        long j6 = jArr[Ne];
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            j6 = operation.invoke(Long.valueOf(jArr[i6]), Long.valueOf(j6)).longValue();
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> fs(float[] fArr, R r5, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r5);
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Float.valueOf(fArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void ft(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        gt(jArr, Random.Default);
    }

    @NotNull
    public static final List<Float> fu(@NotNull float[] fArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.q(kotlin.collections.q.i1(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Long> fv(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        Long[] S4 = kotlin.collections.q.S4(jArr);
        kotlin.collections.q.U3(S4);
        return kotlin.collections.q.t(S4);
    }

    @NotNull
    public static <T> List<T> fw(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return kotlin.collections.q.t(yv(tArr, comparator));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int fx(int[] iArr, Function1<? super Integer, Integer> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (int i7 : iArr) {
            i6 += selector.invoke(Integer.valueOf(i7)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Short> fy(@NotNull short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = sArr.length;
        if (i6 >= length) {
            return ez(sArr);
        }
        if (i6 == 1) {
            return g0.l(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Short.valueOf(sArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static List<Boolean> fz(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? pz(zArr) : g0.l(Boolean.valueOf(zArr[0])) : h0.J();
    }

    public static final boolean g5(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (!predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K, V> Map<K, V> g6(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(bArr.length), 16));
        for (byte b6 : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b6)), valueTransform.invoke(Byte.valueOf(b6)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V> Map<Boolean, V> g7(boolean[] zArr, Function1<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(zArr.length), 16));
        for (boolean z5 : zArr) {
            linkedHashMap.put(Boolean.valueOf(z5), valueSelector.invoke(Boolean.valueOf(z5)));
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final float g8(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr[3];
    }

    @NotNull
    public static final List<Character> g9(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return r0.a6(rz(cArr));
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> gB(@NotNull boolean[] zArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            boolean z5 = zArr[i6];
            arrayList.add(kotlin.o0.a(Boolean.valueOf(z5), other[i6]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> ga(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z5 = false;
        for (boolean z6 : zArr) {
            if (z5) {
                arrayList.add(Boolean.valueOf(z6));
            } else if (!predicate.invoke(Boolean.valueOf(z6)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z6));
                z5 = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> gb(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        return arrayList;
    }

    public static final int gc(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                return i6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C gd(long[] jArr, C destination, Function2<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Long.valueOf(jArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final <R> R ge(@NotNull boolean[] zArr, R r5, @NotNull Function3<? super Integer, ? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (int Qe = Qe(zArr); Qe >= 0; Qe--) {
            r5 = operation.invoke(Integer.valueOf(Qe), Boolean.valueOf(zArr[Qe]), r5);
        }
        return r5;
    }

    @Nullable
    public static final Long gf(@NotNull long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (i6 < 0 || i6 >= jArr.length) {
            return null;
        }
        return Long.valueOf(jArr[i6]);
    }

    public static final int gg(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = dArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Double.valueOf(dArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public static int gi(@NotNull short[] sArr, short s5) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (s5 == sArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C gj(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (char c6 : cArr) {
            destination.add(transform.invoke(Character.valueOf(c6)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R gk(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float gl(@NotNull Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        int Oe = Oe(fArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.max(floatValue, fArr[i6].floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double gm(double[] dArr, Function1<? super Double, Double> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Double.valueOf(dArr[i6])).doubleValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R gn(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final int go(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (comparator.compare(Integer.valueOf(i6), Integer.valueOf(i8)) > 0) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char gp(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return hp(cArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Boolean gq(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                z5 = operation.invoke(Integer.valueOf(i6), Boolean.valueOf(z5), Boolean.valueOf(zArr[i6])).booleanValue();
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S gr(@NotNull T[] tArr, @NotNull Function2<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Oe = Oe(tArr);
        if (Oe < 0) {
            return null;
        }
        S s5 = (S) tArr[Oe];
        for (int i6 = Oe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke((Object) tArr[i6], s5);
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> gs(int[] iArr, R r5, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r5);
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Integer.valueOf(iArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void gt(@NotNull long[] jArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Ne = Ne(jArr); Ne > 0; Ne--) {
            int nextInt = random.nextInt(Ne + 1);
            long j6 = jArr[Ne];
            jArr[Ne] = jArr[nextInt];
            jArr[nextInt] = j6;
        }
    }

    @NotNull
    public static final List<Integer> gu(@NotNull int[] iArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> gv(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return kotlin.collections.q.t(ov(tArr));
    }

    @NotNull
    public static final List<Short> gw(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Short[] T4 = kotlin.collections.q.T4(sArr);
        kotlin.collections.q.h4(T4, comparator);
        return kotlin.collections.q.t(T4);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int gx(long[] jArr, Function1<? super Long, Integer> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (long j6 : jArr) {
            i6 += selector.invoke(Long.valueOf(j6)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Boolean> gy(@NotNull boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return h0.J();
        }
        int length = zArr.length;
        if (i6 >= length) {
            return fz(zArr);
        }
        if (i6 == 1) {
            return g0.l(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = length - i6; i7 < length; i7++) {
            arrayList.add(Boolean.valueOf(zArr[i7]));
        }
        return arrayList;
    }

    @NotNull
    public static final long[] gz(@NotNull Long[] lArr) {
        kotlin.jvm.internal.g0.p(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i6 = 0; i6 < length; i6++) {
            jArr[i6] = lArr[i6].longValue();
        }
        return jArr;
    }

    public static final boolean h5(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K> Map<K, Character> h6(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(cArr.length), 16));
        for (char c6 : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c6)), Character.valueOf(c6));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Byte, ? super V>> M h7(byte[] bArr, M destination, Function1<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (byte b6 : bArr) {
            destination.put(Byte.valueOf(b6), valueSelector.invoke(Byte.valueOf(b6)));
        }
        return destination;
    }

    @InlineOnly
    private static final int h8(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr[3];
    }

    @NotNull
    public static final List<Double> h9(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return r0.a6(sz(dArr));
    }

    @NotNull
    public static final <R, V> List<V> hB(@NotNull boolean[] zArr, @NotNull R[] other, @NotNull Function2<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @InlineOnly
    private static final byte ha(byte[] bArr, int i6, Function1<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= bArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).byteValue() : bArr[i6];
    }

    @NotNull
    public static final List<Long> hb(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (!predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            }
        }
        return arrayList;
    }

    public static long hc(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C hd(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), tArr[i6]));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final void he(@NotNull byte[] bArr, @NotNull Function1<? super Byte, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (byte b6 : bArr) {
            action.invoke(Byte.valueOf(b6));
        }
    }

    @Nullable
    public static <T> T hf(@NotNull T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (i6 < 0 || i6 >= tArr.length) {
            return null;
        }
        return tArr[i6];
    }

    public static final int hg(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Float.valueOf(fArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public static final int hi(@NotNull boolean[] zArr, boolean z5) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (z5 == zArr[length]) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C hj(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (double d6 : dArr) {
            destination.add(transform.invoke(Double.valueOf(d6)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R hk(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer hl(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (i6 < i8) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double hm(float[] fArr, Function1<? super Float, Double> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Float.valueOf(fArr[i6])).doubleValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R hn(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final long ho(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) > 0) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return j6;
    }

    @SinceKotlin(version = "1.3")
    public static final char hp(@NotNull char[] cArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (cArr.length != 0) {
            return cArr[random.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte hq(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                b6 = operation.invoke(Integer.valueOf(i6), Byte.valueOf(b6), Byte.valueOf(bArr[i6])).byteValue();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short hr(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Pe = Pe(sArr);
        if (Pe < 0) {
            return null;
        }
        short s5 = sArr[Pe];
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            s5 = operation.invoke(Short.valueOf(sArr[i6]), Short.valueOf(s5)).shortValue();
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> hs(long[] jArr, R r5, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r5);
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Long.valueOf(jArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T> void ht(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        jt(tArr, Random.Default);
    }

    @NotNull
    public static final List<Integer> hu(@NotNull int[] iArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.r(kotlin.collections.q.j1(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Short> hv(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        Short[] T4 = kotlin.collections.q.T4(sArr);
        kotlin.collections.q.U3(T4);
        return kotlin.collections.q.t(T4);
    }

    @NotNull
    public static final List<Boolean> hw(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Boolean[] M4 = kotlin.collections.q.M4(zArr);
        kotlin.collections.q.h4(M4, comparator);
        return kotlin.collections.q.t(M4);
    }

    @JvmName(name = "sumOfInt")
    public static final int hx(@NotNull Integer[] numArr) {
        kotlin.jvm.internal.g0.p(numArr, "<this>");
        int i6 = 0;
        for (Integer num : numArr) {
            i6 += num.intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Byte> hy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Ie = Ie(bArr); -1 < Ie; Ie--) {
            if (!predicate.invoke(Byte.valueOf(bArr[Ie])).booleanValue()) {
                return x9(bArr, Ie + 1);
            }
        }
        return Xy(bArr);
    }

    @NotNull
    public static final List<Byte> hz(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b6 : bArr) {
            arrayList.add(Byte.valueOf(b6));
        }
        return arrayList;
    }

    public static final boolean i5(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (!predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K, V> Map<K, V> i6(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(cArr.length), 16));
        for (char c6 : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c6)), valueTransform.invoke(Character.valueOf(c6)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Character, ? super V>> M i7(char[] cArr, M destination, Function1<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (char c6 : cArr) {
            destination.put(Character.valueOf(c6), valueSelector.invoke(Character.valueOf(c6)));
        }
        return destination;
    }

    @InlineOnly
    private static final long i8(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr[3];
    }

    @NotNull
    public static final List<Float> i9(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return r0.a6(tz(fArr));
    }

    @NotNull
    public static final List<Pair<Boolean, Boolean>> iB(@NotNull boolean[] zArr, @NotNull boolean[] other) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Boolean.valueOf(zArr[i6]), Boolean.valueOf(other[i6])));
        }
        return arrayList;
    }

    @InlineOnly
    private static final char ia(char[] cArr, int i6, Function1<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= cArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).charValue() : cArr[i6];
    }

    @NotNull
    public static final <T> List<T> ib(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            if (!predicate.invoke(t5).booleanValue()) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    public static final long ic(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return j6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C id(short[] sArr, C destination, Function2<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Short.valueOf(sArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final void ie(@NotNull char[] cArr, @NotNull Function1<? super Character, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (char c6 : cArr) {
            action.invoke(Character.valueOf(c6));
        }
    }

    public static final int ig(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Integer.valueOf(iArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @Nullable
    public static final Boolean ii(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C ij(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (float f6 : fArr) {
            destination.add(transform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R ik(char[] cArr, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long il(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (j6 < j7) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double im(int[] iArr, Function1<? super Integer, Double> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Integer.valueOf(iArr[i6])).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R in(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final <T> T io(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (comparator.compare(t5, t6) > 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final double ip(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return jp(dArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character iq(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                c6 = operation.invoke(Integer.valueOf(i6), Character.valueOf(c6), Character.valueOf(cArr[i6])).charValue();
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    @NotNull
    public static final <T> T[] ir(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        for (T t5 : tArr) {
            if (t5 == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T, R> List<R> is(@NotNull T[] tArr, R r5, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r5);
        int length = tArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, tArr[i6]);
            arrayList.add(r5);
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> iu(@NotNull long[] jArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final byte[] iv(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.G3(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Byte> iw(@NotNull byte[] bArr, @NotNull Iterable<Byte> other) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Byte> qz = qz(bArr);
        m0.J0(qz, other);
        return qz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final <T> int ix(T[] tArr, Function1<? super T, Integer> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (T t5 : tArr) {
            i6 += selector.invoke(t5).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Character> iy(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Je = Je(cArr); -1 < Je; Je--) {
            if (!predicate.invoke(Character.valueOf(cArr[Je])).booleanValue()) {
                return y9(cArr, Je + 1);
            }
        }
        return Yy(cArr);
    }

    @NotNull
    public static final List<Character> iz(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c6 : cArr) {
            arrayList.add(Character.valueOf(c6));
        }
        return arrayList;
    }

    public static final <T> boolean j5(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (!predicate.invoke(t5).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K> Map<K, Double> j6(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(dArr.length), 16));
        for (double d6 : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d6)), Double.valueOf(d6));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Double, ? super V>> M j7(double[] dArr, M destination, Function1<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (double d6 : dArr) {
            destination.put(Double.valueOf(d6), valueSelector.invoke(Double.valueOf(d6)));
        }
        return destination;
    }

    @InlineOnly
    private static final <T> T j8(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr[3];
    }

    @NotNull
    public static final List<Integer> j9(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return r0.a6(uz(iArr));
    }

    @NotNull
    public static final <V> List<V> jB(@NotNull boolean[] zArr, @NotNull boolean[] other, @NotNull Function2<? super Boolean, ? super Boolean, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i6]), Boolean.valueOf(other[i6])));
        }
        return arrayList;
    }

    @InlineOnly
    private static final double ja(double[] dArr, int i6, Function1<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= dArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).doubleValue() : dArr[i6];
    }

    @NotNull
    public static final List<Short> jb(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s5 : sArr) {
            if (!predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                arrayList.add(Short.valueOf(s5));
            }
        }
        return arrayList;
    }

    public static <T> T jc(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C jd(boolean[] zArr, C destination, Function2<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i7), Boolean.valueOf(zArr[i6])));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final void je(@NotNull double[] dArr, @NotNull Function1<? super Double, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (double d6 : dArr) {
            action.invoke(Double.valueOf(d6));
        }
    }

    @Nullable
    public static final Short jf(@NotNull short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (i6 < 0 || i6 >= sArr.length) {
            return null;
        }
        return Short.valueOf(sArr[i6]);
    }

    public static final int jg(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Long.valueOf(jArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @Nullable
    public static final Boolean ji(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            boolean z5 = zArr[length];
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return Boolean.valueOf(z5);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C jj(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 : iArr) {
            destination.add(transform.invoke(Integer.valueOf(i6)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R jk(double[] dArr, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short jl(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (s5 < s6) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double jm(long[] jArr, Function1<? super Long, Double> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Long.valueOf(jArr[i6])).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R jn(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final short jo(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (comparator.compare(Short.valueOf(s5), Short.valueOf(s6)) > 0) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = "1.3")
    public static final double jp(@NotNull double[] dArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (dArr.length != 0) {
            return dArr[random.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double jq(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = operation.invoke(Integer.valueOf(i6), Double.valueOf(d6), Double.valueOf(dArr[i6])).doubleValue();
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    public static void jr(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Ie = Ie(bArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            byte b6 = bArr[i6];
            bArr[i6] = bArr[Ie];
            bArr[Ie] = b6;
            Ie--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> js(short[] sArr, R r5, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r5);
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Short.valueOf(sArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T> void jt(@NotNull T[] tArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Oe = Oe(tArr); Oe > 0; Oe--) {
            int nextInt = random.nextInt(Oe + 1);
            T t5 = tArr[Oe];
            tArr[Oe] = tArr[nextInt];
            tArr[nextInt] = t5;
        }
    }

    @NotNull
    public static final List<Long> ju(@NotNull long[] jArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.s(kotlin.collections.q.k1(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final char[] jv(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.I3(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Character> jw(@NotNull char[] cArr, @NotNull Iterable<Character> other) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Character> rz = rz(cArr);
        m0.J0(rz, other);
        return rz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int jx(short[] sArr, Function1<? super Short, Integer> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (short s5 : sArr) {
            i6 += selector.invoke(Short.valueOf(s5)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Double> jy(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Ke = Ke(dArr); -1 < Ke; Ke--) {
            if (!predicate.invoke(Double.valueOf(dArr[Ke])).booleanValue()) {
                return z9(dArr, Ke + 1);
            }
        }
        return Zy(dArr);
    }

    @NotNull
    public static final List<Double> jz(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d6 : dArr) {
            arrayList.add(Double.valueOf(d6));
        }
        return arrayList;
    }

    public static final boolean k5(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (!predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K, V> Map<K, V> k6(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(dArr.length), 16));
        for (double d6 : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d6)), valueTransform.invoke(Double.valueOf(d6)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Float, ? super V>> M k7(float[] fArr, M destination, Function1<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (float f6 : fArr) {
            destination.put(Float.valueOf(f6), valueSelector.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    @InlineOnly
    private static final short k8(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr[3];
    }

    @NotNull
    public static final List<Long> k9(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return r0.a6(vz(jArr));
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> kA(@NotNull byte[] bArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Byte.valueOf(bArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @InlineOnly
    private static final float ka(float[] fArr, int i6, Function1<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= fArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).floatValue() : fArr[i6];
    }

    @NotNull
    public static final List<Boolean> kb(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z5 : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z5));
            }
        }
        return arrayList;
    }

    public static final <T> T kc(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequence")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R> List<R> kd(T[] tArr, Function2<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.t0(arrayList, transform.invoke(Integer.valueOf(i7), tArr[i6]));
            i6++;
            i7++;
        }
        return arrayList;
    }

    public static final void ke(@NotNull float[] fArr, @NotNull Function1<? super Float, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (float f6 : fArr) {
            action.invoke(Float.valueOf(f6));
        }
    }

    @NotNull
    public static final <K> Map<K, List<Byte>> kf(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b6 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b6));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b6));
        }
        return linkedHashMap;
    }

    public static final <T> int kg(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = tArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(tArr[i6]).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @Nullable
    public static final Byte ki(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C kj(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (long j6 : jArr) {
            destination.add(transform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R kk(float[] fArr, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final byte kl(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (b6 < b7) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double km(T[] tArr, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(tArr[i6]).doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R kn(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final boolean ko(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                if (comparator.compare(Boolean.valueOf(z5), Boolean.valueOf(z6)) > 0) {
                    z5 = z6;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return z5;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final float kp(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return lp(fArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float kq(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = operation.invoke(Integer.valueOf(i6), Float.valueOf(f6), Float.valueOf(fArr[i6])).floatValue();
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void kr(@NotNull byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, bArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            byte b6 = bArr[i6];
            bArr[i6] = bArr[i9];
            bArr[i9] = b6;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <R> List<R> ks(boolean[] zArr, R r5, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return g0.l(r5);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r5);
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, Boolean.valueOf(zArr[i6]));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void kt(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        lt(sArr, Random.Default);
    }

    @NotNull
    public static final <T> List<T> ku(@NotNull T[] tArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    @NotNull
    public static final double[] kv(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.K3(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Double> kw(@NotNull double[] dArr, @NotNull Iterable<Double> other) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Double> sz = sz(dArr);
        m0.J0(sz, other);
        return sz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int kx(boolean[] zArr, Function1<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (boolean z5 : zArr) {
            i6 += selector.invoke(Boolean.valueOf(z5)).intValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Float> ky(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Le = Le(fArr); -1 < Le; Le--) {
            if (!predicate.invoke(Float.valueOf(fArr[Le])).booleanValue()) {
                return A9(fArr, Le + 1);
            }
        }
        return az(fArr);
    }

    @NotNull
    public static final List<Float> kz(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f6 : fArr) {
            arrayList.add(Float.valueOf(f6));
        }
        return arrayList;
    }

    public static final boolean l5(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K> Map<K, Float> l6(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(fArr.length), 16));
        for (float f6 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f6)), Float.valueOf(f6));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Integer, ? super V>> M l7(int[] iArr, M destination, Function1<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (int i6 : iArr) {
            destination.put(Integer.valueOf(i6), valueSelector.invoke(Integer.valueOf(i6)));
        }
        return destination;
    }

    @InlineOnly
    private static final boolean l8(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr[3];
    }

    @NotNull
    public static final <T> List<T> l9(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return r0.a6(wz(tArr));
    }

    @NotNull
    public static final <R, V> List<V> lA(@NotNull byte[] bArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @InlineOnly
    private static final int la(int[] iArr, int i6, Function1<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= iArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).intValue() : iArr[i6];
    }

    @NotNull
    public static <T> List<T> lb(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (List) mb(tArr, new ArrayList());
    }

    public static short lc(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequenceTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C ld(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            m0.t0(destination, transform.invoke(Integer.valueOf(i7), tArr[i6]));
            i6++;
            i7++;
        }
        return destination;
    }

    public static final void le(@NotNull int[] iArr, @NotNull Function1<? super Integer, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (int i6 : iArr) {
            action.invoke(Integer.valueOf(i6));
        }
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> lf(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b6 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b6));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Byte.valueOf(b6)));
        }
        return linkedHashMap;
    }

    public static final int lg(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Short.valueOf(sArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @Nullable
    public static final Byte li(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            byte b6 = bArr[length];
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return Byte.valueOf(b6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C lj(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (T t5 : tArr) {
            destination.add(transform.invoke(t5));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R lk(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final char ll(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (kotlin.jvm.internal.g0.t(c6, c7) < 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return c6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double lm(short[] sArr, Function1<? super Short, Double> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Short.valueOf(sArr[i6])).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R ln(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean lo(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final float lp(@NotNull float[] fArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (fArr.length != 0) {
            return fArr[random.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer lq(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                i6 = operation.invoke(Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(iArr[i7])).intValue();
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    public static final void lr(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Je = Je(cArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            char c6 = cArr[i6];
            cArr[i6] = cArr[Je];
            cArr[Je] = c6;
            Je--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Byte> ls(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return h0.J();
        }
        byte b6 = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(b6));
        int length = bArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            b6 = operation.invoke(Byte.valueOf(b6), Byte.valueOf(bArr[i6])).byteValue();
            arrayList.add(Byte.valueOf(b6));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void lt(@NotNull short[] sArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Pe = Pe(sArr); Pe > 0; Pe--) {
            int nextInt = random.nextInt(Pe + 1);
            short s5 = sArr[Pe];
            sArr[Pe] = sArr[nextInt];
            sArr[nextInt] = s5;
        }
    }

    @NotNull
    public static final <T> List<T> lu(@NotNull T[] tArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.t(kotlin.collections.q.l1(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final float[] lv(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.M3(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Float> lw(@NotNull float[] fArr, @NotNull Iterable<Float> other) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Float> tz = tz(fArr);
        m0.J0(tz, other);
        return tz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long lx(byte[] bArr, Function1<? super Byte, Long> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (byte b6 : bArr) {
            j6 += selector.invoke(Byte.valueOf(b6)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Integer> ly(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Me = Me(iArr); -1 < Me; Me--) {
            if (!predicate.invoke(Integer.valueOf(iArr[Me])).booleanValue()) {
                return B9(iArr, Me + 1);
            }
        }
        return bz(iArr);
    }

    @NotNull
    public static final List<Integer> lz(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i6 : iArr) {
            arrayList.add(Integer.valueOf(i6));
        }
        return arrayList;
    }

    public static boolean m5(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    @NotNull
    public static final <K, V> Map<K, V> m6(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(fArr.length), 16));
        for (float f6 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f6)), valueTransform.invoke(Float.valueOf(f6)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Long, ? super V>> M m7(long[] jArr, M destination, Function1<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (long j6 : jArr) {
            destination.put(Long.valueOf(j6), valueSelector.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    @InlineOnly
    private static final byte m8(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr[4];
    }

    @NotNull
    public static final List<Short> m9(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return r0.a6(xz(sArr));
    }

    @NotNull
    public static final List<Pair<Byte, Byte>> mA(@NotNull byte[] bArr, @NotNull byte[] other) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Byte.valueOf(bArr[i6]), Byte.valueOf(other[i6])));
        }
        return arrayList;
    }

    @InlineOnly
    private static final long ma(long[] jArr, int i6, Function1<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= jArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).longValue() : jArr[i6];
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C mb(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        for (T t5 : tArr) {
            if (t5 != null) {
                destination.add(t5);
            }
        }
        return destination;
    }

    public static final short mc(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return s5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> List<R> md(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            m0.t0(arrayList, transform.invoke(t5));
        }
        return arrayList;
    }

    public static final void me(@NotNull long[] jArr, @NotNull Function1<? super Long, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (long j6 : jArr) {
            action.invoke(Long.valueOf(j6));
        }
    }

    @NotNull
    public static final <K> Map<K, List<Character>> mf(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c6 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c6));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c6));
        }
        return linkedHashMap;
    }

    public static final int mg(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(Boolean.valueOf(zArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @Nullable
    public static final Character mi(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mj(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (short s5 : sArr) {
            destination.add(transform.invoke(Short.valueOf(s5)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R mk(long[] jArr, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double ml(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = Math.max(d6, dArr[i6]);
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final double mm(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Boolean.valueOf(zArr[i6])).doubleValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R mn(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                Object obj2 = (R) selector.invoke(tArr[i6]);
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean mo(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int mp(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return np(iArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long mq(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                j6 = operation.invoke(Integer.valueOf(i6), Long.valueOf(j6), Long.valueOf(jArr[i6])).longValue();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void mr(@NotNull char[] cArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, cArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            char c6 = cArr[i6];
            cArr[i6] = cArr[i9];
            cArr[i9] = c6;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Character> ms(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return h0.J();
        }
        char c6 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c6));
        int length = cArr.length;
        int i6 = 1;
        while (i6 < length) {
            Character invoke = operation.invoke(Character.valueOf(c6), Character.valueOf(cArr[i6]));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i6++;
            c6 = charValue;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void mt(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        nt(zArr, Random.Default);
    }

    @NotNull
    public static final List<Short> mu(@NotNull short[] sArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final int[] mv(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.O3(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Integer> mw(@NotNull int[] iArr, @NotNull Iterable<Integer> other) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Integer> uz = uz(iArr);
        m0.J0(uz, other);
        return uz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long mx(char[] cArr, Function1<? super Character, Long> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (char c6 : cArr) {
            j6 += selector.invoke(Character.valueOf(c6)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Long> my(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Ne = Ne(jArr); -1 < Ne; Ne--) {
            if (!predicate.invoke(Long.valueOf(jArr[Ne])).booleanValue()) {
                return C9(jArr, Ne + 1);
            }
        }
        return cz(jArr);
    }

    @NotNull
    public static final List<Long> mz(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j6 : jArr) {
            arrayList.add(Long.valueOf(j6));
        }
        return arrayList;
    }

    public static final boolean n5(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K> Map<K, Integer> n6(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(iArr.length), 16));
        for (int i6 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i6)), Integer.valueOf(i6));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M n7(@NotNull K[] kArr, @NotNull M destination, @NotNull Function1<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(kArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (K k6 : kArr) {
            destination.put(k6, valueSelector.invoke(k6));
        }
        return destination;
    }

    @InlineOnly
    private static final char n8(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr[4];
    }

    @NotNull
    public static final List<Boolean> n9(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return r0.a6(yz(zArr));
    }

    @NotNull
    public static final <V> List<V> nA(@NotNull byte[] bArr, @NotNull byte[] other, @NotNull Function2<? super Byte, ? super Byte, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i6]), Byte.valueOf(other[i6])));
        }
        return arrayList;
    }

    @InlineOnly
    private static final <T> T na(T[] tArr, int i6, Function1<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= tArr.length) ? defaultValue.invoke(Integer.valueOf(i6)) : tArr[i6];
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C nb(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                destination.add(Byte.valueOf(b6));
            }
        }
        return destination;
    }

    public static final boolean nc(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C nd(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (T t5 : tArr) {
            m0.t0(destination, transform.invoke(t5));
        }
        return destination;
    }

    public static final <T> void ne(@NotNull T[] tArr, @NotNull Function1<? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (T t5 : tArr) {
            action.invoke(t5);
        }
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> nf(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> keySelector, @NotNull Function1<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c6 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c6));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Character.valueOf(c6)));
        }
        return linkedHashMap;
    }

    public static final int ng(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Byte.valueOf(bArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @Nullable
    public static final Character ni(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            char c6 = cArr[length];
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return Character.valueOf(c6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C nj(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (boolean z5 : zArr) {
            destination.add(transform.invoke(Boolean.valueOf(z5)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R nk(T[] tArr, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                R invoke2 = selector.invoke(tArr[i6]);
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double nl(@NotNull Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = dArr[0].doubleValue();
        int Oe = Oe(dArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.max(doubleValue, dArr[i6].doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float nm(byte[] bArr, Function1<? super Byte, Float> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Byte.valueOf(bArr[i6])).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R nn(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean no(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final int np(@NotNull int[] iArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (iArr.length != 0) {
            return iArr[random.nextInt(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S nq(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s5 = (Object) tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                s5 = operation.invoke(Integer.valueOf(i6), s5, (Object) tArr[i6]);
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    public static final void nr(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Ke = Ke(dArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            double d6 = dArr[i6];
            dArr[i6] = dArr[Ke];
            dArr[Ke] = d6;
            Ke--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Double> ns(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return h0.J();
        }
        double d6 = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(d6));
        int length = dArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            d6 = operation.invoke(Double.valueOf(d6), Double.valueOf(dArr[i6])).doubleValue();
            arrayList.add(Double.valueOf(d6));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void nt(@NotNull boolean[] zArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        for (int Qe = Qe(zArr); Qe > 0; Qe--) {
            int nextInt = random.nextInt(Qe + 1);
            boolean z5 = zArr[Qe];
            zArr[Qe] = zArr[nextInt];
            zArr[nextInt] = z5;
        }
    }

    @NotNull
    public static final List<Short> nu(@NotNull short[] sArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.u(kotlin.collections.q.m1(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final long[] nv(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.Q3(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Long> nw(@NotNull long[] jArr, @NotNull Iterable<Long> other) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Long> vz = vz(jArr);
        m0.J0(vz, other);
        return vz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long nx(double[] dArr, Function1<? super Double, Long> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (double d6 : dArr) {
            j6 += selector.invoke(Double.valueOf(d6)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final <T> List<T> ny(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Oe = Oe(tArr); -1 < Oe; Oe--) {
            if (!predicate.invoke(tArr[Oe]).booleanValue()) {
                return D9(tArr, Oe + 1);
            }
        }
        return dz(tArr);
    }

    @NotNull
    public static <T> List<T> nz(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return new ArrayList(h0.v(tArr, false, 1, null));
    }

    public static final boolean o5(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    @NotNull
    public static final <K, V> Map<K, V> o6(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(iArr.length), 16));
        for (int i6 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i6)), valueTransform.invoke(Integer.valueOf(i6)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Short, ? super V>> M o7(short[] sArr, M destination, Function1<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (short s5 : sArr) {
            destination.put(Short.valueOf(s5), valueSelector.invoke(Short.valueOf(s5)));
        }
        return destination;
    }

    @InlineOnly
    private static final double o8(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr[4];
    }

    @NotNull
    public static final <K> List<Byte> o9(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b6 : bArr) {
            if (hashSet.add(selector.invoke(Byte.valueOf(b6)))) {
                arrayList.add(Byte.valueOf(b6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> oA(@NotNull byte[] bArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            byte b6 = bArr[i6];
            arrayList.add(kotlin.o0.a(Byte.valueOf(b6), other[i6]));
        }
        return arrayList;
    }

    @InlineOnly
    private static final short oa(short[] sArr, int i6, Function1<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= sArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).shortValue() : sArr[i6];
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C ob(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (!predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                destination.add(Character.valueOf(c6));
            }
        }
        return destination;
    }

    public static final boolean oc(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return z5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C od(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (byte b6 : bArr) {
            m0.s0(destination, transform.invoke(Byte.valueOf(b6)));
        }
        return destination;
    }

    public static final void oe(@NotNull short[] sArr, @NotNull Function1<? super Short, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (short s5 : sArr) {
            action.invoke(Short.valueOf(s5));
        }
    }

    @NotNull
    public static final <K> Map<K, List<Double>> of(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d6 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d6));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d6));
        }
        return linkedHashMap;
    }

    public static final int og(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Character.valueOf(cArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @Nullable
    public static final Double oi(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Boolean oj(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        if (Qe == 0) {
            return Boolean.valueOf(z5);
        }
        R invoke = selector.invoke(Boolean.valueOf(z5));
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                R invoke2 = selector.invoke(Boolean.valueOf(z6));
                if (invoke.compareTo(invoke2) < 0) {
                    z5 = z6;
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R ok(short[] sArr, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final float ol(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = Math.max(f6, fArr[i6]);
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float om(char[] cArr, Function1<? super Character, Float> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(cArr[i6])).floatValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R on(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean oo(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long op(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return pp(jArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short oq(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                s5 = operation.invoke(Integer.valueOf(i6), Short.valueOf(s5), Short.valueOf(sArr[i6])).shortValue();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void or(@NotNull double[] dArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, dArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            double d6 = dArr[i6];
            dArr[i6] = dArr[i9];
            dArr[i9] = d6;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Float> os(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return h0.J();
        }
        float f6 = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(f6));
        int length = fArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            f6 = operation.invoke(Float.valueOf(f6), Float.valueOf(fArr[i6])).floatValue();
            arrayList.add(Float.valueOf(f6));
        }
        return arrayList;
    }

    public static byte ot(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final List<Boolean> ou(@NotNull boolean[] zArr, @NotNull Iterable<Integer> indices) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int d02 = i0.d0(indices, 10);
        if (d02 == 0) {
            return h0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] ov(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        kotlin.collections.q.U3(tArr2);
        return tArr2;
    }

    @NotNull
    public static final <T> Set<T> ow(@NotNull T[] tArr, @NotNull Iterable<? extends T> other) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<T> wz = wz(tArr);
        m0.J0(wz, other);
        return wz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long ox(float[] fArr, Function1<? super Float, Long> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (float f6 : fArr) {
            j6 += selector.invoke(Float.valueOf(f6)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Short> oy(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Pe = Pe(sArr); -1 < Pe; Pe--) {
            if (!predicate.invoke(Short.valueOf(sArr[Pe])).booleanValue()) {
                return E9(sArr, Pe + 1);
            }
        }
        return ez(sArr);
    }

    @NotNull
    public static final List<Short> oz(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s5 : sArr) {
            arrayList.add(Short.valueOf(s5));
        }
        return arrayList;
    }

    public static final boolean p5(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K> Map<K, Long> p6(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(jArr.length), 16));
        for (long j6 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j6)), Long.valueOf(j6));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <V, M extends Map<? super Boolean, ? super V>> M p7(boolean[] zArr, M destination, Function1<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(valueSelector, "valueSelector");
        for (boolean z5 : zArr) {
            destination.put(Boolean.valueOf(z5), valueSelector.invoke(Boolean.valueOf(z5)));
        }
        return destination;
    }

    @InlineOnly
    private static final float p8(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr[4];
    }

    @NotNull
    public static final <K> List<Character> p9(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c6 : cArr) {
            if (hashSet.add(selector.invoke(Character.valueOf(c6)))) {
                arrayList.add(Character.valueOf(c6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> pA(@NotNull byte[] bArr, @NotNull R[] other, @NotNull Function2<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @InlineOnly
    private static final boolean pa(boolean[] zArr, int i6, Function1<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= zArr.length) ? defaultValue.invoke(Integer.valueOf(i6)).booleanValue() : zArr[i6];
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C pb(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (!predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                destination.add(Double.valueOf(d6));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R pc(T[] tArr, Function1<? super T, ? extends R> transform) {
        R r5;
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = tArr.length;
        int i6 = 0;
        while (true) {
            if (i6 < length) {
                r5 = transform.invoke(tArr[i6]);
                if (r5 != null) {
                    break;
                }
                i6++;
            } else {
                r5 = null;
                break;
            }
        }
        if (r5 != null) {
            return r5;
        }
        throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C pd(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (char c6 : cArr) {
            m0.s0(destination, transform.invoke(Character.valueOf(c6)));
        }
        return destination;
    }

    public static final void pe(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        for (boolean z5 : zArr) {
            action.invoke(Boolean.valueOf(z5));
        }
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> pf(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> keySelector, @NotNull Function1<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d6 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d6));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Double.valueOf(d6)));
        }
        return linkedHashMap;
    }

    public static final int pg(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Double.valueOf(dArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final String ph(@NotNull byte[] bArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) Xg(bArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final Double pi(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            double d6 = dArr[length];
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return Double.valueOf(d6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Byte pj(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        if (Ie == 0) {
            return Byte.valueOf(b6);
        }
        R invoke = selector.invoke(Byte.valueOf(b6));
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                R invoke2 = selector.invoke(Byte.valueOf(b7));
                if (invoke.compareTo(invoke2) < 0) {
                    b6 = b7;
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R pk(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i6]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final float pl(@NotNull Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = fArr[0].floatValue();
        int Oe = Oe(fArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.max(floatValue, fArr[i6].floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float pm(double[] dArr, Function1<? super Double, Float> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Double.valueOf(dArr[i6])).floatValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R pn(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean po(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final long pp(@NotNull long[] jArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (jArr.length != 0) {
            return jArr[random.nextInt(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Boolean pq(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                z5 = operation.invoke(Boolean.valueOf(z5), Boolean.valueOf(zArr[i6])).booleanValue();
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    public static final void pr(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Le = Le(fArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            float f6 = fArr[i6];
            fArr[i6] = fArr[Le];
            fArr[Le] = f6;
            Le--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Integer> ps(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return h0.J();
        }
        int i6 = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(i6));
        int length = iArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            i6 = operation.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i7])).intValue();
            arrayList.add(Integer.valueOf(i6));
        }
        return arrayList;
    }

    public static final byte pt(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Byte b6 = null;
        boolean z5 = false;
        for (byte b7 : bArr) {
            if (predicate.invoke(Byte.valueOf(b7)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                b6 = Byte.valueOf(b7);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type kotlin.Byte");
        return b6.byteValue();
    }

    @NotNull
    public static final List<Boolean> pu(@NotNull boolean[] zArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? h0.J() : kotlin.collections.q.v(kotlin.collections.q.n1(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final short[] pv(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        kotlin.collections.q.W3(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Short> pw(@NotNull short[] sArr, @NotNull Iterable<Short> other) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Short> xz = xz(sArr);
        m0.J0(xz, other);
        return xz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long px(int[] iArr, Function1<? super Integer, Long> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (int i6 : iArr) {
            j6 += selector.invoke(Integer.valueOf(i6)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Boolean> py(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int Qe = Qe(zArr); -1 < Qe; Qe--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[Qe])).booleanValue()) {
                return F9(zArr, Qe + 1);
            }
        }
        return fz(zArr);
    }

    @NotNull
    public static final List<Boolean> pz(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z5 : zArr) {
            arrayList.add(Boolean.valueOf(z5));
        }
        return arrayList;
    }

    public static final boolean q5(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    @NotNull
    public static final <K, V> Map<K, V> q6(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(jArr.length), 16));
        for (long j6 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j6)), valueTransform.invoke(Long.valueOf(j6)));
        }
        return linkedHashMap;
    }

    public static final double q7(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (byte b6 : bArr) {
            d6 += b6;
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @InlineOnly
    private static final int q8(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr[4];
    }

    @NotNull
    public static final <K> List<Double> q9(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d6 : dArr) {
            if (hashSet.add(selector.invoke(Double.valueOf(d6)))) {
                arrayList.add(Double.valueOf(d6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> qA(@NotNull char[] cArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Character.valueOf(cArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Boolean qa(boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return af(zArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C qb(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (!predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                destination.add(Float.valueOf(f6));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R qc(T[] tArr, Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (T t5 : tArr) {
            R invoke = transform.invoke(t5);
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C qd(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (double d6 : dArr) {
            m0.s0(destination, transform.invoke(Double.valueOf(d6)));
        }
        return destination;
    }

    public static final void qe(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Byte.valueOf(bArr[i6]));
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <K> Map<K, List<Float>> qf(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f6 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f6));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f6));
        }
        return linkedHashMap;
    }

    public static final int qg(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Float.valueOf(fArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final String qh(@NotNull char[] cArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) Yg(cArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final Float qi(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Character qj(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        if (Je == 0) {
            return Character.valueOf(c6);
        }
        R invoke = selector.invoke(Character.valueOf(c6));
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                R invoke2 = selector.invoke(Character.valueOf(c7));
                if (invoke.compareTo(invoke2) < 0) {
                    c6 = c7;
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double qk(byte[] bArr, Function1<? super Byte, Double> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Byte.valueOf(bArr[i6])).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final int ql(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (i6 < i8) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float qm(float[] fArr, Function1<? super Float, Float> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Float.valueOf(fArr[i6])).floatValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R qn(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean qo(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T qp(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (T) rp(tArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte qq(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                b6 = operation.invoke(Byte.valueOf(b6), Byte.valueOf(bArr[i6])).byteValue();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final void qr(@NotNull float[] fArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, fArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            float f6 = fArr[i6];
            fArr[i6] = fArr[i9];
            fArr[i9] = f6;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Long> qs(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return h0.J();
        }
        long j6 = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(j6));
        int length = jArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            j6 = operation.invoke(Long.valueOf(j6), Long.valueOf(jArr[i6])).longValue();
            arrayList.add(Long.valueOf(j6));
        }
        return arrayList;
    }

    public static char qt(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static byte[] qu(@NotNull byte[] bArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            bArr2[i6] = bArr[it.next().intValue()];
            i6++;
        }
        return bArr2;
    }

    @NotNull
    public static final byte[] qv(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        Ku(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Boolean> qw(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> other) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Boolean> yz = yz(zArr);
        m0.J0(yz, other);
        return yz;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long qx(long[] jArr, Function1<? super Long, Long> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (long j7 : jArr) {
            j6 += selector.invoke(Long.valueOf(j7)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Byte> qy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b6 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b6));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Byte> qz(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return (Set) Cy(bArr, new LinkedHashSet(k1.j(bArr.length)));
    }

    public static final boolean r5(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <T, K> Map<K, T> r6(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(tArr.length), 16));
        for (T t5 : tArr) {
            linkedHashMap.put(keySelector.invoke(t5), t5);
        }
        return linkedHashMap;
    }

    public static final double r7(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (double d7 : dArr) {
            d6 += d7;
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @InlineOnly
    private static final long r8(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr[4];
    }

    @NotNull
    public static final <K> List<Float> r9(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (hashSet.add(selector.invoke(Float.valueOf(f6)))) {
                arrayList.add(Float.valueOf(f6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> rA(@NotNull char[] cArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Character.valueOf(cArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Byte ra(byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bf(bArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C rb(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                destination.add(Integer.valueOf(i6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Boolean rc(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C rd(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (float f6 : fArr) {
            m0.s0(destination, transform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    public static final void re(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = cArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Character.valueOf(cArr[i6]));
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> rf(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> keySelector, @NotNull Function1<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f6 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f6));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Float.valueOf(f6)));
        }
        return linkedHashMap;
    }

    public static final int rg(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Integer.valueOf(iArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final String rh(@NotNull double[] dArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) Zg(dArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final Float ri(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            float f6 = fArr[length];
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return Float.valueOf(f6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Double rj(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        if (Ke == 0) {
            return Double.valueOf(d6);
        }
        R invoke = selector.invoke(Double.valueOf(d6));
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                R invoke2 = selector.invoke(Double.valueOf(d7));
                if (invoke.compareTo(invoke2) < 0) {
                    d6 = d7;
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double rk(char[] cArr, Function1<? super Character, Double> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(cArr[i6])).doubleValue());
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final long rl(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                if (j6 < j7) {
                    j6 = j7;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float rm(int[] iArr, Function1<? super Integer, Float> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Integer.valueOf(iArr[i6])).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R rn(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean ro(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T rp(@NotNull T[] tArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (tArr.length != 0) {
            return tArr[random.nextInt(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character rq(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                c6 = operation.invoke(Character.valueOf(c6), Character.valueOf(cArr[i6])).charValue();
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    public static void rr(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Me = Me(iArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            int i7 = iArr[i6];
            iArr[i6] = iArr[Me];
            iArr[Me] = i7;
            Me--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <S, T extends S> List<S> rs(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return h0.J();
        }
        S s5 = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s5);
        int length = tArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            s5 = operation.invoke(s5, (Object) tArr[i6]);
            arrayList.add(s5);
        }
        return arrayList;
    }

    public static final char rt(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Character ch = null;
        boolean z5 = false;
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                ch = Character.valueOf(c6);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(ch, "null cannot be cast to non-null type kotlin.Char");
        return ch.charValue();
    }

    @NotNull
    public static byte[] ru(@NotNull byte[] bArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new byte[0] : kotlin.collections.q.f1(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final char[] rv(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        Mu(copyOf);
        return copyOf;
    }

    public static final double rw(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        double d6 = 0.0d;
        for (double d7 : dArr) {
            d6 += d7;
        }
        return d6;
    }

    @JvmName(name = "sumOfLong")
    public static final long rx(@NotNull Long[] lArr) {
        kotlin.jvm.internal.g0.p(lArr, "<this>");
        long j6 = 0;
        for (Long l6 : lArr) {
            j6 += l6.longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Character> ry(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c6 : cArr) {
            if (!predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c6));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Character> rz(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return (Set) Dy(cArr, new LinkedHashSet(k1.j(kotlin.ranges.t.B(cArr.length, 128))));
    }

    public static final boolean s5(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    @NotNull
    public static final <T, K, V> Map<K, V> s6(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(tArr.length), 16));
        for (T t5 : tArr) {
            linkedHashMap.put(keySelector.invoke(t5), valueTransform.invoke(t5));
        }
        return linkedHashMap;
    }

    public static final double s7(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (float f6 : fArr) {
            d6 += f6;
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @InlineOnly
    private static final <T> T s8(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr[4];
    }

    @NotNull
    public static final <K> List<Integer> s9(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            if (hashSet.add(selector.invoke(Integer.valueOf(i6)))) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Character, Character>> sA(@NotNull char[] cArr, @NotNull char[] other) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Character.valueOf(cArr[i6]), Character.valueOf(other[i6])));
        }
        return arrayList;
    }

    @InlineOnly
    private static final Character sa(char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cf(cArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C sb(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (!predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                destination.add(Long.valueOf(j6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Boolean sc(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                return Boolean.valueOf(z5);
            }
        }
        return null;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C sd(@NotNull int[] iArr, @NotNull C destination, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (int i6 : iArr) {
            m0.s0(destination, transform.invoke(Integer.valueOf(i6)));
        }
        return destination;
    }

    public static final void se(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = dArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Double.valueOf(dArr[i6]));
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <K> Map<K, List<Integer>> sf(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i6 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i6));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i6));
        }
        return linkedHashMap;
    }

    public static final int sg(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Long.valueOf(jArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final String sh(@NotNull float[] fArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) ah(fArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final Integer si(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Float sj(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        if (Le == 0) {
            return Float.valueOf(f6);
        }
        R invoke = selector.invoke(Float.valueOf(f6));
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                R invoke2 = selector.invoke(Float.valueOf(f7));
                if (invoke.compareTo(invoke2) < 0) {
                    f6 = f7;
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double sk(double[] dArr, Function1<? super Double, Double> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Double.valueOf(dArr[i6])).doubleValue());
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    @NotNull
    public static final <T extends Comparable<? super T>> T sl(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                T t6 = tArr[i6];
                if (t5.compareTo(t6) < 0) {
                    t5 = t6;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float sm(long[] jArr, Function1<? super Long, Float> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Long.valueOf(jArr[i6])).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R sn(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean so(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final short sp(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return tp(sArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double sq(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                d6 = operation.invoke(Double.valueOf(d6), Double.valueOf(dArr[i6])).doubleValue();
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void sr(@NotNull int[] iArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, iArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            int i10 = iArr[i6];
            iArr[i6] = iArr[i9];
            iArr[i9] = i10;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Short> ss(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return h0.J();
        }
        short s5 = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(s5));
        int length = sArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            s5 = operation.invoke(Short.valueOf(s5), Short.valueOf(sArr[i6])).shortValue();
            arrayList.add(Short.valueOf(s5));
        }
        return arrayList;
    }

    public static final double st(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final char[] su(@NotNull char[] cArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            cArr2[i6] = cArr[it.next().intValue()];
            i6++;
        }
        return cArr2;
    }

    @NotNull
    public static final double[] sv(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        Ou(copyOf);
        return copyOf;
    }

    public static final float sw(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        float f6 = 0.0f;
        for (float f7 : fArr) {
            f6 += f7;
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long sx(T[] tArr, Function1<? super T, Long> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (T t5 : tArr) {
            j6 += selector.invoke(t5).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Double> sy(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d6 : dArr) {
            if (!predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d6));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Double> sz(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return (Set) Ey(dArr, new LinkedHashSet(k1.j(dArr.length)));
    }

    public static final boolean t5(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K> Map<K, Short> t6(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(sArr.length), 16));
        for (short s5 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s5)), Short.valueOf(s5));
        }
        return linkedHashMap;
    }

    public static final double t7(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (int i7 : iArr) {
            d6 += i7;
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @InlineOnly
    private static final short t8(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr[4];
    }

    @NotNull
    public static final <K> List<Long> t9(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (hashSet.add(selector.invoke(Long.valueOf(j6)))) {
                arrayList.add(Long.valueOf(j6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> tA(@NotNull char[] cArr, @NotNull char[] other, @NotNull Function2<? super Character, ? super Character, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i6]), Character.valueOf(other[i6])));
        }
        return arrayList;
    }

    @InlineOnly
    private static final Double ta(double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return df(dArr, i6);
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C tb(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (!predicate.invoke(t5).booleanValue()) {
                destination.add(t5);
            }
        }
        return destination;
    }

    @Nullable
    public static final Byte tc(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C td(@NotNull long[] jArr, @NotNull C destination, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (long j6 : jArr) {
            m0.s0(destination, transform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    public static final void te(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = fArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Float.valueOf(fArr[i6]));
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> tf(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> keySelector, @NotNull Function1<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i6 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i6));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Integer.valueOf(i6)));
        }
        return linkedHashMap;
    }

    public static final <T> int tg(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(tArr[length]).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final String th(@NotNull int[] iArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) bh(iArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final Integer ti(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            int i7 = iArr[length];
            if (predicate.invoke(Integer.valueOf(i7)).booleanValue()) {
                return Integer.valueOf(i7);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Integer tj(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        if (Me == 0) {
            return Integer.valueOf(i6);
        }
        R invoke = selector.invoke(Integer.valueOf(i6));
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                R invoke2 = selector.invoke(Integer.valueOf(i8));
                if (invoke.compareTo(invoke2) < 0) {
                    i6 = i8;
                    invoke = invoke2;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double tk(float[] fArr, Function1<? super Float, Double> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Float.valueOf(fArr[i6])).doubleValue());
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final short tl(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                if (s5 < s6) {
                    s5 = s6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> float tm(T[] tArr, Function1<? super T, Float> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(tArr[i6]).floatValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R tn(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean to(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final short tp(@NotNull short[] sArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (sArr.length != 0) {
            return sArr[random.nextInt(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float tq(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                f6 = operation.invoke(Float.valueOf(f6), Float.valueOf(fArr[i6])).floatValue();
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    public static void tr(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Ne = Ne(jArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            jArr[i6] = jArr[Ne];
            jArr[Ne] = j6;
            Ne--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Boolean> ts(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (zArr.length == 0) {
            return h0.J();
        }
        boolean z5 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z5));
        int length = zArr.length;
        int i6 = 1;
        while (i6 < length) {
            Boolean invoke = operation.invoke(Boolean.valueOf(z5), Boolean.valueOf(zArr[i6]));
            boolean booleanValue = invoke.booleanValue();
            arrayList.add(invoke);
            i6++;
            z5 = booleanValue;
        }
        return arrayList;
    }

    public static final double tt(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Double d6 = null;
        boolean z5 = false;
        for (double d7 : dArr) {
            if (predicate.invoke(Double.valueOf(d7)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                d6 = Double.valueOf(d7);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(d6, "null cannot be cast to non-null type kotlin.Double");
        return d6.doubleValue();
    }

    @NotNull
    public static final char[] tu(@NotNull char[] cArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new char[0] : kotlin.collections.q.g1(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final float[] tv(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        Qu(copyOf);
        return copyOf;
    }

    public static final int tw(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int i6 = 0;
        for (byte b6 : bArr) {
            i6 += b6;
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long tx(short[] sArr, Function1<? super Short, Long> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (short s5 : sArr) {
            j6 += selector.invoke(Short.valueOf(s5)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Float> ty(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (!predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f6));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Float> tz(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return (Set) Fy(fArr, new LinkedHashSet(k1.j(fArr.length)));
    }

    public static boolean u5(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    @NotNull
    public static final <K, V> Map<K, V> u6(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(sArr.length), 16));
        for (short s5 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s5)), valueTransform.invoke(Short.valueOf(s5)));
        }
        return linkedHashMap;
    }

    public static final double u7(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (long j6 : jArr) {
            d6 += j6;
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @InlineOnly
    private static final boolean u8(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr[4];
    }

    @NotNull
    public static final <T, K> List<T> u9(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            if (hashSet.add(selector.invoke(t5))) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> uA(@NotNull char[] cArr, @NotNull R[] other) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            char c6 = cArr[i6];
            arrayList.add(kotlin.o0.a(Character.valueOf(c6), other[i6]));
        }
        return arrayList;
    }

    @InlineOnly
    private static final Float ua(float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return ef(fArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C ub(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (short s5 : sArr) {
            if (!predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                destination.add(Short.valueOf(s5));
            }
        }
        return destination;
    }

    @Nullable
    public static final Byte uc(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                return Byte.valueOf(b6);
            }
        }
        return null;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C ud(@NotNull T[] tArr, @NotNull C destination, @NotNull Function1<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (T t5 : tArr) {
            m0.s0(destination, transform.invoke(t5));
        }
        return destination;
    }

    public static final void ue(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i6]));
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <K> Map<K, List<Long>> uf(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j6 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j6));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j6));
        }
        return linkedHashMap;
    }

    public static final int ug(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Short.valueOf(sArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final String uh(@NotNull long[] jArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) ch(jArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final Long ui(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Long uj(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        if (Ne == 0) {
            return Long.valueOf(j6);
        }
        R invoke = selector.invoke(Long.valueOf(j6));
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                R invoke2 = selector.invoke(Long.valueOf(j7));
                if (invoke.compareTo(invoke2) < 0) {
                    j6 = j7;
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double uk(int[] iArr, Function1<? super Integer, Double> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        int Me = Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Integer.valueOf(iArr[i6])).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Boolean ul(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                if (comparator.compare(Boolean.valueOf(z5), Boolean.valueOf(z6)) < 0) {
                    z5 = z6;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float um(short[] sArr, Function1<? super Short, Float> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Short.valueOf(sArr[i6])).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R un(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean uo(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean up(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return vp(zArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer uq(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                i6 = operation.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i7])).intValue();
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void ur(@NotNull long[] jArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, jArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            long j6 = jArr[i6];
            jArr[i6] = jArr[i9];
            jArr[i9] = j6;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Byte> us(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (bArr.length == 0) {
            return h0.J();
        }
        byte b6 = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(b6));
        int length = bArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            b6 = operation.invoke(Integer.valueOf(i6), Byte.valueOf(b6), Byte.valueOf(bArr[i6])).byteValue();
            arrayList.add(Byte.valueOf(b6));
        }
        return arrayList;
    }

    public static final float ut(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final double[] uu(@NotNull double[] dArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            dArr2[i6] = dArr[it.next().intValue()];
            i6++;
        }
        return dArr2;
    }

    @NotNull
    public static final int[] uv(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        Su(copyOf);
        return copyOf;
    }

    public static int uw(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int i6 = 0;
        for (int i7 : iArr) {
            i6 += i7;
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long ux(boolean[] zArr, Function1<? super Boolean, Long> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        long j6 = 0;
        for (boolean z5 : zArr) {
            j6 += selector.invoke(Boolean.valueOf(z5)).longValue();
        }
        return j6;
    }

    @NotNull
    public static final List<Integer> uy(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i6));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Integer> uz(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return (Set) Gy(iArr, new LinkedHashSet(k1.j(iArr.length)));
    }

    public static final boolean v5(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K> Map<K, Boolean> v6(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(zArr.length), 16));
        for (boolean z5 : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z5)), Boolean.valueOf(z5));
        }
        return linkedHashMap;
    }

    public static final double v7(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (short s5 : sArr) {
            d6 += s5;
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    public static boolean v8(@NotNull byte[] bArr, byte b6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return Vf(bArr, b6) >= 0;
    }

    @NotNull
    public static final <K> List<Short> v9(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s5 : sArr) {
            if (hashSet.add(selector.invoke(Short.valueOf(s5)))) {
                arrayList.add(Short.valueOf(s5));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> vA(@NotNull char[] cArr, @NotNull R[] other, @NotNull Function2<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i6]), other[i6]));
        }
        return arrayList;
    }

    @InlineOnly
    private static final Integer va(int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return ff(iArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C vb(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (boolean z5 : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                destination.add(Boolean.valueOf(z5));
            }
        }
        return destination;
    }

    @Nullable
    public static final Character vc(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C vd(@NotNull short[] sArr, @NotNull C destination, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (short s5 : sArr) {
            m0.s0(destination, transform.invoke(Short.valueOf(s5)));
        }
        return destination;
    }

    public static final void ve(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = jArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Long.valueOf(jArr[i6]));
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> vf(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> keySelector, @NotNull Function1<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j6 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j6));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Long.valueOf(j6)));
        }
        return linkedHashMap;
    }

    public static final int vg(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(Boolean.valueOf(zArr[length])).booleanValue()) {
                    return length;
                }
                if (i6 < 0) {
                    break;
                }
                length = i6;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T> String vh(@NotNull T[] tArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) dh(tArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final Long vi(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            long j6 = jArr[length];
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return Long.valueOf(j6);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <T, R extends Comparable<? super R>> T vj(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = Oe(tArr);
        if (Oe != 0) {
            R invoke = selector.invoke(t5);
            int i6 = 1;
            if (1 <= Oe) {
                while (true) {
                    T t6 = tArr[i6];
                    R invoke2 = selector.invoke(t6);
                    if (invoke.compareTo(invoke2) < 0) {
                        t5 = t6;
                        invoke = invoke2;
                    }
                    if (i6 == Oe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double vk(long[] jArr, Function1<? super Long, Double> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Long.valueOf(jArr[i6])).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte vl(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (comparator.compare(Byte.valueOf(b6), Byte.valueOf(b7)) < 0) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final float vm(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Boolean.valueOf(zArr[i6])).floatValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R vn(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(tArr[0]);
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                Object obj2 = (R) selector.invoke(tArr[i6]);
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean vo(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final boolean vp(@NotNull boolean[] zArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (zArr.length != 0) {
            return zArr[random.nextInt(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Long vq(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                j6 = operation.invoke(Long.valueOf(j6), Long.valueOf(jArr[i6])).longValue();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final <T> void vr(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Oe = Oe(tArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            T t5 = tArr[i6];
            tArr[i6] = tArr[Oe];
            tArr[Oe] = t5;
            Oe--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Character> vs(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (cArr.length == 0) {
            return h0.J();
        }
        char c6 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c6));
        int length = cArr.length;
        int i6 = 1;
        while (i6 < length) {
            Character invoke = operation.invoke(Integer.valueOf(i6), Character.valueOf(c6), Character.valueOf(cArr[i6]));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i6++;
            c6 = charValue;
        }
        return arrayList;
    }

    public static final float vt(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Float f6 = null;
        boolean z5 = false;
        for (float f7 : fArr) {
            if (predicate.invoke(Float.valueOf(f7)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                f6 = Float.valueOf(f7);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(f6, "null cannot be cast to non-null type kotlin.Float");
        return f6.floatValue();
    }

    @NotNull
    public static final double[] vu(@NotNull double[] dArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new double[0] : kotlin.collections.q.h1(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final long[] vv(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        Uu(copyOf);
        return copyOf;
    }

    public static final int vw(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int i6 = 0;
        for (short s5 : sArr) {
            i6 += s5;
        }
        return i6;
    }

    @JvmName(name = "sumOfShort")
    public static final int vx(@NotNull Short[] shArr) {
        kotlin.jvm.internal.g0.p(shArr, "<this>");
        int i6 = 0;
        for (Short sh : shArr) {
            i6 += sh.shortValue();
        }
        return i6;
    }

    @NotNull
    public static final List<Long> vy(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (!predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j6));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Long> vz(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return (Set) Hy(jArr, new LinkedHashSet(k1.j(jArr.length)));
    }

    public static boolean w5(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    @NotNull
    public static final <K, V> Map<K, V> w6(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> keySelector, @NotNull Function1<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(k1.j(zArr.length), 16));
        for (boolean z5 : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z5)), valueTransform.invoke(Boolean.valueOf(z5)));
        }
        return linkedHashMap;
    }

    @JvmName(name = "averageOfByte")
    public static final double w7(@NotNull Byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (Byte b6 : bArr) {
            d6 += b6.byteValue();
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    public static boolean w8(@NotNull char[] cArr, char c6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return Wf(cArr, c6) >= 0;
    }

    @NotNull
    public static final <K> List<Boolean> w9(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z5 : zArr) {
            if (hashSet.add(selector.invoke(Boolean.valueOf(z5)))) {
                arrayList.add(Boolean.valueOf(z5));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> wA(@NotNull double[] dArr, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(kotlin.o0.a(Double.valueOf(dArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @InlineOnly
    private static final Long wa(long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return gf(jArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C wb(@NotNull byte[] bArr, @NotNull C destination, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                destination.add(Byte.valueOf(b6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Character wc(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                return Character.valueOf(c6);
            }
        }
        return null;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C wd(@NotNull boolean[] zArr, @NotNull C destination, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        for (boolean z5 : zArr) {
            m0.s0(destination, transform.invoke(Boolean.valueOf(z5)));
        }
        return destination;
    }

    public static final <T> void we(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = tArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), tArr[i6]);
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> wf(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t5 : tArr) {
            K invoke = keySelector.invoke(t5);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t5);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Set<Byte> wg(@NotNull byte[] bArr, @NotNull Iterable<Byte> other) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Byte> qz = qz(bArr);
        m0.T0(qz, other);
        return qz;
    }

    @NotNull
    public static final String wh(@NotNull short[] sArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) eh(sArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final <T> T wi(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <R extends Comparable<? super R>> Short wj(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        if (Pe == 0) {
            return Short.valueOf(s5);
        }
        R invoke = selector.invoke(Short.valueOf(s5));
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                R invoke2 = selector.invoke(Short.valueOf(s6));
                if (invoke.compareTo(invoke2) < 0) {
                    s5 = s6;
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> Double wk(T[] tArr, Function1<? super T, Double> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(tArr[i6]).doubleValue());
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character wl(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (comparator.compare(Character.valueOf(c6), Character.valueOf(c7)) < 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R wm(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R wn(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final boolean wo(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Boolean wp(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return xp(zArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final <S, T extends S> S wq(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s5 = (Object) tArr[0];
        int Oe = Oe(tArr);
        int i6 = 1;
        if (1 <= Oe) {
            while (true) {
                s5 = operation.invoke(s5, (Object) tArr[i6]);
                if (i6 == Oe) {
                    break;
                }
                i6++;
            }
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T> void wr(@NotNull T[] tArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, tArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            T t5 = tArr[i6];
            tArr[i6] = tArr[i9];
            tArr[i9] = t5;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Double> ws(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (dArr.length == 0) {
            return h0.J();
        }
        double d6 = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(d6));
        int length = dArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            d6 = operation.invoke(Integer.valueOf(i6), Double.valueOf(d6), Double.valueOf(dArr[i6])).doubleValue();
            arrayList.add(Double.valueOf(d6));
        }
        return arrayList;
    }

    public static int wt(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static final float[] wu(@NotNull float[] fArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            fArr2[i6] = fArr[it.next().intValue()];
            i6++;
        }
        return fArr2;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] wv(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        kotlin.collections.q.h4(tArr2, kotlin.comparisons.a.x());
        return tArr2;
    }

    public static long ww(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        long j6 = 0;
        for (long j7 : jArr) {
            j6 += j7;
        }
        return j6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int wx(byte[] bArr, Function1<? super Byte, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (byte b6 : bArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Byte.valueOf(b6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final <T> List<T> wy(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t5 : tArr) {
            if (!predicate.invoke(t5).booleanValue()) {
                break;
            }
            arrayList.add(t5);
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Set<T> wz(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (Set) Iy(tArr, new LinkedHashSet(k1.j(tArr.length)));
    }

    public static final boolean x5(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Byte>> M x6(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (byte b6 : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b6)), Byte.valueOf(b6));
        }
        return destination;
    }

    @JvmName(name = "averageOfDouble")
    public static final double x7(@NotNull Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (Double d7 : dArr) {
            d6 += d7.doubleValue();
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "any { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = cn.bluemobi.dylan.photoview.a.f1297f, hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ boolean x8(double[] dArr, double d6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        for (double d7 : dArr) {
            if (d7 == d6) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final List<Byte> x9(@NotNull byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (i6 >= 0) {
            return Xx(bArr, kotlin.ranges.t.u(bArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <R, V> List<V> xA(@NotNull double[] dArr, @NotNull Iterable<? extends R> other, @NotNull Function2<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(i0.d0(other, 10), length));
        int i6 = 0;
        for (R r5 : other) {
            if (i6 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Double.valueOf(dArr[i6]), r5));
            i6++;
        }
        return arrayList;
    }

    @InlineOnly
    private static final <T> T xa(T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (T) hf(tArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C xb(@NotNull char[] cArr, @NotNull C destination, @NotNull Function1<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (char c6 : cArr) {
            if (predicate.invoke(Character.valueOf(c6)).booleanValue()) {
                destination.add(Character.valueOf(c6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Double xc(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    public static final <R> R xd(@NotNull byte[] bArr, R r5, @NotNull Function2<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (byte b6 : bArr) {
            r5 = operation.invoke(r5, Byte.valueOf(b6));
        }
        return r5;
    }

    public static final void xe(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = sArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Short.valueOf(sArr[i6]));
            i6++;
            i7++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, List<V>> xf(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> keySelector, @NotNull Function1<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (H5BaseWebChromeClient h5BaseWebChromeClient : tArr) {
            K invoke = keySelector.invoke(h5BaseWebChromeClient);
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(h5BaseWebChromeClient));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Set<Character> xg(@NotNull char[] cArr, @NotNull Iterable<Character> other) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Character> rz = rz(cArr);
        m0.T0(rz, other);
        return rz;
    }

    @NotNull
    public static final String xh(@NotNull boolean[] zArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(separator, "separator");
        kotlin.jvm.internal.g0.p(prefix, "prefix");
        kotlin.jvm.internal.g0.p(postfix, "postfix");
        kotlin.jvm.internal.g0.p(truncated, "truncated");
        return ((StringBuilder) fh(zArr, new StringBuilder(), separator, prefix, postfix, i6, truncated, function1)).toString();
    }

    @Nullable
    public static final <T> T xi(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            T t5 = tArr[length];
            if (predicate.invoke(t5).booleanValue()) {
                return t5;
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> byte xj(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        if (Ie != 0) {
            R invoke = selector.invoke(Byte.valueOf(b6));
            int i6 = 1;
            if (1 <= Ie) {
                while (true) {
                    byte b7 = bArr[i6];
                    R invoke2 = selector.invoke(Byte.valueOf(b7));
                    if (invoke.compareTo(invoke2) < 0) {
                        b6 = b7;
                        invoke = invoke2;
                    }
                    if (i6 == Ie) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double xk(short[] sArr, Function1<? super Short, Double> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Short.valueOf(sArr[i6])).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Double xl(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                if (comparator.compare(Double.valueOf(d6), Double.valueOf(d7)) < 0) {
                    d6 = d7;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R xm(char[] cArr, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R> R xn(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i6]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    public static final <T> boolean xo(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Boolean xp(@NotNull boolean[] zArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.nextInt(zArr.length)]);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Short xq(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                s5 = operation.invoke(Short.valueOf(s5), Short.valueOf(sArr[i6])).shortValue();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    public static void xr(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Pe = Pe(sArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            short s5 = sArr[i6];
            sArr[i6] = sArr[Pe];
            sArr[Pe] = s5;
            Pe--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Float> xs(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (fArr.length == 0) {
            return h0.J();
        }
        float f6 = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(f6));
        int length = fArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            f6 = operation.invoke(Integer.valueOf(i6), Float.valueOf(f6), Float.valueOf(fArr[i6])).floatValue();
            arrayList.add(Float.valueOf(f6));
        }
        return arrayList;
    }

    public static final int xt(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Integer num = null;
        boolean z5 = false;
        for (int i6 : iArr) {
            if (predicate.invoke(Integer.valueOf(i6)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                num = Integer.valueOf(i6);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(num, "null cannot be cast to non-null type kotlin.Int");
        return num.intValue();
    }

    @NotNull
    public static final float[] xu(@NotNull float[] fArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new float[0] : kotlin.collections.q.i1(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final short[] xv(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        Yu(copyOf);
        return copyOf;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int xw(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Integer> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (byte b6 : bArr) {
            i6 += selector.invoke(Byte.valueOf(b6)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int xx(char[] cArr, Function1<? super Character, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (char c6 : cArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Character.valueOf(c6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final List<Short> xy(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s5 : sArr) {
            if (!predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s5));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Short> xz(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return (Set) Jy(sArr, new LinkedHashSet(k1.j(sArr.length)));
    }

    public static final <T> boolean y5(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M y6(@NotNull byte[] bArr, @NotNull M destination, @NotNull Function1<? super Byte, ? extends K> keySelector, @NotNull Function1<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        for (byte b6 : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b6)), valueTransform.invoke(Byte.valueOf(b6)));
        }
        return destination;
    }

    @JvmName(name = "averageOfFloat")
    public static final double y7(@NotNull Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (Float f6 : fArr) {
            d6 += f6.floatValue();
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "any { it == element }", imports = {}))
    @DeprecatedSinceKotlin(errorSince = cn.bluemobi.dylan.photoview.a.f1297f, hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ boolean y8(float[] fArr, float f6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        for (float f7 : fArr) {
            if (f7 == f6) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final List<Character> y9(@NotNull char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (i6 >= 0) {
            return Yx(cArr, kotlin.ranges.t.u(cArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final List<Pair<Double, Double>> yA(@NotNull double[] dArr, @NotNull double[] other) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(kotlin.o0.a(Double.valueOf(dArr[i6]), Double.valueOf(other[i6])));
        }
        return arrayList;
    }

    @InlineOnly
    private static final Short ya(short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return jf(sArr, i6);
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C yb(@NotNull double[] dArr, @NotNull C destination, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                destination.add(Double.valueOf(d6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Double yc(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (double d6 : dArr) {
            if (predicate.invoke(Double.valueOf(d6)).booleanValue()) {
                return Double.valueOf(d6);
            }
        }
        return null;
    }

    public static final <R> R yd(@NotNull char[] cArr, R r5, @NotNull Function2<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (char c6 : cArr) {
            r5 = operation.invoke(r5, Character.valueOf(c6));
        }
        return r5;
    }

    public static final void ye(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, kotlin.n1> action) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(action, "action");
        int length = zArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            action.invoke(Integer.valueOf(i7), Boolean.valueOf(zArr[i6]));
            i6++;
            i7++;
        }
    }

    @NotNull
    public static final <K> Map<K, List<Short>> yf(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s5 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s5));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s5));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Set<Double> yg(@NotNull double[] dArr, @NotNull Iterable<Double> other) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Double> sz = sz(dArr);
        m0.T0(sz, other);
        return sz;
    }

    public static /* synthetic */ String yh(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return ph(bArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @Nullable
    public static final Short yi(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char yj(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        if (Je != 0) {
            R invoke = selector.invoke(Character.valueOf(c6));
            int i6 = 1;
            if (1 <= Je) {
                while (true) {
                    char c7 = cArr[i6];
                    R invoke2 = selector.invoke(Character.valueOf(c7));
                    if (invoke.compareTo(invoke2) < 0) {
                        c6 = c7;
                        invoke = invoke2;
                    }
                    if (i6 == Je) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return c6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Double yk(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int Qe = Qe(zArr);
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Boolean.valueOf(zArr[i6])).doubleValue());
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Float yl(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) < 0) {
                    f6 = f7;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R ym(double[] dArr, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int Ke = Ke(dArr);
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte yn(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                if (b6 > b7) {
                    b6 = b7;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    public static final <T> boolean yo(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final Byte yp(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return zp(bArr, Random.Default);
    }

    public static final byte yq(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Ie = Ie(bArr);
        if (Ie < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte b6 = bArr[Ie];
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            b6 = operation.invoke(Byte.valueOf(bArr[i6]), Byte.valueOf(b6)).byteValue();
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static void yr(@NotNull short[] sArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.collections.d.Companion.d(i6, i7, sArr.length);
        int i8 = (i6 + i7) / 2;
        if (i6 == i8) {
            return;
        }
        int i9 = i7 - 1;
        while (i6 < i8) {
            short s5 = sArr[i6];
            sArr[i6] = sArr[i9];
            sArr[i9] = s5;
            i9--;
            i6++;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Integer> ys(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (iArr.length == 0) {
            return h0.J();
        }
        int i6 = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(i6));
        int length = iArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            i6 = operation.invoke(Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(iArr[i7])).intValue();
            arrayList.add(Integer.valueOf(i6));
        }
        return arrayList;
    }

    public static long yt(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @NotNull
    public static int[] yu(@NotNull int[] iArr, @NotNull Collection<Integer> indices) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr2[i6] = iArr[it.next().intValue()];
            i6++;
        }
        return iArr2;
    }

    @NotNull
    public static final <T> T[] yv(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.g0.o(tArr2, "copyOf(...)");
        kotlin.collections.q.h4(tArr2, comparator);
        return tArr2;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int yw(@NotNull char[] cArr, @NotNull Function1<? super Character, Integer> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (char c6 : cArr) {
            i6 += selector.invoke(Character.valueOf(c6)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int yx(double[] dArr, Function1<? super Double, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (double d6 : dArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Double.valueOf(d6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final List<Boolean> yy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z5 : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z5)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z5));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Boolean> yz(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return (Set) Ky(zArr, new LinkedHashSet(k1.j(zArr.length)));
    }

    public static final <T> boolean z5(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (T t5 : tArr) {
            if (predicate.invoke(t5).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Character>> M z6(@NotNull char[] cArr, @NotNull M destination, @NotNull Function1<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        for (char c6 : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c6)), Character.valueOf(c6));
        }
        return destination;
    }

    @JvmName(name = "averageOfInt")
    public static final double z7(@NotNull Integer[] numArr) {
        kotlin.jvm.internal.g0.p(numArr, "<this>");
        double d6 = 0.0d;
        int i6 = 0;
        for (Integer num : numArr) {
            d6 += num.intValue();
            i6++;
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        return d6 / i6;
    }

    public static boolean z8(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return Zf(iArr, i6) >= 0;
    }

    @NotNull
    public static final List<Double> z9(@NotNull double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (i6 >= 0) {
            return Zx(dArr, kotlin.ranges.t.u(dArr.length - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @NotNull
    public static final <V> List<V> zA(@NotNull double[] dArr, @NotNull double[] other, @NotNull Function2<? super Double, ? super Double, ? extends V> transform) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        kotlin.jvm.internal.g0.p(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i6]), Double.valueOf(other[i6])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> za(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b6 : bArr) {
            if (predicate.invoke(Byte.valueOf(b6)).booleanValue()) {
                arrayList.add(Byte.valueOf(b6));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C zb(@NotNull float[] fArr, @NotNull C destination, @NotNull Function1<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (float f6 : fArr) {
            if (predicate.invoke(Float.valueOf(f6)).booleanValue()) {
                destination.add(Float.valueOf(f6));
            }
        }
        return destination;
    }

    @Nullable
    public static final Float zc(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <R> R zd(@NotNull double[] dArr, R r5, @NotNull Function2<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        for (double d6 : dArr) {
            r5 = operation.invoke(r5, Double.valueOf(d6));
        }
        return r5;
    }

    @NotNull
    public static kotlin.ranges.m ze(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return new kotlin.ranges.m(0, Ie(bArr));
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> zf(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> keySelector, @NotNull Function1<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(keySelector, "keySelector");
        kotlin.jvm.internal.g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s5 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s5));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Short.valueOf(s5)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Set<Float> zg(@NotNull float[] fArr, @NotNull Iterable<Float> other) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        Set<Float> tz = tz(fArr);
        m0.T0(tz, other);
        return tz;
    }

    public static /* synthetic */ String zh(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return qh(cArr, charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    @Nullable
    public static final Short zi(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i6 = length - 1;
            short s5 = sArr[length];
            if (predicate.invoke(Short.valueOf(s5)).booleanValue()) {
                return Short.valueOf(s5);
            }
            if (i6 < 0) {
                return null;
            }
            length = i6;
        }
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> double zj(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d6 = dArr[0];
        int Ke = Ke(dArr);
        if (Ke != 0) {
            R invoke = selector.invoke(Double.valueOf(d6));
            int i6 = 1;
            if (1 <= Ke) {
                while (true) {
                    double d7 = dArr[i6];
                    R invoke2 = selector.invoke(Double.valueOf(d7));
                    if (invoke.compareTo(invoke2) < 0) {
                        d6 = d7;
                        invoke = invoke2;
                    }
                    if (i6 == Ke) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final Float zk(byte[] bArr, Function1<? super Byte, Float> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int Ie = Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Byte.valueOf(bArr[i6])).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Integer zl(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = Me(iArr);
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                if (comparator.compare(Integer.valueOf(i6), Integer.valueOf(i8)) < 0) {
                    i6 = i8;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <R extends Comparable<? super R>> R zm(float[] fArr, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int Le = Le(fArr);
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i6]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Character zn(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = Je(cArr);
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                if (kotlin.jvm.internal.g0.t(c6, c7) > 0) {
                    c6 = c7;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    public static final boolean zo(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @Nullable
    public static final Byte zp(@NotNull byte[] bArr, @NotNull Random random) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.nextInt(bArr.length)]);
    }

    public static final char zq(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        int Je = Je(cArr);
        if (Je < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char c6 = cArr[Je];
        for (int i6 = Je - 1; i6 >= 0; i6--) {
            c6 = operation.invoke(Character.valueOf(cArr[i6]), Character.valueOf(c6)).charValue();
        }
        return c6;
    }

    public static final void zr(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int Qe = Qe(zArr);
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            boolean z5 = zArr[i6];
            zArr[i6] = zArr[Qe];
            zArr[Qe] = z5;
            Qe--;
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final List<Long> zs(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        if (jArr.length == 0) {
            return h0.J();
        }
        long j6 = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(j6));
        int length = jArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            j6 = operation.invoke(Integer.valueOf(i6), Long.valueOf(j6), Long.valueOf(jArr[i6])).longValue();
            arrayList.add(Long.valueOf(j6));
        }
        return arrayList;
    }

    public static final long zt(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        Long l6 = null;
        boolean z5 = false;
        for (long j6 : jArr) {
            if (predicate.invoke(Long.valueOf(j6)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                l6 = Long.valueOf(j6);
                z5 = true;
            }
        }
        if (!z5) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.g0.n(l6, "null cannot be cast to non-null type kotlin.Long");
        return l6.longValue();
    }

    @NotNull
    public static int[] zu(@NotNull int[] iArr, @NotNull kotlin.ranges.m indices) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(indices, "indices");
        return indices.isEmpty() ? new int[0] : kotlin.collections.q.j1(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> zv(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        return Zv(bArr, new g.a(selector));
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int zw(@NotNull double[] dArr, @NotNull Function1<? super Double, Integer> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int i6 = 0;
        for (double d6 : dArr) {
            i6 += selector.invoke(Double.valueOf(d6)).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int zx(float[] fArr, Function1<? super Float, kotlin.z0> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        int k6 = kotlin.z0.k(0);
        for (float f6 : fArr) {
            k6 = kotlin.z0.k(k6 + selector.invoke(Float.valueOf(f6)).q0());
        }
        return k6;
    }

    @NotNull
    public static final boolean[] zy(@NotNull Boolean[] boolArr) {
        kotlin.jvm.internal.g0.p(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i6 = 0; i6 < length; i6++) {
            zArr[i6] = boolArr[i6].booleanValue();
        }
        return zArr;
    }

    @NotNull
    public static final Set<Byte> zz(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? (Set) Cy(bArr, new LinkedHashSet(k1.j(bArr.length))) : v1.f(Byte.valueOf(bArr[0])) : w1.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator bA(Object[] objArr) {
        return kotlin.jvm.internal.h.a(objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator cA(byte[] bArr) {
        return kotlin.jvm.internal.i.b(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator dA(short[] sArr) {
        return kotlin.jvm.internal.i.h(sArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator eA(int[] iArr) {
        return kotlin.jvm.internal.i.f(iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator fA(long[] jArr) {
        return kotlin.jvm.internal.i.g(jArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator gA(float[] fArr) {
        return kotlin.jvm.internal.i.e(fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator hA(double[] dArr) {
        return kotlin.jvm.internal.i.d(dArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator iA(boolean[] zArr) {
        return kotlin.jvm.internal.i.a(zArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator jA(char[] cArr) {
        return kotlin.jvm.internal.i.c(cArr);
    }
}
