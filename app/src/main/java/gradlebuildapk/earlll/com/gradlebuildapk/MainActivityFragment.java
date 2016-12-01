package gradlebuildapk.earlll.com.gradlebuildapk;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    TextView tv_show;
    TextView tv_show1;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tv_show= (TextView)view.findViewById(R.id.tv_show);
        tv_show1= (TextView)view.findViewById(R.id.tv_show1);
        setTextShow(tv_show,getMetaData("UMENG_CHANNEL")+"-"+getMetaData("YINTAI_CHANNEL")+"-"+getMetaData("CHANNEL_NAME"));
        setTextShow(tv_show1,"-"+getActivity().getString(R.string.gradle_show)+"-"+getActivity().getString(R.string.gradle_show1));
        return view;
    }
    public void setTextShow(TextView tv,String text){
        if(tv!=null){
            tv.setText(text);
        }
    }

    public String getMetaData(String key){
        String metaDataValue=null;
        try {
            ApplicationInfo info = MyApplication.instance().getPackageManager()
                    .getApplicationInfo(MyApplication.instance().getPackageName(), PackageManager.GET_META_DATA);
            if(info!=null&&info.metaData!=null){
                metaDataValue = info.metaData.getString(key);
                return metaDataValue;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
