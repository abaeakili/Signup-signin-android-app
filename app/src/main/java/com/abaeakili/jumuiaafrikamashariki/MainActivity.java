package com.abaeakili.jumuiaafrikamashariki;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.ClipboardManager;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import java.util.*;
import java.text.*;



public class MainActivity extends Activity {

	private LinearLayout linear4;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear7;
	private TextView top_textview;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private TextView details_textview;
	private ImageView imageview3;
	private Button play_button;
	private Button pause_button;
	private Button stop_button;
	private TextView textview1;



	private SoundPool soundMedia;
	private MediaPlayer media;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		top_textview = (TextView) findViewById(R.id.top_textview);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		details_textview = (TextView) findViewById(R.id.details_textview);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		play_button = (Button) findViewById(R.id.play_button);
		pause_button = (Button) findViewById(R.id.pause_button);
		stop_button = (Button) findViewById(R.id.stop_button);
		textview1 = (TextView) findViewById(R.id.textview1);




		play_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				media = MediaPlayer.create(getApplicationContext(), R.raw.jumuia);
				media.start();
				showMessage("Music is starting!");
			}
		});
		pause_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				media.pause();
				showMessage("Music Paused!");
			}
		});
		stop_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				media.reset();
				showMessage("Media stopped!");
			}
		});

	}

	private void  initializeLogic() {

	}




	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

}
