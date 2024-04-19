package com.sinovoice.hcicloudsdk.common;
/* loaded from: classes.dex */
public class InitParam extends ParamProcessor {

    /* loaded from: classes.dex */
    public class AuthParam {
        public static final String PARAM_KEY_APP_CHANNEL = "appChannel";
        public static final String PARAM_KEY_APP_KEY = "appKey";
        public static final String PARAM_KEY_AUTH_PATH = "authPath";
        public static final String PARAM_KEY_AUTO_CLOUD_AUTH = "autoCloudAuth";
        public static final String PARAM_KEY_CLOUD_URL = "cloudUrl";
        public static final String PARAM_KEY_DEVELOPER_KEY = "developerKey";

        public AuthParam(InitParam initParam) {
        }
    }

    /* loaded from: classes.dex */
    public class HttpProxyParam {
        public static final String PARAM_KEY_PROXY_HOST = "netProxy";
        public static final String PARAM_KEY_PROXY_PORT = "netProxyPort";
        public static final String PARAM_KEY_PROXY_PWD = "netProxyPwd";
        public static final String PARAM_KEY_PROXY_USER = "netProxyUser";

        public HttpProxyParam(InitParam initParam) {
        }
    }

    /* loaded from: classes.dex */
    public class LogParam {
        public static final String PARAM_KEY_LOG_FILE_COUNT = "logFileCount";
        public static final String PARAM_KEY_LOG_FILE_PATH = "logFilePath";
        public static final String PARAM_KEY_LOG_FILE_SIZE = "logFileSize";
        public static final String PARAM_KEY_LOG_LEVEL = "logLevel";

        public LogParam(InitParam initParam) {
        }
    }
}
