package dk.itu.mmad.customscheme;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Uri data = getIntent().getData();
		TextView tv = (TextView) findViewById(R.id.txtview);
		tv.setText(tv.getText() + ", data: " + data.getHost());
	}

}