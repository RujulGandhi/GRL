package grlshop.app.com.grl.Widgets;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import grlshop.app.com.grl.R;
import grlshop.app.com.grl.Utils.Utils;

import static grlshop.app.com.grl.Utils.Constant.USERID;

public class BaseActivity extends Activity {

    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);
    }

    protected void toast(CharSequence text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected void toast(int resId) {
        toast(this.getResources().getText(resId));
    }

    protected void startActivity(Class klass, boolean clearFlag) {
        Intent in = new Intent(this, klass);
        if (clearFlag) {
            in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(in);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
    }

    protected void startActivity(Class klass) {
        Intent in = new Intent(this, klass);
        startActivity(in);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
    }

    protected void startActivityData(Class klass, HashMap<String, String> hash) {
        Intent in = new Intent(this, klass);
        for (Map.Entry<String, String> entry : hash.entrySet()) {
            in.putExtra(entry.getKey(), entry.getValue());
        }
        startActivity(in);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
    }

    protected String getText(EditText eTxt) {
        return eTxt == null ? "" : eTxt.getText().toString().trim();
    }

    protected boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    protected void write(String key, String val) {
        Utils.WriteSharePrefrence(this, key, val);
    }

    protected String read(String key) {
        return Utils.ReadSharePrefrence(this, key);
    }

    public void hideKeyboard() {
        // Check if no view has focus:
        View view = getCurrentFocus();
        if (view != null) {

            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public boolean isLoggedIn() {
        if (read(USERID).equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}