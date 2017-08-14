package com.dqc.qlibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * BaseFragment
 */
@SuppressWarnings("WeakerAccess,unused")
public abstract class BaseFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * startActivity
     *
     * @param clazz Activity.class
     */
    protected void goTo(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    /**
     * startActivity with flags
     *
     * @param clazz Activity.class
     * @param flags FLAG_ACTIVITY
     */
    protected void goTo(Class<?> clazz, int flags) {
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
    protected void goTo(Class<?> clazz, Bundle bundle) {
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
    protected void goTo(Class<?> clazz, Bundle bundle, int flags) {
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
    protected void goToThenKill(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * startActivity with flags then finish
     *
     * @param clazz Activity.class
     * @param flags FLAG_ACTIVITY
     */
    protected void goToThenKill(Class<?> clazz, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.addFlags(flags);
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz  Activity.class
     * @param bundle data
     */
    protected void goToThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * startActivity with bundle and flags then finish
     *
     * @param clazz  Activity.class
     * @param bundle data
     * @param flags  FLAG_ACTIVITY
     */
    protected void goToThenKill(Class<?> clazz, Bundle bundle, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       Activity.class
     * @param requestCode RequestCode
     */
    protected void goToForResult(Class<?> clazz, int requestCode) {
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
    protected void goToForResult(Class<?> clazz, int requestCode, int flags) {
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
    protected void goToForResult(Class<?> clazz, int requestCode, Bundle bundle) {
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
    protected void goToForResult(Class<?> clazz, int requestCode, Bundle bundle, int flags) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        intent.addFlags(flags);
        startActivityForResult(intent, requestCode);
    }
}
