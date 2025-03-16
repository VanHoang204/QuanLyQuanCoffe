/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ADMIN
 */
import java.util.Date;
public class DateFormater {
    public static String toString(Date date) {
       if (date == null) return "null";
       return date.getYear() + "-" + to2(date.getMonth()) + "-" + to2(date.getDate());
    }
    private static String to2(int i) {
        return i > 10 ? i + "" : "0" + i;
    } 
}
