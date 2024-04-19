package com.sinovoice.hcicloudinputvehicle.a;

import android.content.Context;
import com.sinovoice.hcicloudinputvehicle.engine.keyboard.d;
import com.sinovoice.hcicloudinputvehicle.engine.keyboard.e;
import com.sinovoice.hcicloudinputvehicle.engine.keyboard.f;
import com.sinovoice.hcicloudsdk.common.kb.KbRecogResult;
import com.sinovoice.hcicloudsdk.common.kb.KbRecogResultItem;
import com.sinovoice.hcicloudsdk.common.kb.KbResultMatchItem;
import com.sinovoice.hcicloudsdk.common.kb.KbSyllableResultItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: HciCloudUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f155a;

    public static String a() {
        b.b.a.a.a.a("context must be checkAndInit. ", f155a != null);
        String replace = f155a.getFilesDir().getAbsolutePath().replace("files", "lib");
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append("/lib_en_kb.dic.so");
        return !new File(sb.toString()).exists() ? "/system/lib" : replace;
    }

    public static d b(KbRecogResult kbRecogResult) {
        d dVar = new d();
        if (kbRecogResult != null && kbRecogResult.getRecogResultItemList() != null) {
            ArrayList<KbRecogResultItem> recogResultItemList = kbRecogResult.getRecogResultItemList();
            ArrayList<e> arrayList = new ArrayList<>();
            Iterator<KbRecogResultItem> it = recogResultItemList.iterator();
            while (it.hasNext()) {
                KbRecogResultItem next = it.next();
                e eVar = new e();
                eVar.d(next.getResult());
                eVar.e(next.getSymbols());
                ArrayList<f> arrayList2 = new ArrayList<>();
                ArrayList<KbResultMatchItem> matchItemList = next.getMatchItemList();
                if (matchItemList != null) {
                    Iterator<KbResultMatchItem> it2 = matchItemList.iterator();
                    while (it2.hasNext()) {
                        KbResultMatchItem next2 = it2.next();
                        f fVar = new f();
                        fVar.a(next2.getResultItem());
                        fVar.b(next2.getSymbolsItem());
                        arrayList2.add(fVar);
                    }
                }
                eVar.c(arrayList2);
                arrayList.add(eVar);
            }
            ArrayList<KbSyllableResultItem> syllableResultItemList = kbRecogResult.getSyllableResultItemList();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (syllableResultItemList != null) {
                Iterator<KbSyllableResultItem> it3 = syllableResultItemList.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(it3.next().getSyllableResultItem());
                }
            }
            dVar.d(arrayList);
            dVar.e(arrayList3);
            dVar.c(kbRecogResult.getBmore());
        }
        return dVar;
    }
}
