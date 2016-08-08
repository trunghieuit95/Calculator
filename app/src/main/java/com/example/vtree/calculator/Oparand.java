package com.example.vtree.calculator;

/**
 * Created by longdg123 on 8/3/2016.
 */
public class Oparand {
    int _id;
    String Op_bottom;  // phep tinh
    String Op_high;    // ket qua

    public Oparand(int _id, String op_bottom, String op_high) {
        this._id = _id;
        Op_bottom = op_bottom;
        Op_high = op_high;
    }

    public Oparand(String op_high, String op_bottom) {
        Op_high = op_high;
        Op_bottom = op_bottom;
    }

    public Oparand() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getOp_bottom() {
        return Op_bottom;
    }

    public void setOp_bottom(String op_bottom) {
        Op_bottom = op_bottom;
    }

    public String getOp_high() {
        return Op_high;
    }

    public void setOp_high(String op_high) {
        Op_high = op_high;
    }
}
