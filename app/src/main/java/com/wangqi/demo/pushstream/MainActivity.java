package com.wangqi.demo.pushstream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et_input;
	private EditText et_output;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_input = (EditText) this.findViewById(R.id.et_input);
		et_output = (EditText) this.findViewById(R.id.et_output);
	}

	public void mStart(View btn) {
		String inputurl = Environment.getExternalStorageDirectory().getPath() + "/" + et_input.getText().toString();
		String outputurl = et_output.getText().toString();
		FFmpegUtils.push(inputurl, outputurl);
	}

}
