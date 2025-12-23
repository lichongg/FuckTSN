package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager assetManager, String str) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                    try {
                        for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                            String[] split = readLine.split("#");
                            arrayList.add(new BarEntry(Float.parseFloat(split[1]), Float.parseFloat(split[0])));
                        }
                        bufferedReader2.close();
                        return arrayList;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader = bufferedReader2;
                        e.toString();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                                e7.toString();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } catch (IOException e9) {
                e9.toString();
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<Entry> loadEntriesFromAssets(AssetManager assetManager, String str) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                    try {
                        for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                            String[] split = readLine.split("#");
                            if (split.length <= 2) {
                                arrayList.add(new Entry(Float.parseFloat(split[1]), Float.parseFloat(split[0])));
                            } else {
                                int length = split.length - 1;
                                float[] fArr = new float[length];
                                for (int i6 = 0; i6 < length; i6++) {
                                    fArr[i6] = Float.parseFloat(split[i6]);
                                }
                                arrayList.add(new BarEntry(Integer.parseInt(split[split.length - 1]), fArr));
                            }
                        }
                        bufferedReader2.close();
                        return arrayList;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader = bufferedReader2;
                        e.toString();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                                e7.toString();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e9) {
            e9.toString();
        }
    }

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split("#");
                    if (split.length <= 2) {
                        arrayList.add(new Entry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                    } else {
                        int length = split.length - 1;
                        float[] fArr = new float[length];
                        for (int i6 = 0; i6 < length; i6++) {
                            fArr[i6] = Float.parseFloat(split[i6]);
                        }
                        arrayList.add(new BarEntry(Integer.parseInt(split[split.length - 1]), fArr));
                    }
                } else {
                    return arrayList;
                }
            }
        } catch (IOException e6) {
            e6.toString();
            return arrayList;
        }
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e6) {
                e6.toString();
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry entry : list) {
                bufferedWriter.append((CharSequence) (entry.getY() + "#" + entry.getX()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e7) {
            e7.toString();
        }
    }
}
