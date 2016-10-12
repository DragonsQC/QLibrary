package com.dqc.qlibrary.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.dqc.qlibrary.R;

import java.util.List;

/**
 * 网络状态工具类
 *
 * @author DragonsQC
 */
public class NetStateUtils {

    /**
     * 判断是否有网络连接
     *
     * @return 是否有网络连接
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo         mNetworkInfo         = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断WIFI网络是否连接
     *
     * @return WIFI是否连接
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo         mWiFiNetworkInfo     = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null && mWiFiNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断MOBILE网络是否连接
     *
     * @return MOBILE网络是否连接
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo         mMobileNetworkInfo   = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 获取当前的网络状态
     * -1：没有网络，1：WIFI网络，2：wap网络，3：net网络
     *
     * @return 当前的网络状态
     */
    public static int getConnectedType(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo         mNetworkInfo         = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }


    /**
     * 网络未连接时，调用设置方法
     */
    public static void setNetwork(final Context context) {
        new MaterialDialog.Builder(context)
                .title(R.string.net_state_dialog_title)
                .content(R.string.net_state_dialog_msg)
                .cancelable(false)
                .canceledOnTouchOutside(false)
                .autoDismiss(false)
                .negativeText(R.string.exit)
                .negativeColorRes(R.color.gray_500)
                .positiveText(R.string.settings)
                .positiveColorRes(R.color.red_500)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        System.exit(0);
                    }
                })
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Intent intent;
                        /**
                         * 判断系统的版本！如果API大于10 就是3.0+
                         * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同
                         */
                        if (android.os.Build.VERSION.SDK_INT > 10) {
                            intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
                        } else {
                            intent = new Intent();
                            ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
                            intent.setComponent(component);
                            intent.setAction("android.intent.action.VIEW");
                        }
                        context.getApplicationContext().startActivity(intent);
                    }
                })
                .show();

    }

    /**
     * 判断GPS是否打开
     *
     * @return GPS是否打开
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager lm        = ((LocationManager) context.getApplicationContext().getSystemService(Context.LOCATION_SERVICE));
        List<String>    providers = lm.getProviders(true);
        return providers != null && providers.size() > 0;
    }
}