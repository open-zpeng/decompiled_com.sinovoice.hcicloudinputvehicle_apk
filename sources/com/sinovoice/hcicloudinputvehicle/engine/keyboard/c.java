package com.sinovoice.hcicloudinputvehicle.engine.keyboard;

import android.text.TextUtils;
import com.sinovoice.hcicloudsdk.api.kb.HciCloudKb;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.kb.KbConfig;
import com.sinovoice.hcicloudsdk.common.kb.KbFuzzySyllable;
import com.sinovoice.hcicloudsdk.common.kb.KbQueryInfo;
import com.sinovoice.hcicloudsdk.common.kb.KbRecogResult;
import com.sinovoice.hcicloudsdk.common.kb.KbRecogResultItem;
import com.sinovoice.hcicloudsdk.common.kb.KbSyllableResultItem;
import com.sinovoice.hcicloudsdk.common.kb.KbUdbItemInfo;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PinYinSDKWrapper.java */
/* loaded from: classes.dex */
public class c implements InputSDKWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f170a = InputSDKWrapper.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private KbConfig f171b;
    private Session c;
    private KbRecogResult d;
    private final String[][] e = {new String[]{"ch", "c"}, new String[]{"sh", "s"}, new String[]{"zh", "z"}, new String[]{"k", "g"}, new String[]{"f", "h"}, new String[]{"n", "l"}, new String[]{"r", "l"}, new String[]{"ang", "an"}, new String[]{"eng", "en"}, new String[]{"ing", "in"}, new String[]{"iang", "ian"}, new String[]{"uang", "uan"}};
    private final String[][] f = {new String[]{"ch", "ch"}};

    private KbFuzzySyllable[] a(int i) {
        KbFuzzySyllable[] kbFuzzySyllableArr = new KbFuzzySyllable[i];
        for (int i2 = 0; i2 < i; i2++) {
            KbFuzzySyllable kbFuzzySyllable = new KbFuzzySyllable();
            kbFuzzySyllable.setFuzzySyllableType(0);
            kbFuzzySyllable.setSyllableOne(this.e[i2][0]);
            kbFuzzySyllable.setSyllableTwo(this.e[i2][1]);
            kbFuzzySyllableArr[i2] = kbFuzzySyllable;
        }
        return kbFuzzySyllableArr;
    }

    private KbRecogResult b(Session session, KbConfig kbConfig, KbRecogResult kbRecogResult) {
        ArrayList<KbRecogResultItem> arrayList = new ArrayList<>();
        ArrayList<KbSyllableResultItem> arrayList2 = new ArrayList<>();
        if (kbRecogResult != null) {
            if (kbRecogResult.getRecogResultItemList() != null) {
                arrayList.addAll(kbRecogResult.getRecogResultItemList());
            }
            if (kbRecogResult.getSyllableResultItemList() != null) {
                arrayList2.addAll(kbRecogResult.getSyllableResultItemList());
            }
            KbRecogResult kbRecogResult2 = new KbRecogResult();
            if (kbRecogResult.getBmore()) {
                if (HciCloudKb.hciKbRecog(session, kbConfig.getStringConfig(), null, kbRecogResult) == 0) {
                    if (kbRecogResult.getRecogResultItemList() != null) {
                        arrayList.addAll(kbRecogResult.getRecogResultItemList());
                    }
                    if (kbRecogResult.getSyllableResultItemList() != null) {
                        arrayList2.addAll(kbRecogResult.getSyllableResultItemList());
                    }
                    kbRecogResult2.setBmore(kbRecogResult.getBmore());
                } else {
                    kbRecogResult2.setBmore(false);
                }
            }
            kbRecogResult2.setRecogResultItemList(arrayList);
            kbRecogResult2.setSyllableResultItemList(arrayList2);
            return kbRecogResult2;
        }
        return new KbRecogResult();
    }

    private void c(KbRecogResult kbRecogResult) {
        kbRecogResult.setBmore(false);
        kbRecogResult.setRecogResultItemList(new ArrayList<>());
        kbRecogResult.setSyllableResultItemList(new ArrayList<>());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public d getMore() {
        KbRecogResult b2 = b(this.c, this.f171b, this.d);
        this.d = b2;
        return com.sinovoice.hcicloudinputvehicle.a.a.b(b2);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public boolean init() {
        this.c = new Session();
        this.f171b = new KbConfig();
        this.d = new KbRecogResult();
        this.f171b.addParam("capKey", "kb.local.recog");
        this.f171b.addParam("resPrefix", "_cn_");
        this.f171b.addParam("pagecount", "20");
        this.f171b.addParam("inputmode", "pinyin");
        this.f171b.addParam("keyboard", "t9");
        this.f171b.addParam("faultTolerantLevel", "high");
        return HciCloudKb.hciKbSessionStart(this.f171b.getStringConfig(), this.c) == 0;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public d query(String str) {
        c(this.d);
        KbQueryInfo kbQueryInfo = new KbQueryInfo();
        kbQueryInfo.setQuery(str);
        HciCloudKb.hciKbRecog(this.c, this.f171b.getStringConfig(), kbQueryInfo, this.d);
        return com.sinovoice.hcicloudinputvehicle.a.a.b(this.d);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public boolean release() {
        Session session = this.c;
        if (session != null) {
            int hciKbSessionStop = HciCloudKb.hciKbSessionStop(session);
            String str = f170a;
            b.b.a.b.a.c(str, "hciKbSessionStop return: " + hciKbSessionStop);
            if (hciKbSessionStop == 0) {
                return true;
            }
        }
        b.b.a.b.a.b(f170a, "mKbSession is null hciKbSessionStop return -1");
        return false;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public void setFuzzyOn(boolean z) {
        Session session = this.c;
        if (session != null) {
            if (z) {
                int hciKbFuzzySyllable = HciCloudKb.hciKbFuzzySyllable(this.c, a(this.e.length));
                String str = f170a;
                b.b.a.b.a.c(str, "setFuzzy() result: " + hciKbFuzzySyllable);
                return;
            }
            int hciKbFuzzySyllable2 = HciCloudKb.hciKbFuzzySyllable(session, null);
            String str2 = f170a;
            b.b.a.b.a.c(str2, "setFuzzy() result: " + hciKbFuzzySyllable2);
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public void submitUDB(String str, String str2) {
        KbRecogResultItem kbRecogResultItem = new KbRecogResultItem();
        kbRecogResultItem.setResult(str);
        if (!TextUtils.isEmpty(str) && str.length() == 1) {
            kbRecogResultItem.setSymbols(str2);
        } else {
            kbRecogResultItem.setSymbols("");
        }
        KbUdbItemInfo kbUdbItemInfo = new KbUdbItemInfo();
        kbUdbItemInfo.setRecogResultItem(kbRecogResultItem);
        int hciKbUdbCommit = HciCloudKb.hciKbUdbCommit(this.c, "inputMode=pinyin", kbUdbItemInfo);
        String str3 = f170a;
        b.b.a.b.a.b(str3, "submitChineseUDB: errorcode = " + hciKbUdbCommit);
    }
}
