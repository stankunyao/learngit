package com.harmony.themis.software.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args){   
        List<Box> hs = new ArrayList<Box>();   
        hs.add(new Box("1","箱1"));   
        hs.add(new Box("3","箱2"));   
        hs.add(new Box("2","箱2"));   
        hs.add(new Box("2","箱2"));   
        hs.add(new Box("2","箱2"));   
        hs.add(new Box("2","箱2"));   
        List<Box> newStats = new Test().getBox(hs);   
        System.out.println("箱号--------名字");   
        for(Box s:newStats){   
             System.out.println(s.getBoxNo()+"------------"+ s.getBoxName());   
        }   

 }   

 public List<Box> getBox(List<Box> hs){   
     List<Box> boxList = new ArrayList<Box>();   
     boolean flag = false;   
     for (Box sta : hs) {   
         flag = false;   
         for (Box n : boxList) {   
             if (n.equals(sta)) {   
                 flag = true;   
                 break;   
             }   
         }   
         if (!flag) {   
             boxList.add(sta);   
         }   

    }   
    //通过程序进行排序   
//    Collections.sort(boxList,new ComparableYS());   
    return boxList;   
 }   

}   


//class ComparableYS implements Comparator{   
//
// public int compare(Object o1, Object o2){   
//      Box s1 = (Box)o1;   
//      Box s2 = (Box)o2;   
//      //排序顺序 boxNo,boxName   
//      if(!s1.getBoxNo().equals(s2.getBoxNo())){   
//            return s1.getBoxNo().compareTo(s2.getBoxNo());   
//      }
//      else{   
//            return 0;   
//      }   
// }   
//
// public boolean equals(Object o){   
//      return false;   
// }   
//
//}   

class Box{   
private String boxNo;//箱号   
private String boxName;//名字   

public Box(String boxNo,String boxName){   
    this.boxNo = boxNo;   
    this.boxName = boxName;   
}   
  public String getBoxNo() {   
     return boxNo;   
 }   

 public void setBoxNo(String boxNo) {   
     this.boxNo = boxNo;   
 }   

 public String getBoxName() {   
     return boxName;   
 }   

 public void setBoxName(String boxName) {   
     this.boxName = boxName;   
 }   

 //判断是否是同一个箱子   
 public boolean equals(Object o){   
     Box s = (Box)o;   
     return s.getBoxNo().equals(boxNo)?true:false;   
}   

}
