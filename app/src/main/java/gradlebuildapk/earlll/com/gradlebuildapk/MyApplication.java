package gradlebuildapk.earlll.com.gradlebuildapk;

import android.app.Application;

public class MyApplication extends Application {
	private static MyApplication mInstance;

	public static MyApplication instance() {
		return mInstance;
	}

	public void onCreate() {
		super.onCreate();
		mInstance = this;
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
}