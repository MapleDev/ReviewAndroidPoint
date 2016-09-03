package com.xznn.mvp_demo.app.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.xznn.mvp_demo.R;
import com.xznn.mvp_demo.app.presenter.TestUserLocalPresenter;
import com.xznn.mvp_demo.app.presenter.TestUserRemotePresenter;
import com.xznn.mvp_demo.base.fragment.BaseFragment;
import com.xznn.mvp_demo.base.model.Params;


public class UserPackageFragment extends BaseFragment implements
		OnClickListener {

	private TestUserRemotePresenter userRemotePresenter;

	private TestUserLocalPresenter userLocalPresenter;

	public UserPackageFragment() {
		super(UserPackageFragment.class.getName(),
				new TestUserRemotePresenter(), new TestUserLocalPresenter());
		userRemotePresenter = (TestUserRemotePresenter) iPresenters[0];
		userLocalPresenter = (TestUserLocalPresenter) iPresenters[1];
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_user_package, container,
				false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		getDatas();
	}

	private void initView() {
	}

	@Override
	public void onClick(View v) {

	}

	private void getDatas() {
		// QueryString. Maybe from TextView, EditText...
		Params params = new Params();

		// TODO Remote test
		userRemotePresenter.queryPackage(mContext, params,
				new AbstractRequestCallback<Result<Package<User>>>() {

					@Override
					public void onRequestSuccess(Result<Package<User>> result) {
						Package<User> pack = result.getBody();
						String tips = "\n当前页：" + pack.pageNo + "\n每页显示："
								+ pack.pageSize + "\n总记录：" + pack.count + "\n";
						for (User user : pack.datas) {
							tips += "\nID：" + user.getId() + "\nUserName："
									+ user.getName() + "\nAge：" + user.getAge()
									+ "\n";
						}
						showMessage(tips);
					}

					@Override
					public void onRequestFailure(Throwable error) {
						showMessage("请求接口queryPackage失败");
					}
				});
		// TODO Local test
		Package<User> pack = userLocalPresenter.queryPackage(params);
		Log.d(TAG, "Just for test. Get Package from local "
				+ (pack == null ? true : false));
	}

}
