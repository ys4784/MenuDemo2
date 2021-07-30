package tw.com.jingyu.menudemo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_BTN1 = Menu.FIRST;     //Menu.FIRST:Menu裡的第一個
    public static final int MENU_BTN2 = Menu.FIRST + 1;
    public static final int MENU_BTN3 = Menu.FIRST + 2;
    public static final int MENU_BTN4 = Menu.FIRST + 3;

    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    public void findViews(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        //註冊到ContextMenu內(長按後彈出視窗)
        registerForContextMenu(btn1);

        //按一下顯示toast
        btn1.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"點一下彈出文字框",Toast.LENGTH_SHORT).show();
        });


    }

    @Override
    //建立ContextMenu(長按後彈出視窗)
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //setHeaderTitle:設定彈窗的標題
        menu.setHeaderTitle("飛機餐的飲品：");

        /*  menu.add(groupID,itemID,order,title):   新增menu內容
        *       groupID:    選項皆單選，屬於同一個group
        *       itemID:     放各個item的ID
        *       order:      排序等級
        *       title:      放menu內容文字
        * */
        menu.add(0,MENU_BTN1,0,"開水");
        menu.add(0,MENU_BTN2,0,"紅茶");
        menu.add(0,MENU_BTN3,0,"咖啡");
        menu.add(0,MENU_BTN4,0,"酒水");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case MENU_BTN1:
                Toast.makeText(getApplicationContext(),"選擇開水",Toast.LENGTH_SHORT).show();
                break;
            case MENU_BTN2:
                Toast.makeText(getApplicationContext(),"選擇紅茶",Toast.LENGTH_SHORT).show();
                break;
            case MENU_BTN3:
                Toast.makeText(getApplicationContext(),"選擇咖啡",Toast.LENGTH_SHORT).show();
                break;
            case MENU_BTN4:
                Toast.makeText(getApplicationContext(),"選擇酒水",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}