package com.dqc.qlibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * QBaseFragment
 *
 * @author .
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class QBaseFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //<editor-fold defaultstate="collapsed" desc="startActivity 相关方法群" >

    /**
     * startActivity
     *
     * @param clazz Activity.class
     */
    public void goTo(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    /**
     * startActivity with flags
     *
     * @param clazz Activity.class
     * @param flags FLAG_ACTIVITY
     */
    public void goTo(Class<?> clazz, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.addFlags(flags);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz  Activity.class
     * @param bundle data
     */
    public void goTo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity with bundle and flags
     *
     * @param clazz  Activity.class
     * @param bundle data
     * @param flags  FLAG_ACTIVITYs
     */
    public void goTo(Class<?> clazz, Bundle bundle, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz Activity.class
     */
    public void goToThenKill(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
        //noinspection ConstantConditions
        getActivity().finish();
    }

    /**
     * startActivity with flags then finish
     *
     * @param clazz Activity.class
     * @param flags FLAG_ACTIVITY
     */
    public void goToThenKill(Class<?> clazz, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.addFlags(flags);
        startActivity(intent);
        //noinspection ConstantConditions
        getActivity().finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz  Activity.class
     * @param bundle data
     */
    public void goToThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        //noinspection ConstantConditions
        getActivity().finish();
    }

    /**
     * startActivity with bundle and flags then finish
     *
     * @param clazz  Activity.class
     * @param bundle data
     * @param flags  FLAG_ACTIVITY
     */
    public void goToThenKill(Class<?> clazz, Bundle bundle, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivity(intent);
        //noinspection ConstantConditions
        getActivity().finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     */
    public void goToForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle flags
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     * @param flags       FLAG_ACTIVITY
     */
    public void goToForResult(Class<?> clazz, int requestCode, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.addFlags(flags);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     * @param bundle      data
     */
    public void goToForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle and flags
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     * @param bundle      data
     * @param flags       FLAG_ACTIVITY
     */
    public void goToForResult(Class<?> clazz, int requestCode, Bundle bundle, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivityForResult(intent, requestCode);
    }

    //</editor-fold>
}
