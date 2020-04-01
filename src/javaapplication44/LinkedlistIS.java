/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javafx.scene.Node;

public class LinkedlistIS  
{ 
    node head; 
    node sorted; 
   double num;
   
   
    class node  
    { 
        int val; 
        node next; 
 
        public node(int val)  
        { 
            this.val = val; 
        } 
    } 
  
    
    
    
    public int calculateSum(node headref) {
    node node = headref;
    int sum = 0;
    while (node != null) {
        sum += node.val;
        node = node.next;
    }
    return sum;
}
    
    
//     public double calculateAvg(node headref) {
//    node node = headref;
//    
//   
//    return avg;
//}
    void push(int val)  
    { 
        node newnode = new node(val); 
       
        newnode.next = head; 
     
        head = newnode; 
        num++;
    } 
    void insertionSort(node headref)  
    { 
       
        sorted = null; 
        node current = headref;  
        while (current != null)  
        { 
            // Store next for next iteration 
            node next = current.next; 
            // insert current in sorted linked list 
            sortedInsert(current); 
            // Update current 
            current = next; 
        } 
       
        head = sorted; 
    } 
  
    
    void sortedInsert(node newnode)  
    { 
       
        if (sorted == null || sorted.val >= newnode.val)  
        { 
            newnode.next = sorted; 
            sorted = newnode; 
        } 
        else 
        { 
            node current = sorted; 
            
            while (current.next != null && current.next.val < newnode.val)  
            { 
                current = current.next; 
            } 
            newnode.next = current.next; 
            current.next = newnode; 
        } 
    } 

 
    void printlist(node head)  
    { 
        while (head != null)  
        { 
            System.out.print(head.val + " "); 
            head = head.next; 
        } 
    } 
  
    public static void main(String[] args)  
    { 
        LinkedlistIS list = new LinkedlistIS(); 
             Random r = new Random();
        for(int i=0; i<10;i++){
         list.push(   r.nextInt(100) + 1);
        }

    
        System.out.println("Linked List before Sorting.."); 
        list.printlist(list.head); 
        list.insertionSort(list.head); 
        System.out.println("\nLinkedList After sorting"); 
        list.printlist(list.head);
        System.out.println(" ");
        System.out.println("sum : "+list.calculateSum(list.head));
         System.out.println(" ");
        System.out.println("average : "+list.calculateSum(list.head)/list.num);
        
        
    } 
} 