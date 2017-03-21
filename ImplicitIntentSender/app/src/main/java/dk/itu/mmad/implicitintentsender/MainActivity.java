package dk.itu.mmad.implicitintentsender;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	public final static String ACTION = "dk.itu.mmad.RECEIVE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button = (Button) findViewById(R.id.button);
		
		final Intent intent = new Intent(ACTION);
		if(!intentCanBeMatched(intent)) {
			button.setEnabled(false);
		}
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
	}
	
	private boolean intentCanBeMatched(Intent intent) {
		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> hits = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		if(hits.size() == 0) {
			return false;
		}
		Log.i("ImplicitIntentSender", "Match: " + hits.get(0).loadLabel(packageManager));
		return true;
	}

}
