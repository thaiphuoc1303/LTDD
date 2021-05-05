//package com.example.notifition;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class ThreadDemo extends Thread{
//    private Thread t;
//    ArrayList<String> tieude, noidung, thoigian;
//
//    ThreadDemo(ArrayList<String> thoigian, ArrayList<String> tieude, ArrayList<String> noidung) {
//        this.thoigian = thoigian;
//        this.noidung = noidung;
//        this.tieude = tieude;
//    }
//
//    public void run() {
//
//        try {
//            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat simpleDateFormatMain = new SimpleDateFormat("E HH mm");
//            for(int i = 0; i< thoigian.size(); i++) {
//                if (thoigian.get(i) == simpleDateFormatMain.format(calendar.getTime())){
//                    MainActivity mn = null;
//                    mn.addNotifications(tieude.get(i), noidung.get(i));
//                }
//            }
//            Thread.sleep(5000);
//        }catch (InterruptedException e) {
////            System.out.println("Thread " +  threadName + " interrupted.");
//        }
////        System.out.println("Thread " +  threadName + " exiting.");
//    }
//
//
//    public void start () {
//
//        if (t == null) {
//
//            t = new Thread ();
//            t.start ();
//        }
//    }
//}
