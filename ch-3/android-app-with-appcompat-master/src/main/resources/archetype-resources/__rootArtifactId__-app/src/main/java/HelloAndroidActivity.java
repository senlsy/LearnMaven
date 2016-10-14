#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelloAndroidActivity extends ActionBarActivity implements
		OnClickListener {

	private Button helloWorldButton;
	private TextView messageText;

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().show();
		helloWorldButton = (Button) findViewById(R.id.button_helloworld);
		helloWorldButton.setOnClickListener(this);
		messageText = (TextView) findViewById(R.id.text_message);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(final View v) {
		if (v == helloWorldButton) {
			messageText.setText(R.string.hit_text2);
		}
	}

}
