package com.example.demoforappstat;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class DemoForAppStat extends ActionBarActivity {
	
	public static boolean isOnForeground(Context context){  
        ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);  
        List<RunningAppProcessInfo> runningAppProcesses = manager.getRunningAppProcesses();  
        for(RunningAppProcessInfo processInf : runningAppProcesses){  
            if(processInf.processName.equals(context.getPackageName())){  
                if(processInf.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND){  
                    return true;  
                }else{  
                    return false;  
                }  
            }  
        }  
        return false;  
    }  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_for_app_stat);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	String tag = "DemoForAppStat";

	@Override
	protected void onStop() {
		Log.e(tag, "onStop");
		Log.e(tag, "onStop isBack:" + !isOnForeground(this) );
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.e(tag, "onDestroy");
		Log.e(tag, "onDestroy isBack:" + !isOnForeground(this) );
		super.onDestroy();
	}

	@Override
	protected void onPause() { 
		Log.e(tag, "onPause");
		Log.e(tag, "onPause isBack:" + !isOnForeground(this) );
		super.onPause();
	}

	@Override
	protected void onResume() {
		Log.e(tag, "onResume");
		Log.e(tag, "onResume isBack:" + !isOnForeground(this) );
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.e(tag, "onStart");
		Log.e(tag, "onStart isBack:" + !isOnForeground(this) );
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo_for_app_stat, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_demo_for_app_stat, container, false);
			return rootView;
		}
		
		
	}
	public void onBtnClick(View v)
	{
		Intent mIntent = new Intent(this, DemoForAppStat.class);
		startActivity(mIntent);
	}
}
