package com.example.vtree.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnC, btnP, btnDel,
            btnDeg, btnEq, btnAdd, btnSub, btnDev, btnMul, btnAS;
    TextView tvOparand, tvResult;
    // Khởi tạo các biến để kiểm tra phép toán
    String logicButton = "operation";   // Biến kiểm tra tính hợp lý của phép toán
    boolean logicDot = false;           // Biến kiểm tra tính hợp lý của dấu .
    boolean checkC = false;             // Biến kiểm tra để xóa màn hình
    List<Oparand> oparandList = new ArrayList<>();  //List chứa các phép tính đã thực hiện
    DatabaseHandler db;                             //Khai báo database
    Oparand oparandObject = new Oparand();          //Khởi tạo 1 đối tượng phép tính

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        db = new DatabaseHandler(getApplicationContext());
    }

    /**
     * Khai báo các component đồng thời gán cho sự kiện clickListenner
     */
    public void init() {

        btnC = (Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(this);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);
        btnP = (Button) findViewById(R.id.btnP);
        btnP.setOnClickListener(this);
        btnAS = (Button) findViewById(R.id.btnAS);
        btnAS.setOnClickListener(this);
        btnEq = (Button) findViewById(R.id.btnEquals);
        btnEq.setOnClickListener(this);
        btn0 = (Button) findViewById(R.id.btnZero);
        btn0.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.btnOne);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btnTwo);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btnThree);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btnFour);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btnFive);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btnSix);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btnSeven);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btnEight);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btnNine);
        btn9.setOnClickListener(this);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnSub = (Button) findViewById(R.id.btnSubtract);
        btnSub.setOnClickListener(this);
        btnMul = (Button) findViewById(R.id.btnMultiply);
        btnMul.setOnClickListener(this);
        btnDev = (Button) findViewById(R.id.btnDivide);
        btnDev.setOnClickListener(this);
        btnDeg = (Button) findViewById(R.id.btnDecimal);
        btnDeg.setOnClickListener(this);
        tvOparand = (TextView) findViewById(R.id.txtInput);
        tvResult = (TextView) findViewById(R.id.txtSolution);

    }

    /**
     * Xử lí các sự kiện khi các button được click
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnOne:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*1");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "1");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnTwo:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*2");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "2");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnThree:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*3");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "3");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnFour:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*4");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "4");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnFive:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*5");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "5");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnSix:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*6");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "6");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnSeven:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*7");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "7");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnEight:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*8");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "8");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnNine:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*9");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "9");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnZero:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // Xóa trắng màn mình
                    checkC = false;             // Đặt lại biến checkC
                    logicDot = false;             // Đặt lại biến logicDot
                }
                // Xử lý tính logic khi thêm 1 số vào phép toán hiện tại
                if (logicButton == "percent") {
                    tvOparand.setText(tvOparand.getText() + "*0");  // thay đổi phép tính khi viết tắt
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                } else {
                    tvOparand.setText(tvOparand.getText() + "0");   // Thêm 1 số vào biểu thức hiện tại
                    logicButton = "number";                         // gán lại biến logicButoon để biết ng dùng vừa bấm 1 số
                }
                break;
            case R.id.btnAdd:
                // Nếu người dùng nhập 1 phép toán kiểm tra biến logicButton
                if (logicButton == "operation") {
                    // Nếu logicButton = operation không thực hiện gì
                } else {
                    // Nếu logicButton khác operation
                    tvOparand.setText(tvOparand.getText() + "+");   // thêm dấu "+" vào phép tính đang thực hiện
                    logicButton = "operation";                      // Đặt lại biến logicButton không cho phép ng dừng nhập thêm 1 phép tính nữa
                    logicDot = false;                               // đặt lại biến logicDot
                    checkC = false;                                 // đặt lại biến checkC
                }
                break;
            case R.id.btnSubtract:
                // Nếu người dùng nhập 1 phép toán kiểm tra biến logicButton
                if (logicButton == "operation") {
                    // Nếu logicButton = operation không thực hiện gì
                } else {
                    // Nếu logicButton khác operation
                    tvOparand.setText(tvOparand.getText() + "-");   // thêm dấu "-" vào phép tính đang thực hiện
                    logicButton = "operation";                      // Đặt lại biến logicButton không cho phép ng dừng nhập thêm 1 phép tính nữa
                    logicDot = false;                               // đặt lại biến logicDot
                    checkC = false;                                 // đặt lại biến checkC
                }
                break;
            case R.id.btnMultiply:
                // Nếu người dùng nhập 1 phép toán kiểm tra biến logicButton
                if (logicButton == "operation") {
                    // Nếu logicButton = operation không thực hiện gì
                } else {
                    // Nếu logicButton khác operation
                    tvOparand.setText(tvOparand.getText() + "*");   // thêm dấu "*" vào phép tính đang thực hiện
                    logicButton = "operation";                      // Đặt lại biến logicButton không cho phép ng dừng nhập thêm 1 phép tính nữa
                    logicDot = false;                               // đặt lại biến logicDot
                    checkC = false;                                 // đặt lại biến checkC
                }
                break;
            case R.id.btnDivide:
                // Nếu người dùng nhập 1 phép toán kiểm tra biến logicButton
                if (logicButton == "operation") {
                    // Nếu logicButton = operation không thực hiện gì
                } else {
                    // Nếu logicButton khác operation
                    tvOparand.setText(tvOparand.getText() + "/");   // thêm dấu "/" vào phép tính đang thực hiện
                    logicButton = "operation";                      // Đặt lại biến logicButton cho biết người dùng vừa chọn 1 phép tính
                    logicDot = false;                               // đặt lại biến logicDot
                    checkC = false;                                 // đặt lại biến checkC
                }
                break;
            case R.id.btnP:
                // Nếu người dùng nhập "%" kiếm tra biến logicButton
                if (logicButton == "operation") {
                    // Nếu người dùng nhập sai yêu toast ra thông báo
                    Toast.makeText(MainActivity.this, "Yeu cau nhap so", Toast.LENGTH_SHORT).show();
                } else {
                    tvOparand.setText(tvOparand.getText() + "%");   // thêm "%" vào phép tính đang thực hiện
                    logicButton = "percent";                        // Đặt lại biến logicButton cho biết ng dùng vừa bấm "%"
                    checkC = false;                                 // Đặt lại biến checkC
                }
                break;
            case R.id.btnC:
                tvResult.setText("");           // textView Solution về trắng
                tvOparand.setText("");          // textView Input về trắng
                logicButton = "operation";      // không cho phép nhập phép toán đầu tiên
                logicDot = false;               // cho phép viết dấu "."
                break;
            case R.id.btnDecimal:
                // Nếu có phép tính vừa thực hiện thực thì hiện phép tính mới khi người dùng bấm số hoặc "."
                if ((tvResult.getText() != "" && checkC == true) || tvOparand.getText() == "Loi") {
                    tvOparand.setText("");      // textView Input về trắng
                    checkC = false;
                    logicDot = false;             // cho phép viết dấu "."
                }
                if (logicDot == false) {
                    tvOparand.setText(tvOparand.getText() + ".");     // thêm dấu "." vào biểu thức
                    logicDot = true;                                  // không cho phép viết thêm dấu "." trong 1 số
                }
                break;

            // Button Negative/ Positive . ĐỔi dấu số hạng .
            case R.id.btnAS:
                String strOpa = tvOparand.getText().toString();     // Lấy ra chuỗi phép tính.
                // Kiểm tra phép toán
                if (strOpa == "Loi") {
                    break;
                }
                String[] magStr = strOpa.split("");                 // Đưa vào thành mảng các kí tự.
                // Khởi tạo 1 list string ghi nhớ phép tính trước khi đổi dấu.
                List<String> listS = new ArrayList<>();
                for (int i = 0; i < magStr.length; i++) {
                    listS.add(magStr[i]);                           // Add các element của mảng vào
                }

                // Tìm phép tính cuối cùng trong chuỗi phép tính
                // Nếu là "+" hoặc "-" thì sét lại thành "-" hoặc"+"
                // Nếu là "*" và "/" thì thêm kí tự "+"
                if (listS.lastIndexOf("+") > listS.lastIndexOf("-")
                        && listS.lastIndexOf("+") > listS.lastIndexOf("*")
                        && listS.lastIndexOf("+") > listS.lastIndexOf("/")) {
                    listS.set(listS.lastIndexOf("+"), "-");     //Đổi dấu + thành -
                    strOpa = "";                                //Sét chuỗi phép tính thành rỗng
                    for (int i = 0; i < listS.size(); i++) {
                        strOpa += listS.get(i).toString();       // Add lại các phép tính.
                    }
                    tvOparand.setText(strOpa);                  // hiển thị phép tính mới sau khi đổi dấu.
                } else if (listS.lastIndexOf("-") > listS.lastIndexOf("+")
                        && listS.lastIndexOf("-") > listS.lastIndexOf("*")
                        && listS.lastIndexOf("-") > listS.lastIndexOf("/")) {
                    listS.set(listS.lastIndexOf("-"), "+");
                    strOpa = "";
                    for (int i = 0; i < listS.size(); i++) {

                        strOpa += listS.get(i).toString();
                    }
                    tvOparand.setText(strOpa);
                } else if (listS.lastIndexOf("*") > listS.lastIndexOf("+")
                        && listS.lastIndexOf("*") > listS.lastIndexOf("-")
                        && listS.lastIndexOf("*") > listS.lastIndexOf("/")) {
                    listS.set(listS.lastIndexOf("*"), "*-");
                    strOpa = "";
                    for (int i = 0; i < listS.size(); i++) {

                        strOpa += listS.get(i).toString();
                    }
                    tvOparand.setText(strOpa);
                } else if (listS.lastIndexOf("/") > listS.lastIndexOf("+")
                        && listS.lastIndexOf("/") > listS.lastIndexOf("-")
                        && listS.lastIndexOf("/") > listS.lastIndexOf("*")) {
                    listS.set(listS.lastIndexOf("/"), "/-");
                    strOpa = "";
                    for (int i = 0; i < listS.size(); i++) {

                        strOpa += listS.get(i).toString();
                    }
                    tvOparand.setText(strOpa);
                } else if (listS.indexOf("/") == -1 && listS.indexOf("*") == -1
                        && listS.indexOf("-") == -1 && listS.indexOf("+") == -1) {
                    listS.set(0, "-" + listS.get(0));
                    strOpa = "";
                    for (int i = 0; i < listS.size(); i++) {

                        strOpa += listS.get(i).toString();
                    }
                    tvOparand.setText(strOpa);
                }
                break;
            case R.id.btnDel:
                String oparand1 = tvOparand.getText().toString();
                String newOparand = null;
                String lastLeter = "";
                // tạo các chuỗi tiện cho việc kiểm tra
                String number1 = "0123456789";
                String operation = "+-*/";
                String P1 = "%";
                String dot1 = ".";
                // Xóa toàn bộ nội dung textView Input trong 1 vài trường hợp
                if (oparand1.length() == 1 || oparand1 == "" || oparand1 == "Loi") {
                    tvOparand.setText("");
                    tvResult.setText("");
                    logicButton = "operation";
                    logicDot = false;
                    checkC = false;
                }
                // Xử lý khi biểu thức cần xóa có nhiều ký tự
                else {
                    // xóa ký tự cuối cùng của biểu thức
                    newOparand = oparand1.substring(0, oparand1.length() - 1);
                    // lấy ra ký tự cuối cùng
                    lastLeter = newOparand.substring(newOparand.length() - 1, newOparand.length());
                    // kiểm tra ký tự cuối cùng
                    // nếu là số
                    if (number1.lastIndexOf(lastLeter) != -1) {
                        logicButton = "number";       // đặt lại biến logicButton cho biết ng dừng vừa nhập số
                        checkC = false;
                    }
                    // nếu là phép tính
                    if (operation.lastIndexOf(lastLeter) != -1) {
                        logicButton = "operation ";   // đặt lại biến logicButton cho biết ng dừng vừa nhập phép tính
                    }
                    // nếu là "%"
                    if (P1.lastIndexOf(lastLeter) != -1) {
                        logicButton = "percent";      // đặt lại biến logicButton cho biết ng dừng vừa nhập "%"
                    }
                    // nếu là "."
                    if (dot1.lastIndexOf(lastLeter) != -1) {
                        logicDot = false;              // đặt lại biến logicButton cho biết ng dừng vừa nhập "."
                        checkC = false;
                    }
                }
                tvOparand.setText(newOparand);      // đặt lại nội dung textView Input
                break;
            case R.id.btnEquals:
                // Tính kết quả
                // Kiểm tra phép toán
                if (logicButton == "operation") {
                    // nếu ng dùng chưa hoàn thành phép toán
                    Toast.makeText(MainActivity.this, "Hoan thanh phep toan", Toast.LENGTH_SHORT).show();
                } else {
                    if (tvOparand.getText() != "") {
                        logicButton = "number";   // Cho phép thực hiện phép toán với kết quả của phép tính trước đó
                        checkC = true;            // Xóa màn hình nếu người dùng bấm số hoặc "."
                    }
                    try {
                        String oparand = tvOparand.getText().toString();
                        String newStr = oparand.replaceAll("%", "/100");
                        Expression e = new ExpressionBuilder(newStr).build();
                        double result = e.evaluate();
                        tvResult.setText(tvOparand.getText().toString());
                        tvOparand.setText(result + "");
                        logicDot = true;
                        // Lưu kết quả
                        oparandObject.setOp_bottom(tvOparand.getText().toString());     // Lấy nội dung textView Input
                        oparandObject.setOp_high(tvResult.getText().toString());        // Lấy nội dung textView Solution
                        db.addContact(oparandObject);                                   // Thêm vào database
                    } catch (ArithmeticException e) {
                        tvOparand.setText("Loi");
                    } catch (Exception e) {
                        tvOparand.setText("Loi");
                    }
                }
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.help:
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
