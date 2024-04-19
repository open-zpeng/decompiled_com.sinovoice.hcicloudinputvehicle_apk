package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import com.sinovoice.hcicloudsdk.api.hwr.HciCloudHwr;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.hwr.HwrConfig;
import com.sinovoice.hcicloudsdk.common.hwr.HwrRecogResult;
import com.sinovoice.hcicloudsdk.common.hwr.HwrRecogResultItem;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandWriteSDKWrapper.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f164a = "f";

    /* renamed from: b  reason: collision with root package name */
    protected Session f165b;
    protected HwrConfig c;

    public void a() {
        this.f165b = new Session();
        HwrConfig hwrConfig = new HwrConfig();
        this.c = hwrConfig;
        hwrConfig.addParam("capKey", "hwr.local.freestylus");
        this.c.addParam("realtime", "yes");
        this.c.addParam(HwrConfig.InputConfig.PARAM_KEY_SPLIT_MODE, "line");
        this.c.addParam(HwrConfig.InputConfig.PARAM_KEY_WORD_MODE, "mixed");
        this.c.addParam("candNum", "10");
        this.c.addParam("dispCode", "nochange");
    }

    public final ArrayList<String> b(short[] sArr) {
        return c(sArr, 0);
    }

    public final ArrayList<String> c(short[] sArr, int i) {
        HwrRecogResult hwrRecogResult = new HwrRecogResult();
        if (i == 1) {
            this.c.addParam("dispCode", "tosimplified");
        } else if (i == 2) {
            this.c.addParam("dispCode", "totraditional");
        } else {
            this.c.addParam("dispCode", "nochange");
        }
        this.c.addParam(HwrConfig.InputConfig.PARAM_KEY_SPLIT_MODE, com.sinovoice.hcicloudinputvehicle.service.f.b().a().a());
        int hciHwrRecog = HciCloudHwr.hciHwrRecog(this.f165b, sArr, this.c.getStringConfig(), hwrRecogResult);
        String str = f164a;
        b.b.a.b.a.c(str, "hwrRecog() recogResult: " + hciHwrRecog);
        ArrayList<HwrRecogResultItem> resultItemList = hwrRecogResult.getResultItemList();
        ArrayList<String> arrayList = new ArrayList<>();
        if (hwrRecogResult.getResultItemList() != null && hwrRecogResult.getResultItemList().size() > 0) {
            Iterator<HwrRecogResultItem> it = resultItemList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getResult());
            }
        }
        return arrayList;
    }

    public final ArrayList<String> d(short[] sArr, String str) {
        this.c.parseStringConfig(this.c.getStringConfig() + "," + str);
        HwrRecogResult hwrRecogResult = new HwrRecogResult();
        int hciHwrRecog = HciCloudHwr.hciHwrRecog(this.f165b, sArr, this.c.getStringConfig(), hwrRecogResult);
        String str2 = f164a;
        b.b.a.b.a.c(str2, "hwrRecog() recogResult: " + hciHwrRecog);
        ArrayList<HwrRecogResultItem> resultItemList = hwrRecogResult.getResultItemList();
        ArrayList<String> arrayList = new ArrayList<>();
        if (hwrRecogResult.getResultItemList() != null && hwrRecogResult.getResultItemList().size() > 0) {
            Iterator<HwrRecogResultItem> it = resultItemList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getResult());
            }
        }
        return arrayList;
    }

    public final void e() {
        Session session = this.f165b;
        if (session != null) {
            int hciHwrSessionStop = HciCloudHwr.hciHwrSessionStop(session);
            this.f165b = null;
            String str = f164a;
            b.b.a.b.a.c(str, "hciHWRSessionStop return: " + hciHwrSessionStop);
        }
    }
}
