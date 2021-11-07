/*
NOTE: 
This is just a prototype of the final Table class
Need to create table class with proper columns
*/


package OOPSproject.src;

import java.io.*;
import java.util.Scanner;

class Table{
    //Column Names(We can change these as required)
    private int id;
    private String name;
    private int salary;

    //Table Constructor
    public Table(int id,String name,int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    //toString() utility function
    @Override
    public String toString(){
        String str="Id: "+this.id+"\nName: "+this.name+"\nSalary: "+this.salary;
        return str;
    }

    //Method to convert any CSV file to a Table array
    public static Table[] CSVToTable(String filePath){
        Table[] t=new Table[100];  //Increase the size of the table array to accomodate more data
        int pos=0;
        try{
            Scanner sin=new Scanner(new BufferedReader(new FileReader(filePath)));
            while(sin.hasNext()){
                String str=sin.nextLine();
                String[] tokens=str.split(",");
                t[pos++]=new Table(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2]));
            }
            sin.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        return t;
    }
}