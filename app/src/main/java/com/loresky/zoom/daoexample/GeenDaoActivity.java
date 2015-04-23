package com.loresky.zoom.daoexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.loresky.zoom.R;
import com.loresky.zoom.daoexample.dbservice.DbService;
import com.loresky.zoom.util.DebugLog;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/3/9.
 */
public class GeenDaoActivity extends Activity implements OnClickListener {

    private Button add, read;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geendao);

        initData();
        initViews();
        setListener();
    }

    private void initViews() {
        add = (Button) findViewById(R.id.add);
        read = (Button) findViewById(R.id.read);
        editText = (EditText) findViewById(R.id.editTextNote);
    }

    private void setListener() {
        add.setOnClickListener(this);
        read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                addNote();
                break;
            case R.id.read:
                readNote();
                break;
            default:
                break;
        }
    }

    private void initData() {

    }

    private void addNote() {
        String noteText = editText.getText().toString();
        editText.setText("");
        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = " " + df.format(new Date());
        Note note = new Note(null, noteText, comment, new Date());
        DbService.getInstance(this).saveNote(note);
    }

    private void readNote() {
        List<Note> lists = DbService.getInstance(this).loadAllNote();
        int len = lists.size();
        for (int i = 0; i < len; i++) {
            DebugLog.i("id:" + lists.get(i).getId() + "  comment:" + lists.get(i).getComment() + "  text:" + lists.get(i).getText());
        }
    }

}
