#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.robotium.solo.Solo;

public class HelloAndroidActivityTest extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	private Solo solo;

	public HelloAndroidActivityTest() {
		super(HelloAndroidActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@LargeTest
	public void testPressHelloWorldButton() {
		solo.assertCurrentActivity("HelloAndroidActivity did not appear.",
				HelloAndroidActivity.class);
		solo.clickOnButton("Hello world!");
		assertTrue(solo.waitForText("Button is pressed"));
	}

}
