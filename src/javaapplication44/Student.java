/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;


public class Student implements Comparable<Student>{
    int id;
    String Name;
    String Major;
    double Grade;

    public Student(int id, String Name, String Major, double Grade) {
        this.id = id;
        this.Name = Name;
        this.Major = Major;
        this.Grade = Grade;
    }
    @Override
    public String toString(){
        String s = "  "+id+"  "+Name +"  "+Major+"  "+Grade;
        return s;
    }

    @Override
    public int compareTo(Student t) {
       return (int)(this.Grade-  t.Grade);
    }
    
    
}
