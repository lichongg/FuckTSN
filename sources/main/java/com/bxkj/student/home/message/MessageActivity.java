package com.bxkj.student.home.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.chat.ConversationListActivity;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MessageActivity extends BaseActivity {
    private TextView W;
    private TextView X;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        startActivity(new Intent(this.T, (Class<?>) ConversationListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.message.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageActivity.this.i0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("消息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_message;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_notice_message);
        this.X = (TextView) findViewById(R.id.tv_chat_message);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131298995) {
            return;
        }
        startActivity(new Intent(this.T, (Class<?>) SystemMessageListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }
}
