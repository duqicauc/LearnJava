//package org.java.learn.jvm;
//
//
//import sun.jvm.hotspot.oops.*;
//import sun.jvm.hotspot.runtime.*;
//import sun.jvm.hotspot.tools.Tool;
//
///**
// * @author duqi
// * @createTime 2018/9/1 下午11:55
// **/
//public class PermTool extends Tool {
//    @Override
//    public void run() {
//        // Show PermGen object histogram
//        ObjectHistogram histo = new ObjectHistogram();
//        VM.getVM().getObjectHeap().iterate(histo);
//        histo.print();
//
//        // List all classes in PermGen with their ClassLoaders
//        VM.getVM().getObjectHeap().iterate(new DefaultHeapVisitor() {
//
//            @Override
//            public boolean doObj(Oop obj) {
//                if (obj.getKlass() instanceof InstanceKlass) {
//                    obj.printValue();
//                    Oop loader = ((InstanceKlass) obj.getKlass()).getClassLoader();
//                    if (loader == null) {
//                        System.out.println(" -- loaded by Bootstrap ClassLoader");
//                    } else {
//                        System.out.print(" -- loaded by ");
//                        loader.printValue();
//                        System.out.println();
//                    }
//                }
//                return false;
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        new PermTool().execute(args);
//    }
//}
