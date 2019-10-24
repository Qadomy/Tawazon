package com.blue.tawazon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.blue.tawazon.Adapter.ProfileItemAdapter;
import com.blue.tawazon.Classes.ProfileItems;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class ProfileButton extends AppCompatActivity {

    private Button closeProfileButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_button);


        closeProfileButton = findViewById(R.id.closeProfileButton);
        closeProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileButton.this, MainActivity.class);
                startActivity(i);
                customType(ProfileButton.this,"up-to-bottom");


            }
        });

        ArrayList<ProfileItems> profileItems = new ArrayList<ProfileItems>();
        profileItems.add(new ProfileItems("الملف الشخصي والحساب","ملفك الشخصي واعدادات حسابك",R.drawable.profile,R.drawable.icarrow_left));
        profileItems.add(new ProfileItems("مكتبة التحميلات","المحاضرات التي بامكانك تشغيلها بدون الحاجة لانترنت",R.drawable.download,R.drawable.icarrow_left));
        profileItems.add(new ProfileItems("توازن بريميوم","خطة الأشتراك السنوي المدفوعة الخاصة بك",R.drawable.snow,R.drawable.icarrow_left));
        profileItems.add(new ProfileItems("الأشعارات","استقبال الاشعارات من التطبيق",R.drawable.notification,R.drawable.icarrow_left));
        profileItems.add(new ProfileItems("المساعدة والدعم","لديك مشكلة؟ اقتراح؟ أرسل لنا",R.drawable.help,R.drawable.icarrow_left));
        profileItems.add(new ProfileItems("سياسة الخصوصية","بنود سياسة الخصوصية وشروط الخدمة",R.drawable.privacy,R.drawable.icarrow_left));
        profileItems.add(new ProfileItems("شروط الأستخدام","بنود شروط الخدمة",R.drawable.fuctions,R.drawable.icarrow_left));
        profileItems.add(new ProfileItems("قصتنا","تعرف على قصتنا ومن نحن؟",R.drawable.story,R.drawable.icarrow_left));

        ProfileItemAdapter profileItemAdapter = new ProfileItemAdapter(this, profileItems);

        ListView listView = findViewById(R.id.listview_items);
        listView.setAdapter(profileItemAdapter);
    }
}
