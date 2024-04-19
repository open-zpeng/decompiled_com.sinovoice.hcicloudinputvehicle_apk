package com.sinovoice.hcicloudinputvehicle.engine.keyboard;

import com.sinovoice.hcicloudsdk.api.HciCloudSys;
import com.sinovoice.hcicloudsdk.api.kb.HciCloudKb;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.kb.KbConfig;
import com.sinovoice.hcicloudsdk.common.kb.KbQueryInfo;
import com.sinovoice.hcicloudsdk.common.kb.KbRecogResult;
import com.sinovoice.hcicloudsdk.common.kb.KbRecogResultItem;
import com.sinovoice.hcicloudsdk.common.kb.KbSyllableResultItem;
import com.sinovoice.hcicloudsdk.common.kb.KbUdbItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnglishSDKWrapper.java */
/* loaded from: classes.dex */
public class a implements InputSDKWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f166a = "a";

    /* renamed from: b  reason: collision with root package name */
    private KbConfig f167b;
    private Session c;
    private KbRecogResult d;

    private void a(KbRecogResult kbRecogResult, String str) {
        KbRecogResultItem kbRecogResultItem = new KbRecogResultItem();
        kbRecogResultItem.setResult(str);
        ArrayList<KbRecogResultItem> arrayList = new ArrayList<>();
        if (kbRecogResult.getRecogResultItemList() != null) {
            if (kbRecogResult.getRecogResultItemList().size() == 0 || !kbRecogResult.getRecogResultItemList().get(0).getResult().equalsIgnoreCase(kbRecogResultItem.getResult())) {
                arrayList.add(kbRecogResultItem);
            }
            Iterator<KbRecogResultItem> it = kbRecogResult.getRecogResultItemList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            kbRecogResult.setRecogResultItemList(arrayList);
        }
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
        KbRecogResult b2 = b(this.c, this.f167b, this.d);
        this.d = b2;
        return com.sinovoice.hcicloudinputvehicle.a.a.b(b2);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public boolean init() {
        this.c = new Session();
        this.f167b = new KbConfig();
        this.d = new KbRecogResult();
        this.f167b.addParam("capKey", "kb.local.recog");
        this.f167b.addParam("resPrefix", "_en_");
        this.f167b.addParam("pagecount", "20");
        this.f167b.addParam("inputmode", "lower");
        return HciCloudKb.hciKbSessionStart(this.f167b.getStringConfig(), this.c) == 0;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public d query(String str) {
        KbRecogResult kbRecogResult = this.d;
        if (kbRecogResult == null) {
            return null;
        }
        c(kbRecogResult);
        KbQueryInfo kbQueryInfo = new KbQueryInfo();
        kbQueryInfo.setQuery(str);
        int hciKbRecog = HciCloudKb.hciKbRecog(this.c, this.f167b.getStringConfig(), kbQueryInfo, this.d);
        if (hciKbRecog == 0) {
            a(this.d, kbQueryInfo.getQuery());
        } else {
            String str2 = f166a;
            b.b.a.b.a.b(str2, "query [" + str + "] error : code =[" + hciKbRecog + "] msg = [" + HciCloudSys.hciGetErrorInfo(hciKbRecog) + "]");
        }
        return com.sinovoice.hcicloudinputvehicle.a.a.b(this.d);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public boolean release() {
        Session session = this.c;
        if (session != null) {
            int hciKbSessionStop = HciCloudKb.hciKbSessionStop(session);
            String str = f166a;
            b.b.a.b.a.c(str, "hciKbSessionStop return: " + hciKbSessionStop);
            if (hciKbSessionStop == 0) {
                return true;
            }
        }
        b.b.a.b.a.b(f166a, "mKbSession is null hciKbSessionStop return -1");
        return false;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public void setFuzzyOn(boolean z) {
        throw new UnsupportedOperationException("Not suppport fuzzzy in English engine)");
    }

    @Override // com.sinovoice.hcicloudinputvehicle.engine.keyboard.InputSDKWrapper
    public void submitUDB(String str, String str2) {
        KbRecogResultItem kbRecogResultItem = new KbRecogResultItem();
        kbRecogResultItem.setSymbols("");
        kbRecogResultItem.setResult(str);
        kbRecogResultItem.setMatchItemCount(0);
        kbRecogResultItem.setMatchItemList(null);
        KbUdbItemInfo kbUdbItemInfo = new KbUdbItemInfo();
        kbUdbItemInfo.setRecogResultItem(kbRecogResultItem);
        int hciKbUdbCommit = HciCloudKb.hciKbUdbCommit(this.c, "", kbUdbItemInfo);
        String str3 = f166a;
        b.b.a.b.a.b(str3, "submitEnglishUDB: errorcode = " + hciKbUdbCommit);
    }
}
