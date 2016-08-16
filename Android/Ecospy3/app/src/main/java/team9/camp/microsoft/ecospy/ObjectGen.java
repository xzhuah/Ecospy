package team9.camp.microsoft.ecospy;

import java.util.HashMap;

public class ObjectGen
{
    public static HashMap<String, Integer> objectGen;

    static
    {
        objectGen = new HashMap<String, Integer>();
        objectGen.put("5",1);
        objectGen.put("1,1",6);
        objectGen.put("5,1",6);
        objectGen.put("1,1,1",7);
        objectGen.put("5,1,1",7);
        objectGen.put("6,1",7);
        objectGen.put("1,1,1,1",8);
        objectGen.put("5,1,1,1",8);
        objectGen.put("6,1,1",8);
        objectGen.put("7,1",8);
        objectGen.put("2",9);
        objectGen.put("2,2",10);
        objectGen.put("2,2,2,",11);
        objectGen.put("10,9",11);
        objectGen.put("9,9,9",11);
        objectGen.put("3",12);
        objectGen.put("4",13);
        objectGen.put("5,9",14);
        objectGen.put("6,9",15);
        objectGen.put("7,9",16);
        objectGen.put("8,9",17);
        objectGen.put("5,10",18);
        objectGen.put("6,10",19);
        objectGen.put("7,10",20);
        objectGen.put("8,10",21);
        objectGen.put("5,11",22);
        objectGen.put("6,11",23);
        objectGen.put("7,11",24);
        objectGen.put("8,11",25);
        objectGen.put("5,12",26);
        objectGen.put("6,12",27);
        objectGen.put("7,12",28);
        objectGen.put("8,12",29);
        objectGen.put("5,13",30);
        objectGen.put("6,13",31);
        objectGen.put("7,13",32);
        objectGen.put("8,13",33);
        objectGen.put("5,13,13",34);
        objectGen.put("6,13,13",35);
        objectGen.put("7,13,13",36);
        objectGen.put("8,13,13",37);
        objectGen.put("5,13,13,13",38);
        objectGen.put("6,13,13,13",39);
        objectGen.put("7,13,13,13",40);
        objectGen.put("8,13,13,13",41);
        objectGen.put("3,9",42);
        objectGen.put("10,12",43);
        objectGen.put("12,22",44);
        objectGen.put("12,23",45);
        objectGen.put("12,24",46);
        objectGen.put("12,25",27);
        objectGen.put("9,13",48);
        objectGen.put("10,13",49);
        objectGen.put("11,13",50);
    }

    public String intArray2String(int[] arr)
    {
        String result = "";
        for (int i = 0; i < arr.length; i++)
        {
            result += arr[i] + (i + 1 == arr.length ? "" : ",");
        }
        return result;
    }

}
