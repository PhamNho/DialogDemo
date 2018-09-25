package com.example.nho_pc.demodialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moTimePickerDialog(View view) {
        //lấy thông tin giờ phút hiện tại
        Calendar cal = Calendar.getInstance();
        final int hour = cal.get(Calendar.HOUR_OF_DAY);
        int miute = cal.get(Calendar.MINUTE);
        TimePickerDialog time = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int miute) {
                Toast.makeText(MainActivity.this, "Giờ :" + hourOfDay + "_Phút :" + miute, Toast.LENGTH_SHORT).show();
            }
        }, hour, miute, true);
        // Hiển Thị
        time.show();
    }

    public void moShowDatePicker(View view) {
        //Lấy thông tin ngày, tháng , năm
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //thiết lập thông tin
        DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Toast.makeText(MainActivity.this, "Ngày :" + day + "_Tháng :" + month + "_Năm :" + year, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        //hiển thị
        date.show();
    }

    public void moProgressDialog(View view) {
        //B1: định nghĩa ProgressDialog
        final ProgressDialog progress = new ProgressDialog(this);

        //B2: Thiết lập thông tin
        progress.setTitle("Loading");
        progress.setMessage("Do you want to cancel ?");
        progress.setButton(ProgressDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progress.dismiss();//Ẩn progressDialog
            }
        });
        progress.setButton(ProgressDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progress.cancel();
            }
        });
        //thiết lập dạng progress
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        //B3: hiển thị
        progress.show();

        //thiet lap gia tri % neu sử dụng dạng STYLE_HORIZONTAL
        progress.setProgress(88);
    }

    public void moAlertDialog(View view) {
        //B1: định nghĩa alertDialog
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        //B2: thiết lập thông tin
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát không ?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //B3: hiển thị
        builder.show();
    }

    public void moAlertLisDialog(View view) {
        //B1: định nghĩa
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //mảng dữ liệu
        final String[] lops ={"PT13351","PT13352","PT13353","PT13354","PT13355",};
        //B2: thiết lập thông tin title,message(Listview)
        builder.setTitle("Chọn lớp");
        builder.setItems(lops, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, lops[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //B3: Hiển thị
        builder.show();
    }

    public void moSingleChoiceDialog(View view) {
        //B1: định nghĩa
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //mảng lớp
        final String[] lops={"PT13351","PT13352","PT13353","PT13354","PT13355"};
        //B2: thiết lập
        builder.setSingleChoiceItems(lops, 2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, lops[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setTitle("Chọn Lớp" );
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //B3: hiển thị.
        builder.show();

    }

    public void moMultiChoiceDialog(View view) {
        //B1: định nghĩa
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //mảng dữ liệu
        String[] kynang={"Team work","English","Manage Time"};
        boolean[] checked={true,false,false};

        //B2: thiết lập thông tin
        builder.setTitle("Kỹ năng");
        builder.setMultiChoiceItems(kynang, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("Chọn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //B3: hiển thị
        builder.show();
    }

    public void moCustomDialog(View view) {
        //B1: định nghĩa
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        //B2: thiết lập thông tin
        builder.setTitle("Đăng nhập");
        LayoutInflater inflater= (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View dialogview =inflater.inflate(R.layout.dialog_login,null);
        builder.setView(dialogview);
        // khởi tạo những thành phần trong custom dialog
        final EditText edtName =dialogview.findViewById(R.id.edtName);
        final EditText edtPass=dialogview.findViewById(R.id.edtpass);



        builder.setPositiveButton("Đăng nhập", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String edtname=edtName.getText().toString().trim();
                String edtpass=edtPass.getText().toString();

                Toast.makeText(MainActivity.this, "Tài Khoản :" +edtname+";"+"Mật khẩu :"+edtpass, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //b3: hiển thị
        builder.show();
    }

    public void moCustomToast(View view) {
        //B1: định nghĩa toast
        Toast toast=new Toast(MainActivity.this);
        //B2: thiết lập thông tin
        LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1=inflater.inflate(R.layout.toast_custom,null);
        toast.setView(view1);
        toast.setDuration(Toast.LENGTH_LONG);
        //B3: hiển thị
        toast.show();
    }
}
