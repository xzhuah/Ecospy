package team9.camp.microsoft.ecospy.game;

import java.util.HashMap;

public class ObjectGen
{
    public static HashMap<String, Integer> objectGen;
    public static HashMap<String, Integer> objectGen2;

    static
    {
        objectGen = new HashMap<String, Integer>();
        objectGen2=new HashMap<String, Integer>();
        objectGen.put("1",5);
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
        objectGen.put("2,2,2",11);
        objectGen.put("10,9",11);
        objectGen.put("9,9,9",11);
        objectGen.put("3",12);
        objectGen.put("4",13);


        /*objectGen.put("5,9",14);
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
        objectGen.put("11,13",50);*/


        objectGen2.put(getArray
                (9,  -1, 9,
                        -1, 5,  -1,
                        9,  -1, 9),14);
        objectGen2.put(getArray
                (9,  -1, 9,
                        -1, 6,  -1,
                        9,  -1, 9),15);
        objectGen2.put(getArray
                (9,  -1, 9,
                        -1, 7,  -1,
                        9,  -1, 9),16);
        objectGen2.put(getArray
                (9,  -1, 9,
                        -1, 8,  -1,
                        9,  -1, 9),17);



        objectGen2.put(getArray
                (-1,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, 5),18);
        objectGen2.put(getArray
                (5,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, -1),18);
        objectGen2.put(getArray
                (3,  -1, -1,
                        -1, 3,  -1,
                        5,  -1, 3),18);
        objectGen2.put(getArray
                (3,  -1, 5,
                        -1, 3,  -1,
                        -1,  -1, 3),18);
        objectGen2.put(getArray
                (-1,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, 6),19);
        objectGen2.put(getArray
                (6,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, -1),19);
        objectGen2.put(getArray
                (3,  -1, -1,
                        -1, 3,  -1,
                        6,  -1, 3),19);
        objectGen2.put(getArray
                (3,  -1, 6,
                        -1, 3,  -1,
                        -1,  -1, 3),19);
        objectGen2.put(getArray
                (-1,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, 7),20);
        objectGen2.put(getArray
                (7,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, -1),20);
        objectGen2.put(getArray
                (3,  -1, -1,
                        -1, 3,  -1,
                        7,  -1, 3),20);
        objectGen2.put(getArray
                (3,  -1, 7,
                        -1, 3,  -1,
                        -1,  -1, 3),20);
        objectGen2.put(getArray
                (-1,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, 8),21);
        objectGen2.put(getArray
                (8,  -1, 3,
                        -1, 3,  -1,
                        3,  -1, -1),21);
        objectGen2.put(getArray
                (3,  -1, -1,
                        -1, 3,  -1,
                        8,  -1, 3),21);
        objectGen2.put(getArray
                (3,  -1, 8,
                        -1, 3,  -1,
                        -1,  -1, 3),21);

        objectGen2.put(getArray
                (-1,  11, -1,
                        -1, 5,  -1,
                        -1, 10,-1),22);
        objectGen2.put(getArray
                (-1,  11, -1,
                        -1, 6,  -1,
                        -1, 10,-1),23);
        objectGen2.put(getArray
                (-1,  11, -1,
                        -1, 7,  -1,
                        -1, 10,-1),24);
        objectGen2.put(getArray
                (-1,  11, -1,
                        -1, 8,  -1,
                        -1, 10,-1),25);



        //High Level

        objectGen2.put(getArray
                (2,  2, 2,
                        2, 12,  2,
                        2, 2,2),26);

        objectGen2.put(getArray
                (2,  2, 2,
                        1, 4,  1,
                        2, 2,2),27);
        objectGen2.put(getArray
                (3,  3, 3,
                        12, -1,  12,
                        3, 3,3),28);
        objectGen2.put(getArray
                (12,  12, -1,
                        12, 12,  -1,
                        12, 12,-1),29);
        objectGen2.put(getArray
                (-1,  12, 12,
                        -1, 12, 12,
                        -1, 12,12),29);

        objectGen2.put(getArray
                (10,  1, 10,
                        1, 11, 1,
                        10, 1,10),30);

        objectGen2.put(getArray
                (-1,  11, -1,
                        4, 1, 4,
                        -1, 4,-1),31);

        objectGen2.put(getArray
                (-1,  11, -1,
                        2, 1, 2,
                        -1, 2,-1),32);

        objectGen2.put(getArray
                (4,  4, 4,
                        4, -1, 4,
                        4, 4,4),33);
        objectGen2.put(getArray
                (13,  13, 13,
                        4, -1, 4,
                        2, -1,2),34);

        objectGen2.put(getArray
                (13,  13, 13,
                        13, 10, 13,
                        13, 1,13),35);
        objectGen2.put(getArray
                (13,  1, 13,
                        13, 10, 13,
                        13, 13,13),35);
        objectGen2.put(getArray
                (13,  13, 13,
                        13, 10, 1,
                        13, 13,13),35);
        objectGen2.put(getArray
                (13,  13, 13,
                        1, 10, 13,
                        13, 13,13),35);

        objectGen2.put(getArray
                (1,  1, 1,
                        -1, 5, -1,
                        2, 2,2),36);

        objectGen2.put(getArray
                (36,  -1, 36,
                        -1, 10, -1,
                        2, 2,2),37);

        objectGen2.put(getArray
                (1,  -1, 1,
                        1, 10, 1,
                        2, 2,2),38);

        objectGen2.put(getArray
                (1,  1, 1,
                        1, 1, 1,
                        -1, 9,-1),39);

        objectGen2.put(getArray
                (6,  7, 8,
                        -1, 2, -1,
                        2, -1,2),40);

        objectGen2.put(getArray
                (2,  1, 2,
                        1,7, 1,
                        2, 1,2),41);
        objectGen2.put(getArray
                (3,  -1, 3,
                        -1,3, -1,
                        12, 12,12),42);

        objectGen2.put(getArray
                (3,  12, 3,
                        12,12, 12,
                        3, 12,3),43);

        objectGen2.put(getArray
                (3,  3, 3,
                        3,22, 3,
                        12, 12,12),44);
        objectGen2.put(getArray
                (3,  3, 3,
                        3,23, 3,
                        12, 12,12),45);
        objectGen2.put(getArray
                (3,  3, 3,
                        3,24, 3,
                        12, 12,12),46);
        objectGen2.put(getArray
                (3,  3, 3,
                        3,25, 3,
                        12, 12,12),47);

        objectGen2.put(getArray
                (4,  13, 4,
                        4,2, 4,
                        4, 13,4),48);

        objectGen2.put(getArray
                (4,  5, 4,
                        -1,2, -1,
                        13, 13,13),49);

        objectGen2.put(getArray
                (11,  5, 11,
                        6,11, 7,
                        11, 8,11),50);























    }
    private static String getArray(int x1,int x2,int x3,int x4,int x5,int x6,int x7,int x8,int x9){
        /*int result[]=new int[9];
        result[0]=x1;
        result[1]=x2;
        result[2]=x3;
        result[3]=x4;
        result[4]=x5;
        result[5]=x6;
        result[6]=x7;
        result[7]=x8;
        result[8]=x9;*/


        return x1+","+x2+","+x3+","+x4+","+x5+","+x6+","+x7+","+x8+","+x9;
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



    /*
    110
    000
    000
    */

    public static int checkShape(int [] maze,String shape,int Param){
        switch (shape){
            case "OnlyOneThere"://
                int counter1=0;
                for(int i=0;i<maze.length;i++){
                    if(maze[i]==maze[Param]) counter1++;

                }
                if(counter1==1) return maze[Param];
                else return -1;
            case "SingleOf":
                int counter=0,record=-1;
                for(int i=0;i<maze.length;i++){
                    if(maze[i]==-1) continue;
                    else{
                        counter++;
                        record=maze[i];
                    }
                }
                if(counter==1) return record;
                else return -1;

            case "TwoInLine"://
                int pivit=Param*3+1;
                if(maze[pivit+1]!=maze[pivit-1]&&(maze[pivit+1]==maze[pivit]||maze[pivit-1]==maze[pivit])){
                    return maze[pivit];
                }else{
                    return -1;
                }

            case "ThreeInLine"://
                int pivit2=Param*3;
                if(maze[pivit2]==maze[pivit2+1]&&maze[pivit2]==maze[pivit2+2]){
                    return maze[pivit2];
                }else{
                    return -1;
                }

            case "FullOf":
                for(int i=1;i<maze.length;i++){
                    if(maze[i]!=maze[0]) return -1;
                }
                return maze[0];

            case "OutLineOf":
                for(int i=1;i<maze.length;i++){
                    if(i==4){
                        if(maze[i]!=maze[0]){
                            continue;
                        }
                        else return -1;
                    }
                    if(maze[i]!=maze[0]) return -1;
                }
                return maze[0];

            case "Tesselation"://
                boolean test1=true,test2=true;
                for(int i=2;i<maze.length;i+=2){
                    if(maze[i]!=maze[0]){
                        test1=false;
                        break;
                    }
                }
                for(int i=3;i<maze.length;i+=2){
                    if(maze[i]!=maze[1]){
                        test1=false;
                        break;
                    }
                }
                boolean result1=true;
                if(maze[0]==maze[1]) result1=false;
                if(result1){
                    return maze[Param];
                }else{
                    return -1;
                }
            case "FourCorner"://
                if(Param==0){
                    if(maze[0]==maze[2]&&maze[0]==maze[8]&&maze[0]==maze[6]){
                        int mcounter2=0;
                        for(int i=1;i<maze.length;i++){
                            if(maze[i]==maze[0]) mcounter2++;
                        }
                        if(mcounter2==3) return maze[0];
                        else return -1;
                    }
                }else{
                    if(maze[1]==maze[3]&&maze[1]==maze[5]&&maze[1]==maze[7]){
                        int mcounter2=0;
                        for(int i=0;i<maze.length;i++){
                            if(maze[i]==maze[0]) mcounter2++;
                        }
                        if(mcounter2==4) return maze[1];
                        else return -1;
                    }
                }
            case "Bias"://
                if(Param==0){
                    if(maze[0]==maze[4]&&maze[0]==maze[8]){
                        int mcounter=0;
                        for(int i=1;i<maze.length;i++){
                            if(maze[i]==maze[0]) mcounter++;
                        }
                        if(mcounter!=2) return -1;
                        else return maze[0];
                    }
                }else{
                    if(maze[2]==maze[4]&&maze[2]==maze[6]){
                        int mcounter=0;
                        for(int i=0;i<maze.length;i++){
                            if(maze[i]==maze[2]) mcounter++;
                        }
                        if(mcounter!=3) return -1;
                        else return maze[0];
                    }
                }

            default:
                return -1;
        }

    }

}
