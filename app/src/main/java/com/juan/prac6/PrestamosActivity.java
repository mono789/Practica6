package com.juan.prac6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class PrestamosActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    PrestamosSQLiteHelper prestamosSQLiteHelper;
    SQLiteDatabase dbContactos;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_prestamos);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_prestamos,contentFrameLayout);
        prestamosSQLiteHelper= new PrestamosSQLiteHelper(this,"PrestamosDB",null,1);
        dbContactos= prestamosSQLiteHelper.getWritableDatabase();
        ArrayList<User> userList =new ArrayList<User>();
        Cursor c= dbContactos.rawQuery("SELECT * FROM prestamos",null);
        if (c.moveToFirst()){
            do{
                User user= new User(c.getString(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4));
                userList.add(user);
            }while(c.moveToNext());
        }
        else{
            Toast.makeText(this,"No hay prestamos", Toast.LENGTH_SHORT).show();}

        PrestamosAdapter contactosAdapter= new PrestamosAdapter(this,userList);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(contactosAdapter);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
