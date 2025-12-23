package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.media.MediaPlayer;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class y {

    /* renamed from: b, reason: collision with root package name */
    private static MediaPlayer f20355b;

    /* renamed from: a, reason: collision with root package name */
    private static List<Integer> f20354a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static MediaPlayer.OnCompletionListener f20356c = new MediaPlayer.OnCompletionListener() { // from class: com.bxkj.student.run.app.utils.x
        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            y.h();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static MediaPlayer.OnErrorListener f20357d = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements MediaPlayer.OnErrorListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mp, int what, int extra) {
            if (y.f20355b != null) {
                y.f20355b.reset();
                return false;
            }
            return false;
        }
    }

    public static void e(Context mContext, long tempTime, int countStep) {
        Integer valueOf = Integer.valueOf(R.raw.f17643s);
        Integer valueOf2 = Integer.valueOf(R.raw.num_0);
        if (LoginUser.getLoginUser().getFrequency() != 3 && tempTime <= 216000000) {
            long j6 = 60;
            if (LoginUser.getLoginUser().getFrequency() != 0) {
                if (LoginUser.getLoginUser().getFrequency() == 1) {
                    j6 = 120;
                } else if (LoginUser.getLoginUser().getFrequency() == 2) {
                    j6 = 300;
                }
            }
            if (tempTime % j6 == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(R.raw.dingdong));
                arrayList.add(Integer.valueOf(R.raw.active_for));
                int i6 = (countStep / BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH) % 10;
                if (i6 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i6, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(valueOf);
                }
                int i7 = (countStep / 10000) % 10;
                if (i7 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i7, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.f17644w));
                } else if (i6 > 0) {
                    arrayList.add(valueOf2);
                }
                int i8 = (countStep / 1000) % 10;
                if (i8 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i8, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.f17642k));
                } else if (i7 > 0) {
                    arrayList.add(valueOf2);
                }
                int i9 = (countStep / 100) % 10;
                if (i9 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i9, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.f17641b));
                } else if (i8 > 0) {
                    arrayList.add(valueOf2);
                }
                int i10 = (countStep / 10) % 10;
                if (i10 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i10, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(valueOf);
                } else if (i9 > 0) {
                    arrayList.add(valueOf2);
                }
                int i11 = countStep % 10;
                if (i11 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i11, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                }
                if (countStep > 0 && arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).equals(valueOf2)) {
                    arrayList.remove(arrayList.size() - 1);
                } else if (countStep == 0) {
                    arrayList.add(valueOf2);
                }
                arrayList.add(Integer.valueOf(R.raw.step));
                com.orhanobut.logger.j.c("文字=" + i6 + "十" + i7 + "万" + i8 + "千" + i9 + "百" + i10 + "十" + i11 + "个");
                arrayList.add(Integer.valueOf(R.raw.duration));
                String[] split = i.g(tempTime).split("\\:");
                int parseInt = Integer.parseInt(split[0]);
                if (parseInt > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.hour));
                }
                int parseInt2 = Integer.parseInt(split[1]);
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt2, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                arrayList.add(Integer.valueOf(R.raw.minute));
                d0.e().l(mContext, arrayList);
            }
        }
    }

    public static void f(Context context, int resid) {
        f20354a.add(Integer.valueOf(resid));
        try {
            MediaPlayer mediaPlayer = f20355b;
            if (mediaPlayer == null) {
                d(context, resid);
            } else {
                try {
                    if (mediaPlayer.isPlaying()) {
                        h();
                    }
                } catch (Exception unused) {
                }
            }
            d(context, resid);
            MediaPlayer mediaPlayer2 = f20355b;
            if (mediaPlayer2 == null) {
                com.orhanobut.logger.j.e("cant find soundName", new Object[0]);
            } else {
                mediaPlayer2.start();
            }
        } catch (IllegalStateException e6) {
            e6.printStackTrace();
        }
    }

    public static void g(Context mContext, long tempTime, double tempDistance, int countStep) {
        Integer valueOf = Integer.valueOf(R.raw.f17643s);
        Integer valueOf2 = Integer.valueOf(R.raw.num_0);
        if (LoginUser.getLoginUser().getFrequency() != 3 && tempTime <= 216000000 && tempDistance <= 60000.0d) {
            long j6 = 60;
            if (LoginUser.getLoginUser().getFrequency() != 0) {
                if (LoginUser.getLoginUser().getFrequency() == 1) {
                    j6 = 120;
                } else if (LoginUser.getLoginUser().getFrequency() == 2) {
                    j6 = 300;
                }
            }
            if (tempTime % j6 == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(R.raw.dingdong));
                arrayList.add(Integer.valueOf(R.raw.active_for));
                String d6 = i.d(tempDistance);
                com.orhanobut.logger.j.c("formatDistance=" + d6);
                String[] split = d6.split("\\.");
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + Integer.parseInt(split[0]), ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                arrayList.add(Integer.valueOf(R.raw.dot));
                for (char c6 : split[1].toCharArray()) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + String.valueOf(c6), ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                }
                arrayList.add(Integer.valueOf(R.raw.kilometer));
                int i6 = (countStep / BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH) % 10;
                if (i6 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i6, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(valueOf);
                }
                int i7 = (countStep / 10000) % 10;
                if (i7 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i7, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.f17644w));
                } else if (i6 > 0) {
                    arrayList.add(valueOf2);
                }
                int i8 = (countStep / 1000) % 10;
                if (i8 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i8, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.f17642k));
                } else if (i7 > 0) {
                    arrayList.add(valueOf2);
                }
                int i9 = (countStep / 100) % 10;
                if (i9 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i9, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.f17641b));
                } else if (i8 > 0) {
                    arrayList.add(valueOf2);
                }
                int i10 = (countStep / 10) % 10;
                if (i10 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i10, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(valueOf);
                } else if (i9 > 0) {
                    arrayList.add(valueOf2);
                }
                int i11 = countStep % 10;
                if (i11 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i11, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                }
                if (countStep > 0 && arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).equals(valueOf2)) {
                    arrayList.remove(arrayList.size() - 1);
                } else if (countStep == 0) {
                    arrayList.add(valueOf2);
                }
                arrayList.add(Integer.valueOf(R.raw.step));
                com.orhanobut.logger.j.c("文字=" + i6 + "十" + i7 + "万" + i8 + "千" + i9 + "百" + i10 + "十" + i11 + "个");
                arrayList.add(Integer.valueOf(R.raw.duration));
                String[] split2 = i.g(tempTime).split("\\:");
                int parseInt = Integer.parseInt(split2[0]);
                if (parseInt > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.hour));
                }
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + Integer.parseInt(split2[1]), ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                arrayList.add(Integer.valueOf(R.raw.minute));
                d0.e().l(mContext, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        MediaPlayer mediaPlayer = f20355b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            f20355b.release();
            f20355b = null;
        }
    }

    private static MediaPlayer c(Context context, int resid) {
        MediaPlayer create = MediaPlayer.create(context, resid);
        f20355b = create;
        create.setOnCompletionListener(f20356c);
        f20355b.setOnErrorListener(f20357d);
        return f20355b;
    }

    private static void d(Context context, int resid) {
        f20355b = c(context, resid);
    }
}
