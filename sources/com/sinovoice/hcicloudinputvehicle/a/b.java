package com.sinovoice.hcicloudinputvehicle.a;

import android.content.Context;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.tools.d;
import com.sinovoice.hcicloudsdk.api.HciCloudSys;
import com.sinovoice.hcicloudsdk.common.CapabilityItem;
import com.sinovoice.hcicloudsdk.common.CapabilityResult;
import com.sinovoice.hcicloudsdk.common.InitParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: SysSDKMgr.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f156a = "com.sinovoice.hcicloudinputvehicle.a.b";

    /* renamed from: b  reason: collision with root package name */
    private static b f157b;

    private b() {
    }

    private boolean a() {
        try {
            InputStream openRawResource = a.f155a.getResources().openRawResource(R.raw.hci_auth_forever);
            int available = openRawResource.available();
            File file = new File(a.f155a.getFilesDir(), "HCI_AUTH_FOREVER");
            if (file.exists() && file.length() == available) {
                openRawResource.close();
                return true;
            }
            FileOutputStream openFileOutput = a.f155a.openFileOutput("HCI_AUTH_FOREVER", 0);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openRawResource.read(bArr);
                if (read > 0) {
                    openFileOutput.write(bArr, 0, read);
                } else {
                    openRawResource.close();
                    openFileOutput.close();
                    b.b.a.b.a.c(f156a, "copyBasicAuth success");
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            b.b.a.b.a.c(f156a, "copyBasicAuth failed");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            b.b.a.b.a.c(f156a, "copyBasicAuth failed");
            return false;
        }
    }

    private InitParam b(Context context) {
        String str;
        if (d.a()) {
            str = context.getFilesDir().getAbsolutePath() + context.getResources().getString(R.string.log_path);
            if (!new File(str).exists()) {
                new File(str).mkdirs();
            }
            b.b.a.b.a.c(f156a, "hcicloud log path: " + str);
        } else {
            str = "";
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        InitParam initParam = new InitParam();
        initParam.addParam(InitParam.AuthParam.PARAM_KEY_AUTH_PATH, absolutePath);
        initParam.addParam(InitParam.AuthParam.PARAM_KEY_AUTO_CLOUD_AUTH, "no");
        initParam.addParam(InitParam.AuthParam.PARAM_KEY_CLOUD_URL, g(R.string.cloud_url));
        initParam.addParam(InitParam.AuthParam.PARAM_KEY_APP_KEY, g(R.string.app_key));
        initParam.addParam(InitParam.AuthParam.PARAM_KEY_DEVELOPER_KEY, g(R.string.developer_key));
        if (d.a()) {
            initParam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_COUNT, g(R.string.log_count));
            initParam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_PATH, str);
            initParam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_SIZE, g(R.string.log_file_size));
            initParam.addParam(InitParam.LogParam.PARAM_KEY_LOG_LEVEL, g(R.string.log_level));
        }
        return initParam;
    }

    public static b c() {
        if (f157b == null) {
            f157b = new b();
        }
        return f157b;
    }

    private void e() {
        String str = f156a;
        b.b.a.b.a.a(str, "printAllCapkey()");
        CapabilityResult capabilityResult = new CapabilityResult();
        HciCloudSys.hciGetCapabilityList(null, capabilityResult);
        ArrayList<CapabilityItem> capabilityList = capabilityResult.getCapabilityList();
        if (capabilityList != null && capabilityList.size() > 0) {
            Iterator<CapabilityItem> it = capabilityList.iterator();
            while (it.hasNext()) {
                String str2 = f156a;
                b.b.a.b.a.a(str2, "capability:" + it.next().getCapKey());
            }
            return;
        }
        b.b.a.b.a.b(str, "no capability found!");
    }

    private String g(int i) {
        return a.f155a.getString(i);
    }

    public boolean d(Context context) {
        a.f155a = context;
        if (a()) {
            String stringConfig = b(context).getStringConfig();
            String str = f156a;
            b.b.a.b.a.c(str, "initHciCloudSys sysInitParamStr: " + stringConfig);
            int hciInit = HciCloudSys.hciInit(stringConfig, context);
            if (hciInit != 0 && hciInit != 101) {
                b.b.a.b.a.b(str, "initHciCloudSys failed return [" + hciInit + "]. msg = [" + HciCloudSys.hciGetErrorInfo(hciInit) + "]");
                return false;
            }
            e();
            b.b.a.b.a.c(str, "initHciCloudSys success ");
            return true;
        }
        return false;
    }

    public boolean f() {
        int hciRelease = HciCloudSys.hciRelease();
        String str = f156a;
        b.b.a.b.a.c(str, "releaseHciCloud : return [" + hciRelease + "]. msg = [" + HciCloudSys.hciGetErrorInfo(hciRelease) + "]");
        return hciRelease == 0;
    }
}
